package com.ali.user.mobile.coordinator;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ExecutorInjector {
    private static ScheduledExecutorService mScheduledExector;
    private static ThreadPoolExecutor mThreadPoolExecutor;

    public static ThreadPoolExecutor getInjectThreadPoolExecutor() {
        return mThreadPoolExecutor;
    }

    public static ScheduledExecutorService getScheduledExector() {
        return mScheduledExector;
    }

    public static void setInjectThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        mThreadPoolExecutor = threadPoolExecutor;
    }

    public static void setScheduledExector(ScheduledExecutorService scheduledExecutorService) {
        mScheduledExector = scheduledExecutorService;
    }
}
