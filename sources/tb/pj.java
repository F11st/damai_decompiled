package tb;

import cn.damai.common.app.ShareperfenceConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class pj implements TypeConstructor {
    private int a;

    private final boolean b(ClassifierDescriptor classifierDescriptor) {
        return (kf0.r(classifierDescriptor) || d70.E(classifierDescriptor)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull ClassifierDescriptor classifierDescriptor2) {
        b41.i(classifierDescriptor, ShareperfenceConstants.FIRST);
        b41.i(classifierDescriptor2, "second");
        if (b41.d(classifierDescriptor.getName(), classifierDescriptor2.getName())) {
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            for (DeclarationDescriptor containingDeclaration2 = classifierDescriptor2.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
                if (containingDeclaration instanceof ModuleDescriptor) {
                    return containingDeclaration2 instanceof ModuleDescriptor;
                }
                if (containingDeclaration2 instanceof ModuleDescriptor) {
                    return false;
                }
                if (containingDeclaration instanceof PackageFragmentDescriptor) {
                    return (containingDeclaration2 instanceof PackageFragmentDescriptor) && b41.d(((PackageFragmentDescriptor) containingDeclaration).getFqName(), ((PackageFragmentDescriptor) containingDeclaration2).getFqName());
                } else if ((containingDeclaration2 instanceof PackageFragmentDescriptor) || !b41.d(containingDeclaration.getName(), containingDeclaration2.getName())) {
                    return false;
                } else {
                    containingDeclaration = containingDeclaration.getContainingDeclaration();
                }
            }
            return true;
        }
        return false;
    }

    protected abstract boolean c(@NotNull ClassifierDescriptor classifierDescriptor);

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TypeConstructor) && obj.hashCode() == hashCode()) {
            TypeConstructor typeConstructor = (TypeConstructor) obj;
            if (typeConstructor.getParameters().size() != getParameters().size()) {
                return false;
            }
            ClassifierDescriptor declarationDescriptor = getDeclarationDescriptor();
            ClassifierDescriptor declarationDescriptor2 = typeConstructor.getDeclarationDescriptor();
            if (declarationDescriptor2 != null && b(declarationDescriptor) && b(declarationDescriptor2)) {
                return c(declarationDescriptor2);
            }
            return false;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public abstract ClassifierDescriptor getDeclarationDescriptor();

    public int hashCode() {
        int identityHashCode;
        int i = this.a;
        if (i != 0) {
            return i;
        }
        ClassifierDescriptor declarationDescriptor = getDeclarationDescriptor();
        if (b(declarationDescriptor)) {
            identityHashCode = d70.m(declarationDescriptor).hashCode();
        } else {
            identityHashCode = System.identityHashCode(this);
        }
        this.a = identityHashCode;
        return identityHashCode;
    }
}
