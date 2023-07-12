package com.youku.playerservice.axp;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.phenix.request.ImageStatistics;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.vpm.Callable;
import com.youku.vpm.constants.TableField;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class PlayerConfig {
    private String mAppKey;
    private String mAppSecret;
    private String mCCode;
    private Context mContext;
    private DrmConfig mDrmConfig;
    private Callable mDynamicProperties;
    private boolean mIsDebug;
    private int mPlayerViewType;
    private String mUserAgent;
    private PlayDefinition.NetworkType mNetworkType = PlayDefinition.NetworkType.MTOP;
    private int mPositionFrequency = 100;
    private boolean mIsExternal = false;
    private PlayDefinition.PlayEnvironment mPlayEnvironment = PlayDefinition.PlayEnvironment.ONLINE;
    private Map<String, Boolean> mSupportAbility = new ConcurrentHashMap<String, Boolean>() { // from class: com.youku.playerservice.axp.PlayerConfig.1
        {
            put("abrPlay", Boolean.TRUE);
            put("h265", Boolean.FALSE);
        }
    };
    private Map<String, String> mStringMap = new ConcurrentHashMap();

    public PlayerConfig(Context context) {
        this.mContext = context;
    }

    public static PlayerConfig createPlayerConfig(Context context) {
        return createPlayerConfig(context, null);
    }

    public static PlayerConfig createPlayerConfig(Context context, String str) {
        PlayerConfig playerConfig = new PlayerConfig(context);
        String config = ConfigFetcher.getInstance().getConfig("player_config", ImageStatistics.KEY_BITMAP_DECODE, "H264");
        String config2 = ConfigFetcher.getInstance().getConfig("player_config", "decode_mode", "SW");
        playerConfig.setSupport("h265", "H265".equals(config));
        playerConfig.setSupport("hardwareDecode", "HW".equals(config2));
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            float parseFloat = Float.parseFloat(str);
            if (parseFloat >= 2.0f && parseFloat < 4.0f) {
                playerConfig.setSupport("h265", "H265".equals(config) && "H265".equals(ConfigFetcher.getInstance().getConfig("player_feed_config", ImageStatistics.KEY_BITMAP_DECODE, "H264")));
            }
        }
        playerConfig.putString(TableField.PLAYER_SOURCE, str);
        return playerConfig;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public String getCCode() {
        return this.mCCode;
    }

    public Context getContext() {
        return this.mContext;
    }

    public DrmConfig getDrmConfig() {
        return this.mDrmConfig;
    }

    public String getDynamicProperty(String str) {
        Object call;
        if (!this.mStringMap.containsKey(str) || TextUtils.isEmpty(this.mStringMap.get(str))) {
            Callable callable = this.mDynamicProperties;
            if (callable == null) {
                return null;
            }
            call = callable.call(str);
        } else {
            call = this.mStringMap.get(str);
        }
        return (String) call;
    }

    public PlayDefinition.NetworkType getNetworkType() {
        return this.mNetworkType;
    }

    public int getPlayerViewType() {
        return this.mPlayerViewType;
    }

    public int getPositionFrequency() {
        return this.mPositionFrequency;
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

    public PlayerConfig putString(String str, String str2) {
        this.mStringMap.put(str, String.valueOf(str2));
        return this;
    }

    public PlayerConfig setAppKey(String str) {
        this.mAppKey = str;
        return this;
    }

    public PlayerConfig setAppSecret(String str) {
        this.mAppSecret = str;
        return this;
    }

    public PlayerConfig setCCode(String str) {
        this.mCCode = str;
        return this;
    }

    public PlayerConfig setDebug(boolean z) {
        this.mIsDebug = z;
        return this;
    }

    public PlayerConfig setDrmConfig(DrmConfig drmConfig) {
        this.mDrmConfig = drmConfig;
        return this;
    }

    public PlayerConfig setDynamicProperties(Callable callable) {
        this.mDynamicProperties = callable;
        return this;
    }

    public void setExternal(boolean z) {
        this.mIsExternal = z;
    }

    public PlayerConfig setNetworkType(PlayDefinition.NetworkType networkType) {
        this.mNetworkType = networkType;
        return this;
    }

    public PlayerConfig setPlayEnvironment(PlayDefinition.PlayEnvironment playEnvironment) {
        this.mPlayEnvironment = playEnvironment;
        return this;
    }

    public PlayerConfig setPlayerViewType(int i) {
        this.mPlayerViewType = i;
        return this;
    }

    public void setPositionFrequency(int i) {
        this.mPositionFrequency = i;
    }

    public PlayerConfig setSupport(String str, boolean z) {
        this.mSupportAbility.put(str, Boolean.valueOf(z));
        return this;
    }

    public PlayerConfig setUserAgent(String str) {
        this.mUserAgent = str;
        return this;
    }
}
