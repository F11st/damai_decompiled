package tb;

import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class xb {
    public static <T> T a(Class<T> cls, Object... objArr) {
        Constructor<T> declaredConstructor;
        try {
            if (objArr.length == 0) {
                declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            } else {
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
                declaredConstructor = cls.getDeclaredConstructor(clsArr);
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
