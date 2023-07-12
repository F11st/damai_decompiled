package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.y60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class qi2 extends le1 {
    @NotNull
    private final ModuleDescriptor a;
    @NotNull
    private final hp0 b;

    public qi2(@NotNull ModuleDescriptor moduleDescriptor, @NotNull hp0 hp0Var) {
        b41.i(moduleDescriptor, "moduleDescriptor");
        b41.i(hp0Var, "fqName");
        this.a = moduleDescriptor;
        this.b = hp0Var;
    }

    @Nullable
    protected final PackageViewDescriptor a(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        if (ni1Var.g()) {
            return null;
        }
        ModuleDescriptor moduleDescriptor = this.a;
        hp0 c = this.b.c(ni1Var);
        b41.h(c, "fqName.child(name)");
        PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(c);
        if (packageViewDescriptor.isEmpty()) {
            return null;
        }
        return packageViewDescriptor;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getClassifierNames() {
        Set<ni1> d;
        d = kotlin.collections.e0.d();
        return d;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        List g;
        List g2;
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        if (!z60Var.a(z60.Companion.f())) {
            g2 = kotlin.collections.m.g();
            return g2;
        } else if (this.b.d() && z60Var.l().contains(y60.b.INSTANCE)) {
            g = kotlin.collections.m.g();
            return g;
        } else {
            Collection<hp0> subPackagesOf = this.a.getSubPackagesOf(this.b, function1);
            ArrayList arrayList = new ArrayList(subPackagesOf.size());
            for (hp0 hp0Var : subPackagesOf) {
                ni1 g3 = hp0Var.g();
                b41.h(g3, "subFqName.shortName()");
                if (function1.invoke(g3).booleanValue()) {
                    kk.a(arrayList, a(g3));
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public String toString() {
        return "subpackages of " + this.b + " from " + this.a;
    }
}
