package com.taobao.android.job.core;

import androidx.annotation.VisibleForTesting;
import com.taobao.android.job.core.graph.DependencyGraph;
import com.taobao.android.job.core.graph.Graphs;
import com.taobao.android.job.core.graph.Node;
import com.taobao.android.job.core.graph.Traverser;
import com.taobao.android.job.core.graph.TraverserAction;
import com.taobao.android.job.core.task.ExecutionResult;
import com.taobao.android.job.core.task.ExecutionResults;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
@VisibleForTesting(otherwise = 3)
/* loaded from: classes11.dex */
public class DAGStageStateImpl<T, R> implements DAGStageState<T, R> {
    private final DependencyGraph<T, R> graph = Graphs.create();
    private int currentPhase = 0;
    private final AtomicInteger nodesCount = new AtomicInteger(0);
    private final Collection<Node<T, R>> processedNodes = new CopyOnWriteArrayList();
    private final Collection<Node<T, R>> discontinuedNodes = new CopyOnWriteArrayList();
    private final Collection<ExecutionResult<T, R>> failedExecutions = new CopyOnWriteArraySet();

    private boolean allIncomingNodesProcessed(Node<T, R> node) {
        return node.getInComingNodes().isEmpty() || areAlreadyProcessed(node.getInComingNodes());
    }

    private boolean areAlreadyProcessed(Set<Node<T, R>> set) {
        return this.processedNodes.containsAll(set);
    }

    private boolean isAlreadyProcessed(Node<T, R> node) {
        return this.processedNodes.contains(node);
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addAsDependencyToAllInitialNodes(T t) {
        this.graph.addAsDependencyToAllInitialNodes(t);
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addAsDependentOnAllLeafNodes(T t) {
        this.graph.addAsDependentOnAllLeafNodes(t);
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addDependency(T t, T t2) {
        this.graph.addDependency(t, t2);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void addFailedExecution(ExecutionResult<T, R> executionResult) {
        this.failedExecutions.add(executionResult);
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addIndependent(T t) {
        this.graph.addIndependent(t);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void decrementUnProcessedNodesCount() {
        this.nodesCount.decrementAndGet();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public int executeFailedCount() {
        return this.failedExecutions.size();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void forcedStop() {
        this.currentPhase = 3;
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public int getCurrentPhase() {
        return this.currentPhase;
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public Collection<Node<T, R>> getDiscontinuedNodes() {
        return new ArrayList(this.discontinuedNodes);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public ExecutionResults<T, R> getFailedExecutions() {
        ExecutionResults<T, R> executionResults = new ExecutionResults<>();
        executionResults.addAll(this.failedExecutions);
        return executionResults;
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public Node<T, R> getGraphNode(T t) {
        return this.graph.get(t);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public Set<Node<T, R>> getInitialNodes() {
        return this.graph.getInitialNodes();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public Set<Node<T, R>> getNonProcessedRootNodes() {
        return this.graph.getNonProcessedRootNodes();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public Collection<Node<T, R>> getProcessedNodes() {
        return new ArrayList(this.processedNodes);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public int getUnProcessedNodesCount() {
        return this.nodesCount.get();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public int graphSize() {
        return this.graph.size();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void incrementUnProcessedNodesCount() {
        this.nodesCount.incrementAndGet();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public boolean isDiscontinuedNodesNotEmpty() {
        return !this.discontinuedNodes.isEmpty();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void markDiscontinuedNodesProcessed() {
        this.discontinuedNodes.clear();
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void markProcessingDone(Node<T, R> node) {
        this.processedNodes.add(node);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void onRecover() {
        this.currentPhase = 4;
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void onTerminate() {
        this.currentPhase = 2;
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void print(TraverserAction<T, R> traverserAction) {
        Traverser.forGraph(this.graph).traverse(traverserAction);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void processAfterNoError(Collection<Node<T, R>> collection) {
        this.discontinuedNodes.addAll(collection);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void removeFailedExecution(ExecutionResult<T, R> executionResult) {
        this.failedExecutions.remove(executionResult);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void setCurrentPhase(int i) {
        this.currentPhase = i;
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public boolean shouldProcess(Node<T, R> node) {
        return !isAlreadyProcessed(node) && allIncomingNodesProcessed(node);
    }

    @Override // com.taobao.android.job.core.DAGStageState
    public void validate() {
        Graphs.detectCycle(this.graph);
    }
}
