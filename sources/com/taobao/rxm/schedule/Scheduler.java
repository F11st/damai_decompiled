package com.taobao.rxm.schedule;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Scheduler {
    int getQueueSize();

    String getStatus();

    boolean isScheduleMainThread();

    void schedule(ScheduledAction scheduledAction);
}
