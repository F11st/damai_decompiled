package tb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class s12 {
    private static final ExecutorService[] a = new ExecutorService[2];
    private static AtomicInteger b = new AtomicInteger(0);

    /* compiled from: Taobao */
    /* renamed from: tb.s12$a */
    /* loaded from: classes.dex */
    static class ThreadFactoryC9671a implements ThreadFactory {
        ThreadFactoryC9671a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("RepeaterThread:%d", Integer.valueOf(s12.b.getAndIncrement())));
        }
    }

    static {
        for (int i = 0; i < 2; i++) {
            a[i] = Executors.newSingleThreadExecutor(new ThreadFactoryC9671a());
        }
    }

    public static void b(int i, Runnable runnable) {
        a[Math.abs(i % 2)].submit(runnable);
    }
}
