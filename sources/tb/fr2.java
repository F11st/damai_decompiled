package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class fr2 {
    public static final fd2 DONT_CARE = kf0.p("DONT_CARE");
    public static final fd2 CANT_INFER_FUNCTION_PARAM_TYPE = kf0.j("Cannot be inferred");
    @NotNull
    public static final fd2 NO_EXPECTED_TYPE = new C9145a("NO_EXPECTED_TYPE");
    public static final fd2 UNIT_EXPECTED_TYPE = new C9145a("UNIT_EXPECTED_TYPE");

    /* compiled from: Taobao */
    /* renamed from: tb.fr2$a */
    /* loaded from: classes3.dex */
    public static class C9145a extends p60 {
        private final String b;

        public C9145a(String str) {
            this.b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void o(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L9
                if (r9 == r0) goto L9
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lb
            L9:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lb:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L13
                if (r9 == r0) goto L13
                r5 = 3
                goto L14
            L13:
                r5 = 2
            L14:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L30
                if (r9 == r4) goto L2b
                if (r9 == r3) goto L26
                if (r9 == r0) goto L30
                java.lang.String r8 = "newAnnotations"
                r5[r7] = r8
                goto L32
            L26:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L32
            L2b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L32
            L30:
                r5[r7] = r6
            L32:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L3e
                if (r9 == r0) goto L3b
                r5[r1] = r6
                goto L42
            L3b:
                r5[r1] = r7
                goto L42
            L3e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L42:
                if (r9 == r1) goto L56
                if (r9 == r4) goto L52
                if (r9 == r3) goto L4f
                if (r9 == r0) goto L56
                java.lang.String r3 = "replaceAnnotations"
                r5[r4] = r3
                goto L56
            L4f:
                r5[r4] = r7
                goto L56
            L52:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L56:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L64
                if (r9 == r0) goto L64
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L69
            L64:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L69:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.fr2.C9145a.o(int):void");
        }

        @Override // tb.gu2
        @NotNull
        /* renamed from: j */
        public fd2 g(boolean z) {
            throw new IllegalStateException(this.b);
        }

        @Override // tb.gu2
        @NotNull
        /* renamed from: k */
        public fd2 i(@NotNull Annotations annotations) {
            if (annotations == null) {
                o(0);
            }
            throw new IllegalStateException(this.b);
        }

        @Override // tb.p60
        @NotNull
        protected fd2 l() {
            throw new IllegalStateException(this.b);
        }

        @Override // tb.p60
        @NotNull
        public p60 n(@NotNull fd2 fd2Var) {
            if (fd2Var == null) {
                o(2);
            }
            throw new IllegalStateException(this.b);
        }

        @Override // tb.p60
        @NotNull
        /* renamed from: p */
        public C9145a m(@NotNull b81 b81Var) {
            if (b81Var == null) {
                o(3);
            }
            return this;
        }

        @Override // tb.fd2
        @NotNull
        public String toString() {
            String str = this.b;
            if (str == null) {
                o(1);
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.fr2.a(int):void");
    }

    public static boolean b(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(28);
        }
        if (z71Var.d()) {
            return true;
        }
        return dk0.b(z71Var) && b(dk0.a(z71Var).l());
    }

    public static boolean c(@Nullable z71 z71Var, @NotNull Function1<gu2, Boolean> function1) {
        if (function1 == null) {
            a(43);
        }
        return d(z71Var, function1, null, null);
    }

    private static boolean d(@Nullable z71 z71Var, @NotNull Function1<gu2, Boolean> function1, @Nullable Function1<z71, Boolean> function12, yd2<z71> yd2Var) {
        if (function1 == null) {
            a(46);
        }
        if (z71Var == null) {
            return false;
        }
        gu2 f = z71Var.f();
        if (w(z71Var)) {
            return function1.invoke(f).booleanValue();
        }
        if (yd2Var == null || !yd2Var.contains(z71Var)) {
            if (function1.invoke(f).booleanValue()) {
                return true;
            }
            if (function12 == null || !function12.invoke(f).booleanValue()) {
                if (yd2Var == null) {
                    yd2Var = yd2.a();
                }
                yd2Var.add(z71Var);
                ak0 ak0Var = f instanceof ak0 ? (ak0) f : null;
                if (ak0Var == null || !(d(ak0Var.k(), function1, function12, yd2Var) || d(ak0Var.l(), function1, function12, yd2Var))) {
                    if ((f instanceof j60) && d(((j60) f).o(), function1, function12, yd2Var)) {
                        return true;
                    }
                    TypeConstructor c = z71Var.c();
                    if (c instanceof IntersectionTypeConstructor) {
                        for (z71 z71Var2 : ((IntersectionTypeConstructor) c).getSupertypes()) {
                            if (d(z71Var2, function1, function12, yd2Var)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    for (TypeProjection typeProjection : z71Var.b()) {
                        if (!typeProjection.isStarProjection()) {
                            if (d(typeProjection.getType(), function1, function12, yd2Var)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean e(@Nullable z71 z71Var, @NotNull Function1<gu2, Boolean> function1, @NotNull Function1<z71, Boolean> function12) {
        if (function1 == null) {
            a(44);
        }
        if (function12 == null) {
            a(45);
        }
        return d(z71Var, function1, function12, null);
    }

    @Nullable
    public static z71 f(@NotNull z71 z71Var, @NotNull z71 z71Var2, @NotNull TypeSubstitutor typeSubstitutor) {
        if (z71Var == null) {
            a(20);
        }
        if (z71Var2 == null) {
            a(21);
        }
        if (typeSubstitutor == null) {
            a(22);
        }
        z71 q = typeSubstitutor.q(z71Var2, Variance.INVARIANT);
        if (q != null) {
            return r(q, z71Var.d());
        }
        return null;
    }

    @Nullable
    public static ClassDescriptor g(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(30);
        }
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @NotNull
    public static List<TypeProjection> h(@NotNull List<TypeParameterDescriptor> list) {
        List<TypeProjection> A0;
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            arrayList.add(new zq2(typeParameterDescriptor.getDefaultType()));
        }
        A0 = CollectionsKt___CollectionsKt.A0(arrayList);
        if (A0 == null) {
            a(17);
        }
        return A0;
    }

    @NotNull
    public static List<z71> i(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(18);
        }
        TypeSubstitutor f = TypeSubstitutor.f(z71Var);
        Collection<z71> supertypes = z71Var.c().getSupertypes();
        ArrayList arrayList = new ArrayList(supertypes.size());
        for (z71 z71Var2 : supertypes) {
            z71 f2 = f(z71Var, z71Var2, f);
            if (f2 != null) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    @Nullable
    public static TypeParameterDescriptor j(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(64);
        }
        if (z71Var.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) z71Var.c().getDeclarationDescriptor();
        }
        return null;
    }

    public static boolean k(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(29);
        }
        if (z71Var.c().getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        for (z71 z71Var2 : i(z71Var)) {
            if (m(z71Var2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(@Nullable z71 z71Var) {
        return z71Var != null && z71Var.c() == DONT_CARE.c();
    }

    public static boolean m(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(27);
        }
        if (z71Var.d()) {
            return true;
        }
        if (dk0.b(z71Var) && m(dk0.a(z71Var).l())) {
            return true;
        }
        if (bf2.c(z71Var)) {
            return false;
        }
        if (n(z71Var)) {
            return k(z71Var);
        }
        if (z71Var instanceof l2) {
            TypeParameterDescriptor originalTypeParameter = ((NewTypeVariableConstructor) ((l2) z71Var).l()).getOriginalTypeParameter();
            return originalTypeParameter == null || k(originalTypeParameter.getDefaultType());
        }
        TypeConstructor c = z71Var.c();
        if (c instanceof IntersectionTypeConstructor) {
            for (z71 z71Var2 : c.getSupertypes()) {
                if (m(z71Var2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean n(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(61);
        }
        return j(z71Var) != null || (z71Var.c() instanceof NewTypeVariableConstructor);
    }

    @NotNull
    public static z71 o(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(2);
        }
        return q(z71Var, false);
    }

    @NotNull
    public static z71 p(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(1);
        }
        return q(z71Var, true);
    }

    @NotNull
    public static z71 q(@NotNull z71 z71Var, boolean z) {
        if (z71Var == null) {
            a(3);
        }
        gu2 g = z71Var.f().g(z);
        if (g == null) {
            a(4);
        }
        return g;
    }

    @NotNull
    public static z71 r(@NotNull z71 z71Var, boolean z) {
        if (z71Var == null) {
            a(8);
        }
        if (z) {
            return p(z71Var);
        }
        if (z71Var == null) {
            a(9);
        }
        return z71Var;
    }

    @NotNull
    public static fd2 s(@NotNull fd2 fd2Var, boolean z) {
        if (fd2Var == null) {
            a(5);
        }
        if (!z) {
            if (fd2Var == null) {
                a(7);
            }
            return fd2Var;
        }
        fd2 j = fd2Var.j(true);
        if (j == null) {
            a(6);
        }
        return j;
    }

    @NotNull
    public static TypeProjection t(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            a(47);
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    @NotNull
    public static fd2 u(ClassifierDescriptor classifierDescriptor, MemberScope memberScope, Function1<b81, fd2> function1) {
        if (kf0.r(classifierDescriptor)) {
            fd2 j = kf0.j("Unsubstituted type for " + classifierDescriptor);
            if (j == null) {
                a(11);
            }
            return j;
        }
        return v(classifierDescriptor.getTypeConstructor(), memberScope, function1);
    }

    @NotNull
    public static fd2 v(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull Function1<b81, fd2> function1) {
        if (typeConstructor == null) {
            a(12);
        }
        if (memberScope == null) {
            a(13);
        }
        if (function1 == null) {
            a(14);
        }
        fd2 k = KotlinTypeFactory.k(Annotations.Companion.b(), typeConstructor, h(typeConstructor.getParameters()), false, memberScope, function1);
        if (k == null) {
            a(15);
        }
        return k;
    }

    public static boolean w(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(0);
        }
        return z71Var == NO_EXPECTED_TYPE || z71Var == UNIT_EXPECTED_TYPE;
    }
}
