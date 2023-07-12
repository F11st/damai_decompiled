package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class c70 {
    @Nullable
    public static final ClassifierDescriptor a(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        if (containingDeclaration == null || (declarationDescriptor instanceof PackageFragmentDescriptor)) {
            return null;
        }
        if (!b(containingDeclaration)) {
            return a(containingDeclaration);
        }
        if (containingDeclaration instanceof ClassifierDescriptor) {
            return (ClassifierDescriptor) containingDeclaration;
        }
        return null;
    }

    public static final boolean b(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        return declarationDescriptor.getContainingDeclaration() instanceof PackageFragmentDescriptor;
    }

    @Nullable
    public static final ClassDescriptor c(@NotNull ModuleDescriptor moduleDescriptor, @NotNull hp0 hp0Var, @NotNull LookupLocation lookupLocation) {
        MemberScope unsubstitutedInnerClassesScope;
        ClassifierDescriptor contributedClassifier;
        b41.i(moduleDescriptor, "<this>");
        b41.i(hp0Var, "fqName");
        b41.i(lookupLocation, "lookupLocation");
        if (hp0Var.d()) {
            return null;
        }
        hp0 e = hp0Var.e();
        b41.h(e, "fqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(e).getMemberScope();
        ni1 g = hp0Var.g();
        b41.h(g, "fqName.shortName()");
        ClassifierDescriptor contributedClassifier2 = memberScope.getContributedClassifier(g, lookupLocation);
        ClassDescriptor classDescriptor = contributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier2 : null;
        if (classDescriptor == null) {
            hp0 e2 = hp0Var.e();
            b41.h(e2, "fqName.parent()");
            ClassDescriptor c = c(moduleDescriptor, e2, lookupLocation);
            if (c == null || (unsubstitutedInnerClassesScope = c.getUnsubstitutedInnerClassesScope()) == null) {
                contributedClassifier = null;
            } else {
                ni1 g2 = hp0Var.g();
                b41.h(g2, "fqName.shortName()");
                contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(g2, lookupLocation);
            }
            if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            }
            return null;
        }
        return classDescriptor;
    }
}
