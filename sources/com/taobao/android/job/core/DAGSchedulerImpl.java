package com.taobao.android.job.core;

import android.util.Pair;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.task.DefaultTaskFactory;
import com.taobao.android.job.core.task.ExecutionResults;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.job.core.task.TaskFactory;
import com.taobao.android.job.core.task.TaskProvider;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DAGSchedulerImpl<T, R> implements DAGScheduler<T, R> {
    private static final String TAG = "DAGSchedulerImpl";
    private final TaskScheduler<T, R> taskScheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DAGSchedulerImpl(DAGSchedulerConfig<T, R> dAGSchedulerConfig) {
        this.taskScheduler = dAGSchedulerConfig.getTaskScheduler();
    }

    @Override // com.taobao.android.job.core.DAGScheduler
    public DAGStage<T, R> createStage(String str, TaskProvider<T, R> taskProvider) {
        return createStage(str, taskProvider, new DefaultTaskFactory());
    }

    @Override // com.taobao.android.job.core.DAGScheduler
    public Pair<ExecutionResults<T, R>, ExecutionSummary> schedule(SchedulePolicy schedulePolicy, DAGStage<T, R> dAGStage) {
        Log.v(TAG, "schedule stage '%s' with policy", dAGStage.getName());
        return dAGStage.execute(schedulePolicy);
    }

    @Override // com.taobao.android.job.core.DAGScheduler
    public DAGStage<T, R> createStage(String str, TaskProvider<T, R> taskProvider, TaskFactory<T, R> taskFactory) {
        return createStage(str, taskProvider, taskFactory, null);
    }

    @Override // com.taobao.android.job.core.DAGScheduler
    public DAGStage<T, R> createStage(String str, TaskProvider<T, R> taskProvider, TaskFactory<T, R> taskFactory, TaskDeffer<T, R> taskDeffer) {
        return new DAGStage.Builder(str, this.taskScheduler, taskProvider).taskFactory(taskFactory).taskDeffer(taskDeffer).build();
    }
}
