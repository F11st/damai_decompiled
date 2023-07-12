package com.taobao.weex.common;

import com.taobao.weex.bridge.ResultCallback;
import com.taobao.weex.bridge.WXJSObject;
import com.taobao.weex.bridge.WXParams;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.layout.ContentBoxMeasurement;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWXBridge extends IWXObject {
    public static final int DESTROY_INSTANCE = -1;
    public static final int INSTANCE_RENDERING = 1;
    public static final int INSTANCE_RENDERING_ERROR = 0;

    void bindMeasurementToRenderObject(long j);

    int callAddChildToRichtext(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, HashMap<String, String> hashMap2);

    int callAddElement(String str, String str2, String str3, int i, String str4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3, boolean z);

    int callAddEvent(String str, String str2, String str3);

    int callAppendTreeCreateFinish(String str, String str2);

    int callCreateBody(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3);

    int callCreateFinish(String str);

    int callHasTransitionPros(String str, String str2, HashMap<String, String> hashMap);

    int callLayout(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7);

    int callMoveElement(String str, String str2, String str3, int i);

    int callNative(String str, String str2, String str3);

    int callNative(String str, byte[] bArr, String str2);

    void callNativeComponent(String str, String str2, String str3, byte[] bArr, byte[] bArr2);

    Object callNativeModule(String str, String str2, String str3, byte[] bArr, byte[] bArr2);

    int callRefreshFinish(String str, byte[] bArr, String str2);

    int callRemoveChildFromRichtext(String str, String str2, String str3, String str4);

    int callRemoveElement(String str, String str2);

    int callRemoveEvent(String str, String str2, String str3);

    int callRenderSuccess(String str);

    int callUpdateAttrs(String str, String str2, HashMap<String, String> hashMap);

    int callUpdateFinish(String str, byte[] bArr, String str2);

    int callUpdateRichtextChildAttr(String str, String str2, HashMap<String, String> hashMap, String str3, String str4);

    int callUpdateRichtextStyle(String str, String str2, HashMap<String, String> hashMap, String str3, String str4);

    int callUpdateStyle(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, HashMap<String, String> hashMap4);

    int createInstanceContext(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    int destoryInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    int execJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    String execJSOnInstance(String str, String str2, int i);

    int execJSService(String str);

    void execJSWithCallback(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, ResultCallback resultCallback);

    void forceLayout(String str);

    long[] getFirstScreenRenderTime(String str);

    ContentBoxMeasurement getMeasurementFunc(String str, long j);

    long[] getRenderFinishTime(String str);

    int initFramework(String str, WXParams wXParams);

    int initFrameworkEnv(String str, WXParams wXParams, String str2, boolean z);

    void markDirty(String str, String str2, boolean z);

    boolean notifyLayout(String str);

    void onInstanceClose(String str);

    void refreshInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    void registerCoreEnv(String str, String str2);

    void reloadPageLayout(String str);

    void removeInstanceRenderType(String str);

    void reportJSException(String str, String str2, String str3);

    void reportNativeInitStatus(String str, String str2);

    void reportServerCrash(String str, String str2);

    void resetWXBridge(boolean z);

    void setDefaultHeightAndWidthIntoRootDom(String str, float f, float f2, boolean z, boolean z2);

    void setDeviceDisplay(String str, float f, float f2, float f3);

    void setDeviceDisplayOfPage(String str, float f, float f2);

    void setInstanceRenderType(String str, String str2);

    void setJSFrmVersion(String str);

    void setLogType(float f, boolean z);

    void setMargin(String str, String str2, CSSShorthand.EDGE edge, float f);

    void setPadding(String str, String str2, CSSShorthand.EDGE edge, float f);

    void setPageArgument(String str, String str2, String str3);

    void setPageDirty(String str, boolean z);

    void setPosition(String str, String str2, CSSShorthand.EDGE edge, float f);

    void setRenderContainerWrapContent(boolean z, String str);

    void setStyleHeight(String str, String str2, float f);

    void setStyleWidth(String str, String str2, float f);

    void setTimeoutNative(String str, String str2);

    void setViewPortWidth(String str, float f);

    void takeHeapSnapshot(String str);

    void updateInitFrameworkParams(String str, String str2, String str3);
}
