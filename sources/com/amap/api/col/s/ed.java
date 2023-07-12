package com.amap.api.col.s;

import com.amap.api.col.s.ec;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ed extends ef {
    private static ed c = new ed(new ec.a().a("amap-global-threadPool").a());

    private ed(ec ecVar) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(ecVar.a(), ecVar.b(), ecVar.d(), TimeUnit.SECONDS, ecVar.c(), ecVar);
            this.a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            cl.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static ed a() {
        return c;
    }
}
