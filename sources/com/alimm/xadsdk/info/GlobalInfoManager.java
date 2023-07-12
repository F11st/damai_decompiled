package com.alimm.xadsdk.info;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.AdSdkConfig;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.utils.DeviceUtils;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class GlobalInfoManager {
    private static final String AD_SDK_VERSION = "5.2.0";
    private static final String DEFAULT_UA_APP_NAME = "AliXAdSDK";
    private static final String TAG = "GlobalInfoManager";
    private Context mAppContext;
    private String mAppVersion;
    private DeviceInfo mDeviceInfo;
    private String mIpV4;
    private String mPackageName;
    private IRtInfoGetter mRtInfoGetter;
    private AdSdkConfig mSdkConfig;
    private String mUserAgent;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class SingletonHolder {
        static final GlobalInfoManager INSTANCE = new GlobalInfoManager();

        private SingletonHolder() {
        }
    }

    private GlobalInfoManager() {
        this.mAppContext = AdSdkManager.getInstance().getAppContext();
        this.mSdkConfig = AdSdkManager.getInstance().getConfig();
        this.mDeviceInfo = new DeviceInfo(this.mAppContext);
    }

    public static GlobalInfoManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private String getUserAgent(boolean z, String str) {
        if (TextUtils.isEmpty(this.mUserAgent)) {
            String appName = this.mSdkConfig.getAppName();
            if (TextUtils.isEmpty(appName)) {
                appName = DEFAULT_UA_APP_NAME;
            }
            this.mUserAgent = appName + ";" + str + ";Android;" + Build.VERSION.getRELEASE() + ";" + Build.getMODEL();
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getUserAgent: mUserAgent = " + this.mUserAgent);
            }
        }
        return this.mUserAgent;
    }

    @Nullable
    public String getAToken() {
        IRtInfoGetter iRtInfoGetter = this.mRtInfoGetter;
        return (iRtInfoGetter == null || iRtInfoGetter.getAToken() == null) ? "" : this.mRtInfoGetter.getAToken();
    }

    public String getAdSdkVersion() {
        return "5.2.0";
    }

    public String getAdvertisingId() {
        return this.mDeviceInfo.getAdvertisingId();
    }

    public String getAndroidId() {
        return this.mDeviceInfo.getAndroidId();
    }

    public int getAppStartType() {
        IRtInfoGetter iRtInfoGetter = this.mRtInfoGetter;
        if (iRtInfoGetter != null) {
            return iRtInfoGetter.getAppStartType();
        }
        return 0;
    }

    public String getAppVersion() {
        if (TextUtils.isEmpty(this.mAppVersion)) {
            this.mAppVersion = Utils.getVersionName(this.mAppContext);
        }
        return this.mAppVersion;
    }

    public int getAppWindowHeight() {
        if (isTablet()) {
            return Point.gety(DeviceUtils.getAppWindowSize(this.mAppContext));
        }
        int screenHeight = this.mDeviceInfo.getScreenHeight();
        return DeviceUtils.isNavigationBarShow(this.mAppContext) ? screenHeight - DeviceUtils.getNavigationBarHeight(this.mAppContext) : screenHeight;
    }

    @Nullable
    public String getClientCookie() {
        IRtInfoGetter iRtInfoGetter = this.mRtInfoGetter;
        return (iRtInfoGetter == null || iRtInfoGetter.getClientCookie() == null) ? "" : this.mRtInfoGetter.getClientCookie();
    }

    public String getDeviceType() {
        return this.mDeviceInfo.getDeviceType();
    }

    public String getImei() {
        return this.mDeviceInfo.getImei();
    }

    public String getIpV4() {
        return this.mIpV4;
    }

    public String getLicense() {
        return this.mSdkConfig.getLicense();
    }

    public String getMacAddress() {
        return this.mDeviceInfo.getMacAddress();
    }

    public String getNetworkOperatorName() {
        return this.mDeviceInfo.getNetworkOperatorName();
    }

    public String getOaid() {
        return this.mDeviceInfo.getOaid();
    }

    public String getOsType() {
        return this.mDeviceInfo.getOsType();
    }

    public String getOttSystemType() {
        return this.mDeviceInfo.getOttSystemType();
    }

    public String getPackageName() {
        if (TextUtils.isEmpty(this.mPackageName)) {
            this.mPackageName = this.mAppContext.getPackageName();
        }
        String str = this.mPackageName;
        return str != null ? str : "";
    }

    public String getPid() {
        return this.mSdkConfig.getAppPid();
    }

    @Nullable
    public String getPreviewAdAssetId() {
        IRtInfoGetter iRtInfoGetter = this.mRtInfoGetter;
        return (iRtInfoGetter == null || iRtInfoGetter.getPreviewAdAssetId() == null) ? "" : this.mRtInfoGetter.getPreviewAdAssetId();
    }

    public String getPublisherId() {
        return this.mSdkConfig.getAppSite();
    }

    public int getScreenHeight() {
        return this.mDeviceInfo.getScreenHeight();
    }

    public int getScreenWidth() {
        return this.mDeviceInfo.getScreenWidth();
    }

    @Nullable
    public String getStoken() {
        IRtInfoGetter iRtInfoGetter = this.mRtInfoGetter;
        return (iRtInfoGetter == null || iRtInfoGetter.getStoken() == null) ? "" : this.mRtInfoGetter.getStoken();
    }

    public String getUserAgent() {
        return getUserAgent(isTablet(), getAppVersion());
    }

    public String getUtdid() {
        return this.mDeviceInfo.getUtdid();
    }

    public String getUuid() {
        return this.mDeviceInfo.getUuid();
    }

    public boolean isTablet() {
        return this.mDeviceInfo.isTablet();
    }

    public void setIpV4(String str) {
        this.mIpV4 = str;
    }

    public void setRtInfoGetter(IRtInfoGetter iRtInfoGetter) {
        this.mRtInfoGetter = iRtInfoGetter;
    }
}
