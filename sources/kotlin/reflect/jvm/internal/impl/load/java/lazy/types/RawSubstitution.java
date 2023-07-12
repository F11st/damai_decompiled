package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.C8213l;
import kotlin.collections.C8215n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a81;
import tb.b41;
import tb.b81;
import tb.br2;
import tb.dk0;
import tb.fd2;
import tb.hj;
import tb.hq2;
import tb.jn1;
import tb.k50;
import tb.kf0;
import tb.q51;
import tb.u51;
import tb.z71;
import tb.zq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class RawSubstitution extends br2 {
    @NotNull
    public static final C8354a Companion = new C8354a(null);
    @NotNull
    private static final q51 b;
    @NotNull
    private static final q51 c;
    @NotNull
    private final TypeParameterUpperBoundEraser a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$a */
    /* loaded from: classes3.dex */
    public static final class C8354a {
        private C8354a() {
        }

        public /* synthetic */ C8354a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$b */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C8355b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        b = u51.d(typeUsage, false, null, 3, null).i(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        c = u51.d(typeUsage, false, null, 3, null).i(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    public RawSubstitution(@Nullable TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        this.a = typeParameterUpperBoundEraser == null ? new TypeParameterUpperBoundEraser(this) : typeParameterUpperBoundEraser;
    }

    public static /* synthetic */ TypeProjection k(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, q51 q51Var, z71 z71Var, int i, Object obj) {
        if ((i & 4) != 0) {
            z71Var = rawSubstitution.a.c(typeParameterDescriptor, true, q51Var);
            b41.h(z71Var, "fun computeProjection(\n …er, attr)\n        }\n    }");
        }
        return rawSubstitution.j(typeParameterDescriptor, q51Var, z71Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<fd2, Boolean> l(final fd2 fd2Var, final ClassDescriptor classDescriptor, final q51 q51Var) {
        int q;
        List e;
        if (fd2Var.c().getParameters().isEmpty()) {
            return hq2.a(fd2Var, Boolean.FALSE);
        }
        if (AbstractC8271b.c0(fd2Var)) {
            TypeProjection typeProjection = fd2Var.b().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            z71 type = typeProjection.getType();
            b41.h(type, "componentTypeProjection.type");
            e = C8213l.e(new zq2(projectionKind, m(type, q51Var)));
            return hq2.a(KotlinTypeFactory.i(fd2Var.getAnnotations(), fd2Var.c(), e, fd2Var.d(), null, 16, null), Boolean.FALSE);
        } else if (a81.a(fd2Var)) {
            fd2 j = kf0.j(b41.r("Raw error type: ", fd2Var.c()));
            b41.h(j, "createErrorType(\"Raw err…pe: ${type.constructor}\")");
            return hq2.a(j, Boolean.FALSE);
        } else {
            MemberScope memberScope = classDescriptor.getMemberScope(this);
            b41.h(memberScope, "declaration.getMemberScope(this)");
            Annotations annotations = fd2Var.getAnnotations();
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            b41.h(typeConstructor, "declaration.typeConstructor");
            List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
            b41.h(parameters, "declaration.typeConstructor.parameters");
            q = C8215n.q(parameters, 10);
            ArrayList arrayList = new ArrayList(q);
            for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
                b41.h(typeParameterDescriptor, "parameter");
                arrayList.add(k(this, typeParameterDescriptor, q51Var, null, 4, null));
            }
            return hq2.a(KotlinTypeFactory.k(annotations, typeConstructor, arrayList, fd2Var.d(), memberScope, new Function1<b81, fd2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final fd2 invoke(@NotNull b81 b81Var) {
                    ClassDescriptor a;
                    Pair l;
                    b41.i(b81Var, "kotlinTypeRefiner");
                    ClassDescriptor classDescriptor2 = ClassDescriptor.this;
                    if (!(classDescriptor2 instanceof ClassDescriptor)) {
                        classDescriptor2 = null;
                    }
                    hj h = classDescriptor2 == null ? null : DescriptorUtilsKt.h(classDescriptor2);
                    if (h == null || (a = b81Var.a(h)) == null || b41.d(a, ClassDescriptor.this)) {
                        return null;
                    }
                    l = this.l(fd2Var, a, q51Var);
                    return (fd2) l.getFirst();
                }
            }), Boolean.TRUE);
        }
    }

    private final z71 m(z71 z71Var, q51 q51Var) {
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            z71 c2 = this.a.c((TypeParameterDescriptor) declarationDescriptor, true, q51Var);
            b41.h(c2, "typeParameterUpperBoundE…tion, isRaw = true, attr)");
            return m(c2, q51Var);
        } else if (declarationDescriptor instanceof ClassDescriptor) {
            ClassifierDescriptor declarationDescriptor2 = dk0.d(z71Var).c().getDeclarationDescriptor();
            if (declarationDescriptor2 instanceof ClassDescriptor) {
                Pair<fd2, Boolean> l = l(dk0.c(z71Var), (ClassDescriptor) declarationDescriptor, b);
                fd2 component1 = l.component1();
                boolean booleanValue = l.component2().booleanValue();
                Pair<fd2, Boolean> l2 = l(dk0.d(z71Var), (ClassDescriptor) declarationDescriptor2, c);
                fd2 component12 = l2.component1();
                boolean booleanValue2 = l2.component2().booleanValue();
                if (!booleanValue && !booleanValue2) {
                    return KotlinTypeFactory.d(component1, component12);
                }
                return new RawTypeImpl(component1, component12);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + jn1.QUOTE).toString());
        } else {
            throw new IllegalStateException(b41.r("Unexpected declaration kind: ", declarationDescriptor).toString());
        }
    }

    static /* synthetic */ z71 n(RawSubstitution rawSubstitution, z71 z71Var, q51 q51Var, int i, Object obj) {
        if ((i & 2) != 0) {
            q51Var = new q51(TypeUsage.COMMON, null, false, null, null, 30, null);
        }
        return rawSubstitution.m(z71Var, q51Var);
    }

    @Override // tb.br2
    public boolean f() {
        return false;
    }

    @NotNull
    public final TypeProjection j(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull q51 q51Var, @NotNull z71 z71Var) {
        b41.i(typeParameterDescriptor, "parameter");
        b41.i(q51Var, RichTextNode.ATTR);
        b41.i(z71Var, "erasedUpperBound");
        int i = C8355b.$EnumSwitchMapping$0[q51Var.d().ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (!typeParameterDescriptor.getVariance().getAllowsOutPosition()) {
                return new zq2(Variance.INVARIANT, DescriptorUtilsKt.g(typeParameterDescriptor).H());
            }
            List<TypeParameterDescriptor> parameters = z71Var.c().getParameters();
            b41.h(parameters, "erasedUpperBound.constructor.parameters");
            if (!parameters.isEmpty()) {
                return new zq2(Variance.OUT_VARIANCE, z71Var);
            }
            return u51.b(typeParameterDescriptor, q51Var);
        }
        return new zq2(Variance.INVARIANT, z71Var);
    }

    @Override // tb.br2
    @NotNull
    /* renamed from: o */
    public zq2 e(@NotNull z71 z71Var) {
        b41.i(z71Var, "key");
        return new zq2(n(this, z71Var, null, 2, null));
    }

    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, int i, k50 k50Var) {
        this((i & 1) != 0 ? null : typeParameterUpperBoundEraser);
    }
}
