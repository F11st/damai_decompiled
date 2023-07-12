package com.alibaba.gaiax.studio.third.socket.websocket;

import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface SocketWrapperListener {
    void onConnectFailed(Throwable th);

    void onConnected();

    void onDisconnect();

    void onMessage(Response response);

    void onSendDataError(Request request, int i, Throwable th);
}
