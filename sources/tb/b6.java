package tb;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.C8203e0;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.collections.C8225w;
import kotlin.collections.C8226x;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class b6 {
    @NotNull
    private static final hp0 a = new hp0("javax.annotation.meta.TypeQualifierNickname");
    @NotNull
    private static final hp0 b = new hp0("javax.annotation.meta.TypeQualifier");
    @NotNull
    private static final hp0 c = new hp0("javax.annotation.meta.TypeQualifierDefault");
    @NotNull
    private static final hp0 d = new hp0("kotlin.annotations.jvm.UnderMigration");
    @NotNull
    private static final List<AnnotationQualifierApplicabilityType> e;
    @NotNull
    private static final Map<hp0, c51> f;
    @NotNull
    private static final Map<hp0, c51> g;
    @NotNull
    private static final Set<hp0> h;

    static {
        List<AnnotationQualifierApplicabilityType> j;
        Map<hp0, c51> f2;
        List e2;
        List e3;
        Map l;
        Map<hp0, c51> o;
        Set<hp0> g2;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        j = C8214m.j(AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);
        e = j;
        hp0 i = p61.i();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        f2 = C8225w.f(hq2.a(i, new c51(new fm1(nullabilityQualifier, false, 2, null), j, false, false)));
        f = f2;
        hp0 hp0Var = new hp0("javax.annotation.ParametersAreNullableByDefault");
        fm1 fm1Var = new fm1(NullabilityQualifier.NULLABLE, false, 2, null);
        e2 = C8213l.e(annotationQualifierApplicabilityType);
        hp0 hp0Var2 = new hp0("javax.annotation.ParametersAreNonnullByDefault");
        fm1 fm1Var2 = new fm1(nullabilityQualifier, false, 2, null);
        e3 = C8213l.e(annotationQualifierApplicabilityType);
        l = C8226x.l(hq2.a(hp0Var, new c51(fm1Var, e2, false, false, 12, null)), hq2.a(hp0Var2, new c51(fm1Var2, e3, false, false, 12, null)));
        o = C8226x.o(l, f2);
        g = o;
        g2 = C8203e0.g(p61.f(), p61.e());
        h = g2;
    }

    @NotNull
    public static final Map<hp0, c51> a() {
        return g;
    }

    @NotNull
    public static final Set<hp0> b() {
        return h;
    }

    @NotNull
    public static final Map<hp0, c51> c() {
        return f;
    }

    @NotNull
    public static final hp0 d() {
        return d;
    }

    @NotNull
    public static final hp0 e() {
        return c;
    }

    @NotNull
    public static final hp0 f() {
        return b;
    }

    @NotNull
    public static final hp0 g() {
        return a;
    }
}
