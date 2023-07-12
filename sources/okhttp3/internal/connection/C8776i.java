package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C8735a;
import okhttp3.C8744d;
import okhttp3.C8818m;
import okhttp3.C8823o;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.C8753a;
import okio.AsyncTimeout;
import okio.C8857o;
import tb.ps1;
import tb.w31;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.i */
/* loaded from: classes2.dex */
public final class C8776i {
    private final OkHttpClient a;
    private final C8772f b;
    private final Call c;
    private final EventListener d;
    private final AsyncTimeout e;
    @Nullable
    private Object f;
    private C8823o g;
    private C8769d h;
    public C8770e i;
    @Nullable
    private C8766c j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.i$a */
    /* loaded from: classes2.dex */
    class C8777a extends AsyncTimeout {
        C8777a() {
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            C8776i.this.d();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.i$b */
    /* loaded from: classes2.dex */
    static final class C8778b extends WeakReference<C8776i> {
        final Object a;

        C8778b(C8776i c8776i, Object obj) {
            super(c8776i);
            this.a = obj;
        }
    }

    public C8776i(OkHttpClient okHttpClient, Call call) {
        C8777a c8777a = new C8777a();
        this.e = c8777a;
        this.a = okHttpClient;
        this.b = w31.a.i(okHttpClient.connectionPool());
        this.c = call;
        this.d = okHttpClient.eventListenerFactory().create(call);
        c8777a.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private C8735a e(C8818m c8818m) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        C8744d c8744d;
        if (c8818m.n()) {
            SSLSocketFactory sslSocketFactory = this.a.sslSocketFactory();
            hostnameVerifier = this.a.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            c8744d = this.a.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            c8744d = null;
        }
        return new C8735a(c8818m.m(), c8818m.x(), this.a.dns(), this.a.socketFactory(), sSLSocketFactory, hostnameVerifier, c8744d, this.a.proxyAuthenticator(), this.a.proxy(), this.a.protocols(), this.a.connectionSpecs(), this.a.proxySelector());
    }

    @Nullable
    private IOException j(@Nullable IOException iOException, boolean z) {
        C8770e c8770e;
        Socket n;
        boolean z2;
        synchronized (this.b) {
            if (z) {
                if (this.j != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            c8770e = this.i;
            n = (c8770e != null && this.j == null && (z || this.o)) ? n() : null;
            if (this.i != null) {
                c8770e = null;
            }
            z2 = this.o && this.j == null;
        }
        C8753a.h(n);
        if (c8770e != null) {
            this.d.i(this.c, c8770e);
        }
        if (z2) {
            boolean z3 = iOException != null;
            iOException = r(iOException);
            if (z3) {
                this.d.c(this.c, iOException);
            } else {
                this.d.b(this.c);
            }
        }
        return iOException;
    }

    @Nullable
    private IOException r(@Nullable IOException iOException) {
        if (!this.n && this.e.exit()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
            return interruptedIOException;
        }
        return iOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C8770e c8770e) {
        if (this.i == null) {
            this.i = c8770e;
            c8770e.o.add(new C8778b(this, this.f));
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        this.f = ps1.j().n("response.body().close()");
        this.d.d(this.c);
    }

    public boolean c() {
        return this.h.f() && this.h.e();
    }

    public void d() {
        C8766c c8766c;
        C8770e c8770e;
        synchronized (this.b) {
            this.m = true;
            c8766c = this.j;
            C8769d c8769d = this.h;
            if (c8769d != null && c8769d.a() != null) {
                c8770e = this.h.a();
            } else {
                c8770e = this.i;
            }
        }
        if (c8766c != null) {
            c8766c.b();
        } else if (c8770e != null) {
            c8770e.c();
        }
    }

    public void f() {
        synchronized (this.b) {
            if (!this.o) {
                this.j = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException g(C8766c c8766c, boolean z, boolean z2, @Nullable IOException iOException) {
        boolean z3;
        synchronized (this.b) {
            C8766c c8766c2 = this.j;
            if (c8766c != c8766c2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.k;
                this.k = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.l) {
                    z3 = true;
                }
                this.l = true;
            }
            if (this.k && this.l && z3) {
                c8766c2.c().l++;
                this.j = null;
            } else {
                z4 = false;
            }
            return z4 ? j(iOException, false) : iOException;
        }
    }

    public boolean h() {
        boolean z;
        synchronized (this.b) {
            z = this.j != null;
        }
        return z;
    }

    public boolean i() {
        boolean z;
        synchronized (this.b) {
            z = this.m;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8766c k(Interceptor.Chain chain, boolean z) {
        synchronized (this.b) {
            if (!this.o) {
                if (this.j != null) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        C8766c c8766c = new C8766c(this, this.c, this.d, this.h, this.h.b(this.a, chain, z));
        synchronized (this.b) {
            this.j = c8766c;
            this.k = false;
            this.l = false;
        }
        return c8766c;
    }

    @Nullable
    public IOException l(@Nullable IOException iOException) {
        synchronized (this.b) {
            this.o = true;
        }
        return j(iOException, false);
    }

    public void m(C8823o c8823o) {
        C8823o c8823o2 = this.g;
        if (c8823o2 != null) {
            if (C8753a.E(c8823o2.i(), c8823o.i()) && this.h.e()) {
                return;
            }
            if (this.j == null) {
                if (this.h != null) {
                    j(null, true);
                    this.h = null;
                }
            } else {
                throw new IllegalStateException();
            }
        }
        this.g = c8823o;
        this.h = new C8769d(this, this.b, e(c8823o.i()), this.c, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Socket n() {
        int i = 0;
        int size = this.i.o.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (this.i.o.get(i).get() == this) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            C8770e c8770e = this.i;
            c8770e.o.remove(i);
            this.i = null;
            if (c8770e.o.isEmpty()) {
                c8770e.p = System.nanoTime();
                if (this.b.d(c8770e)) {
                    return c8770e.socket();
                }
                return null;
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public C8857o o() {
        return this.e;
    }

    public void p() {
        if (!this.n) {
            this.n = true;
            this.e.exit();
            return;
        }
        throw new IllegalStateException();
    }

    public void q() {
        this.e.enter();
    }
}
