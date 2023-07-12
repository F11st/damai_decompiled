package com.ali.user.mobile.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.util.AttributeSet;
import com.uc.webview.export.WebSettings;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class LoginWebView extends WVUCWebView {
    private static String TAG = "login.LoginWebView";

    public LoginWebView(Context context) {
        super(context);
    }

    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    public void init() {
        setVerticalScrollbarOverlay(true);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(this.context.getDir("cache", 0).getPath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        settings.setBuiltInZoomControls(false);
        try {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LoginWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LoginWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
