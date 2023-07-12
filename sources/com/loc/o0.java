package com.loc;

import com.loc.ci;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class o0 extends p0 {
    private static o0 d = new o0(new ci.a().a("amap-global-threadPool").b());

    private o0(ci ciVar) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(ciVar.a(), ciVar.b(), ciVar.d(), TimeUnit.SECONDS, ciVar.c(), ciVar);
            this.a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            an.m(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static o0 f() {
        return d;
    }
}
