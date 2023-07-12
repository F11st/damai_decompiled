package com.alibaba.analytics.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class Logger {
    private static String a = "Analytics";
    private static boolean b = false;
    private static boolean c = true;
    private static ILogger d;

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes5.dex */
    public interface ILog {
        int e(String str, String str2);

        int e(String str, String str2, Throwable th);
    }

    private static String a(String str, Map<String, String> map) {
        if (str == null && map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i = 0;
        objArr[0] = str;
        sb.append(String.format("[%s] ", objArr));
        if (map != null) {
            int size = map.size();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey() + " : " + entry.getValue());
                i++;
                if (i < size) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String b(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(j(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    private static String c() {
        String str;
        String str2;
        if (!b) {
            return a;
        }
        StackTraceElement k = k();
        str = "";
        if (k != null) {
            String className = k.getClassName();
            str = TextUtils.isEmpty(className) ? "" : className.substring(className.lastIndexOf(46) + 1);
            str2 = k.getMethodName();
        } else {
            str2 = "";
        }
        return "Analytics." + str + "." + str2;
    }

    public static void d() {
        if (p(4)) {
            d.logd(c(), b(null, new Object[0]));
        } else if (o()) {
            Log.d(c(), b(null, new Object[0]));
        }
    }

    public static void e(String str, Map<String, String> map) {
        if (p(4)) {
            d.logd(c(), a(str, map));
        } else if (o()) {
            Log.d(c(), a(str, map));
        }
    }

    public static void f(String str, Object... objArr) {
        if (p(4)) {
            d.logd(c(), b(str, objArr));
        } else if (o()) {
            Log.d(c(), b(str, objArr));
        }
    }

    public static void g() {
        if (p(1)) {
            d.loge(c(), b(null, new Object[0]));
        } else if (o()) {
            Log.e(c(), b(null, new Object[0]));
        }
    }

    public static void h(String str, Throwable th, Object... objArr) {
        if (p(1)) {
            d.loge(c(), b(str, objArr), th);
        } else if (o()) {
            Log.e(c(), b(str, objArr), th);
        }
    }

    public static void i(String str, Object... objArr) {
        if (p(1)) {
            d.loge(c(), b(str, objArr));
        } else if (o()) {
            Log.e(c(), b(str, objArr));
        }
    }

    private static String j(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    private static StackTraceElement k() {
        StackTraceElement[] stackTrace;
        if (b) {
            try {
                for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(Logger.class.getName())) {
                        return stackTraceElement;
                    }
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return null;
    }

    public static void l() {
        if (p(3)) {
            d.logi(c(), b(null, new Object[0]));
        } else if (o()) {
            Log.i(c(), b(null, new Object[0]));
        }
    }

    public static void m(String str, Object... objArr) {
        if (p(3)) {
            d.logi(c(), b(str, objArr));
        } else if (o()) {
            Log.i(c(), b(str, objArr));
        }
    }

    public static boolean n() {
        return b;
    }

    private static boolean o() {
        return b;
    }

    private static boolean p(int i) {
        ILogger iLogger = d;
        return iLogger != null && iLogger.isValid() && i < d.getLogLevel();
    }

    public static void q() {
        if (c) {
            d();
        }
    }

    public static void r(String str, Object... objArr) {
        if (c) {
            f(str, objArr);
        }
    }

    public static void s(boolean z) {
        b = z;
    }

    public static void t(ILogger iLogger) {
        d = iLogger;
    }

    public static void u(String str, Throwable th, Object... objArr) {
        if (p(2)) {
            d.logw(c(), b(str, objArr), th);
        } else if (o()) {
            Log.w(c(), b(str, objArr), th);
        }
    }

    public static void v(String str, Object... objArr) {
        if (p(2)) {
            d.logw(c(), b(str, objArr));
        } else if (o()) {
            Log.w(c(), b(str, objArr));
        }
    }
}
