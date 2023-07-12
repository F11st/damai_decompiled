package com.youku.alixplayer.instances.System.playState;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.System.AndroidPlayer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class APStateReleased extends APAbsBaseState {
    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            androidPlayer.stop();
        }
    }

    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_RELEASED;
    }
}
