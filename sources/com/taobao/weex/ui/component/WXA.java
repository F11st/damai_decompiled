package com.taobao.weex.ui.component;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.view.WXFrameLayout;
import com.taobao.weex.utils.ATagUtil;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXA extends WXDiv {
    @Deprecated
    public WXA(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        if (str.equals("href")) {
            return true;
        }
        return super.setProperty(str, obj);
    }

    public WXA(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(WXFrameLayout wXFrameLayout) {
        addClickListener(new WXComponent.OnClickListener() { // from class: com.taobao.weex.ui.component.WXA.1
            @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
            public void onHostViewClick() {
                String str;
                WXAttr attrs = WXA.this.getAttrs();
                if (attrs == null || (str = (String) attrs.get("href")) == null) {
                    return;
                }
                ATagUtil.onClick(null, WXA.this.getInstanceId(), str);
            }
        });
        super.onHostViewInitialized((WXA) wXFrameLayout);
    }
}
