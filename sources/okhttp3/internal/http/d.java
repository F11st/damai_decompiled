package okhttp3.internal.http;

import anet.channel.request.a;
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
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.m;
import okhttp3.o;
import okhttp3.p;
import okhttp3.q;
import okhttp3.s;
import tb.j01;
import tb.w31;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class d implements Interceptor {
    private final OkHttpClient a;

    public d(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    private o a(q qVar, @Nullable s sVar) throws IOException {
        String g;
        m B;
        Proxy proxy;
        if (qVar != null) {
            int e = qVar.e();
            String g2 = qVar.q().g();
            if (e == 307 || e == 308) {
                if (!g2.equals("GET") && !g2.equals(a.c.HEAD)) {
                    return null;
                }
            } else if (e != 401) {
                if (e == 503) {
                    if ((qVar.n() == null || qVar.n().e() != 503) && e(qVar, Integer.MAX_VALUE) == 0) {
                        return qVar.q();
                    }
                    return null;
                } else if (e == 407) {
                    if (sVar != null) {
                        proxy = sVar.b();
                    } else {
                        proxy = this.a.proxy();
                    }
                    if (proxy.type() == Proxy.Type.HTTP) {
                        return this.a.proxyAuthenticator().authenticate(sVar, qVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (e == 408) {
                    if (this.a.retryOnConnectionFailure()) {
                        p a = qVar.q().a();
                        if (a == null || !a.g()) {
                            if ((qVar.n() == null || qVar.n().e() != 408) && e(qVar, 0) <= 0) {
                                return qVar.q();
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
                return this.a.authenticator().authenticate(sVar, qVar);
            }
            if (!this.a.followRedirects() || (g = qVar.g("Location")) == null || (B = qVar.q().i().B(g)) == null) {
                return null;
            }
            if (B.C().equals(qVar.q().i().C()) || this.a.followSslRedirects()) {
                o.a h = qVar.q().h();
                if (j01.b(g2)) {
                    boolean d = j01.d(g2);
                    if (j01.c(g2)) {
                        h.f("GET", null);
                    } else {
                        h.f(g2, d ? qVar.q().a() : null);
                    }
                    if (!d) {
                        h.h("Transfer-Encoding");
                        h.h(Constants.Protocol.CONTENT_LENGTH);
                        h.h("Content-Type");
                    }
                }
                if (!okhttp3.internal.a.E(qVar.q().i(), B)) {
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

    private boolean c(IOException iOException, i iVar, boolean z, o oVar) {
        if (this.a.retryOnConnectionFailure()) {
            return !(z && d(iOException, oVar)) && b(iOException, z) && iVar.c();
        }
        return false;
    }

    private boolean d(IOException iOException, o oVar) {
        p a = oVar.a();
        return (a != null && a.g()) || (iOException instanceof FileNotFoundException);
    }

    private int e(q qVar, int i) {
        String g = qVar.g("Retry-After");
        if (g == null) {
            return i;
        }
        if (g.matches("\\d+")) {
            return Integer.valueOf(g).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // okhttp3.Interceptor
    public q intercept(Interceptor.Chain chain) throws IOException {
        okhttp3.internal.connection.c f;
        o a;
        o request = chain.request();
        c cVar = (c) chain;
        i c = cVar.c();
        q qVar = null;
        int i = 0;
        while (true) {
            c.m(request);
            if (!c.i()) {
                try {
                    try {
                        q b = cVar.b(request, c, null);
                        if (qVar != null) {
                            b = b.m().n(qVar.m().b(null).c()).c();
                        }
                        qVar = b;
                        f = w31.a.f(qVar);
                        a = a(qVar, f != null ? f.c().route() : null);
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
                        return qVar;
                    }
                    p a2 = a.a();
                    if (a2 != null && a2.g()) {
                        return qVar;
                    }
                    okhttp3.internal.a.g(qVar.a());
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
