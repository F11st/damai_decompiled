package tb;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class pv2 {
    private static final AtomicInteger b = new AtomicInteger();
    private ScheduledThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = pv2.b.getAndIncrement();
            return new Thread(runnable, "UtHandlerThread:" + andIncrement);
        }
    }

    public pv2() {
        this.a = null;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a());
        this.a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(3000L, TimeUnit.MILLISECONDS);
        this.a.allowCoreThreadTimeOut(true);
    }

    public void b(Runnable runnable) {
        this.a.submit(runnable);
    }
}
