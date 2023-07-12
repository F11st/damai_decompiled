package com.youku.tinywindow.utils;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TinyLogger {
    public static boolean DEBUG;

    public static void log(String str, String str2) {
        if (DEBUG) {
            Log.d(str, str2);
        }
    }
}
