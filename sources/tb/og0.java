package tb;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import tb.ng0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class og0 {
    private ng0 a;
    private ng0 b;
    private ng0 c;
    private ng0 d;

    /* compiled from: Taobao */
    /* renamed from: tb.og0$a */
    /* loaded from: classes5.dex */
    class ThreadFactoryC9516a implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        ThreadFactoryC9516a(og0 og0Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Cpu-" + this.a.getAndIncrement());
            thread.setPriority(10);
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.og0$b */
    /* loaded from: classes5.dex */
    class ThreadFactoryC9517b implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        ThreadFactoryC9517b(og0 og0Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Normal-" + this.a.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.og0$c */
    /* loaded from: classes5.dex */
    class ThreadFactoryC9518c implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        ThreadFactoryC9518c(og0 og0Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Rpc-" + this.a.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.og0$d */
    /* loaded from: classes5.dex */
    class ThreadFactoryC9519d implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        ThreadFactoryC9519d(og0 og0Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-IO-" + this.a.getAndIncrement());
            thread.setPriority(1);
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.og0$e */
    /* loaded from: classes5.dex */
    private static class C9520e {
        private static final og0 a = new og0(null);
    }

    /* synthetic */ og0(ThreadFactoryC9516a threadFactoryC9516a) {
        this();
    }

    @NonNull
    public static og0 c() {
        return C9520e.a;
    }

    public ng0 a() {
        if (this.a == null) {
            ng0.C9473a c9473a = new ng0.C9473a();
            int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            c9473a.i(availableProcessors).k(availableProcessors).j(2147483647L).l(20).m(new ThreadFactoryC9516a(this));
            this.a = c9473a.h();
        }
        return this.a;
    }

    public ng0 b() {
        if (this.d == null) {
            ng0.C9473a c9473a = new ng0.C9473a();
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            int availableProcessors2 = (Runtime.getRuntime().availableProcessors() * 5) + 1;
            c9473a.i(availableProcessors).k(availableProcessors2 >= 6 ? availableProcessors2 : 6).j(30000L).g(true).m(new ThreadFactoryC9519d(this));
            this.d = c9473a.h();
        }
        return this.d;
    }

    public ng0 d() {
        if (this.b == null) {
            ng0.C9473a c9473a = new ng0.C9473a();
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            c9473a.i(availableProcessors).k(availableProcessors).l(50).g(false).m(new ThreadFactoryC9517b(this));
            this.b = c9473a.h();
        }
        return this.b;
    }

    public ng0 e() {
        if (this.c == null) {
            ng0.C9473a c9473a = new ng0.C9473a();
            int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            c9473a.i(availableProcessors).k(availableProcessors).l(50).g(false).m(new ThreadFactoryC9518c(this));
            this.c = c9473a.h();
        }
        return this.c;
    }

    private og0() {
    }
}
