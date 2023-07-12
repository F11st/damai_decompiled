package android.taobao.windvane.monitor;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.monitor.WVMonitorConfig;
import android.taobao.windvane.monitor.WVMonitorData;
import android.taobao.windvane.monitor.WVPerformanceMonitorInterface;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVMonitorImpl implements WVConfigMonitorInterface, WVErrorMonitorInterface, WVMonitorInterface, WVPerformanceMonitorInterface {
    private static final String TAG = "WVMonitor";
    private long appStartTime;
    private boolean enabled;
    private boolean needCommitStartTime = true;
    private long initTime = 0;
    private boolean isInit = false;
    private String currentUrl = "";
    private HashSet<String> zipApps = new HashSet<>();
    private ConcurrentHashMap<String, WVMonitorData> dataMap = new ConcurrentHashMap<>();

    public WVMonitorImpl() {
        this.appStartTime = 0L;
        this.enabled = false;
        this.appStartTime = System.currentTimeMillis();
        this.enabled = true;
    }

    private boolean checkNeedCollectResInfo(String str) {
        return (!isEnabled() || str == null || isPage(str)) ? false : true;
    }

    private static boolean errorNeedReport(String str, String str2, Integer num) {
        boolean z = getConfig().isErrorBlacklist;
        for (WVMonitorConfig.ErrorRule errorRule : getConfig().errorRule) {
            String str3 = errorRule.url;
            if (str3 != null && str != null) {
                if (errorRule.urlPattern == null) {
                    errorRule.urlPattern = Pattern.compile(str3);
                }
                if (!errorRule.urlPattern.matcher(str).matches()) {
                    continue;
                }
            }
            String str4 = errorRule.msg;
            if (str4 != null && str2 != null) {
                if (errorRule.msgPattern == null) {
                    errorRule.msgPattern = Pattern.compile(str4);
                }
                if (!errorRule.msgPattern.matcher(str2).matches()) {
                    continue;
                }
            }
            if (TextUtils.isEmpty(errorRule.code) || num == null || errorRule.code.equals(num.toString())) {
                return !z;
            }
        }
        return z;
    }

    private static String formatUrl(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(63);
        if (indexOf <= 0) {
            indexOf = str.length();
        }
        int indexOf2 = str.indexOf(35);
        if (indexOf2 <= 0) {
            indexOf2 = str.length();
        }
        if (indexOf >= indexOf2) {
            indexOf = indexOf2;
        }
        return str.substring(0, indexOf);
    }

    private static WVMonitorConfig getConfig() {
        return WVMonitorConfigManager.getInstance().config;
    }

    private WVMonitorData.resStat getResData(String str) {
        WVMonitorData wVMonitorData;
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap = this.dataMap;
        if (concurrentHashMap == null || (wVMonitorData = concurrentHashMap.get(this.currentUrl)) == null) {
            return null;
        }
        WVMonitorData.resStat resstat = wVMonitorData.args.resStat.get(str);
        if (resstat == null) {
            WVMonitorData.resStat createNewResStatInstance = WVMonitorData.createNewResStatInstance();
            wVMonitorData.args.resStat.put(str, createNewResStatInstance);
            return createNewResStatInstance;
        }
        return resstat;
    }

    private WVMonitorData initData(String str) {
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap = this.dataMap;
        if (concurrentHashMap == null) {
            return null;
        }
        WVMonitorData wVMonitorData = concurrentHashMap.get(str);
        if (wVMonitorData == null) {
            synchronized (WVMonitorImpl.class) {
                if (wVMonitorData == null) {
                    TaoLog.i(TAG, "monitor data init");
                    wVMonitorData = new WVMonitorData();
                    this.currentUrl = str;
                    this.dataMap.put(str, wVMonitorData);
                }
            }
        }
        return wVMonitorData;
    }

    private boolean isEnabled() {
        if (GlobalConfig.context == null) {
            return false;
        }
        return this.enabled;
    }

    private boolean isPage(String str) {
        if (this.dataMap == null) {
            return false;
        }
        return formatUrl(this.currentUrl).equals(formatUrl(str));
    }

    private void pageFinish(String str, long j, boolean z) {
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap;
        WVMonitorData wVMonitorData;
        if (!isEnabled() || str == null || (concurrentHashMap = this.dataMap) == null || (wVMonitorData = concurrentHashMap.get(str)) == null) {
            return;
        }
        int i = 1;
        TaoLog.d(TAG, String.format("pageFinish: %s", str));
        long j2 = wVMonitorData.startTime;
        if (j2 > 0) {
            long j3 = j - j2;
            try {
                TaoLog.d(TAG, String.format("url: %s", str) + " onLoad time :" + j3);
                WVMonitorConfig config = getConfig();
                if (config != null && isEnabled() && j3 >= config.stat.onLoad) {
                    WVMonitorData.C0001stat c0001stat = wVMonitorData.stat;
                    c0001stat.onLoad = j3;
                    if (!z) {
                        i = 0;
                    }
                    c0001stat.finish = i;
                    try {
                        Uri parse = Uri.parse(str);
                        if (parse != null && parse.isHierarchical()) {
                            String queryParameter = parse.getQueryParameter("wvAppMonitor");
                            if (!TextUtils.isEmpty(queryParameter)) {
                                wVMonitorData.wvAppMonitor = Integer.valueOf(queryParameter).intValue();
                            }
                        }
                    } catch (Exception unused) {
                    }
                    upload(str);
                }
            } catch (Exception unused2) {
            }
        }
        this.dataMap.remove(str);
    }

    private void upload(String str) {
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap;
        WVMonitorData wVMonitorData;
        String str2;
        if (!isEnabled() || (concurrentHashMap = this.dataMap) == null || (wVMonitorData = concurrentHashMap.get(str)) == null) {
            return;
        }
        Object obj = "";
        if (wVMonitorData.stat.onLoad == 0) {
            str2 = "";
        } else {
            str2 = "" + wVMonitorData.stat.onLoad;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        WVMonitorData.C0001stat c0001stat = wVMonitorData.stat;
        if (c0001stat.onDomLoad != 0 || c0001stat.onLoad != 0) {
            obj = Integer.valueOf(c0001stat.finish);
        }
        sb.append(obj);
        UserTrackUtil.commitEvent(UserTrackUtil.EVENTID_MONITOR, str, str2, sb.toString(), wVMonitorData.toJsonStringDict());
        if (this.isInit) {
            long j = wVMonitorData.startTime;
            long j2 = this.initTime;
            if (j > j2) {
                this.isInit = false;
                wVMonitorData.isInit = true;
                wVMonitorData.init = j - j2;
            }
        }
        AppMonitorUtil.commitPerformanceInfo(wVMonitorData);
        String str3 = wVMonitorData.stat.packageAppName;
        if (this.zipApps != null && !TextUtils.isEmpty(str3) && !this.zipApps.contains(str3)) {
            AppMonitorUtil.commitPackageVisitStartInfo(str3, System.currentTimeMillis() - this.appStartTime);
            this.zipApps.add(str3);
        }
        if (this.needCommitStartTime) {
            long j3 = this.appStartTime;
            if (j3 != 0) {
                long j4 = wVMonitorData.startTime;
                if (j3 < j4) {
                    AppMonitorUtil.commitStartTimeInfo(wVMonitorData.url, j4 - j3);
                    this.needCommitStartTime = false;
                }
            }
        }
        TaoLog.i(TAG, "upload performance info  URL: " + str + " fromType : " + wVMonitorData.stat.fromType + " packageAppName : " + wVMonitorData.stat.packageAppName);
    }

    @Override // android.taobao.windvane.monitor.WVMonitorInterface
    public void WebViewWrapType(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "UnKnow";
        }
        AppMonitorUtil.commitWVWrapType(str);
    }

    @Override // android.taobao.windvane.monitor.WVMonitorInterface
    public void commitCoreInitTime(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "UnKnow";
        }
        AppMonitorUtil.commitCoreInitTime(j, str);
    }

    @Override // android.taobao.windvane.monitor.WVMonitorInterface
    public void commitCoreTypeByPV(String str, String str2) {
        if (TextUtils.isEmpty("UnKnow")) {
            str = "UnKnow";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UnKnow";
        }
        AppMonitorUtil.commitCoreTypeByPV(str, str2);
    }

    @Override // android.taobao.windvane.monitor.WVMonitorInterface
    public void commitRenderType(String str, String str2, int i) {
        AppMonitorUtil.commitRenderType(str, str2, String.valueOf(i), String.valueOf(GlobalConfig.isBackground));
    }

    @Override // android.taobao.windvane.monitor.WVMonitorInterface
    public void commitUseWebgl(String str) {
        AppMonitorUtil.commitUseWebgl(str);
    }

    @Override // android.taobao.windvane.monitor.WVMonitorInterface
    public void commitWebMultiTypeByPV(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMonitorUtil.commitRenderTypeByPV(str, str2, str3, str4, str5, str6);
        TaoLog.e(TAG, "UC Multi: initRenderType = [" + str + "], successRenderType = [" + str2 + "], renderTypeReason = [" + str3 + "], initGpuType = [" + str4 + "], successGpuType = [" + str5 + "],gpuTypeReason = [" + str6 + jn1.ARRAY_END_STR);
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didExitAtTime(String str, long j) {
        pageFinish(str, j, false);
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didGetPageStatusCode(String str, int i, int i2, String str2, String str3, String str4, Map<String, String> map, WVPerformanceMonitorInterface.NetStat netStat) {
        WVMonitorData initData;
        if (!isEnabled() || str == null || (initData = initData(str)) == null) {
            return;
        }
        WVMonitorData.C0000extra c0000extra = initData.args;
        c0000extra.netStat = netStat;
        if (i > 0) {
            c0000extra.statusCode = i;
        }
        if (i2 > 1) {
            WVMonitorData.C0001stat c0001stat = initData.stat;
            if (c0001stat.fromType <= 1) {
                c0001stat.fromType = i2;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            initData.stat.packageAppVersion = str2;
        }
        if (map != null) {
            initData.args.via = map.get("via");
        }
        if (!TextUtils.isEmpty(str3)) {
            initData.stat.packageAppName = str3;
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        initData.stat.appSeq = str4;
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didGetResourceStatusCode(String str, int i, int i2, Map<String, String> map, WVPerformanceMonitorInterface.NetStat netStat) {
        WVMonitorData.resStat resData;
        if (isPage(str)) {
            didGetPageStatusCode(str, i, i2, null, null, null, map, netStat);
        } else if (!checkNeedCollectResInfo(str) || (resData = getResData(str)) == null) {
        } else {
            resData.fromType = i2;
            resData.statusCode = i;
            resData.via = map != null ? map.get("Via") : "";
            if (netStat == null || !getConfig().stat.netstat) {
                return;
            }
            resData.netStat = netStat;
        }
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didGetResourceVerifyCode(String str, long j, long j2, int i, int i2) {
        WVMonitorData wVMonitorData;
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap = this.dataMap;
        if (concurrentHashMap == null || (wVMonitorData = concurrentHashMap.get(this.currentUrl)) == null) {
            return;
        }
        if (isPage(str)) {
            if (!isEnabled() || str == null) {
                return;
            }
            WVMonitorData.C0001stat c0001stat = wVMonitorData.stat;
            c0001stat.verifyResTime = j;
            c0001stat.verifyTime = j2;
            c0001stat.verifyError = i;
        } else if (checkNeedCollectResInfo(str)) {
            WVMonitorData.resStat resData = getResData(str);
            resData.verifyResTime = j;
            resData.verifyTime = j2;
            resData.verifyError = i;
        }
        WVMonitorData.C0001stat c0001stat2 = wVMonitorData.stat;
        c0001stat2.allVerifyTime += j2;
        c0001stat2.verifyCacheSize = i2;
    }

    @Override // android.taobao.windvane.monitor.WVErrorMonitorInterface
    public void didOccurJSError(String str, String str2, String str3, String str4) {
        if (!isEnabled() || str == null || str2 == null || str4 == null || str3 == null) {
            return;
        }
        TaoLog.d(TAG, String.format("reportJsError: %s ///// %s ///// %s ///// %s", str, str3, str2, str4));
        if (errorNeedReport(str, str2, null)) {
            AppMonitorUtil.commitFail(AppMonitorUtil.JS_ERROR_POINT, 1, String.format("message=%s\nline=%s\nfile=%s", str2, str4, str3), str);
        }
    }

    @Override // android.taobao.windvane.monitor.WVErrorMonitorInterface
    @SuppressLint({"DefaultLocale"})
    public void didOccurNativeError(String str, int i, String str2) {
        if (!isEnabled() || str == null || str2 == null) {
            return;
        }
        TaoLog.d(TAG, String.format("reportNativeError: %s ///// %s ///// %d", str, str2, Integer.valueOf(i)));
        if (isEnabled() && errorNeedReport(str, str2, Integer.valueOf(i))) {
            AppMonitorUtil.commitFail(AppMonitorUtil.NATIVE_ERROR_POINT, i, String.format("message=%s\ncode=%d", str2, Integer.valueOf(i)), str);
        }
    }

    @Override // android.taobao.windvane.monitor.WVConfigMonitorInterface
    public void didOccurUpdateConfigError(String str, int i, String str2) {
        if (!isEnabled() || str2 == null) {
            return;
        }
        AppMonitorUtil.commitConifgUpdateError(str, i, str2);
    }

    @Override // android.taobao.windvane.monitor.WVConfigMonitorInterface
    public void didOccurUpdateConfigSuccess(String str) {
        if (!isEnabled() || str == null) {
            return;
        }
        AppMonitorUtil.commitConifgUpdateSuccess(str);
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didPageDomLoadAtTime(String str, long j) {
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap;
        WVMonitorData wVMonitorData;
        if (!isEnabled() || str == null || (concurrentHashMap = this.dataMap) == null || (wVMonitorData = concurrentHashMap.get(str)) == null) {
            return;
        }
        long j2 = wVMonitorData.startTime;
        if (j2 > 0) {
            long j3 = j - j2;
            if (j3 >= getConfig().stat.onDomLoad) {
                wVMonitorData.stat.onDomLoad = j3;
            }
        }
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didPageFinishLoadAtTime(String str, long j) {
        if (str == null || Uri.parse(str) == null || !Uri.parse(str).isHierarchical()) {
            return;
        }
        pageFinish(str, j, true);
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didPageOccurSelfDefinedEvent(String str, String str2, long j) {
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap;
        WVMonitorData wVMonitorData;
        if (!isEnabled() || str == null || (concurrentHashMap = this.dataMap) == null || (wVMonitorData = concurrentHashMap.get(str)) == null) {
            return;
        }
        TaoLog.d(TAG, String.format("domLoad: %s", str));
        if (wVMonitorData.startTime > 0) {
            Map<String, Long> map = wVMonitorData.args.selfDefine;
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                map.put(entry.getKey(), Long.valueOf(entry.getValue().longValue() - wVMonitorData.startTime));
            }
        }
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didPagePerformanceInfo(String str, String str2) {
        WVMonitorData wVMonitorData;
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap = this.dataMap;
        if (concurrentHashMap == null || (wVMonitorData = concurrentHashMap.get(str)) == null) {
            return;
        }
        wVMonitorData.performanceInfo = str2;
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didPageReceiveFirstByteAtTime(String str, long j) {
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap;
        WVMonitorData wVMonitorData;
        if (!isEnabled() || str == null || (concurrentHashMap = this.dataMap) == null || (wVMonitorData = concurrentHashMap.get(str)) == null) {
            return;
        }
        TaoLog.d(TAG, String.format("domLoad: %s", str));
        long j2 = wVMonitorData.startTime;
        if (j2 > 0) {
            wVMonitorData.stat.firstByteTime = j - j2;
        }
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didPageStartInFSP(String str, long j) {
        AppMonitorUtil.commitFSPInfo(str, j);
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didPageStartLoadAtTime(String str, long j) {
        if (!isEnabled() || str == null || Uri.parse(str) == null || !Uri.parse(str).isHierarchical()) {
            return;
        }
        TaoLog.d(TAG, String.format("pageStart: %s", str));
        WVMonitorData initData = initData(str);
        if (initData == null) {
            return;
        }
        initData.startTime = j;
        initData.url = str;
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didPerformanceCheckResult(String str, long j, String str2, String str3, String str4) {
        AppMonitorUtil.commitWebPerfCheckInfo(str, j, str2, str3, str4);
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didResourceFinishLoadAtTime(String str, long j, String str2, long j2) {
        WVMonitorData wVMonitorData;
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap = this.dataMap;
        if (concurrentHashMap == null || (wVMonitorData = concurrentHashMap.get(this.currentUrl)) == null) {
            return;
        }
        try {
            if (checkNeedCollectResInfo(str)) {
                WVMonitorData.resStat resData = getResData(str);
                resData.end = j - wVMonitorData.startTime;
                resData.protocolType = str2;
                resData.tcpTime = j2;
            } else if (isPage(str)) {
                wVMonitorData.protocolType = str2;
            }
        } catch (Exception e) {
            TaoLog.w(TAG, "didResourceFinishLoadAtTime Exception : " + e.getMessage());
        }
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didResourceStartLoadAtTime(String str, long j) {
        WVMonitorData wVMonitorData;
        ConcurrentHashMap<String, WVMonitorData> concurrentHashMap = this.dataMap;
        if (concurrentHashMap == null || (wVMonitorData = concurrentHashMap.get(this.currentUrl)) == null) {
            return;
        }
        try {
            if (checkNeedCollectResInfo(str)) {
                getResData(str).start = j - wVMonitorData.startTime;
            }
        } catch (Exception e) {
            TaoLog.w(TAG, "didResourceStartLoadAtTime Exception : " + e.getMessage());
        }
    }

    @Override // android.taobao.windvane.monitor.WVConfigMonitorInterface
    public void didUpdateConfig(String str, int i, long j, int i2, int i3) {
        if (!isEnabled() || str == null) {
            return;
        }
        AppMonitorUtil.commitConifgUpdateInfo(str, i, j, i2, i3);
        TaoLog.i(TAG, "updateConfig " + str + " isSuccess : " + i2 + " count : " + i3);
    }

    @Override // android.taobao.windvane.monitor.WVPerformanceMonitorInterface
    public void didWebViewInitAtTime(long j) {
        if (isEnabled()) {
            this.isInit = true;
            this.initTime = j;
        }
    }
}
