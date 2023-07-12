package com.taobao.weex.bridge;

import com.alibaba.fastjson.JSON;
import com.taobao.weex.utils.WXWsonJSONSwitch;
import tb.x13;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXDebugJsBridge {
    public void jsHandleCallAddElement(String str, String str2, String str3, String str4) {
        jsHandleCallAddElement(str, str2, x13.a(JSON.parse(str3)), str4, true);
    }

    public native void jsHandleCallAddElement(String str, String str2, byte[] bArr, String str3, boolean z);

    public native void jsHandleCallAddEvent(String str, String str2, String str3);

    public void jsHandleCallCreateBody(String str, String str2) {
        jsHandleCallCreateBody(str, x13.a(JSON.parse(str2)), true);
    }

    public native void jsHandleCallCreateBody(String str, byte[] bArr, boolean z);

    public native void jsHandleCallCreateFinish(String str);

    public native void jsHandleCallGCanvasLinkNative(String str, int i, String str2);

    public native void jsHandleCallMoveElement(String str, String str2, String str3, String str4);

    public native void jsHandleCallNative(String str, byte[] bArr, String str2);

    public void jsHandleCallNativeComponent(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        jsHandleCallNativeComponent(str, str2, str3, WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bArr), WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bArr2), true);
    }

    public native void jsHandleCallNativeComponent(String str, String str2, String str3, byte[] bArr, byte[] bArr2, boolean z);

    public native void jsHandleCallNativeLog(byte[] bArr);

    public void jsHandleCallNativeModule(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        jsHandleCallNativeModule(str, str2, str3, WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bArr), WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bArr2), true);
    }

    public native void jsHandleCallNativeModule(String str, String str2, String str3, byte[] bArr, byte[] bArr2, boolean z);

    public native void jsHandleCallRefreshFinish(String str, byte[] bArr, String str2);

    public native void jsHandleCallRemoveElement(String str, String str2);

    public native void jsHandleCallRemoveEvent(String str, String str2, String str3);

    public void jsHandleCallUpdateAttrs(String str, String str2, String str3) {
        jsHandleCallUpdateAttrs(str, str2, x13.a(JSON.parseObject(str3)), true);
    }

    public native void jsHandleCallUpdateAttrs(String str, String str2, byte[] bArr, boolean z);

    public native void jsHandleCallUpdateFinish(String str, byte[] bArr, String str2);

    public void jsHandleCallUpdateStyle(String str, String str2, String str3) {
        jsHandleCallUpdateStyleNative(str, str2, x13.a(JSON.parseObject(str3)), true);
    }

    public native void jsHandleCallUpdateStyleNative(String str, String str2, byte[] bArr, boolean z);

    public native void jsHandleClearInterval(String str, String str2);

    public native void jsHandleReportException(String str, String str2, String str3);

    public native void jsHandleSetInterval(String str, String str2, String str3);

    public native void jsHandleSetJSVersion(String str);

    public native void jsHandleSetTimeout(String str, String str2);

    public native void resetWXBridge(Object obj, String str);
}
