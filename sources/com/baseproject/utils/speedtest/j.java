package com.baseproject.utils.speedtest;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.baseproject.utils.speedtest.SpeedTestRequest;
import com.baseproject.utils.speedtest.a;
import com.baseproject.utils.speedtest.j;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.util.concurrent.ExecutorService;
import tb.l83;
import tb.m83;
import tb.q43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class j implements SpeedTestRequest.a {
    private ExecutorService a;
    private SpeedTestRequest b;
    private a c;
    private String d;
    private int e;
    private volatile boolean f = true;
    private g g;
    private h h;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        public q43 a;
        public com.baseproject.utils.speedtest.a b;
        public long c;
    }

    static {
        new j();
    }

    private j() {
    }

    private void d(int i) {
        l83 l83Var = new l83();
        l83Var.a = i;
        g(l83Var);
        g gVar = this.g;
        if (gVar != null) {
            gVar.a(l83Var);
        }
        m83.a(l83Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        int i;
        com.youku.b.a.a.a("SpeedTest", "request cmd info");
        AdapterForTLog.loge("SpeedTest", "request cmd info");
        b bVar = new b();
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = this.c;
        if (aVar != null) {
            i = bVar.a(this.d, aVar);
            this.c.c = System.currentTimeMillis() - currentTimeMillis;
        } else {
            i = -999;
        }
        if (i < 0) {
            d(i);
            c();
            return i;
        }
        com.youku.b.a.a.a("SpeedTest", "cmd info received");
        AdapterForTLog.loge("SpeedTest", "cmd info received");
        if (this.c.b.d != null) {
            this.e = 0;
            i();
            return 0;
        }
        com.youku.b.a.a.a("SpeedTest", "cmd task is empty");
        c();
        return -2005;
    }

    private void g(l83 l83Var) {
        q43 q43Var;
        a aVar = this.c;
        if (aVar == null || (q43Var = aVar.a) == null) {
            return;
        }
        l83Var.j = q43Var.p;
        l83Var.k = q43Var.q;
        l83Var.l = q43Var.r;
        l83Var.o = q43Var.t;
        l83Var.m = q43Var.s;
        l83Var.n = aVar.c;
    }

    private void i() {
        this.a.execute(new Runnable() { // from class: com.baseproject.utils.speedtest.SpeedTest$2
            @Override // java.lang.Runnable
            public void run() {
                int i;
                j.a aVar;
                int i2;
                int i3;
                j.a aVar2;
                j.a aVar3;
                j.a aVar4;
                int i4;
                int i5;
                j.a aVar5;
                SpeedTestRequest speedTestRequest;
                SpeedTestRequest speedTestRequest2;
                i = j.this.e;
                aVar = j.this.c;
                if (i >= aVar.b.d.length) {
                    j.this.c();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("exec task: index=");
                i2 = j.this.e;
                sb.append(i2);
                com.youku.b.a.a.a("SpeedTest", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("exec task: index=");
                i3 = j.this.e;
                sb2.append(i3);
                AdapterForTLog.loge("SpeedTest", sb2.toString());
                j jVar = j.this;
                aVar2 = j.this.c;
                Context context = aVar2.a.a;
                aVar3 = j.this.c;
                a aVar6 = aVar3.b;
                aVar4 = j.this.c;
                a.C0218a[] c0218aArr = aVar4.b.d;
                i4 = j.this.e;
                a.C0218a c0218a = c0218aArr[i4];
                i5 = j.this.e;
                aVar5 = j.this.c;
                jVar.b = new SpeedTestRequest(context, aVar6, c0218a, i5, aVar5.b.d.length);
                speedTestRequest = j.this.b;
                speedTestRequest.e(j.this);
                j.k(j.this);
                speedTestRequest2 = j.this.b;
                speedTestRequest2.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int k(j jVar) {
        int i = jVar.e;
        jVar.e = i + 1;
        return i;
    }

    @Override // com.baseproject.utils.speedtest.SpeedTestRequest.a
    public void a(l83 l83Var) {
        if (this.f) {
            return;
        }
        g(l83Var);
        g gVar = this.g;
        if (gVar != null) {
            gVar.a(l83Var);
        }
        m83.a(l83Var);
        com.youku.b.a.a.a("SpeedTest", JSON.toJSONString(l83Var));
        i();
    }

    public void c() {
        com.youku.b.a.a.a("SpeedTest", "cancel!");
        AdapterForTLog.loge("SpeedTest", "cancel!");
        this.f = true;
        SpeedTestRequest speedTestRequest = this.b;
        if (speedTestRequest != null && speedTestRequest.k()) {
            this.b.j();
        }
        h hVar = this.h;
        if (hVar != null) {
            hVar.a();
        }
        this.a.shutdown();
    }
}
