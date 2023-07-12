package com.alipay.sdk.m.u;

import android.os.SystemClock;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    public static final long a = 3000;
    public static long b = -1;

    public static synchronized boolean a() {
        boolean z;
        synchronized (b.class) {
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
