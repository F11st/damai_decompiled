package tb;

import com.taobao.android.task.Coordinator;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ak2 implements Scheduler {
    private final Coordinator.CoordThreadPoolExecutor a = (Coordinator.CoordThreadPoolExecutor) Coordinator.getDefaultThreadPoolExecutor();

    private ak2() {
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(boolean r14, boolean r15) {
        /*
            r0 = 1
            java.lang.String r1 = "TBScheduler4Phenix"
            r2 = 0
            if (r14 == 0) goto L1d
            tb.ur1 r3 = tb.ur1.o()     // Catch: java.lang.RuntimeException -> La9
            tb.f62 r3 = r3.schedulerBuilder()     // Catch: java.lang.RuntimeException -> La9
            tb.ak2 r4 = new tb.ak2     // Catch: java.lang.RuntimeException -> La9
            r4.<init>()     // Catch: java.lang.RuntimeException -> La9
            r3.b(r4)     // Catch: java.lang.RuntimeException -> La9
            java.lang.String r3 = "enable unify thread pool"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.RuntimeException -> La9
            tb.xt2.f(r1, r3, r4)     // Catch: java.lang.RuntimeException -> La9
        L1d:
            com.taobao.application.common.IAppPreferences r3 = com.taobao.application.common.b.d()     // Catch: java.lang.RuntimeException -> La9
            r4 = -1
            if (r3 == 0) goto L2b
            java.lang.String r5 = "oldDeviceScore"
            int r3 = r3.getInt(r5, r4)     // Catch: java.lang.RuntimeException -> La9
            goto L2c
        L2b:
            r3 = 0
        L2c:
            r5 = 4
            r6 = 5
            r7 = 2
            r8 = 6
            r9 = 3
            if (r3 <= 0) goto L5a
            r10 = 40
            if (r3 > r10) goto L3b
            r14 = 4
            r10 = 2
            r11 = 3
            goto L5d
        L3b:
            r10 = 60
            if (r3 > r10) goto L43
            r14 = 5
            r10 = 3
            r11 = 4
            goto L5d
        L43:
            r10 = 75
            if (r3 > r10) goto L4c
            r14 = 6
            r10 = 3
            r11 = 5
        L4a:
            r12 = 3
            goto L5e
        L4c:
            r10 = 90
            if (r3 > r10) goto L54
            r14 = 7
            r10 = 3
        L52:
            r11 = 6
            goto L4a
        L54:
            if (r14 == 0) goto L5a
            r14 = 8
            r10 = 4
            goto L52
        L5a:
            r14 = 6
            r10 = 3
            r11 = 5
        L5d:
            r12 = 2
        L5e:
            if (r15 == 0) goto L62
            r4 = 25000(0x61a8, float:3.5032E-41)
        L62:
            java.lang.String r15 = "setup max running=%d, decode=%d, fast network=%d, slow network=%d, network expired=%d, score=%d"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.RuntimeException -> La9
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)     // Catch: java.lang.RuntimeException -> La9
            r8[r2] = r13     // Catch: java.lang.RuntimeException -> La9
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.RuntimeException -> La9
            r8[r0] = r13     // Catch: java.lang.RuntimeException -> La9
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.RuntimeException -> La9
            r8[r7] = r13     // Catch: java.lang.RuntimeException -> La9
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.RuntimeException -> La9
            r8[r9] = r7     // Catch: java.lang.RuntimeException -> La9
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.RuntimeException -> La9
            r8[r5] = r7     // Catch: java.lang.RuntimeException -> La9
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.RuntimeException -> La9
            r8[r6] = r3     // Catch: java.lang.RuntimeException -> La9
            tb.xt2.f(r1, r15, r8)     // Catch: java.lang.RuntimeException -> La9
            tb.ur1 r15 = tb.ur1.o()     // Catch: java.lang.RuntimeException -> La9
            tb.f62 r15 = r15.schedulerBuilder()     // Catch: java.lang.RuntimeException -> La9
            tb.f62 r14 = r15.g(r14)     // Catch: java.lang.RuntimeException -> La9
            tb.f62 r14 = r14.d(r10)     // Catch: java.lang.RuntimeException -> La9
            tb.f62 r14 = r14.e(r11)     // Catch: java.lang.RuntimeException -> La9
            tb.f62 r14 = r14.f(r12)     // Catch: java.lang.RuntimeException -> La9
            r14.h(r4)     // Catch: java.lang.RuntimeException -> La9
            goto Lb3
        La9:
            r14 = move-exception
            java.lang.Object[] r15 = new java.lang.Object[r0]
            r15[r2] = r14
            java.lang.String r14 = "init running scheduler error=%s"
            tb.xt2.c(r1, r14, r15)
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ak2.a(boolean, boolean):void");
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public int getQueueSize() {
        return this.a.getQueue().size();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public String getStatus() {
        return "TBScheduler4Phenix[queue=" + getQueueSize() + ",active=" + this.a.getActiveCount() + ",pool=" + this.a.getPoolSize() + ",largest=" + this.a.getLargestPoolSize() + ",tasks=" + this.a.getTaskCount() + ",completes=" + this.a.getCompletedTaskCount() + jn1.ARRAY_END_STR;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public boolean isScheduleMainThread() {
        return false;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public void schedule(ScheduledAction scheduledAction) {
        this.a.execute(scheduledAction, 27);
    }
}
