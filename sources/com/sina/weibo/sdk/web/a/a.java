package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.b.e;
import com.sina.weibo.sdk.common.UiError;
import com.tencent.connect.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class a extends b {
    public a(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    private boolean l(String str) {
        Bundle g;
        AuthInfo a = this.aA.u().a();
        return (a == null || !str.startsWith(a.getRedirectUrl()) || (g = e.g(str)) == null || TextUtils.isEmpty(g.getString(Constants.PARAM_ACCESS_TOKEN))) ? false : true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        AuthInfo a = this.aA.u().a();
        if (a == null || !str.startsWith(a.getRedirectUrl())) {
            return;
        }
        String r = this.aA.u().r();
        if (!TextUtils.isEmpty(r)) {
            WbAuthListener a2 = this.ax.a(r);
            this.aB = a2;
            if (a2 != null) {
                Bundle g = e.g(str);
                if (g != null) {
                    String string = g.getString("error");
                    String string2 = g.getString("error_code");
                    String string3 = g.getString("error_description");
                    if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(g);
                        AccessTokenHelper.writeAccessToken(this.ay, parseAccessToken);
                        this.aB.onComplete(parseAccessToken);
                    } else {
                        this.aB.onError(new UiError(-1, string2, string3));
                    }
                } else {
                    this.aB.onError(new UiError(-1, "bundle is null", "parse url error"));
                }
                this.ax.b(r);
            }
        }
        com.sina.weibo.sdk.web.a aVar = this.az;
        if (aVar != null) {
            aVar.q();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void q() {
        super.q();
        String r = this.aA.u().r();
        if (!TextUtils.isEmpty(r)) {
            WbAuthListener a = this.ax.a(r);
            this.aB = a;
            if (a != null) {
                a.onCancel();
            }
            this.ax.b(r);
        }
        com.sina.weibo.sdk.web.a aVar = this.az;
        if (aVar != null) {
            aVar.q();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final boolean s() {
        q();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            return l(webResourceRequest.getUrl().toString());
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return l(str);
    }
}
