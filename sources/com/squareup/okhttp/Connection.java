package com.squareup.okhttp;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import okio.Source;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Connection {
    private Handshake handshake;
    private HttpConnection httpConnection;
    private long idleStartTimeNs;
    private Object owner;
    private final ConnectionPool pool;
    private int recycleCount;
    private final Route route;
    private Socket socket;
    private SpdyConnection spdyConnection;
    private boolean connected = false;
    private Protocol protocol = Protocol.HTTP_1_1;

    public Connection(ConnectionPool connectionPool, Route route) {
        this.pool = connectionPool;
        this.route = route;
    }

    private void makeTunnel(Request request, int i, int i2) throws IOException {
        HttpConnection httpConnection = new HttpConnection(this.pool, this, this.socket);
        httpConnection.setTimeouts(i, i2);
        URL url = request.url();
        String str = "CONNECT " + url.getHost() + ":" + url.getPort() + " HTTP/1.1";
        do {
            httpConnection.writeRequest(request.headers(), str);
            httpConnection.flush();
            Response build = httpConnection.readResponse().request(request).build();
            long contentLength = OkHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = httpConnection.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code == 200) {
                if (httpConnection.bufferSize() > 0) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                return;
            } else if (code == 407) {
                Route route = this.route;
                request = OkHeaders.processAuthHeader(route.address.authenticator, build, route.proxy);
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
        } while (request != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private Request tunnelRequest(Request request) throws IOException {
        String str;
        if (this.route.requiresTunnel()) {
            String host = request.url().getHost();
            int effectivePort = Util.getEffectivePort(request.url());
            if (effectivePort == Util.getDefaultPort("https")) {
                str = host;
            } else {
                str = host + ":" + effectivePort;
            }
            Request.Builder header = new Request.Builder().url(new URL("https", host, effectivePort, "/")).header(BizTime.HOST, str).header("Proxy-Connection", IRequestConst.CONNECTION_VALUE);
            String header2 = request.header(IRequestConst.USER_AGENT);
            if (header2 != null) {
                header.header(IRequestConst.USER_AGENT, header2);
            }
            String header3 = request.header("Proxy-Authorization");
            if (header3 != null) {
                header.header("Proxy-Authorization", header3);
            }
            return header.build();
        }
        return null;
    }

    private void upgradeToTls(Request request, int i, int i2) throws IOException {
        String selectedProtocol;
        Platform platform = Platform.get();
        if (request != null) {
            makeTunnel(request, i, i2);
        }
        Address address = this.route.address;
        Socket createSocket = address.sslSocketFactory.createSocket(this.socket, address.uriHost, address.uriPort, true);
        this.socket = createSocket;
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        Route route = this.route;
        route.connectionSpec.apply(sSLSocket, route);
        try {
            sSLSocket.startHandshake();
            if (this.route.connectionSpec.supportsTlsExtensions() && (selectedProtocol = platform.getSelectedProtocol(sSLSocket)) != null) {
                this.protocol = Protocol.get(selectedProtocol);
            }
            platform.afterHandshake(sSLSocket);
            this.handshake = Handshake.get(sSLSocket.getSession());
            Address address2 = this.route.address;
            if (address2.hostnameVerifier.verify(address2.uriHost, sSLSocket.getSession())) {
                Address address3 = this.route.address;
                address3.certificatePinner.check(address3.uriHost, this.handshake.peerCertificates());
                Protocol protocol = this.protocol;
                if (protocol != Protocol.SPDY_3 && protocol != Protocol.HTTP_2) {
                    this.httpConnection = new HttpConnection(this.pool, this, this.socket);
                    return;
                }
                sSLSocket.setSoTimeout(0);
                SpdyConnection build = new SpdyConnection.Builder(this.route.address.getUriHost(), true, this.socket).protocol(this.protocol).build();
                this.spdyConnection = build;
                build.sendConnectionPreface();
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) sSLSocket.getSession().getPeerCertificates()[0];
            throw new SSLPeerUnverifiedException("Hostname " + this.route.address.uriHost + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
        } catch (Throwable th) {
            platform.afterHandshake(sSLSocket);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean clearOwner() {
        synchronized (this.pool) {
            if (this.owner == null) {
                return false;
            }
            this.owner = null;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeIfOwnedBy(Object obj) throws IOException {
        if (!isSpdy()) {
            synchronized (this.pool) {
                if (this.owner != obj) {
                    return;
                }
                this.owner = null;
                this.socket.close();
                return;
            }
        }
        throw new IllegalStateException();
    }

    void connect(int i, int i2, int i3, Request request) throws IOException {
        if (!this.connected) {
            if (this.route.proxy.type() != Proxy.Type.DIRECT && this.route.proxy.type() != Proxy.Type.HTTP) {
                this.socket = new Socket(this.route.proxy);
            } else {
                this.socket = this.route.address.socketFactory.createSocket();
            }
            this.socket.setSoTimeout(i2);
            Platform.get().connectSocket(this.socket, this.route.inetSocketAddress, i);
            if (this.route.address.sslSocketFactory != null) {
                upgradeToTls(request, i2, i3);
            } else {
                this.httpConnection = new HttpConnection(this.pool, this, this.socket);
            }
            this.connected = true;
            return;
        }
        throw new IllegalStateException("already connected");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void connectAndSetOwner(OkHttpClient okHttpClient, Object obj, Request request) throws IOException {
        setOwner(obj);
        if (!isConnected()) {
            connect(okHttpClient.getConnectTimeout(), okHttpClient.getReadTimeout(), okHttpClient.getWriteTimeout(), tunnelRequest(request));
            if (isSpdy()) {
                okHttpClient.getConnectionPool().share(this);
            }
            okHttpClient.routeDatabase().connected(getRoute());
        }
        setTimeouts(okHttpClient.getReadTimeout(), okHttpClient.getWriteTimeout());
    }

    public Handshake getHandshake() {
        return this.handshake;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getIdleStartTimeNs() {
        SpdyConnection spdyConnection = this.spdyConnection;
        return spdyConnection == null ? this.idleStartTimeNs : spdyConnection.getIdleStartTimeNs();
    }

    Object getOwner() {
        Object obj;
        synchronized (this.pool) {
            obj = this.owner;
        }
        return obj;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public Route getRoute() {
        return this.route;
    }

    public Socket getSocket() {
        return this.socket;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void incrementRecycleCount() {
        this.recycleCount++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAlive() {
        return (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) ? false : true;
    }

    boolean isConnected() {
        return this.connected;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isIdle() {
        SpdyConnection spdyConnection = this.spdyConnection;
        return spdyConnection == null || spdyConnection.isIdle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReadable() {
        HttpConnection httpConnection = this.httpConnection;
        if (httpConnection != null) {
            return httpConnection.isReadable();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSpdy() {
        return this.spdyConnection != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transport newTransport(HttpEngine httpEngine) throws IOException {
        return this.spdyConnection != null ? new SpdyTransport(httpEngine, this.spdyConnection) : new HttpTransport(httpEngine, this.httpConnection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int recycleCount() {
        return this.recycleCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetIdleStartTime() {
        if (this.spdyConnection == null) {
            this.idleStartTimeNs = System.nanoTime();
            return;
        }
        throw new IllegalStateException("spdyConnection != null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOwner(Object obj) {
        if (isSpdy()) {
            return;
        }
        synchronized (this.pool) {
            if (this.owner == null) {
                this.owner = obj;
            } else {
                throw new IllegalStateException("Connection already has an owner!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProtocol(Protocol protocol) {
        if (protocol != null) {
            this.protocol = protocol;
            return;
        }
        throw new IllegalArgumentException("protocol == null");
    }

    void setTimeouts(int i, int i2) throws IOException {
        if (this.connected) {
            if (this.httpConnection != null) {
                this.socket.setSoTimeout(i);
                this.httpConnection.setTimeouts(i, i2);
                return;
            }
            return;
        }
        throw new IllegalStateException("setTimeouts - not connected");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.route.address.uriHost);
        sb.append(":");
        sb.append(this.route.address.uriPort);
        sb.append(", proxy=");
        sb.append(this.route.proxy);
        sb.append(" hostAddress=");
        sb.append(this.route.inetSocketAddress.getAddress().getHostAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
