package com.alibaba.aliweex.adapter.adapter;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.taobao.windvane.cache.WVMemoryCache;
import android.taobao.windvane.grey.GreyPageInfo;
import android.taobao.windvane.packageapp.WVPackageAppRuntime;
import android.taobao.windvane.packageapp.zipapp.ZCacheResourceResponse;
import android.taobao.windvane.thread.WVThreadPool;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$ProgressListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.NetworkEvent$ProgressEvent;
import anetwork.channel.Request;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.interceptor.Interceptor;
import anetwork.channel.statist.StatisticData;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.aliweex.AliWXSDKEngine;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.IGodEyeStageAdapter;
import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.alibaba.aliweex.interceptor.network.NetworkTracker;
import com.alibaba.fastjson.JSON;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.android.task.Coordinator;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.c22;
import tb.he;
import tb.hh1;
import tb.k60;
import tb.oz2;
import tb.v31;
import tb.zz2;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class WXHttpAdapter implements IWXHttpAdapter {
    public static final String GROUP_CACHE_SWITCH = "weex_degrade_cache_switch";
    public static final String KEY_CACHE_SWITCH = "cache_switch";
    private static String b = "wx_network_ctl_android";
    private a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a implements Interceptor {
        private Map<String, Map<String, Object>> a = new HashMap();

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.aliweex.adapter.adapter.WXHttpAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0125a implements Callback {
            final /* synthetic */ Interceptor.Chain a;

            C0125a(Interceptor.Chain chain) {
                this.a = chain;
            }

            @Override // anetwork.channel.interceptor.Callback
            public void onDataReceiveSize(int i, int i2, he heVar) {
                this.a.callback().onDataReceiveSize(i, i2, heVar);
            }

            @Override // anetwork.channel.interceptor.Callback
            public void onFinish(DefaultFinishEvent defaultFinishEvent) {
                this.a.callback().onFinish(defaultFinishEvent);
            }

            @Override // anetwork.channel.interceptor.Callback
            public void onResponseCode(int i, Map<String, List<String>> map) {
                this.a.callback().onResponseCode(i, map);
                Map map2 = (Map) a.this.a.get(this.a.request().q());
                if (map2 != null) {
                    map2.put(hh1.DIMEN_BIZ, this.a.request().r.bizId);
                    map2.put("cacheTime", Long.valueOf(this.a.request().r.cacheTime));
                    map2.put("firstDataTime", Long.valueOf(this.a.request().r.firstDataTime));
                    map2.put("host", this.a.request().r.host);
                    map2.put(TbAuthConstants.IP, this.a.request().r.ip);
                    map2.put("isDNS", Boolean.valueOf(this.a.request().r.isDNS));
                    map2.put("isProxy", Boolean.valueOf(this.a.request().r.isProxy));
                    map2.put("isSSL", Boolean.valueOf(this.a.request().r.isSSL));
                    map2.put("msg", this.a.request().r.msg);
                    map2.put("netType", this.a.request().r.netType);
                    map2.put("oneWayTime", Long.valueOf(this.a.request().r.oneWayTime));
                    map2.put("port", Integer.valueOf(this.a.request().r.port));
                    map2.put("protocolType", this.a.request().r.protocolType);
                    map2.put("proxyType", this.a.request().r.proxyType);
                    map2.put("recDataSize", Long.valueOf(this.a.request().r.recDataSize));
                    map2.put("recDataTime", Long.valueOf(this.a.request().r.recDataTime));
                    map2.put("sendBeforeTime", Long.valueOf(this.a.request().r.sendBeforeTime));
                    map2.put("sendDataSize", Long.valueOf(this.a.request().r.sendDataSize));
                    map2.put("sendDataTime", Long.valueOf(this.a.request().r.sendDataTime));
                    map2.put(IFullTraceAnalysisV3.Stage.SERVE_RT, Long.valueOf(this.a.request().r.serverRT));
                    map2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(this.a.request().r.statusCode));
                    map2.put("url", this.a.request().r.url);
                    map2.put("waitingTime", Long.valueOf(this.a.request().r.waitingTime));
                    map2.put("start", Long.valueOf(this.a.request().r.start));
                }
            }
        }

        public synchronized Map<String, Object> b(String str) {
            return this.a.remove(str);
        }

        public synchronized void c(String str) {
            this.a.put(str, new HashMap());
        }

        @Override // anetwork.channel.interceptor.Interceptor
        public Future intercept(Interceptor.Chain chain) {
            anet.channel.request.a request = chain.request();
            Callback callback = chain.callback();
            if ("weex".equals(chain.request().g().get(HttpHeaderConstant.F_REFER))) {
                callback = new C0125a(chain);
            }
            return chain.proceed(request, callback);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class b implements NetworkCallBack$FinishListener, NetworkCallBack$ProgressListener, NetworkCallBack$ResponseCodeListener {
        private WXResponse a;
        private IWXHttpAdapter.OnHttpListener b;
        private ByteArrayOutputStream c = new ByteArrayOutputStream();
        private String d;
        private long e;
        private NetworkTracker f;
        private Map<String, List<String>> g;
        private String h;
        private Map<String, String> i;

        b(String str, NetworkTracker networkTracker, WXResponse wXResponse, IWXHttpAdapter.OnHttpListener onHttpListener, String str2, long j, Map<String, String> map) {
            this.f = networkTracker;
            this.a = wXResponse;
            this.b = onHttpListener;
            this.d = str2;
            this.e = j;
            this.h = str;
            this.i = map;
        }

        private boolean a(String str) {
            return str.contains("err.tmall.com/error") || str.contains("err.taobao.com/error");
        }

        private void b(NetworkEvent$FinishEvent networkEvent$FinishEvent) {
            boolean z;
            if (TextUtils.equals(WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR.getErrorCode(), this.a.statusCode)) {
                NetworkTracker networkTracker = this.f;
                if (networkTracker != null) {
                    networkTracker.o(this.a.errorMsg);
                }
                if ("true".equals(com.alibaba.aliweex.a.l().c() != null ? com.alibaba.aliweex.a.l().c().getConfig(WXHttpAdapter.GROUP_CACHE_SWITCH, WXHttpAdapter.KEY_CACHE_SWITCH, "false") : "false") && networkEvent$FinishEvent.getHttpCode() == 200 && !a(this.d) && this.c.size() > 0) {
                    try {
                        WVMemoryCache.getInstance().addMemoryCache(this.d, this.g, this.c.toByteArray());
                    } catch (Exception unused) {
                        Log.e("TBWXHttpAdapter", "Please join windvane dependency!");
                    }
                }
                z = false;
            } else {
                StatisticData statisticData = networkEvent$FinishEvent.getStatisticData();
                WXEnvironment.isApkDebugable();
                this.a.statusCode = String.valueOf(networkEvent$FinishEvent.getHttpCode());
                byte[] byteArray = this.c.toByteArray();
                if (networkEvent$FinishEvent.getHttpCode() == 200) {
                    WXResponse wXResponse = this.a;
                    wXResponse.originalData = byteArray;
                    z = true;
                    if (statisticData != null) {
                        wXResponse.extendParams.put("connectionType", statisticData.connectionType);
                        this.a.extendParams.put("pureNetworkTime", Long.valueOf(statisticData.oneWayTime_ANet));
                        if ("cache".equals(statisticData.connectionType)) {
                            this.a.extendParams.put("requestType", "cache");
                            this.a.extendParams.put(WXPerformance.CACHE_TYPE, "netCache");
                        }
                    }
                    this.a.extendParams.put("actualNetworkTime", Long.valueOf(System.currentTimeMillis() - this.e));
                } else {
                    if (networkEvent$FinishEvent.getHttpCode() == 404) {
                        this.a.errorCode = String.valueOf(networkEvent$FinishEvent.getHttpCode());
                        this.a.errorMsg = "404 NOT FOUND!";
                    } else {
                        this.a.errorCode = String.valueOf(networkEvent$FinishEvent.getHttpCode());
                        WXResponse wXResponse2 = this.a;
                        wXResponse2.errorMsg = "networkMsg==" + networkEvent$FinishEvent.getDesc() + "|networkErrorCode==" + networkEvent$FinishEvent.getHttpCode() + "|mWXResponse==" + JSON.toJSONString(this.a);
                    }
                    z = false;
                }
                NetworkTracker networkTracker2 = this.f;
                if (networkTracker2 != null) {
                    networkTracker2.p(byteArray);
                }
            }
            try {
                WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(this.h);
                if (wXSDKInstance != null && wXSDKInstance.getApmForInstance() != null) {
                    wXSDKInstance.getApmForInstance().d(z, this.a.errorCode);
                    List<String> list = this.g.get(AliWXSDKEngine.g);
                    List<String> list2 = this.g.get(AliWXSDKEngine.h);
                    if (list != null || list2 != null) {
                        StringBuilder sb = new StringBuilder();
                        if (list != null && !list.isEmpty()) {
                            sb.append(AliWXSDKEngine.g);
                            sb.append("=");
                            sb.append(list.get(0));
                        }
                        if (list2 != null && !list2.isEmpty()) {
                            if (sb.length() != 0) {
                                sb.append("&");
                            }
                            sb.append(AliWXSDKEngine.h);
                            sb.append("=");
                            sb.append(list2.get(0));
                        }
                        if (sb.length() != 0) {
                            wXSDKInstance.getContainerInfo().put(AliWXSDKEngine.f, sb.toString());
                            wXSDKInstance.getApmForInstance().e(AliWXSDKEngine.f, sb.toString());
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            WXHttpAdapter.this.k(this.b, this.d, this.a, networkEvent$FinishEvent.getHttpCode(), this.g);
            ByteArrayOutputStream byteArrayOutputStream = this.c;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                    this.c = null;
                } catch (IOException e) {
                    WXLogUtils.e("TBWXHttpAdapter", WXLogUtils.getStackTrace(e));
                    NetworkTracker networkTracker3 = this.f;
                    if (networkTracker3 != null) {
                        networkTracker3.o(e.toString());
                    }
                }
            }
        }

        @Override // anetwork.channel.NetworkCallBack$ProgressListener
        public void onDataReceived(NetworkEvent$ProgressEvent networkEvent$ProgressEvent, Object obj) {
            if (networkEvent$ProgressEvent == null) {
                return;
            }
            NetworkTracker networkTracker = this.f;
            if (networkTracker != null) {
                networkTracker.n(networkEvent$ProgressEvent);
            }
            this.c.write(networkEvent$ProgressEvent.getBytedata(), 0, networkEvent$ProgressEvent.getSize());
            this.b.onHttpResponseProgress(this.c.size());
        }

        @Override // anetwork.channel.NetworkCallBack$FinishListener
        public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
            WXLogUtils.d("TBWXHttpAdapter", "into--[onFinished]");
            b(networkEvent$FinishEvent);
        }

        @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
        public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
            Map<String, String> map2;
            if (map == null) {
                map = new HashMap<>();
            }
            this.g = map;
            this.b.onHeadersReceived(i, map);
            NetworkTracker networkTracker = this.f;
            if (networkTracker != null) {
                networkTracker.q(i, map);
                if (this.f instanceof NetworkTracker) {
                    HashMap hashMap = new HashMap();
                    if (WXHttpAdapter.this.a != null) {
                        hashMap.putAll(WXHttpAdapter.this.a.b(this.d));
                    }
                    hashMap.putAll(this.a.extendParams);
                    this.f.r(hashMap);
                }
            }
            if (this.d.contains("wh_weex=true") && (map2 = this.i) != null && "true".equals(map2.get("isBundleRequest"))) {
                List<String> list = map.get(map.containsKey("Content-Type") ? "Content-Type" : "content-type");
                String obj2 = list != null ? list.toString() : null;
                if (TextUtils.isEmpty(obj2) || !(TextUtils.isEmpty(obj2) || obj2.contains("application/javascript"))) {
                    WXResponse wXResponse = this.a;
                    WXErrorCode wXErrorCode = WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR;
                    wXResponse.statusCode = wXErrorCode.getErrorCode();
                    this.a.errorCode = wXErrorCode.getErrorCode();
                    this.a.errorMsg = "degradeToH5";
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request e(WXRequest wXRequest, WXResponse wXResponse) {
        a aVar;
        c22 c22Var = new c22(wXRequest.url);
        c22Var.setBizId(4102);
        Map<String, String> map = wXRequest.paramMap;
        if (map != null) {
            for (String str : map.keySet()) {
                c22Var.addHeader(str, wXRequest.paramMap.get(str));
            }
        }
        c22Var.addHeader(HttpHeaderConstant.F_REFER, "weex");
        c22Var.addHeader("Accept-Language", h());
        String str2 = wXRequest.method;
        if (TextUtils.isEmpty(str2)) {
            str2 = "GET";
        }
        c22Var.setMethod(str2);
        c22Var.setCharset("UTF-8");
        c22Var.setRetryTime(2);
        c22Var.setConnectTimeout(wXRequest.timeoutMs);
        try {
            if (Boolean.valueOf(g(b, "true")).booleanValue()) {
                c22Var.setExtProperty("CheckContentLength", "true");
            }
        } catch (Exception e) {
            WXLogUtils.e(WXLogUtils.getStackTrace(e));
            WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED, "assembleRequest", WXLogUtils.getStackTrace(e), null);
        }
        if (!TextUtils.isEmpty(wXRequest.body)) {
            c22Var.setBodyEntry(new ByteArrayEntry(wXRequest.body.getBytes()));
        }
        if (WXEnvironment.isApkDebugable() && (aVar = this.a) != null) {
            aVar.c(wXRequest.url);
        }
        return c22Var;
    }

    public static String g(String str, String str2) {
        IConfigAdapter c = com.alibaba.aliweex.a.l().c();
        return c != null ? c.getConfig("wx_network_ctl_android", str, str2) : str2;
    }

    private String h() {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            String str = locale.getLanguage() + "-" + locale.getCountry();
            if (locale.getLanguage().equals("zh")) {
                return str + ",zh;q=0.8,en-US;q=0.5,en;q=0.3";
            }
            return str + "," + locale.getLanguage() + ";q=0.8,en-US;q=0.5,en;q=0.3";
        } catch (Throwable unused) {
            return "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        IWXConnection a2 = com.alibaba.aliweex.adapter.module.net.a.a(WXEnvironment.getApplication());
        String networkType = a2 == null ? "unknown" : a2.getNetworkType();
        return ("wifi".equals(networkType) || "4g".equals(networkType) || "3g".equals(networkType) || "2g".equals(networkType)) ? networkType : "other";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(WXRequest wXRequest, WXResponse wXResponse, IWXHttpAdapter.OnHttpListener onHttpListener, NetworkTracker networkTracker) {
        String trim = wXRequest.url.trim();
        Uri parse = Uri.parse(trim);
        if (TextUtils.equals("200", wXResponse.statusCode)) {
            p("request->zcache->end", wXRequest.url, wXRequest, wXResponse, null);
            wXResponse.extendParams.put(WXInstanceApm.KEY_PAGE_PROPERTIES_REQUEST_TYPE, "zcache");
            wXResponse.extendParams.put("requestType", "cache");
            wXResponse.extendParams.put(WXPerformance.CACHE_TYPE, "zcache");
            n(trim, wXResponse, onHttpListener);
            return;
        }
        l(trim, parse, wXRequest, wXResponse, onHttpListener, networkTracker);
    }

    private String o(InputStream inputStream) {
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        return byteArrayOutputStream.toString("UTF-8");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                f(inputStream);
                return null;
            }
        } finally {
            f(inputStream);
        }
    }

    private void p(String str, String str2, WXRequest wXRequest, WXResponse wXResponse, Map<String, List<String>> map) {
        IGodEyeStageAdapter h;
        IConfigAdapter c = com.alibaba.aliweex.a.l().c();
        if ((c == null || Boolean.valueOf(c.getConfig(oz2.WXAPM_CONFIG_GROUP, "recordRequestState", "true")).booleanValue()) && (h = com.alibaba.aliweex.a.l().h()) != null) {
            try {
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("url", str2);
                }
                if (wXRequest != null) {
                    hashMap.put("timeoutValue", Integer.valueOf(wXRequest.timeoutMs));
                }
                if (wXResponse != null) {
                    hashMap.put("response.statusCode", wXResponse.statusCode);
                    hashMap.put("response.extendParams", wXResponse.extendParams);
                }
                if (map != null) {
                    hashMap.put("response.header", map);
                }
                h.onStage(str, hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void q(final NetworkTracker networkTracker, final WXRequest wXRequest, final WXResponse wXResponse, final IWXHttpAdapter.OnHttpListener onHttpListener) {
        Coordinator.postTask(new Coordinator.TaggedRunnable("TBWXHttpAdapter") { // from class: com.alibaba.aliweex.adapter.adapter.WXHttpAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                WXSDKInstance y = WXSDKManager.v().y(wXRequest.instanceId);
                if (y != null) {
                    y.getApmForInstance().c();
                }
                WXLogUtils.d("TBWXHttpAdapter", "into--[sendRequestByHttp] url:" + wXRequest.url);
                wXResponse.statusCode = WXErrorCode.WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED.getErrorCode();
                wXResponse.extendParams.put(WXPerformance.CACHE_TYPE, "none");
                String i = WXHttpAdapter.this.i();
                wXResponse.extendParams.put(WXInstanceApm.KEY_PAGE_PROPERTIES_REQUEST_TYPE, i);
                wXResponse.extendParams.put("requestType", i);
                try {
                    if (wXRequest.timeoutMs == 3000) {
                        String g = WXHttpAdapter.g("wx_network_timeout_ms", "10000");
                        wXRequest.timeoutMs = Integer.valueOf(g).intValue();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Request e2 = WXHttpAdapter.this.e(wXRequest, wXResponse);
                NetworkTracker networkTracker2 = networkTracker;
                if (networkTracker2 != null) {
                    networkTracker2.s(e2);
                }
                k60 k60Var = new k60(com.alibaba.aliweex.a.l().b());
                WXHttpAdapter wXHttpAdapter = WXHttpAdapter.this;
                WXRequest wXRequest2 = wXRequest;
                k60Var.asyncSend(e2, null, null, new b(wXRequest2.instanceId, networkTracker, wXResponse, onHttpListener, wXRequest2.url, System.currentTimeMillis(), wXRequest.paramMap));
            }
        });
    }

    public void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected WXResponse j(WXRequest wXRequest, WXResponse wXResponse) {
        Log.w("test->", "start getResponseByPackageApp");
        wXResponse.statusCode = "-1";
        String str = "";
        String trim = wXRequest.url.trim();
        try {
            Uri parse = Uri.parse(trim);
            if (parse.getBooleanQueryParameter("wh_weex", false)) {
                String host = parse.getHost();
                trim = trim.replace(host, parse.getHost() + ".local.weex");
            }
            ZCacheResourceResponse zCacheResourceResponse = WVPackageAppRuntime.getZCacheResourceResponse(trim);
            if (zCacheResourceResponse != null) {
                Map<String, String> map = zCacheResourceResponse.headers;
                if (map != null) {
                    wXResponse.extendParams.put("zCacheInfo", map.get("X-ZCache-Info"));
                }
                InputStream inputStream = zCacheResourceResponse.inputStream;
                if (inputStream != null) {
                    str = o(inputStream);
                }
            } else {
                wXResponse.extendParams.put("zCacheInfo", com.taobao.zcache.model.ZCacheResourceResponse.ZCACHE_NO_RESPONSE);
            }
        } catch (Exception e) {
            WXLogUtils.e("getResponseByPackageApp error:" + e.getMessage());
        }
        if (!TextUtils.isEmpty(str)) {
            wXResponse.statusCode = "200";
            wXResponse.originalData = str.getBytes();
            wXResponse.extendParams.put("connectionType", "packageApp");
            Log.w("test->", "end getResponseByPackageApp");
        }
        return wXResponse;
    }

    protected void k(IWXHttpAdapter.OnHttpListener onHttpListener, String str, WXResponse wXResponse, int i, Map<String, List<String>> map) {
        p("weex->onHttpFinish", str, null, wXResponse, map);
        onHttpListener.onHttpFinish(wXResponse);
    }

    protected void l(String str, Uri uri, WXRequest wXRequest, WXResponse wXResponse, IWXHttpAdapter.OnHttpListener onHttpListener, NetworkTracker networkTracker) {
        if (!"200".equals(wXResponse.statusCode)) {
            p("request-> network", wXRequest.url, wXRequest, null, null);
            q(networkTracker, wXRequest, wXResponse, onHttpListener);
            return;
        }
        wXResponse.extendParams.put(WXInstanceApm.KEY_PAGE_PROPERTIES_REQUEST_TYPE, "weex_cache");
        wXResponse.extendParams.put("requestType", "cache");
        wXResponse.extendParams.put(WXPerformance.CACHE_TYPE, "weex_cache");
    }

    protected void n(String str, WXResponse wXResponse, IWXHttpAdapter.OnHttpListener onHttpListener) {
        Log.w("test->", "processZCache");
        onHttpListener.onHttpFinish(wXResponse);
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter
    public void sendRequest(final WXRequest wXRequest, final IWXHttpAdapter.OnHttpListener onHttpListener) {
        if (onHttpListener == null || wXRequest == null) {
            return;
        }
        WXSDKInstance y = WXSDKManager.v().y(wXRequest.instanceId);
        if (y != null) {
            y.getApmForInstance().c();
        }
        if (zz2.c()) {
            wXRequest.paramMap.put(GreyPageInfo.KEY_GREY, "true");
        }
        final NetworkTracker m = WXEnvironment.isApkDebugable() ? NetworkTracker.m() : null;
        if (WXEnvironment.isApkDebugable() && this.a == null) {
            try {
                a aVar = new a();
                this.a = aVar;
                v31.a(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        onHttpListener.onHttpStart();
        final WXResponse wXResponse = new WXResponse();
        if (wXResponse.extendParams == null) {
            wXResponse.extendParams = new HashMap();
        }
        Log.w("test->", "sendRequest" + wXRequest.url);
        if (TextUtils.isEmpty(wXRequest.url)) {
            WXErrorCode wXErrorCode = WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR;
            wXResponse.statusCode = wXErrorCode.getErrorCode();
            wXResponse.errorMsg = wXErrorCode.getErrorMsg() + "request url is empty!";
            onHttpListener.onHttpFinish(wXResponse);
            return;
        }
        p("request->zcache", wXRequest.url, wXRequest, null, null);
        WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(wXRequest.instanceId);
        if (wXSDKInstance != null && wXSDKInstance.isPreDownLoad() && Looper.myLooper() == Looper.getMainLooper()) {
            WVThreadPool.getInstance().execute(new Runnable() { // from class: com.alibaba.aliweex.adapter.adapter.WXHttpAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    WXHttpAdapter.this.j(wXRequest, wXResponse);
                    wXResponse.extendParams.put("packageSpendTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.alibaba.aliweex.adapter.adapter.WXHttpAdapter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            WXHttpAdapter.this.m(wXRequest, wXResponse, onHttpListener, m);
                        }
                    });
                }
            });
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        j(wXRequest, wXResponse);
        wXResponse.extendParams.put("packageSpendTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        m(wXRequest, wXResponse, onHttpListener, m);
    }
}
