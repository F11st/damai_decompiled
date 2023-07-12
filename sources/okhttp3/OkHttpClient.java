package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.C8816l;
import okhttp3.C8827q;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.C8753a;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.C8766c;
import okhttp3.internal.connection.C8772f;
import okhttp3.internal.tls.AbstractC8805b;
import okhttp3.internal.ws.RealWebSocket;
import tb.bm1;
import tb.g13;
import tb.pm1;
import tb.ps1;
import tb.w31;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    final Authenticator authenticator;
    @Nullable
    final C8737c cache;
    final int callTimeout;
    final AbstractC8805b certificateChainCleaner;
    final C8744d certificatePinner;
    final int connectTimeout;
    final C8748f connectionPool;
    final List<C8749g> connectionSpecs;
    final CookieJar cookieJar;
    final C8751h dispatcher;
    final Dns dns;
    final EventListener.Factory eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;
    @Nullable
    final InternalCache internalCache;
    final List<Interceptor> networkInterceptors;
    final int pingInterval;
    final List<Protocol> protocols;
    @Nullable
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final int writeTimeout;
    static final List<Protocol> DEFAULT_PROTOCOLS = C8753a.u(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<C8749g> DEFAULT_CONNECTION_SPECS = C8753a.u(C8749g.MODERN_TLS, C8749g.CLEARTEXT);

    /* compiled from: Taobao */
    /* renamed from: okhttp3.OkHttpClient$a */
    /* loaded from: classes2.dex */
    class C8733a extends w31 {
        C8733a() {
        }

        @Override // tb.w31
        public void a(C8816l.C8817a c8817a, String str) {
            c8817a.b(str);
        }

        @Override // tb.w31
        public void b(C8816l.C8817a c8817a, String str, String str2) {
            c8817a.c(str, str2);
        }

        @Override // tb.w31
        public void c(C8749g c8749g, SSLSocket sSLSocket, boolean z) {
            c8749g.a(sSLSocket, z);
        }

        @Override // tb.w31
        public int d(C8827q.C8828a c8828a) {
            return c8828a.c;
        }

        @Override // tb.w31
        public boolean e(C8735a c8735a, C8735a c8735a2) {
            return c8735a.d(c8735a2);
        }

        @Override // tb.w31
        @Nullable
        public C8766c f(C8827q c8827q) {
            return c8827q.m;
        }

        @Override // tb.w31
        public void g(C8827q.C8828a c8828a, C8766c c8766c) {
            c8828a.k(c8766c);
        }

        @Override // tb.w31
        public Call h(OkHttpClient okHttpClient, C8823o c8823o) {
            return RealCall.newRealCall(okHttpClient, c8823o, true);
        }

        @Override // tb.w31
        public C8772f i(C8748f c8748f) {
            return c8748f.a;
        }
    }

    static {
        w31.a = new C8733a();
    }

    public OkHttpClient() {
        this(new C8734b());
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext l = ps1.j().l();
            l.init(null, new TrustManager[]{x509TrustManager}, null);
            return l.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS", e);
        }
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    @Nullable
    public C8737c cache() {
        return this.cache;
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public C8744d certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public C8748f connectionPool() {
        return this.connectionPool;
    }

    public List<C8749g> connectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public C8751h dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public InternalCache internalCache() {
        C8737c c8737c = this.cache;
        return c8737c != null ? c8737c.a : this.internalCache;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public C8734b newBuilder() {
        return new C8734b(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(C8823o c8823o) {
        return RealCall.newRealCall(this, c8823o, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(C8823o c8823o, g13 g13Var) {
        RealWebSocket realWebSocket = new RealWebSocket(c8823o, g13Var, new Random(), this.pingInterval);
        realWebSocket.d(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    OkHttpClient(C8734b c8734b) {
        boolean z;
        this.dispatcher = c8734b.a;
        this.proxy = c8734b.b;
        this.protocols = c8734b.c;
        List<C8749g> list = c8734b.d;
        this.connectionSpecs = list;
        this.interceptors = C8753a.t(c8734b.e);
        this.networkInterceptors = C8753a.t(c8734b.f);
        this.eventListenerFactory = c8734b.g;
        this.proxySelector = c8734b.h;
        this.cookieJar = c8734b.i;
        this.cache = c8734b.j;
        this.internalCache = c8734b.k;
        this.socketFactory = c8734b.l;
        loop0: while (true) {
            for (C8749g c8749g : list) {
                z = z || c8749g.d();
            }
        }
        SSLSocketFactory sSLSocketFactory = c8734b.m;
        if (sSLSocketFactory == null && z) {
            X509TrustManager D = C8753a.D();
            this.sslSocketFactory = newSslSocketFactory(D);
            this.certificateChainCleaner = AbstractC8805b.b(D);
        } else {
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = c8734b.n;
        }
        if (this.sslSocketFactory != null) {
            ps1.j().f(this.sslSocketFactory);
        }
        this.hostnameVerifier = c8734b.o;
        this.certificatePinner = c8734b.p.f(this.certificateChainCleaner);
        this.proxyAuthenticator = c8734b.q;
        this.authenticator = c8734b.r;
        this.connectionPool = c8734b.s;
        this.dns = c8734b.t;
        this.followSslRedirects = c8734b.u;
        this.followRedirects = c8734b.v;
        this.retryOnConnectionFailure = c8734b.w;
        this.callTimeout = c8734b.x;
        this.connectTimeout = c8734b.y;
        this.readTimeout = c8734b.z;
        this.writeTimeout = c8734b.A;
        this.pingInterval = c8734b.B;
        if (!this.interceptors.contains(null)) {
            if (this.networkInterceptors.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.interceptors);
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.OkHttpClient$b */
    /* loaded from: classes2.dex */
    public static final class C8734b {
        int A;
        int B;
        C8751h a;
        @Nullable
        Proxy b;
        List<Protocol> c;
        List<C8749g> d;
        final List<Interceptor> e;
        final List<Interceptor> f;
        EventListener.Factory g;
        ProxySelector h;
        CookieJar i;
        @Nullable
        C8737c j;
        @Nullable
        InternalCache k;
        SocketFactory l;
        @Nullable
        SSLSocketFactory m;
        @Nullable
        AbstractC8805b n;
        HostnameVerifier o;
        C8744d p;
        Authenticator q;
        Authenticator r;
        C8748f s;
        Dns t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public C8734b() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = new C8751h();
            this.c = OkHttpClient.DEFAULT_PROTOCOLS;
            this.d = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.g = EventListener.l(EventListener.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new bm1();
            }
            this.i = CookieJar.NO_COOKIES;
            this.l = SocketFactory.getDefault();
            this.o = pm1.INSTANCE;
            this.p = C8744d.DEFAULT;
            Authenticator authenticator = Authenticator.NONE;
            this.q = authenticator;
            this.r = authenticator;
            this.s = new C8748f();
            this.t = Dns.SYSTEM;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public C8734b a(Interceptor interceptor) {
            if (interceptor != null) {
                this.e.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public OkHttpClient b() {
            return new OkHttpClient(this);
        }

        public C8734b c(@Nullable C8737c c8737c) {
            this.j = c8737c;
            this.k = null;
            return this;
        }

        public C8734b d(long j, TimeUnit timeUnit) {
            this.y = C8753a.e("timeout", j, timeUnit);
            return this;
        }

        public C8734b e(List<C8749g> list) {
            this.d = C8753a.t(list);
            return this;
        }

        public C8734b f(Dns dns) {
            Objects.requireNonNull(dns, "dns == null");
            this.t = dns;
            return this;
        }

        public C8734b g(EventListener eventListener) {
            Objects.requireNonNull(eventListener, "eventListener == null");
            this.g = EventListener.l(eventListener);
            return this;
        }

        public C8734b h(boolean z) {
            this.v = z;
            return this;
        }

        public C8734b i(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.o = hostnameVerifier;
            return this;
        }

        public C8734b j(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (!arrayList.contains(Protocol.HTTP_1_0)) {
                if (!arrayList.contains(null)) {
                    arrayList.remove(Protocol.SPDY_3);
                    this.c = Collections.unmodifiableList(arrayList);
                    return this;
                }
                throw new IllegalArgumentException("protocols must not contain null");
            } else {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
        }

        public C8734b k(long j, TimeUnit timeUnit) {
            this.z = C8753a.e("timeout", j, timeUnit);
            return this;
        }

        public C8734b l(boolean z) {
            this.w = z;
            return this;
        }

        public C8734b m(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.m = sSLSocketFactory;
            this.n = AbstractC8805b.b(x509TrustManager);
            return this;
        }

        public C8734b n(long j, TimeUnit timeUnit) {
            this.A = C8753a.e("timeout", j, timeUnit);
            return this;
        }

        C8734b(OkHttpClient okHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            this.a = okHttpClient.dispatcher;
            this.b = okHttpClient.proxy;
            this.c = okHttpClient.protocols;
            this.d = okHttpClient.connectionSpecs;
            arrayList.addAll(okHttpClient.interceptors);
            arrayList2.addAll(okHttpClient.networkInterceptors);
            this.g = okHttpClient.eventListenerFactory;
            this.h = okHttpClient.proxySelector;
            this.i = okHttpClient.cookieJar;
            this.k = okHttpClient.internalCache;
            this.j = okHttpClient.cache;
            this.l = okHttpClient.socketFactory;
            this.m = okHttpClient.sslSocketFactory;
            this.n = okHttpClient.certificateChainCleaner;
            this.o = okHttpClient.hostnameVerifier;
            this.p = okHttpClient.certificatePinner;
            this.q = okHttpClient.proxyAuthenticator;
            this.r = okHttpClient.authenticator;
            this.s = okHttpClient.connectionPool;
            this.t = okHttpClient.dns;
            this.u = okHttpClient.followSslRedirects;
            this.v = okHttpClient.followRedirects;
            this.w = okHttpClient.retryOnConnectionFailure;
            this.x = okHttpClient.callTimeout;
            this.y = okHttpClient.connectTimeout;
            this.z = okHttpClient.readTimeout;
            this.A = okHttpClient.writeTimeout;
            this.B = okHttpClient.pingInterval;
        }
    }
}
