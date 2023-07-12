package tb;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class hl2 {
    private static hl2 a;
    private static ScheduledExecutorService b;
    private static final AtomicInteger c = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = hl2.c.getAndIncrement();
            return new Thread(runnable, "AppMonitor:" + andIncrement);
        }
    }

    private static synchronized ScheduledExecutorService b() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (hl2.class) {
            if (b == null) {
                b = Executors.newScheduledThreadPool(4, new a());
            }
            scheduledExecutorService = b;
        }
        return scheduledExecutorService;
    }

    public static synchronized hl2 c() {
        hl2 hl2Var;
        synchronized (hl2.class) {
            if (a == null) {
                a = new hl2();
            }
            hl2Var = a;
        }
        return hl2Var;
    }

    public final ScheduledFuture d(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
        }
        return b().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public final ScheduledFuture e(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }
        return b().scheduleAtFixedRate(runnable, 1000L, j, TimeUnit.MILLISECONDS);
    }

    public void f(Runnable runnable) {
        try {
            b().submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
