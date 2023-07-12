package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class km implements PackageFragmentProviderOptimized {
    @NotNull
    private final List<PackageFragmentProvider> a;
    @NotNull
    private final String b;

    /* JADX WARN: Multi-variable type inference failed */
    public km(@NotNull List<? extends PackageFragmentProvider> list, @NotNull String str) {
        Set E0;
        b41.i(list, "providers");
        b41.i(str, "debugName");
        this.a = list;
        this.b = str;
        list.size();
        E0 = CollectionsKt___CollectionsKt.E0(list);
        E0.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull hp0 hp0Var, @NotNull Collection<PackageFragmentDescriptor> collection) {
        b41.i(hp0Var, "fqName");
        b41.i(collection, "packageFragments");
        for (PackageFragmentProvider packageFragmentProvider : this.a) {
            kp1.a(packageFragmentProvider, hp0Var, collection);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull hp0 hp0Var) {
        List<PackageFragmentDescriptor> A0;
        b41.i(hp0Var, "fqName");
        ArrayList arrayList = new ArrayList();
        for (PackageFragmentProvider packageFragmentProvider : this.a) {
            kp1.a(packageFragmentProvider, hp0Var, arrayList);
        }
        A0 = CollectionsKt___CollectionsKt.A0(arrayList);
        return A0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<hp0> getSubPackagesOf(@NotNull hp0 hp0Var, @NotNull Function1<? super ni1, Boolean> function1) {
        b41.i(hp0Var, "fqName");
        b41.i(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        for (PackageFragmentProvider packageFragmentProvider : this.a) {
            hashSet.addAll(packageFragmentProvider.getSubPackagesOf(hp0Var, function1));
        }
        return hashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        List<PackageFragmentProvider> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (PackageFragmentProvider packageFragmentProvider : list) {
            if (!kp1.b(packageFragmentProvider, hp0Var)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public String toString() {
        return this.b;
    }
}
