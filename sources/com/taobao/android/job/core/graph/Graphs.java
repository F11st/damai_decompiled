package com.taobao.android.job.core.graph;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Graphs {
    private Graphs() {
    }

    public static <T, R> DependencyGraph<T, R> create() {
        return new DependencyGraphImpl();
    }

    public static <T, R> void detectCycle(DependencyGraph<T, R> dependencyGraph) throws GraphCycleDetectedException {
        new CyclicCheckerImpl().detect(dependencyGraph);
    }
}
