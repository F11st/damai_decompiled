package com.youku.alixplayer;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Surface;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.instances.PlayerQueue;
import com.youku.alixplayer.middleware.IDownloadMiddleware;
import com.youku.alixplayer.middleware.IRenderMiddleware;
import com.youku.alixplayer.model.Period;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class AbsAlixPlayer implements IAlixPlayer {
    @Override // com.youku.alixplayer.IAlixPlayer
    public void addDownloadMiddleware(IDownloadMiddleware iDownloadMiddleware) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnAdEventListener(OnAdEventListener onAdEventListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void addOnCurrentPositionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener);

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void addOnInfoListener(OnInfoListener onInfoListener);

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void addOnLoadingChangeListener(OnLoadingChangeListener onLoadingChangeListener);

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void addOnPlayerStateListener(OnStateChangeListener onStateChangeListener);

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void addOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener);

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void addOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void addOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addPostAd(Period period) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addRenderMiddleware(IRenderMiddleware iRenderMiddleware) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int addSubtitle(String str) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void applyDownloadMiddleware(Downloader downloader) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void applyRenderMiddleware(Render render) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void cancelPreloadMediaSource(String str) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void cancelPreloadMediaSourceList() {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void changeVideoSize(int i, int i2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void enableVoice(int i) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int generateCacheFile(String str, String str2) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public double getAvgKeyFrameSize() {
        return 0.0d;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public double getAvgVideoBitrate() {
        return 0.0d;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract long getCurrentPosition(Aliplayer.PositionType positionType);

    @Override // com.youku.alixplayer.IAlixPlayer
    public int getCurrentRenderType() {
        return -1;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract IAlixPlayer.State getCurrentState();

    @Override // com.youku.alixplayer.IAlixPlayer
    public float getCurrentZoomScale() {
        return 1.0f;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int getDownloadSpeed(int[] iArr) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract long getDuration();

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getGlobalInfoByKey(int i) {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public IMediaSource getHitPreloadMediaSource() {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public ILocalConfigCenter getLocalConfigCenter() {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public Aliplayer getMainPlayer() {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getPlayerInfoByKey(int i) {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public PlayerQueue getPlayerQueue() {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public List<String> getPreloadList() {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public Reporter getReporter() {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public double getVideoFrameRate() {
        return 0.0d;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract int getVideoHeight();

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract int getVideoWidth();

    @Override // com.youku.alixplayer.IAlixPlayer
    public float getVolume() {
        return 0.0f;
    }

    public abstract boolean isPlaying();

    @Override // com.youku.alixplayer.IAlixPlayer
    public void panGuesture(int i, float f, float f2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void pause();

    @Override // com.youku.alixplayer.IAlixPlayer
    public void playMidAd(Period period) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void preloadDataSource(IMediaSource iMediaSource, IPreloadListener iPreloadListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void prepareAsync();

    @Override // com.youku.alixplayer.IAlixPlayer
    public float querySixDofAngle() {
        return -1.0f;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void release();

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeRenderMiddleware(IRenderMiddleware iRenderMiddleware) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int screenShotMultiFramesBegin(String str, int i, int i2, Period period, int i3, int i4, int i5) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int screenShotMultiFramesEnd(int i, int i2, int i3, int i4, int i5, Map<String, String> map) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int screenShotOneFrame(AssetManager assetManager, String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, int i7) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void seekTo(int i, int i2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setAdjectiveSource(List<String> list, Bundle bundle, List<String> list2, Bundle bundle2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setAudioCallback(Object obj) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setAudioEnhance(boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setAudioInfo(int i, int i2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setBinocularMode(boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setCDNDomain(Map<String, String> map) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setColorBlindType(int i, int i2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setConfigCenter(IConfigCenter iConfigCenter) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void setDataSource(IMediaSource iMediaSource);

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void setDisplay(Surface surface);

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setDomainStrategyAfterNetChangedM(Object obj) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setEnhanceMode(boolean z, float f, float f2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int setFilter(int i, Map<String, String> map) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setGyroscopeActive(boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setInterfaceOrientation(int i) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setIsLoopPlay(boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setLaifengTSMode(int i) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setLiveSEIGettingMode(boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setMidAd(Period period) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setNightMode(int i) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnCurrentPostionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPickCenter(float f) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPickCenter(float f, boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPickRotate(float f) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPickRotate(float f, boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPlaySpeed(double d) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPlaybackParam(int i, String str) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int setPreloadMaxSize(int i) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setRenderVideo(boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setRotationMatrix(int i, float[] fArr) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setTcConfigParam(int i) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVideoRendCutMode(int i, float f, float f2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVideoRendCutMode(int i, Map<String, String> map) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVideoRendMove(float f, float f2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVideoSuperResolution(int i) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int setVideoVisionIndex(int i) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVolume(float f) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setZoom(int i, double d, double d2, double d3) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setZoomPickWind(int i, int i2, float f, float f2, float f3, float f4) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int skipAd(int i) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void start();

    @Override // com.youku.alixplayer.IAlixPlayer
    public abstract void stop();

    @Override // com.youku.alixplayer.IAlixPlayer
    public void stopMidAd(Period period) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void switchLiveDataSource(IMediaSource iMediaSource) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void switchPlayerMode(int i, int i2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void switchSubtitle(boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int switchSubtitleUrl(String str) {
        return 0;
    }
}
