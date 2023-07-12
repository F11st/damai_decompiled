package com.taobao.weex.appfram.websocket;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWebSocketAdapter {
    public static final String HEADER_SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface EventListener {
        void onClose(int i, String str, boolean z);

        void onError(String str);

        void onMessage(String str);

        void onOpen();
    }

    void close(int i, String str);

    void connect(String str, @Nullable String str2, EventListener eventListener);

    void destroy();

    void send(String str);
}
