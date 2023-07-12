package com.alibaba.gaiax.studio.third.socket.websocket;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.C3396a;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.MainThreadResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import tb.b22;
import tb.eb1;
import tb.gf0;
import tb.h13;
import tb.q22;

/* compiled from: Taobao */
/* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.b */
/* loaded from: classes6.dex */
public class C3392b {
    private h13 a;
    private WebSocketWrapper b;
    private ResponseDelivery c;
    private ReconnectManager d;
    private SocketWrapperListener e;
    private boolean f = false;
    private boolean g = false;
    private WebSocketEngine h;
    private C3396a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.b$a */
    /* loaded from: classes6.dex */
    public class C3393a implements ReconnectManager.OnConnectListener {
        C3393a() {
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager.OnConnectListener
        public void onConnected() {
            eb1.d("[WSManager]", "重连成功");
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager.OnConnectListener
        public void onDisconnect() {
            eb1.d("[WSManager]", "重连失败");
            C3392b.this.a.i().onDisconnect(C3392b.this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.b$b */
    /* loaded from: classes6.dex */
    public class C3394b implements SocketWrapperListener {
        C3394b() {
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onConnectFailed(Throwable th) {
            if (C3392b.this.d != null && C3392b.this.d.reconnecting()) {
                C3392b.this.d.onConnectError(th);
            }
            C3392b.this.a.i().onConnectFailed(th, C3392b.this.c);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onConnected() {
            if (C3392b.this.d != null) {
                C3392b.this.d.onConnected();
            }
            C3392b.this.a.i().onConnected(C3392b.this.c);
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onDisconnect() {
            C3392b.this.a.i().onDisconnect(C3392b.this.c);
            if (C3392b.this.d == null || !C3392b.this.d.reconnecting()) {
                if (C3392b.this.g) {
                    return;
                }
                if (C3392b.this.d == null) {
                    C3392b c3392b = C3392b.this;
                    c3392b.d = c3392b.k();
                }
                C3392b.this.d.onConnectError(null);
                C3392b.this.d.startReconnect();
            } else if (C3392b.this.g) {
                C3392b.this.a.i().onDisconnect(C3392b.this.c);
            } else {
                C3392b.this.d.onConnectError(null);
            }
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onMessage(Response response) {
            if (!C3392b.this.a.j()) {
                response.onResponse(C3392b.this.a.i(), C3392b.this.c);
            } else {
                C3392b.this.i.a(response, C3392b.this.a.i(), C3392b.this.c);
            }
        }

        @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketWrapperListener
        public void onSendDataError(Request request, int i, Throwable th) {
            gf0 b = q22.b();
            b.a(request, i, th);
            if (!C3392b.this.a.j()) {
                C3392b.this.a.i().onSendDataError(b, C3392b.this.c);
            } else {
                C3392b.this.i.b(b, C3392b.this.a.i(), C3392b.this.c);
            }
            if (C3392b.this.g || i != 0) {
                return;
            }
            eb1.b("[WSManager]", "数据发送失败，网络未连接，开始重连。。。");
            C3392b.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3392b(h13 h13Var, WebSocketEngine webSocketEngine, C3396a c3396a) {
        this.a = h13Var;
        this.h = webSocketEngine;
        this.i = c3396a;
        ResponseDelivery h = h13Var.h();
        this.c = h;
        if (h == null) {
            this.c = new MainThreadResponseDelivery();
        }
        SocketWrapperListener m = m();
        this.e = m;
        if (this.b == null) {
            this.b = new WebSocketWrapper(this.a, m);
        }
        Log.e("[WSManager]", "WebSocketManager: " + this.b.l());
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReconnectManager k() {
        return new DefaultReconnectManager(this, new C3393a());
    }

    private SocketWrapperListener m() {
        return new C3394b();
    }

    private void r(Request request) {
        if (this.f) {
            eb1.b("[WSManager]", "This WebSocketManager is destroyed!");
        } else {
            this.h.d(this.b, request, this.e);
        }
    }

    public C3392b h(SocketListener socketListener) {
        this.c.addListener(socketListener);
        return this;
    }

    public void i() {
        this.f = true;
        WebSocketWrapper webSocketWrapper = this.b;
        if (webSocketWrapper != null) {
            this.h.b(webSocketWrapper);
            this.h = null;
            this.b = null;
        }
        ResponseDelivery responseDelivery = this.c;
        if (responseDelivery != null) {
            if (!responseDelivery.isEmpty()) {
                this.c.clear();
            }
            this.c = null;
        }
        ReconnectManager reconnectManager = this.d;
        if (reconnectManager != null) {
            if (reconnectManager.reconnecting()) {
                this.d.stopReconnect();
            }
            this.d = null;
        }
        Log.e("[WSManager]", "destroy: 完成");
    }

    public C3392b j() {
        this.g = true;
        if (this.f) {
            eb1.b("[WSManager]", "This WebSocketManager is destroyed!");
            return this;
        }
        if (this.b.l() != 0) {
            this.h.c(this.b, this.e);
        }
        return this;
    }

    public h13 l() {
        return this.a;
    }

    public C3392b n() {
        this.g = false;
        if (this.d == null) {
            this.d = k();
        }
        if (!this.d.reconnecting()) {
            this.d.startReconnect();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.f) {
            eb1.b("[WSManager]", "This WebSocketManager is destroyed!");
        } else if (this.b.l() == 0) {
            this.h.a(this.b, this.e);
        } else {
            ReconnectManager reconnectManager = this.d;
            if (reconnectManager != null) {
                reconnectManager.onConnected();
            }
            eb1.b("[WSManager]", "WebSocket 已连接，请勿重试。");
        }
    }

    public C3392b p(SocketListener socketListener) {
        this.c.removeListener(socketListener);
        return this;
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Request<String> a = b22.a();
        a.setRequestData(str);
        r(a);
    }

    public C3392b s() {
        if (this.b == null) {
            this.b = new WebSocketWrapper(this.a, this.e);
        }
        if (this.b.l() == 0) {
            Log.e("[WSManager]", "start: reconnect!!!!!");
            n();
        }
        return this;
    }
}
