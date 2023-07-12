package com.uc.webview.export.internal.utility;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public class Log {
    private Log() {
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static boolean enableUCLogger() {
        return com.uc.webview.export.cyclone.Log.enabled();
    }

    public static void flushCachedLogs(StringBuffer stringBuffer) {
        com.uc.webview.export.cyclone.Log.flushCachedLogs(stringBuffer);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void setPrintLog(boolean z, Object[] objArr) {
        if (objArr == null || objArr.length != 5) {
            return;
        }
        Boolean bool = (Boolean) objArr[1];
        com.uc.webview.export.cyclone.Log.setup(z, bool != null ? bool.booleanValue() : false, (ValueCallback) objArr[2]);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        com.uc.webview.export.cyclone.Log.d(str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        com.uc.webview.export.cyclone.Log.e(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        com.uc.webview.export.cyclone.Log.i(str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        com.uc.webview.export.cyclone.Log.w(str, str2, th);
    }
}
