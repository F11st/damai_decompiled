package cn.damai.launcher.splash;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SplashWebViewActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String JSPromptProtocol = "jsPromptProtocol";
    private static final int appCacheMaxSize = 8388608;
    private String originUrl;
    private WebView webView;
    private boolean netFailedFlag = false;
    private boolean loadFinishFlag = false;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class tickletWebDialogWebChromeClient extends WebChromeClient {
        private static transient /* synthetic */ IpChange $ipChange;

        private tickletWebDialogWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1284070176")) {
                return ((Boolean) ipChange.ipc$dispatch("-1284070176", new Object[]{this, webView, str, str2, str3, jsPromptResult})).booleanValue();
            }
            if (SplashWebViewActivity.JSPromptProtocol.equalsIgnoreCase(str3)) {
                jsPromptResult.confirm();
                return true;
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class tickletWebDialogWebViewClient extends WebViewClient {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean loading;

        private tickletWebDialogWebViewClient() {
            this.loading = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1839610257")) {
                ipChange.ipc$dispatch("1839610257", new Object[]{this, webView, str});
                return;
            }
            super.onPageFinished(webView, str);
            if (this.loading) {
                this.loading = false;
                try {
                    SplashWebViewActivity.this.stopProgressDialog();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (SplashWebViewActivity.this.netFailedFlag || SplashWebViewActivity.this.loadFinishFlag) {
                return;
            }
            SplashWebViewActivity.this.loadFinishFlag = true;
            try {
                String title = SplashWebViewActivity.this.webView.getTitle();
                if (title != null && !title.contains("http") && !title.contains("mapi")) {
                    SplashWebViewActivity.this.setTitleContent(title);
                }
            } catch (Exception unused) {
            }
            SplashWebViewActivity.this.webView.loadUrl("javascript:;void(prompt(''+document.body.scrollHeight,'jsPromptProtocol'))");
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-509893586")) {
                ipChange.ipc$dispatch("-509893586", new Object[]{this, webView, str, bitmap});
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1163931562")) {
                ipChange.ipc$dispatch("-1163931562", new Object[]{this, webView, Integer.valueOf(i), str, str2});
            } else {
                SplashWebViewActivity.this.netFailedFlag = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1091981609")) {
                return ((Boolean) ipChange.ipc$dispatch("1091981609", new Object[]{this, webView, str})).booleanValue();
            }
            Uri parse = Uri.parse(str);
            if ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
                SplashWebViewActivity.this.startProgressDialog();
                this.loading = true;
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }
    }

    private void initWebView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962942847")) {
            ipChange.ipc$dispatch("962942847", new Object[]{this});
            return;
        }
        this.webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        this.webView.getSettings().setTextSize(WebSettings.TextSize.NORMAL);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setUseWideViewPort(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setSupportZoom(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setDatabaseEnabled(true);
        this.webView.getSettings().setSavePassword(false);
        this.webView.getSettings().setSupportZoom(true);
        this.webView.getSettings().setAppCacheMaxSize(8388608L);
        this.webView.getSettings().setAllowFileAccess(true);
        this.webView.getSettings().setAppCacheEnabled(true);
        int i = Build.VERSION.SDK_INT;
        if (i < 19) {
            WebSettings settings = this.webView.getSettings();
            settings.setDatabasePath("/data/data/" + getPackageName() + "/databases/");
        }
        if (getCacheDir() != null) {
            this.webView.getSettings().setAppCachePath(getCacheDir().getAbsolutePath());
        }
        if (i >= 11 && i <= 15) {
            this.webView.getSettings().setBuiltInZoomControls(true);
        } else {
            this.webView.getSettings().setBuiltInZoomControls(false);
        }
        WebSettings settings2 = this.webView.getSettings();
        settings2.setUserAgentString(this.webView.getSettings().getUserAgentString() + " damai/vid");
        this.webView.setWebViewClient(new tickletWebDialogWebViewClient());
        this.webView.setWebChromeClient(new tickletWebDialogWebChromeClient());
        this.webView.setDownloadListener(new DownloadListener() { // from class: cn.damai.launcher.splash.SplashWebViewActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1078489916")) {
                    ipChange2.ipc$dispatch("1078489916", new Object[]{this, str, str2, str3, str4, Long.valueOf(j)});
                    return;
                }
                try {
                    SplashWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-908276758")) {
            ipChange.ipc$dispatch("-908276758", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "61758400") ? ((Integer) ipChange.ipc$dispatch("61758400", new Object[]{this})).intValue() : R$layout.splash_privacy_web_activity;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52511675")) {
            ipChange.ipc$dispatch("52511675", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1296244272")) {
            ipChange.ipc$dispatch("-1296244272", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "130499277")) {
            ipChange.ipc$dispatch("130499277", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813014605")) {
            ipChange.ipc$dispatch("1813014605", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.webView = (WebView) findViewById(R$id.splash_privacy_wb);
        initWebView();
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("url");
            this.originUrl = stringExtra;
            this.webView.loadUrl(stringExtra);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1892371916") ? (String) ipChange.ipc$dispatch("-1892371916", new Object[]{this}) : "";
    }
}
