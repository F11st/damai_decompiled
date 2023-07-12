package kotlinx.coroutines;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.am;
import tb.b41;
import tb.eo2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class d<T> extends a<T> {
    private final Thread a;
    private final m b;

    public d(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable m mVar) {
        super(coroutineContext, true);
        this.a = thread;
        this.b = mVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T a() {
        TimeSource a = eo2.a();
        if (a != null) {
            a.registerTimeLoopThread();
        }
        try {
            m mVar = this.b;
            if (mVar != null) {
                m.incrementUseCount$default(mVar, false, 1, null);
            }
            while (!Thread.interrupted()) {
                m mVar2 = this.b;
                long processNextEvent = mVar2 != null ? mVar2.processNextEvent() : AbsPerformance.LONG_NIL;
                if (isCompleted()) {
                    m mVar3 = this.b;
                    if (mVar3 != null) {
                        m.decrementUseCount$default(mVar3, false, 1, null);
                    }
                    T t = (T) s.h(getState$kotlinx_coroutines_core());
                    am amVar = t instanceof am ? t : null;
                    if (amVar == null) {
                        return t;
                    }
                    throw amVar.a;
                }
                TimeSource a2 = eo2.a();
                if (a2 != null) {
                    a2.parkNanos(this, processNextEvent);
                } else {
                    LockSupport.parkNanos(this, processNextEvent);
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } finally {
            TimeSource a3 = eo2.a();
            if (a3 != null) {
                a3.unregisterTimeLoopThread();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object obj) {
        if (!b41.d(Thread.currentThread(), this.a)) {
            LockSupport.unpark(this.a);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean isScopedCoroutine() {
        return true;
    }
}
