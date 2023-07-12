package cn.damai.h5container;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.config.EnvEnum;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVJsbridgeService;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.webview.IWVWebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.util.ToastUtil;
import cn.damai.login.LoginManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.security.realidentity.jsbridge.RP;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uc.UCSoSettings;
import com.taomai.android.h5container.TaoMaiH5Container;
import com.taomai.android.h5container.api.TMActionPlugin;
import com.uploader.export.UploaderGlobal;
import tb.cs;
import tb.mu0;
import tb.on1;
import tb.yu2;
import tb.zk2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class WindvaneAgent {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String Pre = "https://androiddownload.damai.cn/uc/";
    private static final String name = "libkernelu4_zip_uc_3.22.1.238.so";

    public static void initWdBasic(Context context) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2063157673")) {
            ipChange.ipc$dispatch("2063157673", new Object[]{context});
            return;
        }
        UploaderGlobal.g(context);
        if (AppConfig.v()) {
            if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                i = 1;
            } else if (AppConfig.g() == AppConfig.EnvMode.test) {
                i = 2;
            }
            UploaderGlobal.e(0, AppConfig.k());
            UploaderGlobal.e(2, AppConfig.f());
            UploaderGlobal.e(1, AppConfig.k());
            UploaderEnvironmentImplDM uploaderEnvironmentImplDM = new UploaderEnvironmentImplDM(context);
            uploaderEnvironmentImplDM.setEnvironment(i);
            UploaderGlobal.c(new yu2(context, uploaderEnvironmentImplDM));
            WVPluginManager.registerPlugin("DMBridge", (Class<? extends WVApiPlugin>) DMBridge.class, true);
            WVPluginManager.registerPlugin("aluAuthJSBridge", (Class<? extends WVApiPlugin>) DMSNSJsBridge.class);
            WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
            WVPluginManager.registerPlugin("aluWVJSBridge", (Class<? extends WVApiPlugin>) LoginJSBridgeService.class);
            wvEventServiceAddAccountListener();
        }
        i = 0;
        UploaderGlobal.e(0, AppConfig.k());
        UploaderGlobal.e(2, AppConfig.f());
        UploaderGlobal.e(1, AppConfig.k());
        UploaderEnvironmentImplDM uploaderEnvironmentImplDM2 = new UploaderEnvironmentImplDM(context);
        uploaderEnvironmentImplDM2.setEnvironment(i);
        UploaderGlobal.c(new yu2(context, uploaderEnvironmentImplDM2));
        WVPluginManager.registerPlugin("DMBridge", (Class<? extends WVApiPlugin>) DMBridge.class, true);
        WVPluginManager.registerPlugin("aluAuthJSBridge", (Class<? extends WVApiPlugin>) DMSNSJsBridge.class);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        WVPluginManager.registerPlugin("aluWVJSBridge", (Class<? extends WVApiPlugin>) LoginJSBridgeService.class);
        wvEventServiceAddAccountListener();
    }

    public static void initWindVane(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-157517432")) {
            ipChange.ipc$dispatch("-157517432", new Object[]{context});
            return;
        }
        zk2 zk2Var = new zk2(" DamaiApp Android v" + AppConfig.q(), true);
        zk2Var.appKey = AppConfig.c();
        zk2Var.ttid = AppConfig.p();
        zk2Var.appTag = "DM";
        zk2Var.appVersion = AppConfig.q();
        zk2Var.reducePermission = true;
        zk2Var.ucsdkappkeySec = AppConfig.l;
        zk2Var.d(true);
        WindVaneSDK.setEnvMode(EnvEnum.ONLINE);
        if (AppConfig.v()) {
            WindVaneSDK.openLog(true);
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                WindVaneSDK.setEnvMode(EnvEnum.DAILY);
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                WindVaneSDK.setEnvMode(EnvEnum.PRE);
            }
        }
        UCSoSettings.getInstance().setUCCoreRelease32("https://androiddownload.damai.cn/uc/release/armeabi-v7a/libkernelu4_zip_uc_3.22.1.238.so").setUCCoreDebug32("https://androiddownload.damai.cn/uc/debug/armeabi-v7a/libkernelu4_zip_uc_3.22.1.238.so").setUCCoreRelease64("https://androiddownload.damai.cn/uc/release/arm64-v8a/libkernelu4_zip_uc_3.22.1.238.so").setUCCoreDebug64("https://androiddownload.damai.cn/uc/debug/arm64-v8a/libkernelu4_zip_uc_3.22.1.238.so");
        TaoMaiH5Container.c(context, zk2Var);
        TaoMaiH5Container.g("cn.damai.h5.fileProvider");
        String b = OrangeConfigCenter.c().b(on1.WVPLUGIN_NAMESPACE, "whitelist", "");
        DmJSBridgeAuthAopHandler dmJSBridgeAuthAopHandler = new DmJSBridgeAuthAopHandler();
        dmJSBridgeAuthAopHandler.setAuthHost(b);
        WVJsbridgeService.registerJsbridgePreprocessor(dmJSBridgeAuthAopHandler);
        initWdBasic(context);
        TaoMaiH5Container.h(new TaoMaiH5Container.NavHandler() { // from class: cn.damai.h5container.WindvaneAgent.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taomai.android.h5container.TaoMaiH5Container.NavHandler
            public void handleUrl(@NonNull Context context2, @NonNull String str, boolean z, IWVWebView iWVWebView) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-161165246")) {
                    ipChange2.ipc$dispatch("-161165246", new Object[]{this, context2, str, Boolean.valueOf(z), iWVWebView});
                } else if (z) {
                } else {
                    try {
                        Bundle bundle = new Bundle();
                        if (iWVWebView != null && iWVWebView.getUrl() != null && iWVWebView.getUrl().startsWith(UniH5ContainerSwitcher.XIAOMI)) {
                            bundle.putBoolean("fromQr", true);
                        }
                        DMNav.from(context2).withExtras(bundle).toUri(Uri.parse(str));
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.taomai.android.h5container.TaoMaiH5Container.NavHandler
            public boolean shouldOverrideUrlLoading(@NonNull Context context2, @NonNull String str, @NonNull IWVWebView iWVWebView) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "328643231")) {
                    return ((Boolean) ipChange2.ipc$dispatch("328643231", new Object[]{this, context2, str, iWVWebView})).booleanValue();
                }
                return false;
            }
        });
        TaoMaiH5Container.e("getCacheLocation", new TMActionPlugin.IWVAPIPlugin() { // from class: cn.damai.h5container.WindvaneAgent.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taomai.android.h5container.api.TMActionPlugin.IWVAPIPlugin
            public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "468251266")) {
                    return ((Boolean) ipChange2.ipc$dispatch("468251266", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
                }
                try {
                    double[] dMCoordinates = Util.getDMCoordinates();
                    if (dMCoordinates == null || dMCoordinates.length != 2) {
                        if (wVCallBackContext != null) {
                            wVCallBackContext.error("result", "failed");
                        }
                        WindvaneAgent.showToast("getCacheLocation fail");
                    } else {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("longitude", Double.valueOf(dMCoordinates[0]));
                        wVResult.addData("latitude", Double.valueOf(dMCoordinates[1]));
                        wVResult.addData("result", "success");
                        if (wVCallBackContext != null) {
                            wVCallBackContext.success(wVResult);
                        }
                        WindvaneAgent.showToast("getCacheLocation success");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (wVCallBackContext != null) {
                        wVCallBackContext.error();
                    }
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101831792")) {
            ipChange.ipc$dispatch("101831792", new Object[]{str});
        } else if (AppConfig.v()) {
            ToastUtil.i(str);
        }
    }

    private static void wvEventServiceAddAccountListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656806208")) {
            ipChange.ipc$dispatch("-1656806208", new Object[0]);
        } else {
            WVEventService.getInstance().addEventListener(new WVEventListener() { // from class: cn.damai.h5container.WindvaneAgent.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.taobao.windvane.service.WVEventListener
                public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1988938578")) {
                        return (WVEventResult) ipChange2.ipc$dispatch("-1988938578", new Object[]{this, Integer.valueOf(i), wVEventContext, objArr});
                    }
                    if (i != 3005 || objArr == null) {
                        return null;
                    }
                    try {
                        if (objArr.length >= 1) {
                            Object obj = objArr[0];
                            if (obj instanceof String) {
                                final String str = (String) obj;
                                if ("damai-destoryAccount".equalsIgnoreCase(JSON.parseObject(str).getString("event"))) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.h5container.WindvaneAgent.3.1
                                        private static transient /* synthetic */ IpChange $ipChange;

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IpChange ipChange3 = $ipChange;
                                            if (AndroidInstantRuntime.support(ipChange3, "1683385865")) {
                                                ipChange3.ipc$dispatch("1683385865", new Object[]{this});
                                                return;
                                            }
                                            LoginManager.k().u();
                                            DMNav.from(mu0.a()).setTransition(0, 0).toUri(cs.m());
                                            if (AppConfig.v()) {
                                                ToastUtil.i("destoryAccount:" + str);
                                            }
                                        }
                                    });
                                    return null;
                                }
                                return null;
                            }
                            return null;
                        }
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            });
        }
    }
}
