package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.richtext.WXRichText;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionRemoveChildFromRichtext extends BasicGraphicAction {
    private String parentRef;
    private String ref;
    private WXRichText richText;

    public GraphicActionRemoveChildFromRichtext(WXSDKInstance wXSDKInstance, String str, String str2, String str3) {
        super(wXSDKInstance, str3);
        this.ref = str;
        this.parentRef = str2;
        WXRichText wXRichText = (WXRichText) WXSDKManager.v().G().getWXComponent(wXSDKInstance.getInstanceId(), str3);
        this.richText = wXRichText;
        if (wXRichText != null) {
            wXRichText.removeChildNode(str2, str);
        }
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }
}
