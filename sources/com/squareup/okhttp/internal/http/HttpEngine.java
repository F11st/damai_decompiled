package com.squareup.okhttp.internal.http;

import anet.channel.request.a;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.network.util.Constants;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.f;
import okio.h;
import okio.o;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() { // from class: com.squareup.okhttp.internal.http.HttpEngine.1
        @Override // com.squareup.okhttp.ResponseBody
        public long contentLength() {
            return 0L;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public MediaType contentType() {
            return null;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource source() {
            return new Buffer();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    private Address address;
    public final boolean bufferRequestBody;
    private BufferedSink bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    private Connection connection;
    private final boolean forWebSocket;
    private Request networkRequest;
    private final Response priorResponse;
    private Sink requestBodyOut;
    private Route route;
    private RouteSelector routeSelector;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    private boolean transparentGzip;
    private Transport transport;
    private final Request userRequest;
    private Response userResponse;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class NetworkInterceptorChain implements Interceptor.Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int i, Request request) {
            this.index = i;
            this.request = request;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return HttpEngine.this.connection;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) throws IOException {
            this.calls++;
            if (this.index > 0) {
                Interceptor interceptor = HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().getRoute().getAddress();
                if (request.url().getHost().equals(address.getUriHost()) && Util.getEffectivePort(request.url()) == address.getUriPort()) {
                    if (this.calls > 1) {
                        throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                    }
                } else {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                }
            }
            if (this.index >= HttpEngine.this.client.networkInterceptors().size()) {
                HttpEngine.this.transport.writeRequestHeaders(request);
                if (HttpEngine.this.permitsRequestBody() && request.body() != null) {
                    BufferedSink c = h.c(HttpEngine.this.transport.createRequestBody(request, request.body().contentLength()));
                    request.body().writeTo(c);
                    c.close();
                }
                return HttpEngine.this.readNetworkResponse();
            }
            NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, request);
            Interceptor interceptor2 = HttpEngine.this.client.networkInterceptors().get(this.index);
            Response intercept = interceptor2.intercept(networkInterceptorChain);
            if (networkInterceptorChain.calls == 1) {
                return intercept;
            }
            throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }
    }

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, Connection connection, RouteSelector routeSelector, RetryableSink retryableSink, Response response) {
        this.client = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = z;
        this.callerWritesRequestBody = z2;
        this.forWebSocket = z3;
        this.connection = connection;
        this.routeSelector = routeSelector;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
        if (connection != null) {
            Internal.instance.setOwner(connection, this);
            this.route = connection.getRoute();
            return;
        }
        this.route = null;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink c = h.c(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), h.d(new Source() { // from class: com.squareup.okhttp.internal.http.HttpEngine.2
            boolean cacheRequestClosed;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                try {
                    long read = source.read(buffer, j);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            c.close();
                        }
                        return -1L;
                    }
                    buffer.copyTo(c.buffer(), buffer.size() - read, read);
                    c.emitCompleteSegments();
                    return read;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            @Override // okio.Source
            public o timeout() {
                return source.timeout();
            }
        }))).build();
    }

    private static Headers combine(Headers headers, Headers headers2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (!OkHeaders.isEndToEnd(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!Constants.Protocol.CONTENT_LENGTH.equalsIgnoreCase(name2) && OkHeaders.isEndToEnd(name2)) {
                builder.add(name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    private void connect() throws IOException {
        if (this.connection == null) {
            if (this.routeSelector == null) {
                Address createAddress = createAddress(this.client, this.networkRequest);
                this.address = createAddress;
                this.routeSelector = RouteSelector.get(createAddress, this.networkRequest, this.client);
            }
            Connection nextConnection = nextConnection();
            this.connection = nextConnection;
            this.route = nextConnection.getRoute();
            return;
        }
        throw new IllegalStateException();
    }

    private void connectFailed(RouteSelector routeSelector, IOException iOException) {
        if (Internal.instance.recycleCount(this.connection) > 0) {
            return;
        }
        routeSelector.connectFailed(this.connection.getRoute(), iOException);
    }

    private static Address createAddress(OkHttpClient okHttpClient, Request request) throws UnknownHostException {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        String host = request.url().getHost();
        if (host != null && host.length() != 0) {
            if (request.isHttps()) {
                sSLSocketFactory = okHttpClient.getSslSocketFactory();
                hostnameVerifier = okHttpClient.getHostnameVerifier();
                certificatePinner = okHttpClient.getCertificatePinner();
            } else {
                sSLSocketFactory = null;
                hostnameVerifier = null;
                certificatePinner = null;
            }
            return new Address(host, Util.getEffectivePort(request.url()), okHttpClient.getSocketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector());
        }
        throw new UnknownHostException(request.url().toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.squareup.okhttp.Connection createNextConnection() throws java.io.IOException {
        /*
            r4 = this;
            com.squareup.okhttp.OkHttpClient r0 = r4.client
            com.squareup.okhttp.ConnectionPool r0 = r0.getConnectionPool()
        L6:
            com.squareup.okhttp.Address r1 = r4.address
            com.squareup.okhttp.Connection r1 = r0.get(r1)
            if (r1 == 0) goto L2e
            com.squareup.okhttp.Request r2 = r4.networkRequest
            java.lang.String r2 = r2.method()
            java.lang.String r3 = "GET"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L2d
            com.squareup.okhttp.internal.Internal r2 = com.squareup.okhttp.internal.Internal.instance
            boolean r2 = r2.isReadable(r1)
            if (r2 == 0) goto L25
            goto L2d
        L25:
            java.net.Socket r1 = r1.getSocket()
            r1.close()
            goto L6
        L2d:
            return r1
        L2e:
            com.squareup.okhttp.internal.http.RouteSelector r1 = r4.routeSelector
            com.squareup.okhttp.Route r1 = r1.next()
            com.squareup.okhttp.Connection r2 = new com.squareup.okhttp.Connection
            r2.<init>(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.HttpEngine.createNextConnection():com.squareup.okhttp.Connection");
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(a.c.HEAD)) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && OkHeaders.contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static String hostHeader(URL url) {
        if (Util.getEffectivePort(url) != Util.getDefaultPort(url.getProtocol())) {
            return url.getHost() + ":" + url.getPort();
        }
        return url.getHost();
    }

    private boolean isRecoverable(IOException iOException) {
        return (!this.client.getRetryOnConnectionFailure() || (iOException instanceof SSLPeerUnverifiedException) || ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : true;
    }

    private void maybeCache() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.client);
        if (internalCache == null) {
            return;
        }
        if (!CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
            if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    internalCache.remove(this.networkRequest);
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            return;
        }
        this.storeRequest = internalCache.put(stripBody(this.userResponse));
    }

    private Request networkRequest(Request request) throws IOException {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header(BizTime.HOST) == null) {
            newBuilder.header(BizTime.HOST, hostHeader(request.url()));
        }
        Connection connection = this.connection;
        if ((connection == null || connection.getProtocol() != Protocol.HTTP_1_0) && request.header(IRequestConst.CONNECTION) == null) {
            newBuilder.header(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.addCookies(newBuilder, cookieHandler.get(request.uri(), OkHeaders.toMultimap(newBuilder.build().headers(), null)));
        }
        if (request.header(IRequestConst.USER_AGENT) == null) {
            newBuilder.header(IRequestConst.USER_AGENT, Version.userAgent());
        }
        return newBuilder.build();
    }

    private Connection nextConnection() throws IOException {
        Connection createNextConnection = createNextConnection();
        Internal.instance.connectAndSetOwner(this.client, createNextConnection, this, this.networkRequest);
        return createNextConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response readNetworkResponse() throws IOException {
        this.transport.finishRequest();
        Response build = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            build = build.newBuilder().body(this.transport.openResponseBody(build)).build();
        }
        Internal.instance.setProtocol(this.connection, build.protocol());
        return build;
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private Response unzip(Response response) throws IOException {
        if (this.transparentGzip && "gzip".equalsIgnoreCase(this.userResponse.header(Constants.Protocol.CONTENT_ENCODING)) && response.body() != null) {
            f fVar = new f(response.body().source());
            Headers build = response.headers().newBuilder().removeAll(Constants.Protocol.CONTENT_ENCODING).removeAll(Constants.Protocol.CONTENT_LENGTH).build();
            return response.newBuilder().headers(build).body(new RealResponseBody(build, h.d(fVar))).build();
        }
        return response;
    }

    private static boolean validate(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate("Last-Modified");
        return (date2 == null || (date = response2.headers().getDate("Last-Modified")) == null || date.getTime() >= date2.getTime()) ? false : true;
    }

    public Connection close() {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null) {
            Util.closeQuietly(bufferedSink);
        } else {
            Sink sink = this.requestBodyOut;
            if (sink != null) {
                Util.closeQuietly(sink);
            }
        }
        Response response = this.userResponse;
        if (response == null) {
            Connection connection = this.connection;
            if (connection != null) {
                Util.closeQuietly(connection.getSocket());
            }
            this.connection = null;
            return null;
        }
        Util.closeQuietly(response.body());
        Transport transport = this.transport;
        if (transport != null && this.connection != null && !transport.canReuseConnection()) {
            Util.closeQuietly(this.connection.getSocket());
            this.connection = null;
            return null;
        }
        Connection connection2 = this.connection;
        if (connection2 != null && !Internal.instance.clearOwner(connection2)) {
            this.connection = null;
        }
        Connection connection3 = this.connection;
        this.connection = null;
        return connection3;
    }

    public void disconnect() {
        Transport transport = this.transport;
        if (transport != null) {
            try {
                transport.disconnect(this);
            } catch (IOException unused) {
            }
        }
    }

    public Request followUpRequest() throws IOException {
        Proxy proxy;
        String header;
        if (this.userResponse != null) {
            if (getRoute() != null) {
                proxy = getRoute().getProxy();
            } else {
                proxy = this.client.getProxy();
            }
            int code = this.userResponse.code();
            if (code != 307 && code != 308) {
                if (code != 401) {
                    if (code != 407) {
                        switch (code) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (proxy.type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                }
                return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, proxy);
            } else if (!this.userRequest.method().equals("GET") && !this.userRequest.method().equals(a.c.HEAD)) {
                return null;
            }
            if (this.client.getFollowRedirects() && (header = this.userResponse.header("Location")) != null) {
                URL url = new URL(this.userRequest.url(), header);
                if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                    if (url.getProtocol().equals(this.userRequest.url().getProtocol()) || this.client.getFollowSslRedirects()) {
                        Request.Builder newBuilder = this.userRequest.newBuilder();
                        if (HttpMethod.permitsRequestBody(this.userRequest.method())) {
                            newBuilder.method("GET", null);
                            newBuilder.removeHeader("Transfer-Encoding");
                            newBuilder.removeHeader(Constants.Protocol.CONTENT_LENGTH);
                            newBuilder.removeHeader("Content-Type");
                        }
                        if (!sameConnection(url)) {
                            newBuilder.removeHeader("Authorization");
                        }
                        return newBuilder.url(url).build();
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public BufferedSink getBufferedRequestBody() {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null) {
            return bufferedSink;
        }
        Sink requestBody = getRequestBody();
        if (requestBody != null) {
            BufferedSink c = h.c(requestBody);
            this.bufferedRequestBody = c;
            return c;
        }
        return null;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Sink getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public Response getResponse() {
        Response response = this.userResponse;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    public Route getRoute() {
        return this.route;
    }

    public boolean hasResponse() {
        return this.userResponse != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean permitsRequestBody() {
        return HttpMethod.permitsRequestBody(this.userRequest.method());
    }

    public void readResponse() throws IOException {
        Response readNetworkResponse;
        if (this.userResponse != null) {
            return;
        }
        Request request = this.networkRequest;
        if (request == null && this.cacheResponse == null) {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (request == null) {
            return;
        }
        if (this.forWebSocket) {
            this.transport.writeRequestHeaders(request);
            readNetworkResponse = readNetworkResponse();
        } else if (!this.callerWritesRequestBody) {
            readNetworkResponse = new NetworkInterceptorChain(0, request).proceed(this.networkRequest);
        } else {
            BufferedSink bufferedSink = this.bufferedRequestBody;
            if (bufferedSink != null && bufferedSink.buffer().size() > 0) {
                this.bufferedRequestBody.emit();
            }
            if (this.sentRequestMillis == -1) {
                if (OkHeaders.contentLength(this.networkRequest) == -1) {
                    Sink sink = this.requestBodyOut;
                    if (sink instanceof RetryableSink) {
                        this.networkRequest = this.networkRequest.newBuilder().header(Constants.Protocol.CONTENT_LENGTH, Long.toString(((RetryableSink) sink).contentLength())).build();
                    }
                }
                this.transport.writeRequestHeaders(this.networkRequest);
            }
            Sink sink2 = this.requestBodyOut;
            if (sink2 != null) {
                BufferedSink bufferedSink2 = this.bufferedRequestBody;
                if (bufferedSink2 != null) {
                    bufferedSink2.close();
                } else {
                    sink2.close();
                }
                Sink sink3 = this.requestBodyOut;
                if (sink3 instanceof RetryableSink) {
                    this.transport.writeRequestBody((RetryableSink) sink3);
                }
            }
            readNetworkResponse = readNetworkResponse();
        }
        receiveHeaders(readNetworkResponse.headers());
        Response response = this.cacheResponse;
        if (response != null) {
            if (validate(response, readNetworkResponse)) {
                this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), readNetworkResponse.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(readNetworkResponse)).build();
                readNetworkResponse.body().close();
                releaseConnection();
                InternalCache internalCache = Internal.instance.internalCache(this.client);
                internalCache.trackConditionalCacheHit();
                internalCache.update(this.cacheResponse, stripBody(this.userResponse));
                this.userResponse = unzip(this.userResponse);
                return;
            }
            Util.closeQuietly(this.cacheResponse.body());
        }
        Response build = readNetworkResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(readNetworkResponse)).build();
        this.userResponse = build;
        if (hasBody(build)) {
            maybeCache();
            this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
        }
    }

    public void receiveHeaders(Headers headers) throws IOException {
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(headers, null));
        }
    }

    public HttpEngine recover(IOException iOException, Sink sink) {
        RouteSelector routeSelector = this.routeSelector;
        if (routeSelector != null && this.connection != null) {
            connectFailed(routeSelector, iOException);
        }
        boolean z = sink == null || (sink instanceof RetryableSink);
        RouteSelector routeSelector2 = this.routeSelector;
        if (routeSelector2 == null && this.connection == null) {
            return null;
        }
        if ((routeSelector2 == null || routeSelector2.hasNext()) && isRecoverable(iOException) && z) {
            return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), this.routeSelector, (RetryableSink) sink, this.priorResponse);
        }
        return null;
    }

    public void releaseConnection() throws IOException {
        Transport transport = this.transport;
        if (transport != null && this.connection != null) {
            transport.releaseConnectionOnIdle();
        }
        this.connection = null;
    }

    public boolean sameConnection(URL url) {
        URL url2 = this.userRequest.url();
        return url2.getHost().equals(url.getHost()) && Util.getEffectivePort(url2) == Util.getEffectivePort(url) && url2.getProtocol().equals(url.getProtocol());
    }

    public void sendRequest() throws IOException {
        if (this.cacheStrategy != null) {
            return;
        }
        if (this.transport == null) {
            Request networkRequest = networkRequest(this.userRequest);
            InternalCache internalCache = Internal.instance.internalCache(this.client);
            Response response = internalCache != null ? internalCache.get(networkRequest) : null;
            CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), networkRequest, response).get();
            this.cacheStrategy = cacheStrategy;
            this.networkRequest = cacheStrategy.networkRequest;
            this.cacheResponse = cacheStrategy.cacheResponse;
            if (internalCache != null) {
                internalCache.trackResponse(cacheStrategy);
            }
            if (response != null && this.cacheResponse == null) {
                Util.closeQuietly(response.body());
            }
            if (this.networkRequest != null) {
                if (this.connection == null) {
                    connect();
                }
                this.transport = Internal.instance.newTransport(this.connection, this);
                if (this.callerWritesRequestBody && permitsRequestBody() && this.requestBodyOut == null) {
                    long contentLength = OkHeaders.contentLength(networkRequest);
                    if (!this.bufferRequestBody) {
                        this.transport.writeRequestHeaders(this.networkRequest);
                        this.requestBodyOut = this.transport.createRequestBody(this.networkRequest, contentLength);
                        return;
                    } else if (contentLength > 2147483647L) {
                        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                    } else {
                        if (contentLength != -1) {
                            this.transport.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = new RetryableSink((int) contentLength);
                            return;
                        }
                        this.requestBodyOut = new RetryableSink();
                        return;
                    }
                }
                return;
            }
            if (this.connection != null) {
                Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
                this.connection = null;
            }
            Response response2 = this.cacheResponse;
            if (response2 != null) {
                this.userResponse = response2.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
            } else {
                this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
            }
            this.userResponse = unzip(this.userResponse);
            return;
        }
        throw new IllegalStateException();
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis == -1) {
            this.sentRequestMillis = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException();
    }

    public HttpEngine recover(IOException iOException) {
        return recover(iOException, this.requestBodyOut);
    }
}
