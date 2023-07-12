package tb;

import anet.channel.strategy.dispatch.AmdcTaskExecutor;
import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a5 {
    private static AtomicInteger a = new AtomicInteger(0);
    private static ScheduledThreadPoolExecutor b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AMDC" + a5.a.incrementAndGet());
            ALog.f(AmdcTaskExecutor.TAG, "thread created!", null, "name", thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static ScheduledThreadPoolExecutor b() {
        if (b == null) {
            synchronized (a5.class) {
                if (b == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new a());
                    b = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return b;
    }

    public static void c(Runnable runnable, long j) {
        try {
            b().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            ALog.d(AmdcTaskExecutor.TAG, "schedule task failed", null, e, new Object[0]);
        }
    }

    public static void d(Runnable runnable) {
        try {
            b().submit(runnable);
        } catch (Exception e) {
            ALog.d(AmdcTaskExecutor.TAG, "submit task failed", null, e, new Object[0]);
        }
    }
}
