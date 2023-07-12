package com.youku.live.dago.liveplayback.widget.plugins.hbr;

import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.view.ViewGroup;
import com.airbnb.lottie.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.bean.Quality;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipManager;
import com.youku.live.dago.liveplayback.widget.utils.HbrUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HBRPlugin extends AbsPlugin implements HBRContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "HBRPlugin";
    private static final int mChangeTimeout = 15000;
    private int mFromQuality;
    private Handler mHandler;
    private boolean mIsFromDolby;
    private IPlayer mPlayer;
    private IAlixPlayer.State mState;
    private Runnable mTimeoutRunnable;
    private HBRPluginView mView;
    private YoukuVideoInfo mYoukuVideoInfo;

    public HBRPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mIsFromDolby = false;
        this.mFromQuality = -1;
        this.mTimeoutRunnable = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1652646350")) {
                    ipChange.ipc$dispatch("1652646350", new Object[]{this});
                } else if (HBRPlugin.this.mView == null || !HBRPlugin.this.mView.isInflated()) {
                } else {
                    HBRPlugin.this.mView.hide();
                }
            }
        };
        HBRPluginView hBRPluginView = new HBRPluginView(alixPlayerContext, alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId, R.layout.dago_frame_plugin_view, alixPlayerContext.getPluginManager(viewGroup).getViewPlaceholder(this.mName));
        this.mView = hBRPluginView;
        hBRPluginView.setPresenter((HBRContract.Presenter) this);
        this.mAttachToParent = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1929501787")) {
                    ipChange.ipc$dispatch("-1929501787", new Object[]{this, videoRequestError});
                } else {
                    HBRPlugin.this.handleChangeCancelEvent();
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1059303452")) {
                    ipChange.ipc$dispatch("-1059303452", new Object[]{this, youkuVideoInfo});
                } else {
                    HBRPlugin.this.mYoukuVideoInfo = youkuVideoInfo;
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1322578205")) {
                    ipChange.ipc$dispatch("1322578205", new Object[]{this, playVideoInfo});
                }
            }
        });
        alixPlayerContext.getPlayerContainer().addChangeVideoListener(new OnChangeVideoListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideo(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "146488011")) {
                    ipChange.ipc$dispatch("146488011", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideoFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "623761084")) {
                    ipChange.ipc$dispatch("623761084", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    HBRPlugin.this.handleChangeQualitySuccess();
                }
            }
        });
        IPlayer player = alixPlayerContext.getPlayerContainer().getPlayer();
        this.mPlayer = player;
        player.addOnPlayerStateListener(new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2103433552")) {
                    ipChange.ipc$dispatch("2103433552", new Object[]{this, state, state2});
                    return;
                }
                HBRPlugin.this.mState = state2;
                if (HBRPlugin.this.mState == IAlixPlayer.State.STATE_RELEASED) {
                    if (!HBRPlugin.this.mIsFromDolby) {
                        HBRPlugin.this.handleChangeCancelEvent();
                    }
                    HBRPlugin.this.mIsFromDolby = false;
                    HBRPlugin.this.handleActivityDestroy();
                } else if (HBRPlugin.this.mState == IAlixPlayer.State.STATE_ERROR) {
                    HBRPlugin.this.handleChangeCancelEvent();
                    HBRPlugin.this.mIsFromDolby = false;
                } else if (HBRPlugin.this.mState != IAlixPlayer.State.STATE_VIDEO_STARTED || HBRPlugin.this.mPlayer == null || HBRPlugin.this.mPlayer.getVideoStream() == null || HBRPlugin.this.mPlayer.getVideoStream().getCurAlixVideoItem() == null || HBRPlugin.this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality() == HBRPlugin.this.mFromQuality) {
                } else {
                    HBRPlugin.this.handleChangeQualitySuccess();
                }
            }
        });
        this.mPlayerContext.getEventBus().register(this);
        this.mView.hide();
        checkState();
        try {
            b.s(alixPlayerContext.getContext(), HBRPluginView.HBR_CHANGING_LOTTIE);
        } catch (Exception unused) {
        }
    }

    private void checkState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831813797")) {
            ipChange.ipc$dispatch("-1831813797", new Object[]{this});
        } else if (this.mPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mYoukuVideoInfo = this.mPlayer.getVideoStream().getYoukuVideoInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557112413")) {
            ipChange.ipc$dispatch("-557112413", new Object[]{this});
            return;
        }
        HBRPluginView hBRPluginView = this.mView;
        if (hBRPluginView != null) {
            hBRPluginView.handleHBRDestroy();
        }
        HBRPluginView hBRPluginView2 = this.mView;
        if (hBRPluginView2 != null && hBRPluginView2.isInflated()) {
            this.mView.hide();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeCancelEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515231422")) {
            ipChange.ipc$dispatch("515231422", new Object[]{this});
            return;
        }
        removeRunnable(this.mTimeoutRunnable);
        this.mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "473565320")) {
                    ipChange2.ipc$dispatch("473565320", new Object[]{this});
                    return;
                }
                if (HBRPlugin.this.mView != null) {
                    HBRPlugin.this.mView.handleHBRCancel();
                }
                if (HBRPlugin.this.mView == null || !HBRPlugin.this.mView.isInflated()) {
                    return;
                }
                HBRPlugin.this.mView.hide();
            }
        });
    }

    private void handleChangeFinishedEvent(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725825794")) {
            ipChange.ipc$dispatch("-1725825794", new Object[]{this, event});
            return;
        }
        removeRunnable(this.mTimeoutRunnable);
        this.mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "670078825")) {
                    ipChange2.ipc$dispatch("670078825", new Object[]{this});
                } else if (HBRPlugin.this.mView != null) {
                    HBRPlugin.this.mView.handleHBRChanged();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeQualitySuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224188216")) {
            ipChange.ipc$dispatch("-1224188216", new Object[]{this});
        } else if (HbrUtil.isVideoHbr(this.mYoukuVideoInfo, this.mPlayerContext.getPlayerContainer().getPlayer().getVideoStream().getCurAlixVideoItem().getLiveQuality())) {
            handleChangeFinishedEvent(null);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "866592330")) {
                        ipChange2.ipc$dispatch("866592330", new Object[]{this});
                    } else if (HBRPlugin.this.mView == null || !HBRPlugin.this.mView.isInflated()) {
                    } else {
                        HBRPlugin.this.mView.hide();
                    }
                }
            });
        }
    }

    private void handleChangingEvent(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2014532787")) {
            ipChange.ipc$dispatch("2014532787", new Object[]{this, event});
            return;
        }
        this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.HIDE_CONTROL));
        Utils.hideTopTips(this.mPlayerContext);
        HBRPluginView hBRPluginView = this.mView;
        if (hBRPluginView != null) {
            if (!hBRPluginView.isInflated()) {
                this.mView.inflate();
            }
            this.mView.show();
            this.mView.handleStartHBRChanging();
            runDelay(this.mTimeoutRunnable, 15000L);
        }
    }

    private void handleCloseHBREvent(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-638313184")) {
            ipChange.ipc$dispatch("-638313184", new Object[]{this, event});
            return;
        }
        PlayVideoInfo playVideoInfo = this.mPlayerContext.getPlayerContainer().getPlayVideoInfo();
        playVideoInfo.setRequestLiveQuality(this.mFromQuality);
        this.mPlayerContext.getPlayerContainer().play(playVideoInfo);
    }

    private void handleOpenHBREvent(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1320331460")) {
            ipChange.ipc$dispatch("1320331460", new Object[]{this, event});
            return;
        }
        AlixPlayerContext alixPlayerContext = this.mPlayerContext;
        if (alixPlayerContext == null || alixPlayerContext.getPlayerContainer() == null || this.mPlayerContext.getPlayerContainer().getVideoStream() == null || !HbrUtil.hasHbr(this.mYoukuVideoInfo)) {
            return;
        }
        this.mIsFromDolby = false;
        this.mFromQuality = this.mPlayerContext.getPlayerContainer().getPlayer().getVideoStream().getCurAlixVideoItem().getLiveQuality();
        handleChangingEvent(null);
    }

    private void jumpHBRPay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934557360")) {
            ipChange.ipc$dispatch("-934557360", new Object[]{this, str});
        }
    }

    private void removeRunnable(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51823233")) {
            ipChange.ipc$dispatch("51823233", new Object[]{this, runnable});
        } else {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    private void runDelay(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485743130")) {
            ipChange.ipc$dispatch("485743130", new Object[]{this, runnable, Long.valueOf(j)});
        } else {
            this.mHandler.postDelayed(runnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQualityTipChangeEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019521664")) {
            ipChange.ipc$dispatch("-1019521664", new Object[]{this});
            return;
        }
        Event event = new Event(ApiConstants.EventType.ON_QUALITY_TIP_VISIBILITY_CHANGE);
        HashMap hashMap = new HashMap();
        hashMap.put("visible", Boolean.FALSE);
        event.data = hashMap;
        this.mPlayerContext.getEventBus().postSticky(event);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (r0.equals(com.youku.live.dago.liveplayback.ApiConstants.EventType.HBR_QUALITY_CHANGE_CANCEL) == false) goto L10;
     */
    @com.youku.kubus.Subscribe(eventType = {com.youku.live.dago.liveplayback.ApiConstants.EventType.REQUEST_OPEN_HBR, com.youku.live.dago.liveplayback.ApiConstants.EventType.REQUEST_CLOSE_HBR, com.youku.live.dago.liveplayback.ApiConstants.EventType.HBR_QUALITY_CHANGING, com.youku.live.dago.liveplayback.ApiConstants.EventType.HBR_QUALITY_CHANGE_FINISHED, com.youku.live.dago.liveplayback.ApiConstants.EventType.HBR_QUALITY_CHANGE_CANCEL}, priority = 1, threadMode = com.youku.kubus.ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dispatchEvent(com.youku.kubus.Event r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.$ipChange
            java.lang.String r1 = "-227318386"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r5] = r6
            r2[r3] = r7
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            if (r7 != 0) goto L1a
            return
        L1a:
            java.lang.String r0 = r7.type
            r0.hashCode()
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case -974997404: goto L53;
                case -635077908: goto L4a;
                case -178117789: goto L3f;
                case 1040152529: goto L34;
                case 1131084895: goto L29;
                default: goto L27;
            }
        L27:
            r3 = -1
            goto L5d
        L29:
            java.lang.String r2 = "kubus://player/notification/dago_frame_quality_changing"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L32
            goto L27
        L32:
            r3 = 4
            goto L5d
        L34:
            java.lang.String r2 = "kubus://player/notification/dago_close_hbr"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L3d
            goto L27
        L3d:
            r3 = 3
            goto L5d
        L3f:
            java.lang.String r2 = "kubus://player/notification/dago_open_hbr"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L48
            goto L27
        L48:
            r3 = 2
            goto L5d
        L4a:
            java.lang.String r2 = "kubus://player/notification/dago_frame_quality_cancel"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L5d
            goto L27
        L53:
            java.lang.String r2 = "kubus://player/notification/dago_frame_quality_finished"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L5c
            goto L27
        L5c:
            r3 = 0
        L5d:
            switch(r3) {
                case 0: goto L73;
                case 1: goto L6d;
                case 2: goto L69;
                case 3: goto L65;
                case 4: goto L61;
                default: goto L60;
            }
        L60:
            goto L76
        L61:
            r6.handleChangingEvent(r7)
            goto L76
        L65:
            r6.handleCloseHBREvent(r7)
            goto L76
        L69:
            r6.handleOpenHBREvent(r7)
            goto L76
        L6d:
            r6.handleChangeCancelEvent()
            r6.mIsFromDolby = r5
            goto L76
        L73:
            r6.handleChangeFinishedEvent(r7)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.dispatchEvent(com.youku.kubus.Event):void");
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void doClickHdrInstructionClose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193419423")) {
            ipChange.ipc$dispatch("-193419423", new Object[]{this});
        } else if (this.mState != IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mPlayerContext.getPlayerContainer().getPlayer().start();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void hideQualityView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631784188")) {
            ipChange.ipc$dispatch("-631784188", new Object[]{this});
        } else {
            this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REQUEST_QUALITY_VIEW_HIDE));
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.REQUEST_IS_CHANGING_HBR}, priority = 1, threadMode = ThreadMode.MAIN)
    public void isHBRChanging(Event event) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1987144887")) {
            ipChange.ipc$dispatch("-1987144887", new Object[]{this, event});
            return;
        }
        EventBus eventBus = this.mPlayerContext.getEventBus();
        HBRPluginView hBRPluginView = this.mView;
        eventBus.response(event, Boolean.valueOf((hBRPluginView == null || !hBRPluginView.isShow()) ? false : false));
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_HBR_INSTRUCTION}, priority = 1, threadMode = ThreadMode.MAIN)
    public void onShowHbrInstruction(Event event) {
        Map map;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829605602")) {
            ipChange.ipc$dispatch("1829605602", new Object[]{this, event});
            return;
        }
        if (this.mState == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "277051815")) {
                        ipChange2.ipc$dispatch("277051815", new Object[]{this});
                    } else {
                        ((AbsPlugin) HBRPlugin.this).mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.HIDE_CONTROL));
                    }
                }
            }, 500L);
        }
        Object obj = event.data;
        String str = (obj == null || (map = (Map) obj) == null) ? "" : (String) map.get("source_from");
        HBRPluginView hBRPluginView = this.mView;
        if (hBRPluginView != null) {
            hBRPluginView.inflate();
            if (this.mView != null) {
                AlixPlayerContext alixPlayerContext = this.mPlayerContext;
                if (alixPlayerContext != null && alixPlayerContext.getPlayerContainer() != null && this.mPlayerContext.getPlayerContainer().getVideoStream() != null) {
                    boolean hasHbr = HbrUtil.hasHbr(this.mPlayerContext.getPlayerContainer().getVideoStream().getYoukuVideoInfo());
                    this.mView.showShowHBRIntroduction(hasHbr, hasHbr, false, str);
                    return;
                }
                this.mView.showShowHBRIntroduction();
            }
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void openHBR() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845715432")) {
            ipChange.ipc$dispatch("-845715432", new Object[]{this});
        } else if (!HbrUtil.hasHbr(this.mYoukuVideoInfo) || HbrUtil.isVideoHbr(this.mYoukuVideoInfo, this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality())) {
        } else {
            this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REQUEST_OPEN_HBR));
            PlayVideoInfo playVideoInfo = this.mPlayerContext.getPlayerContainer().getPlayVideoInfo();
            int i = -1;
            Iterator<Quality> it = this.mYoukuVideoInfo.getLivePlayControl().qualities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Quality next = it.next();
                if (next.hbr == 1) {
                    i = next.quality;
                    break;
                }
            }
            playVideoInfo.setRequestLiveQuality(i);
            this.mPlayerContext.getPlayerContainer().play(playVideoInfo);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void setOrientation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1698464864")) {
            ipChange.ipc$dispatch("1698464864", new Object[]{this, str});
        } else {
            this.mPlayerContext.getEventBus().post(new Event(str));
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void showHBRChangedTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1373629645")) {
            ipChange.ipc$dispatch("-1373629645", new Object[]{this});
            return;
        }
        Utils.showVipTopTips(this.mPlayerContext, TopTipManager.TipName.CHANGE_QUALITY_TIP_PLUGIN, Html.fromHtml("<font color=#F7C3A7>已为您开启VIP专属的帧享视听体验，请确保当前网络环境良好</font>"), 52, -1, 3000, false, null, new TopTipInfo.DismissCallback() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo.DismissCallback
            public void onDismiss() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2122211162")) {
                    ipChange2.ipc$dispatch("-2122211162", new Object[]{this});
                } else {
                    HBRPlugin.this.sendQualityTipChangeEvent();
                }
            }
        });
    }
}
