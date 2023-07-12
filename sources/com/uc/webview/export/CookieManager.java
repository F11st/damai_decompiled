package com.uc.webview.export;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.ICookieManager;
import java.util.HashMap;
import tb.jn1;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class CookieManager {
    private static HashMap<Integer, CookieManager> a;
    private ICookieManager b;

    private CookieManager(ICookieManager iCookieManager) {
        this.b = iCookieManager;
    }

    private static synchronized CookieManager a(int i) throws RuntimeException {
        CookieManager cookieManager;
        synchronized (CookieManager.class) {
            if (a == null) {
                a = new HashMap<>();
            }
            cookieManager = a.get(Integer.valueOf(i));
            if (cookieManager == null) {
                cookieManager = new CookieManager(SDKFactory.b(i));
                a.put(Integer.valueOf(i), cookieManager);
            }
        }
        return cookieManager;
    }

    public static boolean allowFileSchemeCookies() {
        return getInstance().b.allowFileSchemeCookiesImpl();
    }

    public static CookieManager getInstance() {
        return a(SDKFactory.e());
    }

    public static void setAcceptFileSchemeCookies(boolean z) {
        getInstance().b.setAcceptFileSchemeCookiesImpl(z);
    }

    public boolean acceptCookie() {
        return this.b.acceptCookie();
    }

    public boolean acceptThirdPartyCookies(WebView webView) {
        return this.b.acceptThirdPartyCookies(webView);
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    public void flush() {
        this.b.flush();
    }

    public String getCookie(String str) {
        return this.b.getCookie(str);
    }

    public boolean hasCookies() {
        return this.b.hasCookies();
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        this.b.removeAllCookies(valueCallback);
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        this.b.removeSessionCookies(valueCallback);
    }

    public void setAcceptCookie(boolean z) {
        this.b.setAcceptCookie(z);
    }

    public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        this.b.setAcceptThirdPartyCookies(webView, z);
    }

    public void setCookie(String str, String str2) {
        this.b.setCookie(str, str2);
    }

    public String toString() {
        return "CookieManager@" + hashCode() + jn1.ARRAY_START_STR + this.b + jn1.ARRAY_END_STR;
    }

    public static CookieManager getInstance(WebView webView) {
        return a(webView.getCurrentViewCoreType());
    }

    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        this.b.setCookie(str, str2, valueCallback);
    }
}
