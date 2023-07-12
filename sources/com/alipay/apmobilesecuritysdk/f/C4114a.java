package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import com.alipay.sdk.m.b0.C4146b;
import com.alipay.sdk.m.b0.C4147c;
import com.alipay.sdk.m.b0.C4149e;
import com.alipay.sdk.m.y.C4367c;
import com.alipay.sdk.m.z.C4368a;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.f.a */
/* loaded from: classes12.dex */
public class C4114a {
    public static String a(Context context, String str, String str2) {
        String a;
        if (context == null || C4368a.a(str)) {
            return null;
        }
        if (!C4368a.a(str2)) {
            try {
                a = C4149e.a(context, str, str2, "");
                if (C4368a.a(a)) {
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return C4367c.b(C4367c.a(), a);
    }

    public static String a(String str, String str2) {
        synchronized (C4114a.class) {
            if (C4368a.a(str) || C4368a.a(str2)) {
                return null;
            }
            String a = C4146b.a(str);
            if (C4368a.a(a)) {
                return null;
            }
            String string = new JSONObject(a).getString(str2);
            if (C4368a.a(string)) {
                return null;
            }
            return C4367c.b(C4367c.a(), string);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!C4368a.a(str) && !C4368a.a(str2) && context != null) {
            try {
                String a = C4367c.a(C4367c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, a);
                C4149e.a(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (C4114a.class) {
            if (C4368a.a(str) || C4368a.a(str2)) {
                return;
            }
            try {
                String a = C4146b.a(str);
                JSONObject jSONObject = new JSONObject();
                if (C4368a.b(a)) {
                    try {
                        jSONObject = new JSONObject(a);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                }
                jSONObject.put(str2, C4367c.a(C4367c.a(), str3));
                jSONObject.toString();
                try {
                    System.clearProperty(str);
                } catch (Throwable unused2) {
                }
                if (C4147c.a()) {
                    String str4 = ".SystemConfig" + File.separator + str;
                    if (C4147c.a()) {
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
