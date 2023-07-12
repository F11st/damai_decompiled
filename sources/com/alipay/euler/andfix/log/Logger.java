package com.alipay.euler.andfix.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    int a = 2;

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public int d(String str, String str2) {
        if (this.a <= 3) {
            return debug(str, str2);
        }
        return -1;
    }

    public abstract int debug(String str, String str2);

    public int e(String str, String str2) {
        if (this.a <= 6) {
            return error(str, str2);
        }
        return -1;
    }

    public abstract int error(String str, String str2);

    public int footprint(String str) {
        return i("footprint", str);
    }

    public int i(String str, String str2) {
        if (this.a <= 4) {
            return info(str, str2);
        }
        return -1;
    }

    public abstract int info(String str, String str2);

    public void setLogLevel(int i) {
        if (i >= 2 && i <= 7) {
            this.a = i;
            return;
        }
        throw new RuntimeException("level should between [2 , 7]");
    }

    public int v(String str, String str2) {
        if (this.a <= 2) {
            return verbose(str, str2);
        }
        return -1;
    }

    public abstract int verbose(String str, String str2);

    public int w(String str, String str2) {
        if (this.a <= 5) {
            return warn(str, str2);
        }
        return -1;
    }

    public abstract int warn(String str, String str2);

    public int d(String str, String str2, Throwable th) {
        if (this.a <= 3) {
            return debug(str, str2 + '\n' + getStackTraceString(th));
        }
        return -1;
    }

    public int e(String str, String str2, Throwable th) {
        if (this.a <= 6) {
            return error(str, str2 + '\n' + getStackTraceString(th));
        }
        return -1;
    }

    public int i(String str, String str2, Throwable th) {
        if (this.a <= 4) {
            return info(str, str2 + '\n' + getStackTraceString(th));
        }
        return -1;
    }

    public int v(String str, String str2, Throwable th) {
        if (this.a <= 2) {
            return verbose(str, str2 + '\n' + getStackTraceString(th));
        }
        return -1;
    }

    public int w(String str, String str2, Throwable th) {
        if (this.a <= 5) {
            return warn(str, str2 + '\n' + getStackTraceString(th));
        }
        return -1;
    }

    public int d(String str, Throwable th) {
        if (this.a <= 3) {
            return debug(str, getStackTraceString(th));
        }
        return -1;
    }

    public int e(String str, Throwable th) {
        if (this.a <= 6) {
            return error(str, getStackTraceString(th));
        }
        return -1;
    }

    public int i(String str, Throwable th) {
        if (this.a <= 4) {
            return info(str, getStackTraceString(th));
        }
        return -1;
    }

    public int v(String str, Throwable th) {
        if (this.a <= 2) {
            return verbose(str, getStackTraceString(th));
        }
        return -1;
    }

    public int w(String str, Throwable th) {
        if (this.a <= 5) {
            return warn(str, getStackTraceString(th));
        }
        return -1;
    }
}
