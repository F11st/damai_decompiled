package com.youku.live.widgets.protocol;

import com.youku.live.widgets.WidgetInstance;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IWidgetInstanceMananger {
    WidgetInstance createInstance();

    boolean releaseInstance(WidgetInstance widgetInstance);
}
