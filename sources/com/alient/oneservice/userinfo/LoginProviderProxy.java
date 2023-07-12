package com.alient.oneservice.userinfo;

import android.content.Context;
import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LoginProviderProxy {
    private static LoginProvider sProxy;

    public static boolean checkSessionValid() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.alient.oneservice.provider.impl.userinfo.LoginProviderImpl").b().f();
            }
            return sProxy.checkSessionValid();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.userinfo.LoginProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static LoginProvider getProxy() {
        if (sProxy == null) {
            sProxy = (LoginProvider) a.j("com.alient.oneservice.provider.impl.userinfo.LoginProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && LoginProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (LoginProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void notifyLogin(Context context, YYLoginListener yYLoginListener) {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.alient.oneservice.provider.impl.userinfo.LoginProviderImpl").b().f();
            }
            sProxy.notifyLogin(context, yYLoginListener);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.userinfo.LoginProviderImpl  Throwable: " + th.toString());
        }
    }
}
