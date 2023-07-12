package com.youku.style;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IStyle<STYLE extends Map> {
    public static final String GALLERY_BG_IMG = "galleryBgImg.png";
    public static final String GALLERY_GRADIENT_BOTTOM_COLOR = "galleryGradientBottomColor";
    public static final String GALLERY_GRADIENT_TOP_COLOR = "galleryGradientTopColor";
    public static final String HOME_HOTWORD_TEXT_COLOR = "homeHotWordTextColor";
    public static final String HOME_ICON_FILTER_COLOR = "homeIconFilterColor";
    public static final String HOME_SEARCHFRAME_COLOR = "homeSeachFrameColor";
    public static final String HOME_STATE_BAR_TEXT_COLOR = "homeStateBarTextColor";
    public static final String IS_LIGHT_BACKGROUND = "isLightBackground";
    public static final String NAV_BG_COLOR = "navBgColor";
    public static final String NAV_BG_LOCAL_IMG = "home_nav_bg_l.png";
    public static final String NAV_BG_URL_IMG = "navBgImg";
    public static final String NAV_INDICATOR_COLOR = "navIndicatorColor";
    public static final String NAV_SELECT_IMG = "navSelectImg";
    public static final String NAV_TEXT_SELECT_COLOR = "navTextSelectColor";
    public static final String NAV_TEXT_SELECT_END_COLOR = "navTextEndColorNew";
    public static final String NAV_TEXT_SELECT_START_COLOR = "navTextStartColorNew";
    public static final String NAV_TEXT_UNSELECT_COLOR = "navTextUnSelectColor";
    public static final String PRIORITY = "priority";
    public static final String REFRESH_BG_COLOR = "refreshBgColor";

    void resetStyle();

    void setStyle(STYLE style);
}
