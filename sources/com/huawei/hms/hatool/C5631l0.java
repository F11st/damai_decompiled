package com.huawei.hms.hatool;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.l0 */
/* loaded from: classes10.dex */
public class C5631l0 implements InterfaceRunnableC5635n0 {
    public String a;
    public String b;
    public String c;
    public List<C5642q> d;

    public C5631l0(List<C5642q> list, String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    public final void a() {
        C5621g0.a(AbstractC5607b.i(), "backup_event", u0.a(this.a, this.c, this.b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<C5642q> list = this.d;
        if (list == null || list.size() == 0) {
            C5653y.d("hmsSdk", "failed events is empty");
            return;
        }
        if (C5643q0.a(AbstractC5607b.i(), "cached_v2_1", AbstractC5607b.k() * 1048576)) {
            C5653y.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.b);
            return;
        }
        String a = u0.a(this.a, this.c);
        List<C5642q> list2 = C5650w.b(AbstractC5607b.i(), "cached_v2_1", a).get(a);
        if (list2 != null && list2.size() != 0) {
            this.d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        for (C5642q c5642q : this.d) {
            try {
                jSONArray.put(c5642q.d());
            } catch (JSONException unused) {
                C5653y.e("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > AbstractC5607b.h() * 1048576) {
            C5653y.e("hmsSdk", "this failed data is too long,can not writing it");
            this.d = null;
            return;
        }
        C5653y.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.b);
        C5621g0.b(AbstractC5607b.i(), "cached_v2_1", a, jSONArray2);
        a();
    }
}
