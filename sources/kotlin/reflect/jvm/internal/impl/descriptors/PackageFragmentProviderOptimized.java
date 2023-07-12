package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PackageFragmentProviderOptimized extends PackageFragmentProvider {
    void collectPackageFragments(@NotNull hp0 hp0Var, @NotNull Collection<PackageFragmentDescriptor> collection);

    boolean isEmpty(@NotNull hp0 hp0Var);
}
