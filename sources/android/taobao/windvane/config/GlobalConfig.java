package android.taobao.windvane.config;

import android.app.Application;
import android.taobao.windvane.config.UCHASettings;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class GlobalConfig {
    public static final String DEFAULT_TTID = "hybrid@windvane_android_8.5.0";
    public static final String DEFAULT_UA = " WindVane/8.5.0";
    public static final String VERSION = "8.5.0";
    private static GlobalConfig config;
    public static Application context;
    public static EnvEnum env = EnvEnum.ONLINE;
    public static boolean isBackground = false;
    public static String zType = "2";
    private String appKey;
    private String appSecret;
    private String appTag;
    private String appVersion;
    private String deviceId;
    private String groupName;
    private String groupVersion;
    private String imei;
    private String imsi;
    private String ttid;
    private Callable<Boolean> ucDownloadChecker;
    private String ucLibDir = null;
    private String uc7ZPath = null;
    private boolean ucSdkInternationalEnv = false;
    private boolean ucCoreOuterControl = false;
    private String[] ucsdkappkeySec = null;
    private boolean needSpeed = false;
    private boolean zcacheSpeed = false;
    private boolean openUCDebug = true;
    private UCHASettings ucHASettings = new UCHASettings();
    private UCHASettings.ConfigRate configRates = new UCHASettings.ConfigRate();
    private boolean zcacheOldConfig = true;
    private boolean zcacheType3 = true;
    private boolean open4GDownload = false;
    private int ucCoreWaitMills = 4000;
    private int deleteCorePolicy = 0;
    private boolean disableMultiUnknownCrash = false;
    private boolean useGlobalUrlConfig = false;
    private boolean open5GDownload = false;
    private boolean reducePermission = false;
    private int injected = -1;

    private GlobalConfig() {
    }

    public static String getCdnConfigUrlPre() {
        return getH5Host() + "/bizcache/";
    }

    public static String getCdnHost() {
        EnvEnum envEnum = EnvEnum.ONLINE;
        String str = envEnum.equals(env) ? "https://h5." : "http://h5.";
        return str + envEnum.getValue() + ".taobao.com";
    }

    public static String getH5Host() {
        String str = EnvEnum.ONLINE.equals(env) ? "https://h5." : "http://h5.";
        return str + env.getValue() + ".taobao.com";
    }

    public static synchronized GlobalConfig getInstance() {
        GlobalConfig globalConfig;
        synchronized (GlobalConfig.class) {
            if (config == null) {
                synchronized (GlobalConfig.class) {
                    if (config == null) {
                        config = new GlobalConfig();
                    }
                }
            }
            globalConfig = config;
        }
        return globalConfig;
    }

    public static String getMtopUrl() {
        return "http://api." + env.getValue() + ".taobao.com/rest/api3.do";
    }

    public boolean allowReducePermission() {
        return this.reducePermission;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public String getAppTag() {
        return this.appTag;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public UCHASettings.ConfigRate getConfigRates() {
        return this.configRates;
    }

    public int getDeleteCorePolicy() {
        return this.deleteCorePolicy;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupVersion() {
        return this.groupVersion;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public int getInjectCode() {
        return this.injected;
    }

    public String getTtid() {
        return this.ttid;
    }

    public String getUc7ZPath() {
        return this.uc7ZPath;
    }

    public int getUcCoreWaitMills() {
        return this.ucCoreWaitMills;
    }

    public Callable<Boolean> getUcDownloadChecker() {
        return this.ucDownloadChecker;
    }

    public UCHASettings getUcHASettings() {
        return this.ucHASettings;
    }

    public String getUcLibDir() {
        return this.ucLibDir;
    }

    public String[] getUcsdkappkeySec() {
        return this.ucsdkappkeySec;
    }

    public boolean initParams(WVAppParams wVAppParams) {
        if (wVAppParams != null) {
            if (!TextUtils.isEmpty(wVAppParams.appKey)) {
                if (TextUtils.isEmpty(wVAppParams.ttid)) {
                    this.ttid = DEFAULT_TTID;
                } else {
                    this.ttid = wVAppParams.ttid;
                }
                this.imei = wVAppParams.imei;
                this.imsi = wVAppParams.imsi;
                this.deviceId = wVAppParams.deviceId;
                this.appKey = wVAppParams.appKey;
                this.appSecret = wVAppParams.appSecret;
                this.appTag = wVAppParams.appTag;
                this.appVersion = wVAppParams.appVersion;
                setUcsdkappkeySec(wVAppParams.ucsdkappkeySec);
                if (!TextUtils.isEmpty(wVAppParams.ucLibDir)) {
                    this.ucLibDir = wVAppParams.ucLibDir;
                }
                if (!TextUtils.isEmpty(wVAppParams.uc7ZPath)) {
                    this.uc7ZPath = wVAppParams.uc7ZPath;
                }
                this.ucSdkInternationalEnv = wVAppParams.ucSdkInternationalEnv;
                this.needSpeed = wVAppParams.needSpeed;
                this.zcacheSpeed = wVAppParams.zcacheSpeed;
                this.openUCDebug = wVAppParams.openUCDebug;
                UCHASettings uCHASettings = wVAppParams.ucHASettings;
                if (uCHASettings != null) {
                    this.ucHASettings = uCHASettings;
                }
                UCHASettings.ConfigRate configRate = wVAppParams.configRates;
                if (configRate != null) {
                    this.configRates = configRate;
                }
                this.zcacheOldConfig = wVAppParams.zcacheOldConfig;
                this.zcacheType3 = wVAppParams.zcacheType3;
                this.open4GDownload = wVAppParams.open4GDownload;
                this.open5GDownload = wVAppParams.open5GDownload;
                this.ucCoreOuterControl = wVAppParams.ucCoreOuterControl;
                this.ucCoreWaitMills = wVAppParams.ucCoreWaitMills;
                this.deleteCorePolicy = wVAppParams.deleteCorePolicy;
                this.disableMultiUnknownCrash = wVAppParams.disableMultiUnknownCrash;
                this.useGlobalUrlConfig = wVAppParams.useGlobalUrlConfig;
                this.ucDownloadChecker = wVAppParams.ucDownloadChecker;
                this.reducePermission = wVAppParams.reducePermission;
                return true;
            }
            throw new NullPointerException("initParams error, appKey is empty");
        }
        return false;
    }

    public boolean isDisableMultiUnknownCrash() {
        return this.disableMultiUnknownCrash;
    }

    public boolean isOpen4GDownload() {
        return this.open4GDownload;
    }

    public boolean isOpen5GDownload() {
        return this.open5GDownload;
    }

    public boolean isUcCoreOuterControl() {
        return this.ucCoreOuterControl;
    }

    public boolean isUcSdkInternationalEnv() {
        return this.ucSdkInternationalEnv;
    }

    public boolean isUseGlobalUrlConfig() {
        return this.useGlobalUrlConfig;
    }

    public boolean isZcacheType3() {
        return this.zcacheType3;
    }

    public boolean needSpeed() {
        return this.needSpeed;
    }

    public boolean openUCDebug() {
        return this.openUCDebug;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupVersion(String str) {
        this.groupVersion = str;
    }

    public void setInjectCode(int i) {
        if (this.injected == 2) {
            return;
        }
        this.injected = i;
    }

    public void setUc7ZPath(String str) {
        this.uc7ZPath = str;
    }

    public void setUcsdkappkeySec(String[] strArr) {
        if (strArr != null) {
            this.ucsdkappkeySec = strArr;
        }
    }

    public boolean useZcacheOldConfig() {
        return this.zcacheOldConfig;
    }
}
