package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionLayout extends BasicGraphicAction {
    private final boolean mIsLayoutRTL;
    private final GraphicPosition mLayoutPosition;
    private final GraphicSize mLayoutSize;

    public GraphicActionLayout(WXSDKInstance wXSDKInstance, String str, GraphicPosition graphicPosition, GraphicSize graphicSize, boolean z) {
        super(wXSDKInstance, str);
        this.mLayoutPosition = graphicPosition;
        this.mLayoutSize = graphicSize;
        this.mIsLayoutRTL = z;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        if (wXComponent == null) {
            return;
        }
        wXComponent.setIsLayoutRTL(this.mIsLayoutRTL);
        wXComponent.setDemission(this.mLayoutSize, this.mLayoutPosition);
        wXComponent.setSafeLayout(wXComponent);
        wXComponent.setPadding(wXComponent.getPadding(), wXComponent.getBorder());
    }
}
