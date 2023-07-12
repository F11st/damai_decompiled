package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class t21 extends le1 {
    @NotNull
    private final MemberScope a;

    public t21(@NotNull MemberScope memberScope) {
        b41.i(memberScope, "workerScope");
        this.a = memberScope;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    /* renamed from: a */
    public List<ClassifierDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        List<ClassifierDescriptor> g;
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        z60 n = z60Var.n(z60.Companion.c());
        if (n == null) {
            g = kotlin.collections.m.g();
            return g;
        }
        Collection<DeclarationDescriptor> contributedDescriptors = this.a.getContributedDescriptors(n, function1);
        ArrayList arrayList = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<ni1> getClassifierNames() {
        return this.a.getClassifierNames();
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.a.getContributedClassifier(ni1Var, lookupLocation);
        if (contributedClassifier == null) {
            return null;
        }
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        if (classDescriptor == null) {
            if (contributedClassifier instanceof TypeAliasDescriptor) {
                return (TypeAliasDescriptor) contributedClassifier;
            }
            return null;
        }
        return classDescriptor;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getFunctionNames() {
        return this.a.getFunctionNames();
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getVariableNames() {
        return this.a.getVariableNames();
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        this.a.recordLookup(ni1Var, lookupLocation);
    }

    @NotNull
    public String toString() {
        return b41.r("Classes from ", this.a);
    }
}
