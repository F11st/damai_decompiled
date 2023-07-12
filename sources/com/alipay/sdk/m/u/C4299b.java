package com.alipay.sdk.m.u;

import android.os.SystemClock;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.b */
/* loaded from: classes10.dex */
public class C4299b {
    public static final long a = 3000;
    public static long b = -1;

    public static synchronized boolean a() {
        boolean z;
        synchronized (C4299b.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - b >= 3000) {
                b = elapsedRealtime;
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }
}
