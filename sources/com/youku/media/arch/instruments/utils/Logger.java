package com.youku.media.arch.instruments.utils;

import android.util.Log;
import java.util.Formatter;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class Logger {
    private static RemoteLogAdaptor sRemoteLogAdaptor;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        FATAL
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface RemoteLogAdaptor {
        void log(String str, String str2, Object... objArr);
    }

    private static boolean checkLogLevel(LogLevel logLevel) {
        return true;
    }

    public static void d(String str, String str2, Object... objArr) {
        if (checkLogLevel(LogLevel.DEBUG)) {
            Log.d(str, new Formatter().format(str2, objArr).toString());
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (checkLogLevel(LogLevel.ERROR)) {
            Log.e(str, new Formatter().format(str2, objArr).toString());
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        checkLogLevel(LogLevel.FATAL);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (checkLogLevel(LogLevel.INFO)) {
            Log.i(str, new Formatter().format(str2, objArr).toString());
        }
    }

    public static void setRemoteLogAdaptor(RemoteLogAdaptor remoteLogAdaptor) {
        sRemoteLogAdaptor = remoteLogAdaptor;
    }

    public static void t(String str, String str2, Object... objArr) {
        d(str, str2, objArr);
        RemoteLogAdaptor remoteLogAdaptor = sRemoteLogAdaptor;
        if (remoteLogAdaptor != null) {
            remoteLogAdaptor.log(str, str2, objArr);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (checkLogLevel(LogLevel.VERBOSE)) {
            Log.v(str, new Formatter().format(str2, objArr).toString());
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (checkLogLevel(LogLevel.WARNING)) {
            Log.w(str, new Formatter().format(str2, objArr).toString());
        }
    }
}
