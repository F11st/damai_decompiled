package com.ali.user.mobile.login;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginFrom {
    public static final String ALIPAY = "7";
    public static final String OTHER = "10";
    public static final String PWD = "4";
    public static final String QQ = "3";
    public static final String REGISTER = "9";
    public static final String SMS = "5";
    public static final String TAOBAO = "6";
    public static final String WECHAT = "1";
    public static final String WEIBO = "2";
    private static String sCurrentLoginFrom = "";

    public static String getLoginFrom() {
        return sCurrentLoginFrom;
    }

    public static void setCurrentLoginFrom(String str) {
        sCurrentLoginFrom = str;
    }
}
