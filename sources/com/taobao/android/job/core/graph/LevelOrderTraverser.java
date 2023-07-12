package com.taobao.android.job.core.graph;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class LevelOrderTraverser<T, R> extends Traverser<T, R> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LevelOrderTraverser(DependencyGraph<T, R> dependencyGraph) {
        super(dependencyGraph);
    }

    @Override // com.taobao.android.job.core.graph.Traverser
    public void traverse(TraverserAction<T, R> traverserAction) {
        int i = 0;
        for (List<List<Node<T, R>>> list : traverseLevelOrder(this.graph)) {
            traverserAction.onNewPath(i);
            traversePath(list, traverserAction);
            i++;
        }
    }
}
