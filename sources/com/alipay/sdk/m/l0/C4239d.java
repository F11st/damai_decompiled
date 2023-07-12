package com.alipay.sdk.m.l0;

import android.content.Context;
import android.text.TextUtils;
import java.util.Random;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.l0.d */
/* loaded from: classes12.dex */
public class C4239d {
    public static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] a = C4238c.a(currentTimeMillis);
        byte[] a2 = C4238c.a(nanoTime);
        byte[] a3 = C4238c.a(nextInt);
        byte[] a4 = C4238c.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a, 0, bArr, 0, 4);
        System.arraycopy(a2, 0, bArr, 4, 4);
        System.arraycopy(a3, 0, bArr, 8, 4);
        System.arraycopy(a4, 0, bArr, 12, 4);
        return C4234b.c(bArr, 2);
    }

    public static String b() {
        String a = C4244g.a("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(a)) {
            a = C4244g.a("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(a) ? c() : a;
    }

    public static String b(Context context) {
        return "";
    }

    public static String c() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        String b = C4243f.m215a((String) null) ? b() : null;
        return C4243f.m215a(b) ? a() : b;
    }
}
