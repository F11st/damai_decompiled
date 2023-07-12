package com.youku.alixplayer.instances.System.playState;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.System.AndroidPlayer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface APIState {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface IStateListener {
        void onEnter();

        void onOuter();
    }

    void addStateListener(IStateListener iStateListener);

    void enterAction(IAlixPlayer.State state);

    IAlixPlayer.State getState();

    void outerAction();

    void setAndroidPlayer(AndroidPlayer androidPlayer);
}
