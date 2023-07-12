package tb;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* loaded from: classes11.dex */
public class ug0 extends ExecutorCoroutineDispatcher {
    private CoroutineScheduler a;
    private final int b;
    private final int c;
    private final long d;
    private final String e;

    public ug0(int i, int i2, long j, @NotNull String str) {
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = str;
        this.a = a();
    }

    private final CoroutineScheduler a() {
        return new CoroutineScheduler(this.b, this.c, this.d, this.e);
    }

    public final void b(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        try {
            this.a.f(runnable, taskContext, z);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.enqueue(this.a.d(runnable, taskContext));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.g(this.a, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.g(this.a, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatchYield(coroutineContext, runnable);
        }
    }

    public /* synthetic */ ug0(int i, int i2, String str, int i3, k50 k50Var) {
        this((i3 & 1) != 0 ? ml2.CORE_POOL_SIZE : i, (i3 & 2) != 0 ? ml2.MAX_POOL_SIZE : i2, (i3 & 4) != 0 ? ml2.DEFAULT_SCHEDULER_NAME : str);
    }

    public ug0(int i, int i2, @NotNull String str) {
        this(i, i2, ml2.IDLE_WORKER_KEEP_ALIVE_NS, str);
    }
}
