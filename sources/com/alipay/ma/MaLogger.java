package com.alipay.ma;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MaLogger {
    private static volatile MaEngineLogger a;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface MaEngineLogger {
        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th);

        void i(String str, String str2);

        boolean isDebuggable();

        void v(String str, String str2);

        void w(String str, String str2);
    }

    public static void d(String str, String str2) {
        try {
            if (a != null) {
                a.d(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void e(String str, String str2) {
        try {
            if (a != null) {
                a.e(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void i(String str, String str2) {
        try {
            if (a != null) {
                a.i(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isDebuggable() {
        try {
            if (a != null) {
                return a.isDebuggable();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void registerLogger(MaEngineLogger maEngineLogger) {
        a = maEngineLogger;
    }

    public static void unRegisterLogger() {
        a = null;
    }

    public static void v(String str, String str2) {
        if (a != null) {
            a.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        try {
            if (a != null) {
                a.w(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void e(String str, Throwable th) {
        try {
            if (a == null || th == null) {
                return;
            }
            a.e(str, th.getMessage());
        } catch (Exception unused) {
        }
    }

    public static void e(String str, String str2, Throwable th) {
        try {
            if (a == null || th == null) {
                return;
            }
            MaEngineLogger maEngineLogger = a;
            maEngineLogger.e(str, str2 + ":" + th.getMessage());
        } catch (Exception unused) {
        }
    }
}
