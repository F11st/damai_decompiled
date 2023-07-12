package com.alient.oneservice.nav;

import android.content.Context;
import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class NavProviderProxy {
    private static NavProvider sProxy;

    public static NavProvider getProxy() {
        if (sProxy == null) {
            sProxy = (NavProvider) a.j("com.alient.oneservice.provider.impl.nav.NavProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && NavProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (NavProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void toUri(Context context, Action action) {
        try {
            if (sProxy == null) {
                sProxy = (NavProvider) a.j("com.alient.oneservice.provider.impl.nav.NavProviderImpl").b().f();
            }
            sProxy.toUri(context, action);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.nav.NavProviderImpl  Throwable: " + th.toString());
        }
    }
}
