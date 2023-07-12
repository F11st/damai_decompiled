package okhttp3.internal.http;

import anet.channel.request.C0193a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import mtopsdk.network.util.Constants;
import okhttp3.AbstractC8825p;
import okhttp3.C8818m;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.C8831s;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.C8753a;
import okhttp3.internal.connection.C8766c;
import okhttp3.internal.connection.C8776i;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import tb.j01;
import tb.w31;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http.d */
/* loaded from: classes2.dex */
public final class C8782d implements Interceptor {
    private final OkHttpClient a;

    public C8782d(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    private C8823o a(C8827q c8827q, @Nullable C8831s c8831s) throws IOException {
        String g;
        C8818m B;
        Proxy proxy;
        if (c8827q != null) {
            int e = c8827q.e();
            String g2 = c8827q.q().g();
            if (e == 307 || e == 308) {
                if (!g2.equals("GET") && !g2.equals(C0193a.C0196c.HEAD)) {
                    return null;
                }
            } else if (e != 401) {
                if (e == 503) {
                    if ((c8827q.n() == null || c8827q.n().e() != 503) && e(c8827q, Integer.MAX_VALUE) == 0) {
                        return c8827q.q();
                    }
                    return null;
                } else if (e == 407) {
                    if (c8831s != null) {
                        proxy = c8831s.b();
                    } else {
                        proxy = this.a.proxy();
                    }
                    if (proxy.type() == Proxy.Type.HTTP) {
                        return this.a.proxyAuthenticator().authenticate(c8831s, c8827q);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (e == 408) {
                    if (this.a.retryOnConnectionFailure()) {
                        AbstractC8825p a = c8827q.q().a();
                        if (a == null || !a.g()) {
                            if ((c8827q.n() == null || c8827q.n().e() != 408) && e(c8827q, 0) <= 0) {
                                return c8827q.q();
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                } else {
                    switch (e) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                }
            } else {
                return this.a.authenticator().authenticate(c8831s, c8827q);
            }
            if (!this.a.followRedirects() || (g = c8827q.g("Location")) == null || (B = c8827q.q().i().B(g)) == null) {
                return null;
            }
            if (B.C().equals(c8827q.q().i().C()) || this.a.followSslRedirects()) {
                C8823o.C8824a h = c8827q.q().h();
                if (j01.b(g2)) {
                    boolean d = j01.d(g2);
                    if (j01.c(g2)) {
                        h.f("GET", null);
                    } else {
                        h.f(g2, d ? c8827q.q().a() : null);
                    }
                    if (!d) {
                        h.h("Transfer-Encoding");
                        h.h(Constants.Protocol.CONTENT_LENGTH);
                        h.h("Content-Type");
                    }
                }
                if (!C8753a.E(c8827q.q().i(), B)) {
                    h.h("Authorization");
                }
                return h.l(B).b();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    private boolean b(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean c(IOException iOException, C8776i c8776i, boolean z, C8823o c8823o) {
        if (this.a.retryOnConnectionFailure()) {
            return !(z && d(iOException, c8823o)) && b(iOException, z) && c8776i.c();
        }
        return false;
    }

    private boolean d(IOException iOException, C8823o c8823o) {
        AbstractC8825p a = c8823o.a();
        return (a != null && a.g()) || (iOException instanceof FileNotFoundException);
    }

    private int e(C8827q c8827q, int i) {
        String g = c8827q.g("Retry-After");
        if (g == null) {
            return i;
        }
        if (g.matches("\\d+")) {
            return Integer.valueOf(g).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // okhttp3.Interceptor
    public C8827q intercept(Interceptor.Chain chain) throws IOException {
        C8766c f;
        C8823o a;
        C8823o request = chain.request();
        C8781c c8781c = (C8781c) chain;
        C8776i c = c8781c.c();
        C8827q c8827q = null;
        int i = 0;
        while (true) {
            c.m(request);
            if (!c.i()) {
                try {
                    try {
                        C8827q b = c8781c.b(request, c, null);
                        if (c8827q != null) {
                            b = b.m().n(c8827q.m().b(null).c()).c();
                        }
                        c8827q = b;
                        f = w31.a.f(c8827q);
                        a = a(c8827q, f != null ? f.c().route() : null);
                    } catch (IOException e) {
                        if (!c(e, c, !(e instanceof ConnectionShutdownException), request)) {
                            throw e;
                        }
                    } catch (RouteException e2) {
                        if (!c(e2.getLastConnectException(), c, false, request)) {
                            throw e2.getFirstConnectException();
                        }
                    }
                    if (a == null) {
                        if (f != null && f.h()) {
                            c.p();
                        }
                        return c8827q;
                    }
                    AbstractC8825p a2 = a.a();
                    if (a2 != null && a2.g()) {
                        return c8827q;
                    }
                    C8753a.g(c8827q.a());
                    if (c.h()) {
                        f.e();
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    }
                    request = a;
                } finally {
                    c.f();
                }
            } else {
                throw new IOException("Canceled");
            }
        }
    }
}
