package com.youku.live.widgets.protocol;

import android.view.View;
import com.youku.live.widgets.protocol.activity.IActivityStateReader;
import com.youku.live.widgets.protocol2.IAppearState;
import com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IWidget extends IDestroyable, IElementAppearLevel, IWidgetLifecycle, IActivityStateReader, IAppearState, IWidgetViewInitInterface {
    boolean addChild(IWidget iWidget);

    boolean closeSelf();

    boolean deleteChild(IWidget iWidget);

    @Override // com.youku.live.widgets.protocol.IDestroyable
    void destroy();

    List<IWidget> getChildren();

    IEngineInstance getEngineInstance();

    View getHostView();

    IProps getOptions();

    IWidget getParent();

    IProps getProps();

    View getRealView();

    IProps getTheme();

    void hide();

    void show();
}
