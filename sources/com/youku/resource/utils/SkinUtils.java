package com.youku.resource.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.youku.resource.R;
import com.youku.skinmanager.SkinManager;
import com.youku.skinmanager.SkinManagerHelper;
import com.youku.skinmanager.utils.SkinResourceUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SkinUtils {
    public static final String GALLERY_BG_IMG = "galleryBgImg.png";
    public static final String GALLERY_GRADIENT_BOTTOM_COLOR = "galleryGradientBottomColor";
    public static final String GALLERY_GRADIENT_TOP_COLOR = "galleryGradientTopColor";
    public static final String HOME_CHANNEL_ENTER_IMG_NAME = "home_channel_filter_all.png";
    public static final String HOME_HOT_WORD_TEXT_COLOR = "homeHotWordTextColor";
    public static final String HOME_ICON_FILTER_COLOR = "homeIconFilterColor";
    public static final String HOME_JSON_FILE_NAME = "home.json";
    public static final String HOME_NAV_BG_COLOR = "navBgColor";
    public static final String HOME_NAV_BG_L = "home_nav_bg_l.png";
    public static final String HOME_NAV_TEXT_COLOR_SELECTED = "navTextSelectColor";
    public static final String HOME_NAV_TEXT_COLOR_UNSELECTED = "navTextUnSelectColor";
    public static final String HOME_PREFIX = "/home/";
    public static final String HOME_REFRESH_BG_COLOR = "refreshBgColor";
    public static final String HOME_SEACH_FRAME_COLOR = "homeSeachFrameColor";
    public static final String HOME_STATUS_BAR_TEXT_COLOR = "homeStateBarTextColor";

    public static int getSkinColor(String str) {
        return getSkinColor(HOME_PREFIX, HOME_JSON_FILE_NAME, str);
    }

    public static String getSkinFilePath(String str) {
        return getSkinFilePath(HOME_PREFIX, str);
    }

    public static String getSkinStr(String str) {
        return getSkinStr(HOME_PREFIX, HOME_JSON_FILE_NAME, str);
    }

    public static int getTabIndicatorColor() {
        return -10698497;
    }

    public static int getTabIndicatorColorEndColor() {
        return -686337;
    }

    public static int getTabIndicatorColorStartColor() {
        return -13113089;
    }

    @Deprecated
    public static int getTabSelectedTextEndColor() {
        return ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_PRIMARY_INFO).intValue();
    }

    @Deprecated
    public static int getTabSelectedTextStartColor() {
        return ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_PRIMARY_INFO).intValue();
    }

    public static int getTabTextColorDef() {
        return ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_SECONDARY_INFO).intValue();
    }

    public static int getTabTextColorSelected() {
        return ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_PRIMARY_INFO).intValue();
    }

    public static int getTextDefaultSizeInPx(Context context) {
        return context.getResources().getDimensionPixelOffset(R.dimen.top_navbar_text);
    }

    public static int getTextSelectedSizeInPx(Context context) {
        return context.getResources().getDimensionPixelOffset(R.dimen.resource_size_20);
    }

    public static int getSkinColor(String str, String str2, String str3) {
        if (TextUtils.isEmpty(SkinManager.getInstance().getSkinPath())) {
            return Integer.MAX_VALUE;
        }
        Integer color = SkinManagerHelper.getInstance().getResourceManager().getColor(SkinManager.getInstance().getSkinPath() + str + str2, str3);
        if (color != null) {
            return color.intValue();
        }
        return Integer.MAX_VALUE;
    }

    public static String getSkinFilePath(String str, String str2) {
        if (TextUtils.isEmpty(SkinManager.getInstance().getSkinPath())) {
            return "";
        }
        return SkinManager.getInstance().getSkinPath() + str + str2;
    }

    public static String getSkinStr(String str, String str2, String str3) {
        String json = SkinResourceUtils.getJson(getSkinFilePath(str, str2));
        try {
            return !TextUtils.isEmpty(json) ? JSON.parseObject(json).getString(str3) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
