package tb;

import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaModuleAnnotationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class n51 {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final JavaClassFinder b;
    @NotNull
    private final KotlinClassFinder c;
    @NotNull
    private final DeserializedDescriptorResolver d;
    @NotNull
    private final SignaturePropagator e;
    @NotNull
    private final ErrorReporter f;
    @NotNull
    private final JavaResolverCache g;
    @NotNull
    private final JavaPropertyInitializerEvaluator h;
    @NotNull
    private final SamConversionResolver i;
    @NotNull
    private final JavaSourceElementFactory j;
    @NotNull
    private final ModuleClassResolver k;
    @NotNull
    private final PackagePartProvider l;
    @NotNull
    private final SupertypeLoopChecker m;
    @NotNull
    private final LookupTracker n;
    @NotNull
    private final ModuleDescriptor o;
    @NotNull
    private final ReflectionTypes p;
    @NotNull
    private final AnnotationTypeQualifierResolver q;
    @NotNull
    private final SignatureEnhancement r;
    @NotNull
    private final JavaClassesTracker s;
    @NotNull
    private final JavaResolverSettings t;
    @NotNull
    private final NewKotlinTypeChecker u;
    @NotNull
    private final JavaTypeEnhancementState v;
    @NotNull
    private final JavaModuleAnnotationsProvider w;
    @NotNull
    private final SyntheticJavaPartsProvider x;

    public n51(@NotNull StorageManager storageManager, @NotNull JavaClassFinder javaClassFinder, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull SignaturePropagator signaturePropagator, @NotNull ErrorReporter errorReporter, @NotNull JavaResolverCache javaResolverCache, @NotNull JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, @NotNull SamConversionResolver samConversionResolver, @NotNull JavaSourceElementFactory javaSourceElementFactory, @NotNull ModuleClassResolver moduleClassResolver, @NotNull PackagePartProvider packagePartProvider, @NotNull SupertypeLoopChecker supertypeLoopChecker, @NotNull LookupTracker lookupTracker, @NotNull ModuleDescriptor moduleDescriptor, @NotNull ReflectionTypes reflectionTypes, @NotNull AnnotationTypeQualifierResolver annotationTypeQualifierResolver, @NotNull SignatureEnhancement signatureEnhancement, @NotNull JavaClassesTracker javaClassesTracker, @NotNull JavaResolverSettings javaResolverSettings, @NotNull NewKotlinTypeChecker newKotlinTypeChecker, @NotNull JavaTypeEnhancementState javaTypeEnhancementState, @NotNull JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, @NotNull SyntheticJavaPartsProvider syntheticJavaPartsProvider) {
        b41.i(storageManager, "storageManager");
        b41.i(javaClassFinder, "finder");
        b41.i(kotlinClassFinder, "kotlinClassFinder");
        b41.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        b41.i(signaturePropagator, "signaturePropagator");
        b41.i(errorReporter, "errorReporter");
        b41.i(javaResolverCache, "javaResolverCache");
        b41.i(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        b41.i(samConversionResolver, "samConversionResolver");
        b41.i(javaSourceElementFactory, "sourceElementFactory");
        b41.i(moduleClassResolver, "moduleClassResolver");
        b41.i(packagePartProvider, "packagePartProvider");
        b41.i(supertypeLoopChecker, "supertypeLoopChecker");
        b41.i(lookupTracker, "lookupTracker");
        b41.i(moduleDescriptor, "module");
        b41.i(reflectionTypes, "reflectionTypes");
        b41.i(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        b41.i(signatureEnhancement, "signatureEnhancement");
        b41.i(javaClassesTracker, "javaClassesTracker");
        b41.i(javaResolverSettings, "settings");
        b41.i(newKotlinTypeChecker, "kotlinTypeChecker");
        b41.i(javaTypeEnhancementState, "javaTypeEnhancementState");
        b41.i(javaModuleAnnotationsProvider, "javaModuleResolver");
        b41.i(syntheticJavaPartsProvider, "syntheticPartsProvider");
        this.a = storageManager;
        this.b = javaClassFinder;
        this.c = kotlinClassFinder;
        this.d = deserializedDescriptorResolver;
        this.e = signaturePropagator;
        this.f = errorReporter;
        this.g = javaResolverCache;
        this.h = javaPropertyInitializerEvaluator;
        this.i = samConversionResolver;
        this.j = javaSourceElementFactory;
        this.k = moduleClassResolver;
        this.l = packagePartProvider;
        this.m = supertypeLoopChecker;
        this.n = lookupTracker;
        this.o = moduleDescriptor;
        this.p = reflectionTypes;
        this.q = annotationTypeQualifierResolver;
        this.r = signatureEnhancement;
        this.s = javaClassesTracker;
        this.t = javaResolverSettings;
        this.u = newKotlinTypeChecker;
        this.v = javaTypeEnhancementState;
        this.w = javaModuleAnnotationsProvider;
        this.x = syntheticJavaPartsProvider;
    }

    @NotNull
    public final AnnotationTypeQualifierResolver a() {
        return this.q;
    }

    @NotNull
    public final DeserializedDescriptorResolver b() {
        return this.d;
    }

    @NotNull
    public final ErrorReporter c() {
        return this.f;
    }

    @NotNull
    public final JavaClassFinder d() {
        return this.b;
    }

    @NotNull
    public final JavaClassesTracker e() {
        return this.s;
    }

    @NotNull
    public final JavaModuleAnnotationsProvider f() {
        return this.w;
    }

    @NotNull
    public final JavaPropertyInitializerEvaluator g() {
        return this.h;
    }

    @NotNull
    public final JavaResolverCache h() {
        return this.g;
    }

    @NotNull
    public final JavaTypeEnhancementState i() {
        return this.v;
    }

    @NotNull
    public final KotlinClassFinder j() {
        return this.c;
    }

    @NotNull
    public final NewKotlinTypeChecker k() {
        return this.u;
    }

    @NotNull
    public final LookupTracker l() {
        return this.n;
    }

    @NotNull
    public final ModuleDescriptor m() {
        return this.o;
    }

    @NotNull
    public final ModuleClassResolver n() {
        return this.k;
    }

    @NotNull
    public final PackagePartProvider o() {
        return this.l;
    }

    @NotNull
    public final ReflectionTypes p() {
        return this.p;
    }

    @NotNull
    public final JavaResolverSettings q() {
        return this.t;
    }

    @NotNull
    public final SignatureEnhancement r() {
        return this.r;
    }

    @NotNull
    public final SignaturePropagator s() {
        return this.e;
    }

    @NotNull
    public final JavaSourceElementFactory t() {
        return this.j;
    }

    @NotNull
    public final StorageManager u() {
        return this.a;
    }

    @NotNull
    public final SupertypeLoopChecker v() {
        return this.m;
    }

    @NotNull
    public final SyntheticJavaPartsProvider w() {
        return this.x;
    }

    @NotNull
    public final n51 x(@NotNull JavaResolverCache javaResolverCache) {
        b41.i(javaResolverCache, "javaResolverCache");
        return new n51(this.a, this.b, this.c, this.d, this.e, this.f, javaResolverCache, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, null, 8388608, null);
    }

    public /* synthetic */ n51(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, SignatureEnhancement signatureEnhancement, JavaClassesTracker javaClassesTracker, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState, JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, SyntheticJavaPartsProvider syntheticJavaPartsProvider, int i, k50 k50Var) {
        this(storageManager, javaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, errorReporter, javaResolverCache, javaPropertyInitializerEvaluator, samConversionResolver, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, lookupTracker, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, javaClassesTracker, javaResolverSettings, newKotlinTypeChecker, javaTypeEnhancementState, javaModuleAnnotationsProvider, (i & 8388608) != 0 ? SyntheticJavaPartsProvider.Companion.a() : syntheticJavaPartsProvider);
    }
}
