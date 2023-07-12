package com.alibaba.wireless.security.framework.utils;

import android.os.Process;
import android.util.Log;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FLOG {
    private static String a = "SGTIME";
    private static boolean b;

    public static void d(String str) {
    }

    public static void e(String str) {
    }

    public static String get_currentFuncName() {
        if (b) {
            return Thread.currentThread().getStackTrace()[3].getMethodName();
        }
        return null;
    }

    public static long get_currentTime() {
        if (b) {
            return System.currentTimeMillis();
        }
        return 0L;
    }

    public static void i(String str) {
    }

    public static void printTimeCost(String str, String str2, String str3, long j) {
        if (b) {
            String str4 = a;
            Log.e(str4, jn1.ARRAY_START_STR + Process.myPid() + "][" + Process.myTid() + "][" + str + "][JAVA][" + str2 + "] cost = " + (System.currentTimeMillis() - j) + " ms [" + str3 + jn1.ARRAY_END_STR);
        }
    }

    public static void w(String str) {
    }

    public static void w(String str, Throwable th) {
    }
}
