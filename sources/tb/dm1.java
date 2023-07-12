package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class dm1 extends fn<Void> {
    public dm1() {
        super(null);
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 J = moduleDescriptor.getBuiltIns().J();
        b41.h(J, "module.builtIns.nullableNothingType");
        return J;
    }
}
