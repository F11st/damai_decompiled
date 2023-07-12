package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wz1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class vz1 extends g02 implements JavaAnnotation {
    @NotNull
    private final Annotation a;

    public vz1(@NotNull Annotation annotation) {
        b41.i(annotation, "annotation");
        this.a = annotation;
    }

    @NotNull
    public final Annotation a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    @NotNull
    /* renamed from: b */
    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(s61.b(s61.a(this.a)));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof vz1) && b41.d(this.a, ((vz1) obj).a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    @NotNull
    public Collection<JavaAnnotationArgument> getArguments() {
        Method[] declaredMethods = s61.b(s61.a(this.a)).getDeclaredMethods();
        b41.h(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            wz1.C9889a c9889a = wz1.Factory;
            Object invoke = method.invoke(a(), new Object[0]);
            b41.h(invoke, "method.invoke(annotation)");
            arrayList.add(c9889a.a(invoke, ni1.f(method.getName())));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    @NotNull
    public hj getClassId() {
        return ReflectClassUtilKt.a(s61.b(s61.a(this.a)));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return JavaAnnotation.C8357a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public boolean isIdeExternalAnnotation() {
        return JavaAnnotation.C8357a.b(this);
    }

    @NotNull
    public String toString() {
        return vz1.class.getName() + ": " + this.a;
    }
}
