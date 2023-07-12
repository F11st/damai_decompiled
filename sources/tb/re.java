package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class re extends s31<Byte> {
    public re(byte b) {
        super(Byte.valueOf(b));
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 t = moduleDescriptor.getBuiltIns().t();
        b41.h(t, "module.builtIns.byteType");
        return t;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().intValue() + ".toByte()";
    }
}
