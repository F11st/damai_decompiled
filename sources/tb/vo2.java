package tb;

import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class vo2 {
    public static final String TAG_STATIC_TNET_HOST_PORT = "utanalytics_static_tnet_host_port";
    private static vo2 e;
    private po2 a;
    private no2 b;
    private int c = 0;
    private int d = -1;

    public static synchronized vo2 b() {
        vo2 vo2Var;
        synchronized (vo2.class) {
            if (e == null) {
                e = new vo2();
            }
            vo2Var = e;
        }
        return vo2Var;
    }

    public int a() {
        no2 no2Var = this.b;
        if (no2Var != null) {
            return no2Var.a();
        }
        return 0;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public ITnetHostPortStrategy e() {
        if (w52.d().g()) {
            if (this.b == null) {
                this.b = new no2();
            }
            this.c = 2;
            return this.b;
        } else if (w52.d().h()) {
            if (this.a == null) {
                this.a = new po2();
            }
            this.c = 1;
            return this.a;
        } else {
            this.c = 0;
            return null;
        }
    }

    public void f() {
        w52.d().f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i) {
        this.d = i;
    }
}
