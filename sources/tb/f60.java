package tb;

import com.taobao.phenix.loader.network.NetworkQualityListener;
import com.taobao.rxm.schedule.C6874a;
import com.taobao.rxm.schedule.C6875b;
import com.taobao.rxm.schedule.C6878c;
import com.taobao.rxm.schedule.PairingThrottlingScheduler;
import com.taobao.rxm.schedule.Scheduler;
import com.taobao.rxm.schedule.SchedulerSupplier;
import com.taobao.rxm.schedule.ThrottlingScheduler;
import com.taobao.rxm.schedule.UiThreadScheduler;
import com.taobao.rxm.schedule.UiThreadSchedulerFront;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f60 implements NetworkQualityListener, SchedulerSupplier {
    private static boolean h;
    private final Scheduler a;
    private ThrottlingScheduler b;
    private Scheduler c;
    private Scheduler d;
    private boolean e;
    private final int f;
    private final int g;

    public f60(Scheduler scheduler, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this(scheduler, i, i2, i3, i4, i5, i6, i7, i8, -1);
    }

    @Override // com.taobao.rxm.schedule.SchedulerSupplier
    public Scheduler forCpuBound() {
        return this.a;
    }

    @Override // com.taobao.rxm.schedule.SchedulerSupplier
    public Scheduler forDecode() {
        return this.c;
    }

    @Override // com.taobao.rxm.schedule.SchedulerSupplier
    public Scheduler forIoBound() {
        return this.a;
    }

    @Override // com.taobao.rxm.schedule.SchedulerSupplier
    public Scheduler forNetwork() {
        return this.b;
    }

    @Override // com.taobao.rxm.schedule.SchedulerSupplier
    public Scheduler forUiThread() {
        if (this.d == null) {
            this.d = h ? new UiThreadSchedulerFront() : new UiThreadScheduler();
        }
        return this.d;
    }

    @Override // com.taobao.phenix.loader.network.NetworkQualityListener
    public synchronized void onNetworkQualityChanged(boolean z) {
        if (this.e == z) {
            Object[] objArr = new Object[1];
            objArr[0] = z ? "SLOW" : "FAST";
            xt2.f("Network", "network speed not changed, still %s", objArr);
            return;
        }
        if (z) {
            xt2.f("Network", "network speed changed from FAST to SLOW", new Object[0]);
            this.b.setMaxRunningCount(this.g);
        } else {
            xt2.f("Network", "network speed changed from SLOW to FAST", new Object[0]);
            this.b.setMaxRunningCount(this.f);
        }
        this.e = z;
    }

    public f60(Scheduler scheduler, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this(scheduler, i, i2, i3, i4, i5, i6, i7, i8, i9, false);
    }

    public f60(Scheduler scheduler, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        if (scheduler != null && !z) {
            this.a = new C6878c(scheduler, i2, i4, i5);
        } else {
            this.a = new C6875b("Phenix-Scheduler", i, i2, i3, i4, i5);
        }
        this.f = i7;
        this.g = i8;
        if (i9 > 0) {
            this.b = new PairingThrottlingScheduler(this.a, i7, i9);
        } else {
            this.b = new C6874a(this.a, i7);
        }
        this.c = new C6874a(this.a, i6);
    }
}
