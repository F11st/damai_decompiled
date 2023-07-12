package com.squareup.okhttp.ws;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.ws.RealWebSocket;
import com.squareup.okhttp.internal.ws.WebSocketProtocol;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.C8844h;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WebSocketCall {
    private final Call call;
    private final String key;
    private final Random random;
    private final Request request;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class ConnectionWebSocket extends RealWebSocket {
        private final Connection connection;

        private ConnectionWebSocket(Connection connection, BufferedSource bufferedSource, BufferedSink bufferedSink, Random random, Executor executor, WebSocketListener webSocketListener, String str) {
            super(true, bufferedSource, bufferedSink, random, executor, webSocketListener, str);
            this.connection = connection;
        }

        static RealWebSocket create(Response response, Connection connection, BufferedSource bufferedSource, BufferedSink bufferedSink, Random random, WebSocketListener webSocketListener) {
            String urlString = response.request().urlString();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), Util.threadFactory(String.format("OkHttp %s WebSocket", urlString), true));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return new ConnectionWebSocket(connection, bufferedSource, bufferedSink, random, threadPoolExecutor, webSocketListener, urlString);
        }

        @Override // com.squareup.okhttp.internal.ws.RealWebSocket
        protected void closeConnection() throws IOException {
            Internal.instance.closeIfOwnedBy(this.connection, this);
        }
    }

    protected WebSocketCall(OkHttpClient okHttpClient, Request request) {
        this(okHttpClient, request, new SecureRandom());
    }

    public static WebSocketCall create(OkHttpClient okHttpClient, Request request) {
        return new WebSocketCall(okHttpClient, request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createWebSocket(Response response, WebSocketListener webSocketListener) throws IOException {
        if (response.code() == 101) {
            String header = response.header(IRequestConst.CONNECTION);
            if ("Upgrade".equalsIgnoreCase(header)) {
                String header2 = response.header("Upgrade");
                if ("websocket".equalsIgnoreCase(header2)) {
                    String header3 = response.header("Sec-WebSocket-Accept");
                    String shaBase64 = Util.shaBase64(this.key + WebSocketProtocol.ACCEPT_MAGIC);
                    if (shaBase64.equals(header3)) {
                        Connection callEngineGetConnection = Internal.instance.callEngineGetConnection(this.call);
                        if (Internal.instance.clearOwner(callEngineGetConnection)) {
                            Socket socket = callEngineGetConnection.getSocket();
                            final RealWebSocket create = ConnectionWebSocket.create(response, callEngineGetConnection, C8844h.d(C8844h.m(socket)), C8844h.c(C8844h.i(socket)), this.random, webSocketListener);
                            new Thread(new NamedRunnable("OkHttp WebSocket reader %s", new Object[]{this.request.urlString()}) { // from class: com.squareup.okhttp.ws.WebSocketCall.2
                                @Override // com.squareup.okhttp.internal.NamedRunnable
                                protected void execute() {
                                    do {
                                    } while (create.readMessage());
                                }
                            }).start();
                            Internal.instance.connectionSetOwner(callEngineGetConnection, create);
                            webSocketListener.onOpen(create, this.request, response);
                            return;
                        }
                        throw new IllegalStateException("Unable to take ownership of connection.");
                    }
                    throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + shaBase64 + "' but was '" + header3 + "'");
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        Internal.instance.callEngineReleaseConnection(this.call);
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
    }

    public void cancel() {
        this.call.cancel();
    }

    public void enqueue(final WebSocketListener webSocketListener) {
        Internal.instance.callEnqueue(this.call, new Callback() { // from class: com.squareup.okhttp.ws.WebSocketCall.1
            @Override // com.squareup.okhttp.Callback
            public void onFailure(Request request, IOException iOException) {
                webSocketListener.onFailure(iOException);
            }

            @Override // com.squareup.okhttp.Callback
            public void onResponse(Response response) throws IOException {
                try {
                    WebSocketCall.this.createWebSocket(response, webSocketListener);
                } catch (IOException e) {
                    webSocketListener.onFailure(e);
                }
            }
        }, true);
    }

    WebSocketCall(OkHttpClient okHttpClient, Request request, Random random) {
        if ("GET".equals(request.method())) {
            String urlString = request.urlString();
            if (urlString.startsWith("ws://")) {
                urlString = "http://" + urlString.substring(5);
            } else if (urlString.startsWith("wss://")) {
                urlString = "https://" + urlString.substring(6);
            } else if (!urlString.startsWith("http://") && !urlString.startsWith("https://")) {
                throw new IllegalArgumentException("Request url must use 'ws', 'wss', 'http', or 'https' scheme: " + urlString);
            }
            this.random = random;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            String base64 = ByteString.of(bArr).base64();
            this.key = base64;
            OkHttpClient m575clone = okHttpClient.m575clone();
            m575clone.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
            Request build = request.newBuilder().url(urlString).header("Upgrade", "websocket").header(IRequestConst.CONNECTION, "Upgrade").header("Sec-WebSocket-Key", base64).header("Sec-WebSocket-Version", "13").build();
            this.request = build;
            this.call = m575clone.newCall(build);
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }
}
