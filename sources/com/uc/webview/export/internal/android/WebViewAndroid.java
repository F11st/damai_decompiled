package com.uc.webview.export.internal.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintDocumentAdapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.uc.webview.export.DownloadListener;
import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebMessage;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.ICommonExtension;
import com.uc.webview.export.internal.interfaces.IUCExtension;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.IWebViewOverride;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public class WebViewAndroid extends WebView implements IWebView {
    private com.uc.webview.export.WebView a;
    private IWebViewOverride b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements IWebView.IHitTestResult {
        private WebView.HitTestResult b;

        /* synthetic */ a(WebViewAndroid webViewAndroid, WebView.HitTestResult hitTestResult, byte b) {
            this(hitTestResult);
        }

        @Override // com.uc.webview.export.internal.interfaces.IWebView.IHitTestResult
        public final String getExtra() {
            return this.b.getExtra();
        }

        @Override // com.uc.webview.export.internal.interfaces.IWebView.IHitTestResult
        public final int getType() {
            return this.b.getType();
        }

        private a(WebView.HitTestResult hitTestResult) {
            this.b = hitTestResult;
        }
    }

    public WebViewAndroid(Context context, AttributeSet attributeSet, com.uc.webview.export.WebView webView) {
        super(context, attributeSet);
        this.a = webView;
        setWebViewClient(new t(webView, new WebViewClient()));
        getSettings().setSavePassword(false);
        IWaStat.WaStat.stat(IWaStat.KEY_SYSTEM_NEW_WEBVIEW_PV);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void clearClientCertPreferencesNoStatic(Runnable runnable) {
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreComputeScroll();
        } else {
            super.computeScroll();
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public WebBackForwardList copyBackForwardListInner() {
        android.webkit.WebBackForwardList copyBackForwardList = super.copyBackForwardList();
        if (copyBackForwardList != null) {
            return new h(copyBackForwardList);
        }
        return null;
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public PrintDocumentAdapter createPrintDocumentAdapter(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.createPrintDocumentAdapter(str);
        }
        return null;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    @TargetApi(23)
    public Object createWebMessageChannelInner() {
        WebMessagePort[] createWebMessageChannel = super.createWebMessageChannel();
        if (createWebMessageChannel == null) {
            return null;
        }
        n[] nVarArr = new n[createWebMessageChannel.length];
        for (int i = 0; i < createWebMessageChannel.length; i++) {
            nVarArr[i] = new n(createWebMessageChannel[i]);
        }
        return nVarArr;
    }

    @Override // android.webkit.WebView, com.uc.webview.export.internal.interfaces.IWebView
    public void destroy() {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreDestroy();
        } else {
            super.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            return iWebViewOverride.coreDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreDraw(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.webkit.WebView, com.uc.webview.export.internal.interfaces.IWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // android.webkit.WebView, com.uc.webview.export.internal.interfaces.IWebView
    public void findAllAsync(String str) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.findAllAsync(str);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public ICommonExtension getCommonExtension() {
        return this;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public IWebView.IHitTestResult getHitTestResultInner() {
        WebView.HitTestResult hitTestResult = super.getHitTestResult();
        if (hitTestResult != null) {
            return new a(this, hitTestResult, (byte) 0);
        }
        return null;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public IWebViewOverride getOverrideObject() {
        return this.b;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public WebSettings getSettingsInner() {
        return new p(super.getSettings());
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public IUCExtension getUCExtension() {
        return null;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public View getView() {
        return this;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void notifyForegroundChanged(boolean z) {
    }

    @Override // android.webkit.WebView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreOnConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.webkit.WebView, android.view.View, com.uc.webview.export.internal.interfaces.IWebView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreOnScrollChanged(i, i2, i3, i4);
        } else {
            super.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreOnVisibilityChanged(view, i);
        } else {
            super.onVisibilityChanged(view, i);
        }
    }

    @Override // android.view.View
    @TargetApi(9)
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            IWebViewOverride iWebViewOverride = this.b;
            if (iWebViewOverride != null) {
                return iWebViewOverride.coreOverScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void postVisualStateCallback(long j, WebView.b bVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            super.postVisualStateCallback(j, new s(this, bVar));
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    @TargetApi(23)
    public void postWebMessageInner(WebMessage webMessage, Uri uri) {
        super.postWebMessage(new m(webMessage), uri);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreRequestLayout();
        } else {
            super.requestLayout();
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public WebBackForwardList restoreStateInner(Bundle bundle) {
        android.webkit.WebBackForwardList restoreState = super.restoreState(bundle);
        if (restoreState == null) {
            return null;
        }
        return new h(restoreState);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public WebBackForwardList saveStateInner(Bundle bundle) {
        android.webkit.WebBackForwardList saveState = super.saveState(bundle);
        if (saveState == null) {
            return null;
        }
        return new h(saveState);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void setDownloadListener(DownloadListener downloadListener) {
        if (downloadListener == null) {
            super.setDownloadListener((android.webkit.DownloadListener) null);
        } else {
            super.setDownloadListener(new com.uc.webview.export.internal.android.a(downloadListener));
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void setFindListener(WebView.FindListener findListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.setFindListener(findListener == null ? null : new r(this, findListener));
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void setOverrideObject(IWebViewOverride iWebViewOverride) {
        this.b = iWebViewOverride;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreSetVisibility(i);
        } else {
            super.setVisibility(i);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webChromeClient == null) {
            super.setWebChromeClient((android.webkit.WebChromeClient) null);
        } else {
            super.setWebChromeClient(new i(this.a, webChromeClient));
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient == null) {
            webViewClient = new WebViewClient();
        }
        setWebViewClient(new t(this.a, webViewClient));
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void superComputeScroll() {
        super.computeScroll();
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void superDestroy() {
        super.destroy();
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void superDraw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void superOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void superOnInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreOnInitializeAccessibilityEvent(accessibilityEvent);
        } else {
            onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public void superOnInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            iWebViewOverride.coreOnInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        } else {
            onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void superOnScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void superOnVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public boolean superOverScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public boolean superPerformAccessibilityAction(int i, Bundle bundle) {
        IWebViewOverride iWebViewOverride = this.b;
        if (iWebViewOverride != null) {
            return iWebViewOverride.corePerformAccessibilityAction(i, bundle);
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void superRequestLayout() {
        super.requestLayout();
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebView
    public void superSetVisibility(int i) {
        super.setVisibility(i);
    }
}
