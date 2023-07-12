package tb;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class rl {
    public static final boolean a(@NotNull ql qlVar, @NotNull ClassDescriptor classDescriptor) {
        boolean J;
        b41.i(qlVar, "<this>");
        b41.i(classDescriptor, "classDescriptor");
        if (d70.x(classDescriptor)) {
            Set<hj> b = qlVar.b();
            hj h = DescriptorUtilsKt.h(classDescriptor);
            J = CollectionsKt___CollectionsKt.J(b, h == null ? null : h.g());
            if (J) {
                return true;
            }
        }
        return false;
    }
}
