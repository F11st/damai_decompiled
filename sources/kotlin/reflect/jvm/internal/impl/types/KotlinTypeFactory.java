package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b81;
import tb.bk0;
import tb.fd2;
import tb.gu2;
import tb.iq2;
import tb.jq2;
import tb.kf0;
import tb.oq2;
import tb.xg1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KotlinTypeFactory {
    @NotNull
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        private final fd2 a;
        @Nullable
        private final TypeConstructor b;

        public a(@Nullable fd2 fd2Var, @Nullable TypeConstructor typeConstructor) {
            this.a = fd2Var;
            this.b = typeConstructor;
        }

        @Nullable
        public final fd2 a() {
            return this.a;
        }

        @Nullable
        public final TypeConstructor b() {
            return this.b;
        }
    }

    static {
        KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1 kotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1 = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull b81 b81Var) {
                b41.i(b81Var, "$noName_0");
                return null;
            }
        };
    }

    private KotlinTypeFactory() {
    }

    @JvmStatic
    @NotNull
    public static final fd2 b(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> list) {
        b41.i(typeAliasDescriptor, "<this>");
        b41.i(list, "arguments");
        return new iq2(TypeAliasExpansionReportStrategy.a.INSTANCE, false).i(jq2.Companion.a(null, typeAliasDescriptor, list), Annotations.Companion.b());
    }

    private final MemberScope c(TypeConstructor typeConstructor, List<? extends TypeProjection> list, b81 b81Var) {
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return ((TypeParameterDescriptor) declarationDescriptor).getDefaultType().getMemberScope();
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            if (b81Var == null) {
                b81Var = DescriptorUtilsKt.k(DescriptorUtilsKt.l(declarationDescriptor));
            }
            if (list.isEmpty()) {
                return xg1.b((ClassDescriptor) declarationDescriptor, b81Var);
            }
            return xg1.a((ClassDescriptor) declarationDescriptor, oq2.Companion.a(typeConstructor, list), b81Var);
        } else if (declarationDescriptor instanceof TypeAliasDescriptor) {
            MemberScope i = kf0.i(b41.r("Scope for abbreviation: ", ((TypeAliasDescriptor) declarationDescriptor).getName()), true);
            b41.h(i, "createErrorScope(\"Scope …{descriptor.name}\", true)");
            return i;
        } else if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).a();
        } else {
            throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor + " for constructor: " + typeConstructor);
        }
    }

    @JvmStatic
    @NotNull
    public static final gu2 d(@NotNull fd2 fd2Var, @NotNull fd2 fd2Var2) {
        b41.i(fd2Var, "lowerBound");
        b41.i(fd2Var2, "upperBound");
        return b41.d(fd2Var, fd2Var2) ? fd2Var : new bk0(fd2Var, fd2Var2);
    }

    @JvmStatic
    @NotNull
    public static final fd2 e(@NotNull Annotations annotations, @NotNull IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z) {
        List g;
        b41.i(annotations, "annotations");
        b41.i(integerLiteralTypeConstructor, "constructor");
        g = m.g();
        MemberScope i = kf0.i("Scope for integer literal type", true);
        b41.h(i, "createErrorScope(\"Scope …eger literal type\", true)");
        return j(annotations, integerLiteralTypeConstructor, g, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a f(TypeConstructor typeConstructor, b81 b81Var, List<? extends TypeProjection> list) {
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        ClassifierDescriptor e = declarationDescriptor == null ? null : b81Var.e(declarationDescriptor);
        if (e == null) {
            return null;
        }
        if (e instanceof TypeAliasDescriptor) {
            return new a(b((TypeAliasDescriptor) e, list), null);
        }
        TypeConstructor refine = e.getTypeConstructor().refine(b81Var);
        b41.h(refine, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new a(null, refine);
    }

    @JvmStatic
    @NotNull
    public static final fd2 g(@NotNull Annotations annotations, @NotNull ClassDescriptor classDescriptor, @NotNull List<? extends TypeProjection> list) {
        b41.i(annotations, "annotations");
        b41.i(classDescriptor, "descriptor");
        b41.i(list, "arguments");
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        b41.h(typeConstructor, "descriptor.typeConstructor");
        return i(annotations, typeConstructor, list, false, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final fd2 h(@NotNull final Annotations annotations, @NotNull final TypeConstructor typeConstructor, @NotNull final List<? extends TypeProjection> list, final boolean z, @Nullable b81 b81Var) {
        b41.i(annotations, "annotations");
        b41.i(typeConstructor, "constructor");
        b41.i(list, "arguments");
        if (annotations.isEmpty() && list.isEmpty() && !z && typeConstructor.getDeclarationDescriptor() != null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            b41.f(declarationDescriptor);
            fd2 defaultType = declarationDescriptor.getDefaultType();
            b41.h(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return defaultType;
        }
        return k(annotations, typeConstructor, list, z, INSTANCE.c(typeConstructor, list, b81Var), new Function1<b81, fd2>() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$simpleType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final fd2 invoke(@NotNull b81 b81Var2) {
                KotlinTypeFactory.a f;
                b41.i(b81Var2, "refiner");
                f = KotlinTypeFactory.INSTANCE.f(TypeConstructor.this, b81Var2, list);
                if (f == null) {
                    return null;
                }
                fd2 a2 = f.a();
                if (a2 == null) {
                    Annotations annotations2 = annotations;
                    TypeConstructor b = f.b();
                    b41.f(b);
                    return KotlinTypeFactory.h(annotations2, b, list, z, b81Var2);
                }
                return a2;
            }
        });
    }

    public static /* synthetic */ fd2 i(Annotations annotations, TypeConstructor typeConstructor, List list, boolean z, b81 b81Var, int i, Object obj) {
        if ((i & 16) != 0) {
            b81Var = null;
        }
        return h(annotations, typeConstructor, list, z, b81Var);
    }

    @JvmStatic
    @NotNull
    public static final fd2 j(@NotNull final Annotations annotations, @NotNull final TypeConstructor typeConstructor, @NotNull final List<? extends TypeProjection> list, final boolean z, @NotNull final MemberScope memberScope) {
        b41.i(annotations, "annotations");
        b41.i(typeConstructor, "constructor");
        b41.i(list, "arguments");
        b41.i(memberScope, "memberScope");
        e eVar = new e(typeConstructor, list, z, memberScope, new Function1<b81, fd2>() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final fd2 invoke(@NotNull b81 b81Var) {
                KotlinTypeFactory.a f;
                b41.i(b81Var, "kotlinTypeRefiner");
                f = KotlinTypeFactory.INSTANCE.f(TypeConstructor.this, b81Var, list);
                if (f == null) {
                    return null;
                }
                fd2 a2 = f.a();
                if (a2 == null) {
                    Annotations annotations2 = annotations;
                    TypeConstructor b = f.b();
                    b41.f(b);
                    return KotlinTypeFactory.j(annotations2, b, list, z, memberScope);
                }
                return a2;
            }
        });
        return annotations.isEmpty() ? eVar : new kotlin.reflect.jvm.internal.impl.types.a(eVar, annotations);
    }

    @JvmStatic
    @NotNull
    public static final fd2 k(@NotNull Annotations annotations, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull MemberScope memberScope, @NotNull Function1<? super b81, ? extends fd2> function1) {
        b41.i(annotations, "annotations");
        b41.i(typeConstructor, "constructor");
        b41.i(list, "arguments");
        b41.i(memberScope, "memberScope");
        b41.i(function1, "refinedTypeFactory");
        e eVar = new e(typeConstructor, list, z, memberScope, function1);
        return annotations.isEmpty() ? eVar : new kotlin.reflect.jvm.internal.impl.types.a(eVar, annotations);
    }
}
