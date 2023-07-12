package kotlinx.coroutines;

import com.youku.arch.v3.data.Constants;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import org.jetbrains.annotations.NotNull;
import tb.k40;
import tb.u7;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class m extends CoroutineDispatcher {
    private boolean shared;
    private u7<DispatchedTask<?>> unconfinedQueue;
    private long useCount;

    public static /* synthetic */ void decrementUseCount$default(m mVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            mVar.decrementUseCount(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long delta(boolean z) {
        if (z) {
            return Constants.RequestStrategy.LOCAL_FIRST;
        }
        return 1L;
    }

    public static /* synthetic */ void incrementUseCount$default(m mVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            mVar.incrementUseCount(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void decrementUseCount(boolean z) {
        long delta = this.useCount - delta(z);
        this.useCount = delta;
        if (delta > 0) {
            return;
        }
        if (k40.a()) {
            if (!(this.useCount == 0)) {
                throw new AssertionError();
            }
        }
        if (this.shared) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(@NotNull DispatchedTask<?> dispatchedTask) {
        u7<DispatchedTask<?>> u7Var = this.unconfinedQueue;
        if (u7Var == null) {
            u7Var = new u7<>();
            this.unconfinedQueue = u7Var;
        }
        u7Var.a(dispatchedTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getNextTime() {
        u7<DispatchedTask<?>> u7Var = this.unconfinedQueue;
        if (u7Var == null || u7Var.c()) {
            return AbsPerformance.LONG_NIL;
        }
        return 0L;
    }

    public final void incrementUseCount(boolean z) {
        this.useCount += delta(z);
        if (z) {
            return;
        }
        this.shared = true;
    }

    public final boolean isActive() {
        return this.useCount > 0;
    }

    protected boolean isEmpty() {
        return isUnconfinedQueueEmpty();
    }

    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= delta(true);
    }

    public final boolean isUnconfinedQueueEmpty() {
        u7<DispatchedTask<?>> u7Var = this.unconfinedQueue;
        if (u7Var != null) {
            return u7Var.c();
        }
        return true;
    }

    public long processNextEvent() {
        if (processUnconfinedEvent()) {
            return 0L;
        }
        return AbsPerformance.LONG_NIL;
    }

    public final boolean processUnconfinedEvent() {
        DispatchedTask<?> d;
        u7<DispatchedTask<?>> u7Var = this.unconfinedQueue;
        if (u7Var == null || (d = u7Var.d()) == null) {
            return false;
        }
        d.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    protected void shutdown() {
    }
}
