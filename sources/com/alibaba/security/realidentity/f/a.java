package com.alibaba.security.realidentity.f;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.realidentity.http.RpcInvoker;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a {
    private static final String b = "VideoRecorderUpload";
    public final Context a;

    public a(Context context) {
        this.a = context;
    }

    private void a(String str, String str2, String str3, boolean z, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.alibaba.security.realidentity.jsbridge.a.d, str2);
        hashMap.put("eventCode", str4);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timestamp", (Object) Long.valueOf(System.currentTimeMillis()));
        jSONObject.put("type", (Object) str3);
        jSONObject.put("url", (Object) str);
        jSONObject.put("conf", (Object) str5);
        hashMap.put("eventData", jSONObject.toJSONString());
        RpcInvoker.callMtopAsync(this.a, z ? com.alibaba.security.realidentity.a.b : com.alibaba.security.realidentity.a.a, "1.0", true, hashMap);
    }
}
