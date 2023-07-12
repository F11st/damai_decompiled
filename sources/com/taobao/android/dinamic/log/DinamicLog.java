package com.taobao.android.dinamic.log;

import android.util.Log;
import com.taobao.android.dinamic.C6312a;
import com.taobao.android.dinamic.C6313b;
import tb.nz;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DinamicLog {
    public static boolean a;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.log.DinamicLog$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ long val$consumingTime;
        final /* synthetic */ String val$identifier;
        final /* synthetic */ String val$module;

        AnonymousClass1(String str, String str2, long j) {
            this.val$module = str;
            this.val$identifier = str2;
            this.val$consumingTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6313b.e()) {
                DinamicLog.a(C6313b.TAG, "handleEvent module=" + this.val$module + "identifier=" + this.val$identifier + "consuming=" + (this.val$consumingTime / 1000000.0d));
            }
            C6312a.h().d();
            throw null;
        }
    }

    public static void a(String str, String... strArr) {
        Log.d(str, f(strArr));
    }

    public static void b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    public static void c(String str, Throwable th, String... strArr) {
        Log.e(str, f(strArr), th);
    }

    public static void d(String str, String... strArr) {
        Log.e(str, f(strArr));
    }

    public static void e(String str, String... strArr) {
        Log.i(str, f(strArr));
    }

    private static String f(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void g(String str, String str2, long j) {
        C6312a.h().d();
    }

    public static void h(String str) {
        if (a) {
            a(nz.TAG, str);
        }
    }

    public static void i(String str, Throwable th, String... strArr) {
        Log.w(str, f(strArr), th);
    }

    public static void j(String str, String... strArr) {
        Log.w(str, f(strArr));
    }
}
