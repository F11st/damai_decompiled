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
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.jsbridge.C3900b;
import com.alibaba.security.realidentity.jsbridge.C3901c;
import com.alibaba.security.realidentity.jsbridge.C3902d;
import com.alibaba.security.realidentity.jsbridge.C3903e;
import com.alibaba.security.realidentity.jsbridge.C3908i;
import com.alibaba.security.realidentity.jsbridge.C3909j;
import com.alibaba.security.realidentity.jsbridge.C3910k;
import com.alibaba.security.realidentity.jsbridge.C3911l;
import com.alibaba.security.realidentity.jsbridge.C3914o;
import com.uc.webview.export.WebSettings;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.a.h */
/* loaded from: classes8.dex */
public final class C3849h implements InterfaceC3844d {
    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final AbsHttpInvoker a() {
        return new RPHttpInvoker();
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final Class<? extends AbstractC3893a>[] b() {
        return new Class[]{C3900b.class, C3901c.class, C3902d.class, C3903e.class, C3908i.class, C3909j.class, C3911l.class, C3914o.class, C3910k.class};
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final Class<? extends BucketParams>[] c() {
        return new Class[]{StartHttpParams.class, BiometricsBucketParams.class, UploadFileParams.class, UploadResultParams.class, SubmitHttpParams.class};
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final AbstractC3841b d() {
        return new C3846f();
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final AbstractC3843c a(Context context) {
        final WVUCWebView wVUCWebView = new WVUCWebView(context);
        final WebSettings settings = wVUCWebView.getSettings();
        return new AbstractC3843c() { // from class: com.alibaba.security.realidentity.a.h.1
            private WVUCWebView m() {
                return wVUCWebView;
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final int a() {
                return wVUCWebView.getProgress();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void b(String str) {
                wVUCWebView.loadUrl(str);
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final String c() {
                return wVUCWebView.getOriginalUrl();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final String d() {
                return wVUCWebView.getUrl();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void e() {
                WebSettings webSettings = settings;
                if (webSettings == null) {
                    return;
                }
                webSettings.setUseWideViewPort(true);
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final String f() {
                WebSettings webSettings = settings;
                if (webSettings == null) {
                    return null;
                }
                return webSettings.getUserAgentString();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void g() {
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void h() {
                wVUCWebView.destroy();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void i() {
                wVUCWebView.goBack();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final boolean j() {
                return wVUCWebView.canGoBack();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void k() {
                wVUCWebView.showLoadingView();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void l() {
                wVUCWebView.resumeTimers();
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void a(String str) {
                wVUCWebView.fireEvent(str, null);
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final /* bridge */ /* synthetic */ View b() {
                return wVUCWebView;
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void c(String str) {
                WebSettings webSettings = settings;
                if (webSettings == null) {
                    return;
                }
                webSettings.setUserAgentString(str);
            }

            @Override // com.alibaba.security.realidentity.a.AbstractC3843c
            public final void a(String str, ValueCallback<String> valueCallback) {
                wVUCWebView.evaluateJavascript(str, valueCallback);
            }
        };
    }
}
