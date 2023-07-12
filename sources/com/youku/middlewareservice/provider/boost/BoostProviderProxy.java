package com.youku.middlewareservice.provider.boost;

import android.util.Log;
import com.youku.middlewareservice.provider.boost.BoostProvider;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BoostProviderProxy {
    private static BoostProvider sProxy;

    public static boolean appActionBurst(int i, BoostProvider.AType aType) {
        try {
            if (sProxy == null) {
                sProxy = (BoostProvider) C8883a.j("com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl").b().f();
            }
            return sProxy.appActionBurst(i, aType);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static void appActionEnd() {
        try {
            if (sProxy == null) {
                sProxy = (BoostProvider) C8883a.j("com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl").b().f();
            }
            sProxy.appActionEnd();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl  Throwable: " + th.toString());
        }
    }

    public static boolean appActionLoading(int i, BoostProvider.AType aType) {
        try {
            if (sProxy == null) {
                sProxy = (BoostProvider) C8883a.j("com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl").b().f();
            }
            return sProxy.appActionLoading(i, aType);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static void appBootCompleted() {
        try {
            if (sProxy == null) {
                sProxy = (BoostProvider) C8883a.j("com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl").b().f();
            }
            sProxy.appBootCompleted();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl  Throwable: " + th.toString());
        }
    }

    public static BoostProvider getProxy() {
        if (sProxy == null) {
            sProxy = (BoostProvider) C8883a.j("com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && BoostProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (BoostProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean registerClient(String str) {
        try {
            if (sProxy == null) {
                sProxy = (BoostProvider) C8883a.j("com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl").b().f();
            }
            return sProxy.registerClient(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.boost.BoostProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
