package com.youku.live.widgets.template;

import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.WidgetSDKManager;
import com.youku.live.widgets.config.WidgetEngineRenderConfig;
import com.youku.live.widgets.constants.AppearState;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.impl.BasePluginData;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.impl.BaseWidgetData;
import com.youku.live.widgets.model.template.PluginModel;
import com.youku.live.widgets.model.template.WidgetAttributesModel;
import com.youku.live.widgets.model.template.WidgetModel;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.ITemplateBuilder;
import com.youku.live.widgets.protocol.ITemplateWidgetBuildCallback;
import com.youku.live.widgets.protocol.IWidget;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TemplateBuilder implements ITemplateBuilder {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.widgets.protocol.ITemplateBuilder
    public IPlugin buildPluginWithName(IEngineInstance iEngineInstance, PluginModel pluginModel, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "364320058")) {
            return (IPlugin) ipChange.ipc$dispatch("364320058", new Object[]{this, iEngineInstance, pluginModel, iTemplateWidgetBuildCallback, iProps});
        }
        IPlugin onPreBuildPlugin = iTemplateWidgetBuildCallback != null ? iTemplateWidgetBuildCallback.onPreBuildPlugin(pluginModel) : null;
        if (onPreBuildPlugin == null) {
            onPreBuildPlugin = WidgetSDKManager.getInstance().createPlugin(pluginModel.name);
            if (onPreBuildPlugin instanceof BasePlugin) {
                BasePlugin basePlugin = (BasePlugin) onPreBuildPlugin;
                basePlugin.mAppearState = AppearState.DID_DISAPPEAR;
                basePlugin.bindEngineInstance(iEngineInstance);
            }
        }
        if (onPreBuildPlugin != null) {
            BasePluginData basePluginData = new BasePluginData(pluginModel);
            basePluginData.setOptions(iProps);
            if (onPreBuildPlugin instanceof BasePlugin) {
                ((BasePlugin) onPreBuildPlugin).mIsAppearLevel = WidgetEngineRenderConfig.getInstance().isAppearLevelPlugin(pluginModel.name);
            }
            onPreBuildPlugin.initWithData(iEngineInstance, basePluginData);
            onPreBuildPlugin.willMount();
            onPreBuildPlugin.didMount();
        }
        if (iTemplateWidgetBuildCallback != null) {
            iTemplateWidgetBuildCallback.onBuildPlugin(pluginModel, onPreBuildPlugin);
        }
        return onPreBuildPlugin;
    }

    @Override // com.youku.live.widgets.protocol.ITemplateBuilder
    public void buildPluginsWithTemplate(IEngineInstance iEngineInstance, List<PluginModel> list, float f, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896077689")) {
            ipChange.ipc$dispatch("-896077689", new Object[]{this, iEngineInstance, list, Float.valueOf(f), iTemplateWidgetBuildCallback, iProps});
        } else if (list != null) {
            for (PluginModel pluginModel : list) {
                if (pluginModel != null && pluginModel.name != null) {
                    buildPluginWithName(iEngineInstance, pluginModel, iTemplateWidgetBuildCallback, iProps);
                }
            }
        }
    }

    @Override // com.youku.live.widgets.protocol.ITemplateBuilder
    public void buildWidgetsWithTemplate(IEngineInstance iEngineInstance, IWidget iWidget, CSSLayout cSSLayout, WidgetModel widgetModel, float f, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps) {
        CSSLayout.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1902557625")) {
            ipChange.ipc$dispatch("-1902557625", new Object[]{this, iEngineInstance, iWidget, cSSLayout, widgetModel, Float.valueOf(f), iTemplateWidgetBuildCallback, iProps});
        } else if (widgetModel != null) {
            List<WidgetModel> list = widgetModel.children;
            if (list != null && list.size() > 0) {
                z = true;
            }
            IWidget createWidget = WidgetSDKManager.getInstance().createWidget(widgetModel.name);
            if (createWidget instanceof BaseWidget) {
                BaseWidget baseWidget = (BaseWidget) createWidget;
                baseWidget.mAppearState = AppearState.DID_DISAPPEAR;
                baseWidget.mEngineInstance = iEngineInstance;
                baseWidget.mIsAppearLevel = WidgetEngineRenderConfig.getInstance().isAppearLevelWidget(widgetModel.name);
            }
            if (iTemplateWidgetBuildCallback != null) {
                iTemplateWidgetBuildCallback.onPreBuildWidget(widgetModel, createWidget);
            }
            WidgetAttributesModel widgetAttributesModel = widgetModel.atts;
            if (widgetAttributesModel == null) {
                widgetAttributesModel = null;
            }
            BaseWidgetData baseWidgetData = new BaseWidgetData(widgetAttributesModel);
            if (iTemplateWidgetBuildCallback != null) {
                iTemplateWidgetBuildCallback.onBuildWidget(widgetModel, createWidget);
            }
            createWidget.initWithData(iEngineInstance, iWidget, baseWidgetData);
            createWidget.willMount();
            ViewGroup viewGroup = cSSLayout != null ? cSSLayout : (ViewGroup) iWidget.getHostView();
            if (cSSLayout == null) {
                ViewGroup viewGroup2 = (ViewGroup) iWidget.getRealView();
            }
            if (z && !(viewGroup instanceof CSSLayout)) {
                ViewGroup cSSLayout2 = new CSSLayout(iEngineInstance.getContext());
                viewGroup.addView(cSSLayout2, new ViewGroup.LayoutParams(-1, -1));
                viewGroup = cSSLayout2;
            }
            View initHostView = createWidget.initHostView(iEngineInstance.getContext());
            if (createWidget instanceof BaseWidget) {
                ((BaseWidget) createWidget).mHostView = initHostView;
            }
            if (viewGroup instanceof CSSLayout) {
                WidgetAttributesModel widgetAttributesModel2 = widgetModel.atts;
                WidgetAttributesModel.OrientationModel orientationModel = widgetAttributesModel2.portrait;
                WidgetAttributesModel.OrientationModel orientationModel2 = widgetAttributesModel2.landscape;
                if (orientationModel2 == null) {
                    orientationModel2 = orientationModel;
                }
                ViewGroup.LayoutParams layoutParams2 = initHostView.getLayoutParams();
                if (layoutParams2 instanceof CSSLayout.LayoutParams) {
                    layoutParams = (CSSLayout.LayoutParams) layoutParams2;
                    layoutParams.useCSSLayout = true;
                    layoutParams.aspectRatio = f;
                    if (layoutParams.portraitModel == null) {
                        layoutParams.portraitModel = orientationModel;
                    }
                    if (layoutParams.landscapeModel == null) {
                        layoutParams.landscapeModel = orientationModel2;
                    }
                } else {
                    layoutParams = new CSSLayout.LayoutParams(-1, -1);
                    layoutParams.setOrientationModel(orientationModel, orientationModel2, f);
                }
                viewGroup.addView(initHostView, layoutParams);
            } else {
                viewGroup.addView(initHostView, new ViewGroup.LayoutParams(-1, -1));
            }
            if (z) {
                if (initHostView instanceof CSSLayout) {
                    viewGroup = (CSSLayout) initHostView;
                }
                ViewGroup viewGroup3 = viewGroup;
                for (WidgetModel widgetModel2 : list) {
                    if (widgetModel2 != null) {
                        buildWidgetsWithTemplate(iEngineInstance, createWidget, viewGroup3 instanceof CSSLayout ? (CSSLayout) viewGroup3 : null, widgetModel2, f, iTemplateWidgetBuildCallback, iProps);
                    } else {
                        WidgetAttributesModel widgetAttributesModel3 = widgetModel2.atts;
                    }
                }
            }
            iWidget.addChild(createWidget);
            createWidget.didMount();
        }
    }
}
