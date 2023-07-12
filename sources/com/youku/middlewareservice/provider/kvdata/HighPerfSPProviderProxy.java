package com.youku.middlewareservice.provider.kvdata;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.Set;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class HighPerfSPProviderProxy {
    private static HighPerfSPProvider sProxy;

    public static String[] allKeys(String str) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.allKeys(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static boolean contains(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.contains(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean getBoolean(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getBoolean(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static float getFloat(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getFloat(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return 0.0f;
        }
    }

    public static int getInt(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getInt(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static long getLong(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getLong(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return 0L;
        }
    }

    public static SharedPreferences getMultiProcessPreference(String str) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getMultiProcessPreference(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static SharedPreferences getPreference(String str) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getPreference(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static HighPerfSPProvider getProxy() {
        if (sProxy == null) {
            sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
        }
        return sProxy;
    }

    public static String getString(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getString(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static Set<String> getStringSet(String str, String str2, Set<String> set) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getStringSet(str, str2, set);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void importFromSharedPreferences(String str, SharedPreferences sharedPreferences) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            sProxy.importFromSharedPreferences(str, sharedPreferences);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && HighPerfSPProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (HighPerfSPProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean putBoolean(String str, String str2, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.putBoolean(str, str2, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean putFloat(String str, String str2, float f) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.putFloat(str, str2, f);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean putInt(String str, String str2, int i) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.putInt(str, str2, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean putLong(String str, String str2, long j) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.putLong(str, str2, j);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean putString(String str, String str2, String str3) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.putString(str, str2, str3);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean putStringSet(String str, String str2, Set<String> set) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.putStringSet(str, str2, set);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static void removeValueForKey(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            sProxy.removeValueForKey(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
        }
    }

    public static boolean getBoolean(String str, String str2, boolean z) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getBoolean(str, str2, z);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static float getFloat(String str, String str2, float f) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getFloat(str, str2, f);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return 0.0f;
        }
    }

    public static int getInt(String str, String str2, int i) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getInt(str, str2, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static long getLong(String str, String str2, long j) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getLong(str, str2, j);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return 0L;
        }
    }

    public static String getString(String str, String str2, String str3) {
        try {
            if (sProxy == null) {
                sProxy = (HighPerfSPProvider) a.j("com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl").b().f();
            }
            return sProxy.getString(str, str2, str3);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.kvdata.mmkv.HighPerfSPProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
