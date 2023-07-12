package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class nc0 extends fn<Double> {
    public nc0(double d) {
        super(Double.valueOf(d));
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 z = moduleDescriptor.getBuiltIns().z();
        b41.h(z, "module.builtIns.doubleType");
        return z;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().doubleValue() + ".toDouble()";
    }
}
