package com.alipay.sdk.m.q;

import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.p.AbstractC4271e;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4298a;
import com.alipay.sdk.m.u.C4302e;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.q.b */
/* loaded from: classes10.dex */
public class C4279b extends AbstractC4271e {
    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public JSONObject a() throws JSONException {
        return AbstractC4271e.a("sdkConfig", "obtain");
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public String b() {
        return "5.0.0";
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public boolean c() {
        return true;
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public String a(C4293a c4293a, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        hashMap2.putAll(C4298a.a(c4293a));
        C4302e.d(C4230a.z, "cf " + hashMap2);
        return super.a(c4293a, hashMap, hashMap2);
    }
}
