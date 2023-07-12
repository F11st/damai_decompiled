package com.youku.playerservice.axp.utils;

import android.os.Build;
import android.os.Trace;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SysTraceUtil {
    public static boolean traceSwitch;

    public static void EndSection(String str) {
        if (traceSwitch) {
            Logger.e("SysTimeTrace", "end---" + str);
            if (Build.VERSION.SDK_INT >= 18) {
                Trace.endSection();
            }
        }
    }

    public static void betinSection(String str) {
        if (traceSwitch) {
            Logger.e("SysTimeTrace", "start---" + str);
            if (Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("section");
            }
        }
    }
}
