package com.loc;

import com.loc.ck;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class p0 {
    protected ThreadPoolExecutor a;
    private ConcurrentHashMap<ck, Future<?>> b = new ConcurrentHashMap<>();
    protected ck.a c = new a();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class a implements ck.a {
        a() {
        }

        @Override // com.loc.ck.a
        public final void a(ck ckVar) {
            p0.this.a(ckVar);
        }
    }

    private synchronized void b(ck ckVar, Future<?> future) {
        try {
            this.b.put(ckVar, future);
        } catch (Throwable th) {
            an.m(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean e(ck ckVar) {
        boolean z;
        try {
            z = this.b.containsKey(ckVar);
        } catch (Throwable th) {
            an.m(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }

    protected final synchronized void a(ck ckVar) {
        try {
            this.b.remove(ckVar);
        } catch (Throwable th) {
            an.m(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final Executor c() {
        return this.a;
    }

    public final void d(ck ckVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (e(ckVar) || (threadPoolExecutor = this.a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        ckVar.e = this.c;
        try {
            Future<?> submit = this.a.submit(ckVar);
            if (submit == null) {
                return;
            }
            b(ckVar, submit);
        } catch (RejectedExecutionException e) {
            an.m(e, "TPool", "addTask");
        }
    }
}
