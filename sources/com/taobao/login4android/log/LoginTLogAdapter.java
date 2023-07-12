package com.taobao.login4android.log;

import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginTLogAdapter {
    private static final String TAG_PREFIX = "LoginSDK_";
    private static boolean isTlogValid = true;

    public static void d(String str, String str2) {
        if (isTlogValid) {
            AdapterForTLog.logd(TAG_PREFIX + str, str2);
            return;
        }
        Log.d(TAG_PREFIX + str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (isTlogValid) {
            AdapterForTLog.loge(TAG_PREFIX + str, str2, th);
            return;
        }
        Log.e(TAG_PREFIX + str, str2, th);
    }

    public static void i(String str, String str2) {
        if (isTlogValid) {
            AdapterForTLog.logi(TAG_PREFIX + str, str2);
            return;
        }
        Log.i(TAG_PREFIX + str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        if (isTlogValid) {
            AdapterForTLog.logw(TAG_PREFIX + str, str2, th);
            return;
        }
        Log.w(TAG_PREFIX + str, str2, th);
    }

    public static void e(String str, String str2) {
        if (isTlogValid) {
            AdapterForTLog.loge(TAG_PREFIX + str, str2);
            return;
        }
        Log.e(TAG_PREFIX + str, str2);
    }

    public static void w(String str, String str2) {
        if (isTlogValid) {
            AdapterForTLog.logw(TAG_PREFIX + str, str2);
            return;
        }
        Log.w(TAG_PREFIX + str, str2);
    }

    public static void e(String str, Throwable th) {
        e(str, "", th);
    }

    public static void w(String str, Throwable th) {
        w(str, "", th);
    }
}
