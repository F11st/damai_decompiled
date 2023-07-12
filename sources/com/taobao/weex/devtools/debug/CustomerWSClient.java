package com.taobao.weex.devtools.debug;

import android.os.HandlerThread;
import com.taobao.weex.devtools.WeexInspector;
import com.taobao.weex.devtools.debug.IWebSocketClient;
import com.taobao.weex.devtools.debug.SocketClient;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CustomerWSClient extends SocketClient {
    private IWebSocketClient webSocketClient;

    public CustomerWSClient(DebugServerProxy debugServerProxy) {
        super(debugServerProxy);
        this.webSocketClient = WeexInspector.getCustomerWSClient();
    }

    @Override // com.taobao.weex.devtools.debug.SocketClient
    protected void close() {
        IWebSocketClient iWebSocketClient = this.webSocketClient;
        if (iWebSocketClient != null) {
            iWebSocketClient.close();
        }
    }

    @Override // com.taobao.weex.devtools.debug.SocketClient
    protected void connect(String str) {
        IWebSocketClient iWebSocketClient = this.webSocketClient;
        if (iWebSocketClient != null) {
            iWebSocketClient.connect(str, new IWebSocketClient.WSListener() { // from class: com.taobao.weex.devtools.debug.CustomerWSClient.1
                @Override // com.taobao.weex.devtools.debug.IWebSocketClient.WSListener
                public void onClose() {
                    HandlerThread handlerThread = CustomerWSClient.this.mHandlerThread;
                    if (handlerThread == null || !handlerThread.isAlive()) {
                        return;
                    }
                    CustomerWSClient.this.mHandler.sendEmptyMessage(3);
                }

                @Override // com.taobao.weex.devtools.debug.IWebSocketClient.WSListener
                public void onFailure(Throwable th) {
                    SocketClient.Callback callback = CustomerWSClient.this.mConnectCallback;
                    if (callback != null) {
                        callback.onFailure(th);
                        CustomerWSClient.this.mConnectCallback = null;
                    }
                }

                @Override // com.taobao.weex.devtools.debug.IWebSocketClient.WSListener
                public void onMessage(String str2) {
                    try {
                        CustomerWSClient.this.mProxy.handleMessage(str2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.taobao.weex.devtools.debug.IWebSocketClient.WSListener
                public void onOpen() {
                    SocketClient.Callback callback = CustomerWSClient.this.mConnectCallback;
                    if (callback != null) {
                        callback.onSuccess(null);
                    }
                }
            });
        }
    }

    public boolean isAvailed() {
        return this.webSocketClient != null;
    }

    @Override // com.taobao.weex.devtools.debug.SocketClient, com.taobao.weex.devtools.websocket.SimpleSession
    public boolean isOpen() {
        IWebSocketClient iWebSocketClient = this.webSocketClient;
        return iWebSocketClient != null && iWebSocketClient.isOpen();
    }

    @Override // com.taobao.weex.devtools.debug.SocketClient
    protected void sendProtocolMessage(int i, String str) {
        IWebSocketClient iWebSocketClient = this.webSocketClient;
        if (iWebSocketClient != null) {
            iWebSocketClient.sendMessage(i, str);
        }
    }
}
