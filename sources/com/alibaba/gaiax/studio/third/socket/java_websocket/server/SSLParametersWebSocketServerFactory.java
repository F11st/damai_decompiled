package com.alibaba.gaiax.studio.third.socket.java_websocket.server;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.SSLSocketChannel2;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class SSLParametersWebSocketServerFactory extends DefaultSSLWebSocketServerFactory {
    private final SSLParameters sslParameters;

    public SSLParametersWebSocketServerFactory(SSLContext sSLContext, SSLParameters sSLParameters) {
        this(sSLContext, Executors.newSingleThreadScheduledExecutor(), sSLParameters);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.server.DefaultSSLWebSocketServerFactory, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory
    public ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) throws IOException {
        SSLEngine createSSLEngine = this.sslcontext.createSSLEngine();
        createSSLEngine.setUseClientMode(false);
        createSSLEngine.setSSLParameters(this.sslParameters);
        return new SSLSocketChannel2(socketChannel, createSSLEngine, this.exec, selectionKey);
    }

    public SSLParametersWebSocketServerFactory(SSLContext sSLContext, ExecutorService executorService, SSLParameters sSLParameters) {
        super(sSLContext, executorService);
        if (sSLParameters != null) {
            this.sslParameters = sSLParameters;
            return;
        }
        throw new IllegalArgumentException();
    }
}
