package com.uc.webview.export.internal.utility;

import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.SDKFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public class ReflectionUtil {

    /* compiled from: Taobao */
    @Interface
    /* loaded from: classes11.dex */
    public static final class BindingMethod<T> {
        private Class<?> a;
        private Method b;
        private T c;

        public BindingMethod(Class<?> cls, String str) {
            this(cls, str, null);
        }

        private synchronized T a() {
            if (this.c == null) {
                this.c = invoke();
            }
            return this.c;
        }

        public final T getInstance() {
            if (this.c == null) {
                this.c = a();
            }
            return this.c;
        }

        public final T invoke() {
            return invoke(null, null);
        }

        public BindingMethod(Class<?> cls, String str, Class<?>[] clsArr) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.a = cls;
            try {
                try {
                    this.b = cls.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException e) {
                    throw new NoSuchMethodError(e.getMessage());
                }
            } catch (Throwable unused) {
                this.b = this.a.getMethod(str, clsArr);
            }
        }

        public final T invoke(Object[] objArr) {
            return invoke(null, objArr);
        }

        public final T invoke(Object obj) {
            return invoke(obj, null);
        }

        public final T invoke(Object obj, Object[] objArr) {
            try {
                return (T) this.b.invoke(obj, objArr);
            } catch (RuntimeException e) {
                throw e;
            } catch (InvocationTargetException e2) {
                Throwable targetException = e2.getTargetException();
                if (!(targetException instanceof RuntimeException)) {
                    if (targetException instanceof Error) {
                        throw ((Error) targetException);
                    }
                    throw new RuntimeException(targetException);
                }
                throw ((RuntimeException) targetException);
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public static ClassLoader getCoreClassLoader() {
        return SDKFactory.c;
    }

    public static Method getMethod(Class<?> cls, String str) {
        return getMethod(cls, str, null);
    }

    public static Object getStaticField(String str, String str2) throws Exception {
        try {
            return Class.forName(str, true, SDKFactory.c).getField(str2).get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invoke(String str, String str2) throws Exception {
        return invoke(str, str2, (Class[]) null, (Object[]) null);
    }

    public static Object invokeNoThrow(String str, String str2) {
        try {
            return invoke(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object newInstance(String str) throws Exception {
        return newInstance(str, null, null);
    }

    public static Object newInstanceNoThrow(String str) {
        try {
            return newInstance(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        if (cls == null) {
            return null;
        }
        if (clsArr != null) {
            try {
                try {
                    method = cls.getMethod(str, clsArr);
                } catch (Throwable unused) {
                    method = cls.getDeclaredMethod(str, clsArr);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                if (method2.getName().equals(str)) {
                    method = method2;
                    break;
                }
                i2++;
            }
            if (method == null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length2 = declaredMethods.length;
                while (true) {
                    if (i >= length2) {
                        break;
                    }
                    Method method3 = declaredMethods[i];
                    if (method3.getName().equals(str)) {
                        method = method3;
                        break;
                    }
                    i++;
                }
            }
        }
        if (method != null) {
            method.setAccessible(true);
        }
        return method;
    }

    public static Object invoke(String str, String str2, Class[] clsArr) throws Exception {
        return invoke(str, str2, clsArr, (Object[]) null);
    }

    public static Object newInstance(String str, Class[] clsArr, Object[] objArr) throws Exception {
        try {
            Constructor<?> constructor = Class.forName(str, true, SDKFactory.c).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (!(targetException instanceof Exception)) {
                if (targetException instanceof Error) {
                    throw ((Error) targetException);
                }
                throw new RuntimeException(targetException);
            }
            throw ((Exception) targetException);
        }
    }

    public static Object invoke(String str, String str2, Object[] objArr) throws Exception {
        Class[] clsArr;
        if (objArr != null) {
            clsArr = new Class[objArr.length];
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        } else {
            clsArr = null;
        }
        return invoke(str, str2, clsArr, objArr);
    }

    public static Object invokeNoThrow(Class<?> cls, String str) {
        try {
            return invoke(cls, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeNoThrow(Object obj, String str) {
        try {
            return invoke(obj, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invoke(String str, String str2, Class[] clsArr, Object[] objArr) throws Exception {
        return invoke(Class.forName(str, true, SDKFactory.c), str2, clsArr, objArr);
    }

    public static Object invokeNoThrow(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return invoke(obj, str, clsArr, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invoke(Object obj, String str) throws Exception {
        return invoke(obj, str, (Class[]) null, new Object[0]);
    }

    public static Object invokeNoThrow(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return invoke(Class.forName(str, true, SDKFactory.c), str2, clsArr, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invoke(Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
        if (obj == null) {
            return null;
        }
        return invoke(obj, obj.getClass(), str, clsArr, objArr);
    }

    public static Object invoke(Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        return invoke(null, cls, str, clsArr, objArr);
    }

    public static Object invoke(Object obj, Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Method method;
        try {
            method = cls.getDeclaredMethod(str, clsArr);
        } catch (Throwable unused) {
            method = cls.getMethod(str, clsArr);
        }
        return invoke(obj, cls, method, objArr);
    }

    public static Object invoke(Object obj, Class<?> cls, Method method, Object[] objArr) throws Exception {
        method.setAccessible(true);
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (!(targetException instanceof Exception)) {
                if (targetException instanceof Error) {
                    throw ((Error) targetException);
                }
                throw new RuntimeException(targetException);
            }
            throw ((Exception) targetException);
        }
    }
}
