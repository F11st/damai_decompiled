package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.b81;
import tb.f70;
import tb.fd2;
import tb.fr2;
import tb.gu2;
import tb.jn1;
import tb.ni1;
import tb.u40;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class AbstractTypeAliasDescriptor extends u40 implements TypeAliasDescriptor {
    @NotNull
    private final f70 e;
    private List<? extends TypeParameterDescriptor> f;
    @NotNull
    private final C8311a g;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$a */
    /* loaded from: classes3.dex */
    public static final class C8311a implements TypeConstructor {
        C8311a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* renamed from: a */
        public TypeAliasDescriptor getDeclarationDescriptor() {
            return AbstractTypeAliasDescriptor.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public AbstractC8271b getBuiltIns() {
            return DescriptorUtilsKt.g(getDeclarationDescriptor());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return AbstractTypeAliasDescriptor.this.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public Collection<z71> getSupertypes() {
            Collection<z71> supertypes = getDeclarationDescriptor().getUnderlyingType().c().getSupertypes();
            b41.h(supertypes, "declarationDescriptor.un…pe.constructor.supertypes");
            return supertypes;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull b81 b81Var) {
            b41.i(b81Var, "kotlinTypeRefiner");
            return this;
        }

        @NotNull
        public String toString() {
            return "[typealias " + getDeclarationDescriptor().getName().b() + jn1.ARRAY_END;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @NotNull SourceElement sourceElement, @NotNull f70 f70Var) {
        super(declarationDescriptor, annotations, ni1Var, sourceElement);
        b41.i(declarationDescriptor, "containingDeclaration");
        b41.i(annotations, "annotations");
        b41.i(ni1Var, "name");
        b41.i(sourceElement, "sourceElement");
        b41.i(f70Var, "visibilityImpl");
        this.e = f70Var;
        this.g = new C8311a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        b41.i(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitTypeAliasDescriptor(this, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final fd2 d() {
        ClassDescriptor classDescriptor = getClassDescriptor();
        MemberScope unsubstitutedMemberScope = classDescriptor == null ? null : classDescriptor.getUnsubstitutedMemberScope();
        if (unsubstitutedMemberScope == null) {
            unsubstitutedMemberScope = MemberScope.C8499b.INSTANCE;
        }
        fd2 u = fr2.u(this, unsubstitutedMemberScope, new Function1<b81, fd2>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$computeDefaultType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final fd2 invoke(b81 b81Var) {
                ClassifierDescriptor e = b81Var.e(AbstractTypeAliasDescriptor.this);
                if (e == null) {
                    return null;
                }
                return e.getDefaultType();
            }
        });
        b41.h(u, "@OptIn(TypeRefinement::c…s)?.defaultType\n        }");
        return u;
    }

    @Override // tb.u40, tb.t40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    /* renamed from: e */
    public TypeAliasDescriptor getOriginal() {
        return (TypeAliasDescriptor) super.getOriginal();
    }

    @NotNull
    public final Collection<TypeAliasConstructorDescriptor> f() {
        List g;
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null) {
            g = C8214m.g();
            return g;
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        b41.h(constructors, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            TypeAliasConstructorDescriptorImpl.C8314a c8314a = TypeAliasConstructorDescriptorImpl.Companion;
            StorageManager storageManager = getStorageManager();
            b41.h(classConstructorDescriptor, AdvanceSetting.NETWORK_TYPE);
            TypeAliasConstructorDescriptor b = c8314a.b(storageManager, this, classConstructorDescriptor);
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    @NotNull
    protected abstract List<TypeParameterDescriptor> g();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List list = this.f;
        if (list == null) {
            b41.A("declaredTypeParametersImpl");
            return null;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        return Modality.FINAL;
    }

    @NotNull
    protected abstract StorageManager getStorageManager();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public f70 getVisibility() {
        return this.e;
    }

    public final void h(@NotNull List<? extends TypeParameterDescriptor> list) {
        b41.i(list, "declaredTypeParameters");
        this.f = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return fr2.c(getUnderlyingType(), new Function1<gu2, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$isInner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
                if (((r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) && !tb.b41.d(((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5).getContainingDeclaration(), r0)) != false) goto L9;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(tb.gu2 r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = "type"
                    tb.b41.h(r5, r0)
                    boolean r0 = tb.a81.a(r5)
                    r1 = 1
                    r2 = 0
                    if (r0 != 0) goto L2d
                    kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor r0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.this
                    kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r5.c()
                    kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r5 = r5.getDeclarationDescriptor()
                    boolean r3 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
                    if (r3 == 0) goto L29
                    kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
                    kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
                    boolean r5 = tb.b41.d(r5, r0)
                    if (r5 != 0) goto L29
                    r5 = 1
                    goto L2a
                L29:
                    r5 = 0
                L2a:
                    if (r5 == 0) goto L2d
                    goto L2e
                L2d:
                    r1 = 0
                L2e:
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$isInner$1.invoke(tb.gu2):java.lang.Boolean");
            }
        });
    }

    @Override // tb.t40
    @NotNull
    public String toString() {
        return b41.r("typealias ", getName().b());
    }
}
