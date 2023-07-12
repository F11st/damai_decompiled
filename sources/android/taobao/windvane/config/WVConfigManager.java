package android.taobao.windvane.config;

import android.app.Activity;
import android.os.Looper;
import android.taobao.windvane.config.WVConfigUpdateCallback;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.monitor.WVConfigMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.packageapp.WVPackageAppService;
import android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.HttpHeaderConstant;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVConfigManager {
    public static final String CONFIGNAME_COMMON = "common";
    public static final String CONFIGNAME_COOKIE = "cookie_black_list";
    public static final String CONFIGNAME_CUSTOM = "customs";
    public static final String CONFIGNAME_DOMAIN = "domain";
    public static final String CONFIGNAME_LOCALE = "locale";
    public static final String CONFIGNAME_MONITOR = "monitor";
    public static final String CONFIGNAME_PACKAGE = "package";
    public static final String CONFIGNAME_PREFIXES = "prefixes";
    public static final String CONFIGNAME_URL_CONFIG = "url_config";
    public static final String CONFIG_UPDATETIME = "_updateTime";
    public static final String CONFIG_UPLOADDATA = "_uploadData";
    private static final String DEFAULT_DEMAIN = "https://wvcfg.alicdn.com/";
    public static final String SPNAME_CONFIG = "wv_main_config";
    private static final String TAG = "WVConfigManager";
    private static long updateInterval = 300000;
    private static long updateIntervalServer = 300000;
    private static long updateTime;
    private ConcurrentHashMap<String, WVConfigHandler> mConfigMap;
    public static boolean launch = EnvUtil.isTaobao();
    private static volatile WVConfigManager instance = null;
    private String configDomain = DEFAULT_DEMAIN;
    private int updateConfigCount = 0;
    private boolean enableUpdateConfig = true;
    private ConcurrentHashMap<String, IConfig> mOtherConfigMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: android.taobao.windvane.config.WVConfigManager$5  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$android$taobao$windvane$config$EnvEnum;

        static {
            int[] iArr = new int[EnvEnum.values().length];
            $SwitchMap$android$taobao$windvane$config$EnvEnum = iArr;
            try {
                iArr[EnvEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$taobao$windvane$config$EnvEnum[EnvEnum.PRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$taobao$windvane$config$EnvEnum[EnvEnum.DAILY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum WVConfigUpdateFromType {
        WVConfigUpdateFromTypeCustom,
        WVConfigUpdateFromTypeActive,
        WVConfigUpdateFromTypeFinish,
        WVConfigUpdateFromTypePush,
        WVConfigUpdateFromTypeLaunch,
        WVConfigUpdateFromTypeAppActive,
        WVConfigUpdateFromTypeLocaleChange,
        WVConfigUpdateFromZCache3_0
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class WVPageEventListener implements WVEventListener {
        @Override // android.taobao.windvane.service.WVEventListener
        public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
            IWVWebView iWVWebView;
            if (i == 3002 || i == 1002) {
                if (WVConfigManager.launch && wVEventContext != null && (iWVWebView = wVEventContext.webView) != null && (iWVWebView._getContext() instanceof Activity) && !wVEventContext.webView._getContext().getClass().getSimpleName().equals("MainActivity3")) {
                    WVConfigManager.launch = false;
                }
                if (i == 3002) {
                    WVConfigManager.instance.updateConfig(WVConfigUpdateFromType.WVConfigUpdateFromTypeActive);
                    return null;
                }
                WVConfigManager.instance.updateConfig(WVConfigUpdateFromType.WVConfigUpdateFromTypeFinish);
                return null;
            }
            return null;
        }
    }

    private WVConfigManager() {
        this.mConfigMap = null;
        this.mConfigMap = new ConcurrentHashMap<>();
        WVEventService.getInstance().addEventListener(new WVPageEventListener());
    }

    static /* synthetic */ int access$404(WVConfigManager wVConfigManager) {
        int i = wVConfigManager.updateConfigCount + 1;
        wVConfigManager.updateConfigCount = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateByKey(final String str, final String str2, String str3, final WVConfigUpdateFromType wVConfigUpdateFromType) {
        boolean z;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (!"3".equals(GlobalConfig.zType) || wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromZCache3_0) {
            if (TextUtils.isEmpty(str3)) {
                try {
                    z = WVConfigUtils.isNeedUpdate(str2, str);
                } catch (Exception unused) {
                    z = false;
                }
            } else {
                z = true;
            }
            if ("3".equals(GlobalConfig.zType)) {
                z = true;
            }
            TaoLog.i(TAG, "update key=[" + str + "],needUpdate=[" + z + jn1.ARRAY_END_STR);
            if (wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromTypeLocaleChange) {
                z = true;
            }
            if (z) {
                final WVConfigHandler wVConfigHandler = this.mConfigMap.get(str);
                if (wVConfigHandler != null) {
                    if (wVConfigHandler.getUpdateStatus() && System.currentTimeMillis() - updateTime < updateInterval) {
                        return;
                    }
                    wVConfigHandler.setUpdateStatus(true);
                    wVConfigHandler.setSnapshotN(str2);
                    final long currentTimeMillis = System.currentTimeMillis();
                    wVConfigHandler.update(str3, new WVConfigUpdateCallback() { // from class: android.taobao.windvane.config.WVConfigManager.4
                        @Override // android.taobao.windvane.config.WVConfigUpdateCallback
                        public void updateError(String str4, String str5) {
                            WVConfigMonitorInterface configMonitor = WVMonitorService.getConfigMonitor();
                            if (configMonitor != null) {
                                String str6 = str;
                                configMonitor.didOccurUpdateConfigError(str6, 7, str4 + ":" + str5);
                            }
                        }

                        @Override // android.taobao.windvane.config.WVConfigUpdateCallback
                        public void updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS config_update_status, int i) {
                            wVConfigHandler.setUpdateStatus(false);
                            WVConfigManager.access$404(WVConfigManager.this);
                            if (WVConfigManager.this.updateConfigCount >= WVConfigManager.this.mConfigMap.size()) {
                                WVConfigManager.this.updateConfigCount = 0;
                                WVEventService.getInstance().onEvent(6002);
                            }
                            if (str.equals("common") || str.equals("domain") || str.equals("monitor") || !"3".equals(GlobalConfig.zType)) {
                                boolean equals = WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.SUCCESS.equals(config_update_status);
                                WVConfigMonitorInterface configMonitor = WVMonitorService.getConfigMonitor();
                                if (equals) {
                                    ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, str, str2);
                                    if (configMonitor != null) {
                                        configMonitor.didOccurUpdateConfigSuccess(str);
                                    }
                                } else if (configMonitor != null && !config_update_status.equals(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR)) {
                                    String str4 = str;
                                    int ordinal = config_update_status.ordinal();
                                    configMonitor.didOccurUpdateConfigError(str4, ordinal, str + ":" + str2 + ":" + config_update_status);
                                }
                                if (configMonitor != null) {
                                    WVMonitorService.getConfigMonitor().didUpdateConfig(str, wVConfigUpdateFromType.ordinal(), System.currentTimeMillis() - currentTimeMillis, equals ? 1 : 0, i);
                                }
                            }
                            TaoLog.i(WVConfigManager.TAG, "isUpdateSuccess " + str + " : " + config_update_status);
                        }
                    });
                }
            } else {
                this.updateConfigCount++;
            }
            if (this.updateConfigCount >= this.mConfigMap.size()) {
                this.updateConfigCount = 0;
                WVEventService.getInstance().onEvent(6002);
            }
        }
    }

    public static WVConfigManager getInstance() {
        if (instance == null) {
            synchronized (WVConfigManager.class) {
                if (instance == null) {
                    instance = new WVConfigManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImmediately(final WVConfigUpdateFromType wVConfigUpdateFromType) {
        if (this.enableUpdateConfig && WVConfigUtils.checkAppKeyAvailable()) {
            final long currentTimeMillis = System.currentTimeMillis();
            ConnectManager.getInstance().connectSync(getConfigUrl("0", "0", WVConfigUtils.getTargetValue(), "0"), new HttpConnectListener<HttpResponse>() { // from class: android.taobao.windvane.config.WVConfigManager.1
                @Override // android.taobao.windvane.connect.HttpConnectListener
                public void onError(int i, String str) {
                    TaoLog.d(WVConfigManager.TAG, "update entry failed! : " + str);
                    if (WVMonitorService.getConfigMonitor() != null) {
                        WVMonitorService.getConfigMonitor().didOccurUpdateConfigError("entry-NoNetwork", WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR.ordinal(), str);
                    }
                    super.onError(i, str);
                }

                @Override // android.taobao.windvane.connect.HttpConnectListener
                public void onFinish(HttpResponse httpResponse, int i) {
                    int i2;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (httpResponse == null) {
                        return;
                    }
                    try {
                        String str = new String(httpResponse.getData(), "utf-8");
                        ApiResponse apiResponse = new ApiResponse();
                        JSONObject jSONObject = apiResponse.parseJsonResult(str).success ? apiResponse.data : null;
                        if (WVMonitorService.getPackageMonitorInterface() != null) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            Map<String, String> headers = httpResponse.getHeaders();
                            if (headers != null) {
                                String str2 = headers.get("Age");
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = headers.get("age");
                                }
                                String str3 = headers.get(HttpHeaderConstant.DATE);
                                if (TextUtils.isEmpty(str3)) {
                                    str3 = headers.get("date");
                                }
                                long longValue = !TextUtils.isEmpty(str2) ? Long.valueOf(str2).longValue() * 1000 : 0L;
                                if (!TextUtils.isEmpty(str3)) {
                                    longValue += CommonUtils.parseDate(str3);
                                }
                                if (longValue != 0) {
                                    long j = currentTimeMillis3 - longValue;
                                    TaoLog.i(WVConfigManager.TAG, "updateDiffTime by config : " + j);
                                    WVMonitorService.getPackageMonitorInterface().uploadDiffTimeTime(j);
                                }
                            }
                        }
                        boolean needFull = WVLocaleConfig.getInstance().needFull();
                        WVConfigUpdateFromType wVConfigUpdateFromType2 = wVConfigUpdateFromType;
                        if (needFull) {
                            wVConfigUpdateFromType2 = WVConfigUpdateFromType.WVConfigUpdateFromTypeLocaleChange;
                            WVPackageAppService.getWvPackageAppConfig().requestFullConfigNextTime();
                        }
                        if (jSONObject != null && WVConfigManager.this.mConfigMap != null) {
                            Enumeration keys = WVConfigManager.this.mConfigMap.keys();
                            while (keys.hasMoreElements()) {
                                String str4 = (String) keys.nextElement();
                                WVConfigManager.this.doUpdateByKey(str4, jSONObject.optString(str4, "0"), null, wVConfigUpdateFromType2);
                            }
                            if (WVMonitorService.getConfigMonitor() != null) {
                                WVMonitorService.getConfigMonitor().didOccurUpdateConfigSuccess("entry");
                            }
                        }
                        WVEventService.getInstance().onEvent(7001);
                        i2 = 1;
                    } catch (Exception e) {
                        if (WVMonitorService.getConfigMonitor() != null) {
                            WVConfigMonitorInterface configMonitor = WVMonitorService.getConfigMonitor();
                            int ordinal = WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR.ordinal();
                            configMonitor.didOccurUpdateConfigError("entry", ordinal, "update entry error : " + e.getMessage());
                        }
                        TaoLog.d(WVConfigManager.TAG, "updateImmediately failed!");
                        i2 = 0;
                    }
                    if (WVMonitorService.getConfigMonitor() != null) {
                        WVMonitorService.getConfigMonitor().didUpdateConfig("entry", wVConfigUpdateFromType.ordinal(), currentTimeMillis2, i2, WVConfigManager.this.mConfigMap.size());
                    }
                }
            });
        }
    }

    public boolean checkIfUpdate(WVConfigUpdateFromType wVConfigUpdateFromType) {
        int i = 0;
        if (!"3".equals(GlobalConfig.zType) || wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromZCache3_0) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromTypeAppActive || wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromTypeLocaleChange || currentTimeMillis - updateTime > updateInterval;
            if (z && WVConfigUtils.checkAppKeyAvailable()) {
                updateTime = currentTimeMillis;
            }
            if (WVConfigUtils.checkAppKeyAvailable()) {
                String format = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA).format(Calendar.getInstance().getTime());
                String stringVal = ConfigStorage.getStringVal(SPNAME_CONFIG, "package_uploadData", "0");
                TaoLog.d("WVConfigManager.updateConfig ==> ", "uploadDate = " + stringVal);
                if (!format.equals(stringVal) && WVCommonConfig.commonConfig.monitoredApps.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    Map<String, ZipAppInfo> appsTable = WVPackageAppService.getWvPackageAppConfig().getGlobalConfig().getAppsTable();
                    while (true) {
                        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
                        String[] strArr = wVCommonConfigData.monitoredApps;
                        if (i >= strArr.length) {
                            break;
                        }
                        ZipAppInfo zipAppInfo = appsTable.get(strArr[i]);
                        if (zipAppInfo != null && zipAppInfo.isAppInstalled()) {
                            sb.append(zipAppInfo.name);
                            sb.append("-");
                            sb.append(zipAppInfo.installedSeq);
                            if (i != wVCommonConfigData.monitoredApps.length - 1) {
                                sb.append(",");
                            }
                        }
                        i++;
                    }
                    if (WVMonitorService.getPackageMonitorInterface() != null) {
                        WVMonitorService.getPackageMonitorInterface().commitZCacheDiurnalOverview(sb.toString());
                    }
                    ConfigStorage.putStringVal(SPNAME_CONFIG, "package_uploadData", format);
                }
            }
            return z;
        }
        return false;
    }

    public String configDomainByEnv() {
        int i = AnonymousClass5.$SwitchMap$android$taobao$windvane$config$EnvEnum[GlobalConfig.env.ordinal()];
        return i != 2 ? i != 3 ? "https://wvcfg.alicdn.com" : "https://h5.waptest.taobao.com" : "http://h5.wapa.taobao.com";
    }

    public String getConfigUrl(String str, String str2, String str3, String str4) {
        char charAt;
        String str5 = WVLocaleConfig.getInstance().mCurrentLocale;
        StringBuilder sb = new StringBuilder();
        if (!DEFAULT_DEMAIN.equals(this.configDomain)) {
            sb.append(this.configDomain);
        } else {
            sb.append(configDomainByEnv());
        }
        sb.append("/bizcache/5/windvane/");
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        sb.append("-");
        sb.append(str4);
        sb.append("/");
        sb.append(GlobalConfig.getInstance().getAppKey());
        sb.append("-");
        sb.append(WVConfigUtils.dealAppVersion());
        if (str5 != null) {
            sb.append("-");
            sb.append(str5);
        }
        sb.append("/");
        if (str3 == null && ('a' > (charAt = (str3 = ConfigStorage.getStringVal(SPNAME_CONFIG, "abt", "a")).charAt(0)) || charAt > 'c')) {
            str3 = "a";
        }
        sb.append(str3);
        sb.append("/settings.json");
        TaoLog.w("CONFIG_URL", sb.toString());
        return sb.toString();
    }

    public HashMap getConfigVersions() {
        HashMap hashMap = new HashMap();
        ConcurrentHashMap<String, WVConfigHandler> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null) {
            Enumeration<String> keys = concurrentHashMap.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                String stringVal = ConfigStorage.getStringVal(SPNAME_CONFIG, nextElement, "0");
                if (!stringVal.contains(".")) {
                    Long valueOf = Long.valueOf(Long.parseLong(stringVal));
                    if (valueOf.longValue() == 0) {
                        stringVal = "NO VERSION";
                    } else if (valueOf.longValue() == AbsPerformance.LONG_NIL) {
                        stringVal = "CUSTOM VERION";
                    }
                }
                hashMap.put(nextElement, stringVal);
            }
        }
        return hashMap;
    }

    public WVConfigHandler registedHandler(String str) {
        ConcurrentHashMap<String, WVConfigHandler> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void registerConfigImpl(String str, IConfig iConfig) {
        this.mOtherConfigMap.put(str, iConfig);
    }

    public void registerHandler(String str, WVConfigHandler wVConfigHandler) {
        this.mConfigMap.put(str, wVConfigHandler);
    }

    public void removeHandler(String str) {
        ConcurrentHashMap<String, WVConfigHandler> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap == null) {
            return;
        }
        concurrentHashMap.remove(str);
    }

    public void resetConfig() {
        ConcurrentHashMap<String, WVConfigHandler> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null) {
            Enumeration<String> keys = concurrentHashMap.keys();
            while (keys.hasMoreElements()) {
                ConfigStorage.putStringVal(SPNAME_CONFIG, keys.nextElement(), "0");
            }
        }
        updateTime = 0L;
    }

    public void setConfigDomain(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.configDomain = str;
        }
        TaoLog.w(TAG, "changeConfigDomain : " + str);
    }

    public void setUpdateConfigEnable(boolean z) {
        this.enableUpdateConfig = z;
    }

    public void setUpdateInterval(long j) {
        updateIntervalServer = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[Catch: all -> 0x013d, TryCatch #0 {all -> 0x013d, blocks: (B:3:0x0006, B:6:0x001a, B:8:0x001e, B:11:0x0023, B:17:0x0033, B:24:0x0064, B:26:0x006a, B:28:0x0070, B:30:0x0079, B:29:0x0075, B:31:0x009d, B:33:0x00a3, B:35:0x00dc, B:37:0x00e3, B:38:0x00f4, B:40:0x00fb, B:42:0x0105, B:44:0x010b, B:46:0x0120, B:47:0x0125, B:48:0x0128, B:50:0x012e, B:51:0x0139, B:18:0x003a, B:20:0x003e, B:22:0x005b), top: B:56:0x0006 }] */
    @android.annotation.TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateConfig(final android.taobao.windvane.config.WVConfigManager.WVConfigUpdateFromType r14) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.config.WVConfigManager.updateConfig(android.taobao.windvane.config.WVConfigManager$WVConfigUpdateFromType):void");
    }

    public void updateConfigByKey(String str, String str2) {
        IConfig iConfig = this.mOtherConfigMap.get(str);
        if (iConfig != null) {
            iConfig.setConfig(str2);
        }
    }

    public void updateConfig(final String str, final String str2, final String str3, final WVConfigUpdateFromType wVConfigUpdateFromType) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.config.WVConfigManager.3
                @Override // java.lang.Runnable
                public void run() {
                    WVConfigManager.this.doUpdateByKey(str, str2, str3, wVConfigUpdateFromType);
                }
            });
        } else {
            doUpdateByKey(str, str2, str3, wVConfigUpdateFromType);
        }
    }
}
