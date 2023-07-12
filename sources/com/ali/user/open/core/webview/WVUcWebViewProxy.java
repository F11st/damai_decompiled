package com.ali.user.open.core.webview;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WVUcWebViewProxy implements IWebViewProxy {
    private MemberUCWebView mWebView;

    public WVUcWebViewProxy(Context context) {
        this.mWebView = new MemberUCWebView(context);
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void addBridgeObject(String str, Object obj) {
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public boolean canGoBack() {
        return this.mWebView.canGoBack();
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void destroy() {
        this.mWebView.destroy();
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public ViewParent getParent() {
        return this.mWebView.getParent();
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public String getUrl() {
        return this.mWebView.getUrl();
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public View getWebView() {
        return this.mWebView;
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void goBack() {
        this.mWebView.goBack();
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void loadUrl(String str) {
        try {
            this.mWebView.loadUrl(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void onResume() {
        this.mWebView.onResume();
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void removeAllViews() {
        this.mWebView.removeAllViews();
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void resumeTimers() {
        this.mWebView.resumeTimers();
    }
}
