package com.taobao.accs.asp;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AThreadPool {
    private static final String TAG = "AThreadPool";
    private static AtomicInteger seq = new AtomicInteger(0);
    private static ThreadPoolExecutor threadPoolExecutor = null;
    private static ThreadPoolExecutor singleThreadExecutor = null;
    private static ThreadPoolExecutor loadThreadExecutor = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class AThreadFactory implements ThreadFactory {
        String mName;

        AThreadFactory(String str) {
            this.mName = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.mName + AThreadPool.seq.incrementAndGet());
            thread.setPriority(5);
            return thread;
        }
    }

    private static ThreadPoolExecutor getFileLoadExecutor() {
        if (loadThreadExecutor == null) {
            synchronized (AThreadPool.class) {
                if (loadThreadExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 3L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new AThreadFactory("aprefs-file-load"));
                    loadThreadExecutor = threadPoolExecutor2;
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                }
            }
        }
        return loadThreadExecutor;
    }

    private static ThreadPoolExecutor getFileWriteExecutor() {
        if (threadPoolExecutor == null) {
            synchronized (AThreadPool.class) {
                if (threadPoolExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(4, 4, 3L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new AThreadFactory("aprefs-file-write"));
                    threadPoolExecutor = threadPoolExecutor2;
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                }
            }
        }
        return threadPoolExecutor;
    }

    private static ThreadPoolExecutor getSingleThreadExecutor() {
        if (singleThreadExecutor == null) {
            synchronized (AThreadPool.class) {
                if (singleThreadExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 3L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new AThreadFactory("aprefs-stat"));
                    singleThreadExecutor = threadPoolExecutor2;
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                }
            }
        }
        return singleThreadExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void submitLoadTask(Runnable runnable) {
        try {
            getFileLoadExecutor().submit(runnable);
        } catch (Exception unused) {
        }
    }

    public static void submitSingleTask(Runnable runnable) {
        try {
            getSingleThreadExecutor().submit(runnable);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void submitWriteTask(Runnable runnable) {
        try {
            getFileWriteExecutor().submit(runnable);
        } catch (Exception unused) {
        }
    }
}
