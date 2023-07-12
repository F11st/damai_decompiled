package tb;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class y7 extends fn<List<? extends fn<?>>> {
    @NotNull
    private final Function1<ModuleDescriptor, z71> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public y7(@NotNull List<? extends fn<?>> list, @NotNull Function1<? super ModuleDescriptor, ? extends z71> function1) {
        super(list);
        b41.i(list, "value");
        b41.i(function1, "computeType");
        this.b = function1;
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        z71 invoke = this.b.invoke(moduleDescriptor);
        if (!AbstractC8271b.c0(invoke) && !AbstractC8271b.o0(invoke)) {
            AbstractC8271b.B0(invoke);
        }
        return invoke;
    }
}
