package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.dp */
/* loaded from: classes11.dex */
public class C7632dp {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (com.xiaomi.push.service.ba.a(context).a(ho.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !aj.a(context, str, j);
        }
        return false;
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] m701a = C7613bm.m701a(str);
        try {
            a(m701a);
            return C7674i.a(m701a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m701a = C7613bm.m701a(str);
        try {
            a(m701a);
            return C7674i.b(m701a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
