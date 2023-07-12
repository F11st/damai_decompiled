package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.o0 */
/* loaded from: classes10.dex */
public class C5637o0 {
    public static C5637o0 b;
    public static C5637o0 c;
    public static C5637o0 d;
    public ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, (long) DateUtils.MILLIS_PER_MINUTE, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new ThreadFactoryC5639b());

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.hatool.o0$a */
    /* loaded from: classes10.dex */
    public static class RunnableC5638a implements Runnable {
        public Runnable a;

        public RunnableC5638a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    C5653y.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.hatool.o0$b */
    /* loaded from: classes10.dex */
    public static class ThreadFactoryC5639b implements ThreadFactory {
        public static final AtomicInteger d = new AtomicInteger(1);
        public final ThreadGroup a;
        public final AtomicInteger b = new AtomicInteger(1);
        public final String c;

        public ThreadFactoryC5639b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.c = "FormalHASDK-base-" + d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            return new Thread(threadGroup, runnable, this.c + this.b.getAndIncrement(), 0L);
        }
    }

    static {
        new C5637o0();
        new C5637o0();
        b = new C5637o0();
        c = new C5637o0();
        d = new C5637o0();
    }

    public static C5637o0 a() {
        return d;
    }

    public static C5637o0 b() {
        return c;
    }

    public static C5637o0 c() {
        return b;
    }

    public void a(InterfaceRunnableC5635n0 interfaceRunnableC5635n0) {
        try {
            this.a.execute(new RunnableC5638a(interfaceRunnableC5635n0));
        } catch (RejectedExecutionException unused) {
            C5653y.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
