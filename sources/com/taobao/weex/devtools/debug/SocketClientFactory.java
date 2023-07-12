package com.taobao.weex.devtools.debug;

import com.taobao.weex.devtools.common.ReflectionUtil;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SocketClientFactory {
    public static SocketClient create(DebugServerProxy debugServerProxy) {
        CustomerWSClient customerWSClient = new CustomerWSClient(debugServerProxy);
        if (customerWSClient.isAvailed()) {
            return customerWSClient;
        }
        if (ReflectionUtil.tryGetClassForName("okhttp3.ws.WebSocketListener") != null) {
            return new OkHttp3SocketClient(debugServerProxy);
        }
        if (ReflectionUtil.tryGetClassForName("com.squareup.okhttp.ws.WebSocketListener") != null) {
            return new OkHttpSocketClient(debugServerProxy);
        }
        new RuntimeException("No suitable websocket client found, trying to using WeexInspector.overrideWebSocketClient() to setting one").printStackTrace();
        return null;
    }
}
