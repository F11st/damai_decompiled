package tb;

import com.huawei.hms.opendevice.AbstractC5658c;
import java.util.Map;
import kotlin.collections.C8226x;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class z41 {
    @NotNull
    public static final z41 INSTANCE = new z41();
    @NotNull
    private static final ni1 a;
    @NotNull
    private static final ni1 b;
    @NotNull
    private static final ni1 c;
    @NotNull
    private static final Map<hp0, hp0> d;
    @NotNull
    private static final Map<hp0, hp0> e;

    static {
        Map<hp0, hp0> l;
        Map<hp0, hp0> l2;
        ni1 f = ni1.f("message");
        b41.h(f, "identifier(\"message\")");
        a = f;
        ni1 f2 = ni1.f("allowedTargets");
        b41.h(f2, "identifier(\"allowedTargets\")");
        b = f2;
        ni1 f3 = ni1.f("value");
        b41.h(f3, "identifier(\"value\")");
        c = f3;
        hp0 hp0Var = C8277c.C8278a.target;
        hp0 hp0Var2 = o61.TARGET_ANNOTATION;
        hp0 hp0Var3 = C8277c.C8278a.retention;
        hp0 hp0Var4 = o61.RETENTION_ANNOTATION;
        hp0 hp0Var5 = C8277c.C8278a.repeatable;
        hp0 hp0Var6 = o61.REPEATABLE_ANNOTATION;
        hp0 hp0Var7 = C8277c.C8278a.mustBeDocumented;
        hp0 hp0Var8 = o61.DOCUMENTED_ANNOTATION;
        l = C8226x.l(hq2.a(hp0Var, hp0Var2), hq2.a(hp0Var3, hp0Var4), hq2.a(hp0Var5, hp0Var6), hq2.a(hp0Var7, hp0Var8));
        d = l;
        l2 = C8226x.l(hq2.a(hp0Var2, hp0Var), hq2.a(hp0Var4, hp0Var3), hq2.a(o61.DEPRECATED_ANNOTATION, C8277c.C8278a.deprecated), hq2.a(hp0Var6, hp0Var5), hq2.a(hp0Var8, hp0Var7));
        e = l2;
    }

    private z41() {
    }

    public static /* synthetic */ AnnotationDescriptor f(z41 z41Var, JavaAnnotation javaAnnotation, r81 r81Var, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return z41Var.e(javaAnnotation, r81Var, z);
    }

    @Nullable
    public final AnnotationDescriptor a(@NotNull hp0 hp0Var, @NotNull JavaAnnotationOwner javaAnnotationOwner, @NotNull r81 r81Var) {
        JavaAnnotation findAnnotation;
        b41.i(hp0Var, "kotlinName");
        b41.i(javaAnnotationOwner, "annotationOwner");
        b41.i(r81Var, AbstractC5658c.a);
        if (b41.d(hp0Var, C8277c.C8278a.deprecated)) {
            hp0 hp0Var2 = o61.DEPRECATED_ANNOTATION;
            b41.h(hp0Var2, "DEPRECATED_ANNOTATION");
            JavaAnnotation findAnnotation2 = javaAnnotationOwner.findAnnotation(hp0Var2);
            if (findAnnotation2 != null || javaAnnotationOwner.isDeprecatedInJavaDoc()) {
                return new JavaDeprecatedAnnotationDescriptor(findAnnotation2, r81Var);
            }
        }
        hp0 hp0Var3 = d.get(hp0Var);
        if (hp0Var3 == null || (findAnnotation = javaAnnotationOwner.findAnnotation(hp0Var3)) == null) {
            return null;
        }
        return f(INSTANCE, findAnnotation, r81Var, false, 4, null);
    }

    @NotNull
    public final ni1 b() {
        return a;
    }

    @NotNull
    public final ni1 c() {
        return c;
    }

    @NotNull
    public final ni1 d() {
        return b;
    }

    @Nullable
    public final AnnotationDescriptor e(@NotNull JavaAnnotation javaAnnotation, @NotNull r81 r81Var, boolean z) {
        b41.i(javaAnnotation, "annotation");
        b41.i(r81Var, AbstractC5658c.a);
        hj classId = javaAnnotation.getClassId();
        if (b41.d(classId, hj.m(o61.TARGET_ANNOTATION))) {
            return new JavaTargetAnnotationDescriptor(javaAnnotation, r81Var);
        }
        if (b41.d(classId, hj.m(o61.RETENTION_ANNOTATION))) {
            return new JavaRetentionAnnotationDescriptor(javaAnnotation, r81Var);
        }
        if (b41.d(classId, hj.m(o61.REPEATABLE_ANNOTATION))) {
            return new JavaAnnotationDescriptor(r81Var, javaAnnotation, C8277c.C8278a.repeatable);
        }
        if (b41.d(classId, hj.m(o61.DOCUMENTED_ANNOTATION))) {
            return new JavaAnnotationDescriptor(r81Var, javaAnnotation, C8277c.C8278a.mustBeDocumented);
        }
        if (b41.d(classId, hj.m(o61.DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(r81Var, javaAnnotation, z);
    }
}
