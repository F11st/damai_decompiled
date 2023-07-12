package android.taobao.windvane.xmlmanager;

import androidx.collection.LruCache;
import com.taobao.weex.annotation.JSMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
class WVReflectUtils {
    private static final LruCache<String, Method> methodsCache = new LruCache<>(8);

    WVReflectUtils() {
    }

    private static Method findMethod(Object obj, String str, Object... objArr) {
        Class<?> cls;
        Method[] declaredMethods;
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        String str2 = cls.getName() + JSMethod.NOT_SET + str;
        Method method = methodsCache.get(str2);
        if (method != null) {
            return method;
        }
        while (cls != null) {
            for (Method method2 : cls.getDeclaredMethods()) {
                if (str.equals(method2.getName()) && isMatchParameterTypes(method2.getGenericParameterTypes(), objArr)) {
                    method2.setAccessible(true);
                    methodsCache.put(str2, method2);
                    return method2;
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Object getValue(Object obj, String str) {
        try {
            if (obj instanceof Class) {
                Field field = ((Class) obj).getField(str);
                field.setAccessible(true);
                return field.get(null);
            }
            Field field2 = obj.getClass().getField(str);
            field2.setAccessible(true);
            return field2.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invoke(Object obj, String str, Object... objArr) {
        try {
            Method findMethod = findMethod(obj, str, objArr);
            if (findMethod == null) {
                return null;
            }
            if (obj instanceof Class) {
                return findMethod.invoke(null, objArr);
            }
            return findMethod.invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isMatchParameterTypes(Type[] typeArr, Object... objArr) {
        if (typeArr.length != objArr.length) {
            return false;
        }
        if (typeArr.length == 0) {
            return true;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            Type type = typeArr[i];
            if ((type instanceof Class ? (Class) type : null) == null) {
                return true;
            }
            obj.getClass();
        }
        return true;
    }
}
