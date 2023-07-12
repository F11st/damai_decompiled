package com.youku.network.call;

import android.os.Handler;
import android.text.TextUtils;
import anet.channel.status.NetworkStatusHelper;
import com.youku.android.antiflow.AntiFlowManagerImpl;
import com.youku.android.antiflow.IAntiFlowManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.o;
import okhttp3.q;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class m extends com.youku.network.call.a {
    private static OkHttpClient e = new OkHttpClient();
    private OkHttpClient f;
    private Call g;
    private o h;
    private a i;
    private com.youku.network.d j;
    private IAntiFlowManager k;
    private volatile boolean l = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class a implements Interceptor {
        private int b;
        private int c;

        public a(int i) {
            this.b = i;
        }

        private q a(Interceptor.Chain chain) {
            try {
                return chain.proceed(chain.request());
            } catch (Throwable th) {
                int i = this.c;
                if (i < this.b) {
                    this.c = i + 1;
                    return a(chain);
                } else if (th instanceof IOException) {
                    throw th;
                } else {
                    throw new IOException("error:" + th.getMessage());
                }
            }
        }

        public int a() {
            return this.c;
        }

        @Override // okhttp3.Interceptor
        public q intercept(Interceptor.Chain chain) {
            return a(chain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final n nVar) {
        int g;
        if (!com.youku.network.e.a.a() || (g = this.c.g() * (this.c.j() + 1)) <= 0) {
            return;
        }
        com.youku.network.e.c().schedule(new Runnable() { // from class: com.youku.network.call.OkHttpCall$5
            @Override // java.lang.Runnable
            public void run() {
                com.youku.network.d a2 = com.youku.network.d.a();
                a2.a(-3017);
                nVar.a(a2);
                m.this.b();
            }
        }, g, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Dns dns;
        if (this.l) {
            return;
        }
        try {
            this.k = new AntiFlowManagerImpl(com.youku.httpcommunication.b.a, this.c.e(), this.c.M(), this.c.N());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.b l = e.newBuilder().d(this.c.f(), timeUnit).k(this.c.g(), timeUnit).h(this.c.i()).l(false);
            if (this.c.j() > 0) {
                a aVar = new a(this.c.j());
                this.i = aVar;
                l.a(aVar);
            }
            if (TextUtils.isEmpty(this.c.c()) || TextUtils.isEmpty(this.c.d())) {
                com.youku.httpcommunication.a.b("yknetwork_ok", "no config dns");
                dns = new Dns() { // from class: com.youku.network.call.m.2
                    @Override // okhttp3.Dns
                    public List<InetAddress> lookup(String str) {
                        if (str != null) {
                            return Arrays.asList(InetAddress.getAllByName(str));
                        }
                        throw new UnknownHostException("hostname == null");
                    }
                };
            } else {
                com.youku.network.c cVar = this.c;
                cVar.d(com.youku.network.f.b.a(cVar.e(), this.c.d()));
                com.youku.httpcommunication.a.b("yknetwork_ok", "dns config:ip:" + this.c.c() + " host:" + this.c.d());
                dns = new Dns() { // from class: com.youku.network.call.m.1
                    @Override // okhttp3.Dns
                    public List<InetAddress> lookup(String str) {
                        return Arrays.asList(InetAddress.getAllByName(m.this.c.c()));
                    }
                };
            }
            l.f(dns);
            this.f = l.b();
            com.youku.network.a.e eVar = new com.youku.network.a.e(this.k);
            this.d = eVar;
            this.h = eVar.a(this.c);
            this.j = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.youku.network.d a2 = com.youku.network.d.a();
            this.j = a2;
            a2.a(e2);
            this.j.a(-3006);
        }
        this.l = true;
    }

    @Override // com.youku.network.call.a
    public com.youku.network.d a() {
        e();
        com.youku.network.d dVar = this.j;
        if (dVar != null) {
            return dVar;
        }
        if (this.k.beforeCall()) {
            com.youku.network.d a2 = com.youku.network.d.a();
            a2.b(420);
            return a2;
        }
        try {
            Call newCall = this.f.newCall(this.h);
            this.g = newCall;
            return this.d.a(newCall.execute());
        } catch (IOException e2) {
            e2.printStackTrace();
            com.youku.network.d a3 = com.youku.network.d.a();
            a3.a(e2);
            return com.youku.network.config.b.a(a3, e2, -3005);
        }
    }

    @Override // com.youku.network.call.a
    public void a(final com.youku.network.a aVar) {
        com.youku.network.e.b().execute(new Runnable() { // from class: com.youku.network.call.OkHttpCall$3
            @Override // java.lang.Runnable
            public void run() {
                com.youku.network.d dVar;
                IAntiFlowManager iAntiFlowManager;
                OkHttpClient okHttpClient;
                o oVar;
                Call call;
                com.youku.network.d dVar2;
                com.youku.network.d dVar3;
                com.youku.network.d dVar4;
                m.this.e();
                dVar = m.this.j;
                if (dVar != null) {
                    m mVar = m.this;
                    com.youku.network.a aVar2 = aVar;
                    dVar4 = mVar.j;
                    mVar.a(null, aVar2, dVar4);
                } else if (!NetworkStatusHelper.n()) {
                    m.this.j = com.youku.network.d.a();
                    dVar2 = m.this.j;
                    dVar2.a(-3018);
                    m mVar2 = m.this;
                    com.youku.network.a aVar3 = aVar;
                    dVar3 = mVar2.j;
                    mVar2.a(null, aVar3, dVar3);
                } else {
                    iAntiFlowManager = m.this.k;
                    if (iAntiFlowManager.beforeCall()) {
                        com.youku.network.d a2 = com.youku.network.d.a();
                        a2.b(420);
                        m.this.a(null, aVar, a2);
                        return;
                    }
                    m mVar3 = m.this;
                    okHttpClient = mVar3.f;
                    oVar = m.this.h;
                    mVar3.g = okHttpClient.newCall(oVar);
                    n nVar = new n(aVar, m.this.d);
                    call = m.this.g;
                    call.enqueue(nVar);
                    m.this.a(nVar);
                }
            }
        });
    }

    @Override // com.youku.network.call.a
    public void a(com.youku.network.c cVar) {
        this.c = cVar;
    }

    @Override // com.youku.network.call.a
    public void b() {
        Call call = this.g;
        if (call != null) {
            try {
                call.cancel();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.youku.network.call.a
    public void b(final com.youku.network.a aVar) {
        com.youku.network.e.b().execute(new Runnable() { // from class: com.youku.network.call.OkHttpCall$4
            @Override // java.lang.Runnable
            public void run() {
                com.youku.network.d dVar;
                IAntiFlowManager iAntiFlowManager;
                OkHttpClient okHttpClient;
                o oVar;
                Call call;
                com.youku.network.d dVar2;
                com.youku.network.d dVar3;
                com.youku.network.d dVar4;
                m.this.e();
                dVar = m.this.j;
                if (dVar != null) {
                    m mVar = m.this;
                    Handler handler = a.a;
                    com.youku.network.a aVar2 = aVar;
                    dVar4 = mVar.j;
                    mVar.a(handler, aVar2, dVar4);
                } else if (!NetworkStatusHelper.n()) {
                    m.this.j = com.youku.network.d.a();
                    dVar2 = m.this.j;
                    dVar2.a(-3018);
                    m mVar2 = m.this;
                    com.youku.network.a aVar3 = aVar;
                    dVar3 = mVar2.j;
                    mVar2.a(null, aVar3, dVar3);
                } else {
                    iAntiFlowManager = m.this.k;
                    if (iAntiFlowManager.beforeCall()) {
                        com.youku.network.d a2 = com.youku.network.d.a();
                        a2.b(420);
                        m.this.a(null, aVar, a2);
                        return;
                    }
                    m mVar3 = m.this;
                    okHttpClient = mVar3.f;
                    oVar = m.this.h;
                    mVar3.g = okHttpClient.newCall(oVar);
                    n nVar = new n(a.a, aVar, m.this.d);
                    call = m.this.g;
                    call.enqueue(nVar);
                    m.this.a(nVar);
                }
            }
        });
    }

    public int d() {
        a aVar = this.i;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }
}
