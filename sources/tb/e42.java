package tb;

import java.util.List;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaModuleAnnotationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class e42 {

    /* compiled from: Taobao */
    /* renamed from: tb.e42$a */
    /* loaded from: classes3.dex */
    public static final class C9072a implements JavaModuleAnnotationsProvider {
        C9072a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaModuleAnnotationsProvider
        @Nullable
        public List<JavaAnnotation> getAnnotationsForModuleOwnerOfClass(@NotNull hj hjVar) {
            b41.i(hjVar, "classId");
            return null;
        }
    }

    @NotNull
    public static final i70 a(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StorageManager storageManager, @NotNull NotFoundClasses notFoundClasses, @NotNull LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver) {
        b41.i(moduleDescriptor, "module");
        b41.i(storageManager, "storageManager");
        b41.i(notFoundClasses, "notFoundClasses");
        b41.i(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        b41.i(kotlinClassFinder, "reflectKotlinClassFinder");
        b41.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        return new i70(storageManager, moduleDescriptor, DeserializationConfiguration.C8506a.INSTANCE, new b51(kotlinClassFinder, deserializedDescriptorResolver), new ec(moduleDescriptor, notFoundClasses, storageManager, kotlinClassFinder), lazyJavaPackageFragmentProvider, notFoundClasses, b42.INSTANCE, LookupTracker.C8324a.INSTANCE, ContractDeserializer.Companion.a(), NewKotlinTypeChecker.Companion.a());
    }

    @NotNull
    public static final LazyJavaPackageFragmentProvider b(@NotNull ClassLoader classLoader, @NotNull ModuleDescriptor moduleDescriptor, @NotNull StorageManager storageManager, @NotNull NotFoundClasses notFoundClasses, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull ModuleClassResolver moduleClassResolver, @NotNull PackagePartProvider packagePartProvider) {
        List g;
        b41.i(classLoader, "classLoader");
        b41.i(moduleDescriptor, "module");
        b41.i(storageManager, "storageManager");
        b41.i(notFoundClasses, "notFoundClasses");
        b41.i(kotlinClassFinder, "reflectKotlinClassFinder");
        b41.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        b41.i(moduleClassResolver, "singleModuleClassResolver");
        b41.i(packagePartProvider, "packagePartProvider");
        JavaTypeEnhancementState.C8330a c8330a = JavaTypeEnhancementState.Companion;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(storageManager, c8330a.a());
        JavaTypeEnhancementState a = c8330a.a();
        b02 b02Var = new b02(classLoader);
        SignaturePropagator signaturePropagator = SignaturePropagator.DO_NOTHING;
        b41.h(signaturePropagator, "DO_NOTHING");
        b42 b42Var = b42.INSTANCE;
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        b41.h(javaResolverCache, "EMPTY");
        JavaPropertyInitializerEvaluator.C8335a c8335a = JavaPropertyInitializerEvaluator.C8335a.INSTANCE;
        g = C8214m.g();
        u52 u52Var = new u52(storageManager, g);
        f42 f42Var = f42.INSTANCE;
        SupertypeLoopChecker.C8298a c8298a = SupertypeLoopChecker.C8298a.INSTANCE;
        LookupTracker.C8324a c8324a = LookupTracker.C8324a.INSTANCE;
        ReflectionTypes reflectionTypes = new ReflectionTypes(moduleDescriptor, notFoundClasses);
        JavaTypeEnhancementState a2 = c8330a.a();
        JavaResolverSettings.C8341b c8341b = JavaResolverSettings.C8341b.INSTANCE;
        return new LazyJavaPackageFragmentProvider(new n51(storageManager, b02Var, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, b42Var, javaResolverCache, c8335a, u52Var, f42Var, moduleClassResolver, packagePartProvider, c8298a, c8324a, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, new SignatureEnhancement(annotationTypeQualifierResolver, a2, new r51(c8341b)), JavaClassesTracker.C8329a.INSTANCE, c8341b, NewKotlinTypeChecker.Companion.a(), a, new C9072a(), null, 8388608, null));
    }
}
