package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.r */
/* loaded from: classes10.dex */
public class C5644r implements InterfaceC5646s {
    public List<C5642q> a;
    public AbstractC5636o b;
    public AbstractC5640p c;
    public InterfaceC5646s d;
    public String e = "";
    public String f;

    public C5644r(String str) {
        this.f = str;
    }

    @Override // com.huawei.hms.hatool.InterfaceC5646s
    public JSONObject a() {
        String str;
        List<C5642q> list = this.a;
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
            for (C5642q c5642q : this.a) {
                JSONObject a2 = c5642q.a();
                if (a2 != null) {
                    jSONArray.put(a2);
                } else {
                    C5653y.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String a3 = C5611d.a(t0.a(jSONObject2.toString().getBytes("UTF-8")), this.f);
                if (TextUtils.isEmpty(a3)) {
                    C5653y.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a3);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        C5653y.e("hmsSdk", str);
        return null;
    }

    public void a(e1 e1Var) {
        this.d = e1Var;
    }

    public void a(AbstractC5636o abstractC5636o) {
        this.b = abstractC5636o;
    }

    public void a(AbstractC5640p abstractC5640p) {
        this.c = abstractC5640p;
    }

    public void a(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public void a(List<C5642q> list) {
        this.a = list;
    }
}
