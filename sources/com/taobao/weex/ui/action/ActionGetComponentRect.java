package com.taobao.weex.ui.action;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.SimpleJSCallback;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ActionGetComponentRect extends BasicGraphicAction {
    private final String mCallback;

    public ActionGetComponentRect(WXSDKInstance wXSDKInstance, String str, String str2) {
        super(wXSDKInstance, str);
        this.mCallback = str2;
    }

    private void callbackViewport(WXSDKInstance wXSDKInstance, JSCallback jSCallback) {
        View containerView = wXSDKInstance.getContainerView();
        if (containerView != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            wXSDKInstance.getContainerView().getLocationOnScreen(new int[2]);
            int instanceViewPortWidth = wXSDKInstance.getInstanceViewPortWidth();
            hashMap2.put("left", Float.valueOf(0.0f));
            hashMap2.put("top", Float.valueOf(0.0f));
            hashMap2.put("right", Float.valueOf(getWebPxValue(containerView.getWidth(), instanceViewPortWidth)));
            hashMap2.put("bottom", Float.valueOf(getWebPxValue(containerView.getHeight(), instanceViewPortWidth)));
            hashMap2.put("width", Float.valueOf(getWebPxValue(containerView.getWidth(), instanceViewPortWidth)));
            hashMap2.put("height", Float.valueOf(getWebPxValue(containerView.getHeight(), instanceViewPortWidth)));
            hashMap.put("size", hashMap2);
            hashMap.put("result", Boolean.TRUE);
            jSCallback.invoke(hashMap);
            return;
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("result", Boolean.FALSE);
        hashMap3.put("errMsg", "Component does not exist");
        jSCallback.invoke(hashMap3);
    }

    @NonNull
    private float getWebPxValue(int i, int i2) {
        return WXViewUtils.getWebPxByWidth(i, i2);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.isDestroy()) {
            return;
        }
        JSCallback simpleJSCallback = new SimpleJSCallback(wXSDKIntance.getInstanceId(), this.mCallback);
        if (TextUtils.isEmpty(getRef())) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", Boolean.FALSE);
            hashMap.put("errMsg", "Illegal parameter");
            simpleJSCallback.invoke(hashMap);
        } else if ("viewport".equalsIgnoreCase(getRef())) {
            callbackViewport(wXSDKIntance, simpleJSCallback);
        } else {
            WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
            if (wXComponent == null) {
                return;
            }
            HashMap hashMap2 = new HashMap();
            int instanceViewPortWidth = wXSDKIntance.getInstanceViewPortWidth();
            HashMap hashMap3 = new HashMap();
            Rect componentSize = wXComponent.getComponentSize();
            hashMap3.put("width", Float.valueOf(getWebPxValue(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(componentSize), instanceViewPortWidth)));
            hashMap3.put("height", Float.valueOf(getWebPxValue(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(componentSize), instanceViewPortWidth)));
            hashMap3.put("bottom", Float.valueOf(getWebPxValue(componentSize.bottom, instanceViewPortWidth)));
            hashMap3.put("left", Float.valueOf(getWebPxValue(componentSize.left, instanceViewPortWidth)));
            hashMap3.put("right", Float.valueOf(getWebPxValue(componentSize.right, instanceViewPortWidth)));
            hashMap3.put("top", Float.valueOf(getWebPxValue(componentSize.top, instanceViewPortWidth)));
            hashMap2.put("size", hashMap3);
            hashMap2.put("result", Boolean.TRUE);
            simpleJSCallback.invoke(hashMap2);
        }
    }
}
