package com.uc.crashsdk.a;

import android.util.Log;
import com.uc.crashsdk.JNIBridge;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a {
    public static void a(String str) {
        if (com.uc.crashsdk.g.M()) {
            Log.d("crashsdk", str);
        }
    }

    public static void b(String str) {
        if (com.uc.crashsdk.g.M()) {
            Log.w("crashsdk", str);
        }
    }

    public static void c(String str, String str2) {
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeLog(5, str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeLog(6, str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (com.uc.crashsdk.g.M()) {
            Log.i(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeLog(4, str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (com.uc.crashsdk.g.M()) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        }
    }
}
