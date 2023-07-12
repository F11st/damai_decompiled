package com.alipay.sdk.m.s;

import android.content.Context;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    public static b b;
    public Context a;

    public static b d() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public static boolean e() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public void a(Context context) {
        com.alipay.sdk.m.m.b.b();
        this.a = context.getApplicationContext();
    }

    public Context b() {
        return this.a;
    }

    public String c() {
        return com.alipay.sdk.m.w.b.c(null, this.a);
    }

    public com.alipay.sdk.m.m.b a() {
        return com.alipay.sdk.m.m.b.b();
    }
}
