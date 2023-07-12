package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import tb.du1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public final class SequentialExecutor implements Executor {
    private static final Logger f = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor a;
    @GuardedBy("queue")
    private final Deque<Runnable> b;
    @GuardedBy("queue")
    private WorkerRunningState c;
    @GuardedBy("queue")
    private long d;
    private final QueueWorker e;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private final class QueueWorker implements Runnable {
        private QueueWorker() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
            if (r1 == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
            r4 = com.google.common.util.concurrent.SequentialExecutor.f;
            r5 = java.util.logging.Level.SEVERE;
            r4.log(r5, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void workOnQueue() {
            /*
                r8 = this;
                r0 = 0
                r1 = 0
            L2:
                com.google.common.util.concurrent.SequentialExecutor r2 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L74
                java.util.Deque r2 = com.google.common.util.concurrent.SequentialExecutor.a(r2)     // Catch: java.lang.Throwable -> L74
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L74
                if (r0 != 0) goto L2b
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = com.google.common.util.concurrent.SequentialExecutor.b(r0)     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L71
                if (r0 != r3) goto L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L71
                if (r1 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.SequentialExecutor.d(r0)     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.SequentialExecutor.c(r0, r3)     // Catch: java.lang.Throwable -> L71
                r0 = 1
            L2b:
                com.google.common.util.concurrent.SequentialExecutor r3 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L71
                java.util.Deque r3 = com.google.common.util.concurrent.SequentialExecutor.a(r3)     // Catch: java.lang.Throwable -> L71
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L71
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L71
                if (r3 != 0) goto L4b
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.SequentialExecutor.c(r0, r3)     // Catch: java.lang.Throwable -> L71
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L71
                if (r1 == 0) goto L4a
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4a:
                return
            L4b:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L71
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L74
                r1 = r1 | r2
                r3.run()     // Catch: java.lang.RuntimeException -> L55 java.lang.Throwable -> L74
                goto L2
            L55:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.SequentialExecutor.e()     // Catch: java.lang.Throwable -> L74
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L74
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
                r6.<init>()     // Catch: java.lang.Throwable -> L74
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L74
                r6.append(r3)     // Catch: java.lang.Throwable -> L74
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L74
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L74
                goto L2
            L71:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L71
                throw r0     // Catch: java.lang.Throwable -> L74
            L74:
                r0 = move-exception
                if (r1 == 0) goto L7e
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L7e:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.b) {
                    SequentialExecutor.this.c = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    static /* synthetic */ long d(SequentialExecutor sequentialExecutor) {
        long j = sequentialExecutor.d;
        sequentialExecutor.d = 1 + j;
        return j;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        WorkerRunningState workerRunningState;
        du1.p(runnable);
        synchronized (this.b) {
            WorkerRunningState workerRunningState2 = this.c;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j = this.d;
                Runnable runnable2 = new Runnable() { // from class: com.google.common.util.concurrent.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                };
                this.b.add(runnable2);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.c = workerRunningState3;
                try {
                    this.a.execute(this.e);
                    if (this.c != workerRunningState3) {
                        return;
                    }
                    synchronized (this.b) {
                        if (this.d == j && this.c == workerRunningState3) {
                            this.c = workerRunningState;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.b) {
                        WorkerRunningState workerRunningState4 = this.c;
                        if ((workerRunningState4 != WorkerRunningState.IDLE && workerRunningState4 != WorkerRunningState.QUEUING) || !this.b.removeLastOccurrence(runnable2)) {
                            r0 = false;
                        }
                        if (!(e instanceof RejectedExecutionException) || r0) {
                            throw e;
                        }
                    }
                    return;
                }
            }
            this.b.add(runnable);
        }
    }
}
