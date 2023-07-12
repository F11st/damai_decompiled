package tb;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class m02 extends g02 implements JavaPackage {
    @NotNull
    private final hp0 a;

    public m02(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        this.a = hp0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    /* renamed from: a */
    public List<JavaAnnotation> getAnnotations() {
        List<JavaAnnotation> g;
        g = kotlin.collections.m.g();
        return g;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof m02) && b41.d(getFqName(), ((m02) obj).getFqName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public Collection<JavaClass> getClasses(@NotNull Function1<? super ni1, Boolean> function1) {
        List g;
        b41.i(function1, "nameFilter");
        g = kotlin.collections.m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public hp0 getFqName() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public Collection<JavaPackage> getSubPackages() {
        List g;
        g = kotlin.collections.m.g();
        return g;
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @NotNull
    public String toString() {
        return m02.class.getName() + ": " + getFqName();
    }
}
