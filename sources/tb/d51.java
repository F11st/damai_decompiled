package tb;

import kotlin.collections.C8212k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class d51 {
    @NotNull
    private final LazyJavaPackageFragmentProvider a;
    @NotNull
    private final JavaResolverCache b;

    public d51(@NotNull LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, @NotNull JavaResolverCache javaResolverCache) {
        b41.i(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        b41.i(javaResolverCache, "javaResolverCache");
        this.a = lazyJavaPackageFragmentProvider;
        this.b = javaResolverCache;
    }

    @NotNull
    public final LazyJavaPackageFragmentProvider a() {
        return this.a;
    }

    @Nullable
    public final ClassDescriptor b(@NotNull JavaClass javaClass) {
        b41.i(javaClass, "javaClass");
        hp0 fqName = javaClass.getFqName();
        if (fqName != null && javaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE) {
            return this.b.getClassResolvedFromSource(fqName);
        }
        JavaClass outerClass = javaClass.getOuterClass();
        if (outerClass != null) {
            ClassDescriptor b = b(outerClass);
            MemberScope unsubstitutedInnerClassesScope = b == null ? null : b.getUnsubstitutedInnerClassesScope();
            ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope == null ? null : unsubstitutedInnerClassesScope.getContributedClassifier(javaClass.getName(), NoLookupLocation.FROM_JAVA_LOADER);
            if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            }
            return null;
        } else if (fqName == null) {
            return null;
        } else {
            LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = this.a;
            hp0 e = fqName.e();
            b41.h(e, "fqName.parent()");
            LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment) C8212k.R(lazyJavaPackageFragmentProvider.getPackageFragments(e));
            if (lazyJavaPackageFragment == null) {
                return null;
            }
            return lazyJavaPackageFragment.f(javaClass);
        }
    }
}
