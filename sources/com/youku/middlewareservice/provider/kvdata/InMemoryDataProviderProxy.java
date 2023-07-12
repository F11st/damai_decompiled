package com.youku.middlewareservice.provider.kvdata;

import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class InMemoryDataProviderProxy {
    private static InMemoryDataProvider sProxy;

    public static void clearGlobalData(String str) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            sProxy.clearGlobalData(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
        }
    }

    public static boolean getGlobalBooleanData(String str, String str2, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            return sProxy.getGlobalBooleanData(str, str2, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static int getGlobalIntData(String str, String str2, int i) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            return sProxy.getGlobalIntData(str, str2, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static long getGlobalLongData(String str, String str2, long j) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            return sProxy.getGlobalLongData(str, str2, j);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
            return 0L;
        }
    }

    public static Object getGlobalObjectData(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            return sProxy.getGlobalObjectData(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getGlobalStringData(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            return sProxy.getGlobalStringData(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static InMemoryDataProvider getProxy() {
        if (sProxy == null) {
            sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
        }
        return sProxy;
    }

    public static boolean hasGlobalData(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            return sProxy.hasGlobalData(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && InMemoryDataProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (InMemoryDataProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Object removeGlobalData(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            return sProxy.removeGlobalData(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void setGlobalData(String str, String str2, Object obj) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            sProxy.setGlobalData(str, str2, obj);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void setGlobalData(String str, String str2, long j) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            sProxy.setGlobalData(str, str2, j);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void setGlobalData(String str, String str2, int i) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            sProxy.setGlobalData(str, str2, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void setGlobalData(String str, String str2, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (InMemoryDataProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl").b().f();
            }
            sProxy.setGlobalData(str, str2, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.InMemoryDataProviderImpl  Throwable: " + th.toString());
        }
    }
}
