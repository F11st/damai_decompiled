package com.youku.middlewareservice.provider;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.Map;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class AppUpdateProviderProxy {
    private static AppUpdateProvider sProxy;

    public static void checkUpdate(Context context) {
        try {
            if (sProxy == null) {
                sProxy = (AppUpdateProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AppUpdateProviderImpl").b().f();
            }
            sProxy.checkUpdate(context);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AppUpdateProviderImpl  Throwable: " + th.toString());
        }
    }

    public static AppUpdateProvider getProxy() {
        if (sProxy == null) {
            sProxy = (AppUpdateProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AppUpdateProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && AppUpdateProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (AppUpdateProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void startUpdateActivity(Map<String, String> map, Activity activity) {
        try {
            if (sProxy == null) {
                sProxy = (AppUpdateProvider) C8883a.j("com.youku.middlewareservice_impl.provider.AppUpdateProviderImpl").b().f();
            }
            sProxy.startUpdateActivity(map, activity);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.AppUpdateProviderImpl  Throwable: " + th.toString());
        }
    }
}
