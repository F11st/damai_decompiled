package com.uc.webview.export.internal.android;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.uc.webview.export.GeolocationPermissions;
import com.uc.webview.export.PermissionRequest;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebView;
import com.uc.webview.export.internal.interfaces.CommonDef;
import com.uc.webview.export.internal.interfaces.IOpenFileChooser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class i extends WebChromeClientCompatibility implements IOpenFileChooser {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements WebChromeClient.CustomViewCallback {
        private WebChromeClient.CustomViewCallback b;

        public a(WebChromeClient.CustomViewCallback customViewCallback) {
            this.b = customViewCallback;
        }

        @Override // com.uc.webview.export.WebChromeClient.CustomViewCallback
        public final void onCustomViewHidden() {
            WebChromeClient.CustomViewCallback customViewCallback = this.b;
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class b implements GeolocationPermissions.Callback {
        private GeolocationPermissions.Callback b;

        public b(GeolocationPermissions.Callback callback) {
            this.b = callback;
        }

        @Override // com.uc.webview.export.GeolocationPermissions.Callback
        public final void invoke(String str, boolean z, boolean z2) {
            GeolocationPermissions.Callback callback = this.b;
            if (callback != null) {
                callback.invoke(str, z, z2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class c extends PermissionRequest {
        private android.webkit.PermissionRequest a;

        public c(android.webkit.PermissionRequest permissionRequest) {
            this.a = permissionRequest;
        }

        @Override // com.uc.webview.export.PermissionRequest
        public final void deny() {
            this.a.deny();
        }

        @Override // com.uc.webview.export.PermissionRequest
        public final Uri getOrigin() {
            return this.a.getOrigin();
        }

        @Override // com.uc.webview.export.PermissionRequest
        public final String[] getResources() {
            return this.a.getResources();
        }

        @Override // com.uc.webview.export.PermissionRequest
        public final void grant(String[] strArr) {
            this.a.grant(strArr);
        }
    }

    public i(WebView webView, com.uc.webview.export.WebChromeClient webChromeClient) {
        this.a = webView;
        this.b = webChromeClient;
    }

    private void a(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (this.b.onShowFileChooser(this.a, new k(this, valueCallback), new l(this, str, str2))) {
            return;
        }
        this.b.openFileChooser(valueCallback);
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        return this.b.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        return this.b.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.b.getVisitedHistory(valueCallback);
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(android.webkit.WebView webView) {
        this.b.onCloseWindow(this.a);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onConsoleMessage(String str, int i, String str2) {
        this.b.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(android.webkit.WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        com.uc.webview.export.WebView webView2 = this.a;
        webView2.getClass();
        WebView.WebViewTransport webViewTransport2 = new WebView.WebViewTransport();
        Message obtain = Message.obtain(new j(this, Looper.getMainLooper()));
        obtain.obj = webViewTransport2;
        CommonDef.sOnCreateWindowType = 1;
        boolean onCreateWindow = this.b.onCreateWindow(this.a, z, z2, obtain);
        CommonDef.sOnCreateWindowType = 0;
        if (webViewTransport2.getWebView() == null) {
            webViewTransport.setWebView(null);
        } else {
            webViewTransport.setWebView((android.webkit.WebView) webViewTransport2.getWebView().getCoreView());
        }
        if (webViewTransport.getWebView() != null) {
            message.sendToTarget();
        }
        return onCreateWindow;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.b.onGeolocationPermissionsShowPrompt(str, new b(callback));
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        this.b.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        return this.b.onJsAlert(this.a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        return this.b.onJsBeforeUnload(this.a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        return this.b.onJsConfirm(this.a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.b.onJsPrompt(this.a, str, str2, str3, new d(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(android.webkit.PermissionRequest permissionRequest) {
        this.b.onPermissionRequest(new c(permissionRequest));
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(android.webkit.PermissionRequest permissionRequest) {
        this.b.onPermissionRequestCanceled(new c(permissionRequest));
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(android.webkit.WebView webView, int i) {
        this.b.onProgressChanged(this.a, i);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedIcon(android.webkit.WebView webView, Bitmap bitmap) {
        this.b.onReceivedIcon(this.a, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(android.webkit.WebView webView, String str) {
        this.b.onReceivedTitle(this.a, str);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(android.webkit.WebView webView, String str, boolean z) {
        this.b.onReceivedTouchIconUrl(this.a, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public final void onRequestFocus(android.webkit.WebView webView) {
        this.b.onRequestFocus(this.a);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, new a(customViewCallback));
    }

    @Override // com.uc.webview.export.internal.interfaces.IOpenFileChooser
    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        a(valueCallback, str, str2);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(consoleMessage);
    }

    @Override // com.uc.webview.export.internal.interfaces.IOpenFileChooser
    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        a(valueCallback, str, null);
    }

    @Override // com.uc.webview.export.internal.interfaces.IOpenFileChooser
    public final void openFileChooser(ValueCallback<Uri> valueCallback) {
        a(valueCallback, null, null);
    }
}
