package com.uc.webview.export.internal.interfaces;

import android.webkit.ValueCallback;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface ICookieManager {
    boolean acceptCookie();

    boolean acceptThirdPartyCookies(WebView webView);

    boolean allowFileSchemeCookiesImpl();

    void flush();

    String getCookie(String str);

    boolean hasCookies();

    void removeAllCookies(ValueCallback<Boolean> valueCallback);

    void removeSessionCookies(ValueCallback<Boolean> valueCallback);

    void setAcceptCookie(boolean z);

    void setAcceptFileSchemeCookiesImpl(boolean z);

    void setAcceptThirdPartyCookies(WebView webView, boolean z);

    void setCookie(String str, String str2);

    void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback);
}
