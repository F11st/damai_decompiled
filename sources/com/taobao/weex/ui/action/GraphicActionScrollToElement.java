package com.taobao.weex.ui.action;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionScrollToElement extends BasicGraphicAction {
    private final JSONObject mOptions;

    public GraphicActionScrollToElement(WXSDKInstance wXSDKInstance, String str, JSONObject jSONObject) {
        super(wXSDKInstance, str);
        this.mOptions = jSONObject;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        Scrollable parentScroller;
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        if (wXComponent == null || (parentScroller = wXComponent.getParentScroller()) == null) {
            return;
        }
        parentScroller.scrollTo(wXComponent, this.mOptions);
    }
}
