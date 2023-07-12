package com.taobao.weex.bridge;

import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.base.CalledByNative;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import com.taobao.weex.utils.WXLogUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tb.oz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXParams implements Serializable {
    private String appName;
    private String appVersion;
    private String cacheDir;
    private String crashFilePath;
    private String deviceHeight;
    private String deviceModel;
    private String deviceWidth;
    private String layoutDirection;
    private String libIcuPath;
    private String libJsbPath;
    private String libJscPath;
    private String libJssPath;
    private String libLdPath;
    private String logLevel;
    private String needInitV8;
    private Map<String, String> options;
    private String osVersion;
    private String platform;
    private String shouldInfoCollect;
    private String useSingleProcess;
    private String weexVersion;

    @CalledByNative
    public String getAppName() {
        return this.appName;
    }

    @CalledByNative
    public String getAppVersion() {
        return this.appVersion;
    }

    @CalledByNative
    public String getCacheDir() {
        return this.cacheDir;
    }

    @CalledByNative
    public String getCrashFilePath() {
        WXLogUtils.e("WXParams", "getCrashFilePath:" + this.crashFilePath);
        return this.crashFilePath;
    }

    @CalledByNative
    public String getDeviceHeight() {
        return this.deviceHeight;
    }

    @CalledByNative
    public String getDeviceModel() {
        return this.deviceModel;
    }

    @CalledByNative
    public String getDeviceWidth() {
        return this.deviceWidth;
    }

    @CalledByNative
    public String getLayoutDirection() {
        return this.layoutDirection;
    }

    @CalledByNative
    public String getLibIcuPath() {
        WXLogUtils.e("getLibIcuPath is running " + this.libIcuPath);
        return this.libIcuPath;
    }

    @CalledByNative
    public String getLibJsbPath() {
        WXLogUtils.e("getLibJsbPath is running " + this.libJsbPath);
        return this.libJsbPath;
    }

    @CalledByNative
    public String getLibJscPath() {
        WXLogUtils.e("getLibJscPath is running " + this.libJscPath);
        return this.libJscPath;
    }

    @CalledByNative
    public String getLibJssPath() {
        WXLogUtils.e("getLibJssPath is running " + this.libJssPath);
        return this.libJssPath;
    }

    @CalledByNative
    public String getLibLdPath() {
        WXLogUtils.e("getLibLdPath is running " + this.libLdPath);
        return this.libLdPath;
    }

    public String getLogLevel() {
        String str = this.logLevel;
        return str == null ? "" : str;
    }

    public String getNeedInitV8() {
        String str = this.needInitV8;
        return str == null ? "" : str;
    }

    @CalledByNative
    public Object getOptions() {
        return this.options;
    }

    @CalledByNative
    public String getOsVersion() {
        return this.osVersion;
    }

    @CalledByNative
    public String getPlatform() {
        return this.platform;
    }

    @CalledByNative
    public boolean getReleaseMap() {
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J == null) {
            return false;
        }
        String configWhenInit = J.getConfigWhenInit(oz2.WXAPM_CONFIG_GROUP, "release_map", "true");
        WXLogUtils.e("getReleaseMap:" + configWhenInit);
        return "true".equalsIgnoreCase(configWhenInit);
    }

    public String getShouldInfoCollect() {
        return this.shouldInfoCollect;
    }

    @CalledByNative
    public String getUseRunTimeApi() {
        return String.valueOf(WXEnvironment.sUseRunTimeApi);
    }

    @CalledByNative
    public String getUseSingleProcess() {
        WXLogUtils.e("getUseSingleProcess is running " + this.useSingleProcess);
        return this.useSingleProcess;
    }

    @CalledByNative
    public String getWeexVersion() {
        return this.weexVersion;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setCacheDir(String str) {
        this.cacheDir = str;
    }

    public void setCrashFilePath(String str) {
        WXLogUtils.e("WXParams", "setCrashFilePath: " + str);
        this.crashFilePath = str;
    }

    public void setDeviceHeight(String str) {
        this.deviceHeight = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    @Deprecated
    public void setDeviceWidth(String str) {
        this.deviceWidth = str;
    }

    public void setLayoutDirection(String str) {
        this.layoutDirection = str;
    }

    public void setLibIcuPath(String str) {
        this.libIcuPath = str;
    }

    public void setLibJsbPath(String str) {
        this.libJsbPath = str;
    }

    public void setLibJscPath(String str) {
        this.libJscPath = str;
    }

    public void setLibJssPath(String str) {
        this.libJssPath = str;
    }

    public void setLibLdPath(String str) {
        this.libLdPath = str;
    }

    public void setLogLevel(String str) {
        this.logLevel = str;
    }

    public void setNeedInitV8(boolean z) {
        if (z) {
            this.needInitV8 = "1";
        } else {
            this.needInitV8 = "0";
        }
    }

    public void setOptions(Map<String, String> map) {
        this.options = map;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setShouldInfoCollect(String str) {
        this.shouldInfoCollect = str;
    }

    public void setUseSingleProcess(String str) {
        this.useSingleProcess = str;
    }

    public void setWeexVersion(String str) {
        this.weexVersion = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.appName);
        hashMap.put("appVersion", this.appVersion);
        hashMap.put(WXConfig.cacheDir, this.cacheDir);
        hashMap.put("deviceHeight", this.deviceHeight);
        hashMap.put(WXDebugConstants.ENV_DEVICE_MODEL, this.deviceModel);
        hashMap.put("deviceWidth", this.deviceWidth);
        hashMap.put(WXConfig.layoutDirection, this.layoutDirection);
        hashMap.put("libJssPath", this.libJssPath);
        hashMap.put("logLevel", this.logLevel);
        hashMap.put("needInitV8", this.needInitV8);
        hashMap.put("osVersion", this.osVersion);
        hashMap.put("platform", this.platform);
        hashMap.put("useSingleProcess", this.useSingleProcess);
        hashMap.put("shouldInfoCollect", this.shouldInfoCollect);
        hashMap.put("weexVersion", this.weexVersion);
        hashMap.put("crashFilePath", this.crashFilePath);
        hashMap.put("libJscPath", this.libJscPath);
        hashMap.put("libIcuPath", this.libIcuPath);
        hashMap.put("libLdPath", this.libLdPath);
        hashMap.put(WXBridgeManager.OPTIONS, this.options);
        hashMap.put("useRunTimeApi", Boolean.valueOf(WXEnvironment.sUseRunTimeApi));
        hashMap.put("__enable_native_promise__", Boolean.valueOf(!WXEnvironment.sUseRunTimeApi));
        return hashMap;
    }
}
