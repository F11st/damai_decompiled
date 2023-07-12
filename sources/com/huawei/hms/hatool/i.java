package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class i {
    public static Map<String, m> b = new HashMap();
    public static i c;
    public l a = new l();

    public static i c() {
        if (c == null) {
            d();
        }
        return c;
    }

    public static synchronized void d() {
        synchronized (i.class) {
            if (c == null) {
                c = new i();
            }
        }
    }

    public m a(String str) {
        return b.get(str);
    }

    public Set<String> a() {
        return b.keySet();
    }

    public void a(String str, m mVar) {
        b.put(str, mVar);
    }

    public l b() {
        return this.a;
    }
}
