package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cr2;
import tb.dk0;
import tb.f7;
import tb.fd2;
import tb.fr2;
import tb.gr2;
import tb.gu2;
import tb.oq2;
import tb.z71;
import tb.zq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CapturedTypeApproximationKt {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b extends oq2 {
        b() {
        }

        @Override // tb.oq2
        @Nullable
        public TypeProjection k(@NotNull TypeConstructor typeConstructor) {
            b41.i(typeConstructor, "key");
            CapturedTypeConstructor capturedTypeConstructor = typeConstructor instanceof CapturedTypeConstructor ? (CapturedTypeConstructor) typeConstructor : null;
            if (capturedTypeConstructor == null) {
                return null;
            }
            if (capturedTypeConstructor.getProjection().isStarProjection()) {
                return new zq2(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
            }
            return capturedTypeConstructor.getProjection();
        }
    }

    @NotNull
    public static final f7<z71> a(@NotNull z71 z71Var) {
        List<Pair> H0;
        Object e;
        b41.i(z71Var, "type");
        if (dk0.b(z71Var)) {
            f7<z71> a2 = a(dk0.c(z71Var));
            f7<z71> a3 = a(dk0.d(z71Var));
            return new f7<>(gr2.b(KotlinTypeFactory.d(dk0.c(a2.c()), dk0.d(a3.c())), z71Var), gr2.b(KotlinTypeFactory.d(dk0.c(a2.d()), dk0.d(a3.d())), z71Var));
        }
        TypeConstructor c = z71Var.c();
        if (CapturedTypeConstructorKt.d(z71Var)) {
            TypeProjection projection = ((CapturedTypeConstructor) c).getProjection();
            z71 type = projection.getType();
            b41.h(type, "typeProjection.type");
            z71 b2 = b(type, z71Var);
            int i = a.$EnumSwitchMapping$0[projection.getProjectionKind().ordinal()];
            if (i == 2) {
                fd2 I = TypeUtilsKt.h(z71Var).I();
                b41.h(I, "type.builtIns.nullableAnyType");
                return new f7<>(b2, I);
            } else if (i == 3) {
                fd2 H = TypeUtilsKt.h(z71Var).H();
                b41.h(H, "type.builtIns.nothingType");
                return new f7<>(b(H, z71Var), b2);
            } else {
                throw new AssertionError(b41.r("Only nontrivial projections should have been captured, not: ", projection));
            }
        } else if (!z71Var.b().isEmpty() && z71Var.b().size() == c.getParameters().size()) {
            ArrayList<kotlin.reflect.jvm.internal.impl.types.typesApproximation.a> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<TypeProjection> b3 = z71Var.b();
            List<TypeParameterDescriptor> parameters = c.getParameters();
            b41.h(parameters, "typeConstructor.parameters");
            H0 = CollectionsKt___CollectionsKt.H0(b3, parameters);
            for (Pair pair : H0) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
                b41.h(typeParameterDescriptor, "typeParameter");
                kotlin.reflect.jvm.internal.impl.types.typesApproximation.a g = g(typeProjection, typeParameterDescriptor);
                if (typeProjection.isStarProjection()) {
                    arrayList.add(g);
                    arrayList2.add(g);
                } else {
                    f7<kotlin.reflect.jvm.internal.impl.types.typesApproximation.a> d = d(g);
                    arrayList.add(d.a());
                    arrayList2.add(d.b());
                }
            }
            boolean z = true;
            if (!arrayList.isEmpty()) {
                for (kotlin.reflect.jvm.internal.impl.types.typesApproximation.a aVar : arrayList) {
                    if (!aVar.d()) {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                e = TypeUtilsKt.h(z71Var).H();
                b41.h(e, "type.builtIns.nothingType");
            } else {
                e = e(z71Var, arrayList);
            }
            return new f7<>(e, e(z71Var, arrayList2));
        } else {
            return new f7<>(z71Var, z71Var);
        }
    }

    private static final z71 b(z71 z71Var, z71 z71Var2) {
        z71 r = fr2.r(z71Var, z71Var2.d());
        b41.h(r, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return r;
    }

    @Nullable
    public static final TypeProjection c(@Nullable TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        z71 type = typeProjection.getType();
        b41.h(type, "typeProjection.type");
        if (fr2.c(type, new Function1<gu2, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(gu2 gu2Var) {
                b41.h(gu2Var, AdvanceSetting.NETWORK_TYPE);
                return Boolean.valueOf(CapturedTypeConstructorKt.d(gu2Var));
            }
        })) {
            Variance projectionKind = typeProjection.getProjectionKind();
            b41.h(projectionKind, "typeProjection.projectionKind");
            if (projectionKind == Variance.OUT_VARIANCE) {
                return new zq2(projectionKind, a(type).d());
            }
            if (z) {
                return new zq2(projectionKind, a(type).c());
            }
            return f(typeProjection);
        }
        return typeProjection;
    }

    private static final f7<kotlin.reflect.jvm.internal.impl.types.typesApproximation.a> d(kotlin.reflect.jvm.internal.impl.types.typesApproximation.a aVar) {
        f7<z71> a2 = a(aVar.a());
        f7<z71> a3 = a(aVar.b());
        return new f7<>(new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a(aVar.c(), a2.b(), a3.a()), new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a(aVar.c(), a2.a(), a3.b()));
    }

    private static final z71 e(z71 z71Var, List<kotlin.reflect.jvm.internal.impl.types.typesApproximation.a> list) {
        int q;
        z71Var.b().size();
        list.size();
        q = n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (kotlin.reflect.jvm.internal.impl.types.typesApproximation.a aVar : list) {
            arrayList.add(h(aVar));
        }
        return cr2.e(z71Var, arrayList, null, null, 6, null);
    }

    private static final TypeProjection f(TypeProjection typeProjection) {
        TypeSubstitutor g = TypeSubstitutor.g(new b());
        b41.h(g, "create(object : TypeCons…ojection\n        }\n    })");
        return g.t(typeProjection);
    }

    private static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.a g(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        int i = a.$EnumSwitchMapping$0[TypeSubstitutor.c(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i == 1) {
            z71 type = typeProjection.getType();
            b41.h(type, "type");
            z71 type2 = typeProjection.getType();
            b41.h(type2, "type");
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a(typeParameterDescriptor, type, type2);
        } else if (i == 2) {
            z71 type3 = typeProjection.getType();
            b41.h(type3, "type");
            fd2 I = DescriptorUtilsKt.g(typeParameterDescriptor).I();
            b41.h(I, "typeParameter.builtIns.nullableAnyType");
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a(typeParameterDescriptor, type3, I);
        } else if (i == 3) {
            fd2 H = DescriptorUtilsKt.g(typeParameterDescriptor).H();
            b41.h(H, "typeParameter.builtIns.nothingType");
            z71 type4 = typeProjection.getType();
            b41.h(type4, "type");
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a(typeParameterDescriptor, H, type4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final TypeProjection h(kotlin.reflect.jvm.internal.impl.types.typesApproximation.a aVar) {
        aVar.d();
        if (!b41.d(aVar.a(), aVar.b())) {
            Variance variance = aVar.c().getVariance();
            Variance variance2 = Variance.IN_VARIANCE;
            if (variance != variance2) {
                if (!kotlin.reflect.jvm.internal.impl.builtins.b.l0(aVar.a()) || aVar.c().getVariance() == variance2) {
                    return kotlin.reflect.jvm.internal.impl.builtins.b.n0(aVar.b()) ? new zq2(i(aVar, variance2), aVar.a()) : new zq2(i(aVar, Variance.OUT_VARIANCE), aVar.b());
                }
                return new zq2(i(aVar, Variance.OUT_VARIANCE), aVar.b());
            }
        }
        return new zq2(aVar.a());
    }

    private static final Variance i(kotlin.reflect.jvm.internal.impl.types.typesApproximation.a aVar, Variance variance) {
        return variance == aVar.c().getVariance() ? Variance.INVARIANT : variance;
    }
}
