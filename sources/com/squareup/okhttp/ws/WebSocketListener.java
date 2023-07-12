package com.squareup.okhttp.ws;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ws.WebSocket;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface WebSocketListener {
    void onClose(int i, String str);

    void onFailure(IOException iOException);

    void onMessage(BufferedSource bufferedSource, WebSocket.PayloadType payloadType) throws IOException;

    void onOpen(WebSocket webSocket, Request request, Response response) throws IOException;

    void onPong(Buffer buffer);
}
