package com.youku.style.vo;

import android.text.TextUtils;
import com.youku.style.StyleVisitor;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class StyleValue<STYLE extends Map> implements Serializable {
    public static final int DEFAULT_PRIORITY = 0;
    public int priority;
    protected STYLE style;
    protected StyleVisitor<STYLE> visitor;

    public StyleValue(STYLE style) {
        this.priority = 0;
        StyleVisitor<STYLE> styleVisitor = new StyleVisitor<>(style);
        this.visitor = styleVisitor;
        this.style = compact(styleVisitor);
        if (this.visitor.hasStyleTypedValue("priority", Integer.class)) {
            this.priority = this.visitor.getStyleIntValue("priority");
        }
    }

    protected STYLE compact(StyleVisitor<STYLE> styleVisitor) {
        return styleVisitor.getStyle();
    }

    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        STYLE style = ((StyleValue) obj).style;
        STYLE style2 = this.style;
        if (style2 == null && style == null) {
            return true;
        }
        if (style2 == null || style == null || style.size() != this.style.size()) {
            return false;
        }
        for (Object obj2 : style.keySet()) {
            if (!this.style.containsKey(obj2)) {
                return false;
            }
            Object obj3 = style.get(obj2);
            Object obj4 = this.style.get(obj2);
            if (obj3 != obj4) {
                if (obj3 == null || obj4 == null || obj3.getClass() != obj4.getClass()) {
                    return false;
                }
                if ((!(obj3 instanceof String) || TextUtils.equals((String) obj3, (String) obj4)) && !(obj3 instanceof Integer)) {
                }
                return false;
            }
        }
        return true;
    }

    public STYLE getStyle() {
        return this.style;
    }
}
