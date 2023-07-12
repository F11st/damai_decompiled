package com.alibaba.analytics.core.logbuilder;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.c.C4151a;
import tb.gn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.alibaba.analytics.core.logbuilder.b */
/* loaded from: classes15.dex */
public class C3122b {
    private static String a = "";
    private static boolean b = false;
    private static String c = "";
    private static boolean d;

    C3122b() {
    }

    private static String a(Context context) {
        if (!b && context != null) {
            try {
                a = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable unused) {
            }
            b = true;
            return a;
        }
        return a;
    }

    private static String b() {
        return c(C4151a.b, "");
    }

    private static String c(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Context context) {
        if (!d && context != null) {
            synchronized (C3122b.class) {
                if (d) {
                    return c;
                }
                if (e()) {
                    String b2 = b();
                    c = "aid=" + a(context) + ",hmos=1,hmv=" + b2;
                } else {
                    c = "aid=" + a(context) + ",hmos=0";
                }
                d = true;
                return c + "," + IRequestConst.OAID + "=" + Variables.n().t();
            }
        }
        return c + "," + IRequestConst.OAID + "=" + Variables.n().t();
    }

    private static boolean e() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            return false;
        }
    }
}
