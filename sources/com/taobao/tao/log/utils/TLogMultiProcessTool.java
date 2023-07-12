package com.taobao.tao.log.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogMultiProcessTool {
    public static final String ACTION_CHANGE_LOG_LEVEL = "com.taobao.tao.log.change.loglevel";
    public static final String ACTION_CHANGE_MODULE_LEVEL = "com.taobao.tao.log.change.modulelevel";
    public static final String ACTION_FLUSH = "com.taobao.tao.log.flush";
    public static final String PARAM_LOG_LEVEL = "tlog_log_level";
    public static final String PARAM_MODULE_LEVEL = "tlog_module_level";
    public static final String PARAM_PID = "tlog_pid";
    private static final String TAG = "TLogProcessTool";
    private static TLogMultiProcessReceiver tlogReceiver = new TLogMultiProcessReceiver();
    private static AtomicBoolean isRegister = new AtomicBoolean(false);

    private static String getCurProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean isEnable(Context context) {
        boolean z;
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            z = true;
            if (defaultSharedPreferences.contains(TLogConstant.TLOG_MULTI_PROCESS_NOTIFY)) {
                z = defaultSharedPreferences.getBoolean(TLogConstant.TLOG_MULTI_PROCESS_NOTIFY, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        if (!z) {
            Log.d(TAG, "TLog MultiProcess Notify is disable");
        }
        return z;
    }

    public static boolean isMainProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return !TextUtils.isEmpty(curProcessName) && curProcessName.equals(context.getPackageName());
    }

    public static void notifyProcessChangeLogLevel(LogLevel logLevel) {
        Log.d(TAG, "TLog MultiProcess Notify ChangeLogLevel");
        Intent intent = new Intent(ACTION_CHANGE_LOG_LEVEL);
        intent.putExtra(PARAM_LOG_LEVEL, logLevel);
        sendNotify(intent);
    }

    public static void notifyProcessChangeModuleLevel(String str) {
        Log.d(TAG, "TLog MultiProcess Notify ChangeModuleLevel");
        Intent intent = new Intent(ACTION_CHANGE_MODULE_LEVEL);
        intent.putExtra(PARAM_MODULE_LEVEL, str);
        sendNotify(intent);
    }

    public static void notifyProcessFlushLog() {
        Log.d(TAG, "TLog MultiProcess Notify FlushLog");
        sendNotify(new Intent(ACTION_FLUSH));
    }

    public static void registerMultiProcessReceiver(Context context) {
        if (!isEnable(context) || isRegister.get()) {
            return;
        }
        Log.d(TAG, "Register Multi Process Receiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_FLUSH);
        intentFilter.addAction(ACTION_CHANGE_LOG_LEVEL);
        intentFilter.addAction(ACTION_CHANGE_MODULE_LEVEL);
        context.registerReceiver(tlogReceiver, intentFilter);
        isRegister.set(true);
    }

    private static void sendNotify(Intent intent) {
        Context context = TLogInitializer.getInstance().getContext();
        if (context == null || intent == null || !isEnable(context)) {
            return;
        }
        intent.putExtra(PARAM_PID, Process.myPid());
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void unregisterMultiProcessReceiver(Context context) {
        if (isRegister.get()) {
            context.unregisterReceiver(tlogReceiver);
            isRegister.set(false);
        }
    }
}
