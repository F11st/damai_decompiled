package com.youku.alixplayer.state;

import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class StateError extends AbsBaseState {
    @Override // com.youku.alixplayer.state.AbsBaseState, com.youku.alixplayer.state.IState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_ERROR;
    }
}
