package com.taobao.android.job.core;

import com.taobao.android.job.core.graph.DependencyAware;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DAGTaskChain<T> {
    private final DependencyAware<T> source;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Begin<T> {
        private final DependencyAware<T> source;
        private final T task;

        Begin(DependencyAware<T> dependencyAware, T t) {
            this.source = dependencyAware;
            this.task = t;
        }

        static <T> Begin<T> begin(DependencyAware<T> dependencyAware, T t) {
            return new Begin<>(dependencyAware, t);
        }

        @SafeVarargs
        public final void then(T t, T... tArr) {
            Then.from(this.source, this.task).then(t, tArr);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Ending<T> {
        private final DependencyAware<T> source;

        Ending(DependencyAware<T> dependencyAware, T t) {
            dependencyAware.addAsDependentOnAllLeafNodes(t);
            this.source = dependencyAware;
        }

        static <T> Ending<T> endWith(DependencyAware<T> dependencyAware, T t) {
            return new Ending<>(dependencyAware, t);
        }

        public Starting<T> startWith(T t) {
            return new Starting<>(this.source, t);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Starting<T> {
        private final DependencyAware<T> source;

        Starting(DependencyAware<T> dependencyAware, T t) {
            this.source = dependencyAware;
            dependencyAware.addAsDependencyToAllInitialNodes(t);
        }

        static <T> Starting<T> startWith(DependencyAware<T> dependencyAware, T t) {
            return new Starting<>(dependencyAware, t);
        }

        public Ending<T> endWith(T t) {
            return new Ending<>(this.source, t);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Then<T> {
        private final DependencyAware<T> source;
        private final T task;

        Then(DependencyAware<T> dependencyAware, T t) {
            this.source = dependencyAware;
            this.task = t;
        }

        static <T> Then<T> from(DependencyAware<T> dependencyAware, T t) {
            return new Then<>(dependencyAware, t);
        }

        @SafeVarargs
        public final void then(T t, T... tArr) {
            this.source.addDependency(this.task, t);
            for (T t2 : tArr) {
                this.source.addDependency(this.task, t2);
            }
        }
    }

    private DAGTaskChain(DependencyAware<T> dependencyAware) {
        this.source = dependencyAware;
    }

    public static <T, R> DAGTaskChain<T> from(DAGStage<T, R> dAGStage) {
        return new DAGTaskChain<>(dAGStage.asGraph());
    }

    public Begin<T> beginWith(T t) {
        return Begin.begin(this.source, t);
    }

    public Then<T> createInitialTask(T t) {
        this.source.addIndependent(t);
        return new Then<>(this.source, t);
    }

    public void createTaskPair(T t, T t2) {
        this.source.addDependency(t, t2);
    }

    public Ending<T> endWith(T t) {
        return Ending.endWith(this.source, t);
    }

    public Starting<T> startWith(T t) {
        return Starting.startWith(this.source, t);
    }
}
