package io.flutter.embedding.android;

import android.os.Build;
import io.flutter.Log;
import java.lang.reflect.Method;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemProperties {
    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 91;
    private static final String TAG = "SystemProperties";
    private static Method methodAddChangeCallback;
    private static Method methodGet;
    private static Method methodGetBoolean;
    private static Method methodGetDef;
    private static Method methodGetInt;
    private static Method methodGetLong;
    private static Method methodSet;
    private static Class<?> systemPropertiesHelperClass;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            systemPropertiesHelperClass = cls;
            methodGet = cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
            methodGetDef = systemPropertiesHelperClass.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class);
            methodGetInt = systemPropertiesHelperClass.getMethod("getInt", String.class, Integer.TYPE);
            methodGetLong = systemPropertiesHelperClass.getMethod("getLong", String.class, Long.TYPE);
            methodGetBoolean = systemPropertiesHelperClass.getMethod("getBoolean", String.class, Boolean.TYPE);
            methodSet = systemPropertiesHelperClass.getMethod("set", String.class, String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            methodAddChangeCallback = systemPropertiesHelperClass.getMethod("addChangeCallback", Runnable.class);
        } catch (Throwable unused) {
            Log.w(TAG, "Can not found SystemProperties.addChangeCallback in API " + Build.VERSION.SDK_INT);
        }
    }

    public static void addChangeCallback(Runnable runnable) {
        Method method;
        if (systemPropertiesHelperClass == null || (method = methodAddChangeCallback) == null) {
            return;
        }
        try {
            method.invoke(null, runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String get(String str) {
        Method method;
        if (systemPropertiesHelperClass == null || (method = methodGet) == null) {
            return "";
        }
        try {
            return (String) method.invoke(null, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        Method method;
        if (systemPropertiesHelperClass != null && (method = methodGetBoolean) != null) {
            try {
                return ((Boolean) method.invoke(null, str, Boolean.valueOf(z))).booleanValue();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return z;
    }

    public static int getInt(String str, int i) {
        Method method;
        if (systemPropertiesHelperClass != null && (method = methodGetInt) != null) {
            try {
                return ((Integer) method.invoke(null, str, Integer.valueOf(i))).intValue();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i;
    }

    public static long getLong(String str, long j) {
        Method method;
        if (systemPropertiesHelperClass != null && (method = methodGetLong) != null) {
            try {
                return ((Long) method.invoke(null, str, Long.valueOf(j))).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return j;
    }

    public static void set(String str, String str2) {
        Method method;
        if (systemPropertiesHelperClass == null || (method = methodSet) == null) {
            return;
        }
        try {
            method.invoke(null, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String get(String str, String str2) {
        Method method;
        if (systemPropertiesHelperClass != null && (method = methodGetDef) != null) {
            try {
                return (String) method.invoke(null, str, str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str2;
    }
}
