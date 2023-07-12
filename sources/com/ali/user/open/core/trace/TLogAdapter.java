package com.ali.user.open.core.trace;

import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class TLogAdapter {
    public static void d(String str, String str2) {
        AdapterForTLog.logd(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        AdapterForTLog.loge(str, str2, th);
    }

    public static void i(String str, String str2) {
        AdapterForTLog.logi(str, str2);
    }

    public static void w(String str, String str2) {
        AdapterForTLog.logw(str, str2);
    }

    public static void e(String str, String str2) {
        AdapterForTLog.loge(str, str2);
    }

    public static void e(String str, Throwable th) {
        e(str, "", th);
    }
}
