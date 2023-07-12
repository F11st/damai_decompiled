package tb;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class o2 extends u40 implements TypeParameterDescriptor {
    private final Variance e;
    private final boolean f;
    private final int g;
    private final NotNullLazyValue<TypeConstructor> h;
    private final NotNullLazyValue<fd2> i;
    private final StorageManager j;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    class a implements Function0<TypeConstructor> {
        final /* synthetic */ StorageManager a;
        final /* synthetic */ SupertypeLoopChecker b;

        a(StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            this.a = storageManager;
            this.b = supertypeLoopChecker;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public TypeConstructor invoke() {
            return new c(o2.this, this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class b implements Function0<fd2> {
        final /* synthetic */ ni1 a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public class a implements Function0<MemberScope> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public MemberScope invoke() {
                return TypeIntersectionScope.c("Scope for type parameter " + b.this.a.b(), o2.this.getUpperBounds());
            }
        }

        b(ni1 ni1Var) {
            this.a = ni1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public fd2 invoke() {
            return KotlinTypeFactory.j(Annotations.Companion.b(), o2.this.getTypeConstructor(), Collections.emptyList(), false, new LazyScopeAdapter(new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class c extends AbstractTypeConstructor {
        private final SupertypeLoopChecker d;
        final /* synthetic */ o2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull o2 o2Var, StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            super(storageManager);
            if (storageManager == null) {
                o(0);
            }
            this.e = o2Var;
            this.d = supertypeLoopChecker;
        }

        private static /* synthetic */ void o(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // tb.pj
        protected boolean c(@NotNull ClassifierDescriptor classifierDescriptor) {
            if (classifierDescriptor == null) {
                o(9);
            }
            return (classifierDescriptor instanceof TypeParameterDescriptor) && DescriptorEquivalenceForOverrides.INSTANCE.f(this.e, (TypeParameterDescriptor) classifierDescriptor, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<z71> f() {
            List<z71> f = this.e.f();
            if (f == null) {
                o(1);
            }
            return f;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @Nullable
        public z71 g() {
            return kf0.j("Cyclic upper bounds");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
            kotlin.reflect.jvm.internal.impl.builtins.b g = DescriptorUtilsKt.g(this.e);
            if (g == null) {
                o(4);
            }
            return g;
        }

        @Override // tb.pj, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public ClassifierDescriptor getDeclarationDescriptor() {
            o2 o2Var = this.e;
            if (o2Var == null) {
                o(3);
            }
            return o2Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> emptyList = Collections.emptyList();
            if (emptyList == null) {
                o(2);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker j() {
            SupertypeLoopChecker supertypeLoopChecker = this.d;
            if (supertypeLoopChecker == null) {
                o(5);
            }
            return supertypeLoopChecker;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public List<z71> l(@NotNull List<z71> list) {
            if (list == null) {
                o(7);
            }
            List<z71> d = this.e.d(list);
            if (d == null) {
                o(8);
            }
            return d;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public void n(@NotNull z71 z71Var) {
            if (z71Var == null) {
                o(6);
            }
            this.e.e(z71Var);
        }

        public String toString() {
            return this.e.getName().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o2(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @NotNull Variance variance, boolean z, int i, @NotNull SourceElement sourceElement, @NotNull SupertypeLoopChecker supertypeLoopChecker) {
        super(declarationDescriptor, annotations, ni1Var, sourceElement);
        if (storageManager == null) {
            a(0);
        }
        if (declarationDescriptor == null) {
            a(1);
        }
        if (annotations == null) {
            a(2);
        }
        if (ni1Var == null) {
            a(3);
        }
        if (variance == null) {
            a(4);
        }
        if (sourceElement == null) {
            a(5);
        }
        if (supertypeLoopChecker == null) {
            a(6);
        }
        this.e = variance;
        this.f = z;
        this.g = i;
        this.h = storageManager.createLazyValue(new a(storageManager, supertypeLoopChecker));
        this.i = storageManager.createLazyValue(new b(ni1Var));
        this.j = storageManager;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitTypeParameterDescriptor(this, d);
    }

    @NotNull
    protected List<z71> d(@NotNull List<z71> list) {
        if (list == null) {
            a(12);
        }
        if (list == null) {
            a(13);
        }
        return list;
    }

    protected abstract void e(@NotNull z71 z71Var);

    @NotNull
    protected abstract List<z71> f();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public fd2 getDefaultType() {
        fd2 invoke = this.i.invoke();
        if (invoke == null) {
            a(10);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public int getIndex() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.j;
        if (storageManager == null) {
            a(14);
        }
        return storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor invoke = this.h.invoke();
        if (invoke == null) {
            a(9);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public List<z71> getUpperBounds() {
        List<z71> supertypes = ((c) getTypeConstructor()).getSupertypes();
        if (supertypes == null) {
            a(8);
        }
        return supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public Variance getVariance() {
        Variance variance = this.e;
        if (variance == null) {
            a(7);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isReified() {
        return this.f;
    }

    @Override // tb.u40, tb.t40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) super.getOriginal();
        if (typeParameterDescriptor == null) {
            a(11);
        }
        return typeParameterDescriptor;
    }
}
