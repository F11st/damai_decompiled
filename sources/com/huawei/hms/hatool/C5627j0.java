package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.j0 */
/* loaded from: classes10.dex */
public class C5627j0 implements InterfaceRunnableC5635n0 {
    public Context a = AbstractC5607b.i();
    public String b;
    public JSONObject c;
    public String d;
    public String e;
    public String f;
    public String g;
    public Boolean h;

    public C5627j0(String str, JSONObject jSONObject, String str2, String str3, long j) {
        this.b = str;
        this.c = jSONObject;
        this.d = str2;
        this.e = str3;
        this.f = String.valueOf(j);
        if (AbstractC5604a.i(str2, "oper")) {
            C5618f0 a = C5615e0.a().a(str2, j);
            this.g = a.a();
            this.h = Boolean.valueOf(a.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        C5653y.c("hmsSdk", "Begin to run EventRecordTask...");
        int h = AbstractC5607b.h();
        int k = AbstractC5609c.k(this.d, this.e);
        if (C5643q0.a(this.a, "stat_v2_1", h * 1048576)) {
            C5653y.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            C5623h0.a().a("", "alltype");
            return;
        }
        C5642q c5642q = new C5642q();
        c5642q.b(this.b);
        c5642q.a(this.c.toString());
        c5642q.d(this.e);
        c5642q.c(this.f);
        c5642q.f(this.g);
        Boolean bool = this.h;
        c5642q.e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject d = c5642q.d();
            String a = u0.a(this.d, this.e);
            String a2 = C5621g0.a(this.a, "stat_v2_1", a, "");
            try {
                jSONArray = !TextUtils.isEmpty(a2) ? new JSONArray(a2) : new JSONArray();
            } catch (JSONException unused) {
                C5653y.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(d);
            C5621g0.b(this.a, "stat_v2_1", a, jSONArray.toString());
            if (jSONArray.toString().length() > k * 1024) {
                C5623h0.a().a(this.d, this.e);
            }
        } catch (JSONException unused2) {
            C5653y.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
