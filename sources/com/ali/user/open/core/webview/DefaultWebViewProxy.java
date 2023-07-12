package com.ali.user.open.core.webview;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ali.user.open.core.WebViewProxy;
import com.ali.user.open.core.context.KernelContext;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DefaultWebViewProxy implements WebViewProxy {
    private static volatile DefaultWebViewProxy instance;

    private DefaultWebViewProxy() {
    }

    public static DefaultWebViewProxy getInstance() {
        if (instance == null) {
            synchronized (DefaultWebViewProxy.class) {
                if (instance == null) {
                    instance = new DefaultWebViewProxy();
                }
            }
        }
        return instance;
    }

    @Override // com.ali.user.open.core.WebViewProxy
    public void flush() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.createInstance(KernelContext.getApplicationContext()).sync();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ali.user.open.core.WebViewProxy
    public String getCookie(String str) {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        return cookieManager.getCookie(".taobao.com");
    }

    @Override // com.ali.user.open.core.WebViewProxy
    public void removeAllCookie() {
        CookieManager.getInstance().removeAllCookie();
    }

    @Override // com.ali.user.open.core.WebViewProxy
    public void removeExpiredCookie() {
        CookieManager.getInstance().removeExpiredCookie();
    }

    @Override // com.ali.user.open.core.WebViewProxy
    public void removeSessionCookie() {
        CookieManager.getInstance().removeSessionCookie();
    }

    @Override // com.ali.user.open.core.WebViewProxy
    public void setAcceptCookie(boolean z) {
        CookieManager.getInstance().setAcceptCookie(z);
    }

    @Override // com.ali.user.open.core.WebViewProxy
    public void setCookie(String str, String str2) {
        CookieManager.getInstance().setCookie(str, str2);
    }
}
