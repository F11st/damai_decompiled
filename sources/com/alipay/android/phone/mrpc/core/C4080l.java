package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.l */
/* loaded from: classes10.dex */
public final class C4080l implements InterfaceC4065ab {
    public static C4080l b;
    public static final ThreadFactory i = new ThreadFactoryC4082n();
    public Context a;
    public ThreadPoolExecutor c;
    public C4067b d = C4067b.a("android");
    public long e;
    public long f;
    public long g;
    public int h;

    public C4080l(Context context) {
        this.a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final C4080l a(Context context) {
        C4080l c4080l = b;
        return c4080l != null ? c4080l : b(context);
    }

    public static final synchronized C4080l b(Context context) {
        synchronized (C4080l.class) {
            C4080l c4080l = b;
            if (c4080l != null) {
                return c4080l;
            }
            C4080l c4080l2 = new C4080l(context);
            b = c4080l2;
            return c4080l2;
        }
    }

    public final C4067b a() {
        return this.d;
    }

    @Override // com.alipay.android.phone.mrpc.core.InterfaceC4065ab
    public final Future<C4089u> a(AbstractC4088t abstractC4088t) {
        if (C4087s.a(this.a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.c.getActiveCount());
            objArr[1] = Long.valueOf(this.c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.c.getTaskCount());
            long j = this.g;
            objArr[3] = Long.valueOf(j == 0 ? 0L : ((this.e * 1000) / j) >> 10);
            int i2 = this.h;
            objArr[4] = Long.valueOf(i2 != 0 ? this.f / i2 : 0L);
            objArr[5] = Long.valueOf(this.e);
            objArr[6] = Long.valueOf(this.f);
            objArr[7] = Long.valueOf(this.g);
            objArr[8] = Integer.valueOf(this.h);
            String.format(str, objArr);
        }
        CallableC4085q callableC4085q = new CallableC4085q(this, (C4083o) abstractC4088t);
        C4081m c4081m = new C4081m(this, callableC4085q, callableC4085q);
        this.c.execute(c4081m);
        return c4081m;
    }

    public final void a(long j) {
        this.e += j;
    }

    public final void b(long j) {
        this.f += j;
        this.h++;
    }

    public final void c(long j) {
        this.g += j;
    }
}
