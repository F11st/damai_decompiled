package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushinternal.DebugLogger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    private static boolean a = false;
    private static String b = "AndroidNetworking";

    public static void a() {
        a = true;
    }

    public static void a(String str) {
        if (a) {
            DebugLogger.d(b, str);
        }
    }

    public static void b(String str) {
        if (a) {
            DebugLogger.i(b, str);
        }
    }
}
