package com.youku.android.utils;

import android.util.Log;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SystemUtils {
    private static final String TAG = "SystemUtils";
    private static Class<?> mClassType;
    private static Method mGetIntMethod;
    private static Method mGetMethod;
    private static Method mSetMethod;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static long startTime = 0;
    private static long lastTime = 0;

    public static String get(String str) {
        init();
        try {
            return (String) mGetMethod.invoke(mClassType, str);
        } catch (Exception unused) {
            Log.d(TAG, "get key " + str + " failed ");
            return null;
        }
    }

    public static int getInt(String str, int i) {
        init();
        try {
            return ((Integer) mGetIntMethod.invoke(mClassType, str, Integer.valueOf(i))).intValue();
        } catch (Exception unused) {
            Log.d(TAG, "get key " + str + " failed ");
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

    public static void printTime() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        long currentTimeMillis = System.currentTimeMillis();
        if (startTime == 0) {
            Log.d(TAG, "CurrentTime " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + " start time:" + df.format(new Date(currentTimeMillis)));
            startTime = currentTimeMillis;
        } else {
            Log.d(TAG, "CurrentTime " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + " time:" + (currentTimeMillis - lastTime) + " total:" + (currentTimeMillis - startTime));
        }
        lastTime = currentTimeMillis;
    }

    public static void printTimeClear() {
        startTime = 0L;
    }

    public static void set(String str, String str2) {
        init();
        try {
            mSetMethod.invoke(mClassType, str, str2);
        } catch (Exception unused) {
            Log.d(TAG, "set key " + str + " failed ");
        }
    }
}
