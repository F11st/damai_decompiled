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

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class CustomSSLWebSocketServerFactory extends DefaultSSLWebSocketServerFactory {
    private final String[] enabledCiphersuites;
    private final String[] enabledProtocols;

    public CustomSSLWebSocketServerFactory(SSLContext sSLContext, String[] strArr, String[] strArr2) {
        this(sSLContext, Executors.newSingleThreadScheduledExecutor(), strArr, strArr2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.server.DefaultSSLWebSocketServerFactory, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory
    public ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) throws IOException {
        SSLEngine createSSLEngine = this.sslcontext.createSSLEngine();
        String[] strArr = this.enabledProtocols;
        if (strArr != null) {
            createSSLEngine.setEnabledProtocols(strArr);
        }
        String[] strArr2 = this.enabledCiphersuites;
        if (strArr2 != null) {
            createSSLEngine.setEnabledCipherSuites(strArr2);
        }
        createSSLEngine.setUseClientMode(false);
        return new SSLSocketChannel2(socketChannel, createSSLEngine, this.exec, selectionKey);
    }

    public CustomSSLWebSocketServerFactory(SSLContext sSLContext, ExecutorService executorService, String[] strArr, String[] strArr2) {
        super(sSLContext, executorService);
        this.enabledProtocols = strArr;
        this.enabledCiphersuites = strArr2;
    }
}
