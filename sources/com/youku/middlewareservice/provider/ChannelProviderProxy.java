package com.youku.middlewareservice.provider;

import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ChannelProviderProxy {
    private static ChannelProvider sProxy;

    public static String getChannelId() {
        try {
            if (sProxy == null) {
                sProxy = (ChannelProvider) a.j("com.youku.middlewareservice_impl.provider.ChannelProviderImpl").b().f();
            }
            return sProxy.getChannelId();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ChannelProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getPid() {
        try {
            if (sProxy == null) {
                sProxy = (ChannelProvider) a.j("com.youku.middlewareservice_impl.provider.ChannelProviderImpl").b().f();
            }
            return sProxy.getPid();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ChannelProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static ChannelProvider getProxy() {
        if (sProxy == null) {
            sProxy = (ChannelProvider) a.j("com.youku.middlewareservice_impl.provider.ChannelProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && ChannelProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (ChannelProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isGooglePlayChannel() {
        try {
            if (sProxy == null) {
                sProxy = (ChannelProvider) a.j("com.youku.middlewareservice_impl.provider.ChannelProviderImpl").b().f();
            }
            return sProxy.isGooglePlayChannel();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ChannelProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
