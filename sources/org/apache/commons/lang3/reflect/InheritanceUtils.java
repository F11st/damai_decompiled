package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.BooleanUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class InheritanceUtils {
    public static int distance(Class<?> cls, Class<?> cls2) {
        if (cls == null || cls2 == null) {
            return -1;
        }
        if (cls.equals(cls2)) {
            return 0;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        int integer = BooleanUtils.toInteger(cls2.equals(superclass));
        if (integer == 1) {
            return integer;
        }
        int distance = integer + distance(superclass, cls2);
        if (distance > 0) {
            return distance + 1;
        }
        return -1;
    }
}
