package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.AbstractC5658c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.C8203e0;
import kotlin.collections.C8212k;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.C8220r;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a70;
import tb.b41;
import tb.ni1;
import tb.r81;
import tb.s81;
import tb.wt2;
import tb.x60;
import tb.yv2;
import tb.z60;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope extends s81 {
    @NotNull
    private final JavaClass m;
    @NotNull
    private final LazyJavaClassDescriptor n;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$a */
    /* loaded from: classes3.dex */
    public static final class C8353a extends DFS.AbstractC8561b<ClassDescriptor, wt2> {
        final /* synthetic */ ClassDescriptor a;
        final /* synthetic */ Set<R> b;
        final /* synthetic */ Function1<MemberScope, Collection<R>> c;

        /* JADX WARN: Multi-variable type inference failed */
        C8353a(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
            this.a = classDescriptor;
            this.b = set;
            this.c = function1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        /* renamed from: a */
        public boolean beforeChildren(@NotNull ClassDescriptor classDescriptor) {
            b41.i(classDescriptor, "current");
            if (classDescriptor == this.a) {
                return true;
            }
            MemberScope staticScope = classDescriptor.getStaticScope();
            b41.h(staticScope, "current.staticScope");
            if (staticScope instanceof s81) {
                this.b.addAll((Collection) this.c.invoke(staticScope));
                return false;
            }
            return true;
        }

        public void b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public /* bridge */ /* synthetic */ Object result() {
            b();
            return wt2.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope(@NotNull r81 r81Var, @NotNull JavaClass javaClass, @NotNull LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(r81Var);
        b41.i(r81Var, AbstractC5658c.a);
        b41.i(javaClass, "jClass");
        b41.i(lazyJavaClassDescriptor, "ownerDescriptor");
        this.m = javaClass;
        this.n = lazyJavaClassDescriptor;
    }

    private final <R> Set<R> G(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        List e;
        e = C8213l.e(classDescriptor);
        DFS.b(e, new DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            @NotNull
            /* renamed from: a */
            public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor2) {
                Sequence I;
                Sequence w;
                Iterable<ClassDescriptor> l;
                Collection<z71> supertypes = classDescriptor2.getTypeConstructor().getSupertypes();
                b41.h(supertypes, "it.typeConstructor.supertypes");
                I = CollectionsKt___CollectionsKt.I(supertypes);
                w = SequencesKt___SequencesKt.w(I, new Function1<z71, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1.1
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final ClassDescriptor invoke(z71 z71Var) {
                        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
                        if (declarationDescriptor instanceof ClassDescriptor) {
                            return (ClassDescriptor) declarationDescriptor;
                        }
                        return null;
                    }
                });
                l = SequencesKt___SequencesKt.l(w);
                return l;
            }
        }, new C8353a(classDescriptor, set, function1));
        return set;
    }

    private final PropertyDescriptor I(PropertyDescriptor propertyDescriptor) {
        int q;
        List K;
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        b41.h(overriddenDescriptors, "this.overriddenDescriptors");
        q = C8215n.q(overriddenDescriptors, 10);
        ArrayList arrayList = new ArrayList(q);
        for (PropertyDescriptor propertyDescriptor2 : overriddenDescriptors) {
            b41.h(propertyDescriptor2, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(I(propertyDescriptor2));
        }
        K = CollectionsKt___CollectionsKt.K(arrayList);
        return (PropertyDescriptor) C8212k.q0(K);
    }

    private final Set<SimpleFunctionDescriptor> J(ni1 ni1Var, ClassDescriptor classDescriptor) {
        Set<SimpleFunctionDescriptor> E0;
        Set<SimpleFunctionDescriptor> d;
        LazyJavaStaticClassScope b = yv2.b(classDescriptor);
        if (b == null) {
            d = C8203e0.d();
            return d;
        }
        E0 = CollectionsKt___CollectionsKt.E0(b.getContributedFunctions(ni1Var, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        return E0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    /* renamed from: F */
    public ClassDeclaredMemberIndex i() {
        return new ClassDeclaredMemberIndex(this.m, new Function1<JavaMember, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$computeMemberIndex$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull JavaMember javaMember) {
                b41.i(javaMember, AdvanceSetting.NETWORK_TYPE);
                return Boolean.valueOf(javaMember.isStatic());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    /* renamed from: H */
    public LazyJavaClassDescriptor v() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<ni1> e(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        Set<ni1> d;
        b41.i(z60Var, "kindFilter");
        d = C8203e0.d();
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<ni1> g(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        Set<ni1> D0;
        List j;
        b41.i(z60Var, "kindFilter");
        D0 = CollectionsKt___CollectionsKt.D0(r().invoke().getMethodNames());
        LazyJavaStaticClassScope b = yv2.b(v());
        Set<ni1> functionNames = b == null ? null : b.getFunctionNames();
        if (functionNames == null) {
            functionNames = C8203e0.d();
        }
        D0.addAll(functionNames);
        if (this.m.isEnum()) {
            j = C8214m.j(C8277c.ENUM_VALUE_OF, C8277c.ENUM_VALUES);
            D0.addAll(j);
        }
        D0.addAll(p().a().w().getStaticFunctionNames(v()));
        return D0;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void h(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull ni1 ni1Var) {
        b41.i(collection, "result");
        b41.i(ni1Var, "name");
        p().a().w().generateStaticFunctions(v(), ni1Var, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void k(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull ni1 ni1Var) {
        b41.i(collection, "result");
        b41.i(ni1Var, "name");
        Collection<? extends SimpleFunctionDescriptor> e = a70.e(ni1Var, J(ni1Var, v()), collection, v(), p().a().c(), p().a().k().getOverridingUtil());
        b41.h(e, "resolveOverridesForStati….overridingUtil\n        )");
        collection.addAll(e);
        if (this.m.isEnum()) {
            if (b41.d(ni1Var, C8277c.ENUM_VALUE_OF)) {
                SimpleFunctionDescriptor d = x60.d(v());
                b41.h(d, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(d);
            } else if (b41.d(ni1Var, C8277c.ENUM_VALUES)) {
                SimpleFunctionDescriptor e2 = x60.e(v());
                b41.h(e2, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.s81, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void l(@NotNull final ni1 ni1Var, @NotNull Collection<PropertyDescriptor> collection) {
        b41.i(ni1Var, "name");
        b41.i(collection, "result");
        Set G = G(v(), new LinkedHashSet(), new Function1<MemberScope, Collection<? extends PropertyDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<? extends PropertyDescriptor> invoke(@NotNull MemberScope memberScope) {
                b41.i(memberScope, AdvanceSetting.NETWORK_TYPE);
                return memberScope.getContributedVariables(ni1.this, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            }
        });
        if (!collection.isEmpty()) {
            Collection<? extends PropertyDescriptor> e = a70.e(ni1Var, G, collection, v(), p().a().c(), p().a().k().getOverridingUtil());
            b41.h(e, "resolveOverridesForStati…ingUtil\n                )");
            collection.addAll(e);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : G) {
            PropertyDescriptor I = I((PropertyDescriptor) obj);
            Object obj2 = linkedHashMap.get(I);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(I, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Collection e2 = a70.e(ni1Var, (Collection) entry.getValue(), collection, v(), p().a().c(), p().a().k().getOverridingUtil());
            b41.h(e2, "resolveOverridesForStati…ingUtil\n                )");
            C8220r.v(arrayList, e2);
        }
        collection.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<ni1> m(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        Set<ni1> D0;
        b41.i(z60Var, "kindFilter");
        D0 = CollectionsKt___CollectionsKt.D0(r().invoke().getFieldNames());
        G(v(), D0, new Function1<MemberScope, Collection<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$computePropertyNames$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<ni1> invoke(@NotNull MemberScope memberScope) {
                b41.i(memberScope, AdvanceSetting.NETWORK_TYPE);
                return memberScope.getVariableNames();
            }
        });
        return D0;
    }
}
