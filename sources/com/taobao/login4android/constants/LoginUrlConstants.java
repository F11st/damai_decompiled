package com.taobao.login4android.constants;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginUrlConstants {
    private static final String ALIBABA_SCAN_PREFIX = "m.alibaba.com/qr?";
    private static final String BASE_URL = "//login.m.taobao.com";
    private static final String COMMON_SCAN_URL = "login.m.taobao.com/qrcodeCheck.htm?";
    private static final String COMMON_SCAN_URL_PRE = "login.wapa.taobao.com/qrcodeCheck.htm?";
    private static final String LOGIN_URLS = "((https|http)://)login.(m|wapa|waptest).(taobao|tmall).com/(login/){0,1}login.htm(.*);((https|http)://)login.tmall.com(.*);((https|http)://)login.taobao.com/member/login.jhtml(.*);(http|https)://login.(taobao|tmall).com/login/(.*);http://login.m.taobao.com/minisdk/login.htm;https://oauth.m.taobao.com/authorize";
    private static final String LOGOUT_URLS = "((https|http)://)login.(m|wapa|waptest).(taobao|tmall).com/(login/){0,1}logout.htm(.*)";
    private static final String SCAN_LOGIN = "/qrcodeLogin.htm?shortURL=";

    public static String getLoginUrls() {
        return LOGIN_URLS;
    }

    public static String getLogoutUrls() {
        return LOGOUT_URLS;
    }

    public static String getScanLoginUrl() {
        return "//login.m.taobao.com/qrcodeLogin.htm?shortURL=";
    }

    public static boolean isAlibabaScanUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(ALIBABA_SCAN_PREFIX);
    }

    public static boolean isCommonScanUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(COMMON_SCAN_URL) || str.contains(COMMON_SCAN_URL_PRE);
    }
}
