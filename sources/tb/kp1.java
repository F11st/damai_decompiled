package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class kp1 {
    public static final void a(@NotNull PackageFragmentProvider packageFragmentProvider, @NotNull hp0 hp0Var, @NotNull Collection<PackageFragmentDescriptor> collection) {
        b41.i(packageFragmentProvider, "<this>");
        b41.i(hp0Var, "fqName");
        b41.i(collection, "packageFragments");
        if (packageFragmentProvider instanceof PackageFragmentProviderOptimized) {
            ((PackageFragmentProviderOptimized) packageFragmentProvider).collectPackageFragments(hp0Var, collection);
        } else {
            collection.addAll(packageFragmentProvider.getPackageFragments(hp0Var));
        }
    }

    public static final boolean b(@NotNull PackageFragmentProvider packageFragmentProvider, @NotNull hp0 hp0Var) {
        b41.i(packageFragmentProvider, "<this>");
        b41.i(hp0Var, "fqName");
        return packageFragmentProvider instanceof PackageFragmentProviderOptimized ? ((PackageFragmentProviderOptimized) packageFragmentProvider).isEmpty(hp0Var) : c(packageFragmentProvider, hp0Var).isEmpty();
    }

    @NotNull
    public static final List<PackageFragmentDescriptor> c(@NotNull PackageFragmentProvider packageFragmentProvider, @NotNull hp0 hp0Var) {
        b41.i(packageFragmentProvider, "<this>");
        b41.i(hp0Var, "fqName");
        ArrayList arrayList = new ArrayList();
        a(packageFragmentProvider, hp0Var, arrayList);
        return arrayList;
    }
}
