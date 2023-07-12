package com.taobao.weex.ui.action;

import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionCreateFinish extends BasicGraphicAction {
    private int mLayoutHeight;
    private int mLayoutWidth;

    public GraphicActionCreateFinish(@NonNull WXSDKInstance wXSDKInstance) {
        super(wXSDKInstance, "");
        WXComponent rootComponent = wXSDKInstance.getRootComponent();
        if (rootComponent != null) {
            this.mLayoutWidth = (int) rootComponent.getLayoutWidth();
            this.mLayoutHeight = (int) rootComponent.getLayoutHeight();
        }
        wXSDKInstance.getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_CREATE_FINISH);
        wXSDKInstance.getApmForInstance().j.put(WXInstanceApm.KEY_PAGE_STAGES_CREATE_FINISH, Boolean.TRUE);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.getContext() == null || wXSDKIntance.mHasCreateFinish) {
            return;
        }
        if (wXSDKIntance.getRenderStrategy() == WXRenderStrategy.APPEND_ONCE) {
            wXSDKIntance.onCreateFinish();
        } else if (!"platform".equals(wXSDKIntance.getRenderType())) {
            wXSDKIntance.onCreateFinish();
        }
        wXSDKIntance.mHasCreateFinish = true;
        if (wXSDKIntance.getWXPerformance() != null) {
            wXSDKIntance.getWXPerformance().callCreateFinishTime = System.currentTimeMillis() - wXSDKIntance.getWXPerformance().renderTimeOrigin;
        }
        wXSDKIntance.onOldFsRenderTimeLogic();
    }
}
