package com.huawei.hms.hatool;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.a */
/* loaded from: classes10.dex */
public abstract class AbstractC5604a {
    public static String a(String str, String str2) {
        C5626j c = c(str, str2);
        return c != null ? c.a() : "";
    }

    public static boolean b(String str, String str2) {
        C5626j c = c(str, str2);
        return c != null && c.e();
    }

    public static C5626j c(String str, String str2) {
        C5628k a;
        C5632m a2 = C5624i.c().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return null;
        }
        return a.j();
    }

    public static String d(String str, String str2) {
        C5626j c = c(str, str2);
        return c != null ? c.b() : "";
    }

    public static boolean e(String str, String str2) {
        C5626j c = c(str, str2);
        return c != null && c.f();
    }

    public static boolean f(String str, String str2) {
        C5628k a;
        C5632m a2 = C5624i.c().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return false;
        }
        return a.c();
    }

    public static String g(String str, String str2) {
        C5626j c = c(str, str2);
        return c != null ? c.d() : "";
    }

    public static boolean h(String str, String str2) {
        C5626j c = c(str, str2);
        return c != null && c.g();
    }

    public static boolean i(String str, String str2) {
        C5628k a;
        C5632m a2 = C5624i.c().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return false;
        }
        return a.e();
    }

    public static String j(String str, String str2) {
        C5626j c = c(str, str2);
        return c != null ? c.c() : "";
    }

    public static boolean k(String str, String str2) {
        C5626j c = c(str, str2);
        return c != null && c.h();
    }
}
