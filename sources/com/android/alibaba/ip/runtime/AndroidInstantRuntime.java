package com.android.alibaba.ip.runtime;

import com.android.alibaba.ip.common.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AndroidInstantRuntime {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    protected interface Logging {
        boolean isLoggable(Level level);

        void log(Level level, String str);

        void log(Level level, String str, Throwable th);
    }

    private static Field getField(Class cls, String str) {
        Field fieldByName = getFieldByName(cls, str);
        if (fieldByName != null) {
            fieldByName.setAccessible(true);
            return fieldByName;
        }
        throw new RuntimeException(new NoSuchElementException(str));
    }

    private static Field getFieldByName(Class<?> cls, String str) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            Level level = Level.FINE;
            if (logging.isLoggable(level)) {
                Log.logging.log(level, String.format("getFieldByName:%s in %s", str, cls.getName()));
            }
        }
        while (cls != null) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static Method getMethodByName(Class<?> cls, String str, Class[] clsArr) {
        Log.Logging logging;
        if (cls == null) {
            return null;
        }
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
                if (cls != null && (logging = Log.logging) != null) {
                    Level level = Level.FINE;
                    if (logging.isLoggable(level)) {
                        Log.logging.log(level, String.format("getMethodByName:Looking in %s now", cls.getName()));
                    }
                }
            }
        }
        return null;
    }

    public static Object getPrivateField(Object obj, Class cls, String str) {
        try {
            return getField(cls, str).get(obj);
        } catch (IllegalAccessException e) {
            Log.Logging logging = Log.logging;
            if (logging != null) {
                Level level = Level.SEVERE;
                Object[] objArr = new Object[2];
                objArr[0] = obj == null ? " static" : "";
                objArr[1] = str;
                logging.log(level, String.format("Exception during%1$s getField %2$s", objArr), e);
            }
            throw new RuntimeException(e);
        }
    }

    public static Object getStaticPrivateField(Class cls, String str) {
        return getPrivateField(null, cls, str);
    }

    public static Object invokeProtectedMethod(Object obj, Object[] objArr, Class[] clsArr, String str) throws Throwable {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            Level level = Level.FINE;
            if (logging.isLoggable(level)) {
                Log.logging.log(level, String.format("protectedMethod:%s on %s", str, obj));
            }
        }
        try {
            Method methodByName = getMethodByName(obj.getClass(), str, clsArr);
            if (methodByName != null) {
                methodByName.setAccessible(true);
                return methodByName.invoke(obj, objArr);
            }
            throw new RuntimeException(new NoSuchMethodException(str));
        } catch (IllegalAccessException e) {
            Log.logging.log(Level.SEVERE, String.format("Exception while invoking %s", str), e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw e2.getCause();
        }
    }

    public static Object invokeProtectedStaticMethod(Object[] objArr, Class[] clsArr, String str, Class cls) throws Throwable {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            Level level = Level.FINE;
            if (logging.isLoggable(level)) {
                Log.logging.log(level, String.format("protectedStaticMethod:%s on %s", str, cls.getName()));
            }
        }
        try {
            Method methodByName = getMethodByName(cls, str, clsArr);
            if (methodByName != null) {
                methodByName.setAccessible(true);
                return methodByName.invoke(null, objArr);
            }
            throw new RuntimeException(new NoSuchMethodException(str + " in class " + cls.getName()));
        } catch (IllegalAccessException e) {
            Log.logging.log(Level.SEVERE, String.format("Exception while invoking %s", str), e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw e2.getCause();
        }
    }

    public static <T> T newForClass(Object[] objArr, Class[] clsArr, Class<T> cls) throws Throwable {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            try {
                return cls.cast(declaredConstructor.newInstance(objArr));
            } catch (IllegalAccessException e) {
                Log.logging.log(Level.SEVERE, String.format("Exception while instantiating %s", cls), e);
                throw new RuntimeException(e);
            } catch (InstantiationException e2) {
                Log.logging.log(Level.SEVERE, String.format("Exception while instantiating %s", cls), e2);
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw e3.getCause();
            }
        } catch (NoSuchMethodException e4) {
            Log.logging.log(Level.SEVERE, "Exception while resolving constructor", e4);
            throw new RuntimeException(e4);
        }
    }

    public static void setLogger(Logger logger) {
        Log.logging = new Log.Logging() { // from class: com.android.alibaba.ip.runtime.AndroidInstantRuntime.1
            @Override // com.android.alibaba.ip.common.Log.Logging
            public boolean isLoggable(Level level) {
                return Log.logging.isLoggable(level);
            }

            @Override // com.android.alibaba.ip.common.Log.Logging
            public void log(Level level, String str) {
                Log.logging.log(level, str);
            }

            @Override // com.android.alibaba.ip.common.Log.Logging
            public void log(Level level, String str, Throwable th) {
                Log.logging.log(level, str, th);
            }
        };
    }

    public static void setPrivateField(Object obj, Object obj2, Class cls, String str) {
        try {
            getField(cls, str).set(obj, obj2);
        } catch (IllegalAccessException e) {
            Log.Logging logging = Log.logging;
            if (logging != null) {
                logging.log(Level.SEVERE, String.format("Exception during setPrivateField %s", str), e);
            }
            throw new RuntimeException(e);
        }
    }

    public static void setStaticPrivateField(Object obj, Class cls, String str) {
        setPrivateField(null, obj, cls, str);
    }

    public static boolean support(IpChange ipChange, String str) {
        if (ipChange == null) {
            return false;
        }
        return ipChange.ipc$support(str);
    }

    public static void trace(String str) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            logging.log(Level.FINE, str);
        }
    }

    public static void trace(String str, String str2) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            logging.log(Level.FINE, String.format("%s %s", str, str2));
        }
    }

    public static void trace(String str, String str2, String str3) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            logging.log(Level.FINE, String.format("%s %s %s", str, str2, str3));
        }
    }

    public static void trace(String str, String str2, String str3, String str4) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            logging.log(Level.FINE, String.format("%s %s %s %s", str, str2, str3, str4));
        }
    }
}
