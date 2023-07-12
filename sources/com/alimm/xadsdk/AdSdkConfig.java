package com.alimm.xadsdk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.xadsdk.base.expose.ExposeConfig;
import com.alimm.xadsdk.base.net.INetAdapter;
import com.alimm.xadsdk.base.ut.IUserTracker;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.request.AdRequestConfig;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdSdkConfig implements Serializable {
    private static final String TAG = "AdSdkConfig";
    private static final String VALUE_UNSET = "unset";
    private String mAppName;
    private String mCCode;
    private String mClientId;
    private Map<String, String> mExtend;
    private String mLicense;
    private boolean mNeedGetIpv4;
    private IUserTracker mUserTrackerImpl;
    private boolean mDebugMode = false;
    private String mAppSite = VALUE_UNSET;
    private String mAppPid = "";
    private int mDeviceType = 0;
    private boolean mUseHttps = false;
    private boolean mIsThirdPartyApp = false;
    private AdRequestConfig mRequestConfig = new AdRequestConfig();
    private ExposeConfig mExposeConfig = new ExposeConfig();

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppPid() {
        return this.mAppPid;
    }

    public String getAppSite() {
        return this.mAppSite;
    }

    public String getCCode() {
        return this.mCCode;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public ExposeConfig getExposeConfig() {
        return this.mExposeConfig;
    }

    public String getExtend(String str) {
        if (this.mExtend == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mExtend.get(str);
    }

    public String getLicense() {
        return this.mLicense;
    }

    public boolean getNeedGetIpv4() {
        return this.mNeedGetIpv4;
    }

    public AdRequestConfig getRequestConfig() {
        return this.mRequestConfig;
    }

    @Nullable
    public IUserTracker getUserTrackerImpl() {
        return this.mUserTrackerImpl;
    }

    public boolean isDebugMode() {
        return this.mDebugMode;
    }

    public boolean isThirdPartyApp() {
        return this.mIsThirdPartyApp;
    }

    public boolean isUseHttps() {
        return this.mUseHttps;
    }

    public AdSdkConfig putExtend(String str, String str2) {
        if (this.mExtend == null) {
            this.mExtend = new ConcurrentHashMap(16);
        }
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.mExtend.put(str, str2);
        }
        return this;
    }

    public AdSdkConfig setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public AdSdkConfig setAppPid(String str) {
        this.mAppPid = str;
        return this;
    }

    public AdSdkConfig setAppSite(String str) {
        this.mAppSite = str;
        return this;
    }

    public AdSdkConfig setCCode(String str) {
        this.mCCode = str;
        return this;
    }

    public AdSdkConfig setClientId(String str) {
        this.mClientId = str;
        return this;
    }

    public AdSdkConfig setDebugMode(boolean z) {
        this.mDebugMode = z;
        if (LogUtils.DEBUG) {
            LogUtils.i(TAG, "setDebugMode: debugMode = " + z);
        }
        return this;
    }

    public AdSdkConfig setDeviceType(int i) {
        this.mDeviceType = i;
        return this;
    }

    public AdSdkConfig setExposeNetAdapter(@NonNull INetAdapter iNetAdapter) {
        this.mExposeConfig.setNetAdapter(iNetAdapter);
        return this;
    }

    public AdSdkConfig setLicense(String str) {
        this.mLicense = str;
        return this;
    }

    public AdSdkConfig setNeedGetIpv4(boolean z) {
        this.mNeedGetIpv4 = z;
        return this;
    }

    public AdSdkConfig setOfflineExposeEnabled(boolean z) {
        this.mExposeConfig.setOfflineEnabled(z);
        return this;
    }

    public AdSdkConfig setRequestNetAdapter(@NonNull INetAdapter iNetAdapter) {
        this.mRequestConfig.setNetAdapter(iNetAdapter);
        return this;
    }

    public AdSdkConfig setThirdPartyApp(boolean z) {
        this.mIsThirdPartyApp = z;
        return this;
    }

    public AdSdkConfig setUseHttps(boolean z) {
        this.mUseHttps = z;
        return this;
    }

    public AdSdkConfig setUserTrackerImpl(@NonNull IUserTracker iUserTracker) {
        this.mUserTrackerImpl = iUserTracker;
        return this;
    }
}
