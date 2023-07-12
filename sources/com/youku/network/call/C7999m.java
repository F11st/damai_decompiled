package com.youku.network.call;

import android.os.Handler;
import android.text.TextUtils;
import anet.channel.status.NetworkStatusHelper;
import com.youku.android.antiflow.AntiFlowManagerImpl;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.httpcommunication.C7924a;
import com.youku.httpcommunication.C7925b;
import com.youku.network.C7984c;
import com.youku.network.C8004d;
import com.youku.network.C8007e;
import com.youku.network.InterfaceC7974a;
import com.youku.network.a.C7979e;
import com.youku.network.config.C8003b;
import com.youku.network.e.C8009a;
import com.youku.network.f.C8012b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.m */
/* loaded from: classes3.dex */
public class C7999m extends C7987a {
    private static OkHttpClient e = new OkHttpClient();
    private OkHttpClient f;
    private Call g;
    private C8823o h;
    private C8000a i;
    private C8004d j;
    private IAntiFlowManager k;
    private volatile boolean l = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.network.call.m$a */
    /* loaded from: classes3.dex */
    public final class C8000a implements Interceptor {
        private int b;
        private int c;

        public C8000a(int i) {
            this.b = i;
        }

        private C8827q a(Interceptor.Chain chain) {
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
        public C8827q intercept(Interceptor.Chain chain) {
            return a(chain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final C8001n c8001n) {
        int g;
        if (!C8009a.a() || (g = this.c.g() * (this.c.j() + 1)) <= 0) {
            return;
        }
        C8007e.c().schedule(new Runnable() { // from class: com.youku.network.call.OkHttpCall$5
            @Override // java.lang.Runnable
            public void run() {
                C8004d a = C8004d.a();
                a.a(-3017);
                c8001n.a(a);
                C7999m.this.b();
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
            this.k = new AntiFlowManagerImpl(C7925b.a, this.c.e(), this.c.M(), this.c.N());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.C8734b l = e.newBuilder().d(this.c.f(), timeUnit).k(this.c.g(), timeUnit).h(this.c.i()).l(false);
            if (this.c.j() > 0) {
                C8000a c8000a = new C8000a(this.c.j());
                this.i = c8000a;
                l.a(c8000a);
            }
            if (TextUtils.isEmpty(this.c.c()) || TextUtils.isEmpty(this.c.d())) {
                C7924a.b("yknetwork_ok", "no config dns");
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
                C7984c c7984c = this.c;
                c7984c.d(C8012b.a(c7984c.e(), this.c.d()));
                C7924a.b("yknetwork_ok", "dns config:ip:" + this.c.c() + " host:" + this.c.d());
                dns = new Dns() { // from class: com.youku.network.call.m.1
                    @Override // okhttp3.Dns
                    public List<InetAddress> lookup(String str) {
                        return Arrays.asList(InetAddress.getAllByName(C7999m.this.c.c()));
                    }
                };
            }
            l.f(dns);
            this.f = l.b();
            C7979e c7979e = new C7979e(this.k);
            this.d = c7979e;
            this.h = c7979e.a(this.c);
            this.j = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            C8004d a = C8004d.a();
            this.j = a;
            a.a(e2);
            this.j.a(-3006);
        }
        this.l = true;
    }

    @Override // com.youku.network.call.C7987a
    public C8004d a() {
        e();
        C8004d c8004d = this.j;
        if (c8004d != null) {
            return c8004d;
        }
        if (this.k.beforeCall()) {
            C8004d a = C8004d.a();
            a.b(420);
            return a;
        }
        try {
            Call newCall = this.f.newCall(this.h);
            this.g = newCall;
            return this.d.a(newCall.execute());
        } catch (IOException e2) {
            e2.printStackTrace();
            C8004d a2 = C8004d.a();
            a2.a(e2);
            return C8003b.a(a2, e2, -3005);
        }
    }

    @Override // com.youku.network.call.C7987a
    public void a(final InterfaceC7974a interfaceC7974a) {
        C8007e.b().execute(new Runnable() { // from class: com.youku.network.call.OkHttpCall$3
            @Override // java.lang.Runnable
            public void run() {
                C8004d c8004d;
                IAntiFlowManager iAntiFlowManager;
                OkHttpClient okHttpClient;
                C8823o c8823o;
                Call call;
                C8004d c8004d2;
                C8004d c8004d3;
                C8004d c8004d4;
                C7999m.this.e();
                c8004d = C7999m.this.j;
                if (c8004d != null) {
                    C7999m c7999m = C7999m.this;
                    InterfaceC7974a interfaceC7974a2 = interfaceC7974a;
                    c8004d4 = c7999m.j;
                    c7999m.a(null, interfaceC7974a2, c8004d4);
                } else if (!NetworkStatusHelper.n()) {
                    C7999m.this.j = C8004d.a();
                    c8004d2 = C7999m.this.j;
                    c8004d2.a(-3018);
                    C7999m c7999m2 = C7999m.this;
                    InterfaceC7974a interfaceC7974a3 = interfaceC7974a;
                    c8004d3 = c7999m2.j;
                    c7999m2.a(null, interfaceC7974a3, c8004d3);
                } else {
                    iAntiFlowManager = C7999m.this.k;
                    if (iAntiFlowManager.beforeCall()) {
                        C8004d a = C8004d.a();
                        a.b(420);
                        C7999m.this.a(null, interfaceC7974a, a);
                        return;
                    }
                    C7999m c7999m3 = C7999m.this;
                    okHttpClient = c7999m3.f;
                    c8823o = C7999m.this.h;
                    c7999m3.g = okHttpClient.newCall(c8823o);
                    C8001n c8001n = new C8001n(interfaceC7974a, C7999m.this.d);
                    call = C7999m.this.g;
                    call.enqueue(c8001n);
                    C7999m.this.a(c8001n);
                }
            }
        });
    }

    @Override // com.youku.network.call.C7987a
    public void a(C7984c c7984c) {
        this.c = c7984c;
    }

    @Override // com.youku.network.call.C7987a
    public void b() {
        Call call = this.g;
        if (call != null) {
            try {
                call.cancel();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.youku.network.call.C7987a
    public void b(final InterfaceC7974a interfaceC7974a) {
        C8007e.b().execute(new Runnable() { // from class: com.youku.network.call.OkHttpCall$4
            @Override // java.lang.Runnable
            public void run() {
                C8004d c8004d;
                IAntiFlowManager iAntiFlowManager;
                OkHttpClient okHttpClient;
                C8823o c8823o;
                Call call;
                C8004d c8004d2;
                C8004d c8004d3;
                C8004d c8004d4;
                C7999m.this.e();
                c8004d = C7999m.this.j;
                if (c8004d != null) {
                    C7999m c7999m = C7999m.this;
                    Handler handler = C7987a.a;
                    InterfaceC7974a interfaceC7974a2 = interfaceC7974a;
                    c8004d4 = c7999m.j;
                    c7999m.a(handler, interfaceC7974a2, c8004d4);
                } else if (!NetworkStatusHelper.n()) {
                    C7999m.this.j = C8004d.a();
                    c8004d2 = C7999m.this.j;
                    c8004d2.a(-3018);
                    C7999m c7999m2 = C7999m.this;
                    InterfaceC7974a interfaceC7974a3 = interfaceC7974a;
                    c8004d3 = c7999m2.j;
                    c7999m2.a(null, interfaceC7974a3, c8004d3);
                } else {
                    iAntiFlowManager = C7999m.this.k;
                    if (iAntiFlowManager.beforeCall()) {
                        C8004d a = C8004d.a();
                        a.b(420);
                        C7999m.this.a(null, interfaceC7974a, a);
                        return;
                    }
                    C7999m c7999m3 = C7999m.this;
                    okHttpClient = c7999m3.f;
                    c8823o = C7999m.this.h;
                    c7999m3.g = okHttpClient.newCall(c8823o);
                    C8001n c8001n = new C8001n(C7987a.a, interfaceC7974a, C7999m.this.d);
                    call = C7999m.this.g;
                    call.enqueue(c8001n);
                    C7999m.this.a(c8001n);
                }
            }
        });
    }

    public int d() {
        C8000a c8000a = this.i;
        if (c8000a != null) {
            return c8000a.a();
        }
        return 0;
    }
}
