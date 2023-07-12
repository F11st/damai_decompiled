package com.youku.live.dago.liveplayback.widget.plugins;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.R;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TrailPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private CountDownTimer countDownTimer;
    private LivePlayControl livePlayControl;
    private EventBus mEventBus;
    private Handler mHandler;
    private boolean mIsTrailLive;
    private IPlayer mPlayer;
    private IPlayerContainer mPlayerContainer;
    private LinearLayout mTrailTimeContainer;
    private String mTrailTimeKey;
    private TextView mTrailTimeTv;

    /* compiled from: Taobao */
    /* renamed from: com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements OnVideoStreamListener {
        private static transient /* synthetic */ IpChange $ipChange;

        AnonymousClass2() {
        }

        @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
        public void onDataFail(VideoRequestError videoRequestError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1283435638")) {
                ipChange.ipc$dispatch("-1283435638", new Object[]{this, videoRequestError});
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00d7  */
        @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onDataReady(com.youku.alixplayer.opensdk.YoukuVideoInfo r11) {
            /*
                r10 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass2.$ipChange
                java.lang.String r1 = "1971533065"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L17
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r4] = r10
                r2[r3] = r11
                r0.ipc$dispatch(r1, r2)
                return
            L17:
                com.youku.alixplayer.opensdk.PlayVideoInfo r0 = r11.getPlayVideoInfo()
                com.youku.alixplayer.opensdk.PlayType r0 = r0.getPlayType()
                com.youku.alixplayer.opensdk.PlayType r1 = com.youku.alixplayer.opensdk.PlayType.LIVE
                if (r0 != r1) goto Lee
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r0 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                com.youku.alixplayer.opensdk.live.LiveInfo r1 = r11.getLiveInfo()
                boolean r1 = r1.isTrail
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$302(r0, r1)
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r0 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                boolean r0 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$300(r0)
                if (r0 == 0) goto Lee
                com.youku.alixplayer.opensdk.live.LiveInfo r0 = r11.getLiveInfo()
                com.youku.android.liveservice.bean.LivePlayControl r0 = r0.playControl
                if (r0 == 0) goto Lee
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r0 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                com.youku.alixplayer.opensdk.live.LiveInfo r11 = r11.getLiveInfo()
                com.youku.android.liveservice.bean.LivePlayControl r11 = r11.playControl
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$002(r0, r11)
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                com.youku.android.liveservice.bean.LivePlayControl r0 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$000(r11)
                java.lang.String r0 = r0.screenId
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$402(r11, r0)
                r0 = 120000(0x1d4c0, double:5.9288E-319)
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this     // Catch: java.lang.NumberFormatException -> L77
                com.youku.android.liveservice.bean.LivePlayControl r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$000(r11)     // Catch: java.lang.NumberFormatException -> L77
                java.lang.String r11 = r11.tryPlayTime     // Catch: java.lang.NumberFormatException -> L77
                boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.NumberFormatException -> L77
                if (r11 != 0) goto L7b
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this     // Catch: java.lang.NumberFormatException -> L77
                com.youku.android.liveservice.bean.LivePlayControl r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$000(r11)     // Catch: java.lang.NumberFormatException -> L77
                java.lang.String r11 = r11.tryPlayTime     // Catch: java.lang.NumberFormatException -> L77
                long r0 = java.lang.Long.parseLong(r11)     // Catch: java.lang.NumberFormatException -> L77
                r5 = 60000(0xea60, double:2.9644E-319)
                long r0 = r0 * r5
                goto L7b
            L77:
                r11 = move-exception
                r11.printStackTrace()
            L7b:
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                android.content.Context r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$500(r11)
                java.lang.String r2 = "player_widget_dagoliveplayback"
                android.content.SharedPreferences r11 = r11.getSharedPreferences(r2, r4)
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r2 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                java.lang.String r2 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$400(r2)
                r4 = -1
                long r6 = r11.getLong(r2, r4)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = "countTime:"
                r2.append(r8)
                r2.append(r6)
                java.lang.String r2 = r2.toString()
                java.lang.String r8 = "testLeftTime"
                android.util.Log.e(r8, r2)
                int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r2 != 0) goto Lbf
                android.content.SharedPreferences$Editor r11 = r11.edit()
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r2 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                java.lang.String r2 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$400(r2)
                android.content.SharedPreferences$Editor r11 = r11.putLong(r2, r0)
                r11.apply()
                goto Lce
            Lbf:
                r4 = 0
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto Lcf
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                com.youku.android.liveservice.bean.LivePlayControl r2 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$000(r11)
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$100(r11, r2, r3)
            Lce:
                r6 = r0
            Lcf:
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                android.os.CountDownTimer r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$600(r11)
                if (r11 == 0) goto Le0
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                android.os.CountDownTimer r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$600(r11)
                r11.cancel()
            Le0:
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin r11 = com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.this
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin$2$1 r0 = new com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin$2$1
                r8 = 1000(0x3e8, double:4.94E-321)
                r4 = r0
                r5 = r10
                r4.<init>(r6, r8)
                com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.access$602(r11, r0)
            Lee:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass2.onDataReady(com.youku.alixplayer.opensdk.YoukuVideoInfo):void");
        }

        @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
        public void onNewRequest(PlayVideoInfo playVideoInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "58447426")) {
                ipChange.ipc$dispatch("58447426", new Object[]{this, playVideoInfo});
            } else {
                TrailPlugin.this.hideTrailTime();
            }
        }
    }

    public TrailPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mEventBus = alixPlayerContext.getEventBus();
        this.mHandler = new Handler(Looper.getMainLooper());
        View inflate = LayoutInflater.from(alixPlayerContext.getActivity()).inflate(R.layout.trail_plugin, (ViewGroup) null);
        this.mHolderView = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.trail_time_container);
        this.mTrailTimeContainer = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1072604167")) {
                    ipChange.ipc$dispatch("1072604167", new Object[]{this, view});
                    return;
                }
                TrailPlugin trailPlugin = TrailPlugin.this;
                trailPlugin.sendCallBuyViewEvent(trailPlugin.livePlayControl, 2);
            }
        });
        this.mTrailTimeTv = (TextView) this.mHolderView.findViewById(R.id.trail_time_count_value);
        hideTrailTime();
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new AnonymousClass2());
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        IPlayer player = playerContainer.getPlayer();
        this.mPlayer = player;
        player.addOnPlayerStateListener(new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "385349356")) {
                    ipChange.ipc$dispatch("385349356", new Object[]{this, state, state2});
                } else if (TrailPlugin.this.mIsTrailLive) {
                    if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED && state != IAlixPlayer.State.STATE_VIDEO_PAUSED) {
                        TrailPlugin.this.mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.3.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "845146010")) {
                                    ipChange2.ipc$dispatch("845146010", new Object[]{this});
                                    return;
                                }
                                TrailPlugin.this.show();
                                if (TrailPlugin.this.countDownTimer != null) {
                                    TrailPlugin.this.countDownTimer.start();
                                }
                            }
                        });
                    }
                    if (state2 != IAlixPlayer.State.STATE_STOPPED || TrailPlugin.this.countDownTimer == null) {
                        return;
                    }
                    TrailPlugin.this.countDownTimer.cancel();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTrailTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516029328")) {
            ipChange.ipc$dispatch("-516029328", new Object[]{this});
        } else {
            this.mHandler.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-537006362")) {
                        ipChange2.ipc$dispatch("-537006362", new Object[]{this});
                    } else if (TrailPlugin.this.mTrailTimeContainer != null) {
                        TrailPlugin.this.mTrailTimeContainer.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCallBuyViewEvent(LivePlayControl livePlayControl, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1280474104")) {
            ipChange.ipc$dispatch("1280474104", new Object[]{this, livePlayControl, Integer.valueOf(i)});
            return;
        }
        Event event = new Event(ApiConstants.EventType.SHOW_BUY_VIEW);
        HashMap hashMap = new HashMap();
        hashMap.put("playControl", livePlayControl);
        hashMap.put("payType", Integer.valueOf(i));
        event.data = hashMap;
        this.mEventBus.post(event);
    }

    private void showTrailTime() {
        LinearLayout linearLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301986901")) {
            ipChange.ipc$dispatch("-1301986901", new Object[]{this});
        } else if (!this.mIsTrailLive || (linearLayout = this.mTrailTimeContainer) == null) {
        } else {
            linearLayout.setVisibility(0);
        }
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51708012")) {
            ipChange.ipc$dispatch("51708012", new Object[]{this});
        } else {
            showTrailTime();
        }
    }
}
