package com.ali.user.open.core.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.util.AttributeSet;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.DialogHelper;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes9.dex */
public class MemberUCWebView extends WVUCWebView {
    private static final String TAG = MemberUCWebView.class.getSimpleName();
    private String appCacheDir;
    protected boolean firstAlert;
    protected boolean proceed;

    public MemberUCWebView(Context context) {
        super(context);
        this.firstAlert = true;
        this.proceed = false;
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
        settings.setSaveFormData(false);
        settings.setSupportZoom(false);
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e) {
            e.printStackTrace();
        }
        final IWebViewClient iWebViewClient = (IWebViewClient) context;
        setWebViewClient(new WVUCWebViewClient(context) { // from class: com.ali.user.open.core.webview.MemberUCWebView.1
            @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                iWebViewClient.onPageFinished(str);
            }

            @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                iWebViewClient.onPageStarted(str);
            }

            @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
                MemberUCWebView memberUCWebView = MemberUCWebView.this;
                if (!memberUCWebView.firstAlert) {
                    if (memberUCWebView.proceed) {
                        sslErrorHandler.proceed();
                        return;
                    } else {
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                        return;
                    }
                }
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.ali.user.open.core.webview.MemberUCWebView.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.proceed();
                        MemberUCWebView.this.proceed = true;
                    }
                };
                DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.ali.user.open.core.webview.MemberUCWebView.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.cancel();
                        MemberUCWebView.this.proceed = false;
                    }
                };
                if (webView.getContext() instanceof Activity) {
                    DialogHelper.getInstance().alert((Activity) webView.getContext(), "SSL证书错误", "证书错误. 是否继续访问?", "确定", onClickListener, "取消", onClickListener2);
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
                builder.setPositiveButton("确定", onClickListener);
                builder.setNeutralButton("取消", onClickListener2);
                try {
                    AlertDialog create = builder.create();
                    create.setTitle("SSL证书错误");
                    create.setMessage("证书错误. 是否继续访问?");
                    create.show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return iWebViewClient.shouldOverrideUrlLoading(str);
            }
        });
        setWebChromeClient(new WVUCWebChromeClient() { // from class: com.ali.user.open.core.webview.MemberUCWebView.2
            @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                iWebViewClient.onReceivedTitle(str);
            }
        });
        setDownloadListener(new UCDownloadListener(context));
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebView, com.uc.webview.export.WebView
    public final void addJavascriptInterface(Object obj, String str) {
    }

    public MemberUCWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.firstAlert = true;
        this.proceed = false;
        initSettings(context);
    }
}
