package com.alient.oneservice.config;

import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ConfigProviderProxy {
    private static ConfigProvider sProxy;

    public static ConfigProvider getProxy() {
        if (sProxy == null) {
            sProxy = (ConfigProvider) C8883a.j("com.alient.oneservice.provider.impl.config.ConfigProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && ConfigProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (ConfigProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isAppRecommendAvailability() {
        try {
            if (sProxy == null) {
                sProxy = (ConfigProvider) C8883a.j("com.alient.oneservice.provider.impl.config.ConfigProviderImpl").b().f();
            }
            return sProxy.isAppRecommendAvailability();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.config.ConfigProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isHomepageCndRequestEnable() {
        try {
            if (sProxy == null) {
                sProxy = (ConfigProvider) C8883a.j("com.alient.oneservice.provider.impl.config.ConfigProviderImpl").b().f();
            }
            return sProxy.isHomepageCndRequestEnable();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.config.ConfigProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isOpenSearchCdnDowngrade() {
        try {
            if (sProxy == null) {
                sProxy = (ConfigProvider) C8883a.j("com.alient.oneservice.provider.impl.config.ConfigProviderImpl").b().f();
            }
            return sProxy.isOpenSearchCdnDowngrade();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.config.ConfigProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
