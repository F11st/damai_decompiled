package com.alipay.sdk.m.q;

import android.content.Context;
import com.ali.user.mobile.rpc.safe.AES;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d extends com.alipay.sdk.m.p.e {
    public static final String t = "log_v";

    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.m.p.e
    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.alipay.sdk.m.p.e.c, String.valueOf(z));
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put(com.alipay.sdk.m.p.e.i, AES.BLOCK_MODE);
        return hashMap;
    }

    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return false;
    }

    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a aVar) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put(com.alipay.sdk.m.p.e.l, "1.0.0");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(t, "1.0");
        return a(aVar, hashMap, hashMap2);
    }

    @Override // com.alipay.sdk.m.p.e
    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, com.alipay.sdk.m.l.a.c, true);
    }
}
