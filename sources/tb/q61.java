package tb;

import java.io.InputStream;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class q61 extends AbstractDeserializedPackageFragmentProvider {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q61(@NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull DeserializationConfiguration deserializationConfiguration, @NotNull NewKotlinTypeChecker newKotlinTypeChecker, @NotNull SamConversionResolver samConversionResolver) {
        super(storageManager, kotlinClassFinder, moduleDescriptor);
        List j;
        b41.i(storageManager, "storageManager");
        b41.i(kotlinClassFinder, "finder");
        b41.i(moduleDescriptor, "moduleDescriptor");
        b41.i(notFoundClasses, "notFoundClasses");
        b41.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        b41.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        b41.i(deserializationConfiguration, "deserializationConfiguration");
        b41.i(newKotlinTypeChecker, "kotlinTypeChecker");
        b41.i(samConversionResolver, "samConversionResolver");
        m70 m70Var = new m70(this);
        ae aeVar = ae.INSTANCE;
        z5 z5Var = new z5(moduleDescriptor, notFoundClasses, aeVar);
        LocalClassifierTypeSettings.a aVar = LocalClassifierTypeSettings.a.INSTANCE;
        ErrorReporter errorReporter = ErrorReporter.DO_NOTHING;
        b41.h(errorReporter, "DO_NOTHING");
        LookupTracker.a aVar2 = LookupTracker.a.INSTANCE;
        FlexibleTypeDeserializer.a aVar3 = FlexibleTypeDeserializer.a.INSTANCE;
        j = kotlin.collections.m.j(new zd(storageManager, moduleDescriptor), new JvmBuiltInClassDescriptorFactory(storageManager, moduleDescriptor, null, 4, null));
        f(new h70(storageManager, moduleDescriptor, deserializationConfiguration, m70Var, z5Var, this, aVar, errorReporter, aVar2, aVar3, j, notFoundClasses, ContractDeserializer.Companion.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, aeVar.e(), newKotlinTypeChecker, samConversionResolver, null, 262144, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider
    @Nullable
    protected n70 a(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        InputStream findBuiltInsData = c().findBuiltInsData(hp0Var);
        if (findBuiltInsData == null) {
            return null;
        }
        return ce.Companion.a(hp0Var, e(), d(), findBuiltInsData, false);
    }
}
