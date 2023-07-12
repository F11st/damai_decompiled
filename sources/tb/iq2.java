package tb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class iq2 {
    @NotNull
    public static final C9273a Companion = new C9273a(null);
    @NotNull
    private final TypeAliasExpansionReportStrategy a;
    private final boolean b;

    /* compiled from: Taobao */
    /* renamed from: tb.iq2$a */
    /* loaded from: classes3.dex */
    public static final class C9273a {
        private C9273a() {
        }

        public /* synthetic */ C9273a(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i, TypeAliasDescriptor typeAliasDescriptor) {
            if (i > 100) {
                throw new AssertionError(b41.r("Too deep recursion while expanding type alias ", typeAliasDescriptor.getName()));
            }
        }
    }

    static {
        new iq2(TypeAliasExpansionReportStrategy.C8539a.INSTANCE, false);
    }

    public iq2(@NotNull TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z) {
        b41.i(typeAliasExpansionReportStrategy, "reportStrategy");
        this.a = typeAliasExpansionReportStrategy;
        this.b = z;
    }

    private final void a(Annotations annotations, Annotations annotations2) {
        HashSet hashSet = new HashSet();
        Iterator<AnnotationDescriptor> it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getFqName());
        }
        for (AnnotationDescriptor annotationDescriptor : annotations2) {
            if (hashSet.contains(annotationDescriptor.getFqName())) {
                this.a.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    private final void b(z71 z71Var, z71 z71Var2) {
        TypeSubstitutor f = TypeSubstitutor.f(z71Var2);
        b41.h(f, "create(substitutedType)");
        int i = 0;
        for (Object obj : z71Var2.b()) {
            int i2 = i + 1;
            if (i < 0) {
                C8214m.p();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (!typeProjection.isStarProjection()) {
                z71 type = typeProjection.getType();
                b41.h(type, "substitutedArgument.type");
                if (!TypeUtilsKt.d(type)) {
                    TypeProjection typeProjection2 = z71Var.b().get(i);
                    TypeParameterDescriptor typeParameterDescriptor = z71Var.c().getParameters().get(i);
                    if (this.b) {
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.a;
                        z71 type2 = typeProjection2.getType();
                        b41.h(type2, "unsubstitutedArgument.type");
                        z71 type3 = typeProjection.getType();
                        b41.h(type3, "substitutedArgument.type");
                        b41.h(typeParameterDescriptor, "typeParameter");
                        typeAliasExpansionReportStrategy.boundsViolationInSubstitution(f, type2, type3, typeParameterDescriptor);
                    }
                }
            }
            i = i2;
        }
    }

    private final ld0 c(ld0 ld0Var, Annotations annotations) {
        return ld0Var.i(h(ld0Var, annotations));
    }

    private final fd2 d(fd2 fd2Var, Annotations annotations) {
        return a81.a(fd2Var) ? fd2Var : cr2.f(fd2Var, null, h(fd2Var, annotations), 1, null);
    }

    private final fd2 e(fd2 fd2Var, z71 z71Var) {
        fd2 s = fr2.s(fd2Var, z71Var.d());
        b41.h(s, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return s;
    }

    private final fd2 f(fd2 fd2Var, z71 z71Var) {
        return d(e(fd2Var, z71Var), z71Var.getAnnotations());
    }

    private final fd2 g(jq2 jq2Var, Annotations annotations, boolean z) {
        TypeConstructor typeConstructor = jq2Var.b().getTypeConstructor();
        b41.h(typeConstructor, "descriptor.typeConstructor");
        return KotlinTypeFactory.j(annotations, typeConstructor, jq2Var.a(), z, MemberScope.C8499b.INSTANCE);
    }

    private final Annotations h(z71 z71Var, Annotations annotations) {
        return a81.a(z71Var) ? z71Var.getAnnotations() : f6.a(annotations, z71Var.getAnnotations());
    }

    private final TypeProjection j(TypeProjection typeProjection, jq2 jq2Var, int i) {
        int q;
        gu2 f = typeProjection.getType().f();
        if (md0.a(f)) {
            return typeProjection;
        }
        fd2 a = cr2.a(f);
        if (a81.a(a) || !TypeUtilsKt.u(a)) {
            return typeProjection;
        }
        TypeConstructor c = a.c();
        ClassifierDescriptor declarationDescriptor = c.getDeclarationDescriptor();
        c.getParameters().size();
        a.b().size();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        if (declarationDescriptor instanceof TypeAliasDescriptor) {
            TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) declarationDescriptor;
            if (jq2Var.d(typeAliasDescriptor)) {
                this.a.recursiveTypeAlias(typeAliasDescriptor);
                return new zq2(Variance.INVARIANT, kf0.j(b41.r("Recursive type alias: ", typeAliasDescriptor.getName())));
            }
            List<TypeProjection> b = a.b();
            q = C8215n.q(b, 10);
            ArrayList arrayList = new ArrayList(q);
            int i2 = 0;
            for (Object obj : b) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    C8214m.p();
                }
                arrayList.add(l((TypeProjection) obj, jq2Var, c.getParameters().get(i2), i + 1));
                i2 = i3;
            }
            fd2 k = k(jq2.Companion.a(jq2Var, typeAliasDescriptor, arrayList), a.getAnnotations(), a.d(), i + 1, false);
            fd2 m = m(a, jq2Var, i);
            if (!md0.a(k)) {
                k = bf2.j(k, m);
            }
            return new zq2(typeProjection.getProjectionKind(), k);
        }
        fd2 m2 = m(a, jq2Var, i);
        b(a, m2);
        return new zq2(typeProjection.getProjectionKind(), m2);
    }

    private final fd2 k(jq2 jq2Var, Annotations annotations, boolean z, int i, boolean z2) {
        TypeProjection l = l(new zq2(Variance.INVARIANT, jq2Var.b().getUnderlyingType()), jq2Var, null, i);
        z71 type = l.getType();
        b41.h(type, "expandedProjection.type");
        fd2 a = cr2.a(type);
        if (a81.a(a)) {
            return a;
        }
        l.getProjectionKind();
        a(a.getAnnotations(), annotations);
        fd2 s = fr2.s(d(a, annotations), z);
        b41.h(s, "expandedType.combineAnno…fNeeded(it, isNullable) }");
        return z2 ? bf2.j(s, g(jq2Var, annotations, z)) : s;
    }

    private final TypeProjection l(TypeProjection typeProjection, jq2 jq2Var, TypeParameterDescriptor typeParameterDescriptor, int i) {
        z71 f;
        Variance variance;
        Variance variance2;
        Companion.b(i, jq2Var.b());
        if (typeProjection.isStarProjection()) {
            b41.f(typeParameterDescriptor);
            TypeProjection t = fr2.t(typeParameterDescriptor);
            b41.h(t, "makeStarProjection(typeParameterDescriptor!!)");
            return t;
        }
        z71 type = typeProjection.getType();
        b41.h(type, "underlyingProjection.type");
        TypeProjection c = jq2Var.c(type.c());
        if (c == null) {
            return j(typeProjection, jq2Var, i);
        }
        if (c.isStarProjection()) {
            b41.f(typeParameterDescriptor);
            TypeProjection t2 = fr2.t(typeParameterDescriptor);
            b41.h(t2, "makeStarProjection(typeParameterDescriptor!!)");
            return t2;
        }
        gu2 f2 = c.getType().f();
        Variance projectionKind = c.getProjectionKind();
        b41.h(projectionKind, "argument.projectionKind");
        Variance projectionKind2 = typeProjection.getProjectionKind();
        b41.h(projectionKind2, "underlyingProjection.projectionKind");
        if (projectionKind2 != projectionKind && projectionKind2 != (variance2 = Variance.INVARIANT)) {
            if (projectionKind == variance2) {
                projectionKind = projectionKind2;
            } else {
                this.a.conflictingProjection(jq2Var.b(), typeParameterDescriptor, f2);
            }
        }
        Variance variance3 = typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance();
        if (variance3 == null) {
            variance3 = Variance.INVARIANT;
        }
        b41.h(variance3, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (variance3 != projectionKind && variance3 != (variance = Variance.INVARIANT)) {
            if (projectionKind == variance) {
                projectionKind = variance;
            } else {
                this.a.conflictingProjection(jq2Var.b(), typeParameterDescriptor, f2);
            }
        }
        a(type.getAnnotations(), f2.getAnnotations());
        if (f2 instanceof ld0) {
            f = c((ld0) f2, type.getAnnotations());
        } else {
            f = f(cr2.a(f2), type);
        }
        return new zq2(projectionKind, f);
    }

    private final fd2 m(fd2 fd2Var, jq2 jq2Var, int i) {
        int q;
        TypeConstructor c = fd2Var.c();
        List<TypeProjection> b = fd2Var.b();
        q = C8215n.q(b, 10);
        ArrayList arrayList = new ArrayList(q);
        int i2 = 0;
        for (Object obj : b) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C8214m.p();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            TypeProjection l = l(typeProjection, jq2Var, c.getParameters().get(i2), i + 1);
            if (!l.isStarProjection()) {
                l = new zq2(l.getProjectionKind(), fr2.r(l.getType(), typeProjection.getType().d()));
            }
            arrayList.add(l);
            i2 = i3;
        }
        return cr2.f(fd2Var, arrayList, null, 2, null);
    }

    @NotNull
    public final fd2 i(@NotNull jq2 jq2Var, @NotNull Annotations annotations) {
        b41.i(jq2Var, "typeAliasExpansion");
        b41.i(annotations, "annotations");
        return k(jq2Var, annotations, false, 0, true);
    }
}
