package com.youku.playerservice.axp.player;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerManager {
    private static final PlayerManager playerManager = new PlayerManager();
    private boolean mUseSystemPlayer = false;

    private PlayerManager() {
    }

    public static PlayerManager getInstance() {
        return playerManager;
    }

    public void setUseSystemPlayer(boolean z) {
        this.mUseSystemPlayer = z;
    }

    public boolean useSystemPlayer() {
        return this.mUseSystemPlayer;
    }
}
