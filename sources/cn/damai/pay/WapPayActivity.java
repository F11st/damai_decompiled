package cn.damai.pay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.h5container.DamaiWebView;
import cn.damai.trade.R$array;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.OrderListActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import tb.cm2;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WapPayActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BIZ_TYPE = "bizType";
    public static final String TYPE_AE_CARD = "AE_Card";
    public static final String TYPE_ANT_CHECK_LATER = "ANT_CHECK_LATER";
    public static final String TYPE_CHINA_BANK = "china_bank";
    public static final String TYPE_GUANGDA_CARD_BANK = "guangda_card_bank";
    public static final String TYPE_GUANGFA_CARD_BANK = "guangfa_card_bank";
    public static final String TYPE_ICBC_BANK = "icbc_bank";
    public static final String TYPE_JCB_BANK = "jcb_bank";
    public static final String TYPE_JD_PAY = "jd_pay";
    public static final String TYPE_PINGAN_BANK = "pingan_bank";
    public static final String TYPE_PUFA_BANK = "pufa_bank";
    public static final String TYPE_PUFA_CARD_BANK = "pufa_card_bank";
    public static final String TYPE_UNION_BANK = "union_bank";
    public static final String TYPE_WALLET = "damai_wallet";
    public static final String TYPE_ZERO_PAY = "DAMAI_ZERO_PAY";
    public static final String TYPE_ZHAOSHANG_BANK = "zhaoshang_bank";
    public static final String TYPE_ZHIFUBAO = "zhufubao_wappay";
    private String bizType;
    private Context context;
    private String[] mPayTitle;
    private DamaiWebView mWebView;
    private boolean isFromMovie = false;
    private String mCurrentType = "";
    private String mOrderId = "";
    private String mFromPage = "";
    public int times = 0;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class ALIWebViewClient extends WVUCWebViewClient {
        private static transient /* synthetic */ IpChange $ipChange;

        public ALIWebViewClient(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1011410632")) {
                return ((Boolean) ipChange.ipc$dispatch("1011410632", new Object[]{this, webView, str})).booleanValue();
            }
            if (!str.contains("orderlist.aspx")) {
                return (str.startsWith("http:") || str.startsWith("https:")) ? false : true;
            }
            WapPayActivity.this.gotoOrderList();
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class ICBCWebViewClient extends WVUCWebViewClient {
        private static transient /* synthetic */ IpChange $ipChange;

        public ICBCWebViewClient(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "534531903") ? ((Boolean) ipChange.ipc$dispatch("534531903", new Object[]{this, webView, str})).booleanValue() : (str.startsWith("http:") || str.startsWith("https:")) ? false : true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class MyWebViewClient extends WVUCWebViewClient {
        private static transient /* synthetic */ IpChange $ipChange;

        public MyWebViewClient(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1034183680")) {
                ipChange.ipc$dispatch("-1034183680", new Object[]{this, webView, str});
                return;
            }
            super.onPageFinished(webView, str);
            WapPayActivity.this.stopProgressDialog();
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1755820445")) {
                ipChange.ipc$dispatch("1755820445", new Object[]{this, webView, str, bitmap});
                return;
            }
            super.onPageStarted(webView, str, bitmap);
            WapPayActivity.this.startProgressDialog();
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-112421893")) {
                ipChange.ipc$dispatch("-112421893", new Object[]{this, webView, Integer.valueOf(i), str, str2});
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1752058384")) {
                return ((Boolean) ipChange.ipc$dispatch("-1752058384", new Object[]{this, webView, str})).booleanValue();
            }
            if (str.contains("orderlist.aspx")) {
                WapPayActivity.this.gotoOrderList();
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                return false;
            }
            return true;
        }
    }

    private void getIntentData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577759522")) {
            ipChange.ipc$dispatch("-577759522", new Object[]{this});
            return;
        }
        this.mPayTitle = cm2.a(this, R$array.pay_title);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            if (extras.containsKey("type")) {
                this.mCurrentType = extras.getString("type");
            }
            if (extras.containsKey("fromMovie")) {
                this.isFromMovie = extras.getBoolean("fromMovie");
            }
            if (extras.containsKey("orderid")) {
                this.mOrderId = extras.getString("orderid");
            }
            if (extras.containsKey("from")) {
                this.mFromPage = extras.getString("from", "");
            }
            if (extras.containsKey("bizType")) {
                this.bizType = extras.getString("bizType");
            }
            setTitleContent(extras.getString("title", "支付"));
            return;
        }
        setTitleContent("支付");
    }

    private void loadDataWithBaseUrl(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-914942287")) {
            ipChange.ipc$dispatch("-914942287", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        String[] strArr = this.mPayTitle;
        if (i < strArr.length) {
            setTitleContent(strArr[i]);
        }
        String stringExtra = getIntent().getStringExtra("wappay_url");
        this.mWebView.loadDataWithBaseURL(null, "<html> <head><title></title></head><body>" + stringExtra + "</body><script>document.getElementsByTagName(\"form\")[0].submit()</script></html>", "text/html", "utf-8", null);
    }

    private void loadWebView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712760519")) {
            ipChange.ipc$dispatch("712760519", new Object[]{this});
            return;
        }
        DamaiWebView damaiWebView = (DamaiWebView) findViewById(R$id.myWebView2);
        this.mWebView = damaiWebView;
        WebSettings settings = damaiWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (this.mCurrentType.equals(TYPE_ICBC_BANK)) {
            this.mWebView.setWebViewClient(new ICBCWebViewClient(this));
        } else if (this.mCurrentType.equals(TYPE_ANT_CHECK_LATER)) {
            this.mWebView.setWebViewClient(new ALIWebViewClient(this));
        } else {
            this.mWebView.setWebViewClient(new MyWebViewClient(this));
        }
        this.mWebView.setOnKeyListener(new View.OnKeyListener() { // from class: cn.damai.pay.WapPayActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-714736062")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-714736062", new Object[]{this, view, Integer.valueOf(i), keyEvent})).booleanValue();
                }
                if (i == 4 && keyEvent.getAction() == 1) {
                    if (!WapPayActivity.this.mCurrentType.equals(WapPayActivity.TYPE_PINGAN_BANK) && !WapPayActivity.this.mCurrentType.equals(WapPayActivity.TYPE_JCB_BANK)) {
                        if (WapPayActivity.this.mWebView.canGoBack()) {
                            WapPayActivity.this.mWebView.goBack();
                            WapPayActivity.this.finish();
                        } else if (!WapPayActivity.this.mWebView.canGoBack()) {
                            WapPayActivity.this.gotoOrderList();
                        }
                        return true;
                    }
                    WapPayActivity.this.gotoOrderList();
                    return true;
                }
                return false;
            }
        });
        this.mWebView.setOnTouchListener(new View.OnTouchListener() { // from class: cn.damai.pay.WapPayActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "869540895")) {
                    return ((Boolean) ipChange2.ipc$dispatch("869540895", new Object[]{this, view, motionEvent})).booleanValue();
                }
                int action = motionEvent.getAction();
                if ((action == 0 || action == 1) && !view.hasFocus()) {
                    view.requestFocus();
                    return true;
                }
                return false;
            }
        });
        if (this.mCurrentType.equals(TYPE_ZHIFUBAO)) {
            setTitleContent(this.mPayTitle[0]);
            this.mWebView.loadUrl(getIntent().getStringExtra("wappay_url"));
        } else if (this.mCurrentType.equals(TYPE_WALLET)) {
            setTitleContent(this.mPayTitle[1]);
            this.mWebView.loadUrl(getIntent().getStringExtra("wappay_url"));
        } else if (this.mCurrentType.equals(TYPE_ANT_CHECK_LATER)) {
            setTitleContent(this.mPayTitle[13]);
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            this.mWebView.loadUrl(getIntent().getStringExtra("wappay_url"));
        } else if (this.mCurrentType.equals(TYPE_ZERO_PAY)) {
            setTitleContent("0元支付");
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            this.mWebView.loadUrl(getIntent().getStringExtra("wappay_url"));
        } else if (this.mCurrentType.equals(TYPE_CHINA_BANK)) {
            this.mWebView.setWebViewClient(new MyWebViewClient(this));
            loadDataWithBaseUrl(2);
        } else if (this.mCurrentType.equals(TYPE_UNION_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient(this));
            loadDataWithBaseUrl(3);
        } else if (this.mCurrentType.equals(TYPE_ZHAOSHANG_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(4);
        } else if (this.mCurrentType.equals(TYPE_PUFA_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(5);
        } else if (this.mCurrentType.equals(TYPE_ICBC_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(6);
        } else if (this.mCurrentType.equals(TYPE_PINGAN_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(7);
        } else if (this.mCurrentType.equals(TYPE_JCB_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(8);
        } else if (this.mCurrentType.equals(TYPE_PUFA_CARD_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(9);
        } else if (this.mCurrentType.equals(TYPE_GUANGFA_CARD_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(10);
        } else if (this.mCurrentType.equals(TYPE_JD_PAY)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(11);
        } else if (this.mCurrentType.equals(TYPE_AE_CARD)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(12);
        } else if (this.mCurrentType.equals(TYPE_GUANGDA_CARD_BANK)) {
            this.mWebView.setWebChromeClient(new WVUCWebChromeClient());
            loadDataWithBaseUrl(14);
        }
    }

    public boolean checkICBCApk() {
        PackageInfo packageInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101536187")) {
            return ((Boolean) ipChange.ipc$dispatch("1101536187", new Object[]{this})).booleanValue();
        }
        try {
            packageInfo = getPackageManager().getPackageInfo("com.icbc", 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            System.out.println(cm2.b(this, R$string.damai_alipay_no_installation));
            return false;
        }
        System.out.println(cm2.b(this, R$string.damai_alipay_already_installed));
        return true;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154527176")) {
            ipChange.ipc$dispatch("-154527176", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003 || i == 10001) {
            gotoOrderList();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-327101262") ? ((Integer) ipChange.ipc$dispatch("-327101262", new Object[]{this})).intValue() : R$layout.wap_pay_fragment;
    }

    public void gotoOrderList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772634417")) {
            ipChange.ipc$dispatch("1772634417", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.bizType) && AliPayActivity.FROM_HN_CRETE_ORDER_PAGE.equalsIgnoreCase(this.bizType)) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.mOrderId)) {
                bundle.putString("orderId", this.mOrderId);
            }
            bundle.putBoolean(AliPayActivity.FROM_HN_CRETE_ORDER_PAGE, true);
            DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(cs.h));
            finish();
        } else if (this.isFromMovie) {
            setResult(1000);
            finish();
        } else if ("OrderDetailPage".equals(this.mFromPage)) {
            setResult(1000);
            finish();
        } else {
            Intent intent = new Intent(this.context, OrderListActivity.class);
            if (!TextUtils.isEmpty(this.mOrderId)) {
                intent.putExtra("orderid", this.mOrderId);
            }
            startActivity(intent);
            setResult(1000);
            finish();
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882764041")) {
            ipChange.ipc$dispatch("882764041", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1328224702")) {
            ipChange.ipc$dispatch("-1328224702", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592344805")) {
            ipChange.ipc$dispatch("-1592344805", new Object[]{this});
            return;
        }
        getIntentData();
        loadWebView();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970685090")) {
            ipChange.ipc$dispatch("-970685090", new Object[]{this});
        } else {
            gotoOrderList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1367784767")) {
            ipChange.ipc$dispatch("1367784767", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.context = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-778774465")) {
            ipChange.ipc$dispatch("-778774465", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125314616")) {
            ipChange.ipc$dispatch("2125314616", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404719907")) {
            ipChange.ipc$dispatch("-1404719907", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921517916")) {
            ipChange.ipc$dispatch("-921517916", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
        if (this.mCurrentType.equals(TYPE_ICBC_BANK) && this.times == 1) {
            gotoOrderList();
        }
        this.times++;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1807719334") ? (String) ipChange.ipc$dispatch("1807719334", new Object[]{this}) : "";
    }
}
