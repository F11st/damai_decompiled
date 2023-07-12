package com.youku.alixplayer.state;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.Aliplayer;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class StateReleased extends AbsBaseState {
    @Override // com.youku.alixplayer.state.AbsBaseState, com.youku.alixplayer.state.IState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.stop();
        }
    }

    @Override // com.youku.alixplayer.state.AbsBaseState, com.youku.alixplayer.state.IState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_RELEASED;
    }
}
