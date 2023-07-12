package com.youku.asyncview.utils;

import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class CallbackUtil {
    public static boolean isRunOnUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
