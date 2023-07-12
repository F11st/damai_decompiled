package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ed extends fn<Boolean> {
    public ed(boolean z) {
        super(Boolean.valueOf(z));
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 n = moduleDescriptor.getBuiltIns().n();
        b41.h(n, "module.builtIns.booleanType");
        return n;
    }
}
