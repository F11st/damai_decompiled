package com.huawei.hms.framework.network.grs.g.k;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private final Future<com.huawei.hms.framework.network.grs.g.d> a;
    private final long b = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.a = future;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= 300000;
    }
}
