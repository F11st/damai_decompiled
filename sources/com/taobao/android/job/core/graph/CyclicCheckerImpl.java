package com.taobao.android.job.core.graph;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class CyclicCheckerImpl<T, R> implements CyclicChecker<T, R> {
    private final Collection<Node<T, R>> visitedNodes = new ArrayList();
    private final Collection<Node<T, R>> visitingNodes = new ArrayList();

    private void detectCycle(Node<T, R> node) {
        this.visitedNodes.add(node);
        this.visitingNodes.add(node);
        doDepthFirstTraversal(node);
        this.visitingNodes.remove(node);
    }

    private void doDepthFirstTraversal(Node<T, R> node) {
        for (Node<T, R> node2 : node.getOutGoingNodes()) {
            if (!isVisited(node2)) {
                detectCycle(node2);
            } else if (isVisiting(node2)) {
                throw new GraphCycleDetectedException("Cycle Detected " + node + " With " + node2);
            }
        }
    }

    private void doTraversal(Collection<Node<T, R>> collection) {
        for (Node<T, R> node : collection) {
            detectCycle(node);
        }
    }

    private boolean isVisited(Node<T, R> node) {
        return this.visitedNodes.contains(node);
    }

    private boolean isVisiting(Node<T, R> node) {
        return this.visitingNodes.contains(node);
    }

    @Override // com.taobao.android.job.core.graph.CyclicChecker
    public void detect(DependencyGraph<T, R> dependencyGraph) throws GraphCycleDetectedException {
        try {
            doTraversal(dependencyGraph.allNodes());
        } finally {
            this.visitedNodes.clear();
            this.visitingNodes.clear();
        }
    }
}
