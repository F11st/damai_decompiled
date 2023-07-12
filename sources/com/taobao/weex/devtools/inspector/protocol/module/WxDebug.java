package com.taobao.weex.devtools.inspector.protocol.module;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSON;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.bridge.WXJSObject;
import com.taobao.weex.devtools.debug.WXDebugBridge;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.network.NetworkEventReporterImpl;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import com.taobao.weex.ui.module.WXDomModule;
import com.taobao.weex.utils.LogLevel;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXWsonJSONSwitch;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WxDebug implements ChromeDevtoolsDomain {
    private static final String TAG = "weex-devtool";
    private static final HashMap<String, LogLevel> sLevelMap;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CallJS {
        @JsonProperty(required = true)
        public List<Object> args;
        @JsonProperty(required = true)
        public String method;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CallNative {
        @JsonProperty(required = true)
        public String callback;
        @JsonProperty(required = true)
        public String instance;
        @JsonProperty(required = true)
        public List<Task> tasks;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SyncCallResponse implements JsonRpcResult {
        @JsonProperty
        public String method;
        @JsonProperty
        public SyncCallResponseParams params;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SyncCallResponseParams {
        @JsonProperty
        public Object ret;
        @JsonProperty
        public Integer syncId;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Task {
        @JsonProperty(required = true)
        public List<String> args;
        @JsonProperty(required = true)
        public String method;
        @JsonProperty(required = true)
        public String module;
    }

    static {
        HashMap<String, LogLevel> hashMap = new HashMap<>(6);
        sLevelMap = hashMap;
        hashMap.put("all", LogLevel.ALL);
        hashMap.put("verbose", LogLevel.VERBOSE);
        hashMap.put("info", LogLevel.INFO);
        hashMap.put("debug", LogLevel.DEBUG);
        hashMap.put("warn", LogLevel.WARN);
        hashMap.put("error", LogLevel.ERROR);
    }

    @ChromeDevtoolsMethod
    public void callAddElement(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.d(TAG, "WxDebug-new >>>> callAddElement=" + jSONObject);
        if (jSONObject == null) {
            Log.e(TAG, "callAddElement: params==null !");
            return;
        }
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("ref");
        final String optString3 = jSONObject.optString("index");
        final String optString4 = jSONObject.optString(WXDomModule.WXDOM);
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.3
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallAddElement(optString, optString2, optString4, optString3);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callAddEvent(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callAddEvent: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callAddEvent=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("ref");
        final String optString3 = jSONObject.optString("event");
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.12
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallAddEvent(optString, optString2, optString3);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callCreateBody(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callCreateBody: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callCreateBody=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("domStr");
        if (optString == null || optString.isEmpty() || optString2 == null || optString2.isEmpty()) {
            return;
        }
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.4
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallCreateBody(optString, optString2);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callCreateFinish(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callCreateFinish: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callCreateFinish=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.6
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallCreateFinish(optString);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callMoveElement(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callMoveElement: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callMoveElement=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("ref");
        final String optString3 = jSONObject.optString("parentRef");
        final String optString4 = jSONObject.optString("index_str");
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.11
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallMoveElement(optString, optString2, optString3, optString4);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callNative(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.d(TAG, "WxDebug-new >>>> callNative=" + jSONObject);
        if (jSONObject != null) {
            final String optString = jSONObject.optString("instance");
            final byte[] bytes = jSONObject.optString("tasks").getBytes();
            final String optString2 = jSONObject.optString(WXBridgeManager.METHOD_CALLBACK);
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.1
                @Override // java.lang.Runnable
                public void run() {
                    WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallNative(optString, bytes, optString2);
                }
            });
        }
    }

    @ChromeDevtoolsMethod
    public void callRefreshFinish(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callRefreshFinish: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callRefreshFinish=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString(WXBridgeManager.METHOD_CALLBACK);
        final String optString3 = jSONObject.optString("tasks");
        if (optString == null || optString.isEmpty()) {
            return;
        }
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.7
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallRefreshFinish(optString, optString3.getBytes(), optString2);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callRemoveElement(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callRemoveElement: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callRemoveElement=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("ref");
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.10
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallRemoveElement(optString, optString2);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callRemoveEvent(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callRemoveEvent: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callRemoveEvent=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("ref");
        final String optString3 = jSONObject.optString("event");
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.13
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallRemoveEvent(optString, optString2, optString3);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callUpdateAttrs(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callUpdateAttrs: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callUpdateAttrs=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("ref");
        final String optString3 = jSONObject.optString("data");
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.8
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallUpdateAttrs(optString, optString2, optString3);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callUpdateComponentData(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.d(TAG, "WxDebug-new >>>> callUpdateComponentData=" + jSONObject);
        if (jSONObject != null) {
            final String optString = jSONObject.optString("instance");
            final byte[] bytes = jSONObject.optString("tasks").getBytes();
            final String optString2 = jSONObject.optString(WXBridgeManager.METHOD_CALLBACK);
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.2
                @Override // java.lang.Runnable
                public void run() {
                    WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallNative(optString, bytes, optString2);
                }
            });
        }
    }

    @ChromeDevtoolsMethod
    public void callUpdateFinish(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callUpdateFinish: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callUpdateFinish=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("domStr");
        final String optString3 = jSONObject.optString("tasks");
        if (optString == null || optString.isEmpty() || optString2 == null || optString2.isEmpty()) {
            return;
        }
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.5
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallUpdateFinish(optString, optString3.getBytes(), optString2);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void callUpdateStyle(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e(TAG, "callUpdateStyle: params==null !");
            return;
        }
        WXLogUtils.d(TAG, "WxDebug-new >>>> callUpdateStyle=" + jSONObject);
        final String optString = jSONObject.optString("instance");
        final String optString2 = jSONObject.optString("ref");
        final String optString3 = jSONObject.optString("data");
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.WxDebug.9
            @Override // java.lang.Runnable
            public void run() {
                WXDebugBridge.getInstance().getWXDebugJsBridge().jsHandleCallUpdateStyle(optString, optString2, optString3);
            }
        });
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.d(TAG, "WxDebug-new >>>> disable=" + jSONObject);
        Application application = WXEnvironment.getApplication();
        if (application != null) {
            WXSDKEngine.reload(application, false);
            application.sendBroadcast(new Intent().setAction(WXSDKInstance.ACTION_DEBUG_INSTANCE_REFRESH).putExtra("params", jSONObject == null ? "" : jSONObject.toString()));
        }
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.d(TAG, "WxDebug-new >>>> enable=" + jSONObject);
        Application application = WXEnvironment.getApplication();
        if (application != null) {
            WXSDKEngine.reload(application, true);
            application.sendBroadcast(new Intent().setAction(WXSDKInstance.ACTION_DEBUG_INSTANCE_REFRESH).putExtra("params", jSONObject == null ? "" : jSONObject.toString()));
            LocalBroadcastManager.getInstance(application).sendBroadcast(new Intent("debug_windmill_wxrender_reload"));
        }
    }

    @ChromeDevtoolsMethod
    public void network(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.e(TAG, "WxDebug-new >>>> network=" + jSONObject);
        try {
            boolean z = jSONObject.getBoolean("enable");
            NetworkEventReporterImpl.setEnabled(z);
            WXEnvironment.sDebugNetworkEventReporterEnable = z;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @ChromeDevtoolsMethod
    public void refresh(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.e(TAG, "WxDebug-new >>>> refresh=" + jSONObject);
        Application application = WXEnvironment.getApplication();
        if (application != null) {
            application.sendBroadcast(new Intent().setAction(WXSDKInstance.ACTION_DEBUG_INSTANCE_REFRESH).putExtra("params", jSONObject == null ? "" : jSONObject.toString()));
        }
    }

    @ChromeDevtoolsMethod
    public void reload(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.d(TAG, "WxDebug-new >>>> reload=" + jSONObject);
        WXSDKEngine.reload();
        Application application = WXEnvironment.getApplication();
        if (application != null) {
            application.sendBroadcast(new Intent().setAction(WXSDKInstance.ACTION_DEBUG_INSTANCE_REFRESH).putExtra("params", jSONObject == null ? "" : jSONObject.toString()));
        }
    }

    @ChromeDevtoolsMethod
    public void setElementMode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.d(TAG, "WxDebug-new >>>> setElementMode=" + jSONObject);
        if (jSONObject != null) {
            if ("vdom".equals(jSONObject.optString("mode"))) {
                DOM.setNativeMode(false);
            } else {
                DOM.setNativeMode(true);
            }
        }
    }

    @ChromeDevtoolsMethod
    public void setLogLevel(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        LogLevel logLevel;
        WXLogUtils.d(TAG, "WxDebug-new >>>> setLogLevel=" + jSONObject);
        if (jSONObject == null || (logLevel = sLevelMap.get(jSONObject.optString("logLevel"))) == null) {
            return;
        }
        WXEnvironment.sLogLevel = logLevel;
    }

    @ChromeDevtoolsMethod
    public SyncCallResponse syncCall(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        WXLogUtils.e(TAG, "WxDebug-new >>>> syncCall=" + jSONObject);
        SyncCallResponse syncCallResponse = new SyncCallResponse();
        int optInt = jSONObject.optInt("syncId");
        String optString = jSONObject.optString("method");
        JSONArray optJSONArray = jSONObject.optJSONArray("args");
        String optString2 = optJSONArray.optString(0);
        String optString3 = optJSONArray.optString(1);
        String optString4 = optJSONArray.optString(2);
        JSONArray optJSONArray2 = optJSONArray.optJSONArray(3);
        JSONObject optJSONObject = optJSONArray.optJSONObject(4);
        Object obj = null;
        byte[] bytes = optJSONArray2 != null ? optJSONArray2.toString().getBytes() : null;
        byte[] bytes2 = optJSONObject != null ? optJSONObject.toString().getBytes() : null;
        if ("callNativeModule".equals(optString)) {
            obj = WXDebugBridge.getInstance().callNativeModule(optString2, optString3, optString4, WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bytes), WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bytes2));
        } else if ("callNativeComponent".equals(optString)) {
            WXDebugBridge.getInstance().callNativeComponent(optString2, optString3, optString4, WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bytes), WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bytes2));
        }
        syncCallResponse.method = "WxDebug.syncReturn";
        SyncCallResponseParams syncCallResponseParams = new SyncCallResponseParams();
        syncCallResponseParams.syncId = Integer.valueOf(optInt);
        if (obj instanceof WXJSObject) {
            syncCallResponseParams.ret = WXWsonJSONSwitch.fromObjectToJSONString((WXJSObject) obj);
        } else {
            syncCallResponseParams.ret = JSON.toJSON(obj);
        }
        syncCallResponse.params = syncCallResponseParams;
        return syncCallResponse;
    }
}
