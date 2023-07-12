package cn.damai.ticklet.view;

import android.app.Activity;
import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.h5container.DamaiWebView;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebView;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletWebDialog extends RelativeLayout implements ResponseErrorPage.ErrorRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context ctx;
    private LinearLayout errorPageView;
    protected ResponseErrorPage mErrorPage;
    private String originUrl;
    private View partent;
    private ProgressBar progressBar;
    private RelativeLayout rootRl;
    private DamaiWebView webView;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class TickletWebDialogWebViewClient extends WVUCWebViewClient {
        private static transient /* synthetic */ IpChange $ipChange;

        public TickletWebDialogWebViewClient(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "128283665")) {
                ipChange.ipc$dispatch("128283665", new Object[]{this, webView, str});
                return;
            }
            super.onPageFinished(webView, str);
            TickletWebDialog.this.webView.setVisibility(0);
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.ticklet.view.TickletWebDialog.TickletWebDialogWebViewClient.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-851202305")) {
                        ipChange2.ipc$dispatch("-851202305", new Object[]{this});
                        return;
                    }
                    TickletWebDialog.this.progressBar.setVisibility(8);
                    TickletWebDialog.this.errorPageView.setVisibility(8);
                }
            }, 50L);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1520256628")) {
                ipChange.ipc$dispatch("-1520256628", new Object[]{this, webView, Integer.valueOf(i), str, str2});
                return;
            }
            super.onReceivedError(webView, i, str, str2);
            TickletWebDialog.this.webView.setVisibility(8);
            TickletWebDialog.this.progressBar.setVisibility(8);
            TickletWebDialog.this.errorPageView.setVisibility(0);
            TickletWebDialog tickletWebDialog = TickletWebDialog.this;
            tickletWebDialog.onResponseError("加载失败", null, null, tickletWebDialog.errorPageView, true);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2069642478")) {
                ipChange.ipc$dispatch("2069642478", new Object[]{this, webView, sslErrorHandler, sslError});
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.proceed();
            TickletWebDialog.this.webView.setVisibility(8);
            TickletWebDialog.this.errorPageView.setVisibility(0);
            TickletWebDialog.this.progressBar.setVisibility(8);
            TickletWebDialog tickletWebDialog = TickletWebDialog.this;
            tickletWebDialog.onResponseError("加载失败", null, null, tickletWebDialog.errorPageView, true);
        }
    }

    public TickletWebDialog(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-926185284")) {
            ipChange.ipc$dispatch("-926185284", new Object[]{this});
            return;
        }
        this.partent = LayoutInflater.from(this.ctx).inflate(R$layout.ticklet_web_dialog, this);
        this.rootRl = (RelativeLayout) findViewById(R$id.atom_ticklet_dialog_rl);
        this.webView = (DamaiWebView) findViewById(R$id.atom_ticklet_dialog_wb);
        this.errorPageView = (LinearLayout) findViewById(R$id.errorPageView);
        this.progressBar = (ProgressBar) findViewById(R$id.face_progressbar);
        this.webView.setVisibility(8);
        this.errorPageView.setVisibility(8);
        this.progressBar.setVisibility(0);
    }

    private void setParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460275590")) {
            ipChange.ipc$dispatch("460275590", new Object[]{this});
        } else {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, DisplayMetrics.getheightPixels(t60.b(this.ctx)) - t60.a(this.ctx, 120.0f)));
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074278442")) {
            ipChange.ipc$dispatch("2074278442", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.webView.loadUrl(this.originUrl);
        }
    }

    public void onDestory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685782684")) {
            ipChange.ipc$dispatch("-1685782684", new Object[]{this});
        } else {
            this.webView.destroy();
        }
    }

    protected void onResponseError(String str, String str2, String str3, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-31541007")) {
            ipChange.ipc$dispatch("-31541007", new Object[]{this, str, str2, str3, view, Boolean.valueOf(z)});
        } else {
            onResponseError(1, str, str2, str3, view, z);
        }
    }

    public void setData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599037289")) {
            ipChange.ipc$dispatch("-1599037289", new Object[]{this, str});
            return;
        }
        this.originUrl = str;
        if (TextUtils.isEmpty(str) || this.ctx == null) {
            return;
        }
        this.webView.loadUrl(this.originUrl);
        this.webView.setWebViewClient(new TickletWebDialogWebViewClient(this.ctx));
    }

    public TickletWebDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onResponseError(int i, String str, String str2, String str3, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1753262770")) {
            ipChange.ipc$dispatch("1753262770", new Object[]{this, Integer.valueOf(i), str, str2, str3, view, Boolean.valueOf(z)});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || ((!responseErrorPage.isShown() && this.mErrorPage.getParent() == null) || !(this.ctx instanceof Activity))) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage((Activity) this.ctx, i, str2, str, str3);
            this.mErrorPage = responseErrorPage2;
            if (z) {
                responseErrorPage2.hideTitle();
            }
            this.mErrorPage.setRefreshListener(this);
            if (view instanceof LinearLayout) {
                this.mErrorPage.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                ((LinearLayout) view).addView(this.mErrorPage, 0);
            }
        }
    }

    public TickletWebDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ctx = context;
        setBackgroundResource(R$color.white);
        initView();
        setParam();
    }
}
