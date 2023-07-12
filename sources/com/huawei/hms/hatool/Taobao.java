package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.r  reason: case insensitive filesystem */
/* loaded from: classes10.dex */
public class Taobao implements s {
    public List<q> a;
    public o b;
    public p c;
    public s d;
    public String e = "";
    public String f;

    public Taobao(String str) {
        this.f = str;
    }

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        String str;
        List<q> list = this.a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.b == null || this.c == null || this.d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a = this.d.a();
            a.put("properties", this.c.a());
            try {
                a.put("events_global_properties", new JSONObject(this.e));
            } catch (JSONException unused) {
                a.put("events_global_properties", this.e);
            }
            jSONObject2.put("events_common", a);
            JSONArray jSONArray = new JSONArray();
            for (q qVar : this.a) {
                JSONObject a2 = qVar.a();
                if (a2 != null) {
                    jSONArray.put(a2);
                } else {
                    y.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String a3 = d.a(t0.a(jSONObject2.toString().getBytes("UTF-8")), this.f);
                if (TextUtils.isEmpty(a3)) {
                    y.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a3);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        y.e("hmsSdk", str);
        return null;
    }

    public void a(e1 e1Var) {
        this.d = e1Var;
    }

    public void a(o oVar) {
        this.b = oVar;
    }

    public void a(p pVar) {
        this.c = pVar;
    }

    public void a(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public void a(List<q> list) {
        this.a = list;
    }
}
