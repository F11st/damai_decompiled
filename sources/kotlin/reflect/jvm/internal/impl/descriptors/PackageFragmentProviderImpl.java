package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hp0;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    @NotNull
    private final Collection<PackageFragmentDescriptor> a;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(@NotNull Collection<? extends PackageFragmentDescriptor> collection) {
        b41.i(collection, "packageFragments");
        this.a = collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull hp0 hp0Var, @NotNull Collection<PackageFragmentDescriptor> collection) {
        b41.i(hp0Var, "fqName");
        b41.i(collection, "packageFragments");
        for (Object obj : this.a) {
            if (b41.d(((PackageFragmentDescriptor) obj).getFqName(), hp0Var)) {
                collection.add(obj);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        Collection<PackageFragmentDescriptor> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (b41.d(((PackageFragmentDescriptor) obj).getFqName(), hp0Var)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<hp0> getSubPackagesOf(@NotNull final hp0 hp0Var, @NotNull Function1<? super ni1, Boolean> function1) {
        Sequence I;
        Sequence v;
        Sequence o;
        b41.i(hp0Var, "fqName");
        b41.i(function1, "nameFilter");
        I = CollectionsKt___CollectionsKt.I(this.a);
        v = SequencesKt___SequencesKt.v(I, new Function1<PackageFragmentDescriptor, hp0>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl$getSubPackagesOf$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final hp0 invoke(@NotNull PackageFragmentDescriptor packageFragmentDescriptor) {
                b41.i(packageFragmentDescriptor, AdvanceSetting.NETWORK_TYPE);
                return packageFragmentDescriptor.getFqName();
            }
        });
        o = SequencesKt___SequencesKt.o(v, new Function1<hp0, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl$getSubPackagesOf$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull hp0 hp0Var2) {
                b41.i(hp0Var2, AdvanceSetting.NETWORK_TYPE);
                return Boolean.valueOf(!hp0Var2.d() && b41.d(hp0Var2.e(), hp0.this));
            }
        });
        return SequencesKt___SequencesKt.B(o);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        Collection<PackageFragmentDescriptor> collection = this.a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        for (PackageFragmentDescriptor packageFragmentDescriptor : collection) {
            if (b41.d(packageFragmentDescriptor.getFqName(), hp0Var)) {
                return false;
            }
        }
        return true;
    }
}
