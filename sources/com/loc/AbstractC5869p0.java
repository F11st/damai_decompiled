package com.loc;

import com.loc.ck;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Taobao */
/* renamed from: com.loc.p0 */
/* loaded from: classes10.dex */
public abstract class AbstractC5869p0 {
    protected ThreadPoolExecutor a;
    private ConcurrentHashMap<ck, Future<?>> b = new ConcurrentHashMap<>();
    protected ck.InterfaceC5811a c = new C5870a();

    /* compiled from: Taobao */
    /* renamed from: com.loc.p0$a */
    /* loaded from: classes10.dex */
    final class C5870a implements ck.InterfaceC5811a {
        C5870a() {
        }

        @Override // com.loc.ck.InterfaceC5811a
        public final void a(ck ckVar) {
            AbstractC5869p0.this.a(ckVar);
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
