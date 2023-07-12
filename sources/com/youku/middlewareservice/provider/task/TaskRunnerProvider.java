package com.youku.middlewareservice.provider.task;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface TaskRunnerProvider {
    public static final String DEFAULT_GROUP = "default_group";

    DependentTask createAnchorTask(@NonNull String str, @NonNull String str2, TaskType taskType, Priority priority);

    DependentTask createDependentTask(@NonNull String str, @NonNull DependentTask dependentTask, @NonNull String str2, TaskType taskType, Priority priority, Runnable runnable);

    DependentTask createDependentTask(@NonNull String str, @NonNull DependentTask dependentTask, @NonNull String str2, TaskType taskType, Priority priority, Callable<?> callable, CallableCB<?> callableCB);

    void destroyGroup(String str);

    void execute(@NonNull Runnable runnable);

    void execute(@NonNull Runnable runnable, TaskType taskType);

    void execute(@NonNull Runnable runnable, TaskType taskType, long j);

    void initTaskGroup(String str, int i);

    void pauseTasks(@NonNull String str);

    void resumeTasks(@NonNull String str);

    CommonTask runCancelableTask(@NonNull String str, @NonNull String str2, long j, long j2, DelayType delayType, TaskType taskType, Priority priority, Runnable runnable);

    CommonTask runCancelableTask(@NonNull String str, @NonNull String str2, long j, long j2, DelayType delayType, TaskType taskType, Priority priority, Callable<?> callable, CallableCB<?> callableCB);

    void runDelayedTask(@NonNull String str, @NonNull String str2, long j, long j2, DelayType delayType, TaskType taskType, Priority priority, Runnable runnable);

    void runDelayedTask(@NonNull String str, @NonNull String str2, long j, long j2, DelayType delayType, TaskType taskType, Priority priority, Callable<?> callable, CallableCB<?> callableCB);

    void runDependentTasks(@NonNull DependentTask dependentTask);

    void runTask(@NonNull String str, @NonNull String str2, TaskType taskType, Priority priority, Runnable runnable);

    void runTask(@NonNull String str, @NonNull String str2, TaskType taskType, Priority priority, Callable<?> callable, CallableCB<?> callableCB);
}
