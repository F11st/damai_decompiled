package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.C4097a;
import com.alipay.apmobilesecuritysdk.e.C4109e;
import com.alipay.apmobilesecuritysdk.e.C4110f;
import com.alipay.apmobilesecuritysdk.f.C4114a;
import com.alipay.sdk.m.a0.C4139b;
import com.alipay.sdk.m.z.C4368a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.d.c */
/* loaded from: classes12.dex */
public final class C4102c {
    public static Map<String, String> a(Context context) {
        C4139b b = C4139b.b();
        HashMap hashMap = new HashMap();
        C4110f a = C4109e.a(context);
        String a2 = b.a(context);
        String b2 = b.b(context);
        String m = C4139b.m(context);
        if (a != null) {
            if (C4368a.a(a2)) {
                a2 = a.a();
            }
            if (C4368a.a(b2)) {
                b2 = a.b();
            }
            if (C4368a.a(m)) {
                m = a.e();
            }
        }
        C4110f c4110f = new C4110f(a2, b2, "", "", m);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", c4110f.a());
                jSONObject.put("imsi", c4110f.b());
                jSONObject.put("mac", c4110f.c());
                jSONObject.put("bluetoothmac", c4110f.d());
                jSONObject.put("gsi", c4110f.e());
                String jSONObject2 = jSONObject.toString();
                C4114a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                C4114a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e) {
                C4097a.a(e);
            }
        }
        hashMap.put("AD1", a2);
        hashMap.put("AD2", b2);
        hashMap.put("AD3", C4139b.h(context));
        hashMap.put("AD5", C4139b.j(context));
        hashMap.put("AD6", C4139b.k(context));
        hashMap.put("AD7", C4139b.l(context));
        hashMap.put("AD9", b.c(context));
        hashMap.put("AD10", m);
        hashMap.put("AD11", C4139b.e());
        hashMap.put("AD12", b.a());
        hashMap.put("AD13", C4139b.f());
        hashMap.put("AD14", C4139b.h());
        hashMap.put("AD15", C4139b.i());
        hashMap.put("AD16", C4139b.j());
        hashMap.put("AD17", "");
        hashMap.put("AD19", C4139b.n(context));
        hashMap.put("AD20", C4139b.k());
        hashMap.put("AD22", "");
        hashMap.put("AD23", C4139b.o(context));
        hashMap.put("AD24", C4368a.g(C4139b.i(context)));
        hashMap.put("AD26", C4139b.g(context));
        hashMap.put("AD27", C4139b.p());
        hashMap.put("AD28", C4139b.r());
        hashMap.put("AD29", C4139b.t());
        hashMap.put("AD30", C4139b.q());
        hashMap.put("AD31", C4139b.s());
        hashMap.put("AD32", C4139b.n());
        hashMap.put("AD33", C4139b.o());
        hashMap.put("AD34", C4139b.p(context));
        hashMap.put("AD35", C4139b.q(context));
        hashMap.put("AD36", b.d(context));
        hashMap.put("AD37", C4139b.m());
        hashMap.put("AD38", C4139b.l());
        hashMap.put("AD39", C4139b.e(context));
        hashMap.put("AD40", C4139b.f(context));
        hashMap.put("AD41", C4139b.c());
        hashMap.put("AD42", C4139b.d());
        return hashMap;
    }
}
