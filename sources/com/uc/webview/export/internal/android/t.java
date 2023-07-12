package com.uc.webview.export.internal.android;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebViewClient;
import com.uc.webview.export.WebResourceError;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IPreloadManager;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class t extends WebViewClient {
    private WebView a;
    private com.uc.webview.export.WebViewClient b;

    /* compiled from: Taobao */
    @TargetApi(23)
    /* loaded from: classes11.dex */
    static class a extends WebResourceError {
        private final android.webkit.WebResourceError a;

        public a(android.webkit.WebResourceError webResourceError) {
            this.a = webResourceError;
        }

        @Override // com.uc.webview.export.WebResourceError
        public final CharSequence getDescription() {
            return this.a.getDescription();
        }

        @Override // com.uc.webview.export.WebResourceError
        public final int getErrorCode() {
            return this.a.getErrorCode();
        }
    }

    public t(WebView webView, com.uc.webview.export.WebViewClient webViewClient) {
        this.a = webView;
        this.b = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
        this.b.doUpdateVisitedHistory(this.a, str, z);
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(android.webkit.WebView webView, Message message, Message message2) {
        this.b.onFormResubmission(this.a, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(android.webkit.WebView webView, String str) {
        this.b.onLoadResource(this.a, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(android.webkit.WebView webView, String str) {
        IWaStat.WaStat.statPV(str);
        IWaStat.WaStat.stat(IWaStat.KEY_SYSTEM_WEBVIEW_PV);
        this.b.onPageFinished(this.a, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
        this.b.onPageStarted(this.a, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(android.webkit.WebView webView, int i, String str, String str2) {
        this.b.onReceivedError(this.a, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(android.webkit.WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        com.uc.webview.export.WebViewClient webViewClient = this.b;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(this.a, new c(httpAuthHandler), str, str2);
        } else {
            httpAuthHandler.cancel();
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public final void onReceivedHttpError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        com.uc.webview.export.WebResourceRequest webResourceRequest2 = new com.uc.webview.export.WebResourceRequest(webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders(), webResourceRequest.getUrl(), webResourceRequest.hasGesture(), webResourceRequest.isForMainFrame());
        com.uc.webview.export.WebResourceResponse webResourceResponse2 = new com.uc.webview.export.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
        webResourceResponse2.setStatusCodeAndReasonPhrase(webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
        webResourceResponse2.setResponseHeaders(webResourceResponse.getResponseHeaders());
        this.b.onReceivedHttpError(this.a, webResourceRequest2, webResourceResponse2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(android.webkit.WebView webView, String str, String str2, String str3) {
        this.b.onReceivedLoginRequest(this.a, str, str2, str3);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(android.webkit.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.b.onReceivedSslError(this.a, new g(sslErrorHandler), sslError);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public final boolean onRenderProcessGone(android.webkit.WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean onRenderProcessGone = this.b.onRenderProcessGone(this.a, new u(this, renderProcessGoneDetail));
        Log.w("WebViewClientAndroid", "onRenderProcessGone, res: " + onRenderProcessGone);
        return onRenderProcessGone;
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(android.webkit.WebView webView, float f, float f2) {
        this.b.onScaleChanged(this.a, f, f2);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.onUnhandledKeyEvent(this.a, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
        WebSettings settings;
        String preCacheScope;
        IPreloadManager n;
        com.uc.webview.export.WebResourceResponse shouldInterceptRequest = this.b.shouldInterceptRequest(this.a, str);
        if (shouldInterceptRequest == null) {
            try {
                WebView webView2 = this.a;
                if (webView2 != null && !webView2.isDestroied() && (settings = this.a.getSettings()) != null && (preCacheScope = settings.getPreCacheScope()) != null && preCacheScope.length() > 0 && (n = SDKFactory.n()) != null) {
                    shouldInterceptRequest = n.getPreloadResource(preCacheScope, "common", str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (shouldInterceptRequest == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        if (Build.VERSION.SDK_INT >= 21) {
            webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
            if (shouldInterceptRequest.getReasonPhrase() != null) {
                webResourceResponse.setStatusCodeAndReasonPhrase(shouldInterceptRequest.getStatusCode(), shouldInterceptRequest.getReasonPhrase());
            }
        }
        return webResourceResponse;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        return this.b.shouldOverrideKeyEvent(this.a, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        return this.b.shouldOverrideUrlLoading(this.a, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public final void onReceivedError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
        if (webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
        this.b.onReceivedError(this.a, new com.uc.webview.export.WebResourceRequest(webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders(), webResourceRequest.getUrl(), webResourceRequest.hasGesture(), webResourceRequest.isForMainFrame()), new a(webResourceError));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
        return this.b.shouldOverrideUrlLoading(this.a, new com.uc.webview.export.WebResourceRequest(webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders(), webResourceRequest.getUrl().toString(), webResourceRequest.hasGesture(), webResourceRequest.isForMainFrame()));
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
        com.uc.webview.export.WebResourceRequest webResourceRequest2;
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return null;
        }
        try {
            if (i >= 24) {
                webResourceRequest2 = new com.uc.webview.export.WebResourceRequest(webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders(), webResourceRequest.getUrl().toString(), webResourceRequest.hasGesture(), webResourceRequest.isForMainFrame(), webResourceRequest.isRedirect());
            } else {
                webResourceRequest2 = new com.uc.webview.export.WebResourceRequest(webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders(), webResourceRequest.getUrl().toString(), webResourceRequest.hasGesture(), webResourceRequest.isForMainFrame());
            }
            com.uc.webview.export.WebResourceResponse shouldInterceptRequest = this.b.shouldInterceptRequest(this.a, webResourceRequest2);
            if (shouldInterceptRequest == null) {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
            webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
            if (shouldInterceptRequest.getReasonPhrase() != null) {
                webResourceResponse.setStatusCodeAndReasonPhrase(shouldInterceptRequest.getStatusCode(), shouldInterceptRequest.getReasonPhrase());
            }
            return webResourceResponse;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
