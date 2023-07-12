package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class g {
    public static synchronized String a(Context context, String str) {
        synchronized (g.class) {
            String a = com.alipay.sdk.m.b0.e.a(context, "openapi_file_pri", "openApi" + str, "");
            if (com.alipay.sdk.m.z.a.a(a)) {
                return "";
            }
            String b = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), a);
            return com.alipay.sdk.m.z.a.a(b) ? "" : b;
        }
    }

    public static synchronized void a() {
        synchronized (g.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (g.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        synchronized (g.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    edit.putString("openApi" + str, com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str2));
                    edit.commit();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
