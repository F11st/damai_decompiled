package android.taobao.windvane.extra.performance;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.taobao.windvane.WVPerformanceManager;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.utils.TimeUtils;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.taobao.monitor.procedure.IProcedure;
import com.uc.webview.export.WebView;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import org.json.JSONException;
import org.json.JSONObject;
import tb.hh1;
import tb.wu1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVH5PPManager {
    private static final String TAG = "H5PP";
    public static final int WV_H5PP_ZCache_State_Hit = 2;
    public static final int WV_H5PP_ZCache_State_NotHit = 1;
    public static final int WV_H5PP_ZCache_State_NotUse = 0;
    private static int identify;
    private String errorCode;
    private String errorMessage;
    private long h5_PP_T1;
    private long h5_PP_T1_uptime;
    private long h5_PP_TTI;
    private long h5_PP_initEnd;
    private long h5_PP_initEnd_uptime;
    private long h5_PP_initStart;
    private long h5_PP_initStart_uptime;
    private long h5_PP_loadRequest;
    private long h5_PP_loadRequest_uptime;
    private long h5_PP_startLoad;
    private long h5_PP_startLoad_uptime;
    private String htmlUrl;
    private int htmlZCacheState;
    private WVPagePerformance pagePerformance;
    private IWVWebView webView;

    public WVH5PPManager(IWVWebView iWVWebView) {
        this.webView = iWVWebView;
    }

    private void checkNonZeroStage(SpanWrapper spanWrapper, String str, Long l) {
        if (l.longValue() > 0) {
            FullTraceUtils.addStage(spanWrapper, str, l);
        }
    }

    @TargetApi(7)
    private void takeW3CPP() {
        if (this.pagePerformance == null) {
            return;
        }
        this.webView.evaluateJavascript("(function(performance){var timing=performance&&performance.timing;return timing&&JSON.stringify({ns:timing.navigationStart,fs:timing.fetchStart,rs:timing.requestStart,re:timing.responseEnd,dl:timing.domLoading,dc:timing.domComplete,ds:timing.domContentLoadedEventStart,ls:timing.loadEventStart,le:timing.loadEventEnd})})(window.performance)", new ValueCallback<String>() { // from class: android.taobao.windvane.extra.performance.WVH5PPManager.1
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
                    WVH5PPManager.this.pagePerformance.setH5_PP_navigationStart(jSONObject.optLong(NotificationStyle.NOTIFICATION_STYLE));
                    WVH5PPManager.this.pagePerformance.setH5_PP_fetchStart(jSONObject.optLong("fs"));
                    WVH5PPManager.this.pagePerformance.setH5_PP_responseEnd(jSONObject.optLong("re"));
                    WVH5PPManager.this.pagePerformance.setH5_PP_domContentLoadedEventStart(jSONObject.optLong("ds"));
                    WVH5PPManager.this.pagePerformance.setH5_PP_loadEventStart(jSONObject.optLong("ls"));
                    WVH5PPManager.this.pagePerformance.setH5_PP_loadEventEnd(jSONObject.optLong("le"));
                    WVH5PPManager.this.pagePerformance.setH5_PP_requestStart(jSONObject.optLong("rs"));
                    WVH5PPManager.this.pagePerformance.setH5_PP_domLoading(jSONObject.optLong("dl"));
                    WVH5PPManager.this.pagePerformance.setH5_PP_domComplete(jSONObject.optLong("dc"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (WVH5PPManager.this.webView instanceof View) {
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.uploadPPAfterJs) {
                        WVH5PPManager wVH5PPManager = WVH5PPManager.this;
                        wVH5PPManager.uploadPPInfo((View) wVH5PPManager.webView);
                    }
                }
            }
        });
    }

    private void uploadToFullTrace(View view) {
        if (view instanceof IFullTrace) {
            SpanWrapper spanWrapper = ((IFullTrace) view).getSpanWrapper();
            spanWrapper.setTag("H5_URL", this.pagePerformance.getUrl());
            spanWrapper.setTag("H5_process", CommonUtils.getProcessName(GlobalConfig.context));
            spanWrapper.setTag("H5_isFinished", this.pagePerformance.getH5_PP_isFinished());
            spanWrapper.setTag("H5_errorCode", this.pagePerformance.getH5_PP_errorCode());
            spanWrapper.setTag("H5_errorMessage", this.pagePerformance.getH5_PP_errorMessage());
            spanWrapper.setTag("H5_htmlZCacheState", Integer.valueOf(this.htmlZCacheState));
            checkNonZeroStage(spanWrapper, "H5_initStart", Long.valueOf(this.h5_PP_initStart));
            checkNonZeroStage(spanWrapper, "H5_initEnd", Long.valueOf(this.h5_PP_initEnd));
            checkNonZeroStage(spanWrapper, "H5_loadRequest", Long.valueOf(this.h5_PP_loadRequest));
            checkNonZeroStage(spanWrapper, "H5_startLoad", Long.valueOf(this.pagePerformance.getH5_PP_startLoad()));
            checkNonZeroStage(spanWrapper, "H5_navigationStart", Long.valueOf(this.pagePerformance.getH5_PP_navigationStart()));
            checkNonZeroStage(spanWrapper, "H5_requestStart", Long.valueOf(this.pagePerformance.h5_PP_requestStart_uptime));
            checkNonZeroStage(spanWrapper, "H5_responseEnd", Long.valueOf(this.pagePerformance.getH5_PP_responseEnd_uptime()));
            checkNonZeroStage(spanWrapper, "H5_domLoading", Long.valueOf(this.pagePerformance.h5_PP_domLoading_uptime));
            checkNonZeroStage(spanWrapper, "H5_domComplete", Long.valueOf(this.pagePerformance.h5_PP_domComplete_uptime));
            checkNonZeroStage(spanWrapper, "H5_responseEnd", Long.valueOf(this.pagePerformance.getH5_PP_responseEnd()));
            checkNonZeroStage(spanWrapper, "H5_domContentLoadedEventStart", Long.valueOf(this.pagePerformance.getH5_PP_domContentLoadedEventStart()));
            checkNonZeroStage(spanWrapper, "H5_loadEventStart", Long.valueOf(this.pagePerformance.getH5_PP_loadEventStart()));
            checkNonZeroStage(spanWrapper, "H5_loadEventEnd", Long.valueOf(this.pagePerformance.getH5_PP_loadEventEnd()));
            checkNonZeroStage(spanWrapper, "H5_firstPaint", Long.valueOf(this.pagePerformance.getH5_PP_FP()));
            checkNonZeroStage(spanWrapper, "H5_firstScreenPaint", Long.valueOf(this.pagePerformance.getH5_PP_FSP()));
            checkNonZeroStage(spanWrapper, "H5_timeToInteractive", Long.valueOf(this.pagePerformance.getH5_PP_TTI()));
            checkNonZeroStage(spanWrapper, "H5_T1", Long.valueOf(this.pagePerformance.getH5_PP_T1()));
            checkNonZeroStage(spanWrapper, "H5_T2", Long.valueOf(this.pagePerformance.getH5_PP_T2()));
            checkNonZeroStage(spanWrapper, "H5_finishLoad", Long.valueOf(this.pagePerformance.getH5_PP_finishLoad()));
        }
    }

    public String jsCodeForUserPP() {
        return "javascript:(function(){var observer=new PerformanceObserver(function(list,obj){for(var entry of list.getEntries()){if(entry.entryType=='paint'&&entry.name=='first-paint'){console.log('hybrid://WVPerformance:FP/receiveFPTime?{\"time\":'+entry.startTime+'}')}if(entry.entryType=='longtask'){console.log('hybrid://WVPerformance:TTI/receiveTTITime?{\"time\":'+(entry.startTime+entry.duration)+'}')}}});observer.observe({entryTypes:['longtask','paint']})})()";
    }

    public void pageDidFailLoadWithError(String str, String str2) {
        this.errorCode = str;
        this.errorMessage = str2;
    }

    public void pageDidFinishIntercept() {
    }

    public void pageDidFinishLoad(String str, WebView webView) {
        uploadInfo();
        WVPagePerformance wVPagePerformance = new WVPagePerformance();
        this.pagePerformance = wVPagePerformance;
        wVPagePerformance.setH5_PP_startLoad(this.h5_PP_startLoad);
        this.pagePerformance.setH5_PP_startLoad_uptime(this.h5_PP_startLoad_uptime);
        this.pagePerformance.setH5_PP_finishLoad(System.currentTimeMillis());
        this.pagePerformance.setH5_PP_finishLoad_uptime(SystemClock.uptimeMillis());
        this.pagePerformance.setUrl(str);
        this.pagePerformance.setH5_PP_T1(this.h5_PP_T1);
        this.pagePerformance.setH5_PP_T1_uptime(this.h5_PP_T1_uptime);
        this.pagePerformance.setH5_PP_errorCode(this.errorCode);
        this.pagePerformance.setH5_PP_errorMessage(this.errorMessage);
        takeW3CPP();
        this.pagePerformance.setH5_PP_isFinished(true);
        WVCommonConfig.getInstance();
        if (!WVCommonConfig.commonConfig.uploadPPAfterJs) {
            uploadPPInfo(webView);
        }
        this.errorCode = null;
        this.errorMessage = null;
    }

    public void pageDidLoadRequest() {
        this.h5_PP_loadRequest = System.currentTimeMillis();
        this.h5_PP_loadRequest_uptime = SystemClock.uptimeMillis();
    }

    public void pageDidStartIntercept() {
    }

    public void pageDidStartLoad() {
        WVPagePerformance wVPagePerformance = this.pagePerformance;
        if (wVPagePerformance != null) {
            wVPagePerformance.setH5_PP_TTI(this.h5_PP_TTI);
            this.h5_PP_TTI = 0L;
        }
        this.h5_PP_startLoad = System.currentTimeMillis();
        this.h5_PP_startLoad_uptime = SystemClock.uptimeMillis();
    }

    public void receiveFPTime(long j) {
        WVPagePerformance wVPagePerformance = this.pagePerformance;
        if (wVPagePerformance == null) {
            return;
        }
        wVPagePerformance.setH5_PP_FP(j);
    }

    public void receiveHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void receiveHtmlZCacheState(int i, String str) {
        String str2 = this.htmlUrl;
        if (str2 != null && str2.equals(str)) {
            this.htmlZCacheState = i;
        }
    }

    public void receiveTTITime(long j) {
        if (j - this.h5_PP_TTI <= DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
            this.h5_PP_TTI = j;
        }
    }

    public void recordFSP(long j) {
        WVPagePerformance wVPagePerformance = this.pagePerformance;
        if (wVPagePerformance == null) {
            return;
        }
        wVPagePerformance.setH5_PP_FSP(j);
        this.pagePerformance.setH5_PP_FSP_uptime(TimeUtils.generateUptimeFromCurrentTime(j));
    }

    public void recordUCT1(long j) {
        this.h5_PP_T1 = j;
        this.h5_PP_T1_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void recordUCT2(long j) {
        WVPagePerformance wVPagePerformance = this.pagePerformance;
        if (wVPagePerformance == null) {
            return;
        }
        wVPagePerformance.setH5_PP_T2(j);
        this.pagePerformance.setH5_PP_T2_uptime(TimeUtils.generateUptimeFromCurrentTime(j));
    }

    public void uploadInfo() {
        if (this.pagePerformance == null || !WVPerformanceManager.getInstance().getConfig().isOpenH5PP() || WVPerformanceManager.getInstance().getConfig().isOpenH5_2()) {
            return;
        }
        WVAPMManager wVAPMManager = new WVAPMManager("WindVane.H5");
        int i = identify;
        identify = i + 1;
        wVAPMManager.onStart(String.valueOf(i));
        wVAPMManager.addProperty("URL", this.pagePerformance.getUrl());
        wVAPMManager.addProperty("process", CommonUtils.getProcessName(GlobalConfig.context));
        wVAPMManager.addProperty("isFinished", Boolean.valueOf(this.pagePerformance.getH5_PP_isFinished()));
        wVAPMManager.addProperty("errorCode", this.pagePerformance.getH5_PP_errorCode());
        wVAPMManager.addProperty(hh1.DIMEN_MESSAGE, this.pagePerformance.getH5_PP_errorMessage());
        wVAPMManager.addProperty("htmlZCacheState", Integer.valueOf(this.htmlZCacheState));
        wVAPMManager.onStage("initStart", this.h5_PP_initStart);
        wVAPMManager.onStage("initEnd", this.h5_PP_initEnd);
        wVAPMManager.onStage("loadRequest", this.h5_PP_loadRequest);
        wVAPMManager.onStage("startLoad", this.pagePerformance.getH5_PP_startLoad());
        wVAPMManager.onStage("navigationStart", this.pagePerformance.getH5_PP_navigationStart());
        wVAPMManager.onStage("fetchStart", this.pagePerformance.getH5_PP_fetchStart());
        wVAPMManager.onStage("responseEnd", this.pagePerformance.getH5_PP_responseEnd());
        wVAPMManager.onStage("domContentLoadedEventStart", this.pagePerformance.getH5_PP_domContentLoadedEventStart());
        wVAPMManager.onStage("loadEventStart", this.pagePerformance.getH5_PP_loadEventStart());
        wVAPMManager.onStage("loadEventEnd", this.pagePerformance.getH5_PP_loadEventEnd());
        wVAPMManager.onStage("firstPaint", this.pagePerformance.getH5_PP_FP());
        wVAPMManager.onStage("firstScreenPaint", this.pagePerformance.getH5_PP_FSP());
        wVAPMManager.onStage("timeToInteractive", this.pagePerformance.getH5_PP_TTI());
        wVAPMManager.onStage("T1", this.pagePerformance.getH5_PP_T1());
        wVAPMManager.onStage("T2", this.pagePerformance.getH5_PP_T2());
        wVAPMManager.onStage("finishLoad", this.pagePerformance.getH5_PP_finishLoad());
        wVAPMManager.onEnd();
        Log.i(TAG, "URL: " + this.pagePerformance.getUrl());
        Log.i(TAG, "isFinished: " + this.pagePerformance.getH5_PP_isFinished());
        Log.i(TAG, "errorCode: " + this.pagePerformance.getH5_PP_errorCode());
        Log.i(TAG, "errorMessage: " + this.pagePerformance.getH5_PP_errorMessage());
        Log.i(TAG, "initStart: " + this.h5_PP_initStart);
        Log.i(TAG, "initEnd: " + this.h5_PP_initEnd);
        Log.i(TAG, "loadRequest: " + this.h5_PP_loadRequest);
        Log.i(TAG, "startLoad: " + this.pagePerformance.getH5_PP_startLoad());
        Log.i(TAG, "navigationStart: " + this.pagePerformance.getH5_PP_navigationStart());
        Log.i(TAG, "fetchStart: " + this.pagePerformance.getH5_PP_fetchStart());
        Log.i(TAG, "responseEnd: " + this.pagePerformance.getH5_PP_responseEnd());
        Log.i(TAG, "domContentLoadedEventStart: " + this.pagePerformance.getH5_PP_domContentLoadedEventStart());
        Log.i(TAG, "loadEventStart: " + this.pagePerformance.getH5_PP_loadEventStart());
        Log.i(TAG, "loadEventEnd: " + this.pagePerformance.getH5_PP_loadEventEnd());
        Log.i(TAG, "firstPaint: " + this.pagePerformance.getH5_PP_FP());
        Log.i(TAG, "firstScreenPaint: " + this.pagePerformance.getH5_PP_FSP());
        Log.i(TAG, "timeToInteractive: " + this.pagePerformance.getH5_PP_TTI());
        Log.i(TAG, "T1: " + this.pagePerformance.getH5_PP_T1());
        Log.i(TAG, "T2: " + this.pagePerformance.getH5_PP_T2());
        Log.i(TAG, "finishLoad: " + this.pagePerformance.getH5_PP_finishLoad());
    }

    public void uploadPPInfo(View view) {
        uploadToNativeApm(view);
        uploadToFullTrace(view);
    }

    public void uploadToNativeApm(View view) {
        try {
            IProcedure launcherProcedure = wu1.b.getLauncherProcedure();
            if (launcherProcedure != null && launcherProcedure.isAlive()) {
                uploadToNativeApm(launcherProcedure);
            } else {
                TaoLog.v(TAG, "LauncherProcedure is not Alive");
            }
            IProcedure currentActivityProcedure = wu1.b.getCurrentActivityProcedure();
            if (currentActivityProcedure != null && currentActivityProcedure.isAlive()) {
                uploadToNativeApm(currentActivityProcedure);
            } else {
                TaoLog.d(TAG, "CurrentActivityProcedure is not Alive");
            }
            IProcedure procedure = wu1.b.getProcedure(view);
            if (procedure != null && procedure.isAlive()) {
                uploadToNativeApm(procedure);
            } else {
                TaoLog.d(TAG, "Procedure is not Alive");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void webViewDidFinishInit() {
        this.h5_PP_initEnd = System.currentTimeMillis();
        this.h5_PP_initEnd_uptime = SystemClock.uptimeMillis();
    }

    public void webViewDidStartInit() {
        this.h5_PP_initStart = System.currentTimeMillis();
        this.h5_PP_initStart_uptime = SystemClock.uptimeMillis();
    }

    private void checkNonZeroStage(IProcedure iProcedure, String str, Long l) {
        if (l.longValue() > 0) {
            iProcedure.stage(str, l.longValue());
            return;
        }
        TaoLog.e(TAG, "stage=" + str + " time=" + l);
    }

    public void uploadToNativeApm(IProcedure iProcedure) {
        iProcedure.addProperty("H5_URL", this.pagePerformance.getUrl());
        iProcedure.addProperty("H5_process", CommonUtils.getProcessName(GlobalConfig.context));
        iProcedure.addProperty("H5_isFinished", Boolean.valueOf(this.pagePerformance.getH5_PP_isFinished()));
        iProcedure.addProperty("H5_errorCode", this.pagePerformance.getH5_PP_errorCode());
        iProcedure.addProperty("H5_errorMessage", this.pagePerformance.getH5_PP_errorMessage());
        iProcedure.addProperty("H5_htmlZCacheState", Integer.valueOf(this.htmlZCacheState));
        checkNonZeroStage(iProcedure, "H5_initStart", Long.valueOf(this.h5_PP_initStart_uptime));
        checkNonZeroStage(iProcedure, "H5_initEnd", Long.valueOf(this.h5_PP_initEnd_uptime));
        checkNonZeroStage(iProcedure, "H5_loadRequest", Long.valueOf(this.h5_PP_loadRequest_uptime));
        checkNonZeroStage(iProcedure, "H5_startLoad", Long.valueOf(this.pagePerformance.getH5_PP_startLoad_uptime()));
        checkNonZeroStage(iProcedure, "H5_navigationStart", Long.valueOf(this.pagePerformance.getH5_PP_navigationStart_uptime()));
        checkNonZeroStage(iProcedure, "H5_fetchStart", Long.valueOf(this.pagePerformance.getH5_PP_fetchStart_uptime()));
        checkNonZeroStage(iProcedure, "H5_requestStart", Long.valueOf(this.pagePerformance.h5_PP_requestStart_uptime));
        checkNonZeroStage(iProcedure, "H5_responseEnd", Long.valueOf(this.pagePerformance.getH5_PP_responseEnd_uptime()));
        checkNonZeroStage(iProcedure, "H5_domLoading", Long.valueOf(this.pagePerformance.h5_PP_domLoading_uptime));
        checkNonZeroStage(iProcedure, "H5_domComplete", Long.valueOf(this.pagePerformance.h5_PP_domComplete_uptime));
        checkNonZeroStage(iProcedure, "H5_domContentLoadedEventStart", Long.valueOf(this.pagePerformance.getH5_PP_domContentLoadedEventStart_uptime()));
        checkNonZeroStage(iProcedure, "H5_loadEventStart", Long.valueOf(this.pagePerformance.getH5_PP_loadEventStart_uptime()));
        checkNonZeroStage(iProcedure, "H5_loadEventEnd", Long.valueOf(this.pagePerformance.getH5_PP_loadEventEnd_uptime()));
        checkNonZeroStage(iProcedure, "H5_firstPaint", Long.valueOf(this.pagePerformance.getH5_PP_FP_uptime()));
        checkNonZeroStage(iProcedure, "H5_firstScreenPaint", Long.valueOf(this.pagePerformance.getH5_PP_FSP_uptime()));
        checkNonZeroStage(iProcedure, "H5_timeToInteractive", Long.valueOf(this.pagePerformance.getH5_PP_TTI_uptime()));
        checkNonZeroStage(iProcedure, "H5_T1", Long.valueOf(this.pagePerformance.getH5_PP_T1_uptime()));
        checkNonZeroStage(iProcedure, "H5_T2", Long.valueOf(this.pagePerformance.getH5_PP_T2_uptime()));
        checkNonZeroStage(iProcedure, "H5_finishLoad", Long.valueOf(this.pagePerformance.getH5_PP_finishLoad_uptime()));
    }
}
