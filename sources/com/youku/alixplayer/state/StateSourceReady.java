package com.youku.alixplayer.state;

import android.util.Log;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.model.Playlist;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class StateSourceReady extends AbsBaseState {
    private Playlist mPlaylist;

    @Override // com.youku.alixplayer.state.AbsBaseState, com.youku.alixplayer.state.IState
    public void enterAction(IAlixPlayer.State state) {
        Log.d("StateSourceReady", "setDataSource playlist");
        super.enterAction(state);
        this.mAliplayer.setDataSource(this.mPlaylist);
    }

    @Override // com.youku.alixplayer.state.AbsBaseState, com.youku.alixplayer.state.IState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_SOURCE_READY;
    }

    public void setPlaylist(Playlist playlist) {
        this.mPlaylist = playlist;
    }
}
