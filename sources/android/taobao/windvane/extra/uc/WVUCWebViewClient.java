package android.taobao.windvane.extra.uc;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVUCPrecacheManager;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jspatch.WVJsPatch;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.WVErrorMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.urlintercept.WVURLInterceptService;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVURLFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.monitor.procedure.ViewToken;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.weaver.prefetch.WMLPrefetch;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.extension.RenderProcessGoneDetail;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCExtension;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUCWebViewClient extends WebViewClient {
    private static final String SANDBOX_TAG = "WVUCWebViewClient.sandbox";
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_SMS = "sms:";
    public static final String SCHEME_TEL = "tel:";
    private static final String TAG = "WVUCWebViewClient";
    boolean isError;
    protected WeakReference<Context> mContext;
    private Handler mRenderProcessHandler;
    public int crashCount = 0;
    private boolean useOldBridge = false;
    private Runnable mCrashCountReseter = new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebViewClient.5
        @Override // java.lang.Runnable
        public void run() {
            TaoLog.e(WVUCWebViewClient.SANDBOX_TAG, "crash count reset - " + WVUCWebViewClient.this.crashCount);
            WVUCWebViewClient.this.crashCount = 0;
        }
    };

    public WVUCWebViewClient(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public static String getMetaDataScript() {
        String[] strArr = {"WV.Meta.Performance.JSFSP"};
        String str = "(function(){var d=document,r={}";
        String str2 = "";
        for (int i = 0; i < 1; i++) {
            str = str + String.format(",n%d='%s',e%d=d.getElementById(n%d)", Integer.valueOf(i), strArr[i], Integer.valueOf(i), Integer.valueOf(i));
            str2 = str2 + String.format("if(e%d){r[n%d]=e%d.getAttribute('value')}", Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i));
        }
        return str + String.format(";%sreturn JSON.stringify(r);})()", str2);
    }

    private void getMetaInfo(final WVUCWebView wVUCWebView) {
        String metaDataScript = getMetaDataScript();
        if (metaDataScript == null || wVUCWebView == null) {
            return;
        }
        wVUCWebView.evaluateJavascript(metaDataScript, new ValueCallback<String>() { // from class: android.taobao.windvane.extra.uc.WVUCWebViewClient.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                try {
                    JSONObject metaObject = WVUCWebViewClient.this.getMetaObject(str);
                    if (metaObject != null && wVUCWebView != null) {
                        if (metaObject.has("WV.Meta.Performance.JSFSP")) {
                            if (!TextUtils.isEmpty(metaObject.optString("WV.Meta.Performance.JSFSP"))) {
                                if (!wVUCWebView.isReportedFSP()) {
                                    wVUCWebView.setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_INVALID);
                                }
                            } else {
                                wVUCWebView.setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_VALID);
                                TaoLog.d(WVUCWebViewClient.TAG, "no version setTag " + SystemClock.uptimeMillis());
                            }
                        } else {
                            wVUCWebView.setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_VALID);
                            TaoLog.d(WVUCWebViewClient.TAG, "no JSFSP setTag " + SystemClock.uptimeMillis());
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.uc.webview.export.WebResourceResponse shouldInterceptRequestInternal(com.uc.webview.export.WebView r11, java.lang.String r12, android.taobao.windvane.service.WVEventResult r13) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.uc.WVUCWebViewClient.shouldInterceptRequestInternal(com.uc.webview.export.WebView, java.lang.String, android.taobao.windvane.service.WVEventResult):com.uc.webview.export.WebResourceResponse");
    }

    private void tryPreCacheResources(WebView webView) {
        if (WVUCPrecacheManager.canClearPrecache()) {
            WVUCPrecacheManager.resetClearConfig();
            UCCore.clearPrecacheResources(null);
            WVUCPrecacheManager.setHasPrecache(false);
        }
        if (WVUCPrecacheManager.canPrecache()) {
            WVUCPrecacheManager.resetClearConfig();
            WVUCPrecacheManager.resetPrecacheConfig();
            HashSet<String> preMemCacheUrlSet = WVUCPrecacheManager.preMemCacheUrlSet();
            if (preMemCacheUrlSet != null) {
                HashMap hashMap = new HashMap();
                Iterator<String> it = preMemCacheUrlSet.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    WebResourceResponse shouldInterceptRequest = shouldInterceptRequest(webView, new WebResourceRequest(next, new HashMap()));
                    if (shouldInterceptRequest != null) {
                        hashMap.put(next, shouldInterceptRequest);
                    }
                }
                if (hashMap.size() > 0) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("maxAge", "3600");
                    hashMap2.put("ignoreQuery", "1");
                    UCCore.precacheResources(hashMap, hashMap2);
                    WVUCPrecacheManager.setHasPrecache(true);
                }
            }
        }
    }

    public JSONObject getMetaObject(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("\"") && str.endsWith("\"")) {
                str = str.substring(1, str.length() - 1);
            }
            return new JSONObject(str.replace("\\", ""));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public void onPageFinished(final WebView webView, final String str) {
        String str2;
        TaoLog.e(TAG, "onPageFinished : " + str);
        if (webView instanceof IFullTrace) {
            IFullTrace iFullTrace = (IFullTrace) webView;
            FullTraceUtils.addStage(iFullTrace.getSpanWrapper(), "onPageFinished");
            FullTraceUtils.addProperty(iFullTrace.getSpanWrapper(), "H5_URL", str);
        }
        try {
            if (webView instanceof WVUCWebView) {
                getMetaInfo((WVUCWebView) webView);
            } else {
                TaoLog.e(TAG, "view is " + webView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidFinishLoad(str, webView);
        final long currentTimeMillis = System.currentTimeMillis();
        if (!this.isError && webView.getVisibility() == 4) {
            this.isError = false;
            webView.setVisibility(0);
        }
        super.onPageFinished(webView, str);
        UCExtension uCExtension = null;
        if (webView instanceof WVUCWebView) {
            wVUCWebView.setCurrentUrl(str, "onPageFinished");
            wVUCWebView.onMessage(401, null);
        }
        if (webView instanceof IWVWebView) {
            IWVWebView iWVWebView = (IWVWebView) webView;
            WVEventService.getInstance().onEvent(1002, iWVWebView, str, new Object[0]);
            WVJsPatch.getInstance().execute(iWVWebView, str);
            iWVWebView.fireEvent("WindVaneReady", String.format("{'version':'%s'}", GlobalConfig.VERSION));
        }
        if (WVMonitorService.getPerformanceMonitor() != null) {
            UCExtension uCExtension2 = webView.getUCExtension();
            boolean isLoadFromCachedPage = uCExtension2 != null ? uCExtension2.isLoadFromCachedPage() : false;
            str2 = null;
            WVMonitorService.getPerformanceMonitor().didGetPageStatusCode(str, -1, isLoadFromCachedPage ? 72 : WVUCWebView.getFromType(), null, null, null, null, null);
            uCExtension = uCExtension2;
        } else {
            str2 = null;
        }
        webView.evaluateJavascript("(function(p){if(!p||!p.timing)return;var t=p.timing,s=t.navigationStart,sc=t.secureConnectionStart,dc=t.domComplete,les=t.loadEventStart,lee=t.loadEventEnd;return JSON.stringify({dns:t.domainLookupEnd-t.domainLookupStart,c:t.connectEnd-t.connectStart,scs:sc>0?sc-s:0,req:t.requestStart-s,rps:t.responseStart-s,rpe:t.responseEnd-s,dl:t.domLoading-s,dcl:t.domContentLoadedEventEnd-s,dc:dc>0?dc-s:0,les:les>0?les-s:0,lee:lee>0?lee-s:0})})(window.performance)", new ValueCallback<String>() { // from class: android.taobao.windvane.extra.uc.WVUCWebViewClient.2
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str3) {
                if (WVMonitorService.getPerformanceMonitor() != null) {
                    WVMonitorService.getPerformanceMonitor().didPagePerformanceInfo(str, str3);
                    WVMonitorService.getPerformanceMonitor().didPageFinishLoadAtTime(str, currentTimeMillis);
                }
            }
        });
        TaoLog.i(TAG, str + " LayerType : " + webView.getLayerType());
        if (webView.getCurrentViewCoreType() == 2) {
            webView.evaluateJavascript("javascript:(function(f){if(f.__windvane__.call) return true; else return false})(window)", new ValueCallback<String>() { // from class: android.taobao.windvane.extra.uc.WVUCWebViewClient.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str3) {
                    TaoLog.i("WVJsBridge", "has windvane :" + str3);
                    if ("false".equals(str3)) {
                        webView.loadUrl("javascript:(function(f){try{if(f.__windvane__.nativeCall&&!f.__windvane__.call){var h=f.__windvane__||(f.__windvane__={});var c=\"wvapi:\"+(Math.floor(Math.random()*(1<<16))),a=0,b={},g=function(j){if(j&&typeof j==\"string\"){try{return JSON.parse(j)}catch(i){return{ret:\"HY_RESULT_PARSE_ERROR\"}}}else{return j||{}}};h.call=function(i,m,l,e,k){if(typeof l!=\"function\"){l=null}if(typeof e!=\"function\"){e=null}var j=c+(a++);b[j]={s:l,f:e,};if(k>0){b[j].t=setTimeout(function(){h.onFailure(j,{ret:\"HY_TIMEOUT\"})},k)}if(!m){m={}}if(typeof m!=\"string\"){m=JSON.stringify(m)}f.__windvane__.nativeCall(i,m,j,location.href)};h.find=function(i,j){var e=b[i]||{};if(e.t){clearTimeout(e.t);delete e.t}if(!j){delete b[i]}return e};h.onSuccess=function(j,e,k){var i=h.find(j,k).s;if(i){i(g(e))}};h.onFailure=function(j,e){var i=h.find(j,false).f;if(i){i(g(e))}}}}catch(d){}})(window);");
                    }
                }
            });
        }
        if (WebView.getCoreType() != 1 && WebView.getCoreType() != 3) {
            AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_WEB_CORE_TYPE_BY_PV, WebView.getCoreType(), "", "");
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitCoreTypeByPV(String.valueOf(WVCommonConfig.commonConfig.initUCCorePolicy), "Android");
            }
        } else {
            TaoLog.d(TAG, "onPageFinished.  core type = " + WebView.getCoreType());
            AppMonitorUtil.commitSuccess(AppMonitorUtil.MONITOR_POINT_WEB_CORE_TYPE_BY_PV, str2);
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitCoreTypeByPV(String.valueOf(WVCommonConfig.commonConfig.initUCCorePolicy), "U4");
            }
            if (uCExtension != null && !((WVUCWebView) webView).isStaticWebView()) {
                if (!CommonUtils.isMainProcess(webView.getContext())) {
                    if (WVMonitorService.getWvMonitorInterface() != null) {
                        WVMonitorService.getWvMonitorInterface().commitWebMultiTypeByPV("0", "0", "-1", "0", "0", "-1");
                    }
                } else {
                    uCExtension.getCoreStatus(2, new ValueCallback<Object>() { // from class: android.taobao.windvane.extra.uc.WVUCWebViewClient.4
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(Object obj) {
                            if (obj instanceof Map) {
                                Map map = (Map) obj;
                                if (WVMonitorService.getWvMonitorInterface() != null) {
                                    String str3 = (String) map.get("rt");
                                    String str4 = (String) map.get("rtWhy");
                                    String str5 = (String) map.get("gt");
                                    String str6 = (String) map.get("gtWhy");
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, "onPageFinish");
                                    hashMap.put("requireRenderType", Integer.valueOf(WVCore.getInstance().getUsedWebMulti()));
                                    hashMap.put("realRenderType", str3);
                                    hashMap.put("renderTypeReason", str4);
                                    hashMap.put("requireGpuType", Integer.valueOf(WVCore.getInstance().getUsedGpuMulti()));
                                    hashMap.put("realGpuType", str5);
                                    hashMap.put("gpuTypeReason", str6);
                                    WVMonitorService.getWvMonitorInterface().commitWebMultiTypeByPV(String.valueOf(WVCore.getInstance().getUsedWebMulti()), str3, str4, String.valueOf(WVCore.getInstance().getUsedGpuMulti()), str5, str6);
                                }
                            }
                        }
                    });
                }
            }
        }
        if (WebView.getCoreType() == 3) {
            if (webView.getContext() != null) {
                WVUCWebView.createStaticWebViewIfNeeded(webView.getContext());
            }
            tryPreCacheResources(webView);
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (webView instanceof IFullTrace) {
            FullTraceUtils.addStage(((IFullTrace) webView).getFalcoSpan(), "onPageStarted");
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidStartLoad();
        this.isError = false;
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didPageStartLoadAtTime(str, System.currentTimeMillis());
        }
        if (webView instanceof WVUCWebView) {
            WVEventService.getInstance().onEvent(1001, (IWVWebView) webView, str, bitmap);
            wVUCWebView.onMessage(400, null);
            wVUCWebView.mPageStart = System.currentTimeMillis();
        }
        WVJsBridge.getInstance().tryToRunTailBridges();
        TaoLog.e(TAG, "onPageStarted : " + str);
    }

    @Override // com.uc.webview.export.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        FalcoSpan falcoSpan;
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "Receive error, code: " + i + "; desc: " + str + "; url: " + str2);
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(1005, (IWVWebView) webView, str2, Integer.valueOf(i), str, str2).isSuccess) {
            return;
        }
        String url = webView.getUrl();
        if ((webView instanceof IFullTrace) && (falcoSpan = ((IFullTrace) webView).getFalcoSpan()) != null) {
            FullTraceUtils.addStage(falcoSpan, "onReceivedError");
            falcoSpan.setTag("errorCode", Integer.valueOf(i));
            falcoSpan.setTag(SocialConstants.PARAM_COMMENT, str);
            falcoSpan.setTag("failingUrl", str2);
            falcoSpan.finish("onReceivedError");
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidFailLoadWithError(String.valueOf(i), str);
        if (((i > -16 && i < 0) || i == -80 || i == -50) && (webView instanceof WVUCWebView) && (url == null || url.equals(str2))) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", str + " [" + i + jn1.ARRAY_END_STR);
            hashMap.put("url", str2);
            this.isError = true;
            webView.setVisibility(4);
            wVUCWebView.onMessage(402, hashMap);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVErrorMonitorInterface errorMonitor = WVMonitorService.getErrorMonitor();
            if (url != null) {
                str2 = url;
            }
            errorMonitor.didOccurNativeError(str2, i, str);
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    @SuppressLint({"NewApi"})
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String sslError2 = sslError.toString();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "onReceivedSslError  url: " + sslError.getUrl() + "errorMsg:" + sslError2);
        }
        String url = webView.getUrl();
        if (webView instanceof WVUCWebView) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", "SSL_ERROR");
            hashMap.put("url", url);
            ((WVUCWebView) webView).onMessage(402, hashMap);
        }
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(1006, (IWVWebView) webView, url, sslError2);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVMonitorService.getErrorMonitor().didOccurNativeError(url, 1006, sslError2);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.uc.webview.export.WebViewClient
    public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        TaoLog.e(SANDBOX_TAG, "onRenderProcessGone webview:" + webView + ", crash:" + renderProcessGoneDetail.didCrash() + ", priority:" + renderProcessGoneDetail.rendererPriorityAtExit());
        int i = this.crashCount;
        if (i >= 5) {
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitRenderType(webView.getUrl(), "R_Fail", WVCommonConfig.commonConfig.webMultiPolicy);
            }
            this.crashCount = 0;
            Log.e(SANDBOX_TAG, "onRenderProcessGone webview:" + webView.getClass().getSimpleName() + ", crash:" + renderProcessGoneDetail.didCrash(), new Throwable());
            return false;
        } else if (webView != null) {
            this.crashCount = i + 1;
            if (this.mRenderProcessHandler == null) {
                this.mRenderProcessHandler = new Handler(Looper.getMainLooper());
            }
            this.mRenderProcessHandler.postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebViewClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (webView.isDestroied()) {
                        return;
                    }
                    webView.reload();
                }
            }, 200L);
            this.mRenderProcessHandler.removeCallbacks(this.mCrashCountReseter);
            this.mRenderProcessHandler.postDelayed(this.mCrashCountReseter, 20000L);
            return true;
        } else {
            TaoLog.e(SANDBOX_TAG, "onRenderProcessGone - WebView is null");
            return false;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        int i = 3;
        if (WebView.getCoreType() != 3) {
            TaoLog.e(TAG, "Only U4 WebView will use shouldInterceptRequest(API Level 21), return null.");
            return null;
        } else if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
            String uri = webResourceRequest.getUrl().toString();
            if (WVUCPrecacheManager.getInstance().hasPrecacheDoc(uri)) {
                WVUCPrecacheManager.getInstance().clearPrecacheDoc(uri);
                return null;
            } else if (webView instanceof IWVWebView) {
                return shouldInterceptRequestInternal(webView, uri, WVEventService.getInstance().onEvent(1008, (IWVWebView) webView, uri, webResourceRequest.getRequestHeaders(), Integer.valueOf((!(webView instanceof WVUCWebView) || ((WVUCWebView) webView).getUCExtension() == null) ? 2 : 2)));
            } else {
                return null;
            }
        } else {
            TaoLog.e(TAG, "shouldInterceptRequest, invalid request.");
            return null;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (webView instanceof IFullTrace) {
                FullTraceUtils.addCustomStageAndFinish(((IFullTrace) webView).getFalcoSpan(), null);
                ((IFullTrace) webView).setFalcoSpan(FullTraceUtils.makeSpanChildOf("windvaneSubPage", "H5SubPage", ((IFullTrace) webView).getOpenTracingContext()));
            }
        } catch (Throwable th) {
            TaoLog.e(TAG, "getSpan failed " + CommonUtils.getStackTrace(th));
        }
        if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, (IWVWebView) webView)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "ACCESS_FORBIDDEN");
                hashMap.put("url", str);
                ((WVUCWebView) webView).onMessage(402, hashMap);
            } else {
                webView.loadUrl(forbiddenDomainRedirectURL);
            }
            return true;
        }
        IWVWebView iWVWebView = (IWVWebView) webView;
        if (WVURLFilter.doFilter(str, this.mContext.get(), iWVWebView)) {
            TaoLog.e(TAG, "shouldOverrideUrlLoading filter url=" + str);
            AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_URL_CONFIG_FILTER_TYPE, 3, "WVUCWebView.shouldOverrideUrlLoading", str);
            return true;
        } else if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(1003, iWVWebView, str, new Object[0]).isSuccess) {
            return true;
        } else {
            Context context = webView.getContext();
            if (!str.startsWith("mailto:") && !str.startsWith("tel:") && !str.startsWith(SCHEME_SMS)) {
                WVUCWebView wVUCWebView = (WVUCWebView) webView;
                wVUCWebView.wvh5PPManager.receiveHtmlUrl(str);
                try {
                    if ((webView instanceof IWVWebView) && WVURLInterceptService.getWVURLIntercepter() != null && WVURLInterceptService.getWVURLIntercepter().isOpenURLIntercept()) {
                        if (WVURLInterceptService.getWVURLIntercepter().isNeedupdateURLRule(false)) {
                            WVURLInterceptService.getWVURLIntercepter().updateURLRule();
                        }
                        if (WVURLInterceptService.getWVURLIntercepter().shouldOverrideUrlLoading(context, (IWVWebView) webView, str)) {
                            TaoLog.i(TAG, "intercept url : " + str);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    TaoLog.e(TAG, "shouldOverrideUrlLoading: doFilter error, " + e.getMessage());
                }
                if (webView instanceof WVUCWebView) {
                    UCNetworkDelegate.getInstance().onUrlChange(wVUCWebView, str);
                    wVUCWebView.setCachedUrl(str);
                }
                TaoLog.i(TAG, "shouldOverrideUrlLoading : " + str);
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("userAgent", webView.getSettings().getUserAgentString());
                    WMLPrefetch.getInstance().prefetchData(str, hashMap2);
                } catch (Throwable th2) {
                    TaoLog.e(TAG, "failed to call prefetch: " + th2.getMessage());
                    th2.printStackTrace();
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                if (context != null) {
                    context.startActivity(intent);
                }
            } catch (ActivityNotFoundException unused) {
                TaoLog.e(TAG, "shouldOverrideUrlLoading: ActivityNotFoundException, url=" + str);
            }
            return true;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (WebView.getCoreType() == 3) {
            TaoLog.e(TAG, "U4 WebView will not use shouldInterceptRequest(API Level 11), return null.");
            return null;
        } else if (webView instanceof IWVWebView) {
            int i = 2;
            if (webView instanceof WVUCWebView) {
                i = ((WVUCWebView) webView).getUCExtension() == null ? 2 : 3;
            }
            return shouldInterceptRequestInternal(webView, str, WVEventService.getInstance().onEvent(1004, (IWVWebView) webView, str, Integer.valueOf(i)));
        } else {
            return null;
        }
    }
}
