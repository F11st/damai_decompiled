package android.taobao.windvane.config;

import android.taobao.windvane.config.WVConfigUpdateCallback;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVCommonConfig implements IConfig {
    private static final String TAG = "WVCommonConfig";
    public static final WVCommonConfigData commonConfig = new WVCommonConfigData();
    private static volatile WVCommonConfig instance = null;
    public String commonCfg = "{}";
    private AtomicBoolean inited = new AtomicBoolean(false);

    public static WVCommonConfig getInstance() {
        if (instance == null) {
            synchronized (WVCommonConfig.class) {
                if (instance == null) {
                    instance = new WVCommonConfig();
                }
            }
        }
        return instance;
    }

    @NonNull
    private String[] parseArray(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            String optString = jSONObject.optString(str, "[]");
            if (TextUtils.isEmpty(optString) || optString.length() < 2) {
                return null;
            }
            return optString.substring(1, optString.length() - 1).split(",");
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                strArr[i] = optJSONArray.getString(i);
            } catch (JSONException e) {
                TaoLog.e(TAG, "obtain array error ==>", e.getMessage());
            }
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int parseConfig(String str) {
        JSONObject jSONObject;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        UCParamData uCParamData;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] strArr6 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString("v", "");
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            WVCommonConfigData wVCommonConfigData = commonConfig;
            wVCommonConfigData.v = optString;
            long optLong = jSONObject.optLong("configUpdateInterval", 0L);
            if (optLong >= 0) {
                wVCommonConfigData.updateInterval = optLong;
                WVConfigManager.getInstance().setUpdateInterval(optLong);
            }
            wVCommonConfigData.packagePriorityWeight = jSONObject.optDouble("packagePriorityWeight", 0.1d);
            wVCommonConfigData.packageAppStatus = jSONObject.optInt("packageAppStatus", 2);
            wVCommonConfigData.monitorStatus = jSONObject.optInt("monitorStatus", 2);
            wVCommonConfigData.urlRuleStatus = jSONObject.optInt("urlRuleStatus", 2);
            wVCommonConfigData.packageMaxAppCount = jSONObject.optInt("packageMaxAppCount", 100);
            wVCommonConfigData.urlScheme = jSONObject.optString("urlScheme", "http").replace(":", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("verifySampleRate");
            if (optJSONObject != null) {
                wVCommonConfigData.verifySampleRate = optJSONObject.toString();
            }
            try {
                strArr = parseArray(jSONObject, "monitoredApps");
            } catch (Exception e) {
                e.printStackTrace();
                TaoLog.d(TAG, "parseConfig: monitoredApps parseArray occur some error!");
                strArr = null;
            }
            if (strArr != null) {
                commonConfig.monitoredApps = strArr;
            }
            try {
                strArr2 = parseArray(jSONObject, "systemBlacks");
            } catch (Throwable th) {
                th.printStackTrace();
                TaoLog.d(TAG, "parseConfig: systemBlacks parseArray occur some error!");
                strArr2 = null;
            }
            if (strArr2 != null) {
                commonConfig.systemBlacks = strArr2;
            }
            try {
                strArr3 = parseArray(jSONObject, "brandBlacks");
            } catch (Throwable th2) {
                th2.printStackTrace();
                TaoLog.d(TAG, "parseConfig: brandBlacks parseArray occur some error!");
                strArr3 = null;
            }
            if (strArr2 != null) {
                commonConfig.brandBlacks = strArr3;
            }
            try {
                strArr4 = parseArray(jSONObject, "modelBlacks");
            } catch (Throwable th3) {
                th3.printStackTrace();
                TaoLog.d(TAG, "parseConfig: modelBlacks parseArray occur some error!");
                strArr4 = null;
            }
            if (strArr2 != null) {
                commonConfig.modelBlacks = strArr4;
            }
            try {
                strArr5 = parseArray(jSONObject, "aliNetworkDegradeDomains");
            } catch (Throwable th4) {
                th4.printStackTrace();
                TaoLog.d(TAG, "parseConfig: aliNetworkDegradeDomains parseArray occur some error!");
                strArr5 = null;
            }
            if (strArr5 != null) {
                commonConfig.aliNetworkDegradeDomains = strArr5;
            }
            try {
                strArr6 = parseArray(jSONObject, "disableMixViews");
            } catch (Throwable th5) {
                th5.printStackTrace();
                TaoLog.d(TAG, "parseConfig: disableMixViews parseArray occur some error!");
            }
            WVCommonConfigData wVCommonConfigData2 = commonConfig;
            wVCommonConfigData2.disableMixViews = strArr6;
            String optString2 = jSONObject.optString("disableInstallPeriod");
            if (!TextUtils.isEmpty(optString2)) {
                String[] split = optString2.trim().split("-");
                if (split.length == 2) {
                    if (split[0].matches("^[0-9]*$")) {
                        wVCommonConfigData2.disableInstallPeriod_start = Long.parseLong(split[0]);
                    }
                    if (split[1].matches("^[0-9]*$")) {
                        wVCommonConfigData2.disableInstallPeriod_end = Long.parseLong(split[1]);
                    }
                }
            }
            String optString3 = jSONObject.optString("ucParam", "");
            if (!TextUtils.isEmpty(optString3) && (uCParamData = wVCommonConfigData2.ucParam) != null) {
                uCParamData.parse(optString3);
            }
            wVCommonConfigData2.enableUcShareCore = jSONObject.optBoolean("enableUCShareCore", true);
            wVCommonConfigData2.useSystemWebView = jSONObject.optBoolean("useSystemWebView", false);
            wVCommonConfigData2.ucsdk_alinetwork_rate = jSONObject.optDouble("ucsdk_alinetwork_rate", 1.0d);
            wVCommonConfigData2.reduceCameraPermissionOfStorage = jSONObject.optBoolean("reduceCameraPermissionOfStorage", true);
            wVCommonConfigData2.reduceGalleryPermissionOfStorageWrite = jSONObject.optBoolean("reduceGalleryPermissionOfStorageWrite", true);
            wVCommonConfigData2.ucsdk_image_strategy_rate = jSONObject.optDouble("ucsdk_image_strategy_rate", 1.0d);
            wVCommonConfigData2.cookieUrlRule = jSONObject.optString("cookieUrlRule", "");
            wVCommonConfigData2.ucCoreUrl = jSONObject.optString("ucCoreUrl", "");
            wVCommonConfigData2.shareBlankList = jSONObject.optString("shareBlankList", "");
            wVCommonConfigData2.excludeUCVersions = jSONObject.optString("excludeUCVersions", "1.12.11.0, 1.15.15.0, 1.14.13.0, 1.13.12.0");
            wVCommonConfigData2.isOpenCombo = jSONObject.optBoolean("isOpenCombo", false);
            wVCommonConfigData2.isCheckCleanup = jSONObject.optBoolean("isCheckCleanup", true);
            wVCommonConfigData2.isAutoRegisterApp = jSONObject.optBoolean("isAutoRegisterApp", false);
            wVCommonConfigData2.isUseTBDownloader = jSONObject.optBoolean("isUseTBDownloader", true);
            wVCommonConfigData2.isUseAliNetworkDelegate = jSONObject.optBoolean("isUseAliNetworkDelegate", true);
            wVCommonConfigData2.packageDownloadLimit = jSONObject.optInt("packageDownloadLimit", 30);
            wVCommonConfigData2.packageAccessInterval = jSONObject.optInt("packageAccessInterval", 3000);
            wVCommonConfigData2.packageRemoveInterval = jSONObject.optInt("packageRemoveInterval", 432000000);
            wVCommonConfigData2.recoveryInterval = jSONObject.optInt("recoveryInterval", 432000000);
            wVCommonConfigData2.customsComboLimit = jSONObject.optInt("customsComboLimit", 1);
            wVCommonConfigData2.customsDirectQueryLimit = jSONObject.optInt("customsDirectQueryLimit", 10);
            wVCommonConfigData2.packageZipPrefix = jSONObject.optString("packageZipPrefix", "");
            wVCommonConfigData2.packageZipPreviewPrefix = jSONObject.optString("packageZipPreviewPrefix", "");
            wVCommonConfigData2.ucSkipOldKernel = jSONObject.optBoolean("ucSkipOldKernel", true);
            wVCommonConfigData2.useUCPlayer = jSONObject.optBoolean("useUCPlayer", false);
            wVCommonConfigData2.enableUCPrecache = jSONObject.optBoolean("enableUCPrecache", false);
            wVCommonConfigData2.precachePackageName = jSONObject.optString("precachePackageName", "");
            wVCommonConfigData2.enableUCPrecacheDoc = jSONObject.optBoolean("enableUCPrecacheDoc", false);
            wVCommonConfigData2.initUCCorePolicy = jSONObject.optInt("initUCCorePolicy", wVCommonConfigData2.initUCCorePolicy);
            wVCommonConfigData2.initWebPolicy = jSONObject.optInt("initWebPolicy", 19);
            wVCommonConfigData2.initOldCoreVersions = jSONObject.optString("initOldCoreVersions", "3.*");
            wVCommonConfigData2.openExperiment = jSONObject.optBoolean("openExperiment", wVCommonConfigData2.openExperiment);
            wVCommonConfigData2.openUCExperiment = jSONObject.optBoolean("openUCExperiment", wVCommonConfigData2.openUCExperiment);
            wVCommonConfigData2.openUCImageExperiment = jSONObject.optBoolean("openUCImageExperiment", wVCommonConfigData2.openUCImageExperiment);
            wVCommonConfigData2.discardableFreeIfHasGpuDecode = jSONObject.optBoolean("discardableFreeIfHasGpuDecode", wVCommonConfigData2.discardableFreeIfHasGpuDecode);
            wVCommonConfigData2.ucMultiRetryTimes = jSONObject.optInt("ucMultiRetryTimes", wVCommonConfigData2.ucMultiRetryTimes);
            wVCommonConfigData2.webMultiPolicy = jSONObject.optInt("webMultiPolicy", wVCommonConfigData2.webMultiPolicy);
            wVCommonConfigData2.gpuMultiPolicy = jSONObject.optInt("gpuMultiPolicy", wVCommonConfigData2.gpuMultiPolicy);
            wVCommonConfigData2.ucMultiTimeOut = jSONObject.optInt("ucMultiTimeOut", JosStatusCodes.RTN_CODE_COMMON_ERROR);
            wVCommonConfigData2.ucMultiStartTime = jSONObject.optInt("ucMultiStartTime", wVCommonConfigData2.ucMultiStartTime);
            wVCommonConfigData2.recoverMultiInterval = jSONObject.optInt("recoverMultiInterval", wVCommonConfigData2.recoverMultiInterval);
            wVCommonConfigData2.ucMultiServiceSpeedUp = jSONObject.optBoolean("ucMultiServiceSpeedUp", false);
            wVCommonConfigData2.downloadCoreType = jSONObject.optInt("downloadCoreType", wVCommonConfigData2.downloadCoreType);
            wVCommonConfigData2.openLog = jSONObject.optBoolean("openLog", false);
            wVCommonConfigData2.openTLog = jSONObject.optBoolean("openTLog", true);
            wVCommonConfigData2.useOldBridge = jSONObject.optBoolean("useOldBridge", false);
            wVCommonConfigData2.ffmegSoPath = jSONObject.optString("ffmegSoPath", wVCommonConfigData2.ffmegSoPath);
            wVCommonConfigData2.enableSgRequestCheck = jSONObject.optBoolean("enableSgRequestCheck", wVCommonConfigData2.enableSgRequestCheck);
            wVCommonConfigData2.filterSgRequestCheck = jSONObject.optBoolean("filterSgRequestCheck", wVCommonConfigData2.filterSgRequestCheck);
            wVCommonConfigData2.enableExtImgDecoder = jSONObject.optBoolean("enableExtImgDecoder", true);
            wVCommonConfigData2.skipPreRenderBackgroundWhitePage = jSONObject.optBoolean("skipPreRenderBackgroundWhitePage", true);
            wVCommonConfigData2.fixWhitePageBug = jSONObject.optBoolean("fixWhitePageBug", false);
            wVCommonConfigData2.enablePreStartup = jSONObject.optBoolean("enablePreStartup", true);
            wVCommonConfigData2.useNewThreadPool = jSONObject.optBoolean("useNewThreadPool", true);
            wVCommonConfigData2.enableGpuGoneReload = jSONObject.optBoolean("enableGpuGoneReload", wVCommonConfigData2.enableGpuGoneReload);
            wVCommonConfigData2.open5GAdapter = jSONObject.optBoolean("open5GAdapter", true);
            wVCommonConfigData2.useURLConfig = jSONObject.optBoolean("useURLConfig", true);
            wVCommonConfigData2.targetSdkAdapte = jSONObject.optBoolean("targetSdkAdapte", wVCommonConfigData2.targetSdkAdapte);
            wVCommonConfigData2.enableZCacheAdpter = jSONObject.optBoolean("enableZCacheAdpter", wVCommonConfigData2.enableZCacheAdpter);
            wVCommonConfigData2.zcacheResponseTimeOut = jSONObject.optLong("zcacheResponseTimeOut", wVCommonConfigData2.zcacheResponseTimeOut);
            wVCommonConfigData2.sysZcacheResponseTimeOut = jSONObject.optLong("sysZcacheResponseTimeOut", wVCommonConfigData2.sysZcacheResponseTimeOut);
            wVCommonConfigData2.enableMimeTypeSet = jSONObject.optBoolean("enableMimeTypeSet", true);
            wVCommonConfigData2.fixCameraPermission = jSONObject.optBoolean("fixCameraPermission", wVCommonConfigData2.fixCameraPermission);
            wVCommonConfigData2.enableThreadWatchdog = jSONObject.optBoolean("enableThreadWatchdog", wVCommonConfigData2.enableThreadWatchdog);
            wVCommonConfigData2.storeCachedDir = jSONObject.optBoolean("storeCachedDir", wVCommonConfigData2.storeCachedDir);
            wVCommonConfigData2.enableSamsungClipboard = jSONObject.optBoolean("enableSamsungClipboard", wVCommonConfigData2.enableSamsungClipboard);
            wVCommonConfigData2.enableUCUploadToTlog = jSONObject.optBoolean("enableUCUploadToTlog", wVCommonConfigData2.enableUCUploadToTlog);
            wVCommonConfigData2.enableWVFullTrace = jSONObject.optBoolean("enableWVFullTrace", wVCommonConfigData2.enableWVFullTrace);
            wVCommonConfigData2.uploadPPAfterJs = jSONObject.optBoolean("uploadPPAfterJs", wVCommonConfigData2.uploadPPAfterJs);
            parseUnzipDegradeConfig(jSONObject);
            WVEventService.getInstance().onEvent(WVEventId.CONFIG_COMMON_UPDATE);
            return jSONObject.length();
        }
        return 0;
    }

    private void parseUnzipDegradeConfig(JSONObject jSONObject) {
        String[] split;
        try {
            WVCommonConfigData wVCommonConfigData = commonConfig;
            wVCommonConfigData.zipDegradeMode = jSONObject.optInt("zipDegradeMode", 0);
            wVCommonConfigData.zipDegradeList = jSONObject.optString("zipDegradeList", "");
            String str = Build.getBRAND() + m80.DINAMIC_PREFIX_AT + Build.VERSION.getRELEASE();
            String str2 = wVCommonConfigData.zipDegradeList;
            if (TextUtils.isEmpty(str2) || (split = str2.split(",")) == null) {
                return;
            }
            for (String str3 : split) {
                if (str.equalsIgnoreCase(str3)) {
                    TaoLog.e(TAG, "Degrade unzip: " + str);
                    WVCommonConfigData wVCommonConfigData2 = commonConfig;
                    wVCommonConfigData2.needZipDegrade = true;
                    if (wVCommonConfigData2.zipDegradeMode == 2) {
                        wVCommonConfigData2.packageAppStatus = 0;
                        TaoLog.w(TAG, "Disable package app");
                        return;
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.taobao.windvane.config.IConfig
    public boolean hasInited() {
        return this.inited.get();
    }

    public void init() {
        if (this.inited.compareAndSet(false, true)) {
            String stringVal = ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "commonwv-data");
            if (TextUtils.isEmpty(stringVal)) {
                this.commonCfg = stringVal;
            }
            parseConfig(stringVal);
        }
    }

    @Override // android.taobao.windvane.config.IConfig
    public void setConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.commonCfg = str;
        }
        parseConfig(str);
        ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "commonwv-data", str);
    }

    public void updateCommonRule(final WVConfigUpdateCallback wVConfigUpdateCallback, final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = WVConfigManager.getInstance().getConfigUrl("1", commonConfig.v, WVConfigUtils.getTargetValue(), str2);
            if ("3".equals(GlobalConfig.zType)) {
                str = WVConfigManager.getInstance().getConfigUrl("1", "0", WVConfigUtils.getTargetValue(), str2);
            }
        }
        ConnectManager.getInstance().connectSync(str, new HttpConnectListener<HttpResponse>() { // from class: android.taobao.windvane.config.WVCommonConfig.1
            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onError(int i, String str3) {
                WVConfigUpdateCallback wVConfigUpdateCallback2 = wVConfigUpdateCallback;
                if (wVConfigUpdateCallback2 != null) {
                    wVConfigUpdateCallback2.updateError(str, str3);
                    wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR, 0);
                }
                TaoLog.d(WVCommonConfig.TAG, "update common failed! : " + str3);
                super.onError(i, str3);
            }

            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onFinish(HttpResponse httpResponse, int i) {
                if (wVConfigUpdateCallback == null) {
                    return;
                }
                if (httpResponse != null && httpResponse.getData() != null) {
                    try {
                        String str3 = new String(httpResponse.getData(), "utf-8");
                        if ("3".equals(GlobalConfig.zType)) {
                            WVCommonConfig.this.commonCfg = str3;
                        }
                        int parseConfig = WVCommonConfig.this.parseConfig(str3);
                        if (parseConfig > 0) {
                            ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "commonwv-data", str3);
                            wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.SUCCESS, parseConfig);
                            return;
                        }
                        wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.NO_VERSION, 0);
                        return;
                    } catch (UnsupportedEncodingException e) {
                        wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.ENCODING_ERROR, 0);
                        TaoLog.e(WVCommonConfig.TAG, "config encoding error. " + e.getMessage());
                        return;
                    }
                }
                wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.NULL_DATA, 0);
            }
        });
    }
}
