package com.alibaba.security.common.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.common.d.f */
/* loaded from: classes8.dex */
public final class C3809f {
    private static Class a(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (actualTypeArguments.length <= 0 || !(actualTypeArguments[0] instanceof Class)) {
            return Object.class;
        }
        return (Class) actualTypeArguments[0];
    }

    private static Class b(Class cls) throws IndexOutOfBoundsException {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (actualTypeArguments.length <= 0 || !(actualTypeArguments[0] instanceof Class)) {
            return Object.class;
        }
        return (Class) actualTypeArguments[0];
    }
}
