package com.taobao.accs.utl;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";
    private static Method sForNameMethod;
    private static Method sGetFieldMethod;

    static {
        try {
            sForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "reflect utils init error", e);
        }
    }

    public static Class<?> getHideClass(String str) throws InvocationTargetException, IllegalAccessException {
        Method method = sForNameMethod;
        Objects.requireNonNull(method, "sForNameMethod is null");
        return (Class) method.invoke(null, str);
    }

    public static Field getHideField(Class<?> cls, String str) throws InvocationTargetException, IllegalAccessException {
        Method method = sGetFieldMethod;
        Objects.requireNonNull(method, "sGetFieldMethod is null");
        return (Field) method.invoke(cls, str);
    }
}
