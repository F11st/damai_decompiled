package com.taobao.android.job.core.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class DependencyGraphImpl<T, R> implements DependencyGraph<T, R>, Serializable {
    private Map<T, Node<T, R>> nodes = new HashMap();

    private void addEdges(Node<T, R> node, Node<T, R> node2) {
        if (node.equals(node2)) {
            return;
        }
        node.addOutGoingNode(node2);
        node2.addInComingNode(node);
    }

    private Node<T, R> addOrGet(T t) {
        if (this.nodes.containsKey(t)) {
            return this.nodes.get(t);
        }
        Node<T, R> create = Nodes.create(t);
        this.nodes.put(t, create);
        return create;
    }

    private boolean allParentProcessed(Set<Node<T, R>> set) {
        for (Node<T, R> node : set) {
            if (node.isNotProcessed()) {
                return false;
            }
        }
        return true;
    }

    private void doProcess(Set<Node<T, R>> set, Set<Node<T, R>> set2) {
        for (Node<T, R> node : set2) {
            if (node.isNotProcessed() && allParentProcessed(node.getInComingNodes())) {
                set.add(node);
            } else if (allParentProcessed(node.getInComingNodes())) {
                doProcess(set, node.getOutGoingNodes());
            }
        }
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addAsDependencyToAllInitialNodes(T t) {
        if (size() == 0) {
            addIndependent(t);
            return;
        }
        for (Node<T, R> node : getInitialNodes()) {
            addDependency(t, node.getValue());
        }
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addAsDependentOnAllLeafNodes(T t) {
        if (size() == 0) {
            addIndependent(t);
            return;
        }
        for (Node<T, R> node : getLeafNodes()) {
            addDependency(node.getValue(), t);
        }
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addDependency(T t, T t2) {
        addEdges(addOrGet(t), addOrGet(t2));
    }

    @Override // com.taobao.android.job.core.graph.DependencyAware
    public void addIndependent(T t) {
        addOrGet(t);
    }

    @Override // com.taobao.android.job.core.graph.DependencyGraph
    public Collection<Node<T, R>> allNodes() {
        return new ArrayList(this.nodes.values());
    }

    @Override // com.taobao.android.job.core.graph.DependencyGraph
    public Node<T, R> get(T t) {
        return this.nodes.get(t);
    }

    @Override // com.taobao.android.job.core.graph.DependencyGraph
    public Set<Node<T, R>> getInitialNodes() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<T, Node<T, R>> entry : this.nodes.entrySet()) {
            Node<T, R> value = entry.getValue();
            if (value.getInComingNodes().isEmpty()) {
                linkedHashSet.add(value);
            }
        }
        return linkedHashSet;
    }

    @Override // com.taobao.android.job.core.graph.DependencyGraph
    public Set<Node<T, R>> getLeafNodes() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<T, Node<T, R>> entry : this.nodes.entrySet()) {
            Node<T, R> value = entry.getValue();
            if (value.getOutGoingNodes().isEmpty()) {
                linkedHashSet.add(value);
            }
        }
        return linkedHashSet;
    }

    @Override // com.taobao.android.job.core.graph.DependencyGraph
    public Set<Node<T, R>> getNonProcessedRootNodes() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        doProcess(linkedHashSet, getInitialNodes());
        return linkedHashSet;
    }

    @Override // com.taobao.android.job.core.graph.DependencyGraph
    public int size() {
        return this.nodes.size();
    }
}
