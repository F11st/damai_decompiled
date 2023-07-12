package tb;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class eu0 {
    private Context a;
    private String b;
    private Executor c;

    /* compiled from: Taobao */
    /* renamed from: tb.eu0$b */
    /* loaded from: classes11.dex */
    private static class ExecutorC9113b implements Executor {
        ThreadPoolExecutor a;

        /* compiled from: Taobao */
        /* renamed from: tb.eu0$b$a */
        /* loaded from: classes11.dex */
        class ThreadFactoryC9114a implements ThreadFactory {
            ThreadFactoryC9114a(ExecutorC9113b executorC9113b) {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, lu2.SOPATCH);
            }
        }

        private ExecutorC9113b() {
            this.a = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC9114a(this));
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.execute(runnable);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.eu0$c */
    /* loaded from: classes11.dex */
    private static class C9115c {
        private static final eu0 a = new eu0();
    }

    public static eu0 d() {
        return C9115c.a;
    }

    public String a() {
        return this.b;
    }

    public Context b() {
        return this.a;
    }

    public Executor c() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new ExecutorC9113b();
                }
            }
        }
        return this.c;
    }

    private eu0() {
    }
}
