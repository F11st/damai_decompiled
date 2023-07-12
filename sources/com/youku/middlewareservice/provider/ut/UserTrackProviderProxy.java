package com.youku.middlewareservice.provider.ut;

import android.util.Log;
import com.taobao.statistic.CT;
import java.util.Map;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class UserTrackProviderProxy {
    private static UserTrackProvider sProxy;

    public static void commitEvent(String str, int i, Object obj, Object obj2, Object obj3, String[] strArr) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.commitEvent(str, i, obj, obj2, obj3, strArr);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void ctrlClicked(String str, CT ct, String str2, String str3) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.ctrlClicked(str, ct, str2, str3);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static UserTrackProvider getProxy() {
        if (sProxy == null) {
            sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
        }
        return sProxy;
    }

    public static String getUtdid() {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            return sProxy.getUtdid();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
            return null;
        }
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

    public static void pageAppear(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.pageAppear(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void pageDisappear(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.pageDisappear(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void registTrackPage(String str, String str2, String str3) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.registTrackPage(str, str2, str3);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void updateNextPageProperties(Map<String, String> map) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.updateNextPageProperties(map);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void updatePageInfo(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.updatePageInfo(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void updatePageName(Object obj, String str) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.updatePageName(obj, str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void updatePageProperties(Object obj, Map<String, String> map) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.updatePageProperties(obj, map);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void updateNextPageProperties(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (UserTrackProvider) a.j("com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl").b().f();
            }
            sProxy.updateNextPageProperties(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.ut.UserTrackProviderImpl  Throwable: " + th.toString());
        }
    }
}
