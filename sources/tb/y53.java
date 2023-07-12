package tb;

import java.util.concurrent.atomic.AtomicInteger;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class y53 extends w23 {
    private AtomicInteger b = new AtomicInteger(0);
    private AtomicInteger c = new AtomicInteger(0);
    public AtomicInteger d = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicInteger f = new AtomicInteger(0);

    @Override // tb.w23
    public final void a() {
        n73 n73Var;
        if ((this.b.get() == 0 && this.c.get() == 0 && this.d.get() == 0 && this.f.get() == 0 && this.e.get() == 0) || this.a == null || !com.efs.sdk.base.a.d.a.a().d) {
            return;
        }
        com.efs.sdk.base.a.d.a aVar = this.a;
        int i = this.b.get();
        int i2 = this.c.get();
        int i3 = this.d.get();
        int i4 = this.f.get();
        int i5 = this.e.get();
        n73Var = n73.a.a;
        o43 o43Var = new o43("efs_core", "lf_st", n73Var.a.c);
        o43Var.a("create_cnt", Integer.valueOf(i));
        o43Var.a("cache_cnt", Integer.valueOf(i2));
        o43Var.a("req_cnt", Integer.valueOf(i3));
        o43Var.a("err_cnt", Integer.valueOf(i4));
        o43Var.a("expire_cnt", Integer.valueOf(i5));
        this.b.addAndGet(i * (-1));
        this.c.addAndGet(i2 * (-1));
        this.d.addAndGet(i3 * (-1));
        this.f.addAndGet(i4 * (-1));
        this.e.addAndGet(i5 * (-1));
        aVar.b(o43Var);
    }

    public final void b() {
        this.b.incrementAndGet();
    }

    public final void c() {
        this.c.incrementAndGet();
    }

    public final void d() {
        this.e.incrementAndGet();
    }

    public final void e() {
        this.f.incrementAndGet();
    }
}
