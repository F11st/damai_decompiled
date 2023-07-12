package com.alient.oneservice.appinfo;

import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AppInfoProviderProxy {
    private static AppInfoProvider sProxy;

    public static String getCityId() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) a.j("com.alient.oneservice.provider.impl.appinfo.AppInfoProviderImpl").b().f();
            }
            return sProxy.getCityId();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.appinfo.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getComboChannel() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) a.j("com.alient.oneservice.provider.impl.appinfo.AppInfoProviderImpl").b().f();
            }
            return sProxy.getComboChannel();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.appinfo.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static AppInfoProvider getProxy() {
        if (sProxy == null) {
            sProxy = (AppInfoProvider) a.j("com.alient.oneservice.provider.impl.appinfo.AppInfoProviderImpl").b().f();
        }
        return sProxy;
    }

    public static String getTTID() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) a.j("com.alient.oneservice.provider.impl.appinfo.AppInfoProviderImpl").b().f();
            }
            return sProxy.getTTID();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.appinfo.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && AppInfoProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (AppInfoProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
