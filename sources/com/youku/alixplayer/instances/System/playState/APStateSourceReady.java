package com.youku.alixplayer.instances.System.playState;

import android.util.Log;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.System.model.SystemPlayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class APStateSourceReady extends APAbsBaseState {
    private SystemPlayList mPlaylist;

    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public void enterAction(IAlixPlayer.State state) {
        Log.d("StateSourceReady", "setDataSource playlist");
        super.enterAction(state);
        this.mAndroidPlayer.setDataSource(this.mPlaylist);
    }

    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_SOURCE_READY;
    }

    public void setPlaylist(SystemPlayList systemPlayList) {
        this.mPlaylist = systemPlayList;
    }
}
