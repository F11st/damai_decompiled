package com.youku.alixplayer.opensdk;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IMultiPlayer {
    IPlayer getPlayer(int i);

    List<IPlayer> getPlayers();

    void pause();

    void release();

    void setMute(boolean z);

    void setPlaybackParam(int i, String str);

    void start();

    void stop();
}
