package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class gc1 extends s31<Long> {
    public gc1(long j) {
        super(Long.valueOf(j));
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 F = moduleDescriptor.getBuiltIns().F();
        b41.h(F, "module.builtIns.longType");
        return F;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().longValue() + ".toLong()";
    }
}
