package com.alipay.android.phone.mobilesdk.socketcraft.client;

import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocketAdapter;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocketImpl;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_17;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeImpl1Client;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.ssl.SSLExtensionsFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class WebSocketClient extends WebSocketAdapter implements WebSocket, Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "WebSocketClient";
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private int connectTimeout;
    private Draft draft;
    private WebSocketImpl engine;
    private Map<String, String> headers;
    private InputStream istream;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    private SSLSocketFactory sslSocketFactory;
    protected URI uri;
    private Thread writeThread;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private class WebsocketWriteThread implements Runnable {
        private WebsocketWriteThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = WebSocketClient.this.engine.outQueue.take();
                    WebSocketClient.this.ostream.write(take.array(), 0, take.limit());
                    WebSocketClient.this.ostream.flush();
                } catch (IOException unused) {
                    WebSocketClient.this.engine.eot();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public WebSocketClient(URI uri) {
        this(uri, new Draft_17());
    }

    private void connectNetwork() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            InetAddress[] allByName = InetAddress.getAllByName(this.uri.getHost());
            if (allByName != null && allByName.length > 0) {
                InetAddress inetAddress = allByName[0];
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String hostAddress = inetAddress != null ? inetAddress.getHostAddress() : " null ";
                onDns(hostAddress, currentTimeMillis2);
                SCLogCatUtil.info(TAG, "DNS timing: " + currentTimeMillis2 + ", ip: " + hostAddress);
                long currentTimeMillis3 = System.currentTimeMillis();
                try {
                    this.socket.connect(new InetSocketAddress(inetAddress, getPort()), this.connectTimeout);
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    String hostAddress2 = inetAddress.getHostAddress();
                    onTcpConnect(hostAddress2, currentTimeMillis4);
                    SCLogCatUtil.info(TAG, "Connection timing: " + currentTimeMillis4 + ", ip: " + hostAddress2);
                    SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
                    if (sSLSocketFactory == null) {
                        return;
                    }
                    SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(this.socket, this.uri.getHost(), getPort(), true);
                    SSLExtensionsFactory.getInstance().enableTlsExtensions(sSLSocket, this.uri.getHost());
                    long currentTimeMillis5 = System.currentTimeMillis();
                    try {
                        sSLSocket.startHandshake();
                        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                        onSSLHandshake(currentTimeMillis6);
                        SCLogCatUtil.info(TAG, "SSL timing: " + currentTimeMillis6 + ", ip: " + inetAddress.getHostAddress());
                        this.socket = sSLSocket;
                        return;
                    } catch (Throwable th) {
                        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis5;
                        onSSLHandshake(currentTimeMillis7);
                        SCLogCatUtil.info(TAG, "SSL timing: " + currentTimeMillis7 + ", ip: " + inetAddress.getHostAddress());
                        throw th;
                    }
                } catch (Throwable th2) {
                    long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis3;
                    String hostAddress3 = inetAddress.getHostAddress();
                    onTcpConnect(hostAddress3, currentTimeMillis8);
                    SCLogCatUtil.info(TAG, "Connection timing: " + currentTimeMillis8 + ", ip: " + hostAddress3);
                    throw th2;
                }
            }
            throw new UnknownHostException("Unknown host : " + this.uri.getHost());
        } catch (Throwable th3) {
            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
            onDns(" null ", currentTimeMillis9);
            SCLogCatUtil.info(TAG, "DNS timing: " + currentTimeMillis9 + ", ip:  null ");
            throw th3;
        }
    }

    private int getPort() {
        int port = this.uri.getPort();
        if (port == -1) {
            String scheme = this.uri.getScheme();
            if (scheme.equals("wss")) {
                return 443;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            throw new RuntimeException("unkonow scheme" + scheme);
        }
        return port;
    }

    private void sendHandshake() {
        String path = this.uri.getPath();
        String query = this.uri.getQuery();
        path = (path == null || path.length() == 0) ? "/" : "/";
        if (query != null) {
            path = path + "?" + query;
        }
        int port = getPort();
        StringBuilder sb = new StringBuilder();
        sb.append(this.uri.getHost());
        sb.append(port != 80 ? ":" + port : "");
        String sb2 = sb.toString();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(path);
        handshakeImpl1Client.put(BizTime.HOST, sb2);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.engine.startHandshake(handshakeImpl1Client);
    }

    public void close() {
        if (this.writeThread != null) {
            this.engine.close(1000);
        }
    }

    public void closeBlocking() {
        close();
        this.closeLatch.await();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void closeConnection(int i, String str) {
        this.engine.closeConnection(i, str);
    }

    public void connect() {
        if (this.writeThread == null) {
            Thread thread = new Thread(this);
            this.writeThread = thread;
            thread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean connectBlocking() {
        connect();
        this.connectLatch.await();
        return this.engine.isOpen();
    }

    public WebSocket getConnection() {
        return this.engine;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public WebSocket.READYSTATE getReadyState() {
        return this.engine.getReadyState();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    public URI getURI() {
        return this.uri;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean hasBufferedData() {
        return this.engine.hasBufferedData();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isClosed() {
        return this.engine.isClosed();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isClosing() {
        return this.engine.isClosing();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isConnecting() {
        return this.engine.isConnecting();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isFlushAndClose() {
        return this.engine.isFlushAndClose();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isOpen() {
        return this.engine.isOpen();
    }

    public abstract void onClose(int i, String str, boolean z);

    public void onCloseInitiated(int i, String str) {
    }

    public void onClosing(int i, String str, boolean z) {
    }

    public void onDns(String str, long j) {
    }

    public abstract void onError(Exception exc);

    public void onFragment(Framedata framedata) {
    }

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(ServerHandshake serverHandshake);

    public void onSSLHandshake(long j) {
    }

    public void onTcpConnect(String str, long j) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z) {
        this.connectLatch.countDown();
        this.closeLatch.countDown();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            onWebsocketError(this, e);
        }
        onClose(i, str, z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        onCloseInitiated(i, str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z) {
        onClosing(i, str, z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketAdapter, com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
        onFragment(framedata);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        this.connectLatch.countDown();
        onOpen((ServerHandshake) handshakedata);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
    }

    public void onWsHandshake(long j) {
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            Socket socket = this.socket;
            if (socket == null) {
                this.socket = new Socket(this.proxy);
            } else if (socket.isClosed()) {
                throw new SocketException("Socket is closed");
            }
            if (!this.socket.isBound()) {
                connectNetwork();
            }
            this.istream = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            long currentTimeMillis = System.currentTimeMillis();
            sendHandshake();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            onWsHandshake(currentTimeMillis2);
            SCLogCatUtil.info(TAG, "WebSocketHandshark timing: " + currentTimeMillis2);
            Thread thread = new Thread(new WebsocketWriteThread());
            this.writeThread = thread;
            thread.start();
            byte[] bArr = new byte[WebSocketImpl.RCVBUF];
            while (!isClosed() && !isClosing() && (read = this.istream.read(bArr)) != -1) {
                try {
                    this.engine.decode(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.engine.eot();
                    return;
                } catch (RuntimeException e) {
                    onError(e);
                    this.engine.closeConnection(1006, e.getMessage());
                    return;
                }
            }
            this.engine.eot();
        } catch (Exception e2) {
            onWebsocketError(this.engine, e2);
            this.engine.closeConnection(-1, e2.getMessage());
        }
    }

    public void send(String str) {
        this.engine.send(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.engine.sendFragmentedFrame(opcode, byteBuffer, z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void sendFrame(Framedata framedata) {
        this.engine.sendFrame(framedata);
    }

    public void setProxy(Proxy proxy) {
        if (proxy != null) {
            this.proxy = proxy;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setSocket(Socket socket) {
        if (this.socket == null) {
            this.socket = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public WebSocketClient(URI uri, Draft draft) {
        this(uri, draft, null, 0);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    public void send(byte[] bArr) {
        this.engine.send(bArr);
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map, int i) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft != null) {
            this.uri = uri;
            this.draft = draft;
            this.headers = map;
            this.connectTimeout = i;
            this.engine = new WebSocketImpl(this, draft);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close(int i) {
        this.engine.close();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.getLocalSocketAddress();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.getRemoteSocketAddress();
    }

    public void send(ByteBuffer byteBuffer) {
        this.engine.send(byteBuffer);
    }

    public void close(int i, String str) {
        this.engine.close(i, str);
    }
}
