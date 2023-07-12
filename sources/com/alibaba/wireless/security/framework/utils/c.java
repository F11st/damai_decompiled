package com.alibaba.wireless.security.framework.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c {
    private final Object a;
    private final boolean b = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a {
        private a() {
        }
    }

    private c(Object obj) {
        this.a = obj;
    }

    public static c a(Object obj) {
        return new c(obj);
    }

    private static c a(Method method, Object obj, Object... objArr) throws d {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return a(obj);
            }
            return a(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new d(e);
        }
    }

    public static Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
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

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> b = b();
        try {
            return b.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return b.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    b = b.getSuperclass();
                    if (b == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (b == null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != a.class && !a(clsArr[i]).isAssignableFrom(a(clsArr2[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? a.class : obj.getClass();
        }
        return clsArr;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Method[] methods;
        Method[] declaredMethods;
        Class<?> b = b();
        for (Method method : b.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : b.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            b = b.getSuperclass();
        } while (b != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + b() + ".");
    }

    public c a(String str, Object... objArr) throws d {
        Class<?>[] a2 = a(objArr);
        try {
            try {
                return a(a(str, a2), this.a, objArr);
            } catch (NoSuchMethodException unused) {
                return a(b(str, a2), this.a, objArr);
            }
        } catch (NoSuchMethodException e) {
            throw new d(e);
        }
    }

    public <T> T a() {
        return (T) this.a;
    }

    public Class<?> b() {
        return this.b ? (Class) this.a : this.a.getClass();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.a.equals(((c) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
