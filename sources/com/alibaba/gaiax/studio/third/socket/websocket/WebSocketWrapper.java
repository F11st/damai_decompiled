package com.alibaba.gaiax.studio.third.socket.websocket;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket;
import com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft_6455;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.WebsocketNotConnectedException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshake;
import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import tb.eb1;
import tb.h13;
import tb.q22;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WebSocketWrapper {
    private h13 a;
    private SocketWrapperListener b;
    private WebSocketClient c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class MyWebSocketClient extends WebSocketClient {
        public MyWebSocketClient(URI uri) {
            super(uri);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onClose(int i, String str, boolean z) {
            WebSocketWrapper.this.m(i, str, z);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onError(Exception exc) {
            WebSocketWrapper.this.n(exc);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onMessage(String str) {
            WebSocketWrapper.this.o(str);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onOpen(ServerHandshake serverHandshake) {
            WebSocketWrapper.this.q(serverHandshake);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketAdapter, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
        public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
            super.onWebsocketPing(webSocket, framedata);
            WebSocketWrapper.this.r(framedata);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketAdapter, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
        public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
            super.onWebsocketPong(webSocket, framedata);
            WebSocketWrapper.this.s(framedata);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient
        public void onMessage(ByteBuffer byteBuffer) {
            WebSocketWrapper.this.p(byteBuffer);
        }

        public MyWebSocketClient(URI uri, Draft draft) {
            super(uri, draft);
        }

        public MyWebSocketClient(URI uri, Map<String, String> map) {
            super(uri, map);
        }

        public MyWebSocketClient(URI uri, Draft draft, Map<String, String> map) {
            super(uri, draft, map);
        }

        public MyWebSocketClient(URI uri, Draft draft, Map<String, String> map, int i) {
            super(uri, draft, map, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketWrapper(h13 h13Var, SocketWrapperListener socketWrapperListener) {
        this.a = h13Var;
        this.b = socketWrapperListener;
    }

    private void h() {
        if (this.f) {
            try {
                WebSocketClient webSocketClient = this.c;
                if (webSocketClient != null && !webSocketClient.isClosed()) {
                    this.c.close();
                }
                u();
                this.d = 0;
            } catch (Throwable th) {
                eb1.c("[WSWrapper]", "checkDestroy(WebSocketClient)", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str, boolean z) {
        this.d = 0;
        eb1.a("[WSWrapper]", String.format("WebSocket closed!code=%s,reason:%s,remote:%s", Integer.valueOf(i), str, Boolean.valueOf(z)));
        SocketWrapperListener socketWrapperListener = this.b;
        if (socketWrapperListener != null) {
            socketWrapperListener.onDisconnect();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Exception exc) {
        if (this.f) {
            h();
        } else {
            eb1.c("[WSWrapper]", "WebSocketClient#onError(Exception)", exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        if (this.b != null) {
            Response<String> e = q22.e();
            e.setResponseData(str);
            eb1.d("[WSWrapper]", "WebSocket received message:" + e.toString());
            this.b.onMessage(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(ByteBuffer byteBuffer) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        if (this.b != null) {
            Response<ByteBuffer> a = q22.a();
            a.setResponseData(byteBuffer);
            eb1.d("[WSWrapper]", "WebSocket received message:" + a.toString());
            this.b.onMessage(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(ServerHandshake serverHandshake) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        eb1.d("[WSWrapper]", "WebSocket connect success");
        if (this.e) {
            k();
            return;
        }
        SocketWrapperListener socketWrapperListener = this.b;
        if (socketWrapperListener != null) {
            socketWrapperListener.onConnected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Framedata framedata) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        if (this.b != null) {
            Response<Framedata> c = q22.c();
            c.setResponseData(framedata);
            eb1.d("[WSWrapper]", "WebSocket received ping:" + c.toString());
            this.b.onMessage(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Framedata framedata) {
        if (this.f) {
            h();
            return;
        }
        this.d = 2;
        if (this.b != null) {
            Response<Framedata> d = q22.d();
            d.setResponseData(framedata);
            eb1.d("[WSWrapper]", "WebSocket received pong:" + d.toString());
            this.b.onMessage(d);
        }
    }

    private void u() {
        if (this.b != null) {
            this.b = null;
        }
    }

    void i() {
        Log.e("[WSWrapper]", "connect: ");
        if (this.f) {
            return;
        }
        this.e = false;
        if (this.d == 0) {
            this.d = 1;
            try {
                if (this.c == null) {
                    if (!TextUtils.isEmpty(this.a.b())) {
                        Draft d = this.a.d();
                        if (d == null) {
                            d = new Draft_6455();
                        }
                        Draft draft = d;
                        int a = this.a.a();
                        this.c = new MyWebSocketClient(new URI(this.a.b()), draft, this.a.e(), a <= 0 ? 0 : a);
                        eb1.d("[WSWrapper]", "WebSocket start connect...");
                        if (this.a.f() != null) {
                            this.c.setProxy(this.a.f());
                        }
                        this.c.connect();
                        this.c.setConnectionLostTimeout(this.a.c());
                        if (this.e) {
                            k();
                        }
                        h();
                        return;
                    }
                    throw new RuntimeException("WebSocket connect url is empty!");
                }
                eb1.d("[WSWrapper]", "WebSocket reconnecting...");
                this.c.reconnect();
                if (this.e) {
                    k();
                }
                h();
            } catch (Throwable th) {
                this.d = 0;
                eb1.c("[WSWrapper]", "WebSocket connect failed:", th);
                SocketWrapperListener socketWrapperListener = this.b;
                if (socketWrapperListener != null) {
                    socketWrapperListener.onConnectFailed(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f = true;
        k();
        if (this.d == 0) {
            this.c = null;
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        this.e = true;
        if (this.d == 2) {
            eb1.d("[WSWrapper]", "WebSocket disconnecting...");
            WebSocketClient webSocketClient = this.c;
            if (webSocketClient != null) {
                webSocketClient.close();
            }
            eb1.d("[WSWrapper]", "WebSocket disconnected");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.e = false;
        if (this.d == 0) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(Request request) {
        WebSocketClient webSocketClient = this.c;
        if (webSocketClient == null) {
            return;
        }
        if (request == null) {
            eb1.b("[WSWrapper]", "send data is null!");
        } else if (this.d == 2) {
            try {
                try {
                    request.send(webSocketClient);
                    eb1.d("[WSWrapper]", "send success:" + request.toString());
                }
            } catch (WebsocketNotConnectedException e) {
                this.d = 0;
                eb1.c("[WSWrapper]", "ws is disconnected, send failed:" + request.toString(), e);
                SocketWrapperListener socketWrapperListener = this.b;
                if (socketWrapperListener != null) {
                    socketWrapperListener.onSendDataError(request, 0, e);
                    this.b.onDisconnect();
                }
            }
            request.release();
        } else {
            eb1.b("[WSWrapper]", "WebSocket not connect,send failed:" + request.toString());
            SocketWrapperListener socketWrapperListener2 = this.b;
            if (socketWrapperListener2 != null) {
                socketWrapperListener2.onSendDataError(request, 0, null);
            }
        }
    }
}
