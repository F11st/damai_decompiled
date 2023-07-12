package tb;

import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class zc extends EventLoopImplBase {
    @NotNull
    private final Thread a;

    public zc(@NotNull Thread thread) {
        this.a = thread;
    }

    @Override // kotlinx.coroutines.n
    @NotNull
    protected Thread getThread() {
        return this.a;
    }
}
