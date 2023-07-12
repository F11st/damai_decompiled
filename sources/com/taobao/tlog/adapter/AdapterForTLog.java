package com.taobao.tlog.adapter;

import android.text.TextUtils;
import com.taobao.tao.log.ITLogController;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLog;
import com.taobao.tao.log.TLogInitializer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AdapterForTLog {
    public static final /* synthetic */ int a = 0;
    private static boolean isValid = true;

    public static void formatLogd(String str, String str2, Object... objArr) {
        if (isValid) {
            TLog.formatLogd(str, str2, objArr);
        }
    }

    public static void formatLoge(String str, String str2, Object... objArr) {
        if (isValid) {
            TLog.formatLoge(str, str2, objArr);
        }
    }

    public static void formatLogi(String str, String str2, Object... objArr) {
        if (isValid) {
            TLog.formatLogi(str, str2, objArr);
        }
    }

    public static void formatLogv(String str, String str2, Object... objArr) {
        if (isValid) {
            TLog.formatLogv(str, str2, objArr);
        }
    }

    public static void formatLogw(String str, String str2, Object... objArr) {
        if (isValid) {
            TLog.formatLogw(str, str2, objArr);
        }
    }

    public static String getLogLevel(String str) {
        if (isValid) {
            ITLogController tLogControler = TLogInitializer.getTLogControler();
            if (tLogControler != null) {
                LogLevel logLevel = tLogControler.getLogLevel(str);
                if (logLevel != null) {
                    return logLevel.toString();
                }
                return LogLevel.L.toString();
            }
            return LogLevel.L.toString();
        }
        return "L";
    }

    public static boolean isValid() {
        return isValid;
    }

    public static void logd(String str, String... strArr) {
        if (isValid) {
            TLog.logd(str, strArr);
        }
    }

    public static void loge(String str, String... strArr) {
        if (isValid) {
            TLog.loge(str, strArr);
        }
    }

    public static void logi(String str, String... strArr) {
        if (isValid) {
            TLog.logi(str, strArr);
        }
    }

    public static void logicErrorLog(String str, String str2, String str3) {
        if (!isValid || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TLog.logicErrorLog(str, str2, str3);
    }

    public static void logv(String str, String... strArr) {
        if (isValid) {
            TLog.logv(str, strArr);
        }
    }

    public static void logw(String str, String... strArr) {
        if (isValid) {
            TLog.logw(str, strArr);
        }
    }

    public static void sceneLog(String str, String str2, String str3) {
        if (!isValid || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TLog.sceneLog(str, str2, str3);
    }

    public static void traceLog(String str, String str2) {
        if (!isValid || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TLog.traceLog(str, str2);
    }

    public static void userOptionLog(String str, String str2, String str3, String str4) {
        if (!isValid || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TLog.userOptionLog(str, str2, str3, str4);
    }

    public static void logd(String str, String str2) {
        if (isValid) {
            TLog.logd(str, str2);
        }
    }

    public static void loge(String str, String str2) {
        if (isValid) {
            TLog.loge(str, str2);
        }
    }

    public static void logi(String str, String str2) {
        if (isValid) {
            TLog.logi(str, str2);
        }
    }

    public static void logv(String str, String str2) {
        if (isValid) {
            TLog.logv(str, str2);
        }
    }

    public static void logw(String str, String str2) {
        if (isValid) {
            TLog.logw(str, str2);
        }
    }

    public static void loge(String str, String str2, Throwable th) {
        if (isValid) {
            TLog.loge(str, str2, th);
        }
    }

    public static void logw(String str, String str2, Throwable th) {
        if (isValid) {
            TLog.logw(str, str2, th);
        }
    }

    public static String getLogLevel() {
        return getLogLevel(null);
    }
}
