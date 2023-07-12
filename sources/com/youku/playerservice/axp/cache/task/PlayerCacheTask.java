package com.youku.playerservice.axp.cache.task;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.youku.a.C7792a;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.android.liveservice.bean.BizType;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Mcs;
import com.youku.android.liveservice.bean.MicPlayInfo;
import com.youku.android.liveservice.bean.Quality;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol;
import com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.axpinterface.SimplePlayerEventListener;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.cache.CachePool;
import com.youku.playerservice.axp.cache.CachePreloadParams;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.IInternalCachePreloadCallback;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.LiveItem;
import com.youku.playerservice.axp.item.SliceItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.modules.history.HistoryDataUtil;
import com.youku.playerservice.axp.player.PlayerImpl;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.request.CacheRequest;
import com.youku.playerservice.axp.playinfo.request.LiveRequest;
import com.youku.playerservice.axp.playinfo.request.UpsWithCacheRequest;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.BitStreamUtil;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.data.ExtrasInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerCacheTask extends CacheTask {
    private Context mContext;
    private IInternalCachePreloadCallback mInternalCallback;
    private String mKey;
    private IPlayInfoRequest.Callback mPlayInfoRequestCallback = new IPlayInfoRequest.Callback() { // from class: com.youku.playerservice.axp.cache.task.PlayerCacheTask.2
        @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
        public void onFinished(PlayParams playParams, List<PlayInfoResponse> list) {
            if (PlayerCacheTask.this.mPreloadParams.getPlayParams() != null) {
                PlayerCacheTask.this.mPreloadParams.getPlayParams().putString("preRequestEndTs", String.valueOf(System.currentTimeMillis()));
            }
            if (list == null || list.size() <= 0) {
                return;
            }
            PlayInfoResponse playInfoResponse = list.get(0);
            CachePool.getInstance().savePlayInfoResponse(PlayerCacheTask.this.mContext, playInfoResponse);
            PlayerCacheTask playerCacheTask = PlayerCacheTask.this;
            playerCacheTask.playInternal(playerCacheTask.mPlayerParams, playInfoResponse);
        }
    };
    private IPlayerImplProtocol mPlayer;
    private PlayerConfig mPlayerConfig;
    private PlayParams mPlayerParams;
    private CachePreloadParams mPreloadParams;

    public PlayerCacheTask(String str, CachePreloadParams cachePreloadParams, IInternalCachePreloadCallback iInternalCachePreloadCallback) {
        this.mKey = str;
        this.mPreloadParams = cachePreloadParams;
        this.mInternalCallback = iInternalCachePreloadCallback;
    }

    private IPlayInfoRequest createPlayInfoRequest(PlayParams playParams, PlayerConfig playerConfig) {
        if (playParams.getPlayIdParams() == null || playParams.getPlayIdParams().getPlayInfoRequest() == null) {
            if (playParams.getPlayType() != PlayDefinition.PlayType.VOD) {
                if (playParams.getPlayType() == PlayDefinition.PlayType.LIVE) {
                    return new LiveRequest(playerConfig);
                }
                return null;
            } else if (CacheRequest.hasCacheData(playParams)) {
                CacheRequest cacheRequest = new CacheRequest(this.mContext, playerConfig);
                playParams.putString(TableField.PLAY_WAY, "local");
                return cacheRequest;
            } else {
                return new UpsWithCacheRequest(playerConfig);
            }
        }
        return playParams.getPlayIdParams().getPlayInfoRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playInternal(PlayParams playParams, PlayInfoResponse playInfoResponse) {
        if (playParams == null || playInfoResponse == null) {
            return;
        }
        if (playInfoResponse.getError() != null) {
            IInternalCachePreloadCallback iInternalCachePreloadCallback = this.mInternalCallback;
            if (iInternalCachePreloadCallback != null) {
                iInternalCachePreloadCallback.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PLAYER, null);
                return;
            }
            return;
        }
        PlayDefinition.PlayInfoType infoType = playInfoResponse.getInfoType();
        if (infoType == PlayDefinition.PlayInfoType.UPS) {
            PlayInfo playInfo = new PlayInfo(playParams, this.mPlayerConfig);
            playInfo.setPlayInfoResponse(playInfoResponse);
            playInfo.setPlayIndex(0);
            playInfo.setPlayItem((VodItem) playInfoResponse.getPlayItem(playParams, playParams.getPlayIdParams().getRequestQuality(), playParams.getPlayIdParams().getLanguageCode()));
            playWithPlayInfo(playInfo);
        } else if (infoType != PlayDefinition.PlayInfoType.LOCAL) {
            if (infoType == PlayDefinition.PlayInfoType.LIVE) {
                playLiveInfo(playParams, playInfoResponse);
            }
        } else {
            PlayInfo playInfo2 = new PlayInfo(playParams, this.mPlayerConfig);
            playInfo2.setPlayInfoResponse(playInfoResponse);
            playInfo2.setPlayItem((VodItem) playInfoResponse.getPlayItem(playParams, playParams.getPlayIdParams().getRequestQuality(), playParams.getPlayIdParams().getLanguageCode()));
            this.mPlayer.playWithPlayInfo(playInfo2);
        }
    }

    private void playLiveInfo(PlayParams playParams, PlayInfoResponse playInfoResponse) {
        String str;
        Codec codec;
        String str2;
        LivePlayControl livePlayControl = playInfoResponse.getLiveInfo().getLivePlayControl();
        if (livePlayControl != null) {
            boolean enablePursue = ApsUtil.enablePursue(this.mContext, BizType.getBizTypeByValue(livePlayControl.bizType));
            if (!"live".equals(livePlayControl.streamMode)) {
                if ("mic".equals(livePlayControl.streamMode)) {
                    String str3 = livePlayControl.micInfo.po.get(0);
                    ArrayList arrayList = new ArrayList();
                    if (livePlayControl.micInfo.mcs.size() > 0) {
                        for (Mcs mcs : livePlayControl.micInfo.mcs) {
                            MicPlayInfo micPlayInfo = new MicPlayInfo();
                            micPlayInfo.rtp = PlayerUtil.getPlayRtp(mcs, livePlayControl.micInfo.dfi);
                            micPlayInfo.flv = PlayerUtil.getPlayFlv(mcs, livePlayControl.micInfo.dfi);
                            micPlayInfo.artp = PlayerUtil.getPlayArtp(mcs, livePlayControl.micInfo.dfi);
                            micPlayInfo.grtn = PlayerUtil.getPlayGrtn(mcs, livePlayControl.micInfo.dfi);
                            arrayList.add(micPlayInfo);
                        }
                    }
                    PlayDefinition.PlayFormat playFormatByProtocol = PlayDefinition.PlayFormat.getPlayFormatByProtocol(str3);
                    PlayInfo playInfo = new PlayInfo(playParams, this.mPlayerConfig);
                    playInfo.setPlayInfoResponse(playInfoResponse);
                    playInfo.setPlayIndex(0);
                    LiveItem liveItem = new LiveItem(playParams, "rtp".equals(str3) ? ((MicPlayInfo) arrayList.get(0)).rtp.Url : "httpFlv".equals(str3) ? ((MicPlayInfo) arrayList.get(0)).flv.Url : "artp".equals(str3) ? ((MicPlayInfo) arrayList.get(0)).artp.Url : "grtn".equals(str3) ? ((MicPlayInfo) arrayList.get(0)).grtn.Url : "");
                    liveItem.setLivePlayControl(playInfoResponse.getLiveInfo().getLivePlayControl());
                    liveItem.setPlayFormat(playFormatByProtocol);
                    liveItem.setCodec(Codec.H264);
                    liveItem.setEnablePursue(enablePursue);
                    playInfo.setPlayItem(liveItem);
                    playWithPlayInfo(playInfo);
                    return;
                }
                return;
            }
            Quality defaultQuality = livePlayControl.getDefaultQuality();
            Codec codec2 = Codec.H264;
            PlayDefinition.PlayFormat playFormatByProtocol2 = PlayDefinition.PlayFormat.getPlayFormatByProtocol(defaultQuality.playType);
            int i = defaultQuality.h265;
            boolean z = true;
            if (i != 1 && i != 2) {
                z = false;
            }
            if (!z) {
                str = defaultQuality.h264PlayUrl;
            } else if (!TextUtils.isEmpty(defaultQuality.h265PlayUrl)) {
                str2 = defaultQuality.h265PlayUrl;
                codec = Codec.H265;
                PlayInfo playInfo2 = new PlayInfo(playParams, this.mPlayerConfig);
                playInfo2.setPlayInfoResponse(playInfoResponse);
                playInfo2.setPlayIndex(0);
                LiveItem liveItem2 = new LiveItem(playParams, str2);
                liveItem2.setLivePlayControl(livePlayControl);
                liveItem2.setPlayFormat(playFormatByProtocol2);
                liveItem2.setCodec(codec);
                liveItem2.setEnablePursue(enablePursue);
                liveItem2.setStreamType(defaultQuality.bitStream);
                playInfo2.setPlayItem(liveItem2);
                playWithPlayInfo(playInfo2);
            } else {
                str = defaultQuality.h264PlayUrl;
                TLogUtil.playLog("选流时发生了降档");
            }
            String str4 = str;
            codec = codec2;
            str2 = str4;
            PlayInfo playInfo22 = new PlayInfo(playParams, this.mPlayerConfig);
            playInfo22.setPlayInfoResponse(playInfoResponse);
            playInfo22.setPlayIndex(0);
            LiveItem liveItem22 = new LiveItem(playParams, str2);
            liveItem22.setLivePlayControl(livePlayControl);
            liveItem22.setPlayFormat(playFormatByProtocol2);
            liveItem22.setCodec(codec);
            liveItem22.setEnablePursue(enablePursue);
            liveItem22.setStreamType(defaultQuality.bitStream);
            playInfo22.setPlayItem(liveItem22);
            playWithPlayInfo(playInfo22);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playSuccessAndPaused() {
        if (this.mPreloadParams.getPlayParams().getPlayType() == PlayDefinition.PlayType.VOD && this.mPreloadParams.isNeedToPauseWhenSuccess()) {
            TLogUtil.flowLog(this.mPlayerParams.getSessionId(), "预播放pause");
            this.mPreloadParams.getPlayParams().putString("prePauseTs", String.valueOf(System.currentTimeMillis()));
            this.mPlayer.pause();
            TLogUtil.loge(CacheManager.TAG_PLAYER, "player:pause");
        }
        if (this.mInternalCallback != null) {
            CachePreloadResult cachePreloadResult = new CachePreloadResult();
            cachePreloadResult.setPlayerId(this.mPlayerParams.getPlayIdParams() != null ? this.mPlayerParams.getPlayIdParams().getPlayId() : this.mPlayerParams.getPlayUrlParams() != null ? this.mPlayerParams.getPlayUrlParams().getPlayUrl() : "");
            this.mInternalCallback.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_SUCCESS_PLAYER, cachePreloadResult);
        }
    }

    private void playWithPlayInfo(PlayInfo playInfo) {
        this.mPlayer.playWithPlayInfo(playInfo);
        if (this.mInternalCallback != null) {
            CachePreloadResult cachePreloadResult = new CachePreloadResult();
            cachePreloadResult.setPlayerId(this.mPlayerParams.getPlayIdParams() != null ? this.mPlayerParams.getPlayIdParams().getPlayId() : this.mPlayerParams.getPlayUrlParams() != null ? this.mPlayerParams.getPlayUrlParams().getPlayUrl() : "");
            this.mInternalCallback.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_CREATE_PLAYER, cachePreloadResult);
        }
    }

    @Override // com.youku.playerservice.axp.cache.task.CacheTask, java.util.concurrent.Callable
    public CachePreloadResult call() {
        String str;
        String str2;
        String str3;
        IInternalCachePreloadCallback iInternalCachePreloadCallback;
        IInternalCachePreloadCallback iInternalCachePreloadCallback2;
        IInternalCachePreloadCallback iInternalCachePreloadCallback3;
        PlayParams playParams = this.mPreloadParams.getPlayParams();
        this.mPlayerParams = playParams;
        if (playParams.getPlayIdParams() != null && this.mPlayerParams.getPlayIdParams().isLocalPlay() && (iInternalCachePreloadCallback3 = this.mInternalCallback) != null) {
            iInternalCachePreloadCallback3.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PLAYER, null);
            return null;
        }
        PlayerConfig playerConfig = this.mPreloadParams.getPlayerConfig();
        this.mPlayerConfig = playerConfig;
        if (playerConfig != null) {
            this.mContext = playerConfig.getContext().getApplicationContext();
        }
        if (this.mPlayerParams.getPlayIdParams() != null) {
            str = this.mPlayerParams.getPlayIdParams().getPlayId();
            str2 = this.mPlayerParams.getPlayIdParams().getPlayUrl();
            str3 = this.mPlayerParams.getPlayIdParams().getPlayJson();
        } else {
            IInternalCachePreloadCallback iInternalCachePreloadCallback4 = this.mInternalCallback;
            if (iInternalCachePreloadCallback4 != null) {
                iInternalCachePreloadCallback4.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_NOPLAYID_PLAYER, null);
                return null;
            }
            str = "";
            str2 = str;
            str3 = str2;
        }
        if (TextUtils.isEmpty(str) && (iInternalCachePreloadCallback2 = this.mInternalCallback) != null) {
            iInternalCachePreloadCallback2.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_NOPLAYID_PLAYER, null);
            return null;
        }
        IAlixPlayer a = C7792a.a(this.mContext).a(str);
        if (a != null && a.getCurrentState() != IAlixPlayer.State.STATE_IDLE && a.getCurrentState() != IAlixPlayer.State.STATE_RELEASED && a.getCurrentState() != IAlixPlayer.State.STATE_STOPPED && a.getCurrentState() != IAlixPlayer.State.STATE_ERROR && a.getCurrentState() != IAlixPlayer.State.STATE_SOURCE_FAILED && (iInternalCachePreloadCallback = this.mInternalCallback) != null) {
            iInternalCachePreloadCallback.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_PLAYER, null);
            return null;
        }
        if (this.mPreloadParams.getPlayParams().getPlayIdParams() != null) {
            TLogUtil.loge(CacheManager.TAG_PLAYER, "PlayerCacheTask:" + this.mPreloadParams.getPlayParams().getPlayIdParams().getPlayId());
        }
        this.mPlayer = PlayerImpl.createPlayer(this.mContext, true);
        TLogUtil.loge(CacheManager.TAG_PLAYER, "PlayerCacheTask:createPlayerImpl-" + this.mPlayer.hashCode());
        this.mPlayer.setMuted(true);
        this.mPlayer.setInternalPlayEventListener(new SimplePlayerEventListener() { // from class: com.youku.playerservice.axp.cache.task.PlayerCacheTask.1
            @Override // com.youku.playerservice.axp.axpinterface.SimplePlayerEventListener, com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
            public void onAdStart(InternalPlayerEventListener.ADType aDType, int i) {
                if (aDType == InternalPlayerEventListener.ADType.PRE_AD && i == 0) {
                    PlayerCacheTask.this.playSuccessAndPaused();
                }
            }

            @Override // com.youku.playerservice.axp.axpinterface.SimplePlayerEventListener, com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
            public void onError(int i) {
                TLogUtil.loge(CacheManager.TAG_PLAYER, "player:onError:" + i);
                PlayerCacheTask.this.mPreloadParams.getPlayParams().putString("prePlayerErrorTs", String.valueOf(System.currentTimeMillis()));
                if (PlayerCacheTask.this.mInternalCallback != null) {
                    CachePreloadResult cachePreloadResult = new CachePreloadResult();
                    cachePreloadResult.setPlayerId(PlayerCacheTask.this.mPlayerParams.getPlayIdParams() != null ? PlayerCacheTask.this.mPlayerParams.getPlayIdParams().getPlayId() : PlayerCacheTask.this.mPlayerParams.getPlayUrlParams() != null ? PlayerCacheTask.this.mPlayerParams.getPlayUrlParams().getPlayUrl() : "");
                    PlayInfoError playInfoError = new PlayInfoError();
                    playInfoError.setErrorCode(i);
                    cachePreloadResult.setError(playInfoError);
                    PlayerCacheTask.this.mInternalCallback.onResult(PlayerCacheTask.this.mKey, PlayerCacheTask.this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PLAYER, cachePreloadResult);
                }
            }

            @Override // com.youku.playerservice.axp.axpinterface.SimplePlayerEventListener, com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
            public void onInfo(int i, int i2, int i3, Object obj) {
            }

            @Override // com.youku.playerservice.axp.axpinterface.SimplePlayerEventListener, com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
            public void onPrepared() {
            }

            @Override // com.youku.playerservice.axp.axpinterface.SimplePlayerEventListener, com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener
            public void onRealVideoStart() {
                TLogUtil.flowLog(PlayerCacheTask.this.mPlayerParams.getSessionId(), "预播放onRealVideoStart");
                PlayerCacheTask.this.mPreloadParams.getPlayParams().putString("preRealVideoStartTs", String.valueOf(System.currentTimeMillis()));
                PlayerCacheTask.this.playSuccessAndPaused();
            }
        });
        String string = this.mPlayerConfig.getString(TableField.PLAYER_SOURCE);
        String string2 = this.mPlayerParams.getString(ExtrasInfo.AROUSE_REFER);
        if ("1".equals(string) && !TextUtils.isEmpty(string2) && this.mPlayerParams.getPlayType() == PlayDefinition.PlayType.VOD) {
            BitStream createBitStreamByRefer = BitStreamUtil.createBitStreamByRefer(this.mPlayerParams, string2);
            if (createBitStreamByRefer != null) {
                PlayInfo playInfo = new PlayInfo(this.mPlayerParams, this.mPlayerConfig);
                VodItem vodItem = new VodItem(this.mPlayerParams, createBitStreamByRefer);
                vodItem.setPlayFormat(PlayDefinition.PlayFormat.HLS);
                playInfo.setPlayItem(vodItem);
                TLogUtil.flowLog(this.mPlayerParams.getSessionId(), "预播放，命中refer首分片起播");
                playInfo.putString("fastUrlType", ExtrasInfo.AROUSE_REFER);
                playInfo.putString("fastTsStreamType", vodItem.getStreamType());
                playWithPlayInfo(playInfo);
                return null;
            }
            this.mPlayerParams.putString("fastTsUrlRetry", "27007");
        }
        if ("1".equals(string) && Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            PlayParams playParams2 = this.mPlayerParams;
            playParams2.putString("historyReadTs", System.currentTimeMillis() + "");
            HistoryDataUtil.readHistoryWithUpdate(this.mContext, this.mPlayerParams);
            PlayParams playParams3 = this.mPlayerParams;
            playParams3.putString("historyReadDoneTs", System.currentTimeMillis() + "");
            this.mPlayerParams.getPlayIdParams().setSkipHeadTail(PlayerUtil.isSkipHeadAndTail(this.mContext));
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3) || this.mPlayerParams.getPlayType() != PlayDefinition.PlayType.VOD) {
                if (this.mPreloadParams.getPlayParams() != null) {
                    this.mPreloadParams.getPlayParams().putString("preRequestStartTs", String.valueOf(System.currentTimeMillis()));
                }
                IPlayInfoRequest createPlayInfoRequest = createPlayInfoRequest(this.mPlayerParams, this.mPlayerConfig);
                createPlayInfoRequest.setRequestCallback(this.mPlayInfoRequestCallback);
                createPlayInfoRequest.request(this.mPlayerParams);
                CachePool.getInstance().setPlayInfoRequest(str, createPlayInfoRequest);
                return null;
            }
            PlayInfo playInfo2 = new PlayInfo(this.mPlayerParams, this.mPlayerConfig);
            VodItem vodItem2 = new VodItem(this.mPlayerParams, JSON.parseObject(str3));
            vodItem2.setPlayFormat(this.mPlayerParams.getPlayIdParams().getPlayFormat());
            playInfo2.setPlayItem(vodItem2);
            playInfo2.getPlayParams().putString("fastUrlType", Preloader.KEY_JSON);
            playWithPlayInfo(playInfo2);
            return null;
        }
        PlayInfo playInfo3 = new PlayInfo(this.mPlayerParams, this.mPlayerConfig);
        if (this.mPlayerParams.getPlayType() == PlayDefinition.PlayType.VOD) {
            VodItem vodItem3 = new VodItem(this.mPlayerParams, str2);
            PlayDefinition.PlayFormat playFormat = PlayDefinition.PlayFormat.HLS;
            if (this.mPlayerParams.getPlayIdParams().getPlayFormat() != PlayDefinition.PlayFormat.UNKNOWN) {
                playFormat = this.mPlayerParams.getPlayIdParams().getPlayFormat();
            }
            vodItem3.setPlayFormat(playFormat);
            playInfo3.setPlayItem(vodItem3);
            playInfo3.putString("fastUrlType", "url");
        } else if (this.mPlayerParams.getPlayType() == PlayDefinition.PlayType.LIVE) {
            SliceItem createSliceItemByLiveJson = SliceItem.createSliceItemByLiveJson(this.mPlayerParams.getPlayIdParams().getPlayExtraJson());
            String string3 = this.mPlayerParams.getPlayIdParams().getString("master");
            LiveItem liveItem = new LiveItem(this.mPlayerParams, str2, string3, createSliceItemByLiveJson);
            liveItem.setPlayFormat(this.mPlayerParams.getPlayIdParams().getPlayFormat());
            playInfo3.setPlayItem(liveItem);
            if (TextUtils.isEmpty(string3)) {
                playInfo3.putString("fastUrlType", "url");
            } else {
                playInfo3.putString("fastUrlType", "master");
            }
            if (createSliceItemByLiveJson != null) {
                playInfo3.putString("hasFastTsUrl", "1");
            }
        }
        playWithPlayInfo(playInfo3);
        return null;
    }
}
