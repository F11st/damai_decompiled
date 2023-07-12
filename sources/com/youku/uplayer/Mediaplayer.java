package com.youku.uplayer;

import android.view.SurfaceHolder;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface Mediaplayer {
    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    void prepare();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(int i);

    void setAudioStreamType(int i);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setScreenOnWhilePlaying(boolean z);

    void start();

    void stop();
}
