package com.youku.middlewareservice.provider.kvdata;

import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CloudConfigProviderProxy {
    private static CloudConfigProvider sProxy;

    public static String get(String str, String str2, String str3) {
        try {
            if (sProxy == null) {
                sProxy = (CloudConfigProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl").b().f();
            }
            return sProxy.get(str, str2, str3);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static CloudConfigProvider getProxy() {
        if (sProxy == null) {
            sProxy = (CloudConfigProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && CloudConfigProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (CloudConfigProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int get(String str, String str2, int i) {
        try {
            if (sProxy == null) {
                sProxy = (CloudConfigProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl").b().f();
            }
            return sProxy.get(str, str2, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static Integer get(String str, String str2, Integer num) {
        try {
            if (sProxy == null) {
                sProxy = (CloudConfigProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl").b().f();
            }
            return sProxy.get(str, str2, num);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static float get(String str, String str2, float f) {
        try {
            if (sProxy == null) {
                sProxy = (CloudConfigProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl").b().f();
            }
            return sProxy.get(str, str2, f);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl  Throwable: " + th.toString());
            return 0.0f;
        }
    }

    public static Float get(String str, String str2, Float f) {
        try {
            if (sProxy == null) {
                sProxy = (CloudConfigProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl").b().f();
            }
            return sProxy.get(str, str2, f);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.OrangeConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
