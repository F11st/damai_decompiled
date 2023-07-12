package com.youku.live.livesdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.android.nav.Nav;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import com.youku.arch.v3.data.Constants;
import com.youku.asyncview.AsyncViewPreLoader;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.live.arch.utils.AppUtils;
import com.youku.live.arch.utils.CDNHelper;
import com.youku.live.arch.utils.ObjectUtils;
import com.youku.live.dago.liveplayback.widget.AlixLivePlayback;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IConfig;
import com.youku.live.dsl.config.IConfigImp;
import com.youku.live.dsl.config.IDynamicConfig;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.dsl.differences.IYoukuSupport64;
import com.youku.live.dsl.initialization.IInitializationMC;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.log.IRemoteLog;
import com.youku.live.dsl.log.PerfLogUtils;
import com.youku.live.dsl.network.IRequest;
import com.youku.live.dsl.network.IRequestCallback;
import com.youku.live.dsl.network.IRequestFactory;
import com.youku.live.dsl.network.IResponse;
import com.youku.live.dsl.pages.ILaifengManagerInterface;
import com.youku.live.dsl.pages.IYoukuLiveFactoryInterface;
import com.youku.live.dsl.pages.IYoukuLiveInterface;
import com.youku.live.dsl.pages.IYoukuLiveMethodBridge;
import com.youku.live.dsl.pages.IYoukuLiveMethodCallback;
import com.youku.live.dsl.usertrack.IUserTracker;
import com.youku.live.livesdk.config.PageConfig;
import com.youku.live.livesdk.config.page.RequiresSDK;
import com.youku.live.livesdk.constants.DagoDataCenterConstants;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.constants.SchemaConstants;
import com.youku.live.livesdk.model.mtop.LiveFullInfoV4;
import com.youku.live.livesdk.model.mtop.RecRoomLivingV1;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.RecRoomLivingGetData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.SimpleWidgetDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.TemplateDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.UserInfo;
import com.youku.live.livesdk.monitor.FirstRoomAlarm;
import com.youku.live.livesdk.monitor.page.LivePageMonitorDomain;
import com.youku.live.livesdk.monitor.page.LivePageTaskHolder;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformanceManager;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.live.livesdk.preloader.YKPrefReporter;
import com.youku.live.livesdk.pretch.LiveSdkPreloader;
import com.youku.live.livesdk.util.DebugHelp;
import com.youku.live.livesdk.util.DebugViewHelper;
import com.youku.live.livesdk.util.LivePerfUtils;
import com.youku.live.livesdk.util.LiveTimeUtils;
import com.youku.live.livesdk.util.StringUtil;
import com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider;
import com.youku.live.livesdk.widgets.container.pagable.LiveContentView;
import com.youku.live.livesdk.widgets.container.pagable.PagableConfigure;
import com.youku.live.livesdk.widgets.container.pagable.PagableRecyclerViewProvider;
import com.youku.live.livesdk.widgets.container.pager.PagableDataProvider;
import com.youku.live.livesdk.widgets.container.pager.model.LiveQuickPlayModel;
import com.youku.live.livesdk.widgets.container.pager.model.NewPlayInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.widgets.helper.Accessor;
import com.youku.live.livesdk.widgets.helper.BizConfigHelper;
import com.youku.live.livesdk.widgets.helper.Caller;
import com.youku.live.livesdk.widgets.helper.ConfigHelper;
import com.youku.live.livesdk.widgets.helper.MtopDataHelper;
import com.youku.live.livesdk.wkit.ILiveActivityActions;
import com.youku.live.livesdk.wkit.dialog.DagoLiveDialog;
import com.youku.live.livesdk.wkit.utils.BlackUtil;
import com.youku.live.livesdk.wkit.utils.ConfigUtil;
import com.youku.live.livesdk.wkit.utils.LiveStatusBarUtil;
import com.youku.live.livesdk.wkit.utils.LiveWXAnalyzerDelegate;
import com.youku.live.livesdk.wkit.utils.PipBroadcastReceiver;
import com.youku.live.livesdk.wkit.utils.SdkChannel;
import com.youku.live.livesdk.wkit.utils.YKLToastUtil;
import com.youku.live.livesdk.wkit.view.LoadingRetryView;
import com.youku.live.livesdk.wkit.view.keyboard.KeyboardHeightObserver;
import com.youku.live.livesdk.wkit.view.keyboard.KeyboardHeightProvider;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.WidgetActivity;
import com.youku.live.widgets.WidgetEngineContext;
import com.youku.live.widgets.model.template.TemplateModel;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.monitor.PerfMonitorImp;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IPageableController;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.activity.IActivityStateReader;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import tb.m80;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LiveActivity extends WidgetActivity implements IYoukuLiveMethodBridge, KeyboardHeightObserver, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DAGO_SLID_ROOM = "slidingRoom";
    private static final String ENABLE = "1";
    public static final String JUMP_FROM_NAV = "jump_from_nav";
    public static final String JUMP_SOURCE_KEY = "jump_source_from";
    private static final String LOG_TAG = "LiveActivity";
    public static final int PIP_TYPE_JUMP_APP = 3;
    public static final int PIP_TYPE_JUMP_BACK = 1;
    public static final int PIP_TYPE_JUMP_INNER_H5 = 2;
    public static final int PIP_TYPE_JUMP_MINI_APP = 4;
    public static final int PIP_TYPE_NO = -1;
    private static final String SAFE_AREA_TOP_PIXEL = "safeAreaTopPx";
    private static final String SAFE_AREA_TOP_WEEX = "safeAreaTopWx";
    private static final String TAG = "LiveActivity";
    private static AtomicLong mInstanceIdMaker = null;
    private static boolean sIsColdStart = true;
    private volatile String currentPageLiveId;
    private boolean isInPip;
    protected String mActorBizType;
    private Map<String, String> mBundleParams;
    private Object mErrorPIPQuitTask;
    private KeyboardHeightProvider mKeyboardHeightProvider;
    private LoadingRetryView mLoadingRetryView;
    private ILog mLogger;
    private String mOnePlayId;
    private Map<Integer, String> mOnePlayIdCache;
    private Configuration mPIPConfiguration;
    private PagableDataProvider mPagableDataProvider;
    private PagableViewProvider<SwitchItemModel, LiveContentView> mPagableViewProvider;
    private IPerfMonitor mPagePerfMonitor;
    public ActivityLifecycleState mState;
    private long mTimestampForOnCreateBegin;
    private WidgetEngineContext mWidgetEngineContext;
    private LiveWXAnalyzerDelegate mWxAnalyzerDelegate;
    private IYoukuLiveInterface mYoukuLiveInstance;
    private IYoukuLiveMethodBridge mYoukuLiveMethodBridge;
    private View mYoukuLiveView;
    private Object pvObject;
    private boolean supportBackToMainApp;
    private IUserTracker userTrackerInstance;
    private String instTag = null;
    private Uri pageUri = null;
    private String pageUrl = null;
    private String roomLayout = null;
    private int mKeyboardHeight = 0;
    private ILiveActivityActions mILiveActivityActions = null;
    private boolean onStopCalled = false;
    private PipBroadcastReceiver mPipBroadcastReceiver = null;
    private int mPipType = -1;
    public boolean isFinishByUser = true;
    public boolean mIsFromNav = false;
    private int mConfigurationOrientation = 1;
    private boolean mIsPortraitLocked = false;
    private List<String> mLockerList = new LinkedList();
    private boolean isColdStart = false;
    private boolean matchLayoutCache = false;
    private PagableViewProvider.PagingContentCreator<LiveContentView> mPagingContentCreator = new PagableViewProvider.PagingContentCreator<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.13
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.PagingContentCreator
        public LiveContentView createPageItem() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-521577378")) {
                return (LiveContentView) ipChange.ipc$dispatch("-521577378", new Object[]{this});
            }
            PerfLogUtils.log("LiveActivity.createPageItem start ...");
            LiveContentView liveContentView = new LiveContentView(LiveActivity.this);
            liveContentView.mPagePerfMonitor = LiveActivity.this.mPagePerfMonitor;
            liveContentView.setEngineContext(LiveActivity.this.mWidgetEngineContext);
            if (LiveActivity.this.mTimestampForOnCreateBegin != 0) {
                liveContentView.getInstance().getPerfMonitor().perfBegin(LiveActivity.this.mTimestampForOnCreateBegin);
                LiveActivity.this.mTimestampForOnCreateBegin = 0L;
            } else {
                liveContentView.getInstance().getPerfMonitor().perfBegin(0L);
            }
            liveContentView.getInstance().setActivityLifecycleState(LiveActivity.this.mState);
            Log.d("SlideOp", "live content created:" + liveContentView.hashCode());
            liveContentView.putOptions(LiveActivity.this.getRenderParams());
            LiveActivity.this.getRenderParams().remove("liveRequestSessionId");
            LiveActivity.this.getRenderParams().remove("playControlRequireId");
            return liveContentView;
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.PagingContentCreator
        public void releasePageItem(LiveContentView liveContentView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-229062869")) {
                ipChange.ipc$dispatch("-229062869", new Object[]{this, liveContentView});
            } else if (liveContentView != null) {
                liveContentView.didDisappear();
                liveContentView.getInstance().didDisappear();
                liveContentView.getInstance().didDeactive();
                liveContentView.getInstance().destroy();
                liveContentView.release();
            }
        }
    };
    private boolean mIsKeyRead = false;
    private boolean mIsFirstRoom = true;
    private boolean ismIsFirstRoomVisible = true;
    private PagableViewProvider.OnPagingLifecycleListener<SwitchItemModel, LiveContentView> mOnPagingLifectycleListener = new PagableViewProvider.OnPagingLifecycleListener<SwitchItemModel, LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.14
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageDeinit(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2017538504")) {
                ipChange.ipc$dispatch("2017538504", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView});
                return;
            }
            Log.d("LiveActivity", "onPageDeinit " + i + AVFSCacheConstants.COMMA_SEP + liveContentView.hashCode());
            LiveActivity.this.perfMonitorBegin("onPageDeinit" + i);
            liveContentView.getInstance().putData(LiveRoomConstants.DATA_ROOM_FINISH, Boolean.TRUE);
            LiveActivity.this.perfMonitorEndDisable("onPageDeinit" + i, "onPageDeinit " + i + AVFSCacheConstants.COMMA_SEP + liveContentView.getClass().getName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(liveContentView.hashCode()));
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageIdleChanged(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1005928607")) {
                ipChange.ipc$dispatch("-1005928607", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView, Boolean.valueOf(z)});
                return;
            }
            if (z) {
                LiveActivity liveActivity = LiveActivity.this;
                DebugViewHelper.updateRoomScrollMsg(liveActivity, switchItemModel.liveQuickPlay, liveActivity.mIsFirstRoom ? LiveActivity.this.getRenderParams().get("source_from") : "room_scroll");
            }
            Log.d("LiveActivity", "onPageIdleChanged " + i + AVFSCacheConstants.COMMA_SEP + Boolean.toString(z) + AVFSCacheConstants.COMMA_SEP + liveContentView.hashCode());
            LiveActivity liveActivity2 = LiveActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append("onPageIdleChanged");
            sb.append(i);
            sb.append(z);
            liveActivity2.perfMonitorBegin(sb.toString());
            liveContentView.activate(z);
            if (z) {
                liveContentView.getInstance().didActive();
                LiveActivity.this.perfMonitorEndDisable("onPageIdleChanged" + i + z, "onPageIdleChanged " + i + AVFSCacheConstants.COMMA_SEP + Boolean.toString(z) + AVFSCacheConstants.COMMA_SEP + liveContentView.getClass().getName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(liveContentView.hashCode()));
            } else {
                liveContentView.getInstance().didDeactive();
                LiveActivity.this.perfMonitorEndDisable("onPageIdleChanged" + i + z, "onPageIdleChanged " + i + AVFSCacheConstants.COMMA_SEP + Boolean.toString(z) + AVFSCacheConstants.COMMA_SEP + liveContentView.getClass().getName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(liveContentView.hashCode()));
            }
            PerfLogUtils.log("LiveActivity.onPageIdleChanged, idle = " + z);
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageInit(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1720822727")) {
                ipChange.ipc$dispatch("1720822727", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView});
                return;
            }
            PerfLogUtils.log("LiveActivity.onPageInit ...");
            Log.d("LiveActivity", "onPageInit " + i + AVFSCacheConstants.COMMA_SEP + liveContentView.hashCode());
            boolean z = LiveActivity.this.mIsFirstRoom;
            LiveActivity.this.mIsFirstRoom = false;
            if (z) {
                ((WidgetActivity) LiveActivity.this).root.postDelayed(new Runnable() { // from class: com.youku.live.livesdk.LiveActivity.14.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1683111839")) {
                            ipChange2.ipc$dispatch("-1683111839", new Object[]{this});
                        } else {
                            ((WidgetActivity) LiveActivity.this).root.setBackgroundColor(0);
                        }
                    }
                }, 100L);
            } else if (TextUtils.isEmpty((String) LiveActivity.this.mOnePlayIdCache.get(Integer.valueOf(i)))) {
                LiveActivity.this.mOnePlayIdCache.put(Integer.valueOf(i), YKPrefReporter.genOnePlayId(System.currentTimeMillis()));
            }
            Log.d("YKPrefReporter", "Live init Page SessiondId = " + ((String) LiveActivity.this.mOnePlayIdCache.get(Integer.valueOf(i))) + " " + i);
            LiveActivity liveActivity = LiveActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append("onPageInit");
            sb.append(i);
            liveActivity.perfMonitorBegin(sb.toString());
            liveContentView.getInstance().asyncPutData("DATA_KEY_LAIFENG_KEYBOARD_SHOW", Boolean.FALSE);
            if (LiveActivity.this.mIsKeyRead) {
                HashMap hashMap = new HashMap();
                hashMap.put("is_key_read", "true");
                liveContentView.putOptions(hashMap);
            }
            HashMap hashMap2 = new HashMap();
            if (z) {
                hashMap2.put("isFirstLiveRoom", "1");
                hashMap2.put("matchLayoutCache", LiveActivity.this.matchLayoutCache() ? "1" : "0");
            } else {
                hashMap2.put("isFirstLiveRoom", "0");
                hashMap2.put("matchLayoutCache", "0");
            }
            if (LiveActivity.this.isColdStart()) {
                hashMap2.put("isColdStart", "1");
            } else {
                hashMap2.put("isColdStart", "0");
            }
            if (!z) {
                hashMap2.put("onePlayId", LiveActivity.this.mOnePlayIdCache.get(Integer.valueOf(i)));
            }
            liveContentView.putOptions(hashMap2);
            if (switchItemModel != null) {
                liveContentView.setIsFirstRoom(z);
                liveContentView.setIsFirstEnter(LiveActivity.this.isColdStart());
                liveContentView.updateWithRoomInfo(i, switchItemModel);
            }
            LiveActivity.this.mIsKeyRead = true;
            LiveActivity.this.perfMonitorEndDisable("onPageInit" + i, "onPageDeinit " + i + AVFSCacheConstants.COMMA_SEP + liveContentView.getClass().getName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(liveContentView.hashCode()));
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageInvisible(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1609606848")) {
                ipChange.ipc$dispatch("-1609606848", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView});
                return;
            }
            DebugViewHelper.clearDebugView(LiveActivity.this);
            LiveActivity.this.perfMonitorBegin("onPageInvisible" + i);
            Log.d("LiveActivity", "onPageInvisible " + i + AVFSCacheConstants.COMMA_SEP + liveContentView.hashCode());
            LiveTimeUtils.pageChanged = true;
            liveContentView.getInstance().didDisappear();
            liveContentView.didDisappear();
            LiveActivity.this.perfMonitorEndDisable("onPageInvisible" + i, "onPageInvisible " + i + AVFSCacheConstants.COMMA_SEP + liveContentView.getClass().getName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(liveContentView.hashCode()));
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageVisible(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView) {
            NewPlayInfoModel newPlayInfoModel;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1800366587")) {
                ipChange.ipc$dispatch("-1800366587", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView});
                return;
            }
            LiveActivity.this.perfMonitorBegin("onPageVisible" + i);
            Log.d("LiveActivity", "onPageVisible " + i + AVFSCacheConstants.COMMA_SEP + liveContentView.hashCode());
            String string = ((IDynamicConfig) Dsl.getService(IDynamicConfig.class)).getString("device", IDynamicConfig.KEY_DEVICE_SCORE, "0");
            if (!LiveActivity.this.ismIsFirstRoomVisible) {
                String str = (String) LiveActivity.this.mOnePlayIdCache.get(Integer.valueOf(i));
                Log.d("YKPrefReporter", "Live Page SessiondId = " + str + " curId = " + LiveActivity.this.getRenderParams().get("onePlayId") + " " + i);
                YKPrefReporter.getInstance().getPlayBySessionId(str).setRoomSwitch("1");
                YKPrefReporter.getInstance().getPlayBySessionId(str).setOnCreateHasFullInfo("1");
                YKPrefReporter.getInstance().getPlayBySessionId(str).setNav("1");
                YKPrefReporter.getInstance().getPlayBySessionId(str).setLiveDeviceScore(string);
                if (switchItemModel != null) {
                    YKPrefReporter.getInstance().getPlayBySessionId(str).setLiveRoomBizType(String.valueOf(switchItemModel._biztype));
                    LiveQuickPlayModel liveQuickPlayModel = switchItemModel.liveQuickPlay;
                    if (liveQuickPlayModel != null && (newPlayInfoModel = liveQuickPlayModel.newPlayInfo) != null && newPlayInfoModel.playInfo != null) {
                        YKPrefReporter.getInstance().getPlayBySessionId(str).setHasPlayinfo("1");
                    } else {
                        YKPrefReporter.getInstance().getPlayBySessionId(str).setHasPlayinfo("0");
                    }
                }
                YKPrefReporter.getInstance().getPlayBySessionId(str).setClickTime(System.currentTimeMillis());
            } else {
                LiveActivity.this.ismIsFirstRoomVisible = false;
                YKPrefReporter.getInstance().getPlayBySessionId(LiveActivity.this.mOnePlayId).setLiveDeviceScore(string);
                if (switchItemModel != null) {
                    YKPrefReporter.getInstance().getPlayBySessionId(LiveActivity.this.mOnePlayId).setLiveRoomBizType(String.valueOf(switchItemModel._biztype));
                }
            }
            LiveActivity.this.mILiveActivityActions = null;
            liveContentView.didAppear();
            liveContentView.getInstance().didAppear();
            LiveActivity.this.perfMonitorEndDisable("onPageVisible" + i, "onPageDeinit " + i + AVFSCacheConstants.COMMA_SEP + liveContentView.getClass().getName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(liveContentView.hashCode()));
        }
    };
    private boolean hasReleaseListOfContentView = false;
    private boolean mIsLaifengSchema = false;
    private boolean mSupportQuitBlocker = false;
    private volatile boolean isSkip = false;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: com.youku.live.livesdk.LiveActivity.34
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2030252242")) {
                ipChange.ipc$dispatch("-2030252242", new Object[]{this, context, intent});
            } else if ("com.youku.action.Coin_Recharge_Success".equals(intent.getAction())) {
                intent.getStringExtra("pageKey");
                intent.getStringExtra("refer");
                String stringExtra = intent.getStringExtra("totalTagPrice");
                String str = "youku://laifeng/exchange?type=1";
                if (!TextUtils.isEmpty(stringExtra)) {
                    str = "youku://laifeng/exchange?type=1&ucoin=" + stringExtra;
                }
                Nav.from(LiveActivity.this).toUri(str);
            }
        }
    };

    private boolean abtestOpenLayoutPreParseRender() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-623239649") ? ((Boolean) ipChange.ipc$dispatch("-623239649", new Object[]{this})).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("closePauseFinalRelease", true);
    }

    private void animClear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431936634")) {
            ipChange.ipc$dispatch("-1431936634", new Object[]{this});
            return;
        }
        LoadingRetryView loadingRetryView = this.mLoadingRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.setBackListener(null);
            loadingRetryView.setRetryListener(null);
            loadingRetryView.setVisibility(4);
        }
        animHideRetry();
        animStopLoading();
    }

    private void animHideRetry() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720683949")) {
            ipChange.ipc$dispatch("720683949", new Object[]{this});
            return;
        }
        LoadingRetryView loadingRetryView = this.mLoadingRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.hideRetry();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animShowRetry() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-693512600")) {
            ipChange.ipc$dispatch("-693512600", new Object[]{this});
            return;
        }
        if (this.mLoadingRetryView == null) {
            initLoadingView();
        }
        LoadingRetryView loadingRetryView = this.mLoadingRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.showRetry();
        }
        animStopLoading();
    }

    private void animStartLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052174717")) {
            ipChange.ipc$dispatch("1052174717", new Object[]{this});
            return;
        }
        if (this.mLoadingRetryView == null) {
            initLoadingView();
        }
        LoadingRetryView loadingRetryView = this.mLoadingRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.startLoading();
        }
        animHideRetry();
    }

    private void animStopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1321193305")) {
            ipChange.ipc$dispatch("1321193305", new Object[]{this});
            return;
        }
        LoadingRetryView loadingRetryView = this.mLoadingRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.stopLoading();
        }
    }

    private void backButtonClear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1418585938")) {
            ipChange.ipc$dispatch("-1418585938", new Object[]{this});
            return;
        }
        LoadingRetryView loadingRetryView = this.mLoadingRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.setBackButtonVisible(false);
        }
    }

    private void checkSupportsBackToMainApp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104499534")) {
            ipChange.ipc$dispatch("2104499534", new Object[]{this});
        } else {
            this.supportBackToMainApp = true;
        }
    }

    private void cleanPreLayout() {
        AsyncViewPreLoader asyncViewPreLoader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909663388")) {
            ipChange.ipc$dispatch("-909663388", new Object[]{this});
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread() || (asyncViewPreLoader = AsyncViewPreLoader.getAsyncViewPreLoader(this)) == null) {
        } else {
            asyncViewPreLoader.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dip2px(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "29876605") ? ((Integer) ipChange.ipc$dispatch("29876605", new Object[]{this, Integer.valueOf(i)})).intValue() : (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void finalRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1851527497")) {
            ipChange.ipc$dispatch("-1851527497", new Object[]{this});
        } else {
            finalReleaseListOfContentView();
        }
    }

    private void finalReleaseListOfContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636610678")) {
            ipChange.ipc$dispatch("-636610678", new Object[]{this});
        } else if (this.hasReleaseListOfContentView) {
        } else {
            this.hasReleaseListOfContentView = true;
            String str = getRenderParams().get("liveRequestSessionId");
            if (!TextUtils.isEmpty(str)) {
                Preloader.getInstance().remove(str);
            }
            if (this.mPagableViewProvider != null) {
                final boolean z = ConfigHelper.getBoolean("live_platform_issues", "issue29403991_fix_anr_on_finished", true);
                this.mPagableViewProvider.notifyAllViews(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.18
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.livesdk.widgets.helper.Accessor
                    public void onAccess(LiveContentView liveContentView) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1421991540")) {
                            ipChange2.ipc$dispatch("-1421991540", new Object[]{this, liveContentView});
                            return;
                        }
                        if (z) {
                            liveContentView.getInstance().enableRecycleCache(false);
                        }
                        liveContentView.getInstance().putConfig("CONFIG_ACTIVE_SKIP_APPEAR_LEVEL", Boolean.TRUE);
                        liveContentView.finalDidDisappear();
                        liveContentView.getInstance().didDisappear();
                        liveContentView.activate(false);
                        liveContentView.getInstance().didDeactive();
                        liveContentView.getInstance().destroy();
                    }
                });
            }
            PagableDataProvider pagableDataProvider = this.mPagableDataProvider;
            if (pagableDataProvider != null) {
                pagableDataProvider.destroy();
            }
        }
    }

    private static String generateInstanceId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910901901")) {
            return (String) ipChange.ipc$dispatch("-1910901901", new Object[]{str});
        }
        if (mInstanceIdMaker == null) {
            synchronized (LiveActivity.class) {
                if (mInstanceIdMaker == null) {
                    mInstanceIdMaker = new AtomicLong(0L);
                }
            }
        }
        long andIncrement = mInstanceIdMaker.getAndIncrement();
        return str + "$" + andIncrement;
    }

    private static String getInstHashCode(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849493831")) {
            return (String) ipChange.ipc$dispatch("-1849493831", new Object[]{obj});
        }
        return obj.getClass().getSimpleName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(obj.hashCode());
    }

    private String getLivePageSource(String str) {
        String substring;
        int lastIndexOf;
        int lastIndexOf2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146537056")) {
            return (String) ipChange.ipc$dispatch("-146537056", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf(".") > 0) {
            str = str.substring(0, str.lastIndexOf("."));
        }
        int lastIndexOf3 = str.lastIndexOf(".");
        return (lastIndexOf3 <= 0 || (lastIndexOf = (substring = str.substring(lastIndexOf3 + 1)).lastIndexOf(JSMethod.NOT_SET)) <= 0 || !StringUtil.isNumString(substring.substring(lastIndexOf + 1)) || (lastIndexOf2 = str.lastIndexOf(JSMethod.NOT_SET)) <= 0) ? str : str.substring(0, lastIndexOf2);
    }

    private ILog getLogger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1038046310")) {
            return (ILog) ipChange.ipc$dispatch("1038046310", new Object[]{this});
        }
        if (this.mLogger == null) {
            this.mLogger = (ILog) Dsl.getService(IRemoteLog.class);
        }
        return this.mLogger;
    }

    private IPerfMonitor getPagePerfMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1623272447")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-1623272447", new Object[]{this});
        }
        if (this.mPagePerfMonitor == null) {
            synchronized (this) {
                if (this.mPagePerfMonitor == null) {
                    this.mPagePerfMonitor = PerfMonitorImp.createInstance("LiveActivity", this);
                }
            }
        }
        return this.mPagePerfMonitor;
    }

    private Object getPvObject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048691765")) {
            return ipChange.ipc$dispatch("-1048691765", new Object[]{this});
        }
        if (this.pvObject == null) {
            synchronized (this) {
                if (this.pvObject == null) {
                    this.pvObject = new Object();
                }
            }
        }
        return this.pvObject;
    }

    private int getScreenWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1117013815")) {
            return ((Integer) ipChange.ipc$dispatch("1117013815", new Object[]{this})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getSystemService(v.ATTACH_MODE_WINDOW);
        if (windowManager != null) {
            Display.getMetrics(windowManager.getDefaultDisplay(), displayMetrics);
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        }
        return 0;
    }

    private int getStatusBarHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1762650473") ? ((Integer) ipChange.ipc$dispatch("1762650473", new Object[]{this})).intValue() : getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    private IUserTracker getUserTracker() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2122361682")) {
            return (IUserTracker) ipChange.ipc$dispatch("-2122361682", new Object[]{this});
        }
        IUserTracker iUserTracker = this.userTrackerInstance;
        if (iUserTracker != null) {
            return iUserTracker;
        }
        IUserTracker iUserTracker2 = (IUserTracker) Dsl.getService(IUserTracker.class);
        this.userTrackerInstance = iUserTracker2;
        if (iUserTracker2 == null) {
            AppMonitor.Alarm.commitFail("YoukuLiveAlarm", "DslUserTracker", "1000", "empty user tacker instance");
            this.userTrackerInstance = new IUserTracker() { // from class: com.youku.live.livesdk.LiveActivity.33
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public Map<String, String> getLastClickParams() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-1997769631") ? (Map) ipChange2.ipc$dispatch("-1997769631", new Object[]{this}) : new HashMap();
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void pageAppear(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-667752506")) {
                        ipChange2.ipc$dispatch("-667752506", new Object[]{this, obj});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void pageAppearDonotSkip(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1770509941")) {
                        ipChange2.ipc$dispatch("1770509941", new Object[]{this, obj});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void pageDisAppear(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-781304380")) {
                        ipChange2.ipc$dispatch("-781304380", new Object[]{this, obj});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void setLastClickParams(Map<String, String> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-10853555")) {
                        ipChange2.ipc$dispatch("-10853555", new Object[]{this, map});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void skipPage(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-141541220")) {
                        ipChange2.ipc$dispatch("-141541220", new Object[]{this, obj});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void startSessionForUt(Activity activity, String str, String str2, Map<String, String> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-759578665")) {
                        ipChange2.ipc$dispatch("-759578665", new Object[]{this, activity, str, str2, map});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void track4Click(String str, String str2, Map<String, String> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1305688020")) {
                        ipChange2.ipc$dispatch("1305688020", new Object[]{this, str, str2, map});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void track4Click(String str, String str2, String... strArr) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-633609746")) {
                        ipChange2.ipc$dispatch("-633609746", new Object[]{this, str, str2, strArr});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void track4Show(String str, String str2, Map<String, String> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1557884503")) {
                        ipChange2.ipc$dispatch("-1557884503", new Object[]{this, str, str2, map});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void trackCustom(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "304493838")) {
                        ipChange2.ipc$dispatch("304493838", new Object[]{this, str, Integer.valueOf(i), str2, str3, str4, map});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void trackCustom(String str, String str2, Map<String, String> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-996494863")) {
                        ipChange2.ipc$dispatch("-996494863", new Object[]{this, str, str2, map});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void updateNextPageUtParam(String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "716293987")) {
                        ipChange2.ipc$dispatch("716293987", new Object[]{this, str});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void updateNextPageUtParam(Map<String, String> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2071383180")) {
                        ipChange2.ipc$dispatch("2071383180", new Object[]{this, map});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void updatePageName(Object obj, String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-682794479")) {
                        ipChange2.ipc$dispatch("-682794479", new Object[]{this, obj, str});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void updatePageProperties(Object obj, Map<String, String> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1571509254")) {
                        ipChange2.ipc$dispatch("1571509254", new Object[]{this, obj, map});
                    }
                }

                @Override // com.youku.live.dsl.usertrack.IUserTracker
                public void updatePageUrl(Object obj, Uri uri) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-577440986")) {
                        ipChange2.ipc$dispatch("-577440986", new Object[]{this, obj, uri});
                    }
                }
            };
        }
        return this.userTrackerInstance;
    }

    private void gobackToApplication() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943296380")) {
            ipChange.ipc$dispatch("1943296380", new Object[]{this});
        } else if (this.supportBackToMainApp && this.isFinishByUser && AppUtils.checkPackageInfo(this, getPackageName())) {
            try {
                AppUtils.openPackage(this, getPackageName());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void handlePlayerMode(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1487917054")) {
            ipChange.ipc$dispatch("1487917054", new Object[]{this, liveFullInfoData});
            return;
        }
        try {
            for (SimpleWidgetDTO simpleWidgetDTO : liveFullInfoData.widgets.widgetList) {
                if (PluginName.PLAYER.equals(simpleWidgetDTO.name)) {
                    getInstance().putData("LiveFullInfo.Widget.Player.TrustData", simpleWidgetDTO.trustData);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    private boolean hasLastPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-295390425") ? ((Boolean) ipChange.ipc$dispatch("-295390425", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.currentPageLiveId);
    }

    @TargetApi(17)
    public static boolean hasSoftKeys(WindowManager windowManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604216490")) {
            return ((Boolean) ipChange.ipc$dispatch("604216490", new Object[]{windowManager})).booleanValue();
        }
        android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getRealMetrics(defaultDisplay, displayMetrics);
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        Display.getMetrics(defaultDisplay, displayMetrics2);
        return i2 - com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2) > 0 || i - com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2) > 0;
    }

    private void initLoadingView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1317362577")) {
            ipChange.ipc$dispatch("1317362577", new Object[]{this});
        } else if (this.root != null) {
            LoadingRetryView loadingRetryView = new LoadingRetryView(this);
            this.mLoadingRetryView = loadingRetryView;
            this.root.addView(loadingRetryView, new ViewGroup.LayoutParams(-1, -1));
            this.mLoadingRetryView.setBackListener(new View.OnClickListener() { // from class: com.youku.live.livesdk.LiveActivity.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1927533451")) {
                        ipChange2.ipc$dispatch("1927533451", new Object[]{this, view});
                    } else {
                        LiveActivity.this.onBackClick();
                    }
                }
            });
            this.mLoadingRetryView.setRetryListener(new View.OnClickListener() { // from class: com.youku.live.livesdk.LiveActivity.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-256143476")) {
                        ipChange2.ipc$dispatch("-256143476", new Object[]{this, view});
                    } else {
                        LiveActivity.this.onRetryClick();
                    }
                }
            });
        }
    }

    private void innerInitAsyncViewPreLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1510252249")) {
            ipChange.ipc$dispatch("-1510252249", new Object[]{this});
        } else if (LivePerfUtils.supportAsyncViewPreLoader()) {
            AsyncViewPreLoader registerAsyncViewPreLoaderService = AsyncViewPreLoader.registerAsyncViewPreLoaderService(this);
            registerAsyncViewPreLoaderService.setInflateInterceptor(new AsyncViewPreLoader.InflateInterceptor() { // from class: com.youku.live.livesdk.LiveActivity.35
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.asyncview.AsyncViewPreLoader.InflateInterceptor
                public View inflate(AsyncViewPreLoader asyncViewPreLoader, int i, @Nullable ViewGroup viewGroup, boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2120501983")) {
                        return (View) ipChange2.ipc$dispatch("2120501983", new Object[]{this, asyncViewPreLoader, Integer.valueOf(i), viewGroup, Boolean.valueOf(z)});
                    }
                    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                        return null;
                    }
                    View asyncCacheView = asyncViewPreLoader.getAsyncCacheView(i);
                    if (DebugHelp.isDebugBuild()) {
                        Log.e("LiveActivity", "inflate: layout name = " + asyncViewPreLoader.getContext().getResources().getResourceName(i) + ",view = " + asyncCacheView);
                    }
                    if (asyncCacheView == null || z) {
                        return null;
                    }
                    return asyncCacheView;
                }
            });
            int[][] iArr = null;
            try {
                iArr = ((ILaifengManagerInterface) Dsl.getService(ILaifengManagerInterface.class)).requestPreloadLayoutIds();
            } catch (Exception e) {
                e.printStackTrace();
            }
            FrameLayout frameLayout = new FrameLayout(this);
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            for (int[] iArr2 : iArr) {
                registerAsyncViewPreLoaderService.asyncPreLoaderView(iArr2[0], frameLayout, iArr2[1]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isColdStart() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1536105522") ? ((Boolean) ipChange.ipc$dispatch("1536105522", new Object[]{this})).booleanValue() : this.isColdStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOpenImmerse() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1797663986")) {
            return ((Boolean) ipChange.ipc$dispatch("1797663986", new Object[]{this})).booleanValue();
        }
        MyLog.w("LiveActivity", "isOpenImmerse: " + Build.getMODEL());
        return "1".equalsIgnoreCase(((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", IConfigImp.KEY_LOCALCONFIG_IMMERSE, "0")) && !BlackUtil.isBlack();
    }

    private boolean isPortraitPagableLocked() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1721573455") ? ((Boolean) ipChange.ipc$dispatch("-1721573455", new Object[]{this})).booleanValue() : this.mConfigurationOrientation != 1 || this.mLockerList.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isProcessActivityPip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474114743")) {
            return ((Boolean) ipChange.ipc$dispatch("-1474114743", new Object[]{this})).booleanValue();
        }
        ILiveActivityActions iLiveActivityActions = this.mILiveActivityActions;
        if (iLiveActivityActions == null || !iLiveActivityActions.isEnterPipMode()) {
            return false;
        }
        this.mILiveActivityActions.onBackPressed();
        return true;
    }

    private boolean isSameWithLastPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175769723")) {
            return ((Boolean) ipChange.ipc$dispatch("175769723", new Object[]{this, str})).booleanValue();
        }
        if (this.currentPageLiveId != null) {
            return this.currentPageLiveId.equals(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean matchLayoutCache() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "538045497") ? ((Boolean) ipChange.ipc$dispatch("538045497", new Object[]{this})).booleanValue() : this.matchLayoutCache;
    }

    private void muteActiveContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944907384")) {
            ipChange.ipc$dispatch("-1944907384", new Object[]{this});
            return;
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyActiveView(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.20
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-702227549")) {
                        ipChange2.ipc$dispatch("-702227549", new Object[]{this, liveContentView});
                        return;
                    }
                    IWidget findWidgetById = liveContentView.getInstance().findWidgetById(AlixLivePlayback.WIDGET_NAME);
                    if (findWidgetById instanceof ICall) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("mute", Boolean.TRUE);
                        ((ICall) findWidgetById).call(liveContentView.getInstance(), "mutePlayer", hashMap, null, null);
                    }
                }
            });
        }
    }

    private boolean ogcPreprocess(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "369811955")) {
            return ((Boolean) ipChange.ipc$dispatch("369811955", new Object[]{this, liveFullInfoData})).booleanValue();
        }
        IYoukuLiveFactoryInterface iYoukuLiveFactoryInterface = (IYoukuLiveFactoryInterface) Dsl.getService(IYoukuLiveFactoryInterface.class);
        if (iYoukuLiveFactoryInterface != null) {
            View createYoukuLiveView = iYoukuLiveFactoryInterface.createYoukuLiveView(this, liveFullInfoData);
            IYoukuLiveInterface iYoukuLiveInterface = (IYoukuLiveInterface) createYoukuLiveView;
            if (iYoukuLiveInterface != null && createYoukuLiveView != null) {
                iYoukuLiveInterface.setApplication(getApplication());
                iYoukuLiveInterface.setActivity(this);
                iYoukuLiveInterface.onCreate(null);
                this.mYoukuLiveView = createYoukuLiveView;
                this.mYoukuLiveInstance = iYoukuLiveInterface;
                if (createYoukuLiveView instanceof IYoukuLiveMethodBridge) {
                    this.mYoukuLiveMethodBridge = (IYoukuLiveMethodBridge) createYoukuLiveView;
                }
                ViewGroup viewGroup = this.root;
                if (viewGroup != null) {
                    viewGroup.addView(createYoukuLiveView);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "819199360")) {
            ipChange.ipc$dispatch("819199360", new Object[]{this});
            return;
        }
        backButtonClear();
        animClear();
        finish();
    }

    private void onPauseFinalRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073077798")) {
            ipChange.ipc$dispatch("-1073077798", new Object[]{this});
        } else if (abtestOpenLayoutPreParseRender()) {
        } else {
            finalRelease();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRetryClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-841918807")) {
            ipChange.ipc$dispatch("-841918807", new Object[]{this});
            return;
        }
        Object data = getInstance().getData(DagoDataCenterConstants.DAGO_LIVE_ID);
        if (data instanceof String) {
            String str = (String) data;
            animStartLoading();
            requestLiveFullInfo(this.pageUrl, this.pageUri);
        }
    }

    private boolean parseParams(Uri uri, String str, Bundle bundle) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-576483600")) {
            return ((Boolean) ipChange.ipc$dispatch("-576483600", new Object[]{this, uri, str, bundle})).booleanValue();
        }
        perfMonitorBegin("onCreateParseParams");
        try {
            Map<String, String> lastClickParams = getUserTracker().getLastClickParams();
            String str2 = lastClickParams.get("spm-url");
            if (!TextUtils.isEmpty(str2)) {
                YKPrefReporter.getInstance().getPlayBySessionId(this.mOnePlayId).setLiveRoomSource(getLivePageSource(str2));
            }
            getRenderParams().putAll(lastClickParams);
        } catch (Throwable unused) {
        }
        if (uri != null) {
            getRenderParams().put(MtopJSBridge.MtopJSParam.PAGE_URL, uri.toString());
        }
        if (!getRenderParams().containsKey(LiveRoomConstants.PLAY_CLICK_TIME)) {
            Map<String, String> renderParams = getRenderParams();
            renderParams.put(LiveRoomConstants.PLAY_CLICK_TIME, "" + this.mTimestampForOnCreateBegin);
        }
        Map<String, String> renderParams2 = getRenderParams();
        renderParams2.put(LiveRoomConstants.PLAY_ACTIVITY_CREATE_TIME, this.mTimestampForOnCreateBegin + "");
        try {
            getRenderParams().putAll(getUserTracker().getLastClickParams());
        } catch (Throwable unused2) {
        }
        String str3 = null;
        if (uri != null) {
            String host = uri.getHost();
            String path = uri.getPath();
            if (TextUtils.isEmpty(host) || TextUtils.isEmpty(path) || !("v.laifeng.com".equals(host) || "room".equals(host))) {
                z = true;
            } else {
                String replace = path.replace("/", "");
                if (!"recommend".equals(replace)) {
                    str3 = replace;
                }
            }
            for (String str4 : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str4);
                getRenderParams().put(str4, queryParameter);
                if ("id".equals(str4)) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = queryParameter;
                    }
                } else if ("spm".equals(str4) && !TextUtils.isEmpty(queryParameter)) {
                    getRenderParams().put("spm-url", queryParameter);
                }
            }
            z2 = z;
        }
        if (bundle != null) {
            for (String str5 : bundle.keySet()) {
                Object obj = bundle.get(str5);
                if (obj instanceof String) {
                    String str6 = (String) obj;
                    getRenderParams().put(str5, str6);
                    if ("id".equals(str5)) {
                        if (TextUtils.isEmpty(str3)) {
                            str3 = str6;
                        }
                    } else if ("spm".equals(str5) && !TextUtils.isEmpty(str6)) {
                        getRenderParams().put("spm-url", str6);
                    }
                }
            }
        }
        if (uri != null) {
            String queryParameter2 = uri.getQueryParameter(SchemaConstants.SCHEMA_QUERY_DISPLAYGIFTTIPS);
            if (!TextUtils.isEmpty(queryParameter2)) {
                getRenderParams().put(SchemaConstants.SCHEMA_QUERY_DISPLAYGIFTTIPS, queryParameter2);
            }
        }
        if (str3 != null) {
            getInstance().putData(DagoDataCenterConstants.DAGO_LIVE_ID, str3);
            getRenderParams().put("id", str3);
            getRenderParams().put("liveId", str3);
            getRenderParams().put("liveid", str3);
            getRenderParams().put("roomid", str3);
            LiveTimeUtils.roomID = str3;
        }
        getRenderParams().put(SDKConstants.SDK_PAGE_INSTANCE_ID, generateInstanceId("LiveActivity"));
        if (uri != null) {
            String queryParameter3 = uri.getQueryParameter(SchemaConstants.SCHEMA_QUERY_WX_URL);
            if (!TextUtils.isEmpty(queryParameter3)) {
                getRenderParams().put(SDKConstants.SDK_DEBUG_STATIC_WEEX_BUNDLE, URLDecoder.decode(queryParameter3));
            }
            String queryParameter4 = uri.getQueryParameter(SchemaConstants.SCHEMA_QUERY_WX_BUNDLE);
            if (!TextUtils.isEmpty(queryParameter4)) {
                getRenderParams().put(SDKConstants.SDK_DEBUG_STATIC_WEEX_BUNDLE, URLDecoder.decode(queryParameter4));
            }
            String sdkVersion = ConfigUtil.getSdkVersion(getApplicationContext(), uri);
            if (!TextUtils.isEmpty(sdkVersion)) {
                getRenderParams().put(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION, URLDecoder.decode(sdkVersion));
            }
            String queryParameter5 = uri.getQueryParameter("layout");
            if (!TextUtils.isEmpty(queryParameter5)) {
                getRenderParams().put(SDKConstants.SDK_DEBUG_LAYOUT, URLDecoder.decode(queryParameter5));
            }
        } else {
            String useSdkVersionConfig = ConfigUtil.useSdkVersionConfig(getApplicationContext());
            if (!TextUtils.isEmpty(useSdkVersionConfig)) {
                getRenderParams().put(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION, URLDecoder.decode(useSdkVersionConfig));
            } else {
                getRenderParams().put(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION, ObjectUtils.asString(getInstance().getOptions().getString(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION, SDKConstants.SDK_VERSION_NUMBER), SDKConstants.SDK_VERSION_NUMBER));
            }
        }
        patchSafeArea();
        try {
            for (Map.Entry<String, String> entry : getRenderParams().entrySet()) {
                perfConfig(entry.getKey(), entry.getValue());
            }
        } catch (Throwable unused3) {
        }
        perfMonitorEnd("onCreateParseParams");
        if (DebugViewHelper.isDebuggable(this)) {
            try {
                DebugViewHelper.updateMsg(this, getRenderParams());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z2;
    }

    private void patchSafeArea() {
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1491428832")) {
            ipChange.ipc$dispatch("1491428832", new Object[]{this});
        } else if (!isOpenImmerse() || getRenderParams().containsKey(SAFE_AREA_TOP_WEEX)) {
        } else {
            try {
                int statusBarHeightByReflectPX = getStatusBarHeightByReflectPX();
                i2 = statusBarHeightByReflectPX;
                i = PxToDp(statusBarHeightByReflectPX);
            } catch (Throwable unused) {
                i = 0;
            }
            Map<String, String> renderParams = getRenderParams();
            renderParams.put(SAFE_AREA_TOP_PIXEL, "" + i2);
            Map<String, String> renderParams2 = getRenderParams();
            renderParams2.put(SAFE_AREA_TOP_WEEX, "" + i);
        }
    }

    private void perfConfig(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705884145")) {
            ipChange.ipc$dispatch("1705884145", new Object[]{this, str, str2});
        } else {
            getPagePerfMonitor().perfConfig(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfMonitorBegin(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-715767206")) {
            ipChange.ipc$dispatch("-715767206", new Object[]{this, str});
            return;
        }
        Log.e("LiveActivity", str + ":begin");
        getPagePerfMonitor().perfPointBegin(str);
    }

    private void perfMonitorCommitEnd(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "354626495")) {
            ipChange.ipc$dispatch("354626495", new Object[]{this, str});
            return;
        }
        Log.e("LiveActivity", str + ":CommitEnd");
        getPagePerfMonitor().perfPointEnd(str, "").perfCommitSuccess();
    }

    private void perfMonitorEnd(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613779352")) {
            ipChange.ipc$dispatch("-1613779352", new Object[]{this, str});
            return;
        }
        Log.e("LiveActivity", str + ":end");
        getPagePerfMonitor().perfPointEnd(str, "");
    }

    private void perfMonitorEndDisable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1241845842")) {
            ipChange.ipc$dispatch("-1241845842", new Object[]{this, str});
            return;
        }
        Log.e("LiveActivity", str + ":EndDisable");
        getPagePerfMonitor().perfPointEnd(str, "").perfEnable(str, false).perfCommitSuccess();
    }

    private boolean preprocessShouldSkip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-11985682")) {
            return ((Boolean) ipChange.ipc$dispatch("-11985682", new Object[]{this})).booleanValue();
        }
        Intent intent = getIntent();
        Uri data = intent != null ? intent.getData() : null;
        if (data != null && BizConfigHelper.shouldDowngradeToOldContainer(data)) {
            String lowerCase = data.toString().toLowerCase();
            if (SchemaConstants.isYoukuLiveSchema(lowerCase)) {
                this.supportBackToMainApp = false;
                if (lowerCase.startsWith(SchemaConstants.SCHEMA_YOUKULIVE_HTTP)) {
                    lowerCase = lowerCase.replace(SchemaConstants.SCHEMA_YOUKULIVE_HTTP, "youku://ilproomold");
                } else if (lowerCase.startsWith(SchemaConstants.SCHEMA_YOUKULIVE_HTTPS)) {
                    lowerCase = lowerCase.replace(SchemaConstants.SCHEMA_YOUKULIVE_HTTPS, "youku://ilproomold");
                } else if (lowerCase.startsWith(SchemaConstants.SCHEMA_YOUKULIVE_YOUKU_ILPROOM)) {
                    lowerCase = lowerCase.replace(SchemaConstants.SCHEMA_YOUKULIVE_YOUKU_ILPROOM, "youku://ilproomold");
                } else if (lowerCase.startsWith(SchemaConstants.SCHEMA_YOUKULIVE_HTTP_SEP)) {
                    lowerCase = lowerCase.replace(SchemaConstants.SCHEMA_YOUKULIVE_HTTP_SEP, "youku://ilproomold");
                } else if (lowerCase.startsWith(SchemaConstants.SCHEMA_YOUKULIVE_HTTPS_SEP)) {
                    lowerCase = lowerCase.replace(SchemaConstants.SCHEMA_YOUKULIVE_HTTPS_SEP, "youku://ilproomold");
                } else if (lowerCase.startsWith(SchemaConstants.SCHEMA_YOUKULIVE_YOUKU_ILPROOM_SEP)) {
                    lowerCase = lowerCase.replace(SchemaConstants.SCHEMA_YOUKULIVE_YOUKU_ILPROOM_SEP, "youku://ilproomold");
                }
                Nav.from(getApplication()).toUri(lowerCase);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int px2wx(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-376644353") ? ((Integer) ipChange.ipc$dispatch("-376644353", new Object[]{this, Integer.valueOf(i)})).intValue() : (int) ((i * 750.0f) / getScreenWidth());
    }

    private void registerReceiver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1424702058")) {
            ipChange.ipc$dispatch("-1424702058", new Object[]{this});
        } else if (this.mPipBroadcastReceiver != null) {
        } else {
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
            Intent intent = new Intent();
            intent.setAction(PipBroadcastReceiver.SINGLETON_LIVE_ROOM_BROADCAST);
            intent.putExtra("instTag", this.instTag);
            localBroadcastManager.sendBroadcast(intent);
            Intent intent2 = new Intent();
            intent2.setAction("finish_activity_action");
            localBroadcastManager.sendBroadcast(intent2);
            PipBroadcastReceiver pipBroadcastReceiver = new PipBroadcastReceiver(this);
            this.mPipBroadcastReceiver = pipBroadcastReceiver;
            pipBroadcastReceiver.setInstTag(this.instTag);
            IntentFilter intentFilter = new IntentFilter();
            if (Build.VERSION.SDK_INT >= 26) {
                if (ConfigUtil.isPipMiniAppOnPauseFinishing()) {
                    intentFilter.addAction(PipBroadcastReceiver.MINI_APP_ONPAUSE_FINISHING);
                } else {
                    intentFilter.addAction(PipBroadcastReceiver.MINI_APP_INSIDE_EXIT);
                }
                intentFilter.addAction(PipBroadcastReceiver.PIP_LIVE_PLAYER_FULLSCREEN_BROADCAST);
                intentFilter.addAction(PipBroadcastReceiver.PIP_LIVE_EXIT_H5_FROM_LIVE_BROADCAST);
                intentFilter.addAction(PipBroadcastReceiver.PIP_LIVE_PLAYER_LIVEROOM_BROADCAST);
            }
            intentFilter.addAction(PipBroadcastReceiver.SINGLETON_LIVE_ROOM_BROADCAST);
            LocalBroadcastManager.getInstance(this).registerReceiver(this.mPipBroadcastReceiver, intentFilter);
        }
    }

    private boolean renderWithLayoutSource(String str, String str2, TemplateModel templateModel, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68768005")) {
            return ((Boolean) ipChange.ipc$dispatch("-68768005", new Object[]{this, str, str2, templateModel, Boolean.valueOf(z), Boolean.valueOf(z2)})).booleanValue();
        }
        PerfLogUtils.log("LiveActivity.renderWithLayoutSource start ...");
        if (TextUtils.isEmpty(str2) || !str2.contains("\"id\"") || str2.contains("\"OGCLayer\"")) {
            return false;
        }
        if (this.mPagableViewProvider == null) {
            PagableRecyclerViewProvider pagableRecyclerViewProvider = new PagableRecyclerViewProvider(this, PagableConfigure.getInstance().getCurrentModeForLayout());
            this.mPagableViewProvider = pagableRecyclerViewProvider;
            if (pagableRecyclerViewProvider instanceof PagableRecyclerViewProvider) {
                pagableRecyclerViewProvider.setPagingContentCreator(this.mPagingContentCreator);
                ((PagableRecyclerViewProvider) this.mPagableViewProvider).addOnPagingLifecycleListener(this.mOnPagingLifectycleListener);
            }
            this.root.addView(this.mPagableViewProvider.getContentView(), new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.mPagableDataProvider == null) {
            this.mPagableDataProvider = new PagableDataProvider().attach(this.mPagableViewProvider);
        }
        this.mPagableDataProvider.setFirstRoomLayoutSource(str, str2, templateModel, z, z2).setRoomId(getRenderParams().get("liveId")).supportPagerSlide(true).setSdkVersion(getRenderParams().get(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION)).setActorBizType(this.mActorBizType).fetch();
        new FirstRoomAlarm().addArg("liveId", getRenderParams().get("liveId")).commitSuccess();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderWithLiveFullInfo(LiveFullInfoData liveFullInfoData, JSONObject jSONObject) {
        TemplateDTO templateDTO;
        UserInfo userInfo;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-949575431")) {
            ipChange.ipc$dispatch("-949575431", new Object[]{this, liveFullInfoData, jSONObject});
            return;
        }
        PerfLogUtils.log("LiveActivity.renderWithLiveFullInfo start ... ");
        perfMonitorBegin("onCreateRenderWithLiveFullInfo");
        YKPrefReporter.getInstance().getPlayBySessionId(this.mOnePlayId).setFullInfoRenderStartTime(System.currentTimeMillis());
        if (liveFullInfoData != null && (userInfo = liveFullInfoData.loginUser) != null && userInfo.roomKickOut == 1) {
            showKickoutDialog(userInfo.roomKickOutMsg);
        }
        if (liveFullInfoData != null && (templateDTO = liveFullInfoData.template) != null && jSONObject != null) {
            String str = templateDTO.layoutSource;
            if (!TextUtils.isEmpty(str) && str.contains("\"id\"") && !str.contains("\"OGCLayer\"")) {
                if (this.mPagableViewProvider == null) {
                    PagableRecyclerViewProvider pagableRecyclerViewProvider = new PagableRecyclerViewProvider(this, PagableConfigure.getInstance().getCurrentModeForLayout());
                    this.mPagableViewProvider = pagableRecyclerViewProvider;
                    if (pagableRecyclerViewProvider instanceof PagableRecyclerViewProvider) {
                        pagableRecyclerViewProvider.setPagingContentCreator(this.mPagingContentCreator);
                        ((PagableRecyclerViewProvider) this.mPagableViewProvider).addOnPagingLifecycleListener(this.mOnPagingLifectycleListener);
                    }
                    this.root.addView(this.mPagableViewProvider.getContentView(), new ViewGroup.LayoutParams(-1, -1));
                }
                if (this.mPagableDataProvider == null) {
                    this.mPagableDataProvider = new PagableDataProvider().attach(this.mPagableViewProvider);
                }
                this.mPagableDataProvider.setRoomId(getRenderParams().get("liveId")).setFullInfoData(liveFullInfoData).setFullInfoJson(jSONObject).supportPagerSlide(true).setSdkVersion(getRenderParams().get(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION)).setActorBizType(this.mActorBizType).fetch();
                new FirstRoomAlarm().addArg("liveId", getRenderParams().get("liveId")).commitSuccess();
                z = true;
            } else {
                z = ogcPreprocess(liveFullInfoData);
                HashMap hashMap = new HashMap();
                hashMap.put("value", jSONObject);
                hashMap.put(WXBridgeManager.OPTIONS, liveFullInfoData);
                Object data = getInstance().getData(SDKConstants.SDK_DEBUG_STATIC_WEEX_BUNDLE);
                if (data instanceof String) {
                    liveFullInfoData.template.staticJsBundle = (String) data;
                }
                syncMethod("onLiveFullInfoFromContainer", hashMap);
                if (z) {
                    new FirstRoomAlarm().addArg("liveId", getRenderParams().get("liveId")).commitSuccess();
                } else {
                    new FirstRoomAlarm().addArg("liveId", getRenderParams().get("liveId")).setErrorMessage("1000").setErrorCode("ogc process failure").commitFailure();
                }
            }
        } else {
            new FirstRoomAlarm().addArg("liveId", getRenderParams().get("liveId")).setErrorMessage("1000").setErrorCode("empty live full info").commitFailure();
        }
        if (z) {
            animClear();
            backButtonClear();
        } else {
            animShowRetry();
        }
        perfMonitorEnd("onCreateRenderWithLiveFullInfo");
        YKPrefReporter.getInstance().getPlayBySessionId(this.mOnePlayId).setFullInfoRenderEndTime(System.currentTimeMillis());
    }

    private void requestLaifengRecommendRoom(final boolean z, final Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091849337")) {
            ipChange.ipc$dispatch("2091849337", new Object[]{this, Boolean.valueOf(z), map});
            return;
        }
        HashMap hashMap = new HashMap();
        if (map != null && map.containsKey("type")) {
            hashMap.put("type", map.get("type"));
        }
        IRequest createRequestWithMtop = ((IRequestFactory) Dsl.getService(IRequestFactory.class)).createRequestWithMtop("mtop.youku.yklive.rec.room.living.get", "1.0", hashMap, false, false);
        final IRequestCallback iRequestCallback = new IRequestCallback() { // from class: com.youku.live.livesdk.LiveActivity.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dsl.network.IRequestCallback
            public void onCallback(IResponse iResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1822156384")) {
                    ipChange2.ipc$dispatch("1822156384", new Object[]{this, iResponse});
                } else {
                    LiveActivity.this.getInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.LiveActivity.9.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-798412043")) {
                                ipChange3.ipc$dispatch("-798412043", new Object[]{this});
                            } else {
                                LiveActivity.this.animShowRetry();
                            }
                        }
                    });
                }
            }
        };
        IRequestCallback iRequestCallback2 = new IRequestCallback() { // from class: com.youku.live.livesdk.LiveActivity.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dsl.network.IRequestCallback
            public void onCallback(IResponse iResponse) {
                T t;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1957930896")) {
                    ipChange2.ipc$dispatch("-1957930896", new Object[]{this, iResponse});
                    return;
                }
                RecRoomLivingV1 recRoomLivingV1 = null;
                if (iResponse != null && iResponse.getSource() != null) {
                    recRoomLivingV1 = (RecRoomLivingV1) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iResponse.getSource(), RecRoomLivingV1.class);
                }
                if (recRoomLivingV1 != null && (t = recRoomLivingV1.data) != 0 && ((RecRoomLivingGetData) t).id != null) {
                    String str = ((RecRoomLivingGetData) t).id;
                    HashMap hashMap2 = new HashMap(map);
                    hashMap2.put("liveId", str);
                    LiveActivity.this.requestLiveFullInfoV4Imp(z, hashMap2);
                    return;
                }
                iRequestCallback.onCallback(iResponse);
            }
        };
        if (createRequestWithMtop != null) {
            createRequestWithMtop.async(iRequestCallback2, iRequestCallback);
        }
    }

    private void requestLiveFullInfo(String str, Uri uri) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "28753683")) {
            ipChange.ipc$dispatch("28753683", new Object[]{this, str, uri});
            return;
        }
        try {
            z = ((ILaifengManagerInterface) Dsl.getService(ILaifengManagerInterface.class)).isLaifeng(uri, getIntent().getExtras());
        } catch (Throwable unused) {
        }
        if (!SchemaConstants.isYoukuLiveCarouselSchema(str, uri)) {
            if (z) {
                requestLiveFullInfoV4(z);
            } else {
                requestLiveFullInfoV4(z);
            }
        } else if (ogcPreprocess(null)) {
            animClear();
            backButtonClear();
        } else {
            new FirstRoomAlarm().addArg("id", SchemaConstants.SCHEMA_YOUKULIVE_CAROUSEL_VALUE).setErrorCode("1000").setErrorMessage("carousel fail").commitFailure();
            animShowRetry();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void requestLiveFullInfoV4(boolean r13) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.LiveActivity.requestLiveFullInfoV4(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestLiveFullInfoV4Imp(boolean z, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1351629373")) {
            ipChange.ipc$dispatch("-1351629373", new Object[]{this, Boolean.valueOf(z), map});
            return;
        }
        final String str = null;
        if (map != null && map.containsKey("liveId")) {
            str = map.get("liveId");
        }
        if (TextUtils.isEmpty(str) && z) {
            requestLaifengRecommendRoom(z, map);
            return;
        }
        IRequest createRequestWithMtop = ((IRequestFactory) Dsl.getService(IRequestFactory.class)).createRequestWithMtop("mtop.youku.live.com.livefullinfo", "4.0", map, false, false);
        if (createRequestWithMtop != null) {
            IPerfMonitor iPerfMonitor = this.mPagePerfMonitor;
            if (iPerfMonitor != null) {
                iPerfMonitor.point("LiveFullInfoCost", Thread.currentThread().getName() + "::LiveActivity requestLiveFullInfoV4Imp:" + this + ",mLiveId：" + str + ", 1 before reqLiveFullInfo;4.0");
            }
            createRequestWithMtop.async(new IRequestCallback() { // from class: com.youku.live.livesdk.LiveActivity.11
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.IRequestCallback
                public void onCallback(IResponse iResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1264538191")) {
                        ipChange2.ipc$dispatch("-1264538191", new Object[]{this, iResponse});
                        return;
                    }
                    if (LiveActivity.this.mPagePerfMonitor != null) {
                        IPerfMonitor iPerfMonitor2 = LiveActivity.this.mPagePerfMonitor;
                        iPerfMonitor2.point("LiveFullInfoCost", Thread.currentThread().getName() + "::LiveActivity requestLiveFullInfoV4Imp:" + LiveActivity.this + ",mLiveId：" + str + ", 2 after reqLiveFullInfo;4.0");
                    }
                    String source = iResponse.getSource();
                    MyLog.i("LiveFullInfo-LUO: ", source);
                    final LiveFullInfoData liveFullInfoData = (LiveFullInfoData) MtopDataHelper.getDataDataWithModel(source, LiveFullInfoV4.class);
                    if (LiveActivity.this.mPagePerfMonitor != null) {
                        IPerfMonitor iPerfMonitor3 = LiveActivity.this.mPagePerfMonitor;
                        iPerfMonitor3.point("LiveFullInfoCost", Thread.currentThread().getName() + "::LiveActivity requestLiveFullInfoV4Imp parse:" + LiveActivity.this + ",mLiveId：" + str + ", 3 after reqLiveFullInfo;4.0");
                    }
                    final JSONObject dataDataWithJson = MtopDataHelper.getDataDataWithJson(source, LiveFullInfoV4.class);
                    if (liveFullInfoData != null) {
                        if (liveFullInfoData.screenId != null) {
                            Map<String, String> renderParams = LiveActivity.this.getRenderParams();
                            renderParams.put("screenid", "" + liveFullInfoData.screenId);
                        }
                        if (liveFullInfoData.liveId != null) {
                            Map<String, String> renderParams2 = LiveActivity.this.getRenderParams();
                            renderParams2.put("id", "" + liveFullInfoData.liveId);
                            Map<String, String> renderParams3 = LiveActivity.this.getRenderParams();
                            renderParams3.put("liveId", "" + liveFullInfoData.liveId);
                            Map<String, String> renderParams4 = LiveActivity.this.getRenderParams();
                            renderParams4.put("liveid", "" + liveFullInfoData.liveId);
                            Map<String, String> renderParams5 = LiveActivity.this.getRenderParams();
                            renderParams5.put("roomid", "" + liveFullInfoData.liveId);
                        }
                    }
                    if (LiveActivity.this.mPagePerfMonitor != null) {
                        IPerfMonitor iPerfMonitor4 = LiveActivity.this.mPagePerfMonitor;
                        iPerfMonitor4.point("LiveFullInfoCost", Thread.currentThread().getName() + "::LiveActivity requestLiveFullInfoV4Imp parse:" + LiveActivity.this + ",mLiveId：" + str + ", 4 after reqLiveFullInfo;4.0");
                    }
                    LiveActivity.this.getInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.LiveActivity.11.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-2070359996")) {
                                ipChange3.ipc$dispatch("-2070359996", new Object[]{this});
                                return;
                            }
                            LiveActivity.this.getInstance().asyncPutData("mtop.youku.live.com.livefullinfo", liveFullInfoData, dataDataWithJson);
                            LiveActivity.this.renderWithLiveFullInfo(liveFullInfoData, dataDataWithJson);
                        }
                    });
                }
            }, new IRequestCallback() { // from class: com.youku.live.livesdk.LiveActivity.12
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.IRequestCallback
                public void onCallback(IResponse iResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-571145486")) {
                        ipChange2.ipc$dispatch("-571145486", new Object[]{this, iResponse});
                        return;
                    }
                    new FirstRoomAlarm().addArg("liveId", LiveActivity.this.getRenderParams().get("liveId")).setErrorMessage("1000").setErrorCode("failure request live full info in room").commitFailure();
                    LiveActivity.this.getInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.LiveActivity.12.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1941277277")) {
                                ipChange3.ipc$dispatch("-1941277277", new Object[]{this});
                            } else {
                                LiveActivity.this.animShowRetry();
                            }
                        }
                    });
                }
            });
        }
    }

    private static boolean sIsColdStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775970549")) {
            return ((Boolean) ipChange.ipc$dispatch("-1775970549", new Object[0])).booleanValue();
        }
        boolean z = sIsColdStart;
        sIsColdStart = false;
        return z;
    }

    private void setIsFromNav(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548311896")) {
            ipChange.ipc$dispatch("548311896", new Object[]{this, intent});
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null || !JUMP_FROM_NAV.equals(extras.getString(JUMP_SOURCE_KEY, ""))) {
            return;
        }
        this.mIsFromNav = true;
    }

    private boolean supportLaifengPagerSlide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045741217")) {
            return ((Boolean) ipChange.ipc$dispatch("1045741217", new Object[]{this})).booleanValue();
        }
        try {
            return ConfigHelper.getBoolean("live_platform_features", "pager_slide", false);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void tryShowPreview(ViewGroup viewGroup, Intent intent, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047589472")) {
            ipChange.ipc$dispatch("2047589472", new Object[]{this, viewGroup, intent, Boolean.valueOf(z)});
            return;
        }
        Drawable drawable = null;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("audio_bg");
            if (!TextUtils.isEmpty(stringExtra)) {
                drawable = Preloader.getInstance().preparePreViewDrawable(stringExtra, getApplication(), true, z);
            } else {
                drawable = Preloader.getInstance().preparePreViewDrawable(CDNHelper.getInstance().blurWithSize(intent.getStringExtra("cover_url"), 15, 15, 60, 60), getApplication(), false, z);
            }
        }
        if (drawable == null) {
            return;
        }
        final ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageDrawable(drawable);
        viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        imageView.postDelayed(new Runnable() { // from class: com.youku.live.livesdk.LiveActivity.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1368989542")) {
                    ipChange2.ipc$dispatch("1368989542", new Object[]{this});
                } else if (imageView.getParent() != null) {
                    ((ViewGroup) imageView.getParent()).removeView(imageView);
                }
            }
        }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    private void unRegisterReceiver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040325501")) {
            ipChange.ipc$dispatch("2040325501", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 26 && this.mPipBroadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mPipBroadcastReceiver);
            this.mPipBroadcastReceiver.unRegister();
            this.mPipBroadcastReceiver = null;
        }
    }

    private void updateOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-462316005")) {
            ipChange.ipc$dispatch("-462316005", new Object[]{this});
            return;
        }
        Configuration configuration = getResources().getConfiguration();
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1 && rotation != 3) {
            configuration.orientation = 1;
        } else {
            configuration.orientation = 0;
        }
        onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePortraitPagableLockState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832953266")) {
            ipChange.ipc$dispatch("-832953266", new Object[]{this});
        } else if (this.mPagableViewProvider != null) {
            this.mPagableViewProvider.setRoomSwitch(!isPortraitPagableLocked());
        }
    }

    public int PxToDp(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1899836707") ? ((Integer) ipChange.ipc$dispatch("-1899836707", new Object[]{this, Integer.valueOf(i)})).intValue() : (int) ((i / getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.youku.live.dsl.pages.IYoukuLiveMethodBridge
    public void asyncMethod(String str, Map<String, Object> map, IYoukuLiveMethodCallback iYoukuLiveMethodCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167555885")) {
            ipChange.ipc$dispatch("1167555885", new Object[]{this, str, map, iYoukuLiveMethodCallback});
            return;
        }
        IYoukuLiveMethodBridge iYoukuLiveMethodBridge = this.mYoukuLiveMethodBridge;
        if (iYoukuLiveMethodBridge != null) {
            iYoukuLiveMethodBridge.asyncMethod(str, map, iYoukuLiveMethodCallback);
        }
    }

    @Override // com.youku.live.widgets.WidgetActivity, android.app.Activity
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1452742357")) {
            ipChange.ipc$dispatch("1452742357", new Object[]{this});
            return;
        }
        getInstance().putData(LiveRoomConstants.DATA_ROOM_FINISH, Boolean.TRUE);
        getInstance().removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        IYoukuLiveInterface iYoukuLiveInterface = this.mYoukuLiveInstance;
        if (iYoukuLiveInterface != null) {
            iYoukuLiveInterface.finish();
        }
        this.root.setBackground(getApplication().getResources().getDrawable(R.drawable.dago_container_live_room_bg_online_class));
        super.finish();
    }

    public void finishByUser(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1557500545")) {
            ipChange.ipc$dispatch("1557500545", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isFinishByUser = z;
        finish();
    }

    public boolean getIsFromNav() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "640643475") ? ((Boolean) ipChange.ipc$dispatch("640643475", new Object[]{this})).booleanValue() : this.mIsFromNav;
    }

    public int getPipType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-53341280") ? ((Integer) ipChange.ipc$dispatch("-53341280", new Object[]{this})).intValue() : this.mPipType;
    }

    protected Map<String, String> getRenderParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886069701")) {
            return (Map) ipChange.ipc$dispatch("1886069701", new Object[]{this});
        }
        if (this.mBundleParams == null) {
            synchronized (this) {
                if (this.mBundleParams == null) {
                    this.mBundleParams = new HashMap();
                }
            }
        }
        return this.mBundleParams;
    }

    public int getStatusBarHeightByReflectDP() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414844981")) {
            return ((Integer) ipChange.ipc$dispatch("414844981", new Object[]{this})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "426165561")) {
            return ((Integer) ipChange.ipc$dispatch("426165561", new Object[]{this})).intValue();
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559344912")) {
            return ipChange.ipc$dispatch("-559344912", new Object[]{this, str});
        }
        Object systemService = super.getSystemService(str);
        return ("layout_inflater".equals(str) && (systemService instanceof LayoutInflater)) ? AsyncViewPreLoader.getAsyncViewLayoutInflater(this, (LayoutInflater) systemService) : systemService;
    }

    public boolean isInPipMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-290922053") ? ((Boolean) ipChange.ipc$dispatch("-290922053", new Object[]{this})).booleanValue() : this.isInPip;
    }

    public boolean isLandscape() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-577260491") ? ((Boolean) ipChange.ipc$dispatch("-577260491", new Object[]{this})).booleanValue() : getResources().getConfiguration().orientation == 2;
    }

    @Override // com.youku.live.widgets.WidgetActivity
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1062081319")) {
            return ((Boolean) ipChange.ipc$dispatch("-1062081319", new Object[]{this})).booleanValue();
        }
        boolean z = this.mSupportQuitBlocker;
        if (z) {
            getInstance().putData("onDagoContainerQuitEvent", null);
        }
        return z;
    }

    @Override // com.youku.live.widgets.WidgetActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316964890")) {
            ipChange.ipc$dispatch("-316964890", new Object[]{this});
            return;
        }
        IYoukuLiveInterface iYoukuLiveInterface = this.mYoukuLiveInstance;
        boolean onBackPressed = iYoukuLiveInterface != null ? iYoukuLiveInterface.onBackPressed() : false;
        if (!onBackPressed && (pagableViewProvider = this.mPagableViewProvider) != null) {
            onBackPressed = ((Boolean) pagableViewProvider.callActiveView(new Caller<LiveContentView, Void, Boolean>() { // from class: com.youku.live.livesdk.LiveActivity.26
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Caller
                public Boolean onCall(LiveContentView liveContentView, Void r6) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-356290925")) {
                        return (Boolean) ipChange2.ipc$dispatch("-356290925", new Object[]{this, liveContentView, r6});
                    }
                    boolean onActivityBackPressedForWidget = liveContentView.onActivityBackPressedForWidget();
                    if (!onActivityBackPressedForWidget) {
                        onActivityBackPressedForWidget = LiveActivity.this.isProcessActivityPip();
                    }
                    if (!onActivityBackPressedForWidget) {
                        onActivityBackPressedForWidget = liveContentView.onActivityBackPressedForWeex();
                    }
                    return Boolean.valueOf(onActivityBackPressedForWidget);
                }
            }, null, Boolean.FALSE)).booleanValue();
        }
        if (onBackPressed) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.youku.live.widgets.WidgetActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1540882875")) {
            ipChange.ipc$dispatch("-1540882875", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        this.mConfigurationOrientation = configuration.orientation;
        if (getResources().getConfiguration().orientation == 2) {
            getWindow().setFlags(1024, 1024);
            PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
            if (pagableViewProvider != null) {
                pagableViewProvider.setRoomSwitch(false);
            }
        } else {
            getWindow().clearFlags(1024);
            updatePortraitPagableLockState();
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider2 = this.mPagableViewProvider;
        if (pagableViewProvider2 != null) {
            pagableViewProvider2.callActiveView(new Caller<LiveContentView, Configuration, Void>() { // from class: com.youku.live.livesdk.LiveActivity.28
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Caller
                public Void onCall(LiveContentView liveContentView, Configuration configuration2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2084979266")) {
                        return (Void) ipChange2.ipc$dispatch("-2084979266", new Object[]{this, liveContentView, configuration2});
                    }
                    liveContentView.onActivityConfigurationChanged(configuration2);
                    return null;
                }
            }, configuration, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.live.widgets.WidgetActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340830663")) {
            ipChange.ipc$dispatch("340830663", new Object[]{this, bundle});
            return;
        }
        PerfLogUtils.log("LiveActivity.onCreate ... ");
        this.mTimestampForOnCreateBegin = System.currentTimeMillis();
        if (((IYoukuSupport64) Dsl.getService(IYoukuSupport64.class)).isDevice32Install64Apk()) {
            super.onCreate(bundle);
            return;
        }
        if (AXPParamsProvider.ClientType.YOUKU.equals(getPackageName())) {
            getWindow().setSoftInputMode(35);
        }
        innerInitAsyncViewPreLoader();
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.youku.action.Coin_Recharge_Success");
        registerReceiver(this.mBroadcastReceiver, intentFilter);
        LiveTimeUtils.pageChanged = false;
        LiveTimeUtils.anchorPointTime = System.currentTimeMillis();
        perfMonitorBegin("onCreate");
        Intent intent = getIntent();
        if (intent != null) {
            boolean isFromAppColdStart = Preloader.getInstance().isFromAppColdStart();
            ILog logger = getLogger();
            logger.e("LivePreloader", "Room:isFromAppColdStart:" + isFromAppColdStart);
            if (isFromAppColdStart) {
                Map<String, String> coldStartParams = Preloader.getInstance().getColdStartParams();
                if (coldStartParams != null && coldStartParams.size() > 0) {
                    ILog logger2 = getLogger();
                    logger2.e("LivePreloader", "Room:isFromAppColdStart:" + coldStartParams);
                    for (Map.Entry<String, String> entry : coldStartParams.entrySet()) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
                Preloader.getInstance().clearColdStartStatus();
                getLogger().e("LivePreloader", "Room:isFromAppColdStart:clearColdStartStatus");
            }
            String stringExtra = intent.getStringExtra("onePlayId");
            this.mOnePlayId = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.mOnePlayId = YKPrefReporter.genOnePlayId(System.currentTimeMillis());
            }
            getRenderParams().put("onePlayId", this.mOnePlayId);
            long currentTimeMillis = System.currentTimeMillis();
            YKPrefReporter.getInstance().getPlayBySessionId(this.mOnePlayId).setOnCreateStartTime(currentTimeMillis);
            if (!"1".equals(YKPrefReporter.getInstance().getPlayBySessionId(this.mOnePlayId).getNav())) {
                YKPrefReporter.getInstance().getPlayBySessionId(this.mOnePlayId).setClickTime(currentTimeMillis);
            }
        }
        HashMap hashMap = new HashMap();
        this.mOnePlayIdCache = hashMap;
        hashMap.put(0, this.mOnePlayId);
        this.instTag = getInstHashCode(this);
        registerReceiver();
        getPagePerfMonitor().perfBegin(this.mTimestampForOnCreateBegin);
        perfMonitorBegin("onCreateWidgetEngineContext");
        this.mState = ActivityLifecycleState.CREATED;
        WidgetEngineContext widgetEngineContext = new WidgetEngineContext();
        this.mWidgetEngineContext = widgetEngineContext;
        widgetEngineContext.bindActivityController(this, new IActivityStateReader() { // from class: com.youku.live.livesdk.LiveActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
            public ActivityLifecycleState getActivityLifecycleState() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1406483371") ? (ActivityLifecycleState) ipChange2.ipc$dispatch("-1406483371", new Object[]{this}) : LiveActivity.this.mState;
            }

            @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
            public int getActivityOrientation() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1664045667") ? ((Integer) ipChange2.ipc$dispatch("-1664045667", new Object[]{this})).intValue() : LiveActivity.this.mConfigurationOrientation;
            }
        }, new IPageableController() { // from class: com.youku.live.livesdk.LiveActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.widgets.protocol.IPageableController
            public boolean isPageable() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1297830663")) {
                    return ((Boolean) ipChange2.ipc$dispatch("1297830663", new Object[]{this})).booleanValue();
                }
                return true;
            }

            @Override // com.youku.live.widgets.protocol.IPageableController
            public boolean lockPageable(String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1444355728")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-1444355728", new Object[]{this, str})).booleanValue();
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                LiveActivity.this.mLockerList.add(str);
                LiveActivity.this.mIsPortraitLocked = true;
                LiveActivity.this.updatePortraitPagableLockState();
                return LiveActivity.this.mIsPortraitLocked;
            }

            @Override // com.youku.live.widgets.protocol.IPageableController
            public boolean unlockPageable(String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1556997559")) {
                    return ((Boolean) ipChange2.ipc$dispatch("1556997559", new Object[]{this, str})).booleanValue();
                }
                if (TextUtils.isEmpty(str)) {
                    return LiveActivity.this.mIsPortraitLocked;
                }
                if (LiveActivity.this.mLockerList.contains(str)) {
                    LiveActivity.this.mLockerList.remove(str);
                }
                if (LiveActivity.this.mLockerList.size() <= 0) {
                    LiveActivity.this.mIsPortraitLocked = false;
                }
                LiveActivity.this.updatePortraitPagableLockState();
                return !LiveActivity.this.mIsPortraitLocked;
            }
        });
        perfMonitorEnd("onCreateWidgetEngineContext");
        perfMonitorBegin("onCreateSetContentView");
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        setTheme(R.style.LiveAppCompatTheme);
        Uri uri = null;
        getWindow().setBackgroundDrawable(null);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.dago_container_activity_layout, (ViewGroup) null);
        this.root = viewGroup;
        setContentView(viewGroup);
        try {
            if (LivePerfUtils.supportPlayerContextPrePlay() && ((ILaifengManagerInterface) Dsl.getService(ILaifengManagerInterface.class)).startPrePlay(this, this.root)) {
                LivePageTaskHolder.getInstance().createPageTaskDomain(this);
            }
        } catch (Throwable th) {
            if (DebugHelp.isDebugBuild()) {
                th.printStackTrace();
            }
        }
        perfMonitorEnd("onCreateSetContentView");
        if (preprocessShouldSkip()) {
            finish();
            return;
        }
        perfMonitorBegin("onCreateInitLoadingView");
        perfMonitorEnd("onCreateInitLoadingView");
        getWindow().addFlags(128);
        if (isOpenImmerse()) {
            if (Build.VERSION.SDK_INT >= 19) {
                if (hasSoftKeys(getWindowManager())) {
                    getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
                } else {
                    getWindow().addFlags(256);
                    getWindow().addFlags(512);
                }
            }
            LiveStatusBarUtil.setTranslucentStatus(this);
        }
        perfMonitorBegin("onCreateInitLiveSDK");
        LiveSdkPreloader.initLiveSDK(getApplication());
        LiveSdkPreloader.initArch(getApplication());
        ((IInitializationMC) Dsl.getService(IInitializationMC.class)).initialize();
        perfMonitorEnd("onCreateInitLiveSDK");
        perfMonitorBegin("onCreateCheckSupportsBackToMainApp");
        checkSupportsBackToMainApp();
        perfMonitorEnd("onCreateCheckSupportsBackToMainApp");
        Intent intent2 = getIntent();
        Preloader.getInstance().loadFromRoom(intent2);
        if (intent2 != null) {
            Bundle extras = intent2.getExtras();
            if (extras != null) {
                this.mActorBizType = extras.getString(LiveRoomConstants.DATA_COM_IN_TAB_ACTIR_BIZ_TYPE, "");
            }
            Uri data = intent2.getData();
            Log.d("fornia", "pip live Liveactivity oncreate uri" + data);
            String uri2 = data != null ? data.toString() : null;
            this.pageUri = data;
            this.pageUrl = uri2;
            DebugViewHelper.addDebugView(this);
            z = parseParams(data, uri2, extras);
            uri = data;
        } else {
            z = true;
        }
        setIsFromNav(getIntent());
        tryShowPreview(this.root, intent2, z);
        this.matchLayoutCache = getRenderParams().containsKey("roomLayout");
        this.isColdStart = sIsColdStart();
        perfConfig("isColdStart", isColdStart() ? "1" : "0");
        RequiresSDK requiresSDK = PageConfig.getInstance().getRequiresSDK(getRenderParams().get("id"));
        if (requiresSDK.requireAilpSDK()) {
            perfMonitorBegin("onCreateInitAilpSDK");
            LiveSdkPreloader.initAilpSDK(getApplication());
            perfMonitorEnd("onCreateInitAilpSDK");
        }
        if (requiresSDK.requireDagoSDK()) {
            perfMonitorBegin("onCreateInitDagoSDK");
            LiveSdkPreloader.initDagoSDK(getApplication());
            perfMonitorEnd("onCreateInitDagoSDK");
        }
        if (OptConfigUtils.getConfig("donotInitLaifengSDKOnYoukuLive", true)) {
            if (!z) {
                if (requiresSDK.requireLaifengSDK()) {
                    perfMonitorBegin("onCreateInitLaifengSDK");
                    LiveSdkPreloader.initLaifengSDK(getApplication());
                    perfMonitorEnd("onCreateInitLaifengSDK");
                }
            } else if (OptConfigUtils.getConfig("supportAsyncInitLaifengSDK", true)) {
                LivePageTaskHolder.getInstance().addPageNormalTask((Activity) this, true, new Runnable() { // from class: com.youku.live.livesdk.LiveActivity.3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1762016552")) {
                            ipChange2.ipc$dispatch("1762016552", new Object[]{this});
                        } else {
                            LiveSdkPreloader.preRegisterLaifeng(LiveActivity.this.getApplication());
                        }
                    }
                }, "async_init_laifeng_sdk");
            } else {
                LiveSdkPreloader.preRegisterLaifeng(getApplication());
            }
        } else if (requiresSDK.requireLaifengSDK()) {
            perfMonitorBegin("onCreateInitLaifengSDK");
            LiveSdkPreloader.initLaifengSDK(getApplication());
            perfMonitorEnd("onCreateInitLaifengSDK");
        }
        perfMonitorBegin("onCreateRequestLiveFullInfo");
        requestLiveFullInfo(this.pageUrl, uri);
        perfMonitorEnd("onCreateRequestLiveFullInfo");
        if (WXEnvironment.isApkDebugable()) {
            perfMonitorBegin("onCreateLiveWXAnalyzerDelegate");
            LiveWXAnalyzerDelegate liveWXAnalyzerDelegate = new LiveWXAnalyzerDelegate(this);
            this.mWxAnalyzerDelegate = liveWXAnalyzerDelegate;
            liveWXAnalyzerDelegate.onCreate();
            perfMonitorEnd("onCreateLiveWXAnalyzerDelegate");
        }
        if (this.mKeyboardHeightProvider == null) {
            perfMonitorBegin("onCreateKeyboardHeightProvider");
            this.mKeyboardHeightProvider = new KeyboardHeightProvider(this);
            this.root.post(new Runnable() { // from class: com.youku.live.livesdk.LiveActivity.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1565503047")) {
                        ipChange2.ipc$dispatch("1565503047", new Object[]{this});
                    } else if (LiveActivity.this.mKeyboardHeightProvider != null) {
                        LiveActivity.this.mKeyboardHeightProvider.start();
                    }
                }
            });
            perfMonitorEnd("onCreateKeyboardHeightProvider");
        }
        perfMonitorBegin("onCreateUpdateOrientation");
        updateOrientation();
        perfMonitorEnd("onCreateUpdateOrientation");
        perfMonitorCommitEnd("onCreate");
        IPerfMonitor iPerfMonitor = this.mPagePerfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.point("onCreate", "onCreate.end");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent(PipBroadcastReceiver.PIP_LIVE_PLAYER_LIVEROOM_BROADCAST));
        }
        if (!TextUtils.isEmpty(this.mOnePlayId)) {
            YKPrefReporter.getInstance().getPlayBySessionId(this.mOnePlayId).setOnCreateEndTime(System.currentTimeMillis());
        }
        LivePageMonitorDomain pageTaskDomain = LivePageTaskHolder.getInstance().getPageTaskDomain(this);
        if (pageTaskDomain != null) {
            pageTaskDomain.onPageStart();
        }
        String str = getRenderParams().get("liveRequestSessionId");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setPageStart(this.mTimestampForOnCreateBegin).setPageEnd(YoukuLivePerformanceManager.currentTimeMillis());
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1786777945")) {
            ipChange.ipc$dispatch("1786777945", new Object[]{this, str, obj, obj2});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.live.widgets.WidgetActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1576949447")) {
            ipChange.ipc$dispatch("1576949447", new Object[]{this});
        } else if (((IYoukuSupport64) Dsl.getService(IYoukuSupport64.class)).isDevice32Install64Apk()) {
            super.onDestroy();
        } else {
            try {
                ((ILaifengManagerInterface) Dsl.getService(ILaifengManagerInterface.class)).clearPrePlay(this);
            } catch (Exception unused) {
            }
            cleanPreLayout();
            AsyncViewPreLoader.unregisterAsyncViewPreLoaderService(this);
            LivePageTaskHolder.getInstance().releasePageTaskDomain(this);
            this.mState = ActivityLifecycleState.DESTROYED;
            super.onDestroy();
            unregisterReceiver(this.mBroadcastReceiver);
            KeyboardHeightProvider keyboardHeightProvider = this.mKeyboardHeightProvider;
            if (keyboardHeightProvider != null) {
                keyboardHeightProvider.close();
                this.mKeyboardHeightProvider = null;
            }
            unRegisterReceiver();
            IYoukuLiveInterface iYoukuLiveInterface = this.mYoukuLiveInstance;
            if (iYoukuLiveInterface != null) {
                iYoukuLiveInterface.onDestroy();
            }
            LiveWXAnalyzerDelegate liveWXAnalyzerDelegate = this.mWxAnalyzerDelegate;
            if (liveWXAnalyzerDelegate != null) {
                liveWXAnalyzerDelegate.onDestroy();
            }
            if (!SdkChannel.isDamai(this)) {
                gobackToApplication();
            }
            KeyboardHeightProvider keyboardHeightProvider2 = this.mKeyboardHeightProvider;
            if (keyboardHeightProvider2 != null) {
                keyboardHeightProvider2.close();
            }
            finalRelease();
            PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
            if (pagableViewProvider != null) {
                pagableViewProvider.notifyAllViews(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.27
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.livesdk.widgets.helper.Accessor
                    public void onAccess(LiveContentView liveContentView) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-109693526")) {
                            ipChange2.ipc$dispatch("-109693526", new Object[]{this, liveContentView});
                        } else if (liveContentView != null) {
                            liveContentView.getInstance().onActivityDestroy();
                        }
                    }
                });
            }
            WidgetEngineContext widgetEngineContext = this.mWidgetEngineContext;
            if (widgetEngineContext != null) {
                widgetEngineContext.unbindActivityStateReader(this);
                this.mWidgetEngineContext.destroy();
            }
            YKLToastUtil.destroy();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(final int i, final KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66854883")) {
            return ((Boolean) ipChange.ipc$dispatch("-66854883", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        boolean booleanValue = pagableViewProvider != null ? ((Boolean) pagableViewProvider.callActiveView(new Caller<LiveContentView, Void, Boolean>() { // from class: com.youku.live.livesdk.LiveActivity.32
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.livesdk.widgets.helper.Caller
            public Boolean onCall(LiveContentView liveContentView, Void r6) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-662154066") ? (Boolean) ipChange2.ipc$dispatch("-662154066", new Object[]{this, liveContentView, r6}) : Boolean.valueOf(liveContentView.getInstance().onActivityKeyDown(i, keyEvent));
            }
        }, null, Boolean.FALSE)).booleanValue() : false;
        return !booleanValue ? super.onKeyDown(i, keyEvent) : booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918120900")) {
            return ((Boolean) ipChange.ipc$dispatch("918120900", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        LiveWXAnalyzerDelegate liveWXAnalyzerDelegate = this.mWxAnalyzerDelegate;
        return (liveWXAnalyzerDelegate != null && liveWXAnalyzerDelegate.onKeyUp(i, keyEvent)) || super.onKeyUp(i, keyEvent);
    }

    @Override // com.youku.live.livesdk.wkit.view.keyboard.KeyboardHeightObserver
    public void onKeyboardHeightChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-454187781")) {
            ipChange.ipc$dispatch("-454187781", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        MyLog.i("jiangzkb", "onKeyboardHeightChanged: " + i + ", orientation: " + i2);
        int max = Math.max(i, 0);
        if (this.mKeyboardHeight == max) {
            return;
        }
        this.mKeyboardHeight = max;
        final boolean z = max > (i2 == 1 ? 150 : 50);
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyActiveView(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.31
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-447767613")) {
                        ipChange2.ipc$dispatch("-447767613", new Object[]{this, liveContentView});
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (LiveActivity.this.isOpenImmerse()) {
                        LiveActivity liveActivity = LiveActivity.this;
                        hashMap.put("height", Integer.valueOf(liveActivity.px2wx(liveActivity.mKeyboardHeight + LiveActivity.this.dip2px(60))));
                    } else {
                        LiveActivity liveActivity2 = LiveActivity.this;
                        hashMap.put("height", Integer.valueOf(liveActivity2.px2wx(liveActivity2.dip2px(60))));
                    }
                    hashMap.put("keyboardHeight", Integer.valueOf(LiveActivity.this.mKeyboardHeight));
                    hashMap.put("isShow", Integer.valueOf(z ? 1 : 0));
                    MyLog.d("LiveActivity", "EVENT_KEY_BOARD_CHANGED: " + hashMap);
                    liveContentView.getInstance().putData("EVENT_KEY_BOARD_CHANGED", hashMap);
                    if (z) {
                        liveContentView.getInstance().putData("adrKeyboardHeight", hashMap);
                    }
                }
            });
        }
    }

    @Override // com.youku.live.widgets.WidgetActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1675825260")) {
            ipChange.ipc$dispatch("1675825260", new Object[]{this});
            return;
        }
        super.onLowMemory();
        cleanPreLayout();
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyAllViews(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.30
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "81151426")) {
                        ipChange2.ipc$dispatch("81151426", new Object[]{this, liveContentView});
                    } else {
                        liveContentView.getInstance().asyncPutData("onDagoContainerLowMemoryWarningEvent", null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.live.widgets.WidgetActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683815499")) {
            ipChange.ipc$dispatch("683815499", new Object[]{this});
            return;
        }
        this.mState = ActivityLifecycleState.PAUSED;
        super.onPause();
        IYoukuLiveInterface iYoukuLiveInterface = this.mYoukuLiveInstance;
        if (iYoukuLiveInterface != null) {
            iYoukuLiveInterface.onPause();
        }
        LiveWXAnalyzerDelegate liveWXAnalyzerDelegate = this.mWxAnalyzerDelegate;
        if (liveWXAnalyzerDelegate != null) {
            liveWXAnalyzerDelegate.onPause();
        }
        KeyboardHeightProvider keyboardHeightProvider = this.mKeyboardHeightProvider;
        if (keyboardHeightProvider != null) {
            keyboardHeightProvider.setKeyboardHeightObserver(null);
        }
        if (isFinishing()) {
            muteActiveContent();
            onPauseFinalRelease();
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyActiveView(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.19
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1950910579")) {
                        ipChange2.ipc$dispatch("-1950910579", new Object[]{this, liveContentView});
                    } else {
                        liveContentView.getInstance().onActivityPause();
                    }
                }
            });
        }
        if (SdkChannel.isDamai(this)) {
            ((IUserTracker) Dsl.getService(IUserTracker.class)).pageDisAppear(this);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1664513159")) {
            ipChange.ipc$dispatch("1664513159", new Object[]{this, Boolean.valueOf(z), configuration});
            return;
        }
        super.onPictureInPictureModeChanged(z, configuration);
        this.mConfigurationOrientation = configuration.orientation;
        if (Build.VERSION.SDK_INT >= 24) {
            if (!z && isInPictureInPictureMode() && this.mErrorPIPQuitTask == null) {
                this.mErrorPIPQuitTask = new Object();
                this.mPIPConfiguration = configuration;
                Log.d("fornia", "pip live Liveactivity 告知退出小窗 但isInPip " + this + " " + this.isInPip + " sys in pip:" + isInPictureInPictureMode());
                return;
            }
            this.mPIPConfiguration = null;
            this.mErrorPIPQuitTask = null;
            this.isInPip = z;
            Log.d("fornia", "pip live Liveactivity  onPictureInPictureModeChanged isInPip " + this + " " + this.isInPip);
            if (!this.isInPip) {
                setPipType(-1);
            }
            ILiveActivityActions iLiveActivityActions = this.mILiveActivityActions;
            if (iLiveActivityActions != null) {
                iLiveActivityActions.onActivityPictureInPictureModeChanged(z, configuration);
            }
            if (z || !this.onStopCalled) {
                return;
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139229489")) {
            ipChange.ipc$dispatch("2139229489", new Object[]{this, bundle, persistableBundle});
            return;
        }
        IPerfMonitor iPerfMonitor = this.mPagePerfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.point("onPostCreate", "onPostCreate.begin");
        }
        super.onPostCreate(bundle, persistableBundle);
        IPerfMonitor iPerfMonitor2 = this.mPagePerfMonitor;
        if (iPerfMonitor2 != null) {
            iPerfMonitor2.point("onPostCreate", "onPostCreate.end");
        }
    }

    @Override // com.youku.live.widgets.WidgetActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(final int i, final String[] strArr, final int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829908159")) {
            ipChange.ipc$dispatch("-1829908159", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyActiveView(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.25
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "948144552")) {
                        ipChange2.ipc$dispatch("948144552", new Object[]{this, liveContentView});
                    } else {
                        liveContentView.getInstance().onActivityRequestPermissionsResult(i, strArr, iArr);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658313582")) {
            ipChange.ipc$dispatch("-1658313582", new Object[]{this});
            return;
        }
        super.onRestart();
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyAllViews(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.22
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1760065627")) {
                        ipChange2.ipc$dispatch("-1760065627", new Object[]{this, liveContentView});
                    } else {
                        liveContentView.getInstance().putData("DATA_KEY_LAIFENG_ACTIVITY_RESTART", "");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.live.widgets.WidgetActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371230492")) {
            ipChange.ipc$dispatch("1371230492", new Object[]{this});
            return;
        }
        perfMonitorBegin("onResume");
        this.mState = ActivityLifecycleState.RESUMED;
        super.onResume();
        IYoukuLiveInterface iYoukuLiveInterface = this.mYoukuLiveInstance;
        if (iYoukuLiveInterface != null) {
            iYoukuLiveInterface.onResume();
        }
        LiveWXAnalyzerDelegate liveWXAnalyzerDelegate = this.mWxAnalyzerDelegate;
        if (liveWXAnalyzerDelegate != null) {
            liveWXAnalyzerDelegate.onResume();
        }
        KeyboardHeightProvider keyboardHeightProvider = this.mKeyboardHeightProvider;
        if (keyboardHeightProvider != null) {
            keyboardHeightProvider.setKeyboardHeightObserver(this);
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyActiveView(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.21
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1231146588")) {
                        ipChange2.ipc$dispatch("-1231146588", new Object[]{this, liveContentView});
                    } else {
                        liveContentView.getInstance().onActivityResume();
                    }
                }
            });
        }
        perfMonitorEndDisable("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.live.widgets.WidgetActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "726920287")) {
            ipChange.ipc$dispatch("726920287", new Object[]{this});
            return;
        }
        perfMonitorBegin("onStart");
        this.mState = ActivityLifecycleState.STARTED;
        super.onStart();
        IYoukuLiveInterface iYoukuLiveInterface = this.mYoukuLiveInstance;
        if (iYoukuLiveInterface != null) {
            iYoukuLiveInterface.onStart();
        }
        LiveWXAnalyzerDelegate liveWXAnalyzerDelegate = this.mWxAnalyzerDelegate;
        if (liveWXAnalyzerDelegate != null) {
            liveWXAnalyzerDelegate.onStart();
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyActiveView(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.23
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2005982630")) {
                        ipChange2.ipc$dispatch("2005982630", new Object[]{this, liveContentView});
                    } else {
                        liveContentView.getInstance().onActivityStart();
                    }
                }
            });
        }
        if (SdkChannel.isDamai(this)) {
            ((IUserTracker) Dsl.getService(IUserTracker.class)).pageAppear(this);
            ((IUserTracker) Dsl.getService(IUserTracker.class)).updatePageName(this, "page_youkulive");
            ((IUserTracker) Dsl.getService(IUserTracker.class)).updatePageProperties(this, getRenderParams());
        }
        this.onStopCalled = false;
        perfMonitorEndDisable("onStart");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.live.widgets.WidgetActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313340455")) {
            ipChange.ipc$dispatch("313340455", new Object[]{this});
            return;
        }
        this.mState = ActivityLifecycleState.STOPPED;
        super.onStop();
        IYoukuLiveInterface iYoukuLiveInterface = this.mYoukuLiveInstance;
        if (iYoukuLiveInterface != null) {
            iYoukuLiveInterface.onStop();
        }
        LiveWXAnalyzerDelegate liveWXAnalyzerDelegate = this.mWxAnalyzerDelegate;
        if (liveWXAnalyzerDelegate != null) {
            liveWXAnalyzerDelegate.onStop();
        }
        if (isFinishing()) {
            finalRelease();
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyActiveView(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.24
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1477063591")) {
                        ipChange2.ipc$dispatch("1477063591", new Object[]{this, liveContentView});
                    } else {
                        liveContentView.getInstance().onActivityStop();
                    }
                }
            });
        }
        this.onStopCalled = true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103638103")) {
            ipChange.ipc$dispatch("1103638103", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onWindowFocusChanged(z);
        getInstance().asyncPutData(LiveRoomConstants.DATA_ACTIVITY_ON_FOCUS_CHANGED, Boolean.valueOf(z));
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.mPagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.notifyAllViews(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.LiveActivity.29
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public void onAccess(LiveContentView liveContentView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1167531604")) {
                        ipChange2.ipc$dispatch("-1167531604", new Object[]{this, liveContentView});
                    } else {
                        liveContentView.getInstance().asyncPutData(LiveRoomConstants.DATA_ACTIVITY_ON_FOCUS_CHANGED, Boolean.valueOf(z));
                    }
                }
            });
        }
        if (Build.VERSION.SDK_INT < 24 || this.mErrorPIPQuitTask == null || isInPictureInPictureMode()) {
            return;
        }
        Log.e("LiveActivity", "onWindowFocusChanged: check err pip");
        onPictureInPictureModeChanged(false, this.mPIPConfiguration);
    }

    public void pageAppear(String str, String str2, String str3, String str4, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006785689")) {
            ipChange.ipc$dispatch("2006785689", new Object[]{this, str, str2, str3, str4, map});
            return;
        }
        if (hasLastPage()) {
            pageDisappear();
        }
        this.currentPageLiveId = str;
        Log.e("LiveActivity", "LiveActivity.PV:" + str + ":pageAppear");
        if (!this.isSkip) {
            this.isSkip = true;
            try {
                getUserTracker().skipPage(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            getUserTracker().pageAppearDonotSkip(getPvObject());
            getUserTracker().updatePageName(getPvObject(), str2);
            getUserTracker().pageAppearDonotSkip(this);
            getUserTracker().updatePageName(this, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        updatePageProperties(str, map);
    }

    public void pageDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-759544594")) {
            ipChange.ipc$dispatch("-759544594", new Object[]{this});
        } else {
            pageDisappear(this.currentPageLiveId);
        }
    }

    public void setILiveActivityActions(ILiveActivityActions iLiveActivityActions) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2049248995")) {
            ipChange.ipc$dispatch("-2049248995", new Object[]{this, iLiveActivityActions});
            return;
        }
        Log.d("fornia", "pip live liveactivity setILiveActivityActions mILiveActivityActions");
        this.mILiveActivityActions = iLiveActivityActions;
    }

    public void setPipType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "869681258")) {
            ipChange.ipc$dispatch("869681258", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mPipType = i;
        }
    }

    public void showKickoutDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515276089")) {
            ipChange.ipc$dispatch("515276089", new Object[]{this, str});
            return;
        }
        DagoLiveDialog.DialogConfig dialogConfig = new DagoLiveDialog.DialogConfig();
        dialogConfig.title = "";
        if (TextUtils.isEmpty(str)) {
            str = "你已经被踢出了本直播间";
        }
        dialogConfig.content = str;
        dialogConfig.okText = "知道了";
        dialogConfig.isShowCancelBtn = false;
        dialogConfig.onOkBtnClickListener = new DagoLiveDialog.OnDialogButtonClickListener() { // from class: com.youku.live.livesdk.LiveActivity.15
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.livesdk.wkit.dialog.DagoLiveDialog.OnDialogButtonClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2041778595")) {
                    ipChange2.ipc$dispatch("2041778595", new Object[]{this, view});
                } else {
                    LiveActivity.this.finish();
                }
            }
        };
        DagoLiveDialog dagoLiveDialog = new DagoLiveDialog(this, dialogConfig);
        dagoLiveDialog.setCanceledOnTouchOutside(false);
        dagoLiveDialog.setCancelable(false);
        dagoLiveDialog.show();
        dagoLiveDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.youku.live.livesdk.LiveActivity.16
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1098778068")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-1098778068", new Object[]{this, dialogInterface, Integer.valueOf(i), keyEvent})).booleanValue();
                }
                return true;
            }
        });
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.youku.live.livesdk.LiveActivity.17
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "792473515")) {
                    ipChange2.ipc$dispatch("792473515", new Object[]{this});
                } else {
                    LiveActivity.this.finish();
                }
            }
        }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    @Override // com.youku.live.dsl.pages.IYoukuLiveMethodBridge
    public Object syncMethod(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035568893")) {
            return ipChange.ipc$dispatch("-2035568893", new Object[]{this, str, map});
        }
        IYoukuLiveMethodBridge iYoukuLiveMethodBridge = this.mYoukuLiveMethodBridge;
        if (iYoukuLiveMethodBridge != null) {
            return iYoukuLiveMethodBridge.syncMethod(str, map);
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774938762")) {
            ipChange.ipc$dispatch("1774938762", new Object[]{this, broadcastReceiver});
            return;
        }
        if (DebugHelp.isDebugBuild()) {
            Log.d("receiverLeak", "unregisterReceiver", new Exception());
        }
        super.unregisterReceiver(broadcastReceiver);
    }

    public void updatePageProperties(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315437250")) {
            ipChange.ipc$dispatch("-315437250", new Object[]{this, str, map});
        } else if (isSameWithLastPage(str)) {
            Log.e("LiveActivity", "LiveActivity.PV:" + str + ":updatePageProperties:" + map);
            try {
                getUserTracker().updatePageProperties(getPvObject(), map);
                getUserTracker().updatePageProperties(this, map);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void pageDisappear(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632468836")) {
            ipChange.ipc$dispatch("-632468836", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (isSameWithLastPage(str)) {
            Log.e("LiveActivity", "LiveActivity.PV:" + str + ":pageDisAppear");
            try {
                getUserTracker().pageDisAppear(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.currentPageLiveId = null;
        }
    }

    private void perfMonitorEnd(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931328462")) {
            ipChange.ipc$dispatch("-931328462", new Object[]{this, str, str2});
        } else {
            getPagePerfMonitor().perfPointEnd(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfMonitorEndDisable(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1230031352")) {
            ipChange.ipc$dispatch("1230031352", new Object[]{this, str, str2});
        } else {
            getPagePerfMonitor().perfPointEnd(str, str2).perfEnable(str, false);
        }
    }

    public void pageDisappear(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1365069624")) {
            ipChange.ipc$dispatch("1365069624", new Object[]{this, str});
        } else if (isSameWithLastPage(str)) {
            Log.e("LiveActivity", "LiveActivity.PV:" + str + ":pageDisAppear");
            try {
                getUserTracker().pageDisAppear(getPvObject());
                getUserTracker().pageDisAppear(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.currentPageLiveId = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1541970621")) {
            return (Intent) ipChange.ipc$dispatch("1541970621", new Object[]{this, broadcastReceiver, intentFilter});
        }
        if (DebugHelp.isDebugBuild()) {
            Log.d("receiverLeak", "registerReceiver", new Exception());
        }
        return super.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130060730")) {
            return (Intent) ipChange.ipc$dispatch("-130060730", new Object[]{this, broadcastReceiver, intentFilter, Integer.valueOf(i)});
        }
        if (DebugHelp.isDebugBuild()) {
            Log.d("receiverLeak", "registerReceiver", new Exception());
        }
        return super.registerReceiver(broadcastReceiver, intentFilter, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-578756093")) {
            return (Intent) ipChange.ipc$dispatch("-578756093", new Object[]{this, broadcastReceiver, intentFilter, str, handler});
        }
        if (DebugHelp.isDebugBuild()) {
            Log.d("receiverLeak", "registerReceiver", new Exception());
        }
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1448079424")) {
            return (Intent) ipChange.ipc$dispatch("-1448079424", new Object[]{this, broadcastReceiver, intentFilter, str, handler, Integer.valueOf(i)});
        }
        if (DebugHelp.isDebugBuild()) {
            Log.d("receiverLeak", "registerReceiver", new Exception());
        }
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
    }
}
