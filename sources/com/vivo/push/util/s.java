package com.vivo.push.util;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class s {
    public static int a(com.vivo.push.b.c cVar) {
        w b = w.b();
        int b2 = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int a = b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT");
        long b3 = currentTimeMillis - b.b("com.vivo.push_preferences.operate." + b2 + "START_TIME", 0L);
        if (b3 <= 86400000 && b3 >= 0) {
            if (a >= cVar.f()) {
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
