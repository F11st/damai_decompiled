package com.taobao.rxm.schedule;

import android.text.TextUtils;
import java.util.concurrent.PriorityBlockingQueue;
import tb.hh0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class CentralSchedulerQueue extends PriorityBlockingQueue<Runnable> {
    public static final int ACT_BE_QUEUED = 3;
    public static final int ACT_BE_REJECTED = 2;
    public static final int ACT_TO_EXECUTE = 1;
    private final ExecutorStateInspector mExecutorStateInspector;
    private final int mNormalCapacity;
    private final int mPatienceCapacity;

    public CentralSchedulerQueue(ExecutorStateInspector executorStateInspector, int i, int i2) {
        this.mExecutorStateInspector = executorStateInspector;
        this.mNormalCapacity = i;
        this.mPatienceCapacity = i2;
    }

    public synchronized int moveIn(ScheduledAction scheduledAction, boolean z) {
        if (z) {
            if (this.mExecutorStateInspector.isNotFull()) {
                return 1;
            }
        }
        int size = size();
        if (size >= this.mPatienceCapacity) {
            hh0.c("RxSysLog", "SOX current size(%d) of central queue exceeded max patience(%d)!", Integer.valueOf(size), Integer.valueOf(this.mPatienceCapacity));
            String status = this.mExecutorStateInspector.getStatus();
            if (!TextUtils.isEmpty(status)) {
                String replace = status.replace("%", "%%");
                hh0.c("RxSysLog", "SOX detail:" + replace, new Object[0]);
            }
            return 2;
        } else if (size < this.mNormalCapacity || !scheduledAction.canRunDirectly()) {
            if (z) {
                try {
                    if (super.offer((CentralSchedulerQueue) scheduledAction)) {
                        return 3;
                    }
                } catch (IllegalMonitorStateException unused) {
                }
                return scheduledAction.canRunDirectly() ? 2 : 1;
            }
            return 1;
        } else {
            return 2;
        }
    }

    public boolean reachPatienceCapacity() {
        return size() >= this.mPatienceCapacity;
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public int size() {
        try {
            return super.size();
        } catch (IllegalMonitorStateException unused) {
            return 0;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(Runnable runnable) {
        return moveIn((ScheduledAction) runnable, true) == 3;
    }
}
