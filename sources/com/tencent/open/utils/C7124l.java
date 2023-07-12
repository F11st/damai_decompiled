package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.utils.l */
/* loaded from: classes11.dex */
public final class C7124l {
    private static Handler c;
    private static HandlerThread d;
    private static Object b = new Object();
    public static final Executor a = c();

    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.utils.l$a */
    /* loaded from: classes11.dex */
    private static class ExecutorC7125a implements Executor {
        final Queue<Runnable> a;
        Runnable b;

        private ExecutorC7125a() {
            this.a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                C7124l.a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        ExecutorC7125a.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static Handler a() {
        if (c == null) {
            synchronized (C7124l.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                d = handlerThread;
                handlerThread.start();
                c = new Handler(d.getLooper());
            }
        }
        return c;
    }

    public static Executor b() {
        return new ExecutorC7125a();
    }
}
