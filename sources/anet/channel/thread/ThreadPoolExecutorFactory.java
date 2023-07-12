package anet.channel.thread;

import anet.channel.util.ALog;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ThreadPoolExecutorFactory {
    private static ScheduledThreadPoolExecutor a = new ScheduledThreadPoolExecutor(1, new a("AWCN Scheduler"));
    private static ThreadPoolExecutor b;
    private static ThreadPoolExecutor c;
    private static ThreadPoolExecutor d;
    private static ThreadPoolExecutor e;
    private static ThreadPoolExecutor f;
    private static ThreadPoolExecutor g;
    private static ThreadPoolExecutor h;
    private static ThreadPoolExecutor i;
    private static ThreadPoolExecutor j;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class ComparableTask implements Runnable, Comparable<ComparableTask> {
        long createTime;
        int priority;
        Runnable rawTask;

        public ComparableTask(Runnable runnable, int i) {
            this.rawTask = null;
            this.priority = 0;
            this.createTime = System.currentTimeMillis();
            this.rawTask = runnable;
            this.priority = i;
            this.createTime = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.rawTask.run();
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableTask comparableTask) {
            int i = this.priority;
            int i2 = comparableTask.priority;
            return i != i2 ? i - i2 : (int) (comparableTask.createTime - this.createTime);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class a implements ThreadFactory {
        AtomicInteger a = new AtomicInteger(0);
        String b;

        a(String str) {
            this.b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.a.incrementAndGet());
            ALog.f("awcn.ThreadPoolExecutorFactory", "thread created!", null, "name", thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class b {
        public static int a = 0;
        public static int b = 1;
        public static int c = 9;
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        b = new ThreadPoolExecutor(2, 2, 60L, timeUnit, new LinkedBlockingDeque(), new a("AWCN Worker(H)"));
        c = new PriorityExecutor(16, 16, 60L, timeUnit, new PriorityBlockingQueue(), new a("AWCN Worker(M)"));
        d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, new LinkedBlockingDeque(), new a("AWCN Worker(L)"));
        e = new ThreadPoolExecutor(32, 32, 60L, timeUnit, new LinkedBlockingDeque(), new a("AWCN Worker(Backup)"));
        f = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new a("AWCN Detector"));
        g = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new a("AWCN HR"));
        h = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new a("AWCN Cookie"));
        i = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new a("AWCN Monitor"));
        j = new ThreadPoolExecutor(1, 1, 60L, timeUnit, new LinkedBlockingDeque(), new a("AWCN Callback"));
        b.allowCoreThreadTimeOut(true);
        c.allowCoreThreadTimeOut(true);
        d.allowCoreThreadTimeOut(true);
        e.allowCoreThreadTimeOut(true);
        f.allowCoreThreadTimeOut(true);
        g.allowCoreThreadTimeOut(true);
        h.allowCoreThreadTimeOut(true);
        i.allowCoreThreadTimeOut(true);
        j.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        a.remove(runnable);
    }

    public static synchronized void b(int i2) {
        synchronized (ThreadPoolExecutorFactory.class) {
            if (i2 < 6) {
                i2 = 6;
            }
            c.setCorePoolSize(i2);
            c.setMaximumPoolSize(i2);
        }
    }

    public static Future<?> c(Runnable runnable) {
        return e.submit(runnable);
    }

    public static Future<?> d(Runnable runnable) {
        return h.submit(runnable);
    }

    public static Future<?> e(Runnable runnable) {
        return f.submit(runnable);
    }

    public static Future<?> f(Runnable runnable) {
        return g.submit(runnable);
    }

    public static Future<?> g(Runnable runnable, int i2) {
        if (ALog.g(1)) {
            ALog.c("awcn.ThreadPoolExecutorFactory", "submit priority task", null, "priority", Integer.valueOf(i2));
        }
        if (i2 < b.a || i2 > b.c) {
            i2 = b.c;
        }
        if (i2 == b.a) {
            return b.submit(runnable);
        }
        if (i2 == b.c) {
            return d.submit(runnable);
        }
        return c.submit(new ComparableTask(runnable, i2));
    }

    public static Future<?> h(Runnable runnable) {
        return i.submit(runnable);
    }

    public static Future<?> i(Runnable runnable) {
        return a.submit(runnable);
    }

    public static Future<?> j(Runnable runnable, long j2, TimeUnit timeUnit) {
        return a.schedule(runnable, j2, timeUnit);
    }

    public static Future<?> k(Runnable runnable) {
        return j.submit(runnable);
    }
}
