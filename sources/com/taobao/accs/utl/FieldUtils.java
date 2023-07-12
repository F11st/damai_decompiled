package com.taobao.accs.utl;

import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FieldUtils {
    public static <T> T getObjectFromField(Object obj, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static boolean setFieldToObject(Object obj, Field field, Object obj2, Object obj3) throws IllegalAccessException {
        if (obj2 == obj3) {
            return false;
        }
        field.setAccessible(true);
        field.set(obj, obj3);
        return true;
    }
}
