package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionBatchAction extends BasicGraphicAction {
    private List<BasicGraphicAction> mActions;

    public GraphicActionBatchAction(WXSDKInstance wXSDKInstance, String str, List<BasicGraphicAction> list) {
        super(wXSDKInstance, str);
        this.mActions = new ArrayList(list);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        for (int i = 0; i < this.mActions.size(); i++) {
            this.mActions.get(i).executeAction();
        }
    }
}
