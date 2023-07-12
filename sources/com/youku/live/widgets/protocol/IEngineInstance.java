package com.youku.live.widgets.protocol;

import android.content.Context;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.protocol.activity.IActivityStateReader;
import com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener;
import com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IEngineInstance extends IDataCenter, IEventDispatcher, ILayerMananger, IPageableController, IActivityStateReader, IActiveStateChangedListener, IAppearStateChangedListener {
    void addVisibleListener(IEngineInstanceVisibleListener iEngineInstanceVisibleListener);

    void delayRunOnMainThread(Runnable runnable, int i);

    void enableCSSLayoutNotifyConfigChanged(boolean z);

    IPlugin findPluginByName(String str);

    IWidget findWidgetById(String str);

    List<IWidget> findWidgetsByName(String str);

    Context getContext();

    Map<String, Object> getEnvironments();

    String getInstTag();

    IProps getOptions();

    Orientation getOrientation();

    IPerfMonitor getPerfMonitor();

    int getStandardWidth();

    IProps getTheme();

    Object pollRecycleView(String str);

    boolean recycleView(String str, Object obj);

    void removeAllFromMainThread();

    void removeFromMainThread(Runnable runnable);

    void removeVisibleListener(IEngineInstanceVisibleListener iEngineInstanceVisibleListener);

    void runOnMainThread(Runnable runnable);
}
