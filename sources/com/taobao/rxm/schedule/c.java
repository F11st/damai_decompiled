package com.taobao.rxm.schedule;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c implements ExecutorStateInspector, ScheduledActionListener, ThrottlingScheduler {
    private final Scheduler a;
    private final CentralSchedulerQueue b;
    private int c;
    private int d;

    public c(Scheduler scheduler, int i, int i2, int i3) {
        this.a = scheduler;
        this.c = i;
        this.b = new CentralSchedulerQueue(this, i2, i3);
    }

    private void a() {
        ScheduledAction scheduledAction = ScheduledAction.sActionCallerThreadLocal.get();
        while (true) {
            ScheduledAction scheduledAction2 = null;
            synchronized (this) {
                if (this.d < this.c || this.b.reachPatienceCapacity()) {
                    scheduledAction2 = (ScheduledAction) this.b.poll();
                }
            }
            if (scheduledAction2 == null) {
                return;
            }
            c(scheduledAction2, false);
            ScheduledAction.sActionCallerThreadLocal.set(scheduledAction);
        }
    }

    private void b(ScheduledAction scheduledAction) {
        scheduledAction.run();
    }

    private void c(ScheduledAction scheduledAction, boolean z) {
        int moveIn;
        synchronized (this) {
            moveIn = this.b.moveIn(scheduledAction, z);
            if (moveIn != 3) {
                this.d++;
            }
        }
        if (moveIn == 1) {
            this.a.schedule(scheduledAction);
        } else if (moveIn == 2) {
            b(scheduledAction);
        }
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public int getQueueSize() {
        return this.b.size();
    }

    @Override // com.taobao.rxm.schedule.ExecutorStateInspector, com.taobao.rxm.schedule.Scheduler
    public synchronized String getStatus() {
        return "MasterThrottling[running=" + this.d + ", max=" + this.c + "]," + this.a.getStatus();
    }

    @Override // com.taobao.rxm.schedule.ExecutorStateInspector
    public synchronized boolean isNotFull() {
        return this.d < this.c;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized boolean isScheduleMainThread() {
        return this.a.isScheduleMainThread();
    }

    @Override // com.taobao.rxm.schedule.ScheduledActionListener
    public void onActionFinished(ScheduledAction scheduledAction) {
        synchronized (this) {
            this.d--;
        }
        a();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public void schedule(ScheduledAction scheduledAction) {
        scheduledAction.setMasterActionListener(this);
        c(scheduledAction, true);
    }

    @Override // com.taobao.rxm.schedule.ThrottlingScheduler
    public void setMaxRunningCount(int i) {
        synchronized (this) {
            this.c = i;
        }
        a();
    }
}
