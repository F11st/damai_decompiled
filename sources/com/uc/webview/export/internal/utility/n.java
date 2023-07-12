package com.uc.webview.export.internal.utility;

import com.uc.webview.export.internal.setup.ae;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class n {
    private static final String a = "n";
    private static ThreadPoolExecutor b;
    private static LinkedBlockingQueue<Runnable> c;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a extends ThreadPoolExecutor {
        public a(TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(2, 5, 30L, timeUnit, blockingQueue, threadFactory);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected final void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            ae.a().b(runnable);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            ae.a().a(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b implements ThreadFactory {
        private static volatile int a;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            int i = a + 1;
            a = i;
            String format = String.format("%s-%d", "U4SDKPool", Integer.valueOf(i));
            Thread thread = new Thread(runnable, format);
            thread.setUncaughtExceptionHandler(new o(this, format));
            if (a > 1) {
                String str = n.a;
                Log.d(str, "threadName " + format);
            }
            return thread;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public static void a() {
        if (2 != d().getCorePoolSize()) {
            d().setCorePoolSize(2);
        }
    }

    public static int b() {
        return b.a;
    }

    private static ThreadPoolExecutor d() {
        synchronized (n.class) {
            ThreadPoolExecutor threadPoolExecutor = b;
            if (threadPoolExecutor != null) {
                return threadPoolExecutor;
            }
            com.uc.webview.export.internal.uc.startup.b.a(504);
            c = new LinkedBlockingQueue<>(32);
            a aVar = new a(TimeUnit.SECONDS, c, new b((byte) 0));
            b = aVar;
            aVar.allowCoreThreadTimeOut(true);
            com.uc.webview.export.internal.uc.startup.b.a(505);
            return b;
        }
    }

    public static final void b(Runnable runnable) {
        new Thread(runnable, String.format("%s-%d", "U4SDKPool", Integer.valueOf(runnable.hashCode()))).start();
    }

    public static final void a(Runnable runnable) {
        if (runnable != null) {
            d().execute(runnable);
        }
    }

    public static final <T> Future<T> a(Callable<T> callable) {
        return d().submit(callable);
    }
}
