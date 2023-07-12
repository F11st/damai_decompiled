package com.youku.middlewareservice_impl.provider.info;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alient.oneservice.provider.impl.OneConfig;
import com.alient.oneservice.provider.impl.OneContext;
import com.youku.middlewareservice.provider.info.AppInfoProvider;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AppInfoProviderImpl implements AppInfoProvider {
    private static final boolean isDebuggable = OneContext.isDebuggable();

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getAppActiveTime() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getAppActiveVersion() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public Context getAppContext() {
        return OneContext.getApplicationContext();
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getAppKey() {
        return OneConfig.appkey;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getAppType() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public Application getApplication() {
        return OneContext.getApplication();
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getChannel() {
        return OneConfig.getChannel();
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getCurrentProcessName() {
        return ProcessUtil.getCurrentProcessName(OneContext.getApplicationContext());
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getManufacturedAppType() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getPackageName() {
        return getAppContext().getPackageName();
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getPreInstallBrand() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getTTID() {
        return OneConfig.getTtid();
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public int getVersionCode() {
        Context appContext = getAppContext();
        PackageManager packageManager = appContext.getPackageManager();
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return packageManager.getPackageInfo(appContext.getPackageName(), 16384).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                return (int) packageManager.getPackageInfo(appContext.getPackageName(), 16384).getLongVersionCode();
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public String getVersionName() {
        Context appContext = getAppContext();
        try {
            return appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isAbi64FromApk() {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (Build.VERSION.SDK_INT < 21 || (declaredMethod = (cls = Class.forName("dalvik.system.VMRuntime")).getDeclaredMethod("getRuntime", new Class[0])) == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
            return false;
        }
        Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
        if (invoke2 instanceof Boolean) {
            return ((Boolean) invoke2).booleanValue();
        }
        return false;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isDebuggable() {
        return isDebuggable;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isFullApp() {
        return true;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isHuaweiCarPreInstall() {
        return false;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isHuaweiPreInstall() {
        return false;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isManufacturedApp() {
        return true;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isMicroApp() {
        return false;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isPreInstallPackage() {
        return false;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isTudou() {
        return false;
    }

    @Override // com.youku.middlewareservice.provider.info.AppInfoProvider
    public boolean isYouku() {
        return false;
    }
}
