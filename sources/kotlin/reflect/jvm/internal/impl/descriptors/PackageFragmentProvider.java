package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.hp0;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PackageFragmentProvider {
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    List<PackageFragmentDescriptor> getPackageFragments(@NotNull hp0 hp0Var);

    @NotNull
    Collection<hp0> getSubPackagesOf(@NotNull hp0 hp0Var, @NotNull Function1<? super ni1, Boolean> function1);
}
