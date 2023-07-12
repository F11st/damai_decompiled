package com.youku.live.dsl.danmaku;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DanmakuItemBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_BORDER_COLOR = "borderColor";
    public static final String KEY_BORDER_CORNER_SIZE = "borderCornerSize";
    public static final String KEY_BORDER_SIZE = "borderSize";
    public static final String KEY_FONT_BORDER_COLOR = "fontBorderColor";
    public static final String KEY_FONT_BORDER_SIZE = "fontBorderSize";
    public static final String KEY_FONT_COLOR = "fontColor";
    public static final String KEY_FONT_COLOR_BOTTOM = "fontColorBottom";
    public static final String KEY_FONT_COLOR_TOP = "fontColorTop";
    public static final String KEY_FONT_SHADOW_COLOR = "fontShadowColor";
    public static final String KEY_FONT_SHADOW_OFFSET_X = "fontShadowOffsetX";
    public static final String KEY_FONT_SHADOW_OFFSET_Y = "fontShadowOffsetY";
    public static final String KEY_FONT_SHADOW_SIZE = "fontShadowSize";
    public static final String KEY_FONT_SIZE = "fontSize";
    public static final String KEY_IMMEDIATELY = "immediately";
    public static final String KEY_PADDING_BOTTOM = "paddingBottom";
    public static final String KEY_PADDING_LEFT = "paddingLeft";
    public static final String KEY_PADDING_RIGHT = "paddingRight";
    public static final String KEY_PADDING_TOP = "paddingTop";
    public static final String KEY_ROW = "row";
    public static final String KEY_TEXT = "text";
    Map<String, Object> valueMap;

    public Map<String, Object> build() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-577617766") ? (Map) ipChange.ipc$dispatch("-577617766", new Object[]{this}) : getValueMap();
    }

    public Map<String, Object> getValueMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076138823")) {
            return (Map) ipChange.ipc$dispatch("2076138823", new Object[]{this});
        }
        if (this.valueMap == null) {
            synchronized (this) {
                if (this.valueMap == null) {
                    this.valueMap = new ConcurrentHashMap();
                }
            }
        }
        return this.valueMap;
    }

    public DanmakuItemBuilder setExtraValue(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1017508576")) {
            return (DanmakuItemBuilder) ipChange.ipc$dispatch("-1017508576", new Object[]{this, str, Integer.valueOf(i)});
        }
        if (str != null) {
            getValueMap().put(str, Integer.valueOf(i));
        }
        return this;
    }

    public DanmakuItemBuilder setPaddingBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120307069")) {
            return (DanmakuItemBuilder) ipChange.ipc$dispatch("120307069", new Object[]{this, Integer.valueOf(i)});
        }
        getValueMap().put("paddingBottom", Integer.valueOf(i));
        return this;
    }

    public DanmakuItemBuilder setPaddingLeft(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629903975")) {
            return (DanmakuItemBuilder) ipChange.ipc$dispatch("-1629903975", new Object[]{this, Integer.valueOf(i)});
        }
        getValueMap().put("paddingLeft", Integer.valueOf(i));
        return this;
    }

    public DanmakuItemBuilder setPaddingRight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752006156")) {
            return (DanmakuItemBuilder) ipChange.ipc$dispatch("-1752006156", new Object[]{this, Integer.valueOf(i)});
        }
        getValueMap().put("paddingRight", Integer.valueOf(i));
        return this;
    }

    public DanmakuItemBuilder setPaddingTop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161671597")) {
            return (DanmakuItemBuilder) ipChange.ipc$dispatch("161671597", new Object[]{this, Integer.valueOf(i)});
        }
        getValueMap().put("paddingTop", Integer.valueOf(i));
        return this;
    }

    public DanmakuItemBuilder setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464783707")) {
            return (DanmakuItemBuilder) ipChange.ipc$dispatch("-1464783707", new Object[]{this, str});
        }
        if (str != null) {
            getValueMap().put("text", str);
        }
        return this;
    }

    public DanmakuItemBuilder setExtraValue(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529867923")) {
            return (DanmakuItemBuilder) ipChange.ipc$dispatch("-1529867923", new Object[]{this, str, obj});
        }
        if (str != null) {
            getValueMap().put(str, obj);
        }
        return this;
    }
}
