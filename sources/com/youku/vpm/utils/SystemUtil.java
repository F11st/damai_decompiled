package com.youku.vpm.utils;

import android.content.Context;
import java.lang.reflect.Method;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemUtil {
    private static final String TAG = "SystemUtils";
    private static Class<?> mClassType = null;
    private static Method mGetIntMethod = null;
    private static Method mGetMethod = null;
    private static Method mSetMethod = null;
    private static int sDebuggable = -1;

    public static String get(String str) {
        init();
        try {
            return (String) mGetMethod.invoke(mClassType, str);
        } catch (Exception unused) {
            Logger.d(TAG, "get key " + str + " failed ");
            return null;
        }
    }

    public static int getInt(String str, int i) {
        init();
        try {
            return ((Integer) mGetIntMethod.invoke(mClassType, str, Integer.valueOf(i))).intValue();
        } catch (Exception unused) {
            Logger.d(TAG, "get key " + str + " failed ");
            return i;
        }
    }

    private static void init() {
        try {
            if (mClassType == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                mClassType = cls;
                mGetMethod = cls.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
                mSetMethod = mClassType.getDeclaredMethod("set", String.class, String.class);
                mGetIntMethod = mClassType.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isDebug(Context context) {
        if (sDebuggable == -1 && context != null) {
            try {
                if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0) {
                    sDebuggable = 1;
                } else {
                    sDebuggable = 0;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sDebuggable == 1;
    }

    public static void set(String str, String str2) {
        init();
        try {
            mSetMethod.invoke(mClassType, str, str2);
        } catch (Exception unused) {
            Logger.d(TAG, "set key " + str + " failed ");
        }
    }
}
