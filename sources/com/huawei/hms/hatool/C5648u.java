package com.huawei.hms.hatool;

import android.taobao.windvane.connect.HttpRequest;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.u */
/* loaded from: classes10.dex */
public class C5648u {
    public String a;
    public String b;
    public String c;
    public List<C5642q> d;
    public String e;

    public C5648u(String str, String str2, String str3, List<C5642q> list, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = str4;
    }

    public final String a(String str, String str2) {
        String str3;
        String f = AbstractC5609c.f(str, str2);
        if (TextUtils.isEmpty(f)) {
            C5653y.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else if (!"diffprivacy".equals(str2)) {
            return "";
        } else {
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", f);
    }

    public void a() {
        InterfaceRunnableC5635n0 c5631l0;
        C5637o0 c;
        String str;
        String a = a(this.a, this.b);
        if (!TextUtils.isEmpty(a) || "preins".equals(this.b)) {
            if (!"_hms_config_tag".equals(this.a) && !"_openness_config_tag".equals(this.a)) {
                b();
            }
            C5644r d = d();
            if (d != null) {
                byte[] a2 = a(d);
                if (a2.length == 0) {
                    str = "request body is empty";
                } else {
                    c5631l0 = new C5625i0(a2, a, this.a, this.b, this.e, this.d);
                    c = C5637o0.b();
                }
            } else {
                c5631l0 = new C5631l0(this.d, this.a, this.e, this.b);
                c = C5637o0.c();
            }
            c.a(c5631l0);
            return;
        }
        str = "collectUrl is empty";
        C5653y.e("hmsSdk", str);
    }

    public final byte[] a(C5644r c5644r) {
        String str;
        try {
            JSONObject a = c5644r.a();
            if (a == null) {
                C5653y.e("hmsSdk", "uploadEvents is null");
                return new byte[0];
            }
            return t0.a(a.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            C5653y.e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            C5653y.e("hmsSdk", str);
            return new byte[0];
        }
    }

    public final void b() {
        if (C5643q0.a(AbstractC5607b.i(), "backup_event", (int) HttpRequest.DEFAULT_MAX_LENGTH)) {
            C5653y.d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray c = c();
        String a = u0.a(this.a, this.b, this.e);
        C5653y.c("hmsSdk", "Update data cached into backup,spKey: " + a);
        C5621g0.b(AbstractC5607b.i(), "backup_event", a, c.toString());
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (C5642q c5642q : this.d) {
            try {
                jSONArray.put(c5642q.d());
            } catch (JSONException unused) {
                C5653y.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    public final C5644r d() {
        return d1.a(this.d, this.a, this.b, this.e, this.c);
    }
}
