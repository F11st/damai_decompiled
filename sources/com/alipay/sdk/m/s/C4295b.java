package com.alipay.sdk.m.s;

import android.content.Context;
import com.alipay.sdk.m.m.C4248b;
import com.alipay.sdk.m.w.C4325b;
import java.io.File;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.s.b */
/* loaded from: classes12.dex */
public class C4295b {
    public static C4295b b;
    public Context a;

    public static C4295b d() {
        if (b == null) {
            b = new C4295b();
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
        C4248b.b();
        this.a = context.getApplicationContext();
    }

    public Context b() {
        return this.a;
    }

    public String c() {
        return C4325b.c(null, this.a);
    }

    public C4248b a() {
        return C4248b.b();
    }
}
