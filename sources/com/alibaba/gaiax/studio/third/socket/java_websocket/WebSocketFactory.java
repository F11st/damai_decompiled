package com.alibaba.gaiax.studio.third.socket.java_websocket;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import java.util.List;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public interface WebSocketFactory {
    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft);

    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list);
}
