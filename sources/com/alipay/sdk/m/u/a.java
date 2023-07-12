package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.k.a;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    public static final String a = "ap_req";
    public static final String b = "ap_args";
    public static final String c = "ap_resp";

    public static com.alipay.sdk.m.g.a a() {
        try {
            try {
                return com.alipay.sdk.m.h.a.a("NP", System.currentTimeMillis(), new com.alipay.sdk.m.h.c(com.alipay.sdk.m.s.b.d().c()), (short) a.c.a(com.alipay.sdk.m.s.b.d().b()), new com.alipay.sdk.m.h.f());
            } catch (Exception unused) {
                return com.alipay.sdk.m.h.a.c();
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static HashMap<String, String> a(com.alipay.sdk.m.s.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            com.alipay.sdk.m.g.a a2 = a();
            JSONObject jSONObject = new JSONObject();
            Context a3 = aVar != null ? aVar.a() : null;
            if (a3 == null) {
                a3 = com.alipay.sdk.m.s.b.d().b().getApplicationContext();
            }
            String a4 = n.a(aVar, a3);
            String b2 = com.alipay.sdk.m.w.b.b(aVar, a3);
            jSONObject.put("ap_q", a2 != null ? a2.a() : "");
            jSONObject.put(com.alipay.sdk.m.s.a.z, aVar != null ? aVar.d : "");
            jSONObject.put("u_pd", String.valueOf(n.g()));
            jSONObject.put("u_lk", String.valueOf(n.e(n.b())));
            jSONObject.put("u_pi", String.valueOf(aVar != null ? aVar.g : JSMethod.NOT_SET));
            jSONObject.put("u_fu", a4);
            jSONObject.put("u_oi", b2);
            hashMap.put(a, jSONObject.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(a2 != null ? a2.a() : "");
            sb.append("|");
            sb.append(a4);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ap_q", sb.toString());
        } catch (Exception e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx1", e);
        }
        return hashMap;
    }

    public static JSONObject a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(c);
        try {
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return new JSONObject(optString);
        } catch (JSONException e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx2", e);
            return null;
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.putOpt(b, jSONObject2);
        } catch (JSONException e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx2", e);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, HashMap<String, String> hashMap) {
        JSONObject a2 = com.alipay.sdk.m.m.a.D().a();
        if (hashMap == null || a2 == null) {
            return;
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ap_r", a2.optString("ap_r"));
        hashMap.putAll(n.a(a2));
    }
}
