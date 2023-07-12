package com.youku.live.widgets.protocol;

import com.youku.live.widgets.protocol2.IAppearState;
import com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener;
import com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPlugin extends IDestroyable, IElementAppearLevel, IAppearState, IAppearStateChangedListener, IMountStateChangedListener {
    IEngineInstance getEngineInstance();

    IProps getProps();

    void initWithData(IEngineInstance iEngineInstance, IPluginData iPluginData);
}
