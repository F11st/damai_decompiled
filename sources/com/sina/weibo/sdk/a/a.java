package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.a.c;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class a {
    private static final int E;
    private static final int F;
    private static final int G;
    private static final Comparator<Runnable> I;
    private ThreadPoolExecutor H;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        E = availableProcessors;
        F = availableProcessors + 1;
        G = (availableProcessors * 2) + 1;
        I = new Comparator<Runnable>() { // from class: com.sina.weibo.sdk.a.a.1
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
                return 0;
            }
        };
    }

    public a() {
        if (this.H == null) {
            this.H = new ThreadPoolExecutor(F, G, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(5, I));
        }
    }

    public final void a(c cVar) {
        ThreadPoolExecutor threadPoolExecutor = this.H;
        if (cVar.L != c.b.U) {
            int i = c.AnonymousClass4.R[cVar.L - 1];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        cVar.L = c.b.V;
        c.d<Params, Result> dVar = cVar.M;
        dVar.Y = cVar.P;
        dVar.priority = cVar.O;
        threadPoolExecutor.execute(cVar.N);
    }
}
