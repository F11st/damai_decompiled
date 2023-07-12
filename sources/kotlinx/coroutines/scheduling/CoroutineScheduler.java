package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import com.huawei.hms.opendevice.c;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.random.Random;
import kotlinx.coroutines.TimeSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.eo2;
import tb.jn1;
import tb.ju0;
import tb.k40;
import tb.k50;
import tb.kj2;
import tb.ml2;
import tb.o40;
import tb.qo;
import tb.t13;
import tb.ty1;
import tb.wt2;
import tb.yk1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class CoroutineScheduler implements Closeable, Executor {
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    private volatile int _isTerminated;
    @JvmField
    @NotNull
    public final ju0 a;
    @JvmField
    @NotNull
    public final ju0 b;
    @JvmField
    @NotNull
    public final AtomicReferenceArray<Worker> c;
    volatile long controlState;
    @JvmField
    public final int d;
    @JvmField
    public final int e;
    @JvmField
    public final long f;
    @JvmField
    @NotNull
    public final String g;
    private volatile long parkedWorkersStack;
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final kj2 NOT_IN_STACK = new kj2("NOT_IN_STACK");
    private static final AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    static final AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    private static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes11.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public CoroutineScheduler(int i2, int i3, long j2, @NotNull String str) {
        this.d = i2;
        this.e = i3;
        this.f = j2;
        this.g = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 > 0) {
            this.a = new ju0();
            this.b = new ju0();
            this.parkedWorkersStack = 0L;
            this.c = new AtomicReferenceArray<>(i3 + 1);
            this.controlState = i2 << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
    }

    private final boolean b(Task task) {
        if (task.taskContext.getTaskMode() == 1) {
            return this.b.a(task);
        }
        return this.a.a(task);
    }

    private final int c() {
        int a2;
        synchronized (this.c) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            a2 = ty1.a(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (a2 >= this.d) {
                return 0;
            }
            if (i2 >= this.e) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.c.get(i3) == null) {
                Worker worker = new Worker(this, i3);
                this.c.set(i3, worker);
                if (i3 == ((int) (2097151 & i.incrementAndGet(this)))) {
                    worker.start();
                    return a2 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Worker e() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof Worker)) {
            currentThread = null;
        }
        Worker worker = (Worker) currentThread;
        if (worker == null || !b41.d(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public static /* synthetic */ void g(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = yk1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.f(runnable, taskContext, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        return (int) (this.controlState & 2097151);
    }

    private final int k(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    private final Worker l() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            Worker worker = this.c.get((int) (2097151 & j2));
            if (worker == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            int k = k(worker);
            if (k >= 0 && h.compareAndSet(this, j2, k | j3)) {
                worker.setNextParkedWorker(NOT_IN_STACK);
                return worker;
            }
        }
    }

    private final void q(boolean z) {
        long addAndGet = i.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (z || v() || t(addAndGet)) {
            return;
        }
        v();
    }

    private final Task s(Worker worker, Task task, boolean z) {
        if (worker == null || worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.a(task, z);
    }

    private final boolean t(long j2) {
        int a2;
        a2 = ty1.a(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0);
        if (a2 < this.d) {
            int c = c();
            if (c == 1 && this.d > 1) {
                c();
            }
            if (c > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean u(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.t(j2);
    }

    private final boolean v() {
        Worker l;
        do {
            l = l();
            if (l == null) {
                return false;
            }
        } while (!Worker.workerCtl$FU.compareAndSet(l, -1, 0));
        LockSupport.unpark(l);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        p(10000L);
    }

    @NotNull
    public final Task d(@NotNull Runnable runnable, @NotNull TaskContext taskContext) {
        long a2 = ml2.a.a();
        if (runnable instanceof Task) {
            Task task = (Task) runnable;
            task.submissionTime = a2;
            task.taskContext = taskContext;
            return task;
        }
        return new TaskImpl(runnable, a2, taskContext);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        g(this, runnable, null, false, 6, null);
    }

    public final void f(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        TimeSource a2 = eo2.a();
        if (a2 != null) {
            a2.trackTask();
        }
        Task d = d(runnable, taskContext);
        Worker e = e();
        Task s = s(e, d, z);
        if (s != null && !b(s)) {
            throw new RejectedExecutionException(this.g + " was terminated");
        }
        boolean z2 = z && e != null;
        if (d.taskContext.getTaskMode() != 0) {
            q(z2);
        } else if (z2) {
        } else {
            r();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean m(@NotNull Worker worker) {
        long j2;
        long j3;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            indexInArray = worker.getIndexInArray();
            if (k40.a()) {
                if (!(indexInArray != 0)) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.c.get(i2));
        } while (!h.compareAndSet(this, j2, indexInArray | j3));
        return true;
    }

    public final void n(@NotNull Worker worker, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            if (i4 == i2) {
                i4 = i3 == 0 ? k(worker) : i3;
            }
            if (i4 >= 0 && h.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    public final void o(@NotNull Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                TimeSource a2 = eo2.a();
                if (a2 == null) {
                }
            } finally {
                TimeSource a3 = eo2.a();
                if (a3 != null) {
                    a3.unTrackTask();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006b, code lost:
        if (r9 != null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.j
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = r8.e()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r3 = r8.c
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb5
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L5b
            r3 = 1
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r4 = r8.c
            java.lang.Object r4 = r4.get(r3)
            tb.b41.f(r4)
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r4
            if (r4 == r0) goto L56
        L2a:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L37
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r9)
            goto L2a
        L37:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r4.state
            boolean r7 = tb.k40.a()
            if (r7 == 0) goto L4f
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L45
            r6 = 1
            goto L46
        L45:
            r6 = 0
        L46:
            if (r6 == 0) goto L49
            goto L4f
        L49:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L4f:
            tb.t13 r4 = r4.localQueue
            tb.ju0 r6 = r8.b
            r4.g(r6)
        L56:
            if (r3 == r5) goto L5b
            int r3 = r3 + 1
            goto L1d
        L5b:
            tb.ju0 r9 = r8.b
            r9.b()
            tb.ju0 r9 = r8.a
            r9.b()
        L65:
            if (r0 == 0) goto L6e
            kotlinx.coroutines.scheduling.Task r9 = r0.findTask(r2)
            if (r9 == 0) goto L6e
            goto L76
        L6e:
            tb.ju0 r9 = r8.a
            java.lang.Object r9 = r9.d()
            kotlinx.coroutines.scheduling.Task r9 = (kotlinx.coroutines.scheduling.Task) r9
        L76:
            if (r9 == 0) goto L79
            goto L81
        L79:
            tb.ju0 r9 = r8.b
            java.lang.Object r9 = r9.d()
            kotlinx.coroutines.scheduling.Task r9 = (kotlinx.coroutines.scheduling.Task) r9
        L81:
            if (r9 == 0) goto L87
            r8.o(r9)
            goto L65
        L87:
            if (r0 == 0) goto L8e
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.tryReleaseCpu$kotlinx_coroutines_core(r9)
        L8e:
            boolean r9 = tb.k40.a()
            if (r9 == 0) goto Lae
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r9 = r8.d
            if (r10 != r9) goto La5
            r1 = 1
        La5:
            if (r1 == 0) goto La8
            goto Lae
        La8:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        Lae:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        Lb5:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.p(long):void");
    }

    public final void r() {
        if (v() || u(this, 0L, 1, null)) {
            return;
        }
        v();
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.c.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < length; i7++) {
            Worker worker = this.c.get(i7);
            if (worker != null) {
                int f = worker.localQueue.f();
                int i8 = qo.$EnumSwitchMapping$0[worker.state.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    arrayList.add(String.valueOf(f) + "b");
                } else if (i8 == 3) {
                    i2++;
                    arrayList.add(String.valueOf(f) + c.a);
                } else if (i8 == 4) {
                    i5++;
                    if (f > 0) {
                        arrayList.add(String.valueOf(f) + "d");
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return this.g + '@' + o40.b(this) + jn1.ARRAY_START + "Pool Size {core = " + this.d + AVFSCacheConstants.COMMA_SEP + "max = " + this.e + "}, Worker States {CPU = " + i2 + AVFSCacheConstants.COMMA_SEP + "blocking = " + i3 + AVFSCacheConstants.COMMA_SEP + "parked = " + i4 + AVFSCacheConstants.COMMA_SEP + "dormant = " + i5 + AVFSCacheConstants.COMMA_SEP + "terminated = " + i6 + "}, running workers queues = " + arrayList + AVFSCacheConstants.COMMA_SEP + "global CPU queue size = " + this.a.c() + AVFSCacheConstants.COMMA_SEP + "global blocking queue size = " + this.b.c() + AVFSCacheConstants.COMMA_SEP + "Control State {created workers= " + ((int) (2097151 & j2)) + AVFSCacheConstants.COMMA_SEP + "blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + AVFSCacheConstants.COMMA_SEP + "CPUs acquired = " + (this.d - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bC\u0010DB\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\bC\u0010EJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u0007J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0000¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u0019R*\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\u0011R\u0016\u0010/\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010;\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00103R\u0016\u0010<\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010+R\u0016\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020?8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "", "tryAcquireCpuPermit", "()Z", "Ltb/wt2;", "runWorker", "()V", "tryPark", "inStack", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "taskMode", "beforeTask", "(I)V", "afterTask", "park", "tryTerminateWorker", "mode", "idleReset", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "blockingOnly", "trySteal", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "run", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "findTask", "index", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "terminationDeadline", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "mayHaveLocalTasks", "Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes11.dex */
    public final class Worker extends Thread {
        static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;
        @JvmField
        @NotNull
        public final t13 localQueue;
        @JvmField
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        @Nullable
        private volatile Object nextParkedWorker;
        private int rngState;
        @JvmField
        @NotNull
        public WorkerState state;
        private long terminationDeadline;
        @NotNull
        volatile int workerCtl;

        private Worker() {
            setDaemon(true);
            this.localQueue = new t13();
            this.state = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        private final void afterTask(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.i.addAndGet(CoroutineScheduler.this, -2097152L);
            WorkerState workerState = this.state;
            if (workerState != WorkerState.TERMINATED) {
                if (k40.a()) {
                    if (!(workerState == WorkerState.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.DORMANT;
            }
        }

        private final void beforeTask(int i) {
            if (i != 0 && tryReleaseCpu$kotlinx_coroutines_core(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.r();
            }
        }

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.o(task);
            afterTask(taskMode);
        }

        private final Task findAnyTask(boolean z) {
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (z) {
                boolean z2 = nextInt$kotlinx_coroutines_core(CoroutineScheduler.this.d * 2) == 0;
                if (z2 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task h = this.localQueue.h();
                if (h != null) {
                    return h;
                }
                if (!z2 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(false);
        }

        private final void idleReset(int i) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                if (k40.a()) {
                    if (!(i == 1)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.f;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if (nextInt$kotlinx_coroutines_core(2) == 0) {
                Task d = CoroutineScheduler.this.a.d();
                return d != null ? d : CoroutineScheduler.this.b.d();
            }
            Task d2 = CoroutineScheduler.this.b.d();
            return d2 != null ? d2 : CoroutineScheduler.this.a.d();
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            tryPark();
                        } else if (z) {
                            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }

        private final boolean tryAcquireCpuPermit() {
            boolean z;
            if (this.state != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                        if (CoroutineScheduler.i.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.state = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.m(this);
                return;
            }
            if (k40.a()) {
                if (!(this.localQueue.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (inStack() && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final Task trySteal(boolean z) {
            long l;
            if (k40.a()) {
                if (!(this.localQueue.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int j = CoroutineScheduler.this.j();
            if (j < 2) {
                return null;
            }
            int nextInt$kotlinx_coroutines_core = nextInt$kotlinx_coroutines_core(j);
            long j2 = Long.MAX_VALUE;
            for (int i = 0; i < j; i++) {
                nextInt$kotlinx_coroutines_core++;
                if (nextInt$kotlinx_coroutines_core > j) {
                    nextInt$kotlinx_coroutines_core = 1;
                }
                Worker worker = CoroutineScheduler.this.c.get(nextInt$kotlinx_coroutines_core);
                if (worker != null && worker != this) {
                    if (k40.a()) {
                        if (!(this.localQueue.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        l = this.localQueue.k(worker.localQueue);
                    } else {
                        l = this.localQueue.l(worker.localQueue);
                    }
                    if (l == -1) {
                        return this.localQueue.h();
                    }
                    if (l > 0) {
                        j2 = Math.min(j2, l);
                    }
                }
            }
            if (j2 == AbsPerformance.LONG_NIL) {
                j2 = 0;
            }
            this.minDelayUntilStealableTaskNs = j2;
            return null;
        }

        private final void tryTerminateWorker() {
            synchronized (CoroutineScheduler.this.c) {
                if (CoroutineScheduler.this.isTerminated()) {
                    return;
                }
                if (CoroutineScheduler.this.j() <= CoroutineScheduler.this.d) {
                    return;
                }
                if (workerCtl$FU.compareAndSet(this, -1, 1)) {
                    int i = this.indexInArray;
                    setIndexInArray(0);
                    CoroutineScheduler.this.n(this, i, 0);
                    int andDecrement = (int) (CoroutineScheduler.i.getAndDecrement(CoroutineScheduler.this) & 2097151);
                    if (andDecrement != i) {
                        Worker worker = CoroutineScheduler.this.c.get(andDecrement);
                        b41.f(worker);
                        Worker worker2 = worker;
                        CoroutineScheduler.this.c.set(i, worker2);
                        worker2.setIndexInArray(i);
                        CoroutineScheduler.this.n(worker2, andDecrement, i);
                    }
                    CoroutineScheduler.this.c.set(andDecrement, null);
                    wt2 wt2Var = wt2.INSTANCE;
                    this.state = WorkerState.TERMINATED;
                }
            }
        }

        @Nullable
        public final Task findTask(boolean z) {
            Task d;
            if (tryAcquireCpuPermit()) {
                return findAnyTask(z);
            }
            if (z) {
                d = this.localQueue.h();
                if (d == null) {
                    d = CoroutineScheduler.this.b.d();
                }
            } else {
                d = CoroutineScheduler.this.b.d();
            }
            return d != null ? d : trySteal(true);
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        @NotNull
        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final int nextInt$kotlinx_coroutines_core(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.g);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }
    }
}
