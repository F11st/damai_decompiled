package com.taobao.weex.devtools.debug;

import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.weex.devtools.common.LogRedirector;
import com.taobao.weex.devtools.common.ReflectionUtil;
import com.taobao.weex.devtools.debug.SocketClient;
import com.taobao.weex.utils.WXLogUtils;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OkHttp3SocketClient extends SocketClient {
    private static final String CLASS_BUFFER = "okio.Buffer";
    private static final String CLASS_BUFFER_SOURCE = "okio.BufferedSource";
    private static final String CLASS_MEDIATYPE = "okhttp3.MediaType";
    private static final String CLASS_OKHTTP_CLIENT = "okhttp3.OkHttpClient";
    private static final String CLASS_OKHTTP_CLIENT_BUILDER = "okhttp3.OkHttpClient$Builder";
    private static final String CLASS_REQUEST = "okhttp3.Request";
    private static final String CLASS_REQUEST_BODY = "okhttp3.RequestBody";
    private static final String CLASS_REQUEST_BUILDER = "okhttp3.Request$Builder";
    private static final String CLASS_RESPONSE = "okhttp3.Response";
    private static final String CLASS_RESPONSE_BODY = "okhttp3.ResponseBody";
    private static final String CLASS_WEBSOCKET = "okhttp3.ws.WebSocket";
    private static final String CLASS_WEBSOCKET_CALL = "okhttp3.ws.WebSocketCall";
    private static final String CLASS_WEBSOCKET_LISTENER = "okhttp3.ws.WebSocketListener";
    private static final String TAG = "OkHttp3SocketClient";
    private static HashMap<String, Class> sClazzMap = new HashMap<>();
    private Class mBufferedSourceClazz;
    private Class mMediaTypeClazz;
    private Class mOkHttpClientBuilderClazz;
    private Class mOkHttpClientClazz;
    private Class mRequestBodyClazz;
    private Class mRequestBuilderClazz;
    private Class mRequestClazz;
    private Class mResponseBodyClazz;
    private Class mWebSocketCallClazz;
    private Class mWebSocketClazz;
    private Class mWebSocketListenerClazz;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class WebSocketInvocationHandler implements InvocationHandler {
        WebSocketInvocationHandler() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            HandlerThread handlerThread;
            if ("onOpen".equals(method.getName())) {
                OkHttp3SocketClient okHttp3SocketClient = OkHttp3SocketClient.this;
                okHttp3SocketClient.mWebSocket = okHttp3SocketClient.mWebSocketClazz.cast(objArr[0]);
                SocketClient.Callback callback = OkHttp3SocketClient.this.mConnectCallback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            } else if ("onFailure".equals(method.getName())) {
                OkHttp3SocketClient.this.abort("Websocket onFailure", (IOException) objArr[0]);
            } else if ("onMessage".equals(method.getName())) {
                Object tryInvokeMethod = ReflectionUtil.tryInvokeMethod(OkHttp3SocketClient.this.mResponseBodyClazz.cast(objArr[0]), ReflectionUtil.tryGetMethod(OkHttp3SocketClient.this.mResponseBodyClazz, "source", new Class[0]), new Object[0]);
                try {
                    try {
                        OkHttp3SocketClient.this.mProxy.handleMessage((String) ReflectionUtil.tryInvokeMethod(tryInvokeMethod, ReflectionUtil.tryGetMethod(OkHttp3SocketClient.this.mBufferedSourceClazz, "readUtf8", new Class[0]), new Object[0]));
                        ReflectionUtil.tryInvokeMethod(tryInvokeMethod, ReflectionUtil.tryGetMethod(OkHttp3SocketClient.this.mBufferedSourceClazz, "close", new Class[0]), new Object[0]);
                    } catch (Exception e) {
                        if (LogRedirector.isLoggable(OkHttp3SocketClient.TAG, 2)) {
                            LogRedirector.v(OkHttp3SocketClient.TAG, "Unexpected I/O exception processing message: " + e);
                        }
                        ReflectionUtil.tryInvokeMethod(tryInvokeMethod, ReflectionUtil.tryGetMethod(OkHttp3SocketClient.this.mBufferedSourceClazz, "close", new Class[0]), new Object[0]);
                    }
                } catch (Throwable th) {
                    ReflectionUtil.tryInvokeMethod(tryInvokeMethod, ReflectionUtil.tryGetMethod(OkHttp3SocketClient.this.mBufferedSourceClazz, "close", new Class[0]), new Object[0]);
                    throw th;
                }
            } else if (!"onPong".equals(method.getName()) && "onClose".equals(method.getName()) && (handlerThread = OkHttp3SocketClient.this.mHandlerThread) != null && handlerThread.isAlive()) {
                OkHttp3SocketClient.this.mHandler.sendEmptyMessage(3);
            }
            return null;
        }
    }

    static {
        String[] strArr = {CLASS_WEBSOCKET, CLASS_WEBSOCKET_LISTENER, CLASS_WEBSOCKET_CALL, CLASS_MEDIATYPE, CLASS_OKHTTP_CLIENT, CLASS_OKHTTP_CLIENT_BUILDER, CLASS_RESPONSE, CLASS_REQUEST, CLASS_REQUEST_BUILDER, CLASS_BUFFER, CLASS_BUFFER_SOURCE, CLASS_REQUEST_BODY, CLASS_RESPONSE_BODY};
        for (int i = 0; i < 13; i++) {
            String str = strArr[i];
            sClazzMap.put(str, ReflectionUtil.tryGetClassForName(str));
        }
    }

    public OkHttp3SocketClient(DebugServerProxy debugServerProxy) {
        super(debugServerProxy);
        this.mOkHttpClientClazz = sClazzMap.get(CLASS_OKHTTP_CLIENT);
        this.mOkHttpClientBuilderClazz = sClazzMap.get(CLASS_OKHTTP_CLIENT_BUILDER);
        this.mRequestClazz = sClazzMap.get(CLASS_REQUEST);
        this.mRequestBuilderClazz = sClazzMap.get(CLASS_REQUEST_BUILDER);
        this.mWebSocketCallClazz = sClazzMap.get(CLASS_WEBSOCKET_CALL);
        this.mWebSocketListenerClazz = sClazzMap.get(CLASS_WEBSOCKET_LISTENER);
        this.mRequestBodyClazz = sClazzMap.get(CLASS_REQUEST_BODY);
        this.mResponseBodyClazz = sClazzMap.get(CLASS_RESPONSE_BODY);
        this.mMediaTypeClazz = sClazzMap.get(CLASS_MEDIATYPE);
        this.mWebSocketClazz = sClazzMap.get(CLASS_WEBSOCKET);
        this.mBufferedSourceClazz = sClazzMap.get(CLASS_BUFFER_SOURCE);
        this.mInvocationHandler = new WebSocketInvocationHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abort(String str, Throwable th) {
        Log.w(TAG, "Error occurred, shutting down websocket connection: " + str);
        close();
        SocketClient.Callback callback = this.mConnectCallback;
        if (callback != null) {
            callback.onFailure(th);
            this.mConnectCallback = null;
        }
    }

    @Override // com.taobao.weex.devtools.debug.SocketClient
    protected void close() {
        if (this.mWebSocket != null) {
            ReflectionUtil.tryInvokeMethod(this.mWebSocket, ReflectionUtil.tryGetMethod(this.mWebSocketClazz, "close", Integer.TYPE, String.class), 1000, "End of session");
            this.mWebSocket = null;
            WXLogUtils.w(TAG, "Close websocket connection");
        }
    }

    @Override // com.taobao.weex.devtools.debug.SocketClient
    protected void connect(String str) {
        if (this.mSocketClient == null) {
            try {
                Object newInstance = this.mOkHttpClientBuilderClazz.newInstance();
                Class cls = this.mOkHttpClientBuilderClazz;
                Class cls2 = Long.TYPE;
                Method tryGetMethod = ReflectionUtil.tryGetMethod(cls, "connectTimeout", cls2, TimeUnit.class);
                Method tryGetMethod2 = ReflectionUtil.tryGetMethod(this.mOkHttpClientBuilderClazz, "writeTimeout", cls2, TimeUnit.class);
                Method tryGetMethod3 = ReflectionUtil.tryGetMethod(this.mOkHttpClientBuilderClazz, "readTimeout", cls2, TimeUnit.class);
                TimeUnit timeUnit = TimeUnit.SECONDS;
                this.mSocketClient = ReflectionUtil.tryInvokeMethod(ReflectionUtil.tryInvokeMethod(ReflectionUtil.tryInvokeMethod(ReflectionUtil.tryInvokeMethod(newInstance, tryGetMethod, 30, timeUnit), tryGetMethod2, 30, timeUnit), tryGetMethod3, 0, timeUnit), ReflectionUtil.tryGetMethod(this.mOkHttpClientBuilderClazz, "build", new Class[0]), new Object[0]);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Object tryInvokeMethod = ReflectionUtil.tryInvokeMethod(ReflectionUtil.tryInvokeMethod(this.mRequestBuilderClazz.newInstance(), ReflectionUtil.tryGetMethod(this.mRequestBuilderClazz, "url", String.class), str), ReflectionUtil.tryGetMethod(this.mRequestBuilderClazz, "build", new Class[0]), new Object[0]);
                Method tryGetMethod4 = ReflectionUtil.tryGetMethod(this.mWebSocketCallClazz, "enqueue", this.mWebSocketListenerClazz);
                Object tryInvokeMethod2 = ReflectionUtil.tryInvokeMethod(this.mWebSocketCallClazz, ReflectionUtil.tryGetMethod(this.mWebSocketCallClazz, "create", this.mOkHttpClientClazz, this.mRequestClazz), this.mSocketClient, tryInvokeMethod);
                Object newProxyInstance = Proxy.newProxyInstance(this.mWebSocketListenerClazz.getClassLoader(), new Class[]{this.mWebSocketListenerClazz}, this.mInvocationHandler);
                this.mWebSocketListener = newProxyInstance;
                ReflectionUtil.tryInvokeMethod(tryInvokeMethod2, tryGetMethod4, newProxyInstance);
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return;
            }
        }
        throw new IllegalStateException("OkHttp3SocketClient is already initialized.");
    }

    @Override // com.taobao.weex.devtools.debug.SocketClient
    protected void sendProtocolMessage(int i, String str) {
        if (this.mWebSocket == null) {
            return;
        }
        Object tryInvokeMethod = ReflectionUtil.tryInvokeMethod(this.mRequestBodyClazz, ReflectionUtil.tryGetMethod(this.mRequestBodyClazz, "create", this.mMediaTypeClazz, String.class), ReflectionUtil.getFieldValue(ReflectionUtil.tryGetDeclaredField(this.mWebSocketClazz, "TEXT"), null), str);
        ReflectionUtil.tryInvokeMethod(this.mWebSocket, ReflectionUtil.tryGetMethod(this.mWebSocketClazz, "sendMessage", this.mRequestBodyClazz), tryInvokeMethod);
    }
}
