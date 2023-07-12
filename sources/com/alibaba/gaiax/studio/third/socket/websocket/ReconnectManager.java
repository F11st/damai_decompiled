package com.alibaba.gaiax.studio.third.socket.websocket;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface ReconnectManager {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface OnConnectListener {
        void onConnected();

        void onDisconnect();
    }

    void destroy();

    void onConnectError(Throwable th);

    void onConnected();

    boolean reconnecting();

    void startReconnect();

    void stopReconnect();
}
