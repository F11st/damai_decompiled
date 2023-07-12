package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.C6207b;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.web.InterfaceC6232a;
import com.sina.weibo.sdk.web.b.AbstractC6238b;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.web.a.b */
/* loaded from: classes7.dex */
public abstract class AbstractC6234b extends WebViewClient {
    protected AbstractC6238b aA;
    protected WbAuthListener aB;
    protected C6207b ax = C6207b.b();
    protected Activity ay;
    protected InterfaceC6232a az;

    public AbstractC6234b(Activity activity, InterfaceC6232a interfaceC6232a, AbstractC6238b abstractC6238b) {
        this.ay = activity;
        this.az = interfaceC6232a;
        this.aA = abstractC6238b;
    }

    private void a(int i, String str) {
        Bundle extras = this.ay.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Intent intent = new Intent(this.ay, ShareTransActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(extras);
        intent.putExtra("_weibo_resp_errcode", i);
        intent.putExtra("_weibo_resp_errstr", str);
        this.ay.setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(String str) {
        a(0, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(String str) {
        a(2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(String str) {
        a(1, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        InterfaceC6232a interfaceC6232a = this.az;
        if (interfaceC6232a != null) {
            webResourceError.getErrorCode();
            webResourceError.getDescription().toString();
            webResourceRequest.getUrl();
            interfaceC6232a.p();
        }
    }

    public void p(String str) {
    }

    public void q() {
    }

    public boolean s() {
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
