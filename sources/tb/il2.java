package tb;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class il2 {
    private static Executor a = new b(1, "slide-pool-");
    private static Executor b = new b(3, "slide-pool-d-");

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class a implements ThreadFactory {
        private static final AtomicInteger e = new AtomicInteger(1);
        private final String c;
        private final int d;
        private final AtomicInteger b = new AtomicInteger(1);
        private final ThreadGroup a = Thread.currentThread().getThreadGroup();

        a(int i, String str) {
            this.d = i;
            this.c = str + e.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.d);
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class b extends ThreadPoolExecutor {
        b(int i, String str) {
            super(i, i, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(5, str));
            allowCoreThreadTimeOut(true);
        }
    }

    public static void a(Runnable runnable) {
        try {
            b.execute(runnable);
        } catch (Throwable th) {
            m42.d("TaskExecutor", "dispatch", th, new Object[0]);
        }
    }

    public static void b(Runnable runnable) {
        try {
            a.execute(runnable);
        } catch (Throwable th) {
            m42.d("TaskExecutor", "submit", th, new Object[0]);
        }
    }
}
