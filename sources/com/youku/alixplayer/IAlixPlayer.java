package com.youku.alixplayer;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Surface;
import com.youku.alixplayer.alirtc.OnAlixRtcInfoListener;
import com.youku.alixplayer.alirtc.OnRtcMessageListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.instances.PlayerQueue;
import com.youku.alixplayer.middleware.IDownloadMiddleware;
import com.youku.alixplayer.middleware.IRenderMiddleware;
import com.youku.alixplayer.model.Period;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IAlixPlayer {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum State {
        STATE_IDLE,
        STATE_SOURCE_GETTING,
        STATE_SOURCE_READY,
        STATE_SOURCE_FAILED,
        STATE_PREPARING,
        STATE_PREPARED,
        STATE_STARTING,
        STATE_VIDEO_STARTED,
        STATE_VIDEO_PAUSED,
        STATE_VIDEO_COMPLETED,
        STATE_PRE_AD_STARTED,
        STATE_PRE_AD_PAUSED,
        STATE_PRE_VIP_STARTED,
        STATE_PRE_VIP_PAUSED,
        STATE_MID_AD_STARTED,
        STATE_MID_AD_PAUSED,
        STATE_POST_AD_STARTED,
        STATE_POST_AD_PAUSED,
        STATE_POST_AD_COMPLETED,
        STATE_STOPPED,
        STATE_RELEASED,
        STATE_ERROR
    }

    void addDownloadMiddleware(IDownloadMiddleware iDownloadMiddleware);

    void addOnAdEventListener(OnAdEventListener onAdEventListener);

    void addOnCurrentPositionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener);

    void addOnInfoListener(OnInfoListener onInfoListener);

    void addOnLoadingChangeListener(OnLoadingChangeListener onLoadingChangeListener);

    void addOnPlayerStateListener(OnStateChangeListener onStateChangeListener);

    void addOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener);

    void addOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void addOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void addPostAd(Period period);

    void addRenderMiddleware(IRenderMiddleware iRenderMiddleware);

    int addSubtitle(String str);

    void applyDownloadMiddleware(Downloader downloader);

    void applyRenderMiddleware(Render render);

    void cancelPreloadMediaSource(String str);

    void cancelPreloadMediaSourceList();

    void changeVideoSize(int i, int i2);

    @Deprecated
    void enableVoice(int i);

    int generateCacheFile(String str, String str2);

    double getAvgKeyFrameSize();

    double getAvgVideoBitrate();

    IMediaSource getCurrentMediaSource();

    long getCurrentPosition(Aliplayer.PositionType positionType);

    int getCurrentRenderType();

    State getCurrentState();

    float getCurrentZoomScale();

    int getDownloadSpeed(int[] iArr);

    long getDuration();

    String getGlobalInfoByKey(int i);

    IMediaSource getHitPreloadMediaSource();

    AlixPlayerHolderUnbindListener getHolder();

    ILocalConfigCenter getLocalConfigCenter();

    Aliplayer getMainPlayer();

    String getParameterString(int i);

    String getPlayerId();

    String getPlayerInfoByKey(int i);

    PlayerQueue getPlayerQueue();

    List<String> getPreloadList();

    Reporter getReporter();

    double getVideoFrameRate();

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    boolean isMuted();

    boolean isReuse();

    void panGuesture(int i, float f, float f2);

    void pause();

    void playMidAd(Period period);

    void preloadDataSource(IMediaSource iMediaSource, IPreloadListener iPreloadListener);

    void prepareAsync();

    float querySixDofAngle();

    void release();

    void removeOnAdEventListener(OnAdEventListener onAdEventListener);

    void removeOnInfoListener(OnInfoListener onInfoListener);

    void removeOnPlayerStateListener(OnStateChangeListener onStateChangeListener);

    void removeOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener);

    void removeOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void removeOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void removeRenderMiddleware(IRenderMiddleware iRenderMiddleware);

    void reset();

    int screenShotMultiFramesBegin(String str, int i, int i2, Period period, int i3, int i4, int i5);

    int screenShotMultiFramesEnd(int i, int i2, int i3, int i4, int i5, Map<String, String> map);

    int screenShotOneFrame(AssetManager assetManager, String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, int i7);

    void seekTo(int i, int i2);

    void setAdjectiveSource(List<String> list, Bundle bundle, List<String> list2, Bundle bundle2);

    @Deprecated
    void setAudioCallback(Object obj);

    void setAudioEnhance(boolean z);

    void setAudioInfo(int i, int i2);

    void setBinocularMode(boolean z);

    void setCDNDomain(Map<String, String> map);

    void setColorBlindType(int i, int i2);

    void setConfigCenter(IConfigCenter iConfigCenter);

    void setDataSource(IMediaSource iMediaSource);

    void setDisplay(Surface surface);

    void setDomainStrategyAfterNetChangedM(Object obj);

    void setEnhanceMode(boolean z, float f, float f2);

    void setExtraParam(Map<Object, Object> map);

    int setFilter(int i, Map<String, String> map);

    void setGyroscopeActive(boolean z);

    void setHolder(AlixPlayerHolderUnbindListener alixPlayerHolderUnbindListener);

    void setInterfaceOrientation(int i);

    void setIsLoopPlay(boolean z);

    void setLaifengTSMode(int i);

    void setLiveSEIGettingMode(boolean z);

    void setMidAd(Period period);

    void setMute(boolean z);

    void setNightMode(int i);

    void setOnAlixRtcData(int i, Object obj);

    void setOnAlixRtcInfo(OnAlixRtcInfoListener onAlixRtcInfoListener);

    void setOnCurrentPostionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener);

    void setOnRtcMessageListener(OnRtcMessageListener onRtcMessageListener);

    void setPickCenter(float f);

    void setPickCenter(float f, boolean z);

    void setPickRotate(float f);

    void setPickRotate(float f, boolean z);

    void setPlaySpeed(double d);

    void setPlaybackParam(int i, String str);

    void setPlayerId(String str);

    int setPreloadMaxSize(int i);

    void setRenderVideo(boolean z);

    void setReuse(boolean z);

    void setRotationMatrix(int i, float[] fArr);

    void setTcConfigParam(int i);

    @Deprecated
    void setVideoRendCutMode(int i, float f, float f2);

    void setVideoRendCutMode(int i, Map<String, String> map);

    void setVideoRendMove(float f, float f2);

    void setVideoSuperResolution(int i);

    int setVideoVisionIndex(int i);

    void setVolume(float f);

    void setZoom(int i, double d, double d2, double d3);

    void setZoomPickWind(int i, int i2, float f, float f2, float f3, float f4);

    int skipAd(int i);

    void start();

    void stop();

    void stopMidAd(Period period);

    void switchLiveDataSource(IMediaSource iMediaSource);

    void switchPlayerMode(int i, int i2);

    void switchSubtitle(boolean z);

    int switchSubtitleUrl(String str);
}
