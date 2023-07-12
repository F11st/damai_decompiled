package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.g.C4192a;
import com.alipay.sdk.m.h.C4197a;
import com.alipay.sdk.m.h.C4199c;
import com.alipay.sdk.m.h.C4202f;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.w.C4325b;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.a */
/* loaded from: classes10.dex */
public class C4298a {
    public static final String a = "ap_req";
    public static final String b = "ap_args";
    public static final String c = "ap_resp";

    public static C4192a a() {
        try {
            try {
                return C4197a.a("NP", System.currentTimeMillis(), new C4199c(C4295b.d().c()), (short) C4218a.C4223c.a(C4295b.d().b()), new C4202f());
            } catch (Exception unused) {
                return C4197a.c();
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static HashMap<String, String> a(C4293a c4293a) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            C4192a a2 = a();
            JSONObject jSONObject = new JSONObject();
            Context a3 = c4293a != null ? c4293a.a() : null;
            if (a3 == null) {
                a3 = C4295b.d().b().getApplicationContext();
            }
            String a4 = C4318n.a(c4293a, a3);
            String b2 = C4325b.b(c4293a, a3);
            jSONObject.put("ap_q", a2 != null ? a2.a() : "");
            jSONObject.put(C4293a.z, c4293a != null ? c4293a.d : "");
            jSONObject.put("u_pd", String.valueOf(C4318n.g()));
            jSONObject.put("u_lk", String.valueOf(C4318n.e(C4318n.b())));
            jSONObject.put("u_pi", String.valueOf(c4293a != null ? c4293a.g : JSMethod.NOT_SET));
            jSONObject.put("u_fu", a4);
            jSONObject.put("u_oi", b2);
            hashMap.put(a, jSONObject.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(a2 != null ? a2.a() : "");
            sb.append("|");
            sb.append(a4);
            C4218a.a(c4293a, C4226b.l, "ap_q", sb.toString());
        } catch (Exception e) {
            C4218a.a(c4293a, C4226b.l, "APMEx1", e);
        }
        return hashMap;
    }

    public static JSONObject a(C4293a c4293a, JSONObject jSONObject) {
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
            C4218a.a(c4293a, C4226b.l, "APMEx2", e);
            return null;
        }
    }

    public static void a(C4293a c4293a, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.putOpt(b, jSONObject2);
        } catch (JSONException e) {
            C4218a.a(c4293a, C4226b.l, "APMEx2", e);
        }
    }

    public static void a(C4293a c4293a, HashMap<String, String> hashMap) {
        JSONObject a2 = C4245a.D().a();
        if (hashMap == null || a2 == null) {
            return;
        }
        C4218a.a(c4293a, C4226b.l, "ap_r", a2.optString("ap_r"));
        hashMap.putAll(C4318n.a(a2));
    }
}
