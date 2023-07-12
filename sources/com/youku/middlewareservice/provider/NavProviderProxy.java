package com.youku.middlewareservice.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class NavProviderProxy {
    private static NavProvider sProxy;

    public static NavProvider getProxy() {
        if (sProxy == null) {
            sProxy = (NavProvider) C8883a.j("com.youku.middlewareservice_impl.provider.NavProviderImpl").b().f();
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

    public static void toUri(Context context, String str, Bundle bundle) {
        try {
            if (sProxy == null) {
                sProxy = (NavProvider) C8883a.j("com.youku.middlewareservice_impl.provider.NavProviderImpl").b().f();
            }
            sProxy.toUri(context, str, bundle);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.NavProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void toUri(Context context, String str) {
        try {
            if (sProxy == null) {
                sProxy = (NavProvider) C8883a.j("com.youku.middlewareservice_impl.provider.NavProviderImpl").b().f();
            }
            sProxy.toUri(context, str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.NavProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void toUri(Context context, Uri uri, Bundle bundle) {
        try {
            if (sProxy == null) {
                sProxy = (NavProvider) C8883a.j("com.youku.middlewareservice_impl.provider.NavProviderImpl").b().f();
            }
            sProxy.toUri(context, uri, bundle);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.NavProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void toUri(Context context, Uri uri) {
        try {
            if (sProxy == null) {
                sProxy = (NavProvider) C8883a.j("com.youku.middlewareservice_impl.provider.NavProviderImpl").b().f();
            }
            sProxy.toUri(context, uri);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.NavProviderImpl  Throwable: " + th.toString());
        }
    }
}
