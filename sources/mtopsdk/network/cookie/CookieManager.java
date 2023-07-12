package mtopsdk.network.cookie;

import android.content.Context;
import android.webkit.CookieSyncManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CookieManager {
    public static final String TAG = "mtopsdk.CookieManager";
    private static volatile boolean isSetup;
    public static android.webkit.CookieManager webkitCookMgr;

    public static synchronized String getCookie(String str) {
        synchronized (CookieManager.class) {
            if (isSetup) {
                return webkitCookMgr.getCookie(str);
            }
            return null;
        }
    }

    public static synchronized void setCookie(String str, String str2) {
        synchronized (CookieManager.class) {
            if (isSetup) {
                webkitCookMgr.setCookie(str, str2);
                CookieSyncManager.getInstance().sync();
            }
        }
    }

    public static synchronized void setup(Context context) {
        synchronized (CookieManager.class) {
            if (!isSetup && context != null) {
                CookieSyncManager.createInstance(context);
                android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
                webkitCookMgr = cookieManager;
                cookieManager.setAcceptCookie(true);
                webkitCookMgr.removeExpiredCookie();
                isSetup = true;
            }
        }
    }
}
