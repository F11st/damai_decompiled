package tb;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class q02 extends g02 implements JavaValueParameter {
    @NotNull
    private final o02 a;
    @NotNull
    private final Annotation[] b;
    @Nullable
    private final String c;
    private final boolean d;

    public q02(@NotNull o02 o02Var, @NotNull Annotation[] annotationArr, @Nullable String str, boolean z) {
        b41.i(o02Var, "type");
        b41.i(annotationArr, "reflectAnnotations");
        this.a = o02Var;
        this.b = annotationArr;
        this.c = str;
        this.d = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    /* renamed from: a */
    public vz1 findAnnotation(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        return yz1.a(this.b, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    /* renamed from: b */
    public List<vz1> getAnnotations() {
        return yz1.b(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    @NotNull
    /* renamed from: c */
    public o02 getType() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    @Nullable
    public ni1 getName() {
        String str = this.c;
        if (str == null) {
            return null;
        }
        return ni1.e(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public boolean isVararg() {
        return this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(q02.class.getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }
}
