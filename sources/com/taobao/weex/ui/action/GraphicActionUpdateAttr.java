package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionUpdateAttr extends BasicGraphicAction {
    private WXComponent component;
    private Map<String, String> mAttrs;

    public GraphicActionUpdateAttr(WXSDKInstance wXSDKInstance, String str, Map<String, String> map) {
        super(wXSDKInstance, str);
        Map<String, String> map2;
        this.mAttrs = map;
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        this.component = wXComponent;
        if (wXComponent == null || (map2 = this.mAttrs) == null) {
            return;
        }
        wXComponent.addAttr(map2);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = this.component;
        if (wXComponent == null) {
            return;
        }
        wXComponent.getAttrs().mergeAttr();
        this.component.updateAttrs(this.mAttrs);
    }
}
