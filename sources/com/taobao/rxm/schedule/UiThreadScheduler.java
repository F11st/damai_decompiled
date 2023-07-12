package com.taobao.rxm.schedule;

import android.os.Handler;
import android.os.Looper;
import java.util.PriorityQueue;
import tb.j42;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UiThreadScheduler implements Scheduler, Runnable {
    private static final int MAX_COST_TIME = 8;
    private static final int MAX_RECURSIVE_DEPTH = 10;
    private static final int PRIORITY_QUEUE_CAPACITY = 200;
    private long mCostTime;
    private int mCurrRecursiveDepth;
    private boolean mExecutionInProgress;
    private final PriorityQueue<ScheduledAction> mPriorityQueue = new PriorityQueue<>(200);
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override // com.taobao.rxm.schedule.Scheduler
    public int getQueueSize() {
        return this.mPriorityQueue.size();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public String getStatus() {
        return "ui thread scheduler status:\nqueue size:" + getQueueSize() + "\nexecuting:" + this.mExecutionInProgress;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public boolean isScheduleMainThread() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledAction poll;
        int i = this.mCurrRecursiveDepth + 1;
        this.mCurrRecursiveDepth = i;
        if (i <= 10 && this.mCostTime <= 8) {
            synchronized (this) {
                poll = this.mPriorityQueue.poll();
            }
            if (poll != null) {
                long currentTimeMillis = System.currentTimeMillis();
                poll.run();
                this.mCostTime += System.currentTimeMillis() - currentTimeMillis;
                run();
                return;
            }
            synchronized (this) {
                this.mExecutionInProgress = false;
            }
            return;
        }
        this.mCurrRecursiveDepth = 0;
        this.mCostTime = 0L;
        synchronized (this) {
            if (this.mPriorityQueue.size() > 0) {
                this.mHandler.post(this);
            } else {
                this.mExecutionInProgress = false;
            }
        }
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized void schedule(final ScheduledAction scheduledAction) {
        if (j42.a()) {
            this.mHandler.post(new Runnable() { // from class: com.taobao.rxm.schedule.UiThreadScheduler.1
                @Override // java.lang.Runnable
                public void run() {
                    scheduledAction.run();
                }
            });
        } else {
            this.mPriorityQueue.add(scheduledAction);
            if (!this.mExecutionInProgress && !this.mPriorityQueue.isEmpty()) {
                this.mExecutionInProgress = true;
                this.mHandler.post(this);
            }
        }
    }
}
