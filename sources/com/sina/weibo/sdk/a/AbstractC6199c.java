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
/* renamed from: com.sina.weibo.sdk.a.c */
/* loaded from: classes7.dex */
public abstract class AbstractC6199c<Params, Progress, Result> {
    final AbstractCallableC6203d<Params, Result> M;
    final FutureTask<Result> N;
    Params[] P;
    volatile int L = EnumC6201b.U;
    int O = 5;
    Handler x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.a.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            C6200a c6200a = (C6200a) message.obj;
            if (message.what != 1) {
                return;
            }
            AbstractC6199c.a(c6200a.S, c6200a.T[0]);
            message.obj = null;
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.a.c$4  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] R;

        static {
            int[] iArr = new int[EnumC6201b.m().length];
            R = iArr;
            try {
                iArr[EnumC6201b.V - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                R[EnumC6201b.W - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.a.c$a */
    /* loaded from: classes7.dex */
    static class C6200a<Data> {
        final AbstractC6199c S;
        final Data[] T;

        C6200a(AbstractC6199c abstractC6199c, Data... dataArr) {
            this.S = abstractC6199c;
            this.T = dataArr;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.a.c$b */
    /* loaded from: classes7.dex */
    public static final class EnumC6201b {
        public static final int U = 1;
        public static final int V = 2;
        public static final int W = 3;
        private static final /* synthetic */ int[] X = {1, 2, 3};

        public static int[] m() {
            return (int[]) X.clone();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.a.c$c */
    /* loaded from: classes7.dex */
    abstract class AbstractC6202c extends FutureTask<Result> implements Comparable<Object> {
        int priority;

        public AbstractC6202c(AbstractCallableC6203d abstractCallableC6203d) {
            super(abstractCallableC6203d);
            this.priority = abstractCallableC6203d.priority;
        }
    }

    public AbstractC6199c() {
        AbstractCallableC6203d<Params, Result> abstractCallableC6203d = new AbstractCallableC6203d<Params, Result>() { // from class: com.sina.weibo.sdk.a.c.2
            @Override // java.util.concurrent.Callable
            public final Result call() {
                Process.setThreadPriority(AbstractC6199c.this.O);
                return (Result) AbstractC6199c.this.l();
            }
        };
        this.M = abstractCallableC6203d;
        this.N = new AbstractC6199c<Params, Progress, Result>.AbstractC6202c(abstractCallableC6203d) { // from class: com.sina.weibo.sdk.a.c.3
            @Override // java.lang.Comparable
            public final int compareTo(Object obj) {
                return 0;
            }

            @Override // java.util.concurrent.FutureTask
            protected final void done() {
                try {
                    Result result = get();
                    AbstractC6199c abstractC6199c = AbstractC6199c.this;
                    abstractC6199c.x.obtainMessage(1, new C6200a(abstractC6199c, result)).sendToTarget();
                } catch (InterruptedException unused) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                } catch (CancellationException unused2) {
                    AbstractC6199c.this.x.obtainMessage(3, new C6200a(AbstractC6199c.this, null)).sendToTarget();
                } catch (ExecutionException unused3) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                }
            }
        };
    }

    static /* synthetic */ void a(AbstractC6199c abstractC6199c, Object obj) {
        abstractC6199c.onPostExecute(obj);
        abstractC6199c.L = EnumC6201b.W;
    }

    protected abstract Result l();

    protected void onPostExecute(Result result) {
    }

    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.a.c$d */
    /* loaded from: classes7.dex */
    static abstract class AbstractCallableC6203d<Params, Result> implements Callable<Result> {
        Params[] Y;
        int priority;

        private AbstractCallableC6203d() {
            this.priority = 10;
        }

        /* synthetic */ AbstractCallableC6203d(byte b) {
            this();
        }
    }
}
