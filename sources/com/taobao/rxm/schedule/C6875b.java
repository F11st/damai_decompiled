package com.taobao.rxm.schedule;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import tb.cu1;
import tb.hh0;

/* compiled from: Taobao */
/* renamed from: com.taobao.rxm.schedule.b */
/* loaded from: classes11.dex */
public class C6875b implements ExecutorStateInspector, Scheduler {
    private final ThreadPoolExecutor a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final CentralSchedulerQueue c;
    private final String d;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.rxm.schedule.b$a */
    /* loaded from: classes11.dex */
    class ThreadFactoryC6876a implements ThreadFactory {
        ThreadFactoryC6876a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, C6875b.this.d + C6875b.this.b.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.rxm.schedule.b$b */
    /* loaded from: classes11.dex */
    class RejectedExecutionHandlerC6877b implements RejectedExecutionHandler {
        RejectedExecutionHandlerC6877b(C6875b c6875b) {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            hh0.a("RxSysLog", "queue is full and no more available thread, directly run in thread(%s)", Thread.currentThread().getName());
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            runnable.run();
        }
    }

    public C6875b(String str, int i, int i2, int i3, int i4, int i5) {
        cu1.b(i >= 0, "corePoolSize must be >=0");
        cu1.b(i2 >= i, "maxPoolSize shouldn't be less than corePoolSize");
        this.d = str;
        CentralSchedulerQueue centralSchedulerQueue = new CentralSchedulerQueue(this, i4, i5);
        this.c = centralSchedulerQueue;
        this.a = new ThreadPoolExecutor(i, i2, i3, TimeUnit.SECONDS, centralSchedulerQueue, new ThreadFactoryC6876a(), new RejectedExecutionHandlerC6877b(this));
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public int getQueueSize() {
        return this.c.size();
    }

    @Override // com.taobao.rxm.schedule.ExecutorStateInspector, com.taobao.rxm.schedule.Scheduler
    public String getStatus() {
        return this.d + " status: queue=" + this.c.size() + " active=" + this.a.getActiveCount() + " pool=" + this.a.getPoolSize() + " largest=" + this.a.getLargestPoolSize();
    }

    @Override // com.taobao.rxm.schedule.ExecutorStateInspector
    public boolean isNotFull() {
        return this.a.getPoolSize() < this.a.getMaximumPoolSize();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public boolean isScheduleMainThread() {
        return false;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public void schedule(ScheduledAction scheduledAction) {
        if (hh0.g(3)) {
            hh0.a("RxSysLog", getStatus(), new Object[0]);
        }
        this.a.execute(scheduledAction);
    }
}
