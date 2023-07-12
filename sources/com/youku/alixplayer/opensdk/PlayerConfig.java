package com.youku.alixplayer.opensdk;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.alixplayer.opensdk.drm.DrmConfig;
import com.youku.alixplayer.opensdk.utils.Callable;
import com.youku.upsplayer.network.INetworkTask;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PlayerConfig {
    public static final int PLAYER_TYPE_ALIRTC = 1;
    public static final int PLAYER_TYPE_ALIX = 0;
    public static final int PLAYER_TYPE_OTHER = 3;
    public static final int PLAYER_TYPE_SYSTEM_PLAYER = 2;
    public static final int PLAYER_VIEW_TYPE_SURFACE_VIEW = 0;
    public static final int PLAYER_VIEW_TYPE_TEXTURE_VIEW = 1;
    private String mAppKey;
    private String mAppName;
    private String mAppSecret;
    private String mAppVersion;
    private String mClientId;
    private String mDecode;
    private DrmConfig mDrmConfig;
    private Callable<String> mDynamicProperties;
    private boolean mIsExternal;
    private boolean mIsUseHardwareDecode;
    private String mLiveCCode;
    private INetworkTask mNetworkTask;
    private String mPid;
    private String mPlayAbilityJson;
    private boolean mSupportH265;
    private String mUserAgent;
    private String mCCode = "01010101";
    private int mPlayerViewType = 0;
    private int mPlayerType = 0;
    private Bundle mBundle = new Bundle();
    private Map<String, String> mStringMap = new ConcurrentHashMap();
    private Map<String, Boolean> mSupportAbility = new ConcurrentHashMap<String, Boolean>() { // from class: com.youku.alixplayer.opensdk.PlayerConfig.1
        {
            put(FeatureManager.FEATURE_KEY_ABR, Boolean.TRUE);
        }
    };
    private Bundle mExtras = new Bundle();

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public String getCCode() {
        return this.mCCode;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getDecode() {
        return this.mDecode;
    }

    public DrmConfig getDrmConfig() {
        return this.mDrmConfig;
    }

    public Callable<String> getDynamicProperties() {
        return this.mDynamicProperties;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getLiveCCode() {
        return this.mLiveCCode;
    }

    public INetworkTask getNetworkTask() {
        return this.mNetworkTask;
    }

    public String getPid() {
        return this.mPid;
    }

    public String getPlayAbilityJson() {
        return this.mPlayAbilityJson;
    }

    public int getPlayerType() {
        return this.mPlayerType;
    }

    public int getPlayerViewType() {
        return this.mPlayerViewType;
    }

    public String getString(String str) {
        return this.mStringMap.get(str);
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public boolean isExternal() {
        return this.mIsExternal;
    }

    public boolean isSupport(String str) {
        Boolean bool = this.mSupportAbility.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isSupportH265() {
        return this.mSupportH265;
    }

    public boolean isUseHardwareDecode() {
        return this.mIsUseHardwareDecode;
    }

    public void putString(String str, String str2) {
        this.mStringMap.put(str, String.valueOf(str2));
    }

    public PlayerConfig setAppKey(String str) {
        this.mAppKey = str;
        return this;
    }

    public PlayerConfig setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public void setAppSecret(String str) {
        this.mAppSecret = str;
    }

    public PlayerConfig setAppVersion(String str) {
        this.mAppVersion = str;
        return this;
    }

    public PlayerConfig setCCode(String str) {
        this.mCCode = str;
        return this;
    }

    public PlayerConfig setClientId(String str) {
        this.mClientId = str;
        return this;
    }

    public PlayerConfig setDecode(String str) {
        this.mDecode = str;
        return this;
    }

    public void setDrmConfig(DrmConfig drmConfig) {
        this.mDrmConfig = drmConfig;
    }

    public PlayerConfig setDynamicProperties(Callable<String> callable) {
        this.mDynamicProperties = callable;
        return this;
    }

    public void setIsExternal(boolean z) {
        this.mIsExternal = z;
    }

    public PlayerConfig setLiveCCode(String str) {
        this.mLiveCCode = str;
        return this;
    }

    public void setNetworkTask(INetworkTask iNetworkTask) {
        this.mNetworkTask = iNetworkTask;
    }

    public PlayerConfig setPid(String str) {
        this.mPid = str;
        return this;
    }

    public void setPlayAbilityJson(String str) {
        this.mPlayAbilityJson = str;
    }

    public void setPlayerType(int i) {
        this.mPlayerType = i;
    }

    public PlayerConfig setPlayerViewType(int i) {
        this.mPlayerViewType = i;
        return this;
    }

    public void setSupport(String str, boolean z) {
        this.mSupportAbility.put(str, Boolean.valueOf(z));
    }

    public PlayerConfig setSupportH265(boolean z) {
        this.mSupportH265 = z;
        return this;
    }

    public PlayerConfig setUseHardwareDecode(boolean z) {
        this.mIsUseHardwareDecode = z;
        return this;
    }

    public PlayerConfig setUserAgent(String str) {
        this.mUserAgent = str;
        return this;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ccode:");
        sb.append(this.mCCode);
        if (!TextUtils.isEmpty(this.mLiveCCode)) {
            sb.append(" liveCCode:");
            sb.append(this.mLiveCCode);
        }
        sb.append(" appKey:");
        sb.append(this.mAppKey);
        sb.append(" appVersion:");
        sb.append(this.mAppVersion);
        DrmConfig drmConfig = this.mDrmConfig;
        if (drmConfig != null) {
            sb.append(drmConfig.toString());
        }
        return sb.toString();
    }
}
