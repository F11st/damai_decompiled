package com.taobao.weex;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.adapter.IDrawableLoader;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.adapter.IWXJscProcessManager;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.appfram.websocket.IWebSocketAdapter;
import com.taobao.weex.bridge.EventResult;
import com.taobao.weex.bridge.NativeInvokeHelper;
import com.taobao.weex.bridge.SimpleJSCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.bridge.WXEaglePlugin;
import com.taobao.weex.bridge.WXModuleManager;
import com.taobao.weex.bridge.WXParams;
import com.taobao.weex.bridge.WXReactorPage;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.OnWXScrollListener;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.common.WXRefreshData;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.render.WXAbstractRenderContainer;
import com.taobao.weex.ui.action.GraphicActionAddElement;
import com.taobao.weex.ui.component.NestedContainer;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.ui.flat.FlatGUIContext;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.utils.FeatureSwitches;
import com.taobao.weex.utils.Trace;
import com.taobao.weex.utils.WXDeviceUtils;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXJsonUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXReflectionUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.cache.RegisterCache;
import com.taobao.weex.utils.tools.LogDetail;
import com.taobao.weex.utils.tools.TimeCalculator;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import tb.c31;
import tb.nz2;
import tb.r13;
import tb.r62;
import tb.vz2;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXSDKInstance implements View.OnLayoutChangeListener, IWXActivityStateListener {
    public static String ACTION_DEBUG_INSTANCE_REFRESH = "DEBUG_INSTANCE_REFRESH";
    public static String ACTION_INSTANCE_RELOAD = "INSTANCE_RELOAD";
    public static final String BUNDLE_URL = "bundleUrl";
    private static final String SOURCE_TEMPLATE_BASE64_MD5 = "templateSourceBase64MD5";
    public static String requestUrl = "requestUrl";
    static int sScreenHeight = -1;
    public WXBridgeManager.BundType bundleType;
    private List<JSONObject> componentsInfoExceedGPULimit;
    private boolean createInstanceHeartBeat;
    private boolean enableFullScreenHeight;
    private boolean enableLayerType;
    private boolean hasError;
    private boolean hasException;
    public PriorityQueue<WXEmbed> hiddenEmbeds;
    private Map<String, GraphicActionAddElement> inactiveAddElementAction;
    private boolean isCommit;
    private boolean isDestroy;
    public boolean isNewFsEnd;
    private boolean isPreDownLoad;
    private boolean isPreInit;
    private volatile boolean isPreRenderMode;
    private boolean isRenderSuccess;
    private boolean isViewDisAppear;
    private WXInstanceApm mApmForInstance;
    private boolean mAutoAdjustDeviceWidth;
    private String mBundleUrl;
    private ComponentObserver mComponentObserver;
    private Map<String, String> mContainerInfo;
    private Map<Long, ContentBoxMeasurement> mContentBoxMeasurements;
    Context mContext;
    private boolean mCreateInstance;
    private boolean mCurrentGround;
    private CustomFontNetworkHandler mCustomFontNetworkHandler;
    private boolean mDisableSkipFrameworkInit;
    private volatile WXEaglePlugin mEaglePlugin;
    private String mEaglePluginName;
    public boolean mEnd;
    public int mExecJSTraceId;
    private boolean mFixMultiThreadBug;
    @NonNull
    private FlatGUIContext mFlatGUIContext;
    private WXGlobalEventReceiver mGlobalEventReceiver;
    private HashMap<String, List<String>> mGlobalEvents;
    public boolean mHasCreateFinish;
    private C6970c mHttpListener;
    private ImageNetworkHandler mImageNetworkHandler;
    private final String mInstanceId;
    private List<c31> mInstanceOnFireEventInterceptorList;
    private int mInstanceViewPortWidth;
    private WXRefreshData mLastRefreshData;
    private List<String> mLayerOverFlowListeners;
    private int mMaxDeepLayer;
    private ConcurrentHashMap<String, C6944a> mModuleInterceptMap;
    private NativeInvokeHelper mNativeInvokeHelper;
    private boolean mNeedReLoad;
    private boolean mNeedValidate;
    private NestedInstanceInterceptor mNestedInstanceInterceptor;
    private boolean mPageDirty;
    private WXSDKInstance mParentInstance;
    private WXReactorPage mReactorPage;
    private long mRefreshStartTime;
    private WXAbstractRenderContainer mRenderContainer;
    private IWXRenderListener mRenderListener;
    public long mRenderStartNanos;
    public long mRenderStartTime;
    private WXRenderStrategy mRenderStrategy;
    private String mRenderType;
    private boolean mRendered;
    private WXComponent mRootComp;
    private ScrollView mScrollView;
    private IWXStatisticsListener mStatisticsListener;
    private StreamNetworkHandler mStreamNetworkHandler;
    public TimeCalculator mTimeCalculator;
    private boolean mUseScroller;
    private IWXUserTrackAdapter mUserTrackAdapter;
    private Map<String, Serializable> mUserTrackParams;
    private List<OnInstanceVisibleListener> mVisibleListeners;
    private List<ActionBarHandler> mWXActionbarHandlers;
    private List<OnBackPressedHandler> mWXBackPressedHandlers;
    private List<AbstractC6946c> mWXOnActivityResultHandlers;
    private WXPerformance mWXPerformance;
    private List<OnWXScrollListener> mWXScrollListeners;
    private WXScrollView.WXScrollViewListener mWXScrollViewListener;
    private WXProcessNotify mWxProcessNotify;
    private int maxHiddenEmbedsNum;
    public long[] measureTimes;
    public String[] mwxDims;
    public Map<String, List<String>> responseHeaders;
    public WeakReference<String> templateRef;
    private boolean trackComponent;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ActionBarHandler {
        boolean onSupportNavigateUp();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface CustomFontNetworkHandler {
        String fetchLocal(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ImageNetworkHandler {
        String fetchLocal(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ModuleInterceptCallback {
        C6945b CallModuleMethod(String str, String str2, JSONArray jSONArray, JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface NestedInstanceInterceptor {
        void onCreateNestInstance(WXSDKInstance wXSDKInstance, NestedContainer nestedContainer);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnBackPressedHandler {
        boolean onBackPressed();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnInstanceVisibleListener {
        void onAppear();

        void onDisappear();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface StreamNetworkHandler {
        String fetchLocal(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface WXProcessNotify {
        void crashed();

        void reboot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.WXSDKInstance$a */
    /* loaded from: classes11.dex */
    public static class C6944a {
        public ModuleInterceptCallback a;

        public C6944a(String str, ModuleInterceptCallback moduleInterceptCallback) {
            this.a = moduleInterceptCallback;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.WXSDKInstance$b */
    /* loaded from: classes11.dex */
    public static class C6945b {
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.WXSDKInstance$c */
    /* loaded from: classes11.dex */
    public static abstract class AbstractC6946c {
        private String a;

        public AbstractC6946c(String str) {
            this.a = str;
        }

        public boolean a(int i, int i2, Intent intent) {
            return b(i, i2, intent, this.a);
        }

        public abstract boolean b(int i, int i2, Intent intent, String str);
    }

    public WXSDKInstance(Context context) {
        this.mEnd = false;
        this.mHasCreateFinish = false;
        this.mBundleUrl = "";
        this.isDestroy = false;
        this.hasException = false;
        this.hasError = false;
        this.isRenderSuccess = false;
        this.createInstanceHeartBeat = false;
        this.isCommit = false;
        this.mGlobalEventReceiver = null;
        this.enableLayerType = true;
        this.mNeedValidate = false;
        this.mNeedReLoad = false;
        this.mUseScroller = false;
        this.mInstanceViewPortWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
        this.enableFullScreenHeight = false;
        this.mFlatGUIContext = new FlatGUIContext();
        this.isNewFsEnd = false;
        this.componentsInfoExceedGPULimit = new LinkedList();
        this.mExecJSTraceId = wz2.d();
        this.isViewDisAppear = false;
        this.mwxDims = new String[5];
        this.measureTimes = new long[5];
        this.responseHeaders = new HashMap();
        this.mRenderStrategy = WXRenderStrategy.APPEND_ASYNC;
        this.mDisableSkipFrameworkInit = false;
        this.mRenderType = "platform";
        this.mPageDirty = true;
        this.mFixMultiThreadBug = false;
        this.mAutoAdjustDeviceWidth = WXEnvironment.AUTO_ADJUST_ENV_DEVICE_WIDTH;
        this.mCurrentGround = false;
        this.inactiveAddElementAction = new ArrayMap();
        this.mContentBoxMeasurements = new ArrayMap();
        this.maxHiddenEmbedsNum = -1;
        this.mVisibleListeners = new ArrayList();
        this.isPreInit = false;
        this.isPreDownLoad = false;
        this.mHttpListener = null;
        this.mCreateInstance = true;
        this.mGlobalEvents = new HashMap<>();
        this.mModuleInterceptMap = new ConcurrentHashMap<>();
        this.mInstanceId = WXSDKManager.v().f();
        init(context);
    }

    private String assembleFilePath(Uri uri) {
        return (uri == null || uri.getPath() == null) ? "" : uri.getPath().replaceFirst("/", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkWhiteScreen() {
        if (!this.isDestroy && r13.b() && r13.f(this)) {
            WXErrorCode wXErrorCode = this.createInstanceHeartBeat ? WXErrorCode.WX_ERROR_WHITE_SCREEN : WXErrorCode.WHITE_SCREEN_RESPONSE_TIMEOUT;
            if (WXBridgeManager.getInstance().isRebootExceedLimit()) {
                wXErrorCode = WXErrorCode.WHITE_SCREEN_REBOOT_EXCEED_LIMIT;
            }
            HashMap hashMap = new HashMap(1);
            String g = r13.g(this);
            if (g == null) {
                g = "null viewTreeMsg";
            }
            hashMap.put("viewTree", g);
            hashMap.put("weexCoreThreadStackTrace", WXBridgeManager.getInstance().getWeexCoreThreadStackTrace());
            for (Map.Entry<String, String> entry : WXStateRecord.d().e().entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            WXExceptionUtils.commitCriticalExceptionRT(getInstanceId(), wXErrorCode, "checkEmptyScreen", wXErrorCode.getErrorMsg(), hashMap);
        }
    }

    private void destroyView(View view) {
        try {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    destroyView(viewGroup.getChildAt(i));
                }
                viewGroup.removeViews(0, ((ViewGroup) view).getChildCount());
                WXReflectionUtils.setValue(view, "mChildrenCount", 0);
            }
            if (view instanceof Destroyable) {
                ((Destroyable) view).destroy();
            }
        } catch (Exception e) {
            WXLogUtils.e("WXSDKInstance destroyView Exception: ", e);
        }
    }

    private void ensureRenderArchor() {
        if (this.mRenderContainer != null || getContext() == null) {
            return;
        }
        setRenderContainer(new RenderContainer(getContext()));
        this.mRenderContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRenderContainer.setBackgroundColor(0);
        this.mRenderContainer.setSDKInstance(this);
        this.mRenderContainer.addOnLayoutChangeListener(this);
    }

    private String filterUrlByEaglePlugin(String str) {
        Pair<String, WXEaglePlugin> a = C6967b.b().a(str);
        if (a != null) {
            String str2 = (String) a.first;
            this.mEaglePlugin = (WXEaglePlugin) a.second;
            String pluginName = this.mEaglePlugin.getPluginName();
            this.mEaglePluginName = pluginName;
            this.mRenderStrategy = C6967b.e(pluginName);
            return str2;
        }
        return null;
    }

    private void initFixMultiThreadFlag() {
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J != null) {
            this.mFixMultiThreadBug = Boolean.parseBoolean(J.getConfig("android_weex_ext_config", "fixMultiThreadBug", "true"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDataRender() {
        return getEaglePlugin() != null;
    }

    private static boolean isDisableSkipFrameworkInDataRender() {
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J == null) {
            return false;
        }
        return "true".equals(J.getConfig("wxeagle", "disable_skip_framework_init", "false"));
    }

    private void onInterceptInstanceEvent(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        List<c31> list = this.mInstanceOnFireEventInterceptorList;
        if (list == null) {
            return;
        }
        for (c31 c31Var : list) {
            c31Var.onInterceptFireEvent(str, str2, str3, map, map2);
        }
    }

    private void renderByUrlInternal(String str, String str2, Map<String, Object> map, String str3, WXRenderStrategy wXRenderStrategy) {
        LogDetail createLogDetail = this.mTimeCalculator.createLogDetail("renderByUrlInternal");
        createLogDetail.taskStart();
        ensureRenderArchor();
        String wrapPageName = wrapPageName(str, str2);
        this.mBundleUrl = str2;
        setRenderStrategy(wXRenderStrategy);
        if (WXSDKManager.v().B() != null) {
            this.mNeedValidate = WXSDKManager.v().B().needValidate(this.mBundleUrl);
        }
        String filterUrlByEaglePlugin = filterUrlByEaglePlugin(str2);
        if (filterUrlByEaglePlugin != null) {
            wXRenderStrategy = this.mRenderStrategy;
            str2 = filterUrlByEaglePlugin;
        }
        WXRenderStrategy wXRenderStrategy2 = wXRenderStrategy;
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> map2 = map;
        if (!map2.containsKey("bundleUrl")) {
            map2.put("bundleUrl", str2);
        }
        getWXPerformance().pageName = wrapPageName;
        this.mApmForInstance.l();
        this.mApmForInstance.z(wrapPageName);
        Uri parse = Uri.parse(str2);
        if (parse != null && TextUtils.equals(parse.getScheme(), "file")) {
            this.mApmForInstance.r(WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START);
            String loadFileOrAsset = WXFileUtils.loadFileOrAsset(assembleFilePath(parse), this.mContext);
            this.mApmForInstance.r(WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_END);
            render(wrapPageName, loadFileOrAsset, map2, str3, wXRenderStrategy2);
            return;
        }
        IWXHttpAdapter n = WXSDKManager.v().n();
        WXRequest wXRequest = new WXRequest();
        String uri = rewriteUri(Uri.parse(str2), "bundle").toString();
        wXRequest.url = uri;
        if (!TextUtils.isEmpty(uri)) {
            requestUrl = wXRequest.url;
        } else {
            requestUrl = wrapPageName;
        }
        if (wXRequest.paramMap == null) {
            wXRequest.paramMap = new HashMap();
        }
        wXRequest.instanceId = getInstanceId();
        wXRequest.paramMap.put("user-agent", nz2.a(this.mContext, WXEnvironment.getConfig()));
        wXRequest.paramMap.put("isBundleRequest", "true");
        C6970c c6970c = new C6970c(this, wrapPageName, map2, str3, wXRenderStrategy2, System.currentTimeMillis());
        this.mHttpListener = c6970c;
        c6970c.isPreDownLoadMode = this.isPreDownLoad;
        c6970c.setSDKInstance(this);
        this.mApmForInstance.r(WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START);
        n.sendRequest(wXRequest, this.mHttpListener);
        createLogDetail.taskEnd();
    }

    private void renderInternal(String str, String str2, Map<String, Object> map, String str3, WXRenderStrategy wXRenderStrategy) {
        if (this.mRendered || TextUtils.isEmpty(str2)) {
            return;
        }
        renderInternal(str, new r62(str2), map, str3, wXRenderStrategy);
    }

    private void setDeviceDisplay(float f, float f2, float f3) {
        WXBridgeManager.getInstance().setDeviceDisplay(getInstanceId(), f, f2, f3);
    }

    private void setEaglePlugin(String str) {
        this.mEaglePluginName = str;
        this.mEaglePlugin = C6967b.b().c(this.mEaglePluginName);
    }

    private void setRenderStrategy(WXRenderStrategy wXRenderStrategy) {
        this.mRenderStrategy = wXRenderStrategy;
        setEaglePlugin(C6967b.d(wXRenderStrategy));
    }

    private String wrapPageName(String str, String str2) {
        if (TextUtils.equals(str, "default")) {
            WXExceptionUtils.degradeUrl = str2;
            try {
                Uri parse = Uri.parse(str2);
                if (parse != null) {
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme(parse.getScheme());
                    builder.authority(parse.getAuthority());
                    builder.path(parse.getPath());
                    return builder.toString();
                }
            } catch (Exception unused) {
            }
            return str2;
        }
        return str;
    }

    public void OnVSync() {
        if (this.mFixMultiThreadBug) {
            if (this.mPageDirty) {
                WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WXBridgeManager.getInstance().notifyLayout(WXSDKInstance.this.getInstanceId())) {
                            WXBridgeManager.getInstance().forceLayout(WXSDKInstance.this.getInstanceId());
                        }
                    }
                });
            }
        } else if (WXBridgeManager.getInstance().notifyLayout(getInstanceId())) {
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.13
                @Override // java.lang.Runnable
                public void run() {
                    WXBridgeManager.getInstance().forceLayout(WXSDKInstance.this.getInstanceId());
                }
            });
        }
    }

    public void addContentBoxMeasurement(long j, ContentBoxMeasurement contentBoxMeasurement) {
        this.mContentBoxMeasurements.put(Long.valueOf(j), contentBoxMeasurement);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addEventListener(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.mGlobalEvents.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.mGlobalEvents.put(str, list);
        }
        list.add(str2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void addInActiveAddElementAction(String str, GraphicActionAddElement graphicActionAddElement) {
        this.inactiveAddElementAction.put(str, graphicActionAddElement);
    }

    public void addInstanceOnFireEventInterceptor(c31 c31Var) {
        if (c31Var == null || getInstanceOnFireEventInterceptorList().contains(c31Var)) {
            return;
        }
        getInstanceOnFireEventInterceptorList().add(c31Var);
    }

    public void addLayerOverFlowListener(String str) {
        if (this.mLayerOverFlowListeners == null) {
            this.mLayerOverFlowListeners = new ArrayList();
        }
        this.mLayerOverFlowListeners.add(str);
    }

    public void addOnInstanceVisibleListener(OnInstanceVisibleListener onInstanceVisibleListener) {
        this.mVisibleListeners.add(onInstanceVisibleListener);
    }

    public void addUserTrackParameter(String str, Serializable serializable) {
        if (this.mUserTrackParams == null) {
            this.mUserTrackParams = new ConcurrentHashMap();
        }
        this.mUserTrackParams.put(str, serializable);
    }

    public void callActionAddElementTime(long j) {
        WXPerformance wXPerformance = this.mWXPerformance;
        wXPerformance.mActionAddElementSumTime = (int) (wXPerformance.mActionAddElementSumTime + j);
    }

    public void callJsTime(long j) {
        if (this.mEnd) {
            return;
        }
        WXPerformance wXPerformance = this.mWXPerformance;
        wXPerformance.fsCallJsTotalTime += j;
        wXPerformance.fsCallJsTotalNum++;
    }

    public boolean checkModuleEventRegistered(String str, WXModule wXModule) {
        List<String> eventCallbacks;
        return (wXModule == null || (eventCallbacks = wXModule.getEventCallbacks(str)) == null || eventCallbacks.size() <= 0) ? false : true;
    }

    public void clearUserTrackParameters() {
        Map<String, Serializable> map = this.mUserTrackParams;
        if (map != null) {
            map.clear();
        }
    }

    public void createInstanceFuncHeartBeat() {
        WXLogUtils.d("createInstanceFuncHeartBeat: " + this.mInstanceId);
        this.createInstanceHeartBeat = true;
        getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE);
    }

    public final WXSDKInstance createNestedInstance(NestedContainer nestedContainer) {
        WXSDKInstance newNestedInstance = newNestedInstance();
        NestedInstanceInterceptor nestedInstanceInterceptor = this.mNestedInstanceInterceptor;
        if (nestedInstanceInterceptor != null) {
            nestedInstanceInterceptor.onCreateNestInstance(newNestedInstance, nestedContainer);
        }
        if (newNestedInstance != null) {
            newNestedInstance.setComponentObserver(getComponentObserver());
        }
        return newNestedInstance;
    }

    public synchronized void destroy() {
        if (!isDestroy()) {
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.8
                @Override // java.lang.Runnable
                public void run() {
                    if (WXSDKInstance.this.mReactorPage != null) {
                        WXSDKInstance.this.mReactorPage.unregisterJSContext();
                    }
                }
            });
            if (this.mParentInstance != null) {
                this.mParentInstance = null;
            }
            this.mApmForInstance.p();
            if (this.mRendered) {
                WXSDKManager.v().d(this.mInstanceId);
            }
            try {
                if (this.mGlobalEventReceiver != null) {
                    getContext().unregisterReceiver(this.mGlobalEventReceiver);
                    this.mGlobalEventReceiver = null;
                }
            } catch (IllegalArgumentException e) {
                WXLogUtils.w(WXLogUtils.getStackTrace(e));
            }
            WXComponent wXComponent = this.mRootComp;
            if (wXComponent != null) {
                wXComponent.destroy();
                this.mRootComp = null;
            }
            WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
            if (wXAbstractRenderContainer != null) {
                destroyView(wXAbstractRenderContainer);
            }
            HashMap<String, List<String>> hashMap = this.mGlobalEvents;
            if (hashMap != null) {
                hashMap.clear();
            }
            if (this.mComponentObserver != null) {
                this.mComponentObserver = null;
            }
            List<String> list = this.mLayerOverFlowListeners;
            if (list != null) {
                list.clear();
            }
            List<AbstractC6946c> list2 = this.mWXOnActivityResultHandlers;
            if (list2 != null && !list2.isEmpty()) {
                this.mWXOnActivityResultHandlers.clear();
            }
            List<OnBackPressedHandler> list3 = this.mWXBackPressedHandlers;
            if (list3 != null && !list3.isEmpty()) {
                this.mWXBackPressedHandlers.clear();
            }
            List<ActionBarHandler> list4 = this.mWXActionbarHandlers;
            if (list4 != null && !list4.isEmpty()) {
                this.mWXActionbarHandlers.clear();
            }
            getFlatUIContext().destroy();
            this.mFlatGUIContext = null;
            this.mInstanceOnFireEventInterceptorList = null;
            this.mWXScrollListeners = null;
            this.mWXActionbarHandlers = null;
            this.mWXBackPressedHandlers = null;
            this.mRenderContainer = null;
            this.mNestedInstanceInterceptor = null;
            this.mUserTrackAdapter = null;
            this.mScrollView = null;
            this.mContext = null;
            this.mRenderListener = null;
            this.isDestroy = true;
            this.mStatisticsListener = null;
            Map<String, List<String>> map = this.responseHeaders;
            if (map != null) {
                map.clear();
            }
            if (this.templateRef != null) {
                this.templateRef = null;
            }
            Map<Long, ContentBoxMeasurement> map2 = this.mContentBoxMeasurements;
            if (map2 != null) {
                map2.clear();
            }
            if (!this.mModuleInterceptMap.isEmpty()) {
                this.mModuleInterceptMap.clear();
            }
            this.mWXPerformance.afterInstanceDestroy(this.mInstanceId);
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.9
                @Override // java.lang.Runnable
                public void run() {
                    WXBridgeManager.getInstance().onInstanceClose(WXSDKInstance.this.getInstanceId());
                    WXSDKInstance.this.inactiveAddElementAction.clear();
                }
            });
            WXBridgeManager.getInstance().postDelay(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.10
                @Override // java.lang.Runnable
                public void run() {
                    WXSDKManager.v().i().remove(WXSDKInstance.this.mInstanceId);
                }
            }, 1000L);
        }
    }

    public void enableLayerType(boolean z) {
        this.enableLayerType = z;
    }

    public void fireEvent(String str, String str2, Map<String, Object> map, Map<String, Object> map2, List<Object> list) {
        fireEvent(str, str2, map, map2, list, null);
    }

    public void fireGlobalEventCallback(String str, Map<String, Object> map) {
        List<String> list = this.mGlobalEvents.get(str);
        if (list != null) {
            for (String str2 : list) {
                WXSDKManager.v().b(this.mInstanceId, str2, map, true);
            }
        }
    }

    public void fireModuleEvent(String str, WXModule wXModule, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || wXModule == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("module", wXModule.getModuleName());
        hashMap.put("data", map);
        List<String> eventCallbacks = wXModule.getEventCallbacks(str);
        if (eventCallbacks != null) {
            for (String str2 : eventCallbacks) {
                SimpleJSCallback simpleJSCallback = new SimpleJSCallback(this.mInstanceId, str2);
                if (wXModule.isOnce(str2)) {
                    simpleJSCallback.invoke(hashMap);
                } else {
                    simpleJSCallback.invokeAndKeepAlive(hashMap);
                }
            }
        }
    }

    public void firstScreenCreateInstanceTime(long j) {
        if (this.mCreateInstance) {
            this.mWXPerformance.firstScreenJSFExecuteTime = j - this.mRenderStartTime;
            this.mCreateInstance = false;
        }
    }

    public WXInstanceApm getApmForInstance() {
        return this.mApmForInstance;
    }

    @Nullable
    public String getBundleUrl() {
        return this.mBundleUrl;
    }

    public ComponentObserver getComponentObserver() {
        return this.mComponentObserver;
    }

    public List<JSONObject> getComponentsExceedGPULimit() {
        return this.componentsInfoExceedGPULimit;
    }

    public Map<String, String> getContainerInfo() {
        return this.mContainerInfo;
    }

    public View getContainerView() {
        return this.mRenderContainer;
    }

    public ContentBoxMeasurement getContentBoxMeasurement(long j) {
        return this.mContentBoxMeasurements.get(Long.valueOf(j));
    }

    public Context getContext() {
        return this.mContext;
    }

    public CustomFontNetworkHandler getCustomFontNetworkHandler() {
        return this.mCustomFontNetworkHandler;
    }

    public IDrawableLoader getDrawableLoader() {
        return WXSDKManager.v().l();
    }

    public WXEaglePlugin getEaglePlugin() {
        return this.mEaglePlugin;
    }

    public String getEaglePluginName() {
        return this.mEaglePluginName;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FlatGUIContext getFlatUIContext() {
        return this.mFlatGUIContext;
    }

    public ImageNetworkHandler getImageNetworkHandler() {
        return this.mImageNetworkHandler;
    }

    public IWXImgLoaderAdapter getImgLoaderAdapter() {
        return WXSDKManager.v().o();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public GraphicActionAddElement getInActiveAddElementAction(String str) {
        return this.inactiveAddElementAction.get(str);
    }

    public String getInstanceId() {
        return this.mInstanceId;
    }

    public List<c31> getInstanceOnFireEventInterceptorList() {
        if (this.mInstanceOnFireEventInterceptorList == null) {
            this.mInstanceOnFireEventInterceptorList = new ArrayList();
        }
        return this.mInstanceOnFireEventInterceptorList;
    }

    public int getInstanceViewPortWidth() {
        return this.mInstanceViewPortWidth;
    }

    public List<String> getLayerOverFlowListeners() {
        return this.mLayerOverFlowListeners;
    }

    public int getMaxDeepLayer() {
        return this.mMaxDeepLayer;
    }

    public int getMaxHiddenEmbedsNum() {
        return this.maxHiddenEmbedsNum;
    }

    public NativeInvokeHelper getNativeInvokeHelper() {
        return this.mNativeInvokeHelper;
    }

    public WXSDKInstance getParentInstance() {
        return this.mParentInstance;
    }

    public WXReactorPage getReactorPage() {
        return this.mReactorPage;
    }

    public int getRenderContainerPaddingLeft() {
        WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer != null) {
            return wXAbstractRenderContainer.getPaddingLeft();
        }
        return 0;
    }

    public int getRenderContainerPaddingRight() {
        WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer != null) {
            return wXAbstractRenderContainer.getPaddingRight();
        }
        return 0;
    }

    public int getRenderContainerPaddingTop() {
        WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer != null) {
            return wXAbstractRenderContainer.getPaddingTop();
        }
        return 0;
    }

    public WXRenderStrategy getRenderStrategy() {
        return this.mRenderStrategy;
    }

    public String getRenderType() {
        return this.mRenderType;
    }

    public WXComponent getRootComponent() {
        return this.mRootComp;
    }

    public View getRootView() {
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent == null) {
            return null;
        }
        return wXComponent.getRealView();
    }

    public ScrollView getScrollView() {
        return this.mScrollView;
    }

    @Deprecated
    public WXScrollView.WXScrollViewListener getScrollViewListener() {
        return this.mWXScrollViewListener;
    }

    public StreamNetworkHandler getStreamNetworkHandler() {
        return this.mStreamNetworkHandler;
    }

    public String getTemplate() {
        WeakReference<String> weakReference = this.templateRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getTemplateInfo() {
        String template = getTemplate();
        if (template == null) {
            return " template md5 null ,httpHeader:" + JSON.toJSONString(this.responseHeaders);
        } else if (TextUtils.isEmpty(template)) {
            return " template md5  length 0 ,httpHeader" + JSON.toJSONString(this.responseHeaders);
        } else {
            try {
                byte[] bytes = template.getBytes("UTF-8");
                String md5 = WXFileUtils.md5(bytes);
                String base64Md5 = WXFileUtils.base64Md5(bytes);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(md5);
                arrayList2.add(base64Md5);
                this.responseHeaders.put("templateSourceMD5", arrayList);
                this.responseHeaders.put(SOURCE_TEMPLATE_BASE64_MD5, arrayList2);
                return " template md5 " + md5 + " length " + bytes.length + " base64 md5 " + base64Md5 + " response header " + JSON.toJSONString(this.responseHeaders);
            } catch (Exception unused) {
                return "template md5 getBytes error";
            }
        }
    }

    public Context getUIContext() {
        return this.mContext;
    }

    public URIAdapter getURIAdapter() {
        return WXSDKManager.v().A();
    }

    public Map<String, Serializable> getUserTrackParams() {
        return this.mUserTrackParams;
    }

    public IWXHttpAdapter getWXHttpAdapter() {
        return WXSDKManager.v().n();
    }

    public WXPerformance getWXPerformance() {
        return this.mWXPerformance;
    }

    public synchronized List<OnWXScrollListener> getWXScrollListeners() {
        return this.mWXScrollListeners;
    }

    public IWXStatisticsListener getWXStatisticsListener() {
        return this.mStatisticsListener;
    }

    @Nullable
    public IWebSocketAdapter getWXWebSocketAdapter() {
        return WXSDKManager.v().u();
    }

    public int getWeexHeight() {
        WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer == null) {
            return 0;
        }
        return wXAbstractRenderContainer.getHeight();
    }

    public int getWeexWidth() {
        WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer == null) {
            return 0;
        }
        return wXAbstractRenderContainer.getWidth();
    }

    public WXProcessNotify getWxProcessNotify() {
        return this.mWxProcessNotify;
    }

    public boolean hasModuleIntercept(String str) {
        return this.mModuleInterceptMap.containsKey(str);
    }

    public void init(Context context) {
        initFixMultiThreadFlag();
        RegisterCache.getInstance().idle(true);
        this.mContext = context;
        this.mContainerInfo = new HashMap(4);
        this.mNativeInvokeHelper = new NativeInvokeHelper(this.mInstanceId);
        if (this.mWXPerformance == null) {
            this.mWXPerformance = new WXPerformance(this.mInstanceId);
        }
        if (this.mApmForInstance == null) {
            this.mApmForInstance = new WXInstanceApm(this.mInstanceId);
        }
        WXPerformance wXPerformance = this.mWXPerformance;
        wXPerformance.WXSDKVersion = WXEnvironment.WXSDK_VERSION;
        wXPerformance.JSLibInitTime = WXEnvironment.sJSLibInitTime;
        this.mUserTrackAdapter = WXSDKManager.v().t();
        WXSDKManager.v().i().put(this.mInstanceId, this);
        this.mContainerInfo.put(WXInstanceApm.KEY_PAGE_PROPERTIES_CONTAINER_NAME, context instanceof Activity ? context.getClass().getSimpleName() : "unKnowContainer");
        this.mContainerInfo.put(WXInstanceApm.KEY_PAGE_PROPERTIES_INSTANCE_TYPE, "page");
        this.mDisableSkipFrameworkInit = isDisableSkipFrameworkInDataRender();
        if (this.mTimeCalculator == null) {
            this.mTimeCalculator = new TimeCalculator(this);
        }
    }

    public boolean isAutoAdjustDeviceWidth() {
        return this.mAutoAdjustDeviceWidth;
    }

    public boolean isContentMd5Match() {
        Map<String, List<String>> map = this.responseHeaders;
        if (map == null) {
            return true;
        }
        List<String> list = map.get("Content-Md5");
        if (list == null) {
            list = this.responseHeaders.get("content-md5");
        }
        if (list != null && list.size() > 0) {
            String str = list.get(0);
            List<String> list2 = this.responseHeaders.get(SOURCE_TEMPLATE_BASE64_MD5);
            if (list2 == null) {
                getTemplateInfo();
                list2 = this.responseHeaders.get(SOURCE_TEMPLATE_BASE64_MD5);
            }
            if (list2 != null && list2.size() != 0) {
                return str.equals(list2.get(0));
            }
        }
        return true;
    }

    public boolean isDestroy() {
        return this.isDestroy;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isFullScreenHeightEnabled() {
        return this.enableFullScreenHeight;
    }

    public boolean isHasException() {
        return this.hasException;
    }

    public boolean isLayerTypeEnabled() {
        return this.enableLayerType;
    }

    public boolean isNeedReLoad() {
        return this.mNeedReLoad;
    }

    public boolean isNeedValidate() {
        return this.mNeedValidate;
    }

    public boolean isPageDirty() {
        return this.mPageDirty;
    }

    public boolean isPreDownLoad() {
        return this.isPreDownLoad;
    }

    public boolean isPreInitMode() {
        return this.isPreInit;
    }

    public boolean isPreRenderMode() {
        return this.isPreRenderMode;
    }

    public boolean isTrackComponent() {
        return this.trackComponent;
    }

    public boolean isUseScroller() {
        return this.mUseScroller;
    }

    public boolean isUsingEaglePlugin() {
        return this.mEaglePlugin != null;
    }

    public boolean isUsingReactorPage() {
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J != null) {
            return Boolean.parseBoolean(J.getConfig("android_weex_reactorpage_flag", "isUsingReactorPage", "true"));
        }
        return true;
    }

    public boolean isViewDisAppear() {
        return this.isViewDisAppear;
    }

    public C6945b moduleIntercept(String str, String str2, JSONArray jSONArray, JSONObject jSONObject) {
        ModuleInterceptCallback moduleInterceptCallback;
        C6944a c6944a = this.mModuleInterceptMap.get(str);
        if (c6944a == null || (moduleInterceptCallback = c6944a.a) == null) {
            return null;
        }
        return moduleInterceptCallback.CallModuleMethod(str, str2, jSONArray, jSONObject);
    }

    public void moveFixedView(View view) {
        if (this.mRenderContainer != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (viewGroup != this.mRenderContainer) {
                    viewGroup.removeView(view);
                    this.mRenderContainer.addView(view);
                    return;
                }
                return;
            }
            this.mRenderContainer.addView(view);
        }
    }

    protected WXSDKInstance newNestedInstance() {
        return new WXSDKInstance(this.mContext);
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public boolean onActivityBack() {
        WXModuleManager.onActivityBack(getInstanceId());
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            return wXComponent.onActivityBack();
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely, onActivityBack can not be call!");
            return false;
        }
        return false;
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityCreate() {
        WXModuleManager.onActivityCreate(getInstanceId());
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityCreate();
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely,onActivityCreate can not be call!");
        }
        this.mGlobalEventReceiver = new WXGlobalEventReceiver(this);
        try {
            getContext().registerReceiver(this.mGlobalEventReceiver, new IntentFilter(WXGlobalEventReceiver.EVENT_ACTION));
        } catch (Throwable th) {
            WXLogUtils.e(th.getMessage());
            this.mGlobalEventReceiver = null;
        }
    }

    public void onActivityDestroy() {
        WXModuleManager.onActivityDestroy(getInstanceId());
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityDestroy();
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely, onActivityDestroy can not be call!");
        }
        this.mTimeCalculator.println();
        destroy();
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
        onViewDisappear();
        if (!this.isCommit) {
            if (this.mUseScroller) {
                this.mWXPerformance.useScroller = 1;
            }
            this.mWXPerformance.maxDeepViewLayer = getMaxDeepLayer();
            WXPerformance wXPerformance = this.mWXPerformance;
            wXPerformance.wxDims = this.mwxDims;
            wXPerformance.measureTimes = this.measureTimes;
            IWXUserTrackAdapter iWXUserTrackAdapter = this.mUserTrackAdapter;
            if (iWXUserTrackAdapter != null) {
                iWXUserTrackAdapter.commit(this.mContext, null, "load", wXPerformance, getUserTrackParams());
            }
            this.isCommit = true;
        }
        WXModuleManager.onActivityPause(getInstanceId());
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityPause();
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely,onActivityPause can not be call!");
        }
        if (!this.mCurrentGround) {
            WXLogUtils.i("Application to be in the backround");
            Intent intent = new Intent(WXGlobalEventReceiver.EVENT_ACTION);
            intent.putExtra("eventName", Constants.Event.PAUSE_EVENT);
            intent.putExtra(WXGlobalEventReceiver.EVENT_WX_INSTANCEID, getInstanceId());
            Context context = this.mContext;
            if (context != null) {
                context.sendBroadcast(intent);
            } else {
                try {
                    WXEnvironment.getApplication().sendBroadcast(intent);
                } catch (Exception e) {
                    WXLogUtils.e("weex", e);
                }
            }
            this.mCurrentGround = true;
        }
        if ((WXEnvironment.isApkDebugable() || WXEnvironment.isPerf()) && this.mApmForInstance != null) {
            WXLogUtils.e("PerformanceData " + this.mApmForInstance.A());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        WXModuleManager.onActivityResult(getInstanceId(), i, i2, intent);
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityResult(i, i2, intent);
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely, onActivityResult can not be call!");
        }
        List<AbstractC6946c> list = this.mWXOnActivityResultHandlers;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AbstractC6946c> it = this.mWXOnActivityResultHandlers.iterator();
        while (it.hasNext() && !it.next().a(i, i2, intent)) {
        }
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        WXModuleManager.onActivityResume(getInstanceId());
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityResume();
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely, onActivityResume can not be call!");
        }
        if (this.mCurrentGround) {
            WXLogUtils.i("Application  to be in the foreground");
            Intent intent = new Intent(WXGlobalEventReceiver.EVENT_ACTION);
            intent.putExtra("eventName", Constants.Event.RESUME_EVENT);
            intent.putExtra(WXGlobalEventReceiver.EVENT_WX_INSTANCEID, getInstanceId());
            Context context = this.mContext;
            if (context != null) {
                context.sendBroadcast(intent);
            } else {
                WXEnvironment.getApplication().sendBroadcast(intent);
            }
            this.mCurrentGround = false;
        }
        onViewAppear();
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStart() {
        WXModuleManager.onActivityStart(getInstanceId());
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityStart();
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely,onActivityStart can not be call!");
        }
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
        WXModuleManager.onActivityStop(getInstanceId());
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityStop();
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely, onActivityStop can not be call!");
        }
    }

    public boolean onBackPressed() {
        List<OnBackPressedHandler> list = this.mWXBackPressedHandlers;
        if (list != null) {
            for (OnBackPressedHandler onBackPressedHandler : list) {
                if (onBackPressedHandler.onBackPressed()) {
                    return true;
                }
            }
        }
        WXComponent rootComponent = getRootComponent();
        if (rootComponent != null) {
            WXEvent events = rootComponent.getEvents();
            if (events.contains(Constants.Event.NATIVE_BACK) && WXUtils.getBoolean(rootComponent.fireEventWait(Constants.Event.NATIVE_BACK, null).getResult(), Boolean.FALSE).booleanValue()) {
                return true;
            }
            boolean contains = events.contains(Constants.Event.CLICKBACKITEM);
            if (contains) {
                fireEvent(rootComponent.getRef(), Constants.Event.CLICKBACKITEM, null, null);
            }
            return contains;
        }
        return false;
    }

    public void onChangeElement(WXComponent wXComponent, boolean z) {
        WXAbstractRenderContainer wXAbstractRenderContainer;
        if (isDestroy() || (wXAbstractRenderContainer = this.mRenderContainer) == null || this.mWXPerformance == null || wXComponent == null || wXComponent.isIgnoreInteraction || wXAbstractRenderContainer.hasConsumeEvent()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.mHasCreateFinish || currentTimeMillis - this.mWXPerformance.renderTimeOrigin <= DanmakuFactory.DEFAULT_DANMAKU_DURATION) {
            if (wXComponent.mIsAddElementToTree) {
                getWXPerformance().localInteractionViewAddCount++;
                if (!z) {
                    getWXPerformance().interactionViewAddLimitCount++;
                }
                wXComponent.mIsAddElementToTree = false;
            }
            if (z) {
                return;
            }
            this.mApmForInstance.i(wXComponent);
        }
    }

    public void onComponentCreate(WXComponent wXComponent, long j) {
        WXPerformance wXPerformance = this.mWXPerformance;
        wXPerformance.mActionAddElementCount++;
        wXPerformance.mActionAddElementSumTime = (int) (wXPerformance.mActionAddElementSumTime + j);
        if (!this.mEnd) {
            wXPerformance.fsComponentCreateTime = (int) (wXPerformance.fsComponentCreateTime + j);
            wXPerformance.fsComponentCount++;
        }
        wXPerformance.componentCount++;
        wXPerformance.componentCreateTime += j;
    }

    public void onCreateFinish() {
        if (this.mHasCreateFinish || this.mContext == null) {
            return;
        }
        onViewAppear();
        WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        IWXRenderListener iWXRenderListener = this.mRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onViewCreated(this, wXAbstractRenderContainer);
        }
        IWXStatisticsListener iWXStatisticsListener = this.mStatisticsListener;
        if (iWXStatisticsListener != null) {
            iWXStatisticsListener.onFirstView();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        WXModuleManager.onCreateOptionsMenu(getInstanceId(), menu);
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onCreateOptionsMenu(menu);
            return true;
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely,onActivityStart can not be call!");
            return true;
        } else {
            return true;
        }
    }

    public void onHttpStart() {
        if (this.mEnd) {
            return;
        }
        this.mWXPerformance.fsRequestNum++;
    }

    public void onInstanceReady() {
        WXLogUtils.d("test->", "onInstanceReady");
        this.mApmForInstance.r(WXInstanceApm.KEY_PAGE_STAGES_CONTAINER_READY);
        if (this.isPreInit || this.isPreDownLoad) {
            this.mApmForInstance.q(this.isPreDownLoad);
            if (this.isPreDownLoad) {
                this.mHttpListener.onInstanceReady();
            }
        }
    }

    public void onJSException(final String str, final String str2, final String str3) {
        WXStateRecord d = WXStateRecord.d();
        String instanceId = getInstanceId();
        d.k(instanceId, "onJSException," + str + "," + str2 + "|" + str3);
        this.hasException = true;
        if (this.mRenderListener == null || this.mContext == null) {
            return;
        }
        WXLogUtils.e("onJSException " + str + "," + str3);
        runOnUiThread(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.6
            @Override // java.lang.Runnable
            public void run() {
                if (WXSDKInstance.this.mRenderListener == null || WXSDKInstance.this.mContext == null) {
                    return;
                }
                WXSDKInstance.this.mRenderListener.onException(WXSDKInstance.this, str, str2 + str3);
            }
        });
    }

    public void onLayoutChange(View view) {
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        onLayoutChange(view);
    }

    public void onOldFsRenderTimeLogic() {
        if (this.mEnd) {
            return;
        }
        this.mEnd = true;
        if (this.mStatisticsListener != null && this.mContext != null) {
            runOnUiThread(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.7
                @Override // java.lang.Runnable
                public void run() {
                    if (WXSDKInstance.this.mStatisticsListener == null || WXSDKInstance.this.mContext == null) {
                        return;
                    }
                    Trace.beginSection("onFirstScreen");
                    WXSDKInstance.this.mStatisticsListener.onFirstScreen();
                    Trace.endSection();
                }
            });
        }
        this.mApmForInstance.h();
        this.mWXPerformance.fsRenderTime = System.currentTimeMillis();
        this.mWXPerformance.screenRenderTime = System.currentTimeMillis() - this.mRenderStartTime;
    }

    public void onRefreshSuccess(int i, int i2) {
        IWXRenderListener iWXRenderListener = this.mRenderListener;
        if (iWXRenderListener == null || this.mContext == null) {
            return;
        }
        iWXRenderListener.onRefreshSuccess(this, i, i2);
    }

    public void onRenderError(final String str, final String str2) {
        this.hasError = true;
        WXStateRecord d = WXStateRecord.d();
        String instanceId = getInstanceId();
        d.k(instanceId, "onRenderError," + str + "," + str2);
        if (this.mRenderListener == null || this.mContext == null) {
            return;
        }
        WXLogUtils.e("onRenderError " + str + "," + str2);
        runOnUiThread(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.5
            @Override // java.lang.Runnable
            public void run() {
                if (WXSDKInstance.this.mRenderListener != null) {
                    WXSDKInstance wXSDKInstance = WXSDKInstance.this;
                    if (wXSDKInstance.mContext != null) {
                        wXSDKInstance.mRenderListener.onException(WXSDKInstance.this, str, str2);
                    }
                }
            }
        });
    }

    public void onRenderSuccess(int i, int i2) {
        this.isRenderSuccess = true;
        if (!this.isNewFsEnd) {
            getApmForInstance().j();
        }
        if (!getApmForInstance().d.containsKey(WXInstanceApm.KEY_PAGE_STAGES_INTERACTION)) {
            getApmForInstance().i(getRootComponent());
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mRenderStartTime;
        long[] renderFinishTime = WXBridgeManager.getInstance().getRenderFinishTime(getInstanceId());
        WXPerformance wXPerformance = this.mWXPerformance;
        wXPerformance.callBridgeTime = renderFinishTime[0];
        wXPerformance.cssLayoutTime = renderFinishTime[1];
        wXPerformance.parseJsonTime = renderFinishTime[2];
        wXPerformance.totalTime = currentTimeMillis;
        if (wXPerformance.screenRenderTime < 0.001d) {
            wXPerformance.screenRenderTime = currentTimeMillis;
        }
        IWXRenderListener iWXRenderListener = this.mRenderListener;
        if (iWXRenderListener != null && this.mContext != null) {
            iWXRenderListener.onRenderSuccess(this, i, i2);
            if (this.mUserTrackAdapter != null) {
                WXPerformance wXPerformance2 = new WXPerformance(this.mInstanceId);
                wXPerformance2.errCode = WXErrorCode.WX_SUCCESS.getErrorCode();
                wXPerformance2.args = getBundleUrl();
                this.mUserTrackAdapter.commit(this.mContext, null, IWXUserTrackAdapter.JS_BRIDGE, wXPerformance2, getUserTrackParams());
            }
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d(WXLogUtils.WEEX_PERF_TAG, this.mWXPerformance.toString());
            }
        }
        if (WXEnvironment.isPerf()) {
            WXLogUtils.e(WXLogUtils.WEEX_PERF_TAG, this.mWXPerformance.getPerfData());
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        WXModuleManager.onRequestPermissionsResult(getInstanceId(), i, strArr, iArr);
        WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onRequestPermissionsResult(i, strArr, iArr);
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.w("Warning :Component tree has not build completely, onRequestPermissionsResult can not be call!");
        }
    }

    public void onRootCreated(WXComponent wXComponent) {
        this.mRootComp = wXComponent;
        wXComponent.mDeepInComponentTree = 1;
        this.mRenderContainer.addView(wXComponent.getHostView());
        setSize(this.mRenderContainer.getWidth(), this.mRenderContainer.getHeight());
    }

    public boolean onSupportNavigateUp() {
        List<ActionBarHandler> list = this.mWXActionbarHandlers;
        if (list != null) {
            for (ActionBarHandler actionBarHandler : list) {
                if (actionBarHandler.onSupportNavigateUp()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void onUpdateFinish() {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("Instance onUpdateSuccess");
        }
    }

    public void onViewAppear() {
        this.isViewDisAppear = true;
        this.mApmForInstance.n();
        WXComponent rootComponent = getRootComponent();
        if (rootComponent != null) {
            fireEvent(rootComponent.getRef(), Constants.Event.VIEWAPPEAR, null, null);
            for (OnInstanceVisibleListener onInstanceVisibleListener : this.mVisibleListeners) {
                onInstanceVisibleListener.onAppear();
            }
        }
    }

    public void onViewDisappear() {
        this.isViewDisAppear = false;
        this.mApmForInstance.o();
        WXComponent rootComponent = getRootComponent();
        if (rootComponent != null) {
            fireEvent(rootComponent.getRef(), Constants.Event.VIEWDISAPPEAR, null, null);
            for (OnInstanceVisibleListener onInstanceVisibleListener : this.mVisibleListeners) {
                onInstanceVisibleListener.onDisappear();
            }
        }
    }

    public void preDownLoad(String str, Map<String, Object> map, String str2, WXRenderStrategy wXRenderStrategy) {
        this.isPreDownLoad = true;
        setRenderStrategy(wXRenderStrategy);
        this.mApmForInstance.z = false;
        renderByUrl(str, str, map, str2, wXRenderStrategy);
    }

    public void preInit(String str, String str2, Map<String, Object> map, String str3, WXRenderStrategy wXRenderStrategy) {
        this.isPreInit = true;
        setRenderStrategy(wXRenderStrategy);
        if (map == null) {
            map = new HashMap<>();
        }
        this.mApmForInstance.z = false;
        WXSDKManager.v().c(this, new r62(str2), map, str3);
    }

    public void refreshInstance(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        refreshInstance(WXJsonUtils.fromObjectToJSONString(map));
    }

    public synchronized void registerActionbarHandler(ActionBarHandler actionBarHandler) {
        if (actionBarHandler == null) {
            return;
        }
        if (this.mWXActionbarHandlers == null) {
            this.mWXActionbarHandlers = new ArrayList();
        }
        this.mWXActionbarHandlers.add(actionBarHandler);
    }

    @Deprecated
    public void registerActivityStateListener(IWXActivityStateListener iWXActivityStateListener) {
    }

    public synchronized void registerBackPressedHandler(OnBackPressedHandler onBackPressedHandler) {
        if (onBackPressedHandler == null) {
            return;
        }
        if (this.mWXBackPressedHandlers == null) {
            this.mWXBackPressedHandlers = new ArrayList();
        }
        this.mWXBackPressedHandlers.add(onBackPressedHandler);
    }

    public void registerModuleIntercept(String str, ModuleInterceptCallback moduleInterceptCallback) {
        if (TextUtils.isEmpty(str) || moduleInterceptCallback == null) {
            return;
        }
        this.mModuleInterceptMap.put(str, new C6944a(str, moduleInterceptCallback));
    }

    public synchronized void registerOnActivityResultHandler(AbstractC6946c abstractC6946c) {
        if (abstractC6946c == null) {
            return;
        }
        if (this.mWXOnActivityResultHandlers == null) {
            this.mWXOnActivityResultHandlers = new ArrayList();
        }
        this.mWXOnActivityResultHandlers.add(abstractC6946c);
    }

    public synchronized void registerOnWXScrollListener(OnWXScrollListener onWXScrollListener) {
        if (this.mWXScrollListeners == null) {
            this.mWXScrollListeners = new ArrayList();
        }
        this.mWXScrollListeners.add(onWXScrollListener);
    }

    public void registerProcessNotify(WXProcessNotify wXProcessNotify) {
        this.mWxProcessNotify = wXProcessNotify;
    }

    public void registerReactorJSContext(final long j) {
        if (isUsingReactorPage()) {
            if (WXBridgeManager.getInstance().getJSLooper() == Looper.myLooper()) {
                this.mReactorPage = vz2.b().a(j, getInstanceId());
            } else {
                WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.14
                    @Override // java.lang.Runnable
                    public void run() {
                        WXSDKInstance.this.mReactorPage = vz2.b().a(j, WXSDKInstance.this.getInstanceId());
                    }
                });
            }
        }
    }

    public void registerRenderListener(IWXRenderListener iWXRenderListener) {
        this.mRenderListener = iWXRenderListener;
    }

    @Deprecated
    public void registerScrollViewListener(WXScrollView.WXScrollViewListener wXScrollViewListener) {
        this.mWXScrollViewListener = wXScrollViewListener;
    }

    public void registerStatisticsListener(IWXStatisticsListener iWXStatisticsListener) {
        this.mStatisticsListener = iWXStatisticsListener;
    }

    @Deprecated
    public void reloadImages() {
    }

    public void reloadPage(boolean z) {
        WXSDKEngine.reload();
        if (z) {
            if (this.mContext != null) {
                Intent intent = new Intent();
                intent.setAction(ACTION_INSTANCE_RELOAD);
                intent.putExtra("url", this.mBundleUrl);
                this.mContext.sendBroadcast(intent);
                return;
            }
            return;
        }
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J != null) {
            boolean parseBoolean = Boolean.parseBoolean(J.getConfig("android_weex_ext_config", "degrade_to_h5_if_not_reload", "true"));
            WXLogUtils.e("degrade : " + parseBoolean);
            if (parseBoolean) {
                onJSException(String.valueOf(WXErrorCode.WX_ERR_RELOAD_PAGE.getErrorCode()), "Do not reloadPage", "Do not reloadPage degradeToH5");
                WXLogUtils.e("Do not reloadPage degradeToH5");
            }
        }
    }

    public void reloadPageLayout() {
        WXBridgeManager.getInstance().reloadPageLayout(getInstanceId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeEventListener(String str, String str2) {
        List<String> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (list = this.mGlobalEvents.get(str)) == null) {
            return;
        }
        list.remove(str2);
    }

    public void removeFixedView(View view) {
        WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer != null) {
            wXAbstractRenderContainer.removeView(view);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void removeInActiveAddElmentAction(String str) {
        this.inactiveAddElementAction.remove(str);
    }

    public void removeLayerOverFlowListener(String str) {
        List<String> list = this.mLayerOverFlowListeners;
        if (list != null) {
            list.remove(str);
        }
    }

    public void removeOnInstanceVisibleListener(OnInstanceVisibleListener onInstanceVisibleListener) {
        this.mVisibleListeners.remove(onInstanceVisibleListener);
    }

    public void removeUserTrackParameter(String str) {
        Map<String, Serializable> map = this.mUserTrackParams;
        if (map != null) {
            map.remove(str);
        }
    }

    public void render(String str, Map<String, Object> map, String str2) {
        render(str, map, str2, WXRenderStrategy.APPEND_ASYNC);
    }

    @Deprecated
    public void renderByUrl(String str, String str2, Map<String, Object> map, String str3, int i, int i2, WXRenderStrategy wXRenderStrategy) {
        renderByUrl(str, str2, map, str3, wXRenderStrategy);
    }

    public void renderReactor(long j, String str, String str2) {
        if (isUsingReactorPage()) {
            WXReactorPage wXReactorPage = this.mReactorPage;
            if (wXReactorPage != null) {
                wXReactorPage.setPageContext(j);
            }
            render("reactorPage", str, (Map<String, Object>) null, str2, this.mRenderStrategy);
        }
    }

    public void resetDeviceDisplayOfPage() {
        WXBridgeManager.getInstance().setDeviceDisplayOfPage(getInstanceId(), WXViewUtils.getScreenWidth(getContext()), WXViewUtils.getScreenHeight(getContext()));
    }

    public Uri rewriteUri(Uri uri, String str) {
        return getURIAdapter().rewrite(this, str, uri);
    }

    public void runOnUiThread(Runnable runnable) {
        WXSDKManager.v().N(runnable, 0L);
    }

    public void setAutoAdjustDeviceWidth(boolean z) {
        this.mAutoAdjustDeviceWidth = z;
    }

    @Deprecated
    public void setBizType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mWXPerformance.bizType = str;
    }

    @Deprecated
    public void setBundleUrl(String str) {
        this.mBundleUrl = str;
        if (WXSDKManager.v().B() != null) {
            this.mNeedValidate = WXSDKManager.v().B().needValidate(this.mBundleUrl);
        }
    }

    public void setComponentObserver(ComponentObserver componentObserver) {
        this.mComponentObserver = componentObserver;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setComponentsInfoExceedGPULimit(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return;
        }
        this.componentsInfoExceedGPULimit.add(jSONObject);
    }

    public void setContainerInfo(String str, String str2) {
        this.mContainerInfo.put(str, str2);
    }

    public void setContext(@NonNull Context context) {
        this.mContext = context;
    }

    public void setCustomFontNetworkHandler(CustomFontNetworkHandler customFontNetworkHandler) {
        this.mCustomFontNetworkHandler = customFontNetworkHandler;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setEnableFullScreenHeight(boolean z) {
        this.enableFullScreenHeight = z;
    }

    public void setHasException(boolean z) {
        this.hasException = z;
    }

    @Deprecated
    public void setIWXUserTrackAdapter(IWXUserTrackAdapter iWXUserTrackAdapter) {
    }

    public void setImageNetworkHandler(ImageNetworkHandler imageNetworkHandler) {
        this.mImageNetworkHandler = imageNetworkHandler;
    }

    public void setInstanceViewPortWidth(int i) {
        setInstanceViewPortWidth(i, false);
    }

    public void setMaxDeepLayer(int i) {
        this.mMaxDeepLayer = i;
        this.mApmForInstance.D(WXInstanceApm.KEY_PAGE_STATS_MAX_DEEP_VIEW, i);
    }

    public void setMaxDomDeep(int i) {
        this.mApmForInstance.D(WXInstanceApm.KEY_PAGE_STATS_MAX_DEEP_DOM, i);
        WXPerformance wXPerformance = this.mWXPerformance;
        if (wXPerformance != null && wXPerformance.maxDeepVDomLayer <= i) {
            wXPerformance.maxDeepVDomLayer = i;
        }
    }

    public void setMaxHiddenEmbedsNum(int i) {
        this.maxHiddenEmbedsNum = i;
    }

    public void setNeedLoad(boolean z) {
        this.mNeedReLoad = z;
    }

    public void setNestedInstanceInterceptor(NestedInstanceInterceptor nestedInstanceInterceptor) {
        this.mNestedInstanceInterceptor = nestedInstanceInterceptor;
    }

    public void setPageDirty(boolean z) {
        this.mPageDirty = z;
    }

    public void setPageKeepRawCssStyles() {
        WXBridgeManager.getInstance().setPageArgument(getInstanceId(), "reserveCssStyles", "true");
    }

    public void setParentInstance(WXSDKInstance wXSDKInstance) {
        this.mParentInstance = wXSDKInstance;
    }

    public void setPreRenderMode(final boolean z) {
        WXSDKManager.v().G().postOnUiThread(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.4
            @Override // java.lang.Runnable
            public void run() {
                WXSDKInstance.this.isPreRenderMode = z;
            }
        }, 0L);
    }

    public void setRenderContainer(RenderContainer renderContainer) {
        setWXAbstractRenderContainer(renderContainer);
    }

    public void setRenderStartTime(long j) {
        this.mRenderStartTime = j;
    }

    public void setRenderType(String str) {
        this.mRenderType = str;
    }

    public void setRootScrollView(ScrollView scrollView) {
        this.mScrollView = scrollView;
        WXScrollView.WXScrollViewListener wXScrollViewListener = this.mWXScrollViewListener;
        if (wXScrollViewListener == null || !(scrollView instanceof WXScrollView)) {
            return;
        }
        ((WXScrollView) scrollView).addScrollViewListener(wXScrollViewListener);
    }

    public void setSize(int i, int i2) {
        if (i > 0) {
            if ((!(i2 > 0) || !(!this.isDestroy)) || !this.mRendered || this.mRenderContainer == null) {
                return;
            }
            if (sScreenHeight < 0) {
                sScreenHeight = WXViewUtils.getScreenHeight(getContext());
            }
            int i3 = sScreenHeight;
            if (i3 > 0) {
                double d = (i2 / i3) * 100.0d;
                getApmForInstance().g(WXInstanceApm.KEY_PAGE_STATS_BODY_RATIO, d <= 100.0d ? d : 100.0d);
            }
            ViewGroup.LayoutParams layoutParams = this.mRenderContainer.getLayoutParams();
            if (layoutParams != null) {
                final float f = i;
                final float f2 = i2;
                if (this.mRenderContainer.getWidth() != i || this.mRenderContainer.getHeight() != i2) {
                    layoutParams.width = i;
                    layoutParams.height = i2;
                    this.mRenderContainer.setLayoutParams(layoutParams);
                }
                if (this.mRootComp != null) {
                    final boolean z = layoutParams.width == -2;
                    final boolean z2 = layoutParams.height == -2;
                    WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.11
                        @Override // java.lang.Runnable
                        public void run() {
                            WXBridgeManager.getInstance().setDefaultRootSize(WXSDKInstance.this.getInstanceId(), f, f2, z, z2);
                        }
                    });
                }
            }
        }
    }

    public void setStreamNetworkHandler(StreamNetworkHandler streamNetworkHandler) {
        this.mStreamNetworkHandler = streamNetworkHandler;
    }

    public void setTemplate(String str) {
        this.templateRef = new WeakReference<>(str);
    }

    public void setTrackComponent(boolean z) {
        this.trackComponent = z;
    }

    public void setUseSandBox(boolean z) {
        WXBridgeManager.getInstance().setSandBoxContext(z);
    }

    public void setUseScroller(boolean z) {
        this.mUseScroller = z;
    }

    public void setUseSingleProcess(boolean z) {
        WXBridgeManager.getInstance().setUseSingleProcess(z);
    }

    public void setWXAbstractRenderContainer(WXAbstractRenderContainer wXAbstractRenderContainer) {
        if (wXAbstractRenderContainer != null) {
            wXAbstractRenderContainer.setSDKInstance(this);
            wXAbstractRenderContainer.addOnLayoutChangeListener(this);
        }
        this.mRenderContainer = wXAbstractRenderContainer;
        if (wXAbstractRenderContainer != null && wXAbstractRenderContainer.getLayoutParams() != null && this.mRenderContainer.getLayoutParams().width == -2) {
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.1
                @Override // java.lang.Runnable
                public void run() {
                    WXBridgeManager.getInstance().setRenderContentWrapContentToCore(true, WXSDKInstance.this.getInstanceId());
                }
            });
        } else {
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.2
                @Override // java.lang.Runnable
                public void run() {
                    WXBridgeManager.getInstance().setRenderContentWrapContentToCore(false, WXSDKInstance.this.getInstanceId());
                }
            });
        }
    }

    public boolean skipFrameworkInit() {
        return (getEaglePlugin() == null || !getEaglePlugin().isSkipFrameworkInit(getInstanceId()) || this.mDisableSkipFrameworkInit) ? false : true;
    }

    public synchronized void unRegisterActionbarHandler(ActionBarHandler actionBarHandler) {
        List<ActionBarHandler> list = this.mWXActionbarHandlers;
        if (list != null && actionBarHandler != null) {
            list.remove(actionBarHandler);
        }
    }

    public synchronized void unRegisterBackPressedHandler(OnBackPressedHandler onBackPressedHandler) {
        List<OnBackPressedHandler> list = this.mWXBackPressedHandlers;
        if (list != null && onBackPressedHandler != null) {
            list.remove(onBackPressedHandler);
        }
    }

    public void unRegisterModuleIntercept(String str) {
        this.mModuleInterceptMap.remove(str);
    }

    public synchronized void unRegisterOnActivityResultHandler(AbstractC6946c abstractC6946c) {
        List<AbstractC6946c> list = this.mWXOnActivityResultHandlers;
        if (list != null && abstractC6946c != null) {
            list.remove(abstractC6946c);
        }
    }

    public void unRegisterProcessNotify() {
        this.mWxProcessNotify = null;
    }

    public void fireEvent(String str, String str2, Map<String, Object> map, Map<String, Object> map2, List<Object> list, EventResult eventResult) {
        int i;
        onInterceptInstanceEvent(getInstanceId(), str, str2, map, map2);
        WXPerformance wXPerformance = this.mWXPerformance;
        if (wXPerformance != null && (i = wXPerformance.fsCallEventTotalNum) < Integer.MAX_VALUE) {
            wXPerformance.fsCallEventTotalNum = i + 1;
        }
        this.mApmForInstance.C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_EVENT_NUM, 1.0d);
        WXBridgeManager.getInstance().fireEventOnNode(getInstanceId(), str, str2, map, map2, list, eventResult);
    }

    public void refreshInstance(String str) {
        if (str == null) {
            return;
        }
        this.mRefreshStartTime = System.currentTimeMillis();
        WXRefreshData wXRefreshData = this.mLastRefreshData;
        if (wXRefreshData != null) {
            wXRefreshData.isDirty = true;
        }
        this.mLastRefreshData = new WXRefreshData(str, false);
        WXSDKManager.v().O(this.mInstanceId, this.mLastRefreshData);
    }

    @Deprecated
    public void render(String str, Map<String, Object> map, String str2, WXRenderStrategy wXRenderStrategy) {
        render("default", str, map, str2, wXRenderStrategy);
    }

    public void renderByUrl(String str, String str2, Map<String, Object> map, String str3, WXRenderStrategy wXRenderStrategy) {
        renderByUrlInternal(str, str2, map, str3, wXRenderStrategy);
    }

    public void setInstanceViewPortWidth(int i, boolean z) {
        this.mInstanceViewPortWidth = i;
        this.mAutoAdjustDeviceWidth = false;
        if (z) {
            return;
        }
        WXBridgeManager.getInstance().setViewPortWidth(getInstanceId(), this.mInstanceViewPortWidth);
    }

    private void renderInternal(String str, r62 r62Var, Map<String, Object> map, String str2, WXRenderStrategy wXRenderStrategy) {
        if (this.mRendered || r62Var == null || r62Var.c()) {
            return;
        }
        LogDetail createLogDetail = this.mTimeCalculator.createLogDetail("renderInternal");
        setRenderStrategy(wXRenderStrategy);
        if (!this.mApmForInstance.m()) {
            this.mApmForInstance.l();
        }
        this.mApmForInstance.z(str);
        this.mApmForInstance.r(WXInstanceApm.KEY_PAGE_STAGES_RENDER_ORGIGIN);
        this.mApmForInstance.k();
        this.mWXPerformance.pageName = TextUtils.isEmpty(str) ? "defaultBundleUrl" : str;
        if (TextUtils.isEmpty(this.mBundleUrl)) {
            this.mBundleUrl = this.mWXPerformance.pageName;
        }
        if (wz2.b()) {
            wz2.C9890a c = wz2.c("executeBundleJS", this.mInstanceId, -1);
            c.d = this.mExecJSTraceId;
            c.f = this.mInstanceId;
            c.b = "JSThread";
            c.c = "B";
            c.a();
            this.mRenderStartNanos = System.nanoTime();
        }
        ensureRenderArchor();
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> map2 = map;
        if (WXEnvironment.sDynamicMode && !TextUtils.isEmpty(WXEnvironment.sDynamicUrl) && map2.get("dynamicMode") == null) {
            map2.put("dynamicMode", "true");
            renderByUrl(str, WXEnvironment.sDynamicUrl, map2, str2, wXRenderStrategy);
            return;
        }
        new TimeCalculator(this);
        this.mWXPerformance.JSTemplateSize = r62Var.d() / 1024.0f;
        this.mApmForInstance.g(WXInstanceApm.KEY_PAGE_STATS_BUNDLE_SIZE, this.mWXPerformance.JSTemplateSize);
        this.mRenderStartTime = System.currentTimeMillis();
        WXSDKManager.v().U(WXEnvironment.WEEX_CURRENT_KEY, str);
        if (this.mAutoAdjustDeviceWidth && WXDeviceUtils.isAutoResize(this.mContext)) {
            if (WXEnvironment.AUTO_UPDATE_APPLICATION_SCREEN_SIZE) {
                WXViewUtils.updateApplicationScreen(this.mContext);
            }
            WXParams initParams = WXBridgeManager.getInstance().getInitParams();
            if (initParams != null && !TextUtils.equals(initParams.getDeviceWidth(), String.valueOf(WXViewUtils.getScreenWidth(this.mContext)))) {
                initParams.setDeviceWidth(String.valueOf(WXViewUtils.getScreenWidth(this.mContext)));
                initParams.setDeviceHeight(String.valueOf(WXViewUtils.getScreenHeight(this.mContext)));
                float f = WXEnvironment.sApplication.getResources().getDisplayMetrics().density;
                WXEnvironment.addCustomOptions("scale", Float.toString(f));
                WXBridgeManager.getInstance().updateInitDeviceParams(initParams.getDeviceWidth(), initParams.getDeviceHeight(), Float.toString(f), WXViewUtils.getStatusBarHeight(this.mContext) > 0 ? String.valueOf(WXViewUtils.getStatusBarHeight(this.mContext)) : null);
                setDeviceDisplay(WXViewUtils.getScreenWidth(this.mContext), WXViewUtils.getScreenHeight(this.mContext), WXViewUtils.getScreenDensity(this.mContext));
            }
        }
        createLogDetail.taskStart();
        if (isPreInitMode()) {
            getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_START);
            WXBridgeManager.getInstance().loadJsBundleInPreInitMode(getInstanceId(), r62Var.b());
        } else {
            WXSDKManager.v().c(this, r62Var, map2, str2);
        }
        createLogDetail.taskEnd();
        this.mRendered = true;
        final IWXJscProcessManager F = WXSDKManager.v().F();
        if (F == null || !F.shouldReboot()) {
            return;
        }
        WXSDKManager.v().N(new Runnable() { // from class: com.taobao.weex.WXSDKInstance.3
            @Override // java.lang.Runnable
            public void run() {
                WXSDKInstance.this.checkWhiteScreen();
                if (WXSDKInstance.this.isDestroy || WXSDKInstance.this.hasException || WXSDKInstance.this.isRenderSuccess) {
                    return;
                }
                if ((WXSDKInstance.this.hasError && FeatureSwitches.isOpenWithConfig("checkWeexRenderError", "android_weex_ext_config", "checkWeexRenderError", false)) || WXSDKInstance.this.isDataRender() || WXSDKInstance.this.mReactorPage != null) {
                    return;
                }
                View containerView = WXSDKInstance.this.getContainerView();
                if ((containerView instanceof ViewGroup) && ((ViewGroup) containerView).getChildCount() == 0) {
                    if (F.withException(WXSDKInstance.this)) {
                        WXSDKInstance.this.onJSException(String.valueOf(WXErrorCode.WX_ERR_RELOAD_PAGE), "white screen", "No View in Container");
                    }
                    if (WXSDKInstance.this.createInstanceHeartBeat) {
                        return;
                    }
                    WXBridgeManager.getInstance().callReportCrashReloadPage(WXSDKInstance.this.mInstanceId, null);
                    WXLogUtils.e("callReportCrashReloadPage with jsc reboot");
                }
            }
        }, F.rebootTimeout());
    }

    public void render(String str, String str2, Map<String, Object> map, String str3, WXRenderStrategy wXRenderStrategy) {
        render(str, new r62(str2), map, str3, wXRenderStrategy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeEventListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mGlobalEvents.remove(str);
    }

    public void render(String str, r62 r62Var, Map<String, Object> map, String str2, WXRenderStrategy wXRenderStrategy) {
        this.mWXPerformance.beforeInstanceRender(this.mInstanceId);
        if (WXEnvironment.isApkDebugable() && "default".equals(str)) {
            if (getUIContext() != null) {
                new AlertDialog.Builder(getUIContext()).setTitle("Error: Missing pageName").setMessage("We highly recommend you to set pageName. Call\nWXSDKInstance#render(String pageName, String template, Map<String, Object> options, String jsonInitData, WXRenderStrategy flag)\nto fix it.").show();
                return;
            }
            return;
        }
        renderInternal(str, r62Var, map, str2, wXRenderStrategy);
    }

    public void fireEvent(String str, String str2, Map<String, Object> map, Map<String, Object> map2) {
        fireEvent(str, str2, map, map2, null);
    }

    public void fireEvent(String str, String str2, Map<String, Object> map) {
        fireEvent(str, str2, map, null);
    }

    public void fireEvent(String str, String str2) {
        fireEvent(str, str2, new HashMap());
    }

    public void render(String str, byte[] bArr, Map<String, Object> map, String str2) {
        render(str, new r62(bArr), map, str2, WXRenderStrategy.DATA_RENDER_BINARY);
    }

    @Deprecated
    public void render(String str, String str2, Map<String, Object> map, String str3, int i, int i2, WXRenderStrategy wXRenderStrategy) {
        render(str, str2, map, str3, wXRenderStrategy);
    }

    public void render(String str) {
        render("default", str, (Map<String, Object>) null, (String) null, this.mRenderStrategy);
    }

    @Deprecated
    public void render(String str, int i, int i2) {
        render(str);
    }

    public WXSDKInstance() {
        this.mEnd = false;
        this.mHasCreateFinish = false;
        this.mBundleUrl = "";
        this.isDestroy = false;
        this.hasException = false;
        this.hasError = false;
        this.isRenderSuccess = false;
        this.createInstanceHeartBeat = false;
        this.isCommit = false;
        this.mGlobalEventReceiver = null;
        this.enableLayerType = true;
        this.mNeedValidate = false;
        this.mNeedReLoad = false;
        this.mUseScroller = false;
        this.mInstanceViewPortWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
        this.enableFullScreenHeight = false;
        this.mFlatGUIContext = new FlatGUIContext();
        this.isNewFsEnd = false;
        this.componentsInfoExceedGPULimit = new LinkedList();
        this.mExecJSTraceId = wz2.d();
        this.isViewDisAppear = false;
        this.mwxDims = new String[5];
        this.measureTimes = new long[5];
        this.responseHeaders = new HashMap();
        this.mRenderStrategy = WXRenderStrategy.APPEND_ASYNC;
        this.mDisableSkipFrameworkInit = false;
        this.mRenderType = "platform";
        this.mPageDirty = true;
        this.mFixMultiThreadBug = false;
        this.mAutoAdjustDeviceWidth = WXEnvironment.AUTO_ADJUST_ENV_DEVICE_WIDTH;
        this.mCurrentGround = false;
        this.inactiveAddElementAction = new ArrayMap();
        this.mContentBoxMeasurements = new ArrayMap();
        this.maxHiddenEmbedsNum = -1;
        this.mVisibleListeners = new ArrayList();
        this.isPreInit = false;
        this.isPreDownLoad = false;
        this.mHttpListener = null;
        this.mCreateInstance = true;
        this.mGlobalEvents = new HashMap<>();
        this.mModuleInterceptMap = new ConcurrentHashMap<>();
        String f = WXSDKManager.v().f();
        this.mInstanceId = f;
        this.mWXPerformance = new WXPerformance(f);
        this.mApmForInstance = new WXInstanceApm(f);
        WXSDKManager.v().i().put(f, this);
        this.mTimeCalculator = new TimeCalculator(this);
        initFixMultiThreadFlag();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    WXSDKInstance(Context context, String str) {
        this.mEnd = false;
        this.mHasCreateFinish = false;
        this.mBundleUrl = "";
        this.isDestroy = false;
        this.hasException = false;
        this.hasError = false;
        this.isRenderSuccess = false;
        this.createInstanceHeartBeat = false;
        this.isCommit = false;
        this.mGlobalEventReceiver = null;
        this.enableLayerType = true;
        this.mNeedValidate = false;
        this.mNeedReLoad = false;
        this.mUseScroller = false;
        this.mInstanceViewPortWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
        this.enableFullScreenHeight = false;
        this.mFlatGUIContext = new FlatGUIContext();
        this.isNewFsEnd = false;
        this.componentsInfoExceedGPULimit = new LinkedList();
        this.mExecJSTraceId = wz2.d();
        this.isViewDisAppear = false;
        this.mwxDims = new String[5];
        this.measureTimes = new long[5];
        this.responseHeaders = new HashMap();
        this.mRenderStrategy = WXRenderStrategy.APPEND_ASYNC;
        this.mDisableSkipFrameworkInit = false;
        this.mRenderType = "platform";
        this.mPageDirty = true;
        this.mFixMultiThreadBug = false;
        this.mAutoAdjustDeviceWidth = WXEnvironment.AUTO_ADJUST_ENV_DEVICE_WIDTH;
        this.mCurrentGround = false;
        this.inactiveAddElementAction = new ArrayMap();
        this.mContentBoxMeasurements = new ArrayMap();
        this.maxHiddenEmbedsNum = -1;
        this.mVisibleListeners = new ArrayList();
        this.isPreInit = false;
        this.isPreDownLoad = false;
        this.mHttpListener = null;
        this.mCreateInstance = true;
        this.mGlobalEvents = new HashMap<>();
        this.mModuleInterceptMap = new ConcurrentHashMap<>();
        this.mInstanceId = str;
        init(context);
    }
}
