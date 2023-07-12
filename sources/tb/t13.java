package tb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.scheduling.Task;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class t13 {
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(t13.class, Object.class, "lastScheduledTask");
    private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(t13.class, "producerIndex");
    private static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(t13.class, "consumerIndex");
    private static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(t13.class, "blockingTasksInBuffer");
    private final AtomicReferenceArray<Task> a = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    public static /* synthetic */ Task b(t13 t13Var, Task task, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return t13Var.a(task, z);
    }

    private final Task c(Task task) {
        if (task.taskContext.getTaskMode() == 1) {
            e.incrementAndGet(this);
        }
        if (e() == 127) {
            return task;
        }
        int i = this.producerIndex & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, task);
        c.incrementAndGet(this);
        return null;
    }

    private final void d(Task task) {
        if (task != null) {
            if (task.taskContext.getTaskMode() == 1) {
                int decrementAndGet = e.decrementAndGet(this);
                if (k40.a()) {
                    if (!(decrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final Task i() {
        Task andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.a.getAndSet(i2, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(ju0 ju0Var) {
        Task i = i();
        if (i != null) {
            ju0Var.a(i);
            return true;
        }
        return false;
    }

    private final long m(t13 t13Var, boolean z) {
        Task task;
        do {
            task = (Task) t13Var.lastScheduledTask;
            if (task == null) {
                return -2L;
            }
            if (z) {
                if (!(task.taskContext.getTaskMode() == 1)) {
                    return -2L;
                }
            }
            long a = ml2.a.a() - task.submissionTime;
            long j = ml2.WORK_STEALING_TIME_RESOLUTION_NS;
            if (a < j) {
                return j - a;
            }
        } while (!b.compareAndSet(t13Var, task, null));
        b(this, task, false, 2, null);
        return -1L;
    }

    @Nullable
    public final Task a(@NotNull Task task, boolean z) {
        if (z) {
            return c(task);
        }
        Task task2 = (Task) b.getAndSet(this, task);
        if (task2 != null) {
            return c(task2);
        }
        return null;
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@NotNull ju0 ju0Var) {
        Task task = (Task) b.getAndSet(this, null);
        if (task != null) {
            ju0Var.a(task);
        }
        do {
        } while (j(ju0Var));
    }

    @Nullable
    public final Task h() {
        Task task = (Task) b.getAndSet(this, null);
        return task != null ? task : i();
    }

    public final long k(@NotNull t13 t13Var) {
        if (k40.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i = t13Var.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = t13Var.a;
        for (int i2 = t13Var.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (t13Var.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i3);
            if (task != null) {
                if ((task.taskContext.getTaskMode() == 1) && atomicReferenceArray.compareAndSet(i3, task, null)) {
                    e.decrementAndGet(t13Var);
                    b(this, task, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(t13Var, true);
    }

    public final long l(@NotNull t13 t13Var) {
        if (k40.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        Task i = t13Var.i();
        if (i != null) {
            Task b2 = b(this, i, false, 2, null);
            if (k40.a()) {
                if (b2 == null) {
                    return -1L;
                }
                throw new AssertionError();
            }
            return -1L;
        }
        return m(t13Var, false);
    }
}
