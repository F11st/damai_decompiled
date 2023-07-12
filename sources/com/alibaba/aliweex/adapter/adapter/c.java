package com.alibaba.aliweex.adapter.adapter;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.aws.WebSocketCenter;
import com.taobao.aws.api.IWebSocket;
import com.taobao.aws.listener.WebSocketListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.appfram.websocket.IWebSocketAdapter;
import com.taobao.weex.utils.WXLogUtils;
import java.net.URI;
import tb.c22;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class c implements IWebSocketAdapter {
    private IWebSocket a;
    private IWebSocketAdapter.EventListener b;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class a implements WebSocketListener {
        a(c cVar) {
        }
    }

    private boolean a() {
        IWebSocket iWebSocket = this.a;
        if (iWebSocket == null || iWebSocket.getConnState() != 2) {
            IWebSocketAdapter.EventListener eventListener = this.b;
            if (eventListener != null) {
                if (this.a != null) {
                    eventListener.onError("WebSocket session not active: " + this.a.getConnState());
                    return false;
                }
                eventListener.onError("WebSocket session not existed");
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void close(int i, String str) {
        IWebSocket iWebSocket = this.a;
        if (iWebSocket != null) {
            iWebSocket.close();
            this.a = null;
        }
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void connect(String str, @Nullable String str2, IWebSocketAdapter.EventListener eventListener) {
        if (eventListener == null) {
            WXLogUtils.e("WXWebSocketAdapter", "Listener is null!");
        } else if (WXEnvironment.getApplication() == null) {
            eventListener.onError("Application is null");
        } else if (TextUtils.isEmpty(str)) {
            eventListener.onError("Invalid URL:" + str);
        } else {
            this.b = eventListener;
            try {
                c22 c22Var = new c22(URI.create(str));
                if (!TextUtils.isEmpty(str2)) {
                    c22Var.addHeader(IWebSocketAdapter.HEADER_SEC_WEBSOCKET_PROTOCOL, str2);
                }
                this.a = WebSocketCenter.getInstance().newWebSocket(WXEnvironment.getApplication(), c22Var, new a(this));
            } catch (Throwable th) {
                eventListener.onError("Invalid URI:" + th.getMessage());
            }
        }
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void destroy() {
        close(-1, "Context destroyed");
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void send(String str) {
        if (a()) {
            this.a.send(str);
        }
    }
}
