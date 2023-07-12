package com.alipay.apmobilesecuritysdk.e;

import com.alipay.sdk.m.z.C4368a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.e.i */
/* loaded from: classes12.dex */
public final class C4113i {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static Map<String, String> f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (C4113i.class) {
            String str2 = "apdidTokenCache" + str;
            if (f.containsKey(str2)) {
                String str3 = f.get(str2);
                if (C4368a.b(str3)) {
                    return str3;
                }
            }
            return "";
        }
    }

    public static synchronized void a() {
        synchronized (C4113i.class) {
        }
    }

    public static synchronized void a(C4106b c4106b) {
        synchronized (C4113i.class) {
            if (c4106b != null) {
                a = c4106b.a;
                b = c4106b.b;
                c = c4106b.c;
            }
        }
    }

    public static synchronized void a(C4107c c4107c) {
        synchronized (C4113i.class) {
            if (c4107c != null) {
                a = c4107c.a;
                b = c4107c.b;
                d = c4107c.d;
                e = c4107c.e;
                c = c4107c.c;
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (C4113i.class) {
            String str3 = "apdidTokenCache" + str;
            if (f.containsKey(str3)) {
                f.remove(str3);
            }
            f.put(str3, str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
        if (r1 < 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean a(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.Class<com.alipay.apmobilesecuritysdk.e.i> r0 = com.alipay.apmobilesecuritysdk.e.C4113i.class
            monitor-enter(r0)
            long r1 = com.alipay.apmobilesecuritysdk.e.C4112h.a(r6)     // Catch: java.lang.Throwable -> Ld
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L10
        Ld:
            r1 = 86400000(0x5265c00, double:4.2687272E-316)
        L10:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L24
            long r6 = com.alipay.apmobilesecuritysdk.e.C4112h.h(r6, r7)     // Catch: java.lang.Throwable -> L24
            long r3 = r3 - r6
            long r6 = java.lang.Math.abs(r3)     // Catch: java.lang.Throwable -> L24
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 >= 0) goto L28
            r6 = 1
        L22:
            monitor-exit(r0)
            return r6
        L24:
            r6 = move-exception
            com.alipay.apmobilesecuritysdk.c.C4097a.a(r6)     // Catch: java.lang.Throwable -> L2a
        L28:
            r6 = 0
            goto L22
        L2a:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.e.C4113i.a(android.content.Context, java.lang.String):boolean");
    }

    public static synchronized String b() {
        String str;
        synchronized (C4113i.class) {
            str = a;
        }
        return str;
    }

    public static void b(String str) {
        a = str;
    }

    public static synchronized String c() {
        String str;
        synchronized (C4113i.class) {
            str = b;
        }
        return str;
    }

    public static void c(String str) {
        b = str;
    }

    public static synchronized String d() {
        String str;
        synchronized (C4113i.class) {
            str = d;
        }
        return str;
    }

    public static void d(String str) {
        c = str;
    }

    public static synchronized String e() {
        String str;
        synchronized (C4113i.class) {
            str = e;
        }
        return str;
    }

    public static void e(String str) {
        d = str;
    }

    public static synchronized String f() {
        String str;
        synchronized (C4113i.class) {
            str = c;
        }
        return str;
    }

    public static void f(String str) {
        e = str;
    }

    public static synchronized C4107c g() {
        C4107c c4107c;
        synchronized (C4113i.class) {
            c4107c = new C4107c(a, b, c, d, e);
        }
        return c4107c;
    }

    public static void h() {
        f.clear();
        a = "";
        b = "";
        d = "";
        e = "";
        c = "";
    }
}
