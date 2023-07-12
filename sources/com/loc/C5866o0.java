package com.loc;

import com.loc.ci;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.loc.o0 */
/* loaded from: classes10.dex */
public final class C5866o0 extends AbstractC5869p0 {
    private static C5866o0 d = new C5866o0(new ci.C5810a().a("amap-global-threadPool").b());

    private C5866o0(ci ciVar) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(ciVar.a(), ciVar.b(), ciVar.d(), TimeUnit.SECONDS, ciVar.c(), ciVar);
            this.a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            an.m(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static C5866o0 f() {
        return d;
    }
}
