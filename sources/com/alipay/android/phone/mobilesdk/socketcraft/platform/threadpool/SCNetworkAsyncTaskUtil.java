package com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SCNetworkAsyncTaskUtil {
    public static final void execute(Runnable runnable) {
        getThreadPool().execute(runnable);
    }

    public static final void executeIO(Runnable runnable) {
        getThreadPool().executeIO(runnable);
    }

    public static final void executeLazy(Runnable runnable) {
        getThreadPool().executeLazy(runnable);
    }

    public static final void executeLowPri(Runnable runnable) {
        getThreadPool().executeLowPri(runnable);
    }

    public static final void executeSerial(Runnable runnable) {
        getThreadPool().executeSerial(runnable);
    }

    public static final SCNetworkAsyncTaskExecutor getThreadPool() {
        return SCNetworkAsyncTaskExecutorFactory.getInstance();
    }

    public static final ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return getThreadPool().schedule(runnable, j, timeUnit);
    }

    public static final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return getThreadPool().scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    public static final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return getThreadPool().scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    public static final Future<?> submit(Runnable runnable) {
        return getThreadPool().submit(runnable);
    }

    public static final Future<?> submitLazy(Runnable runnable) {
        return getThreadPool().submitLazy(runnable);
    }

    public static final Future<?> submitSerial(Runnable runnable) {
        return getThreadPool().submitSerial(runnable);
    }

    public static final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return getThreadPool().schedule(callable, j, timeUnit);
    }

    public static final <T> Future<T> submit(Callable<T> callable) {
        return getThreadPool().submit(callable);
    }
}
