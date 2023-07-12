package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;
import tb.ni1;
import tb.zg1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ModuleDescriptor extends DeclarationDescriptor {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor$a */
    /* loaded from: classes3.dex */
    public static final class C8292a {
        public static <R, D> R a(@NotNull ModuleDescriptor moduleDescriptor, @NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            b41.i(moduleDescriptor, "this");
            b41.i(declarationDescriptorVisitor, "visitor");
            return declarationDescriptorVisitor.visitModuleDeclaration(moduleDescriptor, d);
        }

        @Nullable
        public static DeclarationDescriptor b(@NotNull ModuleDescriptor moduleDescriptor) {
            b41.i(moduleDescriptor, "this");
            return null;
        }
    }

    @NotNull
    AbstractC8271b getBuiltIns();

    @Nullable
    <T> T getCapability(@NotNull zg1<T> zg1Var);

    @NotNull
    List<ModuleDescriptor> getExpectedByModules();

    @NotNull
    PackageViewDescriptor getPackage(@NotNull hp0 hp0Var);

    @NotNull
    Collection<hp0> getSubPackagesOf(@NotNull hp0 hp0Var, @NotNull Function1<? super ni1, Boolean> function1);

    boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor);
}
