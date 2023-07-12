package com.youku.middlewareservice.provider.json;

import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class JsonProviderProxy {
    private static JsonProvider sProxy;

    public static <T> T fromJson(String str, Class<T> cls) {
        try {
            if (sProxy == null) {
                sProxy = (JsonProvider) a.j("com.youku.middlewareservice_impl.provider.json.JsonProviderImpl").b().f();
            }
            return (T) sProxy.fromJson(str, cls);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.json.JsonProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static JsonProvider getProxy() {
        if (sProxy == null) {
            sProxy = (JsonProvider) a.j("com.youku.middlewareservice_impl.provider.json.JsonProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && JsonProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (JsonProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        try {
            if (sProxy == null) {
                sProxy = (JsonProvider) a.j("com.youku.middlewareservice_impl.provider.json.JsonProviderImpl").b().f();
            }
            return (T) sProxy.parseObject(str, cls);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.json.JsonProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String toJSONString(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (JsonProvider) a.j("com.youku.middlewareservice_impl.provider.json.JsonProviderImpl").b().f();
            }
            return sProxy.toJSONString(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.json.JsonProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String toJson(Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (JsonProvider) a.j("com.youku.middlewareservice_impl.provider.json.JsonProviderImpl").b().f();
            }
            return sProxy.toJson(obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.json.JsonProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
