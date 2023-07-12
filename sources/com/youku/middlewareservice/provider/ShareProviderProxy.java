package com.youku.middlewareservice.provider;

import android.app.Activity;
import android.util.Log;
import java.util.Map;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ShareProviderProxy {
    private static ShareProvider sProxy;

    public static ShareProvider getProxy() {
        if (sProxy == null) {
            sProxy = (ShareProvider) a.j("com.youku.middlewareservice_impl.provider.DefaultShareProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && ShareProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (ShareProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void show(Activity activity, Map<String, String> map) {
        try {
            if (sProxy == null) {
                sProxy = (ShareProvider) a.j("com.youku.middlewareservice_impl.provider.DefaultShareProviderImpl").b().f();
            }
            sProxy.show(activity, map);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.DefaultShareProviderImpl  Throwable: " + th.toString());
        }
    }
}
