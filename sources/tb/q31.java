package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class q31 extends s31<Integer> {
    public q31(int i) {
        super(Integer.valueOf(i));
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 D = moduleDescriptor.getBuiltIns().D();
        b41.h(D, "module.builtIns.intType");
        return D;
    }
}
