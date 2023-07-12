package tb;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.C8203e0;
import kotlin.collections.C8214m;
import kotlin.collections.C8220r;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class lh implements MemberScope {
    @NotNull
    public static final C9410a Companion = new C9410a(null);
    @NotNull
    private final String a;
    @NotNull
    private final MemberScope[] b;

    /* compiled from: Taobao */
    /* renamed from: tb.lh$a */
    /* loaded from: classes3.dex */
    public static final class C9410a {
        private C9410a() {
        }

        public /* synthetic */ C9410a(k50 k50Var) {
            this();
        }

        @NotNull
        public final MemberScope a(@NotNull String str, @NotNull Iterable<? extends MemberScope> iterable) {
            b41.i(str, "debugName");
            b41.i(iterable, "scopes");
            xd2 xd2Var = new xd2();
            for (MemberScope memberScope : iterable) {
                if (memberScope != MemberScope.C8499b.INSTANCE) {
                    if (memberScope instanceof lh) {
                        C8220r.w(xd2Var, ((lh) memberScope).b);
                    } else {
                        xd2Var.add(memberScope);
                    }
                }
            }
            return b(str, xd2Var);
        }

        @NotNull
        public final MemberScope b(@NotNull String str, @NotNull List<? extends MemberScope> list) {
            b41.i(str, "debugName");
            b41.i(list, "scopes");
            int size = list.size();
            if (size != 0) {
                if (size != 1) {
                    Object[] array = list.toArray(new MemberScope[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return new lh(str, (MemberScope[]) array, null);
                }
                return list.get(0);
            }
            return MemberScope.C8499b.INSTANCE;
        }
    }

    private lh(String str, MemberScope[] memberScopeArr) {
        this.a = str;
        this.b = memberScopeArr;
    }

    public /* synthetic */ lh(String str, MemberScope[] memberScopeArr, k50 k50Var) {
        this(str, memberScopeArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<ni1> getClassifierNames() {
        Iterable n;
        n = ArraysKt___ArraysKt.n(this.b);
        return me1.a(n);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(ni1Var, lookupLocation);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        List g;
        Set d;
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            g = C8214m.g();
            return g;
        }
        int i = 0;
        if (length != 1) {
            Collection<DeclarationDescriptor> collection = null;
            int length2 = memberScopeArr.length;
            while (i < length2) {
                MemberScope memberScope = memberScopeArr[i];
                i++;
                collection = i62.a(collection, memberScope.getContributedDescriptors(z60Var, function1));
            }
            if (collection == null) {
                d = C8203e0.d();
                return d;
            }
            return collection;
        }
        return memberScopeArr[0].getContributedDescriptors(z60Var, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        List g;
        Set d;
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            g = C8214m.g();
            return g;
        }
        int i = 0;
        if (length != 1) {
            Collection<SimpleFunctionDescriptor> collection = null;
            int length2 = memberScopeArr.length;
            while (i < length2) {
                MemberScope memberScope = memberScopeArr[i];
                i++;
                collection = i62.a(collection, memberScope.getContributedFunctions(ni1Var, lookupLocation));
            }
            if (collection == null) {
                d = C8203e0.d();
                return d;
            }
            return collection;
        }
        return memberScopeArr[0].getContributedFunctions(ni1Var, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        List g;
        Set d;
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            g = C8214m.g();
            return g;
        }
        int i = 0;
        if (length != 1) {
            Collection<PropertyDescriptor> collection = null;
            int length2 = memberScopeArr.length;
            while (i < length2) {
                MemberScope memberScope = memberScopeArr[i];
                i++;
                collection = i62.a(collection, memberScope.getContributedVariables(ni1Var, lookupLocation));
            }
            if (collection == null) {
                d = C8203e0.d();
                return d;
            }
            return collection;
        }
        return memberScopeArr[0].getContributedVariables(ni1Var, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getFunctionNames() {
        MemberScope[] memberScopeArr = this.b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            C8220r.v(linkedHashSet, memberScope.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getVariableNames() {
        MemberScope[] memberScopeArr = this.b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            C8220r.v(linkedHashSet, memberScope.getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        for (MemberScope memberScope : this.b) {
            memberScope.recordLookup(ni1Var, lookupLocation);
        }
    }

    @NotNull
    public String toString() {
        return this.a;
    }
}
