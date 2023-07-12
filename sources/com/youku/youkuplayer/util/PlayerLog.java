package com.youku.youkuplayer.util;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerLog {
    public static boolean DEBUG = false;
    public static boolean ERROR = false;
    public static boolean INFO = false;
    public static final String TAG = "YKPlayer.LOG";
    public static boolean VERBOSE;
    public static boolean WARN;

    public static void d(String str) {
        if (DEBUG) {
            if (str == null) {
                str = "";
            }
            Log.d(TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = "";
            }
            Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = "";
            }
            Log.d(str, str2, th);
        }
    }

    public static void d(String str, Throwable th) {
        if (DEBUG) {
            if (str == null) {
                str = "";
            }
            Log.d(TAG, str, th);
        }
    }

    public static void e(String str) {
        if (ERROR) {
            if (str == null) {
                str = "";
            }
            Log.e(TAG, str);
        }
    }

    public static void e(String str, String str2) {
        if (ERROR) {
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (ERROR) {
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2, th);
        }
    }

    public static void e(String str, Throwable th) {
        if (ERROR) {
            if (str == null) {
                str = "";
            }
            Log.e(TAG, str, th);
        }
    }

    public static void setDebugMode(boolean z) {
        setLogLevel(z ? 5 : 1);
    }

    public static void setLogLevel(int i) {
        VERBOSE = i > 4;
        DEBUG = i > 3;
        INFO = i > 2;
        WARN = i > 1;
        ERROR = i > 0;
    }

    public static void v(String str) {
        if (DEBUG) {
            if (str == null) {
                str = "";
            }
            Log.v(TAG, str);
        }
    }

    public static void v(String str, String str2) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = "";
            }
            Log.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = "";
            }
            Log.v(str, str2, th);
        }
    }

    public static void v(String str, Throwable th) {
        if (DEBUG) {
            if (str == null) {
                str = "";
            }
            Log.v(TAG, str, th);
        }
    }
}
