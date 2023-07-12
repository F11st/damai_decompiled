package com.huawei.hms.hatool;

import com.alimm.xadsdk.request.builder.IRequestConst;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e1 extends n {
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g;

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.a);
        jSONObject.put(IRequestConst.OAID, this.g);
        jSONObject.put("uuid", this.f);
        jSONObject.put("upid", this.e);
        jSONObject.put("imei", this.b);
        jSONObject.put("sn", this.c);
        jSONObject.put("udid", this.d);
        return jSONObject;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.f = str;
    }
}
