package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IPlayerWrapper extends IAlixPlayer, IPlayer {
    void firstStart();

    @Override // com.youku.alixplayer.IAlixPlayer
    void reset();

    <T extends IMediaSource & IVideoStream> void setVideoStream(T t);
}
