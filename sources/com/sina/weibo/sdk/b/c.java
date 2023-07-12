package com.sina.weibo.sdk.b;

import android.util.Log;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class c {
    private static boolean ai;

    public static void a(String str, String str2) {
        if (ai) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(str, (stackTraceElement.getFileName() + jn1.BRACKET_START_STR + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void b(String str, String str2) {
        if (ai) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(str, (stackTraceElement.getFileName() + jn1.BRACKET_START_STR + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void setLoggerEnable(boolean z) {
        ai = z;
    }
}
