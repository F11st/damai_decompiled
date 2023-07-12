package com.taobao.login4android.session.cookies;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.taobao.login4android.utils.LoginSwitch;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginCookieUtils {
    private static final char COMMA = ',';
    private static final String DOMAIN = "domain";
    private static final char EQUAL = '=';
    private static final String EXPIRES = "expires";
    private static final String HTTPS = "https";
    private static final String HTTP_ONLY = "httponly";
    private static final int HTTP_ONLY_LENGTH = 8;
    private static final String MAX_AGE = "max-age";
    private static final int MAX_COOKIE_LENGTH = 4096;
    private static final String PATH = "path";
    private static final char PATH_DELIM = '/';
    private static final char PERIOD = '.';
    private static final char QUESTION_MARK = '?';
    private static final char QUOTATION = '\"';
    private static final String SECURE = "secure";
    private static final int SECURE_LENGTH = 6;
    private static final char SEMICOLON = ';';
    private static final String TAG = "login.LoginCookieUtils";
    private static final char WHITE_SPACE = ' ';

    public static void expiresCookies(LoginCookie loginCookie) {
        Long l = 1000L;
        loginCookie.expires = l.longValue();
    }

    public static String getHttpDomin(LoginCookie loginCookie) {
        String str = loginCookie.domain;
        if (!TextUtils.isEmpty(str) && str.startsWith(".")) {
            str = str.substring(1);
        }
        if (LoginSwitch.getSwitch("useHttpsDomain", "false")) {
            return "https://" + str;
        }
        return "http://" + str;
    }

    public static String getValue(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            String cookie = cookieManager.getCookie(".taobao.com");
            if (!TextUtils.isEmpty(cookie)) {
                for (String str2 : cookie.split(";")) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2 && str.equals(split2[0].trim())) {
                        int indexOf = str2.indexOf("=");
                        if (split2.length == 2) {
                            return split2[1].trim();
                        }
                        return str2.substring(indexOf + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c5, code lost:
        if (r20.charAt(r7) == r8) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c7, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e8, code lost:
        if (r20.charAt(r7) == r8) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.taobao.login4android.session.cookies.LoginCookie parseCookie(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.login4android.session.cookies.LoginCookieUtils.parseCookie(java.lang.String):com.taobao.login4android.session.cookies.LoginCookie");
    }
}
