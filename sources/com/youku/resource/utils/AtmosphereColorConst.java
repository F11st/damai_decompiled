package com.youku.resource.utils;

import android.graphics.Color;
import android.text.TextUtils;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AtmosphereColorConst {
    public static String galleryGradientBottomColor;
    public static String galleryGradientTopColor;
    public static String homeHotWordTextColor;
    private static boolean isDark;
    public static String navBgColor;
    public static String navBgImg;
    public static String navBgSubColor;
    public static String navColor;
    public static String navIconColor;
    public static String navIndicatorColor;
    public static String navSelectImg;
    public static String navSubColor;
    public static String refreshBgColor;

    static {
        boolean isDarkMode = UIMode.getInstance().isDarkMode();
        isDark = isDarkMode;
        navBgColor = "#1C2029";
        navBgSubColor = "#12FFFFFF";
        navIconColor = "#FFFFFF";
        navColor = "#FFFFFF";
        navSubColor = "#CCFFFFFF";
        navIndicatorColor = "#FFFFFF";
        refreshBgColor = isDarkMode ? "#21283c" : "#2E4F7B";
        navBgImg = "";
        navSelectImg = "";
        galleryGradientTopColor = isDarkMode ? "#21283c" : "#2E4F7B";
        galleryGradientBottomColor = isDarkMode ? "#455a64" : "#ADE8EB";
        homeHotWordTextColor = "#CCFFFFFF";
    }

    public static boolean isDefaultColor(String str, int i) {
        Field[] fields;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (Field field : AtmosphereColorConst.class.getFields()) {
            field.setAccessible(true);
            try {
                if (str.equalsIgnoreCase(field.getName()) && i == Color.parseColor((String) field.get(null))) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isDefaultColor(String str, String str2) {
        try {
            return isDefaultColor(str, Color.parseColor(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
