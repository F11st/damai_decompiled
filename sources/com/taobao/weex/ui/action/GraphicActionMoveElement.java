package com.taobao.weex.ui.action;

import android.text.TextUtils;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionMoveElement extends BasicGraphicAction {
    private int mIndex;
    private String mParentref;

    public GraphicActionMoveElement(WXSDKInstance wXSDKInstance, String str, String str2, int i) {
        super(wXSDKInstance, str);
        this.mParentref = str2;
        this.mIndex = i;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        if (wXComponent == null) {
            return;
        }
        WXVContainer parent = wXComponent.getParent();
        WXComponent wXComponent2 = WXSDKManager.v().G().getWXComponent(getPageId(), this.mParentref);
        if (parent == null || wXComponent2 == null || !(wXComponent2 instanceof WXVContainer)) {
            return;
        }
        if (wXComponent.getHostView() != null && !TextUtils.equals(wXComponent.getComponentType(), "video") && !TextUtils.equals(wXComponent.getComponentType(), "videoplus")) {
            wXComponent.getHostView().getLocationInWindow(new int[2]);
        }
        parent.remove(wXComponent, false);
        WXVContainer wXVContainer = (WXVContainer) wXComponent2;
        wXVContainer.addChild(wXComponent, this.mIndex);
        if (wXComponent.getHostView() != null && !TextUtils.equals(wXComponent.getComponentType(), "video") && !TextUtils.equals(wXComponent.getComponentType(), "videoplus")) {
            wXComponent.getHostView().getLocationInWindow(new int[2]);
        }
        if (wXComponent.isVirtualComponent()) {
            return;
        }
        wXVContainer.addSubView(wXComponent.getHostView(), this.mIndex);
    }
}
