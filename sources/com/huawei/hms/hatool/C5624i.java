package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.i */
/* loaded from: classes10.dex */
public final class C5624i {
    public static Map<String, C5632m> b = new HashMap();
    public static C5624i c;
    public C5630l a = new C5630l();

    public static C5624i c() {
        if (c == null) {
            d();
        }
        return c;
    }

    public static synchronized void d() {
        synchronized (C5624i.class) {
            if (c == null) {
                c = new C5624i();
            }
        }
    }

    public C5632m a(String str) {
        return b.get(str);
    }

    public Set<String> a() {
        return b.keySet();
    }

    public void a(String str, C5632m c5632m) {
        b.put(str, c5632m);
    }

    public C5630l b() {
        return this.a;
    }
}
