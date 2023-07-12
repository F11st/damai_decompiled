package com.alipay.sdk.m.q;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b extends com.alipay.sdk.m.p.e {
    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.m.p.e.a("sdkConfig", "obtain");
    }

    @Override // com.alipay.sdk.m.p.e
    public String b() {
        return "5.0.0";
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return true;
    }

    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a aVar, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        hashMap2.putAll(com.alipay.sdk.m.u.a.a(aVar));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "cf " + hashMap2);
        return super.a(aVar, hashMap, hashMap2);
    }
}
