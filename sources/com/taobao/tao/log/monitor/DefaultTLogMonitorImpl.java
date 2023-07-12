package com.taobao.tao.log.monitor;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultTLogMonitorImpl implements TLogMonitor {
    private static String TAG = "TLOG_MONITOR";

    @Override // com.taobao.tao.log.monitor.TLogMonitor
    public void stageError(String str, String str2, String str3) {
        String str4 = TAG;
        Log.e(str4, str + ":" + str2 + ":" + str3);
    }

    @Override // com.taobao.tao.log.monitor.TLogMonitor
    public void stageInfo(String str, String str2, String str3) {
        String str4 = TAG;
        Log.w(str4, str + ":" + str2 + ":" + str3);
    }

    @Override // com.taobao.tao.log.monitor.TLogMonitor
    public void stageError(String str, String str2, Throwable th) {
        String str3 = TAG;
        Log.e(str3, str + ":" + str2, th);
    }
}
