package com.ut.mini.exposure;

import com.alibaba.analytics.utils.Logger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ExpLogger {
    static boolean enableLog;

    ExpLogger() {
    }

    public static void d() {
        if (enableLog) {
            Logger.d();
        }
    }

    public static void e(String str, Object... objArr) {
        if (enableLog) {
            Logger.i(str, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        if (enableLog) {
            Logger.v(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (enableLog) {
            Logger.f(str, objArr);
        }
    }

    public static void e(String str, Throwable th, Object... objArr) {
        if (enableLog) {
            Logger.h(str, th, objArr);
        }
    }
}
