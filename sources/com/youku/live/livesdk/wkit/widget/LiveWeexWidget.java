package com.youku.live.livesdk.wkit.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.utils.WXSoInstallMgrSdk;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.pages.ILaifengManagerInterface;
import com.youku.live.dsl.weex.IWeexMananger;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.livesdk.constants.DagoDataCenterConstants;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.TemplateDTO;
import com.youku.live.livesdk.monitor.AbsYoukuLiveAlarm;
import com.youku.live.livesdk.monitor.LiveWeexAlarm;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformanceManager;
import com.youku.live.livesdk.widgets.container.pager.model.LiveQuickPlayModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.wkit.dialog.DagoLiveDialog;
import com.youku.live.livesdk.wkit.utils.SdkChannel;
import com.youku.live.livesdk.wkit.widget.view.WeexWidgetView;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import com.youku.live.widgets.protocol.activity.IActivityBackPressedListener;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LiveWeexWidget extends BaseWidget implements IWXRenderListener, ICall, IDataHandler, IActivityBackPressedListener, IActivityConfigurationOrientationChangedListener, IActivityLifecycleStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DAGO_NOTIFY_WEEX_GONE_IN_PIP = "dagoNotifyWeexGoneInPip";
    public static final String DAGO_SIGNAL_FIRST_FRAME = "dagoSignalFirstFrame";
    public static final String GLOBAL_EVENT = "globalEvent";
    public static final String GLOBAL_EVENT_NAME = "globalEventName";
    public static final String TAG = "LiveWeexWidget";
    private AbsYoukuLiveAlarm alarm;
    private Context mContext;
    private String mDebugBindBundle;
    private String mFinalInitData;
    private String mFinalJsBundle;
    private Map<String, Object> mFinalOptions;
    private String mLiveId;
    private WeexWidgetView mRealView;
    private FrameLayout mRootView;
    private boolean mIsActive = false;
    private boolean mWeexDelay = true;
    private String livePerformanceId = null;
    private boolean hasFirstFrame = false;
    private boolean mIsRendered = false;
    private int mInitializedCount = 0;
    private LiveFullInfoData mLiveFullInfoData = null;
    private Runnable asyncRenderActionRunnable = new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.LiveWeexWidget.7
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-591399853")) {
                ipChange.ipc$dispatch("-591399853", new Object[]{this});
            } else {
                LiveWeexWidget.this.renderAction();
            }
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.youku.live.livesdk.wkit.widget.LiveWeexWidget$9  reason: invalid class name */
    /* loaded from: classes12.dex */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$widgets$ActivityLifecycleState;

        static {
            int[] iArr = new int[ActivityLifecycleState.values().length];
            $SwitchMap$com$youku$live$widgets$ActivityLifecycleState = iArr;
            try {
                iArr[ActivityLifecycleState.PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$live$widgets$ActivityLifecycleState[ActivityLifecycleState.RESUMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void asyncRenderAction(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204647366")) {
            ipChange.ipc$dispatch("-204647366", new Object[]{this, Integer.valueOf(i)});
        } else if (i > 0) {
            getEngineInstance().delayRunOnMainThread(this.asyncRenderActionRunnable, i);
        } else {
            getEngineInstance().runOnMainThread(this.asyncRenderActionRunnable);
        }
    }

    private AbsYoukuLiveAlarm getAlarm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996234750")) {
            return (AbsYoukuLiveAlarm) ipChange.ipc$dispatch("996234750", new Object[]{this});
        }
        if (this.alarm == null) {
            synchronized (this) {
                if (this.alarm == null) {
                    this.alarm = new LiveWeexAlarm();
                }
            }
        }
        return this.alarm;
    }

    private int getCheckInitializedInterval() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1758124413")) {
            return ((Integer) ipChange.ipc$dispatch("1758124413", new Object[]{this})).intValue();
        }
        return 500;
    }

    private int getMaxCheckInitializedCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1191703665")) {
            return ((Integer) ipChange.ipc$dispatch("-1191703665", new Object[]{this})).intValue();
        }
        return 5;
    }

    private void initDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122939210")) {
            ipChange.ipc$dispatch("2122939210", new Object[]{this});
        } else {
            getEngineInstance().addDataHandlers(new String[]{"mtop.youku.live.com.livefullinfo", "dagoNotifyWeexGoneInPip", "userRoomKickoutV2", "dagoSignalFirstFrame"}, this);
        }
    }

    private void loadWithRoomInfo(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917221462")) {
            ipChange.ipc$dispatch("1917221462", new Object[]{this, liveFullInfoData});
            return;
        }
        this.mLiveFullInfoData = liveFullInfoData;
        if (liveFullInfoData == null || liveFullInfoData.template == null) {
            return;
        }
        updateData(String.valueOf(liveFullInfoData.liveId), liveFullInfoData.template.staticJsBundle);
    }

    private void loadWithSwitchModel(SwitchItemModel switchItemModel) {
        LiveQuickPlayModel liveQuickPlayModel;
        TemplateDTO templateDTO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948214629")) {
            ipChange.ipc$dispatch("1948214629", new Object[]{this, switchItemModel});
        } else if (switchItemModel == null || (liveQuickPlayModel = switchItemModel.liveQuickPlay) == null || (templateDTO = liveQuickPlayModel.template) == null) {
        } else {
            updateData(switchItemModel.roomId, templateDTO.staticJsBundle);
        }
    }

    private void performanceEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674510")) {
            ipChange.ipc$dispatch("1674510", new Object[]{this});
            return;
        }
        String str = this.livePerformanceId;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setWeexEnd();
    }

    private void performanceError(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "559574859")) {
            ipChange.ipc$dispatch("559574859", new Object[]{this, str});
            return;
        }
        String str2 = this.livePerformanceId;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str2).setWeexError(str);
    }

    private void performanceStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253444391")) {
            ipChange.ipc$dispatch("1253444391", new Object[]{this});
            return;
        }
        String str = this.livePerformanceId;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str).setWeexStart();
    }

    private void removeAsyncRenderAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144803725")) {
            ipChange.ipc$dispatch("1144803725", new Object[]{this});
        } else {
            getEngineInstance().removeFromMainThread(this.asyncRenderActionRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderAction() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910374285")) {
            ipChange.ipc$dispatch("910374285", new Object[]{this});
            return;
        }
        Log.e(TAG, "renderAction: hasFirstFrame:" + this.hasFirstFrame + "; mFinalJsBundle:" + this.mFinalJsBundle + "; mIsRendered:" + this.mIsRendered + ";");
        if (!this.hasFirstFrame || (str = this.mFinalJsBundle) == null || this.mIsRendered) {
            return;
        }
        this.mIsRendered = true;
        render(str, this.mFinalOptions, this.mFinalInitData);
        this.mFinalJsBundle = null;
        this.mFinalOptions = null;
        this.mFinalInitData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderImpl(final String str, final Map<String, Object> map, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043682366")) {
            ipChange.ipc$dispatch("-1043682366", new Object[]{this, str, map, str2});
            return;
        }
        perfMonitorPointError(TAG, "renderImpl.begin;");
        if (!WXSoInstallMgrSdk.isCPUSupport()) {
            this.mInitializedCount = 0;
            getAlarm().setErrorCode("1001").setErrorMessage("not isCPUSupport").commitFailure();
            performanceError("not isCPUSupport");
            perfMonitorPointError(TAG, "renderImpl; Error: isCPUSupport");
        } else if (WXSDKEngine.isInitialized()) {
            perfMonitorPointError(TAG, "renderImpl; Success1");
            if (this.mRealView != null) {
                perfMonitorPointError(TAG, "renderImpl; Success2");
                this.mRealView.render(str, map, str2);
            } else {
                performanceError("mRealView is null");
            }
        } else {
            int i = this.mInitializedCount;
            if (i >= 0 && i < getMaxCheckInitializedCount()) {
                this.mInitializedCount++;
                getEngineInstance().delayRunOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.LiveWeexWidget.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "391167672")) {
                            ipChange2.ipc$dispatch("391167672", new Object[]{this});
                        } else {
                            LiveWeexWidget.this.renderImpl(str, map, str2);
                        }
                    }
                }, getCheckInitializedInterval());
            } else {
                performanceError("not isInitialized timeout");
                this.mInitializedCount = 0;
                getAlarm().setErrorCode("1001").setErrorMessage("not isInitialized timeout").commitFailure();
                perfMonitorPointError(TAG, "renderImpl; Error: check timeout, WXSDKEngine.isInitialized()");
            }
        }
        perfMonitorPointError(TAG, "renderImpl.end;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWeexScreenType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1460695717")) {
            ipChange.ipc$dispatch("-1460695717", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.setScreenType(i);
        }
    }

    private void showKickoutDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770531928")) {
            ipChange.ipc$dispatch("-1770531928", new Object[]{this, str});
            return;
        }
        final Activity activity = (Activity) this.mContext;
        DagoLiveDialog.DialogConfig dialogConfig = new DagoLiveDialog.DialogConfig();
        dialogConfig.title = "";
        dialogConfig.content = "你已经被踢出了本直播间";
        dialogConfig.okText = "知道了";
        dialogConfig.isShowCancelBtn = false;
        dialogConfig.onOkBtnClickListener = new DagoLiveDialog.OnDialogButtonClickListener() { // from class: com.youku.live.livesdk.wkit.widget.LiveWeexWidget.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.livesdk.wkit.dialog.DagoLiveDialog.OnDialogButtonClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-544663559")) {
                    ipChange2.ipc$dispatch("-544663559", new Object[]{this, view});
                    return;
                }
                Activity activity2 = activity;
                if (activity2 == null || activity2.isFinishing()) {
                    return;
                }
                activity.finish();
            }
        };
        DagoLiveDialog dagoLiveDialog = new DagoLiveDialog(this.mContext, dialogConfig);
        dagoLiveDialog.setCanceledOnTouchOutside(false);
        dagoLiveDialog.setCancelable(false);
        dagoLiveDialog.show();
        dagoLiveDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.youku.live.livesdk.wkit.widget.LiveWeexWidget.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-89256574")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-89256574", new Object[]{this, dialogInterface, Integer.valueOf(i), keyEvent})).booleanValue();
                }
                return true;
            }
        });
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null) {
            frameLayout.postDelayed(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.LiveWeexWidget.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-198372843")) {
                        ipChange2.ipc$dispatch("-198372843", new Object[]{this});
                        return;
                    }
                    Activity activity2 = activity;
                    if (activity2 == null || activity2.isFinishing()) {
                        return;
                    }
                    activity.finish();
                }
            }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        }
    }

    private void updateData(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431780198")) {
            ipChange.ipc$dispatch("-431780198", new Object[]{this, str, str2});
            return;
        }
        this.mLiveId = str;
        this.mFinalJsBundle = str2;
        HashMap hashMap = new HashMap();
        if (getEngineInstance().getOptions() != null) {
            getEngineInstance().getOptions().toMap(hashMap);
        }
        try {
            ((ILaifengManagerInterface) Dsl.getService(ILaifengManagerInterface.class)).handleLaifengReoprtParmas(getEngineInstance().getContext(), hashMap);
        } catch (Throwable unused) {
        }
        hashMap.put("liveId", str);
        hashMap.put("id", str);
        SdkChannel sdkChannel = SdkChannel.LAIFENG;
        String tag = sdkChannel.tag();
        if (getEngineInstance() != null && getEngineInstance().getContext() != null) {
            tag = SdkChannel.getTag(getEngineInstance().getContext());
            if (SdkChannel.UNKNOWN.tag().equals(tag)) {
                tag = sdkChannel.tag();
            }
        }
        hashMap.put("sdkenv", tag);
        this.mFinalOptions = hashMap;
        if (this.hasFirstFrame) {
            asyncRenderAction(0);
        }
    }

    @Override // com.youku.live.widgets.protocol.ICall
    public void call(IEngineInstance iEngineInstance, String str, Map<String, Object> map, IResult iResult, IResult iResult2) {
        WeexWidgetView weexWidgetView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653817715")) {
            ipChange.ipc$dispatch("-1653817715", new Object[]{this, iEngineInstance, str, map, iResult, iResult2});
        } else if (!GLOBAL_EVENT.equals(str) || (weexWidgetView = this.mRealView) == null) {
        } else {
            weexWidgetView.getWXSDKInstance().fireGlobalEventCallback((String) map.get(GLOBAL_EVENT_NAME), map);
        }
    }

    public void debugBindBundle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1675777815")) {
            ipChange.ipc$dispatch("-1675777815", new Object[]{this, str});
        } else {
            this.mDebugBindBundle = str;
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-601478729")) {
            ipChange.ipc$dispatch("-601478729", new Object[]{this});
            return;
        }
        perfMonitorPoint(TAG, "destroy.begin");
        super.destroy();
        final WeexWidgetView weexWidgetView = this.mRealView;
        this.mRealView = null;
        WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.LiveWeexWidget.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "587681177")) {
                    ipChange2.ipc$dispatch("587681177", new Object[]{this});
                    return;
                }
                WeexWidgetView weexWidgetView2 = weexWidgetView;
                if (weexWidgetView2 != null) {
                    ViewParent parent = weexWidgetView2.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(weexWidgetView);
                    }
                    weexWidgetView.setRenderListener(null);
                    weexWidgetView.destroy();
                }
            }
        });
        perfMonitorPoint(TAG, "destroy.end");
    }

    public void didActive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068799380")) {
            ipChange.ipc$dispatch("-1068799380", new Object[]{this});
        } else if (this.mIsActive) {
        } else {
            onActiveStateChanged(true);
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724327805")) {
            ipChange.ipc$dispatch("724327805", new Object[]{this});
        } else {
            onActiveStateChanged(true);
        }
    }

    public void didDeactive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284709429")) {
            ipChange.ipc$dispatch("-1284709429", new Object[]{this});
        } else if (this.mIsActive) {
            onActiveStateChanged(false);
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938394603")) {
            ipChange.ipc$dispatch("-938394603", new Object[]{this});
        } else {
            onActiveStateChanged(false);
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586753592")) {
            ipChange.ipc$dispatch("586753592", new Object[]{this});
            return;
        }
        this.mIsActive = false;
        this.mIsRendered = false;
        this.mInitializedCount = 0;
        destroy();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol.IWidget
    public View getRealView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1327370566") ? (View) ipChange.ipc$dispatch("-1327370566", new Object[]{this}) : this.mRealView;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045645106")) {
            return (View) ipChange.ipc$dispatch("-2045645106", new Object[]{this, context});
        }
        this.mContext = context;
        if (this.mRootView == null) {
            this.mRootView = new FrameLayout(context);
        }
        if (this.mRealView == null) {
            this.mRealView = new WeexWidgetView(context);
        }
        this.mRootView.addView(this.mRealView, new FrameLayout.LayoutParams(-1, -1));
        this.mRealView.setRenderListener(this);
        this.mRealView.bindEngineInstance(getEngineInstance());
        return this.mRootView;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727119706")) {
            ipChange.ipc$dispatch("-727119706", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        super.initWithData(iEngineInstance, iWidget, iWidgetData);
        IProps options = getEngineInstance().getOptions();
        String string = options.getString("liveid", "");
        this.mDebugBindBundle = options.getString(SDKConstants.SDK_DEBUG_STATIC_WEEX_BUNDLE, null);
        getAlarm().addArg("liveId", string);
        this.hasFirstFrame = false;
        this.livePerformanceId = options.getString("livePerformanceId", null);
    }

    public void onActiveStateChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2032749763")) {
            ipChange.ipc$dispatch("2032749763", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsActive = z;
        if (z) {
            Object data = getEngineInstance().getData(LiveRoomConstants.DATA_KEY_LAIFENG_RECOMMEND_CURRENT);
            StringBuilder sb = new StringBuilder();
            sb.append("recommend current:");
            sb.append(data == null ? "null" : data.toString());
            Log.d("weex_widget", sb.toString());
            if (data instanceof SwitchItemModel) {
                SwitchItemModel switchItemModel = (SwitchItemModel) data;
                loadWithSwitchModel(switchItemModel);
                perfMonitorPoint(TAG, "onActiveStateChanged(" + z + "); active:" + z + "; roomId:" + switchItemModel.roomId);
                return;
            }
            return;
        }
        this.mIsRendered = false;
        removeAsyncRenderAction();
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.destroy();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790926456")) {
            return ((Boolean) ipChange.ipc$dispatch("-1790926456", new Object[]{this})).booleanValue();
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            return weexWidgetView.getWXSDKInstance().onBackPressed();
        }
        return false;
    }

    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1860719901")) {
            ipChange.ipc$dispatch("-1860719901", new Object[]{this, configuration});
            return;
        }
        final int i = configuration != null ? configuration.orientation : 1;
        getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.LiveWeexWidget.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-394886348")) {
                    ipChange2.ipc$dispatch("-394886348", new Object[]{this});
                } else {
                    LiveWeexWidget.this.setWeexScreenType(i);
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener
    public void onActivityConfigurationOrientationChanged(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28586142")) {
            ipChange.ipc$dispatch("28586142", new Object[]{this, Integer.valueOf(i)});
        } else {
            getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.LiveWeexWidget.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-787913358")) {
                        ipChange2.ipc$dispatch("-787913358", new Object[]{this});
                    } else {
                        LiveWeexWidget.this.setWeexScreenType(i);
                    }
                }
            });
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener
    public void onActivityLifecycleStateChanged(ActivityLifecycleState activityLifecycleState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621127978")) {
            ipChange.ipc$dispatch("1621127978", new Object[]{this, activityLifecycleState});
            return;
        }
        int i = AnonymousClass9.$SwitchMap$com$youku$live$widgets$ActivityLifecycleState[activityLifecycleState.ordinal()];
        if (i == 1) {
            onActivityPause();
        } else if (i != 2) {
        } else {
            onActivityResume();
        }
    }

    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789894039")) {
            ipChange.ipc$dispatch("-1789894039", new Object[]{this});
            return;
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.onActivityPause();
        }
    }

    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995646142")) {
            ipChange.ipc$dispatch("1995646142", new Object[]{this});
            return;
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.onActivityResume();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        WeexWidgetView weexWidgetView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477186616")) {
            ipChange.ipc$dispatch("-1477186616", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                loadWithRoomInfo((LiveFullInfoData) obj);
            }
        } else if (DagoDataCenterConstants.DAGO_LIVE_FULL_INFO_DATA.equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                loadWithRoomInfo((LiveFullInfoData) obj);
            }
        } else if ("dagoNotifyWeexGoneInPip".equals(str)) {
            Log.d("fornia", "pip live LiveWeexWidget DAGO_NOTIFY_WEEX_GONE_IN_PIP" + obj);
            if (obj == null || !(obj instanceof Boolean) || (weexWidgetView = this.mRealView) == null) {
                return;
            }
            weexWidgetView.setVisibility(((Boolean) obj).booleanValue() ? 8 : 0);
        } else if (LiveRoomConstants.DATA_KEY_LAIFENG_RECOMMEND_CURRENT.equals(str)) {
            if (obj instanceof SwitchItemModel) {
                loadWithSwitchModel((SwitchItemModel) obj);
            }
        } else if ("userRoomKickoutV2".equals(str)) {
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                showKickoutDialog((String) obj2);
            }
        } else if ("dagoSignalFirstFrame".equals(str)) {
            if (Boolean.TRUE.equals(obj)) {
                this.hasFirstFrame = true;
                if (this.mIsActive) {
                    asyncRenderAction(0);
                    return;
                }
                return;
            }
            this.hasFirstFrame = false;
            removeAsyncRenderAction();
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onException(WXSDKInstance wXSDKInstance, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "117922209")) {
            ipChange.ipc$dispatch("117922209", new Object[]{this, wXSDKInstance, str, str2});
            return;
        }
        performanceError(str + str2);
        AbsYoukuLiveAlarm errorCode = getAlarm().setErrorCode("1000");
        errorCode.setErrorMessage(str + str2).commitFailure();
        perfMonitorPointError(TAG, "Error: onException, s: " + str + ", s1: " + str2);
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRefreshSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1287502756")) {
            ipChange.ipc$dispatch("-1287502756", new Object[]{this, wXSDKInstance, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        perfMonitorPointError(TAG, "Info: onRefreshSuccess, i: " + i + ", i1: " + i2);
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRenderSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1124325397")) {
            ipChange.ipc$dispatch("-1124325397", new Object[]{this, wXSDKInstance, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        performanceEnd();
        getAlarm().commitSuccess();
        perfMonitorPointError(TAG, "Info: onRenderSuccess, i: " + i + ", i1: " + i2);
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onViewCreated(WXSDKInstance wXSDKInstance, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939396559")) {
            ipChange.ipc$dispatch("-939396559", new Object[]{this, wXSDKInstance, view});
        } else {
            perfMonitorPointError(TAG, "Info: onViewCreated");
        }
    }

    public void render(String str, Map<String, Object> map, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1704500866")) {
            ipChange.ipc$dispatch("1704500866", new Object[]{this, str, map, str2});
            return;
        }
        perfMonitorPointError(TAG, "renderStep; 0");
        String str3 = this.mDebugBindBundle;
        if (!TextUtils.isEmpty(str3)) {
            str = str3;
        }
        perfMonitorPointError(TAG, "renderStep; 1:" + str + "," + this.mIsActive + "," + this.mRealView);
        if (this.mRealView == null && this.mContext != null) {
            WeexWidgetView weexWidgetView = new WeexWidgetView(this.mContext);
            this.mRealView = weexWidgetView;
            weexWidgetView.setRenderListener(this);
            this.mRealView.bindEngineInstance(getEngineInstance());
            FrameLayout frameLayout = this.mRootView;
            if (frameLayout != null) {
                frameLayout.addView(this.mRealView, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        if (this.mRealView != null && !TextUtils.isEmpty(str)) {
            try {
                ((IWeexMananger) Dsl.getService(IWeexMananger.class)).tryInitAndRegister();
            } catch (Throwable unused) {
            }
            perfMonitorPointError(TAG, "renderStep; 2");
            performanceStart();
            renderImpl(str, map, str2);
        } else {
            perfMonitorPointError(TAG, "renderStep; 3");
            this.mFinalJsBundle = str;
            this.mFinalOptions = map;
            this.mFinalInitData = str2;
        }
        perfMonitorPointError(TAG, "renderStep; 4");
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void willMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92530646")) {
            ipChange.ipc$dispatch("-92530646", new Object[]{this});
        } else {
            initDataCenter();
        }
    }
}
