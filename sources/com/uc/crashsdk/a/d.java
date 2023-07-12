package com.uc.crashsdk.a;

import com.alibaba.motu.crashreporter2.CrashReporter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d {
    static final /* synthetic */ boolean a = true;
    private static boolean b = true;
    private static boolean d = false;
    private static String e = "hsdk";
    private static String f = "alid ";
    private static String g;
    private static String i;
    private static final Object c = new Object();
    private static final Object h = new Object();

    public static void a() {
        f.a(0, new e(500), com.uc.crashsdk.b.H() ? 900000L : 90000L);
    }

    public static String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    public static void c() {
        synchronized (h) {
            i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] d() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean e() {
        if (!com.uc.crashsdk.e.F() && !com.uc.crashsdk.b.L()) {
            a(true);
            return b;
        }
        return true;
    }

    private static String f() {
        String str = i;
        if (g.a(str)) {
            synchronized (h) {
                String str2 = com.uc.crashsdk.g.P() ? "https://wpk-auth.ucweb.com" : "https://woodpecker.uc.cn";
                str = g.a(com.uc.crashsdk.b.j(), str2 + "/api/crashsdk/validate", true);
                i = str;
            }
        }
        return str;
    }

    private static String g() {
        byte[] bArr;
        String f2;
        byte[] a2;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.a);
        a(sb, "process", com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", CrashReporter._VERSION);
        a(sb, "ctag", "release");
        a(sb, "inter", com.uc.crashsdk.g.P() ? "true" : "false");
        a(sb, "os", "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        c.a(bArr3, 0, h.j());
        c.a(bArr3, 4, c.a());
        c.a(bArr3, 8, d());
        c.a(bArr3, 12, com.uc.crashsdk.a.f());
        try {
            bArr = c.a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null || (f2 = f()) == null || (a2 = c.a(f2, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = c.a(a2, bArr3, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (!a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (c) {
            g = null;
            a(!com.uc.crashsdk.b.F());
            if (g.b(g)) {
                h.a(g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(boolean r12) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }
}
