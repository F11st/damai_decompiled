package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class e0 {
    public static e0 b;
    public volatile Map<String, f0> a = new HashMap();

    public static e0 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static synchronized void b() {
        synchronized (e0.class) {
            if (b == null) {
                b = new e0();
            }
        }
    }

    public final f0 a(String str) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, new f0());
        }
        return this.a.get(str);
    }

    public f0 a(String str, long j) {
        f0 a = a(str);
        a.a(j);
        return a;
    }
}
