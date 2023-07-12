package com.youku.live.widgets.protocol2;

import android.app.Activity;
import android.content.Context;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.activity.IActivityStateReader;
import com.youku.live.widgets.protocol2.performance.IPerformanceMananger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IWidgetEngineContext extends IDestroyable {
    IWidgetEngineContext bindActivityStateReader(Object obj, IActivityStateReader iActivityStateReader);

    Activity getActivity();

    Context getContext();

    IPerformanceMananger getPerformanceMananger();

    IWidgetEngineContext unbindActivityStateReader(Object obj);
}
