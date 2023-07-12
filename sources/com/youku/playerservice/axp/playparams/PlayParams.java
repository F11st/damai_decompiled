package com.youku.playerservice.axp.playparams;

import android.text.TextUtils;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.playinfo.PlayInfoLiveResponse;
import com.youku.playerservice.axp.playinfo.request.task.UpsProxyInfo;
import com.youku.playerservice.axp.utils.SessionUtil;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.constants.TableField;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayParams {
    private Map<String, String> mExtConfigMap;
    private boolean mIsForcePlay;
    private boolean mIsUseSystemPlayer;
    private PlayIdParams mPlayIdParams;
    private PlayDefinition.PlayScene mPlayScene;
    private PlayDefinition.PlayType mPlayType;
    private PlayUrlParams mPlayUrlParams;
    private boolean mReusedPlayer;
    private String mSessionId;
    private long mStartTime;
    private Map<String, String> mStringMap;
    private UpsProxyInfo mUpsProxyInfo;
    private final IVpmInfo mVpmInfo;

    private PlayParams(PlayDefinition.PlayType playType, PlayDefinition.PlayScene playScene, PlayIdParams playIdParams) {
        this.mStartTime = -1L;
        this.mIsForcePlay = true;
        this.mReusedPlayer = true;
        this.mIsUseSystemPlayer = false;
        this.mStringMap = new ConcurrentHashMap();
        this.mExtConfigMap = new HashMap();
        this.mVpmInfo = new IVpmInfo() { // from class: com.youku.playerservice.axp.playparams.PlayParams.1
            @Override // com.youku.vpm.IMonitor
            public double getDouble(String str, double d) {
                return PlayParams.this.getDouble(str, d);
            }

            @Override // com.youku.vpm.IExt, com.youku.vpm.IMonitor
            public String getString(String str, String str2) {
                return PlayParams.this.getString(str, str2);
            }

            @Override // com.youku.vpm.IVpmInfo
            public Object getTag(String str) {
                return PlayParams.this.getTag(str);
            }
        };
        this.mPlayType = playType;
        this.mPlayScene = playScene;
        this.mPlayIdParams = playIdParams;
        this.mSessionId = SessionUtil.create(playIdParams.getPlayId());
    }

    private PlayParams(PlayDefinition.PlayType playType, PlayDefinition.PlayScene playScene, PlayUrlParams playUrlParams) {
        this.mStartTime = -1L;
        this.mIsForcePlay = true;
        this.mReusedPlayer = true;
        this.mIsUseSystemPlayer = false;
        this.mStringMap = new ConcurrentHashMap();
        this.mExtConfigMap = new HashMap();
        this.mVpmInfo = new IVpmInfo() { // from class: com.youku.playerservice.axp.playparams.PlayParams.1
            @Override // com.youku.vpm.IMonitor
            public double getDouble(String str, double d) {
                return PlayParams.this.getDouble(str, d);
            }

            @Override // com.youku.vpm.IExt, com.youku.vpm.IMonitor
            public String getString(String str, String str2) {
                return PlayParams.this.getString(str, str2);
            }

            @Override // com.youku.vpm.IVpmInfo
            public Object getTag(String str) {
                return PlayParams.this.getTag(str);
            }
        };
        this.mPlayType = playType;
        this.mPlayScene = playScene;
        this.mPlayUrlParams = playUrlParams;
        this.mSessionId = SessionUtil.create("url");
    }

    public static PlayParams createPlayParams(PlayDefinition.PlayType playType, PlayDefinition.PlayScene playScene, PlayIdParams playIdParams) {
        return new PlayParams(playType, playScene, playIdParams);
    }

    public static PlayParams createPlayParams(PlayDefinition.PlayType playType, PlayDefinition.PlayScene playScene, PlayUrlParams playUrlParams) {
        return new PlayParams(playType, playScene, playUrlParams);
    }

    public boolean copyParamsTo(PlayParams playParams) {
        for (Map.Entry<String, String> entry : this.mStringMap.entrySet()) {
            playParams.putString(entry.getKey(), entry.getValue());
        }
        return true;
    }

    public boolean equals(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(this.mStringMap.get(str));
    }

    public double getDouble(String str, double d) {
        return d;
    }

    public Map<String, String> getExtConfigMap() {
        return this.mExtConfigMap;
    }

    public PlayIdParams getPlayIdParams() {
        return this.mPlayIdParams;
    }

    public PlayDefinition.PlayScene getPlayScene() {
        return this.mPlayScene;
    }

    public PlayDefinition.PlayType getPlayType() {
        return this.mPlayType;
    }

    public PlayUrlParams getPlayUrlParams() {
        return this.mPlayUrlParams;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        PlayIdParams playIdParams;
        PlayIdParams playIdParams2;
        if (TextUtils.equals(str, "vid")) {
            if (this.mPlayType == PlayDefinition.PlayType.VOD) {
                PlayIdParams playIdParams3 = this.mPlayIdParams;
                if (playIdParams3 != null) {
                    return playIdParams3.getPlayId();
                }
                PlayUrlParams playUrlParams = this.mPlayUrlParams;
                if (playUrlParams != null) {
                    return playUrlParams.getPlayUrl();
                }
            } else {
                PlayIdParams playIdParams4 = this.mPlayIdParams;
                if (playIdParams4 != null) {
                    return playIdParams4.getString(PlayInfoLiveResponse.SCREEN_ID);
                }
            }
        } else if (TextUtils.equals(str, "showId")) {
            if (this.mPlayType == PlayDefinition.PlayType.LIVE && (playIdParams2 = this.mPlayIdParams) != null) {
                return playIdParams2.getPlayId();
            }
        } else if (TextUtils.equals(str, TableField.VIDEO_TYPE) && (playIdParams = this.mPlayIdParams) != null) {
            return playIdParams.getString(TableField.VIDEO_TYPE);
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1204930704:
                if (str.equals("requestQuality")) {
                    c = 0;
                    break;
                }
                break;
            case 607796817:
                if (str.equals("sessionId")) {
                    c = 1;
                    break;
                }
                break;
            case 2140463422:
                if (str.equals(TableField.MEDIA_TYPE)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                PlayIdParams playIdParams5 = this.mPlayIdParams;
                if (playIdParams5 != null) {
                    return playIdParams5.getRequestQuality().toString();
                }
                return null;
            case 1:
                return this.mSessionId;
            case 2:
                return this.mPlayType.getType() + "";
            default:
                String str3 = this.mStringMap.get(str);
                return str3 != null ? str3 : str2;
        }
    }

    public Object getTag(String str) {
        return null;
    }

    public UpsProxyInfo getUpsProxyInfo() {
        return this.mUpsProxyInfo;
    }

    public IVpmInfo getVpmInfo() {
        return this.mVpmInfo;
    }

    public boolean isForcePlay() {
        return this.mIsForcePlay;
    }

    public boolean isReusedPlayer() {
        return this.mReusedPlayer;
    }

    public boolean isUseSystemPlayer() {
        return this.mIsUseSystemPlayer;
    }

    public void putExtConfig(String str, String str2) {
        this.mExtConfigMap.put(str, str2);
    }

    public void putString(String str, String str2) {
        if (str2 != null) {
            this.mStringMap.put(str, str2);
        } else {
            this.mStringMap.remove(str);
        }
    }

    public void setForcePlay(boolean z) {
        this.mIsForcePlay = z;
    }

    public void setReusedPlayer(boolean z) {
        this.mReusedPlayer = z;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setUpsProxyInfo(UpsProxyInfo upsProxyInfo) {
        this.mUpsProxyInfo = upsProxyInfo;
    }

    public void setUseSystemPlayer(boolean z) {
        this.mIsUseSystemPlayer = z;
    }

    public String toString() {
        StringBuilder sb;
        String str = "playType=" + this.mPlayType + " startTime=" + this.mStartTime + " isForcePlay=" + this.mIsForcePlay;
        PlayIdParams playIdParams = this.mPlayIdParams;
        if (playIdParams != null) {
            String str2 = !TextUtils.isEmpty(playIdParams.getPlayUrl()) ? "url" : !TextUtils.isEmpty(this.mPlayIdParams.getPlayJson()) ? Preloader.KEY_JSON : "id";
            if (this.mPlayType == PlayDefinition.PlayType.LIVE) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(" quality=");
                sb.append(this.mPlayIdParams.getRequestLiveQuality());
            } else {
                sb = new StringBuilder();
                sb.append(str + " quality=" + this.mPlayIdParams.getRequestQuality());
                sb.append(" langCode=");
                sb.append(this.mPlayIdParams.getLanguageCode());
            }
            return (sb.toString() + " type=" + str2) + " isLocalPlay=" + this.mPlayIdParams.isLocalPlay();
        }
        return str;
    }
}
