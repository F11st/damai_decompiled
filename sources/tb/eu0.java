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
    /* loaded from: classes11.dex */
    private static class b implements Executor {
        ThreadPoolExecutor a;

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        class a implements ThreadFactory {
            a(b bVar) {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, lu2.SOPATCH);
            }
        }

        private b() {
            this.a = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(this));
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.execute(runnable);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class c {
        private static final eu0 a = new eu0();
    }

    public static eu0 d() {
        return c.a;
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
                    this.c = new b();
                }
            }
        }
        return this.c;
    }

    private eu0() {
    }
}
