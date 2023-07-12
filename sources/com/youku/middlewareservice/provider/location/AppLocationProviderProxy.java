package com.youku.middlewareservice.provider.location;

import android.util.Log;
import com.youku.middlewareservice.provider.location.AppLocationProvider;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class AppLocationProviderProxy {
    private static AppLocationProvider sProxy;

    public static AppLocationProvider getProxy() {
        if (sProxy == null) {
            sProxy = (AppLocationProvider) a.j("com.youku.middlewareservice_impl.provider.location.AmapLocationProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && AppLocationProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (AppLocationProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void startLocate(AppLocationProvider.OnLocationChangedListener onLocationChangedListener) {
        try {
            if (sProxy == null) {
                sProxy = (AppLocationProvider) a.j("com.youku.middlewareservice_impl.provider.location.AmapLocationProviderImpl").b().f();
            }
            sProxy.startLocate(onLocationChangedListener);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.location.AmapLocationProviderImpl  Throwable: " + th.toString());
        }
    }
}
