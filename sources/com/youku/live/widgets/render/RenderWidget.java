package com.youku.live.widgets.render;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.IWidget;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RenderWidget extends BaseWidget {
    private static transient /* synthetic */ IpChange $ipChange;
    private RenderContainer mRenderContainer;

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol.IWidget
    public boolean deleteChild(IWidget iWidget) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624852448")) {
            return ((Boolean) ipChange.ipc$dispatch("-1624852448", new Object[]{this, iWidget})).booleanValue();
        }
        this.mRenderContainer.removeView(iWidget.getHostView());
        return super.deleteChild(iWidget);
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428793641")) {
            ipChange.ipc$dispatch("-428793641", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget
    public void destroyImp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "49755047")) {
            ipChange.ipc$dispatch("49755047", new Object[]{this});
            return;
        }
        RenderContainer renderContainer = this.mRenderContainer;
        this.mRenderContainer = null;
        if (renderContainer != null) {
            ViewParent parent = renderContainer.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(renderContainer);
            }
            renderContainer.removeAllViews();
        }
        super.destroyImp();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-920246802")) {
            return (View) ipChange.ipc$dispatch("-920246802", new Object[]{this, context});
        }
        if (this.mRenderContainer == null) {
            this.mRenderContainer = new RenderContainer(context);
        }
        RenderContainer renderContainer = this.mRenderContainer;
        this.mHostView = renderContainer;
        return renderContainer;
    }
}
