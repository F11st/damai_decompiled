package com.youku.uplayer;

import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class OriginalMediaPlayer implements Mediaplayer {
    private OnADCountListener mOnADCountListener;
    private OnADPlayListener mOnADPlayListener;
    protected OnAudioSplitProgressListener mOnAudioSplitProgressListener;
    protected OnBufferPercentUpdateListener mOnBufferPercentUpdateListener;
    protected OnCdnSwitchListener mOnCdnSwitchListener;
    private OnCombineVideoListener mOnCombineVideoListener;
    private OnConnectDelayListener mOnConnectDelayListener;
    private OnCpuUsageListener mOnCpuUsageListener;
    private OnCurrentPositionUpdateListener mOnCurrentPositionUpdateListener;
    private OnDropVideoFramesListener mOnDropVideoFramesListener;
    private OnHttp302DelayListener mOnHttp302DelayListener;
    private OnHwDecodeErrorListener mOnHwDecodeErrorListener;
    private OnIsInitialListener mOnIsInitialListener;
    private OnLoadingStatusListener mOnLodingStatusListener;
    private OnLoadingStatusListenerNoTrack mOnLodingStatusListenerNoTrack;
    protected OnMediaEditorProgressListener mOnMediaEditorProgressListener;
    private OnMidADPlayListener mOnMidADPlayListener;
    private OnNativeShotDownListener mOnNativeShotDownListener;
    private OnNetworkErrorListener mOnNetworkErrorListener;
    private OnNetworkSpeedListener mOnNetworkSpeedListener;
    protected OnNetworkSpeedPerMinute mOnNetworkSpeedPerMinute;
    private OnPostADPlayListener mOnPostADPlayListener;
    private OnQualityChangeListener mOnQualityChangeListener;
    private OnRealVideoStartListener mOnRealVideoStartListener;
    private OnScreenShotFinishListener mOnScreenShotFinishListener;
    private OnSliceUpdateListener mOnSliceUpdateListener;
    private OnTimeoutListener mOnTimeoutListener;
    protected OnVideoCurrentIndexUpdateListener mOnVideoCurrentIndexUpdateListener;
    private OnVideoIndexUpdateListener mOnVideoIndexUpdateListener;
    protected OnVideoRealIpUpdateListener mOnVideoRealIpUpdateListener;

    public static int preloadDataSource(String str, int i) {
        return -1;
    }

    public int GetDownloadSpeed(int[] iArr) {
        return -1;
    }

    public void addDataSource(String str, Object obj) {
    }

    public void addDataSource(String str, String str2) {
    }

    public void addPostADUrl(String str, double d, int i, boolean z) {
    }

    public void audioMute(int i) {
    }

    public void changeVideoSize(int i, int i2) {
    }

    public int checkSource(String str) {
        return 0;
    }

    public void closePreloadDataSource(int i) {
    }

    public int combineVideoBegin(String str, int i, int i2, String str2, String str3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        return 0;
    }

    public int combineVideoEnd() {
        return 0;
    }

    public int cropOneFrame(int i, String str, int i2, int i3, int i4, int i5) {
        return 0;
    }

    public int generateCacheFile(String str, String str2) {
        return -1;
    }

    public double getAvgKeyFrameSize() {
        return 0.0d;
    }

    public double getAvgVideoBitrate() {
        return 0.0d;
    }

    public int getCurrentRenderType() {
        return 0;
    }

    public String getPlayerInfoByKey(int i) {
        return "";
    }

    public int getVideoCode() {
        return 0;
    }

    public double getVideoFrameRate() {
        return 0.0d;
    }

    public int getVoiceStatus() {
        return 1;
    }

    public float getVolume() {
        return -1.0f;
    }

    public OnAudioSplitProgressListener getmOnAudioSplitProgressListener() {
        return this.mOnAudioSplitProgressListener;
    }

    public void onAdInteract() {
    }

    public abstract void onSeekStart();

    public void panGuesture(int i, float f, float f2) {
    }

    public void pinchForZoom(int i, float f) {
    }

    public int playBackupAD(String str, int i) {
        return 0;
    }

    public void playMidADConfirm(int i, int i2) {
    }

    public void playPostAD() {
    }

    public void prepareMidAD() {
    }

    public void releaseSurface() {
    }

    public void resetPanoramic() {
    }

    public int screenShotMultiFramesBegin(String str, int i, int i2, String str2, long j, long j2, int i3) {
        return 0;
    }

    public int screenShotMultiFramesEnd(int i, int i2, long j, long j2, int i3, int i4, int i5, int i6, String str, int i7, int i8, int i9, int i10, int i11) {
        return 0;
    }

    public int screenShotOneFrame(AssetManager assetManager, String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, int i7) {
        return 0;
    }

    public void setAdjectiveSource(String str, Object obj, String str2, Object obj2) {
    }

    public int setAudioCallback(AudioCallback audioCallback) {
        return -1;
    }

    public void setAudioEnhance(boolean z) {
    }

    public int setAudioInfo(int i, int i2) {
        return 0;
    }

    public void setBinocularMode(boolean z) {
    }

    public int setColorBlindType(int i, int i2) {
        return 0;
    }

    public void setDataSource(String str, Object obj) {
    }

    public void setDataSource(String str, String str2) {
    }

    public void setEnhanceMode(boolean z, float f, float f2) {
    }

    public void setFilter(int i, Object obj) {
    }

    public void setGyroscope(float f, float f2, float f3, float f4) {
    }

    public void setGyroscopeActive(boolean z) {
    }

    public void setHttpUserAgent(String str) {
    }

    public void setInterfaceOrientation(int i) {
    }

    public void setLaifengTSMode(boolean z) {
    }

    public void setLiveSeiGettingMode(boolean z) {
    }

    public void setLoopingMode(boolean z) {
    }

    public void setMediaEditorProgressListener(OnMediaEditorProgressListener onMediaEditorProgressListener) {
        this.mOnMediaEditorProgressListener = onMediaEditorProgressListener;
    }

    public void setMidADDataSource(String str, Object obj) {
    }

    public void setMidADDataSource(String str, String str2) {
    }

    public void setNightMode(int i) {
    }

    public void setOnADCountListener(OnADCountListener onADCountListener) {
        this.mOnADCountListener = onADCountListener;
    }

    public void setOnADPlayListener(OnADPlayListener onADPlayListener) {
        this.mOnADPlayListener = onADPlayListener;
    }

    public void setOnBufferPercentUpdateListener(OnBufferPercentUpdateListener onBufferPercentUpdateListener) {
        this.mOnBufferPercentUpdateListener = onBufferPercentUpdateListener;
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    public void setOnCdnSwitchListener(OnCdnSwitchListener onCdnSwitchListener) {
        this.mOnCdnSwitchListener = onCdnSwitchListener;
    }

    public void setOnCombineVideoListener(OnCombineVideoListener onCombineVideoListener) {
        this.mOnCombineVideoListener = onCombineVideoListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
    }

    public void setOnConnectDelayListener(OnConnectDelayListener onConnectDelayListener) {
        this.mOnConnectDelayListener = onConnectDelayListener;
    }

    public void setOnCpuUsageListener(OnCpuUsageListener onCpuUsageListener) {
        this.mOnCpuUsageListener = onCpuUsageListener;
    }

    public void setOnCurrentPositionUpdateListener(OnCurrentPositionUpdateListener onCurrentPositionUpdateListener) {
        this.mOnCurrentPositionUpdateListener = onCurrentPositionUpdateListener;
    }

    public void setOnDropVideoFramesListener(OnDropVideoFramesListener onDropVideoFramesListener) {
        this.mOnDropVideoFramesListener = onDropVideoFramesListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
    }

    public void setOnHttp302DelayListener(OnHttp302DelayListener onHttp302DelayListener) {
        this.mOnHttp302DelayListener = onHttp302DelayListener;
    }

    public void setOnHwDecodeErrorListener(OnHwDecodeErrorListener onHwDecodeErrorListener) {
        this.mOnHwDecodeErrorListener = onHwDecodeErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
    }

    public void setOnIsInitialListener(OnIsInitialListener onIsInitialListener) {
        this.mOnIsInitialListener = onIsInitialListener;
    }

    public void setOnLodingStatusListener(OnLoadingStatusListener onLoadingStatusListener) {
        this.mOnLodingStatusListener = onLoadingStatusListener;
    }

    public void setOnMidADPlayListener(OnMidADPlayListener onMidADPlayListener) {
        this.mOnMidADPlayListener = onMidADPlayListener;
    }

    public void setOnNativeShotDownListener(OnNativeShotDownListener onNativeShotDownListener) {
        this.mOnNativeShotDownListener = onNativeShotDownListener;
    }

    public void setOnNetworkErrorListener(OnNetworkErrorListener onNetworkErrorListener) {
        this.mOnNetworkErrorListener = onNetworkErrorListener;
    }

    public void setOnNetworkSpeedListener(OnNetworkSpeedListener onNetworkSpeedListener) {
        this.mOnNetworkSpeedListener = onNetworkSpeedListener;
    }

    public void setOnNetworkSpeedPerMinute(OnNetworkSpeedPerMinute onNetworkSpeedPerMinute) {
        this.mOnNetworkSpeedPerMinute = onNetworkSpeedPerMinute;
    }

    public void setOnPostADPlayListener(OnPostADPlayListener onPostADPlayListener) {
        this.mOnPostADPlayListener = onPostADPlayListener;
    }

    public void setOnPreLoadPlayListener(OnPreLoadPlayListener onPreLoadPlayListener) {
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
    }

    public void setOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener) {
        this.mOnQualityChangeListener = onQualityChangeListener;
    }

    public void setOnRealVideoCompletionListener(OnRealVideoCompletionListener onRealVideoCompletionListener) {
    }

    public void setOnRealVideoStartListener(OnRealVideoStartListener onRealVideoStartListener) {
        this.mOnRealVideoStartListener = onRealVideoStartListener;
    }

    public void setOnScreenShotFinishListener(OnScreenShotFinishListener onScreenShotFinishListener) {
        this.mOnScreenShotFinishListener = onScreenShotFinishListener;
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
    }

    public void setOnSliceUpdateListener(OnSliceUpdateListener onSliceUpdateListener) {
        this.mOnSliceUpdateListener = onSliceUpdateListener;
    }

    public void setOnVideoCurrentIndexUpdateListener(OnVideoCurrentIndexUpdateListener onVideoCurrentIndexUpdateListener) {
        this.mOnVideoCurrentIndexUpdateListener = onVideoCurrentIndexUpdateListener;
    }

    public void setOnVideoIndexUpdateListener(OnVideoIndexUpdateListener onVideoIndexUpdateListener) {
        this.mOnVideoIndexUpdateListener = onVideoIndexUpdateListener;
    }

    public void setOnVideoRealIpUpdateListener(OnVideoRealIpUpdateListener onVideoRealIpUpdateListener) {
        this.mOnVideoRealIpUpdateListener = onVideoRealIpUpdateListener;
    }

    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
    }

    public void setPlayRate(int i) {
    }

    public void setPlaySpeed(double d) {
    }

    public void setPlaybackParam(int i, String str) {
    }

    public void setPreparedFlag(boolean z) {
    }

    public void setPursueVideoFrameType(int i) {
    }

    public void setRenderVideo(boolean z) {
    }

    public void setRotationMatrix(int i, float[] fArr) {
    }

    public void setSurface(Surface surface) {
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
    }

    public int setTcConfigParam(int i) {
        return 0;
    }

    public void setTimeout(int i, int i2) {
    }

    public void setUseHardwareDecode(boolean z) {
    }

    public void setVideoOrientation(int i) {
    }

    public void setVideoRendCutMode(int i, float f, float f2) {
    }

    public void setVideoRendMove(float f, float f2) {
    }

    public int setVideoVisionIndex(int i) {
        return 0;
    }

    public int setVolume(float f) {
        return -1;
    }

    public int setWaterMarkInfo(int i, String str, int i2, int i3, float f, float f2, float f3) {
        return -1;
    }

    public void setmOnAudioSplitProgressListener(OnAudioSplitProgressListener onAudioSplitProgressListener) {
        this.mOnAudioSplitProgressListener = onAudioSplitProgressListener;
    }

    public void setmOnLodingStatusListenerNoTrack(OnLoadingStatusListenerNoTrack onLoadingStatusListenerNoTrack) {
        this.mOnLodingStatusListenerNoTrack = onLoadingStatusListenerNoTrack;
    }

    public void setmOnTimeoutListener(OnTimeoutListener onTimeoutListener) {
        this.mOnTimeoutListener = onTimeoutListener;
    }

    public void skipAd(int i) {
    }

    public int startDetectImage(int i, int i2) {
        return 0;
    }

    public int stopDetectImage() {
        return 0;
    }

    public void stopVideoSurface(Surface surface) {
    }

    public int switchDataSource(String str, Object obj) {
        return 0;
    }

    public void switchPlayerMode(int i, int i2) {
    }
}
