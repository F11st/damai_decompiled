package com.squareup.okhttp;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Network;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class OkHttpClient implements Cloneable {
    private static SSLSocketFactory defaultSslSocketFactory;
    private Authenticator authenticator;
    private Cache cache;
    private CertificatePinner certificatePinner;
    private int connectTimeout;
    private ConnectionPool connectionPool;
    private List<ConnectionSpec> connectionSpecs;
    private CookieHandler cookieHandler;
    private Dispatcher dispatcher;
    private boolean followRedirects;
    private boolean followSslRedirects;
    private HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private InternalCache internalCache;
    private Network network;
    private final List<Interceptor> networkInterceptors;
    private List<Protocol> protocols;
    private Proxy proxy;
    private ProxySelector proxySelector;
    private int readTimeout;
    private boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private int writeTimeout;
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT);

    static {
        Internal.instance = new Internal() { // from class: com.squareup.okhttp.OkHttpClient.1
            @Override // com.squareup.okhttp.internal.Internal
            public void addLenient(Headers.Builder builder, String str) {
                builder.addLenient(str);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public Connection callEngineGetConnection(Call call) {
                return call.engine.getConnection();
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void callEngineReleaseConnection(Call call) throws IOException {
                call.engine.releaseConnection();
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void callEnqueue(Call call, Callback callback, boolean z) {
                call.enqueue(callback, z);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public boolean clearOwner(Connection connection) {
                return connection.clearOwner();
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void closeIfOwnedBy(Connection connection, Object obj) throws IOException {
                connection.closeIfOwnedBy(obj);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void connectAndSetOwner(OkHttpClient okHttpClient, Connection connection, HttpEngine httpEngine, Request request) throws IOException {
                connection.connectAndSetOwner(okHttpClient, httpEngine, request);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void connectionSetOwner(Connection connection, Object obj) {
                connection.setOwner(obj);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public InternalCache internalCache(OkHttpClient okHttpClient) {
                return okHttpClient.internalCache();
            }

            @Override // com.squareup.okhttp.internal.Internal
            public boolean isReadable(Connection connection) {
                return connection.isReadable();
            }

            @Override // com.squareup.okhttp.internal.Internal
            public Network network(OkHttpClient okHttpClient) {
                return okHttpClient.network;
            }

            @Override // com.squareup.okhttp.internal.Internal
            public Transport newTransport(Connection connection, HttpEngine httpEngine) throws IOException {
                return connection.newTransport(httpEngine);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void recycle(ConnectionPool connectionPool, Connection connection) {
                connectionPool.recycle(connection);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public int recycleCount(Connection connection) {
                return connection.recycleCount();
            }

            @Override // com.squareup.okhttp.internal.Internal
            public RouteDatabase routeDatabase(OkHttpClient okHttpClient) {
                return okHttpClient.routeDatabase();
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void setCache(OkHttpClient okHttpClient, InternalCache internalCache) {
                okHttpClient.setInternalCache(internalCache);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void setNetwork(OkHttpClient okHttpClient, Network network) {
                okHttpClient.network = network;
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void setOwner(Connection connection, HttpEngine httpEngine) {
                connection.setOwner(httpEngine);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void setProtocol(Connection connection, Protocol protocol) {
                connection.setProtocol(protocol);
            }
        };
    }

    public OkHttpClient() {
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.retryOnConnectionFailure = true;
        this.routeDatabase = new RouteDatabase();
        this.dispatcher = new Dispatcher();
    }

    private synchronized SSLSocketFactory getDefaultSSLSocketFactory() {
        if (defaultSslSocketFactory == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                defaultSslSocketFactory = sSLContext.getSocketFactory();
            } catch (GeneralSecurityException unused) {
                throw new AssertionError();
            }
        }
        return defaultSslSocketFactory;
    }

    public OkHttpClient cancel(Object obj) {
        getDispatcher().cancel(obj);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final OkHttpClient copyWithDefaults() {
        OkHttpClient okHttpClient = new OkHttpClient(this);
        if (okHttpClient.proxySelector == null) {
            okHttpClient.proxySelector = ProxySelector.getDefault();
        }
        if (okHttpClient.cookieHandler == null) {
            okHttpClient.cookieHandler = CookieHandler.getDefault();
        }
        if (okHttpClient.socketFactory == null) {
            okHttpClient.socketFactory = SocketFactory.getDefault();
        }
        if (okHttpClient.sslSocketFactory == null) {
            okHttpClient.sslSocketFactory = getDefaultSSLSocketFactory();
        }
        if (okHttpClient.hostnameVerifier == null) {
            okHttpClient.hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        if (okHttpClient.certificatePinner == null) {
            okHttpClient.certificatePinner = CertificatePinner.DEFAULT;
        }
        if (okHttpClient.authenticator == null) {
            okHttpClient.authenticator = AuthenticatorAdapter.INSTANCE;
        }
        if (okHttpClient.connectionPool == null) {
            okHttpClient.connectionPool = ConnectionPool.getDefault();
        }
        if (okHttpClient.protocols == null) {
            okHttpClient.protocols = DEFAULT_PROTOCOLS;
        }
        if (okHttpClient.connectionSpecs == null) {
            okHttpClient.connectionSpecs = DEFAULT_CONNECTION_SPECS;
        }
        if (okHttpClient.network == null) {
            okHttpClient.network = Network.DEFAULT;
        }
        return okHttpClient;
    }

    public final Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public final Cache getCache() {
        return this.cache;
    }

    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final List<ConnectionSpec> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public final CookieHandler getCookieHandler() {
        return this.cookieHandler;
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Protocol> getProtocols() {
        return this.protocols;
    }

    public final Proxy getProxy() {
        return this.proxy;
    }

    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    final InternalCache internalCache() {
        return this.internalCache;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Call newCall(Request request) {
        return new Call(this, request);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RouteDatabase routeDatabase() {
        return this.routeDatabase;
    }

    public final OkHttpClient setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
        return this;
    }

    public final OkHttpClient setCache(Cache cache) {
        this.cache = cache;
        this.internalCache = null;
        return this;
    }

    public final OkHttpClient setCertificatePinner(CertificatePinner certificatePinner) {
        this.certificatePinner = certificatePinner;
        return this;
    }

    public final void setConnectTimeout(long j, TimeUnit timeUnit) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (millis == 0 && i > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.connectTimeout = (int) millis;
            return;
        }
        throw new IllegalArgumentException("unit == null");
    }

    public final OkHttpClient setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        return this;
    }

    public final OkHttpClient setConnectionSpecs(List<ConnectionSpec> list) {
        this.connectionSpecs = Util.immutableList(list);
        return this;
    }

    public final OkHttpClient setCookieHandler(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
        return this;
    }

    public final OkHttpClient setDispatcher(Dispatcher dispatcher) {
        if (dispatcher != null) {
            this.dispatcher = dispatcher;
            return this;
        }
        throw new IllegalArgumentException("dispatcher == null");
    }

    public final void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public final OkHttpClient setFollowSslRedirects(boolean z) {
        this.followSslRedirects = z;
        return this;
    }

    public final OkHttpClient setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    final void setInternalCache(InternalCache internalCache) {
        this.internalCache = internalCache;
        this.cache = null;
    }

    public final OkHttpClient setProtocols(List<Protocol> list) {
        List immutableList = Util.immutableList(list);
        if (immutableList.contains(Protocol.HTTP_1_1)) {
            if (!immutableList.contains(Protocol.HTTP_1_0)) {
                if (!immutableList.contains(null)) {
                    this.protocols = Util.immutableList(immutableList);
                    return this;
                }
                throw new IllegalArgumentException("protocols must not contain null");
            }
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + immutableList);
        }
        throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + immutableList);
    }

    public final OkHttpClient setProxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    public final OkHttpClient setProxySelector(ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
        return this;
    }

    public final void setReadTimeout(long j, TimeUnit timeUnit) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (millis == 0 && i > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.readTimeout = (int) millis;
            return;
        }
        throw new IllegalArgumentException("unit == null");
    }

    public final void setRetryOnConnectionFailure(boolean z) {
        this.retryOnConnectionFailure = z;
    }

    public final OkHttpClient setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
        return this;
    }

    public final OkHttpClient setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
        return this;
    }

    public final void setWriteTimeout(long j, TimeUnit timeUnit) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (millis == 0 && i > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.writeTimeout = (int) millis;
            return;
        }
        throw new IllegalArgumentException("unit == null");
    }

    /* renamed from: clone */
    public final OkHttpClient m575clone() {
        try {
            return (OkHttpClient) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    private OkHttpClient(OkHttpClient okHttpClient) {
        ArrayList arrayList = new ArrayList();
        this.interceptors = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.networkInterceptors = arrayList2;
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.retryOnConnectionFailure = true;
        this.routeDatabase = okHttpClient.routeDatabase;
        this.dispatcher = okHttpClient.dispatcher;
        this.proxy = okHttpClient.proxy;
        this.protocols = okHttpClient.protocols;
        this.connectionSpecs = okHttpClient.connectionSpecs;
        arrayList.addAll(okHttpClient.interceptors);
        arrayList2.addAll(okHttpClient.networkInterceptors);
        this.proxySelector = okHttpClient.proxySelector;
        this.cookieHandler = okHttpClient.cookieHandler;
        Cache cache = okHttpClient.cache;
        this.cache = cache;
        this.internalCache = cache != null ? cache.internalCache : okHttpClient.internalCache;
        this.socketFactory = okHttpClient.socketFactory;
        this.sslSocketFactory = okHttpClient.sslSocketFactory;
        this.hostnameVerifier = okHttpClient.hostnameVerifier;
        this.certificatePinner = okHttpClient.certificatePinner;
        this.authenticator = okHttpClient.authenticator;
        this.connectionPool = okHttpClient.connectionPool;
        this.network = okHttpClient.network;
        this.followSslRedirects = okHttpClient.followSslRedirects;
        this.followRedirects = okHttpClient.followRedirects;
        this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
        this.connectTimeout = okHttpClient.connectTimeout;
        this.readTimeout = okHttpClient.readTimeout;
        this.writeTimeout = okHttpClient.writeTimeout;
    }
}
