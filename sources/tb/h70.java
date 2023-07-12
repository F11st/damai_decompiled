package tb;

import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.C8447c;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class h70 {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final ModuleDescriptor b;
    @NotNull
    private final DeserializationConfiguration c;
    @NotNull
    private final ClassDataFinder d;
    @NotNull
    private final AnnotationAndConstantLoader<AnnotationDescriptor, fn<?>> e;
    @NotNull
    private final PackageFragmentProvider f;
    @NotNull
    private final LocalClassifierTypeSettings g;
    @NotNull
    private final ErrorReporter h;
    @NotNull
    private final LookupTracker i;
    @NotNull
    private final FlexibleTypeDeserializer j;
    @NotNull
    private final Iterable<ClassDescriptorFactory> k;
    @NotNull
    private final NotFoundClasses l;
    @NotNull
    private final ContractDeserializer m;
    @NotNull
    private final AdditionalClassPartsProvider n;
    @NotNull
    private final PlatformDependentDeclarationFilter o;
    @NotNull
    private final C8447c p;
    @NotNull
    private final NewKotlinTypeChecker q;
    @NotNull
    private final SamConversionResolver r;
    @NotNull
    private final PlatformDependentTypeTransformer s;
    @NotNull
    private final ClassDeserializer t;

    /* JADX WARN: Multi-variable type inference failed */
    public h70(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull DeserializationConfiguration deserializationConfiguration, @NotNull ClassDataFinder classDataFinder, @NotNull AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends fn<?>> annotationAndConstantLoader, @NotNull PackageFragmentProvider packageFragmentProvider, @NotNull LocalClassifierTypeSettings localClassifierTypeSettings, @NotNull ErrorReporter errorReporter, @NotNull LookupTracker lookupTracker, @NotNull FlexibleTypeDeserializer flexibleTypeDeserializer, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull NotFoundClasses notFoundClasses, @NotNull ContractDeserializer contractDeserializer, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull C8447c c8447c, @NotNull NewKotlinTypeChecker newKotlinTypeChecker, @NotNull SamConversionResolver samConversionResolver, @NotNull PlatformDependentTypeTransformer platformDependentTypeTransformer) {
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "moduleDescriptor");
        b41.i(deserializationConfiguration, PipUtils.DAGO_PIP_MODE_CONFIGURATION);
        b41.i(classDataFinder, "classDataFinder");
        b41.i(annotationAndConstantLoader, "annotationAndConstantLoader");
        b41.i(packageFragmentProvider, "packageFragmentProvider");
        b41.i(localClassifierTypeSettings, "localClassifierTypeSettings");
        b41.i(errorReporter, "errorReporter");
        b41.i(lookupTracker, "lookupTracker");
        b41.i(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        b41.i(iterable, "fictitiousClassDescriptorFactories");
        b41.i(notFoundClasses, "notFoundClasses");
        b41.i(contractDeserializer, "contractDeserializer");
        b41.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        b41.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        b41.i(c8447c, "extensionRegistryLite");
        b41.i(newKotlinTypeChecker, "kotlinTypeChecker");
        b41.i(samConversionResolver, "samConversionResolver");
        b41.i(platformDependentTypeTransformer, "platformDependentTypeTransformer");
        this.a = storageManager;
        this.b = moduleDescriptor;
        this.c = deserializationConfiguration;
        this.d = classDataFinder;
        this.e = annotationAndConstantLoader;
        this.f = packageFragmentProvider;
        this.g = localClassifierTypeSettings;
        this.h = errorReporter;
        this.i = lookupTracker;
        this.j = flexibleTypeDeserializer;
        this.k = iterable;
        this.l = notFoundClasses;
        this.m = contractDeserializer;
        this.n = additionalClassPartsProvider;
        this.o = platformDependentDeclarationFilter;
        this.p = c8447c;
        this.q = newKotlinTypeChecker;
        this.r = samConversionResolver;
        this.s = platformDependentTypeTransformer;
        this.t = new ClassDeserializer(this);
    }

    @NotNull
    public final j70 a(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, @NotNull ix2 ix2Var, @NotNull AbstractC9135fc abstractC9135fc, @Nullable DeserializedContainerSource deserializedContainerSource) {
        List g;
        b41.i(packageFragmentDescriptor, "descriptor");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        b41.i(ix2Var, "versionRequirementTable");
        b41.i(abstractC9135fc, "metadataVersion");
        g = C8214m.g();
        return new j70(this, nameResolver, packageFragmentDescriptor, er2Var, ix2Var, abstractC9135fc, deserializedContainerSource, null, g);
    }

    @Nullable
    public final ClassDescriptor b(@NotNull hj hjVar) {
        b41.i(hjVar, "classId");
        return ClassDeserializer.e(this.t, hjVar, null, 2, null);
    }

    @NotNull
    public final AdditionalClassPartsProvider c() {
        return this.n;
    }

    @NotNull
    public final AnnotationAndConstantLoader<AnnotationDescriptor, fn<?>> d() {
        return this.e;
    }

    @NotNull
    public final ClassDataFinder e() {
        return this.d;
    }

    @NotNull
    public final ClassDeserializer f() {
        return this.t;
    }

    @NotNull
    public final DeserializationConfiguration g() {
        return this.c;
    }

    @NotNull
    public final ContractDeserializer h() {
        return this.m;
    }

    @NotNull
    public final ErrorReporter i() {
        return this.h;
    }

    @NotNull
    public final C8447c j() {
        return this.p;
    }

    @NotNull
    public final Iterable<ClassDescriptorFactory> k() {
        return this.k;
    }

    @NotNull
    public final FlexibleTypeDeserializer l() {
        return this.j;
    }

    @NotNull
    public final NewKotlinTypeChecker m() {
        return this.q;
    }

    @NotNull
    public final LocalClassifierTypeSettings n() {
        return this.g;
    }

    @NotNull
    public final LookupTracker o() {
        return this.i;
    }

    @NotNull
    public final ModuleDescriptor p() {
        return this.b;
    }

    @NotNull
    public final NotFoundClasses q() {
        return this.l;
    }

    @NotNull
    public final PackageFragmentProvider r() {
        return this.f;
    }

    @NotNull
    public final PlatformDependentDeclarationFilter s() {
        return this.o;
    }

    @NotNull
    public final PlatformDependentTypeTransformer t() {
        return this.s;
    }

    @NotNull
    public final StorageManager u() {
        return this.a;
    }

    public /* synthetic */ h70(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, C8447c c8447c, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver, PlatformDependentTypeTransformer platformDependentTypeTransformer, int i, k50 k50Var) {
        this(storageManager, moduleDescriptor, deserializationConfiguration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter, lookupTracker, flexibleTypeDeserializer, iterable, notFoundClasses, contractDeserializer, (i & 8192) != 0 ? AdditionalClassPartsProvider.C8307a.INSTANCE : additionalClassPartsProvider, (i & 16384) != 0 ? PlatformDependentDeclarationFilter.C8308a.INSTANCE : platformDependentDeclarationFilter, c8447c, (65536 & i) != 0 ? NewKotlinTypeChecker.Companion.a() : newKotlinTypeChecker, samConversionResolver, (i & 262144) != 0 ? PlatformDependentTypeTransformer.C8310a.INSTANCE : platformDependentTypeTransformer);
    }
}
