package com.taobao.weex.ui.action;

import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.richtext.WXRichText;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionAddChildToRichtext extends BasicGraphicAction {
    public GraphicActionAddChildToRichtext(@NonNull WXSDKInstance wXSDKInstance, String str, String str2, String str3, String str4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        super(wXSDKInstance, str4);
        WXRichText wXRichText;
        if (WXSDKManager.v() == null || WXSDKManager.v().G() == null || (wXRichText = (WXRichText) WXSDKManager.v().G().getWXComponent(getPageId(), str4)) == null) {
            return;
        }
        wXRichText.AddChildNode(str2, str, str3, hashMap, hashMap2);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }
}
