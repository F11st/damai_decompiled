package com.taobao.android.job.core.graph;

import java.util.Collection;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DependencyGraph<T, R> extends DependencyAware<T> {
    Collection<Node<T, R>> allNodes();

    Node<T, R> get(T t);

    Set<Node<T, R>> getInitialNodes();

    Set<Node<T, R>> getLeafNodes();

    Set<Node<T, R>> getNonProcessedRootNodes();

    int size();
}
