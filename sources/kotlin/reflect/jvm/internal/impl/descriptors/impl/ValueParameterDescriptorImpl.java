package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.n;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.e70;
import tb.f70;
import tb.fn;
import tb.k50;
import tb.ni1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ValueParameterDescriptorImpl extends b implements ValueParameterDescriptor {
    @NotNull
    public static final a Companion = new a(null);
    private final int f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    @Nullable
    private final z71 j;
    @NotNull
    private final ValueParameterDescriptor k;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        @NotNull
        private final Lazy l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithDestructuringDeclaration(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @NotNull z71 z71Var, boolean z, boolean z2, boolean z3, @Nullable z71 z71Var2, @NotNull SourceElement sourceElement, @NotNull Function0<? extends List<? extends VariableDescriptor>> function0) {
            super(callableDescriptor, valueParameterDescriptor, i, annotations, ni1Var, z71Var, z, z2, z3, z71Var2, sourceElement);
            Lazy b;
            b41.i(callableDescriptor, "containingDeclaration");
            b41.i(annotations, "annotations");
            b41.i(ni1Var, "name");
            b41.i(z71Var, "outType");
            b41.i(sourceElement, "source");
            b41.i(function0, "destructuringVariables");
            b = kotlin.b.b(function0);
            this.l = b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
        @NotNull
        public ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull ni1 ni1Var, int i) {
            b41.i(callableDescriptor, "newOwner");
            b41.i(ni1Var, "newName");
            Annotations annotations = getAnnotations();
            b41.h(annotations, "annotations");
            z71 type = getType();
            b41.h(type, "type");
            boolean declaresDefaultValue = declaresDefaultValue();
            boolean isCrossinline = isCrossinline();
            boolean isNoinline = isNoinline();
            z71 varargElementType = getVarargElementType();
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            b41.h(sourceElement, "NO_SOURCE");
            return new WithDestructuringDeclaration(callableDescriptor, null, i, annotations, ni1Var, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, sourceElement, new Function0<List<? extends VariableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends VariableDescriptor> invoke() {
                    return ValueParameterDescriptorImpl.WithDestructuringDeclaration.this.h();
                }
            });
        }

        @NotNull
        public final List<VariableDescriptor> h() {
            return (List) this.l.getValue();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ValueParameterDescriptorImpl a(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @NotNull z71 z71Var, boolean z, boolean z2, boolean z3, @Nullable z71 z71Var2, @NotNull SourceElement sourceElement, @Nullable Function0<? extends List<? extends VariableDescriptor>> function0) {
            b41.i(callableDescriptor, "containingDeclaration");
            b41.i(annotations, "annotations");
            b41.i(ni1Var, "name");
            b41.i(z71Var, "outType");
            b41.i(sourceElement, "source");
            if (function0 == null) {
                return new ValueParameterDescriptorImpl(callableDescriptor, valueParameterDescriptor, i, annotations, ni1Var, z71Var, z, z2, z3, z71Var2, sourceElement);
            }
            return new WithDestructuringDeclaration(callableDescriptor, valueParameterDescriptor, i, annotations, ni1Var, z71Var, z, z2, z3, z71Var2, sourceElement, function0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @NotNull z71 z71Var, boolean z, boolean z2, boolean z3, @Nullable z71 z71Var2, @NotNull SourceElement sourceElement) {
        super(callableDescriptor, annotations, ni1Var, z71Var, sourceElement);
        b41.i(callableDescriptor, "containingDeclaration");
        b41.i(annotations, "annotations");
        b41.i(ni1Var, "name");
        b41.i(z71Var, "outType");
        b41.i(sourceElement, "source");
        this.f = i;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = z71Var2;
        this.k = valueParameterDescriptor == null ? this : valueParameterDescriptor;
    }

    @JvmStatic
    @NotNull
    public static final ValueParameterDescriptorImpl e(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @NotNull z71 z71Var, boolean z, boolean z2, boolean z3, @Nullable z71 z71Var2, @NotNull SourceElement sourceElement, @Nullable Function0<? extends List<? extends VariableDescriptor>> function0) {
        return Companion.a(callableDescriptor, valueParameterDescriptor, i, annotations, ni1Var, z71Var, z, z2, z3, z71Var2, sourceElement, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        b41.i(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitValueParameterDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    @NotNull
    public ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull ni1 ni1Var, int i) {
        b41.i(callableDescriptor, "newOwner");
        b41.i(ni1Var, "newName");
        Annotations annotations = getAnnotations();
        b41.h(annotations, "annotations");
        z71 type = getType();
        b41.h(type, "type");
        boolean declaresDefaultValue = declaresDefaultValue();
        boolean isCrossinline = isCrossinline();
        boolean isNoinline = isNoinline();
        z71 varargElementType = getVarargElementType();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        b41.h(sourceElement, "NO_SOURCE");
        return new ValueParameterDescriptorImpl(callableDescriptor, null, i, annotations, ni1Var, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, sourceElement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        return this.g && ((CallableMemberDescriptor) getContainingDeclaration()).getKind().isReal();
    }

    @Nullable
    public Void f() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @NotNull
    /* renamed from: g */
    public ValueParameterDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        b41.i(typeSubstitutor, "substitutor");
        if (typeSubstitutor.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public /* bridge */ /* synthetic */ fn getCompileTimeInitializer() {
        return (fn) f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public int getIndex() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        int q;
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        b41.h(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        q = n.q(overriddenDescriptors, 10);
        ArrayList arrayList = new ArrayList(q);
        for (CallableDescriptor callableDescriptor : overriddenDescriptors) {
            arrayList.add(callableDescriptor.getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    @Nullable
    public z71 getVarargElementType() {
        return this.j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public f70 getVisibility() {
        f70 f70Var = e70.LOCAL;
        b41.h(f70Var, "LOCAL");
        return f70Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return ValueParameterDescriptor.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // tb.u40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public CallableDescriptor getContainingDeclaration() {
        return (CallableDescriptor) super.getContainingDeclaration();
    }

    @Override // tb.u40, tb.t40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.k;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }
}
