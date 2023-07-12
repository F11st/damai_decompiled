package com.youku.playerservice.axp.cache;

import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.playparams.PlayParams;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CachePreloadParams {
    private boolean isMutePlay = true;
    private boolean isNeedToPauseWhenSuccess = true;
    private AXPCacheAction mCacheAction;
    private String mGroupId;
    private PlayParams mPlayParams;
    private PlayerConfig mPlayerConfig;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum AXPCacheAction {
        AXPCACHEACTION_PLAYINFO_NORMAL(0),
        AXPCACHEACTION_PLAYINFO_MULTI(1),
        AXPCACHEACTION_MEDIASOURCE(2),
        AXPCACHEACTION_PLAYER(3);
        
        int type;

        AXPCacheAction(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    public AXPCacheAction getCacheAction() {
        return this.mCacheAction;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    public PlayerConfig getPlayerConfig() {
        return this.mPlayerConfig;
    }

    public boolean isMutePlay() {
        return this.isMutePlay;
    }

    public boolean isNeedToPauseWhenSuccess() {
        return this.isNeedToPauseWhenSuccess;
    }

    public void setCacheAction(AXPCacheAction aXPCacheAction) {
        this.mCacheAction = aXPCacheAction;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setMutePlay(boolean z) {
        this.isMutePlay = z;
    }

    public void setNeedToPauseWhenSuccess(boolean z) {
        this.isNeedToPauseWhenSuccess = z;
    }

    public void setPlayParams(PlayParams playParams) {
        this.mPlayParams = playParams;
    }

    public void setPlayerConfig(PlayerConfig playerConfig) {
        this.mPlayerConfig = playerConfig;
    }
}
