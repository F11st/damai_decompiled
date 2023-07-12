package com.tencent.stat.common;

import android.util.Log;
import com.tencent.stat.StatConfig;
import org.apache.commons.net.SocketClient;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class StatLogger {
    private boolean debugEnable;
    private int logLevel;
    private String tag;

    public StatLogger() {
        this.tag = "default";
        this.debugEnable = true;
        this.logLevel = 2;
    }

    public StatLogger(String str) {
        this.tag = "default";
        this.debugEnable = true;
        this.logLevel = 2;
        this.tag = str;
    }

    private String getLoggerClassInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(StatLogger.class.getName())) {
                return jn1.ARRAY_START_STR + Thread.currentThread().getName() + jn1.BRACKET_START_STR + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + jn1.ARRAY_END_STR;
            }
        }
        return null;
    }

    public void d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public void debug(Object obj) {
        String str;
        if (this.logLevel <= 3) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                str = loggerClassInfo + " - " + obj;
            }
            Log.d(this.tag, str);
        }
    }

    public void e(Exception exc) {
        if (StatConfig.isDebugEnable()) {
            error(exc);
        }
    }

    public void e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    public void error(Exception exc) {
        if (this.logLevel <= 6) {
            StringBuffer stringBuffer = new StringBuffer();
            String loggerClassInfo = getLoggerClassInfo();
            StackTraceElement[] stackTrace = exc.getStackTrace();
            stringBuffer.append(loggerClassInfo != null ? loggerClassInfo + " - " + exc + SocketClient.NETASCII_EOL : exc + SocketClient.NETASCII_EOL);
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        stringBuffer.append("[ " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + " ]\r\n");
                    }
                }
            }
            Log.e(this.tag, stringBuffer.toString());
        }
    }

    public void error(Object obj) {
        String str;
        if (this.logLevel <= 6) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                str = loggerClassInfo + " - " + obj;
            }
            Log.e(this.tag, str);
        }
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public void i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public void info(Object obj) {
        String str;
        if (this.logLevel <= 4) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                str = loggerClassInfo + " - " + obj;
            }
            Log.i(this.tag, str);
        }
    }

    public boolean isDebugEnable() {
        return this.debugEnable;
    }

    public void setDebugEnable(boolean z) {
        this.debugEnable = z;
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public void verbose(Object obj) {
        String str;
        if (this.logLevel <= 2) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                str = loggerClassInfo + " - " + obj;
            }
            Log.v(this.tag, str);
        }
    }

    public void w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public void warn(Object obj) {
        String str;
        if (this.logLevel <= 5) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                str = loggerClassInfo + " - " + obj;
            }
            Log.w(this.tag, str);
        }
    }
}
