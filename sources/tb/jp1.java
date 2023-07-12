package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class jp1 extends u40 implements PackageFragmentDescriptor {
    @NotNull
    private final hp0 e;
    @NotNull
    private final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp1(@NotNull ModuleDescriptor moduleDescriptor, @NotNull hp0 hp0Var) {
        super(moduleDescriptor, Annotations.Companion.b(), hp0Var.h(), SourceElement.NO_SOURCE);
        b41.i(moduleDescriptor, "module");
        b41.i(hp0Var, "fqName");
        this.e = hp0Var;
        this.f = "package " + hp0Var + " of " + moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        b41.i(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageFragmentDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    public final hp0 getFqName() {
        return this.e;
    }

    @Override // tb.u40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        b41.h(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // tb.t40
    @NotNull
    public String toString() {
        return this.f;
    }

    @Override // tb.u40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public ModuleDescriptor getContainingDeclaration() {
        return (ModuleDescriptor) super.getContainingDeclaration();
    }
}
