package com.youku.alixplayer.instances.System.playState;

import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class APStatePostAdPaused extends APAbsBaseState {
    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        this.mAndroidPlayer.pause();
    }

    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_POST_AD_PAUSED;
    }
}
