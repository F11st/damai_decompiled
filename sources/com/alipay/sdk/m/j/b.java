package com.alipay.sdk.m.j;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    public static boolean a;
    public static String b;

    public static void a(String str) {
        b = str;
    }

    public static String b() {
        c b2 = c.b(c.DOUBLE_REQUEST.b());
        return a(b2.b(), b2.a(), "");
    }

    public static boolean c() {
        return a;
    }

    public static String d() {
        return b;
    }

    public static String e() {
        c b2 = c.b(c.PARAMS_ERROR.b());
        return a(b2.b(), b2.a(), "");
    }

    public static void a(boolean z) {
        a = z;
    }

    public static String a() {
        c b2 = c.b(c.CANCELED.b());
        return a(b2.b(), b2.a(), "");
    }

    public static String a(int i, String str, String str2) {
        return "resultStatus={" + i + "};memo={" + str + "};result={" + str2 + "}";
    }
}
