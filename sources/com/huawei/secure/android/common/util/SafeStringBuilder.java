package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SafeStringBuilder {
    private static final String a = "SafeStringBuilder";
    private static final String b = "";

    public static String substring(StringBuilder sb, int i) {
        if (!TextUtils.isEmpty(sb) && sb.length() >= i && i >= 0) {
            try {
                return sb.substring(i);
            } catch (Exception e) {
                String str = a;
                Log.e(str, "substring exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String substring(StringBuilder sb, int i, int i2) {
        if (!TextUtils.isEmpty(sb) && i >= 0 && i2 <= sb.length() && i2 >= i) {
            try {
                return sb.substring(i, i2);
            } catch (Exception e) {
                String str = a;
                Log.e(str, "substring: " + e.getMessage());
            }
        }
        return "";
    }
}
