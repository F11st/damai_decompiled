package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class qp0 extends l1 {
    @NotNull
    public static final C9610a Companion = new C9610a(null);
    @NotNull
    private static final hj l = new hj(C8277c.BUILT_INS_PACKAGE_FQ_NAME, ni1.f("Function"));
    @NotNull
    private static final hj m = new hj(C8277c.KOTLIN_REFLECT_FQ_NAME, ni1.f("KFunction"));
    @NotNull
    private final StorageManager e;
    @NotNull
    private final PackageFragmentDescriptor f;
    @NotNull
    private final FunctionClassKind g;
    private final int h;
    @NotNull
    private final C9611b i;
    @NotNull
    private final rp0 j;
    @NotNull
    private final List<TypeParameterDescriptor> k;

    /* compiled from: Taobao */
    /* renamed from: tb.qp0$a */
    /* loaded from: classes3.dex */
    public static final class C9610a {
        private C9610a() {
        }

        public /* synthetic */ C9610a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.qp0$b */
    /* loaded from: classes3.dex */
    private final class C9611b extends m1 {
        final /* synthetic */ qp0 d;

        /* compiled from: Taobao */
        /* renamed from: tb.qp0$b$a */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C9612a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FunctionClassKind.values().length];
                iArr[FunctionClassKind.Function.ordinal()] = 1;
                iArr[FunctionClassKind.KFunction.ordinal()] = 2;
                iArr[FunctionClassKind.SuspendFunction.ordinal()] = 3;
                iArr[FunctionClassKind.KSuspendFunction.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9611b(qp0 qp0Var) {
            super(qp0Var.e);
            b41.i(qp0Var, "this$0");
            this.d = qp0Var;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<z71> f() {
            List<hj> e;
            int q;
            List A0;
            List<TypeParameterDescriptor> w0;
            int q2;
            int i = C9612a.$EnumSwitchMapping$0[this.d.o().ordinal()];
            if (i == 1) {
                e = C8213l.e(qp0.l);
            } else if (i == 2) {
                e = C8214m.j(qp0.m, new hj(C8277c.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassKind.Function.numberedClassName(this.d.k())));
            } else if (i == 3) {
                e = C8213l.e(qp0.l);
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                e = C8214m.j(qp0.m, new hj(C8277c.COROUTINES_PACKAGE_FQ_NAME_RELEASE, FunctionClassKind.SuspendFunction.numberedClassName(this.d.k())));
            }
            ModuleDescriptor containingDeclaration = this.d.f.getContainingDeclaration();
            q = C8215n.q(e, 10);
            ArrayList arrayList = new ArrayList(q);
            for (hj hjVar : e) {
                ClassDescriptor a = FindClassInModuleKt.a(containingDeclaration, hjVar);
                if (a == null) {
                    throw new IllegalStateException(("Built-in class " + hjVar + " not found").toString());
                }
                w0 = CollectionsKt___CollectionsKt.w0(getParameters(), a.getTypeConstructor().getParameters().size());
                q2 = C8215n.q(w0, 10);
                ArrayList arrayList2 = new ArrayList(q2);
                for (TypeParameterDescriptor typeParameterDescriptor : w0) {
                    arrayList2.add(new zq2(typeParameterDescriptor.getDefaultType()));
                }
                arrayList.add(KotlinTypeFactory.g(Annotations.Companion.b(), a, arrayList2));
            }
            A0 = CollectionsKt___CollectionsKt.A0(arrayList);
            return A0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return this.d.k;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker j() {
            return SupertypeLoopChecker.C8298a.INSTANCE;
        }

        @Override // tb.m1
        @NotNull
        /* renamed from: q */
        public qp0 p() {
            return this.d;
        }

        @NotNull
        public String toString() {
            return p().toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qp0(@NotNull StorageManager storageManager, @NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull FunctionClassKind functionClassKind, int i) {
        super(storageManager, functionClassKind.numberedClassName(i));
        int q;
        List<TypeParameterDescriptor> A0;
        b41.i(storageManager, "storageManager");
        b41.i(packageFragmentDescriptor, "containingDeclaration");
        b41.i(functionClassKind, "functionKind");
        this.e = storageManager;
        this.f = packageFragmentDescriptor;
        this.g = functionClassKind;
        this.h = i;
        this.i = new C9611b(this);
        this.j = new rp0(storageManager, this);
        ArrayList arrayList = new ArrayList();
        n31 n31Var = new n31(1, i);
        q = C8215n.q(n31Var, 10);
        ArrayList arrayList2 = new ArrayList(q);
        Iterator<Integer> it = n31Var.iterator();
        while (it.hasNext()) {
            e(arrayList, this, Variance.IN_VARIANCE, b41.r("P", Integer.valueOf(((i31) it).nextInt())));
            arrayList2.add(wt2.INSTANCE);
        }
        e(arrayList, this, Variance.OUT_VARIANCE, "R");
        A0 = CollectionsKt___CollectionsKt.A0(arrayList);
        this.k = A0;
    }

    private static final void e(ArrayList<TypeParameterDescriptor> arrayList, qp0 qp0Var, Variance variance, String str) {
        arrayList.add(wq2.l(qp0Var, Annotations.Companion.b(), false, variance, ni1.f(str), arrayList.size(), qp0Var.e));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public p21<fd2> getInlineClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        b41.h(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) s();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public f70 getVisibility() {
        f70 f70Var = e70.PUBLIC;
        b41.h(f70Var, "PUBLIC");
        return f70Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public final int k() {
        return this.h;
    }

    @Nullable
    public Void l() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    /* renamed from: m */
    public List<ClassConstructorDescriptor> getConstructors() {
        List<ClassConstructorDescriptor> g;
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    /* renamed from: n */
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.f;
    }

    @NotNull
    public final FunctionClassKind o() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    /* renamed from: p */
    public List<ClassDescriptor> getSealedSubclasses() {
        List<ClassDescriptor> g;
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    /* renamed from: q */
    public MemberScope.C8499b getStaticScope() {
        return MemberScope.C8499b.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.wg1
    @NotNull
    /* renamed from: r */
    public rp0 b(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this.j;
    }

    @Nullable
    public Void s() {
        return null;
    }

    @NotNull
    public String toString() {
        String b = getName().b();
        b41.h(b, "name.asString()");
        return b;
    }
}
