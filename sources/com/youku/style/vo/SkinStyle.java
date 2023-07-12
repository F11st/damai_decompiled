package com.youku.style.vo;

import com.youku.style.StyleVisitor;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SkinStyle extends StyleValue {
    private static final String HOME_SEARCHFRAME_COLOR_OLD = "homeSeachFrameColor";

    public SkinStyle(Map map) {
        super(map);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map] */
    @Override // com.youku.style.vo.StyleValue
    protected Map compact(StyleVisitor styleVisitor) {
        ?? style = styleVisitor.getStyle();
        if (style != 0 && styleVisitor.hasStyleStringValue("homeSeachFrameColor")) {
            style.put("homeSeachFrameColor", styleVisitor.getStyleStringValue("homeSeachFrameColor"));
            style.remove("homeSeachFrameColor");
        }
        return style;
    }
}
