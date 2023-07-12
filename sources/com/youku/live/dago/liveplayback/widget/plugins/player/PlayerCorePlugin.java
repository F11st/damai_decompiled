package com.youku.live.dago.liveplayback.widget.plugins.player;

import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.AlixPlayer;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnLocalConfigCenterListener;
import com.youku.alixplayer.middleware.DefaultRenderMiddleware;
import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.resize.OnResizerListener;
import com.youku.alixplayer.opensdk.statistics.PlayTimeTrack;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnDataSourceListener;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.kubus.Event;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.ConfigUtils;
import com.youku.live.dago.liveplayback.NetWorkUtil;
import com.youku.live.dago.liveplayback.widget.PickStatus;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.resize.PlayerViewResizer;
import com.youku.live.dago.liveplayback.widget.plugins.watermark.WaterMarkPlugin;
import com.youku.live.livesdk.util.DebugViewHelper;
import com.youku.live.plugin.freeflow.FreeFlowUtil;
import com.youku.live.plugin.p2p.P2pManager;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerCorePlugin extends AbsPlugin implements OnResizerListener, PlayerViewResizer.OnRotateListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "PlayerCorePlugin";
    private OnDataSourceListener mOnDataSourceListener;
    private OnInfoListener mOnInfoListener;
    private OnLocalConfigCenterListener mOnLocalConfigCenterListener;
    private PickRotateTipsView mPickRotateTipsView;
    private IPlayer mPlayer;
    private IPlayerContainer mPlayerContainer;
    private PlayerViewResizer mPlayerView;
    private RetryStrategy mRetryStrategy;
    private WaterMarkPlugin mWaterMarkPlugin;
    private Map<Double, Float> seiDataMap;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class YRenderMiddleware extends DefaultRenderMiddleware {
        private static transient /* synthetic */ IpChange $ipChange;

        public YRenderMiddleware() {
        }

        @Override // com.youku.alixplayer.middleware.DefaultRenderMiddleware
        public boolean processData(byte[] bArr, Map<Integer, String> map, long j, long j2, long j3, long j4, long j5) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-243273427")) {
                return ((Boolean) ipChange.ipc$dispatch("-243273427", new Object[]{this, bArr, map, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)})).booleanValue();
            }
            Logger.d("PlayerCorePlugin-processData", "render_data=" + map + " real_pts=" + j + " real_tbn=" + j2 + " start_time=" + j3 + " pts=" + j4 + " tbn=" + j5);
            if (PlayerCorePlugin.this.isPickMode() && PlayerCorePlugin.this.seiDataMap != null && j != 0 && j2 != 0) {
                if (PlayerCorePlugin.this.seiDataMap.size() > ConfigUtils.getPickSEICountLimit()) {
                    PlayerCorePlugin.this.seiDataMap.clear();
                }
                double doubleValue = new BigDecimal((j * 1.0d) / j2).setScale(2, 4).doubleValue();
                if (PlayerCorePlugin.this.seiDataMap != null && PlayerCorePlugin.this.seiDataMap.containsKey(Double.valueOf(doubleValue))) {
                    float floatValue = ((Float) PlayerCorePlugin.this.seiDataMap.get(Double.valueOf(doubleValue))).floatValue();
                    PlayerCorePlugin.this.seiDataMap.remove(Double.valueOf(doubleValue));
                    if (!((AbsPlugin) PlayerCorePlugin.this).mPlayerContext.isLandScreen() && !PlayerCorePlugin.this.isPickRotating()) {
                        PlayerCorePlugin.this.mPlayerView.setPickCenterWithOffset(floatValue);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public PlayerCorePlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mOnInfoListener = new OnInfoListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.player.PlayerCorePlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Removed duplicated region for block: B:58:0x00ff A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:64:0x00ae A[SYNTHETIC] */
            @Override // com.youku.alixplayer.OnInfoListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onInfo(int r6, int r7, int r8, java.lang.Object r9) {
                /*
                    Method dump skipped, instructions count: 286
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.plugins.player.PlayerCorePlugin.AnonymousClass1.onInfo(int, int, int, java.lang.Object):void");
            }
        };
        this.mOnLocalConfigCenterListener = new OnLocalConfigCenterListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.player.PlayerCorePlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnLocalConfigCenterListener
            public String getLocalConfig(String str, String str2, String str3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1847404378")) {
                    return (String) ipChange.ipc$dispatch("1847404378", new Object[]{this, str, str2, str3});
                }
                if ("downloader_info".equals(str)) {
                    if ("isFreeFlow".equals(str2)) {
                        return FreeFlowUtil.isFreeFlow(((AbsPlugin) PlayerCorePlugin.this).mContext, "live") ? "1" : "0";
                    } else if ("canUseP2P".equals(str2)) {
                        return P2pManager.getInstance(((AbsPlugin) PlayerCorePlugin.this).mContext).canUseP2PWithNetStatus(((AbsPlugin) PlayerCorePlugin.this).mContext) ? "1" : "0";
                    }
                } else if (DebugViewHelper.PLAY_INFO_TAG.equals(str) && "uplayer_ups_net_cost".equals(str2)) {
                    LiveInfo liveInfo = PlayerCorePlugin.this.mPlayerContainer.getVideoStream().getYoukuVideoInfo().getLiveInfo();
                    if (liveInfo != null) {
                        VideoInfo videoInfo = liveInfo.videoInfo;
                        if (videoInfo != null && videoInfo.costTime > 0) {
                            return liveInfo.videoInfo.costTime + "";
                        }
                        TLogUtil.playLog("播控数据request出现异常");
                    } else {
                        TLogUtil.playLog("播控数据LiveInfo出现异常");
                    }
                } else if ("system_info".equals(str) && "network_type".equals(str2)) {
                    int currentNetworkType = NetWorkUtil.getCurrentNetworkType(((AbsPlugin) PlayerCorePlugin.this).mContext);
                    if (currentNetworkType != 0) {
                        switch (currentNetworkType) {
                            case 10:
                                return "0";
                            case 11:
                            case 12:
                                return "1";
                            case 13:
                                return "2";
                            default:
                                return str3;
                        }
                    }
                    return "-1";
                }
                return str3;
            }
        };
        this.mOnDataSourceListener = new OnDataSourceListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.player.PlayerCorePlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplugin.OnDataSourceListener
            public void onChanged(String str, Object obj, Object obj2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1856039799")) {
                    ipChange.ipc$dispatch("1856039799", new Object[]{this, str, obj, obj2});
                } else if ("isPickMode".equals(str)) {
                    if (obj2 == null || !((Boolean) obj2).booleanValue()) {
                        PlayerCorePlugin.this.mPlayerView.setPickMode(false);
                        return;
                    }
                    PlayerCorePlugin.this.mPlayerView.setPickMode(true);
                    PlayerCorePlugin.this.mPickRotateTipsView.show();
                }
            }
        };
        Logger.d(TAG, "initPlayer start");
        this.seiDataMap = new ConcurrentHashMap();
        if (this.mPlayerContext.getPlayerContainer() != null) {
            Logger.d(TAG, "initPlayer from outer");
            this.mPlayerContainer = this.mPlayerContext.getPlayerContainer();
        } else {
            Logger.d(TAG, "initPlayer from inner");
            PlayerConfig playerConfig = this.mPlayerContext.getPlayerConfig();
            IPlayerContainer create = AlixPlayerContainer.create(this.mContext, playerConfig);
            this.mPlayerContainer = create;
            create.setPlaylistBuilder(new PlaylistBuilder(this.mContext, playerConfig));
        }
        int playerIndex = pluginConfig.getPlayerIndex();
        if (playerIndex == 0) {
            this.mPlayer = this.mPlayerContainer.getPlayer();
            this.mWaterMarkPlugin = new WaterMarkPlugin(alixPlayerContext, pluginConfig, viewGroup);
        } else if (playerIndex > 0) {
            this.mPlayer = this.mPlayerContainer.getMultiPlayer().getPlayers().get(playerIndex - 1);
        } else {
            throw new IllegalArgumentException("AlixCorePlugin create failed");
        }
        this.mRetryStrategy = new RetryStrategy(this.mPlayerContainer);
        PlayerViewResizer playerViewResizer = new PlayerViewResizer(this.mContext, alixPlayerContext.getActivity(), this.mPlayer, alixPlayerContext.getPlayerConfig());
        this.mPlayerView = playerViewResizer;
        WaterMarkPlugin waterMarkPlugin = this.mWaterMarkPlugin;
        if (waterMarkPlugin != null) {
            playerViewResizer.addView(waterMarkPlugin.getWaterMarkContainer());
        }
        this.mPlayerView.addOnResizerListener(this);
        this.mPlayerView.setOnRotateListener(this);
        this.mPlayer.setResizer(this.mPlayerView);
        this.mHolderView = this.mPlayerView;
        this.mPlayerContext.setPlayerContainer(this.mPlayerContainer);
        new PostProcessingPlugin(alixPlayerContext, pluginConfig, null);
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            IPlayer iPlayer = this.mPlayer;
            if (iPlayer instanceof AlixPlayer) {
                AlixPlayer alixPlayer = (AlixPlayer) iPlayer;
                alixPlayer.setOnLocalConfigCenterListener(this.mOnLocalConfigCenterListener);
                if (enableRenderMiddleware()) {
                    alixPlayer.addRenderMiddleware(new YRenderMiddleware());
                }
                alixPlayer.addOnInfoListener(this.mOnInfoListener);
            }
        }
        this.mPickRotateTipsView = new PickRotateTipsView(this.mContext, this.mPlayerView);
        this.mPlayerContext.addDataSourceListener(this.mOnDataSourceListener);
        PlayTimeTrack playTimeTrack = this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack();
        if (playTimeTrack != null) {
            playTimeTrack.putTimestamp("playerCoreInitTs", System.currentTimeMillis());
        }
        Logger.d(TAG, "initPlayer end");
    }

    private boolean enableRenderMiddleware() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-559451126") ? ((Boolean) ipChange.ipc$dispatch("-559451126", new Object[]{this})).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig("live_middleware_config", "render", "1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPickMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "729681383")) {
            return ((Boolean) ipChange.ipc$dispatch("729681383", new Object[]{this})).booleanValue();
        }
        Object obj = this.mPlayerContext.get("isPickMode");
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPickRotating() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1334214766") ? ((Boolean) ipChange.ipc$dispatch("-1334214766", new Object[]{this})).booleanValue() : this.mPlayerContext.get("pick_status") != null && this.mPlayerContext.get("pick_status") == PickStatus.ROTATE_START;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.resize.PlayerViewResizer.OnRotateListener
    public void onRotateFinished(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1157797506")) {
            ipChange.ipc$dispatch("-1157797506", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Event event = new Event(ApiConstants.EventType.ROTATE_FINISH);
        event.data = Integer.valueOf(i);
        this.mPlayerContext.getEventBus().post(event);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.resize.PlayerViewResizer.OnRotateListener
    public void onRotateStarted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593999182")) {
            ipChange.ipc$dispatch("-593999182", new Object[]{this});
        } else {
            this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.ROTATE_START));
        }
    }

    @Override // com.youku.alixplayer.opensdk.resize.OnResizerListener
    public void onSizeChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1899799205")) {
            ipChange.ipc$dispatch("1899799205", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        WaterMarkPlugin waterMarkPlugin = this.mWaterMarkPlugin;
        if (waterMarkPlugin != null) {
            waterMarkPlugin.onSizeChanged(i, i2);
        }
    }
}
