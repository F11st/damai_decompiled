package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.interceptor.Interceptor;
import com.youku.alixplayer.opensdk.statistics.IPlayerTrack;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IPlayerContainer {
    void addChangeVideoListener(OnChangeVideoListener onChangeVideoListener);

    void addInterceptor(Interceptor interceptor);

    void addPlayerErrorListener(OnPlayerErrorListener onPlayerErrorListener);

    void addPositionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener);

    void addVideoStreamListener(OnVideoStreamListener onVideoStreamListener);

    IBusinessTrack getBusinessTrack();

    IMultiPlayer getMultiPlayer();

    PlayVideoInfo getPlayVideoInfo();

    IPlayer getPlayer();

    IPlayerTrack getPlayerTrack();

    IVideoStream getVideoStream();

    List<OnVideoStreamListener> getVideoStreamListeners();

    void play(PlayVideoInfo playVideoInfo);

    void recyclePlayer();

    void release();

    void replay();

    void resetListeners();

    void setPlaylistBuilder(IPlaylistBuilder iPlaylistBuilder);

    void setVideoRequestFactory(IVideoRequest.Factory factory);

    boolean snapshot(int i, int i2, String str);

    void stop();
}
