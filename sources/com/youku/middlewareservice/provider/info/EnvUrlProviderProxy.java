package com.youku.middlewareservice.provider.info;

import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class EnvUrlProviderProxy {
    private static EnvUrlProvider sProxy;

    public static String getDailyUrl() {
        try {
            if (sProxy == null) {
                sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
            }
            return sProxy.getDailyUrl();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static int getEnvType() {
        try {
            if (sProxy == null) {
                sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
            }
            return sProxy.getEnvType();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static String getOnlineUrl() {
        try {
            if (sProxy == null) {
                sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
            }
            return sProxy.getOnlineUrl();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getPreUrl() {
        try {
            if (sProxy == null) {
                sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
            }
            return sProxy.getPreUrl();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static EnvUrlProvider getProxy() {
        if (sProxy == null) {
            sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
        }
        return sProxy;
    }

    public static String getUrl() {
        try {
            if (sProxy == null) {
                sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
            }
            return sProxy.getUrl();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && EnvUrlProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (EnvUrlProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isDaily() {
        try {
            if (sProxy == null) {
                sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
            }
            return sProxy.isDaily();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isOnline() {
        try {
            if (sProxy == null) {
                sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
            }
            return sProxy.isOnline();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isPre() {
        try {
            if (sProxy == null) {
                sProxy = (EnvUrlProvider) a.j("com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl").b().f();
            }
            return sProxy.isPre();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.EnvUrlProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
