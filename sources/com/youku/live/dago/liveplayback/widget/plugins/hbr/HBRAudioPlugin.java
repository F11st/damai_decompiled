package com.youku.live.dago.liveplayback.widget.plugins.hbr;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
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
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplayer.util.ClassLoader;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnNotifyListener;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.kubus.Event;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.ToastUtil;
import com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingConfigManager2;
import com.youku.live.dago.liveplayback.widget.utils.HbrUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HBRAudioPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "HBRPlugin";
    private Handler mHandler;
    private boolean mIsOpenAudioHbr;
    private OnChangeVideoListener mOnChangeVideoListener;
    private OnNotifyListener mOnNotifyListener;
    private OnStateChangeListener mOnStateChangeListener;
    private OnVideoStreamListener mOnVideoStreamListener;
    private IPlayer mPlayer;
    private AlixPlayerContext mPlayerContext;
    private boolean mSupportAudioHbr;
    private HBRAudioView mView;
    private YoukuVideoInfo mYoukuVideoInfo;

    public HBRAudioPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mOnVideoStreamListener = new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRAudioPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1162141750")) {
                    ipChange.ipc$dispatch("-1162141750", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2038698313")) {
                    ipChange.ipc$dispatch("2038698313", new Object[]{this, youkuVideoInfo});
                } else {
                    HBRAudioPlugin.this.mYoukuVideoInfo = youkuVideoInfo;
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "125612674")) {
                    ipChange.ipc$dispatch("125612674", new Object[]{this, playVideoInfo});
                }
            }
        };
        this.mOnStateChangeListener = new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRAudioPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-432553300")) {
                    ipChange.ipc$dispatch("-432553300", new Object[]{this, state, state2});
                } else if (state == IAlixPlayer.State.STATE_VIDEO_PAUSED || state2 != IAlixPlayer.State.STATE_VIDEO_STARTED) {
                } else {
                    HBRAudioPlugin.this.onRealVideoStart();
                }
            }
        };
        this.mOnChangeVideoListener = new OnChangeVideoListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRAudioPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideo(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-504182171")) {
                    ipChange.ipc$dispatch("-504182171", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideoFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2111703198")) {
                    ipChange.ipc$dispatch("-2111703198", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    HBRAudioPlugin.this.onChangeVideoFinish();
                }
            }
        };
        this.mOnNotifyListener = new OnNotifyListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRAudioPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplugin.OnNotifyListener
            public void onNotify(Intent intent, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-632451477")) {
                    ipChange.ipc$dispatch("-632451477", new Object[]{this, intent, obj});
                } else if ("setAHDRState".equals(intent.getAction())) {
                    HBRAudioPlugin.this.onAudioHbrClick(((Boolean) ((Map) obj).get("open")).booleanValue());
                }
            }
        };
        HBRAudioView hBRAudioView = new HBRAudioView(alixPlayerContext.getContext(), alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId);
        this.mView = hBRAudioView;
        hBRAudioView.setPresenter(this);
        this.mAttachToParent = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPlayerContext = alixPlayerContext;
        IPlayer player = alixPlayerContext.getPlayerContainer().getPlayer();
        this.mPlayer = player;
        player.addOnPlayerStateListener(this.mOnStateChangeListener);
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(this.mOnVideoStreamListener);
        alixPlayerContext.getPlayerContainer().addChangeVideoListener(this.mOnChangeVideoListener);
        alixPlayerContext.addNotifyListener(this.mOnNotifyListener);
    }

    private boolean isSupportAudioHbr(YoukuVideoInfo youkuVideoInfo) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "204471405")) {
            return ((Boolean) ipChange.ipc$dispatch("204471405", new Object[]{this, youkuVideoInfo})).booleanValue();
        }
        if (youkuVideoInfo == null || youkuVideoInfo.getLivePlayControl() == null || youkuVideoInfo.getLivePlayControl().playerWidget == null) {
            return false;
        }
        boolean z2 = youkuVideoInfo.getLivePlayControl().playerWidget.ahbrPlay == 1;
        String str = null;
        if (this.mPlayer.getVideoStream() != null && this.mPlayer.getVideoStream().getCurAlixVideoItem() != null) {
            str = this.mPlayer.getVideoStream().getCurAlixVideoItem().getStreamType();
        }
        return (z2 && PostProcessingConfigManager2.isSupportAudioHbr(str, "8", youkuVideoInfo.getLivePlayControl().playerWidget)) ? false : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioHbrClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481158491")) {
            ipChange.ipc$dispatch("1481158491", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (this.mSupportAudioHbr) {
            openAudioHbr(z, true);
        }
        sendEngineData(this.mSupportAudioHbr, this.mIsOpenAudioHbr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeVideoFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "477479713")) {
            ipChange.ipc$dispatch("477479713", new Object[]{this});
            return;
        }
        if (this.mSupportAudioHbr && this.mIsOpenAudioHbr) {
            openAudioHbr(true, false);
        }
        sendEngineData(this.mSupportAudioHbr, this.mIsOpenAudioHbr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRealVideoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097336102")) {
            ipChange.ipc$dispatch("1097336102", new Object[]{this});
            return;
        }
        boolean isSupportAudioHbr = isSupportAudioHbr(this.mYoukuVideoInfo);
        this.mSupportAudioHbr = isSupportAudioHbr;
        if (isSupportAudioHbr && this.mIsOpenAudioHbr) {
            openAudioHbr(true, false);
        }
        sendEngineData(this.mSupportAudioHbr, this.mIsOpenAudioHbr);
    }

    private void openAudioHbr(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861352158")) {
            ipChange.ipc$dispatch("1861352158", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        try {
            String streamType = this.mPlayer.getVideoStream().getCurAlixVideoItem().getStreamType();
            int liveQuality = this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality();
            int doManualPostProcess = PostProcessingConfigManager2.doManualPostProcess(this.mPlayer, streamType, this.mPlayer.getVideoStream().getYoukuVideoInfo().getLivePlayControl().playerWidget, "8", z);
            if (!z) {
                this.mIsOpenAudioHbr = false;
            } else if (doManualPostProcess != -1) {
                this.mIsOpenAudioHbr = true;
                if (!HbrUtil.isVideoHbr(this.mYoukuVideoInfo, liveQuality) && z2) {
                    this.mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRAudioPlugin.5
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-254423836")) {
                                ipChange2.ipc$dispatch("-254423836", new Object[]{this});
                            } else {
                                HBRAudioPlugin.this.mView.show();
                            }
                        }
                    });
                }
            } else {
                this.mIsOpenAudioHbr = false;
                this.mSupportAudioHbr = false;
                if (ClassLoader.isDebug()) {
                    ToastUtil.showToast(this.mContext, "帧享开启失败~");
                }
            }
        } catch (Exception e) {
            this.mSupportAudioHbr = false;
            TLogUtil.playLog("帧享开启失败:" + e.getMessage());
            if (ClassLoader.isDebug()) {
                ToastUtil.showToast(this.mContext, "帧享开启失败~");
            }
        }
    }

    private void sendEngineData(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-637186218")) {
            ipChange.ipc$dispatch("-637186218", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("support", Boolean.valueOf(z));
        hashMap.put("open", Boolean.valueOf(z2));
        hashMap.put("ccode", this.mPlayerContext.getPlayerConfig().getLiveCCode());
        Event event = new Event(ApiConstants.EventType.ENGINE_PUT_DATA);
        event.message = "LFLWDataCenterAHDR";
        event.data = hashMap;
        this.mPlayerContext.getEventBus().post(event);
        Intent intent = new Intent("LFLWDataCenterAHDR");
        intent.putExtra("isAudioHbr", z2 ? "1" : "0");
        this.mPlayerContext.onNotify(intent, null);
    }
}
