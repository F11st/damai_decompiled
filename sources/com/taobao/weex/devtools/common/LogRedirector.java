package com.taobao.weex.devtools.common;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogRedirector {
    private static volatile Logger sLogger;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Logger {
        boolean isLoggable(String str, int i);

        void log(int i, String str, String str2);
    }

    public static void d(String str, String str2, Throwable th) {
        d(str, str2 + StringUtils.LF + formatThrowable(th));
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, str2 + StringUtils.LF + formatThrowable(th));
    }

    private static String formatThrowable(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace();
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void i(String str, String str2, Throwable th) {
        i(str, str2 + StringUtils.LF + formatThrowable(th));
    }

    public static boolean isLoggable(String str, int i) {
        Logger logger = sLogger;
        if (logger != null) {
            return logger.isLoggable(str, i);
        }
        return Log.isLoggable(str, i);
    }

    private static void log(int i, String str, String str2) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(i, str, str2);
        } else {
            Log.println(i, str, str2);
        }
    }

    public static void setLogger(Logger logger) {
        Util.throwIfNull(logger);
        Util.throwIfNotNull(sLogger);
        sLogger = logger;
    }

    public static void v(String str, String str2, Throwable th) {
        v(str, str2 + StringUtils.LF + formatThrowable(th));
    }

    public static void w(String str, String str2, Throwable th) {
        w(str, str2 + StringUtils.LF + formatThrowable(th));
    }

    public static void d(String str, String str2) {
        log(3, str, str2);
    }

    public static void e(String str, String str2) {
        log(6, str, str2);
    }

    public static void i(String str, String str2) {
        log(4, str, str2);
    }

    public static void v(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2) {
        log(5, str, str2);
    }
}
