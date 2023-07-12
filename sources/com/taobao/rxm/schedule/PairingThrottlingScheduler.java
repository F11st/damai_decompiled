package com.taobao.rxm.schedule;

import android.util.SparseArray;
import com.taobao.rxm.request.RequestCancelListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tb.a22;
import tb.hh0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PairingThrottlingScheduler implements ThrottlingScheduler, ScheduledActionListener, RequestCancelListener<a22> {
    private final Scheduler a;
    private final Queue<ScheduledAction> b = new LinkedList();
    private final SparseArray<Long> c = new SparseArray<>();
    private final List<Integer> d = new ArrayList();
    private final long e;
    private int f;
    private int g;
    private int h;
    private long i;
    private DegradationListener j;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface DegradationListener {
        void onDegrade2Unlimited();
    }

    public PairingThrottlingScheduler(Scheduler scheduler, int i, int i2) {
        this.a = scheduler;
        this.g = i;
        this.e = i2 * 1000000;
    }

    private void a() {
        ScheduledAction poll;
        ScheduledAction scheduledAction = ScheduledAction.sActionCallerThreadLocal.get();
        while (true) {
            synchronized (this) {
                b();
                poll = this.h < this.g ? this.b.poll() : null;
                if (poll != null) {
                    d(poll);
                }
            }
            if (poll == null) {
                return;
            }
            poll.unregisterCancelListener(this);
            this.a.schedule(poll);
            ScheduledAction.sActionCallerThreadLocal.set(scheduledAction);
        }
    }

    private synchronized void b() {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.i < 30000000) {
            return;
        }
        this.i = nanoTime;
        this.d.clear();
        int size = this.c.size();
        long nanoTime2 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            Long valueAt = this.c.valueAt(i);
            if (valueAt != null && nanoTime2 - valueAt.longValue() >= this.e) {
                this.d.add(Integer.valueOf(this.c.keyAt(i)));
            }
        }
        int size2 = this.d.size();
        boolean z = false;
        for (int i2 = 0; i2 < size2; i2++) {
            int intValue = this.d.get(i2).intValue();
            hh0.f("RxSysLog", "[PairingThrottling] remove expired pair, id=%d", Integer.valueOf(intValue));
            if (!g(intValue) && !z) {
                z = false;
            }
            z = true;
        }
        int i3 = this.f;
        if (i3 < 3) {
            int i4 = i3 + size2;
            this.f = i4;
            if (i4 >= 3) {
                this.g = Integer.MAX_VALUE;
                hh0.i("RxSysLog", "[PairingThrottling] auto degrade to unlimited scheduler, expired total=%d", Integer.valueOf(i4));
                DegradationListener degradationListener = this.j;
                if (degradationListener != null) {
                    degradationListener.onDegrade2Unlimited();
                }
            }
        }
        if (z) {
            a();
        }
    }

    private synchronized void d(ScheduledAction scheduledAction) {
        int contextId = scheduledAction.getContextId();
        if (contextId <= 0) {
            this.h++;
        } else if (scheduledAction.isProduceAction() && this.c.get(contextId) == null) {
            this.c.put(contextId, Long.valueOf(System.nanoTime()));
            this.h++;
        }
    }

    private boolean e(ScheduledAction scheduledAction) {
        return scheduledAction.getContextId() > 0 && !scheduledAction.isProduceAction() && scheduledAction.isConsumeAction();
    }

    private boolean g(int i) {
        synchronized (this) {
            if (i <= 0) {
                this.h--;
                return true;
            } else if (this.c.get(i) != null) {
                this.c.remove(i);
                this.h--;
                return true;
            } else {
                return false;
            }
        }
    }

    public void c(int i) {
        if (g(i)) {
            a();
        }
    }

    public void f(DegradationListener degradationListener) {
        this.j = degradationListener;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized int getQueueSize() {
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
        int contextId = scheduledAction.getContextId();
        if ((contextId <= 0 || scheduledAction.isConsumeAction()) && g(contextId)) {
            a();
        }
    }

    @Override // com.taobao.rxm.request.RequestCancelListener
    public void onCancel(a22 a22Var) {
        if (a22Var != null) {
            int d = a22Var.d();
            ScheduledAction scheduledAction = null;
            synchronized (this) {
                Iterator<ScheduledAction> it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ScheduledAction next = it.next();
                    if (d == next.getContextId()) {
                        scheduledAction = next;
                        break;
                    }
                }
                if (scheduledAction != null) {
                    this.b.remove(scheduledAction);
                }
            }
            if (scheduledAction != null) {
                scheduledAction.cancelActing();
                scheduledAction.unregisterCancelListener(this);
                hh0.f("RxSysLog", "[PairingThrottling] ID=%d cancelled before scheduling the action in queue", Integer.valueOf(d));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027 A[Catch: all -> 0x0037, TryCatch #0 {, blocks: (B:4:0x0008, B:6:0x000e, B:8:0x0013, B:10:0x0019, B:16:0x0027, B:18:0x002e, B:17:0x002b), top: B:25:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002b A[Catch: all -> 0x0037, TryCatch #0 {, blocks: (B:4:0x0008, B:6:0x000e, B:8:0x0013, B:10:0x0019, B:16:0x0027, B:18:0x002e, B:17:0x002b), top: B:25:0x0008 }] */
    @Override // com.taobao.rxm.schedule.Scheduler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void schedule(com.taobao.rxm.schedule.ScheduledAction r3) {
        /*
            r2 = this;
            r3.setBranchActionListener(r2)
            boolean r0 = r2.e(r3)
            monitor-enter(r2)
            boolean r1 = r3.isProduceAction()     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L11
            r2.b()     // Catch: java.lang.Throwable -> L37
        L11:
            if (r0 != 0) goto L24
            int r0 = r2.h     // Catch: java.lang.Throwable -> L37
            int r1 = r2.g     // Catch: java.lang.Throwable -> L37
            if (r0 < r1) goto L24
            java.util.Queue<com.taobao.rxm.schedule.ScheduledAction> r0 = r2.b     // Catch: java.lang.Throwable -> L37
            boolean r0 = r0.offer(r3)     // Catch: java.lang.Throwable -> L37
            if (r0 != 0) goto L22
            goto L24
        L22:
            r0 = 0
            goto L25
        L24:
            r0 = 1
        L25:
            if (r0 == 0) goto L2b
            r2.d(r3)     // Catch: java.lang.Throwable -> L37
            goto L2e
        L2b:
            r3.registerCancelListener(r2)     // Catch: java.lang.Throwable -> L37
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L36
            com.taobao.rxm.schedule.Scheduler r0 = r2.a
            r0.schedule(r3)
        L36:
            return
        L37:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L37
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.rxm.schedule.PairingThrottlingScheduler.schedule(com.taobao.rxm.schedule.ScheduledAction):void");
    }

    @Override // com.taobao.rxm.schedule.ThrottlingScheduler
    public synchronized void setMaxRunningCount(int i) {
        boolean z;
        synchronized (this) {
            z = this.f < 3 && i != this.g;
            if (z) {
                this.g = i;
            }
        }
        if (z) {
            a();
        }
    }
}
