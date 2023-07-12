package com.huawei.secure.android.common.webview;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SafeWebSettings {
    public static void disableContentAccess(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 11) {
            webSettings.setAllowContentAccess(false);
        }
    }

    public static void disableFileCrossAccess(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
    }

    public static void disableGeolocation(WebSettings webSettings) {
        webSettings.setGeolocationEnabled(false);
    }

    public static void disableMixedContentMode(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(1);
        }
    }

    public static void disablePasswordStorage(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT <= 18) {
            webSettings.setSavePassword(false);
        }
    }

    public static void initWebviewAndSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        disableFileCrossAccess(settings);
        removeUnSafeJavascriptImpl(webView);
        disablePasswordStorage(settings);
        disableGeolocation(settings);
        disableMixedContentMode(settings);
        disableContentAccess(settings);
    }

    public static void removeUnSafeJavascriptImpl(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
    }
}
