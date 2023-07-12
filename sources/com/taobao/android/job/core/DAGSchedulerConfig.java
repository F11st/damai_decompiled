package com.taobao.android.job.core;

import androidx.annotation.Nullable;
import java.util.concurrent.ExecutorService;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DAGSchedulerConfig<T, R> {
    private final TaskScheduler<T, R> taskScheduler;

    public DAGSchedulerConfig(@Nullable ExecutorService executorService) {
        this.taskScheduler = new TaskSchedulerImpl(executorService);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskScheduler<T, R> getTaskScheduler() {
        return this.taskScheduler;
    }
}
