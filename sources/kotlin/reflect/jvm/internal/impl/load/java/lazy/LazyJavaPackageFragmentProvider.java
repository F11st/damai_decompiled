package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.youku.arch.v3.data.Constants;
import java.util.Collection;
import java.util.List;
import kotlin.C8179c;
import kotlin.Lazy;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hp0;
import tb.kk;
import tb.n51;
import tb.ni1;
import tb.r81;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {
    @NotNull
    private final r81 a;
    @NotNull
    private final CacheWithNotNullValues<hp0, LazyJavaPackageFragment> b;

    public LazyJavaPackageFragmentProvider(@NotNull n51 n51Var) {
        Lazy c;
        b41.i(n51Var, Constants.COMPONENT);
        TypeParameterResolver.C8342a c8342a = TypeParameterResolver.C8342a.INSTANCE;
        c = C8179c.c(null);
        r81 r81Var = new r81(n51Var, c8342a, c);
        this.a = r81Var;
        this.b = r81Var.e().createCacheWithNotNullValues();
    }

    private final LazyJavaPackageFragment b(hp0 hp0Var) {
        final JavaPackage findPackage = this.a.a().d().findPackage(hp0Var);
        if (findPackage == null) {
            return null;
        }
        return this.b.computeIfAbsent(hp0Var, new Function0<LazyJavaPackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider$getPackageFragment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LazyJavaPackageFragment invoke() {
                r81 r81Var;
                r81Var = LazyJavaPackageFragmentProvider.this.a;
                return new LazyJavaPackageFragment(r81Var, findPackage);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    /* renamed from: c */
    public List<hp0> getSubPackagesOf(@NotNull hp0 hp0Var, @NotNull Function1<? super ni1, Boolean> function1) {
        List<hp0> g;
        b41.i(hp0Var, "fqName");
        b41.i(function1, "nameFilter");
        LazyJavaPackageFragment b = b(hp0Var);
        List<hp0> i = b == null ? null : b.i();
        if (i != null) {
            return i;
        }
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull hp0 hp0Var, @NotNull Collection<PackageFragmentDescriptor> collection) {
        b41.i(hp0Var, "fqName");
        b41.i(collection, "packageFragments");
        kk.a(collection, b(hp0Var));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<LazyJavaPackageFragment> getPackageFragments(@NotNull hp0 hp0Var) {
        List<LazyJavaPackageFragment> k;
        b41.i(hp0Var, "fqName");
        k = C8214m.k(b(hp0Var));
        return k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        return this.a.a().d().findPackage(hp0Var) == null;
    }

    @NotNull
    public String toString() {
        return b41.r("LazyJavaPackageFragmentProvider of module ", this.a.a().m());
    }
}
