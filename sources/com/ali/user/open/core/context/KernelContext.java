package com.ali.user.open.core.context;

import android.content.Context;
import android.content.res.Resources;
import com.ali.user.open.core.WebViewProxy;
import com.ali.user.open.core.config.AuthOption;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.Environment;
import com.ali.user.open.core.registry.ServiceRegistration;
import com.ali.user.open.core.registry.ServiceRegistry;
import com.ali.user.open.core.registry.impl.DefaultServiceRegistry;
import com.ali.user.open.core.registry.impl.ProxyEnabledServiceRegistryDelegator;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.service.impl.ExecutorServiceImpl;
import com.ali.user.open.core.util.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class KernelContext {
    private static final String SDK_VERSION = "android_4.7.1";
    private static final String SDK_VERSION_STD = "a_4.7.1-std";
    public static final String TAG = "kernel";
    public static String UUID = null;
    public static volatile Context applicationContext = null;
    public static AuthOption authOption = null;
    public static MemberExecutorService executorService = null;
    public static final ReentrantLock initLock;
    public static boolean isMini = true;
    public static WebViewProxy mWebViewProxy;
    public static String packageName;
    public static Resources resources;
    public static AuthOption sOneTimeAuthOption;
    public static volatile Boolean sdkInitialized;
    public static String sdkVersion;
    public static volatile ServiceRegistry serviceRegistry;

    static {
        sdkVersion = ConfigManager.getInstance().isMiniProgram() ? SDK_VERSION_STD : SDK_VERSION;
        sdkInitialized = Boolean.FALSE;
        authOption = AuthOption.NORMAL;
        sOneTimeAuthOption = null;
        initLock = new ReentrantLock();
        serviceRegistry = new DefaultServiceRegistry();
        executorService = new ExecutorServiceImpl();
    }

    public static boolean checkServiceValid() {
        return (applicationContext == null || serviceRegistry == null || getServices(RpcService.class) == null || getServices(StorageService.class) == null || getServices(UserTrackerService.class) == null || getService(StorageService.class) == null) ? false : true;
    }

    public static synchronized Context getApplicationContext() {
        synchronized (KernelContext.class) {
            if (applicationContext != null) {
                return applicationContext;
            }
            return SystemUtils.getSystemApp();
        }
    }

    public static Environment getEnvironment() {
        return ConfigManager.getInstance().getEnvironment();
    }

    public static String getSdkVersion() {
        return ConfigManager.getInstance().isMiniProgram() ? SDK_VERSION_STD : SDK_VERSION;
    }

    public static <T> T getService(Class<T> cls, Map<String, String> map) {
        return (T) serviceRegistry.getService(cls, map);
    }

    public static <T> T[] getServices(Class<T> cls) {
        return (T[]) serviceRegistry.getServices(cls, null);
    }

    public static ServiceRegistration registerService(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        return serviceRegistry.registerService(clsArr, obj, map == null ? new HashMap() : new HashMap(map));
    }

    public static void wrapServiceRegistry() {
        if (serviceRegistry instanceof ProxyEnabledServiceRegistryDelegator) {
            return;
        }
        serviceRegistry = new ProxyEnabledServiceRegistryDelegator(serviceRegistry);
    }

    public static <T> T getService(Class<T> cls) {
        return (T) serviceRegistry.getService(cls, null);
    }
}
