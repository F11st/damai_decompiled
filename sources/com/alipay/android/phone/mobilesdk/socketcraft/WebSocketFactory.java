package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import java.net.Socket;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface WebSocketFactory {
    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft, Socket socket);

    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list, Socket socket);
}
