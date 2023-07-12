package com.alibaba.security.realidentity.utils;

import android.content.SharedPreferences;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum FrontLightMode {
    ON,
    AUTO,
    OFF;

    private static FrontLightMode parse(String str) {
        return str == null ? OFF : valueOf(str);
    }

    public static FrontLightMode readPref(SharedPreferences sharedPreferences) {
        return parse(sharedPreferences.getString("preferences_front_light_mode", OFF.toString()));
    }
}
