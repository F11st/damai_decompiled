package com.youku.playerservice.axp.utils;

import android.text.TextUtils;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemUtil {
    private static String mHiAiVersion = "";

    public static String getHiAiVersion() {
        if (TextUtils.isEmpty(mHiAiVersion)) {
            String systemProperty = getSystemProperty("ro.vendor.hiaiversion", "");
            mHiAiVersion = systemProperty;
            return systemProperty;
        }
        return mHiAiVersion;
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
