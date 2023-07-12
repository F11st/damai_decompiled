package com.ali.user.mobile.log;

import android.util.Log;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class TLogAdapter {
    private static final boolean DEBUG = Debuggable.isDebug();
    private static final String TAG_PREFIX = "LoginSDK_";
    private static boolean isTlogValid;

    static {
        try {
            isTlogValid = true;
        } catch (ClassNotFoundException unused) {
            isTlogValid = false;
        }
    }

    public static void d(String str, String str2) {
        if (DataProviderFactory.getDataProvider().getLoggerProxy() != null) {
            LoggerProxy loggerProxy = DataProviderFactory.getDataProvider().getLoggerProxy();
            loggerProxy.d(TAG_PREFIX + str, str2);
        } else if (isTlogValid) {
            AdapterForTLog.logd(TAG_PREFIX + str, str2);
        } else if (DEBUG) {
            Log.d(TAG_PREFIX + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (DataProviderFactory.getDataProvider().getLoggerProxy() != null) {
            LoggerProxy loggerProxy = DataProviderFactory.getDataProvider().getLoggerProxy();
            loggerProxy.e(TAG_PREFIX + str, str2, th);
        } else if (isTlogValid) {
            AdapterForTLog.loge(TAG_PREFIX + str, str2, th);
        } else if (DEBUG) {
            Log.e(TAG_PREFIX + str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (DataProviderFactory.getDataProvider().getLoggerProxy() != null) {
            LoggerProxy loggerProxy = DataProviderFactory.getDataProvider().getLoggerProxy();
            loggerProxy.i(TAG_PREFIX + str, str2);
        } else if (isTlogValid) {
            AdapterForTLog.logi(TAG_PREFIX + str, str2);
        } else if (DEBUG) {
            Log.i(TAG_PREFIX + str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (DataProviderFactory.getDataProvider().getLoggerProxy() != null) {
            LoggerProxy loggerProxy = DataProviderFactory.getDataProvider().getLoggerProxy();
            loggerProxy.w(TAG_PREFIX + str, str2);
        } else if (isTlogValid) {
            AdapterForTLog.logw(TAG_PREFIX + str, str2, th);
        } else if (DEBUG) {
            Log.w(TAG_PREFIX + str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (DataProviderFactory.getDataProvider().getLoggerProxy() != null) {
            LoggerProxy loggerProxy = DataProviderFactory.getDataProvider().getLoggerProxy();
            loggerProxy.e(TAG_PREFIX + str, str2);
        } else if (isTlogValid) {
            AdapterForTLog.loge(TAG_PREFIX + str, str2);
        } else if (DEBUG) {
            Log.e(TAG_PREFIX + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (DataProviderFactory.getDataProvider().getLoggerProxy() != null) {
            LoggerProxy loggerProxy = DataProviderFactory.getDataProvider().getLoggerProxy();
            loggerProxy.w(TAG_PREFIX + str, str2);
        } else if (isTlogValid) {
            AdapterForTLog.logw(TAG_PREFIX + str, str2);
        } else if (DEBUG) {
            Log.w(TAG_PREFIX + str, str2);
        }
    }

    public static void e(String str, Throwable th) {
        e(str, "", th);
    }

    public static void w(String str, Throwable th) {
        w(str, "", th);
    }
}
