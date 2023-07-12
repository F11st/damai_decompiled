package android.taobao.windvane.webview;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.filter.WVSecurityFilter;
import android.taobao.windvane.jsbridge.WVAppEvent;
import android.taobao.windvane.jsbridge.WVBridgeEngine;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVPluginEntryManager;
import android.taobao.windvane.jspatch.WVJsPatchListener;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.urlintercept.WVURLInterceptService;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.view.PopupWindowController;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVWebView extends WebView implements Handler.Callback, IWVWebView {
    private static final String TAG = "WVWebView";
    private static boolean evaluateJavascriptSupported;
    private final String WVURL_SUFFIX;
    public String bizCode;
    protected Context context;
    private String currentUrl;
    private String dataOnActive;
    float dx;
    float dy;
    protected WVPluginEntryManager entryManager;
    protected boolean isAlive;
    boolean isUser;
    private WVJsPatchListener jsPatchListener;
    private boolean longPressSaveImage;
    private boolean mAllowAllOpen;
    SparseArray<MotionEvent> mEventSparseArray;
    protected Handler mHandler;
    private String mImageUrl;
    private View.OnLongClickListener mLongClickListener;
    private int mPageLoadedCount;
    private View.OnClickListener mPopupClickListener;
    private PopupWindowController mPopupController;
    private String[] mPopupMenuTags;
    private boolean mUseGlobalUrlConfig;
    private int mWvNativeCallbackId;
    private long onErrorTime;
    protected boolean supportDownload;
    private boolean useUrlConfig;
    protected WVWebChromeClient webChromeClient;
    protected WVWebViewClient webViewClient;
    private WVSecurityFilter wvSecurityFilter;
    private boolean wvSupportFileSchema;
    private boolean wvSupportNativeJs;
    private WVUIModel wvUIModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class WVDownLoadListener implements DownloadListener {
        WVDownLoadListener() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(WVWebView.TAG, "Download start, url: " + str + " contentDisposition: " + str3 + " mimetype: " + str4 + " contentLength: " + j);
            }
            if (!WVWebView.this.supportDownload) {
                TaoLog.w(WVWebView.TAG, "DownloadListener is not support for webview.");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            try {
                WVWebView.this.context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(WVWebView.this.context, "对不起，您的设备找不到相应的程序", 1).show();
                TaoLog.e(WVWebView.TAG, "DownloadListener not found activity to open this url.");
            }
        }
    }

    static {
        evaluateJavascriptSupported = Build.VERSION.SDK_INT >= 19;
    }

    public WVWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bizCode = "";
        this.mWvNativeCallbackId = 1000;
        this.longPressSaveImage = true;
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = false;
        this.wvSupportFileSchema = EnvUtil.isDebug();
        this.currentUrl = null;
        this.dataOnActive = null;
        this.WVURL_SUFFIX = "?wvFackUrlState=";
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.onErrorTime = 0L;
        this.mPopupController = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save picture to album";
        this.mPopupMenuTags = strArr;
        this.mPopupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.webview.WVWebView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVWebView.this.mPopupMenuTags != null && WVWebView.this.mPopupMenuTags.length > 0 && WVWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.webview.WVWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageTool.saveImageToDCIM(WVWebView.this.context.getApplicationContext(), WVWebView.this.mImageUrl, WVWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.webview.WVWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVWebView.this.mPopupController != null) {
                    WVWebView.this.mPopupController.hide();
                }
            }
        };
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.context = context;
        init();
    }

    private void init() {
        int i;
        if (EnvUtil.isDebug()) {
            WVEventService.getInstance().onEvent(3008);
        }
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        WVWebViewClient wVWebViewClient = new WVWebViewClient(this.context);
        this.webViewClient = wVWebViewClient;
        super.setWebViewClient(wVWebViewClient);
        WVWebChromeClient wVWebChromeClient = new WVWebChromeClient(this.context);
        this.webChromeClient = wVWebChromeClient;
        super.setWebChromeClient(wVWebChromeClient);
        this.webChromeClient.mWebView = this;
        setVerticalScrollBarEnabled(false);
        requestFocus();
        CookieManager.getInstance().setAcceptCookie(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        }
        WVRenderPolicy.disableAccessibility(this.context);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        String appTag = GlobalConfig.getInstance().getAppTag();
        String appVersion = GlobalConfig.getInstance().getAppVersion();
        String userAgentString = settings.getUserAgentString();
        if (userAgentString != null) {
            if (!TextUtils.isEmpty(appTag) && !TextUtils.isEmpty(appVersion)) {
                userAgentString = userAgentString + " AliApp(" + appTag + "/" + appVersion + jn1.BRACKET_END_STR;
            }
            if (!userAgentString.contains("TTID/") && !TextUtils.isEmpty(GlobalConfig.getInstance().getTtid())) {
                userAgentString = userAgentString + " TTID/" + GlobalConfig.getInstance().getTtid();
            }
        }
        settings.setUserAgentString(userAgentString + GlobalConfig.DEFAULT_UA);
        settings.setCacheMode(-1);
        if (i2 >= 5) {
            settings.setDatabaseEnabled(false);
            String str = "/data/data/" + this.context.getPackageName() + "/databases";
            settings.setDatabasePath(str);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(str);
        }
        if (i2 >= 7) {
            settings.setDomStorageEnabled(true);
            settings.setAppCacheEnabled(true);
            Context context = this.context;
            if (context != null && context.getCacheDir() != null) {
                settings.setAppCachePath(this.context.getCacheDir().getAbsolutePath());
            }
        }
        if (i2 < 18) {
            settings.setSavePassword(false);
        }
        if (i2 >= 14) {
            settings.setTextZoom(100);
        } else {
            settings.setTextSize(WebSettings.TextSize.NORMAL);
        }
        if (TaoLog.getLogStatus() && i2 >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        WVJsBridge.getInstance().init();
        this.entryManager = new WVPluginEntryManager(this.context, this);
        WVAppEvent wVAppEvent = new WVAppEvent();
        wVAppEvent.initialize(this.context, this);
        addJsObject("AppEvent", wVAppEvent);
        if (i2 > 10 && i2 < 17) {
            try {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.wvSecurityFilter = new WVSecurityFilter();
        WVEventService.getInstance().addEventListener(this.wvSecurityFilter, WVEventService.WV_FORWARD_EVENT);
        this.jsPatchListener = new WVJsPatchListener(this);
        WVEventService.getInstance().addEventListener(this.jsPatchListener, WVEventService.WV_BACKWARD_EVENT);
        if (WVCommonConfig.commonConfig.enableSamsungClipboard && (i = Build.VERSION.SDK_INT) > 15 && i < 29 && "samsung".equalsIgnoreCase(Build.BOARD)) {
            try {
                ClipboardManager clipboardManager = (ClipboardManager) this.context.getSystemService("clipboard");
                if (clipboardManager != null) {
                    ClipData primaryClip = com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip(clipboardManager);
                    if (primaryClip == null) {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("初始化", ""));
                    } else if ("intent:#Intent;S.K_1171477665=;end".equals(primaryClip.getItemAt(0).coerceToText(this.context).toString())) {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("初始化", ""));
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.wvUIModel = new WVUIModel(this.context, this);
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: android.taobao.windvane.webview.WVWebView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                WebView.HitTestResult hitTestResult;
                try {
                    hitTestResult = WVWebView.this.getHitTestResult();
                } catch (Exception unused2) {
                    hitTestResult = null;
                }
                if (hitTestResult != null && WVWebView.this.longPressSaveImage) {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(WVWebView.TAG, "Long click on WebView, " + hitTestResult.getExtra());
                    }
                    if (hitTestResult.getType() == 8 || hitTestResult.getType() == 5) {
                        WVWebView.this.mImageUrl = hitTestResult.getExtra();
                        WVWebView wVWebView = WVWebView.this;
                        wVWebView.mPopupController = new PopupWindowController(wVWebView.context, wVWebView, wVWebView.mPopupMenuTags, WVWebView.this.mPopupClickListener);
                        WVWebView.this.mPopupController.show();
                        return true;
                    }
                    return false;
                }
                return false;
            }
        };
        this.mLongClickListener = onLongClickListener;
        setOnLongClickListener(onLongClickListener);
        setDownloadListener(new WVDownLoadListener());
        WVTweakWebCoreHandler.tryTweakWebCoreHandler();
        this.isAlive = true;
        if (WVMonitorService.getPackageMonitorInterface() != null) {
            WVMonitorService.getPerformanceMonitor().didWebViewInitAtTime(System.currentTimeMillis());
        }
        if (Build.VERSION.SDK_INT >= 11 && WVRenderPolicy.shouldDisableHardwareRenderInLayer()) {
            try {
                setLayerType(1, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        addJavascriptInterface(new WVBridgeEngine(this), "__windvane__");
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public Context _getContext() {
        return getContext();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    @TargetApi(19)
    public boolean _post(Runnable runnable) {
        if (!isAttachedToWindow() && Build.VERSION.SDK_INT < 24) {
            TaoLog.d(TAG, " webview has not attach to window");
            IWVWebView.taskQueue.add(runnable);
            return true;
        }
        return post(runnable);
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if ("accessibility".equals(str) || "accessibilityTraversal".equals(str)) {
            return;
        }
        if (!this.wvSupportNativeJs && Build.VERSION.SDK_INT < 17) {
            TaoLog.e(TAG, "addJavascriptInterface is disabled before API level 17 for security reason.");
        } else {
            super.addJavascriptInterface(obj, str);
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void addJsObject(String str, Object obj) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.addEntry(str, obj);
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean allowAllOpen() {
        return this.mAllowAllOpen;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean back() {
        if (canGoBack()) {
            goBack();
            int i = this.mPageLoadedCount;
            if (i > 0) {
                this.mPageLoadedCount = i - 1;
            } else {
                TaoLog.e(TAG, "back pressed, mPageLoadedCount=" + this.mPageLoadedCount);
            }
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        if (WVEventService.getInstance().onEvent(3004).isSuccess) {
            return false;
        }
        return super.canGoBack();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean canUseGlobalUrlConfig() {
        return this.mUseGlobalUrlConfig;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean canUseUrlConfig() {
        return this.useUrlConfig;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void clearCache() {
        super.clearCache(true);
    }

    public void closeLongPressSaveImage() {
        this.longPressSaveImage = false;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.isAlive) {
            this.isAlive = false;
            this.mPageLoadedCount = 0;
            InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(getApplicationWindowToken(), 0);
            }
            super.setWebViewClient(null);
            super.setWebChromeClient(null);
            this.webViewClient = null;
            this.webChromeClient = null;
            WVJsBridge.getInstance().tryToRunTailBridges();
            this.entryManager.onDestroy();
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
            WVEventService.getInstance().onEvent(3003);
            WVEventService.getInstance().removeEventListener(this.wvSecurityFilter);
            WVEventService.getInstance().removeEventListener(this.jsPatchListener);
            removeAllViews();
            this.mPopupController = null;
            this.mPopupClickListener = null;
            this.mLongClickListener = null;
            setOnLongClickListener(null);
            ConcurrentHashMap<String, Integer> concurrentHashMap = IWVWebView.JsbridgeHis;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            try {
                super.destroy();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void evaluateJavascript(String str) {
        evaluateJavascript(str, null);
    }

    public void fireEvent(String str) {
        fireEvent(str, "{}");
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        return (int) (super.getContentHeight() * super.getScale());
    }

    public String getCurrentUrl() {
        String url = super.getUrl();
        if (url == null) {
            TaoLog.v(TAG, "getUrl by currentUrl: " + this.currentUrl);
            return this.currentUrl;
        }
        TaoLog.v(TAG, "getUrl by webview: " + url);
        return url;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getDataOnActive() {
        return this.dataOnActive;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public Object getJsObject(String str) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager == null) {
            return null;
        }
        return wVPluginEntryManager.getEntry(str);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public int getPageLoadedCount() {
        return this.mPageLoadedCount;
    }

    @Override // android.webkit.WebView, android.taobao.windvane.webview.IWVWebView
    public String getUrl() {
        return getCurrentUrl();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getUserAgentString() {
        return getSettings().getUserAgentString();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public View getView() {
        return this;
    }

    @Deprecated
    public WVCallBackContext getWVCallBackContext() {
        return new WVCallBackContext(this);
    }

    public Handler getWVHandler() {
        return this.mHandler;
    }

    public WVUIModel getWvUIModel() {
        return this.wvUIModel;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 400:
                WVUIModel wVUIModel = this.wvUIModel;
                if (wVUIModel.isShowLoading() & (wVUIModel != null)) {
                    this.wvUIModel.showLoadingView();
                    this.wvUIModel.switchNaviBar(1);
                }
                this.mPageLoadedCount++;
                return true;
            case 401:
                WVUIModel wVUIModel2 = this.wvUIModel;
                if (wVUIModel2.isShowLoading() & (wVUIModel2 != null)) {
                    this.wvUIModel.hideLoadingView();
                    this.wvUIModel.resetNaviBar();
                }
                if (this.onErrorTime != 0 && System.currentTimeMillis() - this.onErrorTime > 3000) {
                    this.wvUIModel.hideErrorPage();
                }
                return true;
            case 402:
                this.wvUIModel.loadErrorPage();
                this.onErrorTime = System.currentTimeMillis();
                WVUIModel wVUIModel3 = this.wvUIModel;
                if (wVUIModel3.isShowLoading() & (wVUIModel3 != null)) {
                    this.wvUIModel.hideLoadingView();
                }
                return true;
            case 403:
                WVUIModel wVUIModel4 = this.wvUIModel;
                if (wVUIModel4.isShowLoading() & (wVUIModel4 != null)) {
                    this.wvUIModel.hideLoadingView();
                }
                return true;
            case 404:
                Toast.makeText(this.context, EnvUtil.isCN() ? "图片保存到相册成功" : "Success to save picture", 1).show();
                return true;
            case 405:
                Toast.makeText(this.context, EnvUtil.isCN() ? "图片保存到相册失败" : "Failed to save picture", 1).show();
                return true;
            default:
                return false;
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void hideLoadingView() {
        WVUIModel wVUIModel = this.wvUIModel;
        if (wVUIModel != null) {
            wVUIModel.hideLoadingView();
        }
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean isSupportFileSchema() {
        return this.wvSupportFileSchema;
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        if (this.isAlive) {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.isAlive) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "loadDataWithBaseURL: baseUrl=" + str);
            }
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView, android.taobao.windvane.webview.IWVWebView
    public void loadUrl(String str) {
        if (!this.isAlive || str == null) {
            return;
        }
        if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, this)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "GET_ACCESS_FORBIDDEN");
                hashMap.put("url", str);
                onMessage(402, hashMap);
                return;
            }
            try {
                super.loadUrl(forbiddenDomainRedirectURL);
            } catch (Exception e) {
                TaoLog.e(TAG, e.getMessage());
            }
        } else if (WVURLFilter.doFilter(str, this.context, this)) {
            TaoLog.e(TAG, "loadUrl filter url=" + str);
        } else {
            WVEventService.getInstance().onEvent(3010);
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "loadUrl: url=" + str);
            }
            WVSchemeIntercepterInterface wVSchemeIntercepter = WVSchemeInterceptService.getWVSchemeIntercepter();
            if (wVSchemeIntercepter != null) {
                str = wVSchemeIntercepter.dealUrlScheme(str);
            }
            try {
                if (WVURLInterceptService.getWVABTestHandler() != null && WVUrlUtil.shouldTryABTest(str)) {
                    String aBTestUrl = WVURLInterceptService.getWVABTestHandler().toABTestUrl(str);
                    if (!TextUtils.isEmpty(aBTestUrl) && !aBTestUrl.equals(str)) {
                        TaoLog.i(TAG, str + " abTestUrl to : " + aBTestUrl);
                        str = aBTestUrl;
                    }
                }
                super.loadUrl(str);
            } catch (Exception e2) {
                TaoLog.e(TAG, e2.getMessage());
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        for (Runnable runnable : IWVWebView.taskQueue) {
            runnable.run();
        }
        IWVWebView.taskQueue.clear();
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        List<Runnable> list = IWVWebView.taskQueue;
        if (list.size() != 0) {
            list.clear();
        }
    }

    public void onMessage(int i, Object obj) {
        if (this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.mHandler.sendMessage(obtain);
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(11)
    public void onPause() {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onPause();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            super.onPause();
        }
        WVEventService.getInstance().onEvent(3001);
    }

    @Override // android.webkit.WebView
    @TargetApi(11)
    public void onResume() {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onResume();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            super.onResume();
        }
        WVEventService.getInstance().onEvent(3002, this, getUrl(), new Object[0]);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onScrollChanged(i, i2, i3, i4);
        }
        try {
            super.onScrollChanged(i, i2, i3, i4);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (action == 0) {
            this.dx = motionEvent.getX();
            this.dy = motionEvent.getY();
            if (!this.isUser) {
                this.mEventSparseArray.put(pointerId, MotionEvent.obtain(motionEvent));
                return true;
            }
        } else if (action == 2) {
            if (!this.isUser && Math.abs(motionEvent.getY() - this.dy) > 5.0f) {
                return true;
            }
        } else if (action == 1) {
            if (!this.isUser && Math.abs(motionEvent.getY() - this.dy) > 5.0f) {
                this.isUser = true;
                return true;
            }
            MotionEvent motionEvent2 = this.mEventSparseArray.get(pointerId);
            if (motionEvent2 != null) {
                super.onTouchEvent(motionEvent2);
                motionEvent2.recycle();
                this.mEventSparseArray.remove(pointerId);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void openLongPressSaveImage() {
        this.longPressSaveImage = true;
    }

    @Override // android.webkit.WebView
    public void pauseTimers() {
        super.pauseTimers();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "You  must be careful  to Call pauseTimers ,It's Global");
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        if (!this.isAlive || str == null) {
            return;
        }
        if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, this)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "POST_ACCESS_FORBIDDEN");
                hashMap.put("url", str);
                onMessage(402, hashMap);
                return;
            }
            try {
                loadUrl(forbiddenDomainRedirectURL);
            } catch (Exception e) {
                TaoLog.e(TAG, e.getMessage());
            }
        } else if (WVURLFilter.doFilter(str, this.context, this)) {
            TaoLog.e(TAG, "loadUrl filter url=" + str);
        } else {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "postUrl: url=" + str);
            }
            super.postUrl(str, bArr);
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void refresh() {
        reload();
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();
    }

    @Override // android.webkit.WebView
    public void resumeTimers() {
        super.resumeTimers();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "You  must be careful  to Call resumeTimers ,It's Global");
        }
    }

    public void script2NativeCallback(String str, ValueCallback<String> valueCallback) {
        int i = this.mWvNativeCallbackId + 1;
        this.mWvNativeCallbackId = i;
        WVNativeCallbackUtil.putNativeCallbak(String.valueOf(i), valueCallback);
        loadUrl("javascript:console.log('wvNativeCallback/" + i + "/'+function(){var s = " + str + "; return (typeof s === 'object' ? JSON.stringify(s) : typeof s === 'string' ? '\"' + s + '\"' : s);}())");
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setAllowAllOpen(boolean z) {
        this.mAllowAllOpen = z;
    }

    public void setCurrentUrl(String str, String str2) {
        this.currentUrl = str;
        TaoLog.v(TAG, "setCurrentUrl: " + str + " state : " + str2);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setDataOnActive(String str) {
        this.dataOnActive = str;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setGlobalUrlConfigSwitch(boolean z) {
        this.mUseGlobalUrlConfig = z;
    }

    public void setSupportDownload(boolean z) {
        this.supportDownload = z;
    }

    public void setSupportFileSchema(boolean z) {
        this.wvSupportFileSchema = z;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setUrlConfigSwitch(boolean z) {
        this.useUrlConfig = z;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setUserAgentString(String str) {
        getSettings().setUserAgentString(str);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webChromeClient instanceof WVWebChromeClient) {
            WVWebChromeClient wVWebChromeClient = (WVWebChromeClient) webChromeClient;
            this.webChromeClient = wVWebChromeClient;
            wVWebChromeClient.mWebView = this;
            super.setWebChromeClient(webChromeClient);
            return;
        }
        WVWebChromeClient wVWebChromeClient2 = this.webChromeClient;
        if (wVWebChromeClient2 != null) {
            wVWebChromeClient2.extraWebChromeClient = webChromeClient;
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof WVWebViewClient) {
            this.webViewClient = (WVWebViewClient) webViewClient;
            super.setWebViewClient(webViewClient);
            return;
        }
        WVWebViewClient wVWebViewClient = this.webViewClient;
        if (wVWebViewClient != null) {
            wVWebViewClient.extraWebViewClient = webViewClient;
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void showLoadingView() {
        WVUIModel wVUIModel = this.wvUIModel;
        if (wVUIModel != null) {
            wVUIModel.showLoadingView();
        }
    }

    public void superLoadUrl(String str) {
        if (this.isAlive) {
            super.loadUrl(str);
        }
    }

    public void supportJavascriptInterface(boolean z) {
        this.wvSupportNativeJs = z;
    }

    @Override // android.webkit.WebView, android.taobao.windvane.webview.IWVWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (str != null && str.length() > 10 && "javascript:".equals(str.substring(0, 11).toLowerCase())) {
            str = str.substring(11);
        }
        if (evaluateJavascriptSupported) {
            try {
                super.evaluateJavascript(str, valueCallback);
            } catch (IllegalStateException unused) {
                evaluateJavascriptSupported = false;
                evaluateJavascript(str, valueCallback);
            } catch (NoSuchMethodError unused2) {
                evaluateJavascriptSupported = false;
                evaluateJavascript(str, valueCallback);
            }
        } else if (valueCallback == null) {
            loadUrl("javascript:" + str);
        } else {
            script2NativeCallback(str, valueCallback);
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void fireEvent(String str, String str2) {
        getWVCallBackContext().fireEvent(str, str2);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (!this.isAlive || str == null) {
            return;
        }
        if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, this)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "GET_ACCESS_FORBIDDEN");
                hashMap.put("url", str);
                onMessage(402, hashMap);
                return;
            }
            try {
                super.loadUrl(forbiddenDomainRedirectURL);
            } catch (Exception e) {
                TaoLog.e(TAG, e.getMessage());
            }
        } else if (WVURLFilter.doFilter(str, this.context, this)) {
            TaoLog.e(TAG, "loadUrl filter url=" + str);
        } else {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "loadUrl with headers: url=" + str);
            }
            super.loadUrl(str, map);
        }
    }

    public WVWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bizCode = "";
        this.mWvNativeCallbackId = 1000;
        this.longPressSaveImage = true;
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = false;
        this.wvSupportFileSchema = EnvUtil.isDebug();
        this.currentUrl = null;
        this.dataOnActive = null;
        this.WVURL_SUFFIX = "?wvFackUrlState=";
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.onErrorTime = 0L;
        this.mPopupController = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save picture to album";
        this.mPopupMenuTags = strArr;
        this.mPopupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.webview.WVWebView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVWebView.this.mPopupMenuTags != null && WVWebView.this.mPopupMenuTags.length > 0 && WVWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.webview.WVWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageTool.saveImageToDCIM(WVWebView.this.context.getApplicationContext(), WVWebView.this.mImageUrl, WVWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.webview.WVWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVWebView.this.mPopupController != null) {
                    WVWebView.this.mPopupController.hide();
                }
            }
        };
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.context = context;
        init();
    }

    public WVWebView(Context context) {
        super(context);
        this.bizCode = "";
        this.mWvNativeCallbackId = 1000;
        this.longPressSaveImage = true;
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = false;
        this.wvSupportFileSchema = EnvUtil.isDebug();
        this.currentUrl = null;
        this.dataOnActive = null;
        this.WVURL_SUFFIX = "?wvFackUrlState=";
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.onErrorTime = 0L;
        this.mPopupController = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save picture to album";
        this.mPopupMenuTags = strArr;
        this.mPopupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.webview.WVWebView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVWebView.this.mPopupMenuTags != null && WVWebView.this.mPopupMenuTags.length > 0 && WVWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.webview.WVWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageTool.saveImageToDCIM(WVWebView.this.context.getApplicationContext(), WVWebView.this.mImageUrl, WVWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.webview.WVWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVWebView.this.mPopupController != null) {
                    WVWebView.this.mPopupController.hide();
                }
            }
        };
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.context = context;
        init();
    }
}
