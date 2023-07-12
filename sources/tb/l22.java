package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class l22 {
    @NotNull
    private static final zg1<ResolutionAnchorProvider> a = new zg1<>("ResolutionAnchorProvider");

    @Nullable
    public static final ModuleDescriptor a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "<this>");
        ResolutionAnchorProvider resolutionAnchorProvider = (ResolutionAnchorProvider) moduleDescriptor.getCapability(a);
        if (resolutionAnchorProvider == null) {
            return null;
        }
        return resolutionAnchorProvider.getResolutionAnchor(moduleDescriptor);
    }
}
