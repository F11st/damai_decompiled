package com.youku.alixplayer.opensdk;

import android.view.Surface;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnAdEventListener;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.OnVideoSizeChangedListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.resize.IResizer;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IPlayer {
    void addOnAdEventListener(OnAdEventListener onAdEventListener);

    void addOnCurrentPositionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener);

    void addOnInfoListener(OnInfoListener onInfoListener);

    void addOnPlayerStateListener(OnStateChangeListener onStateChangeListener);

    void addOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void clearAllListener();

    @Deprecated
    void enableVoice(int i);

    long getCurrentPosition();

    long getCurrentPosition(Aliplayer.PositionType positionType);

    IAlixPlayer.State getCurrentState();

    long getDuration();

    List<OnStateChangeListener> getOnPlayerStateListeners();

    List<OnVideoSizeChangedListener> getOnVideoSizeChangedListeners();

    IResizer getResizer();

    int getVideoHeight();

    IVideoStream getVideoStream();

    int getVideoWidth();

    boolean isMuted();

    void pause();

    void release();

    void replay();

    void seekTo(int i, int i2);

    void setDisplay(Surface surface);

    int setFilter(int i, Map<String, String> map);

    void setIsLoopPlay(boolean z);

    void setMute(boolean z);

    void setPlaybackParam(int i, String str);

    void setResizer(IResizer iResizer);

    int skipAd(int i);

    void start();

    void stop();
}
