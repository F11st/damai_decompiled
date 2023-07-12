package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;
import tb.eo2;
import tb.k40;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.n */
/* loaded from: classes8.dex */
public abstract class AbstractC8700n extends AbstractC8699m {
    @NotNull
    protected abstract Thread getThread();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void reschedule(long j, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        if (k40.a()) {
            if (!(this != DefaultExecutor.INSTANCE)) {
                throw new AssertionError();
            }
        }
        DefaultExecutor.INSTANCE.schedule(j, delayedTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void unpark() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            TimeSource a = eo2.a();
            if (a != null) {
                a.unpark(thread);
            } else {
                LockSupport.unpark(thread);
            }
        }
    }
}
