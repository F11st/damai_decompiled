package com.youku.live.widgets.protocol;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPluginMananger extends IElementMananger {
    IPlugin createPlugin(String str);

    boolean releaseInstance(IPlugin iPlugin);
}
