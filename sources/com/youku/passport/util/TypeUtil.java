package com.youku.passport.util;

import android.util.Log;
import com.youku.passport.result.AbsResult;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class TypeUtil {
    public static Type getClassType(Object obj, Class<?> cls) {
        Type type = null;
        if (obj == null) {
            return null;
        }
        try {
            for (Type type2 = obj.getClass(); type2 != null && type2 != Object.class; type2 = ((Class) type2).getGenericSuperclass()) {
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    if (parameterizedType.getRawType() == cls) {
                        type = parameterizedType.getActualTypeArguments()[0];
                        return type;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            Log.e("YKLogin.PassportSDK-Api", "find T extends AbsResult fails");
            th.printStackTrace();
            return type;
        }
    }

    public static Type getInterfaceType(Object obj, Class<?> cls) {
        Type type = null;
        if (obj == null) {
            return null;
        }
        try {
            for (Class<?> cls2 = obj.getClass(); cls2 != null && cls2 != Object.class; cls2 = (Class) cls2.getGenericSuperclass()) {
                Type[] genericInterfaces = cls2.getGenericInterfaces();
                int length = genericInterfaces.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Type type2 = genericInterfaces[i];
                    if (type2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type2;
                        if (parameterizedType.getRawType() == cls) {
                            type = parameterizedType.getActualTypeArguments()[0];
                            break;
                        }
                    }
                    i++;
                }
                if (type != null) {
                    break;
                }
            }
        } catch (Throwable th) {
            Log.e("YKLogin.PassportSDK-Api", "find T extends AbsResult fails");
            th.printStackTrace();
        }
        return type;
    }

    public static <T extends AbsResult> T initResult(Object obj, Class<?> cls) {
        Type classType;
        if (obj == null || cls == null) {
            return null;
        }
        if (cls.isInterface()) {
            classType = getInterfaceType(obj, cls);
        } else {
            classType = getClassType(obj, cls);
        }
        return (T) initResultType(classType);
    }

    public static <T extends AbsResult> T initResultType(Type type) {
        if (type instanceof Class) {
            try {
                return (T) ((Class) type).newInstance();
            } catch (Throwable th) {
                Log.e("YKLogin.PassportSDK-Api", "Initiate T extends AbsResult fails");
                th.printStackTrace();
            }
        } else if (type instanceof ParameterizedType) {
            try {
                return (T) ((Class) ((ParameterizedType) type).getRawType()).newInstance();
            } catch (Throwable th2) {
                Log.e("YKLogin.PassportSDK-Api", "Initiate CommonResult<K> fails");
                th2.printStackTrace();
            }
        }
        return null;
    }
}
