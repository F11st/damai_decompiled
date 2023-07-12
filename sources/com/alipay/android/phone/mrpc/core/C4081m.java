package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.m */
/* loaded from: classes12.dex */
public final class C4081m extends FutureTask<C4089u> {
    public final /* synthetic */ CallableC4085q a;
    public final /* synthetic */ C4080l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4081m(C4080l c4080l, Callable callable, CallableC4085q callableC4085q) {
        super(callable);
        this.b = c4080l;
        this.a = callableC4085q;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        C4083o a = this.a.a();
        if (a.f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || a.h()) {
                a.g();
                if (isCancelled() && isDone()) {
                    return;
                }
                cancel(false);
            }
        } catch (InterruptedException e) {
            e.toString();
        } catch (CancellationException unused) {
            a.g();
        } catch (ExecutionException e2) {
            if (e2.getCause() == null || !(e2.getCause() instanceof HttpException)) {
                e2.toString();
                return;
            }
            HttpException httpException = (HttpException) e2.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing http request", th);
        }
    }
}
