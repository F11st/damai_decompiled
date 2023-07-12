package com.alient.oneservice.ut;

import android.util.Log;
import android.view.View;
import java.util.Map;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UserTrackProviderProxy {
    private static UserTrackProvider sProxy;

    public static void click(View view, TrackInfo trackInfo) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.click(view, trackInfo);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void expose(View view, TrackInfo trackInfo) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.expose(view, trackInfo);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static UserTrackProvider getProxy() {
        if (sProxy == null) {
            sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && UserTrackProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (UserTrackProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reportCustom(Map<String, String> map, String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.reportCustom(map, str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void reportOriginalCustomEvent(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.reportOriginalCustomEvent(str, str2, str3, str4, str5, map);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void click(View view, TrackInfo trackInfo, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.click(view, trackInfo, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void expose(String str, TrackInfo trackInfo) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.expose(str, trackInfo);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void click(TrackInfo trackInfo) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.click(trackInfo);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void expose(View view, String str, TrackInfo trackInfo) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.expose(view, str, trackInfo);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void click(TrackInfo trackInfo, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.click(trackInfo, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }
}
