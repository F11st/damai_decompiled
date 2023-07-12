package com.youku.live.dago.liveplayback.widget.plugins.quality;

import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Quality;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.ConfigUtils;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityContract;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ChangeQualityPlugin extends AbsPlugin implements ChangeQualityContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ChangeQualityPlugin";
    public List<Quality> mDefinitions;
    private IPlayerContainer mPlayer;
    private OnVideoStreamListener mPlayerListener;
    private ChangeQualityView mView;
    private YoukuVideoInfo mYoukuVideoInfo;
    private Map<String, Quality> qualityMap;
    public int streamType;

    public ChangeQualityPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mDefinitions = new ArrayList();
        this.streamType = -1;
        this.mPlayerListener = new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-161446750")) {
                    ipChange.ipc$dispatch("-161446750", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-865285087")) {
                    ipChange.ipc$dispatch("-865285087", new Object[]{this, youkuVideoInfo});
                } else {
                    ChangeQualityPlugin.this.initData(youkuVideoInfo);
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1516596570")) {
                    ipChange.ipc$dispatch("1516596570", new Object[]{this, playVideoInfo});
                } else {
                    ChangeQualityPlugin.this.onNewRequest();
                }
            }
        };
        ChangeQualityView changeQualityView = new ChangeQualityView(alixPlayerContext, alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId, R.C7935layout.dago_change_quality_view, alixPlayerContext.getPluginManager(viewGroup).getViewPlaceholder(this.mName));
        this.mView = changeQualityView;
        changeQualityView.setPresenter((ChangeQualityContract.Presenter) this);
        this.mAttachToParent = true;
        this.mPlayer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContext.getEventBus().register(this);
        this.mPlayer.addVideoStreamListener(this.mPlayerListener);
        this.mPlayerContext.getPlayerContainer().getPlayer().addOnPlayerStateListener(new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                Quality liveControlQuality;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-405836076")) {
                    ipChange.ipc$dispatch("-405836076", new Object[]{this, state, state2});
                } else if (state2 != IAlixPlayer.State.STATE_VIDEO_STARTED || ((AbsPlugin) ChangeQualityPlugin.this).mPlayerContext.getPlayerContainer().getPlayVideoInfo().getString("change_quality_setdatasource") == null || !"1".equals(((AbsPlugin) ChangeQualityPlugin.this).mPlayerContext.getPlayerContainer().getPlayVideoInfo().getString("change_quality_setdatasource")) || (liveControlQuality = Utils.getLiveControlQuality(ChangeQualityPlugin.this.mYoukuVideoInfo, ChangeQualityPlugin.this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality())) == null || liveControlQuality.hbr == 1) {
                } else {
                    ChangeQualityPlugin.this.showChangeFinishTips(liveControlQuality);
                }
            }
        });
        this.mPlayerContext.getPlayerContainer().addChangeVideoListener(new OnChangeVideoListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideo(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1362191219")) {
                    ipChange.ipc$dispatch("-1362191219", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                Quality liveControlQuality = Utils.getLiveControlQuality(ChangeQualityPlugin.this.mYoukuVideoInfo, i2);
                if (liveControlQuality == null || liveControlQuality.hbr == 1) {
                    return;
                }
                ChangeQualityPlugin.this.showChangingTips(liveControlQuality);
            }

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideoFinish(boolean z) {
                Quality liveControlQuality;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "605765178")) {
                    ipChange.ipc$dispatch("605765178", new Object[]{this, Boolean.valueOf(z)});
                } else if (!z || (liveControlQuality = Utils.getLiveControlQuality(ChangeQualityPlugin.this.mYoukuVideoInfo, ChangeQualityPlugin.this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality())) == null || liveControlQuality.hbr == 1) {
                } else {
                    ChangeQualityPlugin.this.showChangeFinishTips(liveControlQuality);
                }
            }
        });
    }

    private void closeHbrTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213933293")) {
            ipChange.ipc$dispatch("213933293", new Object[]{this});
            return;
        }
        Utils.showVipTopTips(this.mPlayerContext, TopTipManager.TipName.CHANGE_QUALITY_TIP_PLUGIN, Html.fromHtml("<font color=#F7C3A7>正在关闭VIP专属的帧享视听体验</font>"), 53, -1, 10000, true, null, new TopTipInfo.DismissCallback() { // from class: com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityPlugin.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo.DismissCallback
            public void onDismiss() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "81953900")) {
                    ipChange2.ipc$dispatch("81953900", new Object[]{this});
                } else {
                    ChangeQualityPlugin.this.sendQualityTipChangeEvent();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(YoukuVideoInfo youkuVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2131359686")) {
            ipChange.ipc$dispatch("-2131359686", new Object[]{this, youkuVideoInfo});
            return;
        }
        this.mYoukuVideoInfo = youkuVideoInfo;
        LivePlayControl livePlayControl = youkuVideoInfo.getLivePlayControl();
        if (livePlayControl == null || !"live".equals(livePlayControl.streamMode)) {
            return;
        }
        this.qualityMap = new HashMap();
        this.mDefinitions.clear();
        for (Quality quality : livePlayControl.qualities) {
            if (quality.hbr == 0 || ConfigUtils.supportLiveHbr()) {
                this.mDefinitions.add(quality);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109412564")) {
            ipChange.ipc$dispatch("2109412564", new Object[]{this});
            return;
        }
        if (this.mView.isShow()) {
            this.mView.hide();
        }
        this.streamType = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQualityTipChangeEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264645310")) {
            ipChange.ipc$dispatch("-264645310", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showChangeFinishTips(Quality quality) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962706495")) {
            ipChange.ipc$dispatch("1962706495", new Object[]{this, quality});
            return;
        }
        Utils.showTopTips(this.mPlayerContext, TopTipManager.TipName.CHANGE_QUALITY_TIP_PLUGIN, Html.fromHtml("已为您切换到<font color=#0D9BFF>" + quality.name + "</font>"), -1, -1, 3000, true, null, new TopTipInfo.DismissCallback() { // from class: com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo.DismissCallback
            public void onDismiss() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "592488077")) {
                    ipChange2.ipc$dispatch("592488077", new Object[]{this});
                } else {
                    ChangeQualityPlugin.this.sendQualityTipChangeEvent();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showChangingTips(Quality quality) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000161269")) {
            ipChange.ipc$dispatch("2000161269", new Object[]{this, quality});
            return;
        }
        Utils.showTopTips(this.mPlayerContext, TopTipManager.TipName.CHANGE_QUALITY_TIP_PLUGIN, Html.fromHtml("正在切换到<font color=#0D9BFF>" + quality.name + "</font>，请稍候..."), -1, -1, 3000, true, null, new TopTipInfo.DismissCallback() { // from class: com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityPlugin.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo.DismissCallback
            public void onDismiss() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-428580277")) {
                    ipChange2.ipc$dispatch("-428580277", new Object[]{this});
                } else {
                    ChangeQualityPlugin.this.sendQualityTipChangeEvent();
                }
            }
        });
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityContract.Presenter
    public void changeQuality(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802942774")) {
            ipChange.ipc$dispatch("-1802942774", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.mDefinitions.get(i).quality;
        if (i2 != this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality()) {
            Event event = new Event(ApiConstants.EventType.HBR_QUALITY_CHANGE_CLICK);
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.Name.QUALITY, this.mDefinitions.get(i).name);
            event.data = hashMap;
            this.mPlayerContext.getEventBus().post(event);
            Quality liveControlQuality = Utils.getLiveControlQuality(this.mYoukuVideoInfo, i2);
            if (liveControlQuality != null && liveControlQuality.hbr == 1) {
                this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REQUEST_OPEN_HBR));
            }
            if (ConfigUtils.enableChangePeriod()) {
                this.mPlayer.getVideoStream().changeSource(true, null, i2);
            } else {
                this.mPlayer.getVideoStream().changeSource(false, null, i2);
            }
        }
        this.mView.hide();
    }

    public List<String> getBitStreamListSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2127664901") ? (List) ipChange.ipc$dispatch("-2127664901", new Object[]{this}) : new ArrayList();
    }

    @Override // com.youku.alixplugin.base.AbsPlugin, com.youku.alixplugin.base.IPlugin
    public View getHolderView() {
        ChangeQualityView changeQualityView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "169303843")) {
            return (View) ipChange.ipc$dispatch("169303843", new Object[]{this});
        }
        if (this.mHolderView == null && (changeQualityView = this.mView) != null) {
            this.mHolderView = changeQualityView.getInflatedView();
        }
        return this.mHolderView;
    }

    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-910887540")) {
            ipChange.ipc$dispatch("-910887540", new Object[]{this});
        } else if (this.mView.isShow()) {
            this.mView.hide();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityContract.Presenter
    public void onHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453922305")) {
            ipChange.ipc$dispatch("453922305", new Object[]{this});
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityContract.Presenter
    public void refreshDefinitionData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242525296")) {
            ipChange.ipc$dispatch("-242525296", new Object[]{this});
            return;
        }
        this.mView.mAdapter.setData(this.mDefinitions);
        this.mView.mAdapter.notifyDataSetChanged();
        AlixVideoItem curAlixVideoItem = this.mPlayer.getVideoStream().getCurAlixVideoItem();
        if (curAlixVideoItem != null) {
            int liveQuality = curAlixVideoItem.getLiveQuality();
            for (int i = 0; i < this.mDefinitions.size(); i++) {
                if (liveQuality == this.mDefinitions.get(i).quality) {
                    this.mView.mAdapter.setSelection(i);
                    return;
                }
            }
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_SCREEN_MODE_CHANGE}, priority = 1, threadMode = ThreadMode.MAIN)
    public void screenModeChange(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1003349807")) {
            ipChange.ipc$dispatch("-1003349807", new Object[]{this, event});
        } else if (this.mPlayerContext.isLandScreen() || !this.mView.isShow()) {
        } else {
            this.mView.hide();
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_QUALITY}, priority = 1, threadMode = ThreadMode.MAIN)
    public void show(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945684977")) {
            ipChange.ipc$dispatch("-945684977", new Object[]{this, event});
            return;
        }
        if (this.mPlayer.getVideoStream() != null && this.mPlayer.getVideoStream().getYoukuVideoInfo() != null) {
            initData(this.mPlayer.getVideoStream().getYoukuVideoInfo());
        }
        List<Quality> list = this.mDefinitions;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mView.show();
        if (!this.mView.isInflated() || this.mDefinitions == null) {
            return;
        }
        refreshDefinitionData();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityContract.Presenter
    public void showQualityInfo(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641417914")) {
            ipChange.ipc$dispatch("641417914", new Object[]{this, view});
            return;
        }
        ChangeQualityView changeQualityView = this.mView;
        if (changeQualityView != null) {
            changeQualityView.hide();
        }
        Integer num = (Integer) view.getTag();
        List<Quality> data = this.mView.mAdapter.getData();
        if (num == null || num.intValue() < 0 || num.intValue() >= data.size()) {
            return;
        }
        Quality liveControlQuality = Utils.getLiveControlQuality(this.mYoukuVideoInfo, data.get(num.intValue()).quality);
        if (this.mPlayerContext == null || liveControlQuality == null || liveControlQuality.hbr != 1) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("source_from", "1");
        Event event = new Event(ApiConstants.EventType.SHOW_HBR_INSTRUCTION);
        event.data = hashMap;
        this.mPlayerContext.getEventBus().post(event);
    }
}
