package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.huawei.hms.opendevice.AbstractC5658c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8212k;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.C8226x;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a81;
import tb.b41;
import tb.bf2;
import tb.ej2;
import tb.fd2;
import tb.fj2;
import tb.fn;
import tb.hj;
import tb.hp0;
import tb.hx1;
import tb.j60;
import tb.j70;
import tb.jn1;
import tb.jx1;
import tb.k50;
import tb.k70;
import tb.kf0;
import tb.pi1;
import tb.up0;
import tb.wf2;
import tb.yj0;
import tb.z71;
import tb.zq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TypeDeserializer {
    @NotNull
    private final j70 a;
    @Nullable
    private final TypeDeserializer b;
    @NotNull
    private final String c;
    @NotNull
    private final String d;
    private boolean e;
    @NotNull
    private final Function1<Integer, ClassifierDescriptor> f;
    @NotNull
    private final Function1<Integer, ClassifierDescriptor> g;
    @NotNull
    private final Map<Integer, TypeParameterDescriptor> h;

    public TypeDeserializer(@NotNull j70 j70Var, @Nullable TypeDeserializer typeDeserializer, @NotNull List<ProtoBuf$TypeParameter> list, @NotNull String str, @NotNull String str2, boolean z) {
        Map<Integer, TypeParameterDescriptor> linkedHashMap;
        b41.i(j70Var, AbstractC5658c.a);
        b41.i(list, "typeParameterProtos");
        b41.i(str, "debugName");
        b41.i(str2, "containerPresentableName");
        this.a = j70Var;
        this.b = typeDeserializer;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = j70Var.h().createMemoizedFunctionWithNullableValues(new Function1<Integer, ClassifierDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$classifierDescriptors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final ClassifierDescriptor invoke(int i) {
                ClassifierDescriptor d;
                d = TypeDeserializer.this.d(i);
                return d;
            }
        });
        this.g = j70Var.h().createMemoizedFunctionWithNullableValues(new Function1<Integer, ClassifierDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeAliasDescriptors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final ClassifierDescriptor invoke(int i) {
                ClassifierDescriptor f;
                f = TypeDeserializer.this.f(i);
                return f;
            }
        });
        if (list.isEmpty()) {
            linkedHashMap = C8226x.i();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            for (ProtoBuf$TypeParameter protoBuf$TypeParameter : list) {
                linkedHashMap.put(Integer.valueOf(protoBuf$TypeParameter.getId()), new DeserializedTypeParameterDescriptor(this.a, protoBuf$TypeParameter, i));
                i++;
            }
        }
        this.h = linkedHashMap;
    }

    public final ClassifierDescriptor d(int i) {
        hj a = pi1.a(this.a.g(), i);
        if (a.k()) {
            return this.a.c().b(a);
        }
        return FindClassInModuleKt.b(this.a.c().p(), a);
    }

    private final fd2 e(int i) {
        if (pi1.a(this.a.g(), i).k()) {
            return this.a.c().n().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    public final ClassifierDescriptor f(int i) {
        hj a = pi1.a(this.a.g(), i);
        if (a.k()) {
            return null;
        }
        return FindClassInModuleKt.d(this.a.c().p(), a);
    }

    private final fd2 g(z71 z71Var, z71 z71Var2) {
        List<TypeProjection> M;
        int q;
        AbstractC8271b h = TypeUtilsKt.h(z71Var);
        Annotations annotations = z71Var.getAnnotations();
        z71 h2 = up0.h(z71Var);
        M = CollectionsKt___CollectionsKt.M(up0.j(z71Var), 1);
        q = C8215n.q(M, 10);
        ArrayList arrayList = new ArrayList(q);
        for (TypeProjection typeProjection : M) {
            arrayList.add(typeProjection.getType());
        }
        return up0.a(h, annotations, h2, arrayList, null, z71Var2, true).j(z71Var.d());
    }

    private final fd2 h(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        fd2 fd2Var = null;
        if (size2 == 0) {
            fd2Var = i(annotations, typeConstructor, list, z);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            TypeConstructor typeConstructor2 = typeConstructor.getBuiltIns().X(size).getTypeConstructor();
            b41.h(typeConstructor2, "functionTypeConstructor.…on(arity).typeConstructor");
            fd2Var = KotlinTypeFactory.i(annotations, typeConstructor2, list, z, null, 16, null);
        }
        if (fd2Var == null) {
            fd2 n = kf0.n(b41.r("Bad suspend function in metadata with constructor: ", typeConstructor), list);
            b41.h(n, "createErrorTypeWithArgum…      arguments\n        )");
            return n;
        }
        return fd2Var;
    }

    private final fd2 i(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        fd2 i = KotlinTypeFactory.i(annotations, typeConstructor, list, z, null, 16, null);
        if (up0.n(i)) {
            return p(i);
        }
        return null;
    }

    private final TypeParameterDescriptor l(int i) {
        TypeParameterDescriptor typeParameterDescriptor = this.h.get(Integer.valueOf(i));
        if (typeParameterDescriptor == null) {
            TypeDeserializer typeDeserializer = this.b;
            if (typeDeserializer == null) {
                return null;
            }
            return typeDeserializer.l(i);
        }
        return typeParameterDescriptor;
    }

    private static final List<ProtoBuf$Type.Argument> n(ProtoBuf$Type protoBuf$Type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf$Type.Argument> m0;
        List<ProtoBuf$Type.Argument> argumentList = protoBuf$Type.getArgumentList();
        b41.h(argumentList, "argumentList");
        ProtoBuf$Type g = jx1.g(protoBuf$Type, typeDeserializer.a.j());
        List<ProtoBuf$Type.Argument> n = g == null ? null : n(g, typeDeserializer);
        if (n == null) {
            n = C8214m.g();
        }
        m0 = CollectionsKt___CollectionsKt.m0(argumentList, n);
        return m0;
    }

    public static /* synthetic */ fd2 o(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return typeDeserializer.m(protoBuf$Type, z);
    }

    private final fd2 p(z71 z71Var) {
        boolean releaseCoroutines = this.a.c().g().getReleaseCoroutines();
        TypeProjection typeProjection = (TypeProjection) C8212k.d0(up0.j(z71Var));
        z71 type = typeProjection == null ? null : typeProjection.getType();
        if (type == null) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = type.c().getDeclarationDescriptor();
        hp0 i = declarationDescriptor == null ? null : DescriptorUtilsKt.i(declarationDescriptor);
        boolean z = true;
        if (type.b().size() == 1 && (fj2.a(i, true) || fj2.a(i, false))) {
            z71 type2 = ((TypeProjection) C8212k.q0(type.b())).getType();
            b41.h(type2, "continuationArgumentType.arguments.single().type");
            DeclarationDescriptor e = this.a.e();
            if (!(e instanceof CallableDescriptor)) {
                e = null;
            }
            CallableDescriptor callableDescriptor = (CallableDescriptor) e;
            if (b41.d(callableDescriptor != null ? DescriptorUtilsKt.e(callableDescriptor) : null, ej2.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
                return g(z71Var, type2);
            }
            if (!this.e && (!releaseCoroutines || !fj2.a(i, !releaseCoroutines))) {
                z = false;
            }
            this.e = z;
            return g(z71Var, type2);
        }
        return (fd2) z71Var;
    }

    private final TypeProjection r(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf$Type.Argument argument) {
        if (argument.getProjection() == ProtoBuf$Type.Argument.Projection.STAR) {
            if (typeParameterDescriptor == null) {
                return new wf2(this.a.c().p().getBuiltIns());
            }
            return new StarProjectionImpl(typeParameterDescriptor);
        }
        hx1 hx1Var = hx1.INSTANCE;
        ProtoBuf$Type.Argument.Projection projection = argument.getProjection();
        b41.h(projection, "typeArgumentProto.projection");
        Variance c = hx1Var.c(projection);
        ProtoBuf$Type m = jx1.m(argument, this.a.j());
        return m == null ? new zq2(kf0.j("No type recorded")) : new zq2(c, q(m));
    }

    private final TypeConstructor s(ProtoBuf$Type protoBuf$Type) {
        ClassifierDescriptor invoke;
        Object obj;
        if (protoBuf$Type.hasClassName()) {
            invoke = this.f.invoke(Integer.valueOf(protoBuf$Type.getClassName()));
            if (invoke == null) {
                invoke = t(this, protoBuf$Type, protoBuf$Type.getClassName());
            }
        } else if (protoBuf$Type.hasTypeParameter()) {
            invoke = l(protoBuf$Type.getTypeParameter());
            if (invoke == null) {
                TypeConstructor k = kf0.k("Unknown type parameter " + protoBuf$Type.getTypeParameter() + ". Please try recompiling module containing \"" + this.d + jn1.QUOTE);
                b41.h(k, "createErrorTypeConstruct…\\\"\"\n                    )");
                return k;
            }
        } else if (protoBuf$Type.hasTypeParameterName()) {
            String string = this.a.g().getString(protoBuf$Type.getTypeParameterName());
            Iterator<T> it = k().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (b41.d(((TypeParameterDescriptor) obj).getName().b(), string)) {
                    break;
                }
            }
            invoke = (TypeParameterDescriptor) obj;
            if (invoke == null) {
                TypeConstructor k2 = kf0.k("Deserialized type parameter " + string + " in " + this.a.e());
                b41.h(k2, "createErrorTypeConstruct….containingDeclaration}\")");
                return k2;
            }
        } else if (protoBuf$Type.hasTypeAliasName()) {
            invoke = this.g.invoke(Integer.valueOf(protoBuf$Type.getTypeAliasName()));
            if (invoke == null) {
                invoke = t(this, protoBuf$Type, protoBuf$Type.getTypeAliasName());
            }
        } else {
            TypeConstructor k3 = kf0.k("Unknown type");
            b41.h(k3, "createErrorTypeConstructor(\"Unknown type\")");
            return k3;
        }
        TypeConstructor typeConstructor = invoke.getTypeConstructor();
        b41.h(typeConstructor, "classifier.typeConstructor");
        return typeConstructor;
    }

    private static final ClassDescriptor t(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, int i) {
        Sequence h;
        Sequence v;
        List<Integer> C;
        Sequence h2;
        int m;
        hj a = pi1.a(typeDeserializer.a.g(), i);
        h = SequencesKt__SequencesKt.h(protoBuf$Type, new Function1<ProtoBuf$Type, ProtoBuf$Type>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ProtoBuf$Type invoke(@NotNull ProtoBuf$Type protoBuf$Type2) {
                j70 j70Var;
                b41.i(protoBuf$Type2, AdvanceSetting.NETWORK_TYPE);
                j70Var = TypeDeserializer.this.a;
                return jx1.g(protoBuf$Type2, j70Var.j());
            }
        });
        v = SequencesKt___SequencesKt.v(h, new Function1<ProtoBuf$Type, Integer>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(@NotNull ProtoBuf$Type protoBuf$Type2) {
                b41.i(protoBuf$Type2, AdvanceSetting.NETWORK_TYPE);
                return Integer.valueOf(protoBuf$Type2.getArgumentCount());
            }
        });
        C = SequencesKt___SequencesKt.C(v);
        h2 = SequencesKt__SequencesKt.h(a, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE);
        m = SequencesKt___SequencesKt.m(h2);
        while (C.size() < m) {
            C.add(0);
        }
        return typeDeserializer.a.c().q().d(a, C);
    }

    public final boolean j() {
        return this.e;
    }

    @NotNull
    public final List<TypeParameterDescriptor> k() {
        List<TypeParameterDescriptor> A0;
        A0 = CollectionsKt___CollectionsKt.A0(this.h.values());
        return A0;
    }

    @NotNull
    public final fd2 m(@NotNull final ProtoBuf$Type protoBuf$Type, boolean z) {
        fd2 e;
        int q;
        List<? extends TypeProjection> A0;
        fd2 i;
        fd2 j;
        List<? extends AnnotationDescriptor> k0;
        b41.i(protoBuf$Type, "proto");
        if (protoBuf$Type.hasClassName()) {
            e = e(protoBuf$Type.getClassName());
        } else {
            e = protoBuf$Type.hasTypeAliasName() ? e(protoBuf$Type.getTypeAliasName()) : null;
        }
        if (e != null) {
            return e;
        }
        TypeConstructor s = s(protoBuf$Type);
        if (kf0.r(s.getDeclarationDescriptor())) {
            fd2 o = kf0.o(s.toString(), s);
            b41.h(o, "createErrorTypeWithCusto….toString(), constructor)");
            return o;
        }
        k70 k70Var = new k70(this.a.h(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$simpleType$annotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                j70 j70Var;
                j70 j70Var2;
                j70Var = TypeDeserializer.this.a;
                AnnotationAndConstantLoader<AnnotationDescriptor, fn<?>> d = j70Var.c().d();
                ProtoBuf$Type protoBuf$Type2 = protoBuf$Type;
                j70Var2 = TypeDeserializer.this.a;
                return d.loadTypeAnnotations(protoBuf$Type2, j70Var2.g());
            }
        });
        List<ProtoBuf$Type.Argument> n = n(protoBuf$Type, this);
        q = C8215n.q(n, 10);
        ArrayList arrayList = new ArrayList(q);
        int i2 = 0;
        for (Object obj : n) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C8214m.p();
            }
            List<TypeParameterDescriptor> parameters = s.getParameters();
            b41.h(parameters, "constructor.parameters");
            arrayList.add(r((TypeParameterDescriptor) C8212k.S(parameters, i2), (ProtoBuf$Type.Argument) obj));
            i2 = i3;
        }
        A0 = CollectionsKt___CollectionsKt.A0(arrayList);
        ClassifierDescriptor declarationDescriptor = s.getDeclarationDescriptor();
        if (z && (declarationDescriptor instanceof TypeAliasDescriptor)) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            fd2 b = KotlinTypeFactory.b((TypeAliasDescriptor) declarationDescriptor, A0);
            fd2 j2 = b.j(a81.b(b) || protoBuf$Type.getNullable());
            Annotations.C8302a c8302a = Annotations.Companion;
            k0 = CollectionsKt___CollectionsKt.k0(k70Var, b.getAnnotations());
            i = j2.k(c8302a.a(k0));
        } else {
            Boolean d = yj0.SUSPEND_TYPE.d(protoBuf$Type.getFlags());
            b41.h(d, "SUSPEND_TYPE.get(proto.flags)");
            if (d.booleanValue()) {
                i = h(k70Var, s, A0, protoBuf$Type.getNullable());
            } else {
                i = KotlinTypeFactory.i(k70Var, s, A0, protoBuf$Type.getNullable(), null, 16, null);
                Boolean d2 = yj0.DEFINITELY_NOT_NULL_TYPE.d(protoBuf$Type.getFlags());
                b41.h(d2, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (d2.booleanValue()) {
                    j60 c = j60.C9300a.c(j60.Companion, i, false, 2, null);
                    if (c == null) {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + i + '\'').toString());
                    }
                    i = c;
                }
            }
        }
        ProtoBuf$Type a = jx1.a(protoBuf$Type, this.a.j());
        if (a != null && (j = bf2.j(i, m(a, false))) != null) {
            i = j;
        }
        return protoBuf$Type.hasClassName() ? this.a.c().t().transformPlatformType(pi1.a(this.a.g(), protoBuf$Type.getClassName()), i) : i;
    }

    @NotNull
    public final z71 q(@NotNull ProtoBuf$Type protoBuf$Type) {
        b41.i(protoBuf$Type, "proto");
        if (protoBuf$Type.hasFlexibleTypeCapabilitiesId()) {
            String string = this.a.g().getString(protoBuf$Type.getFlexibleTypeCapabilitiesId());
            fd2 o = o(this, protoBuf$Type, false, 2, null);
            ProtoBuf$Type c = jx1.c(protoBuf$Type, this.a.j());
            b41.f(c);
            return this.a.c().l().create(protoBuf$Type, string, o, o(this, c, false, 2, null));
        }
        return m(protoBuf$Type, true);
    }

    @NotNull
    public String toString() {
        String str = this.c;
        TypeDeserializer typeDeserializer = this.b;
        return b41.r(str, typeDeserializer == null ? "" : b41.r(". Child of ", typeDeserializer.c));
    }

    public /* synthetic */ TypeDeserializer(j70 j70Var, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z, int i, k50 k50Var) {
        this(j70Var, typeDeserializer, list, str, str2, (i & 32) != 0 ? false : z);
    }
}
