package com.alibaba.gaiax.studio.third.socket.websocket;

import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;
import tb.gf0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface SocketListener {
    void onConnectFailed(Throwable th);

    void onConnected();

    void onDisconnect();

    <T> void onMessage(String str, T t);

    <T> void onMessage(ByteBuffer byteBuffer, T t);

    void onPing(Framedata framedata);

    void onPong(Framedata framedata);

    void onSendDataError(gf0 gf0Var);
}
