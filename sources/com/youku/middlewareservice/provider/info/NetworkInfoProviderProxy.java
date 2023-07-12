package com.youku.middlewareservice.provider.info;

import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class NetworkInfoProviderProxy {
    private static NetworkInfoProvider sProxy;

    public static int getNetworkType() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.getNetworkType();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static int getNetworkTypeWithCache() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.getNetworkTypeWithCache();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static NetworkInfoProvider getProxy() {
        if (sProxy == null) {
            sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
        }
        return sProxy;
    }

    public static String getWifiMacAdress() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.getWifiMacAdress();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getWifiSsid() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.getWifiSsid();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && NetworkInfoProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (NetworkInfoProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isMobile() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.isMobile();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isMobileWithCache() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.isMobileWithCache();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isNetworkAvailable() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.isNetworkAvailable();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isNetworkAvailableWithCache() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.isNetworkAvailableWithCache();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isWifi() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.isWifi();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isWifiWithCache() {
        try {
            if (sProxy == null) {
                sProxy = (NetworkInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl").b().f();
            }
            return sProxy.isWifiWithCache();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.NetworkInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
