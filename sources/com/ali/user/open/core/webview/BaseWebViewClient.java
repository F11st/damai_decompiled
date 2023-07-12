package com.ali.user.open.core.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.user.open.core.util.DialogHelper;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BaseWebViewClient extends WebViewClient {
    protected boolean firstAlert = true;
    protected boolean proceed = false;

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!this.firstAlert) {
            if (this.proceed) {
                sslErrorHandler.proceed();
                return;
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                return;
            }
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.ali.user.open.core.webview.BaseWebViewClient.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.proceed();
                BaseWebViewClient.this.proceed = true;
            }
        };
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.ali.user.open.core.webview.BaseWebViewClient.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.cancel();
                BaseWebViewClient.this.proceed = false;
            }
        };
        if (webView.getContext() instanceof Activity) {
            DialogHelper.getInstance().alert((Activity) webView.getContext(), "SSL证书错误", "您的连接不是安全连接，是否继续访问?", "确定", onClickListener, "取消", onClickListener2);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
        builder.setPositiveButton("确定", onClickListener);
        builder.setNeutralButton("取消", onClickListener2);
        try {
            AlertDialog create = builder.create();
            create.setTitle("SSL证书错误");
            create.setMessage("您的连接不是安全连接，是否继续访问?");
            create.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
