package com.youku.alixplayer.instances;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.Keep;
import com.youku.alixplayer.IConfigCenter;
import com.youku.alixplayer.ILocalConfigCenter;
import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.middleware.IRenderMiddleware;
import com.youku.alixplayer.model.Identity;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.util.Destructable;
import com.youku.alixplayer.util.SystemSoLoader;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class Aliplayer implements Destructable {
    private boolean mHasConfig;
    private long mNativeId;
    private OnPlayerHostUpdateListener mOnPlayerHostUpdateListener;
    private OnPlayerP2PListener mOnPlayerP2PListener;
    private Reporter mReporter;
    private WeakReference<Aliplayer> mWeakThis;
    private OnPlayerEventListener playerEventListener;

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes.dex */
    public interface OnPlayerEventListener {
        void onNotify(Identity identity, int i, int i2, int i3, Object obj);
    }

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes.dex */
    public static abstract class OnPlayerHostUpdateListener implements Destructable {
        private long mNativeId = init();

        static {
            SystemSoLoader.load("alixplayer");
        }

        public native void deinit();

        @Override // com.youku.alixplayer.util.Destructable
        public void destruct() {
            deinit();
        }

        public abstract String getDomain(String str, String str2);

        public native long init();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnPlayerP2PListener {
        boolean shouldSupportP2P();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum PlayerCategory {
        ALIPLAYER,
        MIXED_CODECS_PLAYER,
        RAPHAELPLAYER
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum PositionType {
        NORMAL,
        VIDEO_TRACK,
        ACCURATE
    }

    static {
        SystemSoLoader.load("alixplayer");
    }

    public Aliplayer() {
        this(PlayerCategory.MIXED_CODECS_PLAYER);
    }

    private Aliplayer(long j) {
        this.mNativeId = j;
    }

    public Aliplayer(PlayerCategory playerCategory) {
        WeakReference<Aliplayer> weakReference = new WeakReference<>(this);
        this.mWeakThis = weakReference;
        this.mNativeId = init(weakReference, playerCategory.ordinal());
    }

    private native long init(WeakReference<Aliplayer> weakReference, int i);

    private native void nativeSetDataSource(Playlist playlist);

    private native void nativeSetOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener);

    @Keep
    private static boolean shouldSupportP2P(Object obj) {
        Aliplayer aliplayer;
        OnPlayerP2PListener onPlayerP2PListener;
        if (obj == null || !(obj instanceof WeakReference) || (aliplayer = (Aliplayer) ((WeakReference) obj).get()) == null || (onPlayerP2PListener = aliplayer.mOnPlayerP2PListener) == null) {
            return false;
        }
        return onPlayerP2PListener.shouldSupportP2P();
    }

    public native void addDataSource(Playlist playlist, int i);

    public native void addIsolatePeriod(Period period);

    public native void addRenderMiddleware(IRenderMiddleware iRenderMiddleware);

    public native void changeVideoSize(int i, int i2);

    public native void deinit();

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        removeOnPlayerHostUpdateListener();
        deinit();
    }

    public native void enableAudioPipeline(boolean z);

    public native void enableVideoPipeline(boolean z);

    public native void generateCacheFile(String str, String str2);

    public native String getAbility(int i);

    public native double getAvgKeyFrameSize();

    public native double getAvgVideoBitrate();

    public long getCurrentPosition(PositionType positionType) {
        return getCurrentPositionNative(positionType.ordinal());
    }

    public native long getCurrentPositionNative(int i);

    public native int getCurrentRenderType();

    public native float getCurrentZoomScale();

    public native int getDownloadSpeed(int[] iArr);

    public native long getDuration();

    public native String getGlobalInfoByKey(int i);

    public native String getParameterString(int i);

    public native String getPlayerInfoByKey(int i);

    public native double getVideoFrameRate();

    public native int getVideoHeight();

    public native int getVideoWidth();

    public native float getVolume();

    public Reporter getmReporter() {
        return this.mReporter;
    }

    public void goNext() {
        goNext(false);
    }

    public native void goNext(boolean z);

    public native void nativeRemovePlayerHostUpdateListener();

    public native void nativeSetPlayerHostUpdateListener(OnPlayerHostUpdateListener onPlayerHostUpdateListener);

    public native void panGuesture(int i, float f, float f2);

    public native void pause();

    public native void playIsolatePeriod();

    public native void prepare();

    public native float querySixDofAngle();

    public native void release();

    public native void removeIsolatePeriod(int i);

    public void removeOnP2pToCdnChangeListener() {
        this.mOnPlayerP2PListener = null;
    }

    public void removeOnPlayerHostUpdateListener() {
        nativeRemovePlayerHostUpdateListener();
        this.mOnPlayerHostUpdateListener = null;
    }

    public native void removeRenderMiddleware(IRenderMiddleware iRenderMiddleware);

    public native void resetIsolatePeriod();

    public native int screenShotMultiFramesBegin(String str, int i, int i2, Period period, long j, long j2, int i3);

    public native int screenShotMultiFramesEnd(int i, int i2, long j, long j2, int i3, Object obj);

    public native int screenShotOneFrame(AssetManager assetManager, String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, int i7);

    public native void seek(int i, int i2);

    @Deprecated
    public native void setAudioCallback(Object obj);

    public native void setAudioEnhance(boolean z);

    public native void setAudioInfo(int i, int i2);

    public native void setAudioMute(int i);

    public native void setBinocularMode(boolean z);

    public native void setBitmap(Map<String, String> map, Bitmap bitmap);

    public native void setColorBlindType(int i, int i2);

    public native void setCommonParams(Map<String, String> map);

    public void setConfig(IConfigCenter iConfigCenter, ILocalConfigCenter iLocalConfigCenter) {
        if (this.mHasConfig) {
            return;
        }
        this.mHasConfig = true;
        setConfigure(iConfigCenter, iLocalConfigCenter);
    }

    public native void setConfigure(IConfigCenter iConfigCenter, ILocalConfigCenter iLocalConfigCenter);

    public void setDataSource(Playlist playlist) {
        nativeSetDataSource(playlist);
        nativeSetOnPlayerEventListener(this.playerEventListener);
    }

    public native void setDomainStrategyAfterNetChanged(Object obj);

    public native void setEnhanceMode(boolean z, float f, float f2);

    public void setExtraParams(Map<Object, Object> map) {
    }

    public native void setFilter(int i, Object obj);

    public native void setGyroscopeActive(boolean z);

    public native void setInterfaceOrientation(int i);

    public native void setLaifengTSMode(boolean z);

    public native void setLiveSEIGettingMode(boolean z);

    public native void setLooping(boolean z);

    public native void setNightMode(int i);

    public void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener) {
        this.playerEventListener = onPlayerEventListener;
        nativeSetOnPlayerEventListener(onPlayerEventListener);
    }

    public void setOnPlayerHostUpdateListener(OnPlayerHostUpdateListener onPlayerHostUpdateListener) {
        this.mOnPlayerHostUpdateListener = onPlayerHostUpdateListener;
        nativeSetPlayerHostUpdateListener(onPlayerHostUpdateListener);
    }

    public void setOnPlayerP2PListener(OnPlayerP2PListener onPlayerP2PListener) {
        this.mOnPlayerP2PListener = onPlayerP2PListener;
    }

    public native void setPickCenter(float f, boolean z);

    public native void setPickRotate(float f, boolean z);

    public native void setPlaySpeed(double d);

    public native void setPlaybackMode(int i);

    public native void setPlaybackParam(int i, String str);

    public native void setRenderVideo(boolean z);

    public void setReporter(Reporter reporter) {
        this.mReporter = reporter;
        setReporterNative(reporter);
    }

    public native void setReporterNative(Reporter reporter);

    public native void setRotationMatrix(int i, float[] fArr);

    public native void setSurface(Surface surface);

    public native void setTcConfigParam(int i);

    public native void setUserAgent(String str);

    public native void setVideoRendCutMode(int i, float f, float f2);

    public native void setVideoRendCutMode(int i, Map<String, String> map);

    public native void setVideoRendMove(float f, float f2);

    public native void setVideoSuperResolution(int i);

    public native void setVideoVisionIndex(int i);

    public native void setVolume(float f);

    public native void setZoom(int i, double d, double d2, double d3);

    public native void setZoomPickWind(int i, int i2, float f, float f2, float f3, float f4);

    public native void start();

    public native void stop();

    public native void stopIsolatePeriod();

    public native void switchPlayerMode(int i, int i2);
}
