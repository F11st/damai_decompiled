package com.alibaba.motu.crashreporter2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ObjectInvoker {
    private final Object mObject;
    private final Class mObjectClass;

    private ObjectInvoker(Object obj) {
        this.mObject = obj;
        if (obj instanceof Class) {
            this.mObjectClass = (Class) obj;
        } else if (obj != null) {
            this.mObjectClass = obj.getClass();
        } else {
            this.mObjectClass = NullPointerException.class;
        }
    }

    public static ObjectInvoker create(Class cls, Object... objArr) {
        try {
            Constructor constructor = getConstructor(cls, objArr);
            constructor.setAccessible(true);
            return new ObjectInvoker(constructor.newInstance(objArr));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Constructor getConstructor(Class cls, Object... objArr) {
        boolean z;
        int length = objArr != null ? objArr.length : 0;
        for (Constructor constructor : getConstructors(cls, length)) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == length) {
                int i = 0;
                while (true) {
                    if (i >= parameterTypes.length) {
                        z = true;
                        break;
                    } else if (!isClassObject(objArr[i], parameterTypes[i])) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return constructor;
                }
            }
        }
        throw new RuntimeException();
    }

    private static List<Constructor> getConstructors(Class cls, int i) {
        Constructor<?>[] constructors;
        ArrayList arrayList = new ArrayList();
        for (Constructor<?> constructor : cls.getConstructors()) {
            if (constructor.getParameterTypes().length == i) {
                arrayList.add(constructor);
            }
        }
        return arrayList;
    }

    private Field getField(String str) throws RuntimeException {
        Field field;
        Class cls = this.mObjectClass;
        while (true) {
            try {
                field = cls.getDeclaredField(str);
                break;
            } catch (Exception unused) {
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    field = null;
                    break;
                }
            }
        }
        if (field != null) {
            return field;
        }
        throw new RuntimeException(new NoSuchFieldException());
    }

    private Method getMethod(String str, Object... objArr) {
        boolean z;
        int length = objArr != null ? objArr.length : 0;
        for (Method method : getMethodsByName(str, length)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == length) {
                int i = 0;
                while (true) {
                    if (i >= parameterTypes.length) {
                        z = true;
                        break;
                    } else if (!isClassObject(objArr[i], parameterTypes[i])) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return method;
                }
            }
        }
        throw new RuntimeException();
    }

    private List<Method> getMethodsByName(String str, int i) {
        ArrayList arrayList = new ArrayList();
        Class cls = this.mObjectClass;
        do {
            Method[] declaredMethods = cls.getDeclaredMethods();
            if (declaredMethods != null) {
                for (Method method : declaredMethods) {
                    if (method != null && method.getName().equals(str) && method.getParameterTypes().length == i) {
                        arrayList.add(method);
                    }
                }
            }
            cls = cls.getSuperclass();
        } while (cls != Object.class);
        return arrayList;
    }

    private static boolean isClassObject(Object obj, Class cls) {
        if (obj == null) {
            return true;
        }
        if (obj.getClass() == Boolean.class && cls == Boolean.TYPE) {
            return true;
        }
        if (obj.getClass() == Byte.class && cls == Byte.TYPE) {
            return true;
        }
        if (obj.getClass() == Character.class && cls == Character.TYPE) {
            return true;
        }
        if (obj.getClass() == Short.class && cls == Short.TYPE) {
            return true;
        }
        if (obj.getClass() == Integer.class && cls == Integer.TYPE) {
            return true;
        }
        if (obj.getClass() == Float.class && cls == Float.TYPE) {
            return true;
        }
        if (obj.getClass() == Long.class && cls == Long.TYPE) {
            return true;
        }
        if (obj.getClass() == Double.class && cls == Double.TYPE) {
            return true;
        }
        return cls.isInstance(obj);
    }

    public static ObjectInvoker wrap(Object obj) {
        return new ObjectInvoker(obj);
    }

    public ObjectInvoker get(String str) throws RuntimeException {
        try {
            return get(getField(str));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectInvoker invoke(String str, Object... objArr) throws RuntimeException {
        Method method = getMethod(str, objArr);
        method.setAccessible(true);
        try {
            if (!Modifier.isStatic(method.getModifiers())) {
                if (method.getReturnType() != Void.TYPE) {
                    return new ObjectInvoker(method.invoke(this.mObject, objArr));
                }
                method.invoke(this.mObject, objArr);
                return null;
            } else if (method.getReturnType() != Void.TYPE) {
                return new ObjectInvoker(method.invoke(null, objArr));
            } else {
                method.invoke(null, objArr);
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectInvoker set(String str, Object obj) throws RuntimeException {
        return set(getField(str), obj);
    }

    public <T> T toObject() {
        return (T) this.mObject;
    }

    public ObjectInvoker set(String str, Class cls, Object obj) throws Exception {
        return set(cls.getDeclaredField(str), obj);
    }

    public ObjectInvoker get(String str, Class cls) throws RuntimeException {
        try {
            return get(cls.getDeclaredField(str));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ObjectInvoker set(Field field, Object obj) throws RuntimeException {
        try {
            field.setAccessible(true);
            if (Modifier.isStatic(field.getModifiers())) {
                field.set(null, obj);
            } else {
                field.set(this.mObject, obj);
            }
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ObjectInvoker get(Field field) throws Exception {
        field.setAccessible(true);
        return new ObjectInvoker(field.get(Modifier.isStatic(field.getModifiers()) ? null : this.mObject));
    }
}
