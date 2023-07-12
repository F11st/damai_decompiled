package com.alibaba.aliweex.adapter.module;

import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.adapter.IEventModuleAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXEventModule extends WXModule {
    @JSMethod
    public void openURL(String str) {
        IEventModuleAdapter f = C3004a.l().f();
        if (f != null) {
            f.openURL(this.mWXSDKInstance.getContext(), str);
        }
    }
}
