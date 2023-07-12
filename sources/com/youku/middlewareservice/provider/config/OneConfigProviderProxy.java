package com.youku.middlewareservice.provider.config;

import android.util.Log;
import com.youku.middlewareservice.provider.config.OneConfigProvider;
import java.util.Map;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class OneConfigProviderProxy {
    private static OneConfigProvider sProxy;

    public static boolean containsNamespace(String str) {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.containsNamespace(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static String[] getAllNamespaces() {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.getAllNamespaces();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getConfig(String str, String str2, String str3) {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.getConfig(str, str2, str3);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static Map getConfigs(String str) {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.getConfigs(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getCurrentOccVersion() {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.getCurrentOccVersion();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static OneConfigProvider getProxy() {
        if (sProxy == null) {
            sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && OneConfigProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (OneConfigProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean registerListener(String str, OneConfigProvider.IUpdateListenerInterface iUpdateListenerInterface) {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.registerListener(str, iUpdateListenerInterface);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean unregisterListener(String str, OneConfigProvider.IUpdateListenerInterface iUpdateListenerInterface) {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.unregisterListener(str, iUpdateListenerInterface);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static int getConfig(String str, String str2, int i) {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.getConfig(str, str2, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static boolean getConfig(String str, String str2, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.getConfig(str, str2, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static Object getConfig(String str, String str2, Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (OneConfigProvider) a.j("com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl").b().f();
            }
            return sProxy.getConfig(str, str2, obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.config.OneConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
