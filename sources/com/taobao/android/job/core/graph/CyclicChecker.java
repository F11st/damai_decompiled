package com.taobao.android.job.core.graph;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
interface CyclicChecker<T, R> {
    void detect(DependencyGraph<T, R> dependencyGraph) throws GraphCycleDetectedException;
}
