package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ai2 extends fn<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai2(@NotNull String str) {
        super(str);
        b41.i(str, "value");
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 W = moduleDescriptor.getBuiltIns().W();
        b41.h(W, "module.builtIns.stringType");
        return W;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return jn1.QUOTE + b() + jn1.QUOTE;
    }
}
