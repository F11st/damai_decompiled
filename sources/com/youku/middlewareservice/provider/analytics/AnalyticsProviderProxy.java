package com.youku.middlewareservice.provider.analytics;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class AnalyticsProviderProxy {
    private static AnalyticsProvider sProxy;

    public static void addToTrack(Activity activity) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.addToTrack(activity);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void clearIgnoreTagForExposureView(View view) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.clearIgnoreTagForExposureView(view);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void commitExposureData() {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.commitExposureData();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static AnalyticsProvider getProxy() {
        if (sProxy == null) {
            sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void ignorePage(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.ignorePage(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && AnalyticsProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (AnalyticsProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void pageAppear(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.pageAppear(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void pageAppearDonotSkip(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.pageAppearDonotSkip(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void pageDisAppear(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.pageDisAppear(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void refreshExposureData() {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.refreshExposureData();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void scanView(View view) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.scanView(view);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void setIgnoreTagForExposureView(View view) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.setIgnoreTagForExposureView(view);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void setTrackerTagParam(View view, Map<String, String> map, String str) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.setTrackerTagParam(view, map, str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void setTrackerTagParamWithIndex(View view, String str, Map<String, String> map, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.setTrackerTagParamWithIndex(view, str, map, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void skipNextPageBack() {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.skipNextPageBack();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void startSessionForUt(Activity activity, String str, String str2, Map<String, String> map) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.startSessionForUt(activity, str, str2, map);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void utControlClick(String str, String str2, Map<String, String> map) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.utControlClick(str, str2, map);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void utCustomEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.utCustomEvent(str, i, str2, str3, str4, map);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void startSessionForUt(Activity activity, String str, HashMap<String, String> hashMap) {
        try {
            if (sProxy == null) {
                sProxy = (AnalyticsProvider) C8883a.j("com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl").b().f();
            }
            sProxy.startSessionForUt(activity, str, hashMap);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.analytics.AnalyticsProviderImpl  Throwable: " + th.toString());
        }
    }
}
