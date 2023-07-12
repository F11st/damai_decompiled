package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Checks;
import org.jetbrains.annotations.NotNull;
import tb.ki;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class x1 {
    @NotNull
    public final ki a(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "functionDescriptor");
        for (Checks checks : b()) {
            if (checks.b(functionDescriptor)) {
                return checks.a(functionDescriptor);
            }
        }
        return ki.C9361a.INSTANCE;
    }

    @NotNull
    public abstract List<Checks> b();
}
