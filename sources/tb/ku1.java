package tb;

import java.util.Collection;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ku1 {
    @NotNull
    public static final Collection<z71> a(@NotNull ModuleDescriptor moduleDescriptor) {
        List j;
        b41.i(moduleDescriptor, "<this>");
        j = C8214m.j(moduleDescriptor.getBuiltIns().D(), moduleDescriptor.getBuiltIns().F(), moduleDescriptor.getBuiltIns().t(), moduleDescriptor.getBuiltIns().T());
        return j;
    }
}
