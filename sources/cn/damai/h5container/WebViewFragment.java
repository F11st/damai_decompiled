package cn.damai.h5container;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.model.RealNameInfo;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.h5container.refresh.ClassicalHeader;
import cn.damai.h5container.refresh.JRefreshLayout;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.login.havana.ILoginListener;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.mtop.wvplugin.MtopWVPlugin;
import com.uc.webview.export.DownloadListener;
import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebHistoryItem;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import tb.cb1;
import tb.cm2;
import tb.cs;
import tb.hs1;
import tb.jn1;
import tb.mu0;
import tb.qw2;
import tb.uh1;
import tb.wu0;
import tb.xj1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WebViewFragment extends DamaiBaseMvpFragment implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int backType;
    private Bundle bundle;
    private WVUCWebChromeClient chromeClient;
    LoadListener listener;
    ResponseErrorPage mErrorPage;
    ValueCallback<Uri> mUploadMessage;
    DamaiWebView mWebView;
    JRefreshLayout refreshLayout;
    String url;
    WebViewUtil util;
    WebSettings webSetting;
    boolean skip = false;
    boolean mtopWVPluginRegister = false;
    boolean isFromPush = false;
    boolean backtohome = false;
    boolean neterror = false;
    private ScreenShotDetector.IScreenShotExtraListener screenShotExtraListener = new ScreenShotDetector.IScreenShotExtraListener() { // from class: cn.damai.h5container.WebViewFragment.4
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotExtraListener
        public void onDetected(String str, Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1011783789")) {
                ipChange.ipc$dispatch("-1011783789", new Object[]{this, str, activity});
            } else {
                WebViewFragment.this.showDetectView(str);
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface LoadListener {
        void onLoadFinish();
    }

    private String fixUTUrl(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "270293033") ? (String) ipChange.ipc$dispatch("270293033", new Object[]{this, str}) : (str == null || "".equalsIgnoreCase(str)) ? "" : URLDecoder.decode(str.replace("https://passport.damai.cn/third/rurl.do?url=", ""));
    }

    private void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-637540228")) {
            ipChange.ipc$dispatch("-637540228", new Object[]{this, str});
            return;
        }
        if (getActivity() != null && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).setTitleContent(str);
        }
        WVUCWebChromeClient wVUCWebChromeClient = this.chromeClient;
        if (wVUCWebChromeClient != null) {
            wVUCWebChromeClient.onReceivedTitle(this.mWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDetectView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-590108179")) {
            ipChange.ipc$dispatch("-590108179", new Object[]{this, str});
            return;
        }
        this.mWebView.evaluateJavascript("isLiveH5('  Android调用js  ')", new ValueCallback<String>() { // from class: cn.damai.h5container.WebViewFragment.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1144637962")) {
                    ipChange2.ipc$dispatch("-1144637962", new Object[]{this, str2});
                    return;
                }
                cb1.c("webviewFragmenteva", "a+b=" + str2);
            }
        });
        this.mBaseActivity.setmDetectActivityShow(false);
    }

    private void webViewSetting() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976582257")) {
            ipChange.ipc$dispatch("1976582257", new Object[]{this});
            return;
        }
        DMBridge.registerPlugin(getActivity());
        this.mWebView.setWebViewClient(new DmWebViewClient(this));
        this.mWebView.setWebChromeClient(new DmWebChromeClient(this));
        this.mWebView.requestFocus();
        this.mWebView.setSelected(true);
        WebSettings settings = this.mWebView.getSettings();
        this.webSetting = settings;
        settings.setDefaultTextEncodingName("utf-8");
        this.webSetting.setJavaScriptEnabled(true);
        this.webSetting.setGeolocationEnabled(true);
        this.webSetting.setDomStorageEnabled(true);
        this.webSetting.setDatabaseEnabled(true);
        this.webSetting.setAppCacheEnabled(true);
        this.webSetting.setAppCacheMaxSize(12582912L);
        this.webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.webSetting.setBlockNetworkImage(false);
        this.webSetting.setNeedInitialFocus(true);
        this.webSetting.setDefaultFontSize(14);
        this.webSetting.setCacheMode(-1);
        this.webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        this.webSetting.setUseWideViewPort(true);
        this.webSetting.setBuiltInZoomControls(false);
        this.webSetting.setSupportZoom(false);
        this.webSetting.setDisplayZoomControls(false);
        this.webSetting.setLoadWithOverviewMode(true);
        this.mWebView.setOverScrollMode(0);
        String str = getActivity().getFilesDir().getAbsolutePath() + "/dmcache";
        this.webSetting.setDatabasePath(str);
        this.webSetting.setAppCachePath(str);
        try {
            this.webSetting.setSupportMultipleWindows(false);
            this.webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
            this.mWebView.addJavascriptInterface(this, "javatojs");
            this.mWebView.addJavascriptInterface(this, "android");
            this.mWebView.addJavascriptInterface(this, "special_title");
            this.mWebView.addJavascriptInterface(this, "wallet_authenticate");
            this.mWebView.addJavascriptInterface(this, "real_name");
            this.webSetting.setAllowUniversalAccessFromFileURLs(true);
            this.webSetting.setAllowFileAccessFromFileURLs(true);
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mWebView.setVerticalScrollBarEnabled(false);
            this.webSetting.setAllowContentAccess(true);
            this.mWebView.setDownloadListener(new DownloadListener() { // from class: cn.damai.h5container.WebViewFragment.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.uc.webview.export.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1438338371")) {
                        ipChange2.ipc$dispatch("1438338371", new Object[]{this, str2, str3, str4, str5, Long.valueOf(j)});
                        return;
                    }
                    try {
                        WebViewFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                    } catch (Exception e) {
                        qw2.b(e);
                    }
                }
            });
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(AppConfig.v());
        }
    }

    public boolean backPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221749525")) {
            return ((Boolean) ipChange.ipc$dispatch("-1221749525", new Object[]{this})).booleanValue();
        }
        if (this.backtohome) {
            DMNav.from(getActivity()).toUri(NavUri.b(cs.n));
            getActivity().finish();
            return true;
        } else if (this.isFromPush && this.backType != 1) {
            DMNav.from(getActivity()).toUri(NavUri.b(cs.n));
            getActivity().finish();
            return true;
        } else {
            DamaiWebView damaiWebView = this.mWebView;
            if (damaiWebView == null || !damaiWebView.canGoBack()) {
                return false;
            }
            this.mWebView.goBack();
            return true;
        }
    }

    public void checkLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387382887")) {
            ipChange.ipc$dispatch("387382887", new Object[]{this});
        } else {
            LoginManager.k().y(this, new Intent(), 10);
        }
    }

    public boolean checkNetError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581914541")) {
            return ((Boolean) ipChange.ipc$dispatch("-581914541", new Object[]{this})).booleanValue();
        }
        if (!xj1.b(getActivity())) {
            onResponseError("网络不可用,请检查您的网络。", "1001");
            this.neterror = true;
        } else {
            onResponseSuccess();
            this.neterror = false;
        }
        return this.neterror;
    }

    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1087735467")) {
            ipChange.ipc$dispatch("-1087735467", new Object[]{this});
        } else if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-748007129") ? ((Integer) ipChange.ipc$dispatch("-748007129", new Object[]{this})).intValue() : R$layout.webview_fragment;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557383681")) {
            ipChange.ipc$dispatch("557383681", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void initParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541564219")) {
            ipChange.ipc$dispatch("-1541564219", new Object[]{this});
        } else if (getActivity() == null) {
        } else {
            if (this.bundle == null) {
                this.bundle = getArguments();
            }
            if (this.bundle == null && getActivity().getIntent() != null) {
                this.bundle = getActivity().getIntent().getExtras();
            }
            Bundle bundle = this.bundle;
            if (bundle == null) {
                return;
            }
            this.url = bundle.getString("url", "");
            Log.d("applink", " uri : bundle.getString " + this.url);
            if (this.bundle.containsKey(DamaiConstants.PUSH_MSG_SUMMARY)) {
                setTitle(cm2.b(getActivity(), R$string.damai_webviewkefu_activity_introduction_title));
                this.isFromPush = true;
                this.url = this.bundle.getString(DamaiConstants.PUSH_MSG_SUMMARY).trim();
                Log.d("applink", " uri : PUSH_MSG_SUMMARY " + this.url);
                this.backType = this.bundle.getInt(DamaiConstants.PUSH_MSG_BACK_TYPE);
            }
            if (TextUtils.isEmpty(this.url)) {
                ToastUtil.i("url出错啦.");
                getActivity().finish();
                return;
            }
            if (this.url.contains("refreshable=")) {
                String str = null;
                try {
                    str = Uri.parse(this.url).getQueryParameter("refreshable");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (str != null && "true".equals(str)) {
                    this.refreshLayout.setRefreshEnable(true);
                }
            } else if (this.bundle.containsKey("refreshable")) {
                this.refreshLayout.setRefreshEnable(this.bundle.getBoolean("refreshable"));
            }
            if (this.url.contains("h5.m.taopiaopiao.com/app/movie/pages/index")) {
                this.url = "https://h5.m.taopiaopiao.com/app/moviemain/pages/index/index.html?from=damai";
                return;
            }
            this.skip = this.bundle.getBoolean(MonitorType.SKIP, false);
            if (AppConfig.g() == AppConfig.EnvMode.test || AppConfig.g() == AppConfig.EnvMode.prepare) {
                this.skip = true;
            }
            if (WVPluginManager.getPluginInfo(MtopWVPlugin.API_SERVER_NAME) == null) {
                uh1.a();
            }
            this.backtohome = this.bundle.getBoolean("backtohome", false);
            boolean z = this.bundle.getBoolean("fromQr", false);
            if (this.skip || "true".equals(this.bundle.getString(MonitorType.SKIP)) || this.url.contains("dmskip=true") || this.url.startsWith("damai:") || !z || WVServerConfig.isTrustedUrl(this.url)) {
                return;
            }
            if (LoginManager.k().q() && !this.url.contains(ShareperfenceConstants.OLD_LOGIN_KEY)) {
                this.url = URLEncoder.encode(this.url);
                this.url = "https://passport.damai.cn/third/rurl.do?url=" + this.url + "&loginkey=" + z20.q();
                return;
            }
            this.url = URLEncoder.encode(this.url);
            this.url = "https://passport.damai.cn/third/rurl.do?url=" + this.url;
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469886026")) {
            ipChange.ipc$dispatch("1469886026", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1157361133")) {
            ipChange.ipc$dispatch("-1157361133", new Object[]{this});
            return;
        }
        View view = this.rootView;
        if (view == null) {
            return;
        }
        this.mWebView = (DamaiWebView) view.findViewById(R$id.mWebView);
        JRefreshLayout jRefreshLayout = (JRefreshLayout) this.rootView.findViewById(R$id.refreshLayout);
        this.refreshLayout = jRefreshLayout;
        jRefreshLayout.setJRefreshListener(new JRefreshLayout.JRefreshListener() { // from class: cn.damai.h5container.WebViewFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.h5container.refresh.JRefreshLayout.JRefreshListener
            public void onRefresh(JRefreshLayout jRefreshLayout2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1574485245")) {
                    ipChange2.ipc$dispatch("-1574485245", new Object[]{this, jRefreshLayout2});
                } else if (xj1.b(WebViewFragment.this.getContext())) {
                    WebViewFragment.this.onResponseSuccess();
                    WebViewFragment.this.mWebView.reload();
                }
            }
        });
        this.refreshLayout.setHeaderView(new ClassicalHeader(getContext()));
        this.refreshLayout.setRefreshEnable(false);
        try {
            if (getActivity() != null && wu0.d(getActivity().getClass().getSimpleName())) {
                this.refreshLayout.setLayerType(2, null);
            }
        } catch (Exception unused) {
        }
        this.util = new WebViewUtil();
        initParam();
        webViewSetting();
        this.mWebView.loadUrl(this.url);
        checkNetError();
        HavanaProxy.v().g(this);
    }

    public String lastUrl() {
        WebHistoryItem itemAtIndex;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203728681")) {
            return (String) ipChange.ipc$dispatch("-1203728681", new Object[]{this});
        }
        WebBackForwardList copyBackForwardList = this.mWebView.copyBackForwardList();
        return (copyBackForwardList == null || copyBackForwardList.getSize() == 0 || (itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1)) == null) ? "" : itemAtIndex.getUrl();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416338118")) {
            ipChange.ipc$dispatch("-1416338118", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        this.mWebView.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i == 10) {
            if (i2 == -1) {
                initView();
            } else if (i2 != 0) {
                getActivity().setResult(-1);
                finish();
            }
        }
        if (-1 == i2) {
            switch (i) {
                case 257:
                    this.util.startPhotoCapture(intent.getData(), getActivity());
                    return;
                case 258:
                    this.util.startPhotoCapture(Uri.fromFile(new File(hs1.a(getActivity()))), getActivity());
                    return;
                case H5MainActivity.REQUEST_CORP /* 259 */:
                    Uri fromFile = Uri.fromFile(new File(hs1.a(getActivity())));
                    ValueCallback<Uri> valueCallback = this.mUploadMessage;
                    if (valueCallback == null) {
                        return;
                    }
                    valueCallback.onReceiveValue(fromFile);
                    this.mUploadMessage = null;
                    return;
                case H5MainActivity.REQUEST_REALNAME /* 260 */:
                    RealNameInfo realNameInfo = (RealNameInfo) z20.h(ShareperfenceConstants.USER_DATA_REALNAMEINFO, RealNameInfo.class);
                    if (realNameInfo != null && realNameInfo.realNameStatus) {
                        this.mWebView.loadUrl("javascript:realNameThenticate('1')");
                        return;
                    } else {
                        this.mWebView.loadUrl("javascript:realNameThenticate('0')");
                        return;
                    }
                default:
                    return;
            }
        }
        ValueCallback<Uri> valueCallback2 = this.mUploadMessage;
        if (valueCallback2 == null) {
            return;
        }
        valueCallback2.onReceiveValue(null);
        this.mUploadMessage = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-543949511")) {
            ipChange.ipc$dispatch("-543949511", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340102621")) {
            return (View) ipChange.ipc$dispatch("340102621", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        if (!WindVaneSDK.isInitialized()) {
            Log.d("delayInit", "windvane lazy init start");
            String n = AppConfig.n(mu0.a());
            if (!TextUtils.isEmpty(n) && n.equals("cn.damai")) {
                WindvaneAgent.initWindVane(mu0.a());
            }
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-179182521")) {
            ipChange.ipc$dispatch("-179182521", new Object[]{this});
            return;
        }
        super.onDestroy();
        try {
            DamaiWebView damaiWebView = this.mWebView;
            if (damaiWebView != null) {
                damaiWebView.destroy();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        HavanaProxy.v().Q(this);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1699170914")) {
            ipChange.ipc$dispatch("1699170914", new Object[]{this});
            return;
        }
        super.onDestroyView();
        ScreenShotDetector.k().x(null);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Bundle bundle;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211436061")) {
            ipChange.ipc$dispatch("211436061", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onHiddenChanged(z);
        DamaiWebView damaiWebView = this.mWebView;
        if (damaiWebView == null || damaiWebView.getUrl() == null || (bundle = this.bundle) == null || !bundle.containsKey("url") || z) {
            return;
        }
        String string = this.bundle.getString("url");
        initParam();
        if (this.mWebView.getUrl().equals(string) || this.mWebView.getUrl().contains(string)) {
            return;
        }
        this.mWebView.loadUrl(this.url);
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-461711778")) {
            ipChange.ipc$dispatch("-461711778", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421705734")) {
            ipChange.ipc$dispatch("-421705734", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245856591")) {
            ipChange.ipc$dispatch("245856591", new Object[]{this});
            return;
        }
        DamaiWebView damaiWebView = this.mWebView;
        if (damaiWebView != null) {
            damaiWebView.refresh();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-207557345")) {
            ipChange.ipc$dispatch("-207557345", new Object[]{this});
        }
    }

    public void onPageFinished(WebView webView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1894695356")) {
            ipChange.ipc$dispatch("1894695356", new Object[]{this, webView, str});
            return;
        }
        this.webSetting.setBlockNetworkImage(false);
        String title = this.mWebView.getTitle();
        if (title != null && !title.contains("http") && !title.contains("mapi")) {
            setTitle(title);
        }
        if (getActivity() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra("datajson");
            if (!TextUtils.isEmpty(stringExtra)) {
                DamaiWebView damaiWebView = this.mWebView;
                damaiWebView.loadUrl("javascript:orderCommentData(" + stringExtra + jn1.BRACKET_END_STR);
            }
        }
        WVStandardEventCenter.postNotificationToJS(this.mWebView, "dmAndroidShare", "dmAndroidShare");
        JRefreshLayout jRefreshLayout = this.refreshLayout;
        if (jRefreshLayout != null) {
            jRefreshLayout.refreshComplete(true);
        }
        LoadListener loadListener = this.listener;
        if (loadListener != null) {
            loadListener.onLoadFinish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761585717")) {
            ipChange.ipc$dispatch("-761585717", new Object[]{this});
            return;
        }
        super.onPause();
        DamaiWebView damaiWebView = this.mWebView;
        if (damaiWebView != null) {
            damaiWebView.onPause();
        }
        JRefreshLayout jRefreshLayout = this.refreshLayout;
        if (jRefreshLayout != null) {
            jRefreshLayout.refreshComplete(true);
        }
    }

    public void onResponseError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-633942546")) {
            ipChange.ipc$dispatch("-633942546", new Object[]{this, str, str2});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if ((responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) && getActivity() != null) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(getActivity(), str2, str, "");
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.hideTitle();
            this.mErrorPage.setRefreshListener(new ResponseErrorPage.ErrorRefreshListener() { // from class: cn.damai.h5container.WebViewFragment.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
                public void handleError(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-61330672")) {
                        ipChange2.ipc$dispatch("-61330672", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    DamaiWebView damaiWebView = WebViewFragment.this.mWebView;
                    if (damaiWebView != null) {
                        damaiWebView.reload();
                    }
                }
            });
            if (this.rootView instanceof RelativeLayout) {
                ((ViewGroup) this.rootView).addView(this.mErrorPage, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824267585")) {
            ipChange.ipc$dispatch("-1824267585", new Object[]{this});
            return;
        }
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                View view = this.rootView;
                if (view instanceof ViewGroup) {
                    ((ViewGroup) view).removeView(this.mErrorPage);
                }
                this.mErrorPage = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getActivity() == null || !(getActivity() instanceof H5MainActivity)) {
            return;
        }
        ((H5MainActivity) getActivity()).hideShareMenu();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486534244")) {
            ipChange.ipc$dispatch("-486534244", new Object[]{this});
            return;
        }
        super.onResume();
        DamaiWebView damaiWebView = this.mWebView;
        if (damaiWebView != null) {
            damaiWebView.onResume();
        }
        DMBridge.resume(getActivity());
        ScreenShotDetector.k().x(this.screenShotExtraListener);
    }

    public void setBundle(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1291499222")) {
            ipChange.ipc$dispatch("1291499222", new Object[]{this, bundle});
        } else {
            this.bundle = bundle;
        }
    }

    public void setListener(LoadListener loadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-33632406")) {
            ipChange.ipc$dispatch("-33632406", new Object[]{this, loadListener});
        } else {
            this.listener = loadListener;
        }
    }

    public void setWebChromeClientListener(WVUCWebChromeClient wVUCWebChromeClient) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "433038942")) {
            ipChange.ipc$dispatch("433038942", new Object[]{this, wVUCWebChromeClient});
        } else {
            this.chromeClient = wVUCWebChromeClient;
        }
    }
}
