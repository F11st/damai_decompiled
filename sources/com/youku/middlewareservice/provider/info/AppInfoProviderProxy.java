package com.youku.middlewareservice.provider.info;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class AppInfoProviderProxy {
    private static AppInfoProvider sProxy;

    public static String getAppActiveTime() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getAppActiveTime();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getAppActiveVersion() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getAppActiveVersion();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static Context getAppContext() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getAppContext();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getAppKey() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getAppKey();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getAppType() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getAppType();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static Application getApplication() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getApplication();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getChannel() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getChannel();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getCurrentProcessName() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getCurrentProcessName();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getManufacturedAppType() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getManufacturedAppType();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getPackageName() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getPackageName();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getPreInstallBrand() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getPreInstallBrand();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static AppInfoProvider getProxy() {
        if (sProxy == null) {
            sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
        }
        return sProxy;
    }

    public static String getTTID() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getTTID();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static int getVersionCode() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getVersionCode();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static String getVersionName() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.getVersionName();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
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

    public static boolean isAbi64FromApk() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isAbi64FromApk();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isDebuggable() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isDebuggable();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isFullApp() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isFullApp();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isHuaweiCarPreInstall() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isHuaweiCarPreInstall();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isHuaweiPreInstall() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isHuaweiPreInstall();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isManufacturedApp() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isManufacturedApp();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isMicroApp() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isMicroApp();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isPreInstallPackage() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isPreInstallPackage();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isTudou() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isTudou();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isYouku() {
        try {
            if (sProxy == null) {
                sProxy = (AppInfoProvider) C8883a.j("com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl").b().f();
            }
            return sProxy.isYouku();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.AppInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
