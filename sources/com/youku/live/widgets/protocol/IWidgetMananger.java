package com.youku.live.widgets.protocol;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IWidgetMananger extends IElementMananger {
    IWidget createWidget(String str);

    boolean releaseInstance(IWidget iWidget);
}
