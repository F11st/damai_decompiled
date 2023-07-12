package okhttp3.internal.connection;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.k;
import okhttp3.m;
import okhttp3.o;
import okhttp3.q;
import okhttp3.s;
import okio.BufferedSink;
import okio.BufferedSource;
import tb.b01;
import tb.fx2;
import tb.pm1;
import tb.ps1;
import tb.w31;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class e extends Http2Connection.b implements Connection {
    public final f a;
    private final s b;
    private Socket c;
    private Socket d;
    private k e;
    private Protocol f;
    private Http2Connection g;
    private BufferedSource h;
    private BufferedSink i;
    boolean j;
    int k;
    int l;
    private int m;
    private int n = 1;
    final List<Reference<i>> o = new ArrayList();
    long p = AbsPerformance.LONG_NIL;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class a extends RealWebSocket.d {
        final /* synthetic */ c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e eVar, boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink, c cVar) {
            super(z, bufferedSource, bufferedSink);
            this.d = cVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.d.a(-1L, true, true, null);
        }
    }

    public e(f fVar, s sVar) {
        this.a = fVar;
        this.b = sVar;
    }

    private void e(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket createSocket;
        Proxy b = this.b.b();
        okhttp3.a a2 = this.b.a();
        if (b.type() != Proxy.Type.DIRECT && b.type() != Proxy.Type.HTTP) {
            createSocket = new Socket(b);
        } else {
            createSocket = a2.j().createSocket();
        }
        this.c = createSocket;
        eventListener.g(call, this.b.d(), b);
        this.c.setSoTimeout(i2);
        try {
            ps1.j().h(this.c, this.b.d(), i);
            try {
                this.h = okio.h.d(okio.h.m(this.c));
                this.i = okio.h.c(okio.h.i(this.c));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.b.d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void f(b bVar) throws IOException {
        Protocol protocol;
        okhttp3.a a2 = this.b.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) a2.k().createSocket(this.c, a2.l().m(), a2.l().x(), true);
                try {
                    okhttp3.g a3 = bVar.a(sSLSocket2);
                    if (a3.f()) {
                        ps1.j().g(sSLSocket2, a2.l().m(), a2.f());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    k b = k.b(session);
                    if (!a2.e().verify(a2.l().m(), session)) {
                        List<Certificate> f = b.f();
                        if (!f.isEmpty()) {
                            X509Certificate x509Certificate = (X509Certificate) f.get(0);
                            throw new SSLPeerUnverifiedException("Hostname " + a2.l().m() + " not verified:\n    certificate: " + okhttp3.d.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + pm1.a(x509Certificate));
                        }
                        throw new SSLPeerUnverifiedException("Hostname " + a2.l().m() + " not verified (no certificates)");
                    }
                    a2.a().a(a2.l().m(), b.f());
                    String m = a3.f() ? ps1.j().m(sSLSocket2) : null;
                    this.d = sSLSocket2;
                    this.h = okio.h.d(okio.h.m(sSLSocket2));
                    this.i = okio.h.c(okio.h.i(this.d));
                    this.e = b;
                    if (m != null) {
                        protocol = Protocol.get(m);
                    } else {
                        protocol = Protocol.HTTP_1_1;
                    }
                    this.f = protocol;
                    ps1.j().a(sSLSocket2);
                } catch (AssertionError e) {
                    e = e;
                    if (!okhttp3.internal.a.A(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        ps1.j().a(sSLSocket);
                    }
                    okhttp3.internal.a.h(sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    private void g(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        o i4 = i();
        m i5 = i4.i();
        for (int i6 = 0; i6 < 21; i6++) {
            e(i, i2, call, eventListener);
            i4 = h(i2, i3, i4, i5);
            if (i4 == null) {
                return;
            }
            okhttp3.internal.a.h(this.c);
            this.c = null;
            this.i = null;
            this.h = null;
            eventListener.e(call, this.b.d(), this.b.b(), null);
        }
    }

    private o h(int i, int i2, o oVar, m mVar) throws IOException {
        String str = "CONNECT " + okhttp3.internal.a.s(mVar, true) + " HTTP/1.1";
        while (true) {
            b01 b01Var = new b01(null, null, this.h, this.i);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.h.timeout().timeout(i, timeUnit);
            this.i.timeout().timeout(i2, timeUnit);
            b01Var.t(oVar.e(), str);
            b01Var.finishRequest();
            q c = b01Var.readResponseHeaders(false).q(oVar).c();
            b01Var.s(c);
            int e = c.e();
            if (e == 200) {
                if (this.h.getBuffer().exhausted() && this.i.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (e == 407) {
                o authenticate = this.b.a().h().authenticate(this.b, c);
                if (authenticate != null) {
                    if ("close".equalsIgnoreCase(c.g(IRequestConst.CONNECTION))) {
                        return authenticate;
                    }
                    oVar = authenticate;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + c.e());
            }
        }
    }

    private o i() throws IOException {
        o b = new o.a().l(this.b.a().l()).f("CONNECT", null).d(BizTime.HOST, okhttp3.internal.a.s(this.b.a().l(), true)).d("Proxy-Connection", IRequestConst.CONNECTION_VALUE).d(IRequestConst.USER_AGENT, fx2.a()).b();
        o authenticate = this.b.a().h().authenticate(this.b, new q.a().q(b).o(Protocol.HTTP_1_1).g(407).l("Preemptive Authenticate").b(okhttp3.internal.a.EMPTY_RESPONSE).r(-1L).p(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return authenticate != null ? authenticate : b;
    }

    private void j(b bVar, int i, Call call, EventListener eventListener) throws IOException {
        if (this.b.a().k() == null) {
            List<Protocol> f = this.b.a().f();
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (f.contains(protocol)) {
                this.d = this.c;
                this.f = protocol;
                r(i);
                return;
            }
            this.d = this.c;
            this.f = Protocol.HTTP_1_1;
            return;
        }
        eventListener.y(call);
        f(bVar);
        eventListener.x(call, this.e);
        if (this.f == Protocol.HTTP_2) {
            r(i);
        }
    }

    private boolean q(List<s> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            s sVar = list.get(i);
            if (sVar.b().type() == Proxy.Type.DIRECT && this.b.b().type() == Proxy.Type.DIRECT && this.b.d().equals(sVar.d())) {
                return true;
            }
        }
        return false;
    }

    private void r(int i) throws IOException {
        this.d.setSoTimeout(0);
        Http2Connection a2 = new Http2Connection.a(true).d(this.d, this.b.a().l().m(), this.h, this.i).b(this).c(i).a();
        this.g = a2;
        a2.D();
    }

    @Override // okhttp3.internal.http2.Http2Connection.b
    public void a(Http2Connection http2Connection) {
        synchronized (this.a) {
            this.n = http2Connection.r();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.b
    public void b(okhttp3.internal.http2.e eVar) throws IOException {
        eVar.d(ErrorCode.REFUSED_STREAM, null);
    }

    public void c() {
        okhttp3.internal.a.h(this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0090 A[Catch: IOException -> 0x00f9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00f9, blocks: (B:18:0x0088, B:20:0x0090), top: B:66:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142 A[EDGE_INSN: B:76:0x0142->B:61:0x0142 ?: BREAK  ] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.d(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    @Override // okhttp3.Connection
    public k handshake() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(okhttp3.a aVar, @Nullable List<s> list) {
        if (this.o.size() >= this.n || this.j || !w31.a.e(this.b.a(), aVar)) {
            return false;
        }
        if (aVar.l().m().equals(route().a().l().m())) {
            return true;
        }
        if (this.g != null && list != null && q(list) && aVar.e() == pm1.INSTANCE && s(aVar.l())) {
            try {
                aVar.a().a(aVar.l().m(), handshake().f());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean l(boolean z) {
        if (this.d.isClosed() || this.d.isInputShutdown() || this.d.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.g;
        if (http2Connection != null) {
            return http2Connection.q(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.d.getSoTimeout();
                try {
                    this.d.setSoTimeout(1);
                    return !this.h.exhausted();
                } finally {
                    this.d.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean m() {
        return this.g != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExchangeCodec n(OkHttpClient okHttpClient, Interceptor.Chain chain) throws SocketException {
        if (this.g != null) {
            return new okhttp3.internal.http2.d(okHttpClient, this, chain, this.g);
        }
        this.d.setSoTimeout(chain.readTimeoutMillis());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.h.timeout().timeout(chain.readTimeoutMillis(), timeUnit);
        this.i.timeout().timeout(chain.writeTimeoutMillis(), timeUnit);
        return new b01(okHttpClient, this, this.h, this.i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealWebSocket.d o(c cVar) throws SocketException {
        this.d.setSoTimeout(0);
        p();
        return new a(this, true, this.h, this.i, cVar);
    }

    public void p() {
        synchronized (this.a) {
            this.j = true;
        }
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.f;
    }

    @Override // okhttp3.Connection
    public s route() {
        return this.b;
    }

    public boolean s(m mVar) {
        if (mVar.x() != this.b.a().l().x()) {
            return false;
        }
        if (mVar.m().equals(this.b.a().l().m())) {
            return true;
        }
        return this.e != null && pm1.INSTANCE.c(mVar.m(), (X509Certificate) this.e.f().get(0));
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(@Nullable IOException iOException) {
        synchronized (this.a) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.m + 1;
                    this.m = i;
                    if (i > 1) {
                        this.j = true;
                        this.k++;
                    }
                } else if (errorCode != ErrorCode.CANCEL) {
                    this.j = true;
                    this.k++;
                }
            } else if (!m() || (iOException instanceof ConnectionShutdownException)) {
                this.j = true;
                if (this.l == 0) {
                    if (iOException != null) {
                        this.a.c(this.b, iOException);
                    }
                    this.k++;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.b.a().l().m());
        sb.append(":");
        sb.append(this.b.a().l().x());
        sb.append(", proxy=");
        sb.append(this.b.b());
        sb.append(" hostAddress=");
        sb.append(this.b.d());
        sb.append(" cipherSuite=");
        k kVar = this.e;
        sb.append(kVar != null ? kVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f);
        sb.append('}');
        return sb.toString();
    }
}
