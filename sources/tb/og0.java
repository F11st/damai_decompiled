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
    /* loaded from: classes5.dex */
    class a implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        a(og0 og0Var) {
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
    /* loaded from: classes5.dex */
    class b implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        b(og0 og0Var) {
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
    /* loaded from: classes5.dex */
    class c implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        c(og0 og0Var) {
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
    /* loaded from: classes5.dex */
    class d implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        d(og0 og0Var) {
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
    /* loaded from: classes5.dex */
    private static class e {
        private static final og0 a = new og0(null);
    }

    /* synthetic */ og0(a aVar) {
        this();
    }

    @NonNull
    public static og0 c() {
        return e.a;
    }

    public ng0 a() {
        if (this.a == null) {
            ng0.a aVar = new ng0.a();
            int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            aVar.i(availableProcessors).k(availableProcessors).j(2147483647L).l(20).m(new a(this));
            this.a = aVar.h();
        }
        return this.a;
    }

    public ng0 b() {
        if (this.d == null) {
            ng0.a aVar = new ng0.a();
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            int availableProcessors2 = (Runtime.getRuntime().availableProcessors() * 5) + 1;
            aVar.i(availableProcessors).k(availableProcessors2 >= 6 ? availableProcessors2 : 6).j(30000L).g(true).m(new d(this));
            this.d = aVar.h();
        }
        return this.d;
    }

    public ng0 d() {
        if (this.b == null) {
            ng0.a aVar = new ng0.a();
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            aVar.i(availableProcessors).k(availableProcessors).l(50).g(false).m(new b(this));
            this.b = aVar.h();
        }
        return this.b;
    }

    public ng0 e() {
        if (this.c == null) {
            ng0.a aVar = new ng0.a();
            int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            aVar.i(availableProcessors).k(availableProcessors).l(50).g(false).m(new c(this));
            this.c = aVar.h();
        }
        return this.c;
    }

    private og0() {
    }
}
