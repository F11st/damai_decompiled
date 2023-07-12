package com.youku.middlewareservice.provider;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class AtlasProviderProxy {
    private static AtlasProvider sProxy;

    public static void clearActivityStack() {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            sProxy.clearActivityStack();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
        }
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            return sProxy.findField(obj, str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static ClassLoader getBundleClassLoader(String str) {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            return sProxy.getBundleClassLoader(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static AtlasProvider getProxy() {
        if (sProxy == null) {
            sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && AtlasProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (AtlasProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isActivityStackEmpty() {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            return sProxy.isActivityStackEmpty();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static void load(String str, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            sProxy.load(str, runnable, runnable2, runnable3);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
        }
    }

    public static Class<?> loadClass(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            return sProxy.loadClass(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static Activity peekTopActivity() {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            return sProxy.peekTopActivity();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void pushToActivityStack(Activity activity) {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            sProxy.pushToActivityStack(activity);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void updateResources(Context context, String str) {
        try {
            if (sProxy == null) {
                sProxy = (AtlasProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AtlasProviderImpl").b().f();
            }
            sProxy.updateResources(context, str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AtlasProviderImpl  Throwable: " + th.toString());
        }
    }
}
