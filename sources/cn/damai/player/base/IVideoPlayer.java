package cn.damai.player.base;

import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IVideoPlayer {
    void autoPlay();

    void enterFullScreen();

    boolean exitFullScreen();

    int getDuration();

    String getSessionId();

    boolean isFullScreen();

    boolean isPause();

    boolean isPlaying();

    void mute(int i);

    void pause(boolean z);

    void play();

    void release();

    void seek(int i);

    void setVideoData(VideoInfo videoInfo);

    void start();

    void stop();
}
