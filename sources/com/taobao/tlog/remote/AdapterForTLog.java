package com.taobao.tlog.remote;

import android.text.TextUtils;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLog;
import com.taobao.tao.log.TLogController;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AdapterForTLog {
    private static boolean isValid = true;

    public static String getLogLevel(String str) {
        if (isValid) {
            TLogController tLogController = TLogController.getInstance();
            if (tLogController != null) {
                LogLevel logLevel = tLogController.getLogLevel(str);
                if (logLevel != null) {
                    return logLevel.toString();
                }
                return LogLevel.N.toString();
            }
            return LogLevel.N.toString();
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

    public static void traceLog(String str, String str2) {
        if (!isValid || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TLog.traceLog(str, str2);
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
