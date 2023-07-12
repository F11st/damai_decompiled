package com.taobao.weex.common;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXInstanceWrap extends WXModule {
    @JSMethod
    public void error(String str, String str2, String str3) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            if (str3 != null && str3.contains("downgrade_to_root")) {
                while (wXSDKInstance.getParentInstance() != null) {
                    wXSDKInstance = wXSDKInstance.getParentInstance();
                }
            }
            wXSDKInstance.onRenderError(str + "|" + str2, str3);
        }
    }
}
