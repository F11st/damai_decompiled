package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.alibaba.aliweex.adapter.IEventModuleAdapter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXWeb;
import com.taobao.weex.ui.view.IWebView;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.uc.webview.export.JsPromptResult;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tb.jg1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXWVWebView implements IWebView {
    private static String m = "forceWx=true";
    private static final int n;
    private static final boolean o;
    protected IWebView.OnErrorListener a;
    protected IWebView.OnPageListener b;
    protected IWebView.OnMessageListener c;
    private AliWVUCWebView d;
    private Context e;
    private WXSDKInstance f;
    private ProgressBar g;
    private boolean h = true;
    private ArrayList<String> i = new ArrayList<>();
    private String j;
    private Handler k;
    private WXComponent l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class AliWVUCWebView extends WVUCWebView {
        OnScrollListener onScrollChangeListener;

        /* compiled from: Taobao */
        /* loaded from: classes15.dex */
        public interface OnScrollListener {
            void onScroll(int i, int i2, int i3, int i4);
        }

        public AliWVUCWebView(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebView
        public void OnScrollChanged(int i, int i2, int i3, int i4) {
            OnScrollListener onScrollListener = this.onScrollChangeListener;
            if (onScrollListener != null) {
                onScrollListener.onScroll(i, i2, i3, i4);
            }
            super.OnScrollChanged(i, i2, i3, i4);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements AliWVUCWebView.OnScrollListener {
        a() {
        }

        @Override // com.alibaba.aliweex.adapter.component.WXWVWebView.AliWVUCWebView.OnScrollListener
        public void onScroll(int i, int i2, int i3, int i4) {
            if (WXWVWebView.this.f == null || WXWVWebView.this.l == null || !WXWVWebView.this.l.getEvents().contains("onscroll")) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(NotifyType.LIGHTS, Integer.valueOf(i));
            hashMap.put("t", Integer.valueOf(i2));
            WXWVWebView.this.f.fireEvent(WXWVWebView.this.l.getRef(), "onscroll", hashMap, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b extends WVUCWebViewClient {
        b(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WXLogUtils.v("tag", "onPageFinished " + str);
            IWebView.OnPageListener onPageListener = WXWVWebView.this.b;
            if (onPageListener != null) {
                onPageListener.onPageFinish(str, webView.canGoBack(), webView.canGoForward());
            }
            WXWVWebView wXWVWebView = WXWVWebView.this;
            if (wXWVWebView.c != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("javascript:(window.postMessage = function(message, targetOrigin) {if (message == null || !targetOrigin) return;");
                sb.append(WXWVWebView.o ? "prompt('__WEEX_WEB_VIEW_BRIDGE://postMessage?message=' + JSON.stringify(message) + '&targetOrigin=' + targetOrigin)" : "__WEEX_WEB_VIEW_BRIDGE.postMessage(JSON.stringify(message), targetOrigin);");
                sb.append("})");
                wXWVWebView.i(sb.toString());
            }
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WXLogUtils.v("tag", "onPageStarted " + str);
            IWebView.OnPageListener onPageListener = WXWVWebView.this.b;
            if (onPageListener != null) {
                onPageListener.onPageStart(str);
            }
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            IWebView.OnErrorListener onErrorListener = WXWVWebView.this.a;
            if (onErrorListener != null) {
                onErrorListener.onError("error", "page error");
            }
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            IWebView.OnErrorListener onErrorListener = WXWVWebView.this.a;
            if (onErrorListener != null) {
                onErrorListener.onError("error", "ssl error");
            }
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null) {
                if ((WXWVWebView.this.i != null && WXWVWebView.this.i.contains(str)) || str.contains(WXWVWebView.m) || this.mContext.get() == null) {
                    return false;
                }
                IEventModuleAdapter f = com.alibaba.aliweex.a.l().f();
                if (f != null) {
                    f.openURL(WXWVWebView.this.f.getContext(), str);
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c extends WVUCWebChromeClient {
        c() {
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            Uri parse = Uri.parse(str2);
            if (TextUtils.equals(parse.getScheme(), "__WEEX_WEB_VIEW_BRIDGE")) {
                if (TextUtils.equals(parse.getAuthority(), WXWeb.POST_MESSAGE)) {
                    WXWVWebView.this.l(parse.getQueryParameter("message"), parse.getQueryParameter("targetOrigin"));
                    jsPromptResult.confirm("success");
                    return true;
                }
                jsPromptResult.confirm("fail");
                return true;
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // com.uc.webview.export.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            WXWVWebView.this.m(i != 100);
            WXLogUtils.v("tag", "onPageProgressChanged " + i);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            IWebView.OnPageListener onPageListener = WXWVWebView.this.b;
            if (onPageListener != null) {
                onPageListener.onReceivedTitle(webView.getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class d {
        d(WXWVWebView wXWVWebView) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    private static class e extends Handler {
        private final WeakReference<WXWVWebView> a;

        /* synthetic */ e(WXWVWebView wXWVWebView, a aVar) {
            this(wXWVWebView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1 || this.a.get() == null || this.a.get().c == null) {
                return;
            }
            this.a.get().c.onMessage((Map) message.obj);
        }

        private e(WXWVWebView wXWVWebView) {
            this.a = new WeakReference<>(wXWVWebView);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        n = i;
        o = i < 17;
    }

    public WXWVWebView(WXSDKInstance wXSDKInstance, WXComponent wXComponent) {
        String str = null;
        try {
            Uri parse = Uri.parse(wXSDKInstance.getBundleUrl());
            String scheme = parse.getScheme();
            String authority = parse.getAuthority();
            if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority)) {
                str = scheme + jg1.SCHEME_SLASH + authority;
            }
        } catch (Exception unused) {
        }
        this.f = wXSDKInstance;
        this.l = wXComponent;
        this.e = wXSDKInstance.getContext();
        this.j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        if (n < 19) {
            this.d.loadUrl(str);
        } else {
            this.d.evaluateJavascript(str, null);
        }
    }

    private void j(WVUCWebView wVUCWebView) {
        WebSettings settings = wVUCWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        wVUCWebView.setWebViewClient(new b(this.e));
        wVUCWebView.setWebChromeClient(new c());
        if (o) {
            return;
        }
        wVUCWebView.addJavascriptInterface(new d(this), "__WEEX_WEB_VIEW_BRIDGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, String str2) {
        if (str == null || str2 == null || this.c == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("data", JSON.parse(str));
            hashMap.put("origin", str2);
            hashMap.put("type", "message");
            Message message = new Message();
            message.what = 1;
            message.obj = hashMap;
            this.k.sendMessage(message);
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z) {
        if (this.h) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void destroy() {
        AliWVUCWebView aliWVUCWebView = this.d;
        if (aliWVUCWebView != null) {
            aliWVUCWebView.destroy();
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public View getView() {
        FrameLayout frameLayout = new FrameLayout(this.e);
        frameLayout.setBackgroundColor(-1);
        AliWVUCWebView aliWVUCWebView = new AliWVUCWebView(this.e);
        this.d = aliWVUCWebView;
        aliWVUCWebView.onScrollChangeListener = new a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
        frameLayout.addView(this.d);
        j(this.d);
        this.g = new ProgressBar(this.e);
        m(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        this.g.setLayoutParams(layoutParams2);
        layoutParams2.gravity = 17;
        frameLayout.addView(this.g);
        this.k = new e(this, null);
        WXComponent wXComponent = this.l;
        if (wXComponent != null && wXComponent.getStyles() != null) {
            this.d.setBackgroundColor(WXResourceUtils.getColor((String) this.l.getStyles().get("backgroundColor"), 0));
        }
        return frameLayout;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void goBack() {
        AliWVUCWebView aliWVUCWebView = this.d;
        if (aliWVUCWebView == null || !aliWVUCWebView.canGoBack()) {
            return;
        }
        this.d.goBack();
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void goForward() {
        AliWVUCWebView aliWVUCWebView = this.d;
        if (aliWVUCWebView == null || !aliWVUCWebView.canGoForward()) {
            return;
        }
        this.d.goForward();
    }

    public void k(int i, int i2, Intent intent) {
        AliWVUCWebView aliWVUCWebView = this.d;
        if (aliWVUCWebView != null) {
            aliWVUCWebView.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void loadDataWithBaseURL(String str) {
        AliWVUCWebView aliWVUCWebView = this.d;
        if (aliWVUCWebView != null) {
            aliWVUCWebView.loadDataWithBaseURL(this.j, str, "text/html", "utf-8", null);
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void loadUrl(String str) {
        if (this.d != null) {
            this.i.add(str);
            this.d.loadUrl(str);
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void postMessage(Object obj) {
        if (this.d != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", (Object) "message");
                jSONObject.put("data", obj);
                jSONObject.put("origin", (Object) this.j);
                i("javascript:(function () {var initData = " + jSONObject.toString() + ";try {var event = new MessageEvent('message', initData);window.dispatchEvent(event);} catch (e) {}})();");
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void reload() {
        AliWVUCWebView aliWVUCWebView = this.d;
        if (aliWVUCWebView != null) {
            aliWVUCWebView.reload();
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnErrorListener(IWebView.OnErrorListener onErrorListener) {
        this.a = onErrorListener;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnMessageListener(IWebView.OnMessageListener onMessageListener) {
        this.c = onMessageListener;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnPageListener(IWebView.OnPageListener onPageListener) {
        this.b = onPageListener;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setShowLoading(boolean z) {
        this.h = z;
    }
}
