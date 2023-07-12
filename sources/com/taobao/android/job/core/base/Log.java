package com.taobao.android.job.core.base;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static ExecutorService EXECUTOR = null;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    private Log() {
    }

    public static void d(String str, String str2) {
        debug(str, str2, new Object[0]);
    }

    private static void debug(String str, String str2, Object... objArr) {
        String formatLogWithStack = formatLogWithStack(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.d(str, formatLogWithStack, throwableToLog);
        } else {
            android.util.Log.d(str, formatLogWithStack);
        }
    }

    public static void e(final String str, final String str2, final Object... objArr) {
        ExecutorService executorService = EXECUTOR;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.taobao.android.job.core.base.Log.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.eInner(str, str2, objArr);
                }
            });
        } else {
            eInner(str, str2, objArr);
        }
    }

    public static void eInner(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.e(str, formatLog, throwableToLog);
        } else {
            android.util.Log.e(str, formatLog);
        }
    }

    private static String formatLog(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    private static String formatLogWithStack(String str, Object... objArr) {
        return jn1.ARRAY_START_STR + getCallOrigin() + "] " + formatLog(str, objArr);
    }

    private static String getCallOrigin() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Log.class.getName();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (stackTrace[i].getClassName().equals(name)) {
                i += 4;
                break;
            } else {
                i++;
            }
        }
        return stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber();
    }

    private static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    public static void i(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.i(str, formatLog, throwableToLog);
        } else {
            android.util.Log.i(str, formatLog);
        }
    }

    public static boolean isLoggable(String str, int i) {
        return android.util.Log.isLoggable(str, i);
    }

    public static void v(String str, String str2) {
        verbose(str, str2, new Object[0]);
    }

    private static void verbose(String str, String str2, Object... objArr) {
        if (isLoggable(str, 2)) {
            String formatLogWithStack = formatLogWithStack(str2, objArr);
            Throwable throwableToLog = getThrowableToLog(objArr);
            if (throwableToLog != null) {
                android.util.Log.v(str, formatLogWithStack, throwableToLog);
            } else {
                android.util.Log.v(str, formatLogWithStack);
            }
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.w(str, formatLog, throwableToLog);
        } else {
            android.util.Log.w(str, formatLog);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.wtf(str, formatLog, throwableToLog);
        } else {
            android.util.Log.wtf(str, formatLog);
        }
    }

    public static void d(String str, String str2, Object obj) {
        debug(str, str2, obj);
    }

    public static void v(String str, String str2, Object obj) {
        verbose(str, str2, obj);
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        debug(str, str2, obj, obj2);
    }

    public static void v(String str, String str2, Object obj, Object obj2) {
        verbose(str, str2, obj, obj2);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3) {
        debug(str, str2, obj, obj2, obj3);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3) {
        verbose(str, str2, obj, obj2, obj3);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        debug(str, str2, obj, obj2, obj3, obj4);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        verbose(str, str2, obj, obj2, obj3, obj4);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        debug(str, str2, obj, obj2, obj3, obj4, obj5);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        verbose(str, str2, obj, obj2, obj3, obj4, obj5);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        debug(str, str2, obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        verbose(str, str2, obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        debug(str, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        verbose(str, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }
}
