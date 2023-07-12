package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.bf2;
import tb.dk0;
import tb.f70;
import tb.fd2;
import tb.k50;
import tb.ni1;
import tb.x60;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TypeAliasConstructorDescriptorImpl extends AbstractC8316a implements TypeAliasConstructorDescriptor {
    @NotNull
    private final StorageManager D;
    @NotNull
    private final TypeAliasDescriptor E;
    @NotNull
    private final NullableLazyValue F;
    @NotNull
    private ClassConstructorDescriptor G;
    static final /* synthetic */ KProperty<Object>[] H = {a12.i(new PropertyReference1Impl(a12.b(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    @NotNull
    public static final C8314a Companion = new C8314a(null);

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl$a */
    /* loaded from: classes3.dex */
    public static final class C8314a {
        private C8314a() {
        }

        public /* synthetic */ C8314a(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TypeSubstitutor c(TypeAliasDescriptor typeAliasDescriptor) {
            if (typeAliasDescriptor.getClassDescriptor() == null) {
                return null;
            }
            return TypeSubstitutor.f(typeAliasDescriptor.getExpandedType());
        }

        @Nullable
        public final TypeAliasConstructorDescriptor b(@NotNull StorageManager storageManager, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull ClassConstructorDescriptor classConstructorDescriptor) {
            ClassConstructorDescriptor substitute;
            b41.i(storageManager, "storageManager");
            b41.i(typeAliasDescriptor, "typeAliasDescriptor");
            b41.i(classConstructorDescriptor, "constructor");
            TypeSubstitutor c = c(typeAliasDescriptor);
            if (c == null || (substitute = classConstructorDescriptor.substitute(c)) == null) {
                return null;
            }
            Annotations annotations = classConstructorDescriptor.getAnnotations();
            CallableMemberDescriptor.Kind kind = classConstructorDescriptor.getKind();
            b41.h(kind, "constructor.kind");
            SourceElement source = typeAliasDescriptor.getSource();
            b41.h(source, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, substitute, null, annotations, kind, source, null);
            List<ValueParameterDescriptor> i = AbstractC8316a.i(typeAliasConstructorDescriptorImpl, classConstructorDescriptor.getValueParameters(), c);
            if (i == null) {
                return null;
            }
            fd2 c2 = dk0.c(substitute.getReturnType().f());
            fd2 defaultType = typeAliasDescriptor.getDefaultType();
            b41.h(defaultType, "typeAliasDescriptor.defaultType");
            fd2 j = bf2.j(c2, defaultType);
            ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor.getDispatchReceiverParameter();
            typeAliasConstructorDescriptorImpl.l(dispatchReceiverParameter != null ? x60.f(typeAliasConstructorDescriptorImpl, c.n(dispatchReceiverParameter.getType(), Variance.INVARIANT), Annotations.Companion.b()) : null, null, typeAliasDescriptor.getDeclaredTypeParameters(), i, j, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructorDescriptorImpl;
        }
    }

    private TypeAliasConstructorDescriptorImpl(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, final ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement) {
        super(typeAliasDescriptor, typeAliasConstructorDescriptor, annotations, ni1.i("<init>"), kind, sourceElement);
        this.D = storageManager;
        this.E = typeAliasDescriptor;
        p(I().isActual());
        this.F = storageManager.createNullableLazyValue(new Function0<TypeAliasConstructorDescriptorImpl>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TypeAliasConstructorDescriptorImpl invoke() {
                TypeSubstitutor c;
                StorageManager storageManager2 = TypeAliasConstructorDescriptorImpl.this.getStorageManager();
                TypeAliasDescriptor I = TypeAliasConstructorDescriptorImpl.this.I();
                ClassConstructorDescriptor classConstructorDescriptor2 = classConstructorDescriptor;
                TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = TypeAliasConstructorDescriptorImpl.this;
                Annotations annotations2 = classConstructorDescriptor2.getAnnotations();
                CallableMemberDescriptor.Kind kind2 = classConstructorDescriptor.getKind();
                b41.h(kind2, "underlyingConstructorDescriptor.kind");
                SourceElement source = TypeAliasConstructorDescriptorImpl.this.I().getSource();
                b41.h(source, "typeAliasDescriptor.source");
                TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl2 = new TypeAliasConstructorDescriptorImpl(storageManager2, I, classConstructorDescriptor2, typeAliasConstructorDescriptorImpl, annotations2, kind2, source, null);
                TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl3 = TypeAliasConstructorDescriptorImpl.this;
                ClassConstructorDescriptor classConstructorDescriptor3 = classConstructorDescriptor;
                c = TypeAliasConstructorDescriptorImpl.Companion.c(typeAliasConstructorDescriptorImpl3.I());
                if (c == null) {
                    return null;
                }
                ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor3.getDispatchReceiverParameter();
                typeAliasConstructorDescriptorImpl2.l(null, dispatchReceiverParameter == null ? null : dispatchReceiverParameter.substitute(c), typeAliasConstructorDescriptorImpl3.I().getDeclaredTypeParameters(), typeAliasConstructorDescriptorImpl3.getValueParameters(), typeAliasConstructorDescriptorImpl3.getReturnType(), Modality.FINAL, typeAliasConstructorDescriptorImpl3.I().getVisibility());
                return typeAliasConstructorDescriptorImpl2;
            }
        });
        this.G = classConstructorDescriptor;
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement, k50 k50Var) {
        this(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptor, annotations, kind, sourceElement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a
    @NotNull
    /* renamed from: E */
    public TypeAliasConstructorDescriptor e(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull f70 f70Var, @NotNull CallableMemberDescriptor.Kind kind, boolean z) {
        b41.i(declarationDescriptor, "newOwner");
        b41.i(modality, "modality");
        b41.i(f70Var, "visibility");
        b41.i(kind, "kind");
        FunctionDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(f70Var).setKind(kind).setCopyOverrides(z).build();
        Objects.requireNonNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) build;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a
    @NotNull
    /* renamed from: F */
    public TypeAliasConstructorDescriptorImpl f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable ni1 ni1Var, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        b41.i(declarationDescriptor, "newOwner");
        b41.i(kind, "kind");
        b41.i(annotations, "annotations");
        b41.i(sourceElement, "source");
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2) {
            CallableMemberDescriptor.Kind kind3 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new TypeAliasConstructorDescriptorImpl(this.D, I(), getUnderlyingConstructorDescriptor(), this, annotations, kind2, sourceElement);
    }

    @Override // tb.u40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    /* renamed from: G */
    public TypeAliasDescriptor getContainingDeclaration() {
        return I();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a, tb.u40, tb.t40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    /* renamed from: H */
    public TypeAliasConstructorDescriptor getOriginal() {
        return (TypeAliasConstructorDescriptor) super.getOriginal();
    }

    @NotNull
    public TypeAliasDescriptor I() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @Nullable
    /* renamed from: J */
    public TypeAliasConstructorDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        b41.i(typeSubstitutor, "substitutor");
        FunctionDescriptor substitute = super.substitute(typeSubstitutor);
        Objects.requireNonNull(substitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = (TypeAliasConstructorDescriptorImpl) substitute;
        TypeSubstitutor f = TypeSubstitutor.f(typeAliasConstructorDescriptorImpl.getReturnType());
        b41.h(f, "create(substitutedTypeAliasConstructor.returnType)");
        ClassConstructorDescriptor substitute2 = getUnderlyingConstructorDescriptor().getOriginal().substitute(f);
        if (substitute2 == null) {
            return null;
        }
        typeAliasConstructorDescriptorImpl.G = substitute2;
        return typeAliasConstructorDescriptorImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    @NotNull
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        b41.h(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public z71 getReturnType() {
        z71 returnType = super.getReturnType();
        b41.f(returnType);
        b41.h(returnType, "super.getReturnType()!!");
        return returnType;
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor
    @NotNull
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }
}
