package com.taobao.accs.common;

import com.taobao.accs.utl.ALog;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ThreadPoolExecutorFactory {
    private static final String TAG = "ThreadPoolExecutorFactory";
    private static volatile ScheduledThreadPoolExecutor acceptThreadPoolExecutor;
    private static volatile ScheduledThreadPoolExecutor callbackThreadPoolExecutor;
    private static final AtomicInteger integer = new AtomicInteger();
    private static volatile ScheduledThreadPoolExecutor scheduleThreadPoolExecutor;
    private static volatile ScheduledThreadPoolExecutor sendThreadPoolExecutor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class TBThreadFactory implements ThreadFactory {
        private String tag;

        public TBThreadFactory(String str) {
            this.tag = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = ThreadPoolExecutorFactory.integer.getAndIncrement();
            Thread thread = new Thread(runnable, this.tag + andIncrement);
            thread.setPriority(5);
            return thread;
        }
    }

    public static void execute(Runnable runnable) {
        try {
            getScheduledExecutor().execute(runnable);
        } catch (Throwable th) {
            ALog.e(TAG, "ThreadPoolExecutorFactory execute", th, new Object[0]);
        }
    }

    public static void executeCallback(Runnable runnable) {
        try {
            getCallbackScheduledExecutor().execute(runnable);
        } catch (Throwable th) {
            ALog.e(TAG, "ThreadPoolExecutorFactory execute", th, new Object[0]);
        }
    }

    public static ThreadPoolExecutor getAcceptExecutor() {
        if (acceptThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (acceptThreadPoolExecutor == null) {
                    acceptThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new TBThreadFactory("ACCS-ACCEPT"));
                    acceptThreadPoolExecutor.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    acceptThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return acceptThreadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor getCallbackScheduledExecutor() {
        if (callbackThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (callbackThreadPoolExecutor == null) {
                    callbackThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new TBThreadFactory("ACCS-CB"));
                    callbackThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return callbackThreadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        if (scheduleThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (scheduleThreadPoolExecutor == null) {
                    scheduleThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new TBThreadFactory("ACCS"));
                    scheduleThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.SECONDS);
                    scheduleThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return scheduleThreadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor getSendScheduledExecutor() {
        if (sendThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (sendThreadPoolExecutor == null) {
                    sendThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new TBThreadFactory("ACCS-SEND"));
                    sendThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.SECONDS);
                    sendThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return sendThreadPoolExecutor;
    }

    public static ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            return getScheduledExecutor().schedule(runnable, j, timeUnit);
        } catch (Throwable th) {
            ALog.e(TAG, "ThreadPoolExecutorFactory schedule", th, new Object[0]);
            return null;
        }
    }
}
