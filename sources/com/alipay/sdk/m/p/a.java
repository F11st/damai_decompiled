package com.alipay.sdk.m.p;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("&");
        if (split.length == 0) {
            return "";
        }
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        for (String str6 : split) {
            if (TextUtils.isEmpty(str2)) {
                str2 = e(str6);
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = d(str6);
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = f(str6);
            }
            if (TextUtils.isEmpty(str5)) {
                str5 = c(str6);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb.append("biz_type=" + str2 + ";");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append("biz_no=" + str3 + ";");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("trade_no=" + str4 + ";");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append("app_userid=" + str5 + ";");
        }
        String sb2 = sb.toString();
        return sb2.endsWith(";") ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    public static String b(String str) {
        String[] split = str.split("=");
        if (split.length > 1) {
            String str2 = split[1];
            return str2.contains("\"") ? str2.replaceAll("\"", "") : str2;
        }
        return null;
    }

    public static String c(String str) {
        if (str.contains("app_userid")) {
            return b(str);
        }
        return null;
    }

    public static String d(String str) {
        if (str.contains("biz_no")) {
            return b(str);
        }
        return null;
    }

    public static String e(String str) {
        if (str.contains("biz_type")) {
            return b(str);
        }
        return null;
    }

    public static String f(String str) {
        if (!str.contains(com.alipay.sdk.m.k.b.B0) || str.startsWith(com.alipay.sdk.m.k.b.A0)) {
            return null;
        }
        return b(str);
    }
}
