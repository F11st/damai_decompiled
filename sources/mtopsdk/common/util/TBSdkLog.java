package mtopsdk.common.util;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.log.LogAdapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBSdkLog {
    private static final String TAG = "mtopsdk.TBSdkLog";
    private static LogAdapter mLogAdapter = null;
    private static boolean printLog = true;
    private static boolean tLogEnabled = true;
    private static LogEnable logEnable = LogEnable.DebugEnable;
    private static Map<String, LogEnable> logEnabaleMap = new HashMap(5);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum LogEnable {
        VerboseEnable("V"),
        DebugEnable("D"),
        InfoEnable("I"),
        WarnEnable(ExifInterface.LONGITUDE_WEST),
        ErrorEnable(ExifInterface.LONGITUDE_EAST),
        NoneEnable("L");
        
        private String logEnable;

        LogEnable(String str) {
            this.logEnable = str;
        }

        public String getLogEnable() {
            return this.logEnable;
        }
    }

    static {
        LogEnable[] values;
        for (LogEnable logEnable2 : LogEnable.values()) {
            logEnabaleMap.put(logEnable2.getLogEnable(), logEnable2);
        }
    }

    private static String append(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("[seq:");
            sb.append(str);
            sb.append("]|");
        }
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[i]);
                if (i < strArr.length - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static void d(String str, String str2) {
        d(str, (String) null, str2);
    }

    public static void e(String str, String str2) {
        e(str, (String) null, str2);
    }

    public static void i(String str, String str2) {
        i(str, (String) null, str2);
    }

    public static boolean isLogEnable(LogEnable logEnable2) {
        LogAdapter logAdapter;
        LogEnable logEnable3;
        if (tLogEnabled && (logAdapter = mLogAdapter) != null && (logEnable3 = logEnabaleMap.get(logAdapter.getLogLevel())) != null && logEnable.ordinal() != logEnable3.ordinal()) {
            setLogEnable(logEnable3);
        }
        return logEnable2.ordinal() >= logEnable.ordinal();
    }

    public static boolean isPrintLog() {
        return printLog;
    }

    public static void logTraceId(String str, String str2) {
        try {
            LogAdapter logAdapter = mLogAdapter;
            if (logAdapter != null) {
                logAdapter.traceLog(str, str2);
            }
        } catch (Throwable unused) {
            Log.w(TAG, "[logTraceId] call LogAdapter.traceLog error");
        }
    }

    public static void setLogAdapter(LogAdapter logAdapter) {
        mLogAdapter = logAdapter;
        Log.d(TAG, "[setLogAdapter] logAdapter=" + logAdapter);
    }

    public static void setLogEnable(LogEnable logEnable2) {
        if (logEnable2 != null) {
            logEnable = logEnable2;
            Log.d(TAG, "[setLogEnable] logEnable=" + logEnable2);
        }
    }

    public static void setPrintLog(boolean z) {
        printLog = z;
        Log.d(TAG, "[setPrintLog] printLog=" + z);
    }

    public static void setTLogEnabled(boolean z) {
        tLogEnabled = z;
        Log.d(TAG, "[setTLogEnabled] tLogEnabled=" + z);
    }

    public static void w(String str, String str2) {
        w(str, (String) null, str2);
    }

    public static void d(String str, String str2, String str3) {
        if (isLogEnable(LogEnable.DebugEnable)) {
            if (tLogEnabled) {
                LogAdapter logAdapter = mLogAdapter;
                if (logAdapter != null) {
                    logAdapter.printLog(2, str, append(str2, str3), null);
                }
            } else if (printLog) {
                Log.d(str, append(str2, str3));
            }
        }
    }

    public static void e(String str, String str2, String str3) {
        if (isLogEnable(LogEnable.ErrorEnable)) {
            if (tLogEnabled) {
                LogAdapter logAdapter = mLogAdapter;
                if (logAdapter != null) {
                    logAdapter.printLog(16, str, append(str2, str3), null);
                }
            } else if (printLog) {
                Log.e(str, append(str2, str3));
            }
        }
    }

    public static void i(String str, String str2, String str3) {
        if (isLogEnable(LogEnable.InfoEnable)) {
            if (tLogEnabled) {
                LogAdapter logAdapter = mLogAdapter;
                if (logAdapter != null) {
                    logAdapter.printLog(4, str, append(str2, str3), null);
                }
            } else if (printLog) {
                Log.i(str, append(str2, str3));
            }
        }
    }

    public static void w(String str, String str2, String str3) {
        if (isLogEnable(LogEnable.WarnEnable)) {
            if (tLogEnabled) {
                LogAdapter logAdapter = mLogAdapter;
                if (logAdapter != null) {
                    logAdapter.printLog(8, str, append(str2, str3), null);
                }
            } else if (printLog) {
                Log.w(str, append(str2, str3));
            }
        }
    }

    public static void d(String str, String str2, String... strArr) {
        if (isLogEnable(LogEnable.DebugEnable)) {
            if (tLogEnabled) {
                LogAdapter logAdapter = mLogAdapter;
                if (logAdapter != null) {
                    logAdapter.printLog(2, str, append(str2, strArr), null);
                }
            } else if (printLog) {
                Log.d(str, append(str2, strArr));
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, null, str2, th);
    }

    public static void i(String str, String str2, String... strArr) {
        if (isLogEnable(LogEnable.InfoEnable)) {
            if (tLogEnabled) {
                LogAdapter logAdapter = mLogAdapter;
                if (logAdapter != null) {
                    logAdapter.printLog(4, str, append(str2, strArr), null);
                }
            } else if (printLog) {
                Log.i(str, append(str2, strArr));
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        w(str, null, str2, th);
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        if (isLogEnable(LogEnable.ErrorEnable)) {
            if (tLogEnabled) {
                LogAdapter logAdapter = mLogAdapter;
                if (logAdapter != null) {
                    logAdapter.printLog(16, str, append(str2, str3), th);
                }
            } else if (printLog) {
                Log.e(str, append(str2, str3), th);
            }
        }
    }

    public static void w(String str, String str2, String str3, Throwable th) {
        if (isLogEnable(LogEnable.WarnEnable)) {
            if (tLogEnabled) {
                LogAdapter logAdapter = mLogAdapter;
                if (logAdapter != null) {
                    logAdapter.printLog(8, str, append(str2, str3), th);
                }
            } else if (printLog) {
                Log.w(str, append(str2, str3), th);
            }
        }
    }
}
