package com.taobao.android.job.core;

import android.util.Pair;
import com.taobao.android.job.core.task.ExecutionResults;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.job.core.task.TaskFactory;
import com.taobao.android.job.core.task.TaskProvider;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface DAGScheduler<T, R> {
    DAGStage<T, R> createStage(String str, TaskProvider<T, R> taskProvider);

    DAGStage<T, R> createStage(String str, TaskProvider<T, R> taskProvider, TaskFactory<T, R> taskFactory);

    DAGStage<T, R> createStage(String str, TaskProvider<T, R> taskProvider, TaskFactory<T, R> taskFactory, TaskDeffer<T, R> taskDeffer);

    Pair<ExecutionResults<T, R>, ExecutionSummary> schedule(SchedulePolicy schedulePolicy, DAGStage<T, R> dAGStage);
}
