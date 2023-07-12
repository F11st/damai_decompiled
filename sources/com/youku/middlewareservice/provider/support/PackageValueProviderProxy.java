package com.youku.middlewareservice.provider.support;

import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class PackageValueProviderProxy {
    private static PackageValueProvider sProxy;

    public static <T> T get(String str) {
        try {
            if (sProxy == null) {
                sProxy = (PackageValueProvider) C8883a.j("com.youku.middlewareservice_impl.provider.support.PackageValueProviderImpl").b().f();
            }
            return (T) sProxy.get(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.support.PackageValueProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static PackageValueProvider getProxy() {
        if (sProxy == null) {
            sProxy = (PackageValueProvider) C8883a.j("com.youku.middlewareservice_impl.provider.support.PackageValueProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && PackageValueProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (PackageValueProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T get(String str, T t) {
        try {
            if (sProxy == null) {
                sProxy = (PackageValueProvider) C8883a.j("com.youku.middlewareservice_impl.provider.support.PackageValueProviderImpl").b().f();
            }
            return (T) sProxy.get(str, t);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.support.PackageValueProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
