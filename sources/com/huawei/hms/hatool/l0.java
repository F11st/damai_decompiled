package com.huawei.hms.hatool;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class l0 implements n0 {
    public String a;
    public String b;
    public String c;
    public List<q> d;

    public l0(List<q> list, String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    public final void a() {
        g0.a(b.i(), "backup_event", u0.a(this.a, this.c, this.b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<q> list = this.d;
        if (list == null || list.size() == 0) {
            y.d("hmsSdk", "failed events is empty");
            return;
        }
        if (q0.a(b.i(), "cached_v2_1", b.k() * 1048576)) {
            y.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.b);
            return;
        }
        String a = u0.a(this.a, this.c);
        List<q> list2 = w.b(b.i(), "cached_v2_1", a).get(a);
        if (list2 != null && list2.size() != 0) {
            this.d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        for (q qVar : this.d) {
            try {
                jSONArray.put(qVar.d());
            } catch (JSONException unused) {
                y.e("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > b.h() * 1048576) {
            y.e("hmsSdk", "this failed data is too long,can not writing it");
            this.d = null;
            return;
        }
        y.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.b);
        g0.b(b.i(), "cached_v2_1", a, jSONArray2);
        a();
    }
}
