package com.alibaba.security.biometrics.sensor.a;

import android.app.Activity;
import com.alibaba.security.biometrics.sensor.api.RpSecException;
import com.alibaba.security.biometrics.sensor.b.C3796a;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.sensor.a.a */
/* loaded from: classes8.dex */
public abstract class AbstractC3791a<T> {
    protected Activity a;
    protected C3796a b;

    public AbstractC3791a(Activity activity) {
        this.a = activity;
    }

    private static long e() {
        return System.currentTimeMillis();
    }

    abstract void a() throws RpSecException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C3796a c3796a) throws RpSecException {
        this.b = c3796a;
    }

    abstract T b();

    abstract boolean c() throws RpSecException;

    abstract void d() throws RpSecException;
}
