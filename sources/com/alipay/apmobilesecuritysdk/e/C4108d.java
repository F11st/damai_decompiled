package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.C4097a;
import com.alipay.apmobilesecuritysdk.f.C4114a;
import com.alipay.sdk.m.z.C4368a;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.e.d */
/* loaded from: classes12.dex */
public final class C4108d {
    public static C4107c a(String str) {
        try {
            if (!C4368a.a(str)) {
                JSONObject jSONObject = new JSONObject(str);
                return new C4107c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString("utdid"));
            }
        } catch (Exception e) {
            C4097a.a(e);
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (C4108d.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (C4108d.class) {
            C4114a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
            C4114a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
        }
    }

    public static synchronized void a(Context context, C4107c c4107c) {
        synchronized (C4108d.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", c4107c.a);
                jSONObject.put("deviceInfoHash", c4107c.b);
                jSONObject.put("timestamp", c4107c.c);
                jSONObject.put("tid", c4107c.d);
                jSONObject.put("utdid", c4107c.e);
                String jSONObject2 = jSONObject.toString();
                C4114a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                C4114a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
            } catch (Exception e) {
                C4097a.a(e);
            }
        }
    }

    public static synchronized C4107c b() {
        synchronized (C4108d.class) {
            String a = C4114a.a("wxcasxx_v4", "key_wxcasxx_v4");
            if (C4368a.a(a)) {
                return null;
            }
            return a(a);
        }
    }

    public static synchronized C4107c b(Context context) {
        C4107c a;
        synchronized (C4108d.class) {
            String a2 = C4114a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (C4368a.a(a2)) {
                a2 = C4114a.a("wxcasxx_v4", "key_wxcasxx_v4");
            }
            a = a(a2);
        }
        return a;
    }

    public static synchronized C4107c c(Context context) {
        synchronized (C4108d.class) {
            String a = C4114a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (C4368a.a(a)) {
                return null;
            }
            return a(a);
        }
    }
}
