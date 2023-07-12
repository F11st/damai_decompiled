package android.taobao.windvane.monitor;

import android.net.Uri;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.huawei.hms.opendevice.AbstractC5658c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.orange.OConstant;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.ui.module.WXDomModule;
import com.vivo.push.PushClientConstants;
import tb.h23;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AppMonitorUtil {
    public static final String JS_ERROR_POINT = "JavaScriptError";
    public static final String MONITOR_MATCH_URL_FAILED = "urlMatchFailed";
    private static final String MONITOR_MODULE = "WindVane";
    private static final String MONITOR_MODULE_ZCache = "ZCache";
    public static final String MONITOR_POINT_CORE_INIT_TIME = "CoreInitTime";
    public static final String MONITOR_POINT_CORE_TYPE_BY_PV = "CoreTypeByPV";
    public static final String MONITOR_POINT_DIURNAL_OVERVIEW = "DiurnalOverview";
    public static final String MONITOR_POINT_FSP_TIME = "FSP";
    public static final String MONITOR_POINT_GPU_PROCESS_GONE_TYPE = "GpuProcessGone";
    private static final String MONITOR_POINT_INSECURITY_HOST = "insecurityHost";
    private static final String MONITOR_POINT_JS_BRIDGE_RETURN = "JSBridgeReturn";
    public static final String MONITOR_POINT_MULTI_PROCESS = "MultiProcess";
    public static final String MONITOR_POINT_MULTI_PROCESS_BY_PV = "MultiProcessByPV";
    private static final String MONITOR_POINT_OFF_MONITOR = "OffMonitor";
    private static final String MONITOR_POINT_PACKAGEAPP = "PackageApp";
    private static final String MONITOR_POINT_PACKAGEAPP_UPDATE_START = "PackageUpdateStart";
    private static final String MONITOR_POINT_PACKAGEAPP_VISIT = "PackageAppVisit";
    private static final String MONITOR_POINT_PACKAGEAPP_VISIT_START = "PackageVisitStart";
    private static final String MONITOR_POINT_PACKAGEQUEUE = "PackageQueue";
    private static final String MONITOR_POINT_PACKAGE_CLEANUP = "PackageCleanUp";
    private static final String MONITOR_POINT_PACKAGE_WARNING = "PackageWarning";
    private static final String MONITOR_POINT_PAGE_EMPTY = "PageEmpty";
    public static final String MONITOR_POINT_PARAM_PARSE_ERROR = "ParamParseError";
    private static final String MONITOR_POINT_PERFORMANCE = "H5";
    private static final String MONITOR_POINT_PERFORMANCE_2 = "H5_2";
    private static final String MONITOR_POINT_PERFORMANCE_3 = "H5_3";
    private static final String MONITOR_POINT_PERFORMANCE_4 = "H5_4";
    private static final String MONITOR_POINT_PERFORMANCE_5 = "H5_5";
    private static final String MONITOR_POINT_RESOURCE_SIZE = "ResourceSize";
    private static final String MONITOR_POINT_SECURITY_WARNING = "SecurityWarning";
    private static final String MONITOR_POINT_STATUS_CODE = "StatusCode";
    private static final String MONITOR_POINT_UNZIP_ERROR = "UnzipError";
    private static final String MONITOR_POINT_UPDATE_CONFIG_INFO = "Config";
    public static final String MONITOR_POINT_URL_CONFIG_FILTER_TYPE = "UrlConfigFilterType";
    public static final String MONITOR_POINT_URL_CONFIG_JS_API_TYPE = "UrlConfigJsApiType";
    private static final String MONITOR_POINT_USE_WEBGL = "UseWebGl";
    private static final String MONITOR_POINT_WEBVIEW_START = "WebViewStart";
    public static final String MONITOR_POINT_WEBVIEW_WRAP_TYPE = "WebViewWrapType";
    public static final String MONITOR_POINT_WEB_CORE_TYPE = "WebViewCoreType";
    public static final String MONITOR_POINT_WEB_CORE_TYPE_BY_PV = "WebViewCoreTypeByPV";
    private static final String MONITOR_POINT_WEB_PERFORMANCE_CHECK = "WebPerformanceCheck";
    private static final String MONITOR_POINT_WRONG_FOLDER_INDEX = "WrongFolderIndex";
    private static final String MONITOR_POINT_WVUCWEBVIEW = "WVUcwebview";
    public static final String MONITOR_POINT_WV_INIT_TIME = "WVInitTime";
    public static final String MONITOR_POINT_ZCACHE_DOWNLOAD_TIME = "ZCacheDownLoadTime";
    public static final String MONITOR_POINT_ZCACHE_RESPONSE_TIME_OUT = "ZcacheResponseTime";
    public static final String NATIVE_ERROR_POINT = "NativeError";
    public static boolean OFF = false;
    private static final String TAG = "AppMonitorUtil";
    private static boolean isAppMonitorEnabled;

    public static void commitConifgUpdateError(String str, int i, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", "Config", str, Integer.toString(i), str2);
    }

    public static void commitConifgUpdateInfo(String str, int i, long j, int i2, int i3) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("name", str);
            create.setValue("from", Integer.toString(i));
            create.setValue("isSuccess", Integer.toString(i2));
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("updateTime", j);
            create2.setValue("updateCount", i3);
            AppMonitor.Stat.commit("WindVane", "Config", create, create2);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor exception");
        }
    }

    public static void commitConifgUpdateSuccess(String str) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitSuccess("WindVane", "Config", str);
    }

    public static void commitCoreInitTime(long j, String str) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("fromType", str);
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("initTime", j);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_CORE_INIT_TIME, create, create2);
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor commitCoreInitTime exception");
        }
    }

    public static void commitCoreTypeByPV(String str, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("fromType", str);
            create.setValue("coreType", str2);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_CORE_TYPE_BY_PV, create, MeasureValueSet.create());
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor commitCoreTypeByPV exception");
        }
    }

    public static void commitEmptyPage(String str, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        TaoLog.w(TAG, "Webview commitEmptyPage : " + str);
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_PAGE_EMPTY, str, OConstant.CODE_POINT_EXP_BIND_SERVICE, str2);
    }

    public static void commitFSPInfo(String str, long j) {
        if (str == null || j == 0) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("URL", str);
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("time", j);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_FSP_TIME, create, create2);
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor paramParseError exception");
        }
    }

    public static void commitFail(String str, int i, String str2, String str3) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", str, str3, Integer.toString(i), str2);
    }

    public static void commitInSecurityHost(String str) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_INSECURITY_HOST, OConstant.CODE_POINT_EXP_BIND_SERVICE, str);
    }

    public static void commitJsBridgeReturn(String str, String str2, String str3, String str4) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("name", str);
            create.setValue("ret", str2);
            create.setValue("message", str3);
            create.setValue("url", str4);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_JS_BRIDGE_RETURN, create, MeasureValueSet.create());
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor commitJsBridgeReturn exception");
        }
    }

    public static void commitOffMonitor(String str, String str2, String str3) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_OFF_MONITOR, str2, str3, str);
    }

    public static void commitPackageAppUpdateError(String str, String str2, String str3) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_PACKAGEAPP, str3, str, str2);
    }

    public static void commitPackageAppUpdateInfo(ZipAppInfo zipAppInfo, String str, String str2, long j, long j2, long j3, long j4) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("appName", zipAppInfo.name);
            create.setValue("version", zipAppInfo.v);
            create.setValue("seq", String.valueOf(zipAppInfo.s));
            create.setValue("online", str);
            create.setValue("networkSupport", str2);
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("updateTime", j);
            create2.setValue("downloadTime", j2);
            create2.setValue("publishTime", j3);
            create2.setValue("notificationTime", j4);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_PACKAGEAPP, create, create2);
            TaoLog.i(TAG, "app publishTime : " + j3 + " online : " + str);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor exception");
        }
    }

    public static void commitPackageAppUpdateSuccess(String str) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitSuccess("WindVane", MONITOR_POINT_PACKAGEAPP, str);
    }

    public static void commitPackageAppVisitError(String str, String str2, String str3) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_PACKAGEAPP_VISIT, str, str3, str2);
    }

    public static void commitPackageAppWarning(String str, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_PACKAGE_WARNING, str, "1", str2);
    }

    public static void commitPackageClearUpInfo(long j, int i, int i2, int i3, float f, int i4, int i5, float f2, int i6) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("cleanCause", String.valueOf(i6));
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("beforeDelSpace", j);
            create2.setValue("expectedNum", i);
            create2.setValue("installedNum", i2);
            create2.setValue("willDeleteCount", i3);
            create2.setValue("customRadio", f);
            create2.setValue("noCacheCount", i4);
            create2.setValue("normalCount", i5);
            create2.setValue("noCacheRatio", f2);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_PACKAGE_CLEANUP, create, create2);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitPackageClearUpInfo exception");
        }
    }

    public static void commitPackageQueueInfo(String str, long j, long j2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            if (!TextUtils.isEmpty(str)) {
                create.setValue("isInitialUpdate", str);
            }
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("updateCount", j);
            create2.setValue(h23.POINT_SUCCESS_COUNT_MEASURE, j2);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_PACKAGEQUEUE, create, create2);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitPackageQueueInfo exception");
        }
    }

    public static void commitPackageUpdateStartInfo(long j, long j2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("t_startTime", j);
            create2.setValue("t_endTime", j2);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_PACKAGEAPP_UPDATE_START, create, create2);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitPackageUpdateStartInfo exception");
        }
    }

    public static void commitPackageVisitInfo(String str, String str2, long j, long j2, long j3, long j4, long j5) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(PushClientConstants.TAG_PKG_NAME, str);
            create.setValue("hasVerifyTime", str2);
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("time", j);
            create2.setValue("matchTime", j2);
            create2.setValue("readTime", j3);
            create2.setValue("verifyTime", j4);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_PACKAGEAPP_VISIT, create, create2);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitPackageVisitInfo exception");
        }
    }

    public static void commitPackageVisitStartInfo(String str, long j) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(PushClientConstants.TAG_PKG_NAME, str);
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("time", j);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_PACKAGEAPP_VISIT_START, create, create2);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitPackageVisitStartInfo exception");
        }
    }

    public static void commitPackageVisitSuccess(String str, long j) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            AppMonitor.Alarm.commitSuccess("WindVane", MONITOR_POINT_PACKAGEAPP_VISIT, str + "-" + j);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitPackageVisitSuccess exception");
        }
    }

    public static void commitParamParseError(String str, String str2, String str3, String str4) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(MtopJSBridge.MtopJSParam.PAGE_URL, str);
            create.setValue("crashInfo", str2);
            create.setValue("params", str3);
            create.setValue(WXDomModule.INVOKE_METHOD, str4);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_PARAM_PARSE_ERROR, create, MeasureValueSet.create());
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor paramParseError exception");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void commitPerformanceInfo(android.taobao.windvane.monitor.WVMonitorData r20) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.monitor.AppMonitorUtil.commitPerformanceInfo(android.taobao.windvane.monitor.WVMonitorData):void");
    }

    public static void commitRenderType(String str, String str2, String str3, String str4) {
        if (WVCommonConfig.commonConfig.monitorStatus != 0 && isAppMonitorEnabled) {
            try {
                DimensionValueSet create = DimensionValueSet.create();
                create.setValue("url", str);
                create.setValue("r_type", str2);
                create.setValue("process_mode", str3);
                create.setValue("background", str4);
                AppMonitor.Stat.commit("WindVane", MONITOR_POINT_MULTI_PROCESS, create, MeasureValueSet.create());
            } catch (Throwable unused) {
            }
        }
    }

    public static void commitRenderTypeByPV(String str, String str2, String str3, String str4, String str5, String str6) {
        if (WVCommonConfig.commonConfig.monitorStatus != 0 && isAppMonitorEnabled) {
            try {
                DimensionValueSet create = DimensionValueSet.create();
                create.setValue("web_init_mode", str);
                create.setValue("web_succ_mode", str2);
                create.setValue("web_succ_reason", str3);
                create.setValue("gpu_init_mode", str4);
                create.setValue("gpu_succ_mode", str5);
                create.setValue("gpu_succ_reason", str6);
                AppMonitor.Stat.commit("WindVane", MONITOR_POINT_MULTI_PROCESS_BY_PV, create, MeasureValueSet.create());
            } catch (Throwable unused) {
            }
        }
    }

    public static void commitResourceSize(String str, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_RESOURCE_SIZE, str, "1", str2);
    }

    public static void commitSecurityWarning(String str, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_SECURITY_WARNING, str2, OConstant.CODE_POINT_EXP_BIND_SERVICE, str);
    }

    public static void commitStartTimeInfo(String str, long j) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            if (!TextUtils.isEmpty(str)) {
                create.setValue("url", WVUrlUtil.removeQueryParam(str));
            }
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("time", j);
            TaoLog.i(TAG, "Webview start after : " + j + "ms, url : " + WVUrlUtil.removeQueryParam(str));
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_WEBVIEW_START, create, create2);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitStartTimeInfo exception");
        }
    }

    public static void commitStatusCode(String str, String str2, String str3, String str4, String str5) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("url", str);
            create.setValue("isHTML", str4);
            create.setValue(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, str3);
            create.setValue("referrer", str2);
            create.setValue("bizCode", str5);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_STATUS_CODE, create, MeasureValueSet.create());
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitStatusCode exception");
        }
    }

    public static void commitSuccess(String str, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitSuccess("WindVane", str, str2);
    }

    public static void commitUCWebviewError(String str, String str2, String str3) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        AppMonitor.Alarm.commitFail("WindVane", MONITOR_POINT_WVUCWEBVIEW, str3, str, str2);
    }

    public static void commitUseWebgl(String str) {
        if (WVCommonConfig.commonConfig.monitorStatus != 0 && isAppMonitorEnabled) {
            try {
                DimensionValueSet create = DimensionValueSet.create();
                Uri parse = Uri.parse(str);
                create.setValue("url", parse.getHost() + parse.getPath());
                AppMonitor.Stat.commit("WindVane", MONITOR_POINT_USE_WEBGL, create, MeasureValueSet.create());
            } catch (Throwable unused) {
            }
        }
    }

    public static void commitWVInitTime(long j, long j2) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            MeasureValueSet create = MeasureValueSet.create();
            create.setValue("tbInitTime", j2);
            create.setValue("wvInitTime", j);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_WV_INIT_TIME, DimensionValueSet.create(), create);
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor commitWVInitTime exception");
        }
    }

    public static void commitWVWrapType(String str) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("type", str);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_WEBVIEW_WRAP_TYPE, create, MeasureValueSet.create());
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor commitWVWrapType exception");
        }
    }

    public static void commitWebPerfCheckInfo(String str, long j, String str2, String str3, String str4) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("url", str);
            create.setValue("version", str2);
            create.setValue("bizcode", str3);
            create.setValue("result", str4);
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("score", j);
            AppMonitor.Stat.commit("WindVane", MONITOR_POINT_WEB_PERFORMANCE_CHECK, create, create2);
        } catch (Exception unused) {
            TaoLog.i(TAG, "AppMonitor commitPackageUpdateStartInfo exception");
        }
    }

    public static void commitZCacheDiurnalOverview(String str) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("installedApps", str);
            AppMonitor.Stat.commit(MONITOR_MODULE_ZCache, MONITOR_POINT_DIURNAL_OVERVIEW, create, MeasureValueSet.create());
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor commitZCacheDiurnalOverview exception");
        }
    }

    public static void commitZCacheDownLoadTime(String str, long j, long j2, long j3, String str2, boolean z) {
        if (WVCommonConfig.commonConfig.monitorStatus == 0 || !isAppMonitorEnabled) {
            return;
        }
        try {
            MeasureValueSet create = MeasureValueSet.create();
            create.setValue("zcacheDownLoadTime", j2);
            create.setValue("zcacheTaskTime", j3);
            create.setValue(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, j);
            DimensionValueSet create2 = DimensionValueSet.create();
            create2.setValue("appName", str);
            create2.setValue("msg", str2);
            create2.setValue("isSuccess", z ? "true" : "false");
            AppMonitor.Stat.commit(MONITOR_MODULE_ZCache, MONITOR_POINT_ZCACHE_DOWNLOAD_TIME, create2, create);
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor commitZCacheDownLoadTime exception");
        }
    }

    private static Measure createMeasuerWithRange(String str, double d, double d2) {
        Measure measure = new Measure(str);
        measure.setRange(Double.valueOf(d), Double.valueOf(d2));
        return measure;
    }

    public static void init() {
        try {
            isAppMonitorEnabled = false;
            DimensionSet create = DimensionSet.create();
            create.addDimension("isInitialUpdate");
            MeasureSet create2 = MeasureSet.create();
            create2.addMeasure(createMeasuerWithRange("updateCount", 0.1d, 900.0d));
            create2.addMeasure(createMeasuerWithRange(h23.POINT_SUCCESS_COUNT_MEASURE, 0.1d, 900.0d));
            AppMonitor.register("WindVane", MONITOR_POINT_PACKAGEQUEUE, create2, create);
            DimensionSet create3 = DimensionSet.create();
            create3.addDimension(PushClientConstants.TAG_PKG_NAME);
            create3.addDimension("hasVerifyTime");
            MeasureSet create4 = MeasureSet.create();
            create4.addMeasure(createMeasuerWithRange("time", 0.0d, 60000.0d));
            create4.addMeasure(createMeasuerWithRange("matchTime", 0.0d, 60000.0d));
            create4.addMeasure(createMeasuerWithRange("readTime", 0.0d, 60000.0d));
            create4.addMeasure(createMeasuerWithRange("verifyTime", 0.0d, 60000.0d));
            AppMonitor.register("WindVane", MONITOR_POINT_PACKAGEAPP_VISIT, create4, create3);
            DimensionSet create5 = DimensionSet.create();
            create5.addDimension("url");
            create5.addDimension("version");
            create5.addDimension("bizcode");
            create5.addDimension("result");
            MeasureSet create6 = MeasureSet.create();
            create6.addMeasure(createMeasuerWithRange("score", 0.0d, 100.0d));
            AppMonitor.register("WindVane", MONITOR_POINT_WEB_PERFORMANCE_CHECK, create6, create5);
            DimensionSet create7 = DimensionSet.create();
            create7.addDimension(PushClientConstants.TAG_PKG_NAME);
            MeasureSet create8 = MeasureSet.create();
            create8.addMeasure(createMeasuerWithRange("time", 0.0d, 4.32E7d));
            AppMonitor.register("WindVane", MONITOR_POINT_PACKAGEAPP_VISIT_START, create8, create7);
            DimensionSet create9 = DimensionSet.create();
            MeasureSet create10 = MeasureSet.create();
            create10.addMeasure(createMeasuerWithRange("t_startTime", 0.0d, 4.32E7d));
            create10.addMeasure(createMeasuerWithRange("t_endTime", 0.0d, 4.32E7d));
            AppMonitor.register("WindVane", MONITOR_POINT_PACKAGEAPP_UPDATE_START, create10, create9);
            DimensionSet create11 = DimensionSet.create();
            create11.addDimension("cleanCause");
            MeasureSet create12 = MeasureSet.create();
            create12.addMeasure("beforeDelSpace");
            create12.addMeasure("expectedNum");
            create12.addMeasure("installedNum");
            create12.addMeasure("willDeleteCount");
            create12.addMeasure("customRadio");
            create12.addMeasure("noCacheCount");
            create12.addMeasure("normalCount");
            create12.addMeasure("noCacheRatio");
            AppMonitor.register("WindVane", MONITOR_POINT_PACKAGE_CLEANUP, create12, create11);
            DimensionSet create13 = DimensionSet.create();
            create13.addDimension("url");
            MeasureSet create14 = MeasureSet.create();
            create14.addMeasure(createMeasuerWithRange("time", 0.0d, 1800000.0d));
            AppMonitor.register("WindVane", MONITOR_POINT_WEBVIEW_START, create14, create13);
            DimensionSet create15 = DimensionSet.create();
            create15.addDimension("name");
            create15.addDimension("from");
            create15.addDimension("isSuccess");
            MeasureSet create16 = MeasureSet.create();
            create16.addMeasure(createMeasuerWithRange("updateTime", 0.0d, 600000.0d));
            create16.addMeasure(createMeasuerWithRange("updateCount", 0.0d, 1000.0d));
            AppMonitor.register("WindVane", "Config", create16, create15);
            DimensionSet create17 = DimensionSet.create();
            create17.addDimension("url");
            create17.addDimension("isHTML");
            create17.addDimension(HiAnalyticsConstant.HaKey.BI_KEY_RESULT);
            create17.addDimension("referrer");
            create17.addDimension("bizCode");
            AppMonitor.register("WindVane", MONITOR_POINT_STATUS_CODE, MeasureSet.create(), create17);
            DimensionSet create18 = DimensionSet.create();
            create18.addDimension("appName");
            create18.addDimension("version");
            create18.addDimension("seq");
            create18.addDimension("online");
            create18.addDimension("networkSupport");
            MeasureSet create19 = MeasureSet.create();
            create19.addMeasure(createMeasuerWithRange("updateTime", 0.0d, 600000.0d));
            create19.addMeasure(createMeasuerWithRange("downloadTime", 0.0d, 600000.0d));
            create19.addMeasure(createMeasuerWithRange("publishTime", 0.0d, 6.048E8d));
            create19.addMeasure(createMeasuerWithRange("notificationTime", 0.0d, 6.048E8d));
            AppMonitor.register("WindVane", MONITOR_POINT_PACKAGEAPP, create19, create18);
            DimensionSet create20 = DimensionSet.create();
            create20.addDimension("name");
            create20.addDimension("ret");
            create20.addDimension("msg");
            create20.addDimension("url");
            AppMonitor.register("WindVane", MONITOR_POINT_JS_BRIDGE_RETURN, MeasureSet.create(), create20);
            MeasureSet create21 = MeasureSet.create();
            create21.addMeasure("tbInitTime");
            create21.addMeasure("wvInitTime");
            AppMonitor.register("WindVane", MONITOR_POINT_WV_INIT_TIME, create21);
            DimensionSet create22 = DimensionSet.create();
            create22.addDimension("installedApps");
            AppMonitor.register(MONITOR_MODULE_ZCache, MONITOR_POINT_DIURNAL_OVERVIEW, MeasureSet.create(), create22);
            MeasureSet create23 = MeasureSet.create();
            create23.addMeasure("zcacheDownLoadTime");
            create23.addMeasure("zcacheTaskTime");
            create23.addMeasure(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME);
            DimensionSet create24 = DimensionSet.create();
            create24.addDimension("appName");
            create24.addDimension("msg");
            create24.addDimension("isSuccess");
            AppMonitor.register(MONITOR_MODULE_ZCache, MONITOR_POINT_ZCACHE_DOWNLOAD_TIME, create23, create24);
            DimensionSet create25 = DimensionSet.create();
            create25.addDimension("type");
            AppMonitor.register("WindVane", MONITOR_POINT_WEBVIEW_WRAP_TYPE, MeasureSet.create(), create25);
            DimensionSet create26 = DimensionSet.create();
            create26.addDimension("fromType");
            MeasureSet create27 = MeasureSet.create();
            create27.addMeasure("initTime");
            AppMonitor.register("WindVane", MONITOR_POINT_CORE_INIT_TIME, create27, create26);
            DimensionSet create28 = DimensionSet.create();
            create28.addDimension("fromType");
            create28.addDimension("coreType");
            AppMonitor.register("WindVane", MONITOR_POINT_CORE_TYPE_BY_PV, MeasureSet.create(), create28);
            DimensionSet create29 = DimensionSet.create();
            create29.addDimension("url");
            create29.addDimension("r_type");
            create29.addDimension("process_mode");
            create29.addDimension("background");
            AppMonitor.register("WindVane", MONITOR_POINT_MULTI_PROCESS, MeasureSet.create(), create29);
            DimensionSet create30 = DimensionSet.create();
            create30.addDimension(MtopJSBridge.MtopJSParam.PAGE_URL);
            create30.addDimension("crashInfo");
            create30.addDimension("params");
            create30.addDimension(WXDomModule.INVOKE_METHOD);
            AppMonitor.register("WindVane", MONITOR_POINT_PARAM_PARSE_ERROR, MeasureSet.create(), create30);
            DimensionSet create31 = DimensionSet.create();
            create31.addDimension("url");
            AppMonitor.register("WindVane", MONITOR_POINT_USE_WEBGL, MeasureSet.create(), create31);
            DimensionSet create32 = DimensionSet.create();
            create32.addDimension("web_init_mode");
            create32.addDimension("web_succ_mode");
            create32.addDimension("web_succ_reason");
            create32.addDimension("gpu_succ_mode");
            create32.addDimension("gpu_succ_mode");
            create32.addDimension("gpu_succ_reason");
            AppMonitor.register("WindVane", MONITOR_POINT_MULTI_PROCESS_BY_PV, MeasureSet.create(), create29);
            DimensionSet create33 = DimensionSet.create();
            create33.addDimension("url");
            create33.addDimension("via");
            create33.addDimension(PushClientConstants.TAG_PKG_NAME);
            create33.addDimension("pkgVersion");
            create33.addDimension("pkgSeq");
            create33.addDimension("fromType");
            create33.addDimension("protocolType");
            create33.addDimension("hasInit");
            create33.addDimension("isFinished");
            create33.addDimension(HiAnalyticsConstant.HaKey.BI_KEY_RESULT);
            create33.addDimension("verifyError");
            create33.addDimension("inMainProcess");
            MeasureSet create34 = MeasureSet.create();
            create34.addMeasure(createMeasuerWithRange("verifyResTime", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("verifyTime", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("verifyCacheSize", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("allVerifyTime", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("initTime", 0.0d, 60000.0d));
            create34.addMeasure(createMeasuerWithRange("tcp", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("ssl", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("firstByte", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("domLoad", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("pageLoad", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange(AbstractC5658c.a, 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("dc", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("dcl", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("dl", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange(BaseMonitor.COUNT_POINT_DNS, 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("lee", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("les", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("req", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("rpe", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("rps", 0.0d, 600000.0d));
            create34.addMeasure(createMeasuerWithRange("scs", 0.0d, 600000.0d));
            AppMonitor.register("WindVane", "H5", create34, create33);
            AppMonitor.register("WindVane", MONITOR_POINT_PERFORMANCE_2, create34, create33);
            AppMonitor.register("WindVane", MONITOR_POINT_PERFORMANCE_3, create34, create33);
            AppMonitor.register("WindVane", MONITOR_POINT_PERFORMANCE_4, create34, create33);
            AppMonitor.register("WindVane", MONITOR_POINT_PERFORMANCE_5, create34, create33);
            isAppMonitorEnabled = true;
        } catch (Throwable unused) {
            TaoLog.i(TAG, "AppMonitor not found");
        }
    }
}
