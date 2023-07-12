package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import com.alipay.sdk.m.b0.e;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String a;
        if (context == null || com.alipay.sdk.m.z.a.a(str)) {
            return null;
        }
        if (!com.alipay.sdk.m.z.a.a(str2)) {
            try {
                a = e.a(context, str, str2, "");
                if (com.alipay.sdk.m.z.a.a(a)) {
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), a);
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
                return null;
            }
            String a = com.alipay.sdk.m.b0.b.a(str);
            if (com.alipay.sdk.m.z.a.a(a)) {
                return null;
            }
            String string = new JSONObject(a).getString(str2);
            if (com.alipay.sdk.m.z.a.a(string)) {
                return null;
            }
            return com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), string);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!com.alipay.sdk.m.z.a.a(str) && !com.alipay.sdk.m.z.a.a(str2) && context != null) {
            try {
                String a = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, a);
                e.a(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
                return;
            }
            try {
                String a = com.alipay.sdk.m.b0.b.a(str);
                JSONObject jSONObject = new JSONObject();
                if (com.alipay.sdk.m.z.a.b(a)) {
                    try {
                        jSONObject = new JSONObject(a);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                }
                jSONObject.put(str2, com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3));
                jSONObject.toString();
                try {
                    System.clearProperty(str);
                } catch (Throwable unused2) {
                }
                if (com.alipay.sdk.m.b0.c.a()) {
                    String str4 = ".SystemConfig" + File.separator + str;
                    if (com.alipay.sdk.m.b0.c.a()) {
                        File file = new File(Environment.getExternalStorageDirectory(), str4);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
