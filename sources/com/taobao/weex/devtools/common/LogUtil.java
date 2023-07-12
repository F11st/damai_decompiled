package com.taobao.weex.devtools.common;

import com.taobao.weex.devtools.inspector.console.CLog;
import com.taobao.weex.devtools.inspector.protocol.module.Console;
import com.youku.resource.widget.YKActionSheet;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogUtil {
    private static final String TAG = "weex";
    private static final HashMap<String, Console.MessageLevel> sLevelMap;

    static {
        HashMap<String, Console.MessageLevel> hashMap = new HashMap<>(6);
        sLevelMap = hashMap;
        Console.MessageLevel messageLevel = Console.MessageLevel.LOG;
        hashMap.put("verbose", messageLevel);
        hashMap.put("info", messageLevel);
        hashMap.put("assert", messageLevel);
        hashMap.put("debug", Console.MessageLevel.DEBUG);
        hashMap.put(YKActionSheet.ACTION_STYLE_WARNING, Console.MessageLevel.WARNING);
        hashMap.put("error", Console.MessageLevel.ERROR);
    }

    public static void d(String str, Object... objArr) {
        d(format(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        e(format(str, objArr));
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        i(format(str, objArr));
    }

    public static boolean isLoggable(int i) {
        if (i == 5 || i == 6) {
            return true;
        }
        return LogRedirector.isLoggable("weex", i);
    }

    public static void log(String str, String str2) {
        CLog.writeToConsole(sLevelMap.get(str), Console.MessageSource.JAVASCRIPT, str2);
    }

    public static void v(String str, Object... objArr) {
        v(format(str, objArr));
    }

    public static void w(String str, Object... objArr) {
        w(format(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        d(th, format(str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        e(th, format(str, objArr));
    }

    public static void i(Throwable th, String str, Object... objArr) {
        i(th, format(str, objArr));
    }

    public static void v(Throwable th, String str, Object... objArr) {
        v(th, format(str, objArr));
    }

    public static void w(Throwable th, String str, Object... objArr) {
        w(th, format(str, objArr));
    }

    public static void d(String str) {
        if (isLoggable(3)) {
            LogRedirector.d("weex", str);
        }
    }

    public static void e(String str) {
        if (isLoggable(6)) {
            LogRedirector.e("weex", str);
        }
    }

    public static void i(String str) {
        if (isLoggable(4)) {
            LogRedirector.i("weex", str);
        }
    }

    public static void v(String str) {
        if (isLoggable(2)) {
            LogRedirector.v("weex", str);
        }
    }

    public static void w(String str) {
        if (isLoggable(5)) {
            LogRedirector.w("weex", str);
        }
    }

    public static void d(Throwable th, String str) {
        if (isLoggable(3)) {
            LogRedirector.d("weex", str, th);
        }
    }

    public static void e(Throwable th, String str) {
        if (isLoggable(6)) {
            LogRedirector.e("weex", str, th);
        }
    }

    public static void i(Throwable th, String str) {
        if (isLoggable(4)) {
            LogRedirector.i("weex", str, th);
        }
    }

    public static void v(Throwable th, String str) {
        if (isLoggable(2)) {
            LogRedirector.v("weex", str, th);
        }
    }

    public static void w(Throwable th, String str) {
        if (isLoggable(5)) {
            LogRedirector.w("weex", str, th);
        }
    }
}
