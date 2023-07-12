package com.youku.live.dago.liveplayback.widget.plugins.dmmulti;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplugin.ActivityLifeCycleListener;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnNotifyListener;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Stream;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.widget.Constants;
import com.youku.live.dago.liveplayback.widget.plugins.dmmulti.YKGridViewWrapper;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DMMultiViewPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String GRIDVIEW_MTOP = "mtop.youku.yklive.yk.gridview.info";
    private Activity mActivity;
    private ActivityLifeCycleListener mActivityLifeCycleListener;
    private int mCurGirdView;
    private String mCurSenceId;
    private DMMultiView mDMMultiView;
    private boolean mIsRequestSuccess;
    private String mLiveId;
    private String mMcuSceneId;
    private OnNotifyListener mOnNotifyListener;
    private IPlayerContainer mPlayerContainer;
    private AlixPlayerContext mPlayerContext;
    private final OnVideoStreamListener mVideoStreamListenre;
    private MultiGridViewClickListener multiGridViewClickListener;

    public DMMultiViewPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.multiGridViewClickListener = new MultiGridViewClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiViewPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dmmulti.MultiGridViewClickListener
            public void onClick(int i, long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "666967707")) {
                    ipChange.ipc$dispatch("666967707", new Object[]{this, Integer.valueOf(i), Long.valueOf(j)});
                    return;
                }
                PlayVideoInfo playVideoInfo = new PlayVideoInfo(DMMultiViewPlugin.this.mLiveId);
                playVideoInfo.setPlayType(PlayType.LIVE);
                playVideoInfo.putString("changeSceneId", "1");
                playVideoInfo.putString("sceneId", String.valueOf(j));
                DMMultiViewPlugin.this.mPlayerContainer.play(playVideoInfo);
            }
        };
        OnVideoStreamListener onVideoStreamListener = new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiViewPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;
            private List<Stream> mStreams;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1781280027")) {
                    ipChange.ipc$dispatch("1781280027", new Object[]{this, videoRequestError});
                } else {
                    DMMultiViewPlugin.this.mLiveId = videoRequestError.getPlayVideoInfo().getLiveId();
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                List<Stream> list;
                List<Stream> list2;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "566902490")) {
                    ipChange.ipc$dispatch("566902490", new Object[]{this, youkuVideoInfo});
                    return;
                }
                LivePlayControl livePlayControl = youkuVideoInfo.getLivePlayControl();
                if (livePlayControl != null) {
                    String liveId = youkuVideoInfo.getLiveId();
                    if (liveId != null && !liveId.equals(DMMultiViewPlugin.this.mLiveId)) {
                        List<Stream> list3 = livePlayControl.streams;
                        this.mStreams = list3;
                        if (list3 != null) {
                            DMMultiViewPlugin dMMultiViewPlugin = DMMultiViewPlugin.this;
                            dMMultiViewPlugin.mMcuSceneId = dMMultiViewPlugin.getMcuSceneId(list3);
                        }
                    }
                    DMMultiViewPlugin.this.mLiveId = liveId;
                    if (livePlayControl.liveStatus == 1 && (list2 = this.mStreams) != null && list2.size() > 1 && livePlayControl.sceneType == 2) {
                        String str = livePlayControl.sceneId;
                        if (DMMultiViewPlugin.this.mMcuSceneId == null || !DMMultiViewPlugin.this.mMcuSceneId.equals(str)) {
                            DMMultiViewPlugin.this.mCurGirdView = 0;
                            DMMultiViewPlugin.this.mDMMultiView.hide();
                            DMMultiViewPlugin.this.onMultiMode(false);
                            return;
                        }
                        DMMultiViewPlugin.this.mCurGirdView = 1;
                        DMMultiViewPlugin dMMultiViewPlugin2 = DMMultiViewPlugin.this;
                        dMMultiViewPlugin2.request(dMMultiViewPlugin2.mLiveId);
                        DMMultiViewPlugin.this.onMultiMode(true);
                    } else if (livePlayControl.liveStatus != 1 || (list = this.mStreams) == null || list.size() <= 1 || livePlayControl.sceneType != 0) {
                        DMMultiViewPlugin.this.mDMMultiView.hide();
                        DMMultiViewPlugin.this.onMultiMode(false);
                    } else {
                        DMMultiViewPlugin.this.mPlayerContext.setMode(2);
                    }
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1346183149")) {
                    ipChange.ipc$dispatch("-1346183149", new Object[]{this, playVideoInfo});
                } else if (DMMultiViewPlugin.this.mCurSenceId != null) {
                    playVideoInfo.putString("senceId", DMMultiViewPlugin.this.mCurSenceId);
                }
            }
        };
        this.mVideoStreamListenre = onVideoStreamListener;
        this.mActivityLifeCycleListener = new ActivityLifeCycleListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiViewPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplugin.ActivityLifeCycleListener
            public void onConfigurationChanged(Configuration configuration) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2045066428")) {
                    ipChange.ipc$dispatch("-2045066428", new Object[]{this, configuration});
                } else {
                    DMMultiViewPlugin.this.mDMMultiView.onConfigurationChanged(configuration);
                }
            }
        };
        this.mOnNotifyListener = new OnNotifyListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiViewPlugin.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplugin.OnNotifyListener
            public void onNotify(Intent intent, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1649505211")) {
                    ipChange.ipc$dispatch("1649505211", new Object[]{this, intent, obj});
                    return;
                }
                String action = intent.getAction();
                if (Constants.WEEX.ACTION.Multi_GO_BACK.equals(action)) {
                    DMMultiViewPlugin.this.onGoBack();
                } else if ("switchListMultiScreenWithSceneId".equals(action)) {
                    DMMultiViewPlugin.this.mCurSenceId = (String) ((Map) obj).get("sceneId");
                    PlayVideoInfo playVideoInfo = new PlayVideoInfo(DMMultiViewPlugin.this.mLiveId);
                    playVideoInfo.setPlayType(PlayType.LIVE);
                    playVideoInfo.putString("sceneId", DMMultiViewPlugin.this.mCurSenceId);
                    playVideoInfo.putString("isYkMulti", "1");
                    DMMultiViewPlugin.this.mPlayerContainer.play(playVideoInfo);
                    DMMultiViewPlugin.this.mPlayerContext.put("sceneId", DMMultiViewPlugin.this.mCurSenceId);
                }
            }
        };
        DMMultiView dMMultiView = new DMMultiView(alixPlayerContext, alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId);
        this.mDMMultiView = dMMultiView;
        dMMultiView.setPresenter(this);
        this.mAttachToParent = true;
        this.mPlayerContext = alixPlayerContext;
        alixPlayerContext.addActivityLifeCycleListener(this.mActivityLifeCycleListener);
        this.mPlayerContext.addNotifyListener(this.mOnNotifyListener);
        this.mPlayerContext.getEventBus().register(this);
        this.mActivity = alixPlayerContext.getActivity();
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        playerContainer.addVideoStreamListener(onVideoStreamListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMcuSceneId(List<Stream> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1442819652")) {
            return (String) ipChange.ipc$dispatch("-1442819652", new Object[]{this, list});
        }
        for (Stream stream : list) {
            if (1 == stream.gridView) {
                return stream.sceneId;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMultiMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619522944")) {
            ipChange.ipc$dispatch("1619522944", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mPlayerContext.setMode(z ? 1 : 0);
        HashMap hashMap = new HashMap();
        hashMap.put("isSceneMCU", Boolean.valueOf(z));
        sendEngineData(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void request(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "795852460")) {
            ipChange.ipc$dispatch("795852460", new Object[]{this, str});
            return;
        }
        this.mIsRequestSuccess = false;
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str + "");
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(GRIDVIEW_MTOP, "2.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiViewPlugin.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    YKGridViewWrapper yKGridViewWrapper;
                    YKGridViewWrapper.Data data;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2029823018")) {
                        ipChange2.ipc$dispatch("-2029823018", new Object[]{this, iNetResponse});
                        return;
                    }
                    if (iNetResponse != null) {
                        try {
                            if ("SUCCESS".equals(iNetResponse.getRetCode()) && !TextUtils.isEmpty(iNetResponse.getSource()) && (yKGridViewWrapper = (YKGridViewWrapper) JSON.parseObject(iNetResponse.getSource(), YKGridViewWrapper.class)) != null && (data = yKGridViewWrapper.data) != null && data.data != null) {
                                DMMultiViewPlugin.this.mIsRequestSuccess = true;
                                DMMultiViewPlugin.this.mDMMultiView.show(yKGridViewWrapper.data.data, DMMultiViewPlugin.this.multiGridViewClickListener);
                            }
                        } catch (Exception unused) {
                            if (DMMultiViewPlugin.this.mIsRequestSuccess) {
                                return;
                            }
                        } catch (Throwable th) {
                            if (!DMMultiViewPlugin.this.mIsRequestSuccess) {
                                MultiToast.showToast(((AbsPlugin) DMMultiViewPlugin.this).mContext, "接口出错，请退出直播间后重试");
                                Log.e("requestFailed", DMMultiViewPlugin.GRIDVIEW_MTOP);
                            }
                            throw th;
                        }
                    }
                    if (DMMultiViewPlugin.this.mIsRequestSuccess) {
                        return;
                    }
                    MultiToast.showToast(((AbsPlugin) DMMultiViewPlugin.this).mContext, "接口出错，请退出直播间后重试");
                    Log.e("requestFailed", DMMultiViewPlugin.GRIDVIEW_MTOP);
                }
            });
        }
    }

    private void sendEngineData(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-870972672")) {
            ipChange.ipc$dispatch("-870972672", new Object[]{this, map});
            return;
        }
        Event event = new Event(ApiConstants.EventType.ENGINE_PUT_DATA);
        event.message = "LFLWDataCenterMultiSceneKey";
        event.data = map;
        this.mPlayerContext.getEventBus().post(event);
    }

    private void sendEngineDataListMulti(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237048261")) {
            ipChange.ipc$dispatch("-1237048261", new Object[]{this, map});
            return;
        }
        Event event = new Event(ApiConstants.EventType.ENGINE_PUT_DATA);
        event.message = "LFLWDataCenterListMultiSceneStateKey";
        event.data = map;
        this.mPlayerContext.getEventBus().post(event);
    }

    public boolean isFullScreen() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1456907096") ? ((Boolean) ipChange.ipc$dispatch("1456907096", new Object[]{this})).booleanValue() : this.mActivity.getResources().getConfiguration().orientation == 2;
    }

    public void onGoBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906565461")) {
            ipChange.ipc$dispatch("-906565461", new Object[]{this});
            return;
        }
        PlayVideoInfo playVideoInfo = new PlayVideoInfo(this.mLiveId);
        playVideoInfo.setPlayType(PlayType.LIVE);
        playVideoInfo.putString("sceneId", this.mMcuSceneId);
        this.mPlayerContainer.play(playVideoInfo);
    }

    public void onScreenChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377246082")) {
            ipChange.ipc$dispatch("-1377246082", new Object[]{this});
        } else if (isFullScreen()) {
            this.mActivity.setRequestedOrientation(1);
        } else {
            this.mActivity.setRequestedOrientation(0);
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_ERROR}, priority = 1, threadMode = ThreadMode.POSTING)
    public void showError(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189864206")) {
            ipChange.ipc$dispatch("1189864206", new Object[]{this, event});
        } else if (this.mMcuSceneId == null || this.mCurGirdView != 0) {
        } else {
            this.mDMMultiView.showError();
        }
    }
}
