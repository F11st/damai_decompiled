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
/* renamed from: kotlinx.coroutines.d */
/* loaded from: classes8.dex */
public final class C8649d<T> extends AbstractC8619a<T> {
    private final Thread a;
    private final AbstractC8699m b;

    public C8649d(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable AbstractC8699m abstractC8699m) {
        super(coroutineContext, true);
        this.a = thread;
        this.b = abstractC8699m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T a() {
        TimeSource a = eo2.a();
        if (a != null) {
            a.registerTimeLoopThread();
        }
        try {
            AbstractC8699m abstractC8699m = this.b;
            if (abstractC8699m != null) {
                AbstractC8699m.incrementUseCount$default(abstractC8699m, false, 1, null);
            }
            while (!Thread.interrupted()) {
                AbstractC8699m abstractC8699m2 = this.b;
                long processNextEvent = abstractC8699m2 != null ? abstractC8699m2.processNextEvent() : AbsPerformance.LONG_NIL;
                if (isCompleted()) {
                    AbstractC8699m abstractC8699m3 = this.b;
                    if (abstractC8699m3 != null) {
                        AbstractC8699m.decrementUseCount$default(abstractC8699m3, false, 1, null);
                    }
                    T t = (T) C8705s.h(getState$kotlinx_coroutines_core());
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
