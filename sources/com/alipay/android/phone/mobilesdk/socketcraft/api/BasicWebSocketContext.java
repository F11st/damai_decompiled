package com.alipay.android.phone.mobilesdk.socketcraft.api;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BasicWebSocketContext implements WebSocketContext {
    private final WebSocketContext a;
    private Map b;

    public BasicWebSocketContext() {
        this(null);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext
    public void clear() {
        Map map = this.b;
        if (map != null) {
            map.clear();
        }
        WebSocketContext webSocketContext = this.a;
        if (webSocketContext != null) {
            webSocketContext.clear();
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext
    public Object getAttribute(String str) {
        WebSocketContext webSocketContext;
        if (str != null) {
            Map map = this.b;
            Object obj = map != null ? map.get(str) : null;
            return (obj != null || (webSocketContext = this.a) == null) ? obj : webSocketContext.getAttribute(str);
        }
        throw new IllegalArgumentException("Id may not be null");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext
    public Object removeAttribute(String str) {
        if (str != null) {
            Map map = this.b;
            if (map != null) {
                return map.remove(str);
            }
            return null;
        }
        throw new IllegalArgumentException("Id may not be null");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext
    public void setAttribute(String str, Object obj) {
        if (str != null) {
            if (this.b == null) {
                this.b = new HashMap();
            }
            this.b.put(str, obj);
            return;
        }
        throw new IllegalArgumentException("Id may not be null");
    }

    public BasicWebSocketContext(WebSocketContext webSocketContext) {
        this.b = null;
        this.a = webSocketContext;
    }
}
