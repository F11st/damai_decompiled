package com.youku.live.dago.liveplayback.widget.plugins.horizontalfull;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnDataSourceListener;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.alixplugin.view.BaseView;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.widget.PickStatus;
import com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.WeexWidget;
import com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HorizontalFullscreenPlugin extends BaseScreenPlugin implements HorizontalFullControlContact.Presenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String BIZ_TYPE_CIBN = "7";
    private EventBus mEventBus;
    private OnDataSourceListener mOnDataSourceListener;
    private IPlayer mPlayer;
    private IPlayerContainer mPlayerContainer;
    private IAlixPlayer.State mState;
    private HorizontalFullControlView mView;

    public HorizontalFullscreenPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mOnDataSourceListener = new OnDataSourceListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplugin.OnDataSourceListener
            public void onChanged(String str, Object obj, Object obj2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "800250215")) {
                    ipChange.ipc$dispatch("800250215", new Object[]{this, str, obj, obj2});
                } else if ("pick_status".equals(str) && (obj2 instanceof PickStatus)) {
                    if (obj2 == PickStatus.ROTATE_INIT || obj2 == PickStatus.ROTATE_START) {
                        HorizontalFullscreenPlugin.this.mView.hide(false);
                    }
                }
            }
        };
        HorizontalFullControlView horizontalFullControlView = new HorizontalFullControlView(alixPlayerContext.getContext(), alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId, alixPlayerContext.getPluginManager(viewGroup).getViewPlaceholder(this.mName));
        this.mView = horizontalFullControlView;
        horizontalFullControlView.setPresenter((HorizontalFullControlContact.Presenter) this);
        this.mAttachToParent = true;
        this.mEventBus = alixPlayerContext.getEventBus();
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1736467806")) {
                    ipChange.ipc$dispatch("1736467806", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(final YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-800740387")) {
                    ipChange.ipc$dispatch("-800740387", new Object[]{this, youkuVideoInfo});
                } else {
                    ((BaseScreenPlugin) HorizontalFullscreenPlugin.this).mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.1.2
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-957131514")) {
                                ipChange2.ipc$dispatch("-957131514", new Object[]{this});
                                return;
                            }
                            HorizontalFullscreenPlugin.this.hideQualityTip();
                            HorizontalFullscreenPlugin.this.onGetVideoInfoSuccess(youkuVideoInfo);
                        }
                    });
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1581141270")) {
                    ipChange.ipc$dispatch("1581141270", new Object[]{this, playVideoInfo});
                } else {
                    ((BaseScreenPlugin) HorizontalFullscreenPlugin.this).mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-760618009")) {
                                ipChange2.ipc$dispatch("-760618009", new Object[]{this});
                            } else if (HorizontalFullscreenPlugin.this.mView.isShow()) {
                                HorizontalFullscreenPlugin.this.mView.hide();
                                HorizontalFullscreenPlugin.this.hideQualityTip();
                            }
                        }
                    });
                }
            }
        });
        getPlayerContext().addDataSourceListener(this.mOnDataSourceListener);
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        this.mPlayer = playerContainer.getPlayer();
        this.mPlayerContainer.addPositionChangeListener(new OnCurrentPositionChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnCurrentPositionChangeListener
            public void onCurrentPostionChange(final int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1502853845")) {
                    ipChange.ipc$dispatch("1502853845", new Object[]{this, Integer.valueOf(i)});
                } else {
                    ((BaseScreenPlugin) HorizontalFullscreenPlugin.this).mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.2.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-631535290")) {
                                ipChange2.ipc$dispatch("-631535290", new Object[]{this});
                            } else if (HorizontalFullscreenPlugin.this.mView.isShow()) {
                                HorizontalFullscreenPlugin.this.mView.updateProgress(i);
                            }
                        }
                    });
                }
            }
        });
        this.mPlayer.addOnPlayerStateListener(new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "312325367")) {
                    ipChange.ipc$dispatch("312325367", new Object[]{this, state, state2});
                    return;
                }
                HorizontalFullscreenPlugin.this.mState = state2;
                if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    HorizontalFullscreenPlugin.this.initShow();
                }
            }
        });
        this.mPlayer.addOnInfoListener(new OnInfoListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnInfoListener
            public void onInfo(int i, final int i2, int i3, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1957189058")) {
                    ipChange.ipc$dispatch("-1957189058", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
                } else if (i == 2016) {
                    ((BaseScreenPlugin) HorizontalFullscreenPlugin.this).mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.4.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-373369852")) {
                                ipChange2.ipc$dispatch("-373369852", new Object[]{this});
                            } else {
                                HorizontalFullscreenPlugin.this.mView.showQualityTip(true, Quality.getQualityByAbrCode(i2).getDescription());
                            }
                        }
                    });
                }
            }
        });
        this.mEventBus.register(this);
        hide();
        initShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1458054766")) {
            ipChange.ipc$dispatch("-1458054766", new Object[]{this});
            return;
        }
        IAlixPlayer.State currentState = this.mPlayer.getCurrentState();
        if (currentState != IAlixPlayer.State.STATE_VIDEO_STARTED && currentState != IAlixPlayer.State.STATE_VIDEO_PAUSED) {
            this.mView.hide();
        } else if (!canShow()) {
            hide();
        } else if (this.mPlayerContext.isLandScreen() && this.mPlayerContext.isLandVideo() && (this.mPlayerContext.get("pick_status") == null || this.mPlayerContext.get("pick_status") == PickStatus.ROTATE_FINISH || this.mPlayerContext.get("pick_status") == PickStatus.ROTATE_INIT)) {
            onGetVideoInfoSuccess(this.mPlayerContainer.getVideoStream().getYoukuVideoInfo());
            show();
        } else {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideQualityTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144834720")) {
            ipChange.ipc$dispatch("-2144834720", new Object[]{this});
        } else {
            this.mView.showQualityTip(false, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137856913")) {
            ipChange.ipc$dispatch("1137856913", new Object[]{this});
        } else {
            this.mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "337702352")) {
                        ipChange2.ipc$dispatch("337702352", new Object[]{this});
                    } else if (HorizontalFullscreenPlugin.this.mPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                        HorizontalFullscreenPlugin.this.checkAndShow();
                    } else {
                        HorizontalFullscreenPlugin.this.mView.hide();
                    }
                }
            });
        }
    }

    private boolean isPickMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546770740")) {
            return ((Boolean) ipChange.ipc$dispatch("546770740", new Object[]{this})).booleanValue();
        }
        Object obj = this.mPlayerContext.get("isPickMode");
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetVideoInfoSuccess(YoukuVideoInfo youkuVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755099687")) {
            ipChange.ipc$dispatch("1755099687", new Object[]{this, youkuVideoInfo});
            return;
        }
        try {
            List<AlixVideoItem> videoList = this.mPlayerContainer.getVideoStream().getVideoList(null);
            if ("7".equals(youkuVideoInfo.getLivePlayControl().bizType)) {
                this.mView.showQualityTip(false, "");
                this.mView.showQualityView(false, "");
            } else if (videoList != null && videoList.size() > 1) {
                int liveQuality = this.mPlayerContainer.getVideoStream().getCurAlixVideoItem().getLiveQuality();
                if (youkuVideoInfo.getLivePlayControl() != null) {
                    for (com.youku.android.liveservice.bean.Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                        if (quality.quality == liveQuality) {
                            this.mView.showQualityView(true, quality.name);
                            break;
                        }
                    }
                }
            } else {
                this.mView.showQualityTip(false, "");
                this.mView.showQualityView(false, "");
            }
        } catch (Exception e) {
            Log.e("", "EXCEPTION:" + e);
        }
        LivePlayControl livePlayControl = youkuVideoInfo.getLivePlayControl();
        boolean z = youkuVideoInfo.getPlayVideoInfo().getPlayType() == PlayType.LIVE ? youkuVideoInfo.getLiveInfo().isTrail : false;
        if (livePlayControl != null && "1".equals(livePlayControl.playerWidget.castScreen) && !z) {
            this.mView.showDisplayButton(true);
            this.mView.setCastMode(true);
            return;
        }
        this.mView.setCastMode(false);
    }

    private void openScenePanel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "49438748")) {
            ipChange.ipc$dispatch("49438748", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isOpenScenePanel", Boolean.TRUE);
        sendEngineData(hashMap);
    }

    private void sendEngineData(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1026035547")) {
            ipChange.ipc$dispatch("1026035547", new Object[]{this, map});
            return;
        }
        Event event = new Event(ApiConstants.EventType.ENGINE_PUT_DATA);
        event.message = "LFLWDataCenterListMultiSceneStateKey";
        event.data = map;
        this.mPlayerContext.getEventBus().post(event);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin
    protected void addView(List<WeexWidget> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009365815")) {
            ipChange.ipc$dispatch("2009365815", new Object[]{this, list});
        } else {
            this.mView.addView(list);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin, com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.Presenter
    public void addViewGroup(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1807422524")) {
            ipChange.ipc$dispatch("-1807422524", new Object[]{this, viewGroup});
        } else {
            super.addViewGroup(viewGroup);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.Presenter
    public int getMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-25569242") ? ((Integer) ipChange.ipc$dispatch("-25569242", new Object[]{this})).intValue() : getPlayerContext().getMode();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin
    protected BaseView getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "830576706") ? (BaseView) ipChange.ipc$dispatch("830576706", new Object[]{this}) : this.mView;
    }

    @Subscribe(eventType = {ApiConstants.EventType.HIDE_CONTROL}, priority = 1, threadMode = ThreadMode.POSTING)
    public void hidePlayControl(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449791727")) {
            ipChange.ipc$dispatch("449791727", new Object[]{this, event});
        } else if (this.mView.isShow()) {
            hide();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.Presenter
    public void onControlBtnClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1552487805")) {
            ipChange.ipc$dispatch("-1552487805", new Object[]{this});
            return;
        }
        if (this.mState == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mPlayer.pause();
        } else if (this.mPlayerContainer.getPlayVideoInfo().getPlayType() == PlayType.LIVE) {
            LiveInfo liveInfo = this.mPlayerContainer.getVideoStream().getYoukuVideoInfo().getLiveInfo();
            if (liveInfo != null && liveInfo.timeshift == -1) {
                HorizontalFullControlView horizontalFullControlView = this.mView;
                horizontalFullControlView.dragEndForTimeShift(horizontalFullControlView.getLiveTime(), this.mView.getLiveTime(), true);
            } else {
                this.mPlayer.start();
            }
        } else {
            this.mPlayer.start();
        }
        this.mView.showControl();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.Presenter
    public void onDisplayBtnClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1843092674")) {
            ipChange.ipc$dispatch("-1843092674", new Object[]{this});
        } else if (this.mPlayerContext.isDlnaMode()) {
            this.mEventBus.post(new Event("kubus://dlna/notification/request_dlna_quit"));
        } else {
            if (isPickMode()) {
                this.mPlayerContext.put("isPickMode", Boolean.FALSE);
            }
            this.mEventBus.post(new Event(ApiConstants.EventType.REQUEST_DLNA_SHOW_SMALL));
            hide();
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_ERROR}, priority = 1, threadMode = ThreadMode.POSTING)
    public void onError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876693219")) {
            ipChange.ipc$dispatch("1876693219", new Object[]{this});
        } else {
            hide();
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_SINGLE_TAP}, priority = 1, threadMode = ThreadMode.POSTING)
    public void onSingleTap(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751136612")) {
            ipChange.ipc$dispatch("1751136612", new Object[]{this, event});
        } else if (this.mView.isShow()) {
            hide();
        } else {
            checkAndShow();
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.REFRESH_CONTROL_VIEW}, priority = 1, threadMode = ThreadMode.POSTING)
    public void refreshControl(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224451624")) {
            ipChange.ipc$dispatch("-224451624", new Object[]{this, event});
        } else {
            checkAndShow();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.Presenter
    public void seekTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1629577528")) {
            ipChange.ipc$dispatch("1629577528", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < this.mPlayer.getDuration()) {
            this.mPlayer.seekTo(i, 0);
        }
        hideControlDelay();
    }

    public void setLiveTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847115699")) {
            ipChange.ipc$dispatch("847115699", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mView.setLiveTime(j);
        }
    }

    public void setNowTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711733095")) {
            ipChange.ipc$dispatch("711733095", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mView.setNowTime(j);
        }
    }

    public void setStartTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759495091")) {
            ipChange.ipc$dispatch("1759495091", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mView.setStartTime(j);
        }
    }

    public void setSumTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32505308")) {
            ipChange.ipc$dispatch("32505308", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mView.setSumTime(j);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.Presenter
    public void showMultiList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719911310")) {
            ipChange.ipc$dispatch("-719911310", new Object[]{this});
        } else {
            openScenePanel();
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_CONTROL}, priority = 1, threadMode = ThreadMode.POSTING)
    public void showPlayControl(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231868436")) {
            ipChange.ipc$dispatch("1231868436", new Object[]{this, event});
        } else {
            checkAndShow();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.Presenter
    public void showQuality(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461216856")) {
            ipChange.ipc$dispatch("-1461216856", new Object[]{this, view});
            return;
        }
        this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.SHOW_QUALITY));
        hide();
    }
}
