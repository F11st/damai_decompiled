package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.NoTraceTriggerHelper;
import com.taobao.accs.utl.Utils;
import com.youku.arch.v3.core.Constants;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsClientConfig implements Serializable {
    public static final String DEFAULT_CONFIGTAG = "default";
    public static final int SECURITY_OFF = 2;
    public static final int SECURITY_OPEN = 1;
    public static final int SECURITY_TAOBAO = 0;
    private static final String TAG = "AccsClientConfig";
    private static Context mContext;
    private boolean channelModeEnable;
    private boolean mAccsHeartbeatEnable;
    private String mAppKey;
    private String mAppSecret;
    private String mAuthCode;
    private boolean mAutoUnit;
    private String mChannelHost;
    private int mChannelPubKey;
    private int mConfigEnv;
    private boolean mDisableChannel;
    private boolean mForePingEnable;
    private String mInappHost;
    private int mInappPubKey;
    private boolean mKeepalive;
    private int mPingTimeout;
    private boolean mPullUpEnable;
    private boolean mQuickReconnect;
    private int mSecurity;
    private String mStoreId;
    private String mTag;
    private boolean regidEnable;
    public static final String[] DEFAULT_CENTER_HOSTS = {"msgacs.m.taobao.com", "msgacs.wapa.taobao.com", "msgacs.waptest.taobao.com"};
    private static final String[] DEFAULT_CHANNEL_HOSTS = {"accscdn.m.taobao.com", "jmacs.wapa.taobao.com", "jmacs.waptest.taobao.com"};
    public static boolean loadedStaticConfig = false;
    @ENV
    public static int mEnv = 0;
    public static Map<String, AccsClientConfig> mReleaseConfigs = new ConcurrentHashMap(1);
    public static Map<String, AccsClientConfig> mPreviewConfigs = new ConcurrentHashMap(1);
    public static Map<String, AccsClientConfig> mDebugConfigs = new ConcurrentHashMap(1);

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Builder {
        private String mAppKey = "";
        private String mTag = "";
        private String mAppSecret = "";
        private String mInappHost = "";
        private String mChannelHost = "";
        private String mAuthCode = "";
        private String mStoreId = "";
        private int mInappPubKey = -1;
        private int mChannelPubKey = -1;
        private boolean mKeepalive = true;
        private boolean mAutoUnit = true;
        private int mConfigEnv = -1;
        private boolean mDisableChannel = false;
        private boolean mQuickReconnect = false;
        private boolean mAccsHeartbeatEnable = false;
        private boolean mPullUpEnable = true;
        private boolean mForePingEnable = false;
        private boolean regidEnable = false;
        private boolean channelModeEnable = false;
        private int mPingTimeout = 0;
        private int mTriggerChannel = 0;

        public AccsClientConfig build() throws AccsException {
            Map<String, AccsClientConfig> map;
            if (!TextUtils.isEmpty(this.mAppKey)) {
                AccsClientConfig accsClientConfig = new AccsClientConfig();
                accsClientConfig.mAppKey = this.mAppKey;
                accsClientConfig.mAppSecret = this.mAppSecret;
                accsClientConfig.mAuthCode = this.mAuthCode;
                accsClientConfig.mKeepalive = this.mKeepalive;
                accsClientConfig.mAutoUnit = this.mAutoUnit;
                accsClientConfig.mInappPubKey = this.mInappPubKey;
                accsClientConfig.mChannelPubKey = this.mChannelPubKey;
                accsClientConfig.mInappHost = this.mInappHost;
                accsClientConfig.mChannelHost = this.mChannelHost;
                accsClientConfig.mTag = this.mTag;
                accsClientConfig.mStoreId = this.mStoreId;
                accsClientConfig.mConfigEnv = this.mConfigEnv;
                accsClientConfig.mDisableChannel = this.mDisableChannel;
                accsClientConfig.mQuickReconnect = this.mQuickReconnect;
                accsClientConfig.mAccsHeartbeatEnable = this.mAccsHeartbeatEnable;
                accsClientConfig.mPullUpEnable = this.mPullUpEnable;
                accsClientConfig.mForePingEnable = this.mForePingEnable;
                accsClientConfig.regidEnable = this.regidEnable;
                accsClientConfig.channelModeEnable = this.channelModeEnable;
                accsClientConfig.mPingTimeout = this.mPingTimeout;
                NoTraceTriggerHelper.channel = this.mTriggerChannel;
                if (accsClientConfig.mConfigEnv < 0) {
                    accsClientConfig.mConfigEnv = AccsClientConfig.mEnv;
                }
                if (TextUtils.isEmpty(accsClientConfig.mAppSecret)) {
                    accsClientConfig.mSecurity = 0;
                } else {
                    accsClientConfig.mSecurity = 2;
                }
                if (TextUtils.isEmpty(accsClientConfig.mInappHost)) {
                    accsClientConfig.mInappHost = AccsClientConfig.DEFAULT_CENTER_HOSTS[accsClientConfig.mConfigEnv];
                }
                if (TextUtils.isEmpty(accsClientConfig.mChannelHost)) {
                    accsClientConfig.mChannelHost = AccsClientConfig.DEFAULT_CHANNEL_HOSTS[accsClientConfig.mConfigEnv];
                }
                if (TextUtils.isEmpty(accsClientConfig.mTag)) {
                    accsClientConfig.mTag = "default";
                }
                int i = accsClientConfig.mConfigEnv;
                if (i == 1) {
                    map = AccsClientConfig.mPreviewConfigs;
                } else if (i != 2) {
                    map = AccsClientConfig.mReleaseConfigs;
                } else {
                    map = AccsClientConfig.mDebugConfigs;
                }
                ALog.d(AccsClientConfig.TAG, "build", Constants.CONFIG, accsClientConfig);
                AccsClientConfig accsClientConfig2 = map.get(accsClientConfig.getTag());
                if (accsClientConfig2 != null) {
                    ALog.w(AccsClientConfig.TAG, "build conver", "old config", accsClientConfig2);
                }
                map.put(accsClientConfig.getTag(), accsClientConfig);
                return accsClientConfig;
            }
            throw new AccsException("appkey null");
        }

        public Builder setAccsHeartbeatEnable(boolean z) {
            this.mAccsHeartbeatEnable = z;
            return this;
        }

        public Builder setAppKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public Builder setAppSecret(String str) {
            this.mAppSecret = str;
            return this;
        }

        public Builder setAutoCode(String str) {
            this.mAuthCode = str;
            return this;
        }

        public Builder setAutoUnit(boolean z) {
            this.mAutoUnit = z;
            return this;
        }

        public Builder setChannelHost(String str) {
            this.mChannelHost = str;
            return this;
        }

        public Builder setChannelModeEnable(boolean z) {
            this.channelModeEnable = z;
            return this;
        }

        public Builder setChannelPubKey(int i) {
            this.mChannelPubKey = i;
            return this;
        }

        public Builder setConfigEnv(@ENV int i) {
            this.mConfigEnv = i;
            return this;
        }

        public Builder setDisableChannel(boolean z) {
            this.mDisableChannel = z;
            return this;
        }

        public Builder setForePingEnable(boolean z) {
            this.mForePingEnable = z;
            return this;
        }

        public Builder setInappHost(String str) {
            this.mInappHost = str;
            return this;
        }

        public Builder setInappPubKey(int i) {
            this.mInappPubKey = i;
            return this;
        }

        public Builder setKeepAlive(boolean z) {
            this.mKeepalive = z;
            return this;
        }

        public Builder setPingTimeout(int i) {
            this.mPingTimeout = i;
            return this;
        }

        public Builder setPullUpEnable(boolean z) {
            this.mPullUpEnable = z;
            return this;
        }

        public Builder setQuickReconnect(boolean z) {
            this.mQuickReconnect = z;
            return this;
        }

        public Builder setRegidEnable(boolean z) {
            this.regidEnable = z;
            return this;
        }

        public Builder setStoreId(String str) {
            this.mStoreId = str;
            return this;
        }

        public Builder setTag(String str) {
            this.mTag = str;
            return this;
        }

        public Builder setTriggerChannel(int i) {
            this.mTriggerChannel = i;
            return this;
        }
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes8.dex */
    public @interface ENV {
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes8.dex */
    public @interface SECURITY_TYPE {
    }

    protected AccsClientConfig() {
    }

    @Deprecated
    public static AccsClientConfig getConfig(String str) {
        Map<String, AccsClientConfig> map;
        int i = mEnv;
        if (i == 1) {
            map = mPreviewConfigs;
        } else if (i != 2) {
            map = mReleaseConfigs;
        } else {
            map = mDebugConfigs;
        }
        for (AccsClientConfig accsClientConfig : map.values()) {
            if (accsClientConfig.mAppKey.equals(str) && accsClientConfig.mConfigEnv == mEnv) {
                return accsClientConfig;
            }
        }
        ALog.e(TAG, "getConfigByTag return null", "appkey", str);
        return null;
    }

    public static AccsClientConfig getConfigByTag(String str) {
        AccsClientConfig accsClientConfig;
        int i = mEnv;
        if (i == 0) {
            accsClientConfig = mReleaseConfigs.get(str);
        } else if (i == 1) {
            accsClientConfig = mPreviewConfigs.get(str);
        } else if (i != 2) {
            accsClientConfig = mReleaseConfigs.get(str);
        } else {
            accsClientConfig = mDebugConfigs.get(str);
        }
        if (accsClientConfig == null) {
            ALog.e(TAG, "getConfigByTag return null", com.taobao.accs.common.Constants.KEY_CONFIG_TAG, str);
        }
        return accsClientConfig;
    }

    public static Context getContext() {
        Context context = mContext;
        if (context != null) {
            return context;
        }
        synchronized (AccsClientConfig.class) {
            Context context2 = mContext;
            if (context2 != null) {
                return context2;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                mContext = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mContext;
        }
    }

    public static void setAccsConfig(int i, AccsClientConfig accsClientConfig) {
        Map<String, AccsClientConfig> map;
        if (i == 1) {
            map = mPreviewConfigs;
        } else if (i != 2) {
            map = mReleaseConfigs;
        } else {
            map = mDebugConfigs;
        }
        AccsClientConfig accsClientConfig2 = map.get(accsClientConfig.getTag());
        if (accsClientConfig2 != null) {
            ALog.w(TAG, "build conver", "old config", accsClientConfig2);
        }
        map.put(accsClientConfig.getTag(), accsClientConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccsClientConfig) {
            AccsClientConfig accsClientConfig = (AccsClientConfig) obj;
            return this.mSecurity == accsClientConfig.mSecurity && this.mInappPubKey == accsClientConfig.mInappPubKey && this.mChannelPubKey == accsClientConfig.mChannelPubKey && this.mKeepalive == accsClientConfig.mKeepalive && this.mAutoUnit == accsClientConfig.mAutoUnit && this.mConfigEnv == accsClientConfig.mConfigEnv && this.mDisableChannel == accsClientConfig.mDisableChannel && this.mQuickReconnect == accsClientConfig.mQuickReconnect && this.mAccsHeartbeatEnable == accsClientConfig.mAccsHeartbeatEnable && this.mPullUpEnable == accsClientConfig.mPullUpEnable && this.mForePingEnable == accsClientConfig.mForePingEnable && this.mPingTimeout == accsClientConfig.mPingTimeout && Utils.equals(this.mAppKey, accsClientConfig.mAppKey) && Utils.equals(this.mAppSecret, accsClientConfig.mAppSecret) && Utils.equals(this.mInappHost, accsClientConfig.mInappHost) && Utils.equals(this.mChannelHost, accsClientConfig.mChannelHost) && Utils.equals(this.mStoreId, accsClientConfig.mStoreId) && Utils.equals(this.mAuthCode, accsClientConfig.mAuthCode) && Utils.equals(this.mTag, accsClientConfig.mTag);
        }
        return false;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public String getAuthCode() {
        return this.mAuthCode;
    }

    public String getChannelHost() {
        return this.mChannelHost;
    }

    public int getChannelPubKey() {
        return this.mChannelPubKey;
    }

    public int getConfigEnv() {
        return this.mConfigEnv;
    }

    public boolean getDisableChannel() {
        return this.mDisableChannel;
    }

    public String getInappHost() {
        return this.mInappHost;
    }

    public int getInappPubKey() {
        return this.mInappPubKey;
    }

    public int getPingTimeout() {
        return this.mPingTimeout;
    }

    public int getSecurity() {
        return this.mSecurity;
    }

    public String getStoreId() {
        return this.mStoreId;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isAccsHeartbeatEnable() {
        return this.mAccsHeartbeatEnable;
    }

    public boolean isAutoUnit() {
        return this.mAutoUnit;
    }

    public boolean isChannelModeEnable() {
        return this.channelModeEnable;
    }

    public boolean isForePingEnable() {
        return this.mForePingEnable;
    }

    public boolean isKeepalive() {
        return this.mKeepalive;
    }

    public boolean isPullUpEnable() {
        return this.mPullUpEnable;
    }

    public boolean isQuickReconnect() {
        return this.mQuickReconnect;
    }

    public boolean isRegidEnable() {
        return this.regidEnable;
    }

    public void setForePingEnable(boolean z) {
        this.mForePingEnable = z;
    }

    public String toString() {
        return "AccsClientConfig{mAppKey='" + this.mAppKey + "', mAppSecret='" + this.mAppSecret + "', mInappHost='" + this.mInappHost + "', mChannelHost='" + this.mChannelHost + "', mStoreId='" + this.mStoreId + "', mSecurity=" + this.mSecurity + ", mAuthCode='" + this.mAuthCode + "', mInappPubKey=" + this.mInappPubKey + ", mChannelPubKey=" + this.mChannelPubKey + ", mKeepalive=" + this.mKeepalive + ", mAutoUnit=" + this.mAutoUnit + ", mTag='" + this.mTag + "', mConfigEnv=" + this.mConfigEnv + ", mDisableChannel=" + this.mDisableChannel + ", mQuickReconnect=" + this.mQuickReconnect + ", mAccsHeartbeatEnable=" + this.mAccsHeartbeatEnable + ", mPullUpEnable=" + this.mPullUpEnable + ", mForePingEnable=" + this.mForePingEnable + ", mPingTimeout=" + this.mPingTimeout + '}';
    }
}
