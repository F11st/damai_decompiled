package com.taobao.weex.devtools.debug;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.bridge.ResultCallback;
import com.taobao.weex.bridge.WXBridge;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.bridge.WXDebugJsBridge;
import com.taobao.weex.bridge.WXJSObject;
import com.taobao.weex.bridge.WXParams;
import com.taobao.weex.common.IWXBridge;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.websocket.SimpleSession;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXWsonJSONSwitch;
import com.youku.resource.widget.YKActionSheet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import tb.jg1;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXDebugBridge implements IWXBridge {
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");
    private static final String TAG = "weex-devtool";
    private static volatile WXDebugBridge sInstance;
    private volatile SimpleSession mSession;
    private WXDebugJsBridge mWXDebugJsBridge;
    private final Object mLock = new Object();
    private final OkHttpClient client = new OkHttpClient();
    private String syncCallJSURL = "";
    private IWXBridge mOriginBridge = new WXBridge();

    private WXDebugBridge() {
    }

    private int doCreateInstanceContext(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        ArrayList arrayList = new ArrayList();
        int length = wXJSObjectArr == null ? 0 : wXJSObjectArr.length;
        for (int i = 0; i < length; i++) {
            if (wXJSObjectArr[i].type != 2) {
                arrayList.add(WXWsonJSONSwitch.convertWXJSObjectDataToJSON(wXJSObjectArr[i]));
            } else {
                arrayList.add(wXJSObjectArr[i].data);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("method", WXDebugConstants.METHOD_CALL_JS);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("method", str3);
        hashMap2.put("args", arrayList);
        hashMap.put("params", hashMap2);
        return sendMessage(JSON.toJSONString(hashMap));
    }

    private int doImportScript(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        ArrayList arrayList = new ArrayList();
        int length = wXJSObjectArr == null ? 0 : wXJSObjectArr.length;
        for (int i = 0; i < length; i++) {
            if (wXJSObjectArr[i].type != 2) {
                arrayList.add(WXWsonJSONSwitch.convertWXJSObjectDataToJSON(wXJSObjectArr[i]));
            } else {
                arrayList.add(wXJSObjectArr[i].data);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("method", str3);
        hashMap.put("args", arrayList);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("method", WXDebugConstants.METHOD_CALL_JS);
        hashMap2.put("params", hashMap);
        return sendMessage(JSON.toJSONString(hashMap2));
    }

    private Map<String, Object> getEnvironmentMap(WXParams wXParams) {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", wXParams.getAppName());
        hashMap.put("appVersion", wXParams.getAppVersion());
        hashMap.put("platform", wXParams.getPlatform());
        hashMap.put("osVersion", wXParams.getOsVersion());
        hashMap.put("logLevel", wXParams.getLogLevel());
        hashMap.put("weexVersion", wXParams.getWeexVersion());
        hashMap.put(WXDebugConstants.ENV_DEVICE_MODEL, wXParams.getDeviceModel());
        hashMap.put(WXDebugConstants.ENV_INFO_COLLECT, wXParams.getShouldInfoCollect());
        hashMap.put("deviceWidth", wXParams.getDeviceWidth());
        hashMap.put("deviceHeight", wXParams.getDeviceHeight());
        hashMap.put("runtime", "devtools");
        hashMap.putAll(WXEnvironment.getCustomOptions());
        return hashMap;
    }

    private String getInitFrameworkMessage(String str, WXParams wXParams) {
        Map<String, Object> environmentMap;
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put(WXDebugConstants.PARAM_LAYOUT_SANDBOX, "true");
        if (wXParams != null && (environmentMap = getEnvironmentMap(wXParams)) != null && environmentMap.size() > 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(WXDebugConstants.ENV_WX_ENVIRONMENT, environmentMap);
            hashMap.put("env", hashMap2);
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("method", WXDebugConstants.METHOD_INIT_RUNTIME);
        hashMap3.put("params", hashMap);
        return JSON.toJSONString(hashMap3);
    }

    public static WXDebugBridge getInstance() {
        if (sInstance == null) {
            synchronized (WXDebugBridge.class) {
                if (sInstance == null) {
                    sInstance = new WXDebugBridge();
                }
            }
        }
        return sInstance;
    }

    private int sendMessage(String str) {
        if (this.mSession != null && this.mSession.isOpen()) {
            this.mSession.sendText(str);
            return 1;
        }
        WXBridgeManager.getInstance().stopRemoteDebug();
        return 0;
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void bindMeasurementToRenderObject(long j) {
        this.mOriginBridge.bindMeasurementToRenderObject(j);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callAddElement(String str, String str2, String str3, int i, String str4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3, boolean z) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> callAddElement >>>> pageId:" + str + ", componentType:" + str2 + ", ref:" + str3 + ", index:" + i + ", parentRef:" + str4 + ", styles:" + hashMap + ", attributes:" + hashMap2 + ", events:" + hashSet);
        return this.mOriginBridge.callAddElement(str, str2, str3, i, str4, hashMap, hashMap2, hashSet, fArr, fArr2, fArr3, z);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callAddEvent(String str, String str2, String str3) {
        return this.mOriginBridge.callAddEvent(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callAppendTreeCreateFinish(String str, String str2) {
        return this.mOriginBridge.callAppendTreeCreateFinish(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callCreateBody(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> callCreateBody >>>> pageId:" + str + ", componentType:" + str2 + ", ref:" + str3 + ", styles:" + hashMap + ", attributes:" + hashMap2 + ", events:" + hashSet);
        return this.mOriginBridge.callCreateBody(str, str2, str3, hashMap, hashMap2, hashSet, fArr, fArr2, fArr3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callCreateFinish(String str) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> callCreateFinish");
        return this.mOriginBridge.callCreateFinish(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callHasTransitionPros(String str, String str2, HashMap<String, String> hashMap) {
        return this.mOriginBridge.callHasTransitionPros(str, str2, hashMap);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callLayout(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7) {
        WXLogUtils.e("WXDebugBridge layout", "callLayout " + str + AVFSCacheConstants.COMMA_SEP + str2 + AVFSCacheConstants.COMMA_SEP + i + AVFSCacheConstants.COMMA_SEP + i2 + AVFSCacheConstants.COMMA_SEP + i3 + AVFSCacheConstants.COMMA_SEP + i4 + AVFSCacheConstants.COMMA_SEP + i5 + "," + i6);
        return this.mOriginBridge.callLayout(str, str2, i, i2, i3, i4, i5, i6, z, i7);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callMoveElement(String str, String str2, String str3, int i) {
        return this.mOriginBridge.callMoveElement(str, str2, str3, i);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callNative(String str, byte[] bArr, String str2) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> callNative, instanceId is " + str + ", tasks is " + new String(bArr));
        return callNative(str, new String(bArr), str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void callNativeComponent(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> callNativeComponent, instanceId is " + str + ", componentRef is " + str2 + ", method is " + str3 + ", arguments is " + new String(bArr));
        this.mOriginBridge.callNativeComponent(str, str2, str3, bArr, bArr2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public Object callNativeModule(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> callNativeModule, instanceId is " + str + ", module is " + str2 + ", method is " + str3 + ", arguments is " + new String(bArr));
        return this.mOriginBridge.callNativeModule(str, str2, str3, bArr, bArr2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRefreshFinish(String str, byte[] bArr, String str2) {
        return this.mOriginBridge.callRefreshFinish(str, bArr, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRemoveElement(String str, String str2) {
        return this.mOriginBridge.callRemoveElement(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRemoveEvent(String str, String str2, String str3) {
        return this.mOriginBridge.callRemoveEvent(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRenderSuccess(String str) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> callRenderSuccess");
        return this.mOriginBridge.callRenderSuccess(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callUpdateAttrs(String str, String str2, HashMap<String, String> hashMap) {
        return this.mOriginBridge.callUpdateAttrs(str, str2, hashMap);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callUpdateFinish(String str, byte[] bArr, String str2) {
        return this.mOriginBridge.callUpdateFinish(str, bArr, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callUpdateStyle(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, HashMap<String, String> hashMap4) {
        return this.mOriginBridge.callUpdateStyle(str, str2, hashMap, hashMap2, hashMap3, hashMap4);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int createInstanceContext(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> createInstanceContext, instanceId is " + str + ", func is " + str3 + ", args is " + wXJSObjectArr);
        WXJSObject wXJSObject = wXJSObjectArr[0];
        WXJSObject wXJSObject2 = wXJSObjectArr[1];
        WXJSObject wXJSObject3 = wXJSObjectArr[2];
        doCreateInstanceContext(str, str2, WXBridgeManager.METHOD_CREATE_INSTANCE_CONTEXT, new WXJSObject[]{wXJSObject, wXJSObject3, wXJSObjectArr[3], wXJSObjectArr[4]});
        return doImportScript(str, str2, "importScript", new WXJSObject[]{wXJSObject, wXJSObject2, wXJSObject3});
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int destoryInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        return execJS(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int execJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> execJS, instanceId is " + str + ", func is " + str3 + ", args is " + wXJSObjectArr);
        ArrayList arrayList = new ArrayList();
        int length = wXJSObjectArr == null ? 0 : wXJSObjectArr.length;
        for (int i = 0; i < length; i++) {
            if (wXJSObjectArr[i] != null) {
                if (wXJSObjectArr[i].type != 2) {
                    arrayList.add(WXWsonJSONSwitch.convertWXJSObjectDataToJSON(wXJSObjectArr[i]));
                } else {
                    arrayList.add(wXJSObjectArr[i].data);
                }
            }
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.equals(str3, WXBridgeManager.METHOD_REGISTER_COMPONENTS) && !TextUtils.equals(str3, WXBridgeManager.METHOD_REGISTER_MODULES) && !TextUtils.equals(str3, WXBridgeManager.METHOD_DESTROY_INSTANCE)) {
            if (TextUtils.equals(str3, WXBridgeManager.METHOD_CREATE_INSTANCE)) {
                hashMap.put("method", WXBridgeManager.METHOD_CREATE_INSTANCE);
            } else {
                hashMap.put("method", WXDebugConstants.WEEX_CALL_JAVASCRIPT);
            }
        } else {
            hashMap.put("method", str3);
        }
        hashMap.put("args", arrayList);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("method", WXDebugConstants.METHOD_CALL_JS);
        hashMap2.put("params", hashMap);
        return sendMessage(JSON.toJSONString(hashMap2));
    }

    @Override // com.taobao.weex.common.IWXBridge
    public String execJSOnInstance(String str, String str2, int i) {
        return this.mOriginBridge.execJSOnInstance(str, str2, i);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int execJSService(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("method", WXDebugConstants.METHOD_IMPORT_JS);
        hashMap2.put("params", hashMap);
        return sendMessage(JSON.toJSONString(hashMap2));
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void execJSWithCallback(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, ResultCallback resultCallback) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> execJSWithCallback, instanceId is " + str + ", func is " + str3 + ", args is " + wXJSObjectArr);
        ArrayList arrayList = new ArrayList();
        int length = wXJSObjectArr == null ? 0 : wXJSObjectArr.length;
        for (int i = 0; i < length; i++) {
            if (wXJSObjectArr[i] != null) {
                if (wXJSObjectArr[i].type != 2) {
                    arrayList.add(WXWsonJSONSwitch.convertWXJSObjectDataToJSON(wXJSObjectArr[i]));
                } else {
                    arrayList.add(wXJSObjectArr[i].data);
                }
            }
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.equals(str3, WXBridgeManager.METHOD_REGISTER_COMPONENTS) && !TextUtils.equals(str3, WXBridgeManager.METHOD_REGISTER_MODULES) && !TextUtils.equals(str3, WXBridgeManager.METHOD_DESTROY_INSTANCE)) {
            hashMap.put("method", WXDebugConstants.WEEX_CALL_JAVASCRIPT);
        } else {
            hashMap.put("method", str3);
        }
        hashMap.put("args", arrayList);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("method", WXDebugConstants.METHOD_CALL_JS);
        hashMap2.put("params", hashMap);
        try {
            Response execute = this.client.newCall(new Request.Builder().url(this.syncCallJSURL).post(RequestBody.create(MEDIA_TYPE_MARKDOWN, JSON.toJSONString(hashMap2))).build()).execute();
            if (execute.isSuccessful()) {
                execute.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void forceLayout(String str) {
        this.mOriginBridge.forceLayout(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public long[] getFirstScreenRenderTime(String str) {
        return this.mOriginBridge.getFirstScreenRenderTime(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public ContentBoxMeasurement getMeasurementFunc(String str, long j) {
        return this.mOriginBridge.getMeasurementFunc(str, j);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public long[] getRenderFinishTime(String str) {
        return this.mOriginBridge.getRenderFinishTime(str);
    }

    public WXDebugJsBridge getWXDebugJsBridge() {
        return this.mWXDebugJsBridge;
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int initFramework(String str, WXParams wXParams) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> initFramework");
        while (true) {
            if (this.mSession == null || (this.mSession != null && !this.mSession.isOpen())) {
                synchronized (this.mLock) {
                    try {
                        Log.v(TAG, "waiting for session now");
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sendMessage(getInitFrameworkMessage(str, wXParams));
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int initFrameworkEnv(String str, WXParams wXParams, String str2, boolean z) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> initFrameworkEnv");
        return initFramework(str, wXParams);
    }

    public boolean isSessionActive() {
        return this.mSession != null && this.mSession.isOpen();
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void markDirty(String str, String str2, boolean z) {
        this.mOriginBridge.markDirty(str, str2, z);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public boolean notifyLayout(String str) {
        return this.mOriginBridge.notifyLayout(str);
    }

    public void onConnected() {
        Log.v(TAG, "connect to debug server success");
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }

    public void onDisConnected() {
        Log.w(TAG, "WebSocket disconnected");
        synchronized (this.mLock) {
            this.mSession = null;
            this.mLock.notify();
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void onInstanceClose(String str) {
        this.mOriginBridge.onInstanceClose(str);
    }

    public void post(Runnable runnable) {
        if (this.mSession == null || !this.mSession.isOpen()) {
            return;
        }
        this.mSession.post(runnable);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void refreshInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> refreshInstance, instanceId is " + str);
        this.mOriginBridge.refreshInstance(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void registerCoreEnv(String str, String str2) {
        this.mOriginBridge.registerCoreEnv(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void removeInstanceRenderType(String str) {
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void reportJSException(String str, String str2, String str3) {
        this.mOriginBridge.reportJSException(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void reportNativeInitStatus(String str, String str2) {
        this.mOriginBridge.reportNativeInitStatus(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void reportServerCrash(String str, String str2) {
        LogUtil.e("ServerCrash: instanceId: " + str + ", crashFile: " + str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void resetWXBridge(boolean z) {
        this.mWXDebugJsBridge.resetWXBridge(this, getClass().getName().replace('.', r10.DIR));
    }

    public void sendToRemote(String str) {
        if (this.mSession == null || !this.mSession.isOpen()) {
            return;
        }
        this.mSession.sendText(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setDefaultHeightAndWidthIntoRootDom(String str, float f, float f2, boolean z, boolean z2) {
        this.mOriginBridge.setDefaultHeightAndWidthIntoRootDom(str, f, f2, z, z2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setDeviceDisplay(String str, float f, float f2, float f3) {
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setInstanceRenderType(String str, String str2) {
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setJSFrmVersion(String str) {
        this.mOriginBridge.setJSFrmVersion(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setMargin(String str, String str2, CSSShorthand.EDGE edge, float f) {
        this.mOriginBridge.setMargin(str, str2, edge, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPadding(String str, String str2, CSSShorthand.EDGE edge, float f) {
        this.mOriginBridge.setPadding(str, str2, edge, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPageArgument(String str, String str2, String str3) {
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPosition(String str, String str2, CSSShorthand.EDGE edge, float f) {
        this.mOriginBridge.setPosition(str, str2, edge, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setRenderContainerWrapContent(boolean z, String str) {
        this.mOriginBridge.setRenderContainerWrapContent(z, str);
    }

    public void setSession(SimpleSession simpleSession) {
        this.mSession = simpleSession;
        if (this.mSession instanceof SocketClient) {
            String[] split = ((SocketClient) this.mSession).getUrl().split("debugProxy/native");
            if (split.length < 2) {
                return;
            }
            this.syncCallJSURL = split[0] + "syncCallJS" + split[1];
            StringBuilder sb = new StringBuilder();
            sb.append("http://");
            sb.append(this.syncCallJSURL.split(jg1.SCHEME_SLASH)[1]);
            this.syncCallJSURL = sb.toString();
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setStyleHeight(String str, String str2, float f) {
        this.mOriginBridge.setStyleHeight(str, str2, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setStyleWidth(String str, String str2, float f) {
        this.mOriginBridge.setStyleWidth(str, str2, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setTimeoutNative(String str, String str2) {
        this.mOriginBridge.setTimeoutNative(str, str2);
    }

    public void setWXDebugJsBridge(WXDebugJsBridge wXDebugJsBridge) {
        this.mWXDebugJsBridge = wXDebugJsBridge;
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void takeHeapSnapshot(String str) {
        LogUtil.log(YKActionSheet.ACTION_STYLE_WARNING, "Ignore invoke takeSnapshot: " + str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void updateInitFrameworkParams(String str, String str2, String str3) {
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callNative(String str, String str2, String str3) {
        WXLogUtils.e(TAG, "WXDebugBridge >>>> callNative, instanceId is " + str + ", tasks is " + str2);
        return this.mOriginBridge.callNative(str, str2, str3);
    }
}
