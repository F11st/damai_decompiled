package tb;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class vy2 {
    @NotNull
    public static final CallableMemberDescriptor a(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        Integer d;
        b41.i(collection, "descriptors");
        collection.isEmpty();
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            if (callableMemberDescriptor == null || ((d = e70.d(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && d.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        b41.f(callableMemberDescriptor);
        return callableMemberDescriptor;
    }
}
