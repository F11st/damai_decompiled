package com.taobao.orange.util;

import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OLog {
    private static final String PRE_TAG = "NOrange.";
    public static volatile boolean isUseTlog;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Level {
        public static final int D = 1;
        public static final int E = 4;
        public static final int I = 2;
        public static final int L = 5;
        public static final int V = 0;
        public static final int W = 3;

        static int valueOf(String str) {
            char charAt = str.charAt(0);
            if (charAt != 'D') {
                if (charAt != 'E') {
                    if (charAt != 'I') {
                        if (charAt != 'V') {
                            return charAt != 'W' ? 5 : 3;
                        }
                        return 0;
                    }
                    return 2;
                }
                return 4;
            }
            return 1;
        }
    }

    static {
        try {
            int i = AdapterForTLog.a;
            isUseTlog = true;
        } catch (ClassNotFoundException unused) {
            isUseTlog = false;
        }
    }

    private static String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        if (objArr != null) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(" ");
                sb.append(formatKv(objArr[i], objArr[i2]));
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(" ");
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return PRE_TAG + str;
    }

    public static void d(String str, String str2, Object... objArr) {
        if (isPrintLog(1)) {
            if (isUseTlog) {
                AdapterForTLog.logd(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                Log.d(buildLogTag(str), buildLogMsg(str2, objArr));
            }
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (isPrintLog(4)) {
            if (isUseTlog) {
                AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                Log.e(buildLogTag(str), buildLogMsg(str2, objArr));
            }
        }
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(":");
        if (obj2 == null) {
            obj2 = "";
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static void i(String str, String str2, Object... objArr) {
        if (isPrintLog(2)) {
            if (isUseTlog) {
                AdapterForTLog.logi(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                Log.i(buildLogTag(str), buildLogMsg(str2, objArr));
            }
        }
    }

    public static boolean isPrintLog(int i) {
        return !isUseTlog || i >= Level.valueOf(AdapterForTLog.getLogLevel());
    }

    @Deprecated
    public static void setPrintLog(boolean z) {
    }

    @Deprecated
    public static void setUseTlog(boolean z) {
    }

    public static void v(String str, String str2, Object... objArr) {
        if (isPrintLog(0)) {
            if (isUseTlog) {
                AdapterForTLog.logv(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                Log.v(buildLogTag(str), buildLogMsg(str2, objArr));
            }
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (isPrintLog(3)) {
            if (isUseTlog) {
                AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                Log.w(buildLogTag(str), buildLogMsg(str2, objArr));
            }
        }
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog(4)) {
            if (isUseTlog) {
                AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, objArr), th);
            } else {
                Log.e(buildLogTag(str), buildLogMsg(str2, objArr), th);
            }
        }
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog(3)) {
            if (isUseTlog) {
                AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, objArr), th);
            } else {
                Log.w(buildLogTag(str), buildLogMsg(str2, objArr), th);
            }
        }
    }
}
