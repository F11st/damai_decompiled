package com.taobao.tao.log;

import android.text.TextUtils;
import android.util.Log;
import com.youku.alixplayer.MsgID;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLog {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.tao.log.TLog$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$tao$log$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$taobao$tao$log$LogLevel = iArr;
            try {
                iArr[LogLevel.D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$taobao$tao$log$LogLevel[LogLevel.I.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$taobao$tao$log$LogLevel[LogLevel.W.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$taobao$tao$log$LogLevel[LogLevel.E.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$taobao$tao$log$LogLevel[LogLevel.V.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static String getExceptionMsg(String str, Throwable th) {
        if (th == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str) && str.length() > 10240) {
            str = String.format("%s...", str.substring(0, MsgID.MEDIA_INFO_VIDEO_START_RECOVER));
        }
        StringBuilder sb = new StringBuilder();
        String message = th.getMessage();
        String name = th.getClass().getName();
        sb.append("\t");
        sb.append(str + "\t");
        sb.append(name);
        sb.append(AltriaXLaunchTime.SPACE);
        sb.append(message);
        sb.append(SocketClient.NETASCII_EOL);
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            int i = 0;
            while (true) {
                if (i >= stackTrace.length) {
                    break;
                } else if (sb.length() >= 30720) {
                    sb.append(String.format("\t... total %d.\r\n", Integer.valueOf(stackTrace.length)));
                    break;
                } else {
                    sb.append("\tat  ");
                    sb.append(stackTrace[i]);
                    sb.append(SocketClient.NETASCII_EOL);
                    i++;
                }
            }
        }
        return sb.toString();
    }

    private static void log(LogLevel logLevel, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str6)) {
            Log.e(String.format("%s:%s", str, str2), "Log content is null!!!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str = "module";
            } else if (str2.contains(".")) {
                String substring = str2.substring(0, str2.indexOf("."));
                str2 = str2.substring(str2.indexOf(".") + 1);
                str = substring;
            } else {
                str = str2;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "tag";
        }
        TLogNative.writeCodeLog(logLevel.getIndex(), str, str2, str6);
        if (TLogInitializer.getInstance().getOnTrackTLogListener() != null) {
            try {
                TLogInitializer.getInstance().getOnTrackTLogListener().onTrackTLog(logLevel, str, str2, str6);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void logThrowable(LogLevel logLevel, String str, String str2, String str3) {
        if (TLogInitializer.getInstance().isDebugable()) {
            toLogcat(logLevel, str, str2, str3);
        }
        log(logLevel, str, str2, String.valueOf(LogCategory.CodeLog.getIndex()), "", "", str3);
    }

    public static void logd(String str, String str2, String str3) {
        log(LogLevel.D, str, str2, str3);
    }

    public static void loge(String str, String str2, String str3) {
        log(LogLevel.E, str, str2, str3);
    }

    public static void logi(String str, String str2, String str3) {
        log(LogLevel.I, str, str2, str3);
    }

    public static void logv(String str, String str2, String str3) {
        log(LogLevel.V, str, str2, str3);
    }

    public static void logw(String str, String str2, String str3) {
        log(LogLevel.W, str, str2, str3);
    }

    private static void toLogcat(LogLevel logLevel, String str, String str2, String str3) {
        int d;
        if (str3 == null) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "." + str2;
        }
        int i = AnonymousClass1.$SwitchMap$com$taobao$tao$log$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            d = Log.d(str2, str3);
        } else if (i == 2) {
            d = Log.i(str2, str3);
        } else if (i == 3) {
            d = Log.w(str2, str3);
        } else if (i != 4) {
            d = Log.v(str2, str3);
        } else {
            d = Log.e(str2, str3);
        }
        if (d == -100) {
            try {
                Log.class.getMethod(logLevel.getName().toLowerCase(), String.class, String.class).invoke(null, str2, str3);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public static void traceLog(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        log(LogLevel.F, "", "Trace", "T", str, str2, "NULL == log");
    }

    @Deprecated
    public static void logd(String str, String str2) {
        logd("", str, str2);
    }

    @Deprecated
    public static void loge(String str, String str2) {
        loge("", str, str2);
    }

    @Deprecated
    public static void logi(String str, String str2) {
        logi("", str, str2);
    }

    @Deprecated
    public static void logv(String str, String str2) {
        logv("", str, str2);
    }

    @Deprecated
    public static void logw(String str, String str2) {
        logw("", str, str2);
    }

    @Deprecated
    public static void logd(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logd("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logd("", str, sb.toString());
        }
    }

    @Deprecated
    public static void loge(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                loge("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            loge("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logi(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logi("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logi("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logv(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logv("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logv("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logw(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logw("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logw("", str, sb.toString());
        }
    }

    @Deprecated
    public static void loge(String str, String str2, Throwable th) {
        loge("", str, str2, th);
    }

    @Deprecated
    public static void logw(String str, String str2, Throwable th) {
        logw("", str, str2, th);
    }

    public static void loge(String str, String str2, String str3, Throwable th) {
        String exceptionMsg;
        if (th == null) {
            exceptionMsg = str3 + "******* NULL == e *******";
        } else {
            exceptionMsg = getExceptionMsg(str3, th);
        }
        logThrowable(LogLevel.E, str, str2, exceptionMsg);
    }

    public static void logw(String str, String str2, String str3, Throwable th) {
        String exceptionMsg;
        if (th == null) {
            exceptionMsg = str3 + "******* NULL == e *******";
        } else {
            exceptionMsg = getExceptionMsg(str3, th);
        }
        logThrowable(LogLevel.W, str, str2, exceptionMsg);
    }

    private static void log(LogLevel logLevel, String str, String str2, String str3) {
        if (TLogInitializer.getInstance().isDebugable()) {
            toLogcat(logLevel, str, str2, str3);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        log(logLevel, str, str2, String.valueOf(LogCategory.CodeLog.getIndex()), "", "", str3);
    }
}
