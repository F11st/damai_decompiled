package tb;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class uz1 {
    @NotNull
    public static final uz1 INSTANCE = new uz1();

    private uz1() {
    }

    private final ij a(Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            b41.h(cls, "currentClass.componentType");
        }
        if (cls.isPrimitive()) {
            if (b41.d(cls, Void.TYPE)) {
                hj m = hj.m(c.a.unit.l());
                b41.h(m, "topLevel(StandardNames.FqNames.unit.toSafe())");
                return new ij(m, i);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            b41.h(primitiveType, "get(currentClass.name).primitiveType");
            if (i > 0) {
                hj m2 = hj.m(primitiveType.getArrayTypeFqName());
                b41.h(m2, "topLevel(primitiveType.arrayTypeFqName)");
                return new ij(m2, i - 1);
            }
            hj m3 = hj.m(primitiveType.getTypeFqName());
            b41.h(m3, "topLevel(primitiveType.typeFqName)");
            return new ij(m3, i);
        }
        hj a = ReflectClassUtilKt.a(cls);
        o51 o51Var = o51.INSTANCE;
        hp0 b = a.b();
        b41.h(b, "javaClassId.asSingleFqName()");
        hj n = o51Var.n(b);
        if (n != null) {
            a = n;
        }
        return new ij(a, i);
    }

    private final void c(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Constructor<?>[] constructorArr;
        int i;
        int i2;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        b41.h(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i3 = 0;
        while (i3 < length) {
            Constructor<?> constructor = declaredConstructors[i3];
            int i4 = i3 + 1;
            ni1 i5 = ni1.i("<init>");
            b41.h(i5, "special(\"<init>\")");
            rc2 rc2Var = rc2.INSTANCE;
            b41.h(constructor, "constructor");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(i5, rc2Var.a(constructor));
            if (visitMethod == null) {
                constructorArr = declaredConstructors;
                i = length;
                i2 = i4;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                b41.h(declaredAnnotations, "constructor.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i6 = 0;
                while (i6 < length2) {
                    Annotation annotation = declaredAnnotations[i6];
                    i6++;
                    b41.h(annotation, "annotation");
                    f(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                b41.h(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length3 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length4 = parameterAnnotations.length;
                    int i7 = 0;
                    while (i7 < length4) {
                        Annotation[] annotationArr = parameterAnnotations[i7];
                        int i8 = i7 + 1;
                        b41.h(annotationArr, "annotations");
                        int length5 = annotationArr.length;
                        int i9 = 0;
                        while (i9 < length5) {
                            Annotation annotation2 = annotationArr[i9];
                            i9++;
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Class<?> b = s61.b(s61.a(annotation2));
                            int i10 = length;
                            int i11 = i4;
                            hj a = ReflectClassUtilKt.a(b);
                            int i12 = length3;
                            b41.h(annotation2, "annotation");
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i7 + length3, a, new tz1(annotation2));
                            if (visitParameterAnnotation != null) {
                                INSTANCE.h(visitParameterAnnotation, annotation2, b);
                            }
                            length = i10;
                            declaredConstructors = constructorArr2;
                            i4 = i11;
                            length3 = i12;
                        }
                        i7 = i8;
                    }
                }
                constructorArr = declaredConstructors;
                i = length;
                i2 = i4;
                visitMethod.visitEnd();
            }
            length = i;
            declaredConstructors = constructorArr;
            i3 = i2;
        }
    }

    private final void d(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] declaredFields = cls.getDeclaredFields();
        b41.h(declaredFields, "klass.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            ni1 f = ni1.f(field.getName());
            b41.h(f, "identifier(field.name)");
            rc2 rc2Var = rc2.INSTANCE;
            b41.h(field, "field");
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(f, rc2Var.b(field), null);
            if (visitField != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                b41.h(declaredAnnotations, "field.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i2 = 0;
                while (i2 < length2) {
                    Annotation annotation = declaredAnnotations[i2];
                    i2++;
                    b41.h(annotation, "annotation");
                    f(visitField, annotation);
                }
                visitField.visitEnd();
            }
        }
    }

    private final void e(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Method[] methodArr;
        int i;
        Method[] declaredMethods = cls.getDeclaredMethods();
        b41.h(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            i2++;
            ni1 f = ni1.f(method.getName());
            b41.h(f, "identifier(method.name)");
            rc2 rc2Var = rc2.INSTANCE;
            b41.h(method, "method");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(f, rc2Var.c(method));
            if (visitMethod == null) {
                methodArr = declaredMethods;
                i = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                b41.h(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i3 = 0;
                while (i3 < length2) {
                    Annotation annotation = declaredAnnotations[i3];
                    i3++;
                    b41.h(annotation, "annotation");
                    f(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                b41.h(parameterAnnotations, "method.parameterAnnotations");
                int length3 = parameterAnnotations.length;
                int i4 = 0;
                while (i4 < length3) {
                    Annotation[] annotationArr = parameterAnnotations[i4];
                    int i5 = i4 + 1;
                    b41.h(annotationArr, "annotations");
                    int length4 = annotationArr.length;
                    int i6 = 0;
                    while (i6 < length4) {
                        Annotation annotation2 = annotationArr[i6];
                        i6++;
                        Class<?> b = s61.b(s61.a(annotation2));
                        Method[] methodArr2 = declaredMethods;
                        hj a = ReflectClassUtilKt.a(b);
                        int i7 = length;
                        b41.h(annotation2, "annotation");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i4, a, new tz1(annotation2));
                        if (visitParameterAnnotation != null) {
                            INSTANCE.h(visitParameterAnnotation, annotation2, b);
                        }
                        declaredMethods = methodArr2;
                        length = i7;
                    }
                    i4 = i5;
                }
                methodArr = declaredMethods;
                i = length;
                visitMethod.visitEnd();
            }
            declaredMethods = methodArr;
            length = i;
        }
    }

    private final void f(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class<?> b = s61.b(s61.a(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.a(b), new tz1(annotation));
        if (visitAnnotation == null) {
            return;
        }
        INSTANCE.h(visitAnnotation, annotation, b);
    }

    private final void g(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, ni1 ni1Var, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (!b41.d(cls, Class.class)) {
            set = w02.a;
            if (set.contains(cls)) {
                annotationArgumentVisitor.visit(ni1Var, obj);
                return;
            } else if (ReflectClassUtilKt.h(cls)) {
                if (!cls.isEnum()) {
                    cls = cls.getEnclosingClass();
                }
                b41.h(cls, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                hj a = ReflectClassUtilKt.a(cls);
                ni1 f = ni1.f(((Enum) obj).name());
                b41.h(f, "identifier((value as Enum<*>).name)");
                annotationArgumentVisitor.visitEnum(ni1Var, a, f);
                return;
            } else if (Annotation.class.isAssignableFrom(cls)) {
                Class<?>[] interfaces = cls.getInterfaces();
                b41.h(interfaces, "clazz.interfaces");
                Class<?> cls2 = (Class) kotlin.collections.e.L(interfaces);
                b41.h(cls2, "annotationClass");
                KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(ni1Var, ReflectClassUtilKt.a(cls2));
                if (visitAnnotation == null) {
                    return;
                }
                h(visitAnnotation, (Annotation) obj, cls2);
                return;
            } else if (cls.isArray()) {
                KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(ni1Var);
                if (visitArray == null) {
                    return;
                }
                Class<?> componentType = cls.getComponentType();
                int i = 0;
                if (componentType.isEnum()) {
                    b41.h(componentType, OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE);
                    hj a2 = ReflectClassUtilKt.a(componentType);
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i < length) {
                        Object obj2 = objArr[i];
                        i++;
                        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                        ni1 f2 = ni1.f(((Enum) obj2).name());
                        b41.h(f2, "identifier((element as Enum<*>).name)");
                        visitArray.visitEnum(a2, f2);
                    }
                } else if (b41.d(componentType, Class.class)) {
                    Object[] objArr2 = (Object[]) obj;
                    int length2 = objArr2.length;
                    while (i < length2) {
                        Object obj3 = objArr2[i];
                        i++;
                        Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                        visitArray.visitClassLiteral(a((Class) obj3));
                    }
                } else if (Annotation.class.isAssignableFrom(componentType)) {
                    Object[] objArr3 = (Object[]) obj;
                    int length3 = objArr3.length;
                    while (i < length3) {
                        Object obj4 = objArr3[i];
                        i++;
                        b41.h(componentType, OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE);
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation2 = visitArray.visitAnnotation(ReflectClassUtilKt.a(componentType));
                        if (visitAnnotation2 != null) {
                            Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                            h(visitAnnotation2, (Annotation) obj4, componentType);
                        }
                    }
                } else {
                    Object[] objArr4 = (Object[]) obj;
                    int length4 = objArr4.length;
                    while (i < length4) {
                        Object obj5 = objArr4[i];
                        i++;
                        visitArray.visit(obj5);
                    }
                }
                visitArray.visitEnd();
                return;
            } else {
                throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
            }
        }
        annotationArgumentVisitor.visitClassLiteral(ni1Var, a((Class) obj));
    }

    private final void h(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        b41.h(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                b41.f(invoke);
                ni1 f = ni1.f(method.getName());
                b41.h(f, "identifier(method.name)");
                g(annotationArgumentVisitor, f, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }

    public final void b(@NotNull Class<?> cls, @NotNull KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor) {
        b41.i(cls, "klass");
        b41.i(annotationVisitor, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        b41.h(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            i++;
            b41.h(annotation, "annotation");
            f(annotationVisitor, annotation);
        }
        annotationVisitor.visitEnd();
    }

    public final void i(@NotNull Class<?> cls, @NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        b41.i(cls, "klass");
        b41.i(memberVisitor, "memberVisitor");
        e(cls, memberVisitor);
        c(cls, memberVisitor);
        d(cls, memberVisitor);
    }
}
