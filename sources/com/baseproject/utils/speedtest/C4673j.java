package com.baseproject.utils.speedtest;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.baseproject.utils.speedtest.C4666a;
import com.baseproject.utils.speedtest.C4673j;
import com.baseproject.utils.speedtest.SpeedTestRequest;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.b.a.C7892a;
import java.util.concurrent.ExecutorService;
import tb.l83;
import tb.m83;
import tb.q43;

/* compiled from: Taobao */
/* renamed from: com.baseproject.utils.speedtest.j */
/* loaded from: classes10.dex */
public class C4673j implements SpeedTestRequest.InterfaceC4662a {
    private ExecutorService a;
    private SpeedTestRequest b;
    private C4674a c;
    private String d;
    private int e;
    private volatile boolean f = true;
    private InterfaceC4671g g;
    private InterfaceC4672h h;

    /* compiled from: Taobao */
    /* renamed from: com.baseproject.utils.speedtest.j$a */
    /* loaded from: classes10.dex */
    public static class C4674a {
        public q43 a;
        public C4666a b;
        public long c;
    }

    static {
        new C4673j();
    }

    private C4673j() {
    }

    private void d(int i) {
        l83 l83Var = new l83();
        l83Var.a = i;
        g(l83Var);
        InterfaceC4671g interfaceC4671g = this.g;
        if (interfaceC4671g != null) {
            interfaceC4671g.a(l83Var);
        }
        m83.a(l83Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        int i;
        C7892a.a("SpeedTest", "request cmd info");
        AdapterForTLog.loge("SpeedTest", "request cmd info");
        C4668b c4668b = new C4668b();
        long currentTimeMillis = System.currentTimeMillis();
        C4674a c4674a = this.c;
        if (c4674a != null) {
            i = c4668b.a(this.d, c4674a);
            this.c.c = System.currentTimeMillis() - currentTimeMillis;
        } else {
            i = -999;
        }
        if (i < 0) {
            d(i);
            c();
            return i;
        }
        C7892a.a("SpeedTest", "cmd info received");
        AdapterForTLog.loge("SpeedTest", "cmd info received");
        if (this.c.b.d != null) {
            this.e = 0;
            i();
            return 0;
        }
        C7892a.a("SpeedTest", "cmd task is empty");
        c();
        return -2005;
    }

    private void g(l83 l83Var) {
        q43 q43Var;
        C4674a c4674a = this.c;
        if (c4674a == null || (q43Var = c4674a.a) == null) {
            return;
        }
        l83Var.j = q43Var.p;
        l83Var.k = q43Var.q;
        l83Var.l = q43Var.r;
        l83Var.o = q43Var.t;
        l83Var.m = q43Var.s;
        l83Var.n = c4674a.c;
    }

    private void i() {
        this.a.execute(new Runnable() { // from class: com.baseproject.utils.speedtest.SpeedTest$2
            @Override // java.lang.Runnable
            public void run() {
                int i;
                C4673j.C4674a c4674a;
                int i2;
                int i3;
                C4673j.C4674a c4674a2;
                C4673j.C4674a c4674a3;
                C4673j.C4674a c4674a4;
                int i4;
                int i5;
                C4673j.C4674a c4674a5;
                SpeedTestRequest speedTestRequest;
                SpeedTestRequest speedTestRequest2;
                i = C4673j.this.e;
                c4674a = C4673j.this.c;
                if (i >= c4674a.b.d.length) {
                    C4673j.this.c();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("exec task: index=");
                i2 = C4673j.this.e;
                sb.append(i2);
                C7892a.a("SpeedTest", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("exec task: index=");
                i3 = C4673j.this.e;
                sb2.append(i3);
                AdapterForTLog.loge("SpeedTest", sb2.toString());
                C4673j c4673j = C4673j.this;
                c4674a2 = C4673j.this.c;
                Context context = c4674a2.a.a;
                c4674a3 = C4673j.this.c;
                C4666a c4666a = c4674a3.b;
                c4674a4 = C4673j.this.c;
                C4666a.C4667a[] c4667aArr = c4674a4.b.d;
                i4 = C4673j.this.e;
                C4666a.C4667a c4667a = c4667aArr[i4];
                i5 = C4673j.this.e;
                c4674a5 = C4673j.this.c;
                c4673j.b = new SpeedTestRequest(context, c4666a, c4667a, i5, c4674a5.b.d.length);
                speedTestRequest = C4673j.this.b;
                speedTestRequest.e(C4673j.this);
                C4673j.k(C4673j.this);
                speedTestRequest2 = C4673j.this.b;
                speedTestRequest2.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int k(C4673j c4673j) {
        int i = c4673j.e;
        c4673j.e = i + 1;
        return i;
    }

    @Override // com.baseproject.utils.speedtest.SpeedTestRequest.InterfaceC4662a
    public void a(l83 l83Var) {
        if (this.f) {
            return;
        }
        g(l83Var);
        InterfaceC4671g interfaceC4671g = this.g;
        if (interfaceC4671g != null) {
            interfaceC4671g.a(l83Var);
        }
        m83.a(l83Var);
        C7892a.a("SpeedTest", JSON.toJSONString(l83Var));
        i();
    }

    public void c() {
        C7892a.a("SpeedTest", "cancel!");
        AdapterForTLog.loge("SpeedTest", "cancel!");
        this.f = true;
        SpeedTestRequest speedTestRequest = this.b;
        if (speedTestRequest != null && speedTestRequest.k()) {
            this.b.j();
        }
        InterfaceC4672h interfaceC4672h = this.h;
        if (interfaceC4672h != null) {
            interfaceC4672h.a();
        }
        this.a.shutdown();
    }
}
