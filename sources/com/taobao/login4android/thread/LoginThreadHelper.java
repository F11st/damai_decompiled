package com.taobao.login4android.thread;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.utils.ReflectionHelper;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginThreadHelper {
    public static final String TAG = "login.LoginThreadHelper";
    private static Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    public static String getCurProcessName(Context context) {
        try {
            Class<?> cls = Class.forName("com.taobao.tao.TaobaoApplication");
            String str = (String) ReflectionHelper.invokeMethod(cls, cls.getDeclaredMethod("getProcessName", Context.class), context);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        } catch (Throwable unused) {
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "ProcessNameNotFound";
            }
            return "ProcessNameNotFound";
        } catch (Exception e) {
            e.printStackTrace();
            return "GetCurProcessException";
        }
    }

    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void runOnUIThread(Runnable runnable) {
        try {
            if (!isMainThread()) {
                mMainThreadHandler.post(runnable);
            } else {
                runnable.run();
            }
        } catch (Exception e) {
            LoginTLogAdapter.w(TAG, "runOnUIThread failed", e);
            e.printStackTrace();
        }
    }
}
