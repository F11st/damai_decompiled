package com.youku.upsplayer.util;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Logger {
    public static boolean DEBUG = false;
    public static boolean ERROR = false;
    public static boolean INFO = false;
    public static int LOGLEVEL = 0;
    private static final String SYSTEM_PROP_KEY_LOG_LEVEL = "debug.upssdk.loglevel";
    public static final String TAG = "UpsPlayer";
    public static boolean VERBOSE;
    public static boolean WARN;

    static {
        setDebugMode(getDebugMode());
    }

    public static void d(String str, String str2) {
        if (DEBUG) {
            UpsLogProxy.getInstance().getProxy().d("UpsPlayer", getMsg(str, str2));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG) {
            UpsLogProxy.getInstance().getProxy().d("UpsPlayer", getMsg(str, str2), th);
        }
    }

    public static void d_long(String str, String str2) {
        if (!DEBUG || str2 == null) {
            return;
        }
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 2000;
            d(str, str2.substring(i, length > i2 ? i2 : length));
            i = i2;
        }
    }

    public static void e(String str, String str2) {
        if (ERROR) {
            UpsLogProxy.getInstance().getProxy().e("UpsPlayer", getMsg(str, str2));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (ERROR) {
            UpsLogProxy.getInstance().getProxy().e("UpsPlayer", getMsg(str, str2), th);
        }
    }

    public static boolean getDebugMode() {
        return getLogLevelCode() == 1;
    }

    private static int getLogLevelCode() {
        return SystemUtils.getInt(SYSTEM_PROP_KEY_LOG_LEVEL, 0);
    }

    protected static String getMsg(String str, String str2) {
        StringBuilder sb = new StringBuilder("");
        if (str != null) {
            sb.append(str);
        }
        if (str2 != null) {
            sb.append(" ");
            sb.append(str2);
        }
        return sb.toString();
    }

    public static void setDebugMode(boolean z) {
        int i = z ? 5 : 1;
        LOGLEVEL = i;
        VERBOSE = i > 4;
        DEBUG = i > 3;
        INFO = i > 2;
        WARN = i > 1;
        ERROR = i > 0;
    }

    public static void v(String str, String str2) {
        if (DEBUG) {
            UpsLogProxy.getInstance().getProxy().v("UpsPlayer", getMsg(str, str2));
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            UpsLogProxy.getInstance().getProxy().v("UpsPlayer", getMsg(str, str2), th);
        }
    }
}
