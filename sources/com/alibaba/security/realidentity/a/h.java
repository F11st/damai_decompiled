package com.alibaba.security.realidentity.a;

import android.content.Context;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.view.View;
import android.webkit.ValueCallback;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.submit.SubmitHttpParams;
import com.alibaba.security.realidentity.business.upload.UploadFileParams;
import com.alibaba.security.realidentity.business.upload.UploadResultParams;
import com.alibaba.security.realidentity.http.AbsHttpInvoker;
import com.alibaba.security.realidentity.http.RPHttpInvoker;
import com.alibaba.security.realidentity.jsbridge.j;
import com.alibaba.security.realidentity.jsbridge.k;
import com.alibaba.security.realidentity.jsbridge.l;
import com.alibaba.security.realidentity.jsbridge.o;
import com.uc.webview.export.WebSettings;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class h implements d {
    @Override // com.alibaba.security.realidentity.a.d
    public final AbsHttpInvoker a() {
        return new RPHttpInvoker();
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final Class<? extends com.alibaba.security.realidentity.jsbridge.a>[] b() {
        return new Class[]{com.alibaba.security.realidentity.jsbridge.b.class, com.alibaba.security.realidentity.jsbridge.c.class, com.alibaba.security.realidentity.jsbridge.d.class, com.alibaba.security.realidentity.jsbridge.e.class, com.alibaba.security.realidentity.jsbridge.i.class, j.class, l.class, o.class, k.class};
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final Class<? extends BucketParams>[] c() {
        return new Class[]{StartHttpParams.class, BiometricsBucketParams.class, UploadFileParams.class, UploadResultParams.class, SubmitHttpParams.class};
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final b d() {
        return new f();
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final c a(Context context) {
        final WVUCWebView wVUCWebView = new WVUCWebView(context);
        final WebSettings settings = wVUCWebView.getSettings();
        return new c() { // from class: com.alibaba.security.realidentity.a.h.1
            private WVUCWebView m() {
                return wVUCWebView;
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final int a() {
                return wVUCWebView.getProgress();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void b(String str) {
                wVUCWebView.loadUrl(str);
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final String c() {
                return wVUCWebView.getOriginalUrl();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final String d() {
                return wVUCWebView.getUrl();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void e() {
                WebSettings webSettings = settings;
                if (webSettings == null) {
                    return;
                }
                webSettings.setUseWideViewPort(true);
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final String f() {
                WebSettings webSettings = settings;
                if (webSettings == null) {
                    return null;
                }
                return webSettings.getUserAgentString();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void g() {
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void h() {
                wVUCWebView.destroy();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void i() {
                wVUCWebView.goBack();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final boolean j() {
                return wVUCWebView.canGoBack();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void k() {
                wVUCWebView.showLoadingView();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void l() {
                wVUCWebView.resumeTimers();
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void a(String str) {
                wVUCWebView.fireEvent(str, null);
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final /* bridge */ /* synthetic */ View b() {
                return wVUCWebView;
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void c(String str) {
                WebSettings webSettings = settings;
                if (webSettings == null) {
                    return;
                }
                webSettings.setUserAgentString(str);
            }

            @Override // com.alibaba.security.realidentity.a.c
            public final void a(String str, ValueCallback<String> valueCallback) {
                wVUCWebView.evaluateJavascript(str, valueCallback);
            }
        };
    }
}
