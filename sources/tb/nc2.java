package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class nc2 extends s31<Short> {
    public nc2(short s) {
        super(Short.valueOf(s));
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 T = moduleDescriptor.getBuiltIns().T();
        b41.h(T, "module.builtIns.shortType");
        return T;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().intValue() + ".toShort()";
    }
}
