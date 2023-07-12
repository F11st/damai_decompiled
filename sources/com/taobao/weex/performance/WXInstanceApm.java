package com.taobao.weex.performance;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.gz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXInstanceApm {
    public static final String KEY_PAGE_ANIM_BACK_NUM = "wxAnimationInBackCount";
    public static final String KEY_PAGE_PROPERTIES_BIZ_ID = "wxBizID";
    public static final String KEY_PAGE_PROPERTIES_BUBDLE_URL = "wxBundleUrl";
    public static final String KEY_PAGE_PROPERTIES_BUNDLE_TYPE = "wxBundleType";
    public static final String KEY_PAGE_PROPERTIES_CACHE_INFO = "wxZCacheInfo";
    public static final String KEY_PAGE_PROPERTIES_CACHE_TYPE = "wxCacheType";
    public static final String KEY_PAGE_PROPERTIES_CONTAINER_NAME = "wxContainerName";
    public static final String KEY_PAGE_PROPERTIES_INSTANCE_TYPE = "wxInstanceType";
    public static final String KEY_PAGE_PROPERTIES_JSLIB_VERSION = "wxJSLibVersion";
    public static final String KEY_PAGE_PROPERTIES_JS_FM_INI = "wxJsFrameworkInit";
    public static final String KEY_PAGE_PROPERTIES_PARENT_PAGE = "wxParentPage";
    public static final String KEY_PAGE_PROPERTIES_RENDER_TYPE = "wxRenderType";
    public static final String KEY_PAGE_PROPERTIES_REQUEST_TYPE = "wxRequestType";
    public static final String KEY_PAGE_PROPERTIES_UIKIT_TYPE = "wxUIKitType";
    public static final String KEY_PAGE_PROPERTIES_WEEX_VERSION = "wxSDKVersion";
    public static final String KEY_PAGE_STAGES_CONTAINER_READY = "wxContainerReady";
    public static final String KEY_PAGE_STAGES_CREATE_FINISH = "wxJSBundleCreateFinish";
    public static final String KEY_PAGE_STAGES_CUSTOM_PREPROCESS_END = "wxCustomPreprocessEnd";
    public static final String KEY_PAGE_STAGES_CUSTOM_PREPROCESS_START = "wxCustomPreprocessStart";
    public static final String KEY_PAGE_STAGES_DESTROY = "wxDestroy";
    public static final String KEY_PAGE_STAGES_DOWN_BUNDLE_END = "wxEndDownLoadBundle";
    public static final String KEY_PAGE_STAGES_DOWN_BUNDLE_START = "wxStartDownLoadBundle";
    public static final String KEY_PAGE_STAGES_END_EXCUTE_BUNDLE = "wxEndExecuteBundle";
    public static final String KEY_PAGE_STAGES_FIRST_INTERACTION_VIEW = "wxFirstInteractionView";
    public static final String KEY_PAGE_STAGES_FSRENDER = "wxFsRender";
    public static final String KEY_PAGE_STAGES_INTERACTION = "wxInteraction";
    public static final String KEY_PAGE_STAGES_LOAD_BUNDLE_END = "wxEndLoadBundle";
    public static final String KEY_PAGE_STAGES_LOAD_BUNDLE_START = "wxStartLoadBundle";
    public static final String KEY_PAGE_STAGES_NEW_FSRENDER = "wxNewFsRender";
    public static final String KEY_PAGE_STAGES_RENDER_ORGIGIN = "wxRenderTimeOrigin";
    public static final String KEY_PAGE_STATS_ACTUAL_DOWNLOAD_TIME = "wxActualNetworkTime";
    public static final String KEY_PAGE_STATS_BODY_RATIO = "wxBodyRatio";
    public static final String KEY_PAGE_STATS_BUNDLE_SIZE = "wxBundleSize";
    public static final String KEY_PAGE_STATS_CELL_DATA_UN_RECYCLE_NUM = "wxCellDataUnRecycleCount";
    public static final String KEY_PAGE_STATS_CELL_EXCEED_NUM = "wxCellExceedNum";
    public static final String KEY_PAGE_STATS_CELL_UN_RE_USE_NUM = "wxCellUnReUseCount";
    public static final String KEY_PAGE_STATS_COMPONENT_CREATE_COST = "wxComponentCost";
    public static final String KEY_PAGE_STATS_EMBED_COUNT = "wxEmbedCount";
    public static final String KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST = "wxExecJsCallBack";
    public static final String KEY_PAGE_STATS_FS_CALL_EVENT_NUM = "wxFSCallEventTotalNum";
    public static final String KEY_PAGE_STATS_FS_CALL_JS_NUM = "wxFSCallJsTotalNum";
    public static final String KEY_PAGE_STATS_FS_CALL_JS_TIME = "wxFSCallJsTotalTime";
    public static final String KEY_PAGE_STATS_FS_CALL_NATIVE_NUM = "wxFSCallNativeTotalNum";
    public static final String KEY_PAGE_STATS_FS_CALL_NATIVE_TIME = "wxFSCallNativeTotalTime";
    public static final String KEY_PAGE_STATS_FS_REQUEST_NUM = "wxFSRequestNum";
    public static final String KEY_PAGE_STATS_FS_TIMER_NUM = "wxFSTimerCount";
    public static final String KEY_PAGE_STATS_IMG_LOAD_FAIL_NUM = "wxImgLoadFailCount";
    public static final String KEY_PAGE_STATS_IMG_LOAD_NUM = "wxImgLoadCount";
    public static final String KEY_PAGE_STATS_IMG_LOAD_SUCCESS_NUM = "wxImgLoadSuccessCount";
    public static final String KEY_PAGE_STATS_IMG_UN_RECYCLE_NUM = "wxImgUnRecycleCount";
    public static final String KEY_PAGE_STATS_I_ALL_VIEW_COUNT = "wxInteractionAllViewCount";
    public static final String KEY_PAGE_STATS_I_COMPONENT_CREATE_COUNT = "wxInteractionComponentCreateCount";
    public static final String KEY_PAGE_STATS_I_SCREEN_VIEW_COUNT = "wxInteractionScreenViewCount";
    public static final String KEY_PAGE_STATS_JSLIB_INIT_TIME = "wxJSLibInitTime";
    public static final String KEY_PAGE_STATS_LARGE_IMG_COUNT = "wxLargeImgMaxCount";
    public static final String KEY_PAGE_STATS_LAYOUT_TIME = "wxLayoutTime";
    public static final String KEY_PAGE_STATS_MAX_COMPONENT_NUM = "wxMaxComponentCount";
    public static final String KEY_PAGE_STATS_MAX_DEEP_DOM = "wxMaxDeepVDomLayer";
    public static final String KEY_PAGE_STATS_MAX_DEEP_VIEW = "wxMaxDeepViewLayer";
    public static final String KEY_PAGE_STATS_NET_FAIL_NUM = "wxNetworkRequestFailCount";
    public static final String KEY_PAGE_STATS_NET_NUM = "wxNetworkRequestCount";
    public static final String KEY_PAGE_STATS_NET_SUCCESS_NUM = "wxNetworkRequestSuccessCount";
    public static final String KEY_PAGE_STATS_SCROLLER_NUM = "wxScrollerCount";
    public static final String KEY_PAGE_STATS_VIEW_CREATE_COST = "wxViewCost";
    public static final String KEY_PAGE_STATS_WRONG_IMG_SIZE_COUNT = "wxWrongImgSizeCount";
    public static final String KEY_PAGE_TIMER_BACK_NUM = "wxTimerInBackCount";
    public static final String KEY_PROPERTIES_ERROR_CODE = "wxErrorCode";
    public static final String VALUE_BUNDLE_LOAD_LENGTH = "wxLoadedLength";
    public static final String VALUE_ERROR_CODE_DEFAULT = "0";
    public static final String WEEX_FIRSTSCREENPAINT = "Weex_firstScreenPaint";
    public static final String WEEX_PAGE_TOPIC = "weex_page";
    private String a;
    private IWXApmMonitorAdapter b;
    private boolean f;
    public Rect l;
    public String m;
    public boolean o;
    private double r;
    public long s;
    private long t;
    public long u;
    private long v;
    private long w;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    public boolean k = false;
    public boolean n = false;
    public Set<String> q = new CopyOnWriteArraySet();
    private boolean x = false;
    private boolean y = false;
    public volatile boolean z = true;
    private Runnable A = new Runnable() { // from class: com.taobao.weex.performance.WXInstanceApm.1
        @Override // java.lang.Runnable
        public void run() {
            WXInstanceApm.this.v();
        }
    };
    private Runnable B = new Runnable() { // from class: com.taobao.weex.performance.WXInstanceApm.2
        @Override // java.lang.Runnable
        public void run() {
            WXInstanceApm.this.u();
        }
    };
    private long C = 0;
    public final Map<String, Object> j = new ConcurrentHashMap();
    public final Map<String, Long> d = new ConcurrentHashMap();
    private Handler p = new Handler(Looper.getMainLooper());
    private Map<String, Double> c = new ConcurrentHashMap();
    private Map<String, Object> e = new ConcurrentHashMap();

    public WXInstanceApm(String str) {
        this.a = str;
        IApmGenerator j = WXSDKManager.v().j();
        if (j != null) {
            this.b = j.generateApmInstance(WEEX_PAGE_TOPIC);
        }
    }

    private void f(String str, String str2, Map<String, Object> map) {
        Object obj = map.get(str);
        if (obj instanceof String) {
            e(str2, obj);
        }
    }

    private void t() {
        Long l = this.d.get(KEY_PAGE_STAGES_DOWN_BUNDLE_START);
        Long l2 = this.d.get(KEY_PAGE_STAGES_DOWN_BUNDLE_END);
        Long l3 = this.d.get(KEY_PAGE_STAGES_INTERACTION);
        Long l4 = this.d.get(KEY_PAGE_STAGES_CONTAINER_READY);
        if (l2 != null && l != null) {
            WXLogUtils.d("test->", "downLoadTime: " + (l2.longValue() - l.longValue()));
        }
        if (l2 != null && l3 != null) {
            WXLogUtils.d("test->", "renderTime: " + (l3.longValue() - l2.longValue()));
        }
        if (l4 == null || l3 == null) {
            return;
        }
        WXLogUtils.d("test->", "showTime: " + (l3.longValue() - l4.longValue()));
    }

    private void w(String str, Object obj) {
        if (gz2.a) {
            gz2.d(this.a, "properties", str, obj);
        }
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.addProperty(str, obj);
    }

    private void x(String str, long j) {
        if (gz2.a) {
            gz2.d(this.a, TLogEventConst.PARAM_UPLOAD_STAGE, str, Long.valueOf(j));
        }
        if (KEY_PAGE_STAGES_RENDER_ORGIGIN.equalsIgnoreCase(str)) {
            this.p.postDelayed(this.A, DanmakuFactory.DEFAULT_DANMAKU_DURATION);
        }
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.onStage(str, j);
    }

    private void y(String str, double d) {
        if (gz2.a) {
            gz2.d(this.a, "stats", str, Double.valueOf(d));
        }
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.addStats(str, d);
    }

    public String A() {
        Long l = this.d.get(KEY_PAGE_STAGES_RENDER_ORGIGIN);
        Long l2 = this.d.get(KEY_PAGE_STAGES_INTERACTION);
        Long l3 = this.d.get(KEY_PAGE_STAGES_NEW_FSRENDER);
        StringBuilder sb = new StringBuilder();
        if (l != null && l2 != null) {
            sb.append("interactiveTime " + (l2.longValue() - l.longValue()) + "ms");
        }
        if (l3 != null) {
            sb.append(" wxNewFsRender " + l3 + "ms");
        }
        return sb.toString();
    }

    public void B(String str, double d) {
        if (this.b == null) {
            return;
        }
        Double valueOf = Double.valueOf(this.c.containsKey(str) ? this.c.get(str).doubleValue() : 0.0d);
        if (valueOf == null) {
            WXErrorCode wXErrorCode = WXErrorCode.WX_ERR_HASH_MAP_TMP;
            WXExceptionUtils.commitCriticalExceptionRT("", wXErrorCode, "updateDiffStats", "key : " + str, null);
            return;
        }
        g(str, valueOf.doubleValue() + d);
    }

    public void C(String str, double d) {
        if (this.b == null || this.f) {
            return;
        }
        B(str, d);
    }

    public void D(String str, double d) {
        if (this.b == null) {
            return;
        }
        Double valueOf = Double.valueOf(this.c.containsKey(str) ? this.c.get(str).doubleValue() : 0.0d);
        if (valueOf == null) {
            WXErrorCode wXErrorCode = WXErrorCode.WX_ERR_HASH_MAP_TMP;
            WXExceptionUtils.commitCriticalExceptionRT("", wXErrorCode, "updateMaxStats", "key : " + str, null);
        } else if (valueOf.doubleValue() < d) {
            g(str, Double.valueOf(d).doubleValue());
        }
    }

    public void E(Map<String, String> map) {
        double d;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                d = Double.valueOf(entry.getValue()).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                d = -1.0d;
            }
            if (d != -1.0d) {
                this.c.put(entry.getKey(), Double.valueOf(d));
            }
        }
    }

    public void F(Map<String, Object> map) {
        if (this.b == null || map == null) {
            return;
        }
        f(KEY_PAGE_PROPERTIES_REQUEST_TYPE, KEY_PAGE_PROPERTIES_REQUEST_TYPE, map);
        f(WXPerformance.CACHE_TYPE, KEY_PAGE_PROPERTIES_CACHE_TYPE, map);
        f("zCacheInfo", KEY_PAGE_PROPERTIES_CACHE_INFO, map);
        g(KEY_PAGE_STATS_JSLIB_INIT_TIME, WXEnvironment.sJSLibInitTime);
        e(KEY_PAGE_PROPERTIES_JS_FM_INI, Boolean.valueOf(WXEnvironment.JsFrameworkInit));
        Object obj = map.get("actualNetworkTime");
        if (obj instanceof Long) {
            B(KEY_PAGE_STATS_ACTUAL_DOWNLOAD_TIME, ((Long) obj).doubleValue());
        }
    }

    public void a() {
        B(KEY_PAGE_STATS_IMG_LOAD_NUM, 1.0d);
    }

    public void b(boolean z, String str) {
        if (z) {
            B(KEY_PAGE_STATS_IMG_LOAD_SUCCESS_NUM, 1.0d);
        } else {
            B(KEY_PAGE_STATS_IMG_LOAD_FAIL_NUM, 1.0d);
        }
    }

    public void c() {
        if (!this.f) {
            C(KEY_PAGE_STATS_FS_REQUEST_NUM, 1.0d);
        }
        B(KEY_PAGE_STATS_NET_NUM, 1.0d);
    }

    public void d(boolean z, String str) {
        if (z) {
            B(KEY_PAGE_STATS_NET_SUCCESS_NUM, 1.0d);
        } else {
            B(KEY_PAGE_STATS_NET_FAIL_NUM, 1.0d);
        }
    }

    public void e(String str, Object obj) {
        if (this.h || str == null || obj == null) {
            return;
        }
        this.e.put(str, obj);
        if (this.z) {
            w(str, obj);
        }
    }

    public void g(String str, double d) {
        if (this.h || str == null) {
            return;
        }
        this.c.put(str, Double.valueOf(d));
        if (this.z) {
            y(str, d);
        }
    }

    public void h() {
        if (this.b == null) {
            return;
        }
        this.f = true;
        r(KEY_PAGE_STAGES_FSRENDER);
    }

    public void i(WXComponent wXComponent) {
        WXPerformance wXPerformance;
        if (this.b == null || wXComponent == null || wXComponent.getInstance() == null) {
            return;
        }
        if (gz2.a) {
            gz2.c(wXComponent);
        }
        if (this.b == null || (wXPerformance = wXComponent.getInstance().getWXPerformance()) == null) {
            return;
        }
        long fixUnixTime = WXUtils.getFixUnixTime();
        if (gz2.a()) {
            Log.d(gz2.INTERACTION_TAG, "[client][wxinteraction]" + wXComponent.getInstance().getInstanceId() + "," + wXComponent.getComponentType() + "," + wXComponent.getRef() + "," + wXComponent.getStyles() + "," + wXComponent.getAttrs());
        }
        if (!this.i) {
            r(KEY_PAGE_STAGES_FIRST_INTERACTION_VIEW);
            this.i = true;
        }
        if (this.k) {
            return;
        }
        long fixUnixTime2 = WXUtils.getFixUnixTime();
        if (fixUnixTime2 - this.C > 50) {
            WXBridgeManager.getInstance().onInteractionTimeUpdate(this.a);
            this.C = fixUnixTime2;
        }
        this.t = this.s;
        this.v = this.u;
        Double d = this.c.get(KEY_PAGE_STATS_LAYOUT_TIME);
        this.r = d == null ? 0.0d : d.doubleValue();
        wXPerformance.interactionTime = fixUnixTime - wXPerformance.renderUnixTimeOrigin;
        wXPerformance.interactionRealUnixTime = System.currentTimeMillis();
        s(KEY_PAGE_STAGES_INTERACTION, fixUnixTime);
        B(KEY_PAGE_STATS_I_SCREEN_VIEW_COUNT, 1.0d);
        D(KEY_PAGE_STATS_I_ALL_VIEW_COUNT, wXPerformance.localInteractionViewAddCount);
        WXSDKInstance y = WXSDKManager.v().y(this.a);
        if (y != null) {
            D(KEY_PAGE_STATS_I_COMPONENT_CREATE_COUNT, y.getWXPerformance().componentCount);
        }
    }

    public void j() {
        if (this.b == null) {
            return;
        }
        r(KEY_PAGE_STAGES_NEW_FSRENDER);
        r(WEEX_FIRSTSCREENPAINT);
    }

    public void k() {
        new Handler(Looper.getMainLooper()).postDelayed(this.B, DanmakuFactory.DEFAULT_DANMAKU_DURATION);
    }

    public void l() {
        if (this.z && !this.g) {
            this.g = true;
            IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
            if (iWXApmMonitorAdapter == null) {
                return;
            }
            iWXApmMonitorAdapter.onStart(this.a);
            WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(this.a);
            e(KEY_PAGE_PROPERTIES_BUBDLE_URL, wXSDKInstance == null ? "unKnowUrl" : wXSDKInstance.getBundleUrl());
            e(KEY_PROPERTIES_ERROR_CODE, "0");
            e(KEY_PAGE_PROPERTIES_JSLIB_VERSION, WXEnvironment.JS_LIB_SDK_VERSION);
            e(KEY_PAGE_PROPERTIES_WEEX_VERSION, WXEnvironment.WXSDK_VERSION);
            e(KEY_PAGE_PROPERTIES_WEEX_VERSION, WXEnvironment.WXSDK_VERSION);
            g("wxReInitCount", WXBridgeManager.reInitCount);
            if (wXSDKInstance != null) {
                e(KEY_PAGE_PROPERTIES_UIKIT_TYPE, wXSDKInstance.getRenderType());
            }
            e("wxUseRuntimeApi", Boolean.valueOf(WXEnvironment.sUseRunTimeApi));
            if (wXSDKInstance != null && (wXSDKInstance.isUsingEaglePlugin() || wXSDKInstance.getRenderStrategy() == WXRenderStrategy.DATA_RENDER_BINARY || wXSDKInstance.getRenderStrategy() == WXRenderStrategy.DATA_RENDER)) {
                e(KEY_PAGE_PROPERTIES_RENDER_TYPE, WXEnvironment.EAGLE);
            }
            if (wXSDKInstance != null) {
                for (Map.Entry<String, String> entry : wXSDKInstance.getContainerInfo().entrySet()) {
                    e(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public boolean m() {
        return this.g;
    }

    public void n() {
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.onAppear();
    }

    public void o() {
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.onDisappear();
    }

    public void p() {
        IWXApmMonitorAdapter iWXApmMonitorAdapter;
        if (this.b == null || this.h) {
            return;
        }
        new Handler(Looper.getMainLooper()).removeCallbacks(this.B);
        u();
        this.q.clear();
        this.p.removeCallbacks(this.A);
        r(KEY_PAGE_STAGES_DESTROY);
        if (this.g && (iWXApmMonitorAdapter = this.b) != null) {
            iWXApmMonitorAdapter.onEnd();
        }
        this.h = true;
        if (WXEnvironment.isApkDebugable()) {
            t();
        }
    }

    public void q(boolean z) {
        this.z = true;
        if (z) {
            r(KEY_PAGE_STAGES_DOWN_BUNDLE_START);
        }
        l();
        for (Map.Entry<String, Long> entry : this.d.entrySet()) {
            x(entry.getKey(), entry.getValue().longValue());
        }
        for (Map.Entry<String, Double> entry2 : this.c.entrySet()) {
            y(entry2.getKey(), entry2.getValue().doubleValue());
        }
        for (Map.Entry<String, Object> entry3 : this.e.entrySet()) {
            w(entry3.getKey(), entry3.getValue());
        }
    }

    public void r(String str) {
        s(str, WXUtils.getFixUnixTime());
    }

    public void s(String str, long j) {
        if (this.h || str == null) {
            return;
        }
        this.d.put(str, Long.valueOf(j));
        if (this.z) {
            x(str, j);
        }
    }

    public void u() {
        if (this.x) {
            return;
        }
        this.x = true;
        g(KEY_PAGE_STATS_VIEW_CREATE_COST, this.v);
        g(KEY_PAGE_STATS_COMPONENT_CREATE_COST, this.t);
        g(KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST, this.w);
        g(KEY_PAGE_STATS_LAYOUT_TIME, this.r);
    }

    public void v() {
        if (this.y) {
            return;
        }
        this.y = true;
        WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(this.a);
        if (wXSDKInstance == null) {
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(KEY_PAGE_PROPERTIES_BIZ_ID, this.m);
        hashMap.put(KEY_PAGE_PROPERTIES_BUBDLE_URL, wXSDKInstance.getBundleUrl());
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put(KEY_PAGE_STAGES_INTERACTION, Long.valueOf(wXSDKInstance.getWXPerformance().interactionRealUnixTime));
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put(TLogEventConst.PARAM_UPLOAD_STAGE, hashMap2);
        hashMap3.put("properties", hashMap);
        wXSDKInstance.fireGlobalEventCallback("wx_apm", hashMap3);
    }

    public void z(String str) {
        WXSDKInstance wXSDKInstance;
        if (TextUtils.isEmpty(str) && (wXSDKInstance = WXSDKManager.v().i().get(this.a)) != null) {
            str = wXSDKInstance.getContainerInfo().get(KEY_PAGE_PROPERTIES_CONTAINER_NAME);
        }
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter != null) {
            str = iWXApmMonitorAdapter.parseReportUrl(str);
        }
        this.m = str;
        String str2 = TextUtils.isEmpty(str) ? "emptyPageName" : this.m;
        this.m = str2;
        e(KEY_PAGE_PROPERTIES_BIZ_ID, str2);
    }
}
