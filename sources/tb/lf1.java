package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class lf1 {
    @NotNull
    public static final String a(@NotNull SignatureBuildingComponents signatureBuildingComponents, @NotNull ClassDescriptor classDescriptor, @NotNull String str) {
        b41.i(signatureBuildingComponents, "<this>");
        b41.i(classDescriptor, "classDescriptor");
        b41.i(str, "jvmDescriptor");
        return signatureBuildingComponents.k(mf1.f(classDescriptor), str);
    }
}
