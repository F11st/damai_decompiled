package com.taobao.weex;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXGlobalEventModule extends WXModule {
    @JSMethod
    public void addEventListener(String str, String str2) {
        this.mWXSDKInstance.addEventListener(str, str2);
    }

    public void removeEventListener(String str, String str2) {
        this.mWXSDKInstance.removeEventListener(str, str2);
    }

    @Override // com.taobao.weex.common.WXModule
    public void addEventListener(String str, String str2, Map<String, Object> map) {
        super.addEventListener(str, str2, map);
        addEventListener(str, str2);
    }

    @JSMethod
    public void removeEventListener(String str) {
        this.mWXSDKInstance.removeEventListener(str);
    }
}
