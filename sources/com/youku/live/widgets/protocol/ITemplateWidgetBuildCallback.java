package com.youku.live.widgets.protocol;

import com.youku.live.widgets.model.template.PluginModel;
import com.youku.live.widgets.model.template.WidgetModel;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface ITemplateWidgetBuildCallback {
    void onBuildPlugin(PluginModel pluginModel, IPlugin iPlugin);

    void onBuildWidget(WidgetModel widgetModel, IWidget iWidget);

    IPlugin onPreBuildPlugin(PluginModel pluginModel);

    void onPreBuildWidget(WidgetModel widgetModel, IWidget iWidget);
}
