package com.alipay.sdk.m.q;

import android.content.Context;
import com.ali.user.mobile.rpc.safe.AES;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.p.AbstractC4271e;
import com.alipay.sdk.m.p.C4268b;
import com.alipay.sdk.m.s.C4293a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.q.d */
/* loaded from: classes10.dex */
public class C4281d extends AbstractC4271e {
    public static final String t = "log_v";

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public String a(C4293a c4293a, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AbstractC4271e.c, String.valueOf(z));
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put(AbstractC4271e.i, AES.BLOCK_MODE);
        return hashMap;
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public boolean c() {
        return false;
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public String a(C4293a c4293a) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put(AbstractC4271e.l, "1.0.0");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(t, "1.0");
        return a(c4293a, hashMap, hashMap2);
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public C4268b a(C4293a c4293a, Context context, String str) throws Throwable {
        return a(c4293a, context, str, C4230a.c, true);
    }
}
