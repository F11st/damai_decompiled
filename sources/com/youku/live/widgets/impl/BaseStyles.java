package com.youku.live.widgets.impl;

import android.graphics.Color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.protocol.IStyles;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseStyles implements IStyles {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, Object> mStyles;
    private Map<String, Integer> mStylesUnit;

    private Object getStyle(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1021456059") ? ipChange.ipc$dispatch("1021456059", new Object[]{this, str}) : getStyles().get(str);
    }

    private Map<String, Object> getStyles() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579835519")) {
            return (Map) ipChange.ipc$dispatch("1579835519", new Object[]{this});
        }
        if (this.mStyles == null) {
            synchronized (this) {
                if (this.mStyles == null) {
                    this.mStyles = new HashMap();
                }
            }
        }
        return this.mStyles;
    }

    private Map<String, Integer> getStylesUnit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1757102885")) {
            return (Map) ipChange.ipc$dispatch("-1757102885", new Object[]{this});
        }
        if (this.mStylesUnit == null) {
            synchronized (this) {
                if (this.mStylesUnit == null) {
                    this.mStylesUnit = new HashMap();
                }
            }
        }
        return this.mStylesUnit;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public boolean containsKey(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1355075344") ? ((Boolean) ipChange.ipc$dispatch("-1355075344", new Object[]{this, str})).booleanValue() : getStyles().containsKey(str);
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public Object get(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1770726876") ? ipChange.ipc$dispatch("1770726876", new Object[]{this, str}) : getStyle(str);
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public boolean getBoolean(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372329000")) {
            return ((Boolean) ipChange.ipc$dispatch("-372329000", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue();
        }
        Object style = getStyle(str);
        return style instanceof Boolean ? ((Boolean) style).booleanValue() : z;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public Color getColor(String str, Color color) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172828817")) {
            return (Color) ipChange.ipc$dispatch("1172828817", new Object[]{this, str, color});
        }
        Object style = getStyle(str);
        return style instanceof Color ? (Color) style : color;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public double getDouble(String str, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045179207")) {
            return ((Double) ipChange.ipc$dispatch("2045179207", new Object[]{this, str, Double.valueOf(d)})).doubleValue();
        }
        Object style = getStyle(str);
        return style instanceof Double ? ((Double) style).doubleValue() : d;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public float getFloat(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203694684")) {
            return ((Float) ipChange.ipc$dispatch("-1203694684", new Object[]{this, str, Float.valueOf(f)})).floatValue();
        }
        Object style = getStyle(str);
        return style instanceof Float ? ((Float) style).floatValue() : f;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public int getInt(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1490589181")) {
            return ((Integer) ipChange.ipc$dispatch("1490589181", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        }
        Object style = getStyle(str);
        return style instanceof Integer ? ((Integer) style).intValue() : i;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public long getLong(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463309698")) {
            return ((Long) ipChange.ipc$dispatch("-1463309698", new Object[]{this, str, Long.valueOf(j)})).longValue();
        }
        Object style = getStyle(str);
        return style instanceof Long ? ((Long) style).longValue() : j;
    }

    @Override // com.youku.live.widgets.protocol.IMap
    public String getString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506071729")) {
            return (String) ipChange.ipc$dispatch("506071729", new Object[]{this, str, str2});
        }
        Object style = getStyle(str);
        return style instanceof String ? (String) style : str2;
    }

    @Override // com.youku.live.widgets.protocol.IStyles
    public int getUnit(String str) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254350181")) {
            return ((Integer) ipChange.ipc$dispatch("1254350181", new Object[]{this, str})).intValue();
        }
        Map<String, Integer> stylesUnit = getStylesUnit();
        if (stylesUnit == null || (num = stylesUnit.get(str)) == null) {
            return 0;
        }
        int intValue = num.intValue();
        if (intValue == 0 || intValue == 1) {
            return intValue;
        }
        return 0;
    }

    public void putValue(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419259924")) {
            ipChange.ipc$dispatch("-1419259924", new Object[]{this, str, obj});
        } else {
            getStyles().put(str, obj);
        }
    }
}
