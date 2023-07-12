package com.taobao.weex.devtools.websocket;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface SimpleEndpoint {
    void onClose(SimpleSession simpleSession, int i, String str);

    void onError(SimpleSession simpleSession, Throwable th);

    void onMessage(SimpleSession simpleSession, String str);

    void onMessage(SimpleSession simpleSession, byte[] bArr, int i);

    void onOpen(SimpleSession simpleSession);
}
