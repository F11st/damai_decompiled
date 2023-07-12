package com.youku.alixplayer.raphael;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.youku.alixplayer.IConfigCenter;
import com.youku.alixplayer.ILocalConfigCenter;
import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.middleware.IRenderMiddleware;
import com.youku.alixplayer.model.Identity;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.raphael.RaphaelPlayerEngine;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class RaphaelPlayer extends Aliplayer {
    private RaphaelPlayerEngine engine;
    private Identity identity;
    private boolean mHasConfig;
    private Reporter mReporter;
    private Aliplayer.OnPlayerEventListener playerEventListener;
    private int position;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private RaphaelPlayerEngine.OnInfoListener mOnInfoListener = new RaphaelPlayerEngine.OnInfoListener() { // from class: com.youku.alixplayer.raphael.RaphaelPlayer.1
        public void onInfo(int i, int i2, int i3, Object obj) {
            int i4;
            int i5;
            if (i == 1000) {
                i = 1000;
            } else if (i == 1017) {
                i = 306;
            } else if (i == 1030) {
                RaphaelPlayer.this.mVideoWidth = i2;
                RaphaelPlayer.this.mVideoHeight = i3;
                i = 1030;
            } else if (i == 110011) {
                RaphaelPlayer.this.position = i3 / 90;
            } else if (i == 1003) {
                i = 701;
            } else if (i == 1004) {
                i = 702;
            }
            if (i < 60001 || i >= 60100) {
                i4 = i;
                i5 = i2;
            } else {
                i5 = i;
                i4 = 1002;
            }
            if (i4 == 110016) {
                RemoteLogger.log(RaphaelPlayer.class.getSimpleName(), obj.toString());
            }
            try {
                if (RaphaelPlayer.this.playerEventListener != null) {
                    RaphaelPlayer.this.playerEventListener.onNotify(RaphaelPlayer.this.identity, i4, i5, i3, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public RaphaelPlayer(Context context) {
        RaphaelPlayerEngine raphaelPlayerEngine = new RaphaelPlayerEngine(context);
        this.engine = raphaelPlayerEngine;
        raphaelPlayerEngine.setOnInfoListener(this.mOnInfoListener);
        this.identity = new IdentityExt(-1L);
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void addDataSource(Playlist playlist, int i) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void addIsolatePeriod(Period period) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void addRenderMiddleware(IRenderMiddleware iRenderMiddleware) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void changeVideoSize(int i, int i2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void deinit() {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer, com.youku.alixplayer.util.Destructable
    public void destruct() {
        removeOnPlayerHostUpdateListener();
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void enableAudioPipeline(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void enableVideoPipeline(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void generateCacheFile(String str, String str2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public String getAbility(int i) {
        return "";
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public double getAvgKeyFrameSize() {
        return 0.0d;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public double getAvgVideoBitrate() {
        return 0.0d;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public long getCurrentPosition(Aliplayer.PositionType positionType) {
        return this.position;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public long getCurrentPositionNative(int i) {
        return 0L;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public int getCurrentRenderType() {
        return -1;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public float getCurrentZoomScale() {
        return 0.0f;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public int getDownloadSpeed(int[] iArr) {
        return -1;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public long getDuration() {
        return 0L;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public String getGlobalInfoByKey(int i) {
        return "";
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public String getPlayerInfoByKey(int i) {
        return this.engine.getPlayerInfoByKey(i);
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public double getVideoFrameRate() {
        return 0.0d;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public float getVolume() {
        return 0.0f;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public Reporter getmReporter() {
        return this.mReporter;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void goNext() {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void panGuesture(int i, float f, float f2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void pause() {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void playIsolatePeriod() {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void prepare() {
        this.engine.prepareAsync();
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public float querySixDofAngle() {
        return 0.0f;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void release() {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void removeIsolatePeriod(int i) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void removeRenderMiddleware(IRenderMiddleware iRenderMiddleware) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void resetIsolatePeriod() {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public int screenShotMultiFramesBegin(String str, int i, int i2, Period period, long j, long j2, int i3) {
        return 0;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public int screenShotMultiFramesEnd(int i, int i2, long j, long j2, int i3, Object obj) {
        return 0;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public int screenShotOneFrame(AssetManager assetManager, String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, int i7) {
        return 0;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void seek(int i, int i2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    @Deprecated
    public void setAudioCallback(Object obj) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setAudioEnhance(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setAudioInfo(int i, int i2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setAudioMute(int i) {
        Log.d("RaphaelPlayer", "setAudioMute : " + i);
        this.engine.mute(i);
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setBinocularMode(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setColorBlindType(int i, int i2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setConfig(IConfigCenter iConfigCenter, ILocalConfigCenter iLocalConfigCenter) {
        if (this.mHasConfig) {
            return;
        }
        this.mHasConfig = true;
        setConfigure(iConfigCenter, iLocalConfigCenter);
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setConfigure(IConfigCenter iConfigCenter, ILocalConfigCenter iLocalConfigCenter) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setDataSource(Playlist playlist) {
        try {
            Period period = playlist.getPeriodList().get(0);
            String url = period.getSourceList().get(0).getUrl();
            HashMap hashMap = new HashMap();
            hashMap.put("serverIp", period.getHeader("rh_server_ip"));
            hashMap.put("udpPort", period.getHeader("rh_udp_port"));
            hashMap.put("edgeParam", period.getHeader("edge_param"));
            if (!TextUtils.isEmpty(period.getHeader("rh_url"))) {
                url = period.getHeader("rh_url");
            }
            this.engine.setDataSource(url, hashMap);
            Log.d("RaphaelPlayer", "setDataSource => url : " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setDomainStrategyAfterNetChanged(Object obj) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setEnhanceMode(boolean z, float f, float f2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setExtraParams(Map<Object, Object> map) {
        this.engine.setExtraParams(map);
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setFilter(int i, Object obj) {
        this.engine.setFilter(i, (Map) obj);
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setGyroscopeActive(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setInterfaceOrientation(int i) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setLaifengTSMode(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setLiveSEIGettingMode(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setLooping(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setNightMode(int i) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setOnPlayerEventListener(Aliplayer.OnPlayerEventListener onPlayerEventListener) {
        this.playerEventListener = onPlayerEventListener;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setPickCenter(float f, boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setPickRotate(float f, boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setPlaySpeed(double d) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setPlaybackMode(int i) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setPlaybackParam(int i, String str) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setRenderVideo(boolean z) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setReporter(Reporter reporter) {
        this.mReporter = reporter;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setReporterNative(Reporter reporter) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setRotationMatrix(int i, float[] fArr) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setSurface(Surface surface) {
        this.engine.setDisplay(surface);
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setTcConfigParam(int i) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setUserAgent(String str) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setVideoRendCutMode(int i, float f, float f2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setVideoRendCutMode(int i, Map<String, String> map) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setVideoRendMove(float f, float f2) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setVideoSuperResolution(int i) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setVideoVisionIndex(int i) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setVolume(float f) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setZoom(int i, double d, double d2, double d3) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void setZoomPickWind(int i, int i2, float f, float f2, float f3, float f4) {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void start() {
        this.engine.start();
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void stop() {
        this.engine.stop();
        this.engine.release();
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void stopIsolatePeriod() {
    }

    @Override // com.youku.alixplayer.instances.Aliplayer
    public void switchPlayerMode(int i, int i2) {
    }
}
