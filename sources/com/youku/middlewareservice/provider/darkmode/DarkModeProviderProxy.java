package com.youku.middlewareservice.provider.darkmode;

import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DarkModeProviderProxy {
    private static DarkModeProvider sProxy;

    public static String getDarkModeStatus() {
        try {
            if (sProxy == null) {
                sProxy = (DarkModeProvider) a.j("com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl").b().f();
            }
            return sProxy.getDarkModeStatus();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static DarkModeProvider getProxy() {
        if (sProxy == null) {
            sProxy = (DarkModeProvider) a.j("com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && DarkModeProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (DarkModeProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isDarkMode() {
        try {
            if (sProxy == null) {
                sProxy = (DarkModeProvider) a.j("com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl").b().f();
            }
            return sProxy.isDarkMode();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static void onConfigureChanged() {
        try {
            if (sProxy == null) {
                sProxy = (DarkModeProvider) a.j("com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl").b().f();
            }
            sProxy.onConfigureChanged();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl  Throwable: " + th.toString());
        }
    }

    public static boolean showdDarkmodeSwitch() {
        try {
            if (sProxy == null) {
                sProxy = (DarkModeProvider) a.j("com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl").b().f();
            }
            return sProxy.showdDarkmodeSwitch();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.darkmode.DarkModeProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
