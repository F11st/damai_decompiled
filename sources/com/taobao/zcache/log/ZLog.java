package com.taobao.zcache.log;

import android.content.Context;
import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.RVLLog;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class ZLog {
    @Deprecated
    public static void d(String str) {
    }

    public static void d(String str, String str2) {
        RVLLog.e(RVLLevel.Debug, str, str2);
    }

    @Deprecated
    public static void e(String str) {
    }

    public static void e(String str, String str2) {
        RVLLog.e(RVLLevel.Error, str, str2);
    }

    @Deprecated
    public static void i(String str) {
    }

    public static void i(String str, String str2) {
        RVLLog.e(RVLLevel.Info, str, str2);
    }

    @Deprecated
    public static void init(Context context) {
    }

    @Deprecated
    public static void setLogImpl(Object obj) {
    }

    @Deprecated
    public static void v(String str) {
    }

    public static void v(String str, String str2) {
        RVLLog.e(RVLLevel.Verbose, str, str2);
    }

    @Deprecated
    public static void w(String str) {
    }

    public static void w(String str, String str2) {
        RVLLog.e(RVLLevel.Warn, str, str2);
    }
}
