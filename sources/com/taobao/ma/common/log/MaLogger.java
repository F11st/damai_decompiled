package com.taobao.ma.common.log;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaLogger {
    private static final String MA_LOG_TAG = "Ma";
    private static final String NO_MESSAGE = "";
    private static LogLevel mLogLevel = LogLevel.ERROR;

    public static void d(String str) {
        log(LogLevel.DEBUG, str, null);
    }

    public static void e(String str) {
        log(LogLevel.ERROR, str, null);
    }

    public static void i(String str) {
        log(LogLevel.INFO, str, null);
    }

    protected static boolean isLevelEnabled(LogLevel logLevel) {
        return logLevel.getAndroidLogLevel() >= mLogLevel.getAndroidLogLevel();
    }

    private static void log(LogLevel logLevel, String str, Throwable th) {
        if (isLevelEnabled(logLevel)) {
            int androidLogLevel = logLevel.getAndroidLogLevel();
            if (androidLogLevel == 2) {
                logAndroidVerbose(str, th);
            } else if (androidLogLevel == 3) {
                logAndroidDebug(str, th);
            } else if (androidLogLevel == 4) {
                logAndroidInfo(str, th);
            } else if (androidLogLevel == 5) {
                logAndroidWarn(str, th);
            } else if (androidLogLevel != 6) {
            } else {
                logAndroidError(str, th);
            }
        }
    }

    private static void logAndroidDebug(String str, Throwable th) {
        if (th != null) {
            Log.d(MA_LOG_TAG, str, th);
        } else {
            Log.d(MA_LOG_TAG, str);
        }
    }

    private static void logAndroidError(String str, Throwable th) {
        if (th != null) {
            Log.e(MA_LOG_TAG, str, th);
        } else {
            Log.e(MA_LOG_TAG, str);
        }
    }

    private static void logAndroidInfo(String str, Throwable th) {
        if (th != null) {
            Log.i(MA_LOG_TAG, str, th);
        } else {
            Log.i(MA_LOG_TAG, str);
        }
    }

    private static void logAndroidVerbose(String str, Throwable th) {
        if (th != null) {
            Log.v(MA_LOG_TAG, str, th);
        } else {
            Log.v(MA_LOG_TAG, str);
        }
    }

    private static void logAndroidWarn(String str, Throwable th) {
        if (th != null) {
            Log.w(MA_LOG_TAG, str, th);
        } else {
            Log.w(MA_LOG_TAG, str);
        }
    }

    public static void setLogLevel(LogLevel logLevel) {
        mLogLevel = logLevel;
    }

    public static void v(String str) {
        log(LogLevel.TRACE, str, null);
    }

    public static void w(String str) {
        log(LogLevel.WARN, str, null);
    }

    public static void d(Throwable th) {
        log(LogLevel.TRACE, "", th);
    }

    public static void e(Throwable th) {
        log(LogLevel.TRACE, "", th);
    }

    public static void i(Throwable th) {
        log(LogLevel.TRACE, "", th);
    }

    public static void v(Throwable th) {
        log(LogLevel.TRACE, "", th);
    }

    public static void w(Throwable th) {
        log(LogLevel.TRACE, "", th);
    }

    public static void d(String str, Throwable th) {
        log(LogLevel.DEBUG, str, th);
    }

    public static void e(String str, Throwable th) {
        log(LogLevel.ERROR, str, th);
    }

    public static void i(String str, Throwable th) {
        log(LogLevel.INFO, str, th);
    }

    public static void v(String str, Throwable th) {
        log(LogLevel.TRACE, str, th);
    }

    public void w(String str, Throwable th) {
        log(LogLevel.WARN, str, th);
    }
}
