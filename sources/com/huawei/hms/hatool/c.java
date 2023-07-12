package com.huawei.hms.hatool;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class c {
    public static void a(String str, String str2, long j) {
        k h = h(str, str2);
        if (h != null) {
            h.a(j);
        }
    }

    public static boolean a(String str, String str2) {
        k h = h(str, str2);
        if (h != null) {
            return h.a();
        }
        return true;
    }

    public static int b(String str, String str2) {
        k h = h(str, str2);
        if (h != null) {
            return h.d();
        }
        return 7;
    }

    public static boolean c(String str, String str2) {
        k h = h(str, str2);
        if (h != null) {
            return h.g();
        }
        return true;
    }

    public static String d(String str, String str2) {
        k h = h(str, str2);
        return h != null ? h.f() : "";
    }

    public static boolean e(String str, String str2) {
        k h = h(str, str2);
        if (h != null) {
            return h.i();
        }
        return false;
    }

    public static String f(String str, String str2) {
        k h = h(str, str2);
        return h != null ? h.h() : "";
    }

    public static String g(String str, String str2) {
        k h = h(str, str2);
        return h != null ? h.n() : "";
    }

    public static k h(String str, String str2) {
        m a = i.c().a(str);
        if (a != null) {
            if ("alltype".equals(str2)) {
                k a2 = a.a("oper");
                return a2 == null ? a.a("maint") : a2;
            }
            return a.a(str2);
        }
        return null;
    }

    public static Map<String, String> i(String str, String str2) {
        k h = h(str, str2);
        if (h != null) {
            return h.k();
        }
        return null;
    }

    public static long j(String str, String str2) {
        k h = h(str, str2);
        if (h != null) {
            return h.l();
        }
        return 0L;
    }

    public static int k(String str, String str2) {
        k h = h(str, str2);
        if (h != null) {
            return h.b();
        }
        return 10;
    }

    public static String l(String str, String str2) {
        k h = h(str, str2);
        return h != null ? h.o() : "";
    }

    public static String m(String str, String str2) {
        k h = h(str, str2);
        return h != null ? h.q() : "";
    }

    public static String n(String str, String str2) {
        k h = h(str, str2);
        return h != null ? h.m() : "";
    }

    public static String o(String str, String str2) {
        k h = h(str, str2);
        return h != null ? h.p() : "";
    }
}
