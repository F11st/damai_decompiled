package com.taobao.weex.bridge;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.base.CalledByNative;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.IWXBridge;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXJsonUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXWsonJSONSwitch;
import com.taobao.weex.utils.tools.TimeCalculator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXBridge implements IWXBridge {
    public static final boolean MULTIPROCESS = true;
    public static final String TAG = "WXBridge";

    private native void nativeBindMeasurementToRenderObject(long j);

    private native int nativeExecJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    private native int nativeExecJSService(String str);

    private native void nativeForceLayout(String str);

    private native int nativeInitFramework(String str, WXParams wXParams);

    private native int nativeInitFrameworkEnv(String str, WXParams wXParams, String str2, boolean z);

    private native void nativeMarkDirty(String str, String str2, boolean z);

    private native boolean nativeNotifyLayout(String str);

    private native void nativeOnInstanceClose(String str);

    private native void nativeRefreshInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    private native void nativeRegisterCoreEnv(String str, String str2);

    private native void nativeReloadPageLayout(String str);

    private native void nativeRemoveInstanceRenderType(String str);

    private native void nativeResetWXBridge(Object obj, String str);

    private native void nativeSetDefaultHeightAndWidthIntoRootDom(String str, float f, float f2, boolean z, boolean z2);

    private native void nativeSetDeviceDisplay(String str, float f, float f2, float f3);

    private native void nativeSetDeviceDisplayOfPage(String str, float f, float f2);

    private native void nativeSetInstanceRenderType(String str, String str2);

    private native void nativeSetLogType(float f, float f2);

    private native void nativeSetMargin(String str, String str2, int i, float f);

    private native void nativeSetPadding(String str, String str2, int i, float f);

    private native void nativeSetPageArgument(String str, String str2, String str3);

    private native void nativeSetPosition(String str, String str2, int i, float f);

    private native void nativeSetRenderContainerWrapContent(boolean z, String str);

    private native void nativeSetStyleHeight(String str, String str2, float f);

    private native void nativeSetStyleWidth(String str, String str2, float f);

    private native void nativeSetViewPortWidth(String str, float f);

    private native void nativeTakeHeapSnapshot(String str);

    private native void nativeUpdateInitFrameworkParams(String str, String str2, String str3);

    @Override // com.taobao.weex.common.IWXBridge
    public void bindMeasurementToRenderObject(long j) {
        nativeBindMeasurementToRenderObject(j);
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callAddChildToRichtext(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        try {
            return WXBridgeManager.getInstance().callAddChildToRichtext(str, str2, str3, str4, str5, hashMap, hashMap2);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callAddChildToRichtext throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callAddElement(String str, String str2, String str3, int i, String str4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3, boolean z) {
        try {
            return WXBridgeManager.getInstance().callAddElement(str, str2, str3, i, str4, hashMap, hashMap2, hashSet, fArr, fArr2, fArr3, z);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                th.printStackTrace();
                WXLogUtils.e(TAG, "callAddElement throw error:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callAddEvent(String str, String str2, String str3) {
        try {
            return WXBridgeManager.getInstance().callAddEvent(str, str2, str3);
        } catch (Throwable th) {
            WXLogUtils.e(TAG, "callAddEvent throw exception:" + WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callAppendTreeCreateFinish(String str, String str2) {
        try {
            return WXBridgeManager.getInstance().callAppendTreeCreateFinish(str, str2);
        } catch (Throwable th) {
            WXLogUtils.e(TAG, "callAppendTreeCreateFinish throw exception:" + WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callCreateBody(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3) {
        try {
            return WXBridgeManager.getInstance().callCreateBody(str, str2, str3, hashMap, hashMap2, hashSet, fArr, fArr2, fArr3);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callCreateBody throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callCreateFinish(String str) {
        try {
            return WXBridgeManager.getInstance().callCreateFinish(str);
        } catch (Throwable th) {
            WXLogUtils.e(TAG, "callCreateFinish throw exception:" + WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callHasTransitionPros(String str, String str2, HashMap<String, String> hashMap) {
        try {
            return WXBridgeManager.getInstance().callHasTransitionPros(str, str2, hashMap);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callHasTransitionPros throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callLayout(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7) {
        try {
            return WXBridgeManager.getInstance().callLayout(str, str2, i, i2, i3, i4, i5, i6, z, i7);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callLayout throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callMoveElement(String str, String str2, String str3, int i) {
        try {
            return WXBridgeManager.getInstance().callMoveElement(str, str2, str3, i);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callMoveElement throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callNative(String str, byte[] bArr, String str2) {
        if ("HeartBeat".equals(str2)) {
            Log.e("HeartBeat instanceId", str);
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y != null) {
                y.createInstanceFuncHeartBeat();
                return 1;
            }
            return 1;
        }
        return callNative(str, JSON.parseArray(new String(bArr)), str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public void callNativeComponent(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        WXStateRecord d = WXStateRecord.d();
        d.i(str, "callNativeComponent:" + str3);
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            JSONArray jSONArray = null;
            if (bArr != null) {
                if (y != null && (y.getRenderStrategy() == WXRenderStrategy.DATA_RENDER || y.getRenderStrategy() == WXRenderStrategy.DATA_RENDER_BINARY || y.getReactorPage() != null)) {
                    try {
                        jSONArray = (JSONArray) JSON.parse(new String(bArr, "UTF-8"));
                    } catch (Exception unused) {
                        jSONArray = (JSONArray) WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                    }
                } else {
                    jSONArray = (JSONArray) WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                }
            }
            Object parseWsonOrJSON = WXWsonJSONSwitch.parseWsonOrJSON(bArr2);
            WXBridgeManager.getInstance().callNativeComponent(str, str2, str3, jSONArray, parseWsonOrJSON);
        } catch (Exception e) {
            WXLogUtils.e(TAG, e);
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public Object callNativeModule(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        WXSDKInstance y;
        JSONArray jSONArray2;
        try {
            WXStateRecord.d().i(str, "callNativeModule:" + str2 + "." + str3);
            long fixUnixTime = WXUtils.getFixUnixTime();
            WXSDKInstance y2 = WXSDKManager.v().y(str);
            if (bArr != null) {
                if (y2 != null && (y2.getRenderStrategy() == WXRenderStrategy.DATA_RENDER || y2.getRenderStrategy() == WXRenderStrategy.DATA_RENDER_BINARY || y2.getReactorPage() != null)) {
                    try {
                        jSONArray = (JSONArray) JSON.parse(new String(bArr, "UTF-8"));
                    } catch (Exception unused) {
                        jSONArray2 = (JSONArray) WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                    }
                } else {
                    jSONArray2 = (JSONArray) WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                }
                jSONArray = jSONArray2;
            } else {
                jSONArray = null;
            }
            if (bArr2 != null) {
                jSONObject = (JSONObject) WXWsonJSONSwitch.parseWsonOrJSON(bArr2);
            } else {
                if (jSONArray != null && (y = WXSDKManager.v().y(str)) != null && WXBridgeManager.BundType.Rax.equals(y.bundleType)) {
                    Iterator<Object> it = jSONArray.iterator();
                    Object obj = null;
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof JSONObject) && ((JSONObject) next).containsKey("__weex_options__")) {
                            obj = ((JSONObject) next).get("__weex_options__");
                        }
                    }
                    if (obj instanceof JSONObject) {
                        jSONObject = (JSONObject) obj;
                    }
                }
                jSONObject = null;
            }
            Object callNativeModule = WXBridgeManager.getInstance().callNativeModule(str, str2, str3, jSONArray, jSONObject);
            if (y2 != null) {
                y2.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_NATIVE_NUM, 1.0d);
                y2.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_NATIVE_TIME, WXUtils.getFixUnixTime() - fixUnixTime);
            }
            if (y2 != null && (y2.getRenderStrategy() == WXRenderStrategy.DATA_RENDER || y2.getRenderStrategy() == WXRenderStrategy.DATA_RENDER_BINARY)) {
                try {
                    if (callNativeModule == null) {
                        return new WXJSObject(null);
                    }
                    if (callNativeModule.getClass() == WXJSObject.class) {
                        return (WXJSObject) callNativeModule;
                    }
                    return new WXJSObject(3, WXJsonUtils.fromObjectToJSONString(callNativeModule));
                } catch (Exception unused2) {
                    return WXWsonJSONSwitch.toWsonOrJsonWXJSObject(callNativeModule);
                }
            }
            return WXWsonJSONSwitch.toWsonOrJsonWXJSObject(callNativeModule);
        } catch (Exception e) {
            WXLogUtils.e(TAG, e);
            return new WXJSObject(null);
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callRefreshFinish(String str, byte[] bArr, String str2) {
        try {
            return WXBridgeManager.getInstance().callRefreshFinish(str, str2);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callCreateFinish throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callRemoveChildFromRichtext(String str, String str2, String str3, String str4) {
        try {
            return WXBridgeManager.getInstance().callRemoveChildFromRichtext(str, str2, str3, str4);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callRemoveChildFromRichtext throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callRemoveElement(String str, String str2) {
        try {
            return WXBridgeManager.getInstance().callRemoveElement(str, str2);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callRemoveElement throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callRemoveEvent(String str, String str2, String str3) {
        try {
            return WXBridgeManager.getInstance().callRemoveEvent(str, str2, str3);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callRemoveEvent throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callRenderSuccess(String str) {
        try {
            return WXBridgeManager.getInstance().callRenderSuccess(str);
        } catch (Throwable th) {
            WXLogUtils.e(TAG, "callCreateFinish throw exception:" + WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callUpdateAttrs(String str, String str2, HashMap<String, String> hashMap) {
        try {
            return WXBridgeManager.getInstance().callUpdateAttrs(str, str2, hashMap);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callUpdateAttr throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callUpdateFinish(String str, byte[] bArr, String str2) {
        try {
            return WXBridgeManager.getInstance().callUpdateFinish(str, str2);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callCreateBody throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callUpdateRichtextChildAttr(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        try {
            return WXBridgeManager.getInstance().callUpdateRichtextChildAttr(str, str2, hashMap, str3, str4);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callUpdateRichtextChildAttr throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callUpdateRichtextStyle(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        try {
            return WXBridgeManager.getInstance().callUpdateRichtextStyle(str, str2, hashMap, str3, str4);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callUpdateRichtextStyle throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public int callUpdateStyle(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, HashMap<String, String> hashMap4) {
        try {
            return WXBridgeManager.getInstance().callUpdateStyle(str, str2, hashMap, hashMap2, hashMap3, hashMap4);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "callUpdateStyle throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int createInstanceContext(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        Log.e(TimeCalculator.TIMELINE_TAG, "createInstance :" + System.currentTimeMillis());
        WXStateRecord.d().i(str, "createInstanceContext:");
        return nativeCreateInstanceContext(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int destoryInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        WXStateRecord.d().i(str, "destoryInstance:");
        return nativeDestoryInstance(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int execJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        WXStateRecord d = WXStateRecord.d();
        d.i(str, "execJS:" + str2 + "," + str3);
        return nativeExecJS(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public String execJSOnInstance(String str, String str2, int i) {
        WXStateRecord d = WXStateRecord.d();
        d.i(str, "execJSOnInstance:" + i);
        return nativeExecJSOnInstance(str, str2, i);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int execJSService(String str) {
        WXStateRecord.d().i("execJSService", "execJSService:");
        return nativeExecJSService(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void execJSWithCallback(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, ResultCallback resultCallback) {
        WXStateRecord d = WXStateRecord.d();
        d.i(str, "execJSWithCallback:" + str2 + "," + str3);
        if (resultCallback == null) {
            execJS(str, str2, str3, wXJSObjectArr);
        }
        nativeExecJSWithCallback(str, str2, str3, wXJSObjectArr, ResultCallbackManager.generateCallbackId(resultCallback));
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void forceLayout(String str) {
        nativeForceLayout(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public long[] getFirstScreenRenderTime(String str) {
        return nativeGetFirstScreenRenderTime(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public ContentBoxMeasurement getMeasurementFunc(String str, long j) {
        try {
            return WXBridgeManager.getInstance().getMeasurementFunc(str, j);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "getMeasurementFunc throw exception:" + WXLogUtils.getStackTrace(th));
            }
            return null;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public long[] getRenderFinishTime(String str) {
        return nativeGetRenderFinishTime(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int initFramework(String str, WXParams wXParams) {
        return nativeInitFramework(str, wXParams);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int initFrameworkEnv(String str, WXParams wXParams, String str2, boolean z) {
        WXStateRecord.d().i("", "nativeInitFrameworkEnv:");
        return nativeInitFrameworkEnv(str, wXParams, str2, z);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void markDirty(String str, String str2, boolean z) {
        nativeMarkDirty(str, str2, z);
    }

    public native int nativeCreateInstanceContext(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    public native int nativeDestoryInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    public native String nativeDumpIpcPageQueueInfo();

    public native String nativeExecJSOnInstance(String str, String str2, int i);

    public native void nativeExecJSWithCallback(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, long j);

    public native byte[] nativeExecJSWithResult(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    public native long[] nativeGetFirstScreenRenderTime(String str);

    public native long[] nativeGetRenderFinishTime(String str);

    public native void nativeOnInteractionTimeUpdate(String str);

    public native void nativeUpdateGlobalConfig(String str);

    @Override // com.taobao.weex.common.IWXBridge
    public boolean notifyLayout(String str) {
        return nativeNotifyLayout(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void onInstanceClose(String str) {
        nativeOnInstanceClose(str);
    }

    @CalledByNative
    public void onNativePerformanceDataUpdate(String str, Map<String, String> map) {
        WXSDKInstance wXSDKInstance;
        if (TextUtils.isEmpty(str) || map == null || map.size() < 1 || (wXSDKInstance = WXSDKManager.v().i().get(str)) == null || wXSDKInstance.getApmForInstance() == null) {
            return;
        }
        wXSDKInstance.getApmForInstance().E(map);
    }

    @CalledByNative
    public void onReceivedResult(long j, byte[] bArr) {
        WXStateRecord d = WXStateRecord.d();
        d.i("onReceivedResult", "callbackId" + j);
        ResultCallback removeCallbackById = ResultCallbackManager.removeCallbackById(j);
        if (removeCallbackById != null) {
            removeCallbackById.onReceiveResult(bArr);
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void refreshInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        WXStateRecord d = WXStateRecord.d();
        d.i(str, "refreshInstance:" + str2 + "," + str3);
        nativeRefreshInstance(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void registerCoreEnv(String str, String str2) {
        nativeRegisterCoreEnv(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void reloadPageLayout(String str) {
        nativeReloadPageLayout(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void removeInstanceRenderType(String str) {
        nativeRemoveInstanceRenderType(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public void reportJSException(String str, String str2, String str3) {
        WXBridgeManager.getInstance().reportJSException(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public void reportNativeInitStatus(String str, String str2) {
        WXErrorCode[] values;
        if (!WXErrorCode.WX_JS_FRAMEWORK_INIT_SINGLE_PROCESS_SUCCESS.getErrorCode().equals(str) && !WXErrorCode.WX_JS_FRAMEWORK_INIT_FAILED.getErrorCode().equals(str)) {
            WXErrorCode wXErrorCode = WXErrorCode.WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL;
            if (wXErrorCode.getErrorCode().equals(str)) {
                WXExceptionUtils.commitCriticalExceptionRT(null, wXErrorCode, "WeexProxy::initFromParam()", wXErrorCode.getErrorMsg() + ": " + str2, null);
                return;
            }
            for (WXErrorCode wXErrorCode2 : WXErrorCode.values()) {
                if (wXErrorCode2.getErrorType().equals(WXErrorCode.ErrorType.NATIVE_ERROR) && wXErrorCode2.getErrorCode().equals(str)) {
                    WXExceptionUtils.commitCriticalExceptionRT(null, wXErrorCode2, IWXUserTrackAdapter.INIT_FRAMEWORK, str2, null);
                    return;
                }
            }
            return;
        }
        IWXUserTrackAdapter t = WXSDKManager.v().t();
        if (t != null) {
            HashMap hashMap = new HashMap(3);
            hashMap.put("errCode", str);
            hashMap.put("arg", "InitFrameworkNativeError");
            hashMap.put("errMsg", str2);
            WXLogUtils.e("reportNativeInitStatus is running and errorCode is " + str + " And errorMsg is " + str2);
            t.commit(null, null, IWXUserTrackAdapter.INIT_FRAMEWORK, null, hashMap);
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public void reportServerCrash(String str, String str2) {
        WXLogUtils.e(TAG, "reportServerCrash instanceId:" + str + " crashFile: " + str2);
        try {
            WXBridgeManager.getInstance().callReportCrashReloadPage(str, str2);
        } catch (Throwable th) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "reloadPageNative throw exception:" + WXLogUtils.getStackTrace(th));
            }
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void resetWXBridge(boolean z) {
        nativeResetWXBridge(this, getClass().getName().replace('.', r10.DIR));
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setDefaultHeightAndWidthIntoRootDom(String str, float f, float f2, boolean z, boolean z2) {
        nativeSetDefaultHeightAndWidthIntoRootDom(str, f, f2, z, z2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setDeviceDisplay(String str, float f, float f2, float f3) {
        nativeSetDeviceDisplay(str, f, f2, f3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setDeviceDisplayOfPage(String str, float f, float f2) {
        nativeSetDeviceDisplayOfPage(str, f, f2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setInstanceRenderType(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        nativeSetInstanceRenderType(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public void setJSFrmVersion(String str) {
        if (str != null) {
            WXEnvironment.JS_LIB_SDK_VERSION = str;
        }
        WXStateRecord.d().h();
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setLogType(float f, boolean z) {
        Log.e("WeexCore", "setLog" + WXEnvironment.sLogLevel.getValue() + "isPerf : " + z);
        nativeSetLogType(f, z ? 1.0f : 0.0f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setMargin(String str, String str2, CSSShorthand.EDGE edge, float f) {
        nativeSetMargin(str, str2, edge.ordinal(), f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPadding(String str, String str2, CSSShorthand.EDGE edge, float f) {
        nativeSetPadding(str, str2, edge.ordinal(), f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPageArgument(String str, String str2, String str3) {
        nativeSetPageArgument(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public void setPageDirty(String str, boolean z) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null) {
            y.setPageDirty(z);
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPosition(String str, String str2, CSSShorthand.EDGE edge, float f) {
        nativeSetPosition(str, str2, edge.ordinal(), f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setRenderContainerWrapContent(boolean z, String str) {
        nativeSetRenderContainerWrapContent(z, str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setStyleHeight(String str, String str2, float f) {
        nativeSetStyleHeight(str, str2, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setStyleWidth(String str, String str2, float f) {
        nativeSetStyleWidth(str, str2, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    @CalledByNative
    public void setTimeoutNative(String str, String str2) {
        WXBridgeManager.getInstance().setTimeout(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setViewPortWidth(String str, float f) {
        nativeSetViewPortWidth(str, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void takeHeapSnapshot(String str) {
        nativeTakeHeapSnapshot(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void updateInitFrameworkParams(String str, String str2, String str3) {
        WXStateRecord.d().i("", "updateInitFrameworkParams:");
        nativeUpdateInitFrameworkParams(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callNative(String str, String str2, String str3) {
        try {
            return callNative(str, JSON.parseArray(str2), str3);
        } catch (Exception e) {
            WXLogUtils.e(TAG, "callNative throw exception: " + WXLogUtils.getStackTrace(e));
            return 1;
        }
    }

    private int callNative(String str, JSONArray jSONArray, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null) {
            y.firstScreenCreateInstanceTime(currentTimeMillis);
        }
        int i = 1;
        try {
            i = WXBridgeManager.getInstance().callNative(str, jSONArray, str2);
        } catch (Throwable th) {
            WXLogUtils.e(TAG, "callNative throw exception:" + WXLogUtils.getStackTrace(th));
        }
        if (WXEnvironment.isApkDebugable() && i == -1) {
            WXLogUtils.w("destroyInstance :" + str + " JSF must stop callNative");
        }
        return i;
    }
}
