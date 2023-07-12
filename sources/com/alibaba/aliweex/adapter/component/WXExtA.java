package com.alibaba.aliweex.adapter.component;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXA;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.view.WXFrameLayout;
import tb.gf2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXExtA extends WXA {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.component.WXExtA$a */
    /* loaded from: classes5.dex */
    public class C3027a implements WXComponent.OnClickListener {
        C3027a() {
        }

        @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
        public void onHostViewClick() {
            new gf2(WXExtA.this.getInstance().getRootComponent()).a(WXExtA.this);
        }
    }

    public WXExtA(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXA, com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(WXFrameLayout wXFrameLayout) {
        addClickListener(new C3027a());
        super.onHostViewInitialized(wXFrameLayout);
    }
}
