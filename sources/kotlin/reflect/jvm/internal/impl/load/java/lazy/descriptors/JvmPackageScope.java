package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.e0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.i62;
import tb.me1;
import tb.ni1;
import tb.ow2;
import tb.r81;
import tb.tg2;
import tb.z60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] e = {a12.i(new PropertyReference1Impl(a12.b(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @NotNull
    private final r81 a;
    @NotNull
    private final LazyJavaPackageFragment b;
    @NotNull
    private final LazyJavaPackageScope c;
    @NotNull
    private final NotNullLazyValue d;

    public JvmPackageScope(@NotNull r81 r81Var, @NotNull JavaPackage javaPackage, @NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        b41.i(r81Var, c.a);
        b41.i(javaPackage, "jPackage");
        b41.i(lazyJavaPackageFragment, "packageFragment");
        this.a = r81Var;
        this.b = lazyJavaPackageFragment;
        this.c = new LazyJavaPackageScope(r81Var, javaPackage, lazyJavaPackageFragment);
        this.d = r81Var.e().createLazyValue(new Function0<MemberScope[]>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope$kotlinScopes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemberScope[] invoke() {
                LazyJavaPackageFragment lazyJavaPackageFragment2;
                r81 r81Var2;
                LazyJavaPackageFragment lazyJavaPackageFragment3;
                lazyJavaPackageFragment2 = JvmPackageScope.this.b;
                Collection<KotlinJvmBinaryClass> values = lazyJavaPackageFragment2.g().values();
                JvmPackageScope jvmPackageScope = JvmPackageScope.this;
                ArrayList arrayList = new ArrayList();
                for (KotlinJvmBinaryClass kotlinJvmBinaryClass : values) {
                    r81Var2 = jvmPackageScope.a;
                    DeserializedDescriptorResolver b = r81Var2.a().b();
                    lazyJavaPackageFragment3 = jvmPackageScope.b;
                    MemberScope c = b.c(lazyJavaPackageFragment3, kotlinJvmBinaryClass);
                    if (c != null) {
                        arrayList.add(c);
                    }
                }
                Object[] array = i62.b(arrayList).toArray(new MemberScope[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                return (MemberScope[]) array;
            }
        });
    }

    private final MemberScope[] d() {
        return (MemberScope[]) tg2.a(this.d, this, e[0]);
    }

    @NotNull
    public final LazyJavaPackageScope c() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<ni1> getClassifierNames() {
        Iterable n;
        n = ArraysKt___ArraysKt.n(d());
        Set<ni1> a = me1.a(n);
        if (a == null) {
            return null;
        }
        a.addAll(c().getClassifierNames());
        return a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        recordLookup(ni1Var, lookupLocation);
        ClassDescriptor contributedClassifier = this.c.getContributedClassifier(ni1Var, lookupLocation);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        MemberScope[] d = d();
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        int length = d.length;
        while (i < length) {
            MemberScope memberScope = d[i];
            i++;
            ClassifierDescriptor contributedClassifier2 = memberScope.getContributedClassifier(ni1Var, lookupLocation);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        Set d;
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] d2 = d();
        Collection<DeclarationDescriptor> contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(z60Var, function1);
        int length = d2.length;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = d2[i];
            i++;
            contributedDescriptors = i62.a(contributedDescriptors, memberScope.getContributedDescriptors(z60Var, function1));
        }
        if (contributedDescriptors == null) {
            d = e0.d();
            return d;
        }
        return contributedDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        Set d;
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        recordLookup(ni1Var, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] d2 = d();
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = lazyJavaPackageScope.getContributedFunctions(ni1Var, lookupLocation);
        int length = d2.length;
        int i = 0;
        Collection collection = contributedFunctions;
        while (i < length) {
            MemberScope memberScope = d2[i];
            i++;
            collection = i62.a(collection, memberScope.getContributedFunctions(ni1Var, lookupLocation));
        }
        if (collection == null) {
            d = e0.d();
            return d;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        Set d;
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        recordLookup(ni1Var, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] d2 = d();
        Collection<? extends PropertyDescriptor> contributedVariables = lazyJavaPackageScope.getContributedVariables(ni1Var, lookupLocation);
        int length = d2.length;
        int i = 0;
        Collection collection = contributedVariables;
        while (i < length) {
            MemberScope memberScope = d2[i];
            i++;
            collection = i62.a(collection, memberScope.getContributedVariables(ni1Var, lookupLocation));
        }
        if (collection == null) {
            d = e0.d();
            return d;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getFunctionNames() {
        MemberScope[] d = d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : d) {
            r.v(linkedHashSet, memberScope.getFunctionNames());
        }
        linkedHashSet.addAll(c().getFunctionNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getVariableNames() {
        MemberScope[] d = d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : d) {
            r.v(linkedHashSet, memberScope.getVariableNames());
        }
        linkedHashSet.addAll(c().getVariableNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        ow2.b(this.a.a().l(), lookupLocation, this.b, ni1Var);
    }

    @NotNull
    public String toString() {
        return b41.r("scope for ", this.b);
    }
}
