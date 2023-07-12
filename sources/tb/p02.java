package tb;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class p02 extends g02 implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    @NotNull
    private final TypeVariable<?> a;

    public p02(@NotNull TypeVariable<?> typeVariable) {
        b41.i(typeVariable, "typeVariable");
        this.a = typeVariable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    /* renamed from: a */
    public vz1 findAnnotation(@NotNull hp0 hp0Var) {
        return ReflectJavaAnnotationOwner.a.a(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    /* renamed from: b */
    public List<vz1> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    @NotNull
    /* renamed from: c */
    public List<e02> getUpperBounds() {
        List<e02> g;
        Type[] bounds = this.a.getBounds();
        b41.h(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new e02(type));
        }
        e02 e02Var = (e02) kotlin.collections.k.s0(arrayList);
        if (b41.d(e02Var == null ? null : e02Var.a(), Object.class)) {
            g = kotlin.collections.m.g();
            return g;
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof p02) && b41.d(this.a, ((p02) obj).a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    @Nullable
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    @NotNull
    public ni1 getName() {
        ni1 f = ni1.f(this.a.getName());
        b41.h(f, "identifier(typeVariable.name)");
        return f;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.c(this);
    }

    @NotNull
    public String toString() {
        return p02.class.getName() + ": " + this.a;
    }
}
