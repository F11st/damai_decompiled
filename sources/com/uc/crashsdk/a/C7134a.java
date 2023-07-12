package com.uc.crashsdk.a;

import android.util.Log;
import com.uc.crashsdk.C7143b;
import com.uc.crashsdk.C7152g;
import com.uc.crashsdk.JNIBridge;

/* compiled from: Taobao */
/* renamed from: com.uc.crashsdk.a.a */
/* loaded from: classes11.dex */
public final class C7134a {
    public static void a(String str) {
        if (C7152g.M()) {
            Log.d("crashsdk", str);
        }
    }

    public static void b(String str) {
        if (C7152g.M()) {
            Log.w("crashsdk", str);
        }
    }

    public static void c(String str, String str2) {
        if (C7143b.d) {
            JNIBridge.nativeLog(5, str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (C7143b.d) {
            JNIBridge.nativeLog(6, str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (C7152g.M()) {
            Log.i(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (C7143b.d) {
            JNIBridge.nativeLog(4, str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (C7152g.M()) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        }
    }
}
