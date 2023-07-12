package tb;

import com.taobao.phenix.builder.Builder;
import com.taobao.rxm.schedule.Scheduler;
import com.taobao.rxm.schedule.SchedulerSupplier;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f62 implements Builder<SchedulerSupplier> {
    public static final int DEFAULT_CORE_SIZE = 3;
    public static final int DEFAULT_KEEP_ALIVE = 8;
    public static final int DEFAULT_MAX_RUNNING = 6;
    public static final int DEFAULT_PATIENCE_CAPACITY = 1500;
    public static final int DEFAULT_QUEUE_CAPACITY = 5;
    public static final int INVALID_NETWORK_RUNNING_EXPIRED = -1;
    public static final int MAX_DECODE_RUNNING = 3;
    public static final int MAX_NETWORK_RUNNING_AT_FAST = 5;
    public static final int MAX_NETWORK_RUNNING_AT_SLOW = 2;
    public static final int MIN_PATIENCE_CAPACITY = 500;
    public static final int VALID_NETWORK_RUNNING_EXPIRED = 25000;
    private boolean a;
    private Scheduler b;
    private SchedulerSupplier l;
    private int c = 3;
    private int d = 5;
    private int e = 2;
    private int f = -1;
    private int g = 3;
    private int h = 6;
    private int i = 8;
    private int j = 5;
    private int k = 1500;
    private boolean m = true;

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: a */
    public synchronized SchedulerSupplier build() {
        if (!this.a && this.l == null) {
            f60 f60Var = new f60(this.b, this.g, this.h, this.i, this.j, this.k, this.c, this.d, this.e, this.f, this.m);
            this.l = f60Var;
            this.a = true;
            return f60Var;
        }
        return this.l;
    }

    public f62 b(Scheduler scheduler) {
        cu1.e(!this.a, "SchedulerSupplier has been built, not allow central() now");
        this.b = scheduler;
        return this;
    }

    public boolean c() {
        return this.a;
    }

    public f62 d(int i) {
        cu1.e(!this.a, "SchedulerSupplier has been built, not allow maxDecodeRunning() now");
        cu1.e(i <= this.h, "max decode running cannot be greater than max running");
        this.c = i;
        return this;
    }

    public f62 e(int i) {
        cu1.e(!this.a, "SchedulerSupplier has been built, not allow maxNetworkRunningAtFast() now");
        cu1.e(i <= this.h, "max network running at fast cannot be greater than max running");
        this.d = i;
        return this;
    }

    public f62 f(int i) {
        cu1.e(!this.a, "SchedulerSupplier has been built, not allow maxNetworkRunningAtSlow() now");
        cu1.e(i <= this.h, "max network running at slow cannot be greater than max running");
        this.e = i;
        return this;
    }

    public f62 g(int i) {
        cu1.e(!this.a, "SchedulerSupplier has been built, not allow maxRunning() now");
        if (this.b == null) {
            cu1.e(i >= this.g, "max running cannot be lower than core size");
        } else {
            cu1.e(i > 0, "max running must be greater than zero");
        }
        this.h = i;
        return this;
    }

    public f62 h(int i) {
        cu1.e(!this.a, "SchedulerSupplier has been built, not allow networkRunningExpired() now");
        this.f = i;
        return this;
    }

    public f62 i(boolean z) {
        this.m = z;
        return this;
    }

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: j */
    public f62 with(SchedulerSupplier schedulerSupplier) {
        cu1.e(!this.a, "SchedulerSupplier has been built, not allow with() now");
        this.l = schedulerSupplier;
        return this;
    }
}
