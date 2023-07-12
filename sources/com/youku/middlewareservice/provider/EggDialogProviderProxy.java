package com.youku.middlewareservice.provider;

import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class EggDialogProviderProxy {
    private static EggDialogProvider sProxy;

    public static String getEggDialogApi() {
        try {
            if (sProxy == null) {
                sProxy = (EggDialogProvider) C8883a.j("com.youku.middlewareservice_impl.provider.EggDialogProviderImpl").b().f();
            }
            return sProxy.getEggDialogApi();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.EggDialogProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static EggDialogProvider getProxy() {
        if (sProxy == null) {
            sProxy = (EggDialogProvider) C8883a.j("com.youku.middlewareservice_impl.provider.EggDialogProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && EggDialogProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (EggDialogProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isAvailable() {
        try {
            if (sProxy == null) {
                sProxy = (EggDialogProvider) C8883a.j("com.youku.middlewareservice_impl.provider.EggDialogProviderImpl").b().f();
            }
            return sProxy.isAvailable();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.EggDialogProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
