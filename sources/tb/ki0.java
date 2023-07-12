package tb;

import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ki0 {
    public static <T> T a(Object obj, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static boolean b(Object obj, Field field, Object obj2, Object obj3) throws IllegalAccessException {
        if (obj2 == obj3) {
            return false;
        }
        field.setAccessible(true);
        field.set(obj, obj3);
        return true;
    }
}
