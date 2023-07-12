package com.alibaba.aliweex.interceptor.network;

import android.os.SystemClock;
import android.text.TextUtils;
import anetwork.channel.Header;
import anetwork.channel.NetworkEvent$ProgressEvent;
import anetwork.channel.Param;
import anetwork.channel.Request;
import com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector;
import com.alibaba.aliweex.interceptor.a;
import com.alibaba.poplayer.trigger.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.utils.WXLogUtils;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import tb.a31;
import tb.b31;
import tb.ig2;
import tb.kp2;
import tb.sj1;
import tb.x12;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class NetworkTracker {
    private static boolean i = true;
    private sj1 a;
    private String d;
    private b31 e;
    private IWeexAnalyzerInspector f;
    @Nullable
    private String h;
    private boolean b = false;
    private double c = SystemClock.elapsedRealtime() / 1000.0d;
    private final int g = kp2.a();

    private NetworkTracker() {
        if (WXEnvironment.isApkDebugable()) {
            this.a = sj1.d();
            this.f = a.a();
            WXLogUtils.d("NetworkTracker", "Create new instance " + toString());
        }
    }

    private boolean j() {
        sj1 sj1Var;
        return i && WXEnvironment.isApkDebugable() && (sj1Var = this.a) != null && sj1Var.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        if (this.h == null) {
            this.h = String.valueOf(this.g);
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final byte[] bArr, final b31 b31Var) {
        if (j()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.network.NetworkTracker.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bArr != null) {
                        NetworkTracker.this.a.f(NetworkTracker.this.k(), b31Var.d(), b31Var.b(), new ByteArrayInputStream(bArr), false);
                    }
                    NetworkTracker.this.a.k(NetworkTracker.this.k());
                }
            });
        }
    }

    public static NetworkTracker m() {
        return new NetworkTracker();
    }

    private void t(String str, Throwable th) {
        try {
            i = false;
            WXLogUtils.w("Disable NetworkTracker");
            IWXUserTrackAdapter t = WXSDKManager.v().t();
            if (t == null || WXEnvironment.getApplication() == null) {
                return;
            }
            WXPerformance wXPerformance = new WXPerformance("useless");
            wXPerformance.args = "message: " + str + ";requestId: " + this.g + ";isApkDebugable: " + WXEnvironment.isApkDebugable() + ";canReport: " + j() + ";exception: " + WXLogUtils.getStackTrace(th);
            WXErrorCode wXErrorCode = WXErrorCode.WX_ERR_INVOKE_NATIVE;
            wXPerformance.errCode = wXErrorCode.getErrorCode();
            wXPerformance.appendErrMsg(wXErrorCode.getErrorMsg());
            t.commit(WXEnvironment.getApplication(), null, IWXUserTrackAdapter.STREAM_MODULE, wXPerformance, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void n(final NetworkEvent$ProgressEvent networkEvent$ProgressEvent) {
        try {
            if (j()) {
                this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.network.NetworkTracker.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int length = networkEvent$ProgressEvent.getBytedata() == null ? 0 : networkEvent$ProgressEvent.getBytedata().length;
                        WXLogUtils.d("NetworkTracker", NetworkTracker.this.k() + " onDataReceived -> " + length + " bytes");
                        NetworkTracker.this.a.a(NetworkTracker.this.k(), length, 0);
                    }
                });
            }
        } catch (Throwable th) {
            t("Exception on onDataReceived()", th);
        }
    }

    public void o(String str) {
        try {
            if (j()) {
                WXLogUtils.d("NetworkTracker", k() + " onFailed: " + str);
                this.a.e(k(), str);
            }
        } catch (Throwable th) {
            t("Exception on onFailed()", th);
        }
    }

    public void p(final byte[] bArr) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        b31 b31Var;
        try {
            if (j()) {
                this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.network.NetworkTracker.4
                    @Override // java.lang.Runnable
                    public void run() {
                        WXLogUtils.d("NetworkTracker", NetworkTracker.this.k() + " onFinished -> " + bArr.length + " bytes");
                        NetworkTracker networkTracker = NetworkTracker.this;
                        networkTracker.l(bArr, networkTracker.e);
                    }
                });
            }
            if (!WXEnvironment.isApkDebugable() || (iWeexAnalyzerInspector = this.f) == null || !iWeexAnalyzerInspector.isEnabled() || (b31Var = this.e) == null || bArr == null) {
                return;
            }
            IWeexAnalyzerInspector iWeexAnalyzerInspector2 = this.f;
            String str = TextUtils.isEmpty((CharSequence) b31Var.f().get("url")) ? "unknown" : (String) this.e.f().get("url");
            String str2 = new String(bArr);
            int intValue = ((Integer) this.e.f().get(HiAnalyticsConstant.HaKey.BI_KEY_RESULT)).intValue();
            iWeexAnalyzerInspector2.onResponse("http", new IWeexAnalyzerInspector.b(str, str2, intValue, Collections.singletonMap(Constants.Protocol.CONTENT_LENGTH, Collections.singletonList(bArr.length + ""))));
        } catch (Throwable th) {
            t("Exception on onFinished()", th);
        }
    }

    public void q(final int i2, final Map<String, List<String>> map) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        try {
            if (j() && !this.b) {
                this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.network.NetworkTracker.2
                    @Override // java.lang.Runnable
                    public void run() {
                        WXLogUtils.d("NetworkTracker", NetworkTracker.this.k() + " onResponseCode -> " + i2 + AVFSCacheConstants.COMMA_SEP + map.toString());
                        NetworkTracker.this.e = new b31();
                        NetworkTracker.this.e.m(i2);
                        NetworkTracker.this.e.h(NetworkTracker.this.k());
                        NetworkTracker.this.e.i(NetworkTracker.this.d);
                        NetworkTracker.this.e.l(ig2.a(String.valueOf(i2)));
                        String str = "";
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            String obj = ((List) entry.getValue()).toString();
                            if (str2 != null) {
                                NetworkTracker.this.e.a(str2, obj);
                            } else {
                                str = str + obj + ";";
                            }
                        }
                        NetworkTracker.this.e.a("NULL", str);
                        NetworkTracker.this.a.i(NetworkTracker.this.e);
                        NetworkTracker.this.b = true;
                    }
                });
            }
            if (WXEnvironment.isApkDebugable() && (iWeexAnalyzerInspector = this.f) != null && iWeexAnalyzerInspector.isEnabled()) {
                b31 b31Var = new b31();
                this.e = b31Var;
                b31Var.m(i2);
                this.e.i(this.d);
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String obj = entry.getValue().toString();
                    if (key != null) {
                        this.e.a(key, obj);
                    }
                }
            }
        } catch (Throwable th) {
            t("Exception on onResponseCode()", th);
        }
    }

    public void r(final Map<String, Object> map) {
        if (this.e == null || map.isEmpty()) {
            return;
        }
        this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.network.NetworkTracker.6
            @Override // java.lang.Runnable
            public void run() {
                map.put("requestTime", Double.valueOf(NetworkTracker.this.c));
                NetworkTracker.this.e.n(map);
            }
        });
    }

    public void s(final Request request) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        try {
            if (j()) {
                this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.network.NetworkTracker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WXLogUtils.d("NetworkTracker", NetworkTracker.this.k() + " preRequest -> " + request.getURL());
                        a31 a31Var = new a31();
                        for (Header header : request.getHeaders()) {
                            a31Var.a(header.getName(), header.getValue());
                        }
                        if (request.getBodyEntry() != null && request.getBodyEntry().getContentType() != null) {
                            a31Var.a("Content-Type", request.getBodyEntry().getContentType());
                        }
                        if (request.getParams() != null) {
                            for (Param param : request.getParams()) {
                                a31Var.a(param.getKey(), param.getValue());
                            }
                        }
                        a31Var.a("charset", request.getCharset());
                        a31Var.a("connectTimeout", String.valueOf(request.getConnectTimeout()));
                        a31Var.a("readTimeout", String.valueOf(request.getReadTimeout()));
                        a31Var.a(c.KEY_RETRY_TIME, String.valueOf(request.getRetryTime()));
                        NetworkTracker.this.d = request.getURL().toString();
                        a31Var.i(NetworkTracker.this.d);
                        a31Var.h(NetworkTracker.this.k());
                        a31Var.l("ANet");
                        a31Var.m(TextUtils.isEmpty(request.getMethod()) ? "GET" : request.getMethod());
                        if (request.getBodyEntry() != null) {
                            try {
                                x12 x12Var = new x12(NetworkTracker.this.a, NetworkTracker.this.k());
                                OutputStream a = x12Var.a(a31Var.d());
                                request.getBodyEntry().writeTo(a);
                                a.close();
                                a31Var.k(x12Var.b());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        NetworkTracker.this.a.h(a31Var);
                        NetworkTracker.this.a.b(NetworkTracker.this.k(), a31Var.c(), 0);
                    }
                });
            }
            if (WXEnvironment.isApkDebugable() && (iWeexAnalyzerInspector = this.f) != null && iWeexAnalyzerInspector.isEnabled()) {
                this.d = request.getUrlString();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("charset", request.getCharset());
                    hashMap.put("connectTimeout", String.valueOf(request.getConnectTimeout()));
                    hashMap.put("readTimeout", String.valueOf(request.getReadTimeout()));
                    hashMap.put(c.KEY_RETRY_TIME, String.valueOf(request.getRetryTime()));
                    if (request.getHeaders() != null) {
                        for (Header header : request.getHeaders()) {
                            hashMap.put(header.getName(), header.getValue());
                        }
                    }
                    this.f.onRequest("http", new IWeexAnalyzerInspector.a(TextUtils.isEmpty(this.d) ? "unknown" : this.d, "GET", hashMap));
                } catch (Exception e) {
                    WXLogUtils.e("NetworkTracker", e.getMessage());
                }
            }
        } catch (Throwable th) {
            t("Exception on preRequest()", th);
        }
    }
}
