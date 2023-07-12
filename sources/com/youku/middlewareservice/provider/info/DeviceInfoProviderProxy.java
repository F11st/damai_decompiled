package com.youku.middlewareservice.provider.info;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DeviceInfoProviderProxy {
    private static DeviceInfoProvider sProxy;

    public static String getAndroidId() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getAndroidId();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static int getCPUCoresCount() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getCPUCoresCount();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static String getCpuAbi() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getCpuAbi();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getCpuInfo() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getCpuInfo();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getImei() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getImei();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getImsi() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getImsi();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getMachineType() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getMachineType();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getMeid() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getMeid();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getMemoryInfo() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getMemoryInfo();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getOSVersion() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getOSVersion();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static DeviceInfoProvider getProxy() {
        if (sProxy == null) {
            sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
        }
        return sProxy;
    }

    public static int getStatusBarHeight() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getStatusBarHeight();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static int getWindowHeight() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getWindowHeight();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static int getWindowWidth() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.getWindowWidth();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && DeviceInfoProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (DeviceInfoProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean is64Device() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.is64Device();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isCurrentPageHwMagicWindow(Activity activity) {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.isCurrentPageHwMagicWindow(activity);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isFoldScreen() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.isFoldScreen();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isHwMagicWindow() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.isHwMagicWindow();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isPad() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.isPad();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isTalkBackOpen() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.isTalkBackOpen();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isUseLargeLayout() {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.isUseLargeLayout();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isCurrentPageHwMagicWindow(Configuration configuration) {
        try {
            if (sProxy == null) {
                sProxy = (DeviceInfoProvider) a.j("com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl").b().f();
            }
            return sProxy.isCurrentPageHwMagicWindow(configuration);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
