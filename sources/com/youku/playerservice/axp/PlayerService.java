package com.youku.playerservice.axp;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uc.webview.export.media.MessageID;
import com.youku.android.liveservice.bean.PlayerWidget;
import com.youku.android.liveservice.utils.ErrorCodeHelper;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol;
import com.youku.playerservice.axp.axpinterface.IPlayerProtocol;
import com.youku.playerservice.axp.axpinterface.IPlayerService;
import com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener;
import com.youku.playerservice.axp.axpinterface.MultiPlayerEventListener;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.axpinterface.PlayerAction;
import com.youku.playerservice.axp.axpinterface.PlayerEventListener;
import com.youku.playerservice.axp.axpinterface.SimplePlayerEventListener;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.cache.CachePool;
import com.youku.playerservice.axp.interceptor.Chain;
import com.youku.playerservice.axp.interceptor.Interceptor;
import com.youku.playerservice.axp.interceptor.RealInterceptionWrapper;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.LiveItem;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.SliceItem;
import com.youku.playerservice.axp.item.UrlItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.modules.history.HistoryDataUtil;
import com.youku.playerservice.axp.player.ErrorCode;
import com.youku.playerservice.axp.player.PlayerImpl;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoLiveResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.request.CacheRequest;
import com.youku.playerservice.axp.playinfo.request.LiveRequest;
import com.youku.playerservice.axp.playinfo.request.LiveWithCacheRequest;
import com.youku.playerservice.axp.playinfo.request.RealVideoRequest;
import com.youku.playerservice.axp.playinfo.request.UpsRequest;
import com.youku.playerservice.axp.playinfo.request.UpsWithCacheRequest;
import com.youku.playerservice.axp.playinforesult.PlayLiveInfoResult;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.playparams.PlayUrlParams;
import com.youku.playerservice.axp.postprocessing.PostProcessingConfigManager;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.BitStreamUtil;
import com.youku.playerservice.axp.utils.QualityUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.vip.info.VipUserService;
import com.youku.vpm.Callable;
import com.youku.vpm.IPlayerTrack;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.data.ExtrasInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerService implements IPlayerService {
    private Context mContext;
    protected volatile Handler mHandler;
    private HandlerThread mHandlerThread;
    private MultiPlayerEventListener mMultiPlayerEventListener;
    private List<IPlayerImplProtocol> mOtherPlayers;
    private PlayInfo mPlayInfo;
    private IPlayInfoRequest mPlayInfoRequest;
    private PlayParams mPlayParams;
    private IPlayerImplProtocol mPlayer;
    private PlayerConfig mPlayerConfig;
    private PlayerEventListener mPlayerEventListener;
    private IPlayerTrack mPlayerTrack;
    private final InternalPlayerEventListener mPrimaryPlayerEventListener;
    private IPlayInfoRequest mRealVideoRequest;
    private IPlayInfoRequest mReplacementInfoRequest;
    private VodItem mTempItemFrom;
    private VodItem mTempItemTo;
    private List<Interceptor> mInterceptors = new CopyOnWriteArrayList();
    private final IPlayInfoRequest.Callback mPlayInfoRequestCallback = new IPlayInfoRequest.Callback() { // from class: com.youku.playerservice.axp.PlayerService.11
        @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
        public void onFinished(final PlayParams playParams, List<PlayInfoResponse> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            final PlayInfoResponse playInfoResponse = list.get(0);
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.11.1
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.onPlayInfoRequestFinished(playParams, playInfoResponse);
                }
            });
        }
    };
    private final IPlayInfoRequest.Callback mReplacementRequestCallback = new IPlayInfoRequest.Callback() { // from class: com.youku.playerservice.axp.PlayerService.12
        @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
        public void onFinished(final PlayParams playParams, List<PlayInfoResponse> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            final PlayInfoResponse playInfoResponse = list.get(0);
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.12.1
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.onReplacementRequestFinished(playParams, playInfoResponse);
                }
            });
        }
    };
    private final IPlayInfoRequest.Callback mRealVideoRequestCallback = new IPlayInfoRequest.Callback() { // from class: com.youku.playerservice.axp.PlayerService.13
        @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
        public void onFinished(final PlayParams playParams, List<PlayInfoResponse> list) {
            final PlayInfoResponse playInfoResponse = list.get(0);
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.13.1
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.onRealVideoRequestFinish(playParams, playInfoResponse);
                }
            });
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.youku.playerservice.axp.PlayerService$24  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass24 implements InternalPlayerEventListener {
        AnonymousClass24() {
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onAdCountDown(final int i) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.16
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onAdCountDown(i);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onAdEnd(final InternalPlayerEventListener.ADType aDType, final int i) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.15
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService playerService = PlayerService.this;
                    playerService.logWithSessionId("onAdEnd type=" + aDType + " index=" + i);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onAdEnd(aDType, i);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onAdStart(final InternalPlayerEventListener.ADType aDType, final int i) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.14
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService playerService = PlayerService.this;
                    playerService.logWithSessionId("onAdStart type=" + aDType + " index=" + i);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onAdStart(aDType, i);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onComplete() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.6
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.logWithSessionId("onComplete");
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onComplete();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onEndLoading() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.10
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.logWithSessionId("onEndLoading");
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onEndLoading();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onError(final int i) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.8
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService playerService = PlayerService.this;
                    playerService.logWithSessionId("onError errorCode=" + i);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onError(i);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onInfo(final int i, final int i2, final int i3, final Object obj) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.17
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onInfo(i, i2, i3, obj);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onNotify(final String str, final Map<String, Object> map) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.18
                @Override // java.lang.Runnable
                public void run() {
                    PlayParams playParams = PlayerService.this.mPlayParams;
                    if (!"replayWithRequest".equals(str) || playParams == null) {
                        if (PlayerService.this.mPlayerEventListener != null) {
                            PlayerService.this.mPlayerEventListener.onNotify(str, map);
                            return;
                        }
                        return;
                    }
                    for (String str2 : map.keySet()) {
                        playParams.putString(str2, (String) map.get(str2));
                    }
                    if ("1".equals(playParams.getString("disableAd")) && playParams.getPlayIdParams() != null) {
                        playParams.getPlayIdParams().setDisableAd(true);
                    }
                    PlayerService.this.playWithRequest(playParams);
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPause() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.4
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.logWithSessionId(MessageID.onPause);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onPause();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPositionChange(final int i) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.11
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.mPlayer.getPlayerTrack().onPositionChange(i);
                    PlayerService.this.getPlayInfo().setProgress(i);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onPositionChange(i);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPrepared() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.2
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.logWithSessionId(MessageID.onPrepared);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onPrepared();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPreviewChange(final Object obj) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.22
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onPreviewChange(obj);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onPreviewEnd() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.23
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onPreviewEnd();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onQualityChangeFinish(final boolean z, final Object obj) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.7
                @Override // java.lang.Runnable
                public void run() {
                    VodItem vodItem = PlayerService.this.mTempItemFrom;
                    VodItem vodItem2 = PlayerService.this.mTempItemTo;
                    PlayerService.this.mTempItemFrom = null;
                    PlayerService.this.mTempItemTo = null;
                    if (vodItem == null || vodItem2 == null) {
                        PlayerService.this.onQualityChangedFinished(false, null);
                        return;
                    }
                    PlayerService.this.mPlayInfo.setPlayItem(vodItem2);
                    Map<String, Object> saveQualityChange = QualityUtil.saveQualityChange(PlayerService.this.mContext, vodItem.getQuality(), vodItem2.getQuality());
                    PlayerService playerService = PlayerService.this;
                    playerService.logWithSessionId("onQualityChangeFinish " + z + " from=" + vodItem + " to=" + vodItem2);
                    PlayerService.this.onQualityChangedFinished(z, saveQualityChange);
                    PlayerService.this.mPlayer.getModuleManager().onQualityChangeFinish(z, obj);
                    if (PlayerService.this.mPlayInfo.isPanorama()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("vrMode", Integer.valueOf(PlayerService.this.mPlayInfo.getVRMode()));
                        hashMap.put("vrType", Integer.valueOf(PlayerService.this.mPlayInfo.getVRType()));
                        PlayerService.this.mPlayer.doAction(PlayerAction.SWITCH_PLAYER_MODE, hashMap);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onRealVideoStart() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.1
                @Override // java.lang.Runnable
                public void run() {
                    BitStream bitStream;
                    PlayerService.this.logWithSessionId("onRealVideoStart");
                    PlayerService.this.mPlayInfo.setRealVideoStarted(true);
                    PlayerService.this.mPlayer.getModuleManager().onRealVideoStart();
                    PlayDefinition.PlayType playType = PlayerService.this.mPlayParams.getPlayType();
                    PlayDefinition.PlayType playType2 = PlayDefinition.PlayType.VOD;
                    if (playType == playType2) {
                        VodItem vodItem = PlayerService.this.mTempItemFrom;
                        VodItem vodItem2 = PlayerService.this.mTempItemTo;
                        PlayerService.this.mTempItemTo = null;
                        PlayerService.this.mTempItemFrom = null;
                        if (vodItem != null && vodItem2 != null) {
                            PlayerService.this.mPlayInfo.setPlayItem(vodItem2);
                            Map<String, Object> saveQualityChange = QualityUtil.saveQualityChange(PlayerService.this.mContext, vodItem.getQuality(), vodItem2.getQuality());
                            PlayerService playerService = PlayerService.this;
                            playerService.logWithSessionId("onQualityChangeFinish true from=" + vodItem + " to=" + vodItem2);
                            PlayerService.this.onQualityChangedFinished(true, saveQualityChange);
                            PlayerService.this.mPlayer.getModuleManager().onQualityChangeFinish(true, saveQualityChange);
                        }
                        if (PlayerService.this.mPlayInfo.isPanorama()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("vrMode", Integer.valueOf(PlayerService.this.mPlayInfo.getVRMode()));
                            hashMap.put("vrType", Integer.valueOf(PlayerService.this.mPlayInfo.getVRType()));
                            PlayerService.this.mPlayer.doAction(PlayerAction.SWITCH_PLAYER_MODE, hashMap);
                        }
                    }
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onRealVideoStart();
                    }
                    if (PlayerService.this.mPlayParams.getPlayType() == PlayDefinition.PlayType.LIVE && "1".equals(PlayerService.this.mPlayParams.getString(PluginName.CHANGE_QUALITY))) {
                        PlayerService.this.mPlayParams.putString(PluginName.CHANGE_QUALITY, null);
                        Quality quality = Quality.UNKNOWN;
                        Quality quality2 = PlayerService.this.mPlayInfo.getPlayItem().getQuality();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("from", quality);
                        hashMap2.put("to", quality2);
                        PlayerService.this.logWithSessionId("onQualityChangeFinish true");
                        PlayerService.this.onQualityChangedFinished(true, hashMap2);
                    }
                    if (PlayerService.this.mPlayParams.getPlayType() == playType2 && (PlayerService.this.mPlayInfo.getPlayItem() instanceof VodItem) && (bitStream = ((VodItem) PlayerService.this.mPlayInfo.getPlayItem()).getBitStream()) != null && bitStream.onlyHasSliceItem()) {
                        PlayerService.this.mHandler.postDelayed(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PlayerService playerService2 = PlayerService.this;
                                playerService2.mRealVideoRequest = new RealVideoRequest(playerService2.mPlayerConfig);
                                PlayerService.this.mRealVideoRequest.setRequestCallback(PlayerService.this.mRealVideoRequestCallback);
                                PlayerService playerService3 = PlayerService.this;
                                playerService3.logWithSessionId("开始请求正片数据" + PlayerService.this.mPlayParams.getPlayIdParams().getPlayId());
                                PlayerService.this.mRealVideoRequest.request(PlayerService.this.mPlayParams);
                            }
                        }, 1000L);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onRelease() {
            PlayerService.this.logWithSessionId("onRelease");
            PlayerService.this.logWithSessionId(Log.getStackTraceString(new Throwable()));
            if (PlayerService.this.mPlayerEventListener != null) {
                PlayerService.this.mPlayerEventListener.onRelease();
            }
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onScreenShotError(final int i) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.21
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onScreenShotError(i);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onScreenShotFinished() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.19
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onScreenShotFinished();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onScreenShotProgress(final int i) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.20
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onScreenShotProgress(i);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onScreenShotVideoEncoderMode(final int i) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.24
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onScreenShotVideoEncoderMode(i);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onSeekFinish(final boolean z, @NonNull final Map<String, String> map) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.12
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.mPlayer.getPlayerTrack().onSeekFinish(z, map);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onSeekFinish(z, map);
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onStart() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.3
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.logWithSessionId("onStart");
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onStart();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onStartLoading() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.9
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.logWithSessionId("onStartLoading");
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onStartLoading();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onStop() {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.5
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService.this.logWithSessionId(MessageID.onStop);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onStop();
                    }
                }
            });
        }

        @Override // com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
        public void onVideoSizeChanged(final int i, final int i2) {
            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.24.13
                @Override // java.lang.Runnable
                public void run() {
                    PlayerService playerService = PlayerService.this;
                    playerService.logWithSessionId("onVideoSizeChanged wdith=" + i + " height=" + i2);
                    if (PlayerService.this.mPlayerEventListener != null) {
                        PlayerService.this.mPlayerEventListener.onVideoSizeChanged(i, i2);
                    }
                }
            });
        }
    }

    private PlayerService(PlayerConfig playerConfig) {
        AnonymousClass24 anonymousClass24 = new AnonymousClass24();
        this.mPrimaryPlayerEventListener = anonymousClass24;
        this.mPlayerConfig = playerConfig;
        if (playerConfig.getContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        this.mContext = this.mPlayerConfig.getContext();
        if (this.mHandler == null) {
            HandlerThread handlerThread = new HandlerThread("PlayerService-Thread");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }
        this.mPlayer = PlayerImpl.createPlayer(this.mContext, this.mHandler);
        TLogUtil.loge(CacheManager.TAG_PLAYER, "PlayerService:createPlayerImpl-" + this.mPlayer.hashCode());
        this.mPlayer.setInternalPlayEventListener(anonymousClass24);
        IPlayerTrack playerTrack = this.mPlayer.getPlayerTrack();
        this.mPlayerTrack = playerTrack;
        playerTrack.setDynamicProperties(new Callable() { // from class: com.youku.playerservice.axp.PlayerService.1
            @Override // com.youku.vpm.Callable
            public String call(String str) {
                return (TableField.IS_VIP.equals(str) && Utils.isYoukuOrHuaweiBaipai(PlayerService.this.mContext)) ? VipUserService.getInstance().isVip() ? VipUserService.getInstance().isLightVip() ? "2" : "1" : "0" : PlayerService.this.mPlayerConfig.getDynamicProperty(str);
            }
        });
    }

    private IPlayInfoRequest createPlayInfoRequest(PlayParams playParams) {
        PlayIdParams playIdParams = playParams.getPlayIdParams();
        if (playIdParams != null) {
            if (playIdParams.getPlayInfoRequest() != null) {
                return playIdParams.getPlayInfoRequest();
            }
            if (playParams.getPlayType() != PlayDefinition.PlayType.VOD) {
                if (playParams.getPlayType() == PlayDefinition.PlayType.LIVE) {
                    return ApsUtil.enableAxpLivePlayControlCache() ? new LiveWithCacheRequest(this.mPlayerConfig) : new LiveRequest(this.mPlayerConfig);
                }
                return null;
            } else if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && CacheRequest.hasCacheData(playParams)) {
                CacheRequest cacheRequest = new CacheRequest(this.mContext, this.mPlayerConfig);
                playParams.putString(TableField.PLAY_WAY, "local");
                return cacheRequest;
            } else {
                return new UpsWithCacheRequest(this.mPlayerConfig);
            }
        }
        throw new IllegalArgumentException("PlayIdParams is null when createPlayInfoRequest");
    }

    public static IPlayerService createPlayerService(PlayerConfig playerConfig) {
        return new PlayerService(playerConfig);
    }

    private boolean hasPlayId(PlayParams playParams) {
        return (playParams.getPlayIdParams() == null || TextUtils.isEmpty(playParams.getPlayIdParams().getPlayId())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logWithSessionId(String str) {
        PlayParams playParams = this.mPlayParams;
        logWithSessionId((playParams == null || TextUtils.isEmpty(playParams.getSessionId())) ? null : this.mPlayParams.getSessionId(), str);
    }

    private void logWithSessionId(String str, String str2) {
        TLogUtil.flowLog(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayInfoRequestFinished(PlayParams playParams, PlayInfoResponse playInfoResponse) {
        PlayerEventListener playerEventListener;
        this.mPlayer.getPlayerTrack().putTimestamp("requestEndTs", System.currentTimeMillis());
        if (playInfoResponse.getError() == null) {
            logWithSessionId("onFinished success");
            PlayDefinition.PlayInfoType infoType = playInfoResponse.getInfoType();
            if (infoType == PlayDefinition.PlayInfoType.UPS || infoType == PlayDefinition.PlayInfoType.LOCAL) {
                PlayInfo playInfo = new PlayInfo(playParams, this.mPlayerConfig);
                playInfo.setPlayInfoResponse(playInfoResponse);
                PlayInfoResult playInfoResult = new PlayInfoResult(playInfo);
                PlayerEventListener playerEventListener2 = this.mPlayerEventListener;
                if (playerEventListener2 != null) {
                    playerEventListener2.onPlayInfoResult(playInfoResult);
                }
                this.mPlayInfo = playInfo;
                playWithGetPlayItem(playInfo);
                return;
            } else if (infoType == PlayDefinition.PlayInfoType.LIVE) {
                List<PlayInfo> playInfo2 = PlayLiveInfoResult.getPlayInfo(playParams, this.mPlayerConfig, playInfoResponse);
                if (playInfoResponse.getError() != null) {
                    PlayInfoError error = playInfoResponse.getError();
                    PlayInfo playInfo3 = new PlayInfo(playParams, this.mPlayerConfig);
                    playInfo3.setPlayInfoResponse(playInfoResponse);
                    PlayInfoResult playInfoResult2 = new PlayInfoResult(error);
                    playInfoResult2.setPlayInfo(playInfo3);
                    PlayerEventListener playerEventListener3 = this.mPlayerEventListener;
                    if (playerEventListener3 != null) {
                        playerEventListener3.onPlayInfoResult(playInfoResult2);
                        return;
                    }
                    return;
                }
                PlayInfoResult playInfoResult3 = PlayLiveInfoResult.getPlayInfoResult(playInfo2);
                this.mPlayInfo = playInfo2.get(0);
                PlayerEventListener playerEventListener4 = this.mPlayerEventListener;
                if (playerEventListener4 != null) {
                    playerEventListener4.onPlayInfoResult(playInfoResult3);
                }
                PlayInfo playInfo4 = this.mPlayInfo;
                if (playInfo4 == null || !playInfo4.isRecycled()) {
                    playWithPlayInfoList(playInfo2);
                    return;
                } else {
                    logWithSessionId("播放器已经被释放，不再进行播放");
                    return;
                }
            } else {
                return;
            }
        }
        PlayInfoError error2 = playInfoResponse.getError();
        int errorCode = error2.getErrorCode();
        logWithSessionId("onFinished fail " + errorCode);
        PlayInfoResult playInfoResult4 = new PlayInfoResult(error2);
        PlayInfo playInfo5 = new PlayInfo(playParams, this.mPlayerConfig);
        playInfo5.setPlayInfoResponse(playInfoResponse);
        playInfoResult4.setPlayInfo(playInfo5);
        if (this.mPlayParams.getPlayType() != PlayDefinition.PlayType.LIVE) {
            this.mPlayerTrack.onDataFail(errorCode);
            playerEventListener = this.mPlayerEventListener;
            if (playerEventListener == null) {
                return;
            }
        } else if ("1".equals(this.mPlayParams.getString(PluginName.CHANGE_QUALITY))) {
            PlayerEventListener playerEventListener5 = this.mPlayerEventListener;
            if (playerEventListener5 != null) {
                playerEventListener5.onPlayInfoResult(playInfoResult4);
            }
            this.mPlayParams.putString(PluginName.CHANGE_QUALITY, null);
            this.mPlayParams.getPlayIdParams().setRequestLiveQuality(this.mPlayInfo.getPlayItem().getQuality().getLiveCode());
            onQualityChangedFinished(false, null);
            return;
        } else {
            PlayInfo playInfo6 = this.mPlayInfo;
            if (playInfo6 != null && playInfo6.isRealVideoStarted() && this.mPlayInfo.getPlayInfoResponse() == null) {
                if (Arrays.asList(new int[]{ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_REQUEST_SYSTEM_ERROR, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_REQUEST_ERROR, 70400, 70401, 70500, 70501, 70502}).contains(Integer.valueOf(errorCode))) {
                    return;
                }
                this.mPlayerTrack.onDataFail(errorCode);
                PlayerEventListener playerEventListener6 = this.mPlayerEventListener;
                if (playerEventListener6 != null) {
                    playerEventListener6.onPlayInfoResult(playInfoResult4);
                }
                stopInternal("liveInfoError");
                return;
            }
            this.mPlayerTrack.onDataFail(errorCode);
            playerEventListener = this.mPlayerEventListener;
            if (playerEventListener == null) {
                return;
            }
        }
        playerEventListener.onPlayInfoResult(playInfoResult4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQualityChangedFinished(boolean z, Map<String, Object> map) {
        if (z) {
            CachePool.getInstance().removeQGetAndNormalResponses();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isSuccess", Boolean.valueOf(z));
        if (map != null) {
            Quality quality = (Quality) map.get("from");
            Quality quality2 = (Quality) map.get("to");
            if (quality != null) {
                hashMap.put("fromQuality", quality.getDescription());
            }
            if (quality2 != null) {
                hashMap.put("toQuality", quality2.getDescription());
            }
        }
        this.mPlayerTrack.onMsg("onQualityChangeFinish", hashMap);
        PlayerEventListener playerEventListener = this.mPlayerEventListener;
        if (playerEventListener != null) {
            playerEventListener.onQualityChangeFinish(z, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRealVideoRequestFinish(PlayParams playParams, PlayInfoResponse playInfoResponse) {
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo == null) {
            return;
        }
        if (playInfoResponse.getError() != null) {
            PlayInfoResult playInfoResult = new PlayInfoResult(playInfoResponse.getError());
            logWithSessionId("首片起播后补全数据失败" + playInfoResponse.getError().getErrorMsg());
            this.mPlayer.stop();
            PlayerEventListener playerEventListener = this.mPlayerEventListener;
            if (playerEventListener != null) {
                playerEventListener.onPlayInfoResult(playInfoResult);
                return;
            }
            return;
        }
        logWithSessionId("开始请求正片数据成功");
        PlayInfoUpsResponse playInfoUpsResponse = (PlayInfoUpsResponse) playInfoResponse;
        playInfo.setPlayInfoResponse(playInfoUpsResponse);
        PlayInfoResult playInfoResult2 = new PlayInfoResult(playInfo);
        logWithSessionId("对外通知数据请求成功");
        PlayerEventListener playerEventListener2 = this.mPlayerEventListener;
        if (playerEventListener2 != null) {
            playerEventListener2.onPlayInfoResult(playInfoResult2);
        }
        logWithSessionId("根据当前首分片的streamType进行正片选流续播");
        VodItem vodItem = (VodItem) playInfo.getPlayItem();
        VodItem playItem = playInfoUpsResponse.getPlayItem(playParams, vodItem.getStreamType(), playParams.getPlayIdParams().getLanguageCode());
        if (playItem == null) {
            this.mPlayer.stop();
            PlayerEventListener playerEventListener3 = this.mPlayerEventListener;
            if (playerEventListener3 != null) {
                playerEventListener3.onError(ErrorCode.STREAM_MATCH_ERROR);
                return;
            }
            return;
        }
        playInfo.setPlayItem(playItem);
        HashMap hashMap = new HashMap();
        hashMap.put("vodItem", playItem);
        hashMap.put("sliceItem", vodItem.getSliceItem());
        logWithSessionId("进行正片续播");
        this.mPlayer.doAction("continuePlayRealVideo", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onReplacementRequestFinished(PlayParams playParams, PlayInfoResponse playInfoResponse) {
        NetUpsInfo upsInfo;
        if (this.mPlayInfo == null) {
            return;
        }
        if (this.mPlayParams != playParams) {
            logWithSessionId(playParams.getSessionId(), "onReplacementRequestFinished 返回的已经不是当前PlayParams");
            return;
        }
        logWithSessionId(playParams.getSessionId(), "onReplacementRequestFinished");
        if (this.mPlayInfo.getPlayItem() instanceof VodItem) {
            VodItem vodItem = (VodItem) this.mPlayInfo.getPlayItem();
            if (vodItem == null || !vodItem.isCache()) {
                this.mPlayInfo.setPlayInfoResponse(playInfoResponse);
            } else {
                PlayInfoResponse playInfoResponse2 = this.mPlayInfo.getPlayInfoResponse();
                if (playInfoResponse2 != null && (upsInfo = playInfoResponse.getUpsInfo()) != null) {
                    playInfoResponse2.setUpsInfo(upsInfo);
                }
            }
            PlayInfoResult playInfoResult = playInfoResponse.getError() == null ? new PlayInfoResult(this.mPlayInfo) : new PlayInfoResult(playInfoResponse.getError());
            PlayerEventListener playerEventListener = this.mPlayerEventListener;
            if (playerEventListener != null) {
                playerEventListener.onPlayInfoResult(playInfoResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playInternal(PlayParams playParams) {
        VodItem vodItem;
        if (playParams.isForcePlay()) {
            TLogUtil.loge(CacheManager.TAG_PLAYER, "player:forcePlay and stop");
            stopInternal("切集");
        }
        TLogUtil.flowLog(playParams.getSessionId(), "playInternal " + playParams.toString() + " playerSource=" + this.mPlayerConfig.getString(TableField.PLAYER_SOURCE));
        if (!hasPlayId(playParams)) {
            if (playParams.getPlayUrlParams() == null || TextUtils.isEmpty(playParams.getPlayUrlParams().getPlayUrl())) {
                throw new IllegalArgumentException("起播入参错误，不是playId起播，也不是url起播");
            }
            this.mPlayParams = playParams;
            IPlayerTrack playerTrack = this.mPlayer.getPlayerTrack();
            if (playerTrack != null) {
                playerTrack.onNewTrack(playParams.getVpmInfo());
                playerTrack.putTimestamp("playTs", System.currentTimeMillis());
            }
            PlayUrlParams playUrlParams = this.mPlayParams.getPlayUrlParams();
            PlayInfo playInfo = new PlayInfo(this.mPlayParams, this.mPlayerConfig);
            UrlItem urlItem = new UrlItem(this.mPlayParams);
            urlItem.setPlayUrl(playUrlParams.getPlayUrl());
            urlItem.setPlayFormat(playUrlParams.getPlayFormat());
            playInfo.setPlayItem(urlItem);
            this.mPlayInfo = playInfo;
            playWithPlayInfoWithoutResponse(playInfo);
            return;
        }
        PlayIdParams playIdParams = playParams.getPlayIdParams();
        String playId = playIdParams.getPlayId();
        String playUrl = playIdParams.getPlayUrl();
        String playJson = playIdParams.getPlayJson();
        PlayInfo playInfoOfReuse = this.mPlayer.getPlayInfoOfReuse(playId);
        IPlayInfoRequest playInfoRequest = CachePool.getInstance().getPlayInfoRequest(playId);
        if (playInfoOfReuse != null && playParams.isReusedPlayer()) {
            playInfoOfReuse.getPlayParams().copyParamsTo(playParams);
            this.mPlayInfo = playInfoOfReuse;
            playInfoOfReuse.setPlayerConfig(this.mPlayerConfig);
            this.mPlayInfo.setPlayParams(playParams);
            if (playParams.isForcePlay()) {
                this.mPlayer.getPlayerTrack().onNewTrack(playParams.getVpmInfo());
                this.mPlayer.getPlayerTrack().putTimestamp("playTs", System.currentTimeMillis());
            }
            this.mPlayParams = playParams;
            playParams.putString("preloadType", "playInfo");
            this.mPlayer.getModuleManager().onPlay(playParams);
            String str = "playParams " + playParams.toString() + " playerSource=" + this.mPlayerConfig.getString(TableField.PLAYER_SOURCE);
            logWithSessionId("命中PlayInfo预播放 " + str);
            if (this.mPlayerEventListener != null) {
                this.mPlayerEventListener.onPlayInfoResult(new PlayInfoResult(this.mPlayInfo));
            }
            this.mPlayer.playWithPlayInfo(this.mPlayInfo);
            if (playParams.getPlayType() == PlayDefinition.PlayType.VOD && (vodItem = (VodItem) this.mPlayInfo.getPlayItem()) != null && vodItem.getBitStream() != null && vodItem.getBitStream().onlyHasSliceItem()) {
                logWithSessionId("命中PlayInfo预播放 首分片起播，起播后再请求UPS" + str);
                return;
            }
        } else if (playInfoRequest != null && playParams.isReusedPlayer()) {
            PlayParams playParams2 = playInfoRequest.getPlayParams();
            playParams.copyParamsTo(playParams2);
            if (playParams2.isForcePlay()) {
                this.mPlayer.getPlayerTrack().onNewTrack(playParams2.getVpmInfo());
                this.mPlayer.getPlayerTrack().putTimestamp("playTs", System.currentTimeMillis());
            }
            this.mPlayParams = playParams2;
            playParams2.putString("preloadType", "request");
            this.mPlayer.getModuleManager().onPlay(playParams2);
            logWithSessionId("命中request预播放 " + ("playParams " + playParams2.toString() + " playerSource=" + this.mPlayerConfig.getString(TableField.PLAYER_SOURCE)));
            this.mPlayInfoRequest = playInfoRequest;
            playInfoRequest.setRequestCallback(this.mPlayInfoRequestCallback);
            if (playInfoRequest.getState() == IPlayInfoRequest.State.FINISHED) {
                this.mPlayInfoRequestCallback.onFinished(playParams2, playInfoRequest.getPlayInfoResponses());
                return;
            }
            return;
        } else {
            if (playParams.isForcePlay()) {
                this.mPlayer.getPlayerTrack().onNewTrack(playParams.getVpmInfo());
                this.mPlayer.getPlayerTrack().putTimestamp("playTs", System.currentTimeMillis());
            }
            this.mPlayParams = playParams;
            this.mPlayer.getModuleManager().onPlay(playParams);
            String string = playParams.getString(ExtrasInfo.AROUSE_REFER);
            if (!TextUtils.isEmpty(string)) {
                BitStream createBitStreamByRefer = BitStreamUtil.createBitStreamByRefer(playParams, string);
                if (createBitStreamByRefer != null) {
                    PlayInfo playInfo2 = new PlayInfo(this.mPlayParams, this.mPlayerConfig);
                    PlayItem vodItem2 = new VodItem(this.mPlayParams, createBitStreamByRefer);
                    vodItem2.setPlayFormat(PlayDefinition.PlayFormat.HLS);
                    playInfo2.setPlayItem(vodItem2);
                    logWithSessionId("命中唤端首分片起播");
                    this.mPlayInfo = playInfo2;
                    playInfo2.putString("fastUrlType", ExtrasInfo.AROUSE_REFER);
                    playInfo2.putString("fastTsStreamType", vodItem2.getStreamType());
                    playWithPlayInfoWithoutResponse(playInfo2);
                    return;
                }
                playParams.putString("fastTsUrlRetry", "27007");
            }
            if ("1".equals(playParams.getString("isReadHistory"))) {
                this.mPlayer.getPlayerTrack().putTimestamp("historyReadTs", System.currentTimeMillis());
                HistoryDataUtil.readHistoryWithUpdate(this.mContext, this.mPlayParams);
                this.mPlayer.getPlayerTrack().putTimestamp("historyReadDoneTs", System.currentTimeMillis());
            }
            if (!TextUtils.isEmpty(playUrl)) {
                PlayDefinition.PlayFormat playFormat = playIdParams.getPlayFormat();
                PlayInfo playInfo3 = new PlayInfo(this.mPlayParams, this.mPlayerConfig);
                if (this.mPlayParams.getPlayType() == PlayDefinition.PlayType.VOD) {
                    PlayItem vodItem3 = new VodItem(this.mPlayParams, playUrl);
                    PlayDefinition.PlayFormat playFormat2 = PlayDefinition.PlayFormat.HLS;
                    if (playFormat == PlayDefinition.PlayFormat.UNKNOWN) {
                        playFormat = playFormat2;
                    }
                    vodItem3.setPlayFormat(playFormat);
                    playInfo3.setPlayItem(vodItem3);
                    logWithSessionId("url起播后，不再请求ups");
                    this.mPlayInfo = playInfo3;
                    playInfo3.getPlayParams().putString("fastUrlType", "url");
                    playWithPlayInfoWithoutResponse(playInfo3);
                    return;
                } else if (this.mPlayParams.getPlayType() != PlayDefinition.PlayType.LIVE) {
                    throw new IllegalArgumentException("id起播的时候，PlayType为UNKOWN");
                } else {
                    SliceItem createSliceItemByLiveJson = SliceItem.createSliceItemByLiveJson(playIdParams.getPlayExtraJson());
                    String string2 = playIdParams.getString("master");
                    PlayItem liveItem = new LiveItem(this.mPlayParams, playUrl, string2, createSliceItemByLiveJson);
                    liveItem.setPlayFormat(playFormat);
                    playInfo3.setPlayItem(liveItem);
                    if (createSliceItemByLiveJson != null) {
                        playInfo3.putString("hasFastTsUrl", "1");
                    }
                    if (TextUtils.isEmpty(string2)) {
                        playInfo3.putString("fastUrlType", "url");
                    } else {
                        playInfo3.putString("fastUrlType", "master");
                    }
                    this.mPlayInfo = playInfo3;
                    playWithPlayInfoWithoutResponse(playInfo3);
                }
            } else if (!TextUtils.isEmpty(playJson) && this.mPlayParams.getPlayType() == PlayDefinition.PlayType.VOD) {
                JSONObject parseObject = JSON.parseObject(playJson);
                PlayInfo playInfo4 = new PlayInfo(this.mPlayParams, this.mPlayerConfig);
                PlayItem vodItem4 = new VodItem(this.mPlayParams, parseObject);
                vodItem4.setPlayFormat(PlayDefinition.PlayFormat.MP4);
                playInfo4.setPlayItem(vodItem4);
                this.mPlayInfo = playInfo4;
                playInfo4.getPlayParams().putString("fastUrlType", Preloader.KEY_JSON);
                playWithPlayInfoWithoutResponse(playInfo4);
                return;
            }
        }
        if (this.mPlayParams.getPlayIdParams() == null || TextUtils.isEmpty(this.mPlayParams.getPlayIdParams().getPlayId())) {
            return;
        }
        if (!TextUtils.isEmpty(this.mPlayParams.getPlayIdParams().getPlayJson()) || !TextUtils.isEmpty(this.mPlayParams.getPlayIdParams().getPlayUrl())) {
            String string3 = this.mPlayParams.getString("disableRequestToPlay", "0");
            if (!TextUtils.isEmpty(string3) && "1".equals(string3)) {
                return;
            }
        }
        if (TextUtils.isEmpty(playParams.getString("fastTsStreamType"))) {
            playWithRequest(this.mPlayParams);
        }
    }

    private void playWithGetPlayItem(final PlayInfo playInfo) {
        PlayParams playParams = playInfo.getPlayParams();
        PlayInfoUpsResponse playInfoUpsResponse = (PlayInfoUpsResponse) playInfo.getPlayInfoResponse();
        Quality requestQuality = playParams.getPlayIdParams().getRequestQuality();
        Quality upsQuality = playInfoUpsResponse.getUpsQuality();
        if (upsQuality != Quality.UNKNOWN && upsQuality != requestQuality) {
            String sessionId = playParams.getSessionId();
            TLogUtil.flowLog(sessionId, "选流使用ups清晰度" + upsQuality);
            requestQuality = upsQuality;
        }
        playInfo.setPlayItem(playInfoUpsResponse.getPlayItem(playParams, requestQuality, playParams.getPlayIdParams().getLanguageCode()));
        new RealInterceptionWrapper(4, playInfo, this.mInterceptors, new Interceptor() { // from class: com.youku.playerservice.axp.PlayerService.15
            @Override // com.youku.playerservice.axp.interceptor.Interceptor
            public void intercept(Chain chain) {
                PlayerService.this.mPlayer.playWithPlayInfo(playInfo);
            }
        });
    }

    private void playWithPlayInfoList(List<PlayInfo> list) {
        IPlayerImplProtocol createPlayer;
        this.mOtherPlayers = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            final PlayInfo playInfo = list.get(i);
            if (i == 0) {
                createPlayer = this.mPlayer;
            } else {
                PlayerConfig playerConfig = this.mPlayerConfig;
                String string = playerConfig != null ? playerConfig.getString(TableField.PLAYER_SOURCE) : "";
                if (!TextUtils.isEmpty(string) && !ApsUtil.getSinglePlayerConfig().contains(string)) {
                    createPlayer = PlayerImpl.createPlayer(this.mContext);
                    this.mOtherPlayers.add(createPlayer);
                    createPlayer.setInternalPlayEventListener(new SimplePlayerEventListener() { // from class: com.youku.playerservice.axp.PlayerService.16
                        @Override // com.youku.playerservice.axp.axpinterface.SimplePlayerEventListener, com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
                        public void onRealVideoStart() {
                            PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.16.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PlayerService.this.mMultiPlayerEventListener != null) {
                                        PlayerService.this.mMultiPlayerEventListener.onRealVideoStart(playInfo.getPlayIndex());
                                    }
                                }
                            });
                        }
                    });
                }
            }
            createPlayer.playWithPlayInfo(playInfo);
        }
    }

    private void playWithPlayInfoWithoutResponse(final PlayInfo playInfo) {
        logWithSessionId("playWithPlayInfoWithoutResponse");
        if (this.mPlayer.getPlayerTrack() != null) {
            this.mPlayer.getPlayerTrack().onDataReady(playInfo.getVpmFullInfo());
        }
        if (this.mPlayerEventListener != null) {
            this.mPlayerEventListener.onPlayInfoResult(new PlayInfoResult(playInfo));
        }
        new RealInterceptionWrapper(4, playInfo, this.mInterceptors, new Interceptor() { // from class: com.youku.playerservice.axp.PlayerService.14
            @Override // com.youku.playerservice.axp.interceptor.Interceptor
            public void intercept(Chain chain) {
                PlayerService.this.mPlayer.playWithPlayInfo(playInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playWithRequest(PlayParams playParams) {
        IPlayInfoRequest createPlayInfoRequest = createPlayInfoRequest(playParams);
        this.mPlayInfoRequest = createPlayInfoRequest;
        if (createPlayInfoRequest == null) {
            logWithSessionId("mPlayInfoRequest is null");
            logWithSessionId(Log.getStackTraceString(new Throwable()));
            return;
        }
        createPlayInfoRequest.setRequestCallback(this.mPlayInfoRequestCallback);
        logWithSessionId("request");
        this.mPlayer.getPlayerTrack().putTimestamp("requestStartTs", System.currentTimeMillis());
        this.mPlayInfoRequest.request(playParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void post(Runnable runnable) {
        if (Looper.myLooper() == this.mHandlerThread.getLooper() && ApsUtil.enableSameThreadSync()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal(String str) {
        IPlayInfoRequest iPlayInfoRequest = this.mPlayInfoRequest;
        if (iPlayInfoRequest != null) {
            iPlayInfoRequest.cancel();
            this.mPlayInfoRequest = null;
        }
        IPlayInfoRequest iPlayInfoRequest2 = this.mReplacementInfoRequest;
        if (iPlayInfoRequest2 != null) {
            iPlayInfoRequest2.cancel();
            this.mReplacementInfoRequest = null;
        }
        IPlayInfoRequest iPlayInfoRequest3 = this.mRealVideoRequest;
        if (iPlayInfoRequest3 != null) {
            iPlayInfoRequest3.cancel();
            this.mRealVideoRequest = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("stopFrom", str);
        this.mPlayer.getModuleManager().onStop();
        this.mPlayer.getPlayerTrack().onStop(hashMap);
        this.mPlayer.stop();
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo != null) {
            playInfo.recycle();
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public void addInterceptor(Interceptor interceptor) {
        this.mInterceptors.add(interceptor);
    }

    @Override // com.youku.playerservice.axp.axpinterface.ISwitchStream
    public void changeToMultiScene(final String str, final Map<String, String> map) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.10
            @Override // java.lang.Runnable
            public void run() {
                if (PlayerService.this.mPlayParams == null || PlayerService.this.mPlayParams.getPlayIdParams() == null) {
                    return;
                }
                PlayIdParams playIdParams = PlayerService.this.mPlayParams.getPlayIdParams();
                PlayIdParams createPlayIdParams = PlayIdParams.createPlayIdParams(playIdParams.getPlayId(), playIdParams.getCCode());
                createPlayIdParams.putString("sceneId", str);
                createPlayIdParams.putString(PlayInfoLiveResponse.IS_RAPHAEL, "1");
                createPlayIdParams.setRequestLiveQuality(playIdParams.getRequestLiveQuality());
                PlayParams createPlayParams = PlayParams.createPlayParams(PlayDefinition.PlayType.LIVE, PlayDefinition.PlayScene.LIVE_YOUKU, createPlayIdParams);
                createPlayParams.putString("timeShift", "0");
                String sessionId = PlayerService.this.mPlayParams.getSessionId();
                TLogUtil.flowLog(sessionId, "切换视角 sceneId=" + str);
                Map map2 = map;
                if (map2 != null && !map2.isEmpty()) {
                    createPlayIdParams.putExtMap(map);
                    for (String str2 : map.keySet()) {
                        String str3 = (String) map.get(str2);
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            createPlayParams.putString(str2, str3);
                        }
                    }
                }
                PlayerService.this.mPlayer.stop();
                PlayerService.this.playWithParams(createPlayParams);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void changeVideoSize(final int i, final int i2) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.18
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.mPlayer.changeVideoSize(i, i2);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public Object doAction(PlayerAction playerAction, Map<String, Object> map) {
        if (playerAction == PlayerAction.IS_SUPPORT_AUDIO_ENHANCE) {
            PlayParams playParams = this.mPlayParams;
            if (playParams == null || playParams.getPlayType() != PlayDefinition.PlayType.LIVE) {
                return null;
            }
            PlayInfo playInfo = this.mPlayInfo;
            return (playInfo == null || playInfo.getPlayInfoResponse() == null || this.mPlayInfo.getPlayInfoResponse().getLiveInfo() == null || this.mPlayInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl() == null) ? Boolean.FALSE : Boolean.valueOf(PostProcessingConfigManager.isSupportAudioHbr(this.mPlayInfo.getPlayItem().getStreamType(), "8", this.mPlayInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl().playerWidget));
        } else if (playerAction == PlayerAction.OPEN_AUDIO_ENHANCE) {
            PlayParams playParams2 = this.mPlayParams;
            if (playParams2 == null || playParams2.getPlayType() != PlayDefinition.PlayType.LIVE) {
                return null;
            }
            PlayInfo playInfo2 = this.mPlayInfo;
            if (playInfo2 == null || playInfo2.getPlayInfoResponse() == null || this.mPlayInfo.getPlayInfoResponse().getLiveInfo() == null || this.mPlayInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl() == null) {
                return 0;
            }
            String str = (String) map.get("open");
            String streamType = this.mPlayInfo.getPlayItem().getStreamType();
            PlayerWidget playerWidget = this.mPlayInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl().playerWidget;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Integer.valueOf(PostProcessingConfigManager.doManualPostProcess(this.mPlayer, streamType, playerWidget, "8", "1".equals(str)));
        } else {
            return this.mPlayer.doAction(playerAction, map);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public Object doAction(String str, Map<String, Object> map) {
        return this.mPlayer.doAction(str, map);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public long getCurrentPosition() {
        return this.mPlayer.getCurrentPosition();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public Quality getCurrentQuality() {
        PlayItem playItem = this.mPlayer.getPlayInfo().getPlayItem();
        if (playItem != null) {
            return playItem.getQuality();
        }
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public float getCurrentZoomScale() {
        return this.mPlayer.getCurrentZoomScale();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public int getDuration() {
        return this.mPlayer.getDuration();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public PlayInfo getPlayInfo() {
        return this.mPlayInfo;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public double getPlaySpeed() {
        return this.mPlayer.getPlaySpeed();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public IPlayerTrack getPlayerTrack() {
        return this.mPlayer.getPlayerTrack();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IMultiPlayerProtocol
    public IPlayerProtocol getPlayerWithIndex(int i) {
        List<IPlayerImplProtocol> list = this.mOtherPlayers;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.mOtherPlayers.get(i);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public int getVideoHeight() {
        return this.mPlayer.getVideoHeight();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public int getVideoWidth() {
        return this.mPlayer.getVideoWidth();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public float getVolume() {
        return this.mPlayer.getVolume();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void hideZoomPickWind() {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.23
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.mPlayer.hideZoomPickWind();
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public boolean isMuted() {
        return this.mPlayer.isMuted();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public boolean isPaused() {
        return this.mPlayer.isPaused();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public boolean isStarted() {
        return this.mPlayer.isStarted();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void pause() {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.5
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.logWithSessionId("pause");
                PlayerService.this.mPlayer.pause();
                if (PlayerService.this.mPlayerEventListener != null) {
                    PlayerService.this.mPlayerEventListener.onPause();
                }
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public void playWithParams(final PlayParams playParams) {
        if (playParams == null) {
            throw new IllegalArgumentException("PlayParams is null");
        }
        if (playParams.getPlayIdParams() != null) {
            TLogUtil.loge(CacheManager.TAG_PLAYER, "PlayerService-playWithParams:" + playParams.getPlayIdParams().getPlayId());
        }
        TLogUtil.flowLog(playParams.getSessionId(), "playWithParams " + playParams.toString() + " playerSource=" + this.mPlayerConfig.getString(TableField.PLAYER_SOURCE));
        new RealInterceptionWrapper(0, playParams, this.mInterceptors, new Interceptor() { // from class: com.youku.playerservice.axp.PlayerService.2
            @Override // com.youku.playerservice.axp.interceptor.Interceptor
            public void intercept(Chain chain) {
                if (playParams.isForcePlay()) {
                    PlayerService.this.mHandler.removeCallbacksAndMessages(null);
                }
                PlayerService.this.post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        PlayerService.this.playInternal(playParams);
                    }
                });
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService, com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.7
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.logWithSessionId("release");
                PlayerService.this.stopInternal("release");
                if (PlayerService.this.mPlayer != null) {
                    PlayerService.this.mPlayer.release();
                }
                if (PlayerService.this.mOtherPlayers != null && PlayerService.this.mOtherPlayers.size() > 0) {
                    for (IPlayerImplProtocol iPlayerImplProtocol : PlayerService.this.mOtherPlayers) {
                        iPlayerImplProtocol.release();
                    }
                }
                boolean quitSafely = PlayerService.this.mHandlerThread.quitSafely();
                PlayerService playerService = PlayerService.this;
                playerService.logWithSessionId("release quit " + quitSafely);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public void requestWithParams(PlayParams playParams, IPlayInfoRequest.Callback callback) {
        requestWithUpdatePlayInfo(null);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public void requestWithUpdatePlayInfo(Map<String, String> map) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.3
            @Override // java.lang.Runnable
            public void run() {
                PlayParams playParams = PlayerService.this.mPlayParams;
                if (playParams != null) {
                    if (playParams.getPlayType() == PlayDefinition.PlayType.VOD) {
                        PlayerService playerService = PlayerService.this;
                        playerService.mReplacementInfoRequest = new UpsRequest(playerService.mPlayerConfig);
                        if (PlayerService.this.mPlayInfo != null && PlayerService.this.mPlayInfo.getPlayItem() != null) {
                            playParams.putString("local_st", PlayerService.this.mPlayInfo.getPlayItem().getQuality().getUpsCode() + "");
                        }
                    } else if (playParams.getPlayType() == PlayDefinition.PlayType.LIVE) {
                        return;
                    }
                    if (PlayerService.this.mReplacementInfoRequest == null) {
                        PlayerService.this.logWithSessionId("mReplacementInfoRequest is null");
                        PlayerService.this.logWithSessionId(Log.getStackTraceString(new Throwable()));
                        return;
                    }
                    PlayerService.this.mReplacementInfoRequest.setRequestCallback(PlayerService.this.mReplacementRequestCallback);
                    PlayerService.this.logWithSessionId("request replacement");
                    PlayerService.this.mPlayer.getPlayerTrack().putTimestamp("requestStartTs", System.currentTimeMillis());
                    PlayerService.this.mReplacementInfoRequest.request(playParams);
                }
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void seekTo(final int i, final boolean z) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.17
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.mPlayer.getPlayerTrack().onSeek((int) PlayerService.this.mPlayer.getCurrentPosition(), i);
                PlayerService.this.mPlayer.getModuleManager().onSeekTo(i);
                if (PlayerService.this.mPlayer.isPaused()) {
                    PlayerService.this.mPlayer.start();
                }
                if (PlayerService.this.mPlayerEventListener != null) {
                    PlayerService.this.mPlayerEventListener.onStart();
                }
                PlayerService.this.mPlayer.seekTo(i, z);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setAutoPlay(boolean z) {
        this.mPlayer.setAutoPlay(z);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setDisplay(Surface surface) {
        this.mPlayer.setDisplay(surface);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public int setFilter(int i, Map<String, String> map) {
        return this.mPlayer.setFilter(i, map);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setLooping(boolean z) {
        this.mPlayer.setLooping(z);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setMaxZoomScale(final float f) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.21
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.mPlayer.setMaxZoomScale(f);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public void setMultiPlayerEventListener(MultiPlayerEventListener multiPlayerEventListener) {
        this.mMultiPlayerEventListener = multiPlayerEventListener;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setMuted(boolean z) {
        this.mPlayer.setMuted(z);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setPlaySpeed(double d) {
        this.mPlayer.setPlaySpeed(d);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setPlaybackParam(int i, String str) {
        this.mPlayer.setPlaybackParam(i, str);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public void setPlayerEventListener(PlayerEventListener playerEventListener) {
        this.mPlayerEventListener = playerEventListener;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService
    public void setPositionFrenquency(int i) {
        PlayerConfig playerConfig = this.mPlayerConfig;
        if (playerConfig != null) {
            playerConfig.setPositionFrequency(i);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setVolume(float f) {
        this.mPlayer.setVolume(f);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setZoom(final int i, final double d, final double d2, final double d3) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.20
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.mPlayer.setZoom(i, d, d2, d3);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void showZoomPickWind(final int i, final float f, final float f2, final float f3, final float f4) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.22
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.mPlayer.showZoomPickWind(i, f, f2, f3, f4);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void skipAD(final int i) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.19
            @Override // java.lang.Runnable
            public void run() {
                PlayerService playerService = PlayerService.this;
                playerService.logWithSessionId("跳过前贴广告 count=" + i);
                PlayerService.this.mPlayer.skipAD(i);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void start() {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.4
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.mPlayer.start();
                if (PlayerService.this.mPlayerEventListener != null) {
                    PlayerService.this.mPlayerEventListener.onStart();
                }
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void stop() {
        this.mHandler.removeCallbacksAndMessages(null);
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.6
            @Override // java.lang.Runnable
            public void run() {
                PlayerService.this.logWithSessionId("stop");
                PlayerService.this.stopInternal("stop");
                if (PlayerService.this.mPlayerEventListener != null) {
                    PlayerService.this.mPlayerEventListener.onStop();
                }
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService, com.youku.playerservice.axp.axpinterface.ISwitchStream
    public void switchLanguage(final String str) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.9
            @Override // java.lang.Runnable
            public void run() {
                PlayInfoResponse playInfoResponse;
                if (PlayerService.this.mPlayParams.getPlayType() != PlayDefinition.PlayType.VOD) {
                    PlayerService.this.mPlayParams.getPlayType();
                    PlayDefinition.PlayType playType = PlayDefinition.PlayType.LIVE;
                } else if (PlayerService.this.mPlayInfo == null || (playInfoResponse = PlayerService.this.mPlayInfo.getPlayInfoResponse()) == null) {
                } else {
                    PlayItem playItem = playInfoResponse.getPlayItem(PlayerService.this.mPlayInfo.getPlayParams(), PlayerService.this.mPlayInfo.getPlayItem().getQuality(), str);
                    PlayerService.this.mPlayInfo.getPlayParams().setStartTime(PlayerService.this.getCurrentPosition());
                    PlayerService.this.mPlayInfo.setPlayItem(playItem);
                    PlayerService.this.mPlayer.stop();
                    PlayerService.this.mPlayer.playWithPlayInfo(PlayerService.this.mPlayInfo);
                    CachePool.getInstance().removeQGetAndNormalResponses();
                }
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService, com.youku.playerservice.axp.axpinterface.ISwitchStream
    public void switchQuality(final Quality quality) {
        post(new Runnable() { // from class: com.youku.playerservice.axp.PlayerService.8
            @Override // java.lang.Runnable
            public void run() {
                PlayerService playerService;
                String str;
                PlayerService playerService2 = PlayerService.this;
                playerService2.logWithSessionId("onQualityChangeStart to=" + quality);
                HashMap hashMap = new HashMap();
                hashMap.put("fromQuality", quality.getDescription());
                PlayerService.this.mPlayerTrack.onMsg("onQualityChangeStart", hashMap);
                if (PlayerService.this.mPlayParams.getPlayType() != PlayDefinition.PlayType.VOD) {
                    if (PlayerService.this.mPlayParams.getPlayType() == PlayDefinition.PlayType.LIVE) {
                        PlayerService.this.mPlayParams.getPlayIdParams().setRequestLiveQuality(quality.getLiveCode());
                        PlayerService.this.mPlayParams.getPlayIdParams().setDisableAd(true);
                        PlayerService.this.mPlayParams.putString(PluginName.CHANGE_QUALITY, "1");
                        PlayerService playerService3 = PlayerService.this;
                        playerService3.playWithRequest(playerService3.mPlayParams);
                        return;
                    }
                    return;
                }
                if (PlayerService.this.mPlayInfo == null) {
                    playerService = PlayerService.this;
                    str = "playInfo为空，无法切档";
                } else {
                    PlayInfoUpsResponse playInfoUpsResponse = (PlayInfoUpsResponse) PlayerService.this.mPlayInfo.getPlayInfoResponse();
                    if (playInfoUpsResponse == null) {
                        playerService = PlayerService.this;
                        str = "response为空，无法切档";
                    } else {
                        PlayItem playItem = PlayerService.this.mPlayInfo.getPlayItem();
                        Quality quality2 = playItem.getQuality();
                        Quality quality3 = Quality.SOUND;
                        VodItem playItemWithoutDownshift = (quality2 != quality3 || quality == quality3) ? playInfoUpsResponse.getPlayItemWithoutDownshift(PlayerService.this.mPlayInfo.getPlayParams(), quality, playItem.getLangCode()) : playInfoUpsResponse.getPlayItem(PlayerService.this.mPlayInfo.getPlayParams(), quality, playItem.getLangCode());
                        if (playItemWithoutDownshift != null) {
                            PlayerService.this.mTempItemFrom = (VodItem) playItem;
                            PlayerService.this.mTempItemTo = playItemWithoutDownshift;
                            if (QualityUtil.smooth(playItem.getStreamType(), playItemWithoutDownshift.getStreamType())) {
                                PlayerService.this.mPlayer.switchPlayItem(playItemWithoutDownshift);
                                return;
                            }
                            PlayerService.this.mPlayInfo.getPlayParams().setStartTime(PlayerService.this.getCurrentPosition());
                            PlayerService.this.mPlayInfo.setPlayItem(playItemWithoutDownshift);
                            PlayerService.this.mPlayer.stop();
                            PlayerService.this.mPlayer.playWithPlayInfo(PlayerService.this.mPlayInfo);
                            return;
                        }
                        playerService = PlayerService.this;
                        str = "选出VodItem为空，无法切档";
                    }
                }
                playerService.logWithSessionId(str);
                PlayerService.this.onQualityChangedFinished(false, null);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService, com.youku.playerservice.axp.axpinterface.ISwitchStream
    public void switchSceneId(String str) {
        PlayParams playParams = this.mPlayParams;
        PlayInfo playInfo = this.mPlayInfo;
        if (playParams == null) {
            return;
        }
        PlayIdParams createPlayIdParams = PlayIdParams.createPlayIdParams(playParams.getPlayIdParams().getPlayId(), playParams.getPlayIdParams().getCCode());
        createPlayIdParams.setRequestLiveQuality(playParams.getPlayIdParams().getRequestLiveQuality());
        createPlayIdParams.putString("sceneId", str);
        createPlayIdParams.putString(PlayInfoLiveResponse.IS_RAPHAEL, "0");
        if (playInfo != null && playInfo.isRealVideoStarted()) {
            createPlayIdParams.setDisableAd(true);
        }
        PlayParams createPlayParams = PlayParams.createPlayParams(playParams.getPlayType(), playParams.getPlayScene(), createPlayIdParams);
        createPlayParams.putString(TableField.PLAY_FROM, "switchSceneId");
        String sessionId = createPlayParams.getSessionId();
        TLogUtil.flowLog(sessionId, "切换视角 sceneId=" + str);
        playWithParams(createPlayParams);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerService, com.youku.playerservice.axp.axpinterface.ISwitchStream
    public void switchTimeShifted(String str) {
        String str2;
        PlayParams playParams = this.mPlayParams;
        PlayInfo playInfo = this.mPlayInfo;
        if (playParams == null) {
            return;
        }
        PlayIdParams createPlayIdParams = PlayIdParams.createPlayIdParams(playParams.getPlayIdParams().getPlayId(), playParams.getPlayIdParams().getCCode());
        createPlayIdParams.setRequestLiveQuality(playParams.getPlayIdParams().getRequestLiveQuality());
        createPlayIdParams.putString("sceneId", playParams.getString("sceneId"));
        if (playInfo != null && playInfo.isRealVideoStarted()) {
            createPlayIdParams.setDisableAd(true);
        }
        PlayParams createPlayParams = PlayParams.createPlayParams(playParams.getPlayType(), playParams.getPlayScene(), createPlayIdParams);
        createPlayParams.putString(TableField.PLAY_FROM, "timeShifted");
        boolean equals = "-1".equals(str);
        createPlayParams.putString("lhsStart", str);
        if (equals) {
            str2 = "0";
        } else {
            createPlayParams.putString("timeShiftPoint", str);
            str2 = "1";
        }
        createPlayParams.putString("timeShift", str2);
        String sessionId = createPlayParams.getSessionId();
        TLogUtil.flowLog(sessionId, "时移 lhsStart=" + str);
        playWithParams(createPlayParams);
    }
}
