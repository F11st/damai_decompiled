package com.youku.live.widgets.impl;

import android.graphics.Color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.protocol.IProps;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseProps implements IProps {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, Object> mProps;

    private Object getProp(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "568005907") ? ipChange.ipc$dispatch("568005907", new Object[]{this, str}) : getProps().get(str);
    }

    private Map<String, Object> getProps() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738284329")) {
            return (Map) ipChange.ipc$dispatch("-1738284329", new Object[]{this});
        }
        if (this.mProps == null) {
            synchronized (this) {
                if (this.mProps == null) {
                    this.mProps = new HashMap();
                }
            }
        }
        return this.mProps;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public boolean containsKey(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1579263484") ? ((Boolean) ipChange.ipc$dispatch("1579263484", new Object[]{this, str})).booleanValue() : getProps().containsKey(str);
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public Object get(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "562667088") ? ipChange.ipc$dispatch("562667088", new Object[]{this, str}) : getProp(str);
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public boolean getBoolean(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1732957468")) {
            return ((Boolean) ipChange.ipc$dispatch("-1732957468", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue();
        }
        Object prop = getProp(str);
        return prop instanceof Boolean ? ((Boolean) prop).booleanValue() : z;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public Color getColor(String str, Color color) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1815872925")) {
            return (Color) ipChange.ipc$dispatch("1815872925", new Object[]{this, str, color});
        }
        Object prop = getProp(str);
        return prop instanceof Color ? (Color) prop : color;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public double getDouble(String str, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323848005")) {
            return ((Double) ipChange.ipc$dispatch("-1323848005", new Object[]{this, str, Double.valueOf(d)})).doubleValue();
        }
        Object prop = getProp(str);
        return prop instanceof Double ? ((Double) prop).doubleValue() : d;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public float getFloat(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-65446992")) {
            return ((Float) ipChange.ipc$dispatch("-65446992", new Object[]{this, str, Float.valueOf(f)})).floatValue();
        }
        Object prop = getProp(str);
        return prop instanceof Float ? ((Float) prop).floatValue() : f;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public int getInt(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1509650697")) {
            return ((Integer) ipChange.ipc$dispatch("1509650697", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        }
        Object prop = getProp(str);
        return prop instanceof Integer ? ((Integer) prop).intValue() : i;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public long getLong(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872402702")) {
            return ((Long) ipChange.ipc$dispatch("-872402702", new Object[]{this, str, Long.valueOf(j)})).longValue();
        }
        Object prop = getProp(str);
        return prop instanceof Long ? ((Long) prop).longValue() : j;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public String getString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970758363")) {
            return (String) ipChange.ipc$dispatch("-970758363", new Object[]{this, str, str2});
        }
        Object prop = getProp(str);
        return prop instanceof String ? (String) prop : str2;
    }

    @Override // com.youku.live.widgets.protocol.IProps
    public <RetType> RetType getValue(String str, Class<RetType> cls, RetType rettype) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625325316")) {
            return (RetType) ipChange.ipc$dispatch("1625325316", new Object[]{this, str, cls, rettype});
        }
        if (cls != null && getProps().containsKey(str)) {
            RetType rettype2 = (RetType) getProp(str);
            if (rettype2 == null) {
                return null;
            }
            if (cls.isInstance(rettype2)) {
                return rettype2;
            }
        }
        return rettype;
    }

    public BaseProps putValue(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-679236206")) {
            return (BaseProps) ipChange.ipc$dispatch("-679236206", new Object[]{this, str, obj});
        }
        getProps().put(str, obj);
        return this;
    }

    public BaseProps putValues(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196798694")) {
            return (BaseProps) ipChange.ipc$dispatch("-1196798694", new Object[]{this, map});
        }
        getProps().putAll(map);
        return this;
    }

    public BaseProps putValuesString(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-409315253")) {
            return (BaseProps) ipChange.ipc$dispatch("-409315253", new Object[]{this, map});
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                getProps().put(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    @Override // com.youku.live.widgets.protocol.IProps
    public Map<String, Object> toMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1581562146") ? (Map) ipChange.ipc$dispatch("1581562146", new Object[]{this}) : new HashMap(getProps());
    }

    @Override // com.youku.live.widgets.protocol.IProps
    public Map<String, Object> toMap(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170349459")) {
            return (Map) ipChange.ipc$dispatch("-1170349459", new Object[]{this, map});
        }
        if (map == null) {
            return toMap();
        }
        map.putAll(getProps());
        return map;
    }
}
