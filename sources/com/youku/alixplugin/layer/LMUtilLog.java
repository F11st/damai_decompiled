package com.youku.alixplugin.layer;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LMUtilLog {
    public static boolean needDebugLog = true;
    public static boolean needLog = true;

    public static void debugLog(Class<?> cls, String str) {
        if (needDebugLog) {
            Log.i("com.alibaba.layermanager: " + cls.getSimpleName(), str + "");
        }
    }

    public static void log(Class<?> cls, String str) {
        if (needLog) {
            Log.i("com.alibaba.layermanager: " + cls.getSimpleName(), str + "");
        }
    }
}
