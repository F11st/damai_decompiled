package com.youku.style.vo;

import com.youku.css.util.ColorUtil;
import com.youku.style.StyleVisitor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AtmosphereStyle extends StyleValue {
    private static final String HOME_ICON_FILTER_COLOR_OLD = "navIconColor";
    private static final String HOME_SEARCHFRAME_COLOR_OLD = "navBgSubColor";
    private static final String HOME_STATE_BAR_TEXT_COLOR_OLD = "statusBarStyle";
    private static final String NAV_TEXT_END_COLOR_OLD = "navTextEndColor";
    private static final String NAV_TEXT_SELECT_COLOR_OLD = "navColor";
    private static final String NAV_TEXT_START_COLOR_OLD = "navTextStartColor";
    private static final String NAV_TEXT_UNSELECT_COLOR_OLD = "navSubColor";
    private static final String PRIORITY_OLD = "isForced";

    public AtmosphereStyle(Map map) {
        super(map);
        if (this.visitor.hasStyleTypedValue("priority", Integer.class)) {
            this.priority = this.visitor.getStyleIntValue("priority");
        } else {
            this.priority = -1;
        }
    }

    private int parseInt(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        try {
            return Integer.parseInt(String.valueOf(obj));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.Map] */
    @Override // com.youku.style.vo.StyleValue
    protected Map compact(StyleVisitor styleVisitor) {
        ?? style = styleVisitor.getStyle();
        if (style != 0) {
            if (styleVisitor.hasStyleStringValue(NAV_TEXT_UNSELECT_COLOR_OLD)) {
                style.put("navTextUnSelectColor", styleVisitor.getStyleStringValue(NAV_TEXT_UNSELECT_COLOR_OLD));
                style.remove(NAV_TEXT_UNSELECT_COLOR_OLD);
            }
            if (styleVisitor.hasStyleStringValue(NAV_TEXT_SELECT_COLOR_OLD)) {
                style.put("navTextSelectColor", styleVisitor.getStyleStringValue(NAV_TEXT_SELECT_COLOR_OLD));
                style.remove(NAV_TEXT_SELECT_COLOR_OLD);
            }
            if (styleVisitor.hasStyleStringValue(HOME_ICON_FILTER_COLOR_OLD)) {
                style.put("homeIconFilterColor", styleVisitor.getStyleStringValue(HOME_ICON_FILTER_COLOR_OLD));
                style.remove(HOME_ICON_FILTER_COLOR_OLD);
            }
            if (styleVisitor.hasStyleStringValue(HOME_SEARCHFRAME_COLOR_OLD)) {
                style.put("homeSeachFrameColor", styleVisitor.getStyleStringValue(HOME_SEARCHFRAME_COLOR_OLD));
                style.remove(HOME_SEARCHFRAME_COLOR_OLD);
            }
            if (styleVisitor.getStyle() != 0 && styleVisitor.getStyle().get(PRIORITY_OLD) != null) {
                style.put("priority", Integer.valueOf(parseInt(styleVisitor.getStyle().get(PRIORITY_OLD))));
                style.remove(PRIORITY_OLD);
            }
            if (styleVisitor.hasStyleStringValue("refreshBgColor") && ColorUtil.parseColorSafely("#2E4F7B") == styleVisitor.getStyleColor("refreshBgColor") && styleVisitor.hasStyleStringValue("galleryGradientTopColor") && ColorUtil.parseColorSafely("#2E4F7B") == styleVisitor.getStyleColor("galleryGradientTopColor") && styleVisitor.hasStyleStringValue("galleryGradientBottomColor") && ColorUtil.parseColorSafely("#ADE8EB") == styleVisitor.getStyleColor("galleryGradientBottomColor")) {
                style.remove("refreshBgColor");
                style.remove("galleryGradientTopColor");
                style.remove("galleryGradientBottomColor");
            }
            if (styleVisitor.hasStyleStringValue(HOME_STATE_BAR_TEXT_COLOR_OLD)) {
                style.put("homeStateBarTextColor", Integer.parseInt(styleVisitor.getStyleStringValue(HOME_STATE_BAR_TEXT_COLOR_OLD)) == 0 ? "white" : "black");
                style.remove(HOME_STATE_BAR_TEXT_COLOR_OLD);
            }
            if (styleVisitor.hasStyleStringValue(NAV_TEXT_START_COLOR_OLD)) {
                style.remove(NAV_TEXT_START_COLOR_OLD);
            }
            if (styleVisitor.hasStyleStringValue(NAV_TEXT_END_COLOR_OLD)) {
                style.remove(NAV_TEXT_END_COLOR_OLD);
            }
            if (style.size() <= 2) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(style);
                if (hashMap.containsKey("tag")) {
                    hashMap.remove("tag");
                }
                if (hashMap.containsKey("updateTime")) {
                    hashMap.remove("updateTime");
                }
                if (hashMap.size() == 0) {
                    return null;
                }
            }
        }
        return style;
    }
}
