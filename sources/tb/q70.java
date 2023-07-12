package tb;

import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class q70 extends cd2 implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf$Function D;
    @NotNull
    private final NameResolver E;
    @NotNull
    private final er2 F;
    @NotNull
    private final ix2 G;
    @Nullable
    private final DeserializedContainerSource H;
    @NotNull
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode I;

    public /* synthetic */ q70(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, ni1 ni1Var, CallableMemberDescriptor.Kind kind, ProtoBuf$Function protoBuf$Function, NameResolver nameResolver, er2 er2Var, ix2 ix2Var, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement, int i, k50 k50Var) {
        this(declarationDescriptor, simpleFunctionDescriptor, annotations, ni1Var, kind, protoBuf$Function, nameResolver, er2Var, ix2Var, deserializedContainerSource, (i & 1024) != 0 ? null : sourceElement);
    }

    @NotNull
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode J() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    /* renamed from: K */
    public ProtoBuf$Function getProto() {
        return this.D;
    }

    @NotNull
    public final cd2 L(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<? extends ValueParameterDescriptor> list2, @Nullable z71 z71Var, @Nullable Modality modality, @NotNull f70 f70Var, @NotNull Map<? extends CallableDescriptor.UserDataKey<?>, ?> map, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        b41.i(list, "typeParameters");
        b41.i(list2, "unsubstitutedValueParameters");
        b41.i(f70Var, "visibility");
        b41.i(map, "userDataMap");
        b41.i(coroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
        cd2 I = super.I(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, z71Var, modality, f70Var, map);
        b41.h(I, "super.initialize(\n      …    userDataMap\n        )");
        this.I = coroutinesCompatibilityMode;
        return I;
    }

    @Override // tb.cd2, kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a
    @NotNull
    protected AbstractC8316a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable ni1 ni1Var, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        ni1 ni1Var2;
        b41.i(declarationDescriptor, "newOwner");
        b41.i(kind, "kind");
        b41.i(annotations, "annotations");
        b41.i(sourceElement, "source");
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (ni1Var == null) {
            ni1 name = getName();
            b41.h(name, "name");
            ni1Var2 = name;
        } else {
            ni1Var2 = ni1Var;
        }
        q70 q70Var = new q70(declarationDescriptor, simpleFunctionDescriptor, annotations, ni1Var2, kind, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        q70Var.s(k());
        q70Var.I = J();
        return q70Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public er2 getTypeTable() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ix2 getVersionRequirementTable() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public List<hx2> getVersionRequirements() {
        return DeserializedCallableMemberDescriptor.C8511a.a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q70(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable SimpleFunctionDescriptor simpleFunctionDescriptor, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ProtoBuf$Function protoBuf$Function, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, @NotNull ix2 ix2Var, @Nullable DeserializedContainerSource deserializedContainerSource, @Nullable SourceElement sourceElement) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations, ni1Var, kind, sourceElement == null ? SourceElement.NO_SOURCE : sourceElement);
        b41.i(declarationDescriptor, "containingDeclaration");
        b41.i(annotations, "annotations");
        b41.i(ni1Var, "name");
        b41.i(kind, "kind");
        b41.i(protoBuf$Function, "proto");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        b41.i(ix2Var, "versionRequirementTable");
        this.D = protoBuf$Function;
        this.E = nameResolver;
        this.F = er2Var;
        this.G = ix2Var;
        this.H = deserializedContainerSource;
        this.I = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }
}
