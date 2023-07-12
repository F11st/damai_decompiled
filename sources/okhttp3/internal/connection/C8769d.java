package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.C8735a;
import okhttp3.C8831s;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.C8753a;
import okhttp3.internal.connection.C8774h;
import okhttp3.internal.http.ExchangeCodec;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.d */
/* loaded from: classes2.dex */
public final class C8769d {
    private final C8776i a;
    private final C8735a b;
    private final C8772f c;
    private final Call d;
    private final EventListener e;
    private C8774h.C8775a f;
    private final C8774h g;
    private C8770e h;
    private boolean i;
    private C8831s j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8769d(C8776i c8776i, C8772f c8772f, C8735a c8735a, Call call, EventListener eventListener) {
        this.a = c8776i;
        this.c = c8772f;
        this.b = c8735a;
        this.d = call;
        this.e = eventListener;
        this.g = new C8774h(c8735a, c8772f.e, call, eventListener);
    }

    private C8770e c(int i, int i2, int i3, int i4, boolean z) throws IOException {
        C8770e c8770e;
        Socket socket;
        Socket n;
        C8770e c8770e2;
        C8831s c8831s;
        boolean z2;
        boolean z3;
        List<C8831s> list;
        C8774h.C8775a c8775a;
        synchronized (this.c) {
            if (!this.a.i()) {
                this.i = false;
                C8776i c8776i = this.a;
                c8770e = c8776i.i;
                socket = null;
                n = (c8770e == null || !c8770e.j) ? null : c8776i.n();
                C8776i c8776i2 = this.a;
                c8770e2 = c8776i2.i;
                if (c8770e2 != null) {
                    c8770e = null;
                } else {
                    c8770e2 = null;
                }
                if (c8770e2 == null) {
                    if (this.c.h(this.b, c8776i2, null, false)) {
                        c8770e2 = this.a.i;
                        c8831s = null;
                        z2 = true;
                    } else {
                        c8831s = this.j;
                        if (c8831s != null) {
                            this.j = null;
                        } else if (g()) {
                            c8831s = this.a.i.route();
                        }
                        z2 = false;
                    }
                }
                c8831s = null;
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        C8753a.h(n);
        if (c8770e != null) {
            this.e.i(this.d, c8770e);
        }
        if (z2) {
            this.e.h(this.d, c8770e2);
        }
        if (c8770e2 != null) {
            return c8770e2;
        }
        if (c8831s != null || ((c8775a = this.f) != null && c8775a.b())) {
            z3 = false;
        } else {
            this.f = this.g.d();
            z3 = true;
        }
        synchronized (this.c) {
            if (this.a.i()) {
                throw new IOException("Canceled");
            }
            if (z3) {
                list = this.f.a();
                if (this.c.h(this.b, this.a, list, false)) {
                    c8770e2 = this.a.i;
                    z2 = true;
                }
            } else {
                list = null;
            }
            if (!z2) {
                if (c8831s == null) {
                    c8831s = this.f.c();
                }
                c8770e2 = new C8770e(this.c, c8831s);
                this.h = c8770e2;
            }
        }
        if (z2) {
            this.e.h(this.d, c8770e2);
            return c8770e2;
        }
        c8770e2.d(i, i2, i3, i4, z, this.d, this.e);
        this.c.e.a(c8770e2.route());
        synchronized (this.c) {
            this.h = null;
            if (this.c.h(this.b, this.a, list, true)) {
                c8770e2.j = true;
                socket = c8770e2.socket();
                c8770e2 = this.a.i;
                this.j = c8831s;
            } else {
                this.c.g(c8770e2);
                this.a.a(c8770e2);
            }
        }
        C8753a.h(socket);
        this.e.h(this.d, c8770e2);
        return c8770e2;
    }

    private C8770e d(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            C8770e c = c(i, i2, i3, i4, z);
            synchronized (this.c) {
                if (c.l == 0 && !c.m()) {
                    return c;
                }
                if (c.l(z2)) {
                    return c;
                }
                c.p();
            }
        }
    }

    private boolean g() {
        C8770e c8770e = this.a.i;
        return c8770e != null && c8770e.k == 0 && C8753a.E(c8770e.route().a().l(), this.b.l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8770e a() {
        return this.h;
    }

    public ExchangeCodec b(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            return d(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).n(okHttpClient, chain);
        } catch (IOException e) {
            h();
            throw new RouteException(e);
        } catch (RouteException e2) {
            h();
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        synchronized (this.c) {
            boolean z = true;
            if (this.j != null) {
                return true;
            }
            if (g()) {
                this.j = this.a.i.route();
                return true;
            }
            C8774h.C8775a c8775a = this.f;
            if ((c8775a == null || !c8775a.b()) && !this.g.b()) {
                z = false;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        boolean z;
        synchronized (this.c) {
            z = this.i;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        synchronized (this.c) {
            this.i = true;
        }
    }
}
