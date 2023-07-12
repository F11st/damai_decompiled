package com.alibaba.motu.crashreporter.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class AsyncThreadPool {
    public static final AtomicInteger INTEGER = new AtomicInteger();
    public static Integer corePoolSize = null;
    public static int prop = 10;
    private static ExecutorService threadPoolExecutor;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static class CrashThreadFactory implements ThreadFactory {
        private int priority;

        public CrashThreadFactory(int i) {
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = AsyncThreadPool.INTEGER.getAndIncrement();
            Thread thread = new Thread(runnable, "CrashReporter:" + andIncrement);
            thread.setPriority(this.priority);
            return thread;
        }
    }

    static {
        Integer num = 2;
        corePoolSize = num;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(num.intValue(), new CrashThreadFactory(prop));
        threadPoolExecutor = newFixedThreadPool;
        try {
            ((ThreadPoolExecutor) newFixedThreadPool).setKeepAliveTime(3L, TimeUnit.SECONDS);
            ((ThreadPoolExecutor) threadPoolExecutor).allowCoreThreadTimeOut(true);
        } catch (Throwable unused) {
        }
    }

    public static void start(Runnable runnable) {
        try {
            threadPoolExecutor.submit(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
