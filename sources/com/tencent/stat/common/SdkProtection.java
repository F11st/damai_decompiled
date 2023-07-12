package com.tencent.stat.common;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SdkProtection {
    static long valueNotSet = -1;

    public static boolean beginCheck(Context context) {
        long preferencesValue = getPreferencesValue(context, "1.0.0_begin_protection");
        long preferencesValue2 = getPreferencesValue(context, "1.0.0_end__protection");
        if (preferencesValue <= 0 || preferencesValue2 != valueNotSet) {
            if (preferencesValue == valueNotSet) {
                setPreferencesValue(context, "1.0.0_begin_protection", System.currentTimeMillis());
                return true;
            }
            return true;
        }
        return false;
    }

    public static void endCheck(Context context) {
        if (getPreferencesValue(context, "1.0.0_end__protection") == valueNotSet) {
            setPreferencesValue(context, "1.0.0_end__protection", System.currentTimeMillis());
        }
    }

    static long getPreferencesValue(Context context, String str) {
        return StatPreferences.getLong(context, str, valueNotSet);
    }

    static void setPreferencesValue(Context context, String str, long j) {
        StatPreferences.putLong(context, str, j);
    }
}
