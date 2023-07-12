package org.joor;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* compiled from: Taobao */
/* renamed from: org.joor.a */
/* loaded from: classes2.dex */
public class C8883a {
    private final Class<?> a;
    private final Object b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: org.joor.a$a */
    /* loaded from: classes2.dex */
    public static class C8884a {
        private C8884a() {
        }
    }

    private C8883a(Class<?> cls) {
        this(cls, cls);
    }

    public static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private static Class<?> d(String str) throws ReflectException {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Class<?> e(String str, ClassLoader classLoader) throws ReflectException {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private boolean g(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != C8884a.class && !o(clsArr[i]).isAssignableFrom(o(clsArr2[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static C8883a h(Class<?> cls) {
        return new C8883a(cls);
    }

    private static C8883a i(Class<?> cls, Object obj) {
        return new C8883a(cls, obj);
    }

    public static C8883a j(String str) throws ReflectException {
        return h(d(str));
    }

    public static C8883a k(String str, ClassLoader classLoader) throws ReflectException {
        return h(e(str, classLoader));
    }

    private static C8883a l(Constructor<?> constructor, Object... objArr) throws ReflectException {
        try {
            return i(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Class<?>[] n(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? C8884a.class : obj.getClass();
        }
        return clsArr;
    }

    public static Class<?> o(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            return Void.TYPE == cls ? Void.class : cls;
        }
        return cls;
    }

    public C8883a b() throws ReflectException {
        return c(new Object[0]);
    }

    public C8883a c(Object... objArr) throws ReflectException {
        Constructor<?>[] declaredConstructors;
        Class<?>[] n = n(objArr);
        try {
            return l(m().getDeclaredConstructor(n), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor<?> constructor : m().getDeclaredConstructors()) {
                if (g(constructor.getParameterTypes(), n)) {
                    return l(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C8883a) {
            return this.b.equals(((C8883a) obj).f());
        }
        return false;
    }

    public <T> T f() {
        return (T) this.b;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public Class<?> m() {
        return this.a;
    }

    public String toString() {
        return this.b.toString();
    }

    private C8883a(Class<?> cls, Object obj) {
        this.a = cls;
        this.b = obj;
    }
}
