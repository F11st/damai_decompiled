package com.taobao.weex.devtools.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    @Nullable
    public static Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static Class<?> tryGetClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public static Field tryGetDeclaredField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            LogUtil.d(e, "Could not retrieve %s field from %s", str, cls);
            return null;
        }
    }

    @Nullable
    public static Method tryGetMethod(Class<?> cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            LogUtil.d(e, "Could not retrieve %s method from %s", str, cls);
            return null;
        }
    }

    public static Object tryInvokeMethod(Object obj, Method method, Object... objArr) {
        if (method == null || obj == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            LogUtil.d(e, "Could not invoke %s method from %s", method, obj);
            return null;
        } catch (InvocationTargetException e2) {
            LogUtil.d(e2, "Could not invoke %s method from %s", method, obj);
            return null;
        }
    }
}
