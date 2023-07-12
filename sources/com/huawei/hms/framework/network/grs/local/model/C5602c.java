package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.local.model.c */
/* loaded from: classes10.dex */
public class C5602c {
    private String a;
    private final Map<String, C5603d> b = new ConcurrentHashMap(16);
    private List<C5601b> c = new ArrayList(16);

    public C5603d a(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
            return null;
        }
        return this.b.get(str);
    }

    public List<C5601b> a() {
        return this.c;
    }

    public void a(String str, C5603d c5603d) {
        if (TextUtils.isEmpty(str) || c5603d == null) {
            return;
        }
        this.b.put(str, c5603d);
    }

    public void a(List<C5601b> list) {
        this.c = list;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
    }

    public void c(String str) {
        this.a = str;
    }
}
