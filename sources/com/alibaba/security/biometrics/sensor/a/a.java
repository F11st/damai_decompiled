package com.alibaba.security.biometrics.sensor.a;

import android.app.Activity;
import com.alibaba.security.biometrics.sensor.api.RpSecException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class a<T> {
    protected Activity a;
    protected com.alibaba.security.biometrics.sensor.b.a b;

    public a(Activity activity) {
        this.a = activity;
    }

    private static long e() {
        return System.currentTimeMillis();
    }

    abstract void a() throws RpSecException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.alibaba.security.biometrics.sensor.b.a aVar) throws RpSecException {
        this.b = aVar;
    }

    abstract T b();

    abstract boolean c() throws RpSecException;

    abstract void d() throws RpSecException;
}
