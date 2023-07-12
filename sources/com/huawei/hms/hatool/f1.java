package com.huawei.hms.hatool;

import com.alimm.xadsdk.request.builder.IRequestConst;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class f1 extends AbstractC5636o {
    public String g = "";

    @Override // com.huawei.hms.hatool.InterfaceC5646s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IRequestConst.PROTOCOL_VERSION, "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.d);
        jSONObject.put("appid", this.a);
        jSONObject.put("hmac", this.g);
        jSONObject.put("chifer", this.f);
        jSONObject.put("timestamp", this.b);
        jSONObject.put("servicetag", this.c);
        jSONObject.put("requestid", this.e);
        return jSONObject;
    }

    public void g(String str) {
        this.g = str;
    }
}
