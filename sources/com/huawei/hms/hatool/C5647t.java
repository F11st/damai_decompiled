package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.t */
/* loaded from: classes10.dex */
public class C5647t {
    public List<C5642q> a;
    public String b;
    public String c;
    public String d;

    public C5647t(List<C5642q> list, String str, String str2, String str3) {
        this.a = list;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public void a() {
        if (!"_default_config_tag".equals(this.c)) {
            a(this.a, this.c, this.b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (C5642q c5642q : this.a) {
            String c = c5642q.c();
            if (TextUtils.isEmpty(c) || "oper".equals(c)) {
                arrayList4.add(c5642q);
            } else if ("maint".equals(c)) {
                arrayList.add(c5642q);
            } else if ("preins".equals(c)) {
                arrayList2.add(c5642q);
            } else if ("diffprivacy".equals(c)) {
                arrayList3.add(c5642q);
            }
        }
        a(arrayList4, "oper", "_default_config_tag");
        a(arrayList, "maint", "_default_config_tag");
        a(arrayList2, "preins", "_default_config_tag");
        a(arrayList3, "diffprivacy", "_default_config_tag");
    }

    public final void a(List<C5642q> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i = 0; i < size; i++) {
            int i2 = i * 500;
            List<C5642q> subList = list.subList(i2, Math.min(list.size(), i2 + 500));
            String replace = UUID.randomUUID().toString().replace("-", "");
            long currentTimeMillis = System.currentTimeMillis();
            long b = AbstractC5609c.b(str2, str) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (C5642q c5642q : subList) {
                if (!C5643q0.a(c5642q.b(), currentTimeMillis, b)) {
                    arrayList.add(c5642q);
                }
            }
            if (arrayList.size() > 0) {
                new C5648u(str2, str, this.d, arrayList, replace).a();
            } else {
                C5653y.e("hmsSdk", "No data to report handler");
            }
        }
    }
}
