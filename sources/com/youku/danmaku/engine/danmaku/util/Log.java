package com.youku.danmaku.engine.danmaku.util;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Log {
    public static final String DANMU_BTN_TAG = "Danmaku_SWITCHER";
    public static final String DANMU_TAG = "Danmaku_LOG";
    private static final String LOG_TAG = "Youku_Danmaku_SDK";
    public static final String MTOP_TAG = "Danmaku_MTOP";
    public static final String SETTING_TAG = "Danmaku_SETTING";
    public static final String SYSDANMU_TAG = "Danmaku_SYSDANMU";
    private static boolean mIsDebug;
    private static boolean mIsShowToast;

    public static int d(String str, String str2) {
        if (mIsDebug) {
            return android.util.Log.d(str, str2);
        }
        return 0;
    }

    public static int e(String str, String str2) {
        if (mIsDebug) {
            return android.util.Log.e(str, str2);
        }
        return 0;
    }

    public static int i(String str, String str2) {
        if (mIsDebug) {
            return android.util.Log.i(str, str2);
        }
        return 0;
    }

    public static boolean isDebug() {
        return mIsDebug;
    }

    public static boolean isShowToast() {
        return mIsShowToast;
    }

    public static void printStackTrace(Throwable th) {
        if (mIsDebug) {
            th.printStackTrace();
        }
    }

    public static void setDebug(boolean z) {
        mIsDebug = z;
    }

    public static void setShowToast(boolean z) {
        mIsShowToast = z;
    }

    public static void showDebugLog(String str) {
        if (mIsDebug) {
            android.util.Log.d(LOG_TAG, str);
        }
    }

    public static String showTime(long j) {
        Locale locale = Locale.getDefault();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format(locale, "%02d:%02d:%02d", Long.valueOf(timeUnit.toHours(j)), Long.valueOf(timeUnit.toMinutes(j) - TimeUnit.HOURS.toMinutes(timeUnit.toHours(j))), Long.valueOf(timeUnit.toSeconds(j) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j))));
    }

    public static int v(String str, String str2) {
        if (mIsDebug) {
            return android.util.Log.v(str, str2);
        }
        return 0;
    }

    public static int w(String str, String str2) {
        if (mIsDebug) {
            return android.util.Log.w(str, str2);
        }
        return 0;
    }

    public static int d(String str) {
        if (mIsDebug) {
            return android.util.Log.d(LOG_TAG, str);
        }
        return 0;
    }

    public static int e(String str, String str2, Throwable th) {
        if (mIsDebug) {
            return android.util.Log.e(str, str2, th);
        }
        return 0;
    }

    public static int i(String str) {
        if (mIsDebug) {
            return android.util.Log.i(LOG_TAG, str);
        }
        return 0;
    }

    public static int v(String str) {
        if (mIsDebug) {
            return android.util.Log.v(LOG_TAG, str);
        }
        return 0;
    }

    public static int w(String str, Throwable th) {
        if (mIsDebug) {
            return android.util.Log.w(str, th);
        }
        return 0;
    }

    public static int e(String str) {
        if (mIsDebug) {
            return android.util.Log.e(LOG_TAG, str);
        }
        return 0;
    }

    public static int w(String str) {
        if (mIsDebug) {
            return android.util.Log.w(LOG_TAG, str);
        }
        return 0;
    }
}
