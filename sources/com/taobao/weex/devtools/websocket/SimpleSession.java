package com.taobao.weex.devtools.websocket;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface SimpleSession {
    void close(int i, String str);

    boolean isOpen();

    void post(Runnable runnable);

    void sendBinary(byte[] bArr);

    void sendText(String str);
}
