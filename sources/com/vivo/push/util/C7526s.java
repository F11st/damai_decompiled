package com.vivo.push.util;

import com.vivo.push.b.C7415c;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.s */
/* loaded from: classes11.dex */
public final class C7526s {
    public static int a(C7415c c7415c) {
        C7530w b = C7530w.b();
        int b2 = c7415c.b();
        long currentTimeMillis = System.currentTimeMillis();
        int a = b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT");
        long b3 = currentTimeMillis - b.b("com.vivo.push_preferences.operate." + b2 + "START_TIME", 0L);
        if (b3 <= 86400000 && b3 >= 0) {
            if (a >= c7415c.f()) {
                return 1001;
            }
            b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT", a + 1);
            return 0;
        }
        b.a("com.vivo.push_preferences.operate." + b2 + "START_TIME", System.currentTimeMillis());
        b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT", 1);
        return 0;
    }
}
