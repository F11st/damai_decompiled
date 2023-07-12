package com.alibaba.security.common.c;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a {
    public static boolean a = true;
    private static String b = "RPVerify";

    private static void a(String str) {
        b = str;
    }

    public static void b() {
    }

    public static void b(String str, String str2) {
    }

    public static void c(String str, String str2) {
    }

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
    }

    public static void f(String str, String str2) {
    }

    private static void a(boolean z) {
        a = z;
    }

    public static boolean a() {
        return a;
    }

    public static void a(String str, String str2) {
        if (a && str2.length() > 4000) {
            int i = 0;
            while (i < str2.length()) {
                int i2 = i + 4000;
                if (i2 < str2.length()) {
                    str2.substring(i, i2);
                } else {
                    str2.substring(i, str2.length());
                }
                i = i2;
            }
        }
    }

    private static void a(String str, String str2, Object... objArr) {
        if (a) {
            String.format(str2, objArr);
        }
    }
}
