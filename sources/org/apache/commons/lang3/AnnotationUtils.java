package org.apache.commons.lang3;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AnnotationUtils {
    private static final ToStringStyle TO_STRING_STYLE = new ToStringStyle() { // from class: org.apache.commons.lang3.AnnotationUtils.1
        private static final long serialVersionUID = 1;

        {
            setDefaultFullDetail(true);
            setArrayContentDetail(true);
            setUseClassName(true);
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
            setContentStart(jn1.BRACKET_START_STR);
            setContentEnd(jn1.BRACKET_END_STR);
            setFieldSeparator(AVFSCacheConstants.COMMA_SEP);
            setArrayStart(jn1.ARRAY_START_STR);
            setArrayEnd(jn1.ARRAY_END_STR);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
            if (obj instanceof Annotation) {
                obj = AnnotationUtils.toString((Annotation) obj);
            }
            super.appendDetail(stringBuffer, str, obj);
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        protected String getShortClassName(Class<?> cls) {
            Class<?> cls2;
            Iterator<Class<?>> it = ClassUtils.getAllInterfaces(cls).iterator();
            while (true) {
                if (!it.hasNext()) {
                    cls2 = null;
                    break;
                }
                cls2 = it.next();
                if (Annotation.class.isAssignableFrom(cls2)) {
                    break;
                }
            }
            return new StringBuilder(cls2 == null ? "" : cls2.getName()).insert(0, '@').toString();
        }
    };

    private static boolean annotationArrayMemberEquals(Annotation[] annotationArr, Annotation[] annotationArr2) {
        if (annotationArr.length != annotationArr2.length) {
            return false;
        }
        for (int i = 0; i < annotationArr.length; i++) {
            if (!equals(annotationArr[i], annotationArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean arrayMemberEquals(Class<?> cls, Object obj, Object obj2) {
        if (cls.isAnnotation()) {
            return annotationArrayMemberEquals((Annotation[]) obj, (Annotation[]) obj2);
        }
        if (cls.equals(Byte.TYPE)) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if (cls.equals(Short.TYPE)) {
            return Arrays.equals((short[]) obj, (short[]) obj2);
        }
        if (cls.equals(Integer.TYPE)) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if (cls.equals(Character.TYPE)) {
            return Arrays.equals((char[]) obj, (char[]) obj2);
        }
        if (cls.equals(Long.TYPE)) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if (cls.equals(Float.TYPE)) {
            return Arrays.equals((float[]) obj, (float[]) obj2);
        }
        if (cls.equals(Double.TYPE)) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if (cls.equals(Boolean.TYPE)) {
            return Arrays.equals((boolean[]) obj, (boolean[]) obj2);
        }
        return Arrays.equals((Object[]) obj, (Object[]) obj2);
    }

    private static int arrayMemberHash(Class<?> cls, Object obj) {
        if (cls.equals(Byte.TYPE)) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (cls.equals(Short.TYPE)) {
            return Arrays.hashCode((short[]) obj);
        }
        if (cls.equals(Integer.TYPE)) {
            return Arrays.hashCode((int[]) obj);
        }
        if (cls.equals(Character.TYPE)) {
            return Arrays.hashCode((char[]) obj);
        }
        if (cls.equals(Long.TYPE)) {
            return Arrays.hashCode((long[]) obj);
        }
        if (cls.equals(Float.TYPE)) {
            return Arrays.hashCode((float[]) obj);
        }
        if (cls.equals(Double.TYPE)) {
            return Arrays.hashCode((double[]) obj);
        }
        if (cls.equals(Boolean.TYPE)) {
            return Arrays.hashCode((boolean[]) obj);
        }
        return Arrays.hashCode((Object[]) obj);
    }

    public static boolean equals(Annotation annotation, Annotation annotation2) {
        Method[] declaredMethods;
        if (annotation == annotation2) {
            return true;
        }
        if (annotation != null && annotation2 != null) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Class<? extends Annotation> annotationType2 = annotation2.annotationType();
            Validate.notNull(annotationType, "Annotation %s with null annotationType()", annotation);
            Validate.notNull(annotationType2, "Annotation %s with null annotationType()", annotation2);
            if (!annotationType.equals(annotationType2)) {
                return false;
            }
            try {
                for (Method method : annotationType.getDeclaredMethods()) {
                    if (method.getParameterTypes().length == 0 && isValidAnnotationMemberType(method.getReturnType()) && !memberEquals(method.getReturnType(), method.invoke(annotation, new Object[0]), method.invoke(annotation2, new Object[0]))) {
                        return false;
                    }
                }
                return true;
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return false;
    }

    public static int hashCode(Annotation annotation) {
        Method[] declaredMethods;
        int i = 0;
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                if (invoke != null) {
                    i += hashMember(method.getName(), invoke);
                } else {
                    throw new IllegalStateException(String.format("Annotation method %s returned null", method));
                }
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return i;
    }

    private static int hashMember(String str, Object obj) {
        int hashCode;
        int hashCode2 = str.hashCode() * 127;
        if (obj.getClass().isArray()) {
            hashCode = arrayMemberHash(obj.getClass().getComponentType(), obj);
        } else if (obj instanceof Annotation) {
            hashCode = hashCode((Annotation) obj);
        } else {
            hashCode = obj.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public static boolean isValidAnnotationMemberType(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return cls.isPrimitive() || cls.isEnum() || cls.isAnnotation() || String.class.equals(cls) || Class.class.equals(cls);
    }

    private static boolean memberEquals(Class<?> cls, Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (cls.isArray()) {
            return arrayMemberEquals(cls.getComponentType(), obj, obj2);
        }
        if (cls.isAnnotation()) {
            return equals((Annotation) obj, (Annotation) obj2);
        }
        return obj.equals(obj2);
    }

    public static String toString(Annotation annotation) {
        Method[] declaredMethods;
        ToStringBuilder toStringBuilder = new ToStringBuilder(annotation, TO_STRING_STYLE);
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            if (method.getParameterTypes().length <= 0) {
                try {
                    toStringBuilder.append(method.getName(), method.invoke(annotation, new Object[0]));
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return toStringBuilder.build();
    }
}
