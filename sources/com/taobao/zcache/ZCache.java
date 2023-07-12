package com.taobao.zcache;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.util.AndroidRuntimeException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.RVLLog;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import com.taobao.zcache.api.ZCacheAPI;
import com.taobao.zcache.api.ZCacheDev;
import com.taobao.zcache.core.IZCacheCore;
import com.taobao.zcache.core.ZCacheCoreProxy;
import com.uc.webview.export.extension.UCCore;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ZCache {
    private static final String ConfigGroupName = "ZCache";
    private static Map<String, String> config;
    private static Context context;
    private static ZCacheConfig defaultConfig;
    private static Environment env;
    private static String locale;
    private static IZCachePushService pushService;
    private static IZCacheClientService clientService = new ZCacheClientServiceDefaultImpl();
    private static boolean serviceRegistered = false;
    private static final ExecutorService taskQueue = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.taobao.zcache.ZCache.3
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ZCache.Access_" + runnable.hashCode());
        }
    });

    public static void clean() {
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core == null || !ZCacheCoreProxy.isMainProcess()) {
            return;
        }
        core.clean();
    }

    public static String getACacheRootPath(@NonNull String str, @Nullable String str2) {
        IZCacheCore core;
        if (str == null || (core = ZCacheCoreProxy.core()) == null) {
            return null;
        }
        return core.getACacheRootPath(str, str2);
    }

    public static Context getContext() {
        return context;
    }

    private static Error getNullContextError() {
        return new Error(9994, "context is null");
    }

    public static IZCachePushService getPushService() {
        return pushService;
    }

    public static ResourceResponse getResource(@NonNull ResourceRequest resourceRequest) {
        IZCacheCore core;
        if (resourceRequest == null || (core = ZCacheCoreProxy.core()) == null) {
            return null;
        }
        return core.getResource(resourceRequest);
    }

    private static Error getSubProcessUpdateDisabledError() {
        return new Error(2004, "sub process update disabled");
    }

    public static void installPreload() {
        installPreload("preload_packageapp.zip");
    }

    public static boolean isPackInstalled(@NonNull String str) {
        IZCacheCore core;
        if (str == null || (core = ZCacheCoreProxy.core()) == null) {
            return false;
        }
        return core.isInstalled(new PackRequest(str));
    }

    public static boolean isResourceInstalled(@NonNull String str) {
        IZCacheCore core;
        if (str == null || (core = ZCacheCoreProxy.core()) == null) {
            return false;
        }
        return core.isResourceInstalled(new ResourceRequest(str));
    }

    public static void prefetch(@NonNull List<String> list) {
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.prefetch(list);
        }
    }

    private static void registerAPI() {
        try {
            WVPluginManager.registerPlugin(ConfigGroupName, (Class<? extends WVApiPlugin>) ZCacheAPI.class);
            WVPluginManager.registerPlugin("ZCacheDev", (Class<? extends WVApiPlugin>) ZCacheDev.class);
            RVLLog.a(RVLLevel.Info, "ZCache/Setup").f("initDev").d();
        } catch (Exception | NoClassDefFoundError unused) {
        }
    }

    public static void registerAccept(String str, String str2, String str3) {
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.registerAccept(str, str2, str3);
        }
    }

    public static void registerClientService(@NonNull IZCacheClientService iZCacheClientService) {
        if (iZCacheClientService != null) {
            clientService = iZCacheClientService;
        }
    }

    private static void registerOrangeListener() {
        try {
            OrangeConfig.getInstance().registerListener(new String[]{ConfigGroupName}, new OConfigListener() { // from class: com.taobao.zcache.ZCache.2
                @Override // com.taobao.orange.OConfigListener
                public void onConfigUpdate(String str, Map<String, String> map) {
                    if (ZCache.ConfigGroupName.equals(str)) {
                        Map unused = ZCache.config = map;
                        IZCacheCore core = ZCacheCoreProxy.core();
                        if (core != null) {
                            core.setConfig(ZCache.config);
                        }
                    }
                }
            }, true);
            RVLLog.a(RVLLevel.Info, "ZCache/Setup").f("initOrangeListener").d();
        } catch (NoClassDefFoundError unused) {
        }
    }

    public static void registerPushService(IZCachePushService iZCachePushService) {
        if (iZCachePushService == null) {
            if (pushService != null) {
                pushService = null;
                RVLLog.a(RVLLevel.Info, "ZCache/Setup").f("unregisterPushService").d();
                return;
            }
            return;
        }
        pushService = iZCachePushService;
        RVLLog.a(RVLLevel.Info, "ZCache/Setup").f("registerPushService").a("type", iZCachePushService.getClass().getName()).d();
    }

    public static void registerUpdateListener(@NonNull String str, @NonNull PackUpdateFinishedCallback packUpdateFinishedCallback) {
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.registerUpdateListener(str, packUpdateFinishedCallback);
        }
    }

    public static void removeACache(@NonNull String str, @Nullable String str2) {
        IZCacheCore core;
        if (str == null || (core = ZCacheCoreProxy.core()) == null || !ZCacheCoreProxy.isMainProcess()) {
            return;
        }
        core.removePack(new PackRequest(str, str2));
    }

    public static void setConfig(@Nullable ZCacheConfig zCacheConfig) {
        defaultConfig = zCacheConfig;
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.setDefaultConfig(zCacheConfig);
        }
    }

    public static void setContext(@NonNull Context context2) {
        if (context2 == null) {
            return;
        }
        if (context2 instanceof Activity) {
            new AndroidRuntimeException("Cannot use context which instance of Activity").printStackTrace();
            return;
        }
        context = context2;
        RVLLog.g(context2);
        ZCacheCoreProxy.setContext(context);
    }

    public static void setEnv(@NonNull Environment environment) {
        if (environment == null) {
            return;
        }
        env = environment;
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.setEnv(environment);
        }
    }

    public static void setLocale(@Nullable String str) {
        locale = str;
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.setLocale(str);
        }
    }

    public static void setup(Context context2, String str, String str2) {
        if (context2 != null) {
            setContext(context2);
        }
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core == null) {
            RVLLog.a(RVLLevel.Error, "ZCache/Setup").f(UCCore.LEGACY_EVENT_SETUP).e(101, "context is null", new Object[0]).d();
        } else if (ZCacheCoreProxy.isMainProcess()) {
            core.setupWithHTTP(str, str2, env, locale, defaultConfig, config);
            if (!serviceRegistered) {
                serviceRegistered = true;
                registerAPI();
                registerOrangeListener();
                clientService.addClientEventListener(ZCacheCoreProxy.core());
                RVLLog.a(RVLLevel.Info, "ZCache/Setup").f("initClientListener").d();
            }
            new Thread("ZCache.InstallPreload") { // from class: com.taobao.zcache.ZCache.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    ZCache.installPreload();
                }
            }.start();
        } else {
            core.setupSubProcess();
        }
    }

    @Deprecated
    public static void startUpdateQueue() {
    }

    public static void syncSubProcessConfig() {
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.syncSubProcessConfig();
        }
    }

    public static void updatePack(@NonNull PackRequest packRequest, @Nullable PackUpdateFinishedCallback packUpdateFinishedCallback) {
        if (packRequest == null) {
            if (packUpdateFinishedCallback != null) {
                packUpdateFinishedCallback.finish(null, null);
                return;
            }
            return;
        }
        String name = packRequest.getName();
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core == null) {
            if (packUpdateFinishedCallback != null) {
                packUpdateFinishedCallback.finish(name, getNullContextError());
            }
        } else if (ZCacheCoreProxy.isMainProcess()) {
            core.updatePack(packRequest, packUpdateFinishedCallback);
        } else if (packUpdateFinishedCallback != null) {
            packUpdateFinishedCallback.finish(name, getSubProcessUpdateDisabledError());
        }
    }

    public static void installPreload(@NonNull String str) {
        IZCacheCore core;
        if (ZCacheCoreProxy.isMainProcess() && (core = ZCacheCoreProxy.core()) != null) {
            core.installPreload(str);
        }
    }

    public static void getResource(@NonNull final ResourceRequest resourceRequest, @NonNull final ResourceResponseCallback resourceResponseCallback) {
        if (resourceResponseCallback == null) {
            return;
        }
        if (resourceRequest == null) {
            resourceResponseCallback.finish(null);
            return;
        }
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core == null) {
            resourceResponseCallback.finish(null);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            taskQueue.execute(new Runnable() { // from class: com.taobao.zcache.ZCache.4
                @Override // java.lang.Runnable
                public void run() {
                    ZCacheCoreProxy.core().getResource(ResourceRequest.this, resourceResponseCallback);
                }
            });
        } else {
            core.getResource(resourceRequest, resourceResponseCallback);
        }
    }

    public static boolean isPackInstalled(@NonNull PackRequest packRequest) {
        if (packRequest == null) {
            return false;
        }
        IZCacheCore core = ZCacheCoreProxy.core();
        if (core == null) {
            packRequest.setError(getNullContextError());
            return false;
        }
        return core.isInstalled(packRequest);
    }

    public static boolean isResourceInstalled(@NonNull ResourceRequest resourceRequest) {
        IZCacheCore core;
        if (resourceRequest == null || (core = ZCacheCoreProxy.core()) == null) {
            return false;
        }
        return core.isResourceInstalled(resourceRequest);
    }
}
