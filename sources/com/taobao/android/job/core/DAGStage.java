package com.taobao.android.job.core;

import android.util.Pair;
import com.taobao.android.job.core.graph.DependencyAware;
import com.taobao.android.job.core.graph.TraverserAction;
import com.taobao.android.job.core.task.ExecutionResults;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.job.core.task.TaskFactory;
import com.taobao.android.job.core.task.TaskProvider;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class DAGStage<T, R> {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static class Builder<T, R> {
        private final String name;
        private TaskDeffer<T, R> taskDeffer;
        private TaskFactory<T, R> taskFactory;
        private final TaskProvider<T, R> taskProvider;
        private final TaskScheduler<T, R> taskScheduler;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(String str, TaskScheduler<T, R> taskScheduler, TaskProvider<T, R> taskProvider) {
            this.name = str;
            this.taskScheduler = taskScheduler;
            this.taskProvider = taskProvider;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public DAGStage<T, R> build() {
            return new DAGStageImpl(this.name, this.taskScheduler, this.taskDeffer, this.taskProvider, this.taskFactory);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder<T, R> taskDeffer(TaskDeffer<T, R> taskDeffer) {
            this.taskDeffer = taskDeffer;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder<T, R> taskFactory(TaskFactory<T, R> taskFactory) {
            this.taskFactory = taskFactory;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract DependencyAware<T> asGraph();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Pair<ExecutionResults<T, R>, ExecutionSummary> execute(SchedulePolicy schedulePolicy);

    public abstract String getName();

    public abstract Map<T, ExecutionSummary> print(StringBuilder sb);

    public abstract void print(TraverserAction<T, R> traverserAction);

    public abstract void recoverExecution(SchedulePolicy schedulePolicy);
}
