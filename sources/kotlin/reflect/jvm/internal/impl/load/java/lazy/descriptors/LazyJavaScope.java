package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import com.youku.arch.v3.event.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.bx1;
import tb.d70;
import tb.f70;
import tb.fn;
import tb.fr2;
import tb.hq2;
import tb.i21;
import tb.k50;
import tb.kk;
import tb.le1;
import tb.m51;
import tb.mf1;
import tb.mw2;
import tb.ni1;
import tb.q51;
import tb.q81;
import tb.r81;
import tb.tg2;
import tb.u51;
import tb.x60;
import tb.y60;
import tb.z60;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class LazyJavaScope extends le1 {
    static final /* synthetic */ KProperty<Object>[] l = {a12.i(new PropertyReference1Impl(a12.b(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), a12.i(new PropertyReference1Impl(a12.b(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), a12.i(new PropertyReference1Impl(a12.b(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    @NotNull
    private final r81 a;
    @Nullable
    private final LazyJavaScope b;
    @NotNull
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> c;
    @NotNull
    private final NotNullLazyValue<DeclaredMemberIndex> d;
    @NotNull
    private final MemoizedFunctionToNotNull<ni1, Collection<SimpleFunctionDescriptor>> e;
    @NotNull
    private final MemoizedFunctionToNullable<ni1, PropertyDescriptor> f;
    @NotNull
    private final MemoizedFunctionToNotNull<ni1, Collection<SimpleFunctionDescriptor>> g;
    @NotNull
    private final NotNullLazyValue h;
    @NotNull
    private final NotNullLazyValue i;
    @NotNull
    private final NotNullLazyValue j;
    @NotNull
    private final MemoizedFunctionToNotNull<ni1, List<PropertyDescriptor>> k;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    protected static final class a {
        @NotNull
        private final z71 a;
        @Nullable
        private final z71 b;
        @NotNull
        private final List<ValueParameterDescriptor> c;
        @NotNull
        private final List<TypeParameterDescriptor> d;
        private final boolean e;
        @NotNull
        private final List<String> f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull z71 z71Var, @Nullable z71 z71Var2, @NotNull List<? extends ValueParameterDescriptor> list, @NotNull List<? extends TypeParameterDescriptor> list2, boolean z, @NotNull List<String> list3) {
            b41.i(z71Var, "returnType");
            b41.i(list, "valueParameters");
            b41.i(list2, "typeParameters");
            b41.i(list3, "errors");
            this.a = z71Var;
            this.b = z71Var2;
            this.c = list;
            this.d = list2;
            this.e = z;
            this.f = list3;
        }

        @NotNull
        public final List<String> a() {
            return this.f;
        }

        public final boolean b() {
            return this.e;
        }

        @Nullable
        public final z71 c() {
            return this.b;
        }

        @NotNull
        public final z71 d() {
            return this.a;
        }

        @NotNull
        public final List<TypeParameterDescriptor> e() {
            return this.d;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return b41.d(this.a, aVar.a) && b41.d(this.b, aVar.b) && b41.d(this.c, aVar.c) && b41.d(this.d, aVar.d) && this.e == aVar.e && b41.d(this.f, aVar.f);
            }
            return false;
        }

        @NotNull
        public final List<ValueParameterDescriptor> f() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            z71 z71Var = this.b;
            int hashCode2 = (((((hashCode + (z71Var == null ? 0 : z71Var.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            boolean z = this.e;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode2 + i) * 31) + this.f.hashCode();
        }

        @NotNull
        public String toString() {
            return "MethodSignatureData(returnType=" + this.a + ", receiverType=" + this.b + ", valueParameters=" + this.c + ", typeParameters=" + this.d + ", hasStableParameterNames=" + this.e + ", errors=" + this.f + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b {
        @NotNull
        private final List<ValueParameterDescriptor> a;
        private final boolean b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull List<? extends ValueParameterDescriptor> list, boolean z) {
            b41.i(list, "descriptors");
            this.a = list;
            this.b = z;
        }

        @NotNull
        public final List<ValueParameterDescriptor> a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public /* synthetic */ LazyJavaScope(r81 r81Var, LazyJavaScope lazyJavaScope, int i, k50 k50Var) {
        this(r81Var, (i & 2) != 0 ? null : lazyJavaScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PropertyDescriptor C(final JavaField javaField) {
        List<? extends TypeParameterDescriptor> g;
        final bx1 n = n(javaField);
        n.o(null, null, null, null);
        z71 x = x(javaField);
        g = m.g();
        n.t(x, g, s(), null);
        if (d70.K(n, n.getType())) {
            n.e(this.a.e().createNullableLazyValue(new Function0<fn<?>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$resolveProperty$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final fn<?> invoke() {
                    return LazyJavaScope.this.p().a().g().getInitializerConstant(javaField, n);
                }
            }));
        }
        this.a.a().h().recordField(javaField, n);
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Set<SimpleFunctionDescriptor> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String c = mf1.c((SimpleFunctionDescriptor) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(c);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(c, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection<? extends SimpleFunctionDescriptor> a2 = OverridingUtilsKt.a(list, new Function1<SimpleFunctionDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CallableDescriptor invoke(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
                        b41.i(simpleFunctionDescriptor, "$this$selectMostSpecificInEachOverridableGroup");
                        return simpleFunctionDescriptor;
                    }
                });
                set.removeAll(list);
                set.addAll(a2);
            }
        }
    }

    private final bx1 n(JavaField javaField) {
        m51 v = m51.v(v(), q81.a(this.a, javaField), Modality.FINAL, mw2.a(javaField.getVisibility()), !javaField.isFinal(), javaField.getName(), this.a.a().t().source(javaField), y(javaField));
        b41.h(v, "create(\n            owne…d.isFinalStatic\n        )");
        return v;
    }

    private final Set<ni1> q() {
        return (Set) tg2.a(this.j, this, l[2]);
    }

    private final Set<ni1> t() {
        return (Set) tg2.a(this.h, this, l[0]);
    }

    private final Set<ni1> w() {
        return (Set) tg2.a(this.i, this, l[1]);
    }

    private final z71 x(JavaField javaField) {
        boolean z = false;
        z71 o = this.a.g().o(javaField.getType(), u51.d(TypeUsage.COMMON, false, null, 3, null));
        if ((kotlin.reflect.jvm.internal.impl.builtins.b.q0(o) || kotlin.reflect.jvm.internal.impl.builtins.b.t0(o)) && y(javaField) && javaField.getHasConstantNotNullInitializer()) {
            z = true;
        }
        if (z) {
            z71 o2 = fr2.o(o);
            b41.h(o2, "makeNotNullable(propertyType)");
            return o2;
        }
        return o;
    }

    private final boolean y(JavaField javaField) {
        return javaField.isFinal() && javaField.isStatic();
    }

    @NotNull
    protected abstract a A(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull z71 z71Var, @NotNull List<? extends ValueParameterDescriptor> list2);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final JavaMethodDescriptor B(@NotNull JavaMethod javaMethod) {
        int q;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> i;
        b41.i(javaMethod, "method");
        JavaMethodDescriptor J = JavaMethodDescriptor.J(v(), q81.a(this.a, javaMethod), javaMethod.getName(), this.a.a().t().source(javaMethod), this.d.invoke().findRecordComponentByName(javaMethod.getName()) != null && javaMethod.getValueParameters().isEmpty());
        b41.h(J, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        r81 f = ContextKt.f(this.a, J, javaMethod, 0, 4, null);
        List<JavaTypeParameter> typeParameters = javaMethod.getTypeParameters();
        q = n.q(typeParameters, 10);
        List<? extends TypeParameterDescriptor> arrayList = new ArrayList<>(q);
        for (JavaTypeParameter javaTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = f.f().resolveTypeParameter(javaTypeParameter);
            b41.f(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        b D = D(f, J, javaMethod.getValueParameters());
        a A = A(javaMethod, arrayList, j(javaMethod, f), D.a());
        z71 c = A.c();
        ReceiverParameterDescriptor f2 = c == null ? null : x60.f(J, c, Annotations.Companion.b());
        ReceiverParameterDescriptor s = s();
        List<TypeParameterDescriptor> e = A.e();
        List<ValueParameterDescriptor> f3 = A.f();
        z71 d = A.d();
        Modality a2 = Modality.Companion.a(false, javaMethod.isAbstract(), !javaMethod.isFinal());
        f70 a3 = mw2.a(javaMethod.getVisibility());
        if (A.c() != null) {
            i = w.f(hq2.a(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, k.P(D.a())));
        } else {
            i = x.i();
        }
        J.I(f2, s, e, f3, d, a2, a3, i);
        J.M(A.b(), D.b());
        if (!A.a().isEmpty()) {
            f.a().s().reportSignatureErrors(J, A.a());
        }
        return J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final b D(@NotNull r81 r81Var, @NotNull FunctionDescriptor functionDescriptor, @NotNull List<? extends JavaValueParameter> list) {
        Iterable<i21> G0;
        int q;
        List A0;
        Pair a2;
        ni1 name;
        r81 r81Var2 = r81Var;
        b41.i(r81Var2, c.a);
        b41.i(functionDescriptor, Subject.FUNCTION);
        b41.i(list, "jValueParameters");
        G0 = CollectionsKt___CollectionsKt.G0(list);
        q = n.q(G0, 10);
        ArrayList arrayList = new ArrayList(q);
        boolean z = false;
        boolean z2 = false;
        for (i21 i21Var : G0) {
            int a3 = i21Var.a();
            JavaValueParameter javaValueParameter = (JavaValueParameter) i21Var.b();
            Annotations a4 = q81.a(r81Var2, javaValueParameter);
            q51 d = u51.d(TypeUsage.COMMON, z, null, 3, null);
            if (javaValueParameter.isVararg()) {
                JavaType type = javaValueParameter.getType();
                JavaArrayType javaArrayType = type instanceof JavaArrayType ? (JavaArrayType) type : null;
                if (javaArrayType != null) {
                    z71 k = r81Var.g().k(javaArrayType, d, true);
                    a2 = hq2.a(k, r81Var.d().getBuiltIns().k(k));
                } else {
                    throw new AssertionError(b41.r("Vararg parameter should be an array: ", javaValueParameter));
                }
            } else {
                a2 = hq2.a(r81Var.g().o(javaValueParameter.getType(), d), null);
            }
            z71 z71Var = (z71) a2.component1();
            z71 z71Var2 = (z71) a2.component2();
            if (b41.d(functionDescriptor.getName().b(), "equals") && list.size() == 1 && b41.d(r81Var.d().getBuiltIns().I(), z71Var)) {
                name = ni1.f("other");
            } else {
                name = javaValueParameter.getName();
                if (name == null) {
                    z2 = true;
                }
                if (name == null) {
                    name = ni1.f(b41.r("p", Integer.valueOf(a3)));
                    b41.h(name, "identifier(\"p$index\")");
                }
            }
            ni1 ni1Var = name;
            b41.h(ni1Var, "if (function.name.asStri…(\"p$index\")\n            }");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ValueParameterDescriptorImpl(functionDescriptor, null, a3, a4, ni1Var, z71Var, false, false, false, z71Var2, r81Var.a().t().source(javaValueParameter)));
            arrayList = arrayList2;
            z2 = z2;
            z = false;
            r81Var2 = r81Var;
        }
        A0 = CollectionsKt___CollectionsKt.A0(arrayList);
        return new b(A0, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Set<ni1> e(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<DeclarationDescriptor> f(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        List<DeclarationDescriptor> A0;
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z60Var.a(z60.Companion.c())) {
            for (ni1 ni1Var : e(z60Var, function1)) {
                if (function1.invoke(ni1Var).booleanValue()) {
                    kk.a(linkedHashSet, getContributedClassifier(ni1Var, noLookupLocation));
                }
            }
        }
        if (z60Var.a(z60.Companion.d()) && !z60Var.l().contains(y60.a.INSTANCE)) {
            for (ni1 ni1Var2 : g(z60Var, function1)) {
                if (function1.invoke(ni1Var2).booleanValue()) {
                    linkedHashSet.addAll(getContributedFunctions(ni1Var2, noLookupLocation));
                }
            }
        }
        if (z60Var.a(z60.Companion.i()) && !z60Var.l().contains(y60.a.INSTANCE)) {
            for (ni1 ni1Var3 : m(z60Var, function1)) {
                if (function1.invoke(ni1Var3).booleanValue()) {
                    linkedHashSet.addAll(getContributedVariables(ni1Var3, noLookupLocation));
                }
            }
        }
        A0 = CollectionsKt___CollectionsKt.A0(linkedHashSet);
        return A0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Set<ni1> g(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1);

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getClassifierNames() {
        return q();
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        return this.c.invoke();
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        List g;
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        if (getFunctionNames().contains(ni1Var)) {
            return this.g.invoke(ni1Var);
        }
        g = m.g();
        return g;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        List g;
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        if (getVariableNames().contains(ni1Var)) {
            return this.k.invoke(ni1Var);
        }
        g = m.g();
        return g;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getFunctionNames() {
        return t();
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getVariableNames() {
        return w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull ni1 ni1Var) {
        b41.i(collection, "result");
        b41.i(ni1Var, "name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract DeclaredMemberIndex i();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final z71 j(@NotNull JavaMethod javaMethod, @NotNull r81 r81Var) {
        b41.i(javaMethod, "method");
        b41.i(r81Var, c.a);
        return r81Var.g().o(javaMethod.getReturnType(), u51.d(TypeUsage.COMMON, javaMethod.getContainingClass().isAnnotationType(), null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void k(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull ni1 ni1Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void l(@NotNull ni1 ni1Var, @NotNull Collection<PropertyDescriptor> collection);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Set<ni1> m(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> o() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final r81 p() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final NotNullLazyValue<DeclaredMemberIndex> r() {
        return this.d;
    }

    @Nullable
    protected abstract ReceiverParameterDescriptor s();

    @NotNull
    public String toString() {
        return b41.r("Lazy scope for ", v());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final LazyJavaScope u() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract DeclarationDescriptor v();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        b41.i(javaMethodDescriptor, "<this>");
        return true;
    }

    public LazyJavaScope(@NotNull r81 r81Var, @Nullable LazyJavaScope lazyJavaScope) {
        List g;
        b41.i(r81Var, c.a);
        this.a = r81Var;
        this.b = lazyJavaScope;
        StorageManager e = r81Var.e();
        Function0<Collection<? extends DeclarationDescriptor>> function0 = new Function0<Collection<? extends DeclarationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$allDescriptors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Collection<? extends DeclarationDescriptor> invoke() {
                return LazyJavaScope.this.f(z60.ALL, MemberScope.Companion.a());
            }
        };
        g = m.g();
        this.c = e.createRecursionTolerantLazyValue(function0, g);
        this.d = r81Var.e().createLazyValue(new Function0<DeclaredMemberIndex>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$declaredMemberIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DeclaredMemberIndex invoke() {
                return LazyJavaScope.this.i();
            }
        });
        this.e = r81Var.e().createMemoizedFunction(new Function1<ni1, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$declaredFunctions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull ni1 ni1Var) {
                MemoizedFunctionToNotNull memoizedFunctionToNotNull;
                b41.i(ni1Var, "name");
                if (LazyJavaScope.this.u() != null) {
                    memoizedFunctionToNotNull = LazyJavaScope.this.u().e;
                    return (Collection) memoizedFunctionToNotNull.invoke(ni1Var);
                }
                ArrayList arrayList = new ArrayList();
                for (JavaMethod javaMethod : LazyJavaScope.this.r().invoke().findMethodsByName(ni1Var)) {
                    JavaMethodDescriptor B = LazyJavaScope.this.B(javaMethod);
                    if (LazyJavaScope.this.z(B)) {
                        LazyJavaScope.this.p().a().h().recordMethod(javaMethod, B);
                        arrayList.add(B);
                    }
                }
                LazyJavaScope.this.h(arrayList, ni1Var);
                return arrayList;
            }
        });
        this.f = r81Var.e().createMemoizedFunctionWithNullableValues(new Function1<ni1, PropertyDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$declaredField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final PropertyDescriptor invoke(@NotNull ni1 ni1Var) {
                PropertyDescriptor C;
                MemoizedFunctionToNullable memoizedFunctionToNullable;
                b41.i(ni1Var, "name");
                if (LazyJavaScope.this.u() != null) {
                    memoizedFunctionToNullable = LazyJavaScope.this.u().f;
                    return (PropertyDescriptor) memoizedFunctionToNullable.invoke(ni1Var);
                }
                JavaField findFieldByName = LazyJavaScope.this.r().invoke().findFieldByName(ni1Var);
                if (findFieldByName == null || findFieldByName.isEnumEntry()) {
                    return null;
                }
                C = LazyJavaScope.this.C(findFieldByName);
                return C;
            }
        });
        this.g = r81Var.e().createMemoizedFunction(new Function1<ni1, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$functions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull ni1 ni1Var) {
                MemoizedFunctionToNotNull memoizedFunctionToNotNull;
                List A0;
                b41.i(ni1Var, "name");
                memoizedFunctionToNotNull = LazyJavaScope.this.e;
                LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) memoizedFunctionToNotNull.invoke(ni1Var));
                LazyJavaScope.this.E(linkedHashSet);
                LazyJavaScope.this.k(linkedHashSet, ni1Var);
                A0 = CollectionsKt___CollectionsKt.A0(LazyJavaScope.this.p().a().r().e(LazyJavaScope.this.p(), linkedHashSet));
                return A0;
            }
        });
        this.h = r81Var.e().createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$functionNamesLazy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends ni1> invoke() {
                return LazyJavaScope.this.g(z60.FUNCTIONS, null);
            }
        });
        this.i = r81Var.e().createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$propertyNamesLazy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends ni1> invoke() {
                return LazyJavaScope.this.m(z60.VARIABLES, null);
            }
        });
        this.j = r81Var.e().createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$classNamesLazy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends ni1> invoke() {
                return LazyJavaScope.this.e(z60.CLASSIFIERS, null);
            }
        });
        this.k = r81Var.e().createMemoizedFunction(new Function1<ni1, List<? extends PropertyDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$properties$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<PropertyDescriptor> invoke(@NotNull ni1 ni1Var) {
                MemoizedFunctionToNullable memoizedFunctionToNullable;
                List<PropertyDescriptor> A0;
                List<PropertyDescriptor> A02;
                b41.i(ni1Var, "name");
                ArrayList arrayList = new ArrayList();
                memoizedFunctionToNullable = LazyJavaScope.this.f;
                kk.a(arrayList, memoizedFunctionToNullable.invoke(ni1Var));
                LazyJavaScope.this.l(ni1Var, arrayList);
                if (d70.t(LazyJavaScope.this.v())) {
                    A02 = CollectionsKt___CollectionsKt.A0(arrayList);
                    return A02;
                }
                A0 = CollectionsKt___CollectionsKt.A0(LazyJavaScope.this.p().a().r().e(LazyJavaScope.this.p(), arrayList));
                return A0;
            }
        });
    }
}
