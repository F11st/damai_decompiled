package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class q implements s {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.a);
        jSONObject.put("eventtime", this.d);
        jSONObject.put("event", this.b);
        jSONObject.put("event_session_name", this.e);
        jSONObject.put("first_session_event", this.f);
        if (TextUtils.isEmpty(this.c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.c));
        return jSONObject;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.b = jSONObject.optString("event");
        this.c = jSONObject.optString("properties");
        this.c = d.a(this.c, d0.f().a());
        this.a = jSONObject.optString("type");
        this.d = jSONObject.optString("eventtime");
        this.e = jSONObject.optString("event_session_name");
        this.f = jSONObject.optString("first_session_event");
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.a;
    }

    public void c(String str) {
        this.d = str;
    }

    public JSONObject d() {
        JSONObject a = a();
        a.put("properties", d.b(this.c, d0.f().a()));
        return a;
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.e = str;
    }
}
