package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.br2;
import tb.kk;
import tb.ni1;
import tb.z60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SubstitutingScope implements MemberScope {
    @NotNull
    private final MemberScope a;
    @NotNull
    private final TypeSubstitutor b;
    @Nullable
    private Map<DeclarationDescriptor, DeclarationDescriptor> c;
    @NotNull
    private final Lazy d;

    public SubstitutingScope(@NotNull MemberScope memberScope, @NotNull TypeSubstitutor typeSubstitutor) {
        Lazy b;
        b41.i(memberScope, "workerScope");
        b41.i(typeSubstitutor, "givenSubstitutor");
        this.a = memberScope;
        br2 j = typeSubstitutor.j();
        b41.h(j, "givenSubstitutor.substitution");
        this.b = CapturedTypeConstructorKt.f(j, false, 1, null).c();
        b = b.b(new Function0<Collection<? extends DeclarationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope$_allDescriptors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Collection<? extends DeclarationDescriptor> invoke() {
                MemberScope memberScope2;
                Collection<? extends DeclarationDescriptor> d;
                SubstitutingScope substitutingScope = SubstitutingScope.this;
                memberScope2 = substitutingScope.a;
                d = substitutingScope.d(ResolutionScope.a.a(memberScope2, null, null, 3, null));
                return d;
            }
        });
        this.d = b;
    }

    private final Collection<DeclarationDescriptor> c() {
        return (Collection) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends DeclarationDescriptor> Collection<D> d(Collection<? extends D> collection) {
        if (this.b.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet g = kk.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            g.add(e((DeclarationDescriptor) it.next()));
        }
        return g;
    }

    private final <D extends DeclarationDescriptor> D e(D d) {
        if (this.b.k()) {
            return d;
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.c;
        b41.f(map);
        DeclarationDescriptor declarationDescriptor = map.get(d);
        if (declarationDescriptor == null) {
            if (!(d instanceof Substitutable)) {
                throw new IllegalStateException(b41.r("Unknown descriptor in scope: ", d).toString());
            }
            declarationDescriptor = ((Substitutable) d).substitute(this.b);
            if (declarationDescriptor != null) {
                map.put(d, declarationDescriptor);
            } else {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
            }
        }
        return (D) declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<ni1> getClassifierNames() {
        return this.a.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.a.getContributedClassifier(ni1Var, lookupLocation);
        if (contributedClassifier == null) {
            return null;
        }
        return (ClassifierDescriptor) e(contributedClassifier);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        return c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return d(this.a.getContributedFunctions(ni1Var, lookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return d(this.a.getContributedVariables(ni1Var, lookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getFunctionNames() {
        return this.a.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getVariableNames() {
        return this.a.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        MemberScope.a.a(this, ni1Var, lookupLocation);
    }
}
