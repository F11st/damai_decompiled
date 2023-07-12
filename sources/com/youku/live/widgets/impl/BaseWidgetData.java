package com.youku.live.widgets.impl;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.model.template.WidgetAttributesModel;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IStyles;
import com.youku.live.widgets.protocol.IWidgetData;
import com.youku.live.widgets.protocol.Orientation;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseWidgetData implements IWidgetData {
    private static transient /* synthetic */ IpChange $ipChange;
    private IProps mOptions;
    private BaseProps mProps;
    private BaseStyles mStylesPortrait = new BaseStyles();
    private BaseStyles mStylesLandscape = new BaseStyles();

    public BaseWidgetData(WidgetAttributesModel widgetAttributesModel) {
        Map<String, String> map;
        BaseProps baseProps = new BaseProps();
        this.mProps = baseProps;
        if (widgetAttributesModel == null || (map = widgetAttributesModel.extra) == null) {
            return;
        }
        baseProps.putValuesString(map);
    }

    @Override // com.youku.live.widgets.protocol.IWidgetData
    public IProps getOptions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1306271850") ? (IProps) ipChange.ipc$dispatch("1306271850", new Object[]{this}) : this.mOptions;
    }

    @Override // com.youku.live.widgets.protocol.IWidgetData
    public IProps getProps() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-113831044") ? (IProps) ipChange.ipc$dispatch("-113831044", new Object[]{this}) : this.mProps;
    }

    @Override // com.youku.live.widgets.protocol.IWidgetData
    public IStyles getStylesWithOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400341616")) {
            return (IStyles) ipChange.ipc$dispatch("-1400341616", new Object[]{this});
        }
        Orientation orientation = WidgetSDKEngine.getOrientation();
        if (orientation.equals(Orientation.ORIENTATION_LANDSCAPE)) {
            return this.mStylesLandscape;
        }
        if (orientation.equals(Orientation.ORIENTATION_PORTAIT)) {
            return this.mStylesPortrait;
        }
        return this.mStylesPortrait;
    }

    public BaseWidgetData setOptions(IProps iProps) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507190354")) {
            return (BaseWidgetData) ipChange.ipc$dispatch("-1507190354", new Object[]{this, iProps});
        }
        this.mOptions = iProps;
        return this;
    }
}
