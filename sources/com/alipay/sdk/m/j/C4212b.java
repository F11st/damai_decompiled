package com.alipay.sdk.m.j;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.j.b */
/* loaded from: classes12.dex */
public class C4212b {
    public static boolean a;
    public static String b;

    public static void a(String str) {
        b = str;
    }

    public static String b() {
        EnumC4213c b2 = EnumC4213c.b(EnumC4213c.DOUBLE_REQUEST.b());
        return a(b2.b(), b2.a(), "");
    }

    public static boolean c() {
        return a;
    }

    public static String d() {
        return b;
    }

    public static String e() {
        EnumC4213c b2 = EnumC4213c.b(EnumC4213c.PARAMS_ERROR.b());
        return a(b2.b(), b2.a(), "");
    }

    public static void a(boolean z) {
        a = z;
    }

    public static String a() {
        EnumC4213c b2 = EnumC4213c.b(EnumC4213c.CANCELED.b());
        return a(b2.b(), b2.a(), "");
    }

    public static String a(int i, String str, String str2) {
        return "resultStatus={" + i + "};memo={" + str + "};result={" + str2 + "}";
    }
}
