package com.taobao.rxm.schedule;

import java.util.LinkedList;
import java.util.Queue;

/* compiled from: Taobao */
/* renamed from: com.taobao.rxm.schedule.a */
/* loaded from: classes11.dex */
public class C6874a implements ScheduledActionListener, ThrottlingScheduler {
    private final Scheduler a;
    private final Queue<ScheduledAction> b = new LinkedList();
    private int c;
    private int d;

    public C6874a(Scheduler scheduler, int i) {
        this.a = scheduler;
        this.c = i;
    }

    private void a() {
        ScheduledAction poll;
        ScheduledAction scheduledAction = ScheduledAction.sActionCallerThreadLocal.get();
        while (true) {
            synchronized (this) {
                poll = this.d < this.c ? this.b.poll() : null;
                if (poll != null) {
                    this.d++;
                }
            }
            if (poll == null) {
                return;
            }
            this.a.schedule(poll);
            ScheduledAction.sActionCallerThreadLocal.set(scheduledAction);
        }
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public int getQueueSize() {
        return this.b.size();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized String getStatus() {
        return this.a.getStatus();
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019 A[Catch: all -> 0x0027, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000b, B:12:0x0019, B:13:0x001e), top: B:20:0x0004 }] */
    @Override // com.taobao.rxm.schedule.Scheduler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void schedule(com.taobao.rxm.schedule.ScheduledAction r4) {
        /*
            r3 = this;
            r4.setBranchActionListener(r3)
            monitor-enter(r3)
            int r0 = r3.d     // Catch: java.lang.Throwable -> L27
            int r1 = r3.c     // Catch: java.lang.Throwable -> L27
            r2 = 1
            if (r0 < r1) goto L16
            java.util.Queue<com.taobao.rxm.schedule.ScheduledAction> r0 = r3.b     // Catch: java.lang.Throwable -> L27
            boolean r0 = r0.offer(r4)     // Catch: java.lang.Throwable -> L27
            if (r0 != 0) goto L14
            goto L16
        L14:
            r0 = 0
            goto L17
        L16:
            r0 = 1
        L17:
            if (r0 == 0) goto L1e
            int r1 = r3.d     // Catch: java.lang.Throwable -> L27
            int r1 = r1 + r2
            r3.d = r1     // Catch: java.lang.Throwable -> L27
        L1e:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L26
            com.taobao.rxm.schedule.Scheduler r0 = r3.a
            r0.schedule(r4)
        L26:
            return
        L27:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L27
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.rxm.schedule.C6874a.schedule(com.taobao.rxm.schedule.ScheduledAction):void");
    }

    @Override // com.taobao.rxm.schedule.ThrottlingScheduler
    public void setMaxRunningCount(int i) {
        synchronized (this) {
            this.c = i;
        }
        a();
    }
}
