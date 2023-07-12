package com.taobao.weex.utils;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.performance.WXStateRecord;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXLogUtils {
    public static final String WEEX_PERF_TAG = "weex_perf";
    public static final String WEEX_TAG = "weex";
    private static HashMap<String, Class> a;
    private static List<JsLogWatcher> b;
    private static LogWatcher c;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface JsLogWatcher {
        void onJsLog(int i, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface LogWatcher {
        void onLog(String str, String str2, String str3);
    }

    static {
        HashMap<String, Class> hashMap = new HashMap<>(2);
        a = hashMap;
        hashMap.put("com.taobao.weex.devtools.common.LogUtil", a("com.taobao.weex.devtools.common.LogUtil"));
        b = new ArrayList();
    }

    private static Class a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                a.put(str, cls);
                return cls;
            } catch (ClassNotFoundException unused) {
                return cls;
            }
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private static void b(String str, String str2, LogLevel logLevel) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || logLevel == null || TextUtils.isEmpty(logLevel.getName())) {
            return;
        }
        if (logLevel == LogLevel.ERROR && !TextUtils.isEmpty(str2) && str2.contains("IPCException")) {
            WXStateRecord.d().l("ipc", str2);
        }
        LogWatcher logWatcher = c;
        if (logWatcher != null) {
            logWatcher.onLog(logLevel.getName(), str, str2);
        }
        if (WXEnvironment.isApkDebugable()) {
            if (logLevel.getValue() - WXEnvironment.sLogLevel.getValue() >= 0) {
                Log.println(logLevel.getPriority(), str, str2);
                c(logLevel.getName(), str2);
            }
        } else if (logLevel.getValue() - LogLevel.WARN.getValue() < 0 || logLevel.getValue() - WXEnvironment.sLogLevel.getValue() < 0) {
        } else {
            Log.println(logLevel.getPriority(), str, str2);
        }
    }

    private static void c(String str, String str2) {
        if (WXEnvironment.isApkDebugable()) {
            try {
                Class cls = a.get("com.taobao.weex.devtools.common.LogUtil");
                if (cls != null) {
                    cls.getMethod(DumpManager.LOG_PATH, String.class, String.class).invoke(cls, str, str2);
                }
            } catch (Exception unused) {
                Log.d("weex", "LogUtil not found!");
            }
        }
    }

    public static void d(String str) {
        d("weex", str);
    }

    public static void e(String str) {
        e("weex", str);
    }

    public static void eTag(String str, Throwable th) {
        if (WXEnvironment.isApkDebugable()) {
            e(str, getStackTrace(th));
        }
    }

    public static String getStackTrace(@Nullable Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter;
        if (th == null) {
            return "";
        }
        StringWriter stringWriter2 = null;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
            } catch (Throwable th2) {
                th = th2;
                printWriter = null;
            }
        } catch (Throwable th3) {
            th = th3;
            printWriter = null;
        }
        try {
            th.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            try {
                stringWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.close();
            return stringWriter.toString();
        } catch (Throwable th4) {
            th = th4;
            stringWriter2 = stringWriter;
            if (stringWriter2 != null) {
                try {
                    stringWriter2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (printWriter != null) {
                printWriter.close();
            }
            throw th;
        }
    }

    public static void i(String str) {
        i("weex", str);
    }

    public static void info(String str) {
        i("weex", str);
    }

    public static void p(String str) {
        d(WEEX_PERF_TAG, str);
    }

    public static void performance(String str, byte[] bArr) {
    }

    public static void renderPerformanceLog(String str, long j) {
        if (WXEnvironment.isApkDebugable()) {
            return;
        }
        WXEnvironment.isPerf();
    }

    public static void setJsLogWatcher(JsLogWatcher jsLogWatcher) {
        if (b.contains(jsLogWatcher)) {
            return;
        }
        b.add(jsLogWatcher);
    }

    public static void setLogWatcher(LogWatcher logWatcher) {
        c = logWatcher;
    }

    public static void v(String str) {
        v("weex", str);
    }

    public static void w(String str) {
        w("weex", str);
    }

    public static void wtf(String str) {
        wtf("weex", str);
    }

    public static void d(String str, byte[] bArr) {
        d(str, new String(bArr));
    }

    public static void e(String str, byte[] bArr) {
        e(str, new String(bArr));
    }

    public static void i(String str, byte[] bArr) {
        i(str, new String(bArr));
    }

    public static void p(String str, Throwable th) {
        if (WXEnvironment.isApkDebugable()) {
            p(str + getStackTrace(th));
        }
    }

    public static void v(String str, String str2) {
        b(str, str2, LogLevel.VERBOSE);
    }

    public static void w(String str, byte[] bArr) {
        w(str, new String(bArr));
    }

    public static void wtf(String str, String str2) {
        b(str, str2, LogLevel.WTF);
    }

    public static void d(String str, String str2) {
        List<JsLogWatcher> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        b(str, str2, LogLevel.DEBUG);
        if (!WXEnvironment.isApkDebugable() || !"jsLog".equals(str) || (list = b) == null || list.size() <= 0) {
            return;
        }
        for (JsLogWatcher jsLogWatcher : b) {
            if (str2.endsWith("__DEBUG")) {
                jsLogWatcher.onJsLog(3, str2.replace("__DEBUG", ""));
            } else if (str2.endsWith("__INFO")) {
                jsLogWatcher.onJsLog(3, str2.replace("__INFO", ""));
            } else if (str2.endsWith("__WARN")) {
                jsLogWatcher.onJsLog(3, str2.replace("__WARN", ""));
            } else if (str2.endsWith("__ERROR")) {
                jsLogWatcher.onJsLog(3, str2.replace("__ERROR", ""));
            } else {
                jsLogWatcher.onJsLog(3, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        b(str, str2, LogLevel.ERROR);
    }

    public static void i(String str, String str2) {
        b(str, str2, LogLevel.INFO);
    }

    public static void v(String str, Throwable th) {
        if (WXEnvironment.isApkDebugable()) {
            v(str + getStackTrace(th));
        }
    }

    public static void w(String str, String str2) {
        b(str, str2, LogLevel.WARN);
    }

    public static void wtf(String str, Throwable th) {
        if (WXEnvironment.isApkDebugable()) {
            wtf(str + getStackTrace(th));
        }
    }

    public static void e(String str, Throwable th) {
        e(str + getStackTrace(th));
    }

    public static void i(String str, Throwable th) {
        if (WXEnvironment.isApkDebugable()) {
            info(str + getStackTrace(th));
        }
    }

    public static void w(String str, Throwable th) {
        w(str + getStackTrace(th));
    }

    public static void d(String str, Throwable th) {
        if (WXEnvironment.isApkDebugable()) {
            d(str + getStackTrace(th));
        }
    }
}
