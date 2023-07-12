package com.alibaba.android.onescheduler;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface OneTaskBuilder {
    @NonNull
    OneCommonTask buildCommonTask();

    @NonNull
    OneDependentTask buildDependentTask();

    @NonNull
    OneTaskBuilder setAnchorTask(boolean z);

    @NonNull
    OneTaskBuilder setCallable(Callable<?> callable, CallableCallback<?> callableCallback);

    @NonNull
    OneTaskBuilder setDelayTime(long j);

    @NonNull
    OneTaskBuilder setExecutor(Executor executor);

    @NonNull
    OneTaskBuilder setPriority(Priority priority);

    @NonNull
    OneTaskBuilder setRunnable(Runnable runnable);

    @NonNull
    OneTaskBuilder setTaskGroup(String str);

    @NonNull
    OneTaskBuilder setTaskName(String str);

    @NonNull
    OneTaskBuilder setTaskTracker(TaskTracker taskTracker);

    @NonNull
    OneTaskBuilder setTaskType(TaskType taskType);
}
