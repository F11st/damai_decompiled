package com.youku.live.dago.liveplayback.widget.plugins.loading;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.interceptor.Chain;
import com.youku.alixplayer.opensdk.interceptor.Interceptor;
import com.youku.alixplayer.opensdk.statistics.ITrack;
import com.youku.alixplayer.opensdk.utils.MsgIdGroup;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LoadingPlugin extends AbsPlugin implements Interceptor {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mDelayMillis;
    private Handler mHandler;
    private boolean mIsShow;
    private LoadingView mLoadingView;
    private OnInfoListener mOnInfoListener;
    private OnStateChangeListener mOnStateChangeListener;
    private OnVideoStreamListener mOnVideoStreamListener;
    private PlayVideoInfo mPlayVideoInfo;
    private final IPlayer mPlayer;
    private final IPlayerContainer mPlayerContainer;
    private int mRetryCount;
    private Runnable mRetryRunnable;
    private int mSumDelayMillis;

    public LoadingPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOnVideoStreamListener = new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.loading.LoadingPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "914726188")) {
                    ipChange.ipc$dispatch("914726188", new Object[]{this, videoRequestError});
                } else {
                    LoadingPlugin.this.hide();
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1489862869")) {
                    ipChange.ipc$dispatch("-1489862869", new Object[]{this, youkuVideoInfo});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "892018788")) {
                    ipChange.ipc$dispatch("892018788", new Object[]{this, playVideoInfo});
                    return;
                }
                LoadingPlugin.this.mPlayVideoInfo = playVideoInfo;
                LoadingPlugin.this.show();
                LoadingPlugin.this.initRetry();
            }
        };
        this.mOnStateChangeListener = new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.loading.LoadingPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1692908042")) {
                    ipChange.ipc$dispatch("1692908042", new Object[]{this, state, state2});
                } else if (state2 == IAlixPlayer.State.STATE_PRE_AD_STARTED || state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    LoadingPlugin.this.hide();
                    LoadingPlugin.this.initRetry();
                }
            }
        };
        this.mOnInfoListener = new OnInfoListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.loading.LoadingPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnInfoListener
            public void onInfo(int i, int i2, int i3, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1404178415")) {
                    ipChange.ipc$dispatch("-1404178415", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
                } else if (i == 1003) {
                    LoadingPlugin.this.show();
                } else if (i == 1004) {
                    LoadingPlugin.this.hide();
                } else if (MsgIdGroup.isErrorCode(i)) {
                    LoadingPlugin.this.hide();
                }
            }
        };
        this.mRetryCount = 1;
        this.mDelayMillis = 0;
        this.mSumDelayMillis = 0;
        this.mRetryRunnable = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.loading.LoadingPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-212747101")) {
                    ipChange.ipc$dispatch("-212747101", new Object[]{this});
                    return;
                }
                TLogUtil.playLog("满足重试条件，进行重试", LoadingPlugin.this.mPlayerContainer.getPlayer());
                LoadingPlugin.this.mPlayerContainer.getPlayer().replay();
            }
        };
        this.mLoadingView = new LoadingView(alixPlayerContext.getContext(), alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId);
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        int playerIndex = pluginConfig.getPlayerIndex();
        if (playerIndex == 0) {
            this.mPlayer = alixPlayerContext.getPlayerContainer().getPlayer();
        } else if (playerIndex > 0) {
            this.mPlayer = alixPlayerContext.getPlayerContainer().getMultiPlayer().getPlayers().get(playerIndex - 1);
        } else {
            throw new IllegalStateException("PlayerErrorPlugin create failed");
        }
        this.mPlayer.addOnInfoListener(this.mOnInfoListener);
        playerContainer.addVideoStreamListener(this.mOnVideoStreamListener);
        playerContainer.addInterceptor(this);
        this.mPlayer.addOnPlayerStateListener(this.mOnStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955537578")) {
            ipChange.ipc$dispatch("1955537578", new Object[]{this});
            return;
        }
        this.mIsShow = false;
        this.mLoadingView.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRetry() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1138722726")) {
            ipChange.ipc$dispatch("1138722726", new Object[]{this});
            return;
        }
        this.mRetryCount = 1;
        this.mDelayMillis = 0;
        this.mSumDelayMillis = 0;
        ITrack track = this.mPlayerContainer.getPlayerTrack().getTrack();
        if (track != null) {
            track.putString("retryCount", null);
            track.putString("retryErrorCode", null);
        }
    }

    private boolean needRetry(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972250755")) {
            return ((Boolean) ipChange.ipc$dispatch("1972250755", new Object[]{this, message})).booleanValue();
        }
        int i = message.arg1;
        return i == 11802 || i == 11803 || i == 11804 || i == 11805 || i == 11806 || i == 11807 || i == 11808;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184758001")) {
            ipChange.ipc$dispatch("-1184758001", new Object[]{this});
        } else if (this.mIsShow) {
        } else {
            this.mIsShow = true;
            PlayVideoInfo playVideoInfo = this.mPlayVideoInfo;
            if (playVideoInfo != null && "1".equals(playVideoInfo.getString("isYkMulti"))) {
                this.mLoadingView.show("即将开启多视角机位体验");
                this.mPlayVideoInfo.putString("isYkMulti", null);
            }
            PlayVideoInfo playVideoInfo2 = this.mPlayVideoInfo;
            if (playVideoInfo2 == null || !"1".equals(playVideoInfo2.getString("change_quality_setdatasource"))) {
                this.mLoadingView.show();
            }
        }
    }

    @Override // com.youku.alixplayer.opensdk.interceptor.Interceptor
    public void intercept(Chain<Object> chain) {
        Message message;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2016619149")) {
            ipChange.ipc$dispatch("-2016619149", new Object[]{this, chain});
            return;
        }
        if (chain.getAction() == 3) {
            if (needRetry((Message) chain.getParam()) && (i = this.mSumDelayMillis) < 300000) {
                int i2 = this.mDelayMillis + ((this.mRetryCount - 1) * 2000);
                this.mDelayMillis = i2;
                this.mSumDelayMillis = i + i2;
                if (i2 > 0) {
                    show();
                }
                ITrack track = this.mPlayerContainer.getPlayerTrack().getTrack();
                if (track != null) {
                    track.putString("retryCount", this.mRetryCount + "");
                    track.putString("retryErrorCode", message.arg1 + "");
                }
                this.mHandler.postDelayed(this.mRetryRunnable, this.mDelayMillis);
                this.mRetryCount++;
                return;
            }
        }
        chain.proceed();
    }
}
