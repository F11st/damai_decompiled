package com.youku.live.widgets.protocol;

import android.app.Activity;
import android.content.Context;
import com.youku.live.widgets.protocol.activity.IActivityStateReader;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IEngineContext extends IDestroyable, IWidgetInstanceMananger, IActivityStateReader {
    Context getApplicationContext();

    Activity getCurrentActivity();

    IPageableController getPageableController();

    IPluginMananger getPluginMananger();

    IWidgetInstanceMananger getWidgetInstanceMananger();

    IWidgetMananger getWidgetMananger();
}
