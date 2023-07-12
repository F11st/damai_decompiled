package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.a.AbstractC6199c;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.a.a */
/* loaded from: classes7.dex */
public final class C6196a {
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

    public C6196a() {
        if (this.H == null) {
            this.H = new ThreadPoolExecutor(F, G, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(5, I));
        }
    }

    public final void a(AbstractC6199c abstractC6199c) {
        ThreadPoolExecutor threadPoolExecutor = this.H;
        if (abstractC6199c.L != AbstractC6199c.EnumC6201b.U) {
            int i = AbstractC6199c.AnonymousClass4.R[abstractC6199c.L - 1];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        abstractC6199c.L = AbstractC6199c.EnumC6201b.V;
        AbstractC6199c.AbstractCallableC6203d<Params, Result> abstractCallableC6203d = abstractC6199c.M;
        abstractCallableC6203d.Y = abstractC6199c.P;
        abstractCallableC6203d.priority = abstractC6199c.O;
        threadPoolExecutor.execute(abstractC6199c.N);
    }
}
