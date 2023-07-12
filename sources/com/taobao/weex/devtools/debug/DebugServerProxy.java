package com.taobao.weex.devtools.debug;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.bridge.WXDebugJsBridge;
import com.taobao.weex.common.IWXBridge;
import com.taobao.weex.common.IWXDebugConfig;
import com.taobao.weex.devtools.WeexInspector;
import com.taobao.weex.devtools.common.LogRedirector;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.debug.SocketClient;
import com.taobao.weex.devtools.inspector.MessageHandlingException;
import com.taobao.weex.devtools.inspector.MethodDispatcher;
import com.taobao.weex.devtools.inspector.MismatchedResponseException;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcException;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.PendingRequest;
import com.taobao.weex.devtools.inspector.jsonrpc.PendingRequestCallback;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcError;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcResponse;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.json.ObjectMapper;
import com.taobao.weex.utils.LogLevel;
import com.taobao.weex.utils.WXLogUtils;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DebugServerProxy {
    private static final String DEVTOOL_VERSION = "0.24.2.11";
    private static final String TAG = "DebugServerProxy";
    private Context mContext;
    private Iterable<ChromeDevtoolsDomain> mDomainModules;
    private MethodDispatcher mMethodDispatcher;
    private JsonRpcPeer mPeer;
    private WXDebugBridge mWXBridge;
    private WXDebugJsBridge mWXDebugJsBridge;
    private WXBridgeManager mWXJsManager;
    private SocketClient mWebSocketClient;
    private ObjectMapper mObjectMapper = new ObjectMapper();
    public String mRemoteUrl = WXEnvironment.sRemoteDebugProxyUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.devtools.debug.DebugServerProxy$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$weex$devtools$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode;

        static {
            int[] iArr = new int[JsonRpcError.ErrorCode.values().length];
            $SwitchMap$com$taobao$weex$devtools$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode = iArr;
            try {
                iArr[JsonRpcError.ErrorCode.METHOD_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public DebugServerProxy(Context context, IWXDebugConfig iWXDebugConfig) {
        if (context != null) {
            this.mContext = context;
            SocketClient create = SocketClientFactory.create(this);
            this.mWebSocketClient = create;
            this.mPeer = new JsonRpcPeer(this.mObjectMapper, create);
            if (iWXDebugConfig != null) {
                if (iWXDebugConfig.getWXJSManager() != null) {
                    this.mWXJsManager = iWXDebugConfig.getWXJSManager();
                }
                if (iWXDebugConfig.getWXDebugJsBridge() != null) {
                    this.mWXDebugJsBridge = iWXDebugConfig.getWXDebugJsBridge();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Context of DebugServerProxy should not be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDeviceId(Context context) {
        String serial = Build.VERSION.SDK_INT > 8 ? com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getSERIAL() : null;
        return TextUtils.isEmpty(serial) ? Settings.Secure.getString(context.getContentResolver(), "android_id") : serial;
    }

    private void handleRemoteMessage(JsonRpcPeer jsonRpcPeer, String str) throws IOException, MessageHandlingException, JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("method")) {
            handleRemoteRequest(jsonRpcPeer, jSONObject);
        } else if (jSONObject.has("result")) {
            handleRemoteResponse(jsonRpcPeer, jSONObject);
        } else {
            throw new MessageHandlingException("Improper JSON-RPC message: " + str);
        }
    }

    private void handleRemoteRequest(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws MessageHandlingException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String jSONObject4;
        JsonRpcRequest jsonRpcRequest = (JsonRpcRequest) this.mObjectMapper.convertValue(jSONObject, JsonRpcRequest.class);
        try {
            jSONObject3 = this.mMethodDispatcher.dispatch(jsonRpcPeer, jsonRpcRequest.method, jsonRpcRequest.params);
            jSONObject2 = null;
        } catch (JsonRpcException e) {
            logDispatchException(e);
            jSONObject2 = (JSONObject) this.mObjectMapper.convertValue(e.getErrorMessage(), JSONObject.class);
            jSONObject3 = null;
        }
        if (jsonRpcRequest.id != null) {
            JsonRpcResponse jsonRpcResponse = new JsonRpcResponse();
            jsonRpcResponse.id = jsonRpcRequest.id.longValue();
            jsonRpcResponse.result = jSONObject3;
            jsonRpcResponse.error = jSONObject2;
            try {
                jSONObject4 = ((JSONObject) this.mObjectMapper.convertValue(jsonRpcResponse, JSONObject.class)).toString();
            } catch (OutOfMemoryError e2) {
                jsonRpcResponse.result = null;
                jsonRpcResponse.error = (JSONObject) this.mObjectMapper.convertValue(e2.getMessage(), JSONObject.class);
                jSONObject4 = ((JSONObject) this.mObjectMapper.convertValue(jsonRpcResponse, JSONObject.class)).toString();
            }
            jsonRpcPeer.getWebSocket().sendText(jSONObject4);
        }
    }

    private void handleRemoteResponse(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws MismatchedResponseException {
        JsonRpcResponse jsonRpcResponse = (JsonRpcResponse) this.mObjectMapper.convertValue(jSONObject, JsonRpcResponse.class);
        PendingRequest andRemovePendingRequest = jsonRpcPeer.getAndRemovePendingRequest(jsonRpcResponse.id);
        if (andRemovePendingRequest != null) {
            PendingRequestCallback pendingRequestCallback = andRemovePendingRequest.callback;
            if (pendingRequestCallback != null) {
                pendingRequestCallback.onResponse(jsonRpcPeer, jsonRpcResponse);
                return;
            }
            return;
        }
        throw new MismatchedResponseException(jsonRpcResponse.id);
    }

    private static void logDispatchException(JsonRpcException jsonRpcException) {
        JsonRpcError errorMessage = jsonRpcException.getErrorMessage();
        if (AnonymousClass2.$SwitchMap$com$taobao$weex$devtools$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode[errorMessage.code.ordinal()] != 1) {
            LogRedirector.w(TAG, "Error processing remote message", jsonRpcException);
            return;
        }
        LogRedirector.d(TAG, "Method not implemented: " + errorMessage.message);
    }

    private void switchLocalRuntime() {
        WXSDKEngine.reload(WXEnvironment.getApplication(), false);
        WXEnvironment.getApplication().sendBroadcast(new Intent().setAction(WXSDKInstance.ACTION_DEBUG_INSTANCE_REFRESH).putExtra("params", ""));
    }

    public IWXBridge getWXBridge() {
        if (this.mWXBridge == null) {
            WXLogUtils.e(TAG, "WXDebugBridge is null!");
        }
        return this.mWXBridge;
    }

    public void handleMessage(String str) throws IOException {
        try {
            Util.throwIfNull(this.mPeer);
            handleRemoteMessage(this.mPeer, str);
        } catch (Exception e) {
            if (LogRedirector.isLoggable(TAG, 2)) {
                LogRedirector.v(TAG, "Unexpected I/O exception processing message: " + e);
            }
        }
    }

    public void start() {
        synchronized (DebugServerProxy.class) {
            Context context = this.mContext;
            if (context == null) {
                new IllegalArgumentException("Context is null").printStackTrace();
                return;
            }
            WXEnvironment.sDebugServerConnectable = true;
            WeexInspector.initializeWithDefaults(context);
            WXDebugBridge wXDebugBridge = WXDebugBridge.getInstance();
            this.mWXBridge = wXDebugBridge;
            wXDebugBridge.setSession(this.mWebSocketClient);
            this.mWXBridge.setWXDebugJsBridge(this.mWXDebugJsBridge);
            this.mWebSocketClient.connect(this.mRemoteUrl, new SocketClient.Callback() { // from class: com.taobao.weex.devtools.debug.DebugServerProxy.1
                private String getShakeHandsMessage() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", WXEnvironment.getApplication().getPackageName() + " : " + Process.myPid());
                    hashMap.put("model", WXEnvironment.SYS_MODEL);
                    hashMap.put("weexVersion", WXEnvironment.WXSDK_VERSION);
                    hashMap.put("devtoolVersion", DebugServerProxy.DEVTOOL_VERSION);
                    hashMap.put("platform", "android");
                    DebugServerProxy debugServerProxy = DebugServerProxy.this;
                    hashMap.put("deviceId", debugServerProxy.getDeviceId(debugServerProxy.mContext));
                    hashMap.put("network", Boolean.valueOf(WXEnvironment.sDebugNetworkEventReporterEnable));
                    LogLevel logLevel = WXEnvironment.sLogLevel;
                    if (logLevel != null) {
                        hashMap.put("logLevel", logLevel.getName());
                    }
                    hashMap.put("remoteDebug", Boolean.valueOf(WXEnvironment.sRemoteDebugMode));
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("id", "0");
                    hashMap2.put("method", "WxDebug.registerDevice");
                    hashMap2.put("params", hashMap);
                    return JSON.toJSONString(hashMap2);
                }

                @Override // com.taobao.weex.devtools.debug.SocketClient.Callback
                public void onFailure(Throwable th) {
                    synchronized (DebugServerProxy.class) {
                        if (DebugServerProxy.this.mWXBridge != null) {
                            DebugServerProxy.this.mWXBridge.onDisConnected();
                        }
                        Log.w(DebugServerProxy.TAG, "connect debugger server failure!!");
                        th.printStackTrace();
                    }
                }

                @Override // com.taobao.weex.devtools.debug.SocketClient.Callback
                public void onSuccess(String str) {
                    synchronized (DebugServerProxy.class) {
                        if (DebugServerProxy.this.mWebSocketClient != null && DebugServerProxy.this.mWebSocketClient.isOpen()) {
                            DebugServerProxy.this.mWebSocketClient.sendText(getShakeHandsMessage());
                            if (DebugServerProxy.this.mWXBridge != null) {
                                DebugServerProxy.this.mWXBridge.onConnected();
                            }
                            DebugServerProxy debugServerProxy = DebugServerProxy.this;
                            debugServerProxy.mDomainModules = new WeexInspector.DefaultInspectorModulesBuilder(debugServerProxy.mContext).finish();
                            DebugServerProxy debugServerProxy2 = DebugServerProxy.this;
                            debugServerProxy2.mMethodDispatcher = new MethodDispatcher(debugServerProxy2.mObjectMapper, DebugServerProxy.this.mDomainModules);
                            WXSDKManager.v().N(new Runnable() { // from class: com.taobao.weex.devtools.debug.DebugServerProxy.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(WXEnvironment.sApplication, "debug server connected", 0).show();
                                }
                            }, 0L);
                            Log.d(DebugServerProxy.TAG, "connect debugger server success!");
                            if (DebugServerProxy.this.mWXJsManager != null) {
                                DebugServerProxy.this.mWXJsManager.initScriptsFramework(null);
                            }
                        }
                    }
                }
            });
        }
    }

    public void stop(boolean z) {
        synchronized (DebugServerProxy.class) {
            SocketClient socketClient = this.mWebSocketClient;
            if (socketClient != null) {
                socketClient.close(0, null);
                this.mWebSocketClient = null;
            }
            this.mWXBridge = null;
            if (z) {
                switchLocalRuntime();
            }
        }
    }
}
