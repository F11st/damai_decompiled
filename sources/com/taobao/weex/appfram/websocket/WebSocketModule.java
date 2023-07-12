package com.taobao.weex.appfram.websocket;

import android.os.Looper;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.appfram.websocket.IWebSocketAdapter;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WebSocketModule extends WXSDKEngine.DestroyableModule {
    private static final String KEY_CODE = "code";
    private static final String KEY_DATA = "data";
    private static final String KEY_REASON = "reason";
    private static final String KEY_WAS_CLEAN = "wasClean";
    private static final String TAG = "WebSocketModule";
    private C6966a eventListener;
    private IWebSocketAdapter webSocketAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.websocket.WebSocketModule$a */
    /* loaded from: classes11.dex */
    public class C6966a implements IWebSocketAdapter.EventListener {
        private JSCallback a;
        private JSCallback b;
        private JSCallback c;
        private JSCallback d;

        private C6966a(WebSocketModule webSocketModule) {
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onClose(int i, String str, boolean z) {
            if (this.b != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("code", Integer.valueOf(i));
                hashMap.put("reason", str);
                hashMap.put(WebSocketModule.KEY_WAS_CLEAN, Boolean.valueOf(z));
                this.b.invoke(hashMap);
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onError(String str) {
            if (this.c != null) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("data", str);
                this.c.invokeAndKeepAlive(hashMap);
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onMessage(String str) {
            if (this.d != null) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("data", str);
                this.d.invokeAndKeepAlive(hashMap);
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onOpen() {
            JSCallback jSCallback = this.a;
            if (jSCallback != null) {
                jSCallback.invoke(new HashMap(0));
            }
        }
    }

    public WebSocketModule() {
        WXLogUtils.e(TAG, "create new instance");
    }

    private boolean reportErrorIfNoAdapter() {
        if (this.webSocketAdapter == null) {
            C6966a c6966a = this.eventListener;
            if (c6966a != null) {
                c6966a.onError("No implementation found for IWebSocketAdapter");
            }
            WXLogUtils.e(TAG, "No implementation found for IWebSocketAdapter");
            return true;
        }
        return false;
    }

    @JSMethod(uiThread = false)
    public void WebSocket(String str, String str2) {
        if (this.webSocketAdapter != null) {
            WXLogUtils.w(TAG, "close");
            IWebSocketAdapter iWebSocketAdapter = this.webSocketAdapter;
            WebSocketCloseCodes webSocketCloseCodes = WebSocketCloseCodes.CLOSE_GOING_AWAY;
            iWebSocketAdapter.close(webSocketCloseCodes.getCode(), webSocketCloseCodes.name());
        }
        this.webSocketAdapter = this.mWXSDKInstance.getWXWebSocketAdapter();
        if (reportErrorIfNoAdapter()) {
            return;
        }
        C6966a c6966a = new C6966a();
        this.eventListener = c6966a;
        this.webSocketAdapter.connect(str, str2, c6966a);
    }

    @JSMethod(uiThread = false)
    public void close(String str, String str2) {
        if (reportErrorIfNoAdapter()) {
            return;
        }
        int code = WebSocketCloseCodes.CLOSE_NORMAL.getCode();
        if (str != null) {
            try {
                code = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        this.webSocketAdapter.close(code, str2);
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        Runnable runnable = new Runnable() { // from class: com.taobao.weex.appfram.websocket.WebSocketModule.1
            @Override // java.lang.Runnable
            public void run() {
                WXLogUtils.w(WebSocketModule.TAG, "close session with instance id " + WebSocketModule.this.mWXSDKInstance.getInstanceId());
                if (WebSocketModule.this.webSocketAdapter != null) {
                    WebSocketModule.this.webSocketAdapter.destroy();
                }
                WebSocketModule.this.webSocketAdapter = null;
                WebSocketModule.this.eventListener = null;
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            WXBridgeManager.getInstance().post(runnable);
        } else {
            runnable.run();
        }
    }

    @JSMethod(uiThread = false)
    public void onclose(JSCallback jSCallback) {
        C6966a c6966a = this.eventListener;
        if (c6966a != null) {
            c6966a.b = jSCallback;
        }
    }

    @JSMethod(uiThread = false)
    public void onerror(JSCallback jSCallback) {
        C6966a c6966a = this.eventListener;
        if (c6966a != null) {
            c6966a.c = jSCallback;
        }
    }

    @JSMethod(uiThread = false)
    public void onmessage(JSCallback jSCallback) {
        C6966a c6966a = this.eventListener;
        if (c6966a != null) {
            c6966a.d = jSCallback;
        }
    }

    @JSMethod(uiThread = false)
    public void onopen(JSCallback jSCallback) {
        C6966a c6966a = this.eventListener;
        if (c6966a != null) {
            c6966a.a = jSCallback;
        }
    }

    @JSMethod(uiThread = false)
    public void send(String str) {
        if (reportErrorIfNoAdapter()) {
            return;
        }
        this.webSocketAdapter.send(str);
    }
}
