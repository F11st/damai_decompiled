package com.ali.user.mobile.utils;

import android.net.Uri;
import android.text.TextUtils;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class StringUtil {
    public static final String CALLBACK = "https://www.alipay.com/webviewbridge";

    public static boolean checkWebviewBridge(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getAuthority());
        sb.append(parse.getPath());
        return CALLBACK.contains(sb.toString());
    }

    public static boolean contains(String str, String str2) {
        return (str == null || str2 == null || !str.contains(str2)) ? false : true;
    }

    public static String dataMasking(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains(m80.DINAMIC_PREFIX_AT)) {
            int indexOf = str.indexOf(m80.DINAMIC_PREFIX_AT);
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf, str.length());
            if (substring.length() >= 3) {
                return substring.substring(0, 3) + "***" + substring2;
            }
            return substring + "***" + substring2;
        } else if (str.matches("1\\d{10}")) {
            String substring3 = str.substring(0, 3);
            String substring4 = str.substring(7, str.length());
            return substring3 + "****" + substring4;
        } else if (str.length() > 1) {
            String substring5 = str.substring(0, 1);
            String substring6 = str.substring(str.length() - 1, str.length());
            return substring5 + "***" + substring6;
        } else {
            return str;
        }
    }
}
