package com.alient.oneservice.image;

import android.util.Log;
import android.widget.ImageView;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ImageLoaderProviderProxy {
    private static ImageLoaderProvider sProxy;

    public static ImageLoaderProvider getProxy() {
        if (sProxy == null) {
            sProxy = (ImageLoaderProvider) a.j("com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && ImageLoaderProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (ImageLoaderProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ImageTicket load(String str, IImageSuccListener iImageSuccListener, IImageFailListener iImageFailListener) {
        try {
            if (sProxy == null) {
                sProxy = (ImageLoaderProvider) a.j("com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl").b().f();
            }
            return sProxy.load(str, iImageSuccListener, iImageFailListener);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static ImageTicket loadinto(String str, ImageView imageView) {
        try {
            if (sProxy == null) {
                sProxy = (ImageLoaderProvider) a.j("com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl").b().f();
            }
            return sProxy.loadinto(str, imageView);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static ImageTicket load(String str, int i, IImageSuccListener iImageSuccListener, IImageFailListener iImageFailListener) {
        try {
            if (sProxy == null) {
                sProxy = (ImageLoaderProvider) a.j("com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl").b().f();
            }
            return sProxy.load(str, i, iImageSuccListener, iImageFailListener);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
        try {
            if (sProxy == null) {
                sProxy = (ImageLoaderProvider) a.j("com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl").b().f();
            }
            return sProxy.loadinto(str, imageView, i, i2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
