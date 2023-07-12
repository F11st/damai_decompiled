package com.taobao.weex.ui.component;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.list.WXCell;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXHeader extends WXCell {
    @Deprecated
    public WXHeader(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean canRecycled() {
        return !isSticky();
    }

    @Override // com.taobao.weex.ui.component.list.WXCell, com.taobao.weex.ui.component.WXComponent
    public boolean isLazy() {
        return false;
    }

    public WXHeader(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        String componentType = wXVContainer.getComponentType();
        if ("list".equals(componentType) || WXBasicComponentType.RECYCLE_LIST.equals(componentType)) {
            getStyles().put("position", "sticky");
            setSticky("sticky");
        }
    }
}
