package com.youku.live.livesdk.widgets.container.pagable;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.slide.plugin.SlideWVPlugin;
import com.taobao.weex.common.Constants;
import com.youku.live.arch.utils.CDNHelper;
import com.youku.live.arch.utils.MapUtils;
import com.youku.live.arch.utils.ObjectUtils;
import com.youku.live.dago.liveplayback.widget.AlixLivePlayback;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.alarm.IYoukuLiveAlarm;
import com.youku.live.dsl.config.IConfig;
import com.youku.live.dsl.config.IConfigImp;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.dsl.differences.IYoukuArouse;
import com.youku.live.dsl.log.PerfLogUtils;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.dsl.toast.IToast;
import com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface;
import com.youku.live.livesdk.LiveActivity;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.livesdk.constants.DagoDataCenterConstants;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.constants.SchemaConstants;
import com.youku.live.livesdk.model.mtop.LiveFullInfoV4;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.SimpleWidgetDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.TemplateDTO;
import com.youku.live.livesdk.monitor.page.LivePageMonitorDomain;
import com.youku.live.livesdk.monitor.page.LivePageTaskHolder;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformance;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformanceManager;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.live.livesdk.widgets.container.pager.model.AppKeyPlayInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.LiveInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.LiveQuickPlayModel;
import com.youku.live.livesdk.widgets.container.pager.model.NewPlayInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.widgets.helper.ConfigHelper;
import com.youku.live.livesdk.widgets.helper.MtopDataHelper;
import com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV4Plugin;
import com.youku.live.livesdk.wkit.utils.SdkChannel;
import com.youku.live.livesdk.wkit.view.LoadingRetryView;
import com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout;
import com.youku.live.livesdk.wkit.widget.slide.BaseSlideWidget;
import com.youku.live.widgets.WidgetEngineContext;
import com.youku.live.widgets.WidgetInstance;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.model.template.TemplateModel;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineRenderListener;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IWidget;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.ds1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LiveContentView extends FrameLayout implements IDataHandler, IEngineRenderListener, Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DAGO_CONTENT_PREVIEW_STATE_CHANGE = "DAGO_CONTENT_PREVIEW_STATE_CHANGE";
    private static final float DEFAULT_SCROLL_THRESHOLD = 0.25f;
    private static final String ENABLE_VALUE_INT = "1";
    private static final String KEY_AUDIO_STATUS_CHANGED = "dagoAudioCtrlStatusChanged";
    private static final String KEY_CHANNEL_STATUS_CHANGED = "dagoChannelStatusChanged";
    private static final String KEY_PLAYER_CORE_FIRST_FRAME = "playerCoreFirstFrame";
    private static final String KEY_PLAYER_CORE_INFO = "playerCoreInfo";
    private static final String KEY_PLAYER_FIRST_ERROR = "playerFirstError";
    private static final String KEY_PLAYER_FIRST_FRAME = "playerFirstFrame";
    private static final String KEY_PLAYER_PK_MCU = "playerPkMcu";
    private static final String KEY_PLAYER_START = "playerLiveStart";
    private static final String LANDSCAPE_TYPE = "landScape";
    private static final String PORTRAIT_TYPE = "vertical";
    private static final String SAFE_AREA_TOP_PIXEL = "safeAreaTopPix";
    private static final String SAFE_AREA_TOP_WEEX = "safeAreaTopWx";
    private static final String VAL_AUDIO_STATUS_ERROR = "error";
    private static final String VAL_AUDIO_STATUS_HEAR_SOUND = "hearSound";
    private static final String VAL_AUDIO_STATUS_JOIN = "join";
    private static final String VAL_AUDIO_STATUS_START = "start";
    private static final String VAL_CHANNEL_STATUS_OPEN = "open";
    private static final String VAL_CHANNEL_STATUS_OPEN_FAILURE = "openFailure";
    private static final String VAL_CHANNEL_STATUS_OPEN_SUCCESS = "openSuccess";
    private boolean activated;
    private boolean hasArouseSendDrawFinish;
    private boolean hasArouseSendReadyToDraw;
    private boolean hasPlayerCoreFirstFrame;
    private boolean hasPlayerCoreInfo;
    private boolean hasPlayerFirstFrame;
    private boolean hasPlayerPkMcu;
    private boolean hasPlayerStart;
    private volatile boolean isAppear;
    private boolean isUnlimitRotateScreen;
    private String livePerformanceId;
    private String liveSessionId;
    private boolean mActivated;
    private LoadingRetryView mErrorRetryView;
    private Handler mHandler;
    private Runnable mHideWidgetRunnable;
    private WidgetInstance mInstance;
    private boolean mIsFirstEnter;
    private boolean mIsFirstRoom;
    private boolean mIsLandscape;
    private ds1 mLastTicket;
    private String mLatestUrl;
    private WeakReference<IDagoLivePlaybackInjectorInterface> mLivePlaybackWidget;
    private RoomMoveState mMoveState;
    public IPerfMonitor mPagePerfMonitor;
    private Map<String, String> mRenderParams;
    private boolean mRendered;
    private String mRoomId;
    private Runnable mShowWidgetRunnable;
    private BaseSlideLayout mSlideLayout;
    private SwitchItemModel mSwitchItemModel;
    private float mTouchDownX;
    private float mTouchDownY;
    private Map<String, String> mUtParams;
    private WidgetEngineContext mWidgetEngineContext;

    /* compiled from: Taobao */
    /* renamed from: com.youku.live.livesdk.widgets.container.pagable.LiveContentView$5  reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass5 implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String val$roomId;

        AnonymousClass5(String str) {
            this.val$roomId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1916719972")) {
                ipChange.ipc$dispatch("1916719972", new Object[]{this});
                return;
            }
            IPerfMonitor iPerfMonitor = LiveContentView.this.mPagePerfMonitor;
            if (iPerfMonitor != null) {
                iPerfMonitor.point("onRoomChange", "onRoomChange.begin.async");
            }
            Map<String, String> build = MapUtils.build(MapUtils.build(MapUtils.build(new HashMap(), "liveId", this.val$roomId), "sdkVersion", ObjectUtils.asString(LiveContentView.this.getInstance().getOptions().getString(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION, SDKConstants.SDK_VERSION_NUMBER), SDKConstants.SDK_VERSION_NUMBER)), "app", "Android");
            IProps options = LiveContentView.this.getInstance().getOptions();
            if (options != null) {
                Map<String, Object> map = options.toMap();
                if (map.containsKey(SchemaConstants.SCHEMA_QUERY_TPL_TAG)) {
                    String str = (String) map.get(SchemaConstants.SCHEMA_QUERY_TPL_TAG);
                    if (!TextUtils.isEmpty(str)) {
                        build = MapUtils.build(build, "tplTag", str);
                    }
                } else {
                    String asString = ObjectUtils.asString(LiveContentView.this.getRenderParams().get(SchemaConstants.SCHEMA_QUERY_TPL_TAG), "");
                    if (!TextUtils.isEmpty(asString)) {
                        build = MapUtils.build(build, "tplTag", asString);
                    }
                }
            }
            INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop("mtop.youku.live.com.livefullinfo", "4.0", build, false, false);
            IPerfMonitor iPerfMonitor2 = LiveContentView.this.mPagePerfMonitor;
            if (iPerfMonitor2 != null) {
                iPerfMonitor2.point("LiveFullInfoCost", Thread.currentThread().getName() + "::LiveContentView onRoomChange:" + LiveContentView.this + ",mLiveId：" + this.val$roomId + ", 1 before reqLiveFullInfo;4.0");
            }
            if (createRequestWithMTop != null) {
                createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.5.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dsl.network.INetCallback
                    public void onFinish(INetResponse iNetResponse) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "195321172")) {
                            ipChange2.ipc$dispatch("195321172", new Object[]{this, iNetResponse});
                            return;
                        }
                        if (LiveContentView.this.getYoukuLivePerformance() != null) {
                            LiveContentView.this.getYoukuLivePerformance().setFullInfoMtopEnd();
                        }
                        if (iNetResponse == null) {
                            if (LiveContentView.this.getYoukuLivePerformance() != null) {
                                LiveContentView.this.getYoukuLivePerformance().setFullInfoError(Constants.Name.UNDEFINED);
                            }
                            LiveContentView.this.getInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.5.1.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "1674864586")) {
                                        ipChange3.ipc$dispatch("1674864586", new Object[]{this});
                                        return;
                                    }
                                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                    LiveContentView.this.renderLiveFullInfoRetry(anonymousClass5.val$roomId);
                                }
                            });
                            return;
                        }
                        IPerfMonitor iPerfMonitor3 = LiveContentView.this.mPagePerfMonitor;
                        if (iPerfMonitor3 != null) {
                            iPerfMonitor3.point("LiveFullInfoCost", Thread.currentThread().getName() + "::LiveContentView onRoomChange:" + LiveContentView.this + ",mLiveId：" + AnonymousClass5.this.val$roomId + ", 2 after reqLiveFullInfo;4.0");
                        }
                        String source = iNetResponse.getSource();
                        LiveFullInfoData liveFullInfoData = (LiveFullInfoData) MtopDataHelper.getDataDataWithModel(source, LiveFullInfoV4.class);
                        IPerfMonitor iPerfMonitor4 = LiveContentView.this.mPagePerfMonitor;
                        if (iPerfMonitor4 != null) {
                            iPerfMonitor4.point("LiveFullInfoCost", Thread.currentThread().getName() + "::LiveContentView onRoomChange parse:" + LiveContentView.this + ",mLiveId：" + AnonymousClass5.this.val$roomId + ", 3 after reqLiveFullInfo;4.0");
                        }
                        JSONObject dataDataWithJson = MtopDataHelper.getDataDataWithJson(source, LiveFullInfoV4.class);
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        LiveContentView.this.updateWithLiveFullInfo(anonymousClass5.val$roomId, liveFullInfoData, dataDataWithJson);
                        if (LiveContentView.this.getYoukuLivePerformance() != null) {
                            LiveContentView.this.getYoukuLivePerformance().setFullInfoEnd();
                        }
                        IPerfMonitor iPerfMonitor5 = LiveContentView.this.mPagePerfMonitor;
                        if (iPerfMonitor5 != null) {
                            iPerfMonitor5.point("LiveFullInfoCost", Thread.currentThread().getName() + "::LiveContentView onRoomChange parse:" + LiveContentView.this + ",mLiveId：" + AnonymousClass5.this.val$roomId + ", 4 after reqLiveFullInfo;4.0");
                        }
                    }
                });
            }
            IPerfMonitor iPerfMonitor3 = LiveContentView.this.mPagePerfMonitor;
            if (iPerfMonitor3 != null) {
                iPerfMonitor3.point("onRoomChange", "onRoomChange.end.async");
            }
        }
    }

    public LiveContentView(Context context) {
        this(context, null);
    }

    private boolean abtestOpenLayoutPreParseRender() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "412369889") ? ((Boolean) ipChange.ipc$dispatch("412369889", new Object[]{this})).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("openLayoutPreParseRender", true);
    }

    private Activity getActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448977965")) {
            return (Activity) ipChange.ipc$dispatch("448977965", new Object[]{this});
        }
        Context context = getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    private boolean getContainerQuitBlockerValue(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820740929")) {
            return ((Boolean) ipChange.ipc$dispatch("-820740929", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        Object data = getInstance().getData("dagoContainerQuitBlockerProp");
        return data instanceof Boolean ? ((Boolean) data).booleanValue() : z;
    }

    private LoadingRetryView getErrorRetryView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "613376037")) {
            return (LoadingRetryView) ipChange.ipc$dispatch("613376037", new Object[]{this, str});
        }
        LoadingRetryView loadingRetryView = this.mErrorRetryView;
        if (loadingRetryView == null) {
            LoadingRetryView loadingRetryView2 = new LoadingRetryView(getContext());
            loadingRetryView2.setBackButtonVisible(false);
            loadingRetryView2.setBackgroundVisible(false);
            loadingRetryView2.setRetryButtonListener(new View.OnClickListener() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2067793457")) {
                        ipChange2.ipc$dispatch("-2067793457", new Object[]{this, view});
                        return;
                    }
                    LoadingRetryView loadingRetryView3 = LiveContentView.this.mErrorRetryView;
                    if (loadingRetryView3 != null) {
                        loadingRetryView3.hideRetry();
                        loadingRetryView3.startLoading();
                        LiveContentView liveContentView = LiveContentView.this;
                        liveContentView.onRoomChange(liveContentView.mRoomId);
                    }
                }
            });
            addView(loadingRetryView2, new ViewGroup.LayoutParams(-1, -1));
            this.mErrorRetryView = loadingRetryView2;
            return loadingRetryView2;
        }
        if (loadingRetryView.getParent() != null) {
            removeView(loadingRetryView);
            addView(loadingRetryView, new ViewGroup.LayoutParams(-1, -1));
        }
        loadingRetryView.setRetryButtonListener(new View.OnClickListener() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "43496912")) {
                    ipChange2.ipc$dispatch("43496912", new Object[]{this, view});
                    return;
                }
                LoadingRetryView loadingRetryView3 = LiveContentView.this.mErrorRetryView;
                if (loadingRetryView3 != null) {
                    loadingRetryView3.hideRetry();
                    loadingRetryView3.startLoading();
                    LiveContentView liveContentView = LiveContentView.this;
                    liveContentView.onRoomChange(liveContentView.mRoomId);
                }
            }
        });
        return loadingRetryView;
    }

    private Map<String, String> getUtParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453599002")) {
            return (Map) ipChange.ipc$dispatch("1453599002", new Object[]{this});
        }
        if (this.mUtParams == null) {
            synchronized (this) {
                if (this.mUtParams == null) {
                    this.mUtParams = new HashMap(16);
                }
            }
        }
        return this.mUtParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public YoukuLivePerformance getYoukuLivePerformance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913457921")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1913457921", new Object[]{this});
        }
        String str = this.livePerformanceId;
        if (str != null) {
            return YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str);
        }
        return null;
    }

    private void handlePlayerMode(LiveFullInfoData liveFullInfoData, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25469175")) {
            ipChange.ipc$dispatch("-25469175", new Object[]{this, liveFullInfoData, map});
            return;
        }
        try {
            for (SimpleWidgetDTO simpleWidgetDTO : liveFullInfoData.widgets.widgetList) {
                if (PluginName.PLAYER.equals(simpleWidgetDTO.name)) {
                    map.put("LiveFullInfo.Widget.Player.TrustData", simpleWidgetDTO.trustData);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    private void hideLiveFullInfoRetry(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964793869")) {
            ipChange.ipc$dispatch("964793869", new Object[]{this, str});
            return;
        }
        LoadingRetryView loadingRetryView = this.mErrorRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.hideRetry();
            loadingRetryView.stopLoading();
        }
    }

    private void initSlideLayout(WidgetInstance widgetInstance) {
        List<IWidget> findWidgetsByName;
        List<IWidget> findWidgetsByName2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828813788")) {
            ipChange.ipc$dispatch("-828813788", new Object[]{this, widgetInstance});
        } else if (widgetInstance == null) {
        } else {
            IWidget iWidget = null;
            List<IWidget> findWidgetsByName3 = widgetInstance.findWidgetsByName("LiveSlide");
            if (findWidgetsByName3 != null && findWidgetsByName3.size() > 0) {
                iWidget = findWidgetsByName3.get(0);
            }
            if (iWidget == null && (findWidgetsByName2 = widgetInstance.findWidgetsByName("LRLiveSlide")) != null && findWidgetsByName2.size() > 0) {
                iWidget = findWidgetsByName2.get(0);
            }
            if (iWidget == null && (findWidgetsByName = widgetInstance.findWidgetsByName(SlideWVPlugin.SLIDE_PLUGIN_NAME)) != null && findWidgetsByName.size() > 0) {
                iWidget = findWidgetsByName.get(0);
            }
            if (iWidget == null || !(iWidget instanceof BaseSlideWidget)) {
                return;
            }
            this.mSlideLayout = (BaseSlideLayout) iWidget.getHostView();
        }
    }

    private void onRoomChange(String str, LiveFullInfoData liveFullInfoData, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246295232")) {
            ipChange.ipc$dispatch("246295232", new Object[]{this, str, liveFullInfoData, jSONObject});
            return;
        }
        IPerfMonitor iPerfMonitor = this.mPagePerfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.point("onRoomChange", "onRoomChange.begin");
        }
        updateWithLiveFullInfo(str, liveFullInfoData, jSONObject);
    }

    private void onVideoPlayComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1970715607")) {
            ipChange.ipc$dispatch("1970715607", new Object[]{this});
            return;
        }
        LivePageMonitorDomain pageTaskDomain = LivePageTaskHolder.getInstance().getPageTaskDomain((Activity) getContext());
        if (pageTaskDomain != null) {
            pageTaskDomain.onVideoPlayComplete();
        }
    }

    private void patchUtParams(Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1171073698")) {
            ipChange.ipc$dispatch("1171073698", new Object[]{this, map, Boolean.valueOf(z)});
        } else if (z) {
            if (SdkChannel.isLaifeng(getContext())) {
                map.put("pagename", "page_laifeng_liveroom");
                map.put("spm-cnt", "a2ha4.13588222");
            } else if (SdkChannel.isYouku(getContext())) {
                map.put("pagename", "page_yklaifeng_room");
                map.put("spm-cnt", "a2h0m.room");
            } else if (SdkChannel.isUC(getContext())) {
                map.put("pagename", "page_uclive_room");
                map.put("spm-cnt", "uclive.room");
            } else if (SdkChannel.isXiami(getContext())) {
                map.put("pagename", "page_xiamilive_room");
                map.put("spm-cnt", "a2o2q.room");
            }
            map.put("live_type", "4");
        } else {
            map.put("pagename", "page_youkulive");
            map.put("spm-cnt", "a2h08.8176999");
            map.put("live_type", "1");
        }
    }

    private void performanceChannelStatusChanged(Object obj) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893958835")) {
            ipChange.ipc$dispatch("-893958835", new Object[]{this, obj});
            return;
        }
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 == null) {
            return;
        }
        if ("open".equals(str2)) {
            String str3 = this.livePerformanceId;
            if (str3 != null) {
                YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str3).setChannelStart();
            }
        } else if (VAL_CHANNEL_STATUS_OPEN_SUCCESS.equals(str2)) {
            String str4 = this.livePerformanceId;
            if (str4 != null) {
                YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str4).setChannelEnd();
            }
        } else if (!str2.startsWith(VAL_CHANNEL_STATUS_OPEN_FAILURE) || (str = this.livePerformanceId) == null) {
        } else {
            YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setChannelError(str2);
        }
    }

    private void performanceLiveStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1984350084")) {
            ipChange.ipc$dispatch("-1984350084", new Object[]{this, str});
            return;
        }
        String str2 = this.livePerformanceId;
        if (str2 == null || str == null) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str2).setLiveStatus(str);
    }

    private void performancePlayerCoreFirstFrame(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096646833")) {
            ipChange.ipc$dispatch("-1096646833", new Object[]{this, obj});
            return;
        }
        Long l = obj instanceof Long ? (Long) obj : null;
        String str = this.livePerformanceId;
        if (str == null || l == null) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setLiveCoreFirstFrame(l.longValue());
    }

    private void performancePlayerCoreInfo(Object obj) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1353235486")) {
            ipChange.ipc$dispatch("1353235486", new Object[]{this, obj});
            return;
        }
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 == null || (str = this.livePerformanceId) == null) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setLiveCoreInfo(str2);
    }

    private void performancePlayerFirstFrame(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526978578")) {
            ipChange.ipc$dispatch("-1526978578", new Object[]{this, obj});
            return;
        }
        Long l = obj instanceof Long ? (Long) obj : null;
        String str = this.livePerformanceId;
        if (str == null || l == null) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setLiveFirstFrame(l.longValue());
    }

    private void performancePlayerPkMcu(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "358771795")) {
            ipChange.ipc$dispatch("358771795", new Object[]{this, obj});
            return;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            int intValue = num.intValue();
            String str = this.livePerformanceId;
            if (str != null) {
                YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setPkType((intValue & 1) == 1, (intValue & 2) == 2);
            }
        }
    }

    private void performancePlayerStart(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1126335573")) {
            ipChange.ipc$dispatch("1126335573", new Object[]{this, obj});
            return;
        }
        Long l = obj instanceof Long ? (Long) obj : null;
        String str = this.livePerformanceId;
        if (str == null || l == null) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setLiveStart(l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderLiveFullInfoRetry(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330592607")) {
            ipChange.ipc$dispatch("-1330592607", new Object[]{this, str});
            return;
        }
        LoadingRetryView errorRetryView = getErrorRetryView(str);
        if (errorRetryView != null) {
            errorRetryView.showRetry();
            errorRetryView.stopLoading();
        }
    }

    private boolean renderWidgetInstance(String str, String str2, TemplateModel templateModel, String str3, String str4, Map<String, Object> map, String str5, Map<String, Object> map2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "107005521")) {
            return ((Boolean) ipChange.ipc$dispatch("107005521", new Object[]{this, str, str2, templateModel, str3, str4, map, str5, map2})).booleanValue();
        }
        this.liveSessionId = null;
        map.put("id", str);
        map.put("liveId", str);
        map.put("liveid", str);
        map.put("roomid", str);
        if (!TextUtils.isEmpty(str5)) {
            map.put("dagoLiveWeexWidgetStaticJsBundle", str5);
        } else {
            map.remove("dagoLiveWeexWidgetStaticJsBundle");
        }
        if (TextUtils.isEmpty(str2)) {
            z = false;
        } else {
            map.put("syncRenderMode", "true");
            Log.d("SlideOp", "live content view rendered:" + hashCode());
            getInstance().didDisappear();
            getInstance().didDeactive();
            getInstance().destroy();
            if (map.containsKey("isFirstLiveRoom") && "1".equals(map.get("isFirstLiveRoom"))) {
                z2 = true;
            }
            if (z2) {
                youkuArouseSendReadyToDraw();
                if (map.containsKey("liveRequestSessionId")) {
                    Object obj = map.get("liveRequestSessionId");
                    if (obj instanceof String) {
                        this.liveSessionId = (String) obj;
                    }
                }
            }
            if (str2 != null && !abtestOpenLayoutPreParseRender()) {
                getInstance().render(str2, map, map2);
            } else if (abtestOpenLayoutPreParseRender()) {
                if (templateModel != null) {
                    getInstance().render(templateModel, map, map2);
                } else {
                    getInstance().render(str2, map, map2);
                }
            }
            getInstance().addDataHandler("playerFirstError", this);
            getInstance().addDataHandler(KEY_PLAYER_START, this);
            getInstance().addDataHandler("playerFirstFrame", this);
            getInstance().addDataHandler(KEY_PLAYER_CORE_FIRST_FRAME, this);
            getInstance().addDataHandler(KEY_PLAYER_CORE_INFO, this);
            getInstance().addDataHandler(KEY_PLAYER_PK_MCU, this);
            getInstance().addDataHandler(KEY_CHANNEL_STATUS_CHANGED, this);
            Object obj2 = map.get("spm-url");
            String str6 = obj2 instanceof String ? (String) obj2 : "";
            Object obj3 = map.get("isFirstLiveRoom");
            String str7 = obj3 instanceof String ? (String) obj3 : "0";
            Object obj4 = map.get("isColdStart");
            String str8 = obj4 instanceof String ? (String) obj4 : "0";
            Object obj5 = map.get("matchLayoutCache");
            getInstance().getPerfMonitor().perfConfig("roomId", str).perfConfig("spmUrl", str6).perfConfig("firstRoom", str7).perfConfig("isColdStart", str8).perfConfig("matchLayoutCache", obj5 instanceof String ? (String) obj5 : "0").perfCommitSuccess();
            z2 = true;
        }
        if (!z && map2 != null) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                Object data = getInstance().getData(entry.getKey());
                if (data != null && !data.equals(entry.getValue())) {
                    getInstance().asyncPutData(entry.getKey(), entry.getValue());
                }
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderWithLiveFullInfo(String str, LiveFullInfoData liveFullInfoData, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309445563")) {
            ipChange.ipc$dispatch("-309445563", new Object[]{this, str, liveFullInfoData, jSONObject});
            return;
        }
        String str2 = this.mRoomId;
        if (str2 == null || str == null || !str2.equals(str) || liveFullInfoData == null) {
            return;
        }
        try {
            if (liveFullInfoData.template == null || jSONObject == null) {
                return;
            }
            HashMap hashMap = new HashMap(6);
            new String(Base64.decode(liveFullInfoData.template.layout, 0));
            for (LiveBundleLayout liveBundleLayout : liveFullInfoData.template.layoutList) {
                if (!"landScape".equals(liveBundleLayout.type)) {
                    "vertical".equals(liveBundleLayout.type);
                }
            }
            handlePlayerMode(liveFullInfoData, hashMap);
            getInstance().asyncPutData("mtop.youku.live.com.livefullinfo", liveFullInfoData, jSONObject);
            getInstance().asyncPutData("LiveFullInfo.Widget.Player.TrustData", hashMap.get("LiveFullInfo.Widget.Player.TrustData"));
        } catch (Throwable th) {
            Context context = getContext();
            ((IToast) Dsl.getService(IToast.class)).showCenterToast(context, "暂不支持直播间\"" + str + "\"");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidgetVisibility(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127809844")) {
            ipChange.ipc$dispatch("-2127809844", new Object[]{this, Boolean.valueOf(z)});
        } else {
            setWidgetVisibility(z, false);
        }
    }

    private void showPreview(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-201003159")) {
            ipChange.ipc$dispatch("-201003159", new Object[]{this, Boolean.valueOf(z), str});
        }
    }

    private void updatePvWithLiveFullInfo(LiveFullInfoData liveFullInfoData, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847389289")) {
            ipChange.ipc$dispatch("-1847389289", new Object[]{this, liveFullInfoData, map});
            return;
        }
        try {
            updatePvWithLiveFullInfoImp(liveFullInfoData, map);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void updatePvWithLiveFullInfoImp(LiveFullInfoData liveFullInfoData, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235919587")) {
            ipChange.ipc$dispatch("-1235919587", new Object[]{this, liveFullInfoData, map});
            return;
        }
        Map<String, String> utParams = getUtParams();
        utParams.clear();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    utParams.put(entry.getKey(), (String) value);
                }
            }
        }
        String str = null;
        Integer num = liveFullInfoData.liveStatus;
        int intValue = num != null ? num.intValue() : 0;
        if (intValue == 0) {
            str = "预约";
        } else if (intValue == 1) {
            str = "直播";
        } else if (intValue == 2 || intValue == 3) {
            str = "回看";
        }
        performanceLiveStatus(String.valueOf(intValue));
        String str2 = liveFullInfoData.name;
        String str3 = liveFullInfoData.screenId != null ? "" + liveFullInfoData.screenId : "";
        String str4 = liveFullInfoData.liveId != null ? "" + liveFullInfoData.liveId : "";
        utParams.put("type", str);
        utParams.put("liveRoomType", "native");
        utParams.put("screenid", str3);
        utParams.put("page", str2);
        utParams.put("page_type", "1");
        utParams.put("liveid", str4);
        utParams.put("liveId", str4);
        utParams.put("roomid", str4);
        utParams.put("roomId", str4);
        utParams.put("id", str4);
        if (this.isAppear) {
            Context context = getContext();
            if (context instanceof LiveActivity) {
                ((LiveActivity) context).updatePageProperties(this.mRoomId, getUtParams());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithLiveFullInfo(final String str, final LiveFullInfoData liveFullInfoData, final JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920974158")) {
            ipChange.ipc$dispatch("-1920974158", new Object[]{this, str, liveFullInfoData, jSONObject});
            return;
        }
        hideLiveFullInfoRetry(str);
        if (liveFullInfoData != null && jSONObject != null) {
            updatePvWithLiveFullInfo(liveFullInfoData, getRenderParamsAsMap());
            getInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1523692962")) {
                        ipChange2.ipc$dispatch("1523692962", new Object[]{this});
                        return;
                    }
                    IPerfMonitor iPerfMonitor = LiveContentView.this.mPagePerfMonitor;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point("onRoomChange", "onRoomChange.begin.renderWithLiveFullInfo");
                    }
                    LiveContentView.this.renderWithLiveFullInfo(str, liveFullInfoData, jSONObject);
                    IPerfMonitor iPerfMonitor2 = LiveContentView.this.mPagePerfMonitor;
                    if (iPerfMonitor2 != null) {
                        iPerfMonitor2.point("onRoomChange", "onRoomChange.end.renderWithLiveFullInfo");
                    }
                }
            });
            IPerfMonitor iPerfMonitor = this.mPagePerfMonitor;
            if (iPerfMonitor != null) {
                iPerfMonitor.point("onRoomChange", "onRoomChange.end.requestFullInfoV4");
            }
            try {
                if (this.livePerformanceId != null) {
                    YoukuLivePerformanceManager.getInstance().getPerfBySessionId(this.livePerformanceId).setTemplateId(liveFullInfoData.template.templateId).setBizType(String.valueOf(liveFullInfoData.bizType));
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        getInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1720206467")) {
                    ipChange2.ipc$dispatch("1720206467", new Object[]{this});
                } else {
                    LiveContentView.this.renderLiveFullInfoRetry(str);
                }
            }
        });
    }

    private void youkuArouseSendDrawFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861889103")) {
            ipChange.ipc$dispatch("1861889103", new Object[]{this});
        } else if (this.hasArouseSendDrawFinish) {
        } else {
            this.hasArouseSendDrawFinish = true;
            ((IYoukuArouse) Dsl.getService(IYoukuArouse.class)).sendDrawFinish(getActivity());
        }
    }

    private void youkuArouseSendReadyToDraw() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-495503038")) {
            ipChange.ipc$dispatch("-495503038", new Object[]{this});
        } else if (this.hasArouseSendReadyToDraw) {
        } else {
            this.hasArouseSendReadyToDraw = true;
            ((IYoukuArouse) Dsl.getService(IYoukuArouse.class)).sendReadyToDraw(getActivity());
        }
    }

    public int PxToDp(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "483096411") ? ((Integer) ipChange.ipc$dispatch("483096411", new Object[]{this, Integer.valueOf(i)})).intValue() : (int) ((i / getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void activate(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656401597")) {
            ipChange.ipc$dispatch("656401597", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.activated = z;
        }
    }

    public LiveContentView attachWidgetEngineContext(WidgetEngineContext widgetEngineContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58373023")) {
            return (LiveContentView) ipChange.ipc$dispatch("58373023", new Object[]{this, widgetEngineContext});
        }
        this.mWidgetEngineContext = widgetEngineContext;
        return this;
    }

    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-590422196")) {
            ipChange.ipc$dispatch("-590422196", new Object[]{this});
        } else if (this.isAppear) {
        } else {
            this.isAppear = true;
            Context context = getContext();
            if (context instanceof LiveActivity) {
                String str = getRenderParams().get("pagename");
                String str2 = getRenderParams().get("spm-cnt");
                String str3 = getRenderParams().get("live_type");
                getUtParams().put("spm-cnt", str2);
                getUtParams().put("live_type", str3);
                getUtParams().put("liveid", this.mRoomId);
                getUtParams().put("liveId", this.mRoomId);
                getUtParams().put("roomid", this.mRoomId);
                getUtParams().put("roomId", this.mRoomId);
                getUtParams().put("id", this.mRoomId);
                ((LiveActivity) context).pageAppear(this.mRoomId, str, str2, str3, getUtParams());
            }
        }
    }

    public void didDisappear() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1446065126")) {
            ipChange.ipc$dispatch("1446065126", new Object[]{this});
        } else if (this.isAppear) {
            this.isAppear = false;
            if (this.activated && (str = this.livePerformanceId) != null) {
                YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).report();
            }
            Context context = getContext();
            if (context instanceof LiveActivity) {
                ((LiveActivity) context).pageDisappear(this.mRoomId);
            }
        }
    }

    public void finalDidDisappear() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1853428486")) {
            ipChange.ipc$dispatch("1853428486", new Object[]{this});
        } else if (this.isAppear) {
            this.isAppear = false;
            if (this.activated && (str = this.livePerformanceId) != null) {
                YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).report();
            }
            Context context = getContext();
            if (context instanceof LiveActivity) {
                ((LiveActivity) context).pageDisappear(this.mRoomId, true);
            }
        }
    }

    public WidgetInstance getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910447710")) {
            return (WidgetInstance) ipChange.ipc$dispatch("910447710", new Object[]{this});
        }
        if (this.mInstance == null) {
            synchronized (this) {
                if (this.mInstance == null) {
                    WidgetEngineContext widgetEngineContext = this.mWidgetEngineContext;
                    if (widgetEngineContext != null) {
                        this.mInstance = widgetEngineContext.createInstance();
                    } else {
                        this.mInstance = new WidgetInstance();
                    }
                    this.mInstance.setContext(getContext());
                    this.mInstance.setRenderListener(this);
                }
            }
        }
        return this.mInstance;
    }

    public Map<String, String> getParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1344207879") ? (Map) ipChange.ipc$dispatch("-1344207879", new Object[]{this}) : getRenderParams();
    }

    protected Map<String, String> getRenderParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "534003139")) {
            return (Map) ipChange.ipc$dispatch("534003139", new Object[]{this});
        }
        if (this.mRenderParams == null) {
            synchronized (this) {
                if (this.mRenderParams == null) {
                    this.mRenderParams = new HashMap();
                }
            }
        }
        if (!this.mRenderParams.containsKey(DagoLiveFullInfoV4Plugin.DAGO_LIVE_FULL_INFO_V4_PLUGIN_VALUE)) {
            this.mRenderParams.put(DagoLiveFullInfoV4Plugin.DAGO_LIVE_FULL_INFO_V4_PLUGIN_VALUE, "false");
        }
        return this.mRenderParams;
    }

    protected Map<String, Object> getRenderParamsAsMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642628793")) {
            return (Map) ipChange.ipc$dispatch("-1642628793", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getRenderParams());
        return hashMap;
    }

    public int getStatusBarHeightByReflectDP() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937221581")) {
            return ((Integer) ipChange.ipc$dispatch("-937221581", new Object[]{this})).intValue();
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return PxToDp(getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString())));
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getStatusBarHeightByReflectPX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-925901001")) {
            return ((Integer) ipChange.ipc$dispatch("-925901001", new Object[]{this})).intValue();
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception unused) {
            return 0;
        }
    }

    public LiveContentView initDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "494437045")) {
            return (LiveContentView) ipChange.ipc$dispatch("494437045", new Object[]{this});
        }
        getInstance().addDataHandler(DAGO_CONTENT_PREVIEW_STATE_CHANGE, this);
        return this;
    }

    public boolean isUnimitRotateScreen() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1973576885") ? ((Boolean) ipChange.ipc$dispatch("1973576885", new Object[]{this})).booleanValue() : this.isUnlimitRotateScreen;
    }

    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-971250473")) {
            return ((Boolean) ipChange.ipc$dispatch("-971250473", new Object[]{this})).booleanValue();
        }
        boolean onActivityBackPressedForWidget = onActivityBackPressedForWidget();
        return !onActivityBackPressedForWidget ? onActivityBackPressedForWeex() : onActivityBackPressedForWidget;
    }

    public boolean onActivityBackPressedForWeex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1805376559")) {
            return ((Boolean) ipChange.ipc$dispatch("-1805376559", new Object[]{this})).booleanValue();
        }
        boolean containerQuitBlockerValue = getContainerQuitBlockerValue(false);
        if (containerQuitBlockerValue) {
            getInstance().putData("onDagoContainerQuitEvent", null);
        }
        return containerQuitBlockerValue;
    }

    public boolean onActivityBackPressedForWidget() {
        IDagoLivePlaybackInjectorInterface iDagoLivePlaybackInjectorInterface;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1560511598")) {
            return ((Boolean) ipChange.ipc$dispatch("1560511598", new Object[]{this})).booleanValue();
        }
        if (this.isUnlimitRotateScreen) {
            WeakReference<IDagoLivePlaybackInjectorInterface> weakReference = this.mLivePlaybackWidget;
            if (weakReference != null && (iDagoLivePlaybackInjectorInterface = weakReference.get()) != null) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("open", Boolean.FALSE);
                iDagoLivePlaybackInjectorInterface.injectorPlayerAction("setUnlimitScreen", hashMap);
            }
            z = true;
        }
        return !z ? getInstance().onActivityBackPressed() : z;
    }

    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-269061198")) {
            ipChange.ipc$dispatch("-269061198", new Object[]{this, configuration});
            return;
        }
        getInstance().onActivityConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 2) {
            this.mIsLandscape = true;
        } else {
            this.mIsLandscape = false;
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901530409")) {
            ipChange.ipc$dispatch("-901530409", new Object[]{this, str, obj, obj2});
        } else if (DAGO_CONTENT_PREVIEW_STATE_CHANGE.equals(str)) {
            showPreview(false, this.mLatestUrl);
        } else if (KEY_PLAYER_START.equals(str)) {
            if (this.hasPlayerStart) {
                return;
            }
            this.hasPlayerStart = true;
            performancePlayerStart(obj);
        } else if ("playerFirstFrame".equals(str)) {
            if (this.hasPlayerFirstFrame) {
                return;
            }
            this.hasPlayerFirstFrame = true;
            performancePlayerFirstFrame(obj);
            if (this.mIsFirstRoom) {
                youkuArouseSendDrawFinish();
                removeCallbacks(this);
                postDelayed(this, 500L);
            }
        } else if (KEY_PLAYER_CORE_FIRST_FRAME.equals(str)) {
            if (this.hasPlayerCoreFirstFrame) {
                return;
            }
            this.hasPlayerCoreFirstFrame = true;
            performancePlayerCoreFirstFrame(obj);
        } else if (KEY_PLAYER_CORE_INFO.equals(str)) {
            if (this.hasPlayerCoreInfo) {
                return;
            }
            this.hasPlayerCoreInfo = true;
            performancePlayerCoreInfo(obj);
        } else if (KEY_PLAYER_PK_MCU.equals(str)) {
            if (this.hasPlayerPkMcu) {
                return;
            }
            this.hasPlayerPkMcu = true;
            performancePlayerPkMcu(obj);
        } else if (KEY_CHANNEL_STATUS_CHANGED.equals(str)) {
            performanceChannelStatusChanged(obj);
        } else if ("playerFirstError".equals(str)) {
            if (this.mIsFirstRoom) {
                youkuArouseSendDrawFinish();
                removeCallbacks(this);
                onVideoPlayComplete();
            }
        } else if (KEY_PLAYER_CORE_FIRST_FRAME.equals(str)) {
            performancePlayerCoreFirstFrame(obj);
        } else if (KEY_PLAYER_CORE_INFO.equals(str)) {
            performancePlayerCoreInfo(obj);
        } else if (KEY_PLAYER_PK_MCU.equals(str)) {
            performancePlayerPkMcu(obj);
        } else if (KEY_CHANNEL_STATUS_CHANGED.equals(str)) {
            performanceChannelStatusChanged(obj);
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineRenderListener
    public void onException(WidgetInstance widgetInstance, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446333155")) {
            ipChange.ipc$dispatch("-446333155", new Object[]{this, widgetInstance, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", this.mRoomId);
        ((IYoukuLiveAlarm) Dsl.getService(IYoukuLiveAlarm.class)).commitFail(WidgetInstance.TAG, str, str2, hashMap);
    }

    @Override // com.youku.live.widgets.protocol.IEngineRenderListener
    public void onHostViewCreated(WidgetInstance widgetInstance, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009837117")) {
            ipChange.ipc$dispatch("2009837117", new Object[]{this, widgetInstance, view});
            return;
        }
        IPerfMonitor iPerfMonitor = this.mPagePerfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.point("onHostViewCreated", "onHostViewCreated.begin");
        }
        addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
        IPerfMonitor iPerfMonitor2 = this.mPagePerfMonitor;
        if (iPerfMonitor2 != null) {
            iPerfMonitor2.point("onHostViewCreated", "onHostViewCreated.end");
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360953979")) {
            return ((Boolean) ipChange.ipc$dispatch("360953979", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && this.mMoveState == RoomMoveState.IDLE) {
                BaseSlideLayout baseSlideLayout = this.mSlideLayout;
                if (baseSlideLayout != null && !baseSlideLayout.isShow()) {
                    this.mMoveState = RoomMoveState.LEFT;
                } else {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mTouchDownX;
                    if (Math.abs(y - this.mTouchDownY) > Math.abs(f)) {
                        return false;
                    }
                    if (f > 0.0f) {
                        this.mMoveState = RoomMoveState.RIGHT;
                    } else if (f < 0.0f) {
                        this.mMoveState = RoomMoveState.LEFT;
                    }
                }
            }
        } else {
            this.mTouchDownX = motionEvent.getX();
            this.mTouchDownY = motionEvent.getY();
            this.mMoveState = RoomMoveState.IDLE;
            BaseSlideLayout baseSlideLayout2 = this.mSlideLayout;
            if (baseSlideLayout2 != null) {
                baseSlideLayout2.handleSlideEvent(motionEvent);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.youku.live.widgets.protocol.IEngineRenderListener
    public void onRefreshSuccess(WidgetInstance widgetInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1858570")) {
            ipChange.ipc$dispatch("-1858570", new Object[]{this, widgetInstance});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", this.mRoomId);
        ((IYoukuLiveAlarm) Dsl.getService(IYoukuLiveAlarm.class)).commitSuccess(WidgetInstance.TAG, "refreshSuccess", hashMap);
    }

    @Override // com.youku.live.widgets.protocol.IEngineRenderListener
    public void onRenderSuccess(WidgetInstance widgetInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528788665")) {
            ipChange.ipc$dispatch("-528788665", new Object[]{this, widgetInstance});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", this.mRoomId);
        ((IYoukuLiveAlarm) Dsl.getService(IYoukuLiveAlarm.class)).commitSuccess(WidgetInstance.TAG, "renderSuccess", hashMap);
        Log.i("liulei-play", "onRenderSuccess");
        IPerfMonitor iPerfMonitor = this.mPagePerfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.point("onRenderSuccess", "onRenderSuccess.begin");
        }
        IWidget findWidgetById = widgetInstance.findWidgetById(AlixLivePlayback.WIDGET_NAME);
        boolean z = this.mLivePlaybackWidget instanceof ICall;
        if (findWidgetById instanceof IDagoLivePlaybackInjectorInterface) {
            IDagoLivePlaybackInjectorInterface iDagoLivePlaybackInjectorInterface = (IDagoLivePlaybackInjectorInterface) findWidgetById;
            this.mLivePlaybackWidget = new WeakReference<>(iDagoLivePlaybackInjectorInterface);
            iDagoLivePlaybackInjectorInterface.injectorSetRotateEventListener(new IDagoLivePlaybackInjectorInterface.IResultListener() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface.IResultListener
                public void onResult(Map<String, Object> map) {
                    WindowManager.LayoutParams attributes;
                    WindowManager.LayoutParams attributes2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1365707306")) {
                        ipChange2.ipc$dispatch("1365707306", new Object[]{this, map});
                    } else if (map != null) {
                        try {
                            if (!map.containsKey("key") || map.get("key") == null) {
                                return;
                            }
                            if ("DAGOStartOrotateAction".equals(map.get("key"))) {
                                LiveContentView.this.isUnlimitRotateScreen = true;
                                Log.i("liulei-play", "DAGOExitOrotateAction");
                                if (LiveContentView.this.getHandler() != null) {
                                    LiveContentView.this.getHandler().removeCallbacks(LiveContentView.this.mShowWidgetRunnable);
                                }
                                LiveContentView.this.setWidgetVisibility(false);
                                if ((LiveContentView.this.mWidgetEngineContext == null && (LiveContentView.this.mWidgetEngineContext.getCurrentActivity() == null || LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getWindow() == null)) || (attributes2 = LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getWindow().getAttributes()) == null || attributes2.rotationAnimation == 3) {
                                    return;
                                }
                                attributes2.rotationAnimation = 3;
                                LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getWindow().setAttributes(attributes2);
                            } else if ("DAGOFinishOrotateAction".equals(map.get("key"))) {
                                if (map.containsKey(com.youku.live.dago.liveplayback.widget.Constants.ACTION_PARAMS_SCREENMODE) && map.get(com.youku.live.dago.liveplayback.widget.Constants.ACTION_PARAMS_SCREENMODE) != null) {
                                    try {
                                        if (LiveContentView.this.mWidgetEngineContext != null && LiveContentView.this.mWidgetEngineContext.getCurrentActivity() != null) {
                                            int intValue = ((Integer) map.get(com.youku.live.dago.liveplayback.widget.Constants.ACTION_PARAMS_SCREENMODE)).intValue();
                                            if (intValue != 1) {
                                                if (intValue != 2) {
                                                    if (intValue == 3 && LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getRequestedOrientation() != 8) {
                                                        LiveContentView.this.mWidgetEngineContext.getCurrentActivity().setRequestedOrientation(8);
                                                    }
                                                } else if (LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getRequestedOrientation() != 0) {
                                                    LiveContentView.this.mWidgetEngineContext.getCurrentActivity().setRequestedOrientation(0);
                                                }
                                            } else if (LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getRequestedOrientation() != 1) {
                                                LiveContentView.this.mWidgetEngineContext.getCurrentActivity().setRequestedOrientation(1);
                                            }
                                        }
                                        return;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (LiveContentView.this.getHandler() != null) {
                                    LiveContentView.this.getHandler().removeCallbacks(LiveContentView.this.mShowWidgetRunnable);
                                    LiveContentView.this.getHandler().postDelayed(LiveContentView.this.mShowWidgetRunnable, 300L);
                                    return;
                                }
                                LiveContentView.this.setWidgetVisibility(true);
                            } else if ("DAGOExitOrotateAction".equals(map.get("key"))) {
                                LiveContentView.this.isUnlimitRotateScreen = false;
                                if ((LiveContentView.this.mWidgetEngineContext != null || (LiveContentView.this.mWidgetEngineContext.getCurrentActivity() != null && LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getWindow() != null)) && (attributes = LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getWindow().getAttributes()) != null && attributes.rotationAnimation != 0) {
                                    attributes.rotationAnimation = 0;
                                    LiveContentView.this.mWidgetEngineContext.getCurrentActivity().getWindow().setAttributes(attributes);
                                }
                                if (LiveContentView.this.getHandler() != null) {
                                    LiveContentView.this.getHandler().removeCallbacks(LiveContentView.this.mShowWidgetRunnable);
                                }
                                LiveContentView.this.setWidgetVisibility(true, true);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
        IPerfMonitor iPerfMonitor2 = this.mPagePerfMonitor;
        if (iPerfMonitor2 != null) {
            iPerfMonitor2.point("onRenderSuccess", "onRenderSuccess.end");
        }
        initSlideLayout(widgetInstance);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r0 != 4) goto L15;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public LiveContentView putOptions(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043707418")) {
            return (LiveContentView) ipChange.ipc$dispatch("-2043707418", new Object[]{this, map});
        }
        getRenderParams().putAll(map);
        return this;
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800942617")) {
            ipChange.ipc$dispatch("1800942617", new Object[]{this});
        } else {
            this.mInstance = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972052117")) {
            ipChange.ipc$dispatch("1972052117", new Object[]{this});
        } else {
            onVideoPlayComplete();
        }
    }

    public void setEngineContext(WidgetEngineContext widgetEngineContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139601228")) {
            ipChange.ipc$dispatch("-2139601228", new Object[]{this, widgetEngineContext});
            return;
        }
        this.mWidgetEngineContext = widgetEngineContext;
        getInstance().addDataHandler(DAGO_CONTENT_PREVIEW_STATE_CHANGE, this);
    }

    public void setIsFirstEnter(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996490584")) {
            ipChange.ipc$dispatch("-996490584", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsFirstEnter = z;
        }
    }

    public void setIsFirstRoom(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "98025833")) {
            ipChange.ipc$dispatch("98025833", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsFirstRoom = z;
        }
    }

    public void updateWithRoomInfo(int i, SwitchItemModel switchItemModel) {
        String str;
        LiveFullInfoData liveFullInfoData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469102446")) {
            ipChange.ipc$dispatch("1469102446", new Object[]{this, Integer.valueOf(i), switchItemModel});
            return;
        }
        PerfLogUtils.log("LiveContentView.updateRoomInfo start ...");
        boolean z = ConfigHelper.getBoolean("live_platform_bugfix_rollback", "issue29192322_multi_live_full_info", true);
        this.mSwitchItemModel = switchItemModel;
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("dago_analytics", "update room started:" + switchItemModel.roomId + ", timestamp:" + currentTimeMillis);
        StringBuilder sb = new StringBuilder();
        sb.append("update room cover:");
        sb.append(switchItemModel._cover);
        Log.d("dago_log", sb.toString());
        String str2 = switchItemModel._cover;
        showPreview(true, str2);
        this.hasPlayerFirstFrame = false;
        this.hasPlayerStart = false;
        this.hasPlayerCoreFirstFrame = false;
        this.hasPlayerCoreInfo = false;
        this.hasPlayerPkMcu = false;
        if (this.mIsFirstRoom) {
            LiveInfoModel liveInfoModel = switchItemModel.liveInfo;
            if (liveInfoModel == null) {
                liveInfoModel = new LiveInfoModel();
                switchItemModel.liveInfo = liveInfoModel;
            }
            if (liveInfoModel.coverUrl == null && getRenderParams().containsKey("cover_url")) {
                String str3 = getRenderParams().get("cover_url");
                liveInfoModel.coverUrl = str3;
                switchItemModel._cover = str3;
            }
            if (liveInfoModel.avatarUrl == null && getRenderParams().containsKey("anchor_avatar")) {
                liveInfoModel.avatarUrl = getRenderParams().get("anchor_avatar");
            }
            if (liveInfoModel.nickName == null && getRenderParams().containsKey("nick_name")) {
                liveInfoModel.nickName = getRenderParams().get("nick_name");
            }
            if (liveInfoModel.onlineCount <= 0 && getRenderParams().containsKey("online_count")) {
                try {
                    liveInfoModel.onlineCount = Long.parseLong(getRenderParams().get("online_count"));
                } catch (Throwable unused) {
                }
            }
        }
        if (switchItemModel._cover != null) {
            str2 = CDNHelper.getInstance().blurWithSize(switchItemModel._cover, 15, 15, 60, 60);
            switchItemModel._cover = str2;
        }
        long currentTimeMillis2 = YoukuLivePerformanceManager.currentTimeMillis();
        if (switchItemModel.roomId.equals(this.mRoomId)) {
            str = null;
        } else {
            if (!this.mIsFirstRoom) {
                if (!switchItemModel.hasLivePerformanceId()) {
                    switchItemModel.setLivePerformanceId(String.valueOf(currentTimeMillis2));
                }
            } else if (!switchItemModel.hasLivePerformanceId()) {
                switchItemModel.setLivePerformanceId(getRenderParams().get("liveRequestSessionId"));
            }
            this.livePerformanceId = switchItemModel.getLivePerformanceId();
            String str4 = switchItemModel.roomId;
            this.mRoomId = str4;
            HashMap hashMap = new HashMap(6);
            hashMap.put(DagoDataCenterConstants.DAGO_LIVE_ID, str4);
            hashMap.put(LiveRoomConstants.DATA_KEY_LAIFENG_RECOMMEND_CURRENT, switchItemModel);
            LiveQuickPlayModel liveQuickPlayModel = switchItemModel.liveQuickPlay;
            hashMap.put("dagoLaifengUrlList", liveQuickPlayModel == null ? null : liveQuickPlayModel.url_list);
            hashMap.put("dagoLiveIdSwitchProp", str4);
            patchUtParams(getRenderParams(), switchItemModel._isLaifeng);
            Map<String, Object> renderParamsAsMap = getRenderParamsAsMap();
            renderParamsAsMap.put("livePerformanceId", this.livePerformanceId);
            LiveQuickPlayModel liveQuickPlayModel2 = switchItemModel.liveQuickPlay;
            renderParamsAsMap.put("dagoLiveIdPlayerModel", (liveQuickPlayModel2 == null || (r2 = liveQuickPlayModel2.newPlayInfo) == null) ? null : null);
            renderParamsAsMap.put("layout", switchItemModel._layout);
            renderParamsAsMap.put("dagoPlayerCoverImage", str2);
            renderParamsAsMap.put("layoutLandscape", switchItemModel._layoutLandscape);
            renderParamsAsMap.put("layoutPortrait", switchItemModel._layoutPortrait);
            renderParamsAsMap.put("switchItemModel", switchItemModel);
            renderParamsAsMap.put("liveid", this.mRoomId);
            renderParamsAsMap.put("liveId", this.mRoomId);
            renderParamsAsMap.put("id", this.mRoomId);
            renderParamsAsMap.put("isLaifeng", switchItemModel._isLaifeng ? "1" : "0");
            renderParamsAsMap.put("isImmerse", ((IConfig) Dsl.getService(IConfig.class)).getString(IConfigImp.NAMESPACE_LOCALCONFIG, IConfigImp.KEY_LOCALCONFIG_IMMERSE, "1"));
            str = null;
            renderWidgetInstance(str4, switchItemModel._layout, switchItemModel._layoutModel, switchItemModel._layoutPortrait, switchItemModel._layoutLandscape, renderParamsAsMap, switchItemModel._static, hashMap);
            if (z) {
                JSONObject jSONObject = switchItemModel._fullInfoJson;
                if (jSONObject != null && (liveFullInfoData = switchItemModel._fullInfoData) != null) {
                    onRoomChange(this.mRoomId, liveFullInfoData, jSONObject);
                    switchItemModel._fullInfoData = null;
                    switchItemModel._fullInfoJson = null;
                } else {
                    onRoomChange(this.mRoomId, switchItemModel._taskId);
                    switchItemModel._taskId = null;
                }
            }
            String str5 = getRenderParams().get("source_from");
            if (TextUtils.isEmpty(str5)) {
                str5 = "unknown";
            }
            YoukuLivePerformance perfBySessionId = YoukuLivePerformanceManager.getInstance().getPerfBySessionId(this.livePerformanceId);
            if (!this.mIsFirstRoom) {
                perfBySessionId.setNavigateStart(currentTimeMillis2).setNavigateEnd(currentTimeMillis2).setPageStart(currentTimeMillis2).setPageEnd(currentTimeMillis2);
            }
            YoukuLivePerformance templateEnd = perfBySessionId.setFirstEnter(this.mIsFirstEnter).setEnterType(this.mIsFirstRoom ? "0" : "1").setLiveId(switchItemModel.roomId).setSpmUrl(getRenderParams().get("spm-url")).setTemplateStart(currentTimeMillis2).setTemplateEnd(YoukuLivePerformanceManager.currentTimeMillis());
            if (!this.mIsFirstRoom) {
                str5 = "room-scroll";
            }
            templateEnd.setSourceFrom(str5).setListOrder(i);
            if (getInstance().findWidgetById(AlixLivePlayback.WIDGET_NAME) != null) {
                perfBySessionId.setVideoRoomType();
            } else if (getInstance().findPluginByName("LaifengAudioCtrl") != null) {
                perfBySessionId.setAudioRoomType();
            } else {
                perfBySessionId.setOtherRoomType();
            }
            LiveQuickPlayModel liveQuickPlayModel3 = switchItemModel.liveQuickPlay;
            if (liveQuickPlayModel3 != null) {
                perfBySessionId.setBizType(String.valueOf(liveQuickPlayModel3.bizType));
                TemplateDTO templateDTO = switchItemModel.liveQuickPlay.template;
                if (templateDTO != null) {
                    perfBySessionId.setTemplateId(templateDTO.templateId);
                }
                NewPlayInfoModel newPlayInfoModel = switchItemModel.liveQuickPlay.newPlayInfo;
                if (newPlayInfoModel != null) {
                    AppKeyPlayInfoModel appKeyPlayInfoModel = newPlayInfoModel.playInfo;
                    if (appKeyPlayInfoModel != null) {
                        perfBySessionId.setPlayInfoFormat(appKeyPlayInfoModel.format).setHasPlayInfoUrl(switchItemModel.liveQuickPlay.newPlayInfo.playInfo.url != null);
                    }
                    if (switchItemModel.liveQuickPlay.newPlayInfo.rtcInfo != null) {
                        perfBySessionId.setHasRtcInfo(true);
                    }
                }
            }
        }
        if (z) {
            return;
        }
        onRoomChange(this.mRoomId, switchItemModel._taskId);
        switchItemModel._taskId = str;
    }

    public LiveContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidgetVisibility(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537549944")) {
            ipChange.ipc$dispatch("-1537549944", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        List<IWidget> findWidgetsByName = this.mInstance.findWidgetsByName("LiveWeex");
        IWidget iWidget = null;
        IWidget iWidget2 = (findWidgetsByName == null || findWidgetsByName.size() <= 0) ? null : findWidgetsByName.get(0);
        List<IWidget> findWidgetsByName2 = this.mInstance.findWidgetsByName("BackBtn");
        if (findWidgetsByName2 != null && findWidgetsByName2.size() > 0) {
            iWidget = findWidgetsByName2.get(0);
        }
        if (!z) {
            if (iWidget2 != null) {
                if (iWidget2.getHostView() != null) {
                    iWidget2.getHostView().setAlpha(0.0f);
                }
                iWidget2.hide();
            }
            if (iWidget != null) {
                if (iWidget.getHostView() != null) {
                    iWidget.getHostView().setAlpha(0.0f);
                }
                iWidget.hide();
                return;
            }
            return;
        }
        if (iWidget2 != null) {
            if (iWidget2.getHostView() != null) {
                iWidget2.getHostView().setAlpha(1.0f);
            }
            iWidget2.show();
        }
        if (iWidget != null) {
            if (z2) {
                if (iWidget.getHostView() != null) {
                    iWidget.getHostView().setAlpha(1.0f);
                }
                iWidget.show();
                return;
            }
            if (iWidget.getHostView() != null) {
                iWidget.getHostView().setAlpha(0.0f);
            }
            iWidget.hide();
        }
    }

    public LiveContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivated = false;
        this.mRendered = false;
        this.mRoomId = null;
        this.mLastTicket = null;
        this.mLatestUrl = null;
        this.mSwitchItemModel = null;
        this.mTouchDownX = 0.0f;
        this.mTouchDownY = 0.0f;
        this.mIsLandscape = false;
        this.livePerformanceId = null;
        this.mIsFirstRoom = false;
        this.mIsFirstEnter = false;
        this.isUnlimitRotateScreen = false;
        this.mShowWidgetRunnable = new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1788706809")) {
                    ipChange.ipc$dispatch("-1788706809", new Object[]{this});
                } else {
                    LiveContentView.this.setWidgetVisibility(true);
                }
            }
        };
        this.mHideWidgetRunnable = new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1985220314")) {
                    ipChange.ipc$dispatch("-1985220314", new Object[]{this});
                } else {
                    LiveContentView.this.setWidgetVisibility(false);
                }
            }
        };
        this.isAppear = false;
        this.liveSessionId = null;
        this.activated = false;
        this.hasPlayerFirstFrame = false;
        this.hasPlayerStart = false;
        this.hasPlayerCoreFirstFrame = false;
        this.hasPlayerCoreInfo = false;
        this.hasPlayerPkMcu = false;
        this.hasArouseSendReadyToDraw = false;
        this.hasArouseSendDrawFinish = false;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    private void onRoomChange(final String str, String str2) {
        Preloader preloader;
        Preloader.IData data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070967668")) {
            ipChange.ipc$dispatch("2070967668", new Object[]{this, str, str2});
            return;
        }
        IPerfMonitor iPerfMonitor = this.mPagePerfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.point("onRoomChange", "onRoomChange.begin");
        }
        if (str2 != null && (data = (preloader = Preloader.getInstance()).getData(str2)) != null) {
            if (data.isFinish()) {
                updateWithLiveFullInfo(str, (LiveFullInfoData) data.getModel(), data.getJson());
                return;
            } else {
                preloader.addTaskCallback(str2, new Preloader.IResult() { // from class: com.youku.live.livesdk.widgets.container.pagable.LiveContentView.4
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.livesdk.preloader.Preloader.IResult
                    public void onResult(Preloader.IData iData) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1469910767")) {
                            ipChange2.ipc$dispatch("-1469910767", new Object[]{this, iData});
                        } else {
                            LiveContentView.this.updateWithLiveFullInfo(str, (LiveFullInfoData) iData.getModel(), iData.getJson());
                        }
                    }
                });
                return;
            }
        }
        onRoomChange(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRoomChange(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "258196010")) {
            ipChange.ipc$dispatch("258196010", new Object[]{this, str});
            return;
        }
        if (getYoukuLivePerformance() != null) {
            getYoukuLivePerformance().setFullInfoStart();
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new AnonymousClass5(str));
    }
}
