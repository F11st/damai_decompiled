package com.taobao.weex.ui.module;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXDeviceInfoModule extends WXModule {
    @JSMethod(uiThread = false)
    public void enableFullScreenHeight(JSCallback jSCallback, JSONObject jSONObject) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.setEnableFullScreenHeight(true);
            if (jSCallback != null) {
                long screenHeight = WXViewUtils.getScreenHeight(this.mWXSDKInstance.getInstanceId());
                HashMap hashMap = new HashMap();
                hashMap.put("fullScreenHeight", String.valueOf(screenHeight));
                jSCallback.invoke(hashMap);
            }
        }
    }
}
