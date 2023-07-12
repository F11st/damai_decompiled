package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionAppendTreeCreateFinish extends BasicGraphicAction {
    WXComponent component;

    public GraphicActionAppendTreeCreateFinish(WXSDKInstance wXSDKInstance, String str) {
        super(wXSDKInstance, str);
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), str);
        this.component = wXComponent;
        if (wXComponent == null || !(wXComponent instanceof WXVContainer)) {
            return;
        }
        ((WXVContainer) wXComponent).appendTreeCreateFinish();
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }
}
