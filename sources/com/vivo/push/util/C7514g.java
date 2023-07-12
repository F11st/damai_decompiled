package com.vivo.push.util;

import android.os.Looper;
import android.util.Log;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.g */
/* loaded from: classes11.dex */
public final class C7514g {
    public static void a(String str) {
        if (C7523p.a() && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("DebugUtil", "Operation: " + str + " in main thread!", new Throwable());
        }
    }
}
