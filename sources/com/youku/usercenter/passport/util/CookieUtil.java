package com.youku.usercenter.passport.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.youku.usercenter.passport.PassportManager;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CookieUtil {
    public static final String COOKIE_KEY_APPID = "P_appid  ";
    public static final String COOKIE_KEY_DEVICE = "P_deviceid";
    public static final String COOKIE_KEY_PTOKEN = "P_pck_rm";
    public static final String COOKIE_KEY_SDK = "passport_sdk";
    public static final String COOKIE_KEY_STOEKN = "P_sck";
    public static final String COOKIE_KEY_YKTK = "yktk";
    public static final String COOKIE_VALUE_DELETED = "";
    public static final String COOKIE_VALUE_SDK = "Android1.8.5.13_damai";
    public static final String DOMAIN_ALIGAMES = "aligames.com";
    public static final String DOMAIN_LAIFENG = "laifeng.com";
    public static final String DOMAIN_LAIWANTV = "laiwantv.com";
    public static final String DOMAIN_SECURITY = "id.youku.com";
    public static final String DOMAIN_SOKU = "soku.com";
    public static final String DOMAIN_TEST1 = "heyi.test";
    public static final String DOMAIN_TEST2 = "1verge.test";
    public static final String DOMAIN_TUDOU = "tudou.com";
    public static final String DOMAIN_YOUKU = "youku.com";
    private static boolean sDebug;

    public static void checkMarkSDK(Context context) {
        try {
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            String cookie = cookieManager.getCookie(DOMAIN_YOUKU);
            if (TextUtils.isEmpty(cookie) || !cookie.contains("passport_sdk=Android")) {
                setCookie(cookieManager, COOKIE_KEY_SDK, COOKIE_VALUE_SDK, false);
                cookieManager.setCookie(DOMAIN_SECURITY, generateCookie(DOMAIN_SECURITY, COOKIE_KEY_DEVICE, SysUtil.getDeviceId(context), false));
                cookieManager.setCookie(DOMAIN_SECURITY, generateCookie(DOMAIN_SECURITY, COOKIE_KEY_APPID, PassportManager.getInstance().getConfig().mAppId, false));
                if (Build.VERSION.SDK_INT >= 21) {
                    cookieManager.flush();
                } else {
                    createInstance.sync();
                }
            }
        } catch (Throwable th) {
            Logger.e("CookieManager Exception");
            Logger.printStackTrace(th);
        }
    }

    public static void clearCookie(Context context) {
        try {
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            setCookie(cookieManager, "P_sck", "", true);
            setCookie(cookieManager, COOKIE_KEY_YKTK, "", false);
            setCookie(cookieManager, COOKIE_KEY_PTOKEN, "", false);
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.flush();
            } else {
                createInstance.sync();
            }
        } catch (Throwable th) {
            Logger.e("CookieManager Exception");
            Logger.printStackTrace(th);
        }
    }

    public static void clearExtraCookie(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                cookieManager.setCookie(DOMAIN_YOUKU, generateCookie(DOMAIN_YOUKU, keys.next(), "", false));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.flush();
            } else {
                createInstance.sync();
            }
        } catch (Throwable th) {
            Logger.printStackTrace(th);
        }
    }

    public static void clearStoken(Context context) {
        try {
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            setCookie(cookieManager, "P_sck", "", true);
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.flush();
            } else {
                createInstance.sync();
            }
        } catch (Throwable th) {
            Logger.e("CookieManager Exception");
            Logger.printStackTrace(th);
        }
    }

    private static String generateCookie(String str, String str2, String str3, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append(";");
        sb.append("domain=");
        sb.append(str);
        sb.append(";");
        sb.append("path=/;");
        if (z) {
            sb.append("HttpOnly");
        }
        return sb.toString();
    }

    public static void markSDK(Context context, String str, boolean z) {
        try {
            sDebug = z;
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            setCookie(cookieManager, COOKIE_KEY_SDK, COOKIE_VALUE_SDK, false);
            cookieManager.setCookie(DOMAIN_SECURITY, generateCookie(DOMAIN_SECURITY, COOKIE_KEY_DEVICE, SysUtil.getDeviceId(context), false));
            cookieManager.setCookie(DOMAIN_SECURITY, generateCookie(DOMAIN_SECURITY, COOKIE_KEY_APPID, str, false));
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.flush();
            } else {
                createInstance.sync();
            }
        } catch (Throwable th) {
            Logger.e("CookieManager Exception");
            Logger.printStackTrace(th);
        }
    }

    private static void setCookie(CookieManager cookieManager, String str, String str2, boolean z) {
        cookieManager.setCookie(DOMAIN_YOUKU, generateCookie(DOMAIN_YOUKU, str, str2, z));
        cookieManager.setCookie(DOMAIN_LAIFENG, generateCookie(DOMAIN_LAIFENG, str, str2, z));
        cookieManager.setCookie(DOMAIN_LAIWANTV, generateCookie(DOMAIN_LAIWANTV, str, str2, z));
        cookieManager.setCookie(DOMAIN_TUDOU, generateCookie(DOMAIN_TUDOU, str, str2, z));
        cookieManager.setCookie(DOMAIN_SOKU, generateCookie(DOMAIN_SOKU, str, str2, z));
        cookieManager.setCookie(DOMAIN_ALIGAMES, generateCookie(DOMAIN_ALIGAMES, str, str2, z));
        if (sDebug) {
            cookieManager.setCookie(DOMAIN_TEST1, generateCookie(DOMAIN_TEST1, str, str2, z));
            cookieManager.setCookie(DOMAIN_TEST2, generateCookie(DOMAIN_TEST2, str, str2, z));
        }
    }

    public static void syncCookie(Context context, String str, String str2) {
        try {
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            if (!TextUtils.isEmpty(str)) {
                setCookie(cookieManager, "P_sck", str, true);
                setCookie(cookieManager, COOKIE_KEY_PTOKEN, "", false);
            }
            if (!TextUtils.isEmpty(str2)) {
                setCookie(cookieManager, COOKIE_KEY_YKTK, str2, false);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.flush();
            } else {
                createInstance.sync();
            }
        } catch (Throwable th) {
            Logger.e("CookieManager Exception");
            Logger.printStackTrace(th);
        }
    }

    public static void syncExtraCookie(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                cookieManager.setCookie(DOMAIN_YOUKU, generateCookie(DOMAIN_YOUKU, next, jSONObject.optString(next), false));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.flush();
            } else {
                createInstance.sync();
            }
        } catch (Throwable th) {
            Logger.printStackTrace(th);
        }
    }
}
