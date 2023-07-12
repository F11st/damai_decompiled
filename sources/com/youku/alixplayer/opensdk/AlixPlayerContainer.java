package com.youku.alixplayer.opensdk;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.fast.FastData;
import com.youku.alixplayer.opensdk.interceptor.Chain;
import com.youku.alixplayer.opensdk.interceptor.Interceptor;
import com.youku.alixplayer.opensdk.interceptor.RealInterceptionWrapper;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.live.LiveMediaSource;
import com.youku.alixplayer.opensdk.live.LiveTimeShiftRequest;
import com.youku.alixplayer.opensdk.live.LiveVideoRequest;
import com.youku.alixplayer.opensdk.statistics.PlayTimeTrack;
import com.youku.alixplayer.opensdk.statistics.PlayerTrack;
import com.youku.alixplayer.opensdk.statistics.track.business.BusinessTrack;
import com.youku.alixplayer.opensdk.ups.UpsMediaSource;
import com.youku.alixplayer.opensdk.ups.request.UpsVideoRequest;
import com.youku.alixplayer.opensdk.url.UrlMediaSource;
import com.youku.alixplayer.opensdk.utils.MsgIdGroup;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.PlayerWidget;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.uplayer.AliMediaPlayer;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AlixPlayerContainer implements IPlayerContainer {
    public static final String TAG = "Alix-PlayFlow";
    private IMultiPlayerWrapper mAlixMultiplayer;
    private IPlayerWrapper mAlixPlayer;
    private BusinessTrack mBusinessTrack;
    private Context mContext;
    private IVideoRequest.Factory mFactory;
    private PlayVideoInfo mPlayVideoInfo;
    private PlayerConfig mPlayerConfig;
    private PlayerTrack mPlayerTrack;
    private IPlaylistBuilder mPlaylistBuilder;
    private OnCurrentPositionChangeListener mPositionChangeListener;
    private IVideoRequest mVideoRequest;
    private IVideoStream mVideoStream;
    private List<Interceptor> mInterceptors = new CopyOnWriteArrayList();
    private LiveMediaSource.onChangeSourceListener mOnChangeSourceListener = new LiveMediaSource.onChangeSourceListener() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.3
        @Override // com.youku.alixplayer.opensdk.live.LiveMediaSource.onChangeSourceListener
        public void changeSource(boolean z, String str, int i) {
            AlixPlayerContainer.this.mPlayVideoInfo.setRequestLiveQuality(i);
            AlixPlayerContainer.this.mPlayVideoInfo.putString("change_quality_setdatasource", "1");
            if (!(AlixPlayerContainer.this.mVideoRequest instanceof LiveVideoRequest)) {
                AlixPlayerContainer.this.mPlayVideoInfo.putString("timeShift", "0");
                AlixPlayerContainer alixPlayerContainer = AlixPlayerContainer.this;
                alixPlayerContainer.mVideoRequest = new LiveVideoRequest(alixPlayerContainer.mContext, AlixPlayerContainer.this.mPlayerConfig);
                AlixPlayerContainer.this.mVideoRequest.setVideoRequestListener(AlixPlayerContainer.this.mLiveMediaSourceListCallback);
            }
            AlixPlayerContainer.this.mVideoRequest.request(AlixPlayerContainer.this.mPlayVideoInfo, null);
        }
    };
    private IVideoRequest.Callback<LiveInfo, List<LiveInfo>> mLiveMediaSourceListCallback = new IVideoRequest.Callback<LiveInfo, List<LiveInfo>>() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.4
        @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
        public void onFailure(VideoRequestError videoRequestError) {
            AlixPlayerContainer.this.mOnVideoStreamListener.onDataFail(videoRequestError);
            if ("1".equals(AlixPlayerContainer.this.mPlayVideoInfo.getString("change_quality_setdatasource"))) {
                if (!(AlixPlayerContainer.this.mVideoStream instanceof LiveMediaSource) || AlixPlayerContainer.this.mOnChangeVideoListeners == null) {
                    return;
                }
                for (OnChangeVideoListener onChangeVideoListener : AlixPlayerContainer.this.mOnChangeVideoListeners) {
                    onChangeVideoListener.onChangeVideoFinish(false);
                }
            } else if (AlixPlayerContainer.this.isFastPlaying()) {
                AlixPlayerContainer.this.mAlixPlayer.stop();
            }
        }

        @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
        public void onStat(Map<String, String> map) {
        }

        @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
        public void onSuccess(LiveInfo liveInfo, List<LiveInfo> list) {
            PlayerWidget playerWidget;
            if ("1".equals(AlixPlayerContainer.this.mPlayVideoInfo.getString("change_quality_setdatasource"))) {
                if (AlixPlayerContainer.this.mVideoStream instanceof LiveMediaSource) {
                    LiveMediaSource liveMediaSource = new LiveMediaSource(AlixPlayerContainer.this.mContext, AlixPlayerContainer.this.mPlayVideoInfo, AlixPlayerContainer.this.mPlayerConfig, liveInfo);
                    liveMediaSource.setPlaylistBuilder(AlixPlayerContainer.this.mPlaylistBuilder);
                    liveMediaSource.setOnChangeVideoListeners(AlixPlayerContainer.this.mOnChangeVideoListeners);
                    liveMediaSource.setOnChangeSourceListener(AlixPlayerContainer.this.mOnChangeSourceListener);
                    liveMediaSource.setInterceptors(AlixPlayerContainer.this.mInterceptors);
                    AlixPlayerContainer.this.mVideoStream = liveMediaSource;
                    AlixPlayerContainer.this.mOnVideoStreamListener.onDataReady(liveMediaSource.getYoukuVideoInfo());
                    IAlixPlayer.State currentState = AlixPlayerContainer.this.mAlixPlayer.getCurrentState();
                    if (currentState != IAlixPlayer.State.STATE_STOPPED && currentState != IAlixPlayer.State.STATE_IDLE) {
                        AlixPlayerContainer.this.mAlixPlayer.stop();
                    }
                    AlixPlayerContainer.this.mAlixPlayer.setVideoStream(liveMediaSource);
                    return;
                }
                return;
            }
            Log.i("lwj", "video request end with container " + AlixPlayerContainer.this + " and request:" + AlixPlayerContainer.this.mVideoRequest);
            if (AlixPlayerContainer.this.mPlayerTrack != null && AlixPlayerContainer.this.mPlayerTrack.getPlayTimeTrack() != null) {
                AlixPlayerContainer.this.mPlayerTrack.getPlayTimeTrack().setLiveControlEndTime(System.currentTimeMillis());
            }
            TLogUtil.playLog("播控请求成功  其他播放器数量=" + list.size());
            LivePlayControl livePlayControl = liveInfo.playControl;
            boolean z = true;
            if (livePlayControl == null || (playerWidget = livePlayControl.playerWidget) == null || playerWidget.seiDecode != 1) {
                AlixPlayerContainer.this.mPlayVideoInfo.putMonitor("seidecode", "0");
            } else {
                AlixPlayerContainer.this.mPlayVideoInfo.putMonitor("seidecode", "1");
            }
            LiveMediaSource liveMediaSource2 = new LiveMediaSource(AlixPlayerContainer.this.mContext, AlixPlayerContainer.this.mPlayVideoInfo, AlixPlayerContainer.this.mPlayerConfig, liveInfo);
            liveMediaSource2.setPlaylistBuilder(AlixPlayerContainer.this.mPlaylistBuilder);
            liveMediaSource2.setPlayerTrack(AlixPlayerContainer.this.mPlayerTrack);
            liveMediaSource2.setOnChangeVideoListeners(AlixPlayerContainer.this.mOnChangeVideoListeners);
            liveMediaSource2.setOnChangeSourceListener(AlixPlayerContainer.this.mOnChangeSourceListener);
            liveMediaSource2.setInterceptors(AlixPlayerContainer.this.mInterceptors);
            if (AlixPlayerContainer.this.mVideoStream instanceof BaseLiveVideoStream) {
                BaseLiveVideoStream baseLiveVideoStream = (BaseLiveVideoStream) AlixPlayerContainer.this.mVideoStream;
                if (AlixPlayerContainer.this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED || AlixPlayerContainer.this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_STARTING || AlixPlayerContainer.this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PREPARING || AlixPlayerContainer.this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PREPARED) {
                    if (baseLiveVideoStream.match(liveMediaSource2)) {
                        TLogUtil.playLog("本次播放不打断前一个播放", AlixPlayerContainer.this.mAlixPlayer);
                        z = false;
                    } else {
                        TLogUtil.playLog("播控下发地址与当前播放地址不一致，进行打断操作", AlixPlayerContainer.this.mAlixPlayer);
                        if (AlixPlayerContainer.this.mPlayerTrack.getTrack() != null) {
                            AlixPlayerContainer.this.mPlayerTrack.getTrack().putString("liveUrlReplace", "1");
                        }
                    }
                }
            }
            AlixPlayerContainer.this.mVideoStream = liveMediaSource2;
            ArrayList arrayList = new ArrayList();
            for (LiveInfo liveInfo2 : list) {
                LiveMediaSource liveMediaSource3 = new LiveMediaSource(AlixPlayerContainer.this.mContext, AlixPlayerContainer.this.mPlayVideoInfo, AlixPlayerContainer.this.mPlayerConfig, liveInfo2);
                liveMediaSource3.setPlaylistBuilder(AlixPlayerContainer.this.mPlaylistBuilder);
                arrayList.add(liveMediaSource3);
            }
            Map map = null;
            if (arrayList.size() > 0) {
                map = AlixPlayerContainer.this.mAlixMultiplayer.createPlayers(arrayList);
            } else {
                TLogUtil.playLog("没有副播放器数据");
            }
            if (!liveInfo.isTrail || AlixPlayerContainer.this.mContext.getSharedPreferences(Utils.PLAYER_WIDGET_SP, 0).getLong(liveInfo.playControl.screenId, -1L) != 0) {
                AlixPlayerContainer.this.mOnVideoStreamListener.onDataReady(liveMediaSource2.getYoukuVideoInfo());
                if (z) {
                    IAlixPlayer.State currentState2 = AlixPlayerContainer.this.mAlixPlayer.getCurrentState();
                    if (currentState2 != IAlixPlayer.State.STATE_STOPPED && currentState2 != IAlixPlayer.State.STATE_IDLE) {
                        AlixPlayerContainer.this.mAlixPlayer.stop();
                    }
                    AlixPlayerContainer.this.mAlixPlayer.setVideoStream(liveMediaSource2);
                }
                AlixPlayerContainer.this.mAlixMultiplayer.play(map);
                return;
            }
            TLogUtil.playLog("试看时间结束，无需起播");
            AlixPlayerContainer.this.mOnVideoStreamListener.onDataReady(liveMediaSource2.getYoukuVideoInfo());
        }
    };
    private OnStateChangeListener mOnStateChangeListener = new OnStateChangeListener() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.5
        @Override // com.youku.alixplayer.OnStateChangeListener
        public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
            TLogUtil.playLog(state2.toString(), AlixPlayerContainer.this.mAlixPlayer);
            if (state2 == IAlixPlayer.State.STATE_SOURCE_READY) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("dago_analytics", "prepare called:" + currentTimeMillis);
                AlixPlayerContainer.this.mPlayerTrack.prepareAsync();
                AlixPlayerContainer.this.mAlixPlayer.prepareAsync();
            } else if (state2 == IAlixPlayer.State.STATE_PREPARED) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("dago_analytics", "start called:" + currentTimeMillis2);
                Log.i("lwj", "player prepared " + this);
                AlixPlayerContainer.this.mPlayerTrack.firstStart();
                AlixPlayerContainer.this.mAlixPlayer.firstStart();
            }
        }
    };
    private OnCurrentPositionChangeListener mOnCurrentPositionChangeListener = new OnCurrentPositionChangeListener() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.6
        @Override // com.youku.alixplayer.OnCurrentPositionChangeListener
        public void onCurrentPostionChange(int i) {
            AlixPlayerContainer.this.mPlayerTrack.onCurrentPositionUpdate(i, 0);
            if (AlixPlayerContainer.this.mPositionChangeListener != null) {
                AlixPlayerContainer.this.mPositionChangeListener.onCurrentPostionChange(i);
            }
        }
    };
    private OnInfoListener mOnInfoListener = new OnInfoListener() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.7
        @Override // com.youku.alixplayer.OnInfoListener
        public void onInfo(final int i, final int i2, int i3, final Object obj) {
            if (!MsgIdGroup.isErrorCode(i)) {
                AlixPlayerContainer.this.mPlayerTrack.onInfo(i, i2, i3, obj);
            } else {
                final Message message = new Message();
                message.what = i;
                message.arg1 = i2;
                message.arg2 = i3;
                message.obj = obj;
                new RealInterceptionWrapper(3, message, AlixPlayerContainer.this.mInterceptors, new Interceptor() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.7.1
                    @Override // com.youku.alixplayer.opensdk.interceptor.Interceptor
                    public void intercept(Chain<Object> chain) {
                        AlixPlayerContainer.this.mPlayerTrack.onError(message);
                        for (OnPlayerErrorListener onPlayerErrorListener : AlixPlayerContainer.this.mOnPlayerErrorListeners) {
                            onPlayerErrorListener.onError(i, i2, null, obj);
                        }
                    }
                });
            }
            if (i == 1021) {
                TLogUtil.playLog("switch finish", AlixPlayerContainer.this.mAlixPlayer);
                if (AlixPlayerContainer.this.mVideoStream != null && (AlixPlayerContainer.this.mVideoStream instanceof UpsMediaSource)) {
                    ((UpsMediaSource) AlixPlayerContainer.this.mVideoStream).onChangeVideoFinish(true);
                }
                if (AlixPlayerContainer.this.mOnChangeVideoListeners != null) {
                    for (OnChangeVideoListener onChangeVideoListener : AlixPlayerContainer.this.mOnChangeVideoListeners) {
                        onChangeVideoListener.onChangeVideoFinish(true);
                    }
                }
            } else if (i == 1022) {
                TLogUtil.playLog("switch failed", AlixPlayerContainer.this.mAlixPlayer);
                if (AlixPlayerContainer.this.mVideoStream != null && (AlixPlayerContainer.this.mVideoStream instanceof UpsMediaSource)) {
                    ((UpsMediaSource) AlixPlayerContainer.this.mVideoStream).onChangeVideoFinish(false);
                }
                if (AlixPlayerContainer.this.mOnChangeVideoListeners != null) {
                    for (OnChangeVideoListener onChangeVideoListener2 : AlixPlayerContainer.this.mOnChangeVideoListeners) {
                        onChangeVideoListener2.onChangeVideoFinish(false);
                    }
                }
            } else if (i == 1003) {
                TLogUtil.playLog("loading start", AlixPlayerContainer.this.mAlixPlayer);
            } else if (i == 1004) {
                TLogUtil.playLog("loading end", AlixPlayerContainer.this.mAlixPlayer);
            }
        }
    };
    private List<OnVideoStreamListener> mOnVideoStreamListeners = new CopyOnWriteArrayList();
    private List<OnChangeVideoListener> mOnChangeVideoListeners = new CopyOnWriteArrayList();
    private List<OnPlayerErrorListener> mOnPlayerErrorListeners = new CopyOnWriteArrayList();
    private OnVideoStreamListener mOnVideoStreamListener = new OnVideoStreamListener() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.8
        @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
        public void onDataFail(VideoRequestError videoRequestError) {
            TLogUtil.playLog("onDataFail code=" + videoRequestError.getErrorCode(), AlixPlayerContainer.this.mAlixPlayer);
            AlixPlayerContainer.this.mPlayerTrack.onDataFail(videoRequestError);
            for (OnVideoStreamListener onVideoStreamListener : AlixPlayerContainer.this.mOnVideoStreamListeners) {
                onVideoStreamListener.onDataFail(videoRequestError);
            }
        }

        @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
        public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
            TLogUtil.playLog("onDataReady", AlixPlayerContainer.this.mAlixPlayer);
            AlixPlayerContainer.this.mPlayerTrack.onDataReady(youkuVideoInfo);
            for (OnVideoStreamListener onVideoStreamListener : AlixPlayerContainer.this.mOnVideoStreamListeners) {
                onVideoStreamListener.onDataReady(youkuVideoInfo);
            }
        }

        @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
        public void onNewRequest(PlayVideoInfo playVideoInfo) {
            TLogUtil.playLog("onNewRequest", AlixPlayerContainer.this.mAlixPlayer);
            for (OnVideoStreamListener onVideoStreamListener : AlixPlayerContainer.this.mOnVideoStreamListeners) {
                onVideoStreamListener.onNewRequest(playVideoInfo);
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class PlayerInfoKey {
        public static final int PLAYER_INFO_KEY_TOTAL_CONSUMED_SIZE = 1;
        public static final int PLAYER_INFO_KEY_TOTAL_DOWNLOAD_SIZE = 0;
    }

    static {
        System.loadLibrary("c++_shared");
        System.loadLibrary("netcache");
        System.loadLibrary(AliMediaPlayer.ALIPLAYER);
        System.loadLibrary("YouKuABR");
        System.loadLibrary("alixplayer");
    }

    private AlixPlayerContainer(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
        playerConfig.setUserAgent("Youku;" + PlayerUtil.getVersionName(this.mContext) + ";Android" + Build.VERSION.getRELEASE() + ";" + Build.getMODEL());
        this.mPlayerTrack = new PlayerTrack(this.mContext, this);
        this.mAlixPlayer = new AlixPlayerWrapper(this.mContext, this.mPlayerTrack);
        this.mAlixMultiplayer = new AlixMultiPlayer(this.mContext, this.mPlayerTrack);
        this.mBusinessTrack = new BusinessTrack(this.mContext, this);
        this.mAlixPlayer.addOnPlayerStateListener(this.mOnStateChangeListener);
        this.mAlixPlayer.addOnInfoListener(this.mOnInfoListener);
        this.mAlixPlayer.addOnCurrentPositionChangeListener(this.mOnCurrentPositionChangeListener);
        TLogUtil.playLog("PlayerConfig " + playerConfig.toString());
    }

    public static IPlayerContainer create(Context context, PlayerConfig playerConfig) {
        return new AlixPlayerContainer(context, playerConfig);
    }

    private IVideoRequest createVideoRequest(PlayVideoInfo playVideoInfo) {
        if ("1".equals(playVideoInfo.getString("timeShift"))) {
            return new LiveTimeShiftRequest(this.mContext, this.mPlayerConfig);
        }
        IVideoRequest.Factory factory = this.mFactory;
        IVideoRequest create = factory != null ? factory.create(this.mContext, playVideoInfo, this.mPlayerConfig) : null;
        return create == null ? new LiveVideoRequest(this.mContext, this.mPlayerConfig) : create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalPlay(final PlayVideoInfo playVideoInfo) {
        Log.i("lwj", "internal play start" + this);
        TLogUtil.playLog("play " + playVideoInfo.toString() + " playerSource:" + this.mPlayerConfig.getExtras().getString(TableField.PLAYER_SOURCE));
        TLogUtil.playLog("主麦播放器", this.mAlixPlayer);
        boolean isForceReplay = playVideoInfo.isForceReplay();
        boolean z = playVideoInfo.getFastData() != null;
        if (this.mVideoStream instanceof FastMediaSource) {
            isForceReplay = false;
        }
        final boolean z2 = isForceReplay || z;
        IVideoRequest iVideoRequest = this.mVideoRequest;
        if (iVideoRequest != null) {
            iVideoRequest.cancel();
        }
        if (z2) {
            this.mAlixPlayer.stop();
            this.mAlixMultiplayer.stop();
        }
        this.mPlayVideoInfo = playVideoInfo;
        if (z2) {
            this.mPlayerTrack.onNewTrack(playVideoInfo);
        }
        final PlayTimeTrack playTimeTrack = this.mPlayerTrack.getPlayTimeTrack();
        if (playVideoInfo.getPlayType() == PlayType.VOD) {
            UpsVideoRequest upsVideoRequest = new UpsVideoRequest(this.mContext, this.mPlayerConfig);
            this.mVideoRequest = upsVideoRequest;
            UpsMediaSource upsMediaSource = new UpsMediaSource(this.mContext, playVideoInfo, this.mPlayerConfig, upsVideoRequest);
            upsMediaSource.setInterceptors(this.mInterceptors);
            upsMediaSource.setPlaylistBuilder(this.mPlaylistBuilder);
            upsMediaSource.setOnChangeVideoListeners(this.mOnChangeVideoListeners);
            upsMediaSource.addVideoStreamListener(this.mOnVideoStreamListener);
            this.mVideoStream = upsMediaSource;
            upsMediaSource.setPlayerWrapper(this.mAlixPlayer);
            this.mAlixPlayer.setVideoStream(upsMediaSource);
        } else if (playVideoInfo.getPlayType() == PlayType.URL) {
            UrlMediaSource urlMediaSource = new UrlMediaSource(playVideoInfo, this.mPlayerConfig);
            this.mVideoStream = urlMediaSource;
            this.mAlixPlayer.setVideoStream(urlMediaSource);
        } else if (playVideoInfo.getPlayType() == PlayType.LIVE) {
            final HashMap hashMap = new HashMap();
            new RealInterceptionWrapper(1, hashMap, this.mInterceptors, new Interceptor() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.2
                @Override // com.youku.alixplayer.opensdk.interceptor.Interceptor
                public void intercept(Chain<Object> chain) {
                    AlixPlayerContainer.this.playLive(playVideoInfo, hashMap, playTimeTrack, z2);
                }
            });
        } else {
            throw new IllegalArgumentException("playType is null");
        }
        Log.i("lwj", "end internalPlay for non-Preload media source " + this + " request:" + this.mVideoRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFastPlaying() {
        IVideoStream iVideoStream = this.mVideoStream;
        return iVideoStream != null && (iVideoStream instanceof FastMediaSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playLive(PlayVideoInfo playVideoInfo, Map<String, String> map, PlayTimeTrack playTimeTrack, boolean z) {
        if (z) {
            this.mOnVideoStreamListener.onNewRequest(playVideoInfo);
        }
        IVideoRequest createVideoRequest = createVideoRequest(playVideoInfo);
        this.mVideoRequest = createVideoRequest;
        createVideoRequest.setVideoRequestListener(this.mLiveMediaSourceListCallback);
        playTimeTrack.setLiveControlStartTime(System.currentTimeMillis());
        FastData fastData = playVideoInfo.getFastData();
        if (fastData != null) {
            FastMediaSource fastMediaSource = new FastMediaSource(this.mContext, playVideoInfo, this.mPlayerConfig, playVideoInfo.getFastData().getLiveInfo());
            fastMediaSource.setPlaylistBuilder(this.mPlaylistBuilder);
            fastMediaSource.setPlayerTrack(this.mPlayerTrack);
            this.mVideoStream = fastMediaSource;
            this.mOnVideoStreamListener.onDataReady(fastMediaSource.getYoukuVideoInfo());
            this.mAlixPlayer.setVideoStream(fastMediaSource);
            if (fastData.isRequestVideoInfo()) {
                this.mVideoRequest.request(this.mPlayVideoInfo, null);
                return;
            }
            return;
        }
        Log.i("lwj", "normal start video request " + this + AVFSCacheConstants.COMMA_SEP + this.mVideoRequest);
        this.mVideoRequest.request(playVideoInfo, map);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void addChangeVideoListener(OnChangeVideoListener onChangeVideoListener) {
        this.mOnChangeVideoListeners.add(onChangeVideoListener);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void addInterceptor(Interceptor interceptor) {
        this.mInterceptors.add(interceptor);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void addPlayerErrorListener(OnPlayerErrorListener onPlayerErrorListener) {
        this.mOnPlayerErrorListeners.add(onPlayerErrorListener);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void addPositionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener) {
        this.mPositionChangeListener = onCurrentPositionChangeListener;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void addVideoStreamListener(OnVideoStreamListener onVideoStreamListener) {
        this.mOnVideoStreamListeners.add(onVideoStreamListener);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public IBusinessTrack getBusinessTrack() {
        return this.mBusinessTrack;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public IMultiPlayer getMultiPlayer() {
        return this.mAlixMultiplayer;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public PlayVideoInfo getPlayVideoInfo() {
        return this.mPlayVideoInfo;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public IPlayer getPlayer() {
        return this.mAlixPlayer;
    }

    public PlayerConfig getPlayerConfig() {
        return this.mPlayerConfig;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public IVideoStream getVideoStream() {
        return this.mVideoStream;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public List<OnVideoStreamListener> getVideoStreamListeners() {
        return this.mOnVideoStreamListeners;
    }

    public boolean isPlaying() {
        return this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void play(final PlayVideoInfo playVideoInfo) {
        Log.i("lwj", "start play " + this);
        playVideoInfo.setTag("playTs", Long.valueOf(System.currentTimeMillis()));
        new RealInterceptionWrapper(0, playVideoInfo, this.mInterceptors, new Interceptor() { // from class: com.youku.alixplayer.opensdk.AlixPlayerContainer.1
            @Override // com.youku.alixplayer.opensdk.interceptor.Interceptor
            public void intercept(Chain<Object> chain) {
                AlixPlayerContainer.this.internalPlay(playVideoInfo);
            }
        });
        Log.i("lwj", "end play " + this);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void recyclePlayer() {
        resetListeners();
        this.mOnChangeVideoListeners.clear();
        this.mOnVideoStreamListeners.clear();
        this.mOnPlayerErrorListeners.clear();
        this.mPositionChangeListener = null;
        this.mInterceptors.clear();
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void release() {
        IVideoRequest iVideoRequest = this.mVideoRequest;
        if (iVideoRequest != null) {
            iVideoRequest.cancel();
        }
        IPlayerWrapper iPlayerWrapper = this.mAlixPlayer;
        if (iPlayerWrapper != null) {
            iPlayerWrapper.release();
        }
        IMultiPlayerWrapper iMultiPlayerWrapper = this.mAlixMultiplayer;
        if (iMultiPlayerWrapper != null) {
            iMultiPlayerWrapper.release();
        }
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void replay() {
        PlayVideoInfo playVideoInfo = this.mPlayVideoInfo;
        if (playVideoInfo != null) {
            playVideoInfo.clean();
            this.mPlayVideoInfo.putString(TableField.PLAY_FROM, "replay");
            play(this.mPlayVideoInfo);
            return;
        }
        TLogUtil.playLog("playVideoInfo为空，无法replay");
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void resetListeners() {
        this.mAlixPlayer.clearAllListener();
        this.mAlixPlayer.addOnPlayerStateListener(this.mOnStateChangeListener);
        this.mAlixPlayer.addOnInfoListener(this.mOnInfoListener);
        this.mAlixPlayer.addOnCurrentPositionChangeListener(this.mOnCurrentPositionChangeListener);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void setPlaylistBuilder(IPlaylistBuilder iPlaylistBuilder) {
        this.mPlaylistBuilder = iPlaylistBuilder;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void setVideoRequestFactory(IVideoRequest.Factory factory) {
        this.mFactory = factory;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public boolean snapshot(int i, int i2, String str) {
        return this.mAlixPlayer.screenShotOneFrame(this.mContext.getAssets(), str, i, i2, 0, null, 0, 0, 0, 0) != -1;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public void stop() {
        TLogUtil.playLog("stop", this.mAlixPlayer);
        IVideoRequest iVideoRequest = this.mVideoRequest;
        if (iVideoRequest != null) {
            iVideoRequest.cancel();
        }
        this.mAlixPlayer.stop();
        this.mAlixMultiplayer.stop();
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerContainer
    public PlayerTrack getPlayerTrack() {
        return this.mPlayerTrack;
    }
}
