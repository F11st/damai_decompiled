package com.youku.arch.v3.style;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Style {
    private static transient /* synthetic */ IpChange $ipChange;
    public Map<String, Object> cssMap;
    public Style parent;

    public Style() {
    }

    public Object getStyleValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "477945719")) {
            return ipChange.ipc$dispatch("477945719", new Object[]{this, str});
        }
        Map<String, Object> map = this.cssMap;
        if (map != null && map.containsKey(str)) {
            return this.cssMap.get(str);
        }
        Style style = this.parent;
        if (style != null) {
            return style.getStyleValue(str);
        }
        return null;
    }

    public Style(Map<String, Object> map, Style style) {
        this.cssMap = map;
        this.parent = style;
    }
}
