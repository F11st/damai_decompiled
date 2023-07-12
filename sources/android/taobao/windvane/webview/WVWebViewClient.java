package android.taobao.windvane.webview;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jspatch.WVJsPatch;
import android.taobao.windvane.monitor.WVErrorMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.urlintercept.WVURLInterceptService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVWebViewClient extends WebViewClient {
    private static final String TAG = "WVWebViewClient";
    boolean isError;
    protected Context mContext;
    private String currentUrl = null;
    private long mPageFinshTime = 0;
    public WebViewClient extraWebViewClient = null;

    public WVWebViewClient(Context context) {
        this.mContext = context;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, final String str) {
        TaoLog.i(TAG, "onPageFinished : " + str);
        this.mPageFinshTime = System.currentTimeMillis();
        if (!this.isError && webView.getVisibility() == 4) {
            this.isError = false;
            webView.setVisibility(0);
        }
        super.onPageFinished(webView, str);
        if (webView instanceof WVWebView) {
            ((WVWebView) webView).setCurrentUrl(str, "onPageFinished");
        }
        if (webView instanceof IWVWebView) {
            IWVWebView iWVWebView = (IWVWebView) webView;
            WVEventService.getInstance().onEvent(1002, iWVWebView, str, new Object[0]);
            WVJsPatch.getInstance().execute(iWVWebView, str);
        }
        final WVWebView wVWebView = (WVWebView) webView;
        if (TaoLog.getLogStatus()) {
            TaoLog.v(TAG, "Page finish: " + str);
        }
        wVWebView.onMessage(401, null);
        wVWebView.fireEvent("WindVaneReady", String.format("{'version':'%s'}", GlobalConfig.VERSION));
        wVWebView.evaluateJavascript("(function(p){if(!p||!p.timing)return;var t=p.timing,s=t.navigationStart,sc=t.secureConnectionStart,dc=t.domComplete,lee=t.loadEventEnd;return JSON.stringify({dns:t.domainLookupEnd-t.domainLookupStart,c:t.connectEnd-t.connectStart,scs:sc>0?sc-s:0,req:t.requestStart-s,rps:t.responseStart-s,rpe:t.responseEnd-s,dl:t.domLoading-s,dcl:t.domContentLoadedEventEnd-s,dc:dc>0?dc-s:0,lee:lee>0?lee-s:0})})(window.performance)", new ValueCallback<String>() { // from class: android.taobao.windvane.webview.WVWebViewClient.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str2) {
                if (WVMonitorService.getPerformanceMonitor() != null) {
                    WVMonitorService.getPerformanceMonitor().didPagePerformanceInfo(str, str2);
                    WVMonitorService.getPerformanceMonitor().didPageFinishLoadAtTime(str, WVWebViewClient.this.mPageFinshTime);
                }
            }
        });
        wVWebView.evaluateJavascript("javascript:(function(f){if(f.__windvane__.call) return true; else return false})(window)", new ValueCallback<String>() { // from class: android.taobao.windvane.webview.WVWebViewClient.2
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str2) {
                TaoLog.i("WVJsBridge", "has windvane :" + str2);
                if ("false".equals(str2)) {
                    wVWebView.loadUrl("javascript:(function(f){try{if(f.__windvane__.nativeCall&&!f.__windvane__.call){var h=f.__windvane__||(f.__windvane__={});var c=\"wvapi:\"+(Math.floor(Math.random()*(1<<16))),a=0,b={},g=function(j){if(j&&typeof j==\"string\"){try{return JSON.parse(j)}catch(i){return{ret:\"HY_RESULT_PARSE_ERROR\"}}}else{return j||{}}};h.call=function(i,m,l,e,k){if(typeof l!=\"function\"){l=null}if(typeof e!=\"function\"){e=null}var j=c+(a++);b[j]={s:l,f:e,};if(k>0){b[j].t=setTimeout(function(){h.onFailure(j,{ret:\"HY_TIMEOUT\"})},k)}if(!m){m={}}if(typeof m!=\"string\"){m=JSON.stringify(m)}f.__windvane__.nativeCall(i,m,j,location.href)};h.find=function(i,j){var e=b[i]||{};if(e.t){clearTimeout(e.t);delete e.t}if(!j){delete b[i]}return e};h.onSuccess=function(j,e,k){var i=h.find(j,k).s;if(i){i(g(e))}};h.onFailure=function(j,e){var i=h.find(j,false).f;if(i){i(g(e))}}}}catch(d){}})(window);");
                }
            }
        });
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.isError = false;
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(1001, (IWVWebView) webView, str, bitmap);
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.i(TAG, "onPageStarted : " + str);
        }
        this.currentUrl = str;
        ((WVWebView) webView).onMessage(400, null);
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didPageStartLoadAtTime(str, System.currentTimeMillis());
        }
        WVJsBridge.getInstance().tryToRunTailBridges();
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "Receive error, code: " + i + "; desc: " + str + "; url: " + str2);
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(1005, (IWVWebView) webView, str2, Integer.valueOf(i), str, str2).isSuccess) {
            return;
        }
        String url = webView.getUrl();
        if (url == null || url.equals(str2)) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", str + " [" + i + jn1.ARRAY_END_STR);
            hashMap.put("url", str2);
            ((WVWebView) webView).onMessage(402, hashMap);
            this.isError = true;
            webView.setVisibility(4);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVErrorMonitorInterface errorMonitor = WVMonitorService.getErrorMonitor();
            if (url == null) {
                url = str2;
            }
            errorMonitor.didOccurNativeError(url, i, str);
        }
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @SuppressLint({"NewApi"})
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String sslError2 = sslError.toString();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "onReceivedSslError  url: " + sslError.getUrl() + "errorMsg:" + sslError2);
        }
        String url = webView.getUrl();
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(1006, (IWVWebView) webView, url, sslError2);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVMonitorService.getErrorMonitor().didOccurNativeError(url, 1006, sslError2);
        }
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0142  */
    @Override // android.webkit.WebViewClient
    @android.annotation.TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.webview.WVWebViewClient.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, (IWVWebView) webView)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "ACCESS_FORBIDDEN");
                hashMap.put("url", str);
                ((WVWebView) webView).onMessage(402, hashMap);
            } else {
                webView.loadUrl(forbiddenDomainRedirectURL);
            }
            return true;
        }
        IWVWebView iWVWebView = (IWVWebView) webView;
        if (WVURLFilter.doFilter(str, this.mContext, iWVWebView)) {
            TaoLog.e(TAG, "shouldOverrideUrlLoading filter url=" + str);
            return true;
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.v(TAG, "shouldOverrideUrlLoading: " + str);
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(1003, iWVWebView, str, new Object[0]).isSuccess) {
            return true;
        }
        if (!str.startsWith("mailto:") && !str.startsWith("tel:")) {
            try {
                if ((webView instanceof IWVWebView) && WVURLInterceptService.getWVURLIntercepter() != null && WVURLInterceptService.getWVURLIntercepter().isOpenURLIntercept()) {
                    if (WVURLInterceptService.getWVURLIntercepter().isNeedupdateURLRule(false)) {
                        WVURLInterceptService.getWVURLIntercepter().updateURLRule();
                    }
                    if (WVURLInterceptService.getWVURLIntercepter().shouldOverrideUrlLoading(this.mContext, (IWVWebView) webView, str)) {
                        if (TaoLog.getLogStatus()) {
                            TaoLog.v(TAG, "intercept url: " + str);
                        }
                        return true;
                    }
                }
            } catch (Exception e) {
                TaoLog.e(TAG, "shouldOverrideUrlLoading: doFilter error, " + e.getMessage());
            }
            if (WVURLInterceptService.getWVABTestHandler() != null && WVUrlUtil.shouldTryABTest(str)) {
                String aBTestUrl = WVURLInterceptService.getWVABTestHandler().toABTestUrl(str);
                if (!TextUtils.isEmpty(aBTestUrl) && !aBTestUrl.equals(str)) {
                    TaoLog.i(TAG, str + " abTestUrl to : " + aBTestUrl);
                    webView.loadUrl(aBTestUrl);
                    return true;
                }
            }
            if (webView instanceof WVWebView) {
                ((WVWebView) webView).setCurrentUrl(str, "shouldOverrideUrlLoading");
            }
            TaoLog.i(TAG, "shouldOverrideUrlLoading : " + str);
            WebViewClient webViewClient = this.extraWebViewClient;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.mContext.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            TaoLog.e(TAG, "shouldOverrideUrlLoading: ActivityNotFoundException, url=" + str);
        }
        return true;
    }
}
