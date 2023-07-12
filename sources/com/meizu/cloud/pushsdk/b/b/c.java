package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c {
    private static final HashMap<String, Method> a = new HashMap<>();
    private final com.meizu.cloud.pushsdk.b.b.a b;
    private final String c;
    private Class<?>[] d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.meizu.cloud.pushsdk.b.b.a aVar, String str, Class<?>... clsArr) {
        this.b = aVar;
        this.c = str;
        this.d = clsArr;
    }

    private Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    private Method a() throws NoSuchMethodException, ClassNotFoundException {
        Method[] methods;
        Method[] declaredMethods;
        Class<?> a2 = this.b.a();
        for (Method method : a2.getMethods()) {
            if (a(method, this.c, this.d)) {
                return method;
            }
        }
        for (Method method2 : a2.getDeclaredMethods()) {
            if (a(method2, this.c, this.d)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.c + " with params " + Arrays.toString(this.d) + " could be found on type " + a2);
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

    private String b() throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder(this.b.a().getName());
        sb.append(this.c);
        for (Class<?> cls : this.d) {
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b = b();
            Method method = a.get(b);
            if (method == null) {
                if (this.d.length == objArr.length) {
                    method = this.b.a().getMethod(this.c, this.d);
                } else {
                    if (objArr.length > 0) {
                        this.d = new Class[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            this.d[i] = objArr[i].getClass();
                        }
                    }
                    method = a();
                }
                a.put(b, method);
            }
            method.setAccessible(true);
            dVar.b = (T) method.invoke(obj, objArr);
            dVar.a = true;
        } catch (Exception e) {
            DebugLogger.d("ReflectMethod", "invoke exception, " + e.getMessage());
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.b.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }
}
