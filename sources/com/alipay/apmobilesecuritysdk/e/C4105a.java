package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.C4097a;
import com.alipay.apmobilesecuritysdk.f.C4114a;
import com.alipay.sdk.m.z.C4368a;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.e.a */
/* loaded from: classes12.dex */
public final class C4105a {
    public static C4106b a(String str) {
        try {
            if (!C4368a.a(str)) {
                JSONObject jSONObject = new JSONObject(str);
                return new C4106b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
            }
        } catch (Exception e) {
            C4097a.a(e);
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (C4105a.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (C4105a.class) {
            C4114a.a(context, "vkeyid_profiles_v3", "deviceid", "");
            C4114a.a("wxcasxx_v3", "wxcasxx", "");
        }
    }

    public static synchronized void a(Context context, C4106b c4106b) {
        synchronized (C4105a.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", c4106b.a);
                jSONObject.put("deviceInfoHash", c4106b.b);
                jSONObject.put("timestamp", c4106b.c);
                String jSONObject2 = jSONObject.toString();
                C4114a.a(context, "vkeyid_profiles_v3", "deviceid", jSONObject2);
                C4114a.a("wxcasxx_v3", "wxcasxx", jSONObject2);
            } catch (Exception e) {
                C4097a.a(e);
            }
        }
    }

    public static synchronized C4106b b() {
        synchronized (C4105a.class) {
            String a = C4114a.a("wxcasxx_v3", "wxcasxx");
            if (C4368a.a(a)) {
                return null;
            }
            return a(a);
        }
    }

    public static synchronized C4106b b(Context context) {
        C4106b a;
        synchronized (C4105a.class) {
            String a2 = C4114a.a(context, "vkeyid_profiles_v3", "deviceid");
            if (C4368a.a(a2)) {
                a2 = C4114a.a("wxcasxx_v3", "wxcasxx");
            }
            a = a(a2);
        }
        return a;
    }

    public static synchronized C4106b c(Context context) {
        synchronized (C4105a.class) {
            String a = C4114a.a(context, "vkeyid_profiles_v3", "deviceid");
            if (C4368a.a(a)) {
                return null;
            }
            return a(a);
        }
    }
}
