package com.ali.user.open.cookies;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginCookieUtils {
    private static final char COMMA = ',';
    private static final String DISCARD = "discard";
    private static final int DISCARD_LENGTH = 7;
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
    private static final String VERSION = "version";
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
        return "https://" + str;
    }

    public static JSONObject getKeyValues(String str) {
        String[] split;
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            String cookie = CookieManagerService.getWebViewProxy().getCookie(".taobao.com");
            if (!TextUtils.isEmpty(cookie)) {
                for (String str2 : cookie.split(";")) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2 && split2[0].contains(str)) {
                        if (split2.length == 2) {
                            jSONObject.put(split2[0].trim(), split2[1].trim());
                        } else {
                            jSONObject.put(split2[0].trim(), str2.substring(str2.indexOf("=") + 1));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static String getValue(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String cookie = CookieManagerService.getWebViewProxy().getCookie(".taobao.com");
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
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e9, code lost:
        if (r20.charAt(r7) == r8) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0109, code lost:
        if (r20.charAt(r7) == r8) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.ali.user.open.cookies.LoginCookie parseCookie(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.open.cookies.LoginCookieUtils.parseCookie(java.lang.String):com.ali.user.open.cookies.LoginCookie");
    }
}
