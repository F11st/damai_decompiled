package com.youku.live.widgets.widgets.web;

import android.content.Context;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.impl.BaseWidget;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WebWidget extends BaseWidget {
    private static transient /* synthetic */ IpChange $ipChange;
    private WebWidgetView mRealView;

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999707812")) {
            return (View) ipChange.ipc$dispatch("1999707812", new Object[]{this, context});
        }
        WebWidgetView webWidgetView = new WebWidgetView(context);
        this.mRealView = webWidgetView;
        return webWidgetView;
    }
}
