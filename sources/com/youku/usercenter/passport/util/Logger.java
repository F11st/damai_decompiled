package com.youku.usercenter.passport.util;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class Logger {
    public static final boolean DEBUG_DEBUG = true;
    public static final boolean DEBUG_ERROR = true;
    public static final boolean DEBUG_EXCEPT = true;
    public static final boolean DEBUG_INFO = true;
    public static final boolean DEBUG_PERFORMANCE = true;
    public static final boolean DEBUG_VERBOSE = true;
    public static final boolean DEBUG_WARN = true;
    public static final String LOG_TAG = "PassportSDK";
    private static boolean sDebug = true;
    private static boolean sDebugPerformance;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.usercenter.passport.util.Logger$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[LogLevel.WARN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    private Logger() {
    }

    public static void d(String str, String str2) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, str, str2, null);
        }
    }

    private static void doLog(LogLevel logLevel, String str, String str2, Throwable th) {
        if (str2 == null) {
            str2 = "";
        }
        int i = AnonymousClass1.$SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            if (th == null) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, th);
            }
        } else if (i == 2) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        } else if (i == 3) {
            if (th == null) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, th);
            }
        } else if (i == 4) {
            if (th == null) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, th);
            }
        } else if (i != 5) {
        } else {
            if (th == null) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, th);
            }
        }
    }

    public static void e(String str, String str2) {
        doLog(LogLevel.ERROR, str, str2, null);
    }

    public static void i(String str, String str2) {
        if (sDebug) {
            doLog(LogLevel.INFO, str, str2, null);
        }
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isDebugPerformance() {
        return sDebugPerformance;
    }

    public static void p(String str) {
        if (sDebug || sDebugPerformance) {
            doLog(LogLevel.INFO, LOG_TAG, str, null);
        }
    }

    public static void printInvokeTrace(String str) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i = 1; i < stackTrace.length; i++) {
            d(str + ":  " + stackTrace[i].toString());
        }
    }

    public static void printStackTrace(Throwable th) {
        if (sDebug) {
            th.printStackTrace();
        }
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setDebugPerformance(boolean z) {
        sDebugPerformance = z;
    }

    public static void v(String str, String str2) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, str, str2, null);
        }
    }

    public static void w(String str) {
        if (sDebug) {
            doLog(LogLevel.WARN, LOG_TAG, str, null);
        }
    }

    public static void e(String str) {
        doLog(LogLevel.ERROR, LOG_TAG, str, null);
    }

    public static void d(String str) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, null);
        }
    }

    public static void e(String str, Throwable th) {
        doLog(LogLevel.ERROR, LOG_TAG, str, th);
    }

    public static void i(String str) {
        if (sDebug) {
            doLog(LogLevel.INFO, LOG_TAG, str, null);
        }
    }

    public static void p(String str, String str2) {
        if (sDebug || sDebugPerformance) {
            doLog(LogLevel.INFO, str, str2, null);
        }
    }

    public static void v(String str) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, LOG_TAG, str, null);
        }
    }

    public static void w(String str, String str2) {
        if (sDebug) {
            doLog(LogLevel.WARN, str, str2, null);
        }
    }

    public static void printInvokeTrace(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length);
        for (int i2 = 1; i2 < min; i2++) {
            d(str + ":  " + stackTrace[i2].toString());
        }
    }

    public static void d(String str, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, th);
        }
    }

    public static void i(String str, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.INFO, LOG_TAG, str, th);
        }
    }

    public static void v(String str, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, LOG_TAG, str, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.WARN, str, str2, th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, str, str2, th);
        }
    }

    public static void w(String str, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.WARN, LOG_TAG, str, th);
        }
    }
}
