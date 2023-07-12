package com.taobao.android.job.core.graph;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class MergedLevelOrderTraverser<T, R> extends Traverser<T, R> {
    MergedLevelOrderTraverser(DependencyGraph<T, R> dependencyGraph) {
        super(dependencyGraph);
    }

    private List<List<Node<T, R>>> merge(List<List<List<Node<T, R>>>> list) {
        ArrayList arrayList = new ArrayList();
        for (List<List<Node<T, R>>> list2 : list) {
            for (int i = 0; i < list2.size(); i++) {
                if (arrayList.size() <= i) {
                    arrayList.add(new ArrayList());
                }
                ((List) arrayList.get(i)).addAll(list2.get(i));
            }
        }
        return arrayList;
    }

    @Override // com.taobao.android.job.core.graph.Traverser
    public void traverse(TraverserAction<T, R> traverserAction) {
        List<List<Node<T, R>>> merge = merge(traverseLevelOrder(this.graph));
        traverserAction.onNewPath(0);
        traversePath(merge, traverserAction);
    }
}
