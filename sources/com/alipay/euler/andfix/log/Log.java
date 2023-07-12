package com.alipay.euler.andfix.log;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class Log {
    private static Logger a;
    private static AndroidLogger b = AndroidLogger.getInstance();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class AndroidLogger extends Logger {
        private static AndroidLogger b;

        private AndroidLogger() {
        }

        public static AndroidLogger getInstance() {
            if (b == null) {
                synchronized (AndroidLogger.class) {
                    if (b == null) {
                        b = new AndroidLogger();
                    }
                }
            }
            return b;
        }

        @Override // com.alipay.euler.andfix.log.Logger
        public int debug(String str, String str2) {
            android.util.Log.d(str, str2);
            return 0;
        }

        @Override // com.alipay.euler.andfix.log.Logger
        public int error(String str, String str2) {
            android.util.Log.e(str, str2);
            return 0;
        }

        @Override // com.alipay.euler.andfix.log.Logger
        public int info(String str, String str2) {
            android.util.Log.i(str, str2);
            return 0;
        }

        @Override // com.alipay.euler.andfix.log.Logger
        public int verbose(String str, String str2) {
            android.util.Log.v(str, str2);
            return 0;
        }

        @Override // com.alipay.euler.andfix.log.Logger
        public int warn(String str, String str2) {
            android.util.Log.w(str, str2);
            return 0;
        }
    }

    private Log() {
    }

    public static void d(String str, String str2) {
        Logger logger = a;
        if (logger == null || -1 == logger.d(str, str2)) {
            b.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        Logger logger = a;
        if (logger == null || -1 == logger.e(str, str2)) {
            b.e(str, str2);
        }
    }

    public static void footprint(String str) {
        Logger logger = a;
        if (logger == null || -1 == logger.footprint(str)) {
            b.footprint(str);
        }
    }

    public static void i(String str, String str2) {
        Logger logger = a;
        if (logger == null || -1 == logger.i(str, str2)) {
            b.i(str, str2);
        }
    }

    public static void setLogLevel(int i) {
        Logger logger = a;
        if (logger != null) {
            logger.setLogLevel(i);
        }
        b.setLogLevel(i);
    }

    public static void setLogger(Logger logger) {
        if (logger != null) {
            a = logger;
            b.setLogLevel(logger.a);
        }
    }

    public static void v(String str, String str2) {
        Logger logger = a;
        if (logger == null || -1 == logger.v(str, str2)) {
            b.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        Logger logger = a;
        if (logger == null || -1 == logger.w(str, str2)) {
            b.w(str, str2);
        }
    }

    public static void d(String str, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.d(str, th)) {
            b.d(str, th);
        }
    }

    public static void e(String str, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.e(str, th)) {
            b.e(str, th);
        }
    }

    public static void i(String str, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.i(str, th)) {
            b.i(str, th);
        }
    }

    public static void v(String str, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.v(str, th)) {
            b.v(str, th);
        }
    }

    public static void w(String str, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.w(str, th)) {
            b.w(str, th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.d(str, str2, th)) {
            b.d(str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.e(str, str2, th)) {
            b.e(str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.i(str, str2, th)) {
            b.i(str, str2, th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.v(str, str2, th)) {
            b.v(str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        Logger logger = a;
        if (logger == null || -1 == logger.w(str, str2, th)) {
            b.w(str, str2, th);
        }
    }
}
