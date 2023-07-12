package kotlinx.coroutines;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ag0;
import tb.b41;
import tb.dg;
import tb.eo2;
import tb.hd0;
import tb.jn1;
import tb.k40;
import tb.kj2;
import tb.pa1;
import tb.pm2;
import tb.ry1;
import tb.sm2;
import tb.wt2;
import tb.zk1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class EventLoopImplBase extends n implements Delay {
    private static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    private static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ltb/wt2;", "run", "", "toString", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes8.dex */
    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<wt2> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(long j, @NotNull CancellableContinuation<? super wt2> cancellableContinuation) {
            super(j);
            this.cont = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, wt2.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        @NotNull
        public String toString() {
            return super.toString() + this.cont.toString();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ltb/wt2;", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Ljava/lang/Runnable;", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes8.dex */
    private static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long j, @NotNull Runnable runnable) {
            super(j);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        @NotNull
        public String toString() {
            return super.toString() + this.block.toString();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R0\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010!2\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "other", "", "compareTo", "", "now", "", "timeToExecute", "Lkotlinx/coroutines/EventLoopImplBase$a;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "Ltb/wt2;", "dispose", "", "toString", "", "_heap", "Ljava/lang/Object;", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "J", "Ltb/sm2;", "value", "getHeap", "()Ltb/sm2;", "setHeap", "(Ltb/sm2;)V", "heap", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes8.dex */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private Object _heap;
        private int index = -1;
        @JvmField
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            kj2 kj2Var;
            kj2 kj2Var2;
            Object obj = this._heap;
            kj2Var = ag0.a;
            if (obj == kj2Var) {
                return;
            }
            if (!(obj instanceof a)) {
                obj = null;
            }
            a aVar = (a) obj;
            if (aVar != null) {
                aVar.g(this);
            }
            kj2Var2 = ag0.a;
            this._heap = kj2Var2;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        @Nullable
        public sm2<?> getHeap() {
            Object obj = this._heap;
            if (!(obj instanceof sm2)) {
                obj = null;
            }
            return (sm2) obj;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        public final synchronized int scheduleTask(long j, @NotNull a aVar, @NotNull EventLoopImplBase eventLoopImplBase) {
            kj2 kj2Var;
            Object obj = this._heap;
            kj2Var = ag0.a;
            if (obj == kj2Var) {
                return 2;
            }
            synchronized (aVar) {
                DelayedTask b = aVar.b();
                if (eventLoopImplBase.isCompleted()) {
                    return 1;
                }
                if (b == null) {
                    aVar.b = j;
                } else {
                    long j2 = b.nanoTime;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - aVar.b > 0) {
                        aVar.b = j;
                    }
                }
                long j3 = this.nanoTime;
                long j4 = aVar.b;
                if (j3 - j4 < 0) {
                    this.nanoTime = j4;
                }
                aVar.a(this);
                return 0;
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(@Nullable sm2<?> sm2Var) {
            kj2 kj2Var;
            Object obj = this._heap;
            kj2Var = ag0.a;
            if (obj != kj2Var) {
                this._heap = sm2Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        public final boolean timeToExecute(long j) {
            return j - this.nanoTime >= 0;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + jn1.ARRAY_END;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull DelayedTask delayedTask) {
            int i = ((this.nanoTime - delayedTask.nanoTime) > 0L ? 1 : ((this.nanoTime - delayedTask.nanoTime) == 0L ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a extends sm2<DelayedTask> {
        @JvmField
        public long b;

        public a(long j) {
            this.b = j;
        }
    }

    private final void closeQueue() {
        kj2 kj2Var;
        kj2 kj2Var2;
        if (k40.a() && !isCompleted()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
                kj2Var = ag0.b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, kj2Var)) {
                    return;
                }
            } else if (!(obj instanceof pa1)) {
                kj2Var2 = ag0.b;
                if (obj == kj2Var2) {
                    return;
                }
                pa1 pa1Var = new pa1(8, true);
                pa1Var.a((Runnable) obj);
                if (_queue$FU.compareAndSet(this, obj, pa1Var)) {
                    return;
                }
            } else {
                ((pa1) obj).d();
                return;
            }
        }
    }

    private final Runnable dequeue() {
        kj2 kj2Var;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof pa1)) {
                kj2Var = ag0.b;
                if (obj == kj2Var) {
                    return null;
                }
                if (_queue$FU.compareAndSet(this, obj, null)) {
                    return (Runnable) obj;
                }
            } else {
                pa1 pa1Var = (pa1) obj;
                Object j = pa1Var.j();
                if (j != pa1.REMOVE_FROZEN) {
                    return (Runnable) j;
                }
                _queue$FU.compareAndSet(this, obj, pa1Var.i());
            }
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        kj2 kj2Var;
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof pa1)) {
                kj2Var = ag0.b;
                if (obj == kj2Var) {
                    return false;
                }
                pa1 pa1Var = new pa1(8, true);
                pa1Var.a((Runnable) obj);
                pa1Var.a(runnable);
                if (_queue$FU.compareAndSet(this, obj, pa1Var)) {
                    return true;
                }
            } else {
                pa1 pa1Var2 = (pa1) obj;
                int a2 = pa1Var2.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    _queue$FU.compareAndSet(this, obj, pa1Var2.i());
                } else if (a2 == 2) {
                    return false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isCompleted() {
        return this._isCompleted;
    }

    private final void rescheduleAllDelayed() {
        DelayedTask i;
        TimeSource a2 = eo2.a();
        long nanoTime = a2 != null ? a2.nanoTime() : System.nanoTime();
        while (true) {
            a aVar = (a) this._delayed;
            if (aVar == null || (i = aVar.i()) == null) {
                return;
            }
            reschedule(nanoTime, i);
        }
    }

    private final int scheduleImpl(long j, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        a aVar = (a) this._delayed;
        if (aVar == null) {
            _delayed$FU.compareAndSet(this, null, new a(j));
            Object obj = this._delayed;
            b41.f(obj);
            aVar = (a) obj;
        }
        return delayedTask.scheduleTask(j, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCompleted(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        a aVar = (a) this._delayed;
        return (aVar != null ? aVar.e() : null) == delayedTask;
    }

    @Override // kotlinx.coroutines.Delay
    @Nullable
    public Object delay(long j, @NotNull Continuation<? super wt2> continuation) {
        return Delay.a.a(this, j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        enqueue(runnable);
    }

    public final void enqueue(@NotNull Runnable runnable) {
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    @Override // kotlinx.coroutines.m
    protected long getNextTime() {
        DelayedTask e;
        kj2 kj2Var;
        if (super.getNextTime() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof pa1)) {
                kj2Var = ag0.b;
                if (obj == kj2Var) {
                    return AbsPerformance.LONG_NIL;
                }
                return 0L;
            } else if (!((pa1) obj).g()) {
                return 0L;
            }
        }
        a aVar = (a) this._delayed;
        if (aVar == null || (e = aVar.e()) == null) {
            return AbsPerformance.LONG_NIL;
        }
        long j = e.nanoTime;
        TimeSource a2 = eo2.a();
        return ry1.b(j - (a2 != null ? a2.nanoTime() : System.nanoTime()), 0L);
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.a.b(this, j, runnable, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.m
    public boolean isEmpty() {
        kj2 kj2Var;
        if (isUnconfinedQueueEmpty()) {
            a aVar = (a) this._delayed;
            if (aVar == null || aVar.d()) {
                Object obj = this._queue;
                if (obj != null) {
                    if (obj instanceof pa1) {
                        return ((pa1) obj).g();
                    }
                    kj2Var = ag0.b;
                    if (obj != kj2Var) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0057  */
    @Override // kotlinx.coroutines.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long processNextEvent() {
        /*
            r9 = this;
            boolean r0 = r9.processUnconfinedEvent()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.EventLoopImplBase$a r0 = (kotlinx.coroutines.EventLoopImplBase.a) r0
            if (r0 == 0) goto L4d
            boolean r3 = r0.d()
            if (r3 != 0) goto L4d
            kotlinx.coroutines.TimeSource r3 = tb.eo2.a()
            if (r3 == 0) goto L20
            long r3 = r3.nanoTime()
            goto L24
        L20:
            long r3 = java.lang.System.nanoTime()
        L24:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.b()     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            if (r5 == 0) goto L44
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r5.timeToExecute(r3)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            if (r7 == 0) goto L3a
            boolean r5 = r9.enqueueImpl(r5)     // Catch: java.lang.Throwable -> L4a
            goto L3b
        L3a:
            r5 = 0
        L3b:
            if (r5 == 0) goto L42
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.h(r8)     // Catch: java.lang.Throwable -> L4a
            r6 = r5
        L42:
            monitor-exit(r0)
            goto L45
        L44:
            monitor-exit(r0)
        L45:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6
            if (r6 == 0) goto L4d
            goto L24
        L4a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L4d:
            java.lang.Runnable r0 = r9.dequeue()
            if (r0 == 0) goto L57
            r0.run()
            return r1
        L57:
            long r0 = r9.getNextTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    public final void schedule(long j, @NotNull DelayedTask delayedTask) {
        int scheduleImpl = scheduleImpl(j, delayedTask);
        if (scheduleImpl == 0) {
            if (shouldUnpark(delayedTask)) {
                unpark();
            }
        } else if (scheduleImpl == 1) {
            reschedule(j, delayedTask);
        } else if (scheduleImpl != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final DisposableHandle scheduleInvokeOnTimeout(long j, @NotNull Runnable runnable) {
        long d = ag0.d(j);
        if (d < hd0.MAX_MILLIS) {
            TimeSource a2 = eo2.a();
            long nanoTime = a2 != null ? a2.nanoTime() : System.nanoTime();
            DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(d + nanoTime, runnable);
            schedule(nanoTime, delayedRunnableTask);
            return delayedRunnableTask;
        }
        return zk1.INSTANCE;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super wt2> cancellableContinuation) {
        long d = ag0.d(j);
        if (d < hd0.MAX_MILLIS) {
            TimeSource a2 = eo2.a();
            long nanoTime = a2 != null ? a2.nanoTime() : System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(d + nanoTime, cancellableContinuation);
            dg.a(cancellableContinuation, delayedResumeTask);
            schedule(nanoTime, delayedResumeTask);
        }
    }

    @Override // kotlinx.coroutines.m
    protected void shutdown() {
        pm2.INSTANCE.c();
        setCompleted(true);
        closeQueue();
        do {
        } while (processNextEvent() <= 0);
        rescheduleAllDelayed();
    }
}
