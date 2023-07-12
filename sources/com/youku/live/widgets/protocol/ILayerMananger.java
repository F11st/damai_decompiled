package com.youku.live.widgets.protocol;

import android.view.ViewGroup;
import com.youku.live.widgets.model.template.WidgetModel;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface ILayerMananger {
    String addLayer(String str);

    String closeDialog(String str);

    ViewGroup getRootView();

    boolean removeLayer(String str);

    String showDialog(WidgetModel widgetModel);

    String showDialog(String str);
}
