package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8212k;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ak0;
import tb.b41;
import tb.cr2;
import tb.fd2;
import tb.fr2;
import tb.gr2;
import tb.gu2;
import tb.i21;
import tb.z71;
import tb.zq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TypeUtilsKt {
    @NotNull
    public static final TypeProjection a(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return new zq2(z71Var);
    }

    public static final boolean b(@NotNull z71 z71Var, @NotNull Function1<? super gu2, Boolean> function1) {
        b41.i(z71Var, "<this>");
        b41.i(function1, "predicate");
        return fr2.c(z71Var, function1);
    }

    private static final boolean c(z71 z71Var, TypeConstructor typeConstructor, Set<? extends TypeParameterDescriptor> set) {
        Iterable<i21> G0;
        boolean z;
        if (b41.d(z71Var.c(), typeConstructor)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null;
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters == null ? null : classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        G0 = CollectionsKt___CollectionsKt.G0(z71Var.b());
        if (!(G0 instanceof Collection) || !((Collection) G0).isEmpty()) {
            for (i21 i21Var : G0) {
                int a = i21Var.a();
                TypeProjection typeProjection = (TypeProjection) i21Var.b();
                TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters == null ? null : (TypeParameterDescriptor) C8212k.S(declaredTypeParameters, a);
                if (((typeParameterDescriptor == null || set == null || !set.contains(typeParameterDescriptor)) ? false : true) || typeProjection.isStarProjection()) {
                    z = false;
                    continue;
                } else {
                    z71 type = typeProjection.getType();
                    b41.h(type, "argument.type");
                    z = c(type, typeConstructor, set);
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean d(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return b(z71Var, new Function1<gu2, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$containsTypeAliasParameters$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull gu2 gu2Var) {
                b41.i(gu2Var, AdvanceSetting.NETWORK_TYPE);
                ClassifierDescriptor declarationDescriptor = gu2Var.c().getDeclarationDescriptor();
                return Boolean.valueOf(declarationDescriptor == null ? false : TypeUtilsKt.n(declarationDescriptor));
            }
        });
    }

    @NotNull
    public static final TypeProjection e(@NotNull z71 z71Var, @NotNull Variance variance, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        b41.i(z71Var, "type");
        b41.i(variance, "projectionKind");
        if ((typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance()) == variance) {
            variance = Variance.INVARIANT;
        }
        return new zq2(variance, z71Var);
    }

    @NotNull
    public static final Set<TypeParameterDescriptor> f(@NotNull z71 z71Var, @Nullable Set<? extends TypeParameterDescriptor> set) {
        b41.i(z71Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        g(z71Var, z71Var, linkedHashSet, set);
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void g(z71 z71Var, z71 z71Var2, Set<TypeParameterDescriptor> set, Set<? extends TypeParameterDescriptor> set2) {
        boolean J;
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            if (!b41.d(z71Var.c(), z71Var2.c())) {
                set.add(declarationDescriptor);
                return;
            }
            for (z71 z71Var3 : ((TypeParameterDescriptor) declarationDescriptor).getUpperBounds()) {
                b41.h(z71Var3, "upperBound");
                g(z71Var3, z71Var2, set, set2);
            }
            return;
        }
        ClassifierDescriptor declarationDescriptor2 = z71Var.c().getDeclarationDescriptor();
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = declarationDescriptor2 instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor2 : null;
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters == null ? null : classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        int i = 0;
        for (TypeProjection typeProjection : z71Var.b()) {
            int i2 = i + 1;
            TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters == null ? null : (TypeParameterDescriptor) C8212k.S(declaredTypeParameters, i);
            if (!((typeParameterDescriptor == null || set2 == null || !set2.contains(typeParameterDescriptor)) ? false : true) && !typeProjection.isStarProjection()) {
                J = CollectionsKt___CollectionsKt.J(set, typeProjection.getType().c().getDeclarationDescriptor());
                if (!J && !b41.d(typeProjection.getType().c(), z71Var2.c())) {
                    z71 type = typeProjection.getType();
                    b41.h(type, "argument.type");
                    g(type, z71Var2, set, set2);
                }
            }
            i = i2;
        }
    }

    @NotNull
    public static final AbstractC8271b h(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        AbstractC8271b builtIns = z71Var.c().getBuiltIns();
        b41.h(builtIns, "constructor.builtIns");
        return builtIns;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
        r3 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[EDGE_INSN: B:22:0x0051->B:18:0x0051 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0023  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final tb.z71 i(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r7) {
        /*
            java.lang.String r0 = "<this>"
            tb.b41.i(r7, r0)
            java.util.List r0 = r7.getUpperBounds()
            java.lang.String r1 = "upperBounds"
            tb.b41.h(r0, r1)
            r0.isEmpty()
            java.util.List r0 = r7.getUpperBounds()
            tb.b41.h(r0, r1)
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L51
            java.lang.Object r2 = r0.next()
            r4 = r2
            tb.z71 r4 = (tb.z71) r4
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r4.c()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getDeclarationDescriptor()
            boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r5 == 0) goto L39
            r3 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
        L39:
            r4 = 0
            if (r3 != 0) goto L3d
            goto L4e
        L3d:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r5 == r6) goto L4e
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r3 == r5) goto L4e
            r4 = 1
        L4e:
            if (r4 == 0) goto L1c
            r3 = r2
        L51:
            tb.z71 r3 = (tb.z71) r3
            if (r3 != 0) goto L68
            java.util.List r7 = r7.getUpperBounds()
            tb.b41.h(r7, r1)
            java.lang.Object r7 = kotlin.collections.C8212k.P(r7)
            java.lang.String r0 = "upperBounds.first()"
            tb.b41.h(r7, r0)
            r3 = r7
            tb.z71 r3 = (tb.z71) r3
        L68:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.i(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor):tb.z71");
    }

    @JvmOverloads
    public static final boolean j(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        b41.i(typeParameterDescriptor, "typeParameter");
        return l(typeParameterDescriptor, null, null, 6, null);
    }

    @JvmOverloads
    public static final boolean k(@NotNull TypeParameterDescriptor typeParameterDescriptor, @Nullable TypeConstructor typeConstructor, @Nullable Set<? extends TypeParameterDescriptor> set) {
        boolean z;
        b41.i(typeParameterDescriptor, "typeParameter");
        List<z71> upperBounds = typeParameterDescriptor.getUpperBounds();
        b41.h(upperBounds, "typeParameter.upperBounds");
        if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
            for (z71 z71Var : upperBounds) {
                b41.h(z71Var, "upperBound");
                if (c(z71Var, typeParameterDescriptor.getDefaultType().c(), set) && (typeConstructor == null || b41.d(z71Var.c(), typeConstructor))) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean l(TypeParameterDescriptor typeParameterDescriptor, TypeConstructor typeConstructor, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = null;
        }
        if ((i & 4) != 0) {
            set = null;
        }
        return k(typeParameterDescriptor, typeConstructor, set);
    }

    public static final boolean m(@NotNull z71 z71Var, @NotNull z71 z71Var2) {
        b41.i(z71Var, "<this>");
        b41.i(z71Var2, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(z71Var, z71Var2);
    }

    public static final boolean n(@NotNull ClassifierDescriptor classifierDescriptor) {
        b41.i(classifierDescriptor, "<this>");
        return (classifierDescriptor instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor);
    }

    public static final boolean o(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return fr2.n(z71Var);
    }

    @NotNull
    public static final z71 p(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        z71 o = fr2.o(z71Var);
        b41.h(o, "makeNotNullable(this)");
        return o;
    }

    @NotNull
    public static final z71 q(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        z71 p = fr2.p(z71Var);
        b41.h(p, "makeNullable(this)");
        return p;
    }

    @NotNull
    public static final z71 r(@NotNull z71 z71Var, @NotNull Annotations annotations) {
        b41.i(z71Var, "<this>");
        b41.i(annotations, "newAnnotations");
        return (z71Var.getAnnotations().isEmpty() && annotations.isEmpty()) ? z71Var : z71Var.f().i(annotations);
    }

    @NotNull
    public static final z71 s(@NotNull z71 z71Var, @NotNull TypeSubstitutor typeSubstitutor, @NotNull Map<TypeConstructor, ? extends TypeProjection> map, @NotNull Variance variance, @Nullable Set<? extends TypeParameterDescriptor> set) {
        gu2 gu2Var;
        int q;
        int q2;
        int q3;
        b41.i(z71Var, "<this>");
        b41.i(typeSubstitutor, "substitutor");
        b41.i(map, "substitutionMap");
        b41.i(variance, "variance");
        gu2 f = z71Var.f();
        if (f instanceof ak0) {
            ak0 ak0Var = (ak0) f;
            fd2 k = ak0Var.k();
            if (!k.c().getParameters().isEmpty() && k.c().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = k.c().getParameters();
                b41.h(parameters, "constructor.parameters");
                q3 = C8215n.q(parameters, 10);
                ArrayList arrayList = new ArrayList(q3);
                for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
                    TypeProjection typeProjection = (TypeProjection) C8212k.S(z71Var.b(), typeParameterDescriptor.getIndex());
                    if ((set != null && set.contains(typeParameterDescriptor)) || typeProjection == null || !map.containsKey(typeProjection.getType().c())) {
                        typeProjection = new StarProjectionImpl(typeParameterDescriptor);
                    }
                    arrayList.add(typeProjection);
                }
                k = cr2.f(k, arrayList, null, 2, null);
            }
            fd2 l = ak0Var.l();
            if (!l.c().getParameters().isEmpty() && l.c().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = l.c().getParameters();
                b41.h(parameters2, "constructor.parameters");
                q2 = C8215n.q(parameters2, 10);
                ArrayList arrayList2 = new ArrayList(q2);
                for (TypeParameterDescriptor typeParameterDescriptor2 : parameters2) {
                    TypeProjection typeProjection2 = (TypeProjection) C8212k.S(z71Var.b(), typeParameterDescriptor2.getIndex());
                    if ((set != null && set.contains(typeParameterDescriptor2)) || typeProjection2 == null || !map.containsKey(typeProjection2.getType().c())) {
                        typeProjection2 = new StarProjectionImpl(typeParameterDescriptor2);
                    }
                    arrayList2.add(typeProjection2);
                }
                l = cr2.f(l, arrayList2, null, 2, null);
            }
            gu2Var = KotlinTypeFactory.d(k, l);
        } else if (f instanceof fd2) {
            fd2 fd2Var = (fd2) f;
            if (fd2Var.c().getParameters().isEmpty() || fd2Var.c().getDeclarationDescriptor() == null) {
                gu2Var = fd2Var;
            } else {
                List<TypeParameterDescriptor> parameters3 = fd2Var.c().getParameters();
                b41.h(parameters3, "constructor.parameters");
                q = C8215n.q(parameters3, 10);
                ArrayList arrayList3 = new ArrayList(q);
                for (TypeParameterDescriptor typeParameterDescriptor3 : parameters3) {
                    TypeProjection typeProjection3 = (TypeProjection) C8212k.S(z71Var.b(), typeParameterDescriptor3.getIndex());
                    if ((set != null && set.contains(typeParameterDescriptor3)) || typeProjection3 == null || !map.containsKey(typeProjection3.getType().c())) {
                        typeProjection3 = new StarProjectionImpl(typeParameterDescriptor3);
                    }
                    arrayList3.add(typeProjection3);
                }
                gu2Var = cr2.f(fd2Var, arrayList3, null, 2, null);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        z71 n = typeSubstitutor.n(gr2.b(gu2Var, f), variance);
        b41.h(n, "replaceArgumentsByParame…ubstitute(it, variance) }");
        return n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [tb.gu2] */
    @NotNull
    public static final z71 t(@NotNull z71 z71Var) {
        int q;
        fd2 fd2Var;
        int q2;
        int q3;
        b41.i(z71Var, "<this>");
        gu2 f = z71Var.f();
        if (f instanceof ak0) {
            ak0 ak0Var = (ak0) f;
            fd2 k = ak0Var.k();
            if (!k.c().getParameters().isEmpty() && k.c().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = k.c().getParameters();
                b41.h(parameters, "constructor.parameters");
                q3 = C8215n.q(parameters, 10);
                ArrayList arrayList = new ArrayList(q3);
                for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
                    arrayList.add(new StarProjectionImpl(typeParameterDescriptor));
                }
                k = cr2.f(k, arrayList, null, 2, null);
            }
            fd2 l = ak0Var.l();
            if (!l.c().getParameters().isEmpty() && l.c().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = l.c().getParameters();
                b41.h(parameters2, "constructor.parameters");
                q2 = C8215n.q(parameters2, 10);
                ArrayList arrayList2 = new ArrayList(q2);
                for (TypeParameterDescriptor typeParameterDescriptor2 : parameters2) {
                    arrayList2.add(new StarProjectionImpl(typeParameterDescriptor2));
                }
                l = cr2.f(l, arrayList2, null, 2, null);
            }
            fd2Var = KotlinTypeFactory.d(k, l);
        } else if (f instanceof fd2) {
            fd2 fd2Var2 = (fd2) f;
            boolean isEmpty = fd2Var2.c().getParameters().isEmpty();
            fd2Var = fd2Var2;
            if (!isEmpty) {
                ClassifierDescriptor declarationDescriptor = fd2Var2.c().getDeclarationDescriptor();
                fd2Var = fd2Var2;
                if (declarationDescriptor != null) {
                    List<TypeParameterDescriptor> parameters3 = fd2Var2.c().getParameters();
                    b41.h(parameters3, "constructor.parameters");
                    q = C8215n.q(parameters3, 10);
                    ArrayList arrayList3 = new ArrayList(q);
                    for (TypeParameterDescriptor typeParameterDescriptor3 : parameters3) {
                        arrayList3.add(new StarProjectionImpl(typeParameterDescriptor3));
                    }
                    fd2Var = cr2.f(fd2Var2, arrayList3, null, 2, null);
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return gr2.b(fd2Var, f);
    }

    public static final boolean u(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return b(z71Var, new Function1<gu2, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$requiresTypeAliasExpansion$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull gu2 gu2Var) {
                b41.i(gu2Var, AdvanceSetting.NETWORK_TYPE);
                ClassifierDescriptor declarationDescriptor = gu2Var.c().getDeclarationDescriptor();
                boolean z = false;
                if (declarationDescriptor != null && ((declarationDescriptor instanceof TypeAliasDescriptor) || (declarationDescriptor instanceof TypeParameterDescriptor))) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
    }
}
