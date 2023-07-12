package com.alimm.xadsdk.base.utils;

import android.text.TextUtils;
import android.util.Log;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LogUtils {
    public static boolean DEBUG = false;
    private static final String LOG_TAG = "AdSdk";

    public static void d(String str, String str2) {
        Log.d(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2);
    }

    public static void d(String str, String str2, Throwable th) {
        Log.d(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2, th);
    }

    public static void d(String str, Throwable th, String... strArr) {
        if (DEBUG) {
            Log.d(LOG_TAG, getLogString(str, strArr), th);
        }
    }

    public static void d(String str, String... strArr) {
        if (DEBUG) {
            Log.d(LOG_TAG, getLogString(str, strArr));
        }
    }

    public static void e(String str, String str2) {
        Log.e(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2, th);
    }

    public static void e(String str, Throwable th, String... strArr) {
        Log.e(LOG_TAG, getLogString(str, strArr), th);
    }

    public static void e(String str, String... strArr) {
        Log.e(LOG_TAG, getLogString(str, strArr));
    }

    private static String getLogString(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        sb.append(str);
        sb.append("] ");
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static void i(String str, String str2) {
        Log.i(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2);
    }

    public static void i(String str, String str2, Throwable th) {
        Log.i(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2, th);
    }

    public static void i(String str, String... strArr) {
        if (DEBUG) {
            Log.i(LOG_TAG, getLogString(str, strArr));
        }
    }

    public static void setDebugMode(boolean z) {
        DEBUG = z;
    }

    public static void v(String str, String str2) {
        Log.v(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2);
    }

    public static void v(String str, String str2, Throwable th) {
        Log.v(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2, th);
    }

    public static void v(String str, String... strArr) {
        if (DEBUG) {
            Log.v(LOG_TAG, getLogString(str, strArr));
        }
    }

    public static void w(String str, String str2) {
        Log.w(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2);
    }

    public static void w(String str, String str2, Throwable th) {
        Log.w(LOG_TAG, jn1.ARRAY_START_STR + str + "] " + str2, th);
    }

    public static void w(String str, String... strArr) {
        if (DEBUG) {
            Log.w(LOG_TAG, getLogString(str, strArr));
        }
    }
}
