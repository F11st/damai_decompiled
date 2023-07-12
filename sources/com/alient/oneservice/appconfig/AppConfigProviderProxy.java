package com.alient.oneservice.appconfig;

import android.app.Activity;
import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AppConfigProviderProxy {
    private static AppConfigProvider sProxy;

    public static AppConfigProvider getProxy() {
        if (sProxy == null) {
            sProxy = (AppConfigProvider) a.j("com.alient.oneservice.provider.impl.appconfig.AppConfigProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && AppConfigProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (AppConfigProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showToast(Activity activity, String str, int i) {
        try {
            if (sProxy == null) {
                sProxy = (AppConfigProvider) a.j("com.alient.oneservice.provider.impl.appconfig.AppConfigProviderImpl").b().f();
            }
            sProxy.showToast(activity, str, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.appconfig.AppConfigProviderImpl  Throwable: " + th.toString());
        }
    }

    public static Activity topActivity() {
        try {
            if (sProxy == null) {
                sProxy = (AppConfigProvider) a.j("com.alient.oneservice.provider.impl.appconfig.AppConfigProviderImpl").b().f();
            }
            return sProxy.topActivity();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.appconfig.AppConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
