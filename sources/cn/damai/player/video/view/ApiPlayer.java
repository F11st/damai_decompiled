package cn.damai.player.video.view;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.listener.VideoListener;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ApiPlayer {
    int getDuration();

    @Nullable
    VideoInfo getPlayInfo();

    String getSessionId();

    void idle(VideoInfo videoInfo);

    boolean isMute();

    boolean isPaused();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void play(VideoInfo videoInfo);

    void release();

    void setListener(VideoListener videoListener);

    void start();

    void stop();
}
