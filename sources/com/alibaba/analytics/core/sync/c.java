package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.utils.Logger;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.HashMap;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.ct2;
import tb.qa1;
import tb.qo2;
import tb.ro2;
import tb.tc;
import tb.to2;
import tb.vo2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class c {
    private static c g;
    private boolean a = false;
    private qo2 b = null;
    private qo2 c = null;
    private boolean d = false;
    private ITnetHostPortStrategy e = null;
    private int f = 0;

    private c() {
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (g == null) {
                g = new c();
            }
            cVar = g;
        }
        return cVar;
    }

    public int a() {
        qo2 qo2Var = this.c;
        if (qo2Var == null || this.b == null || !this.d) {
            return 0;
        }
        this.d = false;
        Logger.f("TnetHostPortMgrCenter", "LastTnetHostPort type", Integer.valueOf(qo2Var.d()), "TnetHostPort type", Integer.valueOf(this.b.d()));
        return (this.c.d() != 2 || this.b.d() == 2) ? 0 : 1;
    }

    public int c() {
        qo2 qo2Var = this.b;
        if (qo2Var != null && qo2Var.d() == 2 && this.b.d() == 2) {
            return this.b.c();
        }
        return 0;
    }

    public int d() {
        return this.f;
    }

    public qo2 e() {
        qo2 tnetHostPort;
        this.d = true;
        this.c = this.b;
        this.e = vo2.b().e();
        this.f = vo2.b().d();
        ITnetHostPortStrategy iTnetHostPortStrategy = this.e;
        if (iTnetHostPortStrategy != null && (tnetHostPort = iTnetHostPortStrategy.getTnetHostPort()) != null) {
            this.a = true;
            this.b = tnetHostPort;
            return tnetHostPort;
        }
        if (this.a && f.i().j() < 50) {
            f.i().k();
            this.a = false;
        }
        qo2 tnetHostPort2 = to2.b().getTnetHostPort();
        if (tnetHostPort2 != null) {
            this.b = tnetHostPort2;
            return tnetHostPort2;
        }
        qo2 tnetHostPort3 = ro2.a().getTnetHostPort();
        this.b = tnetHostPort3;
        return tnetHostPort3;
    }

    public qo2 f() {
        if (this.b == null) {
            this.b = e();
        }
        return this.b;
    }

    public void g(tc tcVar) {
        if (tcVar == null || Variables.n().J() || this.b == null) {
            return;
        }
        h(tcVar);
        if (this.b.d() == 2) {
            ITnetHostPortStrategy iTnetHostPortStrategy = this.e;
            if (iTnetHostPortStrategy != null) {
                iTnetHostPortStrategy.response(tcVar);
            }
        } else if (this.b.d() == 1) {
            to2.b().response(tcVar);
        } else {
            ro2.a().response(tcVar);
        }
    }

    public void h(tc tcVar) {
        if (tcVar.f && b.a().b() && ct2.d().f(19997, "_ut_nw")) {
            HashMap hashMap = new HashMap();
            hashMap.put(IRequestConst.CT, "" + tcVar.b);
            hashMap.put("rt", "" + tcVar.c);
            hashMap.put("rs", "" + tcVar.d);
            hashMap.put("success", "" + (tcVar.a() ? 1 : 0));
            int d = d();
            if (d == 2) {
                int c = vo2.b().c();
                if (c <= 0) {
                    c = 0;
                }
                hashMap.put("sip", "" + c);
            }
            LogStoreMgr.l().d(new qa1(BizTime.UT, "19997", "_ut_nw", "" + c(), "" + d, hashMap));
        }
    }
}
