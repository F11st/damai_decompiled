package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.opensdk.statistics.IPlayerTrack;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IMultiPlayerWrapper extends IMultiPlayer {
    <T extends IMediaSource & IVideoStream> Map<IPlayerWrapper, T> createPlayers(List<T> list);

    IAlixPlayer.State getCurrentState();

    IPlayerTrack getPlayerTrack();

    <T extends IMediaSource & IVideoStream> void play(Map<IPlayerWrapper, T> map);
}
