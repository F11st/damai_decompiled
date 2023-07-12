package com.alibaba.aliweex;

import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.grey.GreyPageInfo;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.packageapp.WVPackageAppRuntime;
import android.taobao.windvane.packageapp.zipapp.ZCacheResourceResponse;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppUtils;
import android.text.TextUtils;
import com.alibaba.aliweex.adapter.adapter.PhenixBasedDrawableLoader;
import com.alibaba.aliweex.adapter.adapter.WXAPMAdapter;
import com.alibaba.aliweex.adapter.adapter.WXHttpAdapter;
import com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter;
import com.alibaba.aliweex.adapter.adapter.b;
import com.alibaba.aliweex.adapter.adapter.d;
import com.alibaba.aliweex.adapter.component.AliGifImage;
import com.alibaba.aliweex.adapter.component.AliWXEmbed;
import com.alibaba.aliweex.adapter.component.AliWXImage;
import com.alibaba.aliweex.adapter.component.WXCountDown;
import com.alibaba.aliweex.adapter.component.WXExtA;
import com.alibaba.aliweex.adapter.component.WXLatestVisitView;
import com.alibaba.aliweex.adapter.component.WXMarquee;
import com.alibaba.aliweex.adapter.component.WXMask;
import com.alibaba.aliweex.adapter.component.WXParallax;
import com.alibaba.aliweex.adapter.component.WXTabHeader;
import com.alibaba.aliweex.adapter.component.WXTabbar;
import com.alibaba.aliweex.adapter.component.WXWVWeb;
import com.alibaba.aliweex.adapter.module.AliWXLocationModule;
import com.alibaba.aliweex.adapter.module.AliWXNavigatorModule;
import com.alibaba.aliweex.adapter.module.GeolocationModule;
import com.alibaba.aliweex.adapter.module.WXAliPayModule;
import com.alibaba.aliweex.adapter.module.WXCalendarModule;
import com.alibaba.aliweex.adapter.module.WXConfigModule;
import com.alibaba.aliweex.adapter.module.WXCookieModule;
import com.alibaba.aliweex.adapter.module.WXDeviceModule;
import com.alibaba.aliweex.adapter.module.WXEventModule;
import com.alibaba.aliweex.adapter.module.WXFestivalModule;
import com.alibaba.aliweex.adapter.module.WXLocationModule;
import com.alibaba.aliweex.adapter.module.WXNavigationBarModule;
import com.alibaba.aliweex.adapter.module.WXPageInfoModule;
import com.alibaba.aliweex.adapter.module.WXPerformanceModule;
import com.alibaba.aliweex.adapter.module.WXScreenModule;
import com.alibaba.aliweex.adapter.module.WXShareModule;
import com.alibaba.aliweex.adapter.module.WXUserModule;
import com.alibaba.aliweex.adapter.module.WXUserTrackModule;
import com.alibaba.aliweex.adapter.module.WXWindVaneModule;
import com.alibaba.aliweex.adapter.module.audio.WXAudioModule;
import com.alibaba.aliweex.adapter.module.blur.WXBlurEXModule;
import com.alibaba.aliweex.adapter.module.broadcast.WXBroadcastModule;
import com.alibaba.aliweex.adapter.module.mtop.WXMtopModule;
import com.alibaba.aliweex.adapter.module.net.WXConnectionModule;
import com.alibaba.aliweex.plugin.SimpleAudioPlayer;
import com.alibaba.aliweex.utils.MemoryMonitor;
import com.alibaba.android.bindingx.plugin.weex.BindingX;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.alibaba.weex.plugin.gcanvas.GCanvasWeexRegister;
import com.taobao.message.weex.MessgeBundleWeexModuleRegister;
import com.taobao.soloader.SoLoader;
import com.taobao.weaver.prefetch.WMLPrefetch;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.a;
import com.taobao.weex.adapter.ICrashInfoReporter;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.bridge.ModuleFactory;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.common.WXException;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.SimpleComponentHolder;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.config.ConfigComponentHolder;
import com.taobao.weex.ui.config.ConfigModuleFactory;
import com.taobao.weex.utils.WXDeviceUtils;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.uc.webview.export.media.CommandID;
import com.youku.network.HttpIntent;
import java.io.File;
import java.util.HashMap;
import tb.fz2;
import tb.hz2;
import tb.iz2;
import tb.m80;
import tb.mz2;
import tb.oz2;
import tb.pz2;
import tb.q8;
import tb.qz2;
import tb.uh1;
import tb.uz2;
import tb.yz2;
import tb.zz2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AliWXSDKEngine {
    public static String a = "http://h5.m.taobao.com/app/weex/" + WXEnvironment.WXSDK_VERSION + "/weex.js";
    public static String b = "http://h5.m.taobao.com/app/weex/" + WXEnvironment.WXSDK_VERSION + "/weex-rax-api.js";
    public static String c = "http://h5.m.taobao.com/app/rax/rax.js";
    public static String d = "https://g.alicdn.com/rax-pkg/jsservice/raxpkg.js";
    private static String e = "weex_single_or_multi";
    public static String f = GreyPageInfo.KEY_AIR_TAG;
    public static String g = GreyPageInfo.KEY_GREY;
    public static String h = GreyPageInfo.KEY_ENV;
    private static iz2 i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a implements ICrashInfoReporter {
        a() {
        }

        @Override // com.taobao.weex.adapter.ICrashInfoReporter
        public void addCrashInfo(String str, String str2) {
            MotuCrashReporter.getInstance().addNativeHeaderInfo(str, str2);
            if (AliWXSDKEngine.i != null) {
                AliWXSDKEngine.i.b(str2);
            }
        }
    }

    private static void c() {
        com.taobao.weex.a k;
        boolean z;
        if (GlobalConfig.context == null) {
            GlobalConfig.context = com.alibaba.aliweex.a.l().b();
        }
        String b2 = zz2.b("weex", a);
        if (TextUtils.isEmpty(b2)) {
            WXLogUtils.e("TBWXSDKEngine", "TBWXSDKEngine: WV obtain  FRAMEWORK_JS failed");
        }
        com.alibaba.aliweex.a l = com.alibaba.aliweex.a.l();
        if (l.k() == null) {
            a.b e2 = new a.b().h(l.j() == null ? new WXImgLoaderAdapter() : l.j()).g(l.i() == null ? new WXHttpAdapter() : l.i()).m(new yz2()).f(b2).d(new PhenixBasedDrawableLoader()).n(new d()).i(new mz2()).c(new fz2()).j(new pz2()).k(new qz2()).e(com.alibaba.aliweex.adapter.adapter.a.a());
            try {
                Class.forName(SoLoader.class.getName());
                WXLogUtils.e("so loader existed");
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            String i2 = oz2.j().i(oz2.j().c);
            if (z && "true".equals(i2)) {
                WXLogUtils.e("use so loader");
                e2.l(new b());
            }
            if (l.m() != null) {
                for (String str : l.m()) {
                    e2.a(str);
                }
            }
            k = e2.b();
        } else {
            k = l.k();
        }
        try {
            if (k.r() == null) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("AliWeex", "Weex Auto Config Use Atlas Class Loader Adapter");
                }
                k.G(new q8());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WXSDKEngine.initialize(l.b(), k);
        try {
            i = new iz2();
            MotuCrashReporter.getInstance().setCrashCaughtListener(i);
            WXSDKManager.v().V(new a());
            WXSDKManager.v().a0(new hz2());
        } catch (Throwable unused2) {
        }
    }

    public static void d() {
        WXLogUtils.d("[AliWXSDKEngine] initSDKEngine");
        WXEnvironment.sInAliWeex = true;
        MemoryMonitor.d();
        oz2.j().k();
        n();
        WXSDKEngine.addCustomOptions(WXConfig.appGroup, "AliApp");
        WXSDKEngine.addCustomOptions("AliWeexVersion", "0.0.26.68");
        WXSDKEngine.addCustomOptions(WXDebugConstants.ENV_INFO_COLLECT, "false");
        WXSDKEngine.addCustomOptions(WXEnvironment.SETTING_EXCLUDE_X86SUPPORT, String.valueOf(true));
        WXSDKEngine.addCustomOptions("isTabletDevice", String.valueOf(WXUtils.isTabletDevice()));
        boolean z = false;
        if (WXDeviceUtils.isAutoResize(com.alibaba.aliweex.a.l().b())) {
            WXEnvironment.SETTING_FORCE_VERTICAL_SCREEN = false;
        } else {
            WXEnvironment.SETTING_FORCE_VERTICAL_SCREEN = true;
        }
        c();
        k();
        try {
            WVJsBridge.getInstance().init();
            uh1.a();
            WVPluginManager.registerPlugin("WXAudioPlayer", (Class<? extends WVApiPlugin>) SimpleAudioPlayer.class);
        } catch (Throwable unused) {
        }
        try {
            f();
            g();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Runnable secure = WXThread.secure(new Runnable() { // from class: com.alibaba.aliweex.AliWXSDKEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    if (uz2.u()) {
                        return;
                    }
                    try {
                        AliWXSDKEngine.e();
                    } catch (Throwable unused2) {
                    }
                }
            });
            IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
            if (c2 != null && c2.checkMode("mainBlock")) {
                WXBridgeManager.getInstance().postDelay(secure, 3000L);
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(secure, 3000L);
            }
        } catch (Throwable unused2) {
        }
        try {
            z = new File("/data/local/tmp/.apm_online").exists();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        WXAPMAdapter.h = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        WMLPrefetch.getInstance().registerHandler(new com.alibaba.aliweex.plugin.a());
    }

    private static void f() {
        String streamByUrl = ZipAppUtils.getStreamByUrl("rax", c);
        if (TextUtils.isEmpty(streamByUrl)) {
            streamByUrl = WXFileUtils.loadAsset("rax.js", WXEnvironment.getApplication());
        }
        boolean registerService = WXSDKEngine.registerService("rax", streamByUrl, new HashMap());
        WXLogUtils.d("rax framework init " + registerService);
    }

    private static void g() {
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J == null) {
            WXLogUtils.e("load raxPkg failed cause adapter is null");
        } else if (!"true".equalsIgnoreCase(J.getConfigWhenInit(oz2.WXAPM_CONFIG_GROUP, "loadRaxPkg", "true"))) {
            WXLogUtils.e("load raxPkg failed cause config is false");
        } else {
            ZCacheResourceResponse zCacheResourceResponse = WVPackageAppRuntime.getZCacheResourceResponse(d);
            String str = null;
            if (zCacheResourceResponse != null && zCacheResourceResponse.isSuccess) {
                str = WXFileUtils.readStreamToString(zCacheResourceResponse.inputStream);
            }
            if (TextUtils.isEmpty(str)) {
                str = WXFileUtils.loadAsset("raxpkg.js", WXEnvironment.getApplication());
            }
            boolean registerService = WXSDKEngine.registerService("raxpkg", str, new HashMap());
            WXLogUtils.d("raxPkg framework init " + registerService);
        }
    }

    private static void h() {
        j(new String[]{"start"}, "videokeyboard", "com.taobao.android.interactive.wxplatform.module.WXKeyboardModule");
        j(new String[]{"openUrl", "getDisplayCutoutHeight", "getCPUName", "setContinuousPlayStatus", "getContinuousPlayStatus", "getContinuousPlayState", "setContinuousPlayState"}, "videoutils", "com.taobao.android.interactive.wxplatform.module.WXInteractiveUtils");
        i(new String[]{"getDuration", Constants.Value.PLAY, "pause", "replay", "getScreenMode", "getMuted", CommandID.setMuted, "showOrHideTopMoreBtn", "showOrHideTopDanmakuBtn", "showOrHideTopShareBtn", Constants.Event.SLOT_LIFECYCLE.DESTORY, "callReportBtn", "callDanmakuBtn", "callShareBtn"}, "immersivevideo", "com.taobao.android.interactive.shortvideo.weex.IctImmersiveVideoWXComponent", false);
        i(new String[]{"getCurrentTime", "setCurrentTime", "getDuration", Constants.Value.PLAY, "pause", CommandID.setMuted, "getMuted"}, "interactiveVideo", "com.taobao.android.interactive.wxplatform.component.InteractiveVideoComponent", false);
        i(new String[]{"getCurrentTime", "setCurrentTime", "getDuration", Constants.Value.PLAY, "pause", CommandID.setMuted, "getMuted", "onShowcontrols", "setAnchors", "navToUrl"}, "interactiveVideoV2", "com.taobao.android.interactive.wxplatform.component.InteractiveVideoComponentV2", false);
        i(new String[0], "videoshare", "com.taobao.android.interactive.wxplatform.component.InteractiveShareComponent", false);
    }

    private static void i(String[] strArr, String str, String str2, boolean z) {
        ConfigComponentHolder configComponentHolder = new ConfigComponentHolder(str, z, str2, strArr);
        try {
            WXSDKEngine.registerComponent(configComponentHolder, configComponentHolder.isAppendTree(), configComponentHolder.getType());
        } catch (WXException e2) {
            e2.printStackTrace();
        }
    }

    private static void j(String[] strArr, String str, String str2) {
        ConfigModuleFactory configModuleFactory = new ConfigModuleFactory(str, str2, strArr);
        try {
            WXSDKEngine.registerModule(configModuleFactory.getName(), (ModuleFactory) configModuleFactory, false);
        } catch (WXException e2) {
            e2.printStackTrace();
        }
    }

    private static void k() {
        try {
            WXSDKEngine.registerModule("windvane", WXWindVaneModule.class);
            WXSDKEngine.registerModule("mtop", WXMtopModule.class);
            WXSDKEngine.registerModule("userTrack", WXUserTrackModule.class);
            WXSDKEngine.registerModule("share", WXShareModule.class);
            WXSDKEngine.registerModule("user", WXUserModule.class);
            WXSDKEngine.registerModule("geolocation", GeolocationModule.class);
            WXSDKEngine.registerModule("event", WXEventModule.class);
            WXSDKEngine.registerModule("pageInfo", WXPageInfoModule.class);
            WXSDKEngine.registerModule("location", WXLocationModule.class);
            WXSDKEngine.registerModule("alipay", WXAliPayModule.class);
            WXSDKEngine.registerModule("navigationBar", WXNavigationBarModule.class);
            WXSDKEngine.registerModule("audio", WXAudioModule.class);
            WXSDKEngine.registerModule("connection", WXConnectionModule.class);
            WXSDKEngine.registerModule(m80.FESTIVAL_PREFIX, WXFestivalModule.class);
            WXSDKEngine.registerModule(HttpIntent.COOKIE, WXCookieModule.class);
            WXSDKEngine.registerModule(WXBlurEXModule.BLUR_MODULE_NAME, WXBlurEXModule.class);
            WXSDKEngine.registerModule("screen", WXScreenModule.class);
            WXSDKEngine.registerModule("calendar", WXCalendarModule.class);
            WXSDKEngine.registerModule("navigator", AliWXNavigatorModule.class);
            WXSDKEngine.registerModule("navigationBar", WXNavigationBarModule.class);
            WXSDKEngine.registerModule("location", AliWXLocationModule.class);
            WXSDKEngine.registerModule(oz2.WXAPM_CONFIG_GROUP, WXPerformanceModule.class);
            WXSDKEngine.registerModule("orange", WXConfigModule.class);
            WXSDKEngine.registerComponent("web", WXWVWeb.class);
            WXSDKEngine.registerComponent("latestVisitView", WXLatestVisitView.class);
            WXSDKEngine.registerComponent("marquee", WXMarquee.class);
            WXSDKEngine.registerComponent("countdown", WXCountDown.class);
            WXSDKEngine.registerComponent("tabheader", WXTabHeader.class);
            WXSDKEngine.registerComponent("mask", WXMask.class);
            WXSDKEngine.registerComponent("tabbar", WXTabbar.class);
            WXSDKEngine.registerComponent(WXBasicComponentType.EMBED, (Class<? extends WXComponent>) AliWXEmbed.class, true);
            WXSDKEngine.registerComponent((IFComponentHolder) new SimpleComponentHolder(AliWXImage.class, new AliWXImage.a()), false, "image", "img");
            WXSDKEngine.registerComponent((IFComponentHolder) new SimpleComponentHolder(AliGifImage.class, new AliGifImage.a()), false, "gif");
            WXSDKEngine.registerComponent("a", (Class<? extends WXComponent>) WXExtA.class, false);
            WXSDKEngine.registerModule("device", WXDeviceModule.class);
            WXSDKEngine.registerModule("broadcast", WXBroadcastModule.class);
            WXSDKEngine.registerComponent(WXParallax.PARALLAX, WXParallax.class);
            MessgeBundleWeexModuleRegister.init();
            try {
                BindingX.register();
            } catch (Throwable unused) {
            }
            try {
                GCanvasWeexRegister.register();
            } catch (Throwable unused2) {
            }
            h();
        } catch (WXException e2) {
            WXLogUtils.e("[TBWXSDKEngine] registerModulesAndComponents:" + e2.getCause());
        }
    }

    public static synchronized void l(String str) {
        synchronized (AliWXSDKEngine.class) {
            iz2 iz2Var = i;
            if (iz2Var != null) {
                iz2Var.b(str);
            }
            MotuCrashReporter.getInstance().addNativeHeaderInfo(WXEnvironment.WEEX_CURRENT_KEY, str);
        }
    }

    public static synchronized void m(String str) {
        synchronized (AliWXSDKEngine.class) {
            iz2 iz2Var = i;
            if (iz2Var != null) {
                iz2Var.c(str);
            }
        }
    }

    public static void n() {
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if (c2 == null) {
            return;
        }
        String config = c2.getConfig("AliWXSDKEngine", "global_config", "");
        if (!TextUtils.isEmpty(config)) {
            WXBridgeManager.updateGlobalConfig(config);
        }
        WXBridgeManager.getInstance().setUseSingleProcess("true".equals(c2.getConfig(e, "enableSingleProcess", "false")));
    }
}
