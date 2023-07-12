package com.ali.user.open.core.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes9.dex */
public class MemberWebView extends WebView {
    private static final String TAG = MemberWebView.class.getSimpleName();
    private String appCacheDir;
    private Map<String, Object> nameToObj;

    public MemberWebView(Context context) {
        super(context);
        this.nameToObj = new HashMap();
        initSettings(context);
    }

    @TargetApi(21)
    private void initSettings(Context context) {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception unused) {
        }
        settings.setSavePassword(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setSupportZoom(false);
        settings.setSaveFormData(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setDomStorageEnabled(true);
        String path = context.getApplicationContext().getDir("cache", 0).getPath();
        this.appCacheDir = path;
        settings.setAppCachePath(path);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        if (CommonUtils.isNetworkAvailable(context)) {
            settings.setCacheMode(-1);
        } else {
            settings.setCacheMode(1);
        }
        settings.setBuiltInZoomControls(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(SDKLogger.isDebugEnabled());
        }
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
                settings.setMixedContentMode(0);
            } catch (Throwable unused2) {
            }
        }
        final IWebViewClient iWebViewClient = (IWebViewClient) context;
        setWebViewClient(new BaseWebViewClient() { // from class: com.ali.user.open.core.webview.MemberWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                iWebViewClient.onPageFinished(str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                iWebViewClient.onPageStarted(str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return iWebViewClient.shouldOverrideUrlLoading(str);
            }
        });
        setWebChromeClient(new BridgeWebChromeClient() { // from class: com.ali.user.open.core.webview.MemberWebView.2
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                iWebViewClient.onReceivedTitle(str);
            }
        });
        setDownloadListener(new UccDownloadListener(context));
    }

    public final void addBridgeObject(String str, Object obj) {
        this.nameToObj.put(str, obj);
    }

    @Override // android.webkit.WebView
    public final void addJavascriptInterface(Object obj, String str) {
    }

    public Object getBridgeObj(String str) {
        return this.nameToObj.get(str);
    }

    public MemberWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nameToObj = new HashMap();
        initSettings(context);
    }
}
