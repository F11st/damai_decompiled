package com.alibaba.android.schedule;

import com.taobao.orange.OConstant;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;
import tb.ri1;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class MegaScheduler {
    @NotNull
    public static final C3244a Companion = new C3244a(null);
    private static ExecutorService f;
    private static DelayHandler g;
    private final AtomicInteger a;
    private final LinkedList<C3245b> b;
    private int c;
    private final String d;
    private final int e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/alibaba/android/schedule/MegaScheduler$DelayHandler;", "Ljava/lang/Runnable;", "Lcom/alibaba/android/schedule/MegaScheduler$b;", "task", "Ltb/wt2;", "submit", "run", "Ljava/lang/Object;", OConstant.DIMEN_FILE_LOCK, "Ljava/lang/Object;", "Ljava/util/PriorityQueue;", "mDelayList", "Ljava/util/PriorityQueue;", "<init>", "()V", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class DelayHandler implements Runnable {
        private final Object lock = new Object();
        private final PriorityQueue<C3245b> mDelayList = new PriorityQueue<>(10);

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                C3245b c3245b = null;
                synchronized (this.lock) {
                    if (this.mDelayList.isEmpty()) {
                        try {
                            this.lock.wait();
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        long b = this.mDelayList.peek().b() - (System.nanoTime() / 1000000);
                        if (b > 0) {
                            this.lock.wait(b);
                        } else {
                            c3245b = this.mDelayList.remove();
                        }
                    }
                    wt2 wt2Var = wt2.INSTANCE;
                }
                if (c3245b != null) {
                    MegaScheduler.i(c3245b.c(), c3245b.d(), 0L, 2, null);
                }
            }
        }

        public final void submit(@NotNull C3245b c3245b) {
            b41.i(c3245b, "task");
            synchronized (this.lock) {
                this.mDelayList.add(c3245b);
                this.lock.notify();
                wt2 wt2Var = wt2.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/android/schedule/MegaScheduler$TaskExecutor;", "Ljava/lang/Runnable;", "Ltb/wt2;", "run", "Lcom/alibaba/android/schedule/MegaScheduler;", "scheduler", "Lcom/alibaba/android/schedule/MegaScheduler;", "<init>", "(Lcom/alibaba/android/schedule/MegaScheduler;)V", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class TaskExecutor implements Runnable {
        private final MegaScheduler scheduler;

        public TaskExecutor(@NotNull MegaScheduler megaScheduler) {
            b41.i(megaScheduler, "scheduler");
            this.scheduler = megaScheduler;
        }

        @Override // java.lang.Runnable
        public void run() {
            do {
            } while (this.scheduler.g(this.scheduler.a.incrementAndGet()));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.schedule.MegaScheduler$a */
    /* loaded from: classes5.dex */
    public static final class C3244a {
        private C3244a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final DelayHandler c() {
            if (MegaScheduler.g == null) {
                C3244a c3244a = MegaScheduler.Companion;
                synchronized (c3244a) {
                    MegaScheduler.g = new DelayHandler();
                    c3244a.d().submit(MegaScheduler.g);
                }
            }
            DelayHandler delayHandler = MegaScheduler.g;
            b41.f(delayHandler);
            return delayHandler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ExecutorService d() {
            if (MegaScheduler.f == null) {
                synchronized (MegaScheduler.Companion) {
                    MegaScheduler.f = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 120L, TimeUnit.SECONDS, new SynchronousQueue(), new ri1("mega-pool", 0, 2, null));
                    wt2 wt2Var = wt2.INSTANCE;
                }
            }
            ExecutorService executorService = MegaScheduler.f;
            b41.f(executorService);
            return executorService;
        }

        public /* synthetic */ C3244a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.schedule.MegaScheduler$b */
    /* loaded from: classes5.dex */
    public static final class C3245b implements Comparable<C3245b> {
        @NotNull
        private final MegaScheduler a;
        private final long b;
        @NotNull
        private final Runnable c;

        public C3245b(@NotNull MegaScheduler megaScheduler, long j, @NotNull Runnable runnable) {
            b41.i(megaScheduler, "megaScheduler");
            b41.i(runnable, "runnable");
            this.a = megaScheduler;
            this.b = j;
            this.c = runnable;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NotNull C3245b c3245b) {
            b41.i(c3245b, "other");
            long j = this.b;
            long j2 = c3245b.b;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }

        public final long b() {
            return this.b;
        }

        @NotNull
        public final MegaScheduler c() {
            return this.a;
        }

        @NotNull
        public final Runnable d() {
            return this.c;
        }
    }

    public MegaScheduler(@NotNull String str, int i) {
        b41.i(str, "name");
        this.d = str;
        this.e = i;
        this.a = new AtomicInteger();
        this.b = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(int i) {
        synchronized (this.b) {
            if (this.b.isEmpty()) {
                this.c--;
                return false;
            }
            C3245b removeFirst = this.b.removeFirst();
            b41.h(removeFirst, "taskQ.removeFirst()");
            C3245b c3245b = removeFirst;
            wt2 wt2Var = wt2.INSTANCE;
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(this.d + '-' + i);
            try {
                c3245b.d().run();
            } catch (Throwable unused) {
            }
            currentThread.setName(name);
            return true;
        }
    }

    public static /* synthetic */ void i(MegaScheduler megaScheduler, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        megaScheduler.h(runnable, j);
    }

    @JvmOverloads
    public final void h(@NotNull Runnable runnable, long j) {
        b41.i(runnable, "runnable");
        if (j > 0) {
            Companion.c().submit(new C3245b(this, (System.nanoTime() / 1000000) + j, runnable));
            return;
        }
        synchronized (this.b) {
            this.b.addLast(new C3245b(this, 0L, runnable));
            int i = this.e;
            int i2 = this.c;
            if (i2 >= 0 && i > i2) {
                this.c = i2 + 1;
                Companion.d().submit(new TaskExecutor(this));
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
    }
}
