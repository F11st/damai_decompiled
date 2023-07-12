package com.youku.middlewareservice.provider.lightwidget;

import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class LightWidgetProviderProxy {
    private static LightWidgetProvider sProxy;

    public static LightWidgetProvider getProxy() {
        if (sProxy == null) {
            sProxy = (LightWidgetProvider) C8883a.j("com.youku.middlewareservice_impl.provider.lightwidget.LightWidgetProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && LightWidgetProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (LightWidgetProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void releasePreloadImage(long j) {
        try {
            if (sProxy == null) {
                sProxy = (LightWidgetProvider) C8883a.j("com.youku.middlewareservice_impl.provider.lightwidget.LightWidgetProviderImpl").b().f();
            }
            sProxy.releasePreloadImage(j);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.lightwidget.LightWidgetProviderImpl  Throwable: " + th.toString());
        }
    }
}
