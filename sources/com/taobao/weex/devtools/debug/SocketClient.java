package com.taobao.weex.devtools.debug;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.taobao.weex.devtools.websocket.SimpleSession;
import java.lang.reflect.InvocationHandler;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class SocketClient implements SimpleSession {
    protected static final int CLOSE_WEB_SOCKET = 3;
    protected static final int CONNECT_TO_WEB_SOCKET = 1;
    protected static final int DISCONNECT_LOOPER = 4;
    private static final String KEY_MESSAGE = "web_socket_message";
    protected static final int SEND_MESSAGE = 2;
    protected Callback mConnectCallback;
    protected Handler mHandler;
    protected HandlerThread mHandlerThread;
    protected InvocationHandler mInvocationHandler;
    protected DebugServerProxy mProxy;
    protected Object mSocketClient;
    private String mUrl;
    protected Object mWebSocket;
    protected Object mWebSocketListener;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Callback {
        void onFailure(Throwable th);

        void onSuccess(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class MessageHandler extends Handler {
        MessageHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                SocketClient.this.connect(message.getData().getString(SocketClient.KEY_MESSAGE));
            } else if (i == 2) {
                SocketClient.this.sendProtocolMessage(0, message.getData().getString(SocketClient.KEY_MESSAGE));
            } else if (i == 3) {
                SocketClient.this.close();
                SocketClient.this.mHandlerThread.quit();
            } else if (i != 4) {
            } else {
                SocketClient.this.close();
                SocketClient.this.mHandlerThread.quit();
            }
        }
    }

    public SocketClient(DebugServerProxy debugServerProxy) {
        init(debugServerProxy);
    }

    protected abstract void close();

    @Override // com.taobao.weex.devtools.websocket.SimpleSession
    public void close(int i, String str) {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        this.mHandler.sendEmptyMessage(3);
    }

    protected abstract void connect(String str);

    public void connect(String str, Callback callback) {
        this.mUrl = str;
        this.mConnectCallback = callback;
        Message obtain = Message.obtain();
        obtain.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE, str);
        obtain.setData(bundle);
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        this.mHandler.sendMessage(obtain);
    }

    public String getUrl() {
        return this.mUrl;
    }

    protected void init(DebugServerProxy debugServerProxy) {
        this.mUrl = debugServerProxy.mRemoteUrl;
        this.mProxy = debugServerProxy;
        HandlerThread handlerThread = new HandlerThread("DebugServerProxy");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new MessageHandler(this.mHandlerThread.getLooper());
    }

    @Override // com.taobao.weex.devtools.websocket.SimpleSession
    public boolean isOpen() {
        return this.mWebSocket != null;
    }

    @Override // com.taobao.weex.devtools.websocket.SimpleSession
    public void post(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.taobao.weex.devtools.websocket.SimpleSession
    public void sendBinary(byte[] bArr) {
    }

    protected abstract void sendProtocolMessage(int i, String str);

    @Override // com.taobao.weex.devtools.websocket.SimpleSession
    public void sendText(String str) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE, str);
        obtain.setData(bundle);
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        this.mHandler.sendMessage(obtain);
    }
}
