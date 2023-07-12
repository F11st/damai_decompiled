package com.sina.weibo.sdk.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class c<Params, Progress, Result> {
    final d<Params, Result> M;
    final FutureTask<Result> N;
    Params[] P;
    volatile int L = b.U;
    int O = 5;
    Handler x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.a.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (message.what != 1) {
                return;
            }
            c.a(aVar.S, aVar.T[0]);
            message.obj = null;
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.a.c$4  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] R;

        static {
            int[] iArr = new int[b.m().length];
            R = iArr;
            try {
                iArr[b.V - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                R[b.W - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    static class a<Data> {
        final c S;
        final Data[] T;

        a(c cVar, Data... dataArr) {
            this.S = cVar;
            this.T = dataArr;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b {
        public static final int U = 1;
        public static final int V = 2;
        public static final int W = 3;
        private static final /* synthetic */ int[] X = {1, 2, 3};

        public static int[] m() {
            return (int[]) X.clone();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    abstract class AbstractC0272c extends FutureTask<Result> implements Comparable<Object> {
        int priority;

        public AbstractC0272c(d dVar) {
            super(dVar);
            this.priority = dVar.priority;
        }
    }

    public c() {
        d<Params, Result> dVar = new d<Params, Result>() { // from class: com.sina.weibo.sdk.a.c.2
            @Override // java.util.concurrent.Callable
            public final Result call() {
                Process.setThreadPriority(c.this.O);
                return (Result) c.this.l();
            }
        };
        this.M = dVar;
        this.N = new c<Params, Progress, Result>.AbstractC0272c(dVar) { // from class: com.sina.weibo.sdk.a.c.3
            @Override // java.lang.Comparable
            public final int compareTo(Object obj) {
                return 0;
            }

            @Override // java.util.concurrent.FutureTask
            protected final void done() {
                try {
                    Result result = get();
                    c cVar = c.this;
                    cVar.x.obtainMessage(1, new a(cVar, result)).sendToTarget();
                } catch (InterruptedException unused) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                } catch (CancellationException unused2) {
                    c.this.x.obtainMessage(3, new a(c.this, null)).sendToTarget();
                } catch (ExecutionException unused3) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                }
            }
        };
    }

    static /* synthetic */ void a(c cVar, Object obj) {
        cVar.onPostExecute(obj);
        cVar.L = b.W;
    }

    protected abstract Result l();

    protected void onPostExecute(Result result) {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    static abstract class d<Params, Result> implements Callable<Result> {
        Params[] Y;
        int priority;

        private d() {
            this.priority = 10;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }
}
