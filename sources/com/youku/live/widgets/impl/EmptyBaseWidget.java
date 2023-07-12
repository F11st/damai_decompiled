package com.youku.live.widgets.impl;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class EmptyBaseWidget extends BaseWidget {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout mRoot;

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247941080")) {
            return (View) ipChange.ipc$dispatch("-1247941080", new Object[]{this, context});
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.mRoot = frameLayout;
        return frameLayout;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756485376")) {
            ipChange.ipc$dispatch("756485376", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
        } else {
            super.initWithData(iEngineInstance, iWidget, iWidgetData);
        }
    }
}
