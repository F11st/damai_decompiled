package org.android.spdy;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: org.android.spdy.e */
/* loaded from: classes2.dex */
class C8881e {
    private static volatile ScheduledThreadPoolExecutor a;
    private static final AtomicInteger b = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: org.android.spdy.e$a */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC8882a implements ThreadFactory {
        private String a;

        ThreadFactoryC8882a(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = C8881e.b.getAndIncrement();
            Thread thread = new Thread(runnable, this.a + andIncrement);
            thread.setPriority(5);
            return thread;
        }
    }

    C8881e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Runnable runnable) {
        try {
            c().execute(runnable);
        } catch (Throwable th) {
            spduLog.Loge("tnet-jni", "ThreadPoolExecutorFactory execute", th);
        }
    }

    static ScheduledThreadPoolExecutor c() {
        if (a == null) {
            synchronized (C8881e.class) {
                if (a == null) {
                    a = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC8882a("TNET"));
                    a.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return a;
    }
}
