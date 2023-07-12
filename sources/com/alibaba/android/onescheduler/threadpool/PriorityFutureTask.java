package com.alibaba.android.onescheduler.threadpool;

import com.alibaba.android.onescheduler.Priority;
import java.util.concurrent.Callable;
import tb.tf0;
import tb.vm1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PriorityFutureTask<V> extends ListenableFutureTask<V> {
    private Priority mGoupPriority;
    private Priority mPriority;
    private long mPrioritySequence;

    public PriorityFutureTask(Callable<V> callable) {
        super(callable);
    }

    public Priority getGoupPriority() {
        return this.mGoupPriority;
    }

    public Priority getPriority() {
        return this.mPriority;
    }

    public long getPrioritySequence() {
        return this.mPrioritySequence;
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        tf0.a().c(this);
        super.run();
        tf0.a().d(this);
        if (vm1.a) {
            try {
                get();
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public void setGoupPriority(Priority priority) {
        this.mGoupPriority = priority;
    }

    public void setPriority(Priority priority) {
        this.mPriority = priority;
    }

    public void setPrioritySequence(long j) {
        this.mPrioritySequence = j;
    }

    public PriorityFutureTask(Runnable runnable, V v) {
        super(runnable, v);
    }
}
