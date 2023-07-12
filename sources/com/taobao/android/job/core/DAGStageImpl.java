package com.taobao.android.job.core;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.graph.DependencyAware;
import com.taobao.android.job.core.graph.Node;
import com.taobao.android.job.core.graph.TraverserAction;
import com.taobao.android.job.core.helper.TimeHelpers;
import com.taobao.android.job.core.task.ExecutionResult;
import com.taobao.android.job.core.task.ExecutionResults;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.job.core.task.Task;
import com.taobao.android.job.core.task.TaskFactory;
import com.taobao.android.job.core.task.TaskNotFoundException;
import com.taobao.android.job.core.task.TaskProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DAGStageImpl<T, R> extends DAGStage<T, R> implements DependencyAware<T>, ExecutionListener<T, R> {
    private static final String TAG = "DAGStageImpl";
    private final String name;
    @Nullable
    private final TaskDeffer<T, R> taskDeffer;
    private final TaskFactory<T, R> taskFactory;
    private final TaskProvider<T, R> taskProvider;
    private final TaskScheduler<T, R> taskScheduler;
    private final DAGStageState<T, R> state = new DAGStageStateImpl();
    private final Map<T, ExecutionSummary> executionSummary = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DAGStageImpl(String str, TaskScheduler<T, R> taskScheduler, @Nullable TaskDeffer<T, R> taskDeffer, TaskProvider<T, R> taskProvider, TaskFactory<T, R> taskFactory) {
        this.name = str;
        this.taskScheduler = taskScheduler;
        this.taskDeffer = taskDeffer;
        this.taskProvider = taskProvider;
        this.taskFactory = taskFactory;
    }

    private void doAfterExecutionDone(SchedulePolicy schedulePolicy, ExecutionResult<T, R> executionResult) {
        Log.v(TAG, "Processing of node %s done, with status %s", executionResult.getId(), Integer.valueOf(executionResult.getStatus()));
        Node<T, R> graphNode = this.state.getGraphNode(executionResult.getId());
        if (graphNode == null) {
            Log.e(TAG, "got a unexpected node with id '%s', it seems that it is not in graph of stage '%s'", executionResult.getId(), this.name);
            return;
        }
        this.state.decrementUnProcessedNodesCount();
        updateNode(executionResult, graphNode);
        if (executionResult.isSuccess()) {
            this.state.markProcessingDone(graphNode);
        }
        if (executionResult.isSuccess() && !isAnyTaskInError() && this.state.isDiscontinuedNodesNotEmpty()) {
            HashSet hashSet = new HashSet(this.state.getDiscontinuedNodes());
            this.state.markDiscontinuedNodesProcessed();
            doExecute(hashSet, schedulePolicy);
        }
        if (!schedulePolicy.isImmediateNonTerminating() && isAnyTaskInError()) {
            if (isAnyTaskInError() && executionResult.isSuccess()) {
                this.state.processAfterNoError(graphNode.getOutGoingNodes());
                return;
            }
            return;
        }
        doExecute(graphNode.getOutGoingNodes(), schedulePolicy);
    }

    private void doExecute(Collection<Node<T, R>> collection, SchedulePolicy schedulePolicy) {
        for (Node<T, R> node : collection) {
            forceStopIfRequired();
            if (this.state.shouldProcess(node)) {
                Task<T, R> newTask = newTask(schedulePolicy, (Node) node);
                if (node.isNotProcessed() && interceptTask(node, newTask)) {
                    this.state.incrementUnProcessedNodesCount();
                    Log.v(TAG, "Submitting %s node for execution", node.getValue());
                    ExecutionResult<T, R> submit = this.taskScheduler.submit(newTask);
                    if (submit != null) {
                        doAfterExecutionDone(schedulePolicy, submit);
                    }
                } else if (node.isNotProcessed()) {
                    node.setSkipped();
                    Log.v(TAG, "Execution Skipped for node # %s ", node.getValue());
                    this.state.markProcessingDone(node);
                    doExecute(node.getOutGoingNodes(), schedulePolicy);
                }
            } else {
                Log.v(TAG, "node %s depends on %s", node.getValue(), node.getInComingNodes());
            }
            executeDeferredTaskIfAny(schedulePolicy, 0);
        }
    }

    private void doProcessNodes(SchedulePolicy schedulePolicy, Set<Node<T, R>> set) {
        doExecute(set, schedulePolicy);
        executeDeferredTaskIfAny(schedulePolicy, 1);
        doWaitForExecution(schedulePolicy);
    }

    private void doWaitForExecution(SchedulePolicy schedulePolicy) {
        while (this.state.getUnProcessedNodesCount() > 0) {
            forceStopIfRequired();
            doAfterExecutionDone(schedulePolicy, this.taskScheduler.processResult());
        }
    }

    private void executeDeferredTaskIfAny(SchedulePolicy schedulePolicy, int i) {
        TaskDeffer<T, R> taskDeffer;
        Task<T, R> poll;
        if (schedulePolicy.getScheduleBehavior() != 4 || (taskDeffer = this.taskDeffer) == null || (poll = taskDeffer.poll(i)) == null) {
            return;
        }
        if (!poll.shouldRunImmediately()) {
            Log.e(TAG, "deferrable task is designed to run immediately, skip it this time, task name is: '%s'", poll.getId());
            return;
        }
        Log.v(TAG, "begin execute deferred task %s", poll.getId());
        this.taskFactory.newRunner(poll).execute();
        Log.v(TAG, "end execute deferred task %s", poll.getId());
    }

    private void forceStopIfRequired() {
        if (interruptProcessing()) {
            return;
        }
        this.state.forcedStop();
        throw new IllegalStateException("Forced to Stop the instance of DAGStage!");
    }

    private Integer getExecutionCount(Node<T, R> node) {
        Integer num = (Integer) node.getData();
        if (num == null) {
            return 0;
        }
        return num;
    }

    private boolean interceptTask(Node<T, R> node, Task<T, R> task) {
        return task.intercept(parentResults(node));
    }

    private boolean isAnyTaskInError() {
        return this.state.executeFailedCount() > 0;
    }

    private Task<T, R> newTask(SchedulePolicy schedulePolicy, Node<T, R> node) {
        return newTask(schedulePolicy, (SchedulePolicy) node.getValue());
    }

    private ExecutionResults<T, R> parentResults(Node<T, R> node) {
        ExecutionResults<T, R> executionResults = new ExecutionResults<>();
        for (Node<T, R> node2 : node.getInComingNodes()) {
            executionResults.add(new ExecutionResult<>(node2.getValue(), node2.getResult(), status(node2), null));
        }
        return executionResults;
    }

    private int status(Node<T, R> node) {
        if (node.isFailed()) {
            return 0;
        }
        return node.isSkipped() ? 1 : 2;
    }

    private void updateExecutionCount(Node<T, R> node) {
        node.setData(Integer.valueOf(getExecutionCount(node).intValue() + 1));
    }

    private void updateNode(ExecutionResult<T, R> executionResult, Node<T, R> node) {
        updateExecutionCount(node);
        node.setResult(executionResult.getResult());
        if (executionResult.isFailed()) {
            node.setErrored();
        } else {
            node.setSuccess();
        }
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addAsDependencyToAllInitialNodes(T t) {
        this.state.validate();
        this.state.addAsDependencyToAllInitialNodes(t);
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addAsDependentOnAllLeafNodes(T t) {
        this.state.validate();
        this.state.addAsDependentOnAllLeafNodes(t);
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addDependency(T t, T t2) {
        this.state.validate();
        this.state.addDependency(t, t2);
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addIndependent(T t) {
        this.state.validate();
        this.state.addIndependent(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.job.core.DAGStage
    public DependencyAware<T> asGraph() {
        return this;
    }

    @Override // com.taobao.android.job.core.DAGStage
    public Pair<ExecutionResults<T, R>, ExecutionSummary> execute(SchedulePolicy schedulePolicy) {
        this.state.setCurrentPhase(1);
        Set<Node<T, R>> initialNodes = this.state.getInitialNodes();
        this.executionSummary.clear();
        this.taskScheduler.addExecutionListener(this);
        Log.v(TAG, "Start to process stage %s", this.name);
        long currentTimeMillis = System.currentTimeMillis();
        doProcessNodes(schedulePolicy, initialNodes);
        long currentTimeMillis2 = System.currentTimeMillis();
        long between = TimeHelpers.between(currentTimeMillis, currentTimeMillis2);
        this.taskScheduler.removeExecutionListener(this);
        this.state.setCurrentPhase(2);
        this.state.onTerminate();
        int graphSize = this.state.graphSize();
        int size = this.state.getProcessedNodes().size();
        Log.v(TAG, "Total Time taken to process %s jobs in %d ms of stage '%s'.", Integer.valueOf(graphSize), Long.valueOf(between), this.name);
        Log.v(TAG, "Processed Nodes Ordering %s", this.state.getProcessedNodes());
        return Pair.create(this.state.getFailedExecutions(), ExecutionSummary.create(graphSize, size, currentTimeMillis, currentTimeMillis2));
    }

    @Override // com.taobao.android.job.core.DAGStage
    public String getName() {
        return this.name;
    }

    protected boolean interruptProcessing() {
        return true;
    }

    @Override // com.taobao.android.job.core.ExecutionListener
    public void onError(Task<T, R> task, ExecutionResult<T, R> executionResult, Throwable th) {
        this.state.addFailedExecution(executionResult);
    }

    @Override // com.taobao.android.job.core.ExecutionListener
    public void onSuccess(Task<T, R> task, ExecutionResult<T, R> executionResult) {
        this.state.removeFailedExecution(executionResult);
        Log.v(TAG, "Executed: %s, %s", task.getId(), executionResult.getSummary());
        this.executionSummary.put(task.getId(), executionResult.getSummary());
    }

    @Override // com.taobao.android.job.core.DAGStage
    public void print(TraverserAction<T, R> traverserAction) {
        this.state.print(traverserAction);
    }

    @Override // com.taobao.android.job.core.DAGStage
    public void recoverExecution(SchedulePolicy schedulePolicy) {
        if (2 != this.state.getCurrentPhase()) {
            Log.v(TAG, "Recovering DAGStage.");
            this.state.onRecover();
            doWaitForExecution(schedulePolicy);
            doExecute(this.state.getNonProcessedRootNodes(), schedulePolicy);
            doWaitForExecution(schedulePolicy);
            this.state.onTerminate();
            Log.v(TAG, "Processed Nodes Ordering %s", this.state.getProcessedNodes());
            return;
        }
        throw new IllegalStateException("Can't recover terminated DAGStage");
    }

    private Task<T, R> newTask(SchedulePolicy schedulePolicy, T t) {
        Task<T, R> provideTask = this.taskProvider.provideTask(t);
        if (provideTask != null) {
            provideTask.setId(t);
            return this.taskFactory.newRunner(provideTask);
        }
        throw new TaskNotFoundException("task not found: " + t + " in " + this.taskProvider);
    }

    @Override // com.taobao.android.job.core.DAGStage
    public Map<T, ExecutionSummary> print(StringBuilder sb) {
        print(new DAGStageTraverserAction(sb, this.executionSummary));
        return Collections.unmodifiableMap(this.executionSummary);
    }
}
