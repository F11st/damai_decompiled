package com.meizu.cloud.pushsdk.d.f;

import com.meizu.cloud.pushinternal.DebugLogger;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.f.c */
/* loaded from: classes10.dex */
public class C6030c {
    private static int a;

    private static String a() {
        return Thread.currentThread().getName();
    }

    private static String a(String str) {
        return "PushTracker->" + str;
    }

    private static String a(String str, Object... objArr) {
        return a() + "|" + String.format(str, objArr);
    }

    public static void a(EnumC6029b enumC6029b) {
        a = enumC6029b.a();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (a >= EnumC6029b.ERROR.a()) {
            DebugLogger.e(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a >= EnumC6029b.DEBUG.a()) {
            DebugLogger.d(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (a >= EnumC6029b.VERBOSE.a()) {
            DebugLogger.i(a(str), a(str2, objArr));
        }
    }
}
