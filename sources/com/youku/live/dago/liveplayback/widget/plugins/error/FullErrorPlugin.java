package com.youku.live.dago.liveplayback.widget.plugins.error;

import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.utils.ErrorCodeHelper;
import com.youku.kubus.Event;
import com.youku.live.dago.liveplayback.ApiConstants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FullErrorPlugin extends BaseErrorPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private static int[] sIgnoreErrorCode = {ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_LIVE_NOT_BEGIN, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_LIVE_COMPLETE, ErrorCodeHelper.LIVE_ERROR_UNDO_AUDIO_MICMODE, ErrorCodeHelper.LIVE_ERROR_UNDO_UNKNOWN_MICMODE, ErrorCodeHelper.LIVE_ERROR_UNDO_VIDEO_MCU_0, ErrorCodeHelper.LIVE_ERROR_UNDO_VIDEO_MCU_1_NOTONMIC, ErrorCodeHelper.LIVE_ERROR_UNDO_PK_MCU_0};
    private OnVideoStreamListener mOnVideoStreamListener;
    private PlayVideoInfo mPlayVideoInfo;
    private IPlayerContainer mPlayerContainer;

    public FullErrorPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mOnVideoStreamListener = new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.error.FullErrorPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "282717749")) {
                    ipChange.ipc$dispatch("282717749", new Object[]{this, videoRequestError});
                    return;
                }
                String errorMsg = videoRequestError.getErrorMsg();
                int errorCode = videoRequestError.getErrorCode();
                if (FullErrorPlugin.isIgnoreErrorCode(errorCode)) {
                    TLogUtil.playLog("直播间已经结束，无法播放");
                } else if (errorCode != 72001 && errorCode != 71001) {
                    BaseErrorView baseErrorView = FullErrorPlugin.this.mView;
                    baseErrorView.show(errorMsg, errorCode + "", false);
                } else {
                    TLogUtil.playLog("没有权益，弹出购买页面");
                }
                FullErrorPlugin.this.getEventBus().post(new Event(ApiConstants.EventType.SHOW_ERROR));
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "726236788")) {
                    ipChange.ipc$dispatch("726236788", new Object[]{this, youkuVideoInfo});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1186848851")) {
                    ipChange.ipc$dispatch("-1186848851", new Object[]{this, playVideoInfo});
                    return;
                }
                FullErrorPlugin.this.mView.hide();
                FullErrorPlugin.this.mPlayVideoInfo = playVideoInfo;
            }
        };
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        playerContainer.addVideoStreamListener(this.mOnVideoStreamListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isIgnoreErrorCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612215477")) {
            return ((Boolean) ipChange.ipc$dispatch("-612215477", new Object[]{Integer.valueOf(i)})).booleanValue();
        }
        for (int i2 : sIgnoreErrorCode) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.error.BaseErrorPlugin
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1046448697")) {
            ipChange.ipc$dispatch("1046448697", new Object[]{this});
            return;
        }
        this.mView.hide();
        this.mPlayerContainer.replay();
    }
}
