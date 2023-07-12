package com.taobao.android.job.core;

import com.taobao.android.job.core.graph.DependencyAware;
import com.taobao.android.job.core.graph.Node;
import com.taobao.android.job.core.graph.TraverserAction;
import com.taobao.android.job.core.task.ExecutionResult;
import com.taobao.android.job.core.task.ExecutionResults;
import java.util.Collection;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
interface DAGStageState<T, R> extends DependencyAware<T> {
    void addFailedExecution(ExecutionResult<T, R> executionResult);

    void decrementUnProcessedNodesCount();

    int executeFailedCount();

    void forcedStop();

    int getCurrentPhase();

    Collection<Node<T, R>> getDiscontinuedNodes();

    ExecutionResults<T, R> getFailedExecutions();

    Node<T, R> getGraphNode(T t);

    Set<Node<T, R>> getInitialNodes();

    Set<Node<T, R>> getNonProcessedRootNodes();

    Collection<Node<T, R>> getProcessedNodes();

    int getUnProcessedNodesCount();

    int graphSize();

    void incrementUnProcessedNodesCount();

    boolean isDiscontinuedNodesNotEmpty();

    void markDiscontinuedNodesProcessed();

    void markProcessingDone(Node<T, R> node);

    void onRecover();

    void onTerminate();

    void print(TraverserAction<T, R> traverserAction);

    void processAfterNoError(Collection<Node<T, R>> collection);

    void removeFailedExecution(ExecutionResult<T, R> executionResult);

    void setCurrentPhase(int i);

    boolean shouldProcess(Node<T, R> node);

    void validate();
}
