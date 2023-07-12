package com.taobao.weex.ui.action;

import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionRenderSuccess extends BasicGraphicAction {
    public GraphicActionRenderSuccess(@NonNull WXSDKInstance wXSDKInstance) {
        super(wXSDKInstance, "");
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        int i;
        WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.getContext() == null) {
            return;
        }
        WXComponent rootComponent = wXSDKIntance.getRootComponent();
        int i2 = 0;
        if (rootComponent != null) {
            i2 = (int) rootComponent.getLayoutWidth();
            i = (int) rootComponent.getLayoutHeight();
        } else {
            i = 0;
        }
        wXSDKIntance.onRenderSuccess(i2, i);
    }
}
