package com.taobao.android.launcher.statistics.trace;

import android.os.Build;
import android.os.Trace;
import com.taobao.android.launcher.common.Switches;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DAGTraceX {
    private static final boolean sTraceOpen = Switches.isSwitchOn(".dag_systrace_x_open");

    public static void beginSection(String str) {
        if (!sTraceOpen || Build.VERSION.SDK_INT < 18) {
            return;
        }
        Trace.beginSection(str);
    }

    public static void end() {
        if (!sTraceOpen || Build.VERSION.SDK_INT < 18) {
            return;
        }
        Trace.endSection();
    }
}
