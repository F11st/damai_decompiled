package com.youku.middlewareservice.provider;

import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class LogProviderProxy {
    private static LogProvider sProxy;

    public static void enableLog(boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (LogProvider) a.j("com.youku.middlewareservice_impl.provider.LogProviderImpl").b().f();
            }
            sProxy.enableLog(z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.LogProviderImpl  Throwable: " + th.toString());
        }
    }

    public static LogProvider getProxy() {
        if (sProxy == null) {
            sProxy = (LogProvider) a.j("com.youku.middlewareservice_impl.provider.LogProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && LogProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (LogProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void logd(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (LogProvider) a.j("com.youku.middlewareservice_impl.provider.LogProviderImpl").b().f();
            }
            sProxy.logd(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.LogProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void loge(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (LogProvider) a.j("com.youku.middlewareservice_impl.provider.LogProviderImpl").b().f();
            }
            sProxy.loge(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.LogProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void logi(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (LogProvider) a.j("com.youku.middlewareservice_impl.provider.LogProviderImpl").b().f();
            }
            sProxy.logi(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.LogProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void logv(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (LogProvider) a.j("com.youku.middlewareservice_impl.provider.LogProviderImpl").b().f();
            }
            sProxy.logv(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.LogProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void logw(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (LogProvider) a.j("com.youku.middlewareservice_impl.provider.LogProviderImpl").b().f();
            }
            sProxy.logw(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.LogProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void loge(String str, String str2, Throwable th) {
        try {
            if (sProxy == null) {
                sProxy = (LogProvider) a.j("com.youku.middlewareservice_impl.provider.LogProviderImpl").b().f();
            }
            sProxy.loge(str, str2, th);
        } catch (Throwable th2) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.LogProviderImpl  Throwable: " + th2.toString());
        }
    }
}
