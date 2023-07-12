package com.youku.youkuplayer;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.ut.device.UTDevice;
import com.ut.mini.IUTApplication;
import com.ut.mini.UTAnalytics;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;
import com.ut.mini.internal.UTTeamWork;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.PlayerService;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.IPlayerService;
import com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener;
import com.youku.playerservice.axp.axpinterface.PlayerAction;
import com.youku.playerservice.axp.axpinterface.PlayerEventListener;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.QualityStream;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.resize.OnResizerListener;
import com.youku.playerservice.axp.resize.ResizeView;
import com.youku.upsplayer.module.Trial;
import com.youku.upsplayer.module.User;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.vpm.IPlayerTrack;
import com.youku.vpm.proxy.UtProxy;
import com.youku.youkuplayer.data.PlayParam;
import com.youku.youkuplayer.data.YKPlayerConfig;
import com.youku.youkuplayer.plugin.ad.AdPlugin;
import com.youku.youkuplayer.plugin.watermark.WaterMarkPlugin;
import com.youku.youkuplayer.plugin.watermark.WaterMarkRootView;
import com.youku.youkuplayer.util.PlayerLog;
import com.youku.youkuplayer.util.PlayerSDKUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import ntk.dns.DnsEngine;
import ntk.dns.Util;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuPlayer implements OnResizerListener, IYoukuPlayer {
    private static final String TAG = "YoukuPlayer";
    private AdPlugin mAdPlugin;
    private Context mContext;
    private YKPlayerConfig mPlayerConfig;
    private IPlayerService mPlayerService;
    private ResizeView mResizeView;
    private Trial mTrial;
    private User mUser;
    private WaterMarkPlugin mWaterMarkPlugin;
    private List<String> mLangList = new ArrayList();
    private Map<String, List<QualityStream>> mQualityList = new HashMap();
    private List<YKEventListener> mEventListeners = new ArrayList();
    private PlayerEventListener mPlayerEventListener = new PlayerEventListener() { // from class: com.youku.youkuplayer.YoukuPlayer.3
        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onAdCountDown(int i) {
            PlayerLog.d(YoukuPlayer.TAG, "onAdCountDown...i " + i);
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onAdCountUpdate(i);
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onAdEnd(InternalPlayerEventListener.ADType aDType, int i) {
            PlayerLog.d(YoukuPlayer.TAG, "onAdEnd...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (YoukuPlayer.this.mEventListeners != null) {
                    yKEventListener.onAdEnd(aDType.getValue(), i);
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onAdStart(InternalPlayerEventListener.ADType aDType, int i) {
            PlayerLog.d(YoukuPlayer.TAG, "onAdStart...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onAdStart(aDType.getValue(), i, 0);
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onComplete() {
            PlayerLog.d(YoukuPlayer.TAG, "onComplete...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onComplete();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onEndLoading() {
            PlayerLog.d(YoukuPlayer.TAG, "onEndLoading...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onEndLoading();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onError(int i) {
            PlayerLog.d(YoukuPlayer.TAG, "errorCode...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onError(i);
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onInfo(int i, int i2, int i3, Object obj) {
            if (i == 4) {
                for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                    if (yKEventListener != null) {
                        yKEventListener.onSeekComplete();
                    }
                }
            } else if (i != 1031) {
                for (YKEventListener yKEventListener2 : YoukuPlayer.this.mEventListeners) {
                    if (yKEventListener2 != null) {
                        yKEventListener2.onInfo(i, i2, i3, obj);
                    }
                }
            } else {
                for (YKEventListener yKEventListener3 : YoukuPlayer.this.mEventListeners) {
                    if (yKEventListener3 != null) {
                        yKEventListener3.onBufferingUpdate(null, i2);
                    }
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.PlayerEventListener
        public void onNewRequest() {
            PlayerLog.d(YoukuPlayer.TAG, "onNewRequest...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onNewRequest();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onNotify(String str, Map<String, Object> map) {
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPause() {
            PlayerLog.d(YoukuPlayer.TAG, "onPause...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onPause();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.PlayerEventListener
        public void onPlayInfoResult(PlayInfoResult playInfoResult) {
            PlayerLog.d(YoukuPlayer.TAG, "onPlayInfoResult...");
            YoukuPlayer.this.initVideoInfo(playInfoResult);
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onPlayInfoResult(playInfoResult);
                }
            }
            if (playInfoResult.getError() != null) {
                for (YKEventListener yKEventListener2 : YoukuPlayer.this.mEventListeners) {
                    PlayInfoError error = playInfoResult.getError();
                    yKEventListener2.onDataFail(error.getErrorCode(), error.getErrorMsg(), null);
                }
                return;
            }
            for (YKEventListener yKEventListener3 : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener3 != null) {
                    yKEventListener3.onDataReady(playInfoResult);
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPositionChange(int i) {
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onPositionChange(i);
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPrepared() {
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onPrepared();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPreviewChange(Object obj) {
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPreviewEnd() {
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onQualityChangeFinish(boolean z, Object obj) {
            PlayerLog.d(YoukuPlayer.TAG, "onQualityChangeFinish...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onQualityChangeFinish(z, obj);
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onRealVideoStart() {
            PlayerLog.d(YoukuPlayer.TAG, "onRealVideoStart...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onRealVideoStart();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onRelease() {
            PlayerLog.d(YoukuPlayer.TAG, "onRelease...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onRelease();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onScreenShotError(int i) {
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onScreenShotFinished() {
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onScreenShotProgress(int i) {
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onScreenShotVideoEncoderMode(int i) {
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onSeekFinish(boolean z, @NonNull Map<String, String> map) {
            if (z) {
                for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                    if (yKEventListener != null) {
                        yKEventListener.onSeekComplete();
                    }
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onStart() {
            PlayerLog.d(YoukuPlayer.TAG, "onStart...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onStart();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onStartLoading() {
            PlayerLog.d(YoukuPlayer.TAG, "onStartLoading...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                if (yKEventListener != null) {
                    yKEventListener.onStartLoading();
                }
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onStop() {
            PlayerLog.d(YoukuPlayer.TAG, "onStop...");
            for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onVideoSizeChanged(int i, int i2) {
            PlayerLog.d(YoukuPlayer.TAG, "onVideoSizeChanged... width ： " + i + " ， height : " + i2);
            YoukuPlayer.this.mResizeView.refreshVideoSize(i, i2);
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface PlayerCallBack {
        void onAdClick(int i, String str);
    }

    public YoukuPlayer() {
    }

    private YoukuPlayer(Application application, YKPlayerConfig yKPlayerConfig, View view) {
        this.mContext = application.getApplicationContext();
        yKPlayerConfig = yKPlayerConfig == null ? new YKPlayerConfig(application) : yKPlayerConfig;
        fillDefaultConfig(yKPlayerConfig);
        this.mPlayerConfig = yKPlayerConfig;
        initPlayer();
        if (yKPlayerConfig.isExternal()) {
            UtProxy.getInstance().setExternal(true);
            initUT(application, yKPlayerConfig);
        }
    }

    public static IYoukuPlayer create(Application application, YKPlayerConfig yKPlayerConfig, View view) {
        return new YoukuPlayer(application, yKPlayerConfig, view);
    }

    private View createVideoView(int i) {
        return new TextureView(this.mContext);
    }

    private void enableUtTest(boolean z) {
        if (z) {
            String utdid = UTDevice.getUtdid(this.mContext);
            Log.d("UTAnalytics", "online test url: http://usertrack.alibaba-inc.com/validate/verify?debugKey=" + utdid);
            HashMap hashMap = new HashMap();
            hashMap.put("debug_api_url", "https://service-usertrack.alibaba-inc.com/upload_records_from_client");
            hashMap.put("debug_key", utdid);
            hashMap.put("debug_sampling_option", "true");
            UTTeamWork.getInstance().turnOnRealTimeDebug(hashMap);
        }
    }

    private void fillDefaultConfig(YKPlayerConfig yKPlayerConfig) {
        if (yKPlayerConfig == null) {
            return;
        }
        Map<String, String> extConfig = yKPlayerConfig.getExtConfig();
        if (!extConfig.containsKey("ykstream_version")) {
            yKPlayerConfig.putExtConfig("ykstream_version", "2");
        }
        if (extConfig.containsKey("ykstream_version_live")) {
            return;
        }
        yKPlayerConfig.putExtConfig("ykstream_version_live", "2");
    }

    private void initPlayer() {
        FeatureManager.getInstance().removeFeature(FeatureManager.FEATURE_KEY_FREE_FLOW);
        IPlayerService createPlayerService = PlayerService.createPlayerService(this.mPlayerConfig);
        this.mPlayerService = createPlayerService;
        createPlayerService.setPlayerEventListener(this.mPlayerEventListener);
        ResizeView resizeView = new ResizeView(this.mContext);
        this.mResizeView = resizeView;
        resizeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mResizeView.init(this.mPlayerService, 0, createVideoView(0));
        this.mResizeView.addOnResizerListener(this);
        if (!this.mPlayerConfig.isDisableAd()) {
            AdPlugin adPlugin = new AdPlugin(this.mContext, this.mPlayerService, this.mPlayerConfig);
            this.mAdPlugin = adPlugin;
            addPlayerEventListener(adPlugin);
            this.mAdPlugin.setCallback(new PlayerCallBack() { // from class: com.youku.youkuplayer.YoukuPlayer.1
                @Override // com.youku.youkuplayer.YoukuPlayer.PlayerCallBack
                public void onAdClick(int i, String str) {
                    if (YoukuPlayer.this.mEventListeners == null || YoukuPlayer.this.mEventListeners.isEmpty()) {
                        return;
                    }
                    for (YKEventListener yKEventListener : YoukuPlayer.this.mEventListeners) {
                        yKEventListener.onAdClick(i, str);
                    }
                }
            });
        }
        Util.setEnableAps(false);
        DnsEngine.getInstance().init(this.mContext);
        if (this.mPlayerConfig.isShowWalterPlugin()) {
            WaterMarkPlugin waterMarkPlugin = new WaterMarkPlugin(this.mContext);
            this.mWaterMarkPlugin = waterMarkPlugin;
            addPlayerEventListener(waterMarkPlugin);
            this.mResizeView.addView(this.mWaterMarkPlugin.getWaterMarkRootView());
        }
        PlayerLog.setDebugMode(this.mPlayerConfig.isShowLog());
        PlayerLog.d(TAG, "initPlayer...");
    }

    private void initUT(Application application, PlayerConfig playerConfig) {
        final String appName = PlayerSDKUtils.getAppName(application);
        final String appVersionName = PlayerSDKUtils.getAppVersionName(application);
        final String appKey = playerConfig.getAppKey();
        final String appSecret = playerConfig.getAppSecret();
        UTAnalytics.getInstance().setAppApplicationInstance(application, new IUTApplication() { // from class: com.youku.youkuplayer.YoukuPlayer.2
            @Override // com.ut.mini.IUTApplication
            public String getUTAppVersion() {
                return appVersionName;
            }

            @Override // com.ut.mini.IUTApplication
            public String getUTChannel() {
                return appName;
            }

            @Override // com.ut.mini.IUTApplication
            public IUTCrashCaughtListner getUTCrashCraughtListener() {
                return null;
            }

            @Override // com.ut.mini.IUTApplication
            public IUTRequestAuthentication getUTRequestAuthInstance() {
                return new UTBaseRequestAuthentication(appKey, appSecret);
            }

            @Override // com.ut.mini.IUTApplication
            public boolean isAliyunOsSystem() {
                return false;
            }

            @Override // com.ut.mini.IUTApplication
            public boolean isUTCrashHandlerDisable() {
                return true;
            }

            @Override // com.ut.mini.IUTApplication
            public boolean isUTLogEnable() {
                return YoukuPlayer.this.mPlayerConfig.isShowLog();
            }
        });
        AppMonitor.setSampling(10000);
        enableUtTest(this.mPlayerConfig.isShowLog());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initVideoInfo(PlayInfoResult playInfoResult) {
        if (playInfoResult == null || playInfoResult.getPlayInfo() == null || playInfoResult.getPlayInfo().getPlayInfoResponse() == null) {
            return;
        }
        PlayInfoResponse playInfoResponse = playInfoResult.getPlayInfo().getPlayInfoResponse();
        Map<String, List<QualityStream>> qualityList = playInfoResponse.getQualityList(null);
        this.mLangList.clear();
        this.mQualityList.clear();
        if (qualityList != null && !qualityList.isEmpty()) {
            for (String str : qualityList.keySet()) {
                this.mLangList.add(str);
                this.mQualityList.put(str, qualityList.get(str));
            }
        }
        if (playInfoResponse.getUpsInfo() == null || playInfoResponse.getUpsInfo().getVideoInfo() == null) {
            return;
        }
        VideoInfo videoInfo = playInfoResponse.getUpsInfo().getVideoInfo();
        this.mTrial = videoInfo.getTrial();
        this.mUser = videoInfo.getUser();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void addPlayerEventListener(YKEventListener yKEventListener) {
        this.mEventListeners.add(yKEventListener);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void changeVideoSize(int i, int i2) {
        this.mPlayerService.changeVideoSize(i, i2);
    }

    @Override // com.youku.youkuplayer.plugin.ad.IAdAction
    public void clickAd(int i) {
        AdPlugin adPlugin = this.mAdPlugin;
        if (adPlugin != null) {
            adPlugin.clickAd(i);
        }
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public Object doAction(PlayerAction playerAction, Map<String, Object> map) {
        return this.mPlayerService.doAction(playerAction, map);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public long getCurrentPosition() {
        return (int) this.mPlayerService.getCurrentPosition();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public Quality getCurrentQuality() {
        return this.mPlayerService.getCurrentQuality();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public int getDuration() {
        return this.mPlayerService.getDuration();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public List<String> getLangList() {
        return this.mLangList;
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public PlayInfo getPlayInfo() {
        return this.mPlayerService.getPlayInfo();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public double getPlaySpeed() {
        return this.mPlayerService.getPlaySpeed();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public IPlayerTrack getPlayerTrack() {
        return this.mPlayerService.getPlayerTrack();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public List<QualityStream> getQualityList(String str) {
        Map<String, List<QualityStream>> map = this.mQualityList;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public String getSessionId() {
        IPlayerService iPlayerService = this.mPlayerService;
        return (iPlayerService == null || iPlayerService.getPlayInfo() == null || this.mPlayerService.getPlayInfo().getPlayParams() == null) ? "" : this.mPlayerService.getPlayInfo().getPlayParams().getSessionId();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public Trial getTrialInfo() {
        return this.mTrial;
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public User getUserInfo() {
        return this.mUser;
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public int getVideoHeight() {
        return this.mPlayerService.getVideoHeight();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public int getVideoWidth() {
        return this.mPlayerService.getVideoWidth();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public View getView() {
        return this.mResizeView;
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public float getVolume() {
        return this.mPlayerService.getVolume();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public boolean isMuted() {
        return this.mPlayerService.isMuted();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public boolean isPaused() {
        return this.mPlayerService.isPaused();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public boolean isStarted() {
        return this.mPlayerService.isStarted();
    }

    @Override // com.youku.playerservice.axp.resize.OnResizerListener
    public void onSizeChanged(int i, int i2) {
        for (YKEventListener yKEventListener : this.mEventListeners) {
            if (yKEventListener != null) {
                yKEventListener.onVideoSizeChanged(i, i2);
            }
        }
        this.mResizeView.setBackgroundColor(-16777216);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void pause() {
        this.mPlayerService.pause();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void playVideo(PlayParam playParam) {
        PlayParams convert = PlayerSDKUtils.convert(playParam, this.mPlayerConfig);
        this.mPlayerService.setAutoPlay(playParam.isAutoPlay());
        this.mPlayerService.playWithParams(convert);
        this.mPlayerService.setLooping(playParam.isLoopPlay());
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void release() {
        this.mPlayerService.release();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void requestWithParams(PlayParam playParam, IPlayInfoRequest.Callback callback) {
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void requestWithParamsAlone(PlayParam playParam, IPlayInfoRequest.Callback callback) {
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void seekTo(int i, boolean z) {
        this.mPlayerService.seekTo(i, z);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void setDisplay(Surface surface) {
        this.mPlayerService.setDisplay(surface);
    }

    public void setDynamicProperties(Callable<String> callable) {
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public int setFilter(int i, Map<String, String> map) {
        return this.mPlayerService.setFilter(i, map);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void setLooping(boolean z) {
        this.mPlayerService.setLooping(z);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void setMuted(boolean z) {
        this.mPlayerService.setMuted(z);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void setPlaySpeed(double d) {
        this.mPlayerService.setPlaySpeed(d);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void setPlaybackParam(int i, String str) {
        this.mPlayerService.setPlaybackParam(i, str);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void setPositionFrenquency(int i) {
        this.mPlayerService.setPositionFrenquency(i);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void setVolume(float f) {
        this.mPlayerService.setVolume(f);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void setWaterMarkImageView(IWaterMarkImageViewWrap iWaterMarkImageViewWrap) {
        YKPlayerConfig yKPlayerConfig = this.mPlayerConfig;
        if (yKPlayerConfig == null || !yKPlayerConfig.isShowWalterPlugin()) {
            return;
        }
        WaterMarkRootView waterMarkRootView = this.mWaterMarkPlugin.getWaterMarkRootView();
        if (iWaterMarkImageViewWrap != null) {
            waterMarkRootView.setExtWaterMarkImageView(iWaterMarkImageViewWrap);
        }
    }

    @Override // com.youku.youkuplayer.plugin.ad.IAdAction
    public int skipAd(int i) {
        PlayerLog.d(TAG, "skipAd...");
        AdPlugin adPlugin = this.mAdPlugin;
        if (adPlugin != null) {
            return adPlugin.skipAd(i);
        }
        return 0;
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void start() {
        this.mPlayerService.start();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void stop() {
        this.mPlayerService.stop();
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void switchLanguage(String str) {
        this.mPlayerService.switchLanguage(str);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void switchQuality(Quality quality) {
        this.mPlayerService.switchQuality(quality);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void switchSceneId(String str) {
        this.mPlayerService.switchSceneId(str);
    }

    @Override // com.youku.youkuplayer.IYoukuPlayer
    public void switchTimeShifted(String str) {
        this.mPlayerService.switchTimeShifted(str);
    }
}
