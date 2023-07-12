package tb;

import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class to2 implements ITnetHostPortStrategy {
    public static to2 f;
    private boolean d = false;
    private boolean e = false;
    private uj a = new uj();
    private v52 b = new v52();
    private so2 c = new so2();

    private to2() {
    }

    private qo2 a() {
        return this.c.a();
    }

    public static synchronized to2 b() {
        to2 to2Var;
        synchronized (to2.class) {
            if (f == null) {
                f = new to2();
            }
            to2Var = f;
        }
        return to2Var;
    }

    private void f(boolean z, int i, long j) {
        f41.c(z, i, j);
        if (z || !this.e) {
            return;
        }
        this.d = true;
        g(false);
        f41.b(i, j);
    }

    public boolean c() {
        if (this.d || this.a.a() || a() == null) {
            return false;
        }
        int a = l21.a();
        if (a == 2) {
            return true;
        }
        if (a == 3) {
            return this.b.a();
        }
        return false;
    }

    public boolean d() {
        return this.e;
    }

    public void e() {
        SystemConfigMgr.i().l("close_detect_ipv6", this.a);
        SystemConfigMgr.i().l("sample_ipv6", this.b);
    }

    public void g(boolean z) {
        this.e = z;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public qo2 getTnetHostPort() {
        if (c()) {
            return a();
        }
        return null;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public void response(tc tcVar) {
        if (tcVar == null) {
            return;
        }
        f(tcVar.a(), tcVar.a, tcVar.c);
    }
}
