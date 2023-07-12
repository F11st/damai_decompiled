package com.alibaba.aliweex.adapter.module;

import android.text.TextUtils;
import com.alibaba.aliweex.bundle.WeexPageFragment;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.ui.component.NestedContainer;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AliWXLocationModule extends WXLocationModule {
    @Override // com.alibaba.aliweex.adapter.module.WXLocationModule
    @JSMethod
    public void reload(Boolean bool) {
        if (this.mWXSDKInstance.getContext() == null) {
            return;
        }
        WeexPageFragment findWeexPageFragment = findWeexPageFragment();
        NestedContainer nestedContainer = null;
        if (findWeexPageFragment != null && (nestedContainer = findWeexPageFragment.getNestedContainer(this.mWXSDKInstance)) != null) {
            nestedContainer.reload();
        }
        if (nestedContainer == null) {
            super.reload(bool);
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.WXLocationModule
    @JSMethod
    public void replace(String str) {
        if (TextUtils.isEmpty(str) || this.mWXSDKInstance.getContext() == null) {
            return;
        }
        WeexPageFragment findWeexPageFragment = findWeexPageFragment();
        NestedContainer nestedContainer = null;
        if (findWeexPageFragment != null && (nestedContainer = findWeexPageFragment.getNestedContainer(this.mWXSDKInstance)) != null) {
            nestedContainer.renderNewURL(str);
        }
        if (nestedContainer == null) {
            super.replace(str);
        }
    }
}
