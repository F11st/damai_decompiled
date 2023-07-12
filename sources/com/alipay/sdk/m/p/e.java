package com.alipay.sdk.m.p;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.rpc.safe.AES;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.o.a;
import com.alipay.sdk.m.u.m;
import com.alipay.sdk.m.u.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class e {
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
        hashMap.put(d, a.a(str));
        hashMap.put(i, AES.BLOCK_MODE);
        return hashMap;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return "4.9.0";
    }

    public abstract boolean c();

    public String a(com.alipay.sdk.m.s.a aVar) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device", Build.getMODEL());
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put("api_name", "com.alipay.mcpay");
        hashMap.put(l, b());
        return a(aVar, hashMap, new HashMap<>());
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public String a(com.alipay.sdk.m.s.a aVar, String str, JSONObject jSONObject) {
        com.alipay.sdk.m.s.b d2 = com.alipay.sdk.m.s.b.d();
        com.alipay.sdk.m.t.a a = com.alipay.sdk.m.t.a.a(d2.b());
        JSONObject a2 = com.alipay.sdk.m.u.d.a(new JSONObject(), jSONObject);
        try {
            a2.put(com.alipay.sdk.m.l.b.d, str);
            a2.put("tid", a.d());
            a2.put("user_agent", d2.a().a(aVar, a, c()));
            a2.put(com.alipay.sdk.m.l.b.e, n.a(aVar, d2.b(), com.alipay.sdk.m.j.a.d, false));
            a2.put(com.alipay.sdk.m.l.b.f, n.h(d2.b()));
            a2.put(com.alipay.sdk.m.l.b.h, com.alipay.sdk.m.l.a.f);
            a2.put("utdid", d2.c());
            a2.put(com.alipay.sdk.m.l.b.j, a.c());
            a2.put(com.alipay.sdk.m.l.b.k, com.alipay.sdk.m.m.b.b(d2.b()));
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BodyErr", th);
            com.alipay.sdk.m.u.e.a(th);
        }
        return a2.toString();
    }

    public static boolean a(a.b bVar) {
        return Boolean.valueOf(a(bVar, c)).booleanValue();
    }

    public static String a(a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public String a(com.alipay.sdk.m.s.a aVar, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
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
                com.alipay.sdk.m.m.b.a(optString);
                return true;
            }
            return false;
        } catch (JSONException e2) {
            com.alipay.sdk.m.u.e.a(e2);
            return false;
        }
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context) throws Throwable {
        return a(aVar, context, "");
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, m.b(context));
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2) throws Throwable {
        return a(aVar, context, str, str2, true);
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2, boolean z) throws Throwable {
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "Packet: " + str2);
        c cVar = new c(this.b);
        b bVar = new b(a(aVar), a(aVar, str, a()));
        Map<String, String> a = a(false, str);
        d a2 = cVar.a(bVar, this.a, a.get("iSr"));
        a.b a3 = com.alipay.sdk.m.o.a.a(context, new a.C0196a(str2, a(a2.b(), str), a2.a()));
        if (a3 != null) {
            b a4 = cVar.a(new d(a(a3), a3.c), a.get("iSr"));
            return (a4 != null && a(a4.b()) && z) ? a(aVar, context, str, str2, false) : a4;
        }
        throw new RuntimeException("Response is null.");
    }
}
