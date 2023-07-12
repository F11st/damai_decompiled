package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.C7675im;
import com.xiaomi.push.C7677io;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ie;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ce {
    public static iu a(Context context, Cif cif) {
        if (cif.m1030b()) {
            return null;
        }
        byte[] m1028a = cif.m1028a();
        iu a = a(cif.a(), cif.f625b);
        if (a != null) {
            it.a(a, m1028a);
        }
        return a;
    }

    private static iu a(hj hjVar, boolean z) {
        switch (cf.a[hjVar.ordinal()]) {
            case 1:
                return new ik();
            case 2:
                return new iq();
            case 3:
                return new C7677io();
            case 4:
                return new is();
            case 5:
                return new C7675im();
            case 6:
                return new hz();
            case 7:
                return new ie();
            case 8:
                return new il();
            case 9:
                if (z) {
                    return new ii();
                }
                ia iaVar = new ia();
                iaVar.a(true);
                return iaVar;
            case 10:
                return new ie();
            default:
                return null;
        }
    }
}
