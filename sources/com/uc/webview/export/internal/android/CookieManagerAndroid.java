package com.uc.webview.export.internal.android;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.ICookieManager;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public class CookieManagerAndroid implements ICookieManager {
    private CookieManager a = getSystemCookieManager();

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public synchronized boolean acceptCookie() {
        CookieManager cookieManager = this.a;
        if (cookieManager != null) {
            return cookieManager.acceptCookie();
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public boolean acceptThirdPartyCookies(WebView webView) {
        CookieManager cookieManager = this.a;
        if (cookieManager == null || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return cookieManager.acceptThirdPartyCookies((android.webkit.WebView) webView.getCoreView());
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public boolean allowFileSchemeCookiesImpl() {
        if (this.a != null) {
            return CookieManager.allowFileSchemeCookies();
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public void flush() {
        CookieManager cookieManager = this.a;
        if (cookieManager == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        cookieManager.flush();
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public synchronized String getCookie(String str) {
        CookieManager cookieManager = this.a;
        if (cookieManager != null) {
            return cookieManager.getCookie(str);
        }
        return "";
    }

    public CookieManager getSystemCookieManager() {
        try {
            return CookieManager.getInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public synchronized boolean hasCookies() {
        CookieManager cookieManager = this.a;
        if (cookieManager != null) {
            return cookieManager.hasCookies();
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CookieManager cookieManager = this.a;
        if (cookieManager != null && Build.VERSION.SDK_INT >= 21) {
            cookieManager.removeAllCookies(valueCallback);
        } else {
            cookieManager.removeAllCookie();
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        CookieManager cookieManager = this.a;
        if (cookieManager != null && Build.VERSION.SDK_INT >= 21) {
            cookieManager.removeSessionCookies(valueCallback);
        } else {
            cookieManager.removeSessionCookie();
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public synchronized void setAcceptCookie(boolean z) {
        CookieManager cookieManager = this.a;
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(z);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public void setAcceptFileSchemeCookiesImpl(boolean z) {
        if (this.a != null) {
            CookieManager.setAcceptFileSchemeCookies(z);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        CookieManager cookieManager = this.a;
        if (cookieManager == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        cookieManager.setAcceptThirdPartyCookies((android.webkit.WebView) webView.getCoreView(), z);
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public void setCookie(String str, String str2) {
        CookieManager cookieManager = this.a;
        if (cookieManager != null) {
            cookieManager.setCookie(str, str2);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.ICookieManager
    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        CookieManager cookieManager = this.a;
        if (cookieManager == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        cookieManager.setCookie(str, str2, valueCallback);
    }
}
