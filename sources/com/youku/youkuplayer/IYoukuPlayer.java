package com.youku.youkuplayer;

import android.view.Surface;
import android.view.View;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayerAction;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.QualityStream;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.upsplayer.module.Trial;
import com.youku.upsplayer.module.User;
import com.youku.vpm.IPlayerTrack;
import com.youku.youkuplayer.data.PlayParam;
import com.youku.youkuplayer.plugin.ad.IAdAction;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IYoukuPlayer extends IAdAction {
    void addPlayerEventListener(YKEventListener yKEventListener);

    void changeVideoSize(int i, int i2);

    Object doAction(PlayerAction playerAction, Map<String, Object> map);

    long getCurrentPosition();

    Quality getCurrentQuality();

    int getDuration();

    List<String> getLangList();

    PlayInfo getPlayInfo();

    double getPlaySpeed();

    IPlayerTrack getPlayerTrack();

    List<QualityStream> getQualityList(String str);

    String getSessionId();

    Trial getTrialInfo();

    User getUserInfo();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    boolean isMuted();

    boolean isPaused();

    boolean isStarted();

    void pause();

    void playVideo(PlayParam playParam);

    void release();

    void requestWithParams(PlayParam playParam, IPlayInfoRequest.Callback callback);

    void requestWithParamsAlone(PlayParam playParam, IPlayInfoRequest.Callback callback);

    void seekTo(int i, boolean z);

    void setDisplay(Surface surface);

    int setFilter(int i, Map<String, String> map);

    void setLooping(boolean z);

    void setMuted(boolean z);

    void setPlaySpeed(double d);

    void setPlaybackParam(int i, String str);

    void setPositionFrenquency(int i);

    void setVolume(float f);

    void setWaterMarkImageView(IWaterMarkImageViewWrap iWaterMarkImageViewWrap);

    void start();

    void stop();

    void switchLanguage(String str);

    void switchQuality(Quality quality);

    void switchSceneId(String str);

    void switchTimeShifted(String str);
}
