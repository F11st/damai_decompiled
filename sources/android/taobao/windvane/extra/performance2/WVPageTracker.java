package android.taobao.windvane.extra.performance2;

import android.taobao.windvane.WVPerformanceManager;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.extra.performance.WVAPMManager;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.RVLLog;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPageTracker {
    private static String RVLOG_PAGE_MODEL = "WindVane/Page";
    public static final int WVZCacheStateHitZCache = 2;
    public static final int WVZCacheStateNotHitZCache = 1;
    public static final int WVZCacheStateNotUseZCache = 0;
    public static final int WVZNSRFail = 2;
    public static final int WVZNSRSkip = 0;
    public static final int WVZNSRSuccess = 1;
    private static String customizedStageIndentifier = "CSI";
    private static int pageIdentifier;
    static List<PageStatusCallback> pageStatusCallbacks;
    private static int webViewIdentifier;
    private int jsErrorTimes;
    private String mLastPageUniqueIdentifier;
    private String mPageUniqueIdentifier;
    private String mWebViewUniqueIdentifier;
    private IPerformance performance;
    private long redirectCounts;
    private long redirectEntrance;
    private long redirectExport;
    private String url;
    private IWVWebView webView;
    private long mReceiveFirstPaintElapse = 0;
    private long mNavigationStartTS = 0;
    private int[][] stateMachine = {new int[]{1, 1, -1, -1, -1}, new int[]{-1, 1, 2, 3, -1}, new int[]{-1, 1, 2, 3, 4}, new int[]{-1, 1, 2, 3, -1}, new int[]{-1, -1, -1, 3, -1}};
    private String[] stages = {"initStart", "initEnd", "loadRequest", "interceptStart", "interceptEnd", "startLoad", "navigationStart", "fetchStart", "responseEnd", "domContentLoadedEventStart", "loadEventStart", "loadEventEnd", "finishLoad", "firstPaint", "firstScreenPaint", "timeToInteractive", "T1", "T2", "dealloc", "creatActivity", "attachToWindow", "firstScreenPaintCustomize"};
    private WVPageState state = WVPageState.WVPageStateInit;
    private ArrayList<WVResource> resources = new ArrayList<>();
    private HashMap<String, WVResource> resourcesMap = new HashMap<>();
    private ArrayList<Integer> events = new ArrayList<>();
    private long tti = 0;
    private Object lock_event = new Object();
    private Object lock_resource = new Object();
    private WVAPMManager apmManager = new WVAPMManager("WindVane.H5");

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface PageStatusCallback {
        void onPageFinish(String str);

        void onRedirect(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum WVPageState {
        WVPageStateError(-1),
        WVPageStateInit(0),
        WVPageStateLoadURL(1),
        WVPageStateStartLoad(2),
        WVPageStateFinishLoad(3),
        WVPageStateErrorOccurred(4);
        
        private int state;

        WVPageState(int i) {
            this.state = i;
        }

        public int value() {
            return this.state;
        }

        public static WVPageState valueOf(int i) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    return null;
                                }
                                return WVPageStateErrorOccurred;
                            }
                            return WVPageStateFinishLoad;
                        }
                        return WVPageStateStartLoad;
                    }
                    return WVPageStateLoadURL;
                }
                return WVPageStateInit;
            }
            return WVPageStateError;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class WVResource implements Serializable {
        public int dataSize;
        public boolean isHTML;
        public long loadingEndTime;
        public long loadingStartTime;
        public int statusCode;
        public String url;
        public String zcacheInfo;
        public int zcacheState;

        WVResource() {
        }
    }

    public WVPageTracker() {
        if (usable()) {
            updateWebViewIdentifier();
        }
    }

    private void addEvent(int i) {
        synchronized (this.lock_event) {
            this.events.add(new Integer(i));
        }
    }

    private void addResource(String str, WVResource wVResource) {
        if (str == null) {
            return;
        }
        synchronized (this.lock_resource) {
            if (this.resourcesMap.get(str) != null) {
                return;
            }
            this.resources.add(wVResource);
            this.resourcesMap.put(str, wVResource);
        }
    }

    private void analyzeEvents() {
        synchronized (this.lock_event) {
            String str = "";
            for (int i = 0; i < this.events.size(); i++) {
                str = str + this.events.get(i);
            }
            onApmAddedProperty("routingEvent", str);
        }
    }

    private void analyzeResources() {
        int i;
        int i2;
        WVPageTracker wVPageTracker = this;
        int i3 = 0;
        String str = "";
        long j = 0;
        int i4 = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        while (i3 < wVPageTracker.resources.size()) {
            WVResource wVResource = wVPageTracker.resources.get(i3);
            if (wVResource == null) {
                i = i4;
                TaoLog.e("WVPageTracker", " analyzeResources : resource为空！");
                i2 = i3;
            } else {
                i = i4;
                i2 = i3;
                long j7 = wVResource.loadingStartTime;
                long j8 = j;
                long j9 = wVResource.loadingEndTime;
                if (j7 < j9) {
                    j3 += j9 - j7;
                    j2++;
                }
                String valueOf = String.valueOf(wVResource.statusCode);
                if (valueOf.startsWith("2")) {
                    j4++;
                } else if (valueOf.startsWith("4") || valueOf.startsWith("5")) {
                    j5++;
                }
                if (wVResource.isHTML) {
                    int i5 = wVResource.zcacheState;
                    String str2 = wVResource.zcacheInfo;
                    i = i5;
                    if (str2 != null) {
                        str = str2;
                    }
                } else {
                    int i6 = wVResource.zcacheState;
                    if (i6 == 1) {
                        j6++;
                    } else if (i6 == 2) {
                        j6++;
                        j = j8 + 1;
                    }
                }
                j = j8;
            }
            i3 = i2 + 1;
            wVPageTracker = this;
            i4 = i;
        }
        long j10 = j;
        int i7 = i4;
        long j11 = j2 > 0 ? j3 / j2 : 0L;
        onApmAddedStatistic("resourceTotalCount", this.resources.size());
        onApmAddedStatistic("resourceSuccessfulCount", j4);
        onApmAddedStatistic("resourceFailedCount", j5);
        onApmAddedStatistic("resourceAverageTime", j11);
        onApmAddedStatistic("zcacheUsageCount", j6);
        onApmAddedStatistic("zcacheHitCount", j10);
        onApmAddedProperty("htmlZCacheState", Integer.valueOf(i7));
        onApmAddedProperty("htmlZCacheInfo", str);
        AtsTools.sendAtsPerformanceLog("page-resources", this.resources);
    }

    private void analyzeStates() {
        onApmAddedStatistic("redirectCounts", this.redirectCounts - 1);
        long j = this.redirectExport;
        long j2 = this.redirectEntrance;
        onApmAddedStatistic("redirectTime", j - j2 > 0 ? j - j2 : 0L);
    }

    private boolean checkoutHash(String str) {
        String str2;
        return (str == null || (str2 = this.url) == null || str.equals(str2) || !urlWithoutFragment(str).equals(urlWithoutFragment(this.url))) ? false : true;
    }

    private void clearEvent() {
        synchronized (this.lock_event) {
            this.events.clear();
        }
    }

    private void clearResource() {
        synchronized (this.lock_resource) {
            this.resources.clear();
            this.resourcesMap.clear();
        }
    }

    private long currentTime() {
        return System.currentTimeMillis();
    }

    private boolean isPage(String str) {
        return str.equals(this.url);
    }

    private void onApmAddedProperty(String str, Object obj) {
        this.apmManager.addProperty(str, obj);
        IPerformance iPerformance = this.performance;
        if (iPerformance != null && iPerformance.getPerformanceDelegate() != null) {
            this.performance.getPerformanceDelegate().recordProperties(str, obj);
        }
        AtsTools.sendAtsPerformanceLog(str, obj);
    }

    private void onApmAddedResidue() {
        onApmStaged(this.stages[15], this.tti);
        AtsTools.sendAtsPerformanceLog(this.stages[15], Long.valueOf(this.tti));
        analyzeResources();
        analyzeEvents();
        onResidueRecovered();
    }

    private void onApmAddedStatistic(String str, long j) {
        this.apmManager.addStatistic(str, j);
        IPerformance iPerformance = this.performance;
        if (iPerformance != null && iPerformance.getPerformanceDelegate() != null) {
            this.performance.getPerformanceDelegate().recordStatistics(str, j);
        }
        AtsTools.sendAtsPerformanceLog(str, Long.valueOf(j));
    }

    private void onApmFinished() {
        this.apmManager.onEnd();
        IPerformance iPerformance = this.performance;
        if (iPerformance == null || iPerformance.getPerformanceDelegate() == null) {
            return;
        }
        this.performance.getPerformanceDelegate().end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onApmStaged(String str, long j) {
        this.apmManager.onStage(str, j);
        IPerformance iPerformance = this.performance;
        if (iPerformance != null && iPerformance.getPerformanceDelegate() != null) {
            this.performance.getPerformanceDelegate().recordStage(str, j);
        }
        AtsTools.sendAtsPerformanceLog(str, Long.valueOf(j));
    }

    private void onApmStarted() {
        this.apmManager.onStart(this.mPageUniqueIdentifier);
        IPerformance iPerformance = this.performance;
        if (iPerformance == null || iPerformance.getPerformanceDelegate() == null) {
            return;
        }
        this.performance.getPerformanceDelegate().start();
    }

    private void onPropertyRecovered() {
        this.jsErrorTimes = 0;
        this.redirectCounts = 0L;
        this.redirectEntrance = 0L;
    }

    private void onResidueRecovered() {
        onResourceRecovered();
        clearEvent();
        this.tti = 0L;
    }

    private void onResourceRecovered() {
        clearResource();
    }

    private void onStateChanged(int i) {
        addEvent(i);
        WVPageState wVPageState = this.state;
        WVPageState wVPageState2 = WVPageState.WVPageStateError;
        if (wVPageState == wVPageState2) {
            return;
        }
        if (wVPageState == WVPageState.WVPageStateStartLoad) {
            this.redirectCounts++;
        }
        WVPageState valueOf = WVPageState.valueOf(this.stateMachine[wVPageState.value()][i]);
        this.state = valueOf;
        if (valueOf == wVPageState2) {
            onApmAddedProperty("errorProcess", 1);
        }
    }

    private void onStateRecovered() {
        if (this.state == WVPageState.WVPageStateError) {
            this.state = WVPageState.WVPageStateInit;
        }
    }

    private void recordRedirectEntrance() {
        if (this.redirectEntrance == 0) {
            this.redirectEntrance = currentTime();
        }
    }

    private void recordRedirectExport() {
        if (this.redirectExport == 0) {
            this.redirectExport = currentTime();
        }
    }

    private void recoverPageIdentifier() {
        String str = this.mLastPageUniqueIdentifier;
        if (str != null) {
            this.mPageUniqueIdentifier = str;
            this.mLastPageUniqueIdentifier = null;
        }
    }

    public static void registerH5LifeCallback(PageStatusCallback pageStatusCallback) {
        if (pageStatusCallback == null) {
            return;
        }
        if (pageStatusCallbacks == null) {
            pageStatusCallbacks = new ArrayList();
        }
        if (pageStatusCallbacks.contains(pageStatusCallback)) {
            return;
        }
        pageStatusCallbacks.add(pageStatusCallback);
    }

    public static void removeH5LifeCallback(PageStatusCallback pageStatusCallback) {
        List<PageStatusCallback> list;
        if (pageStatusCallback == null || (list = pageStatusCallbacks) == null) {
            return;
        }
        list.remove(pageStatusCallback);
    }

    private WVResource takeResource(String str) {
        WVResource wVResource;
        if (str == null) {
            return null;
        }
        synchronized (this.lock_resource) {
            wVResource = this.resourcesMap.get(str);
        }
        return wVResource;
    }

    private void updatePageIdentifier() {
        this.mLastPageUniqueIdentifier = this.mPageUniqueIdentifier;
        pageIdentifier++;
        this.mPageUniqueIdentifier = this.mWebViewUniqueIdentifier + "-" + pageIdentifier;
    }

    private void updateWebViewIdentifier() {
        webViewIdentifier++;
        this.mWebViewUniqueIdentifier = "WV_" + webViewIdentifier;
    }

    private String urlWithoutFragment(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        return indexOf == -1 ? str : str.substring(0, indexOf);
    }

    private boolean usable() {
        return WVPerformanceManager.getInstance().getConfig().isOpenH5_2();
    }

    public void attachToWindow() {
        if (usable()) {
            onApmStaged(this.stages[20], currentTime());
        }
    }

    public void blockURLEnd() {
        if (usable()) {
            long currentTime = currentTime();
            RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("interceptEnd", this.mPageUniqueIdentifier).h(currentTime).d();
            onApmStaged(this.stages[4], currentTime);
        }
    }

    public void blockURLStart() {
        if (usable()) {
            long currentTime = currentTime();
            RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("interceptStart", this.mPageUniqueIdentifier).h(currentTime).d();
            onApmStaged(this.stages[3], currentTime);
        }
    }

    public void creatActivity(long j) {
        if (usable()) {
            onApmStaged(this.stages[19], j);
        }
    }

    public void destroy() {
        if (usable()) {
            onApmAddedResidue();
            onApmStaged(this.stages[18], currentTime());
            onApmFinished();
        }
    }

    public void initEnd() {
        if (usable()) {
            long currentTime = currentTime();
            RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("initEnd", this.mPageUniqueIdentifier).h(currentTime).d();
            onApmStaged(this.stages[1], currentTime);
        }
    }

    public void initStart(IPerformance iPerformance, IWVWebView iWVWebView) {
        if (usable()) {
            this.performance = iPerformance;
            this.webView = iWVWebView;
            updatePageIdentifier();
            long currentTime = currentTime();
            RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("initStart", this.mPageUniqueIdentifier).h(currentTime).d();
            onApmStarted();
            onApmStaged(this.stages[0], currentTime);
            onApmAddedProperty(com.taobao.aranger.constant.Constants.PARAM_PROCESS_NAME, CommonUtils.getProcessName(GlobalConfig.context));
        }
    }

    public void loadUrl(String str) {
        if (usable()) {
            this.url = str;
            recordRedirectEntrance();
            long currentTime = currentTime();
            RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("loadRequest", this.mPageUniqueIdentifier).a("url", str).h(currentTime).d();
            onStateChanged(0);
            onApmStaged(this.stages[2], currentTime);
            IWVWebView iWVWebView = this.webView;
            if (iWVWebView == null || iWVWebView.getUserAgentString() == null || this.webView.getUserAgentString().indexOf("Triver") == -1) {
                return;
            }
            onApmAddedProperty("triver", 1);
        }
    }

    public void onPageFinished(IWVWebView iWVWebView, String str) {
        if (usable()) {
            List<PageStatusCallback> list = pageStatusCallbacks;
            if (list != null) {
                for (PageStatusCallback pageStatusCallback : list) {
                    try {
                        pageStatusCallback.onPageFinish(str);
                    } catch (Throwable unused) {
                    }
                }
            }
            onStateChanged(3);
            if (checkoutHash(str)) {
                return;
            }
            recordRedirectExport();
            long currentTime = currentTime();
            RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("finishLoad", this.mPageUniqueIdentifier).h(currentTime).d();
            onApmStaged(this.stages[12], currentTime);
            onApmAddedProperty("isFinished", new Integer(1));
            onApmAddedProperty("URL", str);
            onApmAddedStatistic("jsErrorTimes", this.jsErrorTimes);
            onPageReceivedPerformanceTiming(iWVWebView);
            analyzeStates();
            onStateRecovered();
            onPropertyRecovered();
        }
    }

    public void onPageReceivedCustomizedFSP(long j) {
        if (usable()) {
            onApmStaged(this.stages[21], j);
        }
    }

    public void onPageReceivedCustomizedStage(long j, String str) {
        if (usable()) {
            onApmStaged(customizedStageIndentifier + "-" + str, j);
        }
    }

    public void onPageReceivedError(IWVWebView iWVWebView, String str, int i) {
        if (usable()) {
            onStateChanged(4);
            onApmAddedProperty("errorCode", new Integer(i));
            onApmAddedProperty("errorMsg", str);
        }
    }

    public void onPageReceivedFP(long j) {
        if (usable()) {
            if (this.mNavigationStartTS > 0) {
                RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("firstPaint", this.mPageUniqueIdentifier).h(this.mNavigationStartTS + j).d();
            } else {
                this.mReceiveFirstPaintElapse = j;
            }
            onApmStaged(this.stages[13], j);
        }
    }

    public void onPageReceivedFSP(long j) {
        if (usable()) {
            onApmStaged(this.stages[14], j);
        }
    }

    public void onPageReceivedJSError() {
        if (usable()) {
            this.jsErrorTimes++;
        }
    }

    public void onPageReceivedPerformanceTiming(IWVWebView iWVWebView) {
        iWVWebView.evaluateJavascript("(function(performance){var timing=performance&&performance.timing;return timing&&JSON.stringify({ns:timing.navigationStart,fs:timing.fetchStart,rs:timing.requestStart,re:timing.responseEnd,ds:timing.domContentLoadedEventStart,dc:timing.domComplete,ls:timing.loadEventStart,le:timing.loadEventEnd})})(window.performance)", new ValueCallback<String>() { // from class: android.taobao.windvane.extra.performance2.WVPageTracker.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = "{}";
                }
                if (str.startsWith("\"") && str.endsWith("\"")) {
                    str = str.substring(1, str.length() - 1);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str.replace("\\", ""));
                    long optLong = jSONObject.optLong(NotificationStyle.NOTIFICATION_STYLE);
                    long optLong2 = jSONObject.optLong("rs");
                    long optLong3 = jSONObject.optLong("re");
                    long optLong4 = jSONObject.optLong("dc");
                    RVLLevel rVLLevel = RVLLevel.Error;
                    RVLLog.a(rVLLevel, WVPageTracker.RVLOG_PAGE_MODEL).g("navigationStart", WVPageTracker.this.mPageUniqueIdentifier).h(optLong).d();
                    RVLLog.a(rVLLevel, WVPageTracker.RVLOG_PAGE_MODEL).g("requestStart", WVPageTracker.this.mPageUniqueIdentifier).h(optLong2).d();
                    RVLLog.a(rVLLevel, WVPageTracker.RVLOG_PAGE_MODEL).g("responseEnd", WVPageTracker.this.mPageUniqueIdentifier).h(optLong3).d();
                    RVLLog.a(rVLLevel, WVPageTracker.RVLOG_PAGE_MODEL).g("domComplete", WVPageTracker.this.mPageUniqueIdentifier).h(optLong4).d();
                    if (WVPageTracker.this.mReceiveFirstPaintElapse > 0) {
                        RVLLog.a(rVLLevel, WVPageTracker.RVLOG_PAGE_MODEL).g("firstPaint", WVPageTracker.this.mPageUniqueIdentifier).h(WVPageTracker.this.mReceiveFirstPaintElapse + optLong).d();
                    } else {
                        WVPageTracker.this.mNavigationStartTS = optLong;
                    }
                    WVPageTracker wVPageTracker = WVPageTracker.this;
                    wVPageTracker.onApmStaged(wVPageTracker.stages[6], optLong);
                    WVPageTracker wVPageTracker2 = WVPageTracker.this;
                    wVPageTracker2.onApmStaged(wVPageTracker2.stages[7], jSONObject.optLong("fs"));
                    WVPageTracker wVPageTracker3 = WVPageTracker.this;
                    wVPageTracker3.onApmStaged(wVPageTracker3.stages[8], optLong3);
                    WVPageTracker wVPageTracker4 = WVPageTracker.this;
                    wVPageTracker4.onApmStaged(wVPageTracker4.stages[9], jSONObject.optLong("ds"));
                    WVPageTracker wVPageTracker5 = WVPageTracker.this;
                    wVPageTracker5.onApmStaged(wVPageTracker5.stages[10], jSONObject.optLong("ls"));
                    WVPageTracker wVPageTracker6 = WVPageTracker.this;
                    wVPageTracker6.onApmStaged(wVPageTracker6.stages[11], jSONObject.optLong("le"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onPageReceivedT1(long j) {
        if (usable()) {
            onApmStaged(this.stages[16], j);
        }
    }

    public void onPageReceivedT2(long j) {
        if (usable()) {
            RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("T2", this.mPageUniqueIdentifier).h(j).d();
        }
    }

    public void onPageReceivedTTI(long j) {
        if (usable() && j - this.tti <= DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
            this.tti = j;
        }
    }

    public void onPageStarted(IWVWebView iWVWebView, String str) {
        if (usable()) {
            if (this.state == WVPageState.WVPageStateFinishLoad) {
                updatePageIdentifier();
                onApmAddedResidue();
                onApmFinished();
                onApmStarted();
                recordRedirectEntrance();
            }
            long currentTime = currentTime();
            RVLLog.a(RVLLevel.Error, RVLOG_PAGE_MODEL).g("startLoad", this.mPageUniqueIdentifier).h(currentTime).d();
            onStateChanged(2);
            onApmStaged(this.stages[5], currentTime);
        }
    }

    public void onResourceFinished(String str, int i) {
        WVResource takeResource;
        if (usable() && (takeResource = takeResource(str)) != null) {
            takeResource.loadingEndTime = currentTime();
            takeResource.dataSize = i;
            IPerformance iPerformance = this.performance;
            if (iPerformance == null || iPerformance.getPerformanceDelegate() == null) {
                return;
            }
            this.performance.getPerformanceDelegate().onResourceFinished(str, i);
        }
    }

    public void onResourceReceivedStatusCode(String str, String str2, int i) {
        WVResource takeResource;
        List<PageStatusCallback> list;
        if (usable() && (takeResource = takeResource(str)) != null) {
            if (i == 302 && takeResource.isHTML && (list = pageStatusCallbacks) != null) {
                for (PageStatusCallback pageStatusCallback : list) {
                    try {
                        pageStatusCallback.onRedirect(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            }
            takeResource.statusCode = i;
            IPerformance iPerformance = this.performance;
            if (iPerformance == null || iPerformance.getPerformanceDelegate() == null) {
                return;
            }
            this.performance.getPerformanceDelegate().onResourceReceivedStatusCode(str, i);
        }
    }

    public void onResourceReceivedZCacheInfo(String str, String str2) {
        WVResource takeResource;
        if (usable() && (takeResource = takeResource(str)) != null) {
            takeResource.zcacheInfo = str2;
        }
    }

    public void onResourceReceivedZCacheState(String str, int i) {
        WVResource takeResource;
        if (usable() && (takeResource = takeResource(str)) != null) {
            takeResource.zcacheState = i;
        }
    }

    public void onResourceStarted(String str) {
        if (usable()) {
            WVResource wVResource = new WVResource();
            wVResource.loadingStartTime = currentTime();
            wVResource.url = str;
            if (isPage(str)) {
                wVResource.isHTML = true;
            }
            addResource(str, wVResource);
            IPerformance iPerformance = this.performance;
            if (iPerformance == null || iPerformance.getPerformanceDelegate() == null) {
                return;
            }
            this.performance.getPerformanceDelegate().onResourceStarted(str);
        }
    }

    public void onWebViewNSREvent(int i) {
        if (usable()) {
            onApmAddedProperty("nativeSideRendering", Integer.valueOf(i));
        }
    }

    public void shouldOverrideUrlLoading(IWVWebView iWVWebView, String str) {
        if (usable()) {
            this.url = str;
            WVPageState wVPageState = this.state;
            if (wVPageState == WVPageState.WVPageStateFinishLoad || wVPageState == WVPageState.WVPageStateInit) {
                updatePageIdentifier();
                onApmAddedResidue();
                onApmFinished();
                onApmStarted();
                recordRedirectEntrance();
            }
            onStateChanged(1);
        }
    }
}
