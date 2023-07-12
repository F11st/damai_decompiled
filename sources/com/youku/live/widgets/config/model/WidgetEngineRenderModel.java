package com.youku.live.widgets.config.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.AlixLivePlayback;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class WidgetEngineRenderModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public Map<String, Boolean> widgets = new HashMap();
    public Map<String, Boolean> plugins = new HashMap();

    public WidgetEngineRenderModel() {
        this.widgets.put(AlixLivePlayback.WIDGET_NAME, Boolean.TRUE);
    }

    public boolean isAppearRenderPlugin(String str) {
        Boolean bool;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296944244")) {
            return ((Boolean) ipChange.ipc$dispatch("-296944244", new Object[]{this, str})).booleanValue();
        }
        Map<String, Boolean> map = this.plugins;
        if (map == null || !map.containsKey(str) || (bool = this.plugins.get(str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isAppearRenderWidget(String str) {
        Boolean bool;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323346149")) {
            return ((Boolean) ipChange.ipc$dispatch("-1323346149", new Object[]{this, str})).booleanValue();
        }
        Map<String, Boolean> map = this.widgets;
        if (map == null || !map.containsKey(str) || (bool = this.widgets.get(str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
