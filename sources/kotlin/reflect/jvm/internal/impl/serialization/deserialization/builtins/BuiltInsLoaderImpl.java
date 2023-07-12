package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.ae;
import tb.b41;
import tb.ce;
import tb.ee;
import tb.h70;
import tb.hp0;
import tb.m70;
import tb.u52;
import tb.z5;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {
    @NotNull
    private final ee a = new ee();

    @NotNull
    public final PackageFragmentProvider a(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Set<hp0> set, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z, @NotNull Function1<? super String, ? extends InputStream> function1) {
        int q;
        List g;
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "module");
        b41.i(set, "packageFqNames");
        b41.i(iterable, "classDescriptorFactories");
        b41.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        b41.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        b41.i(function1, "loadResource");
        q = n.q(set, 10);
        ArrayList<ce> arrayList = new ArrayList(q);
        for (hp0 hp0Var : set) {
            String n = ae.INSTANCE.n(hp0Var);
            InputStream invoke = function1.invoke(n);
            if (invoke != null) {
                arrayList.add(ce.Companion.a(hp0Var, storageManager, moduleDescriptor, invoke, z));
            } else {
                throw new IllegalStateException(b41.r("Resource not found in classpath: ", n));
            }
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager, moduleDescriptor);
        DeserializationConfiguration.a aVar = DeserializationConfiguration.a.INSTANCE;
        m70 m70Var = new m70(packageFragmentProviderImpl);
        ae aeVar = ae.INSTANCE;
        z5 z5Var = new z5(moduleDescriptor, notFoundClasses, aeVar);
        LocalClassifierTypeSettings.a aVar2 = LocalClassifierTypeSettings.a.INSTANCE;
        ErrorReporter errorReporter = ErrorReporter.DO_NOTHING;
        b41.h(errorReporter, "DO_NOTHING");
        LookupTracker.a aVar3 = LookupTracker.a.INSTANCE;
        FlexibleTypeDeserializer.a aVar4 = FlexibleTypeDeserializer.a.INSTANCE;
        ContractDeserializer a = ContractDeserializer.Companion.a();
        c e = aeVar.e();
        g = m.g();
        h70 h70Var = new h70(storageManager, moduleDescriptor, aVar, m70Var, z5Var, packageFragmentProviderImpl, aVar2, errorReporter, aVar3, aVar4, iterable, notFoundClasses, a, additionalClassPartsProvider, platformDependentDeclarationFilter, e, null, new u52(storageManager, g), null, 327680, null);
        for (ce ceVar : arrayList) {
            ceVar.f(h70Var);
        }
        return packageFragmentProviderImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    @NotNull
    public PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z) {
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "builtInsModule");
        b41.i(iterable, "classDescriptorFactories");
        b41.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        b41.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        return a(storageManager, moduleDescriptor, kotlin.reflect.jvm.internal.impl.builtins.c.BUILT_INS_PACKAGE_FQ_NAMES, iterable, platformDependentDeclarationFilter, additionalClassPartsProvider, z, new BuiltInsLoaderImpl$createPackageFragmentProvider$1(this.a));
    }
}
