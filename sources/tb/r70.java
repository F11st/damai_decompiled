package tb;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class r70 extends AbstractTypeAliasDescriptor implements DeserializedMemberDescriptor {
    @NotNull
    private final StorageManager h;
    @NotNull
    private final ProtoBuf$TypeAlias i;
    @NotNull
    private final NameResolver j;
    @NotNull
    private final er2 k;
    @NotNull
    private final ix2 l;
    @Nullable
    private final DeserializedContainerSource m;
    private Collection<? extends TypeAliasConstructorDescriptor> n;
    private fd2 o;
    private fd2 p;
    private List<? extends TypeParameterDescriptor> q;
    private fd2 r;
    @NotNull
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode s;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public r70(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.storage.StorageManager r13, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r14, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r15, @org.jetbrains.annotations.NotNull tb.ni1 r16, @org.jetbrains.annotations.NotNull tb.f70 r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r19, @org.jetbrains.annotations.NotNull tb.er2 r20, @org.jetbrains.annotations.NotNull tb.ix2 r21, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r22) {
        /*
            r12 = this;
            r6 = r12
            r7 = r13
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            java.lang.String r0 = "storageManager"
            tb.b41.i(r13, r0)
            java.lang.String r0 = "containingDeclaration"
            r1 = r14
            tb.b41.i(r14, r0)
            java.lang.String r0 = "annotations"
            r2 = r15
            tb.b41.i(r15, r0)
            java.lang.String r0 = "name"
            r3 = r16
            tb.b41.i(r3, r0)
            java.lang.String r0 = "visibility"
            r5 = r17
            tb.b41.i(r5, r0)
            java.lang.String r0 = "proto"
            tb.b41.i(r8, r0)
            java.lang.String r0 = "nameResolver"
            tb.b41.i(r9, r0)
            java.lang.String r0 = "typeTable"
            tb.b41.i(r10, r0)
            java.lang.String r0 = "versionRequirementTable"
            tb.b41.i(r11, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            java.lang.String r0 = "NO_SOURCE"
            tb.b41.h(r4, r0)
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.h = r7
            r6.i = r8
            r6.j = r9
            r6.k = r10
            r6.l = r11
            r0 = r22
            r6.m = r0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE
            r6.s = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.r70.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, tb.ni1, tb.f70, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, tb.er2, tb.ix2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    @NotNull
    protected List<TypeParameterDescriptor> g() {
        List list = this.q;
        if (list == null) {
            b41.A("typeConstructorParameters");
            return null;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    @Nullable
    public ClassDescriptor getClassDescriptor() {
        if (a81.a(getExpandedType())) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = getExpandedType().c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public fd2 getDefaultType() {
        fd2 fd2Var = this.r;
        if (fd2Var == null) {
            b41.A("defaultTypeImpl");
            return null;
        }
        return fd2Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    @NotNull
    public fd2 getExpandedType() {
        fd2 fd2Var = this.p;
        if (fd2Var != null) {
            return fd2Var;
        }
        b41.A("expandedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    @NotNull
    protected StorageManager getStorageManager() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public er2 getTypeTable() {
        return this.k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    @NotNull
    public fd2 getUnderlyingType() {
        fd2 fd2Var = this.o;
        if (fd2Var != null) {
            return fd2Var;
        }
        b41.A("underlyingType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ix2 getVersionRequirementTable() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public List<hx2> getVersionRequirements() {
        return DeserializedMemberDescriptor.a.a(this);
    }

    @NotNull
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode i() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    /* renamed from: j */
    public ProtoBuf$TypeAlias getProto() {
        return this.i;
    }

    public final void k(@NotNull List<? extends TypeParameterDescriptor> list, @NotNull fd2 fd2Var, @NotNull fd2 fd2Var2, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        b41.i(list, "declaredTypeParameters");
        b41.i(fd2Var, "underlyingType");
        b41.i(fd2Var2, "expandedType");
        b41.i(coroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
        h(list);
        this.o = fd2Var;
        this.p = fd2Var2;
        this.q = TypeParameterUtilsKt.d(this);
        this.r = d();
        this.n = f();
        this.s = coroutinesCompatibilityMode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @NotNull
    /* renamed from: l */
    public TypeAliasDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        b41.i(typeSubstitutor, "substitutor");
        if (typeSubstitutor.k()) {
            return this;
        }
        StorageManager storageManager = getStorageManager();
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        b41.h(containingDeclaration, "containingDeclaration");
        Annotations annotations = getAnnotations();
        b41.h(annotations, "annotations");
        ni1 name = getName();
        b41.h(name, "name");
        r70 r70Var = new r70(storageManager, containingDeclaration, annotations, name, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<TypeParameterDescriptor> declaredTypeParameters = getDeclaredTypeParameters();
        fd2 underlyingType = getUnderlyingType();
        Variance variance = Variance.INVARIANT;
        z71 n = typeSubstitutor.n(underlyingType, variance);
        b41.h(n, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        fd2 a = cr2.a(n);
        z71 n2 = typeSubstitutor.n(getExpandedType(), variance);
        b41.h(n2, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        r70Var.k(declaredTypeParameters, a, cr2.a(n2), i());
        return r70Var;
    }
}
