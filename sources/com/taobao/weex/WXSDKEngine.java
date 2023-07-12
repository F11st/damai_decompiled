package com.taobao.weex;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.taobao.weex.C6948a;
import com.taobao.weex.adapter.IDrawableLoader;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.adapter.IWXJsFileLoaderAdapter;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.appfram.clipboard.WXClipboardModule;
import com.taobao.weex.appfram.navigator.IActivityNavBarSetter;
import com.taobao.weex.appfram.navigator.INavigator;
import com.taobao.weex.appfram.navigator.WXNavigatorModule;
import com.taobao.weex.appfram.pickers.WXPickersModule;
import com.taobao.weex.appfram.storage.IWXStorageAdapter;
import com.taobao.weex.appfram.storage.WXStorageModule;
import com.taobao.weex.appfram.websocket.WebSocketModule;
import com.taobao.weex.bridge.ModuleFactory;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.bridge.WXModuleManager;
import com.taobao.weex.bridge.WXServiceManager;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.TypeModuleFactory;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXException;
import com.taobao.weex.common.WXInstanceWrap;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.http.WXStreamModule;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.ui.ExternalLoaderComponentHolder;
import com.taobao.weex.ui.IExternalComponentGetter;
import com.taobao.weex.ui.IExternalModuleGetter;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.SimpleComponentHolder;
import com.taobao.weex.ui.WXComponentRegistry;
import com.taobao.weex.ui.animation.WXAnimationModule;
import com.taobao.weex.ui.component.Textarea;
import com.taobao.weex.ui.component.WXA;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXDiv;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.ui.component.WXHeader;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.ui.component.WXIndicator;
import com.taobao.weex.ui.component.WXInput;
import com.taobao.weex.ui.component.WXLoading;
import com.taobao.weex.ui.component.WXLoadingIndicator;
import com.taobao.weex.ui.component.WXRefresh;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.component.WXSlider;
import com.taobao.weex.ui.component.WXSliderNeighbor;
import com.taobao.weex.ui.component.WXSwitch;
import com.taobao.weex.ui.component.WXText;
import com.taobao.weex.ui.component.WXVideo;
import com.taobao.weex.ui.component.WXWeb;
import com.taobao.weex.ui.component.list.HorizontalListComponent;
import com.taobao.weex.ui.component.list.SimpleListComponent;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.WXListComponent;
import com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList;
import com.taobao.weex.ui.component.richtext.WXRichText;
import com.taobao.weex.ui.config.AutoScanConfigRegister;
import com.taobao.weex.ui.module.ConsoleLogModule;
import com.taobao.weex.ui.module.WXDeviceInfoModule;
import com.taobao.weex.ui.module.WXLocaleModule;
import com.taobao.weex.ui.module.WXMetaModule;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.taobao.weex.ui.module.WXTimerModule;
import com.taobao.weex.ui.module.WXWebViewModule;
import com.taobao.weex.utils.LogLevel;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXSoInstallMgrSdk;
import com.taobao.weex.utils.batch.BatchOperationHelper;
import com.taobao.weex.utils.cache.RegisterCache;
import com.youku.arch.v3.data.Constants;
import com.youku.live.livesdk.wkit.widget.LiveWeexWidget;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tb.C9796v;
import tb.kh1;
import tb.vz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXSDKEngine implements Serializable {
    public static final String JS_FRAMEWORK_RELOAD = "js_framework_reload";
    private static final String TAG = "WXSDKEngine";
    private static final String V8_SO_NAME = "weexcore";
    private static volatile boolean mIsInit;
    private static volatile boolean mIsSoInit;
    private static final Object mLock = new Object();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class DestroyableModule extends WXModule implements Destroyable {
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.WXSDKEngine$a */
    /* loaded from: classes11.dex */
    public static abstract class AbstractC6943a<T extends DestroyableModule> extends TypeModuleFactory<T> {
    }

    public static void addCustomOptions(String str, String str2) {
        WXEnvironment.addCustomOptions(str, str2);
    }

    public static void callback(String str, String str2, Map<String, Object> map) {
        WXSDKManager.v().a(str, str2, map);
    }

    private static void doInitInternal(final Application application, final C6948a c6948a) {
        WXEnvironment.sApplication = application;
        if (application == null) {
            WXLogUtils.e(TAG, " doInitInternal application is null");
            WXErrorCode wXErrorCode = WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT;
            WXExceptionUtils.commitCriticalExceptionRT(null, wXErrorCode, "doInitInternal", wXErrorCode.getErrorMsg() + "WXEnvironment sApplication is null", null);
        }
        WXEnvironment.JsFrameworkInit = false;
        WXBridgeManager.getInstance().postWithName(new Runnable() { // from class: com.taobao.weex.WXSDKEngine.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                WXSDKManager v = WXSDKManager.v();
                v.M();
                C6948a c6948a2 = C6948a.this;
                if (c6948a2 != null) {
                    v.X(c6948a2);
                }
                WXSoInstallMgrSdk.init(application, v.r(), v.H());
                C6948a c6948a3 = C6948a.this;
                IWXUserTrackAdapter E = c6948a3 != null ? c6948a3.E() : null;
                boolean unused = WXSDKEngine.mIsSoInit = WXSoInstallMgrSdk.initSo("weexcore", 1, E);
                WXSoInstallMgrSdk.copyJssRuntimeSo();
                C6948a c6948a4 = C6948a.this;
                if (c6948a4 != null) {
                    for (String str : c6948a4.B()) {
                        WXSoInstallMgrSdk.initSo(str, 1, E);
                    }
                }
                C6967b.b().f(1, E);
                vz2.b().c(1, E);
                if (!WXSDKEngine.mIsSoInit) {
                    WXErrorCode wXErrorCode2 = WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT;
                    WXExceptionUtils.commitCriticalExceptionRT(null, wXErrorCode2, "doInitInternal", wXErrorCode2.getErrorMsg() + "isSoInit false", null);
                    return;
                }
                C6948a c6948a5 = C6948a.this;
                v.K(c6948a5 != null ? c6948a5.u() : null);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                WXEnvironment.sSDKInitExecuteTime = currentTimeMillis2;
                WXLogUtils.renderPerformanceLog("SDKInitExecuteTime", currentTimeMillis2);
            }
        }, null, "doInitWeexSdkInternal");
        WXStateRecord.d().o();
        register();
    }

    public static IActivityNavBarSetter getActivityNavBarSetter() {
        return WXSDKManager.v().h();
    }

    public static IDrawableLoader getDrawableLoader() {
        return WXSDKManager.v().l();
    }

    public static IWXHttpAdapter getIWXHttpAdapter() {
        return WXSDKManager.v().n();
    }

    public static IWXImgLoaderAdapter getIWXImgLoaderAdapter() {
        return WXSDKManager.v().o();
    }

    public static IWXJsFileLoaderAdapter getIWXJsFileLoaderAdapter() {
        return WXSDKManager.v().q();
    }

    public static IWXStorageAdapter getIWXStorageAdapter() {
        return WXSDKManager.v().s();
    }

    public static IWXUserTrackAdapter getIWXUserTrackAdapter() {
        return WXSDKManager.v().t();
    }

    public static INavigator getNavigator() {
        return WXSDKManager.v().x();
    }

    @Deprecated
    public static void init(Application application) {
        init(application, null);
    }

    public static void initialize(Application application, C6948a c6948a) {
        synchronized (mLock) {
            if (mIsInit) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            WXEnvironment.sSDKInitStart = currentTimeMillis;
            if (WXEnvironment.isApkDebugable(application)) {
                WXEnvironment.sLogLevel = LogLevel.DEBUG;
            } else {
                WXEnvironment.sLogLevel = LogLevel.WARN;
            }
            doInitInternal(application, c6948a);
            registerApplicationOptions(application);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            WXEnvironment.sSDKInitInvokeTime = currentTimeMillis2;
            WXLogUtils.renderPerformanceLog("SDKInitInvokeTime", currentTimeMillis2);
            mIsInit = true;
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (mLock) {
            z = mIsInit && WXEnvironment.JsFrameworkInit;
        }
        return z;
    }

    public static boolean isSoInitialized() {
        boolean z;
        synchronized (mLock) {
            z = mIsSoInit;
        }
        return z;
    }

    private static void register() {
        BatchOperationHelper batchOperationHelper = new BatchOperationHelper(WXBridgeManager.getInstance());
        try {
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXText.class, new WXText.Creator()), false, "text");
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXDiv.class, new WXDiv.Ceator()), false, "container", WXBasicComponentType.DIV, "header", WXBasicComponentType.FOOTER);
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXImage.class, new WXImage.Creator()), false, "image", "img");
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXScroller.class, new WXScroller.Creator()), false, WXBasicComponentType.SCROLLER);
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXSlider.class, new WXSlider.Creator()), true, "slider", WXBasicComponentType.CYCLE_SLIDER);
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXSliderNeighbor.class, new WXSliderNeighbor.Creator()), true, WXBasicComponentType.SLIDER_NEIGHBOR);
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXCell.class, new WXCell.Creator()), true, WXBasicComponentType.CELL);
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXListComponent.class, new WXListComponent.Creator()), true, "list", WXBasicComponentType.VLIST, WXBasicComponentType.RECYCLER, WXBasicComponentType.WATERFALL);
            registerComponent((IFComponentHolder) new SimpleComponentHolder(WXRichText.class, new WXRichText.Creator()), false, WXBasicComponentType.RICHTEXT);
            registerComponent((Class<? extends WXComponent>) SimpleListComponent.class, false, "simplelist");
            registerComponent((Class<? extends WXComponent>) WXRecyclerTemplateList.class, false, WXBasicComponentType.RECYCLE_LIST);
            registerComponent((Class<? extends WXComponent>) HorizontalListComponent.class, false, WXBasicComponentType.HLIST);
            registerComponent(WXBasicComponentType.CELL_SLOT, (Class<? extends WXComponent>) WXCell.class, true);
            registerComponent(WXBasicComponentType.INDICATOR, (Class<? extends WXComponent>) WXIndicator.class, true);
            registerComponent("video", (Class<? extends WXComponent>) WXVideo.class, false);
            registerComponent("input", (Class<? extends WXComponent>) WXInput.class, false);
            registerComponent(WXBasicComponentType.TEXTAREA, (Class<? extends WXComponent>) Textarea.class, false);
            registerComponent("switch", (Class<? extends WXComponent>) WXSwitch.class, false);
            registerComponent("a", (Class<? extends WXComponent>) WXA.class, false);
            registerComponent(WXBasicComponentType.EMBED, (Class<? extends WXComponent>) WXEmbed.class, true);
            registerComponent("web", WXWeb.class);
            registerComponent("refresh", WXRefresh.class);
            registerComponent("loading", WXLoading.class);
            registerComponent(WXBasicComponentType.LOADING_INDICATOR, WXLoadingIndicator.class);
            registerComponent("header", WXHeader.class);
            registerModule("modal", WXModalUIModule.class);
            registerModule("instanceWrap", WXInstanceWrap.class);
            registerModule(C9796v.TAK_ABILITY_SHOW_POP_ANIMATION, WXAnimationModule.class);
            registerModule(C3834a.C3837c.d, WXWebViewModule.class);
            registerModule("navigator", WXNavigatorModule.class);
            registerModule(kh1.RESOURCE_STREAM, WXStreamModule.class);
            registerModule("timer", WXTimerModule.class);
            registerModule("storage", WXStorageModule.class);
            registerModule("clipboard", WXClipboardModule.class);
            registerModule(LiveWeexWidget.GLOBAL_EVENT, WXGlobalEventModule.class);
            registerModule("picker", WXPickersModule.class);
            registerModule("meta", WXMetaModule.class);
            registerModule("webSocket", WebSocketModule.class);
            registerModule("locale", WXLocaleModule.class);
            registerModule(AbstractC3893a.I, WXDeviceInfoModule.class);
            registerModule("sdk-console-log", ConsoleLogModule.class);
        } catch (WXException e) {
            WXLogUtils.e("[WXSDKEngine] register:", e);
        }
        if (RegisterCache.getInstance().enableAutoScan()) {
            AutoScanConfigRegister.doScanConfig();
        }
        batchOperationHelper.flush();
    }

    private static void registerApplicationOptions(Application application) {
        if (application == null) {
            WXLogUtils.e(TAG, "RegisterApplicationOptions application is null");
            return;
        }
        Resources resources = application.getResources();
        registerCoreEnv("screen_width_pixels", String.valueOf(DisplayMetrics.getwidthPixels(resources.getDisplayMetrics())));
        registerCoreEnv("screen_height_pixels", String.valueOf(DisplayMetrics.getheightPixels(resources.getDisplayMetrics())));
        int identifier = resources.getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            registerCoreEnv("status_bar_height", String.valueOf(resources.getDimensionPixelSize(identifier)));
        }
    }

    public static boolean registerComponent(String str, Class<? extends WXComponent> cls, boolean z) throws WXException {
        return registerComponent(cls, z, str);
    }

    public static void registerCoreEnv(String str, String str2) {
        WXBridgeManager.getInstance().registerCoreEnv(str, str2);
    }

    public static <T extends WXModule> boolean registerModule(String str, Class<T> cls, boolean z) throws WXException {
        return cls != null && registerModule(str, new TypeModuleFactory(cls), z);
    }

    public static <T extends WXModule> boolean registerModuleWithFactory(String str, AbstractC6943a abstractC6943a, boolean z) throws WXException {
        return registerModule(str, abstractC6943a, z);
    }

    public static boolean registerService(String str, String str2, Map<String, Object> map) {
        return WXServiceManager.registerService(str, str2, map);
    }

    public static void reload(final Context context, String str, boolean z) {
        WXEnvironment.sRemoteDebugMode = z;
        WXBridgeManager.getInstance().restart();
        WXBridgeManager.getInstance().initScriptsFramework(str);
        WXServiceManager.reload();
        WXModuleManager.reload();
        WXComponentRegistry.reload();
        WXSDKManager.v().N(new Runnable() { // from class: com.taobao.weex.WXSDKEngine.2
            @Override // java.lang.Runnable
            public void run() {
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(WXSDKEngine.JS_FRAMEWORK_RELOAD));
            }
        }, 0L);
    }

    public static void restartBridge(boolean z) {
        WXEnvironment.sDebugMode = z;
        WXSDKManager.v().S();
    }

    public static void setActivityNavBarSetter(IActivityNavBarSetter iActivityNavBarSetter) {
        WXSDKManager.v().T(iActivityNavBarSetter);
    }

    public static void setJSExcetptionAdapter(IWXJSExceptionAdapter iWXJSExceptionAdapter) {
        WXSDKManager.v().W(iWXJSExceptionAdapter);
    }

    public static void setNavigator(INavigator iNavigator) {
        WXSDKManager.v().Y(iNavigator);
    }

    public static boolean unRegisterService(String str) {
        return WXServiceManager.unRegisterService(str);
    }

    @Deprecated
    public static void init(Application application, IWXUserTrackAdapter iWXUserTrackAdapter) {
        init(application, iWXUserTrackAdapter, null);
    }

    public static boolean registerComponent(String str, IExternalComponentGetter iExternalComponentGetter, boolean z) throws WXException {
        return registerComponent(new ExternalLoaderComponentHolder(str, iExternalComponentGetter), z, str);
    }

    public static <T extends WXModule> boolean registerModule(String str, ModuleFactory moduleFactory, boolean z) throws WXException {
        return WXModuleManager.registerModule(str, moduleFactory, z);
    }

    public static <T extends WXModule> boolean registerModuleWithFactory(String str, IExternalModuleGetter iExternalModuleGetter, boolean z) throws WXException {
        return registerModule(str, iExternalModuleGetter.getExternalModuleClass(str, WXEnvironment.getApplication()), z);
    }

    @Deprecated
    public static void init(Application application, IWXUserTrackAdapter iWXUserTrackAdapter, String str) {
        initialize(application, new C6948a.C6950b().m(iWXUserTrackAdapter).b());
    }

    public static boolean registerComponent(Class<? extends WXComponent> cls, boolean z, String... strArr) throws WXException {
        if (cls == null) {
            return false;
        }
        return registerComponent(new SimpleComponentHolder(cls), z, strArr);
    }

    public static boolean registerModule(String str, Class<? extends WXModule> cls) throws WXException {
        return registerModule(str, (Class) cls, false);
    }

    public static boolean registerComponent(IFComponentHolder iFComponentHolder, boolean z, String... strArr) throws WXException {
        boolean z2 = true;
        try {
            boolean z3 = true;
            for (String str : strArr) {
                try {
                    HashMap hashMap = new HashMap();
                    if (z) {
                        hashMap.put("append", "tree");
                    }
                    z3 = z3 && WXComponentRegistry.registerComponent(str, iFComponentHolder, hashMap);
                } catch (Throwable th) {
                    th = th;
                    z2 = z3;
                    th.printStackTrace();
                    return z2;
                }
            }
            return z3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Deprecated
    public static void init(Application application, String str, IWXUserTrackAdapter iWXUserTrackAdapter, IWXImgLoaderAdapter iWXImgLoaderAdapter, IWXHttpAdapter iWXHttpAdapter) {
        initialize(application, new C6948a.C6950b().m(iWXUserTrackAdapter).g(iWXHttpAdapter).h(iWXImgLoaderAdapter).b());
    }

    public static void reload(Context context, boolean z) {
        reload(context, null, z);
    }

    public static void reload() {
        reload(WXEnvironment.getApplication(), WXEnvironment.sRemoteDebugMode);
    }

    public static boolean registerComponent(String str, Class<? extends WXComponent> cls) throws WXException {
        return WXComponentRegistry.registerComponent(str, new SimpleComponentHolder(cls), new HashMap());
    }

    public static boolean registerComponent(Map<String, Object> map, Class<? extends WXComponent> cls) throws WXException {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("type");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return WXComponentRegistry.registerComponent(str, new SimpleComponentHolder(cls), map);
    }
}
