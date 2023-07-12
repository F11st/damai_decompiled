package com.youku.live.widgets.impl;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.model.template.PluginModel;
import com.youku.live.widgets.protocol.IPluginData;
import com.youku.live.widgets.protocol.IProps;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BasePluginData implements IPluginData {
    private static transient /* synthetic */ IpChange $ipChange;
    private IProps mOptions;
    private BaseProps mProps;

    public BasePluginData(PluginModel pluginModel) {
        Map<String, String> map;
        BaseProps baseProps = new BaseProps();
        this.mProps = baseProps;
        if (pluginModel == null || (map = pluginModel.atts) == null) {
            return;
        }
        baseProps.putValuesString(map);
    }

    @Override // com.youku.live.widgets.protocol.IPluginData
    public IProps getOptions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1693816293") ? (IProps) ipChange.ipc$dispatch("-1693816293", new Object[]{this}) : this.mOptions;
    }

    @Override // com.youku.live.widgets.protocol.IPluginData
    public IProps getProps() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1679693165") ? (IProps) ipChange.ipc$dispatch("1679693165", new Object[]{this}) : this.mProps;
    }

    public BasePluginData setOptions(IProps iProps) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820850608")) {
            return (BasePluginData) ipChange.ipc$dispatch("-1820850608", new Object[]{this, iProps});
        }
        this.mOptions = iProps;
        return this;
    }
}
