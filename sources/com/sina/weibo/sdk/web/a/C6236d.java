package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.b.C6214e;
import com.sina.weibo.sdk.web.InterfaceC6232a;
import com.sina.weibo.sdk.web.b.AbstractC6238b;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.web.a.d */
/* loaded from: classes7.dex */
public final class C6236d extends AbstractC6234b {
    public C6236d(Activity activity, InterfaceC6232a interfaceC6232a, AbstractC6238b abstractC6238b) {
        super(activity, interfaceC6232a, abstractC6238b);
    }

    @Override // com.sina.weibo.sdk.web.a.AbstractC6234b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.sina.weibo.sdk.web.a.AbstractC6234b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.AbstractC6234b
    public final void p(String str) {
        n(str);
    }

    @Override // com.sina.weibo.sdk.web.a.AbstractC6234b
    public final void q() {
        o("cancel share!!!");
        InterfaceC6232a interfaceC6232a = this.az;
        if (interfaceC6232a != null) {
            interfaceC6232a.q();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.AbstractC6234b
    public final boolean s() {
        q();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle h = C6214e.h(str);
        if (h != null) {
            String string = h.getString("code");
            String string2 = h.getString("msg");
            if ("0".equals(string)) {
                m(string2);
            } else {
                n(string2);
            }
        } else {
            n("bundle is null!!!");
        }
        InterfaceC6232a interfaceC6232a = this.az;
        if (interfaceC6232a != null) {
            interfaceC6232a.q();
            return true;
        }
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.AbstractC6234b, android.webkit.WebViewClient
    @TargetApi(21)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (TextUtils.isEmpty(uri) || !uri.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle h = C6214e.h(uri);
        if (h != null) {
            String string = h.getString("code");
            String string2 = h.getString("msg");
            if (TextUtils.isEmpty(string)) {
                o("code is null!!!");
            } else if ("0".equals(string)) {
                m(string2);
            } else {
                n(string2);
            }
        } else {
            n("bundle is null!!!");
        }
        InterfaceC6232a interfaceC6232a = this.az;
        if (interfaceC6232a != null) {
            interfaceC6232a.q();
            return true;
        }
        return true;
    }
}
