package com.huawei.hms.framework.common;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SystemPropUtils {
    private static final String TAG = "SystemPropUtils";

    public static String getProperty(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                Class<?> cls = Class.forName(str3);
                return (String) cls.getMethod(str, String.class, String.class).invoke(cls, str2, str4);
            } catch (Exception e) {
                Logger.e(TAG, "getProperty catch exception: ", e);
                return str4;
            }
        }
        Logger.w(TAG, "reflect class for method has exception.");
        return str4;
    }
}
