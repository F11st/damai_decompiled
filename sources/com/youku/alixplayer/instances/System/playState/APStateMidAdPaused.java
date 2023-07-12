package com.youku.alixplayer.instances.System.playState;

import android.util.Log;
import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class APStateMidAdPaused extends APAbsBaseState {
    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        Log.d("StateMidAdPaused", "pause()");
        this.mAndroidPlayer.pause();
    }

    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_MID_AD_PAUSED;
    }
}
