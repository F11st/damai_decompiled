package com.taobao.weex.ui.action;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.SimpleJSCallback;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ActionGetLayoutDirection extends BasicGraphicAction {
    private final String mCallback;

    public ActionGetLayoutDirection(WXSDKInstance wXSDKInstance, String str, String str2) {
        super(wXSDKInstance, str);
        this.mCallback = str2;
    }

    private void callbackViewport(WXSDKInstance wXSDKInstance, JSCallback jSCallback) {
        if (wXSDKInstance.getContainerView() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("direction", "ltr");
            hashMap.put("result", Boolean.TRUE);
            jSCallback.invoke(hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", Boolean.FALSE);
        hashMap2.put("errMsg", "Component does not exist");
        jSCallback.invoke(hashMap2);
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
            int nativeRenderObjectGetLayoutDirectionFromPathNode = NativeRenderObjectUtils.nativeRenderObjectGetLayoutDirectionFromPathNode(wXComponent.getRenderObjectPtr());
            Object obj = "ltr";
            if (nativeRenderObjectGetLayoutDirectionFromPathNode == 0) {
                obj = "inherit";
            } else if (nativeRenderObjectGetLayoutDirectionFromPathNode != 1 && nativeRenderObjectGetLayoutDirectionFromPathNode == 2) {
                obj = Constants.Name.RTL;
            }
            simpleJSCallback.invoke(obj);
        }
    }
}
