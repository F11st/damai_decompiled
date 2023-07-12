package com.huawei.secure.android.common.encrypt.utils;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static final String a = "SecurityComp10105310: ";

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(a(str), str2, th);
    }

    public static void b(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void c(String str, String str2) {
        Log.i(a(str), str2);
    }

    public static void d(String str, String str2) {
        Log.v(a(str), str2);
    }

    public static void e(String str, String str2) {
        Log.w(a(str), str2);
    }

    private static String a(String str) {
        return a + str;
    }
}
