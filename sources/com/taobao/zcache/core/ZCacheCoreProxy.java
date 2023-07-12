package com.taobao.zcache.core;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.RVLLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ZCacheCoreProxy {
    private static boolean _isMainProcess;
    private static IZCacheCore zcacheCore;

    public static IZCacheCore core() {
        return zcacheCore;
    }

    private static String getProcessName(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isMainProcess() {
        return _isMainProcess;
    }

    public static void setContext(Context context) {
        if (context == null || zcacheCore != null) {
            return;
        }
        String processName = getProcessName(context);
        String packageName = context.getPackageName();
        boolean equals = TextUtils.equals(processName, packageName);
        _isMainProcess = equals;
        if (!equals) {
            RVLLog.a(RVLLevel.Warn, "ZCache/Setup").f("setContext").e(101, "Current process name \"%s\" is not equal to packageName \"%s\"", processName, packageName).d();
        }
        zcacheCore = new ZCacheCoreWrapper(context);
    }
}
