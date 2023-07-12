package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a81;
import tb.ak0;
import tb.bf2;
import tb.br2;
import tb.cg0;
import tb.cr2;
import tb.dk0;
import tb.fd2;
import tb.fr2;
import tb.gr2;
import tb.gu2;
import tb.h21;
import tb.hp0;
import tb.jn1;
import tb.kf0;
import tb.kq2;
import tb.md0;
import tb.nj0;
import tb.oq2;
import tb.t90;
import tb.z71;
import tb.zq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TypeSubstitutor {
    public static final TypeSubstitutor EMPTY = g(br2.EMPTY);
    @NotNull
    private final br2 a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class a implements Function1<hp0, Boolean> {
        a() {
        }

        private static /* synthetic */ void a(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public Boolean invoke(@NotNull hp0 hp0Var) {
            if (hp0Var == null) {
                a(0);
            }
            return Boolean.valueOf(!hp0Var.equals(c.a.unsafeVariance));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VarianceConflictType.values().length];
            a = iArr;
            try {
                iArr[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected TypeSubstitutor(@NotNull br2 br2Var) {
        if (br2Var == null) {
            a(7);
        }
        this.a = br2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.a(int):void");
    }

    private static void b(int i, TypeProjection typeProjection, br2 br2Var) {
        if (i <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(typeProjection) + "; substitution: " + o(br2Var));
    }

    @NotNull
    public static Variance c(@NotNull Variance variance, @NotNull TypeProjection typeProjection) {
        if (variance == null) {
            a(35);
        }
        if (typeProjection == null) {
            a(36);
        }
        if (typeProjection.isStarProjection()) {
            Variance variance2 = Variance.OUT_VARIANCE;
            if (variance2 == null) {
                a(37);
            }
            return variance2;
        }
        return d(variance, typeProjection.getProjectionKind());
    }

    @NotNull
    public static Variance d(@NotNull Variance variance, @NotNull Variance variance2) {
        if (variance == null) {
            a(38);
        }
        if (variance2 == null) {
            a(39);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                a(40);
            }
            return variance2;
        } else if (variance2 == variance3) {
            if (variance == null) {
                a(41);
            }
            return variance;
        } else if (variance == variance2) {
            if (variance2 == null) {
                a(42);
            }
            return variance2;
        } else {
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
        }
    }

    private static VarianceConflictType e(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    @NotNull
    public static TypeSubstitutor f(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(6);
        }
        return g(oq2.i(z71Var.c(), z71Var.b()));
    }

    @NotNull
    public static TypeSubstitutor g(@NotNull br2 br2Var) {
        if (br2Var == null) {
            a(0);
        }
        return new TypeSubstitutor(br2Var);
    }

    @NotNull
    public static TypeSubstitutor h(@NotNull br2 br2Var, @NotNull br2 br2Var2) {
        if (br2Var == null) {
            a(3);
        }
        if (br2Var2 == null) {
            a(4);
        }
        return g(t90.i(br2Var, br2Var2));
    }

    @NotNull
    private static Annotations i(@NotNull Annotations annotations) {
        if (annotations == null) {
            a(33);
        }
        return !annotations.hasAnnotation(c.a.unsafeVariance) ? annotations : new nj0(annotations, new a());
    }

    @NotNull
    private static TypeProjection l(@NotNull z71 z71Var, @NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeProjection typeProjection2) {
        if (z71Var == null) {
            a(26);
        }
        if (typeProjection == null) {
            a(27);
        }
        if (typeProjection2 == null) {
            a(28);
        }
        if (!z71Var.getAnnotations().hasAnnotation(c.a.unsafeVariance)) {
            if (typeProjection == null) {
                a(29);
            }
            return typeProjection;
        }
        TypeConstructor c = typeProjection.getType().c();
        if (c instanceof NewCapturedTypeConstructor) {
            TypeProjection projection = ((NewCapturedTypeConstructor) c).getProjection();
            Variance projectionKind = projection.getProjectionKind();
            VarianceConflictType e = e(typeProjection2.getProjectionKind(), projectionKind);
            VarianceConflictType varianceConflictType = VarianceConflictType.OUT_IN_IN_POSITION;
            if (e == varianceConflictType) {
                return new zq2(projection.getType());
            }
            return (typeParameterDescriptor != null && e(typeParameterDescriptor.getVariance(), projectionKind) == varianceConflictType) ? new zq2(projection.getType()) : typeProjection;
        }
        return typeProjection;
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!cg0.a(th)) {
                return "[Exception while computing toString(): " + th + jn1.ARRAY_END_STR;
            }
            throw th;
        }
    }

    private TypeProjection r(TypeProjection typeProjection, int i) throws SubstitutionException {
        z71 type = typeProjection.getType();
        Variance projectionKind = typeProjection.getProjectionKind();
        if (type.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        fd2 b2 = bf2.b(type);
        z71 q = b2 != null ? m().q(b2, Variance.INVARIANT) : null;
        z71 b3 = cr2.b(type, s(type.c().getParameters(), type.b(), i), this.a.d(type.getAnnotations()));
        if ((b3 instanceof fd2) && (q instanceof fd2)) {
            b3 = bf2.j((fd2) b3, (fd2) q);
        }
        return new zq2(projectionKind, b3);
    }

    private List<TypeProjection> s(List<TypeParameterDescriptor> list, List<TypeProjection> list2, int i) throws SubstitutionException {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i2);
            TypeProjection typeProjection = list2.get(i2);
            TypeProjection u = u(typeProjection, typeParameterDescriptor, i + 1);
            int i3 = b.a[e(typeParameterDescriptor.getVariance(), u.getProjectionKind()).ordinal()];
            if (i3 == 1 || i3 == 2) {
                u = fr2.t(typeParameterDescriptor);
            } else if (i3 == 3) {
                Variance variance = typeParameterDescriptor.getVariance();
                Variance variance2 = Variance.INVARIANT;
                if (variance != variance2 && !u.isStarProjection()) {
                    u = new zq2(variance2, u.getType());
                }
            }
            if (u != typeProjection) {
                z = true;
            }
            arrayList.add(u);
        }
        return !z ? list2 : arrayList;
    }

    @NotNull
    private TypeProjection u(@NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, int i) throws SubstitutionException {
        z71 r;
        if (typeProjection == null) {
            a(18);
        }
        b(i, typeProjection, this.a);
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        z71 type = typeProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
            gu2 origin = typeWithEnhancement.getOrigin();
            z71 enhancement = typeWithEnhancement.getEnhancement();
            TypeProjection u = u(new zq2(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i + 1);
            if (u.isStarProjection()) {
                return u;
            }
            z71 q = q(enhancement, typeProjection.getProjectionKind());
            gu2 f = u.getType().f();
            if (q instanceof TypeWithEnhancement) {
                q = ((TypeWithEnhancement) q).getEnhancement();
            }
            return new zq2(u.getProjectionKind(), gr2.e(f, q));
        }
        if (!md0.a(type) && !(type.f() instanceof RawType)) {
            TypeProjection e = this.a.e(type);
            TypeProjection l = e != null ? l(type, e, typeParameterDescriptor, typeProjection) : null;
            Variance projectionKind = typeProjection.getProjectionKind();
            if (l == null && dk0.b(type) && !kq2.b(type)) {
                ak0 a2 = dk0.a(type);
                int i2 = i + 1;
                TypeProjection u2 = u(new zq2(projectionKind, a2.k()), typeParameterDescriptor, i2);
                TypeProjection u3 = u(new zq2(projectionKind, a2.l()), typeParameterDescriptor, i2);
                return (u2.getType() == a2.k() && u3.getType() == a2.l()) ? typeProjection : new zq2(u2.getProjectionKind(), KotlinTypeFactory.d(cr2.a(u2.getType()), cr2.a(u3.getType())));
            } else if (!kotlin.reflect.jvm.internal.impl.builtins.b.l0(type) && !a81.a(type)) {
                if (l != null) {
                    VarianceConflictType e2 = e(projectionKind, l.getProjectionKind());
                    if (!CapturedTypeConstructorKt.d(type)) {
                        int i3 = b.a[e2.ordinal()];
                        if (i3 == 1) {
                            throw new SubstitutionException("Out-projection in in-position");
                        }
                        if (i3 == 2) {
                            return new zq2(Variance.OUT_VARIANCE, type.c().getBuiltIns().I());
                        }
                    }
                    CustomTypeVariable a3 = kq2.a(type);
                    if (l.isStarProjection()) {
                        return l;
                    }
                    if (a3 != null) {
                        r = a3.substitutionResult(l.getType());
                    } else {
                        r = fr2.r(l.getType(), type.d());
                    }
                    if (!type.getAnnotations().isEmpty()) {
                        r = TypeUtilsKt.r(r, new CompositeAnnotations(r.getAnnotations(), i(this.a.d(type.getAnnotations()))));
                    }
                    if (e2 == VarianceConflictType.NO_CONFLICT) {
                        projectionKind = d(projectionKind, l.getProjectionKind());
                    }
                    return new zq2(projectionKind, r);
                }
                typeProjection = r(typeProjection, i);
                if (typeProjection == null) {
                    a(25);
                }
            }
        }
        return typeProjection;
    }

    @NotNull
    public br2 j() {
        br2 br2Var = this.a;
        if (br2Var == null) {
            a(8);
        }
        return br2Var;
    }

    public boolean k() {
        return this.a.f();
    }

    @NotNull
    public TypeSubstitutor m() {
        br2 br2Var = this.a;
        return ((br2Var instanceof h21) && br2Var.b()) ? new TypeSubstitutor(new h21(((h21) this.a).j(), ((h21) this.a).i(), false)) : this;
    }

    @NotNull
    public z71 n(@NotNull z71 z71Var, @NotNull Variance variance) {
        if (z71Var == null) {
            a(9);
        }
        if (variance == null) {
            a(10);
        }
        if (k()) {
            if (z71Var == null) {
                a(11);
            }
            return z71Var;
        }
        try {
            z71 type = u(new zq2(variance, z71Var), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (SubstitutionException e) {
            fd2 j = kf0.j(e.getMessage());
            if (j == null) {
                a(13);
            }
            return j;
        }
    }

    @Nullable
    public TypeProjection p(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            a(16);
        }
        TypeProjection t = t(typeProjection);
        return (this.a.a() || this.a.b()) ? CapturedTypeApproximationKt.c(t, this.a.b()) : t;
    }

    @Nullable
    public z71 q(@NotNull z71 z71Var, @NotNull Variance variance) {
        if (z71Var == null) {
            a(14);
        }
        if (variance == null) {
            a(15);
        }
        TypeProjection p = p(new zq2(variance, j().g(z71Var, variance)));
        if (p == null) {
            return null;
        }
        return p.getType();
    }

    @Nullable
    public TypeProjection t(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            a(17);
        }
        if (k()) {
            return typeProjection;
        }
        try {
            return u(typeProjection, null, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }
}
