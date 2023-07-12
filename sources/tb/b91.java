package tb;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class b91 extends ExecutorCoroutineDispatcher implements Executor, TaskContext {
    private static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(b91.class, "inFlightTasks");
    private final ug0 b;
    private final int c;
    private final String d;
    private final int e;
    private final ConcurrentLinkedQueue<Runnable> a = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    public b91(@NotNull ug0 ug0Var, int i, @Nullable String str, int i2) {
        this.b = ug0Var;
        this.c = i;
        this.d = str;
        this.e = i2;
    }

    private final void a(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.c) {
                this.b.b(runnable, this, z);
                return;
            }
            this.a.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.c) {
                return;
            }
            runnable = this.a.poll();
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
        Runnable poll = this.a.poll();
        if (poll != null) {
            this.b.b(poll, this, true);
            return;
        }
        f.decrementAndGet(this);
        Runnable poll2 = this.a.poll();
        if (poll2 != null) {
            a(poll2, true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        a(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.e;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.b + jn1.ARRAY_END;
    }
}
