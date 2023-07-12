package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.a6;
import tb.al1;
import tb.b41;
import tb.cx1;
import tb.dx1;
import tb.ej2;
import tb.f70;
import tb.fn;
import tb.gx1;
import tb.hx1;
import tb.hx2;
import tb.ii0;
import tb.ix1;
import tb.ix2;
import tb.j70;
import tb.jx1;
import tb.k70;
import tb.l70;
import tb.ni1;
import tb.p70;
import tb.pi1;
import tb.q70;
import tb.r70;
import tb.tl;
import tb.up0;
import tb.x60;
import tb.yj0;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MemberDeserializer {
    @NotNull
    private final j70 a;
    @NotNull
    private final a6 b;

    public MemberDeserializer(@NotNull j70 j70Var) {
        b41.i(j70Var, c.a);
        this.a = j70Var;
        this.b = new a6(j70Var.c().p(), j70Var.c().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gx1 c(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new gx1.b(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.a.g(), this.a.j(), this.a.d());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).x();
        }
        return null;
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode d(DeserializedMemberDescriptor deserializedMemberDescriptor, TypeDeserializer typeDeserializer) {
        if (s(deserializedMemberDescriptor)) {
            g(typeDeserializer);
            if (typeDeserializer.j()) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode e(DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, Collection<? extends ValueParameterDescriptor> collection, Collection<? extends TypeParameterDescriptor> collection2, z71 z71Var, boolean z) {
        int q;
        List k;
        List<z71> m0;
        boolean z2;
        boolean z3;
        int q2;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode2;
        boolean z4;
        if (s(deserializedCallableMemberDescriptor) && !b41.d(DescriptorUtilsKt.e(deserializedCallableMemberDescriptor), ej2.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            q = n.q(collection, 10);
            ArrayList arrayList = new ArrayList(q);
            for (ValueParameterDescriptor valueParameterDescriptor : collection) {
                arrayList.add(valueParameterDescriptor.getType());
            }
            k = m.k(receiverParameterDescriptor == null ? null : receiverParameterDescriptor.getType());
            m0 = CollectionsKt___CollectionsKt.m0(arrayList, k);
            if (z71Var != null && f(z71Var)) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                for (TypeParameterDescriptor typeParameterDescriptor : collection2) {
                    List<z71> upperBounds = typeParameterDescriptor.getUpperBounds();
                    b41.h(upperBounds, "typeParameter.upperBounds");
                    if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                        for (z71 z71Var2 : upperBounds) {
                            b41.h(z71Var2, AdvanceSetting.NETWORK_TYPE);
                            if (f(z71Var2)) {
                                z2 = true;
                                continue;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    continue;
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (z3) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            q2 = n.q(m0, 10);
            ArrayList arrayList2 = new ArrayList(q2);
            for (z71 z71Var3 : m0) {
                b41.h(z71Var3, "type");
                if (up0.o(z71Var3) && z71Var3.b().size() <= 3) {
                    List<TypeProjection> b = z71Var3.b();
                    if (!(b instanceof Collection) || !b.isEmpty()) {
                        for (TypeProjection typeProjection : b) {
                            z71 type = typeProjection.getType();
                            b41.h(type, "it.type");
                            if (f(type)) {
                                z4 = true;
                                break;
                            }
                        }
                    }
                    z4 = false;
                    if (z4) {
                        coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
                    } else {
                        coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
                    }
                } else {
                    coroutinesCompatibilityMode2 = f(z71Var3) ? DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE : DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
                }
                arrayList2.add(coroutinesCompatibilityMode2);
            }
            DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode3 = (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) k.f0(arrayList2);
            if (coroutinesCompatibilityMode3 == null) {
                coroutinesCompatibilityMode3 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            if (z) {
                coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
            } else {
                coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            return (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) tl.b(coroutinesCompatibilityMode, coroutinesCompatibilityMode3);
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    private final boolean f(z71 z71Var) {
        return TypeUtilsKt.b(z71Var, new PropertyReference1() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$containsSuspendFunctionType$1
            @Override // kotlin.reflect.KProperty1
            @Nullable
            public Object get(@Nullable Object obj) {
                return Boolean.valueOf(up0.o((z71) obj));
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            @NotNull
            public String getName() {
                return "isSuspendFunctionType";
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public KDeclarationContainer getOwner() {
                return a12.d(up0.class, "deserialization");
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public String getSignature() {
                return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            }
        });
    }

    private final void g(TypeDeserializer typeDeserializer) {
        for (TypeParameterDescriptor typeParameterDescriptor : typeDeserializer.k()) {
            typeParameterDescriptor.getUpperBounds();
        }
    }

    private final Annotations h(final MessageLite messageLite, int i, final AnnotatedCallableKind annotatedCallableKind) {
        if (!yj0.HAS_ANNOTATIONS.d(i).booleanValue()) {
            return Annotations.Companion.b();
        }
        return new al1(this.a.h(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getAnnotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                j70 j70Var;
                gx1 c;
                j70 j70Var2;
                List<? extends AnnotationDescriptor> A0;
                List<? extends AnnotationDescriptor> g;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                j70Var = memberDeserializer.a;
                c = memberDeserializer.c(j70Var.e());
                if (c == null) {
                    A0 = null;
                } else {
                    MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                    MessageLite messageLite2 = messageLite;
                    AnnotatedCallableKind annotatedCallableKind2 = annotatedCallableKind;
                    j70Var2 = memberDeserializer2.a;
                    A0 = CollectionsKt___CollectionsKt.A0(j70Var2.c().d().loadCallableAnnotations(c, messageLite2, annotatedCallableKind2));
                }
                if (A0 != null) {
                    return A0;
                }
                g = m.g();
                return g;
            }
        });
    }

    private final ReceiverParameterDescriptor i() {
        DeclarationDescriptor e = this.a.e();
        ClassDescriptor classDescriptor = e instanceof ClassDescriptor ? (ClassDescriptor) e : null;
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    private final Annotations j(final ProtoBuf$Property protoBuf$Property, final boolean z) {
        if (!yj0.HAS_ANNOTATIONS.d(protoBuf$Property.getFlags()).booleanValue()) {
            return Annotations.Companion.b();
        }
        return new al1(this.a.h(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getPropertyFieldAnnotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                j70 j70Var;
                gx1 c;
                j70 j70Var2;
                List<? extends AnnotationDescriptor> A0;
                j70 j70Var3;
                List<? extends AnnotationDescriptor> g;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                j70Var = memberDeserializer.a;
                c = memberDeserializer.c(j70Var.e());
                if (c == null) {
                    A0 = null;
                } else {
                    boolean z2 = z;
                    MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                    ProtoBuf$Property protoBuf$Property2 = protoBuf$Property;
                    if (z2) {
                        j70Var3 = memberDeserializer2.a;
                        A0 = CollectionsKt___CollectionsKt.A0(j70Var3.c().d().loadPropertyDelegateFieldAnnotations(c, protoBuf$Property2));
                    } else {
                        j70Var2 = memberDeserializer2.a;
                        A0 = CollectionsKt___CollectionsKt.A0(j70Var2.c().d().loadPropertyBackingFieldAnnotations(c, protoBuf$Property2));
                    }
                }
                if (A0 != null) {
                    return A0;
                }
                g = m.g();
                return g;
            }
        });
    }

    private final Annotations k(final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        return new k70(this.a.h(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getReceiverParameterAnnotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                j70 j70Var;
                gx1 c;
                j70 j70Var2;
                List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations;
                List<? extends AnnotationDescriptor> g;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                j70Var = memberDeserializer.a;
                c = memberDeserializer.c(j70Var.e());
                if (c == null) {
                    loadExtensionReceiverParameterAnnotations = null;
                } else {
                    MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                    MessageLite messageLite2 = messageLite;
                    AnnotatedCallableKind annotatedCallableKind2 = annotatedCallableKind;
                    j70Var2 = memberDeserializer2.a;
                    loadExtensionReceiverParameterAnnotations = j70Var2.c().d().loadExtensionReceiverParameterAnnotations(c, messageLite2, annotatedCallableKind2);
                }
                if (loadExtensionReceiverParameterAnnotations != null) {
                    return loadExtensionReceiverParameterAnnotations;
                }
                g = m.g();
                return g;
            }
        });
    }

    private final void l(q70 q70Var, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<? extends ValueParameterDescriptor> list2, z71 z71Var, Modality modality, f70 f70Var, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map, boolean z) {
        q70Var.L(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, z71Var, modality, f70Var, map, e(q70Var, receiverParameterDescriptor, list2, list, z71Var, z));
    }

    private final int o(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r26, final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r27, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r28) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.r(java.util.List, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind):java.util.List");
    }

    private final boolean s(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        boolean z;
        boolean z2;
        if (this.a.c().g().getReleaseCoroutines()) {
            List<hx2> versionRequirements = deserializedMemberDescriptor.getVersionRequirements();
            if (!(versionRequirements instanceof Collection) || !versionRequirements.isEmpty()) {
                for (hx2 hx2Var : versionRequirements) {
                    if (b41.d(hx2Var.b(), new hx2.b(1, 3, 0, 4, null)) && hx2Var.a() == ProtoBuf$VersionRequirement.VersionKind.LANGUAGE_VERSION) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            return z2;
        }
        return false;
    }

    @NotNull
    public final ClassConstructorDescriptor m(@NotNull ProtoBuf$Constructor protoBuf$Constructor, boolean z) {
        List g;
        j70 s;
        TypeDeserializer i;
        l70 l70Var;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode e;
        b41.i(protoBuf$Constructor, "proto");
        ClassDescriptor classDescriptor = (ClassDescriptor) this.a.e();
        int flags = protoBuf$Constructor.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        l70 l70Var2 = new l70(classDescriptor, null, h(protoBuf$Constructor, flags, annotatedCallableKind), z, CallableMemberDescriptor.Kind.DECLARATION, protoBuf$Constructor, this.a.g(), this.a.j(), this.a.k(), this.a.d(), null, 1024, null);
        j70 j70Var = this.a;
        g = m.g();
        MemberDeserializer f = j70.b(j70Var, l70Var2, g, null, null, null, null, 60, null).f();
        List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Constructor.getValueParameterList();
        b41.h(valueParameterList, "proto.valueParameterList");
        l70Var2.J(f.r(valueParameterList, protoBuf$Constructor, annotatedCallableKind), ix1.a(hx1.INSTANCE, yj0.VISIBILITY.d(protoBuf$Constructor.getFlags())));
        l70Var2.A(classDescriptor.getDefaultType());
        boolean z2 = true;
        l70Var2.s(!yj0.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.d(protoBuf$Constructor.getFlags()).booleanValue());
        DeclarationDescriptor e2 = this.a.e();
        DeserializedClassDescriptor deserializedClassDescriptor = e2 instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) e2 : null;
        if (((deserializedClassDescriptor != null && (s = deserializedClassDescriptor.s()) != null && (i = s.i()) != null && i.j()) && s(l70Var2)) ? false : false) {
            e = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            l70Var = l70Var2;
        } else {
            Collection<? extends ValueParameterDescriptor> valueParameters = l70Var2.getValueParameters();
            b41.h(valueParameters, "descriptor.valueParameters");
            Collection<? extends TypeParameterDescriptor> typeParameters = l70Var2.getTypeParameters();
            b41.h(typeParameters, "descriptor.typeParameters");
            l70Var = l70Var2;
            e = e(l70Var2, null, valueParameters, typeParameters, l70Var2.getReturnType(), false);
        }
        l70Var.O(e);
        return l70Var;
    }

    @NotNull
    public final SimpleFunctionDescriptor n(@NotNull ProtoBuf$Function protoBuf$Function) {
        Annotations b;
        ix2 k;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> i;
        z71 q;
        b41.i(protoBuf$Function, "proto");
        int flags = protoBuf$Function.hasFlags() ? protoBuf$Function.getFlags() : o(protoBuf$Function.getOldFlags());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations h = h(protoBuf$Function, flags, annotatedCallableKind);
        if (jx1.d(protoBuf$Function)) {
            b = k(protoBuf$Function, annotatedCallableKind);
        } else {
            b = Annotations.Companion.b();
        }
        if (b41.d(DescriptorUtilsKt.i(this.a.e()).c(pi1.b(this.a.g(), protoBuf$Function.getName())), ej2.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            k = ix2.Companion.b();
        } else {
            k = this.a.k();
        }
        ix2 ix2Var = k;
        DeclarationDescriptor e = this.a.e();
        ni1 b2 = pi1.b(this.a.g(), protoBuf$Function.getName());
        hx1 hx1Var = hx1.INSTANCE;
        q70 q70Var = new q70(e, null, h, b2, ix1.b(hx1Var, yj0.MEMBER_KIND.d(flags)), protoBuf$Function, this.a.g(), this.a.j(), ix2Var, this.a.d(), null, 1024, null);
        j70 j70Var = this.a;
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Function.getTypeParameterList();
        b41.h(typeParameterList, "proto.typeParameterList");
        j70 b3 = j70.b(j70Var, q70Var, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf$Type h2 = jx1.h(protoBuf$Function, this.a.j());
        ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (h2 != null && (q = b3.i().q(h2)) != null) {
            receiverParameterDescriptor = x60.f(q70Var, q, b);
        }
        ReceiverParameterDescriptor i2 = i();
        List<TypeParameterDescriptor> k2 = b3.i().k();
        MemberDeserializer f = b3.f();
        List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Function.getValueParameterList();
        b41.h(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> r = f.r(valueParameterList, protoBuf$Function, annotatedCallableKind);
        z71 q2 = b3.i().q(jx1.j(protoBuf$Function, this.a.j()));
        Modality b4 = hx1Var.b(yj0.MODALITY.d(flags));
        f70 a = ix1.a(hx1Var, yj0.VISIBILITY.d(flags));
        i = x.i();
        yj0.b bVar = yj0.IS_SUSPEND;
        Boolean d = bVar.d(flags);
        b41.h(d, "IS_SUSPEND.get(flags)");
        l(q70Var, receiverParameterDescriptor, i2, k2, r, q2, b4, a, i, d.booleanValue());
        Boolean d2 = yj0.IS_OPERATOR.d(flags);
        b41.h(d2, "IS_OPERATOR.get(flags)");
        q70Var.z(d2.booleanValue());
        Boolean d3 = yj0.IS_INFIX.d(flags);
        b41.h(d3, "IS_INFIX.get(flags)");
        q70Var.w(d3.booleanValue());
        Boolean d4 = yj0.IS_EXTERNAL_FUNCTION.d(flags);
        b41.h(d4, "IS_EXTERNAL_FUNCTION.get(flags)");
        q70Var.r(d4.booleanValue());
        Boolean d5 = yj0.IS_INLINE.d(flags);
        b41.h(d5, "IS_INLINE.get(flags)");
        q70Var.y(d5.booleanValue());
        Boolean d6 = yj0.IS_TAILREC.d(flags);
        b41.h(d6, "IS_TAILREC.get(flags)");
        q70Var.C(d6.booleanValue());
        Boolean d7 = bVar.d(flags);
        b41.h(d7, "IS_SUSPEND.get(flags)");
        q70Var.B(d7.booleanValue());
        Boolean d8 = yj0.IS_EXPECT_FUNCTION.d(flags);
        b41.h(d8, "IS_EXPECT_FUNCTION.get(flags)");
        q70Var.q(d8.booleanValue());
        q70Var.s(!yj0.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.d(flags).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.a.c().h().deserializeContractFromFunction(protoBuf$Function, q70Var, this.a.j(), b3.i());
        if (deserializeContractFromFunction != null) {
            q70Var.o(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return q70Var;
    }

    @NotNull
    public final PropertyDescriptor p(@NotNull ProtoBuf$Property protoBuf$Property) {
        ProtoBuf$Property protoBuf$Property2;
        Annotations b;
        z71 q;
        p70 p70Var;
        ReceiverParameterDescriptor f;
        yj0.d<ProtoBuf$Modality> dVar;
        yj0.d<ProtoBuf$Visibility> dVar2;
        cx1 cx1Var;
        final p70 p70Var2;
        final ProtoBuf$Property protoBuf$Property3;
        int i;
        boolean z;
        dx1 dx1Var;
        List g;
        List<ProtoBuf$ValueParameter> e;
        cx1 b2;
        b41.i(protoBuf$Property, "proto");
        int flags = protoBuf$Property.hasFlags() ? protoBuf$Property.getFlags() : o(protoBuf$Property.getOldFlags());
        DeclarationDescriptor e2 = this.a.e();
        Annotations h = h(protoBuf$Property, flags, AnnotatedCallableKind.PROPERTY);
        hx1 hx1Var = hx1.INSTANCE;
        yj0.d<ProtoBuf$Modality> dVar3 = yj0.MODALITY;
        Modality b3 = hx1Var.b(dVar3.d(flags));
        yj0.d<ProtoBuf$Visibility> dVar4 = yj0.VISIBILITY;
        f70 a = ix1.a(hx1Var, dVar4.d(flags));
        Boolean d = yj0.IS_VAR.d(flags);
        b41.h(d, "IS_VAR.get(flags)");
        boolean booleanValue = d.booleanValue();
        ni1 b4 = pi1.b(this.a.g(), protoBuf$Property.getName());
        CallableMemberDescriptor.Kind b5 = ix1.b(hx1Var, yj0.MEMBER_KIND.d(flags));
        Boolean d2 = yj0.IS_LATEINIT.d(flags);
        b41.h(d2, "IS_LATEINIT.get(flags)");
        boolean booleanValue2 = d2.booleanValue();
        Boolean d3 = yj0.IS_CONST.d(flags);
        b41.h(d3, "IS_CONST.get(flags)");
        boolean booleanValue3 = d3.booleanValue();
        Boolean d4 = yj0.IS_EXTERNAL_PROPERTY.d(flags);
        b41.h(d4, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = d4.booleanValue();
        Boolean d5 = yj0.IS_DELEGATED.d(flags);
        b41.h(d5, "IS_DELEGATED.get(flags)");
        boolean booleanValue5 = d5.booleanValue();
        Boolean d6 = yj0.IS_EXPECT_PROPERTY.d(flags);
        b41.h(d6, "IS_EXPECT_PROPERTY.get(flags)");
        hx1 hx1Var2 = hx1Var;
        p70 p70Var3 = new p70(e2, null, h, b3, a, booleanValue, b4, b5, booleanValue2, booleanValue3, booleanValue4, booleanValue5, d6.booleanValue(), protoBuf$Property, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        j70 j70Var = this.a;
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Property.getTypeParameterList();
        b41.h(typeParameterList, "proto.typeParameterList");
        j70 b6 = j70.b(j70Var, p70Var3, typeParameterList, null, null, null, null, 60, null);
        Boolean d7 = yj0.HAS_GETTER.d(flags);
        b41.h(d7, "HAS_GETTER.get(flags)");
        boolean booleanValue6 = d7.booleanValue();
        if (booleanValue6 && jx1.e(protoBuf$Property)) {
            protoBuf$Property2 = protoBuf$Property;
            b = k(protoBuf$Property2, AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            protoBuf$Property2 = protoBuf$Property;
            b = Annotations.Companion.b();
        }
        z71 q2 = b6.i().q(jx1.k(protoBuf$Property2, this.a.j()));
        List<TypeParameterDescriptor> k = b6.i().k();
        ReceiverParameterDescriptor i2 = i();
        ProtoBuf$Type i3 = jx1.i(protoBuf$Property2, this.a.j());
        if (i3 == null || (q = b6.i().q(i3)) == null) {
            p70Var = p70Var3;
            f = null;
        } else {
            p70Var = p70Var3;
            f = x60.f(p70Var, q, b);
        }
        p70Var.t(q2, k, i2, f);
        Boolean d8 = yj0.HAS_ANNOTATIONS.d(flags);
        b41.h(d8, "HAS_ANNOTATIONS.get(flags)");
        int b7 = yj0.b(d8.booleanValue(), dVar4.d(flags), dVar3.d(flags), false, false, false);
        if (booleanValue6) {
            int getterFlags = protoBuf$Property.hasGetterFlags() ? protoBuf$Property.getGetterFlags() : b7;
            Boolean d9 = yj0.IS_NOT_DEFAULT.d(getterFlags);
            b41.h(d9, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue7 = d9.booleanValue();
            Boolean d10 = yj0.IS_EXTERNAL_ACCESSOR.d(getterFlags);
            b41.h(d10, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue8 = d10.booleanValue();
            Boolean d11 = yj0.IS_INLINE_ACCESSOR.d(getterFlags);
            b41.h(d11, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = d11.booleanValue();
            Annotations h2 = h(protoBuf$Property2, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue7) {
                hx1Var2 = hx1Var2;
                dVar = dVar3;
                dVar2 = dVar4;
                b2 = new cx1(p70Var, h2, hx1Var2.b(dVar3.d(getterFlags)), ix1.a(hx1Var2, dVar4.d(getterFlags)), !booleanValue7, booleanValue8, booleanValue9, p70Var.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                dVar = dVar3;
                dVar2 = dVar4;
                b2 = x60.b(p70Var, h2);
                b41.h(b2, "{\n                Descri…nnotations)\n            }");
            }
            b2.k(p70Var.getReturnType());
            cx1Var = b2;
        } else {
            dVar = dVar3;
            dVar2 = dVar4;
            cx1Var = null;
        }
        Boolean d12 = yj0.HAS_SETTER.d(flags);
        b41.h(d12, "HAS_SETTER.get(flags)");
        if (d12.booleanValue()) {
            if (protoBuf$Property.hasSetterFlags()) {
                b7 = protoBuf$Property.getSetterFlags();
            }
            int i4 = b7;
            Boolean d13 = yj0.IS_NOT_DEFAULT.d(i4);
            b41.h(d13, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue10 = d13.booleanValue();
            Boolean d14 = yj0.IS_EXTERNAL_ACCESSOR.d(i4);
            b41.h(d14, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue11 = d14.booleanValue();
            Boolean d15 = yj0.IS_INLINE_ACCESSOR.d(i4);
            b41.h(d15, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = d15.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations h3 = h(protoBuf$Property2, i4, annotatedCallableKind);
            if (booleanValue10) {
                hx1 hx1Var3 = hx1Var2;
                dx1 dx1Var2 = new dx1(p70Var, h3, hx1Var3.b(dVar.d(i4)), ix1.a(hx1Var3, dVar2.d(i4)), !booleanValue10, booleanValue11, booleanValue12, p70Var.getKind(), null, SourceElement.NO_SOURCE);
                g = m.g();
                z = true;
                p70Var2 = p70Var;
                protoBuf$Property3 = protoBuf$Property2;
                i = flags;
                MemberDeserializer f2 = j70.b(b6, dx1Var2, g, null, null, null, null, 60, null).f();
                e = l.e(protoBuf$Property.getSetterValueParameter());
                dx1Var2.l((ValueParameterDescriptor) k.q0(f2.r(e, protoBuf$Property3, annotatedCallableKind)));
                dx1Var = dx1Var2;
            } else {
                p70Var2 = p70Var;
                protoBuf$Property3 = protoBuf$Property2;
                i = flags;
                z = true;
                dx1Var = x60.c(p70Var2, h3, Annotations.Companion.b());
                b41.h(dx1Var, "{\n                Descri…          )\n            }");
            }
        } else {
            p70Var2 = p70Var;
            protoBuf$Property3 = protoBuf$Property2;
            i = flags;
            z = true;
            dx1Var = null;
        }
        Boolean d16 = yj0.HAS_CONSTANT.d(i);
        b41.h(d16, "HAS_CONSTANT.get(flags)");
        if (d16.booleanValue()) {
            p70Var2.e(this.a.h().createNullableLazyValue(new Function0<fn<?>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final fn<?> invoke() {
                    j70 j70Var2;
                    gx1 c;
                    j70 j70Var3;
                    MemberDeserializer memberDeserializer = MemberDeserializer.this;
                    j70Var2 = memberDeserializer.a;
                    c = memberDeserializer.c(j70Var2.e());
                    b41.f(c);
                    j70Var3 = MemberDeserializer.this.a;
                    AnnotationAndConstantLoader<AnnotationDescriptor, fn<?>> d17 = j70Var3.c().d();
                    ProtoBuf$Property protoBuf$Property4 = protoBuf$Property3;
                    z71 returnType = p70Var2.getReturnType();
                    b41.h(returnType, "property.returnType");
                    return d17.loadPropertyConstant(c, protoBuf$Property4, returnType);
                }
            }));
        }
        p70Var2.w(cx1Var, dx1Var, new ii0(j(protoBuf$Property3, false), p70Var2), new ii0(j(protoBuf$Property3, z), p70Var2), d(p70Var2, b6.i()));
        return p70Var2;
    }

    @NotNull
    public final TypeAliasDescriptor q(@NotNull ProtoBuf$TypeAlias protoBuf$TypeAlias) {
        int q;
        b41.i(protoBuf$TypeAlias, "proto");
        Annotations.a aVar = Annotations.Companion;
        List<ProtoBuf$Annotation> annotationList = protoBuf$TypeAlias.getAnnotationList();
        b41.h(annotationList, "proto.annotationList");
        q = n.q(annotationList, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : annotationList) {
            a6 a6Var = this.b;
            b41.h(protoBuf$Annotation, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(a6Var.a(protoBuf$Annotation, this.a.g()));
        }
        r70 r70Var = new r70(this.a.h(), this.a.e(), aVar.a(arrayList), pi1.b(this.a.g(), protoBuf$TypeAlias.getName()), ix1.a(hx1.INSTANCE, yj0.VISIBILITY.d(protoBuf$TypeAlias.getFlags())), protoBuf$TypeAlias, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        j70 j70Var = this.a;
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$TypeAlias.getTypeParameterList();
        b41.h(typeParameterList, "proto.typeParameterList");
        j70 b = j70.b(j70Var, r70Var, typeParameterList, null, null, null, null, 60, null);
        r70Var.k(b.i().k(), b.i().m(jx1.o(protoBuf$TypeAlias, this.a.j()), false), b.i().m(jx1.b(protoBuf$TypeAlias, this.a.j()), false), d(r70Var, b.i()));
        return r70Var;
    }
}
