package cn.damai.h5container;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.taobao.windvane.webview.WVUIModel;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.model.RealNameInfo;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.h5container.DMH5Fragment;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.login.havana.ILoginListener;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.mtop.wvplugin.MtopWVPlugin;
import com.taomai.android.h5container.ui.TaoMaiUCH5Fragment;
import com.taomai.android.h5container.webview.TaoMaiUCWebView;
import com.uc.webview.export.DownloadListener;
import com.uc.webview.export.WebResourceError;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import com.youku.android.utils.OPRUtils;
import java.io.File;
import java.net.URLEncoder;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bl2;
import tb.cb1;
import tb.cl2;
import tb.cs;
import tb.hs1;
import tb.mu0;
import tb.qw2;
import tb.uh1;
import tb.xj1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class DMH5Fragment extends TaoMaiUCH5Fragment implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int backType;
    private boolean backtohome;
    @Nullable
    private Bundle bundle;
    private boolean isFromPush;
    @Nullable
    private ResponseErrorPage mErrorPage;
    @Nullable
    private ValueCallback<Uri> mUploadMessage;
    private boolean neterror;
    private boolean skip;
    @NotNull
    private final WebViewUtil util = new WebViewUtil();
    @NotNull
    private final ScreenShotDetector.IScreenShotExtraListener screenShotExtraListener = new ScreenShotDetector.IScreenShotExtraListener() { // from class: tb.sr
        @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotExtraListener
        public final void onDetected(String str, Activity activity) {
            DMH5Fragment.m37screenShotExtraListener$lambda6(DMH5Fragment.this, str, activity);
        }
    };

    private final void initParam() {
        boolean K;
        boolean K2;
        boolean K3;
        String str;
        Bundle arguments;
        Intent intent;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1942686420")) {
            ipChange.ipc$dispatch("1942686420", new Object[]{this});
            return;
        }
        if (this.bundle == null) {
            this.bundle = getArguments();
        }
        if (this.bundle == null) {
            FragmentActivity activity = getActivity();
            if ((activity != null ? activity.getIntent() : null) != null) {
                FragmentActivity activity2 = getActivity();
                this.bundle = (activity2 == null || (intent = activity2.getIntent()) == null) ? null : intent.getExtras();
            }
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && arguments2.containsKey(DamaiConstants.PUSH_MSG_SUMMARY)) {
            setWebTitle("活动介绍");
            this.isFromPush = true;
            String string = requireArguments().getString(DamaiConstants.PUSH_MSG_SUMMARY);
            b41.f(string);
            int length = string.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = b41.k(string.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            setUrl(string.subSequence(i, length + 1).toString());
            Log.d("applink", " uri : PUSH_MSG_SUMMARY " + getUrl());
            Bundle bundle = this.bundle;
            b41.f(bundle);
            this.backType = bundle.getInt(DamaiConstants.PUSH_MSG_BACK_TYPE);
        }
        if (TextUtils.isEmpty(getUrl())) {
            ToastUtil.i("url出错啦.");
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
                return;
            }
            return;
        }
        String url = getUrl();
        b41.f(url);
        K = StringsKt__StringsKt.K(url, "refreshable=", false, 2, null);
        if (K) {
            try {
                str = Uri.parse(getUrl()).getQueryParameter("refreshable");
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (str != null && b41.d("true", str) && (arguments = getArguments()) != null) {
                arguments.putString("pullRefresh", "YES");
            }
        } else {
            Bundle bundle2 = this.bundle;
            if (bundle2 != null) {
                b41.f(bundle2);
                if (bundle2.containsKey("refreshable")) {
                    Bundle bundle3 = this.bundle;
                    b41.f(bundle3);
                    boolean z4 = bundle3.getBoolean("refreshable");
                    Bundle arguments3 = getArguments();
                    if (arguments3 != null) {
                        arguments3.putString("pullRefresh", z4 ? "YES" : "NO");
                    }
                }
            }
        }
        String url2 = getUrl();
        b41.f(url2);
        K2 = StringsKt__StringsKt.K(url2, "h5.m.taopiaopiao.com/app/movie/pages/index", false, 2, null);
        if (K2) {
            setUrl("https://h5.m.taopiaopiao.com/app/moviemain/pages/index/index.html?from=damai");
            return;
        }
        Bundle bundle4 = this.bundle;
        this.skip = bundle4 != null ? bundle4.getBoolean(MonitorType.SKIP, false) : false;
        if (AppConfig.g() == AppConfig.EnvMode.test || AppConfig.g() == AppConfig.EnvMode.prepare) {
            this.skip = true;
        }
        if (WVPluginManager.getPluginInfo(MtopWVPlugin.API_SERVER_NAME) == null) {
            uh1.a();
        }
        Bundle bundle5 = this.bundle;
        this.backtohome = bundle5 != null ? bundle5.getBoolean("backtohome", false) : false;
        Bundle bundle6 = this.bundle;
        z = (bundle6 == null || !bundle6.getBoolean("fromQr", false)) ? false : false;
        if (!z) {
            Bundle bundle7 = this.bundle;
            z = b41.d(bundle7 != null ? bundle7.getString("fromQr", null) : null, "true");
        }
        if (this.skip) {
            z = false;
        }
        if (z) {
            if (LoginManager.k().q()) {
                String url3 = getUrl();
                b41.f(url3);
                K3 = StringsKt__StringsKt.K(url3, ShareperfenceConstants.OLD_LOGIN_KEY, false, 2, null);
                if (!K3) {
                    setUrl(URLEncoder.encode(getUrl()));
                    setUrl("https://passport.damai.cn/third/rurl.do?url=" + getUrl() + "&loginkey=" + z20.q());
                    return;
                }
            }
            setUrl(URLEncoder.encode(getUrl()));
            setUrl("https://passport.damai.cn/third/rurl.do?url=" + getUrl());
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2014797276")) {
            ipChange.ipc$dispatch("-2014797276", new Object[]{this});
            return;
        }
        HavanaProxy.v().g(this);
        webViewSetting();
        TaoMaiUCWebView webView = getWebView();
        if (webView == null) {
            return;
        }
        WVUIModel wVUIModel = new WVUIModel(getActivity(), getWebView());
        ResponseErrorPage responseErrorPage = new ResponseErrorPage(getActivity(), OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM, "麦麦很忙，系统很累请稍后重试", "");
        responseErrorPage.hideTitle();
        responseErrorPage.setRefreshListener(new ResponseErrorPage.ErrorRefreshListener() { // from class: tb.rr
            @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
            public final void handleError(int i) {
                DMH5Fragment.m36initView$lambda4$lambda3$lambda2(DMH5Fragment.this, i);
            }
        });
        wVUIModel.setErrorView(responseErrorPage);
        webView.setWvUIModel(wVUIModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-4$lambda-3$lambda-2  reason: not valid java name */
    public static final void m36initView$lambda4$lambda3$lambda2(DMH5Fragment dMH5Fragment, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143370605")) {
            ipChange.ipc$dispatch("-1143370605", new Object[]{dMH5Fragment, Integer.valueOf(i)});
            return;
        }
        b41.i(dMH5Fragment, "this$0");
        TaoMaiUCWebView webView = dMH5Fragment.getWebView();
        if (webView != null) {
            webView.reload();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: screenShotExtraListener$lambda-6  reason: not valid java name */
    public static final void m37screenShotExtraListener$lambda6(DMH5Fragment dMH5Fragment, String str, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589698782")) {
            ipChange.ipc$dispatch("589698782", new Object[]{dMH5Fragment, str, activity});
            return;
        }
        b41.i(dMH5Fragment, "this$0");
        b41.h(str, "s");
        dMH5Fragment.showDetectView(str);
    }

    private final void showDetectView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809326334")) {
            ipChange.ipc$dispatch("809326334", new Object[]{this, str});
            return;
        }
        TaoMaiUCWebView webView = getWebView();
        if (webView != null) {
            webView.evaluateJavascript("isLiveH5('  Android调用js  ')", new ValueCallback() { // from class: tb.qr
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    DMH5Fragment.m38showDetectView$lambda7((String) obj);
                }
            });
        }
        ScreenShotDetector.k().y(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDetectView$lambda-7  reason: not valid java name */
    public static final void m38showDetectView$lambda7(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147009323")) {
            ipChange.ipc$dispatch("2147009323", new Object[]{str});
            return;
        }
        cb1.c("webviewFragmenteva", "a+b=" + str);
    }

    private final void webViewSetting() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206749634")) {
            ipChange.ipc$dispatch("206749634", new Object[]{this});
            return;
        }
        DMBridge.registerPlugin(getActivity());
        TaoMaiUCWebView webView = getWebView();
        if (webView != null) {
            webView.setWebViewClient(new DmWebViewClient(this));
        }
        TaoMaiUCWebView webView2 = getWebView();
        if (webView2 != null) {
            webView2.setWebChromeClient(new DmWebChromeClient(this));
        }
        TaoMaiUCWebView webView3 = getWebView();
        if (webView3 != null) {
            webView3.requestFocus();
        }
        TaoMaiUCWebView webView4 = getWebView();
        if (webView4 != null) {
            webView4.setSelected(true);
        }
        TaoMaiUCWebView webView5 = getWebView();
        WebSettings settings = webView5 != null ? webView5.getSettings() : null;
        if (settings == null) {
            return;
        }
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(12582912L);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setBlockNetworkImage(false);
        settings.setNeedInitialFocus(true);
        settings.setDefaultFontSize(14);
        settings.setCacheMode(-1);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        TaoMaiUCWebView webView6 = getWebView();
        if (webView6 != null) {
            webView6.setOverScrollMode(0);
        }
        String str = requireActivity().getFilesDir().getAbsolutePath() + "/dmcache";
        settings.setDatabasePath(str);
        settings.setAppCachePath(str);
        try {
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            TaoMaiUCWebView webView7 = getWebView();
            if (webView7 != null) {
                webView7.addJavascriptInterface(this, "javatojs");
            }
            TaoMaiUCWebView webView8 = getWebView();
            if (webView8 != null) {
                webView8.addJavascriptInterface(this, "android");
            }
            TaoMaiUCWebView webView9 = getWebView();
            if (webView9 != null) {
                webView9.addJavascriptInterface(this, "special_title");
            }
            TaoMaiUCWebView webView10 = getWebView();
            if (webView10 != null) {
                webView10.addJavascriptInterface(this, "wallet_authenticate");
            }
            TaoMaiUCWebView webView11 = getWebView();
            if (webView11 != null) {
                webView11.addJavascriptInterface(this, "real_name");
            }
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setAllowFileAccessFromFileURLs(true);
            TaoMaiUCWebView webView12 = getWebView();
            if (webView12 != null) {
                webView12.setHorizontalScrollBarEnabled(false);
            }
            TaoMaiUCWebView webView13 = getWebView();
            if (webView13 != null) {
                webView13.setVerticalScrollBarEnabled(false);
            }
            settings.setAllowContentAccess(true);
            TaoMaiUCWebView webView14 = getWebView();
            if (webView14 != null) {
                webView14.setDownloadListener(new DownloadListener() { // from class: tb.tr
                    @Override // com.uc.webview.export.DownloadListener
                    public final void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                        DMH5Fragment.m39webViewSetting$lambda1(DMH5Fragment.this, str2, str3, str4, str5, j);
                    }
                });
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(AppConfig.v());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: webViewSetting$lambda-1  reason: not valid java name */
    public static final void m39webViewSetting$lambda1(DMH5Fragment dMH5Fragment, String str, String str2, String str3, String str4, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1164706672")) {
            ipChange.ipc$dispatch("1164706672", new Object[]{dMH5Fragment, str, str2, str3, str4, Long.valueOf(j)});
            return;
        }
        b41.i(dMH5Fragment, "this$0");
        try {
            dMH5Fragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            qw2.b(e);
        }
    }

    public final void checkLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1024970296")) {
            ipChange.ipc$dispatch("1024970296", new Object[]{this});
        } else {
            LoginManager.k().y(this, new Intent(), 10);
        }
    }

    public final boolean checkNetError() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1439204066")) {
            return ((Boolean) ipChange.ipc$dispatch("1439204066", new Object[]{this})).booleanValue();
        }
        if (!xj1.b(getActivity())) {
            onResponseError("网络不可用,请检查您的网络。", "1001");
            z = true;
        } else {
            onResponseSuccess();
        }
        this.neterror = z;
        return z;
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    @NotNull
    public bl2 createWebViewChromeClient() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "927105437") ? (bl2) ipChange.ipc$dispatch("927105437", new Object[]{this}) : new DmWebChromeClient() { // from class: cn.damai.h5container.DMH5Fragment$createWebViewChromeClient$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(DMH5Fragment.this);
            }

            @Override // com.uc.webview.export.WebChromeClient
            public void onProgressChanged(@Nullable WebView webView, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "91551815")) {
                    ipChange2.ipc$dispatch("91551815", new Object[]{this, webView, Integer.valueOf(i)});
                    return;
                }
                super.onProgressChanged(webView, i);
                DMH5Fragment.this.updateProgress(i);
            }
        };
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    @NotNull
    public cl2 createWebViewClient() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1489623672") ? (cl2) ipChange.ipc$dispatch("1489623672", new Object[]{this}) : new DmWebViewClient() { // from class: cn.damai.h5container.DMH5Fragment$createWebViewClient$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(DMH5Fragment.this);
            }

            @Override // cn.damai.h5container.DmWebViewClient, tb.cl2, android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-763941222")) {
                    ipChange2.ipc$dispatch("-763941222", new Object[]{this, webView, str});
                    return;
                }
                super.onPageFinished(webView, str);
                DMH5Fragment.this.handleOnPageFinished(webView, str);
            }

            @Override // cn.damai.h5container.DmWebViewClient, tb.cl2, android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1464101321")) {
                    ipChange2.ipc$dispatch("-1464101321", new Object[]{this, webView, str, bitmap});
                    return;
                }
                super.onPageStarted(webView, str, bitmap);
                DMH5Fragment.this.handleOnPageStarted(webView, str, bitmap);
            }

            @Override // cn.damai.h5container.DmWebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public void onReceivedError(@Nullable WebView webView, int i, @Nullable String str, @Nullable String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1108421227")) {
                    ipChange2.ipc$dispatch("-1108421227", new Object[]{this, webView, Integer.valueOf(i), str, str2});
                    return;
                }
                super.onReceivedError(webView, i, str, str2);
                DMH5Fragment.this.handleOnReceivedError(webView, i, str, str2);
            }

            @Override // cn.damai.h5container.DmWebViewClient, com.uc.webview.export.WebViewClient
            public void onReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-595392887")) {
                    ipChange2.ipc$dispatch("-595392887", new Object[]{this, webView, webResourceRequest, webResourceError});
                    return;
                }
                super.onReceivedError(DMH5Fragment.this.getWebView(), webResourceRequest, webResourceError);
                DMH5Fragment.this.handleOnReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
    }

    @Nullable
    public final ResponseErrorPage getMErrorPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1278396365") ? (ResponseErrorPage) ipChange.ipc$dispatch("-1278396365", new Object[]{this}) : this.mErrorPage;
    }

    @Nullable
    public final ValueCallback<Uri> getMUploadMessage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1457737146") ? (ValueCallback) ipChange.ipc$dispatch("1457737146", new Object[]{this}) : this.mUploadMessage;
    }

    public final boolean getNeterror() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "370335412") ? ((Boolean) ipChange.ipc$dispatch("370335412", new Object[]{this})).booleanValue() : this.neterror;
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180404573")) {
            ipChange.ipc$dispatch("180404573", new Object[]{this, bundle});
        } else {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4607733")) {
            ipChange.ipc$dispatch("-4607733", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i == 10) {
            if (i2 == -1) {
                initView();
            } else if (i2 != 0) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.setResult(-1);
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
        if (-1 == i2) {
            switch (i) {
                case 257:
                    WebViewUtil webViewUtil = this.util;
                    b41.f(intent);
                    webViewUtil.startPhotoCapture(intent.getData(), getActivity());
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
                    b41.f(valueCallback);
                    valueCallback.onReceiveValue(fromFile);
                    this.mUploadMessage = null;
                    return;
                case H5MainActivity.REQUEST_REALNAME /* 260 */:
                    RealNameInfo realNameInfo = (RealNameInfo) z20.h(ShareperfenceConstants.USER_DATA_REALNAMEINFO, RealNameInfo.class);
                    if (realNameInfo != null && realNameInfo.realNameStatus) {
                        TaoMaiUCWebView webView = getWebView();
                        if (webView != null) {
                            webView.loadUrl("javascript:realNameThenticate('1')");
                            return;
                        }
                        return;
                    }
                    TaoMaiUCWebView webView2 = getWebView();
                    if (webView2 != null) {
                        webView2.loadUrl("javascript:realNameThenticate('0')");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        ValueCallback<Uri> valueCallback2 = this.mUploadMessage;
        if (valueCallback2 == null) {
            return;
        }
        b41.f(valueCallback2);
        valueCallback2.onReceiveValue(null);
        this.mUploadMessage = null;
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, com.taomai.android.h5container.provider.IKeyboardHookProvider
    public boolean onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446423047")) {
            return ((Boolean) ipChange.ipc$dispatch("-446423047", new Object[]{this})).booleanValue();
        }
        if (this.backtohome) {
            DMNav.from(getActivity()).toUri(NavUri.b(cs.n));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return true;
        } else if (this.isFromPush && this.backType != 1) {
            DMNav.from(getActivity()).toUri(NavUri.b(cs.n));
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
            return true;
        } else {
            return super.onBackPressed();
        }
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423737750")) {
            ipChange.ipc$dispatch("1423737750", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (!WindVaneSDK.isInitialized()) {
            Log.d("delayInit", "windvane lazy init start");
            String n = AppConfig.n(mu0.a());
            if (!TextUtils.isEmpty(n) && b41.d(n, "cn.damai")) {
                WindvaneAgent.initWindVane(mu0.a());
            }
        }
        initParam();
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257792046")) {
            return (View) ipChange.ipc$dispatch("1257792046", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        initView();
        return onCreateView;
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989899178")) {
            ipChange.ipc$dispatch("-989899178", new Object[]{this});
            return;
        }
        super.onDestroy();
        HavanaProxy.v().Q(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-574677775")) {
            ipChange.ipc$dispatch("-574677775", new Object[]{this});
            return;
        }
        super.onDestroyView();
        ScreenShotDetector.k().x(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        if (r7 == true) goto L30;
     */
    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onHiddenChanged(boolean r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.h5container.DMH5Fragment.$ipChange
            java.lang.String r1 = "209334574"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r6
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2[r4] = r7
            r0.ipc$dispatch(r1, r2)
            return
        L1b:
            super.onHiddenChanged(r7)
            com.taomai.android.h5container.webview.TaoMaiUCWebView r0 = r6.getWebView()
            if (r0 == 0) goto L8b
            com.taomai.android.h5container.webview.TaoMaiUCWebView r0 = r6.getWebView()
            r1 = 0
            if (r0 == 0) goto L30
            java.lang.String r0 = r0.getUrl()
            goto L31
        L30:
            r0 = r1
        L31:
            if (r0 != 0) goto L34
            goto L8b
        L34:
            android.os.Bundle r0 = r6.bundle
            if (r0 == 0) goto L8b
            tb.b41.f(r0)
            java.lang.String r2 = "url"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L8b
            if (r7 != 0) goto L8b
            android.os.Bundle r7 = r6.bundle
            tb.b41.f(r7)
            java.lang.String r7 = r7.getString(r2)
            r6.initParam()
            if (r7 == 0) goto L7c
            com.taomai.android.h5container.webview.TaoMaiUCWebView r0 = r6.getWebView()
            if (r0 == 0) goto L5e
            java.lang.String r0 = r0.getUrl()
            goto L5f
        L5e:
            r0 = r1
        L5f:
            boolean r0 = tb.b41.d(r0, r7)
            if (r0 != 0) goto L7b
            com.taomai.android.h5container.webview.TaoMaiUCWebView r0 = r6.getWebView()
            if (r0 == 0) goto L78
            java.lang.String r0 = r0.getUrl()
            if (r0 == 0) goto L78
            boolean r7 = kotlin.text.C8596g.K(r0, r7, r5, r3, r1)
            if (r7 != r4) goto L78
            goto L79
        L78:
            r4 = 0
        L79:
            if (r4 == 0) goto L7c
        L7b:
            return
        L7c:
            java.lang.String r7 = r6.getUrl()
            if (r7 == 0) goto L8b
            com.taomai.android.h5container.webview.TaoMaiUCWebView r0 = r6.getWebView()
            if (r0 == 0) goto L8b
            r0.loadUrl(r7)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.h5container.DMH5Fragment.onHiddenChanged(boolean):void");
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559406829")) {
            ipChange.ipc$dispatch("1559406829", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2131332535")) {
            ipChange.ipc$dispatch("-2131332535", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523976032")) {
            ipChange.ipc$dispatch("-1523976032", new Object[]{this});
        } else {
            reload();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064993488")) {
            ipChange.ipc$dispatch("-1064993488", new Object[]{this});
        }
    }

    public final void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        TaoMaiUCWebView webView2;
        Intent intent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765559669")) {
            ipChange.ipc$dispatch("-1765559669", new Object[]{this, webView, str});
            return;
        }
        TaoMaiUCWebView webView3 = getWebView();
        String str2 = null;
        WebSettings settings = webView3 != null ? webView3.getSettings() : null;
        if (settings != null) {
            settings.setBlockNetworkImage(false);
        }
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                str2 = intent.getStringExtra("datajson");
            }
            if (!TextUtils.isEmpty(str2) && (webView2 = getWebView()) != null) {
                webView2.loadUrl("javascript:orderCommentData(" + str2 + ')');
            }
        }
        WVStandardEventCenter.postNotificationToJS(getWebView(), "dmAndroidShare", "dmAndroidShare");
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734775706")) {
            ipChange.ipc$dispatch("734775706", new Object[]{this});
        } else {
            super.onPause();
        }
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523149781")) {
            ipChange.ipc$dispatch("1523149781", new Object[]{this});
            return;
        }
        super.onRefresh();
        if (xj1.b(getContext())) {
            onResponseSuccess();
            reload();
        }
    }

    public final void onResponseError(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1405828413")) {
            ipChange.ipc$dispatch("1405828413", new Object[]{this, str, str2});
        }
    }

    public final void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889413682")) {
            ipChange.ipc$dispatch("-1889413682", new Object[]{this});
            return;
        }
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                b41.f(responseErrorPage);
                responseErrorPage.setVisibility(8);
                this.mErrorPage = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentActivity activity = getActivity();
        DMH5Activity dMH5Activity = activity instanceof DMH5Activity ? (DMH5Activity) activity : null;
        if (dMH5Activity != null) {
            dMH5Activity.hideShareMenu();
        }
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343970387")) {
            ipChange.ipc$dispatch("-1343970387", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().y(true);
        DMBridge.resume(getActivity());
        ScreenShotDetector.k().x(this.screenShotExtraListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777880494")) {
            ipChange.ipc$dispatch("777880494", new Object[]{this});
        } else {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-377752328")) {
            ipChange.ipc$dispatch("-377752328", new Object[]{this});
        } else {
            super.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075645615")) {
            ipChange.ipc$dispatch("1075645615", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
    }

    public final void setBundle(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608543129")) {
            ipChange.ipc$dispatch("-1608543129", new Object[]{this, bundle});
        } else {
            this.bundle = bundle;
        }
    }

    public final void setMErrorPage(@Nullable ResponseErrorPage responseErrorPage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073326253")) {
            ipChange.ipc$dispatch("-2073326253", new Object[]{this, responseErrorPage});
        } else {
            this.mErrorPage = responseErrorPage;
        }
    }

    public final void setMUploadMessage(@Nullable ValueCallback<Uri> valueCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892322724")) {
            ipChange.ipc$dispatch("-892322724", new Object[]{this, valueCallback});
        } else {
            this.mUploadMessage = valueCallback;
        }
    }

    public final void setNeterror(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493705936")) {
            ipChange.ipc$dispatch("-493705936", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.neterror = z;
        }
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253611367")) {
            ipChange.ipc$dispatch("1253611367", new Object[]{this, Boolean.valueOf(z)});
        } else {
            super.setUserVisibleHint(z);
        }
    }
}
