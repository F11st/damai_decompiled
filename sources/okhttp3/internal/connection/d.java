package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.connection.h;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class d {
    private final i a;
    private final okhttp3.a b;
    private final f c;
    private final Call d;
    private final EventListener e;
    private h.a f;
    private final h g;
    private e h;
    private boolean i;
    private s j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(i iVar, f fVar, okhttp3.a aVar, Call call, EventListener eventListener) {
        this.a = iVar;
        this.c = fVar;
        this.b = aVar;
        this.d = call;
        this.e = eventListener;
        this.g = new h(aVar, fVar.e, call, eventListener);
    }

    private e c(int i, int i2, int i3, int i4, boolean z) throws IOException {
        e eVar;
        Socket socket;
        Socket n;
        e eVar2;
        s sVar;
        boolean z2;
        boolean z3;
        List<s> list;
        h.a aVar;
        synchronized (this.c) {
            if (!this.a.i()) {
                this.i = false;
                i iVar = this.a;
                eVar = iVar.i;
                socket = null;
                n = (eVar == null || !eVar.j) ? null : iVar.n();
                i iVar2 = this.a;
                eVar2 = iVar2.i;
                if (eVar2 != null) {
                    eVar = null;
                } else {
                    eVar2 = null;
                }
                if (eVar2 == null) {
                    if (this.c.h(this.b, iVar2, null, false)) {
                        eVar2 = this.a.i;
                        sVar = null;
                        z2 = true;
                    } else {
                        sVar = this.j;
                        if (sVar != null) {
                            this.j = null;
                        } else if (g()) {
                            sVar = this.a.i.route();
                        }
                        z2 = false;
                    }
                }
                sVar = null;
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        okhttp3.internal.a.h(n);
        if (eVar != null) {
            this.e.i(this.d, eVar);
        }
        if (z2) {
            this.e.h(this.d, eVar2);
        }
        if (eVar2 != null) {
            return eVar2;
        }
        if (sVar != null || ((aVar = this.f) != null && aVar.b())) {
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
                    eVar2 = this.a.i;
                    z2 = true;
                }
            } else {
                list = null;
            }
            if (!z2) {
                if (sVar == null) {
                    sVar = this.f.c();
                }
                eVar2 = new e(this.c, sVar);
                this.h = eVar2;
            }
        }
        if (z2) {
            this.e.h(this.d, eVar2);
            return eVar2;
        }
        eVar2.d(i, i2, i3, i4, z, this.d, this.e);
        this.c.e.a(eVar2.route());
        synchronized (this.c) {
            this.h = null;
            if (this.c.h(this.b, this.a, list, true)) {
                eVar2.j = true;
                socket = eVar2.socket();
                eVar2 = this.a.i;
                this.j = sVar;
            } else {
                this.c.g(eVar2);
                this.a.a(eVar2);
            }
        }
        okhttp3.internal.a.h(socket);
        this.e.h(this.d, eVar2);
        return eVar2;
    }

    private e d(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            e c = c(i, i2, i3, i4, z);
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
        e eVar = this.a.i;
        return eVar != null && eVar.k == 0 && okhttp3.internal.a.E(eVar.route().a().l(), this.b.l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a() {
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
            h.a aVar = this.f;
            if ((aVar == null || !aVar.b()) && !this.g.b()) {
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
