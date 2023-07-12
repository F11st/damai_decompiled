package com.taobao.aranger.utils;

import android.content.ComponentName;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.annotation.type.ServiceName;
import com.taobao.aranger.core.ipc.provider.ARangerProvider;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class TypeUtils {
    private TypeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean arrayContainsAnnotation(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        if (annotationArr != null && cls != null) {
            for (Annotation annotation : annotationArr) {
                if (cls.isInstance(annotation)) {
                    return true;
                }
            }
        }
        return false;
    }

    static String basicNameConvert(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2056817302:
                if (str.equals("java.lang.Integer")) {
                    c = 0;
                    break;
                }
                break;
            case -527879800:
                if (str.equals("java.lang.Float")) {
                    c = 1;
                    break;
                }
                break;
            case -515992664:
                if (str.equals("java.lang.Short")) {
                    c = 2;
                    break;
                }
                break;
            case 155276373:
                if (str.equals("java.lang.Character")) {
                    c = 3;
                    break;
                }
                break;
            case 344809556:
                if (str.equals("java.lang.Boolean")) {
                    c = 4;
                    break;
                }
                break;
            case 398507100:
                if (str.equals("java.lang.Byte")) {
                    c = 5;
                    break;
                }
                break;
            case 398795216:
                if (str.equals("java.lang.Long")) {
                    c = 6;
                    break;
                }
                break;
            case 761287205:
                if (str.equals("java.lang.Double")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "int";
            case 1:
                return TypedValues.Custom.S_FLOAT;
            case 2:
                return "short";
            case 3:
                return "char";
            case 4:
                return TypedValues.Custom.S_BOOLEAN;
            case 5:
                return "byte";
            case 6:
                return "long";
            case 7:
                return "double";
            default:
                return str;
        }
    }

    private static boolean classAssignable(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        int length = clsArr2.length;
        for (int i = 0; i < length; i++) {
            if (clsArr2[i] != null && !classMatch(clsArr[i], clsArr2[i]) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean classMatch(Class<?> cls, Class<?> cls2) {
        return cls == cls2 || primitiveMatch(cls, cls2) || primitiveMatch(cls2, cls);
    }

    public static void convertObjectToArray(String str, Object obj, Object obj2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 2887:
                if (str.equals("[B")) {
                    c = 0;
                    break;
                }
                break;
            case 2888:
                if (str.equals("[C")) {
                    c = 1;
                    break;
                }
                break;
            case 2889:
                if (str.equals("[D")) {
                    c = 2;
                    break;
                }
                break;
            case 2891:
                if (str.equals("[F")) {
                    c = 3;
                    break;
                }
                break;
            case 2894:
                if (str.equals("[I")) {
                    c = 4;
                    break;
                }
                break;
            case 2895:
                if (str.equals("[J")) {
                    c = 5;
                    break;
                }
                break;
            case 2904:
                if (str.equals("[S")) {
                    c = 6;
                    break;
                }
                break;
            case 2911:
                if (str.equals("[Z")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                byte[] bArr = (byte[]) obj2;
                if (bArr != null) {
                    byte[] bArr2 = (byte[]) obj;
                    System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                    return;
                }
                return;
            case 1:
                char[] cArr = (char[]) obj2;
                if (cArr != null) {
                    char[] cArr2 = (char[]) obj;
                    System.arraycopy(cArr, 0, cArr2, 0, cArr2.length);
                    return;
                }
                return;
            case 2:
                double[] dArr = (double[]) obj2;
                if (dArr != null) {
                    double[] dArr2 = (double[]) obj;
                    System.arraycopy(dArr, 0, dArr2, 0, dArr2.length);
                    return;
                }
                return;
            case 3:
                float[] fArr = (float[]) obj2;
                if (fArr != null) {
                    float[] fArr2 = (float[]) obj;
                    System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
                    return;
                }
                return;
            case 4:
                int[] iArr = (int[]) obj2;
                if (iArr != null) {
                    int[] iArr2 = (int[]) obj;
                    System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
                    return;
                }
                return;
            case 5:
                long[] jArr = (long[]) obj2;
                if (jArr != null) {
                    long[] jArr2 = (long[]) obj;
                    System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
                    return;
                }
                return;
            case 6:
                short[] sArr = (short[]) obj2;
                if (sArr != null) {
                    short[] sArr2 = (short[]) obj;
                    System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
                    return;
                }
                return;
            case 7:
                boolean[] zArr = (boolean[]) obj2;
                if (zArr != null) {
                    boolean[] zArr2 = (boolean[]) obj;
                    System.arraycopy(zArr, 0, zArr2, 0, zArr2.length);
                    return;
                }
                return;
            default:
                Object[] objArr = (Object[]) obj2;
                if (objArr != null) {
                    Object[] objArr2 = (Object[]) obj;
                    System.arraycopy(objArr, 0, objArr2, 0, objArr2.length);
                    return;
                }
                return;
        }
    }

    public static String getClassId(Class<?> cls) {
        return cls.getName();
    }

    public static Constructor<?> getConstructor(Class<?> cls, Class<?>[] clsArr) throws IPCException {
        Constructor[] constructors;
        String constructorId = getConstructorId(cls, clsArr);
        Constructor d = d.e().d(constructorId);
        if (d != null) {
            return d;
        }
        for (Constructor constructor : cls.getConstructors()) {
            if (classAssignable(constructor.getParameterTypes(), clsArr)) {
                if (d == null) {
                    d.e().g(constructorId, constructor);
                    d = constructor;
                } else {
                    throw new IPCException(15, "The class " + cls.getName() + " has too many constructors whose  parameter types match the required types.");
                }
            }
        }
        if (d != null) {
            return d;
        }
        throw new IPCException(16, "The class " + cls.getName() + " do not have a constructor whose  parameter types match the required types.");
    }

    private static String getConstructorId(Class cls, Class[] clsArr) {
        return cls.getSimpleName() + '(' + getMethodParameters(clsArr) + ')';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) throws IPCException {
        Method[] declaredMethods;
        Method method = null;
        for (Method method2 : cls.getDeclaredMethods()) {
            if (method2.getName().equals(str) && classAssignable(method2.getParameterTypes(), clsArr)) {
                if (method == null) {
                    method2.setAccessible(true);
                    method = method2;
                } else {
                    throw new IPCException(14, "There are more than one method named " + str + " of the class " + cls.getName() + " matching the parameters!");
                }
            }
        }
        if (method == null) {
            return null;
        }
        if (method.getReturnType() == cls2) {
            return method;
        }
        throw new IPCException(17, "The method named " + str + " of the class " + cls.getName() + " matches the parameter types but not the return type. The return type is " + method.getReturnType().getName() + " but the required type is " + cls2.getName() + ". The method in the local interface must exactly match the method in the remote class.");
    }

    public static Method getMethodForGettingInstance(Class<?> cls, String str, Class<?>[] clsArr) throws IPCException {
        Method[] declaredMethods;
        Method method = null;
        for (Method method2 : cls.getDeclaredMethods()) {
            String name = method2.getName();
            if (((str.equals("") && name.equals("getInstance")) || (!str.equals("") && name.equals(str))) && classAssignable(method2.getParameterTypes(), clsArr)) {
                if (method == null) {
                    method2.setAccessible(true);
                    method = method2;
                } else {
                    throw new IPCException(37, "When getting instance, there are more than one method named " + str + " of the class " + cls.getName() + " matching the parameters!");
                }
            }
        }
        if (method != null) {
            if (method.getReturnType() == cls) {
                return method;
            }
            throw new IPCException(38, "When getting instance, the method named " + str + " of the class " + cls.getName() + " matches the parameter types but not the return type. The return type is " + method.getReturnType().getName() + " but the required type is " + cls.getName() + ".");
        }
        throw new IPCException(39, "When getting instance, the method named " + str + " of the class " + cls.getName() + " is not found. The class must have a method for getting instance.");
    }

    public static String getMethodId(String str, ParameterWrapper[] parameterWrapperArr) {
        return str + '(' + getMethodParameters(parameterWrapperArr) + ')';
    }

    private static String getMethodParameters(ParameterWrapper[] parameterWrapperArr) {
        StringBuilder sb = new StringBuilder();
        int length = parameterWrapperArr.length;
        if (length == 0) {
            return sb.toString();
        }
        sb.append(basicNameConvert(parameterWrapperArr[0].getName()));
        for (int i = 1; i < length; i++) {
            sb.append(",");
            sb.append(basicNameConvert(parameterWrapperArr[i].getName()));
        }
        return sb.toString();
    }

    public static int getObjectArraySize(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 2887:
                if (str.equals("[B")) {
                    c = 0;
                    break;
                }
                break;
            case 2888:
                if (str.equals("[C")) {
                    c = 1;
                    break;
                }
                break;
            case 2889:
                if (str.equals("[D")) {
                    c = 2;
                    break;
                }
                break;
            case 2891:
                if (str.equals("[F")) {
                    c = 3;
                    break;
                }
                break;
            case 2894:
                if (str.equals("[I")) {
                    c = 4;
                    break;
                }
                break;
            case 2895:
                if (str.equals("[J")) {
                    c = 5;
                    break;
                }
                break;
            case 2904:
                if (str.equals("[S")) {
                    c = 6;
                    break;
                }
                break;
            case 2911:
                if (str.equals("[Z")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return ((byte[]) obj).length;
            case 1:
                return ((char[]) obj).length;
            case 2:
                return ((double[]) obj).length;
            case 3:
                return ((float[]) obj).length;
            case 4:
                return ((int[]) obj).length;
            case 5:
                return ((long[]) obj).length;
            case 6:
                return ((short[]) obj).length;
            case 7:
                return ((boolean[]) obj).length;
            default:
                return ((Object[]) obj).length;
        }
    }

    private static boolean primitiveMatch(Class cls, Class cls2) {
        return (cls == Boolean.class && cls2 == Boolean.TYPE) || (cls == Byte.class && cls2 == Byte.TYPE) || ((cls == Character.class && cls2 == Character.TYPE) || ((cls == Short.class && cls2 == Short.TYPE) || ((cls == Integer.class && cls2 == Integer.TYPE) || ((cls == Long.class && cls2 == Long.TYPE) || ((cls == Float.class && cls2 == Float.TYPE) || ((cls == Double.class && cls2 == Double.TYPE) || (cls == Void.class && cls2 == Void.TYPE)))))));
    }

    public static void validateComponentName(ComponentName componentName) throws IPCException {
        if (!TextUtils.isEmpty(componentName.getClassName()) && !TextUtils.isEmpty(componentName.getPackageName())) {
            if (ARanger.getContext().getPackageName().equals(componentName.getPackageName())) {
                try {
                    if (!ARangerProvider.class.isAssignableFrom(Class.forName(componentName.getClassName()))) {
                        throw new IPCException(20, "Only class extends ARangerProvider can be passed as the parameters.");
                    }
                    return;
                } catch (ClassNotFoundException unused) {
                    throw new IPCException(20, "The " + componentName.getClassName() + " class not found, please check the provider class name.");
                }
            }
            return;
        }
        throw new IPCException(28, "the package name or provider class name in component is null!");
    }

    public static void validateServiceInterface(String str, Class<?> cls) throws IPCException {
        if (cls.isInterface()) {
            if (TextUtils.isEmpty(str)) {
                ServiceName serviceName = (ServiceName) cls.getAnnotation(ServiceName.class);
                if (serviceName == null || TextUtils.isEmpty(serviceName.value())) {
                    throw new IPCException(20, "the interfaces must have ServiceName annotation.");
                }
                return;
            }
            return;
        }
        throw new IPCException(20, "Only interfaces can be passed as the parameters.");
    }

    private static String getMethodParameters(Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        int length = clsArr.length;
        if (length == 0) {
            return sb.toString();
        }
        sb.append(basicNameConvert(getClassId(clsArr[0])));
        for (int i = 1; i < length; i++) {
            sb.append(",");
            sb.append(basicNameConvert(getClassId(clsArr[i])));
        }
        return sb.toString();
    }
}
