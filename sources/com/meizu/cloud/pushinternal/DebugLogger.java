package com.meizu.cloud.pushinternal;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.C5939g;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DebugLogger {
    public static boolean debug;

    public static void d(String str, String str2) {
        C5939g.b().a(str, str2);
    }

    public static void e(String str, String str2) {
        C5939g.b().d(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        C5939g.b().a(str, str2, th);
    }

    public static void flush() {
        C5939g.b().a(false);
    }

    public static void i(String str, String str2) {
        C5939g.b().b(str, str2);
    }

    public static void init(Context context) {
        C5939g.b().a(context);
    }

    public static void init(Context context, String str) {
        C5939g.b().a(context, str);
    }

    public static boolean isDebuggable() {
        return C5939g.b().a();
    }

    public static void switchDebug(boolean z) {
        C5939g.b().b(z);
    }

    public static void w(String str, String str2) {
        C5939g.b().c(str, str2);
    }
}
