package cn.damai.ticklet.utils;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;
import tb.oe1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class UTTimeUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int o = 0;
    public static int p = 1;
    public static int q = 3;
    private long a;
    private long b = 0;
    private long c = 0;
    private Boolean d = Boolean.TRUE;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private oe1 h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;

    public UTTimeUtils(int i) {
        this.a = 0L;
        Boolean bool = Boolean.FALSE;
        this.e = bool;
        this.f = bool;
        this.g = bool;
        this.i = "db_query";
        this.j = "net_query";
        this.k = "finish(db)";
        this.l = "finish(net)";
        this.m = "finish(local)";
        this.n = "combin_render";
        this.h = new oe1(i);
        this.a = System.currentTimeMillis();
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756679861")) {
            ipChange.ipc$dispatch("-756679861", new Object[]{this});
            return;
        }
        this.a = System.currentTimeMillis();
        Boolean bool = Boolean.FALSE;
        this.d = bool;
        this.c = 0L;
        this.e = bool;
        this.f = bool;
        this.g = bool;
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676306843")) {
            ipChange.ipc$dispatch("676306843", new Object[]{this});
        } else if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
    }

    public void m(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051943444")) {
            ipChange.ipc$dispatch("-2051943444", new Object[]{this, Long.valueOf(j)});
        } else if (this.e.booleanValue() || j == 0) {
        } else {
            this.e = Boolean.TRUE;
            if (j > 10000) {
                return;
            }
            this.h.a(this.i, j);
            cb1.b("member_activity_time", "dbstr=" + j);
        }
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173080502")) {
            ipChange.ipc$dispatch("173080502", new Object[]{this});
            return;
        }
        if (this.b == 0) {
            this.b = System.currentTimeMillis() - this.a;
        }
        cb1.b("member_activity_time", "init_time=" + this.b);
    }

    public void o(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868328303")) {
            ipChange.ipc$dispatch("-1868328303", new Object[]{this, view});
        } else if (this.g.booleanValue() || this.a == 0) {
        } else {
            this.g = Boolean.TRUE;
            if (view != null) {
                view.post(new Runnable() { // from class: cn.damai.ticklet.utils.UTTimeUtils.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1801558721")) {
                            ipChange2.ipc$dispatch("1801558721", new Object[]{this});
                            return;
                        }
                        if (UTTimeUtils.this.c != 0) {
                            UTTimeUtils.this.h.a(UTTimeUtils.this.n, System.currentTimeMillis() - UTTimeUtils.this.c);
                        }
                        long currentTimeMillis = System.currentTimeMillis() - UTTimeUtils.this.a;
                        if (!UTTimeUtils.this.d.booleanValue() && UTTimeUtils.this.b < 2000) {
                            currentTimeMillis += UTTimeUtils.this.b;
                        }
                        if (currentTimeMillis > 300000) {
                            return;
                        }
                        UTTimeUtils.this.h.a(UTTimeUtils.this.m, currentTimeMillis);
                    }
                });
            }
        }
    }

    public void p(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1470241248")) {
            ipChange.ipc$dispatch("1470241248", new Object[]{this, view});
        } else if (this.g.booleanValue() || this.a == 0) {
        } else {
            this.g = Boolean.TRUE;
            if (view != null) {
                view.post(new Runnable() { // from class: cn.damai.ticklet.utils.UTTimeUtils.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1998072226")) {
                            ipChange2.ipc$dispatch("1998072226", new Object[]{this});
                            return;
                        }
                        if (UTTimeUtils.this.c != 0) {
                            UTTimeUtils.this.h.a(UTTimeUtils.this.n, System.currentTimeMillis() - UTTimeUtils.this.c);
                        }
                        cb1.b("member_activity_time", "combin_render =" + (System.currentTimeMillis() - UTTimeUtils.this.c));
                        long currentTimeMillis = System.currentTimeMillis() - UTTimeUtils.this.a;
                        if (!UTTimeUtils.this.d.booleanValue() && UTTimeUtils.this.b < 2000) {
                            currentTimeMillis += UTTimeUtils.this.b;
                        }
                        if (currentTimeMillis > 300000) {
                            return;
                        }
                        if (UTTimeUtils.this.e.booleanValue()) {
                            UTTimeUtils.this.h.a(UTTimeUtils.this.k, currentTimeMillis);
                        } else {
                            UTTimeUtils.this.h.a(UTTimeUtils.this.l, currentTimeMillis);
                        }
                        cb1.b("member_activity_time", "start_time=" + UTTimeUtils.this.a);
                        if (UTTimeUtils.this.e.booleanValue()) {
                            cb1.b("member_activity_time", "db_finish=" + currentTimeMillis);
                            return;
                        }
                        cb1.b("member_activity_time", "net_finish=" + currentTimeMillis);
                    }
                });
            }
        }
    }

    public void q(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649650385")) {
            ipChange.ipc$dispatch("1649650385", new Object[]{this, Long.valueOf(j)});
        } else if (this.f.booleanValue() || j == 0) {
        } else {
            this.f = Boolean.TRUE;
            if (j > 30000) {
                return;
            }
            this.h.a(this.j, j);
            cb1.b("member_activity_time", "netstr=" + j);
        }
    }
}
