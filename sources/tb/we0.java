package tb;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class we0 extends fj {
    private final TypeConstructor h;
    private final MemberScope i;
    private final NotNullLazyValue<Set<ni1>> j;
    private final Annotations k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class a extends le1 {
        private final MemoizedFunctionToNotNull<ni1, Collection<? extends SimpleFunctionDescriptor>> a;
        private final MemoizedFunctionToNotNull<ni1, Collection<? extends PropertyDescriptor>> b;
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> c;
        final /* synthetic */ we0 d;

        /* compiled from: Taobao */
        /* renamed from: tb.we0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0464a implements Function1<ni1, Collection<? extends SimpleFunctionDescriptor>> {
            C0464a(we0 we0Var) {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Collection<? extends SimpleFunctionDescriptor> invoke(ni1 ni1Var) {
                return a.this.f(ni1Var);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        class b implements Function1<ni1, Collection<? extends PropertyDescriptor>> {
            b(we0 we0Var) {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Collection<? extends PropertyDescriptor> invoke(ni1 ni1Var) {
                return a.this.g(ni1Var);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        class c implements Function0<Collection<DeclarationDescriptor>> {
            c(we0 we0Var) {
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public Collection<DeclarationDescriptor> invoke() {
                return a.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public class d extends el1 {
            final /* synthetic */ Set a;

            d(a aVar, Set set) {
                this.a = set;
            }

            private static /* synthetic */ void f(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // tb.gp1
            public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    f(0);
                }
                OverridingUtil.L(callableMemberDescriptor, null);
                this.a.add(callableMemberDescriptor);
            }

            @Override // tb.el1
            protected void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    f(1);
                }
                if (callableMemberDescriptor2 == null) {
                    f(2);
                }
            }
        }

        public a(@NotNull we0 we0Var, StorageManager storageManager) {
            if (storageManager == null) {
                a(0);
            }
            this.d = we0Var;
            this.a = storageManager.createMemoizedFunction(new C0464a(we0Var));
            this.b = storageManager.createMemoizedFunction(new b(we0Var));
            this.c = storageManager.createLazyValue(new c(we0Var));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00be  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void a(int r13) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.we0.a.a(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<DeclarationDescriptor> e() {
            HashSet hashSet = new HashSet();
            for (ni1 ni1Var : (Set) this.d.j.invoke()) {
                NoLookupLocation noLookupLocation = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(getContributedFunctions(ni1Var, noLookupLocation));
                hashSet.addAll(getContributedVariables(ni1Var, noLookupLocation));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<? extends SimpleFunctionDescriptor> f(@NotNull ni1 ni1Var) {
            if (ni1Var == null) {
                a(8);
            }
            return i(ni1Var, h().getContributedFunctions(ni1Var, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<? extends PropertyDescriptor> g(@NotNull ni1 ni1Var) {
            if (ni1Var == null) {
                a(4);
            }
            return i(ni1Var, h().getContributedVariables(ni1Var, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        @NotNull
        private MemberScope h() {
            MemberScope memberScope = this.d.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope == null) {
                a(9);
            }
            return memberScope;
        }

        @NotNull
        private <D extends CallableMemberDescriptor> Collection<? extends D> i(@NotNull ni1 ni1Var, @NotNull Collection<? extends D> collection) {
            if (ni1Var == null) {
                a(10);
            }
            if (collection == null) {
                a(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.DEFAULT.w(ni1Var, collection, Collections.emptySet(), this.d, new d(this, linkedHashSet));
            return linkedHashSet;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getClassifierNames() {
            Set<ni1> emptySet = Collections.emptySet();
            if (emptySet == null) {
                a(18);
            }
            return emptySet;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
            if (z60Var == null) {
                a(13);
            }
            if (function1 == null) {
                a(14);
            }
            Collection<DeclarationDescriptor> invoke = this.c.invoke();
            if (invoke == null) {
                a(15);
            }
            return invoke;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(5);
            }
            if (lookupLocation == null) {
                a(6);
            }
            Collection<? extends SimpleFunctionDescriptor> invoke = this.a.invoke(ni1Var);
            if (invoke == null) {
                a(7);
            }
            return invoke;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(1);
            }
            if (lookupLocation == null) {
                a(2);
            }
            Collection<? extends PropertyDescriptor> invoke = this.b.invoke(ni1Var);
            if (invoke == null) {
                a(3);
            }
            return invoke;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getFunctionNames() {
            Set<ni1> set = (Set) this.d.j.invoke();
            if (set == null) {
                a(17);
            }
            return set;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getVariableNames() {
            Set<ni1> set = (Set) this.d.j.invoke();
            if (set == null) {
                a(19);
            }
            return set;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private we0(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor, @NotNull z71 z71Var, @NotNull ni1 ni1Var, @NotNull NotNullLazyValue<Set<ni1>> notNullLazyValue, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        super(storageManager, classDescriptor, ni1Var, sourceElement, false);
        if (storageManager == null) {
            c(6);
        }
        if (classDescriptor == null) {
            c(7);
        }
        if (z71Var == null) {
            c(8);
        }
        if (ni1Var == null) {
            c(9);
        }
        if (notNullLazyValue == null) {
            c(10);
        }
        if (annotations == null) {
            c(11);
        }
        if (sourceElement == null) {
            c(12);
        }
        this.k = annotations;
        this.h = new lj(this, Collections.emptyList(), Collections.singleton(z71Var), storageManager);
        this.i = new a(this, storageManager);
        this.j = notNullLazyValue;
    }

    private static /* synthetic */ void c(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    public static we0 f(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor, @NotNull ni1 ni1Var, @NotNull NotNullLazyValue<Set<ni1>> notNullLazyValue, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (storageManager == null) {
            c(0);
        }
        if (classDescriptor == null) {
            c(1);
        }
        if (ni1Var == null) {
            c(2);
        }
        if (notNullLazyValue == null) {
            c(3);
        }
        if (annotations == null) {
            c(4);
        }
        if (sourceElement == null) {
            c(5);
        }
        return new we0(storageManager, classDescriptor, classDescriptor.getDefaultType(), ni1Var, notNullLazyValue, annotations, sourceElement);
    }

    @Override // tb.wg1
    @NotNull
    public MemberScope b(@NotNull b81 b81Var) {
        if (b81Var == null) {
            c(13);
        }
        MemberScope memberScope = this.i;
        if (memberScope == null) {
            c(14);
        }
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations = this.k;
        if (annotations == null) {
            c(21);
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            c(16);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            c(22);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public p21<fd2> getInlineClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            c(18);
        }
        return classKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            c(19);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            c(23);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope.b bVar = MemberScope.b.INSTANCE;
        if (bVar == null) {
            c(15);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.h;
        if (typeConstructor == null) {
            c(17);
        }
        return typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public f70 getVisibility() {
        f70 f70Var = e70.PUBLIC;
        if (f70Var == null) {
            c(20);
        }
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

    public String toString() {
        return "enum entry " + getName();
    }
}
