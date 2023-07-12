package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.e0 */
/* loaded from: classes10.dex */
public final class C5615e0 {
    public static C5615e0 b;
    public volatile Map<String, C5618f0> a = new HashMap();

    public static C5615e0 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static synchronized void b() {
        synchronized (C5615e0.class) {
            if (b == null) {
                b = new C5615e0();
            }
        }
    }

    public final C5618f0 a(String str) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, new C5618f0());
        }
        return this.a.get(str);
    }

    public C5618f0 a(String str, long j) {
        C5618f0 a = a(str);
        a.a(j);
        return a;
    }
}
