package tb;

import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class i70 {
    @NotNull
    private final h70 a;

    public i70(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull DeserializationConfiguration deserializationConfiguration, @NotNull b51 b51Var, @NotNull ec ecVar, @NotNull LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, @NotNull NotFoundClasses notFoundClasses, @NotNull ErrorReporter errorReporter, @NotNull LookupTracker lookupTracker, @NotNull ContractDeserializer contractDeserializer, @NotNull NewKotlinTypeChecker newKotlinTypeChecker) {
        List g;
        List g2;
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "moduleDescriptor");
        b41.i(deserializationConfiguration, PipUtils.DAGO_PIP_MODE_CONFIGURATION);
        b41.i(b51Var, "classDataFinder");
        b41.i(ecVar, "annotationAndConstantLoader");
        b41.i(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        b41.i(notFoundClasses, "notFoundClasses");
        b41.i(errorReporter, "errorReporter");
        b41.i(lookupTracker, "lookupTracker");
        b41.i(contractDeserializer, "contractDeserializer");
        b41.i(newKotlinTypeChecker, "kotlinTypeChecker");
        kotlin.reflect.jvm.internal.impl.builtins.b builtIns = moduleDescriptor.getBuiltIns();
        JvmBuiltIns jvmBuiltIns = builtIns instanceof JvmBuiltIns ? (JvmBuiltIns) builtIns : null;
        LocalClassifierTypeSettings.a aVar = LocalClassifierTypeSettings.a.INSTANCE;
        g51 g51Var = g51.INSTANCE;
        g = kotlin.collections.m.g();
        AdditionalClassPartsProvider G0 = jvmBuiltIns == null ? null : jvmBuiltIns.G0();
        AdditionalClassPartsProvider additionalClassPartsProvider = G0 == null ? AdditionalClassPartsProvider.a.INSTANCE : G0;
        PlatformDependentDeclarationFilter G02 = jvmBuiltIns != null ? jvmBuiltIns.G0() : null;
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter = G02 == null ? PlatformDependentDeclarationFilter.b.INSTANCE : G02;
        kotlin.reflect.jvm.internal.impl.protobuf.c a = b71.INSTANCE.a();
        g2 = kotlin.collections.m.g();
        this.a = new h70(storageManager, moduleDescriptor, deserializationConfiguration, b51Var, ecVar, lazyJavaPackageFragmentProvider, aVar, errorReporter, lookupTracker, g51Var, g, notFoundClasses, contractDeserializer, additionalClassPartsProvider, platformDependentDeclarationFilter, a, newKotlinTypeChecker, new u52(storageManager, g2), null, 262144, null);
    }

    @NotNull
    public final h70 a() {
        return this.a;
    }
}
