package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.ui.component.WXComponent;
import tb.sg2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionRemoveEvent extends BasicGraphicAction {
    private final String mEvent;

    public GraphicActionRemoveEvent(WXSDKInstance wXSDKInstance, String str, Object obj) {
        super(wXSDKInstance, str);
        this.mEvent = WXEvent.getEventName(obj);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        if (wXComponent == null) {
            return;
        }
        sg2.f();
        wXComponent.removeEvent(this.mEvent);
        sg2.c("removeEventFromComponent");
    }
}
