package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class p70 extends bx1 implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf$Property A;
    @NotNull
    private final NameResolver B;
    @NotNull
    private final er2 C;
    @NotNull
    private final ix2 D;
    @Nullable
    private final DeserializedContainerSource E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p70(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull f70 f70Var, boolean z, @NotNull ni1 ni1Var, @NotNull CallableMemberDescriptor.Kind kind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, @NotNull ix2 ix2Var, @Nullable DeserializedContainerSource deserializedContainerSource) {
        super(declarationDescriptor, propertyDescriptor, annotations, modality, f70Var, z, ni1Var, kind, SourceElement.NO_SOURCE, z2, z3, z6, false, z4, z5);
        b41.i(declarationDescriptor, "containingDeclaration");
        b41.i(annotations, "annotations");
        b41.i(modality, "modality");
        b41.i(f70Var, "visibility");
        b41.i(ni1Var, "name");
        b41.i(kind, "kind");
        b41.i(protoBuf$Property, "proto");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        b41.i(ix2Var, "versionRequirementTable");
        this.A = protoBuf$Property;
        this.B = nameResolver;
        this.C = er2Var;
        this.D = ix2Var;
        this.E = deserializedContainerSource;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public er2 getTypeTable() {
        return this.C;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ix2 getVersionRequirementTable() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public List<hx2> getVersionRequirements() {
        return DeserializedCallableMemberDescriptor.a.a(this);
    }

    @Override // tb.bx1
    @NotNull
    protected bx1 i(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull f70 f70Var, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ni1 ni1Var, @NotNull SourceElement sourceElement) {
        b41.i(declarationDescriptor, "newOwner");
        b41.i(modality, "newModality");
        b41.i(f70Var, "newVisibility");
        b41.i(kind, "kind");
        b41.i(ni1Var, "newName");
        b41.i(sourceElement, "source");
        return new p70(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, f70Var, isVar(), ni1Var, kind, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // tb.bx1, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean d = yj0.IS_EXTERNAL_PROPERTY.d(getProto().getFlags());
        b41.h(d, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return d.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    /* renamed from: v */
    public ProtoBuf$Property getProto() {
        return this.A;
    }

    public final void w(@Nullable cx1 cx1Var, @Nullable PropertySetterDescriptor propertySetterDescriptor, @Nullable FieldDescriptor fieldDescriptor, @Nullable FieldDescriptor fieldDescriptor2, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        b41.i(coroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
        super.o(cx1Var, propertySetterDescriptor, fieldDescriptor, fieldDescriptor2);
        wt2 wt2Var = wt2.INSTANCE;
    }
}
