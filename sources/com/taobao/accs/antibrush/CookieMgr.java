package com.taobao.accs.antibrush;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.analysis.StageType;
import com.uc.webview.export.extension.UCCore;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CookieMgr {
    public static final String KEY_SEC = "sec";
    public static final String TAG = "CookieMgr";
    private static volatile boolean isSetup;
    public static CookieManager webkitCookMgr;

    private static boolean checkSetup() {
        Context context;
        if (!isSetup && (context = GlobalClientInfo.mContext) != null) {
            setup(context);
        }
        return isSetup;
    }

    public static synchronized String getCookieSec(String str) {
        synchronized (CookieMgr.class) {
            if (!checkSetup()) {
                ALog.e(TAG, "cookieMgr not setup", new Object[0]);
                return null;
            }
            return parse(webkitCookMgr.getCookie(str));
        }
    }

    public static String parse(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        do {
            try {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf != -1) {
                    String trim = nextToken.substring(0, indexOf).trim();
                    String trim2 = nextToken.substring(indexOf + 1).trim();
                    if (KEY_SEC.equals(trim)) {
                        str2 = stripOffSurroundingQuote(trim2);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid cookie name-value pair");
                }
            } catch (Throwable th) {
                ALog.e(TAG, StageType.PARSE, th, new Object[0]);
            }
        } while (stringTokenizer.hasMoreTokens());
        return str2;
    }

    public static synchronized void setup(Context context) {
        synchronized (CookieMgr.class) {
            try {
            } catch (Throwable th) {
                ALog.e(TAG, UCCore.LEGACY_EVENT_SETUP, th, new Object[0]);
            }
            if (!GlobalConfig.enableCookie) {
                ALog.i(TAG, "disable cookie", new Object[0]);
            } else if (isSetup) {
            } else {
                int i = Build.VERSION.SDK_INT;
                if (i < 21) {
                    CookieSyncManager.createInstance(context);
                }
                CookieManager cookieManager = CookieManager.getInstance();
                webkitCookMgr = cookieManager;
                cookieManager.setAcceptCookie(true);
                if (i < 21) {
                    webkitCookMgr.removeExpiredCookie();
                }
                isSetup = true;
            }
        }
    }

    private static String stripOffSurroundingQuote(String str) {
        if (str == null || str.length() <= 2 || str.charAt(0) != '\"' || str.charAt(str.length() - 1) != '\"') {
            return (str == null || str.length() <= 2 || str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') ? str : str.substring(1, str.length() - 1);
        }
        return str.substring(1, str.length() - 1);
    }
}
