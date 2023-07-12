package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class l70 extends dj implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf$Constructor F;
    @NotNull
    private final NameResolver G;
    @NotNull
    private final er2 H;
    @NotNull
    private final ix2 I;
    @Nullable
    private final DeserializedContainerSource J;
    @NotNull
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode K;

    public /* synthetic */ l70(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z, CallableMemberDescriptor.Kind kind, ProtoBuf$Constructor protoBuf$Constructor, NameResolver nameResolver, er2 er2Var, ix2 ix2Var, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement, int i, k50 k50Var) {
        this(classDescriptor, constructorDescriptor, annotations, z, kind, protoBuf$Constructor, nameResolver, er2Var, ix2Var, deserializedContainerSource, (i & 1024) != 0 ? null : sourceElement);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.dj, kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    @NotNull
    /* renamed from: L */
    public l70 f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable ni1 ni1Var, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        b41.i(declarationDescriptor, "newOwner");
        b41.i(kind, "kind");
        b41.i(annotations, "annotations");
        b41.i(sourceElement, "source");
        l70 l70Var = new l70((ClassDescriptor) declarationDescriptor, (ConstructorDescriptor) functionDescriptor, annotations, this.D, kind, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        l70Var.s(k());
        l70Var.O(M());
        return l70Var;
    }

    @NotNull
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode M() {
        return this.K;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    /* renamed from: N */
    public ProtoBuf$Constructor getProto() {
        return this.F;
    }

    public void O(@NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        b41.i(coroutinesCompatibilityMode, "<set-?>");
        this.K = coroutinesCompatibilityMode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public er2 getTypeTable() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ix2 getVersionRequirementTable() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public List<hx2> getVersionRequirements() {
        return DeserializedCallableMemberDescriptor.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l70(@NotNull ClassDescriptor classDescriptor, @Nullable ConstructorDescriptor constructorDescriptor, @NotNull Annotations annotations, boolean z, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ProtoBuf$Constructor protoBuf$Constructor, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, @NotNull ix2 ix2Var, @Nullable DeserializedContainerSource deserializedContainerSource, @Nullable SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations, z, kind, sourceElement == null ? SourceElement.NO_SOURCE : sourceElement);
        b41.i(classDescriptor, "containingDeclaration");
        b41.i(annotations, "annotations");
        b41.i(kind, "kind");
        b41.i(protoBuf$Constructor, "proto");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        b41.i(ix2Var, "versionRequirementTable");
        this.F = protoBuf$Constructor;
        this.G = nameResolver;
        this.H = er2Var;
        this.I = ix2Var;
        this.J = deserializedContainerSource;
        this.K = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }
}
