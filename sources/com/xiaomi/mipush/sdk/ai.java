package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bm;
import com.xiaomi.push.hj;
import com.xiaomi.push.hy;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ie;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ai {
    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar) {
        return a(context, t, hjVar, !hjVar.equals(hj.Registration), context.getPackageName(), b.m629a(context).m630a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar, boolean z, String str, String str2) {
        return a(context, t, hjVar, z, str, str2, true);
    }

    protected static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] a = it.a(t);
        if (a != null) {
            Cif cif = new Cif();
            if (z) {
                String d = b.m629a(context).d();
                if (TextUtils.isEmpty(d)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a = com.xiaomi.push.i.b(bm.m701a(d), a);
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
                    }
                }
            }
            hy hyVar = new hy();
            hyVar.f545a = 5L;
            hyVar.f546a = "fakeid";
            cif.a(hyVar);
            cif.a(ByteBuffer.wrap(a));
            cif.a(hjVar);
            cif.b(z2);
            cif.b(str);
            cif.a(z);
            cif.a(str2);
            return cif;
        }
        str3 = "invoke convertThriftObjectToBytes method, return null.";
        com.xiaomi.channel.commonutils.logger.b.m586a(str3);
        return null;
    }

    public static iu a(Context context, Cif cif) {
        byte[] m1028a;
        if (cif.m1030b()) {
            byte[] a = i.a(context, cif, e.ASSEMBLE_PUSH_FCM);
            if (a == null) {
                a = bm.m701a(b.m629a(context).d());
            }
            try {
                m1028a = com.xiaomi.push.i.a(a, cif.m1028a());
            } catch (Exception e) {
                throw new u("the aes decrypt failed.", e);
            }
        } else {
            m1028a = cif.m1028a();
        }
        iu a2 = a(cif.a(), cif.f625b);
        if (a2 != null) {
            it.a(a2, m1028a);
        }
        return a2;
    }

    private static iu a(hj hjVar, boolean z) {
        switch (aj.a[hjVar.ordinal()]) {
            case 1:
                return new ik();
            case 2:
                return new iq();
            case 3:
                return new io();
            case 4:
                return new is();
            case 5:
                return new im();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends iu<T, ?>> Cif b(Context context, T t, hj hjVar, boolean z, String str, String str2) {
        return a(context, t, hjVar, z, str, str2, false);
    }
}
