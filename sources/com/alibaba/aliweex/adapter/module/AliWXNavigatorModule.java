package com.alibaba.aliweex.adapter.module;

import android.view.Menu;
import com.alibaba.aliweex.AliWXSDKInstance;
import com.alibaba.aliweex.C3004a;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.appfram.navigator.WXNavigatorModule;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AliWXNavigatorModule extends WXNavigatorModule {
    @Override // com.taobao.weex.common.WXModule
    public boolean onCreateOptionsMenu(Menu menu) {
        C3004a.l().n();
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance instanceof AliWXSDKInstance) {
            ((AliWXSDKInstance) wXSDKInstance).b();
        }
        return super.onCreateOptionsMenu(menu);
    }
}
