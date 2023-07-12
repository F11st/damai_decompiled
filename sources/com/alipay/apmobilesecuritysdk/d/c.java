package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        com.alipay.sdk.m.a0.b b = com.alipay.sdk.m.a0.b.b();
        HashMap hashMap = new HashMap();
        f a = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String a2 = b.a(context);
        String b2 = b.b(context);
        String m = com.alipay.sdk.m.a0.b.m(context);
        if (a != null) {
            if (com.alipay.sdk.m.z.a.a(a2)) {
                a2 = a.a();
            }
            if (com.alipay.sdk.m.z.a.a(b2)) {
                b2 = a.b();
            }
            if (com.alipay.sdk.m.z.a.a(m)) {
                m = a.e();
            }
        }
        f fVar = new f(a2, b2, "", "", m);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
        }
        hashMap.put("AD1", a2);
        hashMap.put("AD2", b2);
        hashMap.put("AD3", com.alipay.sdk.m.a0.b.h(context));
        hashMap.put("AD5", com.alipay.sdk.m.a0.b.j(context));
        hashMap.put("AD6", com.alipay.sdk.m.a0.b.k(context));
        hashMap.put("AD7", com.alipay.sdk.m.a0.b.l(context));
        hashMap.put("AD9", b.c(context));
        hashMap.put("AD10", m);
        hashMap.put("AD11", com.alipay.sdk.m.a0.b.e());
        hashMap.put("AD12", b.a());
        hashMap.put("AD13", com.alipay.sdk.m.a0.b.f());
        hashMap.put("AD14", com.alipay.sdk.m.a0.b.h());
        hashMap.put("AD15", com.alipay.sdk.m.a0.b.i());
        hashMap.put("AD16", com.alipay.sdk.m.a0.b.j());
        hashMap.put("AD17", "");
        hashMap.put("AD19", com.alipay.sdk.m.a0.b.n(context));
        hashMap.put("AD20", com.alipay.sdk.m.a0.b.k());
        hashMap.put("AD22", "");
        hashMap.put("AD23", com.alipay.sdk.m.a0.b.o(context));
        hashMap.put("AD24", com.alipay.sdk.m.z.a.g(com.alipay.sdk.m.a0.b.i(context)));
        hashMap.put("AD26", com.alipay.sdk.m.a0.b.g(context));
        hashMap.put("AD27", com.alipay.sdk.m.a0.b.p());
        hashMap.put("AD28", com.alipay.sdk.m.a0.b.r());
        hashMap.put("AD29", com.alipay.sdk.m.a0.b.t());
        hashMap.put("AD30", com.alipay.sdk.m.a0.b.q());
        hashMap.put("AD31", com.alipay.sdk.m.a0.b.s());
        hashMap.put("AD32", com.alipay.sdk.m.a0.b.n());
        hashMap.put("AD33", com.alipay.sdk.m.a0.b.o());
        hashMap.put("AD34", com.alipay.sdk.m.a0.b.p(context));
        hashMap.put("AD35", com.alipay.sdk.m.a0.b.q(context));
        hashMap.put("AD36", b.d(context));
        hashMap.put("AD37", com.alipay.sdk.m.a0.b.m());
        hashMap.put("AD38", com.alipay.sdk.m.a0.b.l());
        hashMap.put("AD39", com.alipay.sdk.m.a0.b.e(context));
        hashMap.put("AD40", com.alipay.sdk.m.a0.b.f(context));
        hashMap.put("AD41", com.alipay.sdk.m.a0.b.c());
        hashMap.put("AD42", com.alipay.sdk.m.a0.b.d());
        return hashMap;
    }
}
