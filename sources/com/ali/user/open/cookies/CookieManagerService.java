package com.ali.user.open.cookies;

import com.ali.user.open.core.WebViewProxy;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.webview.DefaultWebViewProxy;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CookieManagerService {
    private CookieManagerService() {
    }

    public static WebViewProxy getWebViewProxy() {
        WebViewProxy webViewProxy = KernelContext.mWebViewProxy;
        return webViewProxy != null ? webViewProxy : DefaultWebViewProxy.getInstance();
    }
}
