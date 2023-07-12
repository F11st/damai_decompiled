package com.youku.alixplayer.instances.System.playState;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.System.AndroidPlayer;
import com.youku.alixplayer.instances.System.playState.APIState;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class APAbsBaseState implements APIState {
    protected AndroidPlayer mAndroidPlayer;
    protected List<APIState.IStateListener> mStateListeners = new CopyOnWriteArrayList();

    @Override // com.youku.alixplayer.instances.System.playState.APIState
    public void addStateListener(APIState.IStateListener iStateListener) {
        this.mStateListeners.add(iStateListener);
    }

    @Override // com.youku.alixplayer.instances.System.playState.APIState
    public void enterAction(IAlixPlayer.State state) {
        for (APIState.IStateListener iStateListener : this.mStateListeners) {
            iStateListener.onEnter();
        }
    }

    @Override // com.youku.alixplayer.instances.System.playState.APIState
    public abstract IAlixPlayer.State getState();

    @Override // com.youku.alixplayer.instances.System.playState.APIState
    public void outerAction() {
        for (APIState.IStateListener iStateListener : this.mStateListeners) {
            iStateListener.onOuter();
        }
    }

    @Override // com.youku.alixplayer.instances.System.playState.APIState
    public void setAndroidPlayer(AndroidPlayer androidPlayer) {
        this.mAndroidPlayer = androidPlayer;
    }
}
