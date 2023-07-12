package com.youku.live.widgets.protocol;

import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.model.template.PluginModel;
import com.youku.live.widgets.model.template.WidgetModel;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface ITemplateBuilder {
    IPlugin buildPluginWithName(IEngineInstance iEngineInstance, PluginModel pluginModel, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps);

    void buildPluginsWithTemplate(IEngineInstance iEngineInstance, List<PluginModel> list, float f, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps);

    void buildWidgetsWithTemplate(IEngineInstance iEngineInstance, IWidget iWidget, CSSLayout cSSLayout, WidgetModel widgetModel, float f, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps);
}
