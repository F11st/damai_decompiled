package com.ta.audid.utils;

import java.util.concurrent.ScheduledFuture;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TaskExecutor {
    private static TaskExecutor instance;
    private static C6247a mHandler2Executor;

    public static synchronized TaskExecutor getInstance() {
        TaskExecutor taskExecutor;
        synchronized (TaskExecutor.class) {
            if (instance == null) {
                mHandler2Executor = new C6247a();
                instance = new TaskExecutor();
            }
            taskExecutor = instance;
        }
        return taskExecutor;
    }

    public final ScheduledFuture schedule(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (scheduledFuture != null) {
            try {
                if (!scheduledFuture.isDone()) {
                    scheduledFuture.cancel(true);
                }
            } catch (Exception unused) {
                return scheduledFuture;
            }
        }
        return mHandler2Executor.b(runnable, j);
    }
}
