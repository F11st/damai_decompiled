package com.youku.playerservice.axp.axpinterface;

import android.view.Surface;
import com.youku.vpm.IPlayerTrack;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IPlayerProtocol {
    void changeVideoSize(int i, int i2);

    Object doAction(PlayerAction playerAction, Map<String, Object> map);

    Object doAction(String str, Map<String, Object> map);

    long getCurrentPosition();

    float getCurrentZoomScale();

    int getDuration();

    double getPlaySpeed();

    IPlayerTrack getPlayerTrack();

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    void hideZoomPickWind();

    boolean isMuted();

    boolean isPaused();

    boolean isStarted();

    void pause();

    void release();

    void seekTo(int i, boolean z);

    void setAutoPlay(boolean z);

    void setDisplay(Surface surface);

    int setFilter(int i, Map<String, String> map);

    void setLooping(boolean z);

    void setMaxZoomScale(float f);

    void setMuted(boolean z);

    void setPlaySpeed(double d);

    void setPlaybackParam(int i, String str);

    void setVolume(float f);

    void setZoom(int i, double d, double d2, double d3);

    void showZoomPickWind(int i, float f, float f2, float f3, float f4);

    void skipAD(int i);

    void start();

    void stop();
}
