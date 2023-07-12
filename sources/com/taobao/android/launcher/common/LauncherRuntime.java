package com.taobao.android.launcher.common;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.taobao.android.job.core.task.Task;
import com.taobao.android.launcher.config.Configuration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LauncherRuntime {
    public static final int LAUNCH_TYPE_LINK = 1;
    public static final int LAUNCH_TYPE_LINK_H5 = 2;
    public static final int LAUNCH_TYPE_NORMAL = 0;
    public static final int LAUNCH_TYPE_OTHER = 3;
    public static final String PROCESS_CHANNEL = "cn.damai:channel";
    public static final String PROCESS_MAIN = "cn.damai";
    public static long mAC = 0;
    public static long mAHead = 0;
    public static long mATail = 0;
    public static long mFront = 0;
    public static long mLaunch = 0;
    public static String sAppVersion = null;
    public static Application sApplication = null;
    public static boolean sCold = true;
    public static Configuration sConfiguration;
    public static Context sContext;
    public static boolean sDebuggable;
    public static int sLaunchType;
    public static final LoginState sLoginState = new LoginState();
    private static Handler sMainHandler;
    public static String sPackageName;
    public static String sPackageTag;
    public static String sProcessName;
    public static OnDemandReceiver sReceiver;
    public static long sStartTime;
    public static String sTTID;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface LaunchType {
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface LauncherProcess {
    }

    public static boolean defferTask(Task<String, Void> task) {
        Configuration configuration = sConfiguration;
        if (configuration != null) {
            return configuration.deffer.offer(task, 1);
        }
        return false;
    }

    public static void init(Application application, String str, String str2, long j) {
        sApplication = application;
        sContext = application;
        sPackageName = str;
        sProcessName = str2;
        sStartTime = j;
        sMainHandler = new Handler(Looper.getMainLooper());
        System.setProperty("processStartTime", "" + SystemClock.uptimeMillis());
    }

    public static boolean isStartByLauncher(Intent intent) {
        return (intent == null || TextUtils.isEmpty(intent.getAction()) || !intent.getAction().equals("android.intent.action.MAIN") || intent.getCategories() == null || !intent.getCategories().contains("android.intent.category.LAUNCHER")) ? false : true;
    }

    public static void postUIDelayedTask(Runnable runnable, long j) {
        sMainHandler.postDelayed(runnable, j);
    }

    public static void postUITask(Runnable runnable) {
        sMainHandler.post(runnable);
    }

    public static void sendBroadcast(Intent intent) {
        sContext.sendBroadcast(intent);
    }
}
