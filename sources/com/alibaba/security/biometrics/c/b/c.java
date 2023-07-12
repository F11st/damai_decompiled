package com.alibaba.security.biometrics.c.b;

import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class c {
    public static void a(int i, int i2) {
        if (i == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("succ", 1);
            bundle.putInt("reason", i);
            bundle.putInt("retry_tt", i2);
            a.b().a("10031", bundle);
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("succ", 0);
            bundle2.putInt("reason", i);
            bundle2.putInt("retry_tt", i2);
            a.b().a("10031", bundle2);
        }
        if (i == -1) {
            a.b().a("10030", (Bundle) null);
        }
    }
}
