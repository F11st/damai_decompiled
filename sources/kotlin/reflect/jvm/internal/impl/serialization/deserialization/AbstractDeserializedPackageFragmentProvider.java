package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.youku.arch.v3.data.Constants;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.C8203e0;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.h70;
import tb.hp0;
import tb.kk;
import tb.n70;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final KotlinMetadataFinder b;
    @NotNull
    private final ModuleDescriptor c;
    protected h70 d;
    @NotNull
    private final MemoizedFunctionToNullable<hp0, PackageFragmentDescriptor> e;

    public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull KotlinMetadataFinder kotlinMetadataFinder, @NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(storageManager, "storageManager");
        b41.i(kotlinMetadataFinder, "finder");
        b41.i(moduleDescriptor, "moduleDescriptor");
        this.a = storageManager;
        this.b = kotlinMetadataFinder;
        this.c = moduleDescriptor;
        this.e = storageManager.createMemoizedFunctionWithNullableValues(new Function1<hp0, PackageFragmentDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider$fragments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final PackageFragmentDescriptor invoke(@NotNull hp0 hp0Var) {
                b41.i(hp0Var, "fqName");
                n70 a = AbstractDeserializedPackageFragmentProvider.this.a(hp0Var);
                if (a == null) {
                    return null;
                }
                a.f(AbstractDeserializedPackageFragmentProvider.this.b());
                return a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract n70 a(@NotNull hp0 hp0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final h70 b() {
        h70 h70Var = this.d;
        if (h70Var != null) {
            return h70Var;
        }
        b41.A(Constants.COMPONENT);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final KotlinMetadataFinder c() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull hp0 hp0Var, @NotNull Collection<PackageFragmentDescriptor> collection) {
        b41.i(hp0Var, "fqName");
        b41.i(collection, "packageFragments");
        kk.a(collection, this.e.invoke(hp0Var));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ModuleDescriptor d() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final StorageManager e() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(@NotNull h70 h70Var) {
        b41.i(h70Var, "<set-?>");
        this.d = h70Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull hp0 hp0Var) {
        List<PackageFragmentDescriptor> k;
        b41.i(hp0Var, "fqName");
        k = C8214m.k(this.e.invoke(hp0Var));
        return k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<hp0> getSubPackagesOf(@NotNull hp0 hp0Var, @NotNull Function1<? super ni1, Boolean> function1) {
        Set d;
        b41.i(hp0Var, "fqName");
        b41.i(function1, "nameFilter");
        d = C8203e0.d();
        return d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(@NotNull hp0 hp0Var) {
        PackageFragmentDescriptor a;
        b41.i(hp0Var, "fqName");
        if (this.e.isComputed(hp0Var)) {
            a = this.e.invoke(hp0Var);
        } else {
            a = a(hp0Var);
        }
        return a == null;
    }
}
