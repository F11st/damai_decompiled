package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class dq<Params, Progress, Result> {
    public static final Executor a;
    public static final Executor b;
    public static final Executor c;
    private static final ThreadFactory d;
    private static final BlockingQueue<Runnable> e;
    private static final HandlerC4520c f;
    private static volatile Executor g;
    private final AbstractCallableC4518a<Params, Result> h;
    private final FutureTask<Result> i;
    private volatile EnumC4522e j = EnumC4522e.PENDING;
    private final AtomicBoolean k = new AtomicBoolean();
    private final AtomicBoolean l = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dq$4  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4522e.values().length];
            a = iArr;
            try {
                iArr[EnumC4522e.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC4522e.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dq$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractCallableC4518a<Params, Result> implements Callable<Result> {
        Params[] b;

        private AbstractCallableC4518a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dq$b */
    /* loaded from: classes10.dex */
    public static class C4519b<Data> {
        final dq a;
        final Data[] b;

        C4519b(dq dqVar, Data... dataArr) {
            this.a = dqVar;
            this.b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dq$c */
    /* loaded from: classes10.dex */
    public static class HandlerC4520c extends Handler {
        public HandlerC4520c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            if (obj == null || !(obj instanceof C4519b)) {
                return;
            }
            C4519b c4519b = (C4519b) obj;
            int i = message.what;
            if (i == 1) {
                c4519b.a.e(c4519b.b[0]);
            } else if (i != 2) {
            } else {
                c4519b.a.b((Object[]) c4519b.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dq$d */
    /* loaded from: classes10.dex */
    private static class ExecutorC4521d implements Executor {
        final ArrayDeque<Runnable> a;
        Runnable b;

        private ExecutorC4521d() {
            this.a = new ArrayDeque<>();
        }

        protected synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                dq.a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() { // from class: com.amap.api.mapcore.util.dq.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        ExecutorC4521d.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dq$e */
    /* loaded from: classes10.dex */
    public enum EnumC4522e {
        PENDING,
        RUNNING,
        FINISHED
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.amap.api.mapcore.util.dq.1
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AbstractAsyncTask #" + this.a.getAndIncrement());
            }
        };
        d = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        e = linkedBlockingQueue;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a = new ThreadPoolExecutor(5, 128, 1L, timeUnit, linkedBlockingQueue, threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
        Executor executorC4521d = eq.c() ? new ExecutorC4521d() : new ThreadPoolExecutor(1, 2, 1L, timeUnit, new LinkedBlockingQueue(), new ed("AMapSERIAL_EXECUTOR"), new ThreadPoolExecutor.AbortPolicy());
        b = executorC4521d;
        c = new ThreadPoolExecutor(2, 2, 1L, timeUnit, new LinkedBlockingQueue(), new ed("AMapDUAL_THREAD_EXECUTOR"), new ThreadPoolExecutor.AbortPolicy());
        f = new HandlerC4520c(Looper.getMainLooper());
        g = executorC4521d;
    }

    public dq() {
        AbstractCallableC4518a<Params, Result> abstractCallableC4518a = new AbstractCallableC4518a<Params, Result>() { // from class: com.amap.api.mapcore.util.dq.2
            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                dq.this.l.set(true);
                dq dqVar = dq.this;
                return (Result) dqVar.d(dqVar.a((Object[]) this.b));
            }
        };
        this.h = abstractCallableC4518a;
        this.i = new FutureTask<Result>(abstractCallableC4518a) { // from class: com.amap.api.mapcore.util.dq.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                try {
                    dq dqVar = dq.this;
                    dqVar.c((dq) dqVar.i.get());
                } catch (InterruptedException e2) {
                    Log.w("AbstractAsyncTask", e2);
                } catch (CancellationException unused) {
                    dq.this.c((dq) null);
                } catch (ExecutionException e3) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result d(Result result) {
        f.obtainMessage(1, new C4519b(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Result result) {
        if (d()) {
            b((dq<Params, Progress, Result>) result);
        } else {
            a((dq<Params, Progress, Result>) result);
        }
        this.j = EnumC4522e.FINISHED;
    }

    protected abstract Result a(Params... paramsArr);

    protected void a(Result result) {
    }

    protected void b() {
    }

    protected void b(Progress... progressArr) {
    }

    protected void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Result result) {
        if (this.l.get()) {
            return;
        }
        d(result);
    }

    public final EnumC4522e a() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Result result) {
        c();
    }

    public final boolean d() {
        return this.k.get();
    }

    public final boolean a(boolean z) {
        this.k.set(true);
        return this.i.cancel(z);
    }

    public final dq<Params, Progress, Result> c(Params... paramsArr) {
        return a(g, paramsArr);
    }

    public final dq<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.j != EnumC4522e.PENDING) {
            int i = AnonymousClass4.a[this.j.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.j = EnumC4522e.RUNNING;
        b();
        this.h.b = paramsArr;
        executor.execute(this.i);
        return this;
    }
}
