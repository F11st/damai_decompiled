package com.youku.live.widgets.model.template;

import com.taobao.uikit.feature.features.FeatureFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class TemplateModel implements Serializable {
    public String _raw;
    public BuilderModel builder;
    public String id;
    public List<PluginModel> plugins;
    public int standardWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
    public boolean supportLandscape = false;
    @Deprecated
    public String templateId;
    public Map<String, String> theme;
    public String version;
    public WidgetModel widget;
}
