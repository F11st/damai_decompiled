package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class kk0 extends fn<Float> {
    public kk0(float f) {
        super(Float.valueOf(f));
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 B = moduleDescriptor.getBuiltIns().B();
        b41.h(B, "module.builtIns.floatType");
        return B;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().floatValue() + ".toFloat()";
    }
}
