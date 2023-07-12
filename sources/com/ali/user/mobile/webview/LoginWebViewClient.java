package com.ali.user.mobile.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.security.biz.R;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebView;
import java.lang.ref.WeakReference;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class LoginWebViewClient extends WVUCWebViewClient {
    protected boolean firstAlert;
    protected boolean proceed;
    protected WeakReference<Activity> reference;

    public LoginWebViewClient(Activity activity) {
        super(activity);
        this.firstAlert = true;
        this.proceed = false;
        this.reference = new WeakReference<>(activity);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        TLogAdapter.e("WebViewActivity", "已忽略证书校验的错误！");
        Properties properties = new Properties();
        if (webView.getUrl() != null) {
            properties.setProperty("url", webView.getUrl());
        }
        UserTrackAdapter.sendUT("Event_ReceivedSslError", properties);
        Activity activity = this.reference.get();
        if (!this.firstAlert) {
            if (this.proceed) {
                sslErrorHandler.proceed();
                return;
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                return;
            }
        }
        String string = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_title);
        String string2 = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_info);
        String string3 = webView.getContext().getResources().getString(R.string.aliuser_confirm);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.webview.LoginWebViewClient.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.proceed();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                LoginWebViewClient.this.proceed = true;
            }
        };
        String string4 = webView.getContext().getResources().getString(R.string.aliuser_cancel);
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.webview.LoginWebViewClient.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.cancel();
                LoginWebViewClient.this.proceed = false;
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        };
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).alert(string, string2, string3, onClickListener, string4, onClickListener2);
            this.firstAlert = false;
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
        builder.setPositiveButton(string3, onClickListener);
        builder.setNeutralButton(string4, onClickListener2);
        try {
            AlertDialog create = builder.create();
            create.setTitle(string);
            create.setMessage(string2);
            create.show();
            this.firstAlert = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean overrideUrlLoading(WebView webView, String str) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldOverrideUrlLoading(com.uc.webview.export.WebView r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.ref.WeakReference<android.app.Activity> r0 = r3.reference
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 == 0) goto L26
            boolean r0 = r3.overrideUrlLoading(r4, r5)     // Catch: java.lang.Exception -> Lf
            goto L27
        Lf:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "webview内跳转地址有问题"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "WebViewActivity"
            com.ali.user.mobile.log.TLogAdapter.e(r2, r1, r0)
        L26:
            r0 = 0
        L27:
            if (r0 == 0) goto L2b
            r4 = 1
            return r4
        L2b:
            boolean r4 = super.shouldOverrideUrlLoading(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.webview.LoginWebViewClient.shouldOverrideUrlLoading(com.uc.webview.export.WebView, java.lang.String):boolean");
    }
}
