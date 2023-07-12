package com.alipay.sdk.m.p;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.rpc.safe.AES;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.j.C4211a;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.l.C4231b;
import com.alipay.sdk.m.m.C4248b;
import com.alipay.sdk.m.o.C4261a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.t.C4296a;
import com.alipay.sdk.m.u.C4301d;
import com.alipay.sdk.m.u.C4302e;
import com.alipay.sdk.m.u.C4317m;
import com.alipay.sdk.m.u.C4318n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.p.e */
/* loaded from: classes12.dex */
public abstract class AbstractC4271e {
    public static final String c = "msp-gzip";
    public static final String d = "Msp-Param";
    public static final String e = "Operation-Type";
    public static final String f = "content-type";
    public static final String g = "Version";
    public static final String h = "AppId";
    public static final String i = "des-mode";
    public static final String j = "namespace";
    public static final String k = "api_name";
    public static final String l = "api_version";
    public static final String m = "data";
    public static final String n = "params";
    public static final String o = "public_key";
    public static final String p = "device";
    public static final String q = "action";
    public static final String r = "type";
    public static final String s = "method";
    public boolean a = true;
    public boolean b = true;

    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(c, String.valueOf(z));
        hashMap.put(e, "alipay.msp.cashier.dispatch.bytes");
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put("Version", "2.0");
        hashMap.put(h, "TAOBAO");
        hashMap.put(d, C4267a.a(str));
        hashMap.put(i, AES.BLOCK_MODE);
        return hashMap;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return "4.9.0";
    }

    public abstract boolean c();

    public String a(C4293a c4293a) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device", Build.getMODEL());
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put("api_name", "com.alipay.mcpay");
        hashMap.put(l, b());
        return a(c4293a, hashMap, new HashMap<>());
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public String a(C4293a c4293a, String str, JSONObject jSONObject) {
        C4295b d2 = C4295b.d();
        C4296a a = C4296a.a(d2.b());
        JSONObject a2 = C4301d.a(new JSONObject(), jSONObject);
        try {
            a2.put(C4231b.d, str);
            a2.put("tid", a.d());
            a2.put("user_agent", d2.a().a(c4293a, a, c()));
            a2.put(C4231b.e, C4318n.a(c4293a, d2.b(), C4211a.d, false));
            a2.put(C4231b.f, C4318n.h(d2.b()));
            a2.put(C4231b.h, C4230a.f);
            a2.put("utdid", d2.c());
            a2.put(C4231b.j, a.c());
            a2.put(C4231b.k, C4248b.b(d2.b()));
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, "BodyErr", th);
            C4302e.a(th);
        }
        return a2.toString();
    }

    public static boolean a(C4261a.C4263b c4263b) {
        return Boolean.valueOf(a(c4263b, c)).booleanValue();
    }

    public static String a(C4261a.C4263b c4263b, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (c4263b == null || str == null || (map = c4263b.a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public String a(C4293a c4293a, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (hashMap2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (jSONObject.has("params")) {
                String optString = jSONObject.getJSONObject("params").optString(o, null);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                C4248b.a(optString);
                return true;
            }
            return false;
        } catch (JSONException e2) {
            C4302e.a(e2);
            return false;
        }
    }

    public C4268b a(C4293a c4293a, Context context) throws Throwable {
        return a(c4293a, context, "");
    }

    public C4268b a(C4293a c4293a, Context context, String str) throws Throwable {
        return a(c4293a, context, str, C4317m.b(context));
    }

    public C4268b a(C4293a c4293a, Context context, String str, String str2) throws Throwable {
        return a(c4293a, context, str, str2, true);
    }

    public C4268b a(C4293a c4293a, Context context, String str, String str2, boolean z) throws Throwable {
        C4302e.b(C4230a.z, "Packet: " + str2);
        C4269c c4269c = new C4269c(this.b);
        C4268b c4268b = new C4268b(a(c4293a), a(c4293a, str, a()));
        Map<String, String> a = a(false, str);
        C4270d a2 = c4269c.a(c4268b, this.a, a.get("iSr"));
        C4261a.C4263b a3 = C4261a.a(context, new C4261a.C4262a(str2, a(a2.b(), str), a2.a()));
        if (a3 != null) {
            C4268b a4 = c4269c.a(new C4270d(a(a3), a3.c), a.get("iSr"));
            return (a4 != null && a(a4.b()) && z) ? a(c4293a, context, str, str2, false) : a4;
        }
        throw new RuntimeException("Response is null.");
    }
}
