package com.taobao.orange.util;

import android.app.ActivityManager;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.taobao.orange.GlobalOrange;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AndroidUtil {
    private static final String TAG = "AndroidUtil";
    private static final String TAOBAO_CHANNEL_PROCESS_NAME = "com.taobao.taobao:channel";
    private static final String TAOBAO_PACKAGE_NAME = "com.taobao.taobao";
    private static final String TMALL_PACKAGE_NAME = "com.tmall.wireless";
    public static String currentProcess = "";
    private static String mainProcess = "";

    private static String getProcessName(Context context, int i) {
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            try {
                if (runningAppProcessInfo.pid == i) {
                    str = runningAppProcessInfo.processName;
                }
                if (mainProcess.equals(runningAppProcessInfo.processName)) {
                    GlobalOrange.isMainProcessAlive = true;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static boolean isMainProcess(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(mainProcess)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
                mainProcess = str;
                OLog.d(TAG, "isMainProcess", "mainProcessName", str);
            }
            if (TextUtils.isEmpty(currentProcess)) {
                String processName = getProcessName(context, Process.myPid());
                currentProcess = processName;
                OLog.d(TAG, "isMainProcess", "currentProcessName", processName);
            }
            if (TextUtils.isEmpty(mainProcess) || TextUtils.isEmpty(currentProcess)) {
                return true;
            }
            return mainProcess.equalsIgnoreCase(currentProcess);
        } catch (Throwable th) {
            OLog.e(TAG, "isMainProcess", th, new Object[0]);
            return true;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isAvailable();
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean isTaobaoChannelProcess(Context context) {
        try {
            if (TextUtils.isEmpty(mainProcess)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
                mainProcess = str;
                OLog.d(TAG, "isMainProcess", "mainProcessName", str);
            }
            if (TextUtils.isEmpty(currentProcess)) {
                currentProcess = getProcessName(context, Process.myPid());
            }
        } catch (Throwable th) {
            OLog.e(TAG, "isTaobaoChannelProcess", th.toString());
        }
        return "com.taobao.taobao:channel".equals(currentProcess);
    }

    public static boolean isTaobaoPackage(Context context) {
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        return "com.taobao.taobao".equals(packageName) || "com.tmall.wireless".equals(packageName);
    }

    public static void setThreadPriority() {
        try {
            Process.setThreadPriority(2);
        } catch (Throwable th) {
            OLog.e(TAG, "setThreadPriority", th, new Object[0]);
        }
    }
}
