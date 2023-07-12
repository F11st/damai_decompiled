package com.alibaba.aliweex.adapter.module;

import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.adapter.IPageInfoModuleAdapter;
import com.alibaba.aliweex.adapter.ITBPageInfoModuleAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXPageInfoModule extends WXModule {
    @JSMethod
    public void setIcon(String str) {
        IPageInfoModuleAdapter o = C3004a.l().o();
        if (o instanceof ITBPageInfoModuleAdapter) {
            ((ITBPageInfoModuleAdapter) o).setInstanceId(this.mWXSDKInstance.getInstanceId());
        }
        if (o != null) {
            o.setIcon(this.mWXSDKInstance.getContext(), str);
        }
    }

    @JSMethod
    public void setTitle(String str) {
        IPageInfoModuleAdapter o = C3004a.l().o();
        if (o instanceof ITBPageInfoModuleAdapter) {
            ((ITBPageInfoModuleAdapter) o).setInstanceId(this.mWXSDKInstance.getInstanceId());
        }
        if (o != null) {
            o.setTitle(this.mWXSDKInstance.getContext(), str);
        }
    }
}
