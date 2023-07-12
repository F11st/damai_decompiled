package com.youku.live.dago.liveplayback.widget.plugins.error;

import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnPlayerErrorListener;
import com.youku.alixplayer.opensdk.utils.MsgIdGroup;
import com.youku.alixplayer.opensdk.utils.NetworkUtil;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.kubus.Event;
import com.youku.live.dago.liveplayback.ApiConstants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerErrorPlugin extends BaseErrorPlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String NET_ERROR_MSG = "世界上最遥远的距离就是断网";
    private static final String NET_ERROR_PIP = "网络异常";
    public static final String TAG = "PlayerErrorPlugin";
    private OnPlayerErrorListener mOnPlayerErrorListener;
    private IPlayer mPlayer;
    private IPlayerContainer mPlayerContainer;
    private OnStateChangeListener mPlayerStateChangeListener;

    public PlayerErrorPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mOnPlayerErrorListener = new OnPlayerErrorListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.error.PlayerErrorPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnPlayerErrorListener
            public void onError(int i, int i2, String str, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-740672553")) {
                    ipChange.ipc$dispatch("-740672553", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, obj});
                    return;
                }
                TLogUtil.playLog("播放器异常，中断播放");
                if (PlayerErrorPlugin.this.mPlayer.getCurrentState() != IAlixPlayer.State.STATE_STOPPED) {
                    PlayerErrorPlugin.this.mPlayer.stop();
                }
                if (NetworkUtil.isConnectedNet(((AbsPlugin) PlayerErrorPlugin.this).mContext)) {
                    if (MsgIdGroup.isNetworkError(i, i2)) {
                        BaseErrorView baseErrorView = PlayerErrorPlugin.this.mView;
                        baseErrorView.show("网络断片儿了，快刷新一下唤醒TA", i2 + "", true);
                    } else if (MsgIdGroup.isPlayerError(i, i2)) {
                        BaseErrorView baseErrorView2 = PlayerErrorPlugin.this.mView;
                        baseErrorView2.show("小主莫慌，请刷新一下试试", i2 + "", true);
                    } else {
                        BaseErrorView baseErrorView3 = PlayerErrorPlugin.this.mView;
                        baseErrorView3.show("系统异常", i2 + "", true);
                    }
                    PlayerErrorPlugin.this.mView.showPiP("直播中断");
                } else {
                    PlayerErrorPlugin.this.mView.showPiP(PlayerErrorPlugin.NET_ERROR_PIP);
                    PlayerErrorPlugin.this.mView.show(PlayerErrorPlugin.NET_ERROR_MSG, null, true);
                }
                PlayerErrorPlugin.this.getEventBus().post(new Event(ApiConstants.EventType.SHOW_ERROR));
            }
        };
        this.mPlayerStateChangeListener = new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.error.PlayerErrorPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1894385843")) {
                    ipChange.ipc$dispatch("1894385843", new Object[]{this, state, state2});
                } else if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    PlayerErrorPlugin.this.mView.hide();
                } else if (state2 == IAlixPlayer.State.STATE_SOURCE_FAILED) {
                    PlayerErrorPlugin.this.mView.show("小主莫慌，请刷新一下试试", "28001", true);
                }
            }
        };
        this.mPlayerContainer = alixPlayerContext.getPlayerContainer();
        int playerIndex = pluginConfig.getPlayerIndex();
        if (playerIndex == 0) {
            this.mPlayer = alixPlayerContext.getPlayerContainer().getPlayer();
        } else if (playerIndex > 0) {
            this.mPlayer = alixPlayerContext.getPlayerContainer().getMultiPlayer().getPlayers().get(playerIndex - 1);
        } else {
            throw new IllegalStateException("PlayerErrorPlugin create failed");
        }
        this.mPlayer.addOnPlayerStateListener(this.mPlayerStateChangeListener);
        this.mPlayerContainer.addPlayerErrorListener(this.mOnPlayerErrorListener);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.error.BaseErrorPlugin
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376360437")) {
            ipChange.ipc$dispatch("-1376360437", new Object[]{this});
            return;
        }
        this.mView.hide();
        this.mPlayerContainer.replay();
    }
}
