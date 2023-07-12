package com.youku.live.widgets.protocol2.lifecycle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IWidgetViewInitInterface {
    @Deprecated
    ViewGroup.LayoutParams getLayoutParams();

    View initHostView(Context context);

    void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData);
}
