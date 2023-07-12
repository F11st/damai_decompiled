package com.huawei.hms.framework.network.grs.g.k;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.g.C5578d;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.g.k.b */
/* loaded from: classes10.dex */
public class C5589b {
    private final Future<C5578d> a;
    private final long b = SystemClock.elapsedRealtime();

    public C5589b(Future<C5578d> future) {
        this.a = future;
    }

    public Future<C5578d> a() {
        return this.a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= 300000;
    }
}
