package com.youku.middlewareservice.provider.kvdata;

import android.content.SharedPreferences;
import android.util.Log;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class SPProviderProxy {
    private static SPProvider sProxy;

    public static boolean getPreferenceBoolean(String str) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getPreferenceBoolean(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static int getPreferenceInt(String str) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getPreferenceInt(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static long getPreferenceLong(String str) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getPreferenceLong(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return 0L;
        }
    }

    public static String getPreferenceString(String str) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getPreferenceString(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static SPProvider getProxy() {
        if (sProxy == null) {
            sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
        }
        return sProxy;
    }

    public static SharedPreferences getSharedPreferences(String str) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getSharedPreferences(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && SPProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (SPProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void savePreference(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            sProxy.savePreference(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
        }
    }

    public static boolean getPreferenceBoolean(String str, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getPreferenceBoolean(str, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static int getPreferenceInt(String str, int i) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getPreferenceInt(str, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static long getPreferenceLong(String str, long j) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getPreferenceLong(str, j);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return 0L;
        }
    }

    public static String getPreferenceString(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getPreferenceString(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static SharedPreferences getSharedPreferences() {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            return sProxy.getSharedPreferences();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void savePreference(String str, int i) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            sProxy.savePreference(str, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void savePreference(String str, long j) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            sProxy.savePreference(str, j);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void savePreference(String str, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (SPProvider) C8883a.j("com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl").b().f();
            }
            sProxy.savePreference(str, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.SPProviderImpl  Throwable: " + th.toString());
        }
    }
}
