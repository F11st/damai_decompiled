package com.taobao.ma.util;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StringUtils {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNull(String str) {
        return str == null || "null".equals(str);
    }

    public static String nullToString(String str) {
        return isNull(str) ? "" : str;
    }
}
