package cn.damai.h5container;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.nav.C0724a;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alipay.sdk.app.H5PayCallback;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.H5PayResultModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.constants.LoginUrlConstants;
import com.taobao.login4android.scan.QrScanActivity;
import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebHistoryItem;
import com.uc.webview.export.WebResourceError;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import com.youku.android.utils.OPRUtils;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import tb.cl2;
import tb.cs;
import tb.ev0;
import tb.g41;
import tb.l8;
import tb.pc0;
import tb.qm;
import tb.tr2;
import tb.xj1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DmWebViewClient extends cl2 {
    private static transient /* synthetic */ IpChange $ipChange;
    final Pattern ACCEPTED_URI_SCHEMA;
    Activity activity;
    Fragment fragment;
    C0724a unSkipProcessor;

    public DmWebViewClient(Fragment fragment) {
        super(fragment.getActivity());
        this.ACCEPTED_URI_SCHEMA = Pattern.compile("(?i)((?:http|https|file):\\/\\/|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");
        this.fragment = fragment;
        this.activity = fragment.getActivity();
        this.unSkipProcessor = new C0724a();
    }

    private void checkLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782208999")) {
            ipChange.ipc$dispatch("-782208999", new Object[]{this});
            return;
        }
        Fragment fragment = this.fragment;
        if (fragment instanceof WebViewFragment) {
            ((WebViewFragment) fragment).checkLogin();
        } else if (fragment instanceof DMH5Fragment) {
            ((DMH5Fragment) fragment).checkLogin();
        }
    }

    private boolean checkNetError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175882081")) {
            return ((Boolean) ipChange.ipc$dispatch("1175882081", new Object[]{this})).booleanValue();
        }
        Fragment fragment = this.fragment;
        if (fragment instanceof WebViewFragment) {
            return ((WebViewFragment) fragment).checkNetError();
        }
        if (fragment instanceof DMH5Fragment) {
            return ((DMH5Fragment) fragment).checkNetError();
        }
        return false;
    }

    private void finishInterceptIfPageEmpty(WebView webView) {
        WebBackForwardList copyBackForwardList;
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659845806")) {
            ipChange.ipc$dispatch("-1659845806", new Object[]{this, webView});
        } else if (webView == null || (copyBackForwardList = webView.copyBackForwardList()) == null) {
        } else {
            Log.d("damai-webview", "finishInterceptIfPageEmpty: " + copyBackForwardList.getSize());
            if (copyBackForwardList.getSize() == 0 && (activity = this.activity) != null && !activity.isFinishing()) {
                this.activity.finish();
                return;
            }
            WebHistoryItem currentItem = copyBackForwardList.getCurrentItem();
            if (currentItem == null || !qm.Companion.d(currentItem.getUrl()) || this.activity.isFinishing()) {
                return;
            }
            this.activity.finish();
        }
    }

    private boolean isNumeric(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1285045637") ? ((Boolean) ipChange.ipc$dispatch("-1285045637", new Object[]{this, str})).booleanValue() : Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private boolean isSpecializedHandlerAvailable(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "358442451")) {
            return ((Boolean) ipChange.ipc$dispatch("358442451", new Object[]{this, intent})).booleanValue();
        }
        List<ResolveInfo> queryIntentActivities = this.activity.getPackageManager().queryIntentActivities(intent, 64);
        if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && (intentFilter.countDataAuthorities() != 0 || intentFilter.countDataPaths() != 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2090098275") ? (Activity) ipChange.ipc$dispatch("-2090098275", new Object[]{this}) : this.activity;
    }

    @Override // tb.cl2, android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548221258")) {
            ipChange.ipc$dispatch("1548221258", new Object[]{this, webView, str});
            return;
        }
        super.onPageFinished(webView, str);
        Fragment fragment = this.fragment;
        if (fragment != null) {
            if (fragment instanceof WebViewFragment) {
                ((WebViewFragment) fragment).onPageFinished(webView, str);
            } else if (fragment instanceof DMH5Fragment) {
                ((DMH5Fragment) fragment).onPageFinished(webView, str);
            }
        }
    }

    @Override // tb.cl2, android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Fragment fragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555569895")) {
            ipChange.ipc$dispatch("555569895", new Object[]{this, webView, str, bitmap});
            return;
        }
        super.onPageStarted(webView, str, bitmap);
        if (!xj1.b(getActivity()) || (fragment = this.fragment) == null) {
            return;
        }
        if (fragment instanceof WebViewFragment) {
            ((WebViewFragment) fragment).onResponseSuccess();
        } else if (fragment instanceof DMH5Fragment) {
            ((DMH5Fragment) fragment).onResponseSuccess();
        }
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Fragment fragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-863344059")) {
            ipChange.ipc$dispatch("-863344059", new Object[]{this, webView, Integer.valueOf(i), str, str2});
            return;
        }
        super.onReceivedError(webView, i, str, str2);
        if (Build.VERSION.SDK_INT < 23 && (fragment = this.fragment) != null) {
            if (fragment instanceof WebViewFragment) {
                ((WebViewFragment) fragment).onResponseError("网络不可用,请检查您的网络.", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
                ((WebViewFragment) this.fragment).neterror = true;
            } else if (fragment instanceof DMH5Fragment) {
                ((DMH5Fragment) fragment).onResponseError("网络不可用,请检查您的网络.", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
                ((DMH5Fragment) this.fragment).setNeterror(true);
            }
        }
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094993302")) {
            return (WebResourceResponse) ipChange.ipc$dispatch("-1094993302", new Object[]{this, webView, str});
        }
        Log.d("shouldIntercept", "url : ---- " + str);
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // tb.cl2, android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1561395014")) {
            return ((Boolean) ipChange.ipc$dispatch("-1561395014", new Object[]{this, webView, str})).booleanValue();
        }
        Log.d("damai-webview", "H5MainActivity.shouldOverrideUrlLoading(): url=" + str);
        super.shouldOverrideUrlLoading(webView, str);
        if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
            if (str.contains("asyn://needLogIn")) {
                checkLogin();
                return true;
            } else if (str.contains("event://movie")) {
                Intent intent = new Intent();
                intent.putExtra("url", tr2.TPP_H5_URL);
                DMNav.from(this.mContext.get()).withExtras(intent.getExtras()).toUri(NavUri.b(cs.t));
                return true;
            } else if (str.equals("asyn://backToNative")) {
                this.activity.finish();
                return true;
            } else if (!str.startsWith("alipays:") && !str.startsWith("alipay")) {
                if (!str.startsWith(tr2.SCHEME)) {
                    try {
                        Intent parseUri = Intent.parseUri(str, 1);
                        if (!this.ACCEPTED_URI_SCHEMA.matcher(str).matches() || isSpecializedHandlerAvailable(parseUri)) {
                            try {
                                this.activity.startActivityIfNeeded(parseUri, -1);
                                return true;
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                                return true;
                            }
                        }
                        return false;
                    } catch (URISyntaxException e2) {
                        Log.w("Browser", "Bad URI " + str + ": " + e2.getMessage());
                        return false;
                    }
                } else if (str.startsWith("damai://V1/SystemSeting")) {
                    DMNav.from(this.activity).toUri(str);
                    finishInterceptIfPageEmpty(webView);
                    return true;
                } else if (str.startsWith("damai://V1/PushSeting")) {
                    DMNav.from(this.activity).toUri(str);
                    finishInterceptIfPageEmpty(webView);
                    return true;
                } else if (str.startsWith("damai://V1/PrivacySeting")) {
                    DMNav.from(this.activity).toUri(str);
                    finishInterceptIfPageEmpty(webView);
                    return true;
                }
            } else {
                try {
                    this.mContext.get().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception unused) {
                    new DMDialog(this.mContext.get()).q("未检测到支付宝客户端，请安装后重试。").n("立即安装", new DialogInterface.OnClickListener() { // from class: cn.damai.h5container.DmWebViewClient.5
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1089469875")) {
                                ipChange2.ipc$dispatch("1089469875", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                                return;
                            }
                            ((Context) ((WVUCWebViewClient) DmWebViewClient.this).mContext.get()).startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://d.alipay.com")));
                            dialogInterface.dismiss();
                        }
                    }).i("取消", new DialogInterface.OnClickListener() { // from class: cn.damai.h5container.DmWebViewClient.4
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "119888852")) {
                                ipChange2.ipc$dispatch("119888852", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                            } else {
                                dialogInterface.dismiss();
                            }
                        }
                    }).t(3).o(true).show();
                }
                return true;
            }
        } else if (checkNetError()) {
            return true;
        } else {
            if (LoginUrlConstants.isCommonScanUrl(str)) {
                Intent intent2 = new Intent(getActivity(), QrScanActivity.class);
                intent2.putExtra(LoginConstant.SCAN_KEY, str);
                this.activity.startActivity(intent2);
                this.activity.finish();
                return true;
            }
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("intercept");
            if (!TextUtils.isEmpty(queryParameter) && "no".equals(queryParameter)) {
                return false;
            }
            String queryParameter2 = parse.getQueryParameter("utm");
            if (!TextUtils.isEmpty(queryParameter2)) {
                C0529c.e().H("utm", queryParameter2);
            }
            if (HavanaProxy.v().B(str)) {
                if (!LoginManager.k().q()) {
                    new DMThemeDialog(this.activity).r(DMThemeDialog.DMDialogTheme.THEME_TAOBAO_LOGIN).o("淘宝授权 登录大麦账号").f(false).i("手机淘宝登录", new DialogInterface.OnClickListener() { // from class: cn.damai.h5container.DmWebViewClient.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1506113079")) {
                                ipChange2.ipc$dispatch("1506113079", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                            } else {
                                HavanaProxy.v().p(DmWebViewClient.this.activity);
                            }
                        }
                    }).g(true, null).show();
                } else {
                    HavanaProxy.v().P(this.activity, new HavanaProxy.UccTrustLoginListener() { // from class: cn.damai.h5container.DmWebViewClient.2
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.login.havana.HavanaProxy.UccTrustLoginListener
                        public void onFail() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-39013877")) {
                                ipChange2.ipc$dispatch("-39013877", new Object[]{this});
                            }
                        }

                        @Override // cn.damai.login.havana.HavanaProxy.UccTrustLoginListener
                        public void onSuccess() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-2119202402")) {
                                ipChange2.ipc$dispatch("-2119202402", new Object[]{this});
                                return;
                            }
                            Fragment fragment = DmWebViewClient.this.fragment;
                            if (fragment != null) {
                                if (fragment instanceof WebViewFragment) {
                                    if (((WebViewFragment) fragment).mWebView != null) {
                                        ((WebViewFragment) fragment).mWebView.reload();
                                    }
                                } else if (fragment instanceof DMH5Fragment) {
                                    ((DMH5Fragment) fragment).reload();
                                }
                            }
                        }
                    });
                }
                return true;
            } else if (str.contains("m.damai.cn/ticket")) {
                if (toDetailPage(str.substring(str.lastIndexOf("/") + 1, str.indexOf(".htm")), str, webView)) {
                    return true;
                }
            } else if (!str.contains("piao.damai.cn/") && !str.contains("m.damai.cn/ticket")) {
                if (str.contains("m.damai.cn/proj.aspx?id")) {
                    HashMap<String, String> pamMap = WebViewUtil.getPamMap(str);
                    if (pamMap != null && toDetailPage(pamMap.get("id"), str, webView)) {
                        return true;
                    }
                } else if (!str.contains("h5.m.taobao.com/damai/perform/item.html?projectId") && !str.contains("m.damai.cn/damai/perform/item.html?projectId")) {
                    if (!str.contains("m.damai.cn/weixinshare.aspx") && !str.contains("m.damai.cn/weixinfshare.aspx")) {
                        if (str.contains("m.damai.cn/children.html")) {
                            getActivity().setResult(101);
                            this.activity.finish();
                        } else if (str.contains("mapi.damai.cn/Page/ScanCodeLogin/Success.aspx")) {
                            getActivity().setResult(101);
                            this.activity.finish();
                        } else if (str.contains("mapi.damai.cn/Page/ScanCodeLogin/error.aspx?error=")) {
                            checkLogin();
                            this.activity.finish();
                            return true;
                        } else if (str.contains("msecurity.damai.cn/securityCenter-front-wap/successbind")) {
                            z20.b0(true);
                            z20.b0(true);
                        } else if (str.contains("http://m.damai.cn/proj.aspx?id")) {
                            HashMap<String, String> pamMap2 = WebViewUtil.getPamMap(str);
                            if (pamMap2 == null) {
                                return false;
                            }
                            long parseLong = Long.parseLong(pamMap2.get("id"));
                            if (this.mContext.get() != null) {
                                Intent intent3 = new Intent();
                                intent3.putExtra(IssueConstants.ProjectID, parseLong);
                                DMNav.from(this.activity).withExtras(intent3.getExtras()).toUri(cs.a());
                            }
                            finishInterceptIfPageEmpty(webView);
                            return true;
                        } else if (str.startsWith("https://m.damai.cn/damai/activity/detaillist/index.html")) {
                            String queryParameter3 = Uri.parse(str).getQueryParameter("id");
                            if (isNumeric(queryParameter3)) {
                                Bundle bundle = new Bundle();
                                bundle.putString("id", queryParameter3);
                                DMNav.from(this.activity).withExtras(bundle).toUri(NavUri.b("detailed_list"));
                                finishInterceptIfPageEmpty(webView);
                                return true;
                            }
                        } else if (str.startsWith("https://m.damai.cn/app/dmfe/dramas/pages/ip/index.html")) {
                            String queryParameter4 = Uri.parse(str).getQueryParameter(g41.ISSUE_PARAM_IPID);
                            if (isNumeric(queryParameter4)) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("id", queryParameter4);
                                DMNav.from(this.activity).withExtras(bundle2).toUri(NavUri.b("ipdrama"));
                                finishInterceptIfPageEmpty(webView);
                                return true;
                            }
                        } else if (!str.startsWith("https://m.damai.cn/app/dmfe/show/pages/starHome/index.html") && !str.startsWith("https://market.wapa.damai.cn/shows/artist.html") && !str.startsWith("https://m.damai.cn/shows/artist.html")) {
                            if (str.startsWith("https://m.damai.cn/app/dmfe/show/pages/brand/index.html")) {
                                String queryParameter5 = Uri.parse(str).getQueryParameter("brandId");
                                if (isNumeric(queryParameter5)) {
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString("userId", queryParameter5);
                                    bundle3.putString(RepertoireDetailFragment.USERTYPE, "4");
                                    DMNav.from(this.activity).withExtras(bundle3).toUri(NavUri.b(cs.Y));
                                    this.activity.finish();
                                    return true;
                                }
                            } else {
                                int shouldIntercept = NativePageInterceptor.shouldIntercept(str);
                                if (shouldIntercept != 0) {
                                    NativePageInterceptor.interceptToNativePage(this.activity, shouldIntercept, str);
                                    finishInterceptIfPageEmpty(webView);
                                    return true;
                                } else if (ev0.e(str, ev0.d()) && !str.contains(pc0.j)) {
                                    Log.d("damai-webview", "H5UrlConstant.interceptUrl: url=" + str);
                                    DMNav.from(this.activity).toUri(str);
                                    return true;
                                } else if (this.unSkipProcessor.e(str, this.activity, null)) {
                                    finishInterceptIfPageEmpty(webView);
                                    return true;
                                } else if (new PayTask(getActivity()).payInterceptorWithUrl(str, true, new H5PayCallback() { // from class: cn.damai.h5container.DmWebViewClient.3
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    @Override // com.alipay.sdk.app.H5PayCallback
                                    public void onPayResult(H5PayResultModel h5PayResultModel) {
                                        IpChange ipChange2 = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange2, "-1897277608")) {
                                            ipChange2.ipc$dispatch("-1897277608", new Object[]{this, h5PayResultModel});
                                            return;
                                        }
                                        Log.d("damai-webview", "PayTask.onPayResult: result=" + h5PayResultModel.getReturnUrl() + ", :" + h5PayResultModel.getResultCode());
                                        final String returnUrl = h5PayResultModel.getReturnUrl();
                                        if (TextUtils.isEmpty(returnUrl)) {
                                            return;
                                        }
                                        DmWebViewClient.this.getActivity().runOnUiThread(new Runnable() { // from class: cn.damai.h5container.DmWebViewClient.3.1
                                            private static transient /* synthetic */ IpChange $ipChange;

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IpChange ipChange3 = $ipChange;
                                                if (AndroidInstantRuntime.support(ipChange3, "-801014839")) {
                                                    ipChange3.ipc$dispatch("-801014839", new Object[]{this});
                                                    return;
                                                }
                                                Activity activity = DmWebViewClient.this.activity;
                                                if (activity != null) {
                                                    DMNav.from(activity).toUri(returnUrl);
                                                    DmWebViewClient.this.activity.finish();
                                                }
                                            }
                                        });
                                    }
                                })) {
                                    Log.d("damai-webview", "PayTask.payInterceptorWithUrl: url=" + str);
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        } else {
                            String queryParameter6 = Uri.parse(str).getQueryParameter(l8.KEY_ARTIST_ID);
                            if (isNumeric(queryParameter6)) {
                                Bundle bundle4 = new Bundle();
                                bundle4.putString("userId", queryParameter6);
                                bundle4.putString(RepertoireDetailFragment.USERTYPE, "2");
                                DMNav.from(this.activity).withExtras(bundle4).toUri(NavUri.b(cs.Y));
                                this.activity.finish();
                                return true;
                            }
                        }
                    } else {
                        WebViewUtil.share(str, getActivity());
                        return true;
                    }
                } else {
                    HashMap<String, String> pamMap3 = WebViewUtil.getPamMap(str);
                    if (pamMap3 != null && toDetailPage(pamMap3.get("projectId"), str, webView)) {
                        return true;
                    }
                }
            } else {
                int lastIndexOf = str.lastIndexOf("/");
                int indexOf = str.indexOf(".htm");
                int i = lastIndexOf + 1;
                if (i <= indexOf && i >= 0 && indexOf >= 0) {
                    try {
                        toDetailPage(str.substring(i, indexOf), str, webView);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean toDetailPage(String str, String str2, WebView webView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "982425899")) {
            return ((Boolean) ipChange.ipc$dispatch("982425899", new Object[]{this, str, str2, webView})).booleanValue();
        }
        try {
            if (str2.contains(pc0.j)) {
                return false;
            }
            long parseLong = Long.parseLong(str);
            Bundle bundle = new Bundle();
            bundle.putLong(IssueConstants.ProjectID, parseLong);
            DMNav.from(getActivity()).withExtras(bundle).toUri(cs.a());
            finishInterceptIfPageEmpty(webView);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Fragment fragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304525351")) {
            ipChange.ipc$dispatch("-304525351", new Object[]{this, webView, webResourceRequest, webResourceError});
            return;
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (!webResourceRequest.isForMainFrame() || (fragment = this.fragment) == null) {
            return;
        }
        if (fragment instanceof WebViewFragment) {
            ((WebViewFragment) fragment).onResponseError("网络不可用,请检查您的网络.", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
            ((WebViewFragment) this.fragment).neterror = true;
        } else if (fragment instanceof DMH5Fragment) {
            ((DMH5Fragment) fragment).onResponseError("网络不可用,请检查您的网络.", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
            ((DMH5Fragment) this.fragment).setNeterror(true);
        }
    }
}
