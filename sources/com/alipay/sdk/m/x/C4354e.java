package com.alipay.sdk.m.x;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.jsbridge.api.WVFile;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4315k;
import com.alipay.sdk.m.u.C4318n;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.x.e */
/* loaded from: classes10.dex */
public class C4354e extends LinearLayout {
    public static Handler m = new Handler(Looper.getMainLooper());
    public ImageView a;
    public TextView b;
    public ImageView c;
    public ProgressBar d;
    public WebView e;
    public final C4360e f;
    public InterfaceC4361f g;
    public InterfaceC4362g h;
    public InterfaceC4363h i;
    public final C4293a j;
    public View.OnClickListener k;
    public final float l;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.e$a */
    /* loaded from: classes10.dex */
    public class View$OnClickListenerC4355a implements View.OnClickListener {

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.x.e$a$a */
        /* loaded from: classes10.dex */
        public class RunnableC4356a implements Runnable {
            public final /* synthetic */ View a;

            public RunnableC4356a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.setEnabled(true);
            }
        }

        public View$OnClickListenerC4355a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC4363h interfaceC4363h = C4354e.this.i;
            if (interfaceC4363h != null) {
                view.setEnabled(false);
                C4354e.m.postDelayed(new RunnableC4356a(view), 256L);
                if (view != C4354e.this.a) {
                    if (view == C4354e.this.c) {
                        interfaceC4363h.a(C4354e.this);
                        return;
                    }
                    return;
                }
                interfaceC4363h.b(C4354e.this);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.e$b */
    /* loaded from: classes10.dex */
    public class C4357b implements DownloadListener {
        public final /* synthetic */ Context a;

        public C4357b(Context context) {
            this.a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.e$c */
    /* loaded from: classes10.dex */
    public class C4358c extends WebChromeClient {
        public C4358c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return C4354e.this.g.a(C4354e.this, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (!C4354e.this.f.b) {
                C4354e.this.d.setVisibility(8);
            } else if (i > 90) {
                C4354e.this.d.setVisibility(4);
            } else {
                if (C4354e.this.d.getVisibility() == 4) {
                    C4354e.this.d.setVisibility(0);
                }
                C4354e.this.d.setProgress(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            C4354e.this.g.c(C4354e.this, str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.e$d */
    /* loaded from: classes10.dex */
    public class C4359d extends WebViewClient {
        public C4359d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (C4354e.this.h.b(C4354e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (C4354e.this.h.d(C4354e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (C4354e.this.h.a(C4354e.this, i, str, str2)) {
                return;
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (C4354e.this.h.a(C4354e.this, sslErrorHandler, sslError)) {
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (C4354e.this.h.a(C4354e.this, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.e$e */
    /* loaded from: classes10.dex */
    public static final class C4360e {
        public boolean a;
        public boolean b;

        public C4360e(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.e$f */
    /* loaded from: classes10.dex */
    public interface InterfaceC4361f {
        boolean a(C4354e c4354e, String str, String str2, String str3, JsPromptResult jsPromptResult);

        void c(C4354e c4354e, String str);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.e$g */
    /* loaded from: classes10.dex */
    public interface InterfaceC4362g {
        boolean a(C4354e c4354e, int i, String str, String str2);

        boolean a(C4354e c4354e, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean a(C4354e c4354e, String str);

        boolean b(C4354e c4354e, String str);

        boolean d(C4354e c4354e, String str);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.e$h */
    /* loaded from: classes10.dex */
    public interface InterfaceC4363h {
        void a(C4354e c4354e);

        void b(C4354e c4354e);
    }

    public C4354e(Context context, C4293a c4293a, C4360e c4360e) {
        this(context, null, c4293a, c4360e);
    }

    public ImageView getBackButton() {
        return this.a;
    }

    public ProgressBar getProgressbar() {
        return this.d;
    }

    public ImageView getRefreshButton() {
        return this.c;
    }

    public TextView getTitle() {
        return this.b;
    }

    public String getUrl() {
        return this.e.getUrl();
    }

    public WebView getWebView() {
        return this.e;
    }

    public void setChromeProxy(InterfaceC4361f interfaceC4361f) {
        this.g = interfaceC4361f;
        if (interfaceC4361f == null) {
            this.e.setWebChromeClient(null);
        } else {
            this.e.setWebChromeClient(new C4358c());
        }
    }

    public void setWebClientProxy(InterfaceC4362g interfaceC4362g) {
        this.h = interfaceC4362g;
        if (interfaceC4362g == null) {
            this.e.setWebViewClient(null);
        } else {
            this.e.setWebViewClient(new C4359d());
        }
    }

    public void setWebEventProxy(InterfaceC4363h interfaceC4363h) {
        this.i = interfaceC4363h;
    }

    public C4354e(Context context, AttributeSet attributeSet, C4293a c4293a, C4360e c4360e) {
        super(context, attributeSet);
        this.k = new View$OnClickListenerC4355a();
        this.f = c4360e == null ? new C4360e(false, false) : c4360e;
        this.j = c4293a;
        this.l = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f.a ? 0 : 8);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        imageView.setOnClickListener(this.k);
        this.a.setScaleType(ImageView.ScaleType.CENTER);
        this.a.setImageDrawable(C4315k.a(C4315k.a, context));
        this.a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setTextColor(-15658735);
        this.b.setTextSize(17.0f);
        this.b.setMaxLines(1);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.c = imageView2;
        imageView2.setOnClickListener(this.k);
        this.c.setScaleType(ImageView.ScaleType.CENTER);
        this.c.setImageDrawable(C4315k.a(C4315k.b, context));
        this.c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    private void c(Context context) {
        WebView webView = new WebView(context);
        this.e = webView;
        webView.setVerticalScrollbarOverlay(true);
        a(this.e, context);
        WebSettings settings = this.e.getSettings();
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(WVFile.FILE_MAX_SIZE);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(false);
        this.e.setVerticalScrollbarOverlay(true);
        this.e.setDownloadListener(new C4357b(context));
        try {
            try {
                this.e.removeJavascriptInterface("searchBoxJavaBridge_");
                this.e.removeJavascriptInterface("accessibility");
                this.e.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception unused) {
                Method method = this.e.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.e, "searchBoxJavaBridge_");
                    method.invoke(this.e, "accessibility");
                    method.invoke(this.e, "accessibilityTraversal");
                }
            }
        } catch (Throwable unused2) {
        }
        AbstractC4344c.a(this.e);
        addView(this.e, new LinearLayout.LayoutParams(-1, -1));
    }

    private void b(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, 16973855);
        this.d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
        this.d.setMax(100);
        this.d.setBackgroundColor(-218103809);
        addView(this.d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    public void a(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(userAgentString + C4318n.g(context));
    }

    public void a(String str) {
        this.e.loadUrl(str);
        AbstractC4344c.a(this.e);
    }

    public void a(String str, byte[] bArr) {
        this.e.postUrl(str, bArr);
    }

    public void a() {
        removeAllViews();
        this.e.removeAllViews();
        this.e.setWebViewClient(null);
        this.e.setWebChromeClient(null);
        this.e.destroy();
    }

    private int a(int i) {
        return (int) (i * this.l);
    }
}
