package com.youku.antitheftchain;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AtcLog {
    public static final String PREFIX = "Atc_";
    public static boolean enableDebug = false;
    public static boolean enableError = true;
    public static boolean enableInfo = true;
    public static boolean enableWarning = true;

    /* compiled from: Taobao */
    /* renamed from: com.youku.antitheftchain.AtcLog$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel = iArr;
            try {
                iArr[LogLevel.info.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel[LogLevel.debug.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel[LogLevel.warning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel[LogLevel.error.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum LogLevel {
        error,
        warning,
        debug,
        info
    }

    public static void d(String str, String str2) {
        if (enableDebug) {
            Log.d(PREFIX + str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (enableDebug) {
            Log.d(PREFIX + str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (enableError) {
            Log.e(PREFIX + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (enableError) {
            Log.e(PREFIX + str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (enableInfo) {
            Log.i(PREFIX + str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (enableInfo) {
            Log.i(PREFIX + str, str2, th);
        }
    }

    public static void setLogLevel(LogLevel logLevel) {
        enableInfo = false;
        enableError = false;
        enableWarning = false;
        enableDebug = false;
        int i = AnonymousClass1.$SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            enableInfo = true;
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    enableError = true;
                    enableWarning = true;
                    enableDebug = true;
                    return;
                }
                enableError = true;
            }
            enableWarning = true;
            enableError = true;
        }
        enableDebug = true;
        enableWarning = true;
        enableError = true;
    }

    public static void w(String str, String str2) {
        if (enableWarning) {
            Log.w(PREFIX + str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (enableWarning) {
            Log.w(PREFIX + str, str2, th);
        }
    }
}
