package com.alibaba.aliweex.adapter.module.mtop;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anetwork.channel.statist.StatisticData;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.module.mtop.WXMtopModule;
import com.alibaba.aliweex.interceptor.mtop.MtopTracker;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.RemoteBusiness;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.utils.WXLogUtils;
import com.uc.webview.export.extension.UCCore;
import com.youku.live.livesdk.preloader.Preloader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;
import org.json.JSONArray;
import tb.nz2;
import tb.oz2;
import tb.th1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class WXMtopRequest {
    public static final String MSG_FAILED = "WX_FAILED";
    public static final String MSG_PARAM_ERR = "MSG_PARAM_ERR";
    public static final String MSG_SUCCESS = "WX_SUCCESS";
    private static ScheduledExecutorService e = Executors.newScheduledThreadPool(1);
    private MtopTracker a;
    private WXMtopModule.MTOP_VERSION b;
    public String c;
    private Handler d = new a(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private class RbListener implements IRemoteCacheListener, IRemoteListener {
        private MtopResponse cachedResponse;
        private JSCallback callback;
        private JSCallback failure;
        public String instanceId;
        private MtopTracker mtopTracker;
        private WeakReference<RemoteBusiness> rbWeakRef;
        public String requestAi;
        private long timer;
        private boolean isTimeout = false;
        private boolean isFinish = false;

        public RbListener(MtopTracker mtopTracker, JSCallback jSCallback, JSCallback jSCallback2, RemoteBusiness remoteBusiness, long j) {
            this.mtopTracker = mtopTracker;
            this.callback = jSCallback;
            this.failure = jSCallback2;
            this.timer = j;
            this.rbWeakRef = new WeakReference<>(remoteBusiness);
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteCacheListener
        public synchronized void onCached(MtopCacheEvent mtopCacheEvent, BaseOutDo baseOutDo, Object obj) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d("WXMtopRequest", "RemoteBusiness callback onCached");
            }
            if (mtopCacheEvent != null) {
                this.cachedResponse = mtopCacheEvent.getMtopResponse();
                WXMtopRequest.e.schedule(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.RbListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        RbListener.this.onTimeOut();
                    }
                }, this.timer, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public synchronized void onError(int i, final MtopResponse mtopResponse, Object obj) {
            if (mtopResponse != null) {
                if (!this.isTimeout) {
                    WXSDKInstance y = WXSDKManager.v().y(this.instanceId);
                    if (y != null) {
                        y.getApmForInstance().d(false, null);
                    }
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.d("WXMtopRequest", "RemoteBusiness callback onError");
                    }
                    this.isFinish = true;
                    WXMtopRequest.e.submit(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.RbListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            RbListener rbListener = RbListener.this;
                            com.alibaba.aliweex.adapter.module.mtop.a n = WXMtopRequest.this.n(rbListener.callback, RbListener.this.failure, mtopResponse);
                            if (RbListener.this.mtopTracker != null) {
                                RbListener.this.mtopTracker.n(mtopResponse.getApi(), n.toString());
                            }
                            WXMtopRequest.this.l(n);
                        }
                    });
                }
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public synchronized void onSuccess(int i, final MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
            if (mtopResponse != null) {
                if (!this.isTimeout) {
                    WXSDKInstance y = WXSDKManager.v().y(this.instanceId);
                    if (y != null) {
                        y.getApmForInstance().d(true, null);
                    }
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.d("WXMtopRequest", "RemoteBusiness callback onSuccess");
                    }
                    this.isFinish = true;
                    WXMtopRequest.e.submit(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.RbListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RbListener.this.mtopTracker != null) {
                                RbListener.this.mtopTracker.p(mtopResponse);
                            }
                            RbListener rbListener = RbListener.this;
                            WXMtopRequest wXMtopRequest = WXMtopRequest.this;
                            wXMtopRequest.l(wXMtopRequest.n(rbListener.callback, RbListener.this.failure, mtopResponse));
                        }
                    });
                }
            }
        }

        public synchronized void onTimeOut() {
            if (this.isFinish) {
                return;
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d("WXMtopRequest", "callback onTimeOut");
            }
            this.isTimeout = true;
            RemoteBusiness remoteBusiness = this.rbWeakRef.get();
            if (remoteBusiness != null) {
                remoteBusiness.cancelRequest();
            }
            MtopTracker mtopTracker = this.mtopTracker;
            if (mtopTracker != null) {
                mtopTracker.p(this.cachedResponse);
            }
            WXMtopRequest wXMtopRequest = WXMtopRequest.this;
            wXMtopRequest.l(wXMtopRequest.n(this.callback, this.failure, this.cachedResponse));
            WXSDKInstance y = WXSDKManager.v().y(this.instanceId);
            if (y != null) {
                y.getApmForInstance().d(false, "onTimeOut");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            JSCallback d;
            if (message.what == 500 && (message.obj instanceof com.alibaba.aliweex.adapter.module.mtop.a)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("WXMtopRequest", "call result, retString: " + ((com.alibaba.aliweex.adapter.module.mtop.a) message.obj).toString());
                }
                try {
                    com.alibaba.aliweex.adapter.module.mtop.a aVar = (com.alibaba.aliweex.adapter.module.mtop.a) message.obj;
                    if (aVar.c() == null || aVar.e() == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (WXMtopRequest.this.b == WXMtopModule.MTOP_VERSION.V1) {
                        jSONObject.put("result", (Object) (aVar.g() ? "WX_SUCCESS" : "WX_FAILED"));
                        jSONObject.put("data", (Object) JSON.parseObject(aVar.toString()));
                        d = aVar.c();
                    } else {
                        jSONObject = JSON.parseObject(aVar.toString());
                        if (aVar.g()) {
                            d = aVar.c();
                        } else {
                            if (!jSONObject.containsKey("result")) {
                                jSONObject.put("result", (Object) aVar.f());
                            }
                            d = aVar.d();
                        }
                    }
                    JSCallback jSCallback = d;
                    WXMtopRequest.this.o("weex-mtop-end", null, null, null, aVar);
                    if (jSCallback != null) {
                        jSCallback.invoke(jSONObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public WXMtopRequest(WXMtopModule.MTOP_VERSION mtop_version) {
        if (WXEnvironment.isApkDebugable()) {
            this.a = MtopTracker.m();
        }
        this.b = mtop_version;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteBusiness j(MtopRequest mtopRequest, th1 th1Var, String str) {
        RemoteBusiness build = RemoteBusiness.build(mtopRequest, StringUtils.isBlank(th1Var.e) ? SDKConfig.getInstance().getGlobalTtid() : th1Var.e);
        build.showLoginUI(!th1Var.i.equals("AutoLoginOnly"));
        if (th1Var.k) {
            build.protocol(ProtocolEnum.HTTPSECURE);
        } else {
            build.protocol(ProtocolEnum.HTTP);
        }
        if ("true".equals(oz2.j().h(oz2.j().m))) {
            build.useCache();
        }
        if (th1Var.d > 0) {
            build.useWua();
        }
        build.reqMethod(th1Var.h ? MethodEnum.POST : MethodEnum.GET);
        if (th1Var.d() != null) {
            build.headers(th1Var.d());
        }
        if (StringUtils.isNotBlank(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("x-ua", str);
            build.headers((Map<String, String>) hashMap);
        }
        if (!StringUtils.isBlank(th1Var.g) && (Preloader.KEY_JSON.equals(th1Var.g) || "originaljson".equals(th1Var.g))) {
            build.setJsonType(JsonTypeEnum.valueOf(th1Var.g.toUpperCase()));
        }
        try {
            if (!TextUtils.isEmpty(th1Var.l)) {
                build.setPageUrl(th1Var.l);
            }
        } catch (Throwable unused) {
        }
        try {
            if (!TextUtils.isEmpty(th1Var.m)) {
                build.setPageName(th1Var.m);
            }
        } catch (Throwable unused2) {
        }
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MtopRequest k(th1 th1Var) {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(th1Var.a);
        mtopRequest.setVersion(th1Var.b);
        mtopRequest.setNeedEcode(th1Var.c);
        mtopRequest.setNeedSession(true);
        if (StringUtils.isNotBlank(th1Var.j)) {
            mtopRequest.setData(th1Var.j);
        }
        mtopRequest.dataParams = th1Var.c();
        return mtopRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.alibaba.aliweex.adapter.module.mtop.a aVar) {
        this.d.obtainMessage(500, aVar).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091 A[Catch: JSONException -> 0x0156, TryCatch #0 {JSONException -> 0x0156, blocks: (B:3:0x0010, B:6:0x0035, B:9:0x003c, B:11:0x0044, B:18:0x0063, B:20:0x0091, B:29:0x00ac, B:32:0x00b6, B:34:0x00ca, B:35:0x00d2, B:37:0x00db, B:39:0x00ed, B:42:0x00f7, B:43:0x00fb, B:45:0x0101, B:47:0x0116, B:49:0x011a, B:50:0x0122, B:51:0x0128, B:53:0x0130, B:54:0x0134, B:56:0x013a, B:58:0x014a, B:61:0x0151, B:36:0x00d4, B:21:0x0096, B:23:0x009c, B:24:0x00a1, B:12:0x004d, B:16:0x0056, B:17:0x0059), top: B:66:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096 A[Catch: JSONException -> 0x0156, TryCatch #0 {JSONException -> 0x0156, blocks: (B:3:0x0010, B:6:0x0035, B:9:0x003c, B:11:0x0044, B:18:0x0063, B:20:0x0091, B:29:0x00ac, B:32:0x00b6, B:34:0x00ca, B:35:0x00d2, B:37:0x00db, B:39:0x00ed, B:42:0x00f7, B:43:0x00fb, B:45:0x0101, B:47:0x0116, B:49:0x011a, B:50:0x0122, B:51:0x0128, B:53:0x0130, B:54:0x0134, B:56:0x013a, B:58:0x014a, B:61:0x0151, B:36:0x00d4, B:21:0x0096, B:23:0x009c, B:24:0x00a1, B:12:0x004d, B:16:0x0056, B:17:0x0059), top: B:66:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca A[Catch: JSONException -> 0x0156, TryCatch #0 {JSONException -> 0x0156, blocks: (B:3:0x0010, B:6:0x0035, B:9:0x003c, B:11:0x0044, B:18:0x0063, B:20:0x0091, B:29:0x00ac, B:32:0x00b6, B:34:0x00ca, B:35:0x00d2, B:37:0x00db, B:39:0x00ed, B:42:0x00f7, B:43:0x00fb, B:45:0x0101, B:47:0x0116, B:49:0x011a, B:50:0x0122, B:51:0x0128, B:53:0x0130, B:54:0x0134, B:56:0x013a, B:58:0x014a, B:61:0x0151, B:36:0x00d4, B:21:0x0096, B:23:0x009c, B:24:0x00a1, B:12:0x004d, B:16:0x0056, B:17:0x0059), top: B:66:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4 A[Catch: JSONException -> 0x0156, TryCatch #0 {JSONException -> 0x0156, blocks: (B:3:0x0010, B:6:0x0035, B:9:0x003c, B:11:0x0044, B:18:0x0063, B:20:0x0091, B:29:0x00ac, B:32:0x00b6, B:34:0x00ca, B:35:0x00d2, B:37:0x00db, B:39:0x00ed, B:42:0x00f7, B:43:0x00fb, B:45:0x0101, B:47:0x0116, B:49:0x011a, B:50:0x0122, B:51:0x0128, B:53:0x0130, B:54:0x0134, B:56:0x013a, B:58:0x014a, B:61:0x0151, B:36:0x00d4, B:21:0x0096, B:23:0x009c, B:24:0x00a1, B:12:0x004d, B:16:0x0056, B:17:0x0059), top: B:66:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7 A[Catch: JSONException -> 0x0156, TryCatch #0 {JSONException -> 0x0156, blocks: (B:3:0x0010, B:6:0x0035, B:9:0x003c, B:11:0x0044, B:18:0x0063, B:20:0x0091, B:29:0x00ac, B:32:0x00b6, B:34:0x00ca, B:35:0x00d2, B:37:0x00db, B:39:0x00ed, B:42:0x00f7, B:43:0x00fb, B:45:0x0101, B:47:0x0116, B:49:0x011a, B:50:0x0122, B:51:0x0128, B:53:0x0130, B:54:0x0134, B:56:0x013a, B:58:0x014a, B:61:0x0151, B:36:0x00d4, B:21:0x0096, B:23:0x009c, B:24:0x00a1, B:12:0x004d, B:16:0x0056, B:17:0x0059), top: B:66:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0130 A[Catch: JSONException -> 0x0156, TryCatch #0 {JSONException -> 0x0156, blocks: (B:3:0x0010, B:6:0x0035, B:9:0x003c, B:11:0x0044, B:18:0x0063, B:20:0x0091, B:29:0x00ac, B:32:0x00b6, B:34:0x00ca, B:35:0x00d2, B:37:0x00db, B:39:0x00ed, B:42:0x00f7, B:43:0x00fb, B:45:0x0101, B:47:0x0116, B:49:0x011a, B:50:0x0122, B:51:0x0128, B:53:0x0130, B:54:0x0134, B:56:0x013a, B:58:0x014a, B:61:0x0151, B:36:0x00d4, B:21:0x0096, B:23:0x009c, B:24:0x00a1, B:12:0x004d, B:16:0x0056, B:17:0x0059), top: B:66:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.th1 m(org.json.JSONObject r15) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.m(org.json.JSONObject):tb.th1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.alibaba.aliweex.adapter.module.mtop.a n(JSCallback jSCallback, JSCallback jSCallback2, MtopResponse mtopResponse) {
        long currentTimeMillis = System.currentTimeMillis();
        com.alibaba.aliweex.adapter.module.mtop.a aVar = new com.alibaba.aliweex.adapter.module.mtop.a(jSCallback, jSCallback2);
        if (mtopResponse != null) {
            aVar.f = mtopResponse.getApi();
        }
        aVar.b("ret", new JSONArray().put("HY_FAILED"));
        if (mtopResponse == null) {
            aVar.a("code", "-1");
            TBSdkLog.d("WXMtopRequest", "parseResult: time out");
            return aVar;
        }
        aVar.a("code", String.valueOf(mtopResponse.getResponseCode()));
        if (mtopResponse.isSessionInvalid()) {
            aVar.b("ret", new JSONArray().put("ERR_SID_INVALID"));
            return aVar;
        }
        try {
            if (mtopResponse.getBytedata() != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new String(mtopResponse.getBytedata(), "utf-8"));
                jSONObject.put("code", String.valueOf(mtopResponse.getResponseCode()));
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                if (mtopResponse.getMtopStat() != null && mtopResponse.getMtopStat().getNetStat() != null) {
                    StatisticData netStat = mtopResponse.getMtopStat().getNetStat();
                    jSONObject2.put("oneWayTime", netStat.oneWayTime_AEngine);
                    jSONObject2.put("recDataSize", netStat.totalSize);
                } else {
                    jSONObject2.put("oneWayTime", 0);
                    jSONObject2.put("recDataSize", 0);
                }
                jSONObject.put(UCCore.EVENT_STAT, jSONObject2);
                aVar.h(jSONObject);
            }
            if (mtopResponse.isApiSuccess()) {
                aVar.j(true);
            } else {
                aVar.i(mtopResponse.getRetCode());
            }
        } catch (Exception unused) {
            if (TBSdkLog.isPrintLog()) {
                TBSdkLog.e("WXMtopRequest", "parseResult mtop response parse fail, content: " + mtopResponse.toString());
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("WXMtopRequest", "parseResult cost time(ms):" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, String str3, String str4, com.alibaba.aliweex.adapter.module.mtop.a aVar) {
        IConfigAdapter c = com.alibaba.aliweex.a.l().c();
        if ((c == null || Boolean.valueOf(c.getConfig(oz2.WXAPM_CONFIG_GROUP, "recordMtopState", "true")).booleanValue()) && com.alibaba.aliweex.a.l().h() != null) {
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                hashMap.put("url", str3);
                WXStateRecord d = WXStateRecord.d();
                d.i("", "sendMtop:" + str3);
            }
            if (str2 != null) {
                hashMap.put("pageName", str2);
            }
            if (str4 != null) {
                hashMap.put("msg", str4);
            }
            if (aVar != null) {
                String str5 = aVar.f;
                if (str5 == null) {
                    str5 = "";
                }
                hashMap.put("callApi", str5);
                hashMap.put("success", Boolean.valueOf(aVar.g()));
                hashMap.put("retCode", aVar.f());
                if (!aVar.g()) {
                    hashMap.put("result", aVar.e().toString());
                }
                WXStateRecord d2 = WXStateRecord.d();
                d2.i("", "receiveMtop:" + str5 + ",result" + aVar.e().toString());
            }
        }
    }

    public void p(Context context, JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        q(context, jSONObject.toString(), jSCallback, jSCallback2);
    }

    public void q(final Context context, final String str, final JSCallback jSCallback, final JSCallback jSCallback2) {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("mtop send >>> " + str);
        }
        WXSDKInstance y = WXSDKManager.v().y(this.c);
        if (y != null) {
            y.getApmForInstance().c();
        }
        e.submit(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                    th1 m = WXMtopRequest.this.m(jSONObject);
                    if (m == null) {
                        com.alibaba.aliweex.adapter.module.mtop.a aVar = new com.alibaba.aliweex.adapter.module.mtop.a(jSCallback, jSCallback2);
                        aVar.b("ret", new JSONArray().put("HY_PARAM_ERR"));
                        WXMtopRequest.this.l(aVar);
                        return;
                    }
                    WXSDKInstance y2 = WXSDKManager.v().y(WXMtopRequest.this.c);
                    if ((TextUtils.isEmpty(m.m) || TextUtils.isEmpty(m.l)) && y2 != null) {
                        XState.setValue(XStateConstants.KEY_CURRENT_PAGE_NAME, y2.getApmForInstance().m);
                        XState.setValue(XStateConstants.KEY_CURRENT_PAGE_URL, y2.getBundleUrl());
                    }
                    MtopRequest k = WXMtopRequest.this.k(m);
                    WXMtopRequest.this.o("weex-send-mtop", y2 == null ? "" : y2.getWXPerformance().pageName, k.getApiName(), k.getVersion(), null);
                    String optString = jSONObject.optString("userAgent");
                    if (TextUtils.isEmpty(optString)) {
                        optString = nz2.a(context, WXEnvironment.getConfig());
                    }
                    RemoteBusiness j = WXMtopRequest.this.j(k, m, optString);
                    if (WXMtopRequest.this.a != null) {
                        WXMtopRequest.this.a.r(j);
                    }
                    WXMtopRequest wXMtopRequest = WXMtopRequest.this;
                    RbListener rbListener = new RbListener(wXMtopRequest.a, jSCallback, jSCallback2, j, m.f);
                    rbListener.instanceId = WXMtopRequest.this.c;
                    rbListener.requestAi = k.getApiName();
                    j.registeListener((IRemoteListener) rbListener);
                    j.startRequest();
                } catch (Exception e2) {
                    TBSdkLog.e("WXMtopRequest", "send Request failed" + e2);
                    com.alibaba.aliweex.adapter.module.mtop.a aVar2 = new com.alibaba.aliweex.adapter.module.mtop.a(jSCallback, jSCallback2);
                    aVar2.b("ret", new JSONArray().put("HY_FAILED"));
                    WXMtopRequest.this.l(aVar2);
                }
            }
        });
    }

    public WXMtopRequest r(String str) {
        this.c = str;
        return this;
    }
}
