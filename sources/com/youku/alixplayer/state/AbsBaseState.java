package com.youku.alixplayer.state;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.state.IState;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class AbsBaseState implements IState {
    protected Aliplayer mAliplayer;
    protected List<IState.IStateListener> mStateListeners = new CopyOnWriteArrayList();

    @Override // com.youku.alixplayer.state.IState
    public void addStateListener(IState.IStateListener iStateListener) {
        this.mStateListeners.add(iStateListener);
    }

    @Override // com.youku.alixplayer.state.IState
    public void enterAction(IAlixPlayer.State state) {
        for (IState.IStateListener iStateListener : this.mStateListeners) {
            iStateListener.onEnter();
        }
    }

    @Override // com.youku.alixplayer.state.IState
    public abstract IAlixPlayer.State getState();

    @Override // com.youku.alixplayer.state.IState
    public void outerAction() {
        for (IState.IStateListener iStateListener : this.mStateListeners) {
            iStateListener.onOuter();
        }
    }

    @Override // com.youku.alixplayer.state.IState
    public void setAliplayer(Aliplayer aliplayer) {
        this.mAliplayer = aliplayer;
    }
}
