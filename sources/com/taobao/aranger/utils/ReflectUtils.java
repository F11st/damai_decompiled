package com.taobao.aranger.utils;

import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";
    private static Method sGetDeclaredMethod;

    static {
        try {
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "reflect utils init error", e);
        }
    }

    public static Method getHideMethod(Class<?> cls, String str, Class<?>... clsArr) throws IllegalAccessException, InvocationTargetException, NullPointerException {
        Method method = sGetDeclaredMethod;
        Objects.requireNonNull(method, "sGetDeclaredMethod is null");
        return (Method) method.invoke(cls, str, clsArr);
    }
}
