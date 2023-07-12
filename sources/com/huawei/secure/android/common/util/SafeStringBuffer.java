package com.huawei.secure.android.common.util;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SafeStringBuffer {
    private static final String a = "SafeStringBuffer";
    private static final String b = "";

    public static String substring(StringBuffer stringBuffer, int i) {
        if (stringBuffer != null && stringBuffer.length() >= i && i >= 0) {
            try {
                return stringBuffer.substring(i);
            } catch (Exception e) {
                String str = a;
                Log.e(str, "substring exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String substring(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer != null && i >= 0 && i2 <= stringBuffer.length() && i2 >= i) {
            try {
                return stringBuffer.substring(i, i2);
            } catch (Exception e) {
                String str = a;
                Log.e(str, "substring: " + e.getMessage());
            }
        }
        return "";
    }
}
