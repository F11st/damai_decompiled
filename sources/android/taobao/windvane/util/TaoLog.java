package android.taobao.windvane.util;

import android.taobao.windvane.util.log.AndroidLog;
import android.taobao.windvane.util.log.ILog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class TaoLog {
    private static int LENGTH = 5120;
    public static Map<String, Integer> LogLevel = new HashMap();
    private static boolean enabled = false;
    private static ILog impl = null;
    private static String tagPre = "WindVane.";

    static {
        ILog.LogLevelEnum[] values;
        setImpl(new AndroidLog());
        for (ILog.LogLevelEnum logLevelEnum : ILog.LogLevelEnum.values()) {
            LogLevel.put(logLevelEnum.getLogLevelName(), Integer.valueOf(logLevelEnum.getLogLevel()));
        }
        impl = new AndroidLog();
    }

    public static void d(String str, String str2, Object... objArr) {
        ILog iLog;
        if (!shouldPrintDebug() || (iLog = impl) == null) {
            return;
        }
        iLog.d(tagPre + str, format(str2, objArr));
    }

    public static void e(String str, String str2) {
        if (!shouldPrintError() || impl == null) {
            return;
        }
        int length = str2.length() / LENGTH;
        int i = 0;
        while (i < length) {
            int i2 = LENGTH;
            int i3 = i * i2;
            i++;
            impl.e(tagPre + str, str2.substring(i3, i2 * i));
        }
        impl.e(tagPre + str, str2.substring(i * LENGTH));
    }

    private static String format(String str, Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    public static boolean getLogStatus() {
        return impl != null && enabled;
    }

    public static void i(String str, String str2) {
        ILog iLog;
        if (!shouldPrintInfo() || (iLog = impl) == null) {
            return;
        }
        iLog.i(tagPre + str, str2);
    }

    public static void log(int i, String str, String str2) {
        if (i == 2) {
            v(str, str2);
        } else if (i == 3) {
            d(str, str2);
        } else if (i == 4) {
            i(str, str2);
        } else if (i == 5) {
            w(str, str2);
        } else if (i != 6) {
            v(str, str2);
        } else {
            e(str, str2);
        }
    }

    public static void setImpl(ILog iLog) {
        if (EnvUtil.isAppDebug()) {
            w("TaoLog", "Ignore set log impl on debug mode");
        } else {
            impl = iLog;
        }
    }

    public static void setLogSwitcher(boolean z) {
        enabled = z;
    }

    public static void setTagPre(String str) {
        tagPre = str;
    }

    public static boolean shouldPrintDebug() {
        return getLogStatus() && impl.isLogLevelEnabled(ILog.LogLevelEnum.DEBUG.getLogLevel());
    }

    public static boolean shouldPrintError() {
        return getLogStatus() && impl.isLogLevelEnabled(ILog.LogLevelEnum.ERROR.getLogLevel());
    }

    public static boolean shouldPrintInfo() {
        return getLogStatus() && impl.isLogLevelEnabled(ILog.LogLevelEnum.INFO.getLogLevel());
    }

    public static boolean shouldPrintVerbose() {
        return getLogStatus() && impl.isLogLevelEnabled(ILog.LogLevelEnum.VERBOSE.getLogLevel());
    }

    public static boolean shouldPrintWarn() {
        return getLogStatus() && impl.isLogLevelEnabled(ILog.LogLevelEnum.WARNING.getLogLevel());
    }

    public static void v(String str, String str2) {
        ILog iLog;
        if (!shouldPrintVerbose() || (iLog = impl) == null) {
            return;
        }
        iLog.v(tagPre + str, str2);
    }

    public static void w(String str, String str2) {
        ILog iLog;
        if (!shouldPrintWarn() || (iLog = impl) == null) {
            return;
        }
        iLog.w(tagPre + str, str2);
    }

    public static void d(String str, String str2, Throwable th, Object... objArr) {
        ILog iLog;
        if (!shouldPrintDebug() || (iLog = impl) == null) {
            return;
        }
        iLog.d(tagPre + str, format(str2, objArr), th);
    }

    public static void i(String str, String str2, Object... objArr) {
        ILog iLog;
        if (!shouldPrintInfo() || (iLog = impl) == null) {
            return;
        }
        iLog.i(tagPre + str, format(str2, objArr));
    }

    public static void v(String str, String str2, Object... objArr) {
        ILog iLog;
        if (!shouldPrintVerbose() || (iLog = impl) == null) {
            return;
        }
        iLog.v(tagPre + str, format(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        ILog iLog;
        if (!shouldPrintWarn() || (iLog = impl) == null) {
            return;
        }
        iLog.w(tagPre + str, format(str2, objArr));
    }

    public static void d(String str, String str2) {
        ILog iLog;
        if (!shouldPrintDebug() || (iLog = impl) == null) {
            return;
        }
        iLog.d(tagPre + str, str2);
    }

    public static void e(String str, String str2, Object... objArr) {
        ILog iLog;
        if (!shouldPrintError() || (iLog = impl) == null) {
            return;
        }
        iLog.e(tagPre + str, format(str2, objArr));
    }

    public static void i(String str, String str2, Throwable th, Object... objArr) {
        ILog iLog;
        if (!shouldPrintInfo() || (iLog = impl) == null) {
            return;
        }
        iLog.i(tagPre + str, format(str2, objArr), th);
    }

    public static void v(String str, String str2, Throwable th, Object... objArr) {
        ILog iLog;
        if (!shouldPrintVerbose() || (iLog = impl) == null) {
            return;
        }
        iLog.v(tagPre + str, format(str2, objArr), th);
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        ILog iLog;
        if (!shouldPrintWarn() || (iLog = impl) == null) {
            return;
        }
        iLog.w(tagPre + str, format(str2, objArr), th);
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        ILog iLog;
        if (!shouldPrintError() || (iLog = impl) == null) {
            return;
        }
        iLog.e(tagPre + str, format(str2, objArr), th);
    }
}
