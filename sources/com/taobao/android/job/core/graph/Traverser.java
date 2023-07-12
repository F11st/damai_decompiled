package com.taobao.android.job.core.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class Traverser<T, R> {
    protected final DependencyGraph<T, R> graph;
    private List<Node<T, R>> visited = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Traverser(DependencyGraph<T, R> dependencyGraph) {
        this.graph = dependencyGraph;
    }

    private void doTraverse(List<List<Node<T, R>>> list, Node<T, R> node) {
        LinkedList linkedList = new LinkedList();
        linkedList.offer(node);
        while (!linkedList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                Node<T, R> node2 = (Node) linkedList.poll();
                if (!isVisited(node2) && isVisited(node2.getInComingNodes())) {
                    if (!arrayList.contains(node2) && !visitedAtThisLevel(arrayList, node2.getInComingNodes())) {
                        arrayList.add(node2);
                        this.visited.add(node2);
                    }
                    for (Node<T, R> node3 : node2.getOutGoingNodes()) {
                        if (node3 != null && !this.visited.contains(node3)) {
                            linkedList.offer(node3);
                        }
                    }
                }
            }
            list.add(arrayList);
        }
    }

    public static <T, R> Traverser<T, R> forGraph(DependencyGraph<T, R> dependencyGraph) {
        return new LevelOrderTraverser(dependencyGraph);
    }

    private boolean isVisited(Node<T, R> node) {
        return this.visited.contains(node);
    }

    private boolean visitedAtThisLevel(List<Node<T, R>> list, Set<Node<T, R>> set) {
        for (Node<T, R> node : set) {
            if (list.contains(node)) {
                return true;
            }
        }
        return false;
    }

    public abstract void traverse(TraverserAction<T, R> traverserAction);

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<List<List<Node<T, R>>>> traverseLevelOrder(DependencyGraph<T, R> dependencyGraph) {
        ArrayList arrayList = new ArrayList();
        for (Node<T, R> node : dependencyGraph.getInitialNodes()) {
            ArrayList arrayList2 = new ArrayList();
            doTraverse(arrayList2, node);
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void traversePath(List<List<Node<T, R>>> list, TraverserAction<T, R> traverserAction) {
        int i = 0;
        for (List<Node<T, R>> list2 : list) {
            traverserAction.onNewLevel(i);
            for (Node<T, R> node : list2) {
                traverserAction.onNode(node);
            }
            i++;
        }
    }

    private boolean isVisited(Set<Node<T, R>> set) {
        return this.visited.containsAll(set);
    }
}
